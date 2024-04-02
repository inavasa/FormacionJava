package org.indra.claseDoce.logging;

import java.text.MessageFormat;
import java.time.LocalDate;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String mensaje) {
        System.out.println(MessageFormat.format("[{0}] {1}", LocalDate.now(), mensaje));
    }
}
