package com.daya.deletablelistview.sample;

import android.support.annotation.NonNull;

/**
 * Created by Shnoble on 2017. 11. 19..
 */

public class UserFieldListItem {
    private final String mField;
    private final String mValue;

    public UserFieldListItem(@NonNull String field,
                             @NonNull String value) {
        this.mField = field;
        this.mValue = value;
    }

    public String getField() {
        return mField;
    }

    public String getValue() {
        return mValue;
    }

    @Override
    public String toString() {
        return mField + ":" + mValue;
    }
}
