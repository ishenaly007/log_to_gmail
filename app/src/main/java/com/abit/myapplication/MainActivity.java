package com.abit.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText email, title, text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent();
        btn=(Button) findViewById(R.id.btn1);
        email=(EditText) findViewById(R.id.et_email);
        title=(EditText) findViewById(R.id.et_title);
        text=(EditText) findViewById(R.id.et_text);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("plain/text");
                emailIntent.putExtra(Intent.EXTRA_EMAIL,
                        new String[]{email.getText().toString()});
                emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
                        title.getText().toString());
                emailIntent.putExtra(Intent.EXTRA_TEXT,
                        text.getText().toString());
                MainActivity.this.startActivity(Intent.createChooser(emailIntent, "Sending..."));

            }
        });
    }
}