package com.nugumanov.wavelettransform;

import com.nugumanov.wavelettransform.enums.TransformType;
import com.nugumanov.wavelettransform.enums.WaveletType;

import java.awt.image.BufferedImage;

interface WaveletTransformation {

    BufferedImage transform(BufferedImage bufferedImage, TransformType transformType, WaveletType waveletType, int iterations);

    BufferedImage forwardImage(BufferedImage image, WaveletType type, int iterations);

    double[][] forwardArray(BufferedImage image, WaveletType type, int iterations);

    BufferedImage reverseImage(BufferedImage image, WaveletType type, int iterations);

    double[][] reverseArray(BufferedImage image, WaveletType type, int iterations);
}
