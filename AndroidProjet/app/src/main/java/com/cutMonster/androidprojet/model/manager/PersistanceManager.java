package com.cutMonster.androidprojet.model.manager;

import com.cutMonster.androidprojet.model.Joueur;
import com.cutMonster.androidprojet.model.persistance.Sauveur;
import com.cutMonster.androidprojet.model.persistance.SauveurSer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe PersistanceManager permettant de gérer la persistance de la liste de joueurs
 */
public class PersistanceManager {

    /**
     * Attribut statique de type PersistanceManager instanceUnique utilisé pour le Singleton
     */
    private static PersistanceManager instanceUnique;

    /**
     * Attribut statique de type string pour le nom du fichier de sérialisation
     */
    public static final String NAME_FILE = "lesJoueurs";

    /**
     * liste lesJoueurs de type Joueur
     */
    private List<Joueur> lesJoueurs = new ArrayList<>();

    /**
     * leSauveur de type Sauveur
     */
    private final Sauveur leSauveur = new SauveurSer();

    /**
     * Constructeur privée de PersistanceManager
     */
    private PersistanceManager(){

    }

    /**
     * Méthode publique permettant d'ajouter un joueur à la liste de joueur
     * @param j joueur reçu
     */
    public void ajouterJoueur(Joueur j)
    {
        lesJoueurs.add(j);
    }

    /**
     * Méthode de type List<Joueur> getLesJoueurs permettant de récupérer la liste de joueurs
     * @return la liste de joueurs
     */
    public List<Joueur> getLesJoueurs() {
        return lesJoueurs;
    }

    /**
     * Méthode qui vérifie qu'il n'y ai pas d'instance de PersistanceManager déjà créée, si non alors elle l'instancie
     * @return le persistanceManager unique ou non
     */
    public static PersistanceManager getInstance() {
        if (instanceUnique == null) {
            instanceUnique = new PersistanceManager();
        }
        return instanceUnique;
    }


    /**
     * Méthode permettant de charger les données à partir d'un fichier
     */
    public void chargerDonnees(FileInputStream file){
        lesJoueurs = leSauveur.chargerStats(file);
    }

    /**
     * Méthode permettant de sauvegarder les données dans un fichier
     */
    public void sauvegarderDonnees(FileOutputStream file){
        leSauveur.sauvegarderStats(lesJoueurs, file);
    }



}
