import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class Main {

    public static void main(String[] args) {

        JFrame jFrame = getJFrame();
        jFrame.add(new MyComponents());

        String[] strings = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for(String s : strings){
            System.out.println(s);
        }

    }

    static class MyComponents extends JComponent{
        @Override
        protected void paintComponent(Graphics graphics) {
            Graphics2D graphics2D = (Graphics2D) graphics;
            graphics2D.setBackground(Color.gray);
            Font font = new Font("Verdana", Font.BOLD, 30);
            Point2D p1 = new Point2D.Float(20, 70);
            Point2D p2 = new Point2D.Float(480, 70);
            Line2D line2D = new Line2D.Float(p1, p2);
            Ellipse2D ellipse2D = new Ellipse2D.Float(30, 100, 440, 150);
            Rectangle2D rectangle2D = new Rectangle2D.Float(30, 100, 440, 150);
            Image image = new ImageIcon("src/main/resources/icon.jpg").getImage();

            graphics2D.setFont(font);
            graphics2D.setPaint(Color.green);
            graphics2D.drawString("Hello, World!", 150, 50);
            graphics2D.setPaint(Color.red);
            graphics2D.draw(line2D);
            graphics2D.setPaint(Color.blue);
            graphics2D.draw(ellipse2D);
            graphics2D.draw(rectangle2D);
            graphics2D.drawImage(image, 500, 20, null);
        }
    }

    static JFrame getJFrame(){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        //jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setTitle("This is my application");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        Image icon = toolkit.getImage("/home/dzesen/IdeaWorkspace/MyAppSwing/src/main/resources/icon.jpg");
        jFrame.setIconImage(icon);
        jFrame.setBounds(dimension.width/2-250, dimension.height/2-150, 770, 320);
        jFrame.getContentPane().setBackground(Color.gray);
        return jFrame;
    }

}
