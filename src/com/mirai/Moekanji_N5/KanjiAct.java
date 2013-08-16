package com.mirai.Moekanji_N5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class KanjiAct extends Activity {

    private Cursor kanjis;
    private KanjiDatabase kanjidb;
    private Context mContext;
    ArrayList<Item> items = new ArrayList<Item>();

    /**
     * Called when the activity is selected.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kanji_listview);

        final ListView listview = (ListView) findViewById(R.id.lvKanjiList);

        // 2 lists - List<Kanji> for displaying kanji
        //           ArrayList<Item> for displaying the list of kanji

        KanjiDatabase kanjiDB = new KanjiDatabase(this);

        // Copy again for testing to update database
        kanjiDB.copyDatabase();

        List<Kanji> kanlist = kanjiDB.getAllKanji();

        //String kanji = kanlist.get(0).getKanji();

//        String[] values = new String[] { "Android",  "Windows7",
//                "Android", "iPhone", "WindowsMobile" };

        // Add a section

        ArrayList items = new ArrayList();
        // read from List<Kanji>
        int i = 0;
        int tmpcat = 0;
        String sectionCat;
        while (i < kanlist.size()) {
            Kanji kanji0 = kanlist.get(i);

            // tmpcat has no category or different than the kanji category
            if (tmpcat == 0 || tmpcat != kanji0.category_id)
            {
                tmpcat = kanji0.category_id;
                sectionCat = getKanjiCategory(tmpcat);

                // Add Section Item
                items.add(new SectionItem(sectionCat));

            }
            else
            {
                // Same category so add kanji as Entry Item
                items.add(new EntryItem("", kanji0.on, kanji0.meaning, kanji0.kanji));
                i++;
            }


        }
//
//        items.add(new EntryItem("", "Item 2", "This is item 1.2", ""));
//        items.add(new EntryItem("", "Item 3", "This is item 1.3", ""));
//
//        items.add(new SectionItem("あいうえお"));
//        items.add(new EntryItem("", "Item 4", "This is item 2.1", ""));
//        items.add(new EntryItem("", "Item 5", "This is item 2.2", ""));
//        items.add(new EntryItem("", "Item 6", "This is item 2.3", ""));
//        items.add(new EntryItem("", "Item 7", "This is item 2.4", ""));

        //Pass List of Kanji to Adaptor
        final KanjiListArrayAdapter kanAdapt = new KanjiListArrayAdapter(this, items);

        // Assign adapter to ListView
        listview.setAdapter(kanAdapt);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> kanAdapt, View listView,
                                    int position, long id) {
                Intent intent = new Intent(KanjiAct.this, ImageDisplayAct.class);

                EntryItem ei = (EntryItem) kanAdapt.getItemAtPosition(position);
                // Get image_path
                String pth = ei.image_path;
                intent.putExtra("image_path", pth);

                startActivity(intent);

                //intent = new Intent(this, ImageDisplayAct.class);

//                Toast.makeText(getApplicationContext(),
//                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
//                        .show();
            }
        });

    }

    // Get the kanji category
    private String getKanjiCategory(int tmpcat) {
        String category = "";

        switch (tmpcat) {
            case 1:  category = "あ　い　う　え　お";
                break;
            case 2:  category = "か　き　く　け　こ";
                break;
            case 3:  category = "さ　ひ　す　せ　そ";
                break;
            case 4:  category = "た　ち　つ　て　と";
                break;
            case 5:  category = "な　に　ぬ　ね　の";
                break;
            case 6:  category = "は　ひ　ふ　へ　ほ";
                break;
            case 7:  category = "ま　み　む　め　も";
                break;
            case 8:  category = "や　ゆ　よ";
                break;
            case 9:  category = "ら　り　る　れ　ろ";
                break;
            case 10:  category = "わ　を";
                break;
            case 11:  category = "ん";
                break;
            case 12:  category = "が　ぎ　ぐ　げ　ご";
                break;
            case 13:  category = "ざ　じ　ず　ぜ　ぞ";
                break;
            case 14:  category = "だ　ぢ　づ　で　ど";
                break;
            case 15:  category = "ば　び　ぶ　べ　ぼ";
                break;
            case 16:  category = "ぱ　ぴ　ぷ　ぺ　ぽ";
                break;
        }
        return category;

    }


}
