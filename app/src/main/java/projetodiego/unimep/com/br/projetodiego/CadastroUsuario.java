package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import projetodiego.unimep.com.br.projetodiego.dao.RemedinhoDao;
import projetodiego.unimep.com.br.projetodiego.modelo.Usuario;

public class CadastroUsuario extends AppCompatActivity {

    private ControleUsuarios controle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);
        controle = new ControleUsuarios(this);

        Button voltaActivity = (Button) findViewById(R.id.botaoVoltar);
        voltaActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent callTelaAnterior = new Intent(CadastroUsuario.this, Login.class);
                startActivity(callTelaAnterior);
            }
        });


        Button salvarCadastro = (Button) findViewById(R.id.botaoSalvarCadastro);
        salvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nomeUsuario = findViewById(R.id.NomeUsuario);
                EditText emailUsuario = findViewById(R.id.EmailUsuario);
                EditText senhaUsuario = findViewById(R.id.PrimeiraSenha);
                EditText confirmaSenha = findViewById(R.id.confirmaSenha);
                Usuario Usuario = controle.getControleUsuarios();
                RemedinhoDao dao = new RemedinhoDao(CadastroUsuario.this);
                if (nomeUsuario.length() == 0) {
                    nomeUsuario.setError("Você precisa inserir seu nome para continuar.");
                    nomeUsuario.requestFocus();
                }
                if (emailUsuario.length() == 0) {
                    emailUsuario.setError("Você precisa inserir seu email para continuar.");
                    emailUsuario.requestFocus();
                }
                if (senhaUsuario.length() == 0) {
                    senhaUsuario.setError("Você precisa inserir uma senha para continuar.");
                    senhaUsuario.requestFocus();
                }
                if (confirmaSenha.length() == 0) {
                    confirmaSenha.setError("Você precisa confirmar sua senha para continuar.");
                    confirmaSenha.requestFocus();
                    if (confirmaSenha != senhaUsuario) {
                        confirmaSenha.setError("As senhas não batem.");
                        confirmaSenha.requestFocus();
                    }
                }
                if (nomeUsuario.length() != 0 && emailUsuario.length() != 0 && senhaUsuario.length() != 0 && confirmaSenha.length() != 0) {
                    dao.inserirNovoUsuario(Usuario);
                    dao.close();
                    finish();
                    Intent callSalvarUsuario = new Intent(CadastroUsuario.this, sucessoCadastroUsuario.class);
                    startActivity(callSalvarUsuario);
                    finish();
                }
            }
        });
    }
}
