package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaDeConfigurcao extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_configurcao);

        Button voltarTela = (Button) findViewById(R.id.botaoVoltar);
        voltarTela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callBack = new Intent(TelaDeConfigurcao.this, RemediosCadastrados.class);
                startActivity(callBack);
            }
        });
    }
}
