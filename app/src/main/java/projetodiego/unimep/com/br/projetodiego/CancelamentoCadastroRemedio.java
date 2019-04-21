package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CancelamentoCadastroRemedio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancelamento_cadastro_remedio);

        int finishTime = 2500;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                CancelamentoCadastroRemedio.this.finish();
                Intent callCancelamentoDeCadastro = new Intent(CancelamentoCadastroRemedio.this, RemediosCadastrados.class);
                startActivity(callCancelamentoDeCadastro);
            }
        }, finishTime);
     }
}

