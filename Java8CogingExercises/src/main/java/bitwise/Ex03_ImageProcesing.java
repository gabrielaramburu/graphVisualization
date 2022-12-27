package bitwise;

import java.awt.image.*;
import javax.imageio.*;
import java.io.*;

public class Ex03_ImageProcesing {
  private static final String INPUT_IMAGE = "./inputImage.jpg";
  private static final String OUTPUT_IMAGE = ".outputImage.jpg";

  public static void main(String[] args) throws IOException {
    BufferedImage image = ImageIO.read(new File(INPUT_IMAGE));
    BufferedImage outImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
    procesing(image, outImage,0, 0, image.getWidth(), image.getHeight());

    File newImageFile = new File(OUTPUT_IMAGE);
    ImageIO.write(outImage, "jpg", newImageFile);
  }

  public static void procesing(BufferedImage in, BufferedImage out, int leftCorner, int topCorner,
                              int width, int height) {

      for(int x = leftCorner; x < leftCorner + width && x < in.getWidth(); x++) {
        for (int y = topCorner; y < topCorner + height && y < out.getHeight(); y++) {
          rePainting(in, out, x, y);
        }
      }

  }
  public static void rePainting(BufferedImage in, BufferedImage out, int x, int y) {
    int rgb = in.getRGB(x, y);

    int red = getRed(rgb);
    int green = getGreen(rgb);
    int blue = getBlue(rgb);

    red+=10;
    green+=20;
    blue+=40;
    
    int newRGB = createNewRGB(red, green, blue);

    out.setRGB(x, y, newRGB);
  }

  public static int createNewRGB(int red, int green, int blue) {
      int newColor = 0;
      newColor |= blue;
      newColor |= green << 8;
      newColor |= red << 16;

      newColor |= 0xFF000000;
      return newColor;
  }

  public static int getRed(int rgb) {
    return (rgb & 0x00FF0000) >> 16;
  }


  public static int getGreen(int rgb) {
    return (rgb & 0x0000FF00) >> 8;
  }


  public static int getBlue(int rgb) {
    return rgb & 0x000000FF;
  }
}
