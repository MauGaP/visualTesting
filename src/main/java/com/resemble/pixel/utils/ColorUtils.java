package com.resemble.pixel.utils;

import com.resemble.pixel.Pixel;
import java.awt.image.BufferedImage;

public abstract class ColorUtils {

    /**
     * Get brightness (grayscale value) from RGB.
     *
     * @param r red channel value (0-255)
     * @param g green channel value (0-255)
     * @param b blue channel value (0-255)
     * @return brightnss value (0-255)
     */
    public static int getBrightness(int r, int g, int b) {
        return (int) (0.3 * r + 0.59 * g + 0.11 * b);
    }

    /**
     * Get hue value from RGB.
     *
     * @param r red channel value (0-255)
     * @param g green channel value (0-255)
     * @param b blue channel value (0-255)
     * @return hue value
     */
    public static double getHue(int r, int g, int b) {
        int max = Math.max(Math.max(r, g), b);
        int min = Math.min(Math.min(r, g), b);

        if (max == min) {
            return 0.0; // achromatic
        } else {
            double d = (double) max / 255.0 - (double) min / 255.0;
            double h;
            if (r == max) {
                h = (((double) g / 255.0) - ((double) b / 255.0)) / d;
                if (g < b) {
                    h += 6.0;
                }
            } else if (g == max) {
                h = (((double) b / 255.0) - ((double) r / 255.0)) / d + 2.0;
            } else {
                h = (((double) r / 255.0) - ((double) g / 255.0)) / d + 4.0;
            }
            return h / 6.0;
        }
    }

    /**
     * Get color distance on RGB channels.
     * <p>
     * dist = (abs(a.red-b.red)+abs(a.green-b.green)+abs(a.blue-b.blue))/3
     *
     * @param a first pixel
     * @param b second pixel
     * @return RGB color distance in range [0-255]
     */
    public static int colorsDistanceRGB(Pixel a, Pixel b) {
        return (Math.abs(a.getRed().getValue() - b.getRed().getValue()) +
                Math.abs(a.getGreen().getValue() - b.getGreen().getValue()) +
                Math.abs(a.getBlue().getValue() - b.getBlue().getValue())) / 3;
    }

    /**
     * Get ARGB (0xAARRGGBB) from image at (x,y).
     *
     * @param image an image
     * @param x x coordinate
     * @param y y coordinate
     * @return ARGB (0xAARRGGBB) value at (x,y) on the image
     */
    public static int getARGB(BufferedImage image, int x, int y) {
        return image.getRGB(x, y);
    }

    /**
     * Set ARGB (0xAARRGGBB) on the image at (x,y).
     *
     * @param image an image
     * @param x x coordinate
     * @param y y coordinate
     * @param argb ARGB (0xAARRGGBB) value to be set
     */
    public static void setARGB(BufferedImage image, int x, int y, int argb) {
        image.setRGB(x, y, argb);
    }

    /**
     * Set ARGB (a,r,g,b) on the image at (x,y).
     *
     * @param image an image
     * @param x x coordinate
     * @param y y coordinate
     * @param a alpha value [0-255]
     * @param r red value [0-255]
     * @param g green value [0-255]
     * @param b blue value [0-255]
     */
    public static void setARGB(BufferedImage image, int x, int y, int a, int r, int g, int b) {
        image.setRGB(x, y, getARGB(a, r, g, b));
    }

    /**
     * Set ARGB (pixel) on the image at (x,y).
     *
     * @param image an image
     * @param x x coordinate
     * @param y y coordinate
     * @param px source pixel to be set (ARGB used)
     */
    public static void setARGB(BufferedImage image, int x, int y, Pixel px) {
        setARGB(image, x, y,
                px.getAlpha().getValue(), px.getRed().getValue(),
                px.getGreen().getValue(), px.getBlue().getValue());
    }

    /**
     * Get ARGB (0xAARRGGBB) from channel values.
     *
     * @param a alpha value [0-255]
     * @param r red value [0-255]
     * @param g green value [0-255]
     * @param b blue value [0-255]
     * @return ARGB (0xAARRGGBB) value combined from (a,r,g,b)
     */
    public static int getARGB(int a, int r, int g, int b) {
        return (((a & 0x000000FF) << 24) | ((r & 0x000000FF) << 16) |
                ((g & 0x000000FF) << 8) | (b & 0x000000FF));
    }

    /**
     * Get alpha value from ARGB (0xAARRGGBB).
     *
     * @param argb ARGB (0xAARRGGBB) value
     * @return alpha value [0-255]
     */
    public static int getARGB_Alpha(int argb) {
        return (argb & 0xFF000000) >>> 24;
    }

    /**
     * Get red value from ARGB (0xAARRGGBB).
     *
     * @param argb ARGB (0xAARRGGBB) value
     * @return red value [0-255]
     */
    public static int getARGB_Red(int argb) {
        return (argb & 0x00FF0000) >>> 16;
    }

    /**
     * Get green value from ARGB (0xAARRGGBB).
     *
     * @param argb ARGB (0xAARRGGBB) value
     * @return green value [0-255]
     */
    public static int getARGB_Green(int argb) {
        return (argb & 0x0000FF00) >>> 8;
    }

    /**
     * Get blue value from ARGB (0xAARRGGBB).
     *
     * @param argb ARGB (0xAARRGGBB) value
     * @return blue value [0-255]
     */
    public static int getARGB_Blue(int argb) {
        return argb & 0x000000FF;
    }
}
