package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_principal);

        Button entrarTelaPrincipal = (Button) findViewById(R.id.entrarInicial);
        entrarTelaPrincipal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent direciona_formulario = new Intent(TelaPrincipal.this, Login.class);
                startActivity(direciona_formulario);
            }
        });
    }
}
