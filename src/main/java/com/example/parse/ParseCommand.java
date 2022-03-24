package com.example.parse;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "parse", description = "parse source code file in each directory.",
    mixinStandardHelpOptions = true)
public class ParseCommand implements Runnable{

    @Option(names = {"-p", "--path"}, description = "parse directory path")
        String query = "";

    @Option(names = {"--here"}, description = "parse in current position")
        Boolean here;

    @Override
    public void run() {
        System.out.println("parse command is running...");

    }
}
