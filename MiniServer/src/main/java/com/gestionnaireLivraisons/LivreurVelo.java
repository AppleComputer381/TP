package com.gestionnaireLivraisons;

/**
 * La classe de livreur à vélo
 */
// TODO : À compléter/modifier
public class LivreurVelo extends Livreur {
    public LivreurVelo(int id, String nom) {
        super(id, nom);

    }

    @Override
    public int capaciteLivraison() {
        return 2;
    }

    @Override
    public double calculerRevenu() {
        return 5.0 * this.nbLivraisonsEffectuees();
    }

    @Override
    public String toString() {
        return this.getId() + " VELO " + this.getNom();
    }
}
