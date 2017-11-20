package com.toast.android.logtypeslist.sample;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.toast.android.logtypeslist.sample.alert.SimpleInputTextDialog;
import com.toast.android.logtypeslist.sample.widgets.LogTypeListView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final LogTypeListView typeListView = findViewById(R.id.log_type_list);

        findViewById(R.id.add_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SimpleInputTextDialog.show(MainActivity.this, "Add Type", "Input type name", "Add", new SimpleInputTextDialog.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, EditText editText) {
                        String type = editText.getText().toString();
                        if (!TextUtils.isEmpty(type)) {
                            typeListView.addType(type);
                        }
                        Log.d(TAG, "Types: " + typeListView.getTypes());
                    }
                }, "Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
            }
        });
    }
}
