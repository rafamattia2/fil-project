package rafamattia.liwproject.models;

public class TaskConsume {
    private int taskId;
    private int materialId;
    private int quantityUsed;
    private float value;

    public TaskConsume(){
        quantityUsed = 0;
        value = 0f;
    }
    public TaskConsume(int taskId, int materialId, int quantityUsed, float value) {
        this.taskId = taskId;
        this.materialId = materialId;
        this.quantityUsed = quantityUsed;
        this.value = value;
    }

    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getMaterialId() {
        return materialId;
    }

    public void setMaterialId(int materialId) {
        this.materialId = materialId;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }

    public void setQuantityUsed(int quantityUsed) {
        this.quantityUsed = quantityUsed;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
