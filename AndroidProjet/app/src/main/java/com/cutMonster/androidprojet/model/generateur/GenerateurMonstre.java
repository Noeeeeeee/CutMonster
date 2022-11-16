package com.cutMonster.androidprojet.model.generateur;

import com.cutMonster.androidprojet.model.entite.Monstre;

import java.util.List;
import java.util.Random;

/**
 * Classe permettant de générer des monstres
 */
public class GenerateurMonstre {

    /**
     * Méthode public de type Monstre creerMonstre permettant de créer un monstre
     * @param lesMonstres liste de monstres du jeu
     * @return le monstre que l'on vient de créer
     */
    public Monstre creerMonstre(List<Monstre> lesMonstres)
    {

        Random random = new Random();

        int x = random.nextInt(600);

        int y = random.nextInt(1000);

        Monstre m = new Monstre(x, y);
        lesMonstres.add(m);
        return m;

    }

}
