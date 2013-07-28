package com.mirai.Moekanji_N5;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.*;

import java.util.List;

public class KanjiAct extends Activity {

    private Cursor kanjis;
    private KanjiDatabase kanjidb;
    private Context mContext;

    /**
     * Called when the activity is selected.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kanji_listview);

        final ListView listview = (ListView) findViewById(R.id.lvKanjiList);


        KanjiDatabase kanjiDB = new KanjiDatabase(this);

        List<Kanji> kanlist = kanjiDB.getAllKanji();

        String kanji = kanlist.get(0).getKanji();

        String[] values = new String[] { "Android",  "Windows7",
                "Android", "iPhone", "WindowsMobile" };

        //TODO - Make the Kanji List with at least 2 kanjis in each category

        //Pass List of Kanji to Adaptor
        final KanjiArrayAdapter kanAdapt = new KanjiArrayAdapter(this, values);

        // Assign adapter to ListView
        listview.setAdapter(kanAdapt);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> kanAdapt, View listView,
                                    int position, long id) {
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();
            }
        });

        // Test button press
        //Toast my_toast = Toast.makeText(mContext, btn.getText() + " " + btn.getId() +  " was pressed!", Toast.LENGTH_LONG);
        //my_toast.setGravity(Gravity.CENTER, 0, 0);
        // my_toast.show();

    }


}
