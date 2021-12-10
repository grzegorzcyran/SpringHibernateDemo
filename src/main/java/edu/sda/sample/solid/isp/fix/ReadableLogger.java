package edu.sda.sample.solid.isp.fix;

import java.util.Collection;

//Na tym interfejsie nie można nałożyć anotacji @FunctionalInterface
//bo mamy abstrakcyjne 2 metody:
// - read() z ReadableLogger
// - write z Logger, po którym ReadableLogger dziedziczy
//@FunctionalInterface
public interface ReadableLogger extends Logger {

    Collection<String> read();

}
