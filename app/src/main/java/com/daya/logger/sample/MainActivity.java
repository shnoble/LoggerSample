package com.daya.logger.sample;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.daya.logger.sample.fragment.CrashLoggerFragment;
import com.daya.logger.sample.fragment.InstanceLoggerFragment;
import com.daya.logger.sample.fragment.MainLoggerFragment;
import com.daya.logger.sample.fragment.ToastLoggerFragment;
import com.daya.logger.sample.widgets.configuration.LoggerConfigurationFragment;

public class MainActivity extends AppCompatActivity
        implements LoggerConfigurationFragment.OnStartListener,
        ToastLoggerFragment.OnToastLoggerFragmentListener,
        InstanceLoggerFragment.OnInstanceLoggerFragmentListener,
        CrashLoggerFragment.OnCrashLoggerFragmentListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, LoggerConfigurationFragment.newInstance("a", "b"))
                .commit();
    }

    @Override
    public void onStartLogger() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, MainLoggerFragment.newInstance())
                .commit();
    }

    @Override
    public void onToastLoggerFragmentInteraction() {

    }

    @Override
    public void onCrashLoggerFragmentInteraction() {

    }

    @Override
    public void onInstanceLoggerFragmentInteraction() {

    }
}
