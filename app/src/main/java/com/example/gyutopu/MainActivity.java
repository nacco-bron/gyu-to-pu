package com.example.gyutopu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.messageButton);
        final TextView messageTextView = findViewById(R.id.messageTextView);
        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                String text = event.getAction() == MotionEvent.ACTION_DOWN ? "＼ ﾌﾟｯ ／" : "…";
                messageTextView.setText(text);
                return false;
            }
        });
    }
}
