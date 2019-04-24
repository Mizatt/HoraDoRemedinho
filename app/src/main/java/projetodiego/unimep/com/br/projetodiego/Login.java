package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button entrarTelaPrincipal = (Button) findViewById(R.id.botaoEntrarLogin);
        entrarTelaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callTelaPrincipal = new Intent(Login.this, RemediosCadastrados.class);
                startActivity(callTelaPrincipal);
            }
        });

        Button telaCriarConta = (Button) findViewById(R.id.botaoCriarConta);
        telaCriarConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callTelaCriarConta = new Intent(Login.this, CadastroUsuario .class);
                startActivity(callTelaCriarConta);
            }
        });

    }
}
