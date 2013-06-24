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
    int _id;
    int _category_id;
    String _imagepath;
    String _kanji;
    String _compkanji;
    String _compkan_meaning;
    String _kun;
    String _on;
    String _meaning;

    // empty constructor
    public Kanji() {

    }

    // constructor
    public Kanji(int id, int category_id, String imagepath, String kanji, String compkanji, String compkan_meaning, String kun, String on, String meaning){
        this._id = id;
        this._category_id = category_id;
        this._imagepath = imagepath;
        this._kanji = kanji;
        this._compkanji = compkanji;
        this._compkan_meaning = compkanji;
        this._kun = kun;
        this._on = on;
        this._meaning = meaning;

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_category_id() {
        return _category_id;
    }

    public void set_category_id(int _category_id) {
        this._category_id = _category_id;
    }

    public String get_imagepath() {
        return _imagepath;
    }

    public void set_imagepath(String _imagepath) {
        this._imagepath = _imagepath;
    }

    public String get_kanji() {
        return _kanji;
    }

    public void set_kanji(String _kanji) {
        this._kanji = _kanji;
    }

    public String get_compkanji() {
        return _compkanji;
    }

    public void set_compkanji(String _compkanji) {
        this._compkanji = _compkanji;
    }

    public String get_compkan_meaning() {
        return _compkan_meaning;
    }

    public void set_compkan_meaning(String _compkan_meaning) {
        this._compkan_meaning = _compkan_meaning;
    }

    public String get_kun() {
        return _kun;
    }

    public void set_kun(String _kun) {
        this._kun = _kun;
    }

    public String get_on() {
        return _on;
    }

    public void set_on(String _on) {
        this._on = _on;
    }

    public String get_meaning() {
        return _meaning;
    }

    public void set_meaning(String _meaning) {
        this._meaning = _meaning;
    }




}
