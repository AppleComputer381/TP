package com.gestionnaireLivraisons;

/**
 * La classe de livreur en voiture
 */
public class LivreurVoiture extends Livreur {

    // Constructeur
    public LivreurVoiture(int id, String nom) {
        super(id, nom);
    }

    @Override
    public int capaciteLivraison() {
        return 5;
    }

    @Override
    public double calculerRevenu() {
        return 7.5 * this.nbLivraisonsEffectuees();
    }
}