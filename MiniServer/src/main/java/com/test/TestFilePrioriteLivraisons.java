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
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENTE, 1);
        Livraison TreeLivraison = new Livraison(Priorite.NORMALE, 2);
        Livraison ForLivraison = new Livraison(Priorite.URGENTE, 2);
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
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENTE, 1);
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
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();
        Livraison FirstLivraison = new Livraison(Priorite.NORMALE, 1);
        Livraison SecondLivraison = new Livraison(Priorite.URGENTE, 1);
        file.ajouterTout(Arrays.asList(FirstLivraison, SecondLivraison));
        file.retirer();
        if (file.taille() == 1) {
            System.out.println("OK");
        } else {
            System.out.println("NOK");
        }
    }

    /**
     * Test de l'ordre de priorité (compareTo de Livraison).
     */
    private static void testOrdrePriorite() {
        System.out.print("Test ordre de priorité (compareTo) : ");
        FilePrioriteLivraisons file = new FilePrioriteLivraisons();

        Livraison l1 = new Livraison(Priorite.NORMALE, 2);
        Livraison l2 = new Livraison(Priorite.URGENTE, 1);
        Livraison l3 = new Livraison(Priorite.NORMALE, 1);
        Livraison l4 = new Livraison(Priorite.NORMALE, 1);
        l4.nouvelleTentative();
        l4.nouvelleTentative();

        file.ajouterTout(Arrays.asList(l1, l2, l3, l4));

        if (file.retirer() == l2 &&
                file.retirer() == l4 &&
                file.retirer() == l3 &&
                file.retirer() == l1) {
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
        TestFilePrioriteLivraisons.testOrdrePriorite();
    }
}
