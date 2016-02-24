package com.brittolab.icare.Database;

/**
 * Created by Mobile App Develop on 19-1-16.
 */
public class HospitalInfoTable {


        private int hospitalID;
        private String hospitalName;
        private String HospitalAddress;
        private String hospitalPhone;
        private double refUserId;


    public HospitalInfoTable(int hospitalID, String hospitalName, String HospitalAddress, String hospitalPhone,int refUserId) {
            this.hospitalName = hospitalName;
            this.HospitalAddress = HospitalAddress;
            this.hospitalPhone = hospitalPhone;
            this.refUserId = refUserId;
        }
    public int getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(int hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getHospitalAddress() {
        return HospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        HospitalAddress = hospitalAddress;
    }

    public String getHospitalPhone() {
        return hospitalPhone;
    }

    public void setHospitalPhone(String hospitalPhone) {
        this.hospitalPhone = hospitalPhone;
    }

    public double getRefUserId() {
        return refUserId;
    }

    public void setRefUserId(double refUserId) {
        this.refUserId = refUserId;
    }


    }
