package com.daya.dashboard.sample.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.daya.dashboard.sample.R;

/**
 * Created by Shnoble on 2017. 11. 15..
 */

public class DashBoardView extends LinearLayout {
    private CounterView mTriedCounterView;
    private CounterView mSucceedCounterView;
    private CounterView mSavedCounterView;
    private CounterView mFilteredCounterView;
    private CounterView mFailedCounterView;

    private int mTriedCount = 0;
    private int mSucceedCount = 0;
    private int mSavedCount = 0;
    private int mFilteredCount = 0;
    private int mFailedCount = 0;

    public DashBoardView(Context context) {
        super(context);
        init(null, 0);
    }

    public DashBoardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public DashBoardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyle) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        View view = layoutInflater.inflate(R.layout.layout_dash_board, this, false);
        addView(view);

        mTriedCounterView = (CounterView) findViewById(R.id.tried_counter);
        mSucceedCounterView = (CounterView) findViewById(R.id.succeed_counter);
        mSavedCounterView = (CounterView) findViewById(R.id.saved_counter);
        mFilteredCounterView = (CounterView) findViewById(R.id.filtered_counter);
        mFailedCounterView = (CounterView) findViewById(R.id.failed_counter);
    }

    public void setTriedCount(int count) {
        mTriedCounterView.setCount(count);
        mTriedCount = count;
    }

    public void setSucceedCount(int count) {
        mSucceedCounterView.setCount(count);
        mSucceedCount = count;
    }

    public void setSavedCount(int count) {
        mSavedCounterView.setCount(count);
        mSavedCount = count;
    }

    public void setFilteredCount(int count) {
        mFilteredCounterView.setCount(count);
        mFilteredCount = count;
    }

    public void setFailedCount(int count) {
        mFailedCounterView.setCount(count);
        mFailedCount = count;
    }

    public void increaseTriedCount() {
        setTriedCount(mTriedCount + 1);
    }

    public void increaseSucceedCount() {
        setSucceedCount(mSucceedCount + 1);
    }

    public void increaseSavedCount() {
        setSavedCount(mSavedCount + 1);
    }

    public void increaseFilteredCount() {
        setFilteredCount(mFilteredCount + 1);
    }

    public void increaseFailedCount() {
        setFailedCount(mFailedCount + 1);
    }

    public void clear() {
        setTriedCount(0);
        setSucceedCount(0);
        setSavedCount(0);
        setFilteredCount(0);
        setFailedCount(0);
    }
}
