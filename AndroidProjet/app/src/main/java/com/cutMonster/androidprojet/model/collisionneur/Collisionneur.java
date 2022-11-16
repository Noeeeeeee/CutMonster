package com.cutMonster.androidprojet.model.collisionneur;

import android.graphics.Rect;

import com.cutMonster.androidprojet.model.entite.Defenseur;
import com.cutMonster.androidprojet.model.entite.Monstre;

/**
 * Classe du collisionneur
 */
public class Collisionneur {

    /**
     * Méthode publique de type boolean isTouchDefenseur qui permet de supprimer le monstre lorsque il touche le défenseur
     * @param monstre un monstre de la liste de monstres
     * @param leDefenseur le défenseur courant du jeu
     * @return vrai si le défenseur touche le monstre
     */
    public boolean isTouchDefenseur (Monstre monstre, Defenseur leDefenseur)
    {
        Rect leRectangleMonstre;
        Rect leRectangleDefenseur = new Rect((int)leDefenseur.getX(), (int)leDefenseur.getY(), (int)leDefenseur.getX()+leDefenseur.getWidth(), (int)leDefenseur.getY()+leDefenseur.getHeight());

            leRectangleMonstre = new Rect((int) monstre.getX(), (int) monstre.getY(), (int) monstre.getX() + monstre.getWidth(), (int) monstre.getY() + monstre.getHeight());
            if (leRectangleDefenseur.intersect(leRectangleMonstre)) {
                return true;
            }

        return false;

    }

    /**
     * Méthode publique de type boolean permettant de terminer la partie lorsqu'un monstre touche la bordure inférieur de l'écran
     * @param leMonstre un monstre de la liste de monstre
     * @param a valeur la bordure de l'écran inférieur
     * @return vrai si le monstre touche la bordure de l'écran inférieur
     */
    public boolean isTouchDownScreen(Monstre leMonstre, int a)
    {
        if (leMonstre.getY()+leMonstre.getHeight()+50 >= a)
        {
            return true;
        }

        return false;
    }

    /**
     * Méthode publique de type boolean permettant d'autoriser le déplacement vers la droite
     * @param leDefenseur le défenseur courant du jeu
     * @param widthEcran largeur de l'écran
     * @return vrai si le défenseur atteint la bordure de l'écran à droite
     */
    public boolean isTouchBorderScreenRight(Defenseur leDefenseur, int widthEcran)
    {
        if (leDefenseur.getX() +leDefenseur.getWidth() >= widthEcran-50)
        {
            return true;
        }
        return false;
    }

    /**
     * Méthode publique de type boolean permettant d'autoriser le déplacement vers la gauche
     * @param leDefenseur le défenseur courant du jeu
     * @return vrai si le défenseur atteint la bordure de l'écran de gauche
     */
    public boolean isTouchBorderScreenLeft(Defenseur leDefenseur)
    {
        if (leDefenseur.getX() <= 0)
        {
            return true;
        }
        return false;
    }
}
