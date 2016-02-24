package com.brittolab.icare.Database;

import java.sql.Blob;

/**
 * Created by Mobile App Develop on 19-1-16.
 */
public class MedicalRecordTable {

    private int medRecId;
    private String visitDate;
    private String problemSummary;
    private Blob prescriptionPhoto;
    private int refUserId;
    private int refDrId;



    public MedicalRecordTable(int medRecId, String visitDate, String problemSummary, Blob prescriptionPhoto, int refUserId, int refDrId) {
        this.medRecId = medRecId;
        this.visitDate = visitDate;
        this.problemSummary = problemSummary;
        this.prescriptionPhoto = prescriptionPhoto;
        this.refUserId = refUserId;
        this.refDrId = refDrId;
    }

    public int getMedRecId() {
        return medRecId;
    }

    public void setMedRecId(int medRecId) {
        this.medRecId = medRecId;
    }

    public String getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(String visitDate) {
        this.visitDate = visitDate;
    }

    public String getProblemSummary() {
        return problemSummary;
    }

    public void setProblemSummary(String problemSummary) {
        this.problemSummary = problemSummary;
    }

    public Blob getPrescriptionPhoto() {
        return prescriptionPhoto;
    }

    public void setPrescriptionPhoto(Blob prescriptionPhoto) {
        this.prescriptionPhoto = prescriptionPhoto;
    }

    public int getRefUserId() {
        return refUserId;
    }

    public void setRefUserId(int refUserId) {
        this.refUserId = refUserId;
    }

    public int getRefDrId() {
        return refDrId;
    }

    public void setRefDrId(int refDrId) {
        this.refDrId = refDrId;
    }

}
