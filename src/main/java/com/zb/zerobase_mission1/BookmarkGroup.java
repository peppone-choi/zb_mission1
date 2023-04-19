package com.zb.zerobase_mission1;

public class BookmarkGroup {
    private int bookmarkGroupId;

    private String bookmarkGroupName;

    private int order;

    private String bookmarkGroupMakeDay;

    private String BookmarkGroupCorrectionDay;

    public BookmarkGroup(int bookmarkGroupId, String bookmarkGroupName, int order, String bookmarkGroupMakeDay, String bookmarkGroupCorrectionDay) {
        this.bookmarkGroupId = bookmarkGroupId;
        this.bookmarkGroupName = bookmarkGroupName;
        this.order = order;
        this.bookmarkGroupMakeDay = bookmarkGroupMakeDay;
        BookmarkGroupCorrectionDay = bookmarkGroupCorrectionDay;
    }

    public int getBookmarkGroupId() {
        return bookmarkGroupId;
    }

    public void setBookmarkGroupId(int bookmarkGroupId) {
        this.bookmarkGroupId = bookmarkGroupId;
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

    public String getBookmarkGroupCorrectionDay() {
        return BookmarkGroupCorrectionDay;
    }

    public void setBookmarkGroupCorrectionDay(String bookmarkGroupCorrectionDay) {
        BookmarkGroupCorrectionDay = bookmarkGroupCorrectionDay;
    }
}
