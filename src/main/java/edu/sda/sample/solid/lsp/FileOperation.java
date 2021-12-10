package edu.sda.sample.solid.lsp;

import java.util.Optional;

public interface FileOperation {

    byte[] read();

    void write(byte[] data);

    default void NPESample() {
        String aaa = null;

        String bbb = aaa.substring(4);
    }

    default void OptionalNPESample() {
        String aaa = null;
        Optional<String> aaaOpt = Optional.ofNullable(aaa);

        if(aaaOpt.isPresent()) {
            String bbb = aaa.substring(4);
        }
    }
}
