package com.daya.logger.sample.widgets.configuration;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.daya.logger.sample.R;
import com.daya.logger.sample.widgets.InstanceLoggerConfigurationView;
import com.daya.logger.sample.widgets.ToastLoggerConfigurationView;

public class LoggerConfigurationFragment extends Fragment {
    private static final String TAG = LoggerConfigurationFragment.class.getSimpleName();

    private ToastLoggerConfigurationView mToastLoggerConfigurationView;
    private InstanceLoggerConfigurationView mInstanceLoggerConfigurationView;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnStartListener mListener;

    public LoggerConfigurationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoggerConfigurationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoggerConfigurationFragment newInstance(String param1, String param2) {
        LoggerConfigurationFragment fragment = new LoggerConfigurationFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_configuration_logger, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d(TAG, "onViewCreated");

        TabHost loggerTab = view.findViewById(R.id.loggerTabHost);
        loggerTab.setup();

        TabHost.TabSpec toastLoggerTabSpec = loggerTab.newTabSpec("toast_logger_configuration")
                .setContent(R.id.toast_logger_configuration_view)
                .setIndicator("TOAST");
        loggerTab.addTab(toastLoggerTabSpec);

        TabHost.TabSpec instanceLoggerTabSpec = loggerTab.newTabSpec("instance_logger_configuration")
                .setContent(R.id.instance_logger_configuration_view)
                .setIndicator("Instance");
        loggerTab.addTab(instanceLoggerTabSpec);

        mToastLoggerConfigurationView = view.findViewById(R.id.toast_logger_configuration_view);
        mInstanceLoggerConfigurationView = view.findViewById(R.id.instance_logger_configuration_view);

        view.findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onStartButtonPressed();
            }
        });
    }

    public void onStartButtonPressed() {
        Log.d(TAG, "Toast Logger Project Key: " + mToastLoggerConfigurationView.getProjectKey());
        Log.d(TAG, "Toast Logger Project Version: " + mToastLoggerConfigurationView.getProjectVersion());

        Log.d(TAG, "Instance Logger Project Key: " + mInstanceLoggerConfigurationView.getProjectKey());
        Log.d(TAG, "Instance Logger Project Version: " + mInstanceLoggerConfigurationView.getProjectVersion());

        if (mListener != null) {
            mListener.onStartLogger();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnStartListener) {
            mListener = (OnStartListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnStartListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnStartListener {
        // TODO: Update argument type and name
        void onStartLogger();
    }
}
