package projetodiego.unimep.com.br.projetodiego.modelo;

import java.io.Serializable;

public class Remedios implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRemedio() {
        return Remedio;
    }

    public void setRemedio(String remedio) {
        Remedio = remedio;
    }

    private int id;
    private String Remedio;

    @Override
    public String toString() {
        return this.id + ": " + this.Remedio;
    }
}
