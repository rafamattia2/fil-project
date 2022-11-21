package rafamattia.liwproject.models;

public class Wage {
    protected int id;
    protected int idEmployee;
    protected float value;

    public Wage(){
        this.idEmployee=0;
        this.value=0;
    }
    public Wage(int idEmployee, float value) {
        this.idEmployee = idEmployee;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
