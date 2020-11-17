package com.resemble.utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public abstract class ImageUtils {

    public static final int IMAGE_TYPE = BufferedImage.TYPE_INT_ARGB;
    private static final boolean CHECK_TYPE = true;

    /**
     * Check image type.
     *
     * @param img
     * @param name
     * @throws IllegalArgumentException when image type is invalid
     */
    public static void checkImageType(BufferedImage img, String name) throws IllegalArgumentException {
        if (CHECK_TYPE && img.getType() != IMAGE_TYPE) {
            throw new IllegalArgumentException(String.format("Invalid %s.type=%s, expected %s",
                    name, img.getType(), IMAGE_TYPE));
        }
    }

    public static BufferedImage resize(BufferedImage image,
                              int width, int height) {
        BufferedImage resized = new BufferedImage(width,height,image.getType());
        // scales the input image to the output image
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return resized;
    }
        /**
         * Check image dimensions are matching.
         *
         * @param img1
         * @param imgName1
         * @param img2
         * @param imgName2
         * @throws IllegalArgumentException when image dimensions are not matching
         */
        public static void checkImageMatch (BufferedImage img1, String imgName1, BufferedImage img2, String imgName2)
            throws IllegalArgumentException {
            if ((img1.getWidth() != img2.getWidth()) || (img1.getHeight() != img2.getHeight())) {
                throw new IllegalArgumentException(String.format("Size mismatch (%s.{w,h}={%d,%d} and %s.{w,h}={%d,%d})",
                        imgName1, img1.getWidth(), img1.getHeight(), imgName2, img2.getWidth(), img2.getHeight()));
            }
        }

        /**
         * Create new empty buffered image of the same size and type as <code>img</code>.
         *
         * @param img
         * @return new empty buffered image
         */
        public static BufferedImage createEmptyImage (BufferedImage img){
            return new BufferedImage(img.getWidth(), img.getHeight(), img.getType());
        }

        /**
         * Read buffered image from file and convert it to desired format if needed.
         *
         * @param file image file
         * @return buffered image read from file
         * @throws java.io.IOException on error reading image file
         */
        public static BufferedImage readImage (File file) throws IOException {
            BufferedImage bufImg;
            try {
                bufImg = ImageIO.read(file);
            } catch (IOException ex) {
                throw new IOException("Could not read image file '" + file + "'", ex);
            }
            if (CHECK_TYPE && bufImg.getType() != IMAGE_TYPE) {
                BufferedImage convertedImg = new BufferedImage(bufImg.getWidth(), bufImg.getHeight(), IMAGE_TYPE);
                convertedImg.getGraphics().drawImage(bufImg, 0, 0, null);
                return convertedImg;
            }
            return bufImg;
        }

        /**
         * Read buffered image from URL and convert it to desired format if needed.
         *
         * @param imgUrl image URL
         * @return buffered image read from file
         * @throws java.io.IOException on error reading image file
         */
        public static BufferedImage readImage (URL imgUrl) throws IOException {
            BufferedImage bufImg;
            try {
                bufImg = ImageIO.read(imgUrl);
            } catch (IOException ex) {
                throw new IOException("Could not read image url '" + imgUrl + "'", ex);
            }
            if (CHECK_TYPE && bufImg.getType() != IMAGE_TYPE) {
                BufferedImage convertedImg = new BufferedImage(bufImg.getWidth(), bufImg.getHeight(), IMAGE_TYPE);
                convertedImg.getGraphics().drawImage(bufImg, 0, 0, null);
                return convertedImg;
            }
            return bufImg;
        }

    /**
     * Find the White background and returned a cropped image
     *
     * @param image Image to Crop
     * @param whiteThreshold Threshold to consider a grayscaled pixel as white. 0 = completely white
     * @return cropped Image
     */
        public static BufferedImage cropWhiteBackground(BufferedImage image, int whiteThreshold){
            int firstX = 9999;
            int firstY = 9999;
            int lastX = 0;
            int lastY = 0;
            for (int y = 0; y < image.getHeight(); y++) {
                for (int x = 0; x < image.getWidth(); x++) {
                    int grayScalePixel= image.getRGB(x, y)& 0xFF;
                    boolean isWhite = grayScalePixel  >= 255 - whiteThreshold;
                    if(!isWhite && x < firstX) {
                        firstX = x;
                    }
                    if(!isWhite && y < firstY) {
                        firstY = y;
                    }
                    if(!isWhite && x > lastX) {
                        lastX = x;
                    }
                    if(!isWhite && y > lastY) {
                        lastY = y;
                    }
                }
            }
            return image.getSubimage(firstX,firstY, lastX-firstX, lastY-firstY);
        }
    }
