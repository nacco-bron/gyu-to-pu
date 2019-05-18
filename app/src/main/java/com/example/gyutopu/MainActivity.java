package com.example.gyutopu;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
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

        final View animeTextView = findViewById(R.id.animeTextView);
        final View animeTextView2 = findViewById(R.id.animeTextView2);
        final GyuResults gyuResults = new GyuResults(listGyuResults());

        btn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() != MotionEvent.ACTION_DOWN) return false;

                powanAnimate(animeTextView);
                mokumokuAnimate(animeTextView2);
                final View animeTextView3 = gyuResults.randomChoice();
                puAnimate(animeTextView3);
                return false;
            }
        });
    }

    private void powanAnimate( View target ) {

        List<Animator> animatorList= new ArrayList<Animator>();
        final AnimatorSet animatorSet = new AnimatorSet();

        // フェードアウト alphaプロパティを1fから0fに変化
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat( target, "alpha", 1f, 0f );
        // 0.5秒かけて実行
        alphaAnimator.setDuration( 500 );
        animatorList.add( alphaAnimator );

        // translationYプロパティ 10fから0fに変化
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat( target, "translationY", 10f,0f);
        // 0.5秒かけて実行
        translationYAnimator.setDuration( 500 );
        animatorList.add( translationYAnimator );

        // リストのAnimatorを同時に実行
        animatorSet.playTogether( animatorList );
        animatorSet.start();
    }

    private void mokumokuAnimate( View target ) {

        List<Animator> animatorList= new ArrayList<Animator>();
        final AnimatorSet animatorSet = new AnimatorSet();
        int startDelay = 1000;
        int mokuDelay = 500;
        int mokuCount = 10;
        int moku = mokuDelay / mokuCount;

        // translationYプロパティ 上下に揺らす
        ObjectAnimator translationYAnimator = ObjectAnimator.ofFloat( target, "translationY", 30f,0f);
        translationYAnimator.setDuration( moku );
        translationYAnimator.setRepeatCount( mokuCount );
        translationYAnimator.setRepeatMode(Animation.RESTART);
        animatorList.add( translationYAnimator );
        // フェードアウト alphaプロパティを1fから0fに変化
        ObjectAnimator alphaAnimator = ObjectAnimator.ofFloat( target, "alpha", 1f, 0f );
        alphaAnimator.setDuration( mokuDelay );
        animatorList.add( alphaAnimator );

        // リストのAnimatorを同時に実行
        animatorSet.playTogether( animatorList );
        animatorSet.setStartDelay(startDelay); //ﾎﾟﾜﾝの後の間
        animatorSet.start();
    }

    private void puAnimate( View target ) {

        int startDelay = 2000;
        PropertyValuesHolder alpha = PropertyValuesHolder.ofFloat("alpha" , 0f , 1f);
        PropertyValuesHolder scaleX = PropertyValuesHolder.ofFloat("scaleX" , 0.9f , 1.5f);
        PropertyValuesHolder scaleY = PropertyValuesHolder.ofFloat("scaleY" , 0.9f , 1.5f);
        ObjectAnimator puAnimator = ObjectAnimator.ofPropertyValuesHolder(target,alpha,scaleX,scaleY);
        puAnimator.setDuration(100);
        puAnimator.setRepeatCount(1);
        puAnimator.setRepeatMode(Animation.RESTART);
        puAnimator.setStartDelay(startDelay);
        puAnimator.start();
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
