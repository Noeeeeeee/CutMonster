package com.cutMonster.androidprojet.model.persistance;


import com.cutMonster.androidprojet.model.Joueur;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Classe permettant la serialization d'une collection de joueurs dans un fichier
 */
public class SauveurSer extends Sauveur {

    /**
     * Méthode permettant de sauvegarder une collection de joueurs
     * @param lesJoueurs la collection de joueurs à sauvegarder
     */
    @Override
    public void sauvegarderStats(List<Joueur> lesJoueurs, FileOutputStream file) {
        serialiser(lesJoueurs, file);
    }

    /**
     * Méthode permettant de charger une collection de joueurs
     * @return La collection de joueurs
     */
    @Override
    public List<Joueur> chargerStats(FileInputStream file) {
        return deserialiser(file);
    }


    /**
     * Méthode permettant de sérialiser la liste de joueurs
     * @param lesJoueurs la collection de joueurs
     */
    private void serialiser(List<Joueur> lesJoueurs, FileOutputStream file) {
        try {
            ObjectOutputStream oout = new ObjectOutputStream(file);
            oout.writeObject(lesJoueurs);
            oout.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    /**
     * Méthode permettant de désérialiser la liste de joueurs
     * @return retourne la liste de joueurs
     */
    private List<Joueur> deserialiser(FileInputStream file) {
        List<Joueur> lesJoueurs = new ArrayList<Joueur>();
        try {
            ObjectInputStream oin = new ObjectInputStream(file);
            lesJoueurs = (ArrayList<Joueur>) oin.readObject();
            oin.close();
        } catch (ClassNotFoundException | IOException nfe) {
            nfe.printStackTrace();
        }
        return lesJoueurs;
    }

}