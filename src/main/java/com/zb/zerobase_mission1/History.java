package com.zb.zerobase_mission1;

public class History {
    String id;
    String lat;
    String lnt;
    String localTime;

    public History(String lat, String lnt, String localTime) {
        this.lat = lat;
        this.lnt = lnt;
        this.localTime = localTime;
    }

    public History(String id, String lat, String lnt, String localTime) {
        this.id = id;
        this.lat = lat;
        this.lnt = lnt;
        this.localTime = localTime;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLnt() {
        return lnt;
    }

    public void setLnt(String lnt) {
        this.lnt = lnt;
    }

    public String getLocalTime() {
        return localTime;
    }

    public void setLocalTime(String localTime) {
        this.localTime = localTime;
    }
}
