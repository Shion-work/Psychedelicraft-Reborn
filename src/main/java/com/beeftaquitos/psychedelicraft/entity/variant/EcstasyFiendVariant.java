package com.beeftaquitos.psychedelicraft.entity.variant;
import java.util.Arrays;
import java.util.Comparator;

public enum EcstasyFiendVariant {
    DEFAULT(0),
    BLUE(1),
    GREEN(2),
    PINK(3),
    ORANGE(4),
    YELLOW(5),
    GRAY(6),
    LILAC(7),
    BLACK(8),
    WHITE(9),
    PURPLE(10),
    BROWN(11),
    CYAN(12),
    LIME(13),
    BEIGE(14),
    SALMON(15);

    private static final EcstasyFiendVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(EcstasyFiendVariant::getId)).toArray(EcstasyFiendVariant[]::new);
    private final int id;

    EcstasyFiendVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static EcstasyFiendVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}