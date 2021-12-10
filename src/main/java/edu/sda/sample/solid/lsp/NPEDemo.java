package edu.sda.sample.solid.lsp;

public class NPEDemo {

    public static void main(String[] args) {

        FileOperation fileOperation = new FileOperation() {
            @Override
            public byte[] read() {
                return new byte[0];
            }

            @Override
            public void write(byte[] data) {
            }
        };

        fileOperation.OptionalNPESample();
//        fileOperation.NPESample();
    }
}
