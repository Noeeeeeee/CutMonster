package com.cutMonster.androidprojet.model.entite;

/**
 * Classe abstraite Entite
 */
public abstract class Entite {

    /**
     * height de l'entite de type int
     */
    protected int height;

    /**
     * width de l'entite de type int
     */
    protected int width;

    /**
     * position x de l'entite de type double
     */
    protected  double x ;

    /**
     * position y de l'entite de type double
     */
    protected double y;

    /**
     * image de l'entite de type int
     */
    int image;

    /**
     * Constructeur publique Entite
     * @param x coordonnée de x de l'entite
     * @param y coordonnée de y de l'entite
     * @param image image de l'entite
     * @param height height de l'entite
     * @param width width de l'entite
     */
    public Entite(double x, double y, int image, int height, int width)
    {
        this.x = x;
        this.y = y;
        this.image = image;
        this.height = height;
        this.width = width;
    }

    /**
     * Autre constructeur publique Entite
     * @param x coordonnée de x de l'entite
     * @param y coordonnée de x de l'entite
     * @param height height de l'entite
     * @param width width de l'entite
     */
    public Entite(double x, double y, int height, int width)
    {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    /**
     * Méthode publique getX coordonnée x
     * @return un double (coordonnnée x) de l'entite
     */
    public double getX() {
        return x;
    }

    /**
     * Méthode publique Setter coordonnée x
     * @param x coordonnée de x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Méthode publique getY coordonnée y
     * @return un double (coordonnnée y) de l'entite
     */
    public double getY() {
        return y;
    }

    /**
     * Méthode publique Setter coordonnée y
     * @param y coordonnée de y
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Méthode publique getImage
     * @return String l'image de l'Entite
     */
    public int getImage()
    {
        return image;
    }

    /**
     * Méthode publique Setter de l'image de l'entite
     * @param image image de l'entite
     */
    public void setImage(int image) {
        this.image = image;
    }

    /**
     * Méthode publique getHeight
     * @return int height de l'entite
     */
    public int getHeight() {
        return height;
    }

    /**
     * Méthode publique Setter de height de l'entite
     * @param height height de l'entite
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Méthode publique getWidth
     * @return int width de l'entite
     */
    public int getWidth() {
        return width;
    }

    /**
     * Méthode publique Setter de width de l'entite
     * @param width height de l'entite
     */
    public void setWidth(int width) {
        this.width = width;
    }




}
