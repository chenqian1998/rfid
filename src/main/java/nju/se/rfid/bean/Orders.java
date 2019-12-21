package nju.se.rfid.bean;

import java.util.Date;

public class Orders {
    private Integer orderId;
    private Integer productId;
    private Double weight;
    private Date createDate;
    private Integer status;
    private Integer createCompany;
    private Integer sendCompany;
    private Integer receiveCompany;
    private Integer destoryCompany;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateCompany() {
        return createCompany;
    }

    public void setCreateCompany(Integer createCompany) {
        this.createCompany = createCompany;
    }

    public Integer getSendCompany() {
        return sendCompany;
    }

    public void setSendCompany(Integer sendCompany) {
        this.sendCompany = sendCompany;
    }

    public Integer getReceiveCompany() {
        return receiveCompany;
    }

    public void setReceiveCompany(Integer receiveCompany) {
        this.receiveCompany = receiveCompany;
    }


    public Integer getDestoryCompany() {
        return destoryCompany;
    }

    public void setDestoryCompany(Integer destoryCompany) {
        this.destoryCompany = destoryCompany;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", productId=" + productId +
                ", weight=" + weight +
                ", createDate=" + createDate +
                ", status=" + status +
                ", createCompany=" + createCompany +
                ", sendCompany=" + sendCompany +
                ", receiveCompany=" + receiveCompany +
                ", destoryCompany=" + destoryCompany +
                '}';
    }

}
