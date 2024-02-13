package io.kelvin;

import io.kelvin.commands.WcCommand;
import picocli.CommandLine;

public class App {
    public static void main(String[] args) {
        new CommandLine(new WcCommand()).execute(args);
    }
}
