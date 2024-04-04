package com.bitc.java404;

import java.util.List;

public class BoxOfficeResultDTO {
    private String boxOfficeType;
    private  String showRange;
    private List<DailyBoxOfficeItemDTO> dailyBoxOfficeList;

    public String getBoxOfficeType() {
        return boxOfficeType;
    }

    public void setBoxOfficeType(String boxOfficeType) {
        this.boxOfficeType = boxOfficeType;
    }

    public String getShowRange() {
        return showRange;
    }

    public void setShowRange(String showRange) {
        this.showRange = showRange;
    }

    public List<DailyBoxOfficeItemDTO> getDailyBoxOfficeList() {
        return dailyBoxOfficeList;
    }

    public void setDailyBoxOfficeList(List<DailyBoxOfficeItemDTO> dailyBoxOfficeList) {
        this.dailyBoxOfficeList = dailyBoxOfficeList;
    }
}
