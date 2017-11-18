package com.daya.deletablelistview.sample;

import android.content.Context;
import android.support.annotation.NonNull;
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

public class UserFieldListViewAdapter extends BaseAdapter {
    private List<UserFieldListItem> mUserFieldItems = new ArrayList<>();

    @Override
    public int getCount() {
        return mUserFieldItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserFieldItems.get(position);
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
            view = inflater.inflate(R.layout.layout_user_field_list_item, viewGroup, false);
        }

        final TextView fieldView = (TextView) view.findViewById(R.id.field_text_view);
        final TextView valueView = (TextView) view.findViewById(R.id.value_text_view);

        UserFieldListItem item = mUserFieldItems.get(position);
        fieldView.setText(item.getField());
        valueView.setText(item.getValue());

        view.findViewById(R.id.delete_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserFieldItems.remove(position);
                notifyDataSetChanged();
            }
        });
        return view;
    }

    public boolean addItem(@NonNull UserFieldListItem item) {
        for (UserFieldListItem userFieldListItem : mUserFieldItems) {
            if (userFieldListItem.getField().equals(item.getField())) {
                return false;
            }
        }
        mUserFieldItems.add(item);
        return true;
    }

    public List<UserFieldListItem> getItems() {
        return mUserFieldItems;
    }
}
