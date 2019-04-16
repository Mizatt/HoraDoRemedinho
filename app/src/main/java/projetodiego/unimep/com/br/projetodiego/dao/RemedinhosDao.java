package projetodiego.unimep.com.br.projetodiego.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import projetodiego.unimep.com.br.projetodiego.modelo.Remedios;

public class RemedinhosDao extends SQLiteOpenHelper {

    public RemedinhosDao(Context context) {
        super(context, "HoraDoRemedinho", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QuerySQL = "CREATE TABLE Remedinhos(id INTEGER PRIMARY KEY NOT NULL, nomeremedio TEXT NOT NULL, hora TIME); ";
        db.execSQL(QuerySQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String QuerySQL = "DROP TABLE IF EXISTS Remedinhos";
        db.execSQL(QuerySQL);
        onCreate(db);
    }
}
