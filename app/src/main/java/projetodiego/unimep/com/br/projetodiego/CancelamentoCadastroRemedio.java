package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CancelamentoCadastroRemedio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cancelamento_cadastro_remedio);

        int finishTime = 1000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                CancelamentoCadastroRemedio.this.finish();
                Intent callCancelamentoDeCadastro = new Intent(CancelamentoCadastroRemedio.this, RemediosCadastrados.class);
                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                startActivity(callCancelamentoDeCadastro);
            }
        }, finishTime);
     }
}

