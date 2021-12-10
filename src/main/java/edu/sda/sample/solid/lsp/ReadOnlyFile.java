package edu.sda.sample.solid.lsp;

public class ReadOnlyFile implements FileOperation {
    @Override
    public byte[] read() {
        System.out.println("Reading is fine in " + ReadOnlyFile.class.getName());
        return new byte[0];
    }

    /**
     *
     * LSP - Liskow Substitution Principle
     * Zasada podstawiania interfejsów
     * Jeśli mamy kilka klas implementujących dany interfejs to korzystając z dowolnej z nich
     * powinniśmy się sopdziewać określonego rezultatu. Rezultat w szczegółach może się różnić
     * ale ogólnie powinien być podobny
     *
     */

    @Override
    public void write(byte[] data) {
        System.out.println("Writing is forbidden in " + ReadOnlyFile.class.getSimpleName());
        throw new UnsupportedOperationException();
    }
}
