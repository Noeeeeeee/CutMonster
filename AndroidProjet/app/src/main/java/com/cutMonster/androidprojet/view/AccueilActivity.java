package com.cutMonster.androidprojet.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.cutMonster.androidprojet.R;
import com.cutMonster.androidprojet.model.Joueur;
import com.cutMonster.androidprojet.model.manager.GameManager;
import com.cutMonster.androidprojet.model.manager.PersistanceManager;

import java.io.FileNotFoundException;

public class AccueilActivity extends AppCompatActivity {

    private Button bouttonJouer = null ;
    private Button bouttonQuitter = null ;
    private Button bouttonScore = null ;
    PersistanceManager persistanceManager = PersistanceManager.getInstance();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_accueil);
        try {
            persistanceManager.chargerDonnees(openFileInput(PersistanceManager.NAME_FILE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bouttonJouer = findViewById(R.id.bouttonJouer);
        bouttonJouer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText editTextPseudo = findViewById(R.id.editTextPseudo);
                String pseudo = editTextPseudo.getText().toString();
                if (editTextPseudo.getText().toString().isEmpty())
                    new AlertDialog.Builder(AccueilActivity.this)
                            .setTitle("Alerte")
                            .setMessage("Pseudo vide")
                            .setCancelable(false)
                            .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int which) {
                                    dialogInterface.dismiss();
                                }
                            })
                    .show();

                else {

                    GameManager.leJoueurCourant = new Joueur(pseudo, 0);
                    Intent intent = new Intent(AccueilActivity.this, JeuActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });

        bouttonQuitter = findViewById(R.id.bouttonQuitter);
        bouttonQuitter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });

        bouttonScore = findViewById(R.id.bouttonScore);
        bouttonScore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(AccueilActivity.this, ScoreActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
