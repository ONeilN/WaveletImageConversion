package com.nugumanov.wavelettransform;

import java.awt.image.BufferedImage;

public interface WaveletTransformation {

    BufferedImage forwardImage(BufferedImage image, Wavelets type, int iterations);

    double[][] forwardArray(BufferedImage image, Wavelets type, int iterations);

    BufferedImage reverseImage(BufferedImage image, Wavelets type, int iterations);

    double[][] reverseArray(BufferedImage image, Wavelets type, int iterations);
}
