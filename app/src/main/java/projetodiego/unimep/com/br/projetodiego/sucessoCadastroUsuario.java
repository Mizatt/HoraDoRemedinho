package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class sucessoCadastroUsuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sucesso_cadastro_usuario);

        int finishTime = 3000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                sucessoCadastroUsuario.this.finish();
                Intent callLoginAposSucesso = new Intent(sucessoCadastroUsuario.this, Login.class);
                startActivity(callLoginAposSucesso);
            }
        }, finishTime);
    }
}
