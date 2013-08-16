package com.mirai.Moekanji_N5;


public class EntryItem implements Item{

    public final String thumbnail_path;
	public final String hiragana;
	public final String eng_meaning;
    public final String image_path;


	public EntryItem(String thumbnail_path, String hiragana, String eng_meaning, String image_path) {
		this.thumbnail_path = thumbnail_path;
        this.hiragana = hiragana;
		this.eng_meaning = eng_meaning;
        this.image_path = image_path;
	}
	
	@Override
	public boolean isSection() {
		return false;
	}

}
