package io.kelvin.commands;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.stream.Stream;

@Command(
        name = "pro-wc",
        mixinStandardHelpOptions = true,
        version = "Word count 1.0",
        description = """
                Print  newline,  word,  and  byte counts for each FILE, and a total line if more than one
                FILE is specified.  A word is a non-zero-length sequence of printable  characters  delim‐ited
                by white space.""")
public class WcCommand implements Runnable {

    @Parameters(index = "0")
    File file;

    @Option(names = {"-c", "--bytes"}, description = "print the byte counts")
    boolean printBytesCountOnly;

    @Option(names = {"-l", "--print the newline counts"}, description = "print the newline counts")
    boolean printNewLinesCountOnly;

    @Override
    public void run() {
        if (printBytesCountOnly){
            System.out.println(this.file.length() + " " + this.file.getName());
        }
        if (printNewLinesCountOnly) {
            printNewLinesCountOnly(this.file);
        }
    }

    private void printNewLinesCountOnly(File file) {
        if (!file.exists()){
            System.out.println("File doesn't exists!");
            return;
        }
        if (!file.isFile()){
            System.out.println("Path does not point to a file!");
            return;
        }
        if (!file.canRead()){
            System.out.println("File is not readable!");
            return;
        }
        try(Stream<String> lines = Files.lines(file.toPath())) {
            System.out.println(lines.count() + " " + file.getName());
        } catch (IOException e) {
            System.out.println("Error occurred when trying to read lines of " + file.getName());
        }
    }
}
