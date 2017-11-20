package com.toast.android.logtypeslist.sample.widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.toast.android.logtypeslist.sample.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shhong on 2017. 11. 16..
 */

public class LogTypeListView extends LinearLayout {
    private List<String> mTypes = new ArrayList<>();
    private LinearLayout mListView;

    public LogTypeListView(Context context) {
        super(context);
        init(null, 0);
    }

    public LogTypeListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public LogTypeListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        mListView = (LinearLayout) layoutInflater.inflate(R.layout.layout_log_type_list, this, false);
        addView(mListView);
    }

    public void addType(String type) {
        LayoutInflater layoutInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (layoutInflater == null) {
            return;
        }

        if (mListView.findViewWithTag(type) != null) {
            return;
        }

        mTypes.add(type);

        final View typeView = layoutInflater.inflate(R.layout.layout_log_type_list_item, this, false);
        typeView.setTag(type);

        TextView typeNameView = typeView.findViewById(R.id.type_name);
        typeNameView.setText(type);

        typeView.findViewById(R.id.delete_button).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String tag = (String) typeView.getTag();
                mTypes.remove(tag);
                mListView.removeView(typeView);
            }
        });

        mListView.addView(typeView);
    }

    public List<String> getTypes() {
        if (mTypes.isEmpty()) {
            return null;
        }
        return mTypes;
    }
}
