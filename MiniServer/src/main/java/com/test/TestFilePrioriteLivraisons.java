package com.test;

import com.gestionnaireLivraisons.FilePrioriteLivraisons;
import com.gestionnaireLivraisons.Livraison;
import com.gestionnaireLivraisons.Priorite;

import java.util.Arrays;
import java.util.Random;

public class TestFilePrioriteLivraisons {
    /**
     * Test de la méthode estVide.
     */
    private static void testEstVide() {
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        System.out.print("Test estVide : ");
        if (file.estVide()) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }

    }

    /**
     * Test de la méthode ajouter.
     */
    private static void testAjouter() {
        System.out.println("Test ajouter : ");
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        file.ajouter(FirstLivraison);
        if (file.estVide()) {
            System.out.println("NOK");
        } else {
            System.out.println("OK");
        }

    }

    /**
     * Test de la méthode ajouterTout.
     */
    private static void testAjouterTout() {
        System.out.println("Test ajouterTout : ");
        String result = "";
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENT, 1);
        Livraison TreeLivraison = new Livraison(Priorite.NORMALE, 2);
        Livraison ForLivraison = new Livraison(Priorite.URGENT, 2);
        file.ajouterTout(Arrays.asList(FirstLivraison, SecondLivraison, TreeLivraison, ForLivraison));

        if (file.taille() == 4) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    /**
     * Test de la méthode taille.
     */
    private static void testTaille() {
        System.out.println("Test taille : ");
        String result = "";
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENT, 1);
        file.ajouterTout(Arrays.asList(FirstLivraison, SecondLivraison));
        if (file.taille() == 2) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    /**
     * Test de la méthode retirer.
     */
    private static void testRetirer() {
        System.out.println("Test retirer : ");
        String result = "";
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENT, 1);
        file.ajouterTout(Arrays.asList(FirstLivraison, SecondLivraison));
        file.retirer();
        if (file.taille() == 1) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    /**
     * Lancements des tests pour la classe FilePrioriteLivraisons.
     */
    public static void tests() {
        System.out.println("----- TEST FilePrioriteLivraisons -----");

        TestFilePrioriteLivraisons.testEstVide();
        TestFilePrioriteLivraisons.testAjouter();
        TestFilePrioriteLivraisons.testAjouterTout();
        TestFilePrioriteLivraisons.testTaille();
        TestFilePrioriteLivraisons.testRetirer();
    }
}
