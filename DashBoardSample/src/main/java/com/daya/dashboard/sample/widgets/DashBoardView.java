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
    public static final int TRIED_COUNTER = 0;
    public static final int SUCCEED_COUNTER = 1;
    public static final int SAVED_COUNTER = 2;
    public static final int FILTERED_COUNTER = 3;
    public static final int FAILED_COUNTER = 4;
    public static final int COUNTER_COUNT = 5;

    private CounterView[] mCounterViews;
    private int[] mCounts;

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

        mCounts = new int[COUNTER_COUNT];
        mCounterViews = new CounterView[COUNTER_COUNT];
        mCounterViews[TRIED_COUNTER] = (CounterView) findViewById(R.id.tried_counter);
        mCounterViews[SUCCEED_COUNTER] = (CounterView) findViewById(R.id.succeed_counter);
        mCounterViews[SAVED_COUNTER] = (CounterView) findViewById(R.id.saved_counter);
        mCounterViews[FILTERED_COUNTER] = (CounterView) findViewById(R.id.filtered_counter);
        mCounterViews[FAILED_COUNTER] = (CounterView) findViewById(R.id.failed_counter);
    }

    public void setCount(int viewId, int count) {
        mCounterViews[viewId].setCount(count);
        mCounts[viewId] = count;
    }

    public void increaseCount(int viewId) {
        setCount(viewId, mCounts[viewId] + 1);
    }

    public void clear() {
        for (int i = 0; i < COUNTER_COUNT; i++) {
            setCount(i, 0);
        }
    }
}
