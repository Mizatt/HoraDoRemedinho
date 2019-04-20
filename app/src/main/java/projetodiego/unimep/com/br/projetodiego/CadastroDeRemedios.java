package projetodiego.unimep.com.br.projetodiego;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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
                projetodiego.unimep.com.br.projetodiego.modelo.Remedio Remedio = control.getModeloRemedio();
                RemedinhoDao dao = new RemedinhoDao(CadastroDeRemedios.this);
                if (Remedio.getId() != 0) {
                    dao.alterarRemedios(Remedio);
                } else {
                    dao.inserirNovoRemedio(Remedio);
                }
                dao.close();
                Intent sucessoCadastro = new Intent(CadastroDeRemedios.this, SucessoCadastroRemedinho.class);
                startActivity(sucessoCadastro);
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
                Intent sucessoCadastro = new Intent(CadastroDeRemedios.this, SucessoCadastroRemedinho.class);
                startActivity(sucessoCadastro);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
