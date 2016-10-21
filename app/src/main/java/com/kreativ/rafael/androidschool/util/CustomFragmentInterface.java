package com.kreativ.rafael.androidschool.util;

/**
 * Created by Rafael on 06/10/2016.
 */

public interface CustomFragmentInterface {

    void onEditOptionSelected(int which);

    void setColor(int color);

    void setSize(int h, int w);

    void setIcon(int drawable);
}
