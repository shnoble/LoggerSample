package com.daya.logger.sample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daya.logger.sample.R;

public class ToastLoggerFragment extends Fragment {
    private OnToastLoggerFragmentListener mListener;

    public ToastLoggerFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_toast_logger, container, false);
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
            mListener.onToastLoggerFragmentInteraction();
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnToastLoggerFragmentListener) {
            mListener = (OnToastLoggerFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnToastLoggerFragmentListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnToastLoggerFragmentListener {
        void onToastLoggerFragmentInteraction();
    }
}
