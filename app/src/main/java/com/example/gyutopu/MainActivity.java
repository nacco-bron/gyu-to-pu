package com.example.gyutopu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void changeTextView(View view){
        final TextView mesView = findViewById(R.id.messageTextView);
        mesView.setText("＼ ﾌﾟｯ ／");
    }

}
