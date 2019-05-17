package com.example.gyutopu;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.messageButton);

        final List<View> gyuResults = listGyuResults();

        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != MotionEvent.ACTION_DOWN) return false;
                View gyuResult = randomChoice(gyuResults);
                showOf(gyuResult, gyuResults);
                return false;
            }
        });
    }

    private List<View> listGyuResults() {
        List<View> results = new ArrayList<>();
        results.add(findViewById(R.id.messageTextView));
        results.add(findViewById(R.id.cowFaceImageView));
        results.add(findViewById(R.id.pigFaceImageView));
        results.add(findViewById(R.id.hamburgerImageView));
        results.add(findViewById(R.id.sushiImageView));
        return results;
    }

    private View randomChoice(List<View> list) {
        int index = new Random().nextInt(list.size());
        return list.get(index);
    }

    private void showOf(View gyuResult, List<View> gyuResults) {
        for (View item : gyuResults) {
            int visible = item == gyuResult ? View.VISIBLE : View.INVISIBLE;
            item.setVisibility(visible);
        }
    }
}
