package com.kreativ.rafael.androidschool.util;

import android.content.Context;

import com.kreativ.rafael.androidschool.R;

/**
 * Created by Rafael on 20/09/2016.
 */
public class Util {
    private static int NUM_ATRIBUTOS = 3;

    public static String[] getPropertiesLabel(boolean[] propertyVisible, Context context) {
        String[] propertyLabels = new String[NUM_ATRIBUTOS];
        int cont = 0;

        if (propertyVisible[0]) { propertyLabels[cont] = context.getString(R.string.prop_color); ++cont; }
        if (propertyVisible[1]) { propertyLabels[cont] = context.getString(R.string.prop_size); ++cont; }
        if (propertyVisible[2]) { propertyLabels[cont] = context.getString(R.string.prop_icon); ++cont; }

        return propertyLabels;
    }

    public static boolean[] getPropertyVisibles(int componentCode) {
        boolean[] propertyVisibles = new boolean[NUM_ATRIBUTOS];

        if (componentCode == EnumComponent.BtnSimple.getValue()) {
            propertyVisibles[0] = true;
        }

        return propertyVisibles;
    }

}
