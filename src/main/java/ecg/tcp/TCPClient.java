package ecg.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

import ecg.ecgshow.MyECGShowUI;
import ecg.myals.WelcomeWindow;
//没有main方法
public class TCPClient extends Thread{  //跑多线程，私有变量只能在TCPClient这个类内使用
	private Socket s;
	private InputStream is;//输入流is
	private String host;//主机域名
	private int port;   //主机端口号
	private byte[] receivedBuffer = new byte[40000];//接收缓存，40000个字节
	private byte[] receivedTemp = new byte[1024];   //接收临时变量，1024个字节
	public boolean connectFlag = false;//布尔变量型 连接标志，初始时设为false没有连接
	public boolean stopFlag = false;   //布尔变量型 停止标志，初始时设为false 连接依旧存在
	private MyECGShowUI myECGShowUI;   //图形化界面
	
	public Socket getS() {	//获得socket
		return s;
	}

	public void setS(Socket s) {  //给TCPClient下的Socket类的实例s赋值
		this.s = s;
	}

	public InputStream getIs() {	//获得输入流is
		return is;
	}

	public void setIs(InputStream is) {	//给TCPClient下的InputStream类的实例is赋值
		this.is = is;
	}

	public String getHost() {		//获得主机名
		return host;
	}

	public void setHost(String host) {	//给TCPClient下的String类的实例host赋值
		this.host = host;
	}

	public int getPort() {		//获得端口
		return port;
	}

	public void setPort(int port) {	//给TCPClient下的int类的port赋值
		this.port = port;
	}
	
	public void connect(){	//public类型的方法 connect(),有异常处理
		try {
			s = new Socket(host, port);	//用host和 port初始化Socket类的s变量
			connectFlag = true;		//	连接标志为true
			WelcomeWindow.welcomeWindow.getTCPC().getjButton1().setText("结束");		//在als.myals包中的WelcomeWindow类的一个实例welcomeWindow的getTCPC()方法
			WelcomeWindow.welcomeWindow.getTCPC().getjTextField1().setEnabled(false);
			WelcomeWindow.welcomeWindow.getTCPC().getjTextField2().setEnabled(false);
			try {
				for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
						javax.swing.UIManager.setLookAndFeel(info.getClassName());
						break;
					}
				}
			} catch (ClassNotFoundException ex) {	//class未找到异常
				java.util.logging.Logger.getLogger(MyECGShowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (InstantiationException ex) {	//实例化异常
				java.util.logging.Logger.getLogger(MyECGShowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (IllegalAccessException ex) {	//非法访问异常
				java.util.logging.Logger.getLogger(MyECGShowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {	//swing组件中的不支持LookAndFeel异常
				java.util.logging.Logger.getLogger(MyECGShowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}
			//</editor-fold>

         /* Create and display the form */  //创建并且显示图表
			java.awt.EventQueue.invokeLater(new Runnable() {	//多线程
				public void run() {			//多线程要运行的代码段
					if (myECGShowUI == null) {
						myECGShowUI = new MyECGShowUI("ecg", 5000L);
					}
					myECGShowUI.setVisible(true);
				}
			});
		} catch (UnknownHostException e) {		//public void connect()对应的异常处理。未知的主机异常
			// TODO Auto-generated catch block
			e.printStackTrace();	//打印栈的跟踪
		} catch (IOException e) {	//IO异常
			// TODO Auto-generated catch block
			e.printStackTrace();	//打印栈的跟踪
		}
		try {		//处理InputStream的异常
			is = s.getInputStream();	//把Socket的实例s获得的输入流给InputStream类型的is
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startReceive(){		//开始接收,startReceive方法
		int len = 0;	//初始化长度为0
		int lenTemp;	//长度len的临时变量
		while(true){		//这个方法就是做这个while循环
			if(stopFlag){		//如果停止传输
				try {
					WelcomeWindow.welcomeWindow.getFos().close();	//关闭（信息获取？）
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;	//停止传输的话就跳出循环
			}
			try {		//如果没有停止传输
				lenTemp = is.read(receivedTemp);	//读入字节流,private byte[] receivedTemp = new byte[1024];   //接收临时变量，1024个字节
				System.arraycopy(receivedTemp, 0, receivedBuffer, len,
						lenTemp);	//System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
				len = lenTemp + len;	//用lenTemp更新receivedBuffer的长度len
				while (len >= 3 && len >= ((receivedBuffer[2] & 0xFF)*256 + (receivedBuffer[1] & 0xFF)+3)) {	//不知道是什么意思
					int frameLen = (receivedBuffer[2] & 0xFF)*256 + (receivedBuffer[1] & 0xFF)+3;	//帧长度frameLen
//						if (WelcomeWindow.welcomeWindow.getGuardianData() != null) {
//							switch (receivedBuffer[0]) {
//							case 0x01:
//							WelcomeWindow.welcomeWindow.getGuardianData().heart_rate = ((receivedBuffer[14]<<8)+(receivedBuffer[15]&0xFF))+"";
//							WelcomeWindow.welcomeWindow.getFos().write(receivedBuffer, 16, 3000);
//							break;
//							case 0x03:
//							WelcomeWindow.welcomeWindow.getGuardianData().systolic_pressure = ((receivedBuffer[6]<<8)+(receivedBuffer[7]&0xFF))+"";
//							WelcomeWindow.welcomeWindow.getGuardianData().diastolic_pressure = ((receivedBuffer[8]<<8)+(receivedBuffer[9]&0xFF))+"";
//							break;
//							case 0x04:
//							WelcomeWindow.welcomeWindow.getGuardianData().blood_oxygen = receivedBuffer[8]+"";
////							UpdateData.dataReadyFlag2 = true;
//							break;
//							}
//						}
//							if (WelcomeWindow.welcomeWindow.getALSMW() != null)
//								switch (receivedBuffer[0]) {
//								case 0x01:
//									WelcomeWindow.welcomeWindow
//										.getALSMW()
//										.getjTextField26()
//										.setText((receivedBuffer[14]<<8)+(receivedBuffer[15]&0xFF)+" bpm");
//									if(WelcomeWindow.welcomeWindow.getALSMW().getMyECGShowUI() != null){
//										WelcomeWindow.welcomeWindow.getALSMW().getMyECGShowUI().getDataReFresher().refreshData(Arrays.copyOfRange(receivedBuffer, 16, 3016));
//									}
//									break;
//								case 0x03:
//									WelcomeWindow.welcomeWindow
//										.getALSMW()
//										.getjTextField27()
//										.setText((receivedBuffer[6]<<8)+(receivedBuffer[7]&0xFF)+" mmHg");
//									WelcomeWindow.welcomeWindow
//										.getALSMW()
//										.getjTextField28()
//										.setText((receivedBuffer[8]<<8)+(receivedBuffer[9]&0xFF)+" mmHg");
//									break;
//								case 0x04:
//									WelcomeWindow.welcomeWindow
//									.getALSMW()
//									.getjTextField29()
//									.setText(receivedBuffer[8]+"%");
//									break;
//								}
					// readBuffer = Arrays.copyOfRange(readBuffer, frameLen, length);

                    if(receivedBuffer[0]==0x01){
                        WelcomeWindow.welcomeWindow.getFos().write(receivedBuffer, 16, 3000);
                        myECGShowUI.getDataReFresher().refreshData(Arrays.copyOfRange(receivedBuffer, 16, 3016));
                    }

						System.out.println(len);
						System.out.println(frameLen);
					System.arraycopy(receivedBuffer, frameLen, receivedBuffer, 0, len - frameLen);	//更新receivedBuffer
					len = len - frameLen;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override	  //重载run()方法
	public void run() {	  //public class TCPClient extends Thread的线程
		// TODO Auto-generated method stub
		connect();
		startReceive();
		try {
			//is.close();
			s.shutdownInput();
			s.close();
			System.out.println("关闭成功！");
			WelcomeWindow.welcomeWindow.getTCPC().getjButton1().setText("确定");
			WelcomeWindow.welcomeWindow.getTCPC().getjTextField1().setEnabled(true);
			WelcomeWindow.welcomeWindow.getTCPC().getjTextField2().setEnabled(true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
