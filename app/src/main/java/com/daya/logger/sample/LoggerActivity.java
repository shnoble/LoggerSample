package com.daya.logger.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
import android.widget.Toast;

import static com.daya.logger.sample.fragment.CrashLoggerFragment.OnCrashLoggerFragmentListener;
import static com.daya.logger.sample.fragment.InstanceLoggerFragment.OnInstanceLoggerFragmentListener;
import static com.daya.logger.sample.fragment.ToastLoggerFragment.OnToastLoggerFragmentListener;

public class LoggerActivity extends AppCompatActivity
        implements OnToastLoggerFragmentListener, OnInstanceLoggerFragmentListener,
        OnCrashLoggerFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logger);

        TabHost loggerTab = (TabHost) findViewById(R.id.loggerTabHost);
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
    public void onToastLoggerFragmentInteraction() {
        Toast.makeText(this, "onToastLoggerFragmentInteraction", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onInstanceLoggerFragmentInteraction() {
        Toast.makeText(this, "onInstanceLoggerFragmentInteraction", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCrashLoggerFragmentInteraction() {
        Toast.makeText(this, "onCrashLoggerFragmentInteraction", Toast.LENGTH_SHORT).show();
    }
}
