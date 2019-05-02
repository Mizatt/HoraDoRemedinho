package projetodiego.unimep.com.br.projetodiego;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import projetodiego.unimep.com.br.projetodiego.dao.RemedinhoDao;
import projetodiego.unimep.com.br.projetodiego.modelo.Remedio;

public class CadastroDeRemedios extends AppCompatActivity {

    private ControleRemedios control;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_novo_remedio);
        control = new ControleRemedios(this);


        Intent dadosRecebidos = getIntent();
        Remedio Remedio = (projetodiego.unimep.com.br.projetodiego.modelo.Remedio) dadosRecebidos.getSerializableExtra("remedio_selecionado");
        if (Remedio != null) {
            control.edicaoDeCadastro(Remedio);
        }


        Button salvar_remedio = (Button) findViewById(R.id.botaoSalvarRemedinho);
        salvar_remedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText nomeDoRemedio = findViewById(R.id.nomeDoRemedio);
                projetodiego.unimep.com.br.projetodiego.modelo.Remedio Remedio = control.getModeloRemedio();
                RemedinhoDao dao = new RemedinhoDao(CadastroDeRemedios.this);
                if (Remedio.getId() != 0) {
                    if (nomeDoRemedio.length() == 0) {
                        nomeDoRemedio.setError("Você precisa inserir algo para continuar.");
                        nomeDoRemedio.requestFocus();
                    }
                    if (nomeDoRemedio.length() != 0) {
                        dao.alterarRemedios(Remedio);
                        dao.close();
                        finish();
                        Intent sucessoCadastro = new Intent(CadastroDeRemedios.this, sucessoCadastroRemedinho.class);
                        startActivity(sucessoCadastro);
                    }
                }
                if (Remedio.getId() == 0) {
                    if (nomeDoRemedio.length() == 0) {
                            nomeDoRemedio.setError("Você precisa inserir algo para continuar.");
                            nomeDoRemedio.requestFocus();
                    }
                        if (nomeDoRemedio.length() != 0) {
                            dao.inserirNovoRemedio(Remedio);
                            dao.close();
                            finish();
                            Intent sucessoCadastro = new Intent(CadastroDeRemedios.this, sucessoCadastroRemedinho.class);
                            startActivity(sucessoCadastro);
                        }
                    }
                }
        });

        Button voltarTelaAnterior = findViewById(R.id.botaoVoltar);
        voltarTelaAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent voltarTela = new Intent(CadastroDeRemedios.this, RemediosCadastrados.class);
                startActivity(voltarTela);
            }
        });


        Button cancelarCadastroDeRemedio = (Button) findViewById(R.id.botaoCancelar);
        cancelarCadastroDeRemedio.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
            Intent cancelarCadastro = new Intent(CadastroDeRemedios.this, CancelamentoCadastroRemedio.class);
            startActivity(cancelarCadastro);
        }
    });
}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.botaoSalvarRemedinho:
                Remedio remedio = control.getModeloRemedio();
                RemedinhoDao dao = new RemedinhoDao(this);
                if (remedio.getId() != 0) {
                    dao.alterarRemedios(remedio);
                } else {
                    dao.inserirNovoRemedio(remedio);
                }
                dao.close();
                Intent sucessoCadastro = new Intent(CadastroDeRemedios.this, sucessoCadastroRemedinho.class);
                startActivity(sucessoCadastro);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
