package com.example.Gcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewEventActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.eventlistsql.REPLY";

    private EditText editEventView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_event);
        editEventView = findViewById(R.id.edit_event);
        final Button button = findViewById(R.id.button_save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                if(TextUtils.isEmpty(editEventView.getText())){
                    setResult(RESULT_CANCELED, replyIntent);
                } else {
                    String event = editEventView.getText().toString();
                    replyIntent.putExtra(EXTRA_REPLY, event);
                    setResult(RESULT_OK, replyIntent);
                }
                finish();
            }
        });
    }
}
