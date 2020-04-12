package com.nugumanov.wavelettransform;

import com.nugumanov.wavelettransform.transforms.Transform;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageTransformation implements WaveletTransformation {

    private Transform waveletTransform = null;

    public BufferedImage transform(BufferedImage bufferedImage, TransformType transformType, WaveletType waveletType, int iterations) {
        switch (transformType) {
            case FORWARD:
                return forwardImage(bufferedImage, waveletType, iterations);
            case REVERSE:
                return reverseImage(bufferedImage, waveletType, iterations);
            default: return null;
        }
    }

    public BufferedImage forwardImage(BufferedImage bufferedImage, WaveletType type, int iterations) {

        waveletTransform = WaveletFactory.getTransform(type);
        BufferedImage resultImage = bufferedImage;

        int width = bufferedImage.getWidth();    // Ширина изображения
        int height = bufferedImage.getHeight();  // Высота изображения

        Color c;            // Переменная для хранения цвета пикселя

        double[][] Red = new double[width][height];
        double[][] Green = new double[width][height];
        double[][] Blue = new double[width][height];

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                c = new Color(bufferedImage.getRGB(i, j));
                Red[i][j] = Scale(0, 255, -1, 1, c.getRed());
                Green[i][j] = Scale(0, 255, -1, 1, c.getGreen());
                Blue[i][j] = Scale(0, 255, -1, 1, c.getBlue());
            }
        }

        waveletTransform.FWT(Red, iterations, width, height);
        waveletTransform.FWT(Green, iterations, width, height);
        waveletTransform.FWT(Blue, iterations, width, height);

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                c = new Color((int) Scale(-1, 1, 0, 255, Red[i][j]),
                        (int) Scale(-1, 1, 0, 255, Green[i][j]),
                        (int) Scale(-1, 1, 0, 255, Blue[i][j]));
                resultImage.setRGB(i, j, c.getRGB());
            }
        }

        return resultImage;
    }

    public double[][] forwardArray(BufferedImage image, WaveletType type, int iterations) {
        return new double[0][];
    }

    public BufferedImage reverseImage(BufferedImage bufferedImage, WaveletType type, int iterations) {

        waveletTransform = WaveletFactory.getTransform(type);
        BufferedImage resultImage = bufferedImage;

        int width = bufferedImage.getWidth();    // Ширина изображения
        int height = bufferedImage.getHeight();  // Высота изображения

        Color c;            // Переменная для хранения цвета пикселя

        double[][] Red = new double[width][height];
        double[][] Green = new double[width][height];
        double[][] Blue = new double[width][height];

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                c = new Color(bufferedImage.getRGB(i, j));
                Red[i][j] = Scale(0, 255, -1, 1, c.getRed());
                Green[i][j] = Scale(0, 255, -1, 1, c.getGreen());
                Blue[i][j] = Scale(0, 255, -1, 1, c.getBlue());
            }
        }

        waveletTransform.IWT(Red, iterations, width, height);
        waveletTransform.IWT(Green, iterations, width, height);
        waveletTransform.IWT(Blue, iterations, width, height);

        for (int j = 0; j < height; j++) {
            for (int i = 0; i < width; i++) {
                c = new Color((int) Scale(-1, 1, 0, 255, Red[i][j]), (int) Scale(-1, 1, 0, 255, Green[i][j]), (int) Scale(-1, 1, 0, 255, Blue[i][j]));
                resultImage.setRGB(i, j, c.getRGB());
            }
        }

        return resultImage;
    }

    public double[][] reverseArray(BufferedImage image, WaveletType type, int iterations) {
        return new double[0][];
    }

    public double Scale(double fromMin, double fromMax, double toMin, double toMax, double x) {

        if (fromMax - fromMin == 0) return 0;
        double value = (toMax - toMin) * (x - fromMin) / (fromMax - fromMin) + toMin;
        if (value > toMax) {
            value = toMax;
        }
        if (value < toMin) {
            value = toMin;
        }
        return value;
    } // Scale
}
