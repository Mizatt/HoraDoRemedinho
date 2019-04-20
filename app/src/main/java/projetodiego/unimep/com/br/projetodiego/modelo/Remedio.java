package projetodiego.unimep.com.br.projetodiego.modelo;

import java.io.Serializable;

public class Remedio implements Serializable {
    private int id;
    private String nomeDoRemedio;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDoRemedio() {
        return nomeDoRemedio;
    }

    public void setNomeDoRemedio(String nomeDoRemedio) {
        this.nomeDoRemedio = nomeDoRemedio;
    }


    @Override
    public String toString() {
        return this.id + ": " + this.nomeDoRemedio;
    }
}
