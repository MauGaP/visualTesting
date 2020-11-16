package org.visualvalidation.tasks.comparison;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.visualvalidation.util.FolderScanner.GOLDEN_IMAGE_FOLDER;

public class ScanGoldenImageFolderForImages {
    public static List scanGoldenImageFolderForImages() throws IOException {
        List<String> result;
        try (Stream<Path> walk = Files.walk(Paths.get(GOLDEN_IMAGE_FOLDER))) {

            result = walk.filter(Files::isRegularFile)
                    .map(x -> x.getFileName().toString()).collect(Collectors.toList());
        }
        return result;
    }
}
