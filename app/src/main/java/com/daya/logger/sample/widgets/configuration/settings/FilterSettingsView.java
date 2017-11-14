package com.daya.logger.sample.widgets.configuration.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.daya.logger.sample.R;

/**
 * Created by shhong on 2017. 11. 14..
 */

public class FilterSettingsView extends LinearLayout {

    public FilterSettingsView(Context context) {
        super(context);
        init();
    }

    public FilterSettingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FilterSettingsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        View v = layoutInflater.inflate(R.layout.layout_settings_filter, this, false);
        addView(v);
    }
}
