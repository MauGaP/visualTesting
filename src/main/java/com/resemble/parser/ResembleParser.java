package com.resemble.parser;

import com.resemble.pixel.utils.ColorUtils;
import com.resemble.utils.ImageUtils;

import java.awt.image.BufferedImage;

public abstract class ResembleParser {

    public static ResembleParserData parse(BufferedImage sourceImageData) {
        ImageUtils.checkImageType(sourceImageData, "sourceImageData");
        int pixelCount = 0;
        double redTotal = 0;
        double greenTotal = 0;
        double blueTotal = 0;
        double alphaTotal = 0;
        double brightnessTotal = 0;
        double whiteTotal = 0;
        double blackTotal = 0;
        int width = sourceImageData.getWidth();
        int height = sourceImageData.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int argb = ColorUtils.getARGB(sourceImageData, x, y);
                int alpha = ColorUtils.getARGB_Alpha(argb);
                int red = ColorUtils.getARGB_Red(argb);
                int green = ColorUtils.getARGB_Green(argb);
                int blue = ColorUtils.getARGB_Blue(argb);
                int brightness = ColorUtils.getBrightness(red, green, blue);

                if (red == green && red == blue && alpha > 0) {
                    if (red == 0) {
                        blackTotal++;
                    } else if (red == 255) {
                        whiteTotal++;
                    }
                }

                pixelCount++;
                redTotal += (double) red / 255.0 * 100.0;
                greenTotal += (double) green / 255.0 * 100.0;
                blueTotal += (double) blue / 255.0 * 100.0;
                alphaTotal += (255.0 - (double) alpha) / 255.0 * 100.0;
                brightnessTotal += (double) brightness / 255.0 * 100.0;
            }
        }
        return new ResembleParserData(redTotal, greenTotal, blueTotal, alphaTotal,
                brightnessTotal, whiteTotal, blackTotal, pixelCount);
    }
}
