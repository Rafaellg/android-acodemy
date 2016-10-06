package com.kreativ.rafael.androidschool.util;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.kreativ.rafael.androidschool.R;

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

}
