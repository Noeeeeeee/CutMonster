package com.cutMonster.androidprojet.model.boucleur;

import java.util.Observable;
import java.util.Observer;

/**
 * Classe du boucleur du jeu
 */
public class Boucleur extends Observable implements Runnable{

    private boolean running = false;

    public void run(){

        while(running){
            setChanged();
            notifyObservers();
            try{
                Thread.sleep(50);
            } catch (InterruptedException e) {
                running = false;
            }
        }
    }

    /**
     * Méthode qui permet d'ajouter un observer
     * @param o object à observer
     */
    @Override
    public synchronized void addObserver(Observer o) {
        super.addObserver(o);
    }

    @Override
    public synchronized void deleteObserver(Observer o) {
        super.deleteObserver(o);
    }

    @Override
    public void notifyObservers() {
        super.notifyObservers();
    }

    public boolean isRunning(){
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
}