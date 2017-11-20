/*
 * Copyright 2013-present NHN Entertainment Corp. All rights Reserved.
 * NHN Entertainment PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 * @author shhong@nhnent.com
 */

package com.toast.android.logtypeslist.sample.alert;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.EditText;

/**
 * Created by shhong on 2017. 3. 2..
 */

public class SimpleInputTextDialog {
    public static final String TAG = SimpleInputTextDialog.class.getSimpleName();

    public static void show(@NonNull final Context context,
                            @NonNull final String title,
                            @NonNull final String message,
                            @Nullable final String positiveButtonText,
                            @Nullable final OnClickListener positiveListener,
                            @Nullable final String negativeButtonText,
                            @Nullable final DialogInterface.OnClickListener negativeListener) {
        final EditText editText = new EditText(context);
        show(context, title, message, editText,
                positiveButtonText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if (positiveListener != null) {
                            positiveListener.onClick(dialogInterface, editText);
                        }
                    }
                },
                negativeButtonText,
                negativeListener,
                null,
                true);
    }

    public static void show(@NonNull final Context context,
                            @NonNull final String title,
                            @NonNull final String message,
                            @NonNull final EditText editText,
                            @Nullable final String positiveButtonText,
                            @Nullable final DialogInterface.OnClickListener positiveListener,
                            @Nullable final String negativeButtonText,
                            @Nullable final DialogInterface.OnClickListener negativeListener,
                            @Nullable final DialogInterface.OnCancelListener cancelListener,
                            final boolean isCancelable) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(context)
                        .setTitle(title)
                        .setMessage(message)
                        .setView(editText)
                        .setPositiveButton(positiveButtonText, positiveListener)
                        .setNegativeButton(negativeButtonText, negativeListener)
                        .setOnCancelListener(cancelListener)
                        .setCancelable(isCancelable)
                        .create()
                        .show();
            }
        };

        if (Looper.myLooper() != context.getMainLooper()) {
            Handler mainHandler = new Handler(context.getMainLooper());
            mainHandler.post(runnable);
        } else {
            //Logger.d(TAG, "This method was called on the main thread.");
            runnable.run();
        }
    }

    public interface OnClickListener {
        void onClick(DialogInterface dialog, EditText editText);
    }
}
