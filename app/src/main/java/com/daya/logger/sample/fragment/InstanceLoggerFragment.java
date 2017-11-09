package com.daya.logger.sample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daya.logger.sample.R;

public class InstanceLoggerFragment extends Fragment {
    private OnInstanceLoggerFragmentListener mListener;

    public InstanceLoggerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_instance_logger, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.send_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSendButtonPressed();
            }
        });
    }

    public void onSendButtonPressed() {
        if (mListener != null) {
            mListener.onInstanceLoggerFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnInstanceLoggerFragmentListener) {
            mListener = (OnInstanceLoggerFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnInstanceLoggerFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnInstanceLoggerFragmentListener {
        void onInstanceLoggerFragmentInteraction();
    }
}
