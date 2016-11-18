package com.rafaelguimas.androidschool.util;

import com.rafaelguimas.androidschool.ApplicationMain;
import com.rafaelguimas.androidschool.R;
import com.rafaelguimas.androidschool.fragment.category.containers.LVCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.containers.LVComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.containers.LVXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.containers.WVCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.containers.WVComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.containers.WVXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.datetime.DPCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.datetime.DPComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.datetime.DPXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.datetime.TPCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.datetime.TPComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.datetime.TPXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.imagesmedia.IVComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.imagesmedia.IVXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.layouts.GLComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.layouts.GLXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.layouts.LLHComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.layouts.LLHXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.layouts.LLVComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.layouts.LLVXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.imagesmedia.VVCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.imagesmedia.VVComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.imagesmedia.VVXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.layouts.RLComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.layouts.RLXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.textfields.ETCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.textfields.ETComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.textfields.ETXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.FABCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.FABComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.FABXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.imagesmedia.IBCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.imagesmedia.IBComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.imagesmedia.IBXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.RBCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.RBComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.RBXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.SBCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.SBComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.SBXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.SPCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.SPComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.SPXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.TBCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.TBComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.TBXMLFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.TVCodeFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.TVComponentFragment;
import com.rafaelguimas.androidschool.fragment.category.widgets.TVXMLFragment;

/**
 * Created by Rafael on 20/09/2016.
 */
public enum EnumComponent {
    // Widgets
    TextView(ApplicationMain.getContext().getString(R.string.item_text_view), new TVComponentFragment(), new TVCodeFragment(), new TVXMLFragment(), null),
    BtnSimple(ApplicationMain.getContext().getString(R.string.item_simple_btn), new SBComponentFragment(), new SBCodeFragment(), new SBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    BtnFAB(ApplicationMain.getContext().getString(R.string.item_floating_btn), new FABComponentFragment(), new FABCodeFragment(), new FABXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    BtnRadio(ApplicationMain.getContext().getString(R.string.item_radio_btn), new RBComponentFragment(), new RBCodeFragment(), new RBXMLFragment(), null),
    BtnToggle(ApplicationMain.getContext().getString(R.string.item_toggle_btn), new TBComponentFragment(), new TBCodeFragment(), new TBXMLFragment(), new String[] {ApplicationMain.getContext().getString(R.string.prop_color), ApplicationMain.getContext().getString(R.string.prop_size)}),
    Spinner(ApplicationMain.getContext().getString(R.string.item_spinner), new SPComponentFragment(), new SPCodeFragment(), new SPXMLFragment(), null),

    // Text Fields
    EditText(ApplicationMain.getContext().getString(R.string.item_edit_text), new ETComponentFragment(), new ETCodeFragment(), new ETXMLFragment(), null),

    // Layouts
    GridLayout(ApplicationMain.getContext().getString(R.string.item_grid_layout), new GLComponentFragment(), null, new GLXMLFragment(), null),
    LinearLayoutHorizontal(ApplicationMain.getContext().getString(R.string.item_linear_layout_horizontal), new LLHComponentFragment(), null, new LLHXMLFragment(), null),
    LinearLayoutVertical(ApplicationMain.getContext().getString(R.string.item_linear_layout_vertical), new LLVComponentFragment(), null, new LLVXMLFragment(), null),
    RelativeLayout(ApplicationMain.getContext().getString(R.string.item_relative_layout), new RLComponentFragment(), null, new RLXMLFragment(), null),

    // Containers
    ListView(ApplicationMain.getContext().getString(R.string.item_list_view), new LVComponentFragment(), new LVCodeFragment(), new LVXMLFragment(), null),
    WebView(ApplicationMain.getContext().getString(R.string.item_web_view), new WVComponentFragment(), new WVCodeFragment(), new WVXMLFragment(), null),

    // Images & Media
    BtnImage(ApplicationMain.getContext().getString(R.string.item_image_btn), new IBComponentFragment(), new IBCodeFragment(), new IBXMLFragment(), null),
    ImageView(ApplicationMain.getContext().getString(R.string.item_image_view), new IVComponentFragment(), null, new IVXMLFragment(), null),
    VideoView(ApplicationMain.getContext().getString(R.string.item_video_view), new VVComponentFragment(), new VVCodeFragment(), new VVXMLFragment(), null),

    // Images & Media
    TimePicker(ApplicationMain.getContext().getString(R.string.item_time_picker), new TPComponentFragment(), new TPCodeFragment(), new TPXMLFragment(), null),
    DatePicker(ApplicationMain.getContext().getString(R.string.item_date_picker), new DPComponentFragment(), new DPCodeFragment(), new DPXMLFragment(), null);

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
