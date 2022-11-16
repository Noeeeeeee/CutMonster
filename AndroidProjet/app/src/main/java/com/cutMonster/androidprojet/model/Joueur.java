package com.cutMonster.androidprojet.model;

import java.io.Serializable;

/**
 * Classe Joueur
 */
public class Joueur implements Serializable {
    /**
     * pseudo du joueur de type String
     */
    private String pseudo;

    /**
     * nbPoints du joueur de type int
     */
    private int nbPoints;

    /**
     * Consctructeur publique de Joueur
     * @param pseudo
     * @param nbPoints
     */
    public Joueur(String pseudo, int nbPoints) {
        this.pseudo = pseudo;
        this.nbPoints = nbPoints;
    }

    /**
     * Méthode publique getPseudo
     * @return le pseudo du joueur
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * Méthode publique setPseudo
     * @param pseudo pseudo du joueur
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * Méthode publique getNbPoints
     * @return le nombre de points du joueur
     */
    public int getNbPoints() {
        return nbPoints;
    }

    /**
     * Méthode publique setNbPoints
     * @param nbPoints nombre de points du joueur
     */
    public void setNbPoints(int nbPoints) {
        this.nbPoints = nbPoints;
    }

    /**
     * To string du joueur
     * @return String le message
     */
    public String ToString() {
        return "Je m'appelle " + pseudo + " et je possède " + nbPoints;
    }
}
