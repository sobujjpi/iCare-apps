package com.brittolab.icare.Database;


public class DietInfoTable {
    private int dietId;
    private String dietType;
    private String foodMenu;
    private String alermDate;
    private String alermTime;
    private String UserId;




    public DietInfoTable(int dietId, String dietType, String foodMenu, String alermDate, String alermTime, String refUserId) {
        this.dietId = dietId;
        this.dietType = dietType;
        this.foodMenu = foodMenu;
        this.alermDate = alermDate;
        this.alermTime = alermTime;
        this.UserId = UserId;

    }

    public DietInfoTable(int dietId, String dietType, String foodMenu, String alermDate, String alermTime) {
        this.dietId = dietId;
        this.dietType = dietType;
        this.foodMenu = foodMenu;
        this.alermDate = alermDate;
        this.alermTime = alermTime;
    }

    public DietInfoTable(String dietType, String foodMenu, String alermDate, String alermTime) {
        this.dietType = dietType;
        this.foodMenu = foodMenu;
        this.alermDate = alermDate;
        this.alermTime = alermTime;
    }

    public DietInfoTable(String foodMenu, String alermDate, String alermTime) {
        this.foodMenu = foodMenu;
        this.alermDate = alermDate;
        this.alermTime = alermTime;
    }

    public int getDietId() {
        return dietId;
    }

    public void setDietId(int dietId) {
        this.dietId = dietId;
    }

    public String getDietType() {
        return dietType;
    }

    public void setDietType(String dietType) {
        this.dietType = dietType;
    }

    public String getFoodMenu() {
        return foodMenu;
    }

    public void setFoodMenu(String foodMenu) {
        this.foodMenu = foodMenu;
    }

    public String getAlermDate() {
        return alermDate;
    }

    public void setAlermDate(String alermDate) {
        this.alermDate = alermDate;
    }

    public String getAlermTime() {
        return alermTime;
    }

    public void setAlermTime(String alermTime) {
        this.alermTime = alermTime;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }


}

