package projetodiego.unimep.com.br.projetodiego;

import android.widget.EditText;

import projetodiego.unimep.com.br.projetodiego.modelo.Usuario;

public class ControleUsuarios {
    private final EditText NomeUsuario;
    private final EditText EmailUsuario;
    private final EditText SenhaUsuario;

    private Usuario var_usuario;

    public ControleUsuarios(CadastroUsuario activity) {
        NomeUsuario = (EditText) activity.findViewById(R.id.NomeUsuario);
        EmailUsuario = (EditText) activity.findViewById(R.id.EmailUsuario);
        SenhaUsuario = (EditText) activity.findViewById(R.id.SenhaUsuario);
        var_usuario = new Usuario();
    }

    public Usuario getControleUsuarios() {
        var_usuario.setNomeUsuario(NomeUsuario.getText().toString());
        var_usuario.setEmailUsuario(EmailUsuario.getText().toString());
        var_usuario.setSenhaUsuario(SenhaUsuario.getText().toString());
        return var_usuario;
    }

}
