package com.daya.logger.sample.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.daya.logger.sample.R;
import com.daya.logger.sample.widgets.configuration.settings.FilterSettingsView;
import com.daya.logger.sample.widgets.configuration.settings.LogSettingsView;
import com.daya.logger.sample.widgets.configuration.settings.ProjectSettingsView;

/**
 * Created by Shnoble on 2017. 11. 14..
 */

public class InstanceLoggerConfigurationView extends LinearLayout {
    private static final String TAG = InstanceLoggerConfigurationView.class.getSimpleName();
    private ProjectSettingsView mProjectSettingsView;
    private LogSettingsView mLogSettingsView;
    private FilterSettingsView mFilterSettingsView;

    public InstanceLoggerConfigurationView(Context context) {
        super(context);
        init();
    }

    public InstanceLoggerConfigurationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InstanceLoggerConfigurationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        View view = layoutInflater.inflate(R.layout.layout_configuration_logger_instance, this, false);
        addView(view);

        mProjectSettingsView = view.findViewById(R.id.project_settings_view);
        mLogSettingsView = view.findViewById(R.id.log_settings_view);
        mFilterSettingsView = view.findViewById(R.id.filter_settings_view);

        // Settings type
        Spinner settingsSpinner = view.findViewById(R.id.settings_type_spinner);
        settingsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d(TAG, "Selected settings type: " + position + "(" + id + ")");

                int settingsVisibility;
                if (position == 2) {
                    settingsVisibility = VISIBLE;
                } else {
                    settingsVisibility = GONE;
                }
                mLogSettingsView.setVisibility(settingsVisibility);
                mFilterSettingsView.setVisibility(settingsVisibility);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        settingsSpinner.setSelection(2);
    }

    public String getProjectKey() {
        return mProjectSettingsView.getProjectKey();
    }

    public String getProjectVersion() {
        return mProjectSettingsView.getProjectVersion();
    }
}
