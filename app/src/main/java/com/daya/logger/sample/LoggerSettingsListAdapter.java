package com.daya.logger.sample;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shnoble on 2017. 11. 8..
 */

public class LoggerSettingsListAdapter extends BaseAdapter {
    private List<View> mViews = new ArrayList<>();

    public LoggerSettingsListAdapter() {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
