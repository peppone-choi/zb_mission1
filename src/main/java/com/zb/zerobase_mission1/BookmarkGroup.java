package com.zb.zerobase_mission1;

public class BookmarkGroup {
    private int bookmarkId;

    private String bookmarkGroupName;

    private int order;

    private String bookmarkGroupMakeDay;

    private String BookmartGroupCorrectionDay;


    public BookmarkGroup(int bookmarkId, String bookmarkGroupName, int order, String bookmarkGroupMakeDay, String bookmartGroupCorrectionDay) {
        this.bookmarkId = bookmarkId;
        this.bookmarkGroupName = bookmarkGroupName;
        this.order = order;
        this.bookmarkGroupMakeDay = bookmarkGroupMakeDay;
        BookmartGroupCorrectionDay = bookmartGroupCorrectionDay;
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

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getBookmarkGroupMakeDay() {
        return bookmarkGroupMakeDay;
    }

    public void setBookmarkGroupMakeDay(String bookmarkGroupMakeDay) {
        this.bookmarkGroupMakeDay = bookmarkGroupMakeDay;
    }

    public String getBookmartGroupCorrectionDay() {
        return BookmartGroupCorrectionDay;
    }

    public void setBookmartGroupCorrectionDay(String bookmartGroupCorrectionDay) {
        BookmartGroupCorrectionDay = bookmartGroupCorrectionDay;
    }
}
