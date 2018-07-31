package net.deatrich.app.checkbox_issue_111734667.ui;

import android.content.Context;
import android.support.v7.widget.AppCompatCheckBox;
import android.util.AttributeSet;
import android.widget.CompoundButton;

import net.deatrich.app.checkbox_issue_111734667.R;


public class CustomCheckboxWorkaround extends AppCompatCheckBox {


    public CustomCheckboxWorkaround(Context context, AttributeSet attrs) {
        super(context, attrs);
        setButtonDrawable(R.drawable.checkbox_selector);
        invalidate();

    }


}
