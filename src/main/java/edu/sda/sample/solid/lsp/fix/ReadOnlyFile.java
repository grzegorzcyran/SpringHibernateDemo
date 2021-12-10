package edu.sda.sample.solid.lsp.fix;

public class ReadOnlyFile implements FileReadable {

    @Override
    public byte[] read() {
        System.out.println("Reading some data");
        return new byte[0];
    }
}
