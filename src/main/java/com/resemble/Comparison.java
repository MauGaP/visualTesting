package com.resemble;

import com.resemble.analysis.ResembleAnalysis;
import com.resemble.analysis.ResembleAnalysisOptions;
import com.resemble.analysis.ResembleAnalysisResults;
import com.resemble.analysis.ResembleAnaylsisOptionsTemplates;
import com.resemble.gui.ImageWindow;
import com.resemble.utils.ImageUtils;
import com.resemble.parser.ResembleParser;
import com.resemble.parser.ResembleParserData;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.UnsupportedLookAndFeelException;

public class Comparison {

    public static void compare(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Requires arguments: <image path 1> <image path 2>");
            System.exit(1);
        }
        setLookAndFeel();

        ResembleAnalysisOptions options = ResembleAnaylsisOptionsTemplates.ignoringAntialiasing();
        options.setCropWhiteBackground(true);
        options.setCropThreshold(50);
        File imgFile1 = new File(args[0]);
        File imgFile2 = new File(args[1]);

        BufferedImage img1 = ImageUtils.readImage(imgFile1);
        ResembleParserData dataImg1 = ResembleParser.parse(img1);

        ImageWindow.show(img1, "File 1: " + imgFile1.getName(),
                String.format("File 1: '%s'\n" +
                        "Image 1:\n%s\n\n" +
                        "Info: %s",
                        imgFile1, img1, dataImg1)
        );

        BufferedImage img2 = ImageUtils.readImage(imgFile2);
        ResembleParserData dataImg2 = ResembleParser.parse(img2);

        ImageWindow.show(img2, "File 2: " + imgFile2.getName(),
                String.format("File 2: '%s'\n" +
                        "Image 2:\n%s\n\n" +
                        "Info: %s",
                        imgFile2, img2, dataImg2)
        );

        ResembleAnalysisResults results = new ResembleAnalysis(options).analyseImages(img1, img2);
        ResembleParserData dataResult = ResembleParser.parse(results.getOutputImage());

        ImageWindow.show(results.getOutputImage(), "Results",
                String.format("File 1: '%s'\n" +
                        "File 2: '%s'\n\n" +
                        "Info: %s\n\n" +
                        "Output image:\n%s\n\n" +
                        "Options:\n%s\n\n" +
                        "Mismatch percentage: %.2f %%\n" +
                        "Analysis time: %d miliseconds\n" +
                        "Difference bounds: %s",
                        imgFile1, imgFile2, dataResult, results.getOutputImage(), options,
                        results.getMismatchPercentage(), results.getAnalysisTime().toMillis(),
                        results.getDiffBounds())
        );

    }

    private static void setLookAndFeel() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info: javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }
}
