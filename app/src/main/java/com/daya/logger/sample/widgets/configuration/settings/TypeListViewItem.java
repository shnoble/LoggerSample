package com.daya.logger.sample.widgets.configuration.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.daya.logger.sample.R;

public class TypeListViewItem extends LinearLayout {
    public TypeListViewItem(Context context) {
        super(context);
        init();
    }

    public TypeListViewItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TypeListViewItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        View view = layoutInflater.inflate(R.layout.layout_log_type_list_item, this, false);
        addView(view);
    }
}
