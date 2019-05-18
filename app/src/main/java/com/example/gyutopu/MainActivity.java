package com.example.gyutopu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.messageButton);

        final GyuResults gyuResults = new GyuResults(listGyuResults());

        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != MotionEvent.ACTION_DOWN) return false;
                gyuResults.showRandom();
                return false;
            }
        });
    }

    private List<View> listGyuResults() {
        int[] ids = new int[]{
                R.id.messageTextView,
                R.id.cowFaceImageView,
                R.id.pigFaceImageView,
                R.id.hamburgerImageView,
                R.id.sushiImageView
        };
        List<View> results = new ArrayList<>();
        for (int id : ids) {
            results.add(findViewById(id));
        }
        return results;
    }
}
