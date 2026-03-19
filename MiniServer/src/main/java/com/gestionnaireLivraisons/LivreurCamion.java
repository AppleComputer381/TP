package com.gestionnaireLivraisons;

/**
 * La classe de livreur en camion
 */
public class LivreurCamion extends Livreur {

    // Constructeur
    public LivreurCamion(int id, String nom) {
        super(id, nom);
    }

    @Override
    public int capaciteLivraison() {
        return 10;
    }

    @Override
    public double calculerRevenu() {
        return 10.0 * this.nbLivraisonsEffectuees();
    }

    @Override
    public String toString() {
        return this.getId() + " CAMION " + this.getNom();
    }
}
