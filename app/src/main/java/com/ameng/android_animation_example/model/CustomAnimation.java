package com.ameng.android_animation_example.model;

import android.content.Context;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

/**
 * Created by ameng on 8/19/16.
 */
public class CustomAnimation {
    /**
     * animationAlpha 動畫透明度
     * animationScale 動畫縮放
     * animationTranslate 動畫移動
     * animationRotate 動畫旋轉
     */
    private Animation animationAlpha;
    private Animation animationScale;
    private Animation animationTranslate;
    private Animation animationRotate;
    private Context context;

    public CustomAnimation(Context context) {
        this.context = context;
    }

    public void setAnimationAlpha(float from, float to, int duration, int repeatCount, boolean fillAfter, int startOffset) {
        if (animationAlpha != null) {
            animationAlpha = null;
        }
        animationAlpha = new AlphaAnimation(from, to);
        animationAlpha.setDuration(duration);
        animationAlpha.setRepeatCount(repeatCount);
        animationAlpha.setFillAfter(fillAfter);
        animationAlpha.setStartOffset(startOffset);
    }

    public Animation getAlpha() {
        return animationAlpha;
    }
}
