package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_usuario);

        Button voltaActivity = (Button) findViewById(R.id.botaoVoltar);
        voltaActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callTelaAnterior = new Intent(CadastroUsuario.this, Login.class);
                startActivity(callTelaAnterior);
            }
        });

        Button salvarCadastro = (Button) findViewById(R.id.botaoSalvarCadastro);
        salvarCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callSalvarUsuario = new Intent(CadastroUsuario.this, sucessoCadastroUsuario.class);
                startActivity(callSalvarUsuario);
                finish();
            }
        });
    }
}
