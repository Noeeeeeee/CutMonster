package com.cutMonster.androidprojet.model.entite;

/**
 * Classe Monstre qui hérite de Entite
 */
public class Monstre extends Entite {

    /**
     * Constructeur publique Monstre
     * @param x coordonnée de x du monstre
     * @param y coordonnée de y du monstre
     */
    public Monstre(double x, double y)
    {
        super(x, y, 200, 200);
    }



}
