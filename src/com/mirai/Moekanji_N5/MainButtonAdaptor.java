package com.mirai.Moekanji_N5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;

/**
 * Created with IntelliJ IDEA.
 * User: Weroth
 * Date: 6/1/13
 * Time: 12:19 PM
 * Image Adaptor for Main Menu. Fills the gridView with icon images.
 */
public class MainButtonAdaptor extends BaseAdapter {
    private Context mContext;

    // Gets the context to be used later
    public MainButtonAdaptor(Context c) {
        mContext = c;
    }

    // Keep the filenames of the images in an array
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
        Button btn;

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

        return btn;
    }
}
