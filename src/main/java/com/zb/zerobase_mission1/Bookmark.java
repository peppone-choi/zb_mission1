package com.zb.zerobase_mission1;

public class Bookmark {
    private int bookmarkId;
    private String bookmarkGroupName;
    private String bookmarkWifiName;
    private String bookmarkDay;

    public Bookmark(int bookmarkId, String bookmarkGroupName, String bookmarkWifiName, String bookmarkDay) {
        this.bookmarkId = bookmarkId;
        this.bookmarkGroupName = bookmarkGroupName;
        this.bookmarkWifiName = bookmarkWifiName;
        this.bookmarkDay = bookmarkDay;
    }

    public int getBookmarkId() {
        return bookmarkId;
    }

    public void setBookmarkId(int bookmarkId) {
        this.bookmarkId = bookmarkId;
    }

    public String getBookmarkGroupName() {
        return bookmarkGroupName;
    }

    public void setBookmarkGroupName(String bookmarkGroupName) {
        this.bookmarkGroupName = bookmarkGroupName;
    }

    public String getBookmarkWifiName() {
        return bookmarkWifiName;
    }

    public void setBookmarkWifiName(String bookmarkWifiName) {
        this.bookmarkWifiName = bookmarkWifiName;
    }

    public String getBookmarkDay() {
        return bookmarkDay;
    }

    public void setBookmarkDay(String bookmarkDay) {
        this.bookmarkDay = bookmarkDay;
    }
}
