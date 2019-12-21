package nju.se.rfid.bean;

import java.util.Date;

public class Product {
    private Integer productId;
    private String casId;
    private Integer batchId;
    private String productName;
    private Date createDate;
    private Integer companyId;

    public String getCasId() {
        return casId;
    }

    public void setCasId(String casId) {
        this.casId = casId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getBatchId() {
        return batchId;
    }

    public void setBatchId(Integer batchId) {
        this.batchId = batchId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", casId='" + casId + '\'' +
                ", batchId=" + batchId +
                ", productName='" + productName + '\'' +
                ", createDate=" + createDate +
                ", companyId=" + companyId +
                '}';
    }
}
