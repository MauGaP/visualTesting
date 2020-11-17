package com.resemble.analysis;

import java.awt.image.BufferedImage;
import java.time.Duration;
import java.time.Instant;

public class ResembleAnalysisResults {

    private final BufferedImage outputImage;
    private final double mismatchPercentage;
    private final DiffBounds diffBounds;
    private final Duration analysisTime;

    public ResembleAnalysisResults(BufferedImage outputImage, int mismatchCount, DiffBounds diffBounds, Instant startTime) {
        this.outputImage = outputImage;
        this.mismatchPercentage =
                ((double) mismatchCount) / ((double) outputImage.getWidth() * outputImage.getHeight()) * 100.0;
        this.diffBounds = diffBounds;
        this.analysisTime = Duration.between(startTime, Instant.now());
    }

    @Override
    public String toString() {
        return "ResembleAnalysisResults{" + "outputImage=" + outputImage + ", mismatchPercentage=" + mismatchPercentage + ", diffBounds=" + diffBounds + ", analysisTime=" + analysisTime + '}';
    }

    public BufferedImage getOutputImage() {
        return outputImage;
    }

    public double getMismatchPercentage() {
        return mismatchPercentage;
    }

    public DiffBounds getDiffBounds() {
        return diffBounds;
    }

    public Duration getAnalysisTime() {
        return analysisTime;
    }

}
