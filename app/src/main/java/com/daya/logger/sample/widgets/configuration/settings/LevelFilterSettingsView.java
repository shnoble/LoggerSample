package com.daya.logger.sample.widgets.configuration.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.daya.logger.sample.R;

/**
 * Created by shhong on 2017. 11. 14..
 */

public class LevelFilterSettingsView extends LinearLayout {

    private View mLevelView;

    public LevelFilterSettingsView(Context context) {
        super(context);
        init();
    }

    public LevelFilterSettingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LevelFilterSettingsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        View view = layoutInflater.inflate(R.layout.layout_settings_filter_level, this, false);
        addView(view);

        mLevelView = view.findViewById(R.id.level_layout);

        Switch enabledSwitch = view.findViewById(R.id.enabled_switch);
        enabledSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                mLevelView.setVisibility(isChecked ? VISIBLE : GONE);
            }
        });
    }
}
