package com.mahmoud.mostafa.pockemonapp.base;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;

import com.mahmoud.mostafa.pockemonapp.R;

public class BaseActivity extends AppCompatActivity {
    public void disappearBottomRightAnimation(Activity a) {
        a.overridePendingTransition(R.anim.disappear_bottom_right_in, R.anim.disappear_bottom_right_out);
    }

    public void appearBottomRightAnimation(Activity a) {
        a.overridePendingTransition(R.anim.appear_bottom_right_in, R.anim.appear_bottom_right_out);
    }
}
