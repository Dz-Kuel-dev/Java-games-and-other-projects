import javax.swing.*;
import java.awt.*;

public class DrawWindow extends JFrame{

        private boolean isBackground;//false

        public DrawWindow(){
            this.setSize(800, 800);
            this.setTitle(":: DRAWING KIRBY IN WINDOW::");
            this.setDefaultCloseOperation(EXIT_ON_CLOSE);
            this.setResizable(false);

            this.setLocation(1000,250);

            this.setVisible(true);
        }


        @Override
        public void paint (Graphics g){

            if(!isBackground){
                g.setColor(new Color(120, 220, 250));
                g.fillRect(0,0,1000,1000);
                isBackground = true;
            }
            //Grass
            g.setColor(new Color(100, 220, 100));
            g.fillRect(0,600,1000,1000);
            //Sun
            g.setColor(Color.YELLOW);
            g.fillOval(20,20, 150, 150);
            //Shoes
            g.setColor(new Color(210,0, 50));
            g.fillOval(220,470, 140, 185);
            g.fillOval(420,470, 140, 185);
            //Shoes-Shadow
            g.setColor(new Color(180,20, 20));
            g.fillOval(235,470, 115, 185);
            g.fillOval(435,470, 115, 185);
            //Arm-RIght-Shadow
            g.setColor(new Color(204, 86, 149));
            g.fillOval(495,268, 140, 110);
            //Arm-Right
            g.setColor(Color.PINK);
            g.fillOval(500,270, 130, 100);
            //Arm-Left-Shadow
            g.setColor(new Color(240, 128, 170));
            g.fillOval(156,268, 135, 110);
            //Body-Shadow
            g.setColor(new Color(240, 128, 170));
            g.fillOval(199,198, 400, 400);
            //Body
            g.setColor(Color.PINK);
            g.fillOval(200,200, 390, 380);
            //Eye-Silhouette
            g.setColor(Color.BLACK);
            g.fillOval(500,300, 35, 80);
            g.fillOval(420,300, 35, 80);
            //Eye-Color
            g.setColor(Color.BLUE);
            g.fillOval(425,330, 25, 40);
            g.fillOval(505,330, 25, 40);
            //Eye-Inside
            g.setColor(Color.BLACK);
            g.fillOval(425,310, 25, 40);
            g.fillOval(505,310, 25, 40);
            //Eye-Light
            g.setColor(Color.WHITE);
            g.fillOval(427,303, 20, 36);
            g.fillOval(507,303, 20, 36);
            //Mouth
            g.setColor(new Color(180,0, 50));
            g.fillOval(467,393, 15, 30);
            //Tongue
            g.setColor(Color.RED);
            g.fillOval(470,405, 10, 15);
            //Cheeks
            g.setColor(new Color(245, 137, 211));
            g.fillOval(380,380, 40, 25);
            g.fillOval(540,380, 30, 25);
            //Arm-Left
            g.setColor(Color.PINK);
            g.fillOval(160,270, 130, 100);


        }
}
