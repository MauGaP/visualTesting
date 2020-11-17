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

    public static BufferedImage compare(String[] args) throws IOException {
        if (args.length != 2) {
            System.out.println("Requires arguments: <golden image path>, <image to compare path>");
            System.exit(1);
        }
        setLookAndFeel();

        ResembleAnalysisOptions options = ResembleAnaylsisOptionsTemplates.ignoringLess();
        File imgFile1 = new File(args[0]);
        File imgFile2 = new File(args[1]);

        BufferedImage img1 = ImageUtils.readImage(imgFile1);
        ResembleParserData dataImg1 = ResembleParser.parse(img1);

        BufferedImage img2 = ImageUtils.readImage(imgFile2);
        ResembleParserData dataImg2 = ResembleParser.parse(img2);

        ResembleAnalysisResults results = new ResembleAnalysis(options).analyseImages(img1, img2);
        ResembleParserData dataResult = ResembleParser.parse(results.getOutputImage());

        return results.getOutputImage();
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

    public static void compare(String s, String s1) {
    }
}
