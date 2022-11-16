package com.cutMonster.androidprojet.model.entite;

/**
 * CLasse Defenseur qui hérite d'Entite
 */
public class Defenseur extends Entite {

    /**
     * Constructeur publique Defenseur
     * @param x coordonnée de x du défenseur
     * @param y coordonnée de y du défenseur
     * @param image image du défenseur
     */
    public Defenseur(double x, double y, int image)
    {
       super(x, y, image, 300, 200);
    }


}
