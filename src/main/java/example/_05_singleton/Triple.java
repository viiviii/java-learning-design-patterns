package example._05_singleton;

enum Triple {
    ALPHA, BETA, GAMMA;

    public static Triple getInstance(String name) {
        return Triple.valueOf(name);
    }
}
