package io.kelvin.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;

@Command(
        name = "ccwc",
        mixinStandardHelpOptions = true,
        version = "Word count 1.0",
        description = "Print  newline,  word,  and  byte counts for each FILE, and a total line if more than one\n" +
                "FILE is specified.  A word is a non-zero-length sequence of printable  characters  delim‐ited\n" +
                "by white space.")
public class WcCommand implements Runnable {

    @Parameters(index = "0")
    File file;

    @Option(names = {"-c", "--bytes"}, description = "print the byte counts")
    boolean printBytesOnly;

    @Override
    public void run() {
        if (printBytesOnly){
            System.out.println(file.length() + " " + file.getName());
        }
    }
}
