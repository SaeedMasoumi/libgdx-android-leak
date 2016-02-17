package io.saeid.libgdx.androidleak;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.saeid.libgdx.androidleak.activity.LeakActivity;
import io.saeid.libgdx.androidleak.fragment.LeakFragmentActivity;


public class AndroidLauncher extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AndroidLauncher.this, LeakFragmentActivity.class));
            }
        });
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AndroidLauncher.this, LeakActivity.class));
            }
        });
    }
}
