package com.mirai.Moekanji_N5;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class MainAct extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        GridView gridview = (GridView) findViewById(R.id.maingrid);
        gridview.setAdapter(new MainButtonAdapter(this));

    }

}
