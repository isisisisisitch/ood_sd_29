package ca.bytetube.ood._11_linuxfilessearch;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Find all files larger than 1MB in a directory
        String path = "/Users/dall./Desktop/test";
        FileFinder fileFinder = new FileFinder();
        List<File> largeFiles = fileFinder.findLargeFile(path, 2 * 1024 * 1024);
        // largeFiles.forEach(file -> System.out.println(file.getAbsolutePath()));

        List<File> docxFiles = fileFinder.findFilesByExtension(path, "docx");
        //docxFiles.forEach(file -> System.out.println(file.getAbsolutePath()));

        //Find all pdf files or larger than 1MB files in a directory
        Filter complexFilter = new OrFilter(new SizeFilter(1 * 1024 * 1024), new ExtensionFilter("pdf"));
        List<File> files = fileFinder.find(path, complexFilter);
        files.forEach(file -> System.out.println(file.getAbsolutePath()));
    }
}
