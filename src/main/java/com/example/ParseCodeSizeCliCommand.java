package com.example;

import com.example.parse.ParseCommand;
import io.micronaut.configuration.picocli.PicocliRunner;
import io.micronaut.context.ApplicationContext;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "parse-code-size-cli", description = "...",
        mixinStandardHelpOptions = true, subcommands = {ParseCommand.class})
public class ParseCodeSizeCliCommand implements Runnable {

    @Option(names = {"-v", "--verbose"}, description = "...")
    boolean verbose;

    public static void main(String[] args) throws Exception {
        PicocliRunner.run(ParseCodeSizeCliCommand.class, args);
    }
    // testing comment
    // testing comment 2

    public void run() {
        // business logic here
        if (verbose) {
            System.out.println("Hi!");
        }
    }
}
