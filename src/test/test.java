import actor.Listener.NoticeListener;
<<<<<<< HEAD
import ct.ctshow.ImagePanel;
=======
import ct.ctshow.CTHistoryData;
>>>>>>> 9b3c977da614eae073e6be1ea38e19866a553054
import util.ImageUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by zzq on 16/5/29.
 */
public class Test extends JFrame {
    public Test(){

    }
    public static void main(String[] args) {
<<<<<<< HEAD
        //JScrollPane jScrollPane =new JScrollPane(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        try {
            BufferedImage  bufferedImage=ImageIO.read(new File("/Users/macbook/Documents/IdeaProject/BlackHole/res/肝   癌/肝   癌20160529141030.png"));
            BufferedImage zoomImage = ImageUtil.zoom(bufferedImage,100,100);
            ImagePanel imagePanel=new ImagePanel(zoomImage);
            Test kk=new Test();
            kk.add(imagePanel);
           //kk.repaint();
            kk.setVisible(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //test1.add(jScrollPane);
=======
>>>>>>> 9b3c977da614eae073e6be1ea38e19866a553054

    }
}
