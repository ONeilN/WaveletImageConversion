package com.nugumanov.wavelettransform.test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Helper class for uploading and saving images.
 * @author Nugumanov Aizat
 */
public class ImageOpenSave implements ImageInOut {

    /**
     * Method for uploading images to the application.
     * @param file Image to upload.
     * @return Image to wavelet transform.
     */
    public BufferedImage inputImage(File file) {

        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bufferedImage;
    }

    /**
     * Method for saving the converted image.
     * @param image Image to save.
     * @param outFile File to save.
     * @param format Image format.
     */
    public void outputImage(BufferedImage image, File outFile, String format) {

        try {
            ImageIO.write(image, format, outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
