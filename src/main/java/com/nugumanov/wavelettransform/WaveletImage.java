package com.nugumanov.wavelettransform;

import java.awt.image.BufferedImage;

public interface WaveletImage {

    int getIterationCount();

    double[][] getWaveletArray();

    TransformType getTransformType();

    WaveletType getWaveletType();

    BufferedImage getSourceImage();

    BufferedImage getTransformedImage();

    BufferedImage getCroppedImage();
}
