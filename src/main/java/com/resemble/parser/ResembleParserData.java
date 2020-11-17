package com.resemble.parser;

public class ResembleParserData {

    private final double red;
    private final double green;
    private final double blue;
    private final double alpha;
    private final double brightness;
    private final double white;
    private final double black;

    ResembleParserData(double redTotal, double greenTotal, double blueTotal, double alphaTotal, double brightnessTotal, double whiteTotal, double blackTotal, double pixelCount) {
        this.red = Math.floor(redTotal / pixelCount);
        this.green = Math.floor(greenTotal / pixelCount);
        this.blue = Math.floor(blueTotal / pixelCount);
        this.alpha = Math.floor(alphaTotal / pixelCount);
        this.brightness = Math.floor(brightnessTotal / pixelCount);
        this.white = Math.floor(whiteTotal / pixelCount * 100.0);
        this.black = Math.floor(blackTotal / pixelCount * 100.0);
    }

    @Override
    public String toString() {
        return "ResembleParserData{" + "red=" + red + ", green=" + green + ", blue=" + blue + ", alpha=" + alpha + ", brightness=" + brightness + ", white=" + white + ", black=" + black + '}';
    }

    public double getRed() {
        return red;
    }

    public double getGreen() {
        return green;
    }

    public double getBlue() {
        return blue;
    }

    public double getAlpha() {
        return alpha;
    }

    public double getBrightness() {
        return brightness;
    }

    public double getWhite() {
        return white;
    }

    public double getBlack() {
        return black;
    }

}
