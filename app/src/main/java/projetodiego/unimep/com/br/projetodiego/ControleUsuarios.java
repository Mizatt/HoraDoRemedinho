package projetodiego.unimep.com.br.projetodiego;

import android.widget.EditText;

import projetodiego.unimep.com.br.projetodiego.modelo.Usuario;

public class ControleUsuarios {
    private final EditText nomeUsuario;
    private final EditText emailUsuario;
    private final EditText senhaUsuario;

    private Usuario var_usuario;

    public ControleUsuarios(CadastroUsuario activity) {
        nomeUsuario = (EditText) activity.findViewById(R.id.NomeUsuario);
        emailUsuario = (EditText) activity.findViewById(R.id.EmailUsuario);
        senhaUsuario = (EditText) activity.findViewById(R.id.confirmaSenha);
        var_usuario = new Usuario();
    }

    public Usuario getControleUsuarios() {
        var_usuario.setNomeUsuario(nomeUsuario.getText().toString());
        var_usuario.setEmailUsuario(emailUsuario.getText().toString());
        var_usuario.setSenhaUsuario(senhaUsuario.getText().toString());
        return var_usuario;
    }

}
