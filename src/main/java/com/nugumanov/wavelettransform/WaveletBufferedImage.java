package com.nugumanov.wavelettransform;

import com.nugumanov.wavelettransform.transforms.TransformType;
import com.nugumanov.wavelettransform.transforms.WaveletType;

import java.awt.image.BufferedImage;

public class WaveletBufferedImage implements WaveletImage {

    private int iterationCount;
    private double[][] waveletArray;
    private TransformType transformType;
    private WaveletType waveletType;
    private BufferedImage sourceImage;
    private BufferedImage transformedImage;

    private WaveletTransformation transformation = new ImageTransformation();

    public WaveletBufferedImage(BufferedImage bufferedImage, TransformType transformType, WaveletType waveletType, int iterationCount) {

        this.iterationCount = iterationCount;
        this.transformType = transformType;
        this.waveletType = waveletType;
        this.sourceImage = bufferedImage;
        this.transformedImage = transformation.transform(bufferedImage, transformType, waveletType, iterationCount);
    }

    public int getIterationCount() {
        return iterationCount;
    }

    public double[][] getWaveletArray() {
        return waveletArray;
    }

    public TransformType getTransformType() {
        return transformType;
    }

    public WaveletType getWaveletType() {
        return waveletType;
    }

    public BufferedImage getSourceImage() {
        return sourceImage;
    }

    public BufferedImage getTransformedImage() {
        return transformedImage;
    }

    public BufferedImage getCroppedImage() {
        return null;
    }
}
