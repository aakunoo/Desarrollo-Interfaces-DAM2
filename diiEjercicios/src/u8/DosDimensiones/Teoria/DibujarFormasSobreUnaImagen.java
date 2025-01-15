package u8.DosDimensiones.Teoria;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class DibujarFormasSobreUnaImagen {
  public static void main(String[] argv) throws Exception {
    int width = 500;
    int height = 500;

    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    Graphics2D g2d = bufferedImage.createGraphics();

    g2d.setColor(Color.white);
    g2d.fillRect(0, 0, width, height);
    g2d.setColor(Color.black);
    g2d.fillOval(0, 0, width, height);
    g2d.setColor(Color.blue);
    g2d.drawLine(0, 0, width, height);
    g2d.drawLine(0, height, width, 0);
    g2d.setColor(Color.ORANGE);
    g2d.fillOval(width/2 - 40, height/2 - 40 , 80, 80);
    
    
    g2d.dispose();
    RenderedImage rendImage = bufferedImage;

    File file = new File("newimage.png");
    ImageIO.write(rendImage, "png", file);

    file = new File("newimage.jpg");
    ImageIO.write(rendImage, "jpg", file);
  }
}