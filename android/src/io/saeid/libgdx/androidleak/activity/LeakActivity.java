package io.saeid.libgdx.androidleak.activity;

import android.os.Bundle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.squareup.leakcanary.RefWatcher;

import io.saeid.libgdx.androidleak.LeakApplication;
import io.saeid.libgdx.leak.MyGdxGame;

public class LeakActivity extends AndroidApplication {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        initialize(new MyGdxGame(), config);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        whatShouldBeDoneOnSuperMethod();
        RefWatcher refWatcher = LeakApplication.getRefWatcher(this);
        refWatcher.watch(this);
    }

    private void whatShouldBeDoneOnSuperMethod() {
        Gdx.app = null;
        Gdx.input = null;
        Gdx.audio = null;
        Gdx.files = null;
        Gdx.graphics = null;
        Gdx.net = null;
    }
}
