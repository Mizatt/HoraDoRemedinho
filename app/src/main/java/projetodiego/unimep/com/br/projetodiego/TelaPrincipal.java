package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        int finishTime = 3000;
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                TelaPrincipal.this.finish();
                Intent callAbreApp = new Intent(TelaPrincipal.this, Login.class);
                findViewById(R.id.loadingPanel).setVisibility(View.GONE);
                startActivity(callAbreApp);
            }
        }, finishTime);
    }
}
