package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CadastroRemedinhos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_remedinhos);

        Button salvarCadastroRemedinho = (Button) findViewById(R.id.botaoSalvarRemedinho);
        salvarCadastroRemedinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callSalvaRemedinho = new Intent(CadastroRemedinhos.this, SucessoCadastroRemedinho.class);
                startActivity(callSalvaRemedinho);
                finish();
            }
        });

        Button cancelarCadastroRemedinho = (Button) findViewById(R.id.botaoCancelar);
        cancelarCadastroRemedinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callCancelaCadastro = new Intent(CadastroRemedinhos.this, RemedinhosCadastrados.class);
                startActivity(callCancelaCadastro);
                Toast.makeText(CadastroRemedinhos.this, "Cadastro de remédio cancelado!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        Button cancelarCadastroRemedinho1 = (Button) findViewById(R.id.botaoVoltar);
        cancelarCadastroRemedinho1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callCancelaCadastro = new Intent(CadastroRemedinhos.this, RemedinhosCadastrados.class);
                startActivity(callCancelaCadastro);
                Toast.makeText(CadastroRemedinhos.this, "Cadastro de remédio cancelado!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
