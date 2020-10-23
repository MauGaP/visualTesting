package com.resemble.analysis;

import com.resemble.pixel.Pixel;
import com.resemble.pixel.impl.PixelImpl;
import com.resemble.pixel.utils.ColorUtils;
import com.resemble.utils.ImageUtils;

import java.awt.image.BufferedImage;
import java.time.Instant;

public class ResembleAnalysis {

    private final Pixel targetPix = new PixelImpl();
    private final ResembleAnalysisOptions options;

    public ResembleAnalysis(ResembleAnalysisOptions options) {
        this.options = options;
    }

    public ResembleAnalysisResults analyseImages(BufferedImage img1, BufferedImage img2) {
        Instant startTime = Instant.now();
        ImageUtils.checkImageType(img1, "img1");
        ImageUtils.checkImageType(img2, "img2");
        if(options.isCropWhiteBackground()){
            img1 = ImageUtils.cropWhiteBackground(img1,options.getCropThreshold());
            img2 = ImageUtils.cropWhiteBackground(img2,options.getCropThreshold());
        }

        if(options.isScaleToSameSize()){
            if(img1.getWidth() > img2.getWidth()) {
                img1 = ImageUtils.resize(img1, img2.getWidth(),img2.getHeight());
            } else {
                img2 = ImageUtils.resize(img2, img1.getWidth(),img1.getHeight());
            }
        }

        BufferedImage imgOut = ImageUtils.createEmptyImage(img1);

        DiffBounds diffBounds = new DiffBounds();
        diffBounds.setTop(img1.getHeight());
        diffBounds.setLeft(img1.getWidth());
        diffBounds.setBottom(0);
        diffBounds.setRight(0);

        int width = img1.getWidth();
        int height = img1.getHeight();
        int skip = 0;
        int mismatchCount = 0;

        if (options.getLargeImageThreshold() != 0.0 && options.isIgnoreAntialiasing() &&
                (width > options.getLargeImageThreshold() ||
                height > options.getLargeImageThreshold())) {
            skip = 6;
        }

        Pixel pixel1 = new PixelImpl(0, 0, 0, 0);
        Pixel pixel2 = new PixelImpl(0, 0, 0, 0);

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (skip != 0) { // only skip if the image isn't small
                    if ((y % skip == 0) || (x % skip == 0)) {
                        continue;
                    }
                }
                pixel1.setARGB(img1, x, y);
                pixel2.setARGB(img2, x, y);

                if (options.isIgnoreColors()) {
                    if (pixel1.isPixelBrightnessSimilar(pixel2, options.getTolerance())) {
                        copyGrayScalePixel(imgOut, x, y, pixel2);
                    } else {
                        mismatchCount = errorPixel(imgOut, x, y, pixel1, pixel2, mismatchCount, diffBounds);
                    }
                    continue;
                }

                if (pixel1.isARGBSimilar(pixel2, options.getTolerance())) {
                    copyPixel(imgOut, x, y, pixel1);
                } else if (options.isIgnoreAntialiasing() && (isAntialiased(pixel1, img1, x, y) ||
                        isAntialiased(pixel2, img2, x, y))) {
                    if (pixel1.isPixelBrightnessSimilar(pixel2, options.getTolerance())) {
                        copyGrayScalePixel(imgOut, x, y, pixel2);
                    } else {
                        mismatchCount = errorPixel(imgOut, x, y, pixel1, pixel2, mismatchCount, diffBounds);
                    }
                } else {
                    mismatchCount = errorPixel(imgOut, x, y, pixel1, pixel2, mismatchCount, diffBounds);
                }
            }
        }

        return new ResembleAnalysisResults(imgOut, mismatchCount, diffBounds, startTime);
    }

    private int errorPixel(BufferedImage imgOut, int x, int y, Pixel pixel1, Pixel pixel2,
            int mismatchCount, DiffBounds diffBounds) {
        options.getErrorPixel().getTransformer()
                .transform(imgOut, x, y, pixel1, pixel2, options);
        diffBounds.updateBound(x, y);
        return mismatchCount + 1;
    }

    private void copyGrayScalePixel(BufferedImage imgOut, int x, int y, Pixel pixel) {
        int b = pixel.getMinBrightness().getValue();
        int a = (int) (pixel.getAlpha().getValue() * options.getPixelTransparency());
        ColorUtils.setARGB(imgOut, x, y, a, b, b, b);
    }

    private void copyPixel(BufferedImage imgOut, int x, int y, Pixel pixel) {
        ColorUtils.setARGB(imgOut, x, y, pixel);
    }

    private boolean isAntialiased(Pixel sourcePix, BufferedImage img, int x, int y) {
        final int minDist = -1;
        final int maxDist = 1;
        int width = img.getWidth();
        int height = img.getHeight();
        int hasHighContrastSibling = 0;
        int hasEquivalentSibling = 0;
        int hasSiblingWithDifferentHue = 0;
        for (int xi = minDist; xi <= maxDist; xi++) { // for pixels in sourcePix boundaries
            for (int yi = minDist; yi <= maxDist; yi++) {
                if (xi == 0 && yi == 0) {
                    continue; // ignore source pixel
                }
                int x2 = x + xi;
                int y2 = y + yi;
                if (x2 < 0 || y2 < 0 || x2 >= width || y2 >= height) {
                    continue; // ignore pixels outside image boundaries
                }

                targetPix.setARGB(img, x2, y2);

                if (sourcePix.isContrasting(targetPix, options.getTolerance())) {
                    hasHighContrastSibling++;
                }

                if (sourcePix.isRGBSame(targetPix)) {
                    hasEquivalentSibling++;
                }
                double targetPixHue = targetPix.getHue().getValue();
                double sourcePixHue = sourcePix.getHue().getValue();
                double diffHue = Math.abs(targetPixHue - sourcePixHue);
                if (diffHue > 0.3) {
                    hasSiblingWithDifferentHue++;
                }
                if (hasSiblingWithDifferentHue > 1 || hasHighContrastSibling > 1) {
                    return true;
                }
            }
        }
        return (hasEquivalentSibling < 2);
    }
}
