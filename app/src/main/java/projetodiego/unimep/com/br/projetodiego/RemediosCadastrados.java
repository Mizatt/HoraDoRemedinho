package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.List;

import projetodiego.unimep.com.br.projetodiego.modelo.Remedio;
import projetodiego.unimep.com.br.projetodiego.dao.RemedinhoDao;


public class RemediosCadastrados extends AppCompatActivity {
    private ListView lista_remedios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedinhos_cadastrados);

        lista_remedios = findViewById(R.id.listaDeRemediosCadastrados);

        lista_remedios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Remedio Remedios = (Remedio) lista_remedios.getItemAtPosition(position);
                Intent redirecionaFormulario = new Intent(RemediosCadastrados.this, CadastroDeRemedios.class);
                redirecionaFormulario.putExtra("remedio_selecionado", Remedios);
                startActivity(redirecionaFormulario);
            }
        });

        Button adicionarNovoRemedinho = (Button) findViewById(R.id.botãoCadastrarNovoRemedinho);
        adicionarNovoRemedinho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent chamaFormularioCadastrodeRemedinhos = new Intent(RemediosCadastrados.this, CadastroDeRemedios.class);
                startActivity(chamaFormularioCadastrodeRemedinhos);
            }
        });
        registerForContextMenu(lista_remedios);

        Button acessarConfiguracoes = (Button) findViewById(R.id.botaoacessoconfiguraçoes);
        acessarConfiguracoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callTelaConfiguracoes = new Intent(RemediosCadastrados.this, TelaConfiguracao.class);
                startActivity(callTelaConfiguracoes);
            }
        });
    }

    private void consultarRemediosCadastrados() {
        RemedinhoDao DAO = new RemedinhoDao(this);
        List<Remedio> lista_de_remedios = DAO.listaRemedios();
        DAO.close();
        ArrayAdapter<Remedio> array_adapter = new ArrayAdapter<Remedio>(this, android.R.layout.simple_list_item_1, lista_de_remedios);
        lista_remedios.setAdapter(array_adapter);
        if (lista_de_remedios.size() >= 1) {
            ImageView nenhumRemedioCadastrado = (ImageView) findViewById(R.id.nenhumremediocadastrado);
            nenhumRemedioCadastrado.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        consultarRemediosCadastrados();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem Deletar = menu.add("Deletar o cadastro?");
        Deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo informacao_do_menu = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Remedio Remedio = (projetodiego.unimep.com.br.projetodiego.modelo.Remedio) lista_remedios.getItemAtPosition(informacao_do_menu.position);
                RemedinhoDao DAO = new RemedinhoDao(RemediosCadastrados.this);
                DAO.deletarRemedios(Remedio);
                DAO.close();
                Intent confirmarExclusao = new Intent(RemediosCadastrados.this,ExclusaoDeRegistro.class);
                startActivity(confirmarExclusao);
                onResume();
                return false;
            }
        });
    }
}
