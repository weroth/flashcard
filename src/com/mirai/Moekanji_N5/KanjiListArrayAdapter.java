package com.mirai.Moekanji_N5;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * User: Weroth
 * Date: 7/28/13
 * Time: 8:44 PM
 * Creates Array Adapter for KanjiAct.
 */
public class KanjiListArrayAdapter extends ArrayAdapter<Item> {
    private final Context context;
    private ArrayList<Item> items;
    private LayoutInflater vi;

    public KanjiListArrayAdapter(Context context, ArrayList<Item> items) {
        super(context, R.layout.list_item, items);
        this.context = context;
        this.items = items;
        vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        final Item i = items.get(position);
        if (i != null) {
            if(i.isSection()){
                // Section
                SectionItem si = (SectionItem)i;
                v = vi.inflate(R.layout.list_section, null);

                v.setOnClickListener(null);
                v.setOnLongClickListener(null);
                v.setLongClickable(false);

                final TextView sectionView = (TextView) v.findViewById(R.id.list_item_section_text);
                sectionView.setText(si.getTitle());
            }else{
                // Item
                EntryItem ei = (EntryItem)i;
                v = vi.inflate(R.layout.list_item, null);
                final TextView title = (TextView)v.findViewById(R.id.tvHiragana);
                final TextView subtitle = (TextView)v.findViewById(R.id.tvEngword);

                if (title != null)
                    title.setText(ei.hiragana);
                if(subtitle != null)
                    subtitle.setText(ei.eng_meaning);
            }
        }
        return v;
    }

}
