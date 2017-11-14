package com.daya.logger.sample.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.daya.logger.sample.R;
import com.daya.logger.sample.widgets.configuration.settings.ProjectSettingsView;

/**
 * Created by Shnoble on 2017. 11. 14..
 */

public class ToastLoggerConfigurationView extends LinearLayout {
    private ProjectSettingsView mProjectSettingsView;

    public ToastLoggerConfigurationView(Context context) {
        super(context);
        init();
    }

    public ToastLoggerConfigurationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ToastLoggerConfigurationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        View view = layoutInflater.inflate(R.layout.layout_configuration_logger_toast, this, false);
        addView(view);

        mProjectSettingsView = view.findViewById(R.id.project_settings_view);
    }

    public String getProjectKey() {
        return mProjectSettingsView.getProjectKey();
    }

    public String getProjectVersion() {
        return mProjectSettingsView.getProjectVersion();
    }
}
