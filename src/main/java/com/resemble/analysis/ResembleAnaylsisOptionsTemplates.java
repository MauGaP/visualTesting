package com.resemble.analysis;

import com.resemble.pixel.impl.PixelImpl;

public class ResembleAnaylsisOptionsTemplates {

    public static ResembleAnalysisOptions ignoringAntialiasing() {
        ResembleAnalysisOptions options = new ResembleAnalysisOptions(64,96, new PixelImpl(32, 32, 32, 32));
        options.setIgnoreAntialiasing(true);
        options.setIgnoreColors(false);
        return options;
    }

    public static ResembleAnalysisOptions ignoringColors() {
        ResembleAnalysisOptions options = ignoringLess();
        options.setIgnoreAntialiasing(false);
        options.setIgnoreColors(true);
        return options;
    }

    public static ResembleAnalysisOptions ignoringAlpha() {
        ResembleAnalysisOptions options = new ResembleAnalysisOptions(16,240, new PixelImpl(16, 16, 16, 255));
        options.setIgnoreAntialiasing(false);
        options.setIgnoreColors(false);
        return options;
    }

    public static ResembleAnalysisOptions ignoringLess() {
        return new ResembleAnalysisOptions(16,40, new PixelImpl(16, 16, 16, 16));
    }

    public static ResembleAnalysisOptions ignoringNothing() {
        return new ResembleAnalysisOptions(0,255, new PixelImpl(0, 0, 0, 0));
    }
}
