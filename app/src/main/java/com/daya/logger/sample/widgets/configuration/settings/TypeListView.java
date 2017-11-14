package com.daya.logger.sample.widgets.configuration.settings;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.daya.logger.sample.R;

/**
 * Created by shhong on 2017. 11. 14..
 */

public class TypeListView extends LinearLayout {
    private static final String TAG = TypeListView.class.getSimpleName();

    public TypeListView(Context context) {
        super(context);
        init(context);
    }

    public TypeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public TypeListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        View view = layoutInflater.inflate(R.layout.layout_log_type_list, this, false);
        addView(view);

        LinearLayout containerView = findViewById(R.id.log_type_view_container);
        containerView.addView(new TypeListViewItem(context));
        containerView.addView(new TypeListViewItem(context));
        containerView.addView(new TypeListViewItem(context));
    }
}
