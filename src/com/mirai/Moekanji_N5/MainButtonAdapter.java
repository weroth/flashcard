package com.mirai.Moekanji_N5;

import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: Weroth
 * Date: 6/1/13
 * Time: 12:19 PM
 * Image Adaptor for Main Menu. Dynamically fills the gridView with icon images.
 */
public class MainButtonAdapter extends BaseAdapter {
    private Context mContext;

    // Gets the context to be used later
    public MainButtonAdapter(Context c) {
        mContext = c;
    }

    // Keep the file names of the images in an array
    public String[] filenames = {
            "menu_viewsingle",
            "menu_viewcomp",
            "menu_help"
    };

    // Total of buttons stored
    public int getCount() {
        return filenames.length;
    }

    // Require for structure
    public Object getItem(int position) {
        return null;
    }

    //
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Button btn;

        if (convertView == null)
        {
            // if it's not recycled, initialise some attributes
            btn = new Button(mContext);
            btn.setLayoutParams(new GridView.LayoutParams(100,55));
            btn.setPadding(8,8,8,8);
        }
        else
        {
            btn = (Button) convertView;
        }
        // imageView.setImageResource(mThumbIds[position]);
        //cb.setText("Button #"+Integer.toString(i));
        btn.setBackgroundResource(R.drawable.ic_launcher);
        btn.setText(filenames[position]);
        btn.setId(position);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = null;
                switch(btn.getId()) {
                    case(0):
                        intent = new Intent(mContext, KanjiAct.class);

                    case(1):
                    case(2):

                }

                if (intent != null) mContext.startActivity(intent);

                // Test button press
                Toast my_toast = Toast.makeText(mContext, btn.getText() + " " + btn.getId() +  " was pressed!", Toast.LENGTH_LONG);
                //my_toast.setGravity(Gravity.CENTER, 0, 0);
                my_toast.show();
            }
        });

        return btn;
    }


}
