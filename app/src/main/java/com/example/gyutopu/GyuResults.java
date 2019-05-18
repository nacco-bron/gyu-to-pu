package com.example.gyutopu;

import android.view.View;

import java.util.List;
import java.util.Random;

public class GyuResults {
    private final List<View> views;

    public GyuResults(List<View> views) {
        this.views = views;
    }

    public void showRandom() {
        View gyuResult = randomChoice();
        showOf(gyuResult);
    }

    private View randomChoice() {
        int index = new Random().nextInt(views.size());
        return views.get(index);
    }

    private void showOf(View gyuResult) {
        for (View item : views) {
            int visible = item == gyuResult ? View.VISIBLE : View.INVISIBLE;
            item.setVisibility(visible);
        }
    }
}
