package com.example.parse;

import jakarta.inject.Inject;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

import java.io.File;

@Command(name = "parse", description = "parse source code file in each directory.",
    mixinStandardHelpOptions = true)
public class ParseCommand implements Runnable{

    @Option(names = {"-p", "--path"}, description = "parse directory path")
        String query = "";

    @Option(names = {"--here"}, description = "parse in current position")
        Boolean here;

    @Inject
    ShowFile showFile = new ShowFile();

    @Override
    public void run() {
        System.out.println("parse command is running...");

        String fname = "C:\\Users\\Gary-Home\\repos\\parse-code-size-cli\\file-io-java";

        File file = new File(fname);
        showFile.countSubFiles(file);
        System.out.println("max: " + showFile.maxLines);

        File[] files = file.listFiles();

        System.out.println(file.getName() + " :");

        for (int i = 0; i < files.length; i++) {
            showFile.showSubFiles(files[i]);
        }

    }
}
