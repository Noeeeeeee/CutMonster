package com.cutMonster.androidprojet.model.manager;

import com.cutMonster.androidprojet.R;
import com.cutMonster.androidprojet.model.Joueur;
import com.cutMonster.androidprojet.model.boucleur.Boucleur;
import com.cutMonster.androidprojet.model.collisionneur.Collisionneur;
import com.cutMonster.androidprojet.model.deplaceur.Deplaceur;
import com.cutMonster.androidprojet.model.entite.Defenseur;
import com.cutMonster.androidprojet.model.entite.Monstre;
import com.cutMonster.androidprojet.model.generateur.GenerateurMonstre;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class GameManager implements Observer {

    /**
     * leDefenseurCourant de type Defenseur
     */
    private Defenseur leDefenseurCourant;
    /**
     * leCollisionneur de type Collisionneur
     */
    private Collisionneur leCollisionneur = new Collisionneur();

    /**
     * leDeplaceur de type Deplaceur
     */
    private Deplaceur leDeplaceur = new Deplaceur(leCollisionneur);

    /**
     * leJoueurCourant de type Joueur
     */
    public static Joueur leJoueurCourant;

    /**
     * leMonstreCourant de type Monstre
     */
    private  Monstre leMonstreCourant;

    /**
     * leGenerateurMonstre de type GenerateurMonstre
     */
    private GenerateurMonstre leGenerateurMonstre = new GenerateurMonstre();

    /**
     * leBoucleur de type Boucleur
     */
    private Boucleur leBoucleur = new Boucleur();

    /**
     * lesMonstres, liste de monstres de type Monstre
     */
    List<Monstre> lesMonstres = new ArrayList<>();

    /**
     * Constructeur publique GameManager
     */
    public GameManager(){

    }


    /**
     * Méthode publique getLeBoucleur qui récupre le boucleur
     * @return leBoucleur
     */
    public Boucleur getLeBoucleur() {
        return leBoucleur;
    }

    /**
     * Méthode publique de type Boucleur GenerateurMonstre permettant de récupérer le générateur de monstre
     * @return le générateur de monstre
     */
    public GenerateurMonstre getLeGenerateurMonstre() {
        return leGenerateurMonstre;
    }

    /**
     * Méthode publique lancerPartie permettant de lancer la partie
     */
    public void lancerPartie()
    {
        leBoucleur.setRunning(true);
        new Thread(leBoucleur).start();
        creeDefenseur(10, 15);
    }

    /**
     * Méthode publique de type Defenseur getLeDefenseurCourant permettant de récupérer le defenseurCourant
     * @return le defenseur courant
     */
    public Defenseur getLeDefenseurCourant() {
        return leDefenseurCourant;
    }

    public void setLeDefenseurCourant(Defenseur leDefenseurCourant) {
        this.leDefenseurCourant = leDefenseurCourant;
    }

    /**
     * Méthode publique getlesMonstres permettant de retourner la liste de monstres du jeu
     * @return la liste de monstres
     */
    public List<Monstre> getlesMonstres() {
        return lesMonstres;
    }

    /**
     * Méthode publique de type Joueur permettant de retourner le joueur courant
     * @return le joueur courant
     */
    public Joueur getLeJoueurCourant() {
        return leJoueurCourant;
    }

    public void setLeJoueurCourant(Joueur leJoueurCourant) {
        this.leJoueurCourant = leJoueurCourant;
    }

    /**
     * Méthode publique de type Deplaceur getLeDeplaceur permettant de recupérer le deplaceur
     * @return le deplaceur
     */
    public Deplaceur getLeDeplaceur() {
        return leDeplaceur;
    }

    /**
     * Méthode publique de type Collisionneur getLeCollisionneur permettant de récupérer le Collisionneur
     * @return le Collisionneur
     */
    public Collisionneur getLeCollisionneur() {
        return leCollisionneur;
    }

    /**
     * Méthode publique de type Monstre creerMonstre permettant de creer un monstre
     * @return le monstre courant
     */
    public Monstre creerMonstre()
    {
        return leMonstreCourant = leGenerateurMonstre.creerMonstre(lesMonstres);
    }

    /**
     * Méthode publique supprimerMonstre permettant de supprimer un monstre de la liste
     * @param m monstre
     */
    public void supprimerMonstre(Monstre m)
    {
        lesMonstres.remove(m);
    }

    /**
     * Méthode publique creeDefensuer permettant de creer un defenseur
     * @param positionXdep position x du defenseur au départ
     * @param positionYdep positon y du defenseur au départ
     */
    public void creeDefenseur(double positionXdep, double positionYdep)
    {
        leDefenseurCourant = new Defenseur(positionXdep, positionYdep, R.drawable.defenseur);
    }


    @Override
    public void update(Observable o, Object arg) {

    }
}
