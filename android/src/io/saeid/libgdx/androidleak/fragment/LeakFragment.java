package io.saeid.libgdx.androidleak.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidFragmentApplication;
import com.squareup.leakcanary.RefWatcher;

import io.saeid.libgdx.androidleak.LeakApplication;
import io.saeid.libgdx.leak.MyGdxGame;

/**
 * @author Saeed Masoumi (s-masoumi@live.com)
 */
public class LeakFragment extends AndroidFragmentApplication implements AndroidFragmentApplication.Callbacks {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        return initializeForView(new MyGdxGame(), config);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        whatShouldBeDoneOnSuperMethod();
    }

    private void whatShouldBeDoneOnSuperMethod() {
        Gdx.app = null;
        Gdx.input = null;
        Gdx.audio = null;
        Gdx.files = null;
        Gdx.graphics = null;
        Gdx.net = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        System.out.println("OnDestroy Called!!!");
        RefWatcher refWatcher = LeakApplication.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }


}
