package com.nugumanov.wavelettransform;

import com.nugumanov.wavelettransform.enums.TransformType;
import com.nugumanov.wavelettransform.enums.WaveletType;

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
