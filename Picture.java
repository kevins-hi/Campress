import java.awt.image.BufferedImage;
import java.awt.Color;

public class Picture {
    private int width, height;
    private Pixel[][] pixelArray;
    private double[][] rMatrix;
    private double[][] gMatrix;
    private double[][] bMatrix;

    public Picture(BufferedImage input) {
        this.width = input.getWidth();
        this.height = input.getHeight();
        this.pixelArray = new Pixel[width][height];

        for (int i = 0; i < this.width; ++i) {
            for (int j = 0; j < this.height; ++j) {
                this.pixelArray[i][height - j - 1] = new Pixel(new Color(input.getRGB(i, j)));
            }
        }

        this.rMatrix = generateRMatrix();
        this.gMatrix = generateGMatrix();
        this.bMatrix = generateBMatrix();
    }

    public Picture(Pixel[][] inputArray) {
        this.height = inputArray.length;
        this.width = inputArray[0].length;
        this.pixelArray = inputArray;

        this.rMatrix = generateRMatrix();
        this.gMatrix = generateGMatrix();
        this.bMatrix = generateBMatrix();
    }

    public Pixel[][] getPixels() {
        return this.pixelArray;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    private double[][] generateRMatrix() {
        double[][] rMatrix = new double[this.width][this.height];
        for (int i = 0; i < this.width; ++i) {
            for (int j = 0; j < this.height; ++j) {
                rMatrix[i][j] = (double) this.pixelArray[i][j].getColor().getRed();
            }
        }
        return rMatrix;
    }

    private double[][] generateGMatrix() {
        double[][] gMatrix = new double[this.width][this.height];
        for (int i = 0; i < this.width; ++i) {
            for (int j = 0; j < this.height; ++j) {
                gMatrix[i][j] = (double) this.pixelArray[i][j].getColor().getGreen();
            }
        }
        return gMatrix;
    }

    private double[][] generateBMatrix() {
        double[][] bMatrix = new double[this.width][this.height];
        for (int i = 0; i < this.width; ++i) {
            for (int j = 0; j < this.height; ++j) {
                bMatrix[i][j] = (double) this.pixelArray[i][j].getColor().getBlue();
            }
        }
        return bMatrix;
    }

    public double[][] getRMatrix() {
        return this.rMatrix;
    }

    public double[][] getGMatrix() {
        return this.gMatrix;
    }

    public double[][] getBMatrix() {
        return this.bMatrix;
    }

    public void grayScale() {
        for (int i = 0; i < this.width; ++i) {
            for (int j = 0; j < this.height; ++j) {
                this.pixelArray[i][j].grayScale();
            }
        }
    }
}