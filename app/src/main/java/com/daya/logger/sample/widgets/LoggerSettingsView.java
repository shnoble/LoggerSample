package com.daya.logger.sample.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.daya.logger.sample.R;

/**
 * TODO: document your custom view class.
 */
public class LoggerSettingsView extends LinearLayout {
    private static final String TAG = LoggerSettingsView.class.getSimpleName();

    public LoggerSettingsView(Context context) {
        super(context);
        init(null, 0);
    }

    public LoggerSettingsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public LoggerSettingsView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray typedArray = getContext().obtainStyledAttributes(
                attrs, R.styleable.LoggerSettingsView, defStyle, 0);

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        View v = layoutInflater.inflate(R.layout.layout_logger_settings, this, false);
        addView(v);

        Spinner settingsSpinner = findViewById(R.id.settings_type_spinner);
        settingsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Log.d(TAG, "Selected settings type: " + i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        typedArray.recycle();
    }
}
