package com.daya.dashboard.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.daya.dashboard.sample.widgets.DashBoardView;

public class MainActivity extends AppCompatActivity {

    private DashBoardView mDashBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDashBoard = findViewById(R.id.dash_board);

        mDashBoard.setTriedCount(1);
        mDashBoard.setSucceedCount(2);
        mDashBoard.setSavedCount(3);
        mDashBoard.setFilteredCount(4);
        mDashBoard.setFailedCount(5);

        findViewById(R.id.increase_tried_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDashBoard.increaseTriedCount();
            }
        });

        findViewById(R.id.increase_succeed_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDashBoard.increaseSucceedCount();
            }
        });

        findViewById(R.id.increase_saved_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDashBoard.increaseSavedCount();
            }
        });

        findViewById(R.id.increase_filtered_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDashBoard.increaseFilteredCount();
            }
        });

        findViewById(R.id.increase_failed_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDashBoard.increaseFailedCount();
            }
        });

        findViewById(R.id.clear_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDashBoard.clear();
            }
        });
    }


}
