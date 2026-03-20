package com.gestionnaireLivraisons;

/**
 * La classe de livreur en voiture
 */
public class LivreurAuto extends Livreur {
    // definition des constantes
    private static final int CAPACITE = 5;
    private static final double REVENU = 7.5;
    private static final String TRANSPORT = "VOITURE";

    // Constructeur
    public LivreurAuto(int id, String nom) {
        super(id, nom);
    }

    @Override
    public int capaciteLivraison() {
        return CAPACITE;
    }

    @Override
    public double calculerRevenu() {
        return REVENU * this.nbLivraisonsEffectuees();
    }

    @Override
    public String getTransport() {
        return TRANSPORT;
    }

}