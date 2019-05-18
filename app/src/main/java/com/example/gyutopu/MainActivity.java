package com.example.gyutopu;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.messageButton);

        final View animeTextView = findViewById(R.id.animeTextView);

        final GyuResults gyuResults = new GyuResults(listGyuResults());

        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != MotionEvent.ACTION_DOWN) return false;

                    animateAlpha(animeTextView);

//                gyuResults.showRandom();
                return false;
            }
        });
    }

    private void animateAlpha( View target ) {

        // alphaプロパティを0fから1fに変化させます
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat( target, "alpha", 0f, 1f );

        // 3秒かけて実行させます
        objectAnimator.setDuration( 3000 );

        // アニメーションを開始します
        objectAnimator.start();
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
