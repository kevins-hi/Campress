import java.awt.Color;
import java.lang.Math;

public class Campress {
    public static void displayCompressions(Picture pic, ImageRenderer rend) {
        int width = pic.getWidth();
        int height = pic.getHeight();
        int min = Math.min(width, height);
        int pauseTime = 200;
        for (int i = 1; i <= min; ++i) {
            displayCompressionNumber(i, pic, rend);
            StdDraw.setPenColor(Color.black);
            StdDraw.text(width / 2, height - 12, i + "");
            StdDraw.show();
            if (i < min / 10) {
                pauseTime = 200;
            } else if (i < min / 2) {
                pauseTime = 50;
            } else {
                pauseTime = 0;
            }
            StdDraw.pause(pauseTime);
        }
    }

    private static void displayCompressionNumber(int k, Picture pic, ImageRenderer rend) {
        int width = pic.getWidth();
        int height = pic.getHeight();
        SVDinator3000 rSVD = new SVDinator3000(pic.getRMatrix());
        SVDinator3000 gSVD = new SVDinator3000(pic.getGMatrix());
        SVDinator3000 bSVD = new SVDinator3000(pic.getBMatrix());
        int[][] reds = rSVD.getCompressionNumber(k);
        int[][] greens = gSVD.getCompressionNumber(k);
        int[][] blues = bSVD.getCompressionNumber(k);
        Pixel[][] pixels = new Pixel[width][height];
        for (int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                pixels[i][j] = new Pixel(new Color(reds[i][j], greens[i][j], blues[i][j]));
            }
        }
        rend.renderFrame(pixels);
    }
}
