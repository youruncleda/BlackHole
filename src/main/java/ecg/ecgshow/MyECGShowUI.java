/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ecg.ecgshow;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.WindowAdapter;
//import java.awt.event.WindowEvent;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import myecg.myanalizer.Analizer;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;

import com.alee.laf.WebLookAndFeel;

/**
 *
 * @author MCH
 */
public class MyECGShowUI extends javax.swing.JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form MyECGShowUI
     */
	
	// Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    public static final int LEAD_COUNT=3;
	private DataRefresher dataReFresher;
	private JPanel ecgPanel;
	private JLabel label_HI;
	private JLabel label_HB;
	private JLabel lblBeat;
	private JLabel label_APB;
	private JLabel label_VPB;
	private JLabel label_HT;
	private JLabel isAPCLabel;
	private JLabel isPVCLabel;
	private JLabel isBeatLabel;
	private JPanel panel_PI;
	private JLabel label_PI;
	private JLabel label_Name;
	private JLabel lblName;
	private JLabel label_ID;
	private JLabel lblId;
	private JPanel panel_OP;
	private JButton showException;
	private JButton stopRefresh;
	private JLabel label_OP;
	private JPanel panel_charts;
	
	private TimeSeries[] ecgSerises = new TimeSeries[LEAD_COUNT];
//	private Analizer analizer;	
	
	
    public MyECGShowUI(String title, long timeZone) {		//构造方法
    	super(title);
        initComponents(timeZone);
        ECGShow();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents(long timeZone) {		//初始化组件

    	double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    	double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        jScrollPane1 = new javax.swing.JScrollPane();		//滚动条
        jPanel1 = new javax.swing.JPanel();
        
        showException = new javax.swing.JButton();
        stopRefresh = new javax.swing.JButton();
        
        label_HI = new javax.swing.JLabel();
        label_HB = new javax.swing.JLabel();
        lblBeat = new javax.swing.JLabel();
        label_APB = new javax.swing.JLabel();
        label_VPB = new javax.swing.JLabel();
        label_HT = new javax.swing.JLabel();
        isAPCLabel = new javax.swing.JLabel();
        isPVCLabel = new javax.swing.JLabel();
        isBeatLabel = new javax.swing.JLabel();
        label_PI = new javax.swing.JLabel();
        label_Name = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        label_ID = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        label_OP = new javax.swing.JLabel();
        
        ecgPanel = new javax.swing.JPanel();
        panel_PI = new javax.swing.JPanel();
        panel_OP = new javax.swing.JPanel();
        panel_charts = new javax.swing.JPanel(new GridLayout(LEAD_COUNT,1));

//      setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        
        showException.setText("异常");
        stopRefresh.setText("暂停");
        
        label_HI.setText("健康信息：");
        label_HB.setText("心率：");
        lblBeat.setText("beat");
        label_APB.setText("房性早搏：");
        label_VPB.setText("室性早搏：");
        label_HT.setText("心动过速：");
        isAPCLabel.setText("否");
        isPVCLabel.setText("否");
        isBeatLabel.setText("否");
        label_PI.setText("个人信息：");
        label_Name.setText("姓名：");
        lblName.setText("name");
        label_ID.setText("ID：");
        lblId.setText("id");
        label_OP.setText("操作：");

        javax.swing.GroupLayout ecgPanelLayout = new javax.swing.GroupLayout(ecgPanel);
        ecgPanel.setLayout(ecgPanelLayout);
        ecgPanelLayout.setHorizontalGroup(
          ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ecgPanelLayout.createSequentialGroup()
                .addGroup(ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                	.addGroup(ecgPanelLayout.createSequentialGroup()
                         .addGap(20, 20, 20)
                         .addComponent(label_HI))
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(label_HB)
                        .addGap(2, 2, 2)
                        .addComponent(lblBeat))
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(label_APB)
                        .addGap(2, 2, 2)
                        .addComponent(isAPCLabel))
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(label_VPB)
                        .addGap(2, 2, 2)
                        .addComponent(isPVCLabel))
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(label_HT)
                        .addGap(2, 2, 2)
                        .addComponent(isBeatLabel)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        ecgPanelLayout.setVerticalGroup(
        	ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
             .addGroup(ecgPanelLayout.createSequentialGroup()
                .addGroup(ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_HI)))
                .addGroup(ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_HB))
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblBeat)))
                .addGroup(ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_APB))
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(isAPCLabel)))
                .addGroup(ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_VPB))
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(isPVCLabel)))
                .addGroup(ecgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_HT))
                    .addGroup(ecgPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(isBeatLabel)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout panel_PILayout = new javax.swing.GroupLayout(panel_PI);
        panel_PI.setLayout(panel_PILayout);
        panel_PILayout.setHorizontalGroup(
        	panel_PILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PILayout.createSequentialGroup()
                .addGroup(panel_PILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                	.addGroup(panel_PILayout.createSequentialGroup()
                         .addGap(20, 20, 20)
                         .addComponent(label_PI))
                    .addGroup(panel_PILayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(label_Name)
                        .addGap(2, 2, 2)
                        .addComponent(lblName))
                    .addGroup(panel_PILayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(label_ID)
                        .addGap(2, 2, 2)
                        .addComponent(lblId)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        panel_PILayout.setVerticalGroup(
        	panel_PILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_PILayout.createSequentialGroup()
                .addGroup(panel_PILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_PILayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_PI)))
                .addGroup(panel_PILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_PILayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_Name))
                    .addGroup(panel_PILayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblName)))
                .addGroup(panel_PILayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_PILayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_ID))
                    .addGroup(panel_PILayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lblId)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        
        javax.swing.GroupLayout panel_OPLayout = new javax.swing.GroupLayout(panel_OP);
        panel_OP.setLayout(panel_OPLayout);
        panel_OPLayout.setHorizontalGroup(
        	panel_OPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_OPLayout.createSequentialGroup()
                .addGroup(panel_OPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                	.addGroup(panel_OPLayout.createSequentialGroup()
                         .addGap(20, 20, 20)
                         .addComponent(label_OP))
                    .addGroup(panel_OPLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(showException)
                        .addGap(2, 2, 2)
                        .addComponent(stopRefresh)))
                .addContainerGap(90, Short.MAX_VALUE))
        );
        panel_OPLayout.setVerticalGroup(
        	panel_OPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_OPLayout.createSequentialGroup()
                .addGroup(panel_OPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_OPLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(label_OP)))
                .addGroup(panel_OPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_OPLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(showException))
                    .addGroup(panel_OPLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(stopRefresh)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
              
		for (int i = 0; i < LEAD_COUNT; i++) {
			TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
			ecgSerises[i] = new TimeSeries("导联" + (i+1));
			ecgSerises[i].setMaximumItemAge(timeZone);
			timeseriescollection.addSeries(ecgSerises[i]);
			DateAxis dateaxis = new DateAxis("Time");
			NumberAxis numberaxis = new NumberAxis("ecg");
			dateaxis.setTickLabelFont(new Font("SansSerif", 0, 12));
			numberaxis.setTickLabelFont(new Font("SansSerif", 0, 12));
			dateaxis.setLabelFont(new Font("SansSerif", 0, 14));
			numberaxis.setLabelFont(new Font("SansSerif", 0, 14));

			XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer(true, false);
			xylineandshaperenderer.setSeriesPaint(0, Color.red);
			XYPlot xyplot = new XYPlot(timeseriescollection, dateaxis, numberaxis, xylineandshaperenderer);
			xyplot.setBackgroundPaint(Color.lightGray);
			xyplot.setDomainGridlinePaint(Color.red);
			xyplot.setRangeGridlinePaint(Color.blue);
			xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));

			dateaxis.setAutoRange(true);
			dateaxis.setLowerMargin(0.0D);
			dateaxis.setUpperMargin(0.0D);
			dateaxis.setTickLabelsVisible(true);
			numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
			numberaxis.setLowerBound(1500D);
			numberaxis.setUpperBound(3000D);
			JFreeChart jfreechart = new JFreeChart(xyplot);
			jfreechart.setBackgroundPaint(Color.white);
			ChartPanel chartpanel = new ChartPanel(jfreechart,
				(int) lx * 5 / 9, (int) ly * 9 / 40, 0, 0,
				Integer.MAX_VALUE, Integer.MAX_VALUE, true, true, false,
				true, false, false);

			chartpanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createEmptyBorder(4, 4, 4, 4),
				BorderFactory.createLineBorder(Color.black)));

			panel_charts.add(chartpanel);
		}

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(panel_PI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(ecgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(panel_OP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(panel_charts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        )
                    )
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(panel_PI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(ecgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(panel_OP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        )
                .addGap(10, 10, 10)
                .addComponent(panel_charts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);  
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void ECGShow() {	
		dataReFresher = new DataRefresher(ecgSerises);
		stopRefresh.addActionListener(dataReFresher);
		
//		addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent e) {
//				if (JOptionPane.showConfirmDialog(null, "确定退出吗?") == JOptionPane.OK_OPTION)
//					System.exit(0);
//			}
//		});

//		analizer = new Analizer();
//		dataReFresher.addObserver(analizer);
		dataReFresher.start();
	}

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
	
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MyECGShowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyECGShowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyECGShowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyECGShowUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	new MyECGShowUI("ecg",5000L).setVisible(true);
            }
        });
    }

    public DataRefresher getDataReFresher() {
		return dataReFresher;
	}

	public void setDataReFresher(DataRefresher dataReFresher) {
		this.dataReFresher = dataReFresher;
	}


}