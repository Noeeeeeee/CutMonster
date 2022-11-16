package com.cutMonster.androidprojet.model.deplaceur;

import com.cutMonster.androidprojet.model.collisionneur.Collisionneur;
import com.cutMonster.androidprojet.model.entite.Defenseur;
import com.cutMonster.androidprojet.model.entite.Monstre;

import java.util.List;

/**
 * CLasse permettant de gérer le déplacement des objets du jeu
 */
public class Deplaceur {

    Collisionneur leCollisionneur;

    /**
     * Constructeur public Deplaceur
     * @param leCollisionneur leCollisionneur de type Collisionneur permet de limiter les déplacements
     */
    public Deplaceur(Collisionneur leCollisionneur)
    {
        this.leCollisionneur = leCollisionneur;
    }

    /**
     * Méthode publique deplacementCote permettant de déplacer à gauche ou à droite une entité
     * @param d le défenseur courant du jeu
     * @param x valeur de déplacement
     * @param a width de l'écran
     */
    public void deplacementCote(Defenseur d, float x, int a){
        if(x > 0)
        {
            if (!leCollisionneur.isTouchBorderScreenLeft(d))
            {
                d.setX(d.getX()-x);
                d.setY(d.getY());
            }
        }
        if(x < 0)
        {
            if(!leCollisionneur.isTouchBorderScreenRight(d, a))
            {
                d.setX(d.getX()-x);
                d.setY(d.getY());
            }
        }


    }


    /**
     * Méthode public deplacementBas permettant de déplacer les monstres vers le bas
     * @param lesMonstres liste de monstres du jeu
     * @param avanceeMonstre valeur int définissant le pas d'avancée du monstre
     */
    public void deplacementBas(List<Monstre> lesMonstres, int avanceeMonstre){
        for (Monstre m : lesMonstres)
        {
            m.setX(m.getX());
            m.setY(m.getY() + avanceeMonstre);
        }
    }
}
