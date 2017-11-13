package com.daya.logger.sample.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.daya.logger.sample.R;

/**
 * TODO: document your custom view class.
 */
public class InputTextView extends LinearLayout {
    public InputTextView(Context context) {
        super(context);
        initView(null, 0);
    }

    public InputTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(attrs, 0);
    }

    public InputTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(attrs, defStyle);
    }

    private void initView(AttributeSet attrs, int defStyle) {
        // Load attributes
        final TypedArray typedArray = getContext().obtainStyledAttributes(
                attrs, R.styleable.InputTextView, defStyle, 0);

        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.layout_input_text, this, false);
        addView(v);

        String title = typedArray.getString(R.styleable.InputTextView_inputTextTitle);
        TextView titleView = findViewById(R.id.title);
        titleView.setText(title);

        String hint = typedArray.getString(R.styleable.InputTextView_inputTextHint);
        EditText valueView = findViewById(R.id.value);
        valueView.setHint(hint);

        //return inflater.inflate(R.layout.fragment_crash_logger, container, false);

        /*
        mExampleString = a.getString(
                R.styleable.InputTextView_exampleString);
        mExampleColor = a.getColor(
                R.styleable.InputTextView_exampleColor,
                mExampleColor);
        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
        // values that should fall on pixel boundaries.
        mExampleDimension = a.getDimension(
                R.styleable.InputTextView_exampleDimension,
                mExampleDimension);

        if (a.hasValue(R.styleable.InputTextView_exampleDrawable)) {
            mExampleDrawable = a.getDrawable(
                    R.styleable.InputTextView_exampleDrawable);
            mExampleDrawable.setCallback(this);
        }
        */

        typedArray.recycle();

        /*
        // Set up a default TextPaint object
        mTextPaint = new TextPaint();
        mTextPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setTextAlign(Paint.Align.LEFT);

        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements();*/
    }
}
