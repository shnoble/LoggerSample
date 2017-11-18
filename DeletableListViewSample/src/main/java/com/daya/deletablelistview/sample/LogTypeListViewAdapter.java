package com.daya.deletablelistview.sample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shnoble on 2017. 11. 19..
 */

public class LogTypeListViewAdapter extends BaseAdapter {
    private List<String> mLogTypes = new ArrayList<>();

    @Override
    public int getCount() {
        return mLogTypes.size();
    }

    @Override
    public Object getItem(int position) {
        return mLogTypes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        final Context context = viewGroup.getContext();

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (inflater == null) {
                return null;
            }
            view = inflater.inflate(R.layout.layout_type_list_item, viewGroup, false);
        }

        TextView logTypeView = (TextView) view.findViewById(R.id.log_type_text_view);

        String type = mLogTypes.get(position);
        logTypeView.setText(type);

        view.findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLogTypes.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }

    public boolean addItem(String type) {
        if (mLogTypes.contains(type)) {
            return false;
        }
        mLogTypes.add(type);
        return true;
    }

    public List<String> getItems() {
        return mLogTypes;
    }
}
