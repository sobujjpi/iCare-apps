package com.brittolab.icare.Database;

/**
 * Created by Mobile App Develop on 19-1-16.
 */
public class EmergencyContactTable {

    private int emrgId;
    private String emrgName;
    private String relation;
    private String contactNo;
    private double refUserId;




    public EmergencyContactTable(int emrgId, String emrgName, String relation, String contactNo, int refUserId) {
        this.emrgId = emrgId;
        this.emrgName = emrgName;
        this.relation = relation;
        this.contactNo = contactNo;
        this.refUserId = refUserId;
    }

    public int getEmrgId() {
        return emrgId;
    }

    public void setEmrgId(int emrgId) {
        this.emrgId = emrgId;
    }

    public String getEmrgName() {
        return emrgName;
    }

    public void setEmrgName(String emrgName) {
        this.emrgName = emrgName;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public double getRefUserId() {
        return refUserId;
    }

    public void setRefUserId(double refUserId) {
        this.refUserId = refUserId;
    }
}
