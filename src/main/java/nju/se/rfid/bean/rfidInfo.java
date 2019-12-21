package nju.se.rfid.bean;

import java.util.ArrayList;

public class rfidInfo {
    private String cas_id;
    private Integer batch_id;
    private ArrayList<Integer> operateInfo;

    public String getCas_id() {
        return cas_id;
    }

    public void setCas_id(String cas_id) {
        this.cas_id = cas_id;
    }

    public Integer getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(Integer batch_id) {
        this.batch_id = batch_id;
    }

    public ArrayList<Integer> getOperateInfo() {
        return operateInfo;
    }

    public void setOperateInfo(ArrayList<Integer> operateInfo) {
        this.operateInfo = operateInfo;
    }
}
