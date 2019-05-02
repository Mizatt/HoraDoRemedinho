package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ExclusaoDeRegistro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exclusao_de_registro);

        int finishTime = 1500;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                ExclusaoDeRegistro.this.finish();
                Intent callExclusaoDeRegistro = new Intent(ExclusaoDeRegistro.this, RemediosCadastrados.class);
                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                startActivity(callExclusaoDeRegistro);
            }
        }, finishTime);
    }
}
