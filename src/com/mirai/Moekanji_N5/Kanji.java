package com.mirai.Moekanji_N5;


/**
 * Created with IntelliJ IDEA.
 * User: Weroth
 * Date: 6/17/13
 * Time: 1:34 PM
 * To change this template use File | Settings | File Templates.
 */
public class Kanji {

    // private variables
    int id;
    int category_id;
    String imagepath;
    String kanji;
    String compkanji;
    String compkan_meaning;
    String kun;
    String on;
    String meaning;

    // empty constructor
    public Kanji() {

    }

    // constructor
    public Kanji(int id, int category_id, String imagepath, String kanji, String compkanji, String compkan_meaning, String kun, String on, String meaning){
        this.id = id;
        this.category_id = category_id;
        this.imagepath = imagepath;
        this.kanji = kanji;
        this.compkanji = compkanji;
        this.compkan_meaning = compkanji;
        this.kun = kun;
        this.on = on;
        this.meaning = meaning;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getimagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
    }

    public String getKanji() {
        return kanji;
    }

    public void setKanji(String kanji) {
        this.kanji = kanji;
    }

    public String getCompkanji() {
        return compkanji;
    }

    public void setCompkanji(String compkanji) {
        this.compkanji = compkanji;
    }

    public String getCompkan_meaning() {
        return compkan_meaning;
    }

    public void setCompkan_meaning(String compkan_meaning) {
        this.compkan_meaning = compkan_meaning;
    }

    public String getKun() {
        return kun;
    }

    public void setKun(String kun) {
        this.kun = kun;
    }

    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

}
