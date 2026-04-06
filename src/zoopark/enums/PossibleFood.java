package zoopark.enums;

public enum PossibleFood {
    STEAK, CHICKEN, RAW_MEAT,
    FISH, SHRIMP,
    GRASS, LEAVES, FRUITS, VEGETABLES, SEEDS,
    INSECTS, WORMS;

    public boolean isMeat() {
        return this == STEAK || this == CHICKEN || this == RAW_MEAT;
    }

    public boolean isFish() {
        return this == FISH || this == SHRIMP;
    }

    public boolean isPlantBased() {
        return this == GRASS || this == LEAVES || this == FRUITS || this == VEGETABLES || this == SEEDS;
    }

    public boolean isInsects() {
        return this == INSECTS || this == WORMS;
    }
}
