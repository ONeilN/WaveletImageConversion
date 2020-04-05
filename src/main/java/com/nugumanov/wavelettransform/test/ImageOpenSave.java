package com.nugumanov.wavelettransform.test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageOpenSave implements ImageInOut {

    public BufferedImage inputImage(File file) {

        BufferedImage bufferedImage = null;
        try {
            bufferedImage = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bufferedImage;
    }

    public void outputImage(BufferedImage image, File outFile, String format) {

        try {
            ImageIO.write(image, format, outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
