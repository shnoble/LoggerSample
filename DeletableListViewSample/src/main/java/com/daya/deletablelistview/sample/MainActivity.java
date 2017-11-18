package com.daya.deletablelistview.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // LogType ListView Adapter 생성
        final LogTypeListViewAdapter logTypeListViewAdapter = new LogTypeListViewAdapter();

        // LogType ListView 에 Adapter 설정
        final NonScrollListView logTypeListView = (NonScrollListView) findViewById(R.id.log_type_list_view);
        logTypeListView.setEnabled(false);
        logTypeListView.setAdapter(logTypeListViewAdapter);

        logTypeListViewAdapter.addItem("A");
        logTypeListViewAdapter.addItem("B");
        logTypeListViewAdapter.addItem("C");
        logTypeListViewAdapter.addItem("D");

        // UserField ListView Adapter 생성
        final UserFieldListViewAdapter userFieldListViewAdapter = new UserFieldListViewAdapter();

        // UserField ListView 에 Adapter 설정
        final NonScrollListView userFieldListView = (NonScrollListView) findViewById(R.id.user_field_list_view);
        userFieldListView.setEnabled(false);
        userFieldListView.setAdapter(userFieldListViewAdapter);

        userFieldListViewAdapter.addItem(new UserFieldListItem("UserField1", "UserValue1"));
        userFieldListViewAdapter.addItem(new UserFieldListItem("UserField2", "UserValue2"));
        userFieldListViewAdapter.addItem(new UserFieldListItem("UserField3", "UserValue3"));
        userFieldListViewAdapter.addItem(new UserFieldListItem("UserField4", "UserValue4"));

        findViewById(R.id.add_log_type_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (logTypeListViewAdapter.addItem("Add Type " + mIndex++)) {
                    logTypeListViewAdapter.notifyDataSetChanged();
                }
            }
        });

        findViewById(R.id.add_user_field_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mIndex++;
                if (userFieldListViewAdapter.addItem(new UserFieldListItem("AddUserField" + mIndex, "AddUserValue" + mIndex))) {
                    userFieldListViewAdapter.notifyDataSetChanged();
                }
            }
        });

        findViewById(R.id.get_log_type_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Log types: " + logTypeListViewAdapter.getItems());
            }
        });

        findViewById(R.id.get_user_field_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "User Fields: " + userFieldListViewAdapter.getItems());
            }
        });
    }
}
