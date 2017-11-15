package com.daya.dashboard.sample.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daya.dashboard.sample.R;

/**
 * Created by Shnoble on 2017. 11. 15..
 */

public class CounterView extends LinearLayout {
    private TextView mCountView;

    public CounterView(Context context) {
        super(context);
        init(null, 0);
    }

    public CounterView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CounterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyle) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        View view = layoutInflater.inflate(R.layout.layout_counter, this, false);
        addView(view);

        // Load attributes
        final TypedArray typedArray = getContext().obtainStyledAttributes(
                attrs, R.styleable.CounterView, defStyle, 0);

        String name = typedArray.getString(R.styleable.CounterView_counterName);
        int color = typedArray.getColor(R.styleable.CounterView_counterColor, Color.GRAY);

        TextView nameView = findViewById(R.id.name_view);
        nameView.setText(name);

        mCountView = (TextView) findViewById(R.id.count_view);
        mCountView.setTextColor(color);

        typedArray.recycle();
    }

    public void setCount(int count) {
        mCountView.setText(String.valueOf(count));
    }
}
