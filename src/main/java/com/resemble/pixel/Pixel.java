package com.resemble.pixel;

import java.awt.image.BufferedImage;

public interface Pixel {

    boolean isPixelBrightnessSimilar(Pixel d2, Pixel tolerance);

    boolean isRGBSame(Pixel d2);

    boolean isARGBSimilar(Pixel d2, Pixel tolerance);

    boolean isContrasting(Pixel d2, Pixel tolerance);

    PixelChannel<Integer> getAlpha();

    PixelChannel<Integer> getRed();

    PixelChannel<Integer> getGreen();

    PixelChannel<Integer> getBlue();

    PixelChannel<Integer> getMinBrightness();

    PixelChannel<Integer> getMaxBrightness();

    PixelChannel<Double> getHue();

    PixelChannel get(PixelChannel.Channel channel);

    void setARGB(int argb);

    void setARGB(int a, int r, int g, int b);

    void setARGB(BufferedImage image, int x, int y);
}
