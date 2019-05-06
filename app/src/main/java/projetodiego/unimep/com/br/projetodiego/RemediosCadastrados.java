package projetodiego.unimep.com.br.projetodiego;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import projetodiego.unimep.com.br.projetodiego.modelo.Remedio;
import projetodiego.unimep.com.br.projetodiego.dao.RemedinhoDao;


public class RemediosCadastrados extends AppCompatActivity {
    private ListView lista_remedios;
    private int backButtonCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remedinhos_cadastrados);
        final Button botaoEditar = (Button) findViewById(R.id.botaoEditar);
        botaoEditar.setEnabled(false);
        final Button botaoExcluir = (Button) findViewById(R.id.botaoExcluir);
        botaoExcluir.setEnabled(false);
        final Button adicionarNovoRemedinho = (Button) findViewById(R.id.botãoCadastrarNovoRemedinho);

        final AlertDialog.Builder alertDialogSair = new android.support.v7.app.AlertDialog.Builder(this);
        alertDialogSair.setMessage("Deseja sair do app?");
        alertDialogSair.setCancelable(false);

        alertDialogSair.setPositiveButton("Sim",  new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                finishAffinity();
                System.exit(0);
            }
        });
        alertDialogSair.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onResume();
            }
        });

        final AlertDialog Sair = alertDialogSair.create();

        lista_remedios = findViewById(R.id.listaDeRemediosCadastrados);
        lista_remedios.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                parent.getItemAtPosition(position);
                view.setBackground(getDrawable(R.drawable.selectedcolor));
                    lista_remedios.setSelected(true);
                    botaoExcluir.setEnabled(true);
                    botaoEditar.setEnabled(true);
                    adicionarNovoRemedinho.setEnabled(false);
                return false;
            }
        });

        lista_remedios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                parent.getItemAtPosition(position);
                view.setBackground(getDrawable(R.drawable.notselected));
                lista_remedios.setSelected(false);
                botaoExcluir.setEnabled(false);
                botaoEditar.setEnabled(false);
                adicionarNovoRemedinho.setEnabled(true);
            }
        });

        final AlertDialog.Builder alertDialog1 = new AlertDialog.Builder(lista_remedios.getContext());
        alertDialog1.setMessage("Deseja excluir remédio selecionado?");
        alertDialog1.setCancelable(false);

        alertDialog1.setPositiveButton("Sim",  new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Remedio Remedio = (projetodiego.unimep.com.br.projetodiego.modelo.Remedio) lista_remedios.getItemAtPosition(lista_remedios.getCheckedItemPosition());
                RemedinhoDao DAO = new RemedinhoDao(RemediosCadastrados.this);
                DAO.deletarRemedios(Remedio);
                DAO.close();
                Intent confirmarExclusao = new Intent(RemediosCadastrados.this,ExclusaoDeRegistro.class);
                startActivity(confirmarExclusao);
                onResume();
            }
        });

        alertDialog1.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                lista_remedios.getItemAtPosition(id);
                lista_remedios.setBackground(getDrawable(R.drawable.notselected));
                lista_remedios.setSelected(false);
                botaoExcluir.setEnabled(false);
                botaoEditar.setEnabled(false);
                adicionarNovoRemedinho.setEnabled(true);
                onResume();
            }
        });

        final AlertDialog alertaExclusao = alertDialog1.create();
        botaoExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertaExclusao.show();
            }
        });

        botaoEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Remedio Remedio = (projetodiego.unimep.com.br.projetodiego.modelo.Remedio) lista_remedios.getItemAtPosition(lista_remedios.getCheckedItemPosition());
                Intent redirecionaFormulario = new Intent(RemediosCadastrados.this, CadastroDeRemedios.class);
                redirecionaFormulario.putExtra("remedio_selecionado", Remedio);
                startActivity(redirecionaFormulario);
            }
        });

        Button botaoSair = (Button) findViewById(R.id.botaoSair);
        botaoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sair.show();
            }
        });

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
                Intent callTelaConfiguracoes = new Intent(RemediosCadastrados.this, TelaDeConfigurcao.class);
                startActivity(callTelaConfiguracoes);
            }
        });
}

    @Override
    public void onBackPressed() {
        if (backButtonCount >= 1) {
           finishAffinity();
            System.exit(0);
        } else {
            Toast.makeText(this, "Pressione novamente o botão para fechar o app.", Toast.LENGTH_SHORT).show();
            backButtonCount++;
        }
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
}


