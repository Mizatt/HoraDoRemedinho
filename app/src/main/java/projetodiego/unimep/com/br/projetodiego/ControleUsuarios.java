package projetodiego.unimep.com.br.projetodiego;

import android.widget.EditText;

import projetodiego.unimep.com.br.projetodiego.modelo.Usuarios;

public class ControleUsuarios {
    private  final EditText NomeUsuario;
    private final EditText EmailUsuario;
    private final EditText SenhaUsuario;

    private Usuarios var_usuarios;

    public ControleUsuarios(CadastroUsuario activity) {
        NomeUsuario =(EditText)activity.findViewById(R.id.NomeUsuario);
        EmailUsuario = (EditText)activity.findViewById(R.id.EmailUsuario);
        SenhaUsuario = (EditText)activity.findViewById(R.id.SenhaUsuario);
        var_usuarios =new Usuarios();
    }

    public Usuarios getControleUsuarios() {
        var_usuarios.setNomeUsuario(NomeUsuario.getText().toString());
        var_usuarios.setEmailUsuario(EmailUsuario.getText().toString());
        var_usuarios.setSenhaUsuario(SenhaUsuario.getText().toString());
        return var_usuarios;
    }

}
