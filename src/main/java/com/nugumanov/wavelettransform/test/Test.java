package com.nugumanov.wavelettransform.test;

import com.nugumanov.wavelettransform.*;

import java.awt.image.BufferedImage;
import java.io.File;

public class Test {
    public static void main(String[] args) {

        ImageInOut imageInOut = new ImageOpenSave();
        WaveletTransformation waveletTransformation = new ImageTransformation();

        /**
         *  Forward Test
         */
        File forwardInputFile = new File("src/main/resources/testimages/test.png");

        BufferedImage forwardImage = imageInOut.inputImage(forwardInputFile);

        WaveletImage waveletForwardImage = new WaveletBufferedImage(forwardImage, TransformType.FORWARD, WaveletType.HAAR, 2);

        File forwardOutputFile = new File("src/main/resources/resultimages/haar.forward.test.png");
        imageInOut.outputImage(waveletForwardImage.getTransformedImage(), forwardOutputFile, "png");

        /**
         * Reverse Test
         */
        File reverseInputFile = new File("src/main/resources/testimages/haar.test.png");

        BufferedImage reverseImage = imageInOut.inputImage(reverseInputFile);

        WaveletImage waveletReverseImage = new WaveletBufferedImage(reverseImage, TransformType.REVERSE, WaveletType.HAAR, 2);

        File reverseOutputFile = new File("src/main/resources/resultimages/haar.reverse.test.png");
        imageInOut.outputImage(waveletReverseImage.getTransformedImage(), reverseOutputFile, "png");
    }
}
