package com.bitc.java404;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "body")
public class PharmacyBodyDTO {
    private int noOfRows;
    private int pageNo;
    private int totalCount;
    private PharmacyItemsDTO items;

    @XmlElement
    public int getNoOfRows() {
        return noOfRows;
    }

    public void setNoOfRows(int noOfRows) {
        this.noOfRows = noOfRows;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    @XmlElement(name = "items")
    public PharmacyItemsDTO getItems() {
        return items;
    }

    public void setItems(PharmacyItemsDTO items) {
        this.items = items;
    }
}
