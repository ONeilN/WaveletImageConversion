package com.nugumanov.wavelettransform.test;

import com.nugumanov.wavelettransform.ImageTransformation;
import com.nugumanov.wavelettransform.WaveletTransformation;
import com.nugumanov.wavelettransform.Wavelets;

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

        BufferedImage resultForward = waveletTransformation.forwardImage(forwardImage, Wavelets.HAAR, 2);

        File forwardOutputFile = new File("src/main/resources/resultimages/haar.forward.test.png");
        imageInOut.outputImage(resultForward, forwardOutputFile, "png");

        /**
         * Reverse Test
         */
        File reverseInputFile = new File("src/main/resources/testimages/haar.test.png");

        BufferedImage reverseImage = imageInOut.inputImage(reverseInputFile);

        BufferedImage resultReverse = waveletTransformation.reverseImage(reverseImage, Wavelets.HAAR, 2);

        File reverseOutputFile = new File("src/main/resources/resultimages/haar.reverse.test.png");
        imageInOut.outputImage(resultReverse, reverseOutputFile, "png");
    }
}
