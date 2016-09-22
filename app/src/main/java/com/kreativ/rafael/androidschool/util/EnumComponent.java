package com.kreativ.rafael.androidschool.util;

/**
 * Created by Rafael on 20/09/2016.
 */

public enum EnumComponent {
    BtnSimple(1), BtnFloating(2);

    private int value;

    EnumComponent(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
