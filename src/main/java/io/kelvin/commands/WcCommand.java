package io.kelvin.commands;

import picocli.CommandLine;

@CommandLine.Command(
        name = "ccwc",
        mixinStandardHelpOptions = true,
        version = "Word count 1.0",
        description = "Print  newline,  word,  and  byte counts for each FILE, and a total line if more than one\n" +
                "FILE is specified.  A word is a non-zero-length sequence of printable  characters  delim‐ited\n" +
                "by white space.")
public class WcCommand implements Runnable{

    @Override
    public void run() {
        System.out.println("I am working still!");
    }
}
