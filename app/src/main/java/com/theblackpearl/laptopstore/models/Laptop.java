package com.theblackpearl.laptopstore.models;

public class Laptop {
    int id;
    String manufacturer ;
    String model;
    String GPU;
    String CPU;
    String RAM;
    String HARD_TYPE;
    String HARD_SIZE;
    String IMAGE ;

    public Laptop(int id, String manufacturer, String model, String GPU, String CPU, String RAM, String HARD_TYPE, String HARD_SIZE, String IMAGE) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.GPU = GPU;
        this.CPU = CPU;
        this.RAM = RAM;
        this.HARD_TYPE = HARD_TYPE;
        this.HARD_SIZE = HARD_SIZE;
        this.IMAGE = IMAGE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public String getHARD_TYPE() {
        return HARD_TYPE;
    }

    public void setHARD_TYPE(String HARD_TYPE) {
        this.HARD_TYPE = HARD_TYPE;
    }

    public String getHARD_SIZE() {
        return HARD_SIZE;
    }

    public void setHARD_SIZE(String HARD_SIZE) {
        this.HARD_SIZE = HARD_SIZE;
    }

    public String getIMAGE() {
        return IMAGE;
    }

    public void setIMAGE(String IMAGE) {
        this.IMAGE = IMAGE;
    }
}

