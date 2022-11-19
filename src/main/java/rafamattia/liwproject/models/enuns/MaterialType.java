package rafamattia.liwproject.models.enuns;

public enum MaterialType {
    TUBO_QUADRADO(0, "TUBO QUADRADO"), TUBO_REDONDO(1, "TUBO REDONDO"), BARRA_QUADRADA(2, "BARRA QUADRADA"), BARRA_REDONDA(3, "BARRA REDONDA"),
    CHAPA(4, "CHAPA"), TELA(5, "TELA");

    private Integer cod;
    private String description;

    MaterialType(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public static MaterialType toEnum(Integer cod) {
        if (cod == null){
            return null;
        }

        for (MaterialType x: MaterialType.values()) {
            if (cod.equals(x.getCod())){
                return x;
            }
        }
        throw new IllegalArgumentException("Status "+ cod +" é inválido!");
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }
}
