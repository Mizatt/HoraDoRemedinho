package projetodiego.unimep.com.br.projetodiego.modelo;

import java.io.Serializable;

public class Remedio implements Serializable {
    private int id;
    private String nomeDoRemedio;

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    private boolean marcado;

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

//Nessa área ele retorna os dados sobre os remédios cadastrados. TEM QUE DEIXAR MAIS BIURI
    @Override
    public String toString() {
        return this.id + ": " + this.nomeDoRemedio;
    }
}
