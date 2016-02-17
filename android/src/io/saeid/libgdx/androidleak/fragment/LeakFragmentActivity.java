package io.saeid.libgdx.androidleak.fragment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;

import io.saeid.libgdx.androidleak.R;


/**
 * @author Saeed Masoumi (s-masoumi@live.com)
 */
public class LeakFragmentActivity extends AppCompatActivity implements AndroidFragmentApplication.Callbacks {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.leak);
    }

    @Override
    public void exit() {

    }
}
