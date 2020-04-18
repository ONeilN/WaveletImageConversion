package com.nugumanov.wavelettransform.transforms;

/**
 * A class that implements the direct and inverse two-dimensional Haar transform
 * @author Nugumanov Aizat
 */
public class HaarWaveletTransform implements WaveletTransform {

    private static double w0 = 0.5;
    private static double w1 = -0.5;
    private static double s0 = 0.5;
    private static double s1 = 0.5;

    /**
     * Direct one-dimensional wavelet transform
     * @param data - array of values to transform
     */
    public void FWT(double[] data) {

        double[] temp = new double[data.length];

        int h = data.length >> 1;
        for (int i = 0; i < h; i++) {

            int k = (i << 1);
            temp[i] = data[k] * s0 + data[k + 1] * s1;
            temp[i + h] = data[k] * w0 + data[k + 1] * w1;
        }

        for (int i = 0; i < data.length; i++) {

            data[i] = temp[i];
        }
    } // FWT 1

    /**
     * Direct two-dimensional wavelet transform
     * @param data - array of values to transform
     * @param iterations - count of iterations
     * @param width - image width
     * @param height - image height
     */
    public void FWT(double[][] data, int iterations, int width, int height) {

        int rows = width;
        int cols = height;

        double[] row = new double[cols];
        double[] col = new double[rows];

        for (int k = 0; k < iterations; k++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < row.length; j++)
                    row[j] = data[i][j];

                FWT(row);

                for (int j = 0; j < row.length; j++)
                    data[i][j] = row[j];
            }

            for (int j = 0; j < cols; j++) {
                for (int i = 0; i < col.length; i++)
                    col[i] = data[i][j];

                FWT(col);

                for (int i = 0; i < col.length; i++)
                    data[i][j] = col[i];
            }
        }
    } // FWT 2

    /**
     * Reverse one-dimensional wavelet transform
     * @param data - array of values to transform
     */
    public void IWT(double[] data) {
        double[] temp = new double[data.length];

        int h = data.length >> 1;
        for (int i = 0; i < h; i++) {

            int k = (i << 1);
            temp[k] = (data[i] * s0 + data[i + h] * w0) / w0;
            temp[k + 1] = (data[i] * s1 + data[i + h] * w1) / s0;
        }

        for (int i = 0; i < data.length; i++) {

            data[i] = temp[i];
        }
    } // IWT 1

    /**
     * Reverse two-dimensional wavelet transform
     * @param data - array of values to transform
     * @param iterations - count of iterations
     * @param width - image width
     * @param height - image height
     */
    public void IWT(double[][] data, int iterations, int width, int height) {
        int rows = width;
        int cols = height;

        double[] col = new double[rows];
        double[] row = new double[cols];

        for (int l = 0; l < iterations; l++) {
            for (int j = 0; j < cols; j++) {
                for (int i = 0; i < col.length; i++)
                    col[i] = data[i][j];

                IWT(col);

                for (int i = 0; i < col.length; i++)
                    data[i][j] = col[i];
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < row.length; j++)
                    row[j] = data[i][j];

                IWT(row);

                for (int j = 0; j < row.length; j++)
                    data[i][j] = row[j];
            }
        }
    } // IWT 2
}
