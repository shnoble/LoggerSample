package com.daya.logger.sample.widgets.configuration.settings;

import android.content.Context;
import android.content.res.TypedArray;
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
    private static final String TAG = ProjectSettingsView.class.getSimpleName();

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

        // Load attributes
        final TypedArray typedArray = getContext().obtainStyledAttributes(
                attrs, R.styleable.ProjectSettingsView, defStyle, 0);

        mProjectKeyEditText = view.findViewById(R.id.project_key_edit_text);
        mProjectVersionEditText = view.findViewById(R.id.project_version_edit_text);

        boolean isSettingsVisibility =
                typedArray.getBoolean(R.styleable.ProjectSettingsView_isSettingsVisibility, false);
        view.findViewById(R.id.settings_layout).setVisibility(isSettingsVisibility ? VISIBLE : GONE);

        typedArray.recycle();
    }

    public String getProjectKey() {
        return mProjectKeyEditText.getText().toString();
    }

    public String getProjectVersion() {
        return mProjectVersionEditText.getText().toString();
    }
}
