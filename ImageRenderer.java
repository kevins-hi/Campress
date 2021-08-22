import java.awt.Color;

public class ImageRenderer {
    private int width;
    private int height;

    public void initialize(int w, int h) {
        this.width = w;
        this.height = h;

        StdDraw.setCanvasSize(width, height);
        StdDraw.setXscale(0, width);
        StdDraw.setYscale(0, height);

        StdDraw.clear(new Color(255, 255, 255));

        StdDraw.enableDoubleBuffering();
        StdDraw.show();
    }

    public void renderFrame(Pixel[][] image) {
        StdDraw.clear(new Color(255, 255, 255));

        for (int i = 0; i < image.length; ++i) {
            for (int j = 0; j < image[0].length; ++j) {
                Pixel pixel = image[i][j];
                Color pixelColor = pixel.getColor();
                StdDraw.setPenColor(pixelColor);
                StdDraw.filledSquare(i, j, 0.5);
            }
        }

        StdDraw.show();
    }
}