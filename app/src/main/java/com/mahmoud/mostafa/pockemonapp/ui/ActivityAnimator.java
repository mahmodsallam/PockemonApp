package com.mahmoud.mostafa.pockemonapp.ui;

import android.app.Activity;

import com.mahmoud.mostafa.pockemonapp.R;

public class ActivityAnimator {
    public void disappearBottomRightAnimation(Activity a) {
        a.overridePendingTransition(R.anim.disappear_bottom_right_in, R.anim.disappear_bottom_right_out);
    }

    public void appearBottomRightAnimation(Activity a) {
        a.overridePendingTransition(R.anim.appear_bottom_right_in, R.anim.appear_bottom_right_out);
    }


}
