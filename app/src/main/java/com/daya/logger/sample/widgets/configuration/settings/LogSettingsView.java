package com.daya.logger.sample.widgets.configuration.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.daya.logger.sample.R;

public class LogSettingsView extends LinearLayout {

    public LogSettingsView(Context context) {
        super(context);
        init();
    }

    public LogSettingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LogSettingsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        View v = layoutInflater.inflate(R.layout.layout_settings_log, this, false);
        addView(v);
    }
}
