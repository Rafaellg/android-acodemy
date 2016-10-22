package com.kreativ.rafael.androidschool.util;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.kreativ.rafael.androidschool.R;

import java.util.List;

import io.github.kbiakov.codeview.highlight.ColorTheme;

/**
 * Created by Rafael on 20/09/2016.
 */
public class Util {
    private static String DEFAULT_LANGUAGE = "java";

    public static ColorTheme getDefaultCodeTheme() {
        return ColorTheme.MONOKAI;
    }

    public static int getDefaultCodeBg(Context context) {
        return ContextCompat.getColor(context, R.color.bgPrimaryColor);
    }

    public static String getDefaultCodeLanguage() {
        return DEFAULT_LANGUAGE;
    }

    public static String getStringFromCodeList(List<String> codeList) {
        String code = "";

        for (int i = 0; i < codeList.size(); i++) {
            String line = codeList.get(i);
            code += i != codeList.size()-1 ? line + "\n" : line;
        }

        return code;
    }

    public static int[] getColorsArray(Context context) {
        int[] colors = new int[8];

        colors[0] = ContextCompat.getColor(context, R.color.materialRed);
        colors[1] = ContextCompat.getColor(context, R.color.materialPink);
        colors[2] = ContextCompat.getColor(context, R.color.materialPurple);
        colors[3] = ContextCompat.getColor(context, R.color.materialBlue);
        colors[4] = ContextCompat.getColor(context, R.color.materialGreen);
        colors[5] = ContextCompat.getColor(context, R.color.materialYellow);
        colors[6] = ContextCompat.getColor(context, R.color.materialOrange);
        colors[7] = ContextCompat.getColor(context, R.color.materialBrown);

        return colors;
    }

    public static String getHexFromIntColor(int color) {
        return String.format("#%06X", (0xFFFFFF & color));
    }

}
