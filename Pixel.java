import java.awt.Color;

public class Pixel {
    private Color color;

    public Pixel(Color color) {
        this.color = color;
    }

    public Pixel() {
        this.color = new Color(255, 255, 255);
    }

    public Color getColor() {
        return this.color;
    }

    public void grayScale() {
        int r = this.color.getRed();
        int g = this.color.getGreen();
        int b = this.color.getBlue();
        int gray = (r + g + b) / 3;
        this.color = new Color(gray, gray, gray);
    }
}