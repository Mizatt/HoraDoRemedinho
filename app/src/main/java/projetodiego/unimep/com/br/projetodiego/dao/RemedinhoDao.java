package projetodiego.unimep.com.br.projetodiego.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import projetodiego.unimep.com.br.projetodiego.modelo.Remedio;


public class RemedinhoDao extends SQLiteOpenHelper {

    public RemedinhoDao(Context context) {
        super(context, "HoraDoRemedinho", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QuerySQL = "CREATE TABLE tabelaRemedios(id INTEGER PRIMARY KEY NOT NULL, nomeremedio TEXT NOT NULL); ";
        db.execSQL(QuerySQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String QuerySQL = "DROP TABLE IF EXISTS tabelaRemedios";
        db.execSQL(QuerySQL);
        onCreate(db);
    }

    public void inserirNovoRemedio(Remedio Remedio) {
        SQLiteDatabase appDatabase = getWritableDatabase();
        ContentValues Valores = new ContentValues();
        Valores.put("nomeremedio", Remedio.getNomeDoRemedio());
        appDatabase.insert("tabelaRemedios", null, Valores);
    }

    public List<Remedio> listaRemedios() {
        String SQL = "SELECT * FROM tabelaRemedios;";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(SQL, null);
        List<Remedio> remediosCadastrados = new ArrayList<Remedio>();
        while (cursor.moveToNext()) {
            Remedio listaRemedio = new Remedio();
            listaRemedio.setId(cursor.getInt(cursor.getColumnIndex("id")));
            listaRemedio.setNomeDoRemedio(cursor.getString(cursor.getColumnIndex("nomeremedio")));
            remediosCadastrados.add(listaRemedio);
        }
        cursor.close();
        return remediosCadastrados;
    }

    public void deletarRemedios(Remedio D) {
        SQLiteDatabase db = getWritableDatabase();
        String[] Parametros = {String.valueOf(D.getId())};
        db.delete("tabelaRemedios", "id = ?", Parametros);
    }

    public void alterarRemedios(Remedio Remedio) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues Valores = new ContentValues();
        Valores.put("nomeremedio", Remedio.getNomeDoRemedio());
        String[] alteracaoParametro = {Integer.toString(Remedio.getId())};
        db.update("tabelaRemedios", Valores, "id = ?", alteracaoParametro);
    }
}
