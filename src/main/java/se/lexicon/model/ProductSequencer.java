package se.lexicon.model;

public class ProductSequencer {
    private static int sequencer = 0;

    public static int nextId() {
        return ++sequencer;
    }
}
