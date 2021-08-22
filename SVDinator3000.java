import Jama.Matrix;
import Jama.SingularValueDecomposition;

public class SVDinator3000 {
    int height, width;
    Matrix S;
    Matrix U;
    Matrix V;

    public SVDinator3000(double[][] input) {
        this.height = input.length;
        this.width = input[0].length;
        Matrix inputAsMatrix = new Matrix(input);
        if (height < width) {
            inputAsMatrix = inputAsMatrix.transpose();
        }
        SingularValueDecomposition svd = inputAsMatrix.svd();
        this.S = svd.getS();
        this.U = svd.getU();
        this.V = svd.getV();
    }

    public int[][] getCompressionNumber(int k) {
        double[][] sArray = this.getFirstKSingularValues(k);
        double[][] newA = this.getNewA(sArray);
        int[][] compressed = new int[this.height][this.width];
        for (int i = 0; i < this.height; ++i) {
            for (int j = 0; j < this.width; ++j) {
                double elem = newA[i][j];
                if (elem < 0) {
                    compressed[i][j] = 0;
                } else if (elem < 255) {
                    compressed[i][j] = (int) newA[i][j];
                } else {
                    compressed[i][j] = 255;
                }
            }
        }
        return compressed;
    }

    private double[][] getFirstKSingularValues(int k) {
        double[][] sArray = this.S.getArray();
        int min = Math.min(this.height, this.width);
        for (int i = k; i < min; ++i) {
            sArray[i][i] = 0.0;
        }
        return sArray;
    }

    private double[][] getNewA(double[][] sArray) {
        Matrix newS = new Matrix(sArray);
        Matrix vT = this.V.transpose();
        Matrix A = this.U.times(newS).times(vT);
        if (height < width) {
            A = A.transpose();
        }
        return A.getArray();
    }
}
