package edu.sda.sample.solid.lsp;

public class File implements FileOperation {

    @Override
    public byte[] read() {
        System.out.println("Reading some data");
        return new byte[0];
    }

    @Override
    public void write(byte[] data) {
        System.out.println("Writing some data..");
    }
}
