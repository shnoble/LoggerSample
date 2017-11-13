package com.daya.logger.sample.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.daya.logger.sample.R;

/**
 * Created by Shnoble on 2017. 11. 14..
 */

public class InstanceLoggerConfigurationView extends LinearLayout {
    private ProjectSettingsView mProjectSettingsView;

    public InstanceLoggerConfigurationView(Context context) {
        super(context);
        init(null, 0);
    }

    public InstanceLoggerConfigurationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public InstanceLoggerConfigurationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        View view = layoutInflater.inflate(R.layout.layout_configuration_logger_instance, this, false);
        addView(view);

        mProjectSettingsView = view.findViewById(R.id.project_settings_view);

        view.findViewById(R.id.show_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                findViewById(R.id.text_view).setVisibility(GONE);
            }
        });
    }

    public String getProjectKey() {
        return mProjectSettingsView.getProjectKey();
    }

    public String getProjectVersion() {
        return mProjectSettingsView.getProjectVersion();
    }
}
