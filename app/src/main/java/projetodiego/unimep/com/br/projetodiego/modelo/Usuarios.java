package projetodiego.unimep.com.br.projetodiego.modelo;

import java.io.Serializable;

public class Usuarios implements Serializable {
    private  int id;
    private String NomeUsuario;
    private String EmailUsuario;
    private  String SenhaUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return NomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        NomeUsuario = nomeUsuario;
    }

    public String getEmailUsuario() {
        return EmailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        EmailUsuario = emailUsuario;
    }

    public String getSenhaUsuario() {
        return SenhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        SenhaUsuario = senhaUsuario;
    }
}
