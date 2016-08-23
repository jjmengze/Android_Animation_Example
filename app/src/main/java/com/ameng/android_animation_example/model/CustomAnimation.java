package com.ameng.android_animation_example.model;

import android.content.Context;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;

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

    /**
     * 透明度動畫
     *
     * @param from        開始的透明度
     * @param to          結束的透明度
     * @param duration    動畫執行時間
     * @param repeatCount 重覆動畫次數
     * @param fillAfter   動畫執行完是否停留在執行的狀態
     * @param startOffset 執行前的等待時間
     */
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

    /**
     * 大小縮放動畫
     *
     * @param fromX       開始 X的大小
     * @param toX         結束 X的大小
     * @param fromY       開始 Y的大小
     * @param toY         結束 Y的大小
     * @param duration    動畫執行時間
     * @param repeatCount 重覆動畫次數
     * @param fillAfter   動畫執行完是否停留在執行的狀態
     * @param startOffset 執行前的等待時間
     */
    public void setAnimationScale(float fromX, float toX, float fromY, float toY, int duration, int repeatCount, boolean fillAfter, int startOffset) {
        if (animationScale != null) {
            animationScale = null;
        }
        animationScale = new ScaleAnimation(fromX, toX, fromY, toY,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        animationScale.setDuration(duration);
        animationScale.setRepeatCount(repeatCount);
        animationScale.setFillAfter(fillAfter);
        animationScale.setStartOffset(startOffset);
    }

    public Animation getAnimationAlpha() {
        return animationAlpha;
    }

    public Animation getAnimationScale() {
        return animationAlpha;
    }
}
