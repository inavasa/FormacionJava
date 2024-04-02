package org.indra.claseDoce.logging;

import lombok.SneakyThrows;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileLogger implements Logger {
    private String fileName;

    public FileLogger(String fileName) {
        this.fileName = fileName;
    }

    @Override
    @SneakyThrows
    public void log(String mensaje) {
        FileWriter file = new FileWriter(this.fileName + ".txt", true);
        BufferedWriter bw = new BufferedWriter(file);
        PrintWriter out = new PrintWriter(bw);
        out.println("mensaje");
    }
}
