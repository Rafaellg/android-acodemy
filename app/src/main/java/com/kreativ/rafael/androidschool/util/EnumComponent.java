package com.kreativ.rafael.androidschool.util;

import com.kreativ.rafael.androidschool.ApplicationMain;
import com.kreativ.rafael.androidschool.R;
import com.kreativ.rafael.androidschool.fragment.category.widgets.FABCodeFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.FABComponentFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.FABXMLFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.IBCodeFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.IBComponentFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.IBXMLFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.RBCodeFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.RBComponentFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.RBXMLFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.SBCodeFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.SBComponentFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.SBXMLFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.TBCodeFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.TBComponentFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.TBXMLFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.TVCodeFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.TVComponentFragment;
import com.kreativ.rafael.androidschool.fragment.category.widgets.TVXMLFragment;

/**
 * Created by Rafael on 20/09/2016.
 */
public enum EnumComponent {
    // Widgets
    TextView(ApplicationMain.getContext().getString(R.string.item_text_view), new TVComponentFragment(), new TVCodeFragment(), new TVXMLFragment(), new String[] {}),
    BtnSimple(ApplicationMain.getContext().getString(R.string.item_simple_btn), new SBComponentFragment(), new SBCodeFragment(), new SBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    BtnFAB(ApplicationMain.getContext().getString(R.string.item_floating_btn), new FABComponentFragment(), new FABCodeFragment(), new FABXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    BtnRadio(ApplicationMain.getContext().getString(R.string.item_radio_btn), new RBComponentFragment(), new RBCodeFragment(), new RBXMLFragment(), new String[] {}),
    BtnToggle(ApplicationMain.getContext().getString(R.string.item_toggle_btn), new TBComponentFragment(), new TBCodeFragment(), new TBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    Spinner(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    ProgressBar(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    SeekBar(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),

    // Text Fields
    EditText(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),

    // Layouts
    GridLayout(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    FrameLayout(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    LinearLayout(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    RelativeLayout(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),

    // Containers
    ListView(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    GridView(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),

    // Images & Media
    BtnImage(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    ImageView(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    VideoView(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),

    // Images & Media
    TimePicker(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    DatePicker(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)});

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
