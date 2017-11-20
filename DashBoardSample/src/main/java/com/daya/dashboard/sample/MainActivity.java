package com.daya.dashboard.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.daya.dashboard.sample.widgets.DashBoardView;

public class MainActivity extends AppCompatActivity {

    private DashBoardView mDashBoard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDashBoard = findViewById(R.id.dash_board);

        mDashBoard.setCount(DashBoardView.TRIED_COUNTER, 1);
        mDashBoard.setCount(DashBoardView.SUCCEED_COUNTER, 2);
        mDashBoard.setCount(DashBoardView.SAVED_COUNTER, 3);
        mDashBoard.setCount(DashBoardView.FILTERED_COUNTER, 4);
        mDashBoard.setCount(DashBoardView.FAILED_COUNTER, 5);

        findViewById(R.id.increase_tried_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDashBoard.increaseCount(DashBoardView.TRIED_COUNTER);
            }
        });

        findViewById(R.id.increase_succeed_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDashBoard.increaseCount(DashBoardView.SUCCEED_COUNTER);
            }
        });

        findViewById(R.id.increase_saved_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDashBoard.increaseCount(DashBoardView.SAVED_COUNTER);
            }
        });

        findViewById(R.id.increase_filtered_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDashBoard.increaseCount(DashBoardView.FILTERED_COUNTER);
            }
        });

        findViewById(R.id.increase_failed_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDashBoard.increaseCount(DashBoardView.FAILED_COUNTER);
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
