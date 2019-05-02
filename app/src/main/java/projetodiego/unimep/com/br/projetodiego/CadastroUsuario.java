package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        Button voltaActivity = (Button) findViewById(R.id.botaoVoltar);
        voltaActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent callTelaAnterior = new Intent(CadastroUsuario.this, Login.class);
                startActivity(callTelaAnterior);
            }
        });

        final EditText NomeUsuario = findViewById(R.id.NomeUsuario);
        final EditText EmailUsuario = findViewById(R.id.EmailUsuario);
        final EditText SenhaUsuario = findViewById(R.id.PrimeiraSenha);
        final EditText ConfirmaSenha = findViewById(R.id.confirmaSenha);
        Button salvarCadastro = (Button) findViewById(R.id.botaoSalvarCadastro);
        salvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NomeUsuario.length() == 0) {
                    NomeUsuario.setError("Você precisa inserir seu nome para continuar.");
                    NomeUsuario.requestFocus();
                }
                if (EmailUsuario.length() == 0) {
                    EmailUsuario.setError("Você precisa inserir seu email para continuar.");
                    EmailUsuario.requestFocus();
                }
                if (SenhaUsuario.length() == 0) {
                    SenhaUsuario.setError("Você precisa inserir uma senha para continuar.");
                    SenhaUsuario.requestFocus();
                }
                if (ConfirmaSenha.length() == 0) {
                    ConfirmaSenha.setError("Você precisa confirmar sua senha para continuar.");
                    ConfirmaSenha.requestFocus();
                    if (ConfirmaSenha != SenhaUsuario) {
                        ConfirmaSenha.setError("As senhas não batem.");
                        ConfirmaSenha.requestFocus();
                    }
                }
                if (NomeUsuario.length() != 0 && EmailUsuario.length() != 0 && SenhaUsuario.length() != 0 && ConfirmaSenha.length() != 0) {
                    Intent callSalvarUsuario = new Intent(CadastroUsuario.this, sucessoCadastroUsuario.class);
                    startActivity(callSalvarUsuario);
                    finish();
                }
            }
        });
    }
}
