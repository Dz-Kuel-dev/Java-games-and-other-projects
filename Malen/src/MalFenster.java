import javax.swing.*;
import java.awt.*;

public class MalFenster extends JFrame{

        private boolean isBackground;//false

        public MalFenster(){
            this.setSize(800, 800);
            this.setTitle(":: MALEN IM FENSTER ::");
            //wenn nicht geschloseen, prozess nicht getötet, nur fenster geschlosssen
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
            //Wiese
            g.setColor(new Color(100, 220, 100));
            g.fillRect(0,600,1000,1000);
            //Sonne
            g.setColor(Color.YELLOW);
            g.fillOval(20,20, 150, 150);
            //Schuhe
            g.setColor(new Color(210,0, 50));
            g.fillOval(220,470, 140, 185);
            g.fillOval(420,470, 140, 185);
            //Shuhe-Schatten
            g.setColor(new Color(180,20, 20));
            g.fillOval(235,470, 115, 185);
            g.fillOval(435,470, 115, 185);
            //Arm-Rechts-Schatten
            g.setColor(new Color(204, 86, 149));
            g.fillOval(495,268, 140, 110);
            //Arm-Rechts
            g.setColor(Color.PINK);
            g.fillOval(500,270, 130, 100);
            //Arm-Links-Schatten
            g.setColor(new Color(240, 128, 170));
            g.fillOval(156,268, 135, 110);
            //Körber-Schatten
            g.setColor(new Color(240, 128, 170));
            g.fillOval(199,198, 400, 400);
            //Körber
            g.setColor(Color.PINK);
            g.fillOval(200,200, 390, 380);
            //Auge-Umriss
            g.setColor(Color.BLACK);
            g.fillOval(500,300, 35, 80);
            g.fillOval(420,300, 35, 80);
            //Auge-Farbe
            g.setColor(Color.BLUE);
            g.fillOval(425,330, 25, 40);
            g.fillOval(505,330, 25, 40);
            //Auge-Innen
            g.setColor(Color.BLACK);
            g.fillOval(425,310, 25, 40);
            g.fillOval(505,310, 25, 40);
            //Auge-Licht
            g.setColor(Color.WHITE);
            g.fillOval(427,303, 20, 36);
            g.fillOval(507,303, 20, 36);
            //Mund
            g.setColor(new Color(180,0, 50));
            g.fillOval(467,393, 15, 30);
            //Zunge
            g.setColor(Color.RED);
            g.fillOval(470,405, 10, 15);
            //Wangen
            g.setColor(new Color(245, 137, 211));
            g.fillOval(380,380, 40, 25);
            g.fillOval(540,380, 30, 25);
            //Arm-Links
            g.setColor(Color.PINK);
            g.fillOval(160,270, 130, 100);






//            if(!isBackground) {
//                g.setColor(new Color(116, 167, 254));//kann überschrieben werden wenn erneut genutzt
//                                         //immer RGB wählen
//                                         //immer großbuchstaben, oder rgb werte
//                g.fillRect(0, 0, 1000, 1000);
//                isBackground = true;
//            }
//
//            g.setColor(Color.ORANGE);
//            g.fillRect(50, 100, 100, 100);
//
//            g.setColor(Color.ORANGE);
//            g.drawRect(200, 100, 100, 100);
//
//            g.setColor(new Color(232,0,0));
//            g.fillOval(200,200,50,50);
//
//            g.setColor(new Color(0,230,0));
//            g.drawString("Hallo Welt", 300, 300);
//
//            g.setColor(new Color(0,0,230));
//            g.fillPolygon(new Polygon(new int[]{600, 400, 800}, new int[]{200, 400, 400}, 3));
        }
}
