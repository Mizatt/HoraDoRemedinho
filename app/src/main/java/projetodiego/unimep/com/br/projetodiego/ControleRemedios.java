package projetodiego.unimep.com.br.projetodiego;

import android.widget.EditText;

import projetodiego.unimep.com.br.projetodiego.modelo.Remedio;

public class ControleRemedios {
    private EditText nomeDoRemedio;

    private Remedio varRemedio;

    public ControleRemedios(CadastroDeRemedios activity) {
        nomeDoRemedio = (EditText) activity.findViewById(R.id.nomeDoRemedio);
        varRemedio = new Remedio();
    }

    public Remedio getModeloRemedio() {
        varRemedio.setNomeDoRemedio(nomeDoRemedio.getText().toString());
        return varRemedio;
    }

    public void edicaoDeCadastro(Remedio D) {
        nomeDoRemedio.setText(D.getNomeDoRemedio());
        this.varRemedio = D;
    }

}
