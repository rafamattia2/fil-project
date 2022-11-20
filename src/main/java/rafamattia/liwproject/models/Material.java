package rafamattia.liwproject.models;

import rafamattia.liwproject.models.enuns.MaterialType;

public class Material {
    private int id;
    private int id_stock;
    private String name;
    private MaterialType type;
    private String measurements;
    private int amount;
    private float value;

    public Material() {
        this.id_stock = 0;
        this.name = null;
        this.type = null;
        this.measurements = null;
        this.amount = 0;
        this.value = 0;
    }
    public Material(int id_stock, String name, MaterialType type, String measurements, int amount, float value) {
        this.id_stock = id_stock;
        this.name = name;
        this.type = type;
        this.measurements = measurements;
        this.amount = amount;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_stock() {
        return id_stock;
    }

    public void setId_stock(int id_stock) {
        this.id_stock = id_stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaterialType getType() {
        return type;
    }

    public void setType(MaterialType type) {
        this.type = type;
    }

    public String getMeasurements() {
        return measurements;
    }

    public void setMeasurements(String measurments) {
        this.measurements = measurments;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
