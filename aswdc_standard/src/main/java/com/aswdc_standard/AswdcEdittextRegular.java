package com.aswdc_standard;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class AswdcEdittextRegular extends TextInputLayout {

    private TextInputEditText editText;

    public AswdcEdittextRegular(@NonNull Context context) {
        super(context);
        init();
    }

    public AswdcEdittextRegular(@NonNull Context context, AttributeSet attrs) {
        super(context, attrs, R.style.Widget_MaterialComponents_TextInputLayout_OutlinedBox);
        init();
    }

    private void init() {
        setWillNotDraw(false);
        editText = new TextInputEditText(getContext());
        createEditBox(editText);
        setEndIconMode(END_ICON_CLEAR_TEXT);
    }

    private void createEditBox(TextInputEditText editText) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        editText.setLayoutParams(layoutParams);
        editText.setTextColor(getResources().getColor(R.color.libColorBlack));
        editText.setTextSize(18.0f);
        addView(editText);
    }
}
