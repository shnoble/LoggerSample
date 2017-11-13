package com.daya.logger.sample.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.daya.logger.sample.R;

/**
 * TODO: document your custom view class.
 */
public class LoggerConfigurationView extends LinearLayout {

    public LoggerConfigurationView(Context context) {
        super(context);
        init(null, 0);
    }

    public LoggerConfigurationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public LoggerConfigurationView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        final TypedArray typedArray = getContext().obtainStyledAttributes(
                attrs, R.styleable.LoggerConfigurationView, defStyle, 0);

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.layout_logger_configuration, this, false);
        addView(v);

        boolean settingsVisibility =
                typedArray.getBoolean(R.styleable.LoggerConfigurationView_settingsVisibility, false);

        findViewById(R.id.settings_layout).setVisibility(settingsVisibility ? VISIBLE : GONE);
        typedArray.recycle();
    }
}
