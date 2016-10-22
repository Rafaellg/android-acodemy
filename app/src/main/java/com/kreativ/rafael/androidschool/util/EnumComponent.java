package com.kreativ.rafael.androidschool.util;

import com.kreativ.rafael.androidschool.ApplicationMain;
import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.fragment.category.buttom.FABCodeFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.FABComponentFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.FABXMLFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.RBCodeFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.RBComponentFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.RBXMLFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.SBCodeFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.SBComponentFragment;
import com.kreativ.rafael.androidschool.fragment.category.buttom.SBXMLFragment;

/**
 * Created by Rafael on 20/09/2016.
 */
public enum EnumComponent {
    BtnSimple(ApplicationMain.getContext().getString(R.string.item_simple_btn), new SBComponentFragment(), new SBCodeFragment(), new SBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    BtnFAB(ApplicationMain.getContext().getString(R.string.item_floating_btn), new FABComponentFragment(), new FABCodeFragment(), new FABXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    BtnRadio(ApplicationMain.getContext().getString(R.string.item_radio_btn), new RBComponentFragment(), new RBCodeFragment(), new RBXMLFragment(), new String[] {}),
    BtnToggle(ApplicationMain.getContext().getString(R.string.item_toggle_btn), new FABComponentFragment(), new FABCodeFragment(), new FABXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    BtnImage(ApplicationMain.getContext().getString(R.string.item_image_btn), new FABComponentFragment(), new FABCodeFragment(), new FABXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)});

    private String title;
    private String[] properties;
    private CustomFragment fragmentComponent, fragmentCode, fragmentXML;

    EnumComponent(String title, CustomFragment fragmentComponent, CustomFragment fragmentCode, CustomFragment fragmentXML, String[] properties) {
        this.title = title;
        this.fragmentComponent = fragmentComponent;
        this.fragmentCode = fragmentCode;
        this.fragmentXML = fragmentXML;
        this.properties = properties;
    }

    public String getTitle() {
        return title;
    }

    public String[] getProperties() {
        return properties;
    }

    public CustomFragment getFragmentComponent() {
        return fragmentComponent;
    }

    public CustomFragment getFragmentCode() {
        return fragmentCode;
    }

    public CustomFragment getFragmentXML() {
        return fragmentXML;
    }
}
