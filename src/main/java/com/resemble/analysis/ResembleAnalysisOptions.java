package com.resemble.analysis;

import com.resemble.pixel.impl.PixelImpl;

public class ResembleAnalysisOptions {

    private PixelImpl tolerance;
    private final PixelImpl errorPixelColor = new PixelImpl(255, 255, 0, 255); // ARGB
    private ErrorPixel errorPixel = ErrorPixel.FLAT;
    private boolean ignoreAntialiasing = false;
    private boolean ignoreColors = false;
    private boolean scaleToSameSize = true;


    private boolean cropWhiteBackground = false;
    private int cropThreshold = 0;
    private double pixelTransparency = 1.0;
    private double largeImageThreshold = 1200.0;

    ResembleAnalysisOptions(int minBrightness, int maxBrightness, PixelImpl tolerance) {
        this.tolerance = tolerance;
        this.tolerance.getMinBrightness().setValue(minBrightness);
        this.tolerance.getMaxBrightness().setValue(maxBrightness);
    }

    @Override
    public String toString() {
        return "ResembleAnalysisOptions{" + "tolerance=" + tolerance +
                ", errorPixelColor=" + errorPixelColor +
                ", errorPixel=" + errorPixel +
                ", ignoreAntialiasing=" + ignoreAntialiasing +
                ", ignoreColors=" + ignoreColors +
                ", scaleToSameSize=" + scaleToSameSize +
                ", pixelTransparency=" + pixelTransparency +
                ", cropWhiteBackground=" + cropWhiteBackground +
                ", cropThreshold=" + cropThreshold +
                ", largeImageThreshold=" + largeImageThreshold + '}';
    }

    public ErrorPixel getErrorPixel() {
        return errorPixel;
    }

    public void setErrorPixel(ErrorPixel errorPixel) {
        this.errorPixel = errorPixel;
    }

    public boolean isIgnoreAntialiasing() {
        return ignoreAntialiasing;
    }

    public void setIgnoreAntialiasing(boolean ignoreAntialiasing) {
        this.ignoreAntialiasing = ignoreAntialiasing;
    }

    public int getCropThreshold() {
        return cropThreshold;
    }

    public void setCropThreshold(int threshold) {
        this.cropThreshold = threshold;
    }

    public boolean isCropWhiteBackground() {
        return cropWhiteBackground;
    }

    public void setCropWhiteBackground(boolean cropWhiteBackground) {
        this.cropWhiteBackground = cropWhiteBackground;
    }

    public boolean isIgnoreColors() {
        return ignoreColors;
    }

    public void setIgnoreColors(boolean ignoreColors) {
        this.ignoreColors = ignoreColors;
    }

    public boolean isScaleToSameSize() {
        return scaleToSameSize;
    }

    public void setScaleToSameSize(boolean scaleToSameSize) {
        this.scaleToSameSize = scaleToSameSize;
    }

    /**
     * Get pixel transparency in range [0 - 1].
     *
     * @return pixel transparency
     */
    public double getPixelTransparency() {
        return pixelTransparency;
    }

    /**
     * Set pixel transparency in range [0 - 1].
     *
     * @param pixelTransparency
     */
    public void setPixelTransparency(double pixelTransparency) {
        this.pixelTransparency = pixelTransparency;
    }

    public double getLargeImageThreshold() {
        return largeImageThreshold;
    }

    public void setLargeImageThreshold(double largeImageThreshold) {
        this.largeImageThreshold = largeImageThreshold;
    }

    public PixelImpl getTolerance() {
        return tolerance;
    }

    /**
     * Get color for Error Pixels (ARGB).
     *
     * @return color for Error Pixels
     */
    public PixelImpl getErrorPixelColor() {
        return errorPixelColor;
    }


}
