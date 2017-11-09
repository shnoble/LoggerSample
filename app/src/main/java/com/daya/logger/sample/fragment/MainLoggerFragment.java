package com.daya.logger.sample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.daya.logger.sample.R;

public class MainLoggerFragment extends Fragment {
    private static final String TAG = MainLoggerFragment.class.getSimpleName();

    public MainLoggerFragment() {
    }

    public static MainLoggerFragment newInstance() {
        return new MainLoggerFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_logger, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TabHost loggerTab = view.findViewById(R.id.loggerTabHost);
        loggerTab.setup();

        TabHost.TabSpec toastLoggerTabSpec = loggerTab.newTabSpec("toast_logger")
                .setContent(R.id.toast_logger_fragment)
                .setIndicator("TOAST");
        loggerTab.addTab(toastLoggerTabSpec);

        TabHost.TabSpec instanceLoggerTabSpec = loggerTab.newTabSpec("instance_logger")
                .setContent(R.id.instance_logger_fragment)
                .setIndicator("Instance");
        loggerTab.addTab(instanceLoggerTabSpec);

        TabHost.TabSpec crashLoggerTabSpec = loggerTab.newTabSpec("crash_logger")
                .setContent(R.id.crash_logger_fragment)
                .setIndicator("CRASH");
        loggerTab.addTab(crashLoggerTabSpec);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
