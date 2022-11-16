package com.cutMonster.androidprojet.view;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cutMonster.androidprojet.R;
import com.cutMonster.androidprojet.model.manager.PersistanceManager;
import com.cutMonster.androidprojet.view.adaptateur.Adaptateur;

public class ScoreActivity extends AppCompatActivity {


    PersistanceManager persistanceManager = PersistanceManager.getInstance();
    private Button bouttonRetourScore = null ;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_score);

        RecyclerView recyclerView = findViewById(R.id.listeJoueurs);
        Adaptateur adapter = new Adaptateur(persistanceManager.getLesJoueurs());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        bouttonRetourScore = findViewById(R.id.bouttonRetourScore);
        bouttonRetourScore.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(ScoreActivity.this, AccueilActivity.class);
                startActivity(intent);
                finish();
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
