package com.slws.utils;

import androidx.annotation.NonNull;

public enum States {
    KEYWORD("keyword"),
    INTEREST("mInterest");
    private final String name;

    States(String s) {
        name = s;
    }

    @NonNull
    @Override
    public String toString() {
        return this.name;
    }
}
