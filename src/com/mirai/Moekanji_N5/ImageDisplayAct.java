package com.mirai.Moekanji_N5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import junit.framework.Assert;

/**
 * Created with IntelliJ IDEA.
 * User: Weroth
 * Date: 8/13/13
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */
public class ImageDisplayAct extends Activity {

    ImageView image;

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.kanji_imageview);

        image = (ImageView) findViewById(R.id.image);

        // Get string from the argument passed
        Intent intent = getIntent();
        //String imagePath = intent.getExtras().getString("image_path");

        String path = intent.getStringExtra("image_path");

        int resid = getDrawable(this, path);
        image.setImageResource(resid);


    }

    public static int getDrawable(Context context, String name)
    {
        Assert.assertNotNull(context);
        Assert.assertNotNull(name);

        String PACKAGE_NAME = context.getPackageName();

        return context.getResources().getIdentifier(name,
                "drawable", PACKAGE_NAME);
    }
}
