package com.company;

public enum CardValue {
    N6("6"),
    N7("7"),
    N8("8"),
    N9("9"),
    N10("10"),
    NJ("J"), // 2
    NQ("Q"), // 3
    NK("K"), // 4
    NA("A"); // 11 or 1

    String face;

    CardValue(String face) {
        this.face = face;
    }

    public String getFace() {
        return face;
    }

    @Override
    public String toString() {
        return face;
    }
}
