import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String path = "images/smaller.jpeg";
        BufferedImage bf = null;
        try {
            bf = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Picture pic = new Picture(bf);
        ImageRenderer rend = new ImageRenderer();
        rend.initialize(pic.getWidth(), pic.getHeight());
        Campress.displayCompressions(pic, rend);
    }
}