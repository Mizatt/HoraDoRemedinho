package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import projetodiego.unimep.com.br.projetodiego.dao.RemedinhosDao;
import projetodiego.unimep.com.br.projetodiego.modelo.Remedios;

public class RemedinhosCadastrados extends AppCompatActivity {
    private ListView listaRemediosCadastrados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedinhos_cadastrados);
        listaRemediosCadastrados = findViewById(R.id.listadeRemedinhos);
        Button adicionarNovoRemedinho = (Button) findViewById(R.id.botãoCadastrarNovoRemedinho);
        adicionarNovoRemedinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chamaFormularioCadastrodeRemedinhos = new Intent(RemedinhosCadastrados.this, CadastroRemedinhos.class);
                startActivity(chamaFormularioCadastrodeRemedinhos);
            }
        });
        registerForContextMenu(listaRemediosCadastrados);

        Button acessarConfiguracoes = (Button) findViewById(R.id.botaoacessoconfiguraçoes);
        acessarConfiguracoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callTelaConfiguracoes = new Intent(RemedinhosCadastrados.this, TelaDeConfigurcao.class);
                startActivity(callTelaConfiguracoes);
            }
        });
    }
}
