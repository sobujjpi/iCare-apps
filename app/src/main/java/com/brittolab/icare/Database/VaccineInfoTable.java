package com.brittolab.icare.Database;


public class VaccineInfoTable {

    private int vaccineId;
    private String vaccineName;
    private String vaccineDate;
    private String vaccineTime;
    private String vaccineDetails;
    private String vaccineAlert;
    private int refUserId;



    public VaccineInfoTable(int vaccineId, String vaccineName, String vaccineDate, String vaccineTime,
                            String vaccineDetails, String vaccineAlert, int refUserId) {
        this.vaccineId = vaccineId;
        this.vaccineName = vaccineName;
        this.vaccineDate = vaccineDate;
        this.vaccineTime = vaccineTime;
        this.vaccineDetails = vaccineDetails;
        this.vaccineAlert = vaccineAlert;
        this.refUserId = refUserId;

    }

    public VaccineInfoTable(int vaccineId, String vaccineName, String vaccineDate, String vaccineTime, String vaccineDetails, String vaccineAlert) {
        this.vaccineId = vaccineId;
        this.vaccineName = vaccineName;
        this.vaccineDate = vaccineDate;
        this.vaccineTime = vaccineTime;
        this.vaccineDetails = vaccineDetails;
        this.vaccineAlert = vaccineAlert;
    }

    public VaccineInfoTable(String vaccineName, String vaccineDate, String vaccineTime, String vaccineDetails, String vaccineAlert) {
        this.vaccineName = vaccineName;
        this.vaccineDate = vaccineDate;
        this.vaccineTime = vaccineTime;
        this.vaccineDetails = vaccineDetails;
        this.vaccineAlert = vaccineAlert;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public String getVaccineDate() {
        return vaccineDate;
    }

    public void setVaccineDate(String vaccineDate) {
        this.vaccineDate = vaccineDate;
    }

    public String getVaccineTime() {
        return vaccineTime;
    }

    public void setVaccineTime(String vaccineTime) {
        this.vaccineTime = vaccineTime;
    }

    public String getVaccineDetails() {
        return vaccineDetails;
    }

    public void setVaccineDetails(String vaccineDetails) {
        this.vaccineDetails = vaccineDetails;
    }

    public String getVaccineAlert() {
        return vaccineAlert;
    }

    public void setVaccineAlert(String vaccineAlert) {
        this.vaccineAlert = vaccineAlert;
    }

    public int getRefUserId() {
        return refUserId;
    }

    public void setRefUserId(int refUserId) {
        this.refUserId = refUserId;
    }

}
