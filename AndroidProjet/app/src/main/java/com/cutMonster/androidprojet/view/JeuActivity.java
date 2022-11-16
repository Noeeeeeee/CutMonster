package com.cutMonster.androidprojet.view;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.cutMonster.androidprojet.R;
import com.cutMonster.androidprojet.model.deplaceur.Deplaceur;
import com.cutMonster.androidprojet.model.manager.GameManager;
import com.cutMonster.androidprojet.model.entite.Monstre;
import com.cutMonster.androidprojet.model.manager.PersistanceManager;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class JeuActivity extends AppCompatActivity implements Observer {

    private static final String TAG = null;
    private Sensor gyroscopeSensor;
    private SensorManager sensorManager;
    GameManager gameManager;
    PersistanceManager persistanceManager = PersistanceManager.getInstance();
    private Button bouttonRetourJeu = null;
    private Deplaceur leDeplaceur;
    private FrameLayout monFrameLayout;
    ImageView imageViewDefenseur;
    private List<ImageView> listeImageViewMonstre;
    private int compteur = 0;
    private TextView textViewPoint = null;
    private SensorEventListener gyroscopeEventListener;
    private float valueZ[] = new float[3];
    private int iterator = 0;
    private Point point = new Point();
    private int avanceeMonstre = 25;
    private MediaPlayer mediaPlayer;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_jeu);
        monFrameLayout = findViewById(R.id.monFrameLayout);
        gameManager = new GameManager();
        gameManager.getLeBoucleur().addObserver(this);
        gameManager.lancerPartie();


        leDeplaceur = gameManager.getLeDeplaceur();


        listeImageViewMonstre = new ArrayList<>();

        getWindowManager().getDefaultDisplay().getSize(point);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        gyroscopeSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        bouttonRetourJeu = findViewById(R.id.bouttonRetourJeu);
        bouttonRetourJeu.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(JeuActivity.this, AccueilActivity.class);
                startActivity(intent);
                finish();
            }
        });

        gyroscopeEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                valueZ = sensorEvent.values.clone();
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {


            }
        };


    }


    @Override
    protected void onResume() {
        super.onResume();
        gameManager.getLeBoucleur().setRunning(true);
        sensorManager.registerListener(gyroscopeEventListener, gyroscopeSensor, SensorManager.SENSOR_DELAY_NORMAL);
        imageViewDefenseur = findViewById(R.id.imageDefenseur);
        imageViewDefenseur.setImageResource(gameManager.getLeDefenseurCourant().getImage());
        textViewPoint = findViewById(R.id.points);
        this.mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.fight_looped);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }


    @Override
    protected void onPause() {
        gameManager.getLeBoucleur().setRunning(false);
        mediaPlayer.stop();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        gameManager.getLeBoucleur().deleteObserver(this);
        gameManager.getLeBoucleur().setRunning(false);
        GameManager.leJoueurCourant.setNbPoints(compteur);
        persistanceManager.ajouterJoueur(GameManager.leJoueurCourant);
        try {
            persistanceManager.sauvegarderDonnees(openFileOutput(PersistanceManager.NAME_FILE, MODE_PRIVATE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        sensorManager.unregisterListener(gyroscopeEventListener);
        super.onDestroy();

    }


    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        gameManager.getLeDefenseurCourant().setX(imageViewDefenseur.getX());
        gameManager.getLeDefenseurCourant().setY(imageViewDefenseur.getY());
    }


    @Override
    public void update(Observable o, Object arg) {
        runOnUiThread(() -> {
                gameManager.getLeDeplaceur().deplacementCote(gameManager.getLeDefenseurCourant(), valueZ[0] * 12, point.x);
                imageViewDefenseur.setX((float) gameManager.getLeDefenseurCourant().getX());


            if (iterator == 10) {
                compteur++;
                CreerMonstre();
                iterator = 0;
            }
                leDeplaceur.deplacementBas(gameManager.getlesMonstres(), avanceeMonstre);


                List<ImageView> delete = new LinkedList<>();
                int i = 0;
                for (ImageView monstre : listeImageViewMonstre) {

                    Monstre leMonstre = null;
                    for (Monstre m : gameManager.getlesMonstres()
                    ) {
                        if (monstre.getX() == m.getX() && monstre.getY() == m.getY() - avanceeMonstre) {
                            leMonstre = m;
                            break;
                        }

                    }

                    if (leMonstre == null) {
                        delete.add(monstre);
                        continue;
                    }

                    if (gameManager.getLeCollisionneur().isTouchDefenseur(leMonstre, gameManager.getLeDefenseurCourant())) {
                        gameManager.getlesMonstres().remove(leMonstre);
                        delete.add(monstre);
                        monFrameLayout.removeView(monstre);
                    }

                    if(gameManager.getLeCollisionneur().isTouchDownScreen(leMonstre, point.y))
                    {
                        gameManager.getLeBoucleur().setRunning(false);
                        sensorManager.unregisterListener(gyroscopeEventListener);
                        new AlertDialog.Builder(JeuActivity.this)
                            .setTitle("Perdu")
                            .setMessage("Vous avez perdu")
                            .setCancelable(false)
                            .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int which) {
                                    dialogInterface.dismiss();
                                    Intent intent = new Intent(JeuActivity.this, AccueilActivity.class);
                                    startActivity(intent);
                                    finish();
                                }
                            })
                    .show();
                    }
                    monstre.setY((float) leMonstre.getY());


                }

                listeImageViewMonstre.removeAll(delete);


            textViewPoint.setText(getResources().getString(R.string.points, compteur));
            iterator++;
        });




    }

    public void CreerMonstre(){
        ImageView imageViewMonstre = new ImageView(this);
        imageViewMonstre.setImageResource(R.drawable.monstre);
        Monstre monstreCourant = gameManager.creerMonstre();
        imageViewMonstre.setX((float) monstreCourant.getX());
        imageViewMonstre.setY((float) monstreCourant.getY());
        monFrameLayout.addView(imageViewMonstre);
        imageViewMonstre.getLayoutParams().width = 250;
        imageViewMonstre.getLayoutParams().height = 250;
        listeImageViewMonstre.add(imageViewMonstre);
    }


}



