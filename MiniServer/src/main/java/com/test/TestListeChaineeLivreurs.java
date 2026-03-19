package com.test;

import java.util.Arrays;

import com.gestionnaireLivraisons.*;

public class TestListeChaineeLivreurs {

    /**
     * Test de la méthode ajouter.
     */
    private static void testAjouter() {
        System.out.print("Test ajouter : ");
        ListeChaineeLivreurs liste = new ListeChaineeLivreurs();

        // creation de la tete
        Livreur livreur = new LivreurVelo(1, "Emilien");
        try {
            liste.ajouter(livreur);
        } catch (ListeChaineeException e) {
            System.out.println("NOK");
        }

        if (liste.taille() == 1) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    private static void testAjouterExistant() {
        System.out.print("Test ajouter existant : ");
        ListeChaineeLivreurs liste = new ListeChaineeLivreurs();
        Livreur livreur = new LivreurVelo(1, "Emilien");
        try {
            liste.ajouter(livreur);
            liste.ajouter(livreur);
            System.out.println("NOK");
        } catch (ListeChaineeException e) {
            System.out.println("OK");
        }
    }

    /**
     * Test de la méthode supprimer.
     */
    private static void testSupprimer() {
        System.out.print("Test supprimer : ");
        ListeChaineeLivreurs liste = new ListeChaineeLivreurs();
        Livreur livreur = new LivreurVelo(1, "Emilien");
        try {
            liste.ajouter(livreur);
            liste.supprimer(1);
            if (liste.taille() == 0) {
                System.out.println("OK");
            } else {
                System.out.println("NOK");
            }
        } catch (ListeChaineeException e) {
            System.out.println("NOK");
        }
    }

    /**
     * Test de la méthode rechercher.
     */
    private static void testRechercher() {
        System.out.print("Test rechercher : ");
        ListeChaineeLivreurs liste = new ListeChaineeLivreurs();
        Livreur livreur = new LivreurVelo(1, "Emilien");
        Livreur livreur2 = new LivreurVelo(2, "Paul");
        Livreur livreur3 = new LivreurVelo(3, "Quentin");
        try {
            liste.ajouter(livreur);
            liste.ajouter(livreur2);
            liste.ajouter(livreur3);
            if (liste.rechercher(1) == livreur) {
                System.out.println("OK");
            } else {
                System.out.println("NOK");
            }
        } catch (ListeChaineeException e) {
            System.out.println("NOK");
        }
    }

    /**
     * Test de la méthode taille.
     */
    private static void testTaille() {
        System.out.print("Test taille : ");
        ListeChaineeLivreurs liste = new ListeChaineeLivreurs();
        Livreur livreur = new LivreurVelo(1, "Emilien");
        Livreur livreur2 = new LivreurVelo(2, "Paul");
        Livreur livreur3 = new LivreurVelo(3, "Quentin");
        try {
            liste.ajouter(livreur);
            liste.ajouter(livreur2);
            liste.ajouter(livreur3);
            if (liste.taille() == 3) {
                System.out.println("OK");
            } else {
                System.out.println("NOK");
            }
        } catch (ListeChaineeException e) {
            System.out.println("NOK");
        }
    }

    /**
     * Test de la méthode toArray.
     */
    private static void testToArray() {
        System.out.print("Test toArray : ");
        ListeChaineeLivreurs liste = new ListeChaineeLivreurs();
        Livreur livreur = new LivreurVelo(1, "Emilien");
        Livreur livreur2 = new LivreurVelo(2, "Paul");
        Livreur livreur3 = new LivreurVelo(3, "Quentin");
        try {
            liste.ajouter(livreur);
            liste.ajouter(livreur2);
            liste.ajouter(livreur3);
            if (Arrays.equals(liste.toArray(), new Livreur[] { livreur, livreur2, livreur3 })) {
                System.out.println("OK");
            } else {
                System.out.println("NOK");
            }
        } catch (ListeChaineeException e) {
            System.out.println("NOK");
        }
    }

    /**
     * Lancements des tests pour la classe ListeChaineeLivreurs.
     */
    public static void tests() {
        System.out.println("----- TEST ListeChaineeLivreurs -----");

        TestListeChaineeLivreurs.testTaille();
        TestListeChaineeLivreurs.testAjouter();
        TestListeChaineeLivreurs.testAjouterExistant();
        TestListeChaineeLivreurs.testSupprimer();
        TestListeChaineeLivreurs.testRechercher();
        TestListeChaineeLivreurs.testToArray();
    }
}
