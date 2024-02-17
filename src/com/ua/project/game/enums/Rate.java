package com.ua.project.game.enums;

public enum Rate {
    ZERO((short)0),
    ONE((short)1),
    TWO((short)2),
    THREE((short)3),
    FOUR((short)4),
    FIVE((short)5);

    private final short rate;

    private Rate(short rate){
        this.rate = rate;
    }

    public short getRate() {
        return rate;
    }
}
