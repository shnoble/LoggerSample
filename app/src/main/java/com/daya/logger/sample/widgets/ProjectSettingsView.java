package com.daya.logger.sample.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.daya.logger.sample.R;

/**
 * Created by Shnoble on 2017. 11. 14..
 */

public class ProjectSettingsView extends LinearLayout {
    private EditText mProjectKeyEditText;
    private EditText mProjectVersionEditText;

    public ProjectSettingsView(Context context) {
        super(context);
        init(null, 0);
    }

    public ProjectSettingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public ProjectSettingsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        View view = layoutInflater.inflate(R.layout.layout_settings_project, this, false);
        addView(view);

        mProjectKeyEditText = findViewById(R.id.project_key_edit_text);
        mProjectVersionEditText = findViewById(R.id.project_version_edit_text);
    }

    public String getProjectKey() {
        return mProjectKeyEditText.getText().toString();
    }

    public String getProjectVersion() {
        return mProjectVersionEditText.getText().toString();
    }
}
