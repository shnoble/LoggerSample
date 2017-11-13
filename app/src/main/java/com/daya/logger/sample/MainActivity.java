package com.daya.logger.sample;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.daya.logger.sample.fragment.CrashLoggerFragment;
import com.daya.logger.sample.fragment.configuration.InstanceLoggerConfigurationFragment;
import com.daya.logger.sample.fragment.InstanceLoggerFragment;
import com.daya.logger.sample.fragment.configuration.MainLoggerConfigurationFragment;
import com.daya.logger.sample.fragment.MainLoggerFragment;
import com.daya.logger.sample.fragment.configuration.ToastLoggerConfigurationFragment;
import com.daya.logger.sample.fragment.ToastLoggerFragment;

public class MainActivity extends AppCompatActivity
        implements MainLoggerConfigurationFragment.OnStartListener,
        ToastLoggerConfigurationFragment.OnFragmentInteractionListener,
        InstanceLoggerConfigurationFragment.OnFragmentInteractionListener,
        ToastLoggerFragment.OnToastLoggerFragmentListener,
        InstanceLoggerFragment.OnInstanceLoggerFragmentListener,
        CrashLoggerFragment.OnCrashLoggerFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, MainLoggerConfigurationFragment.newInstance("a", "b"))
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

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
