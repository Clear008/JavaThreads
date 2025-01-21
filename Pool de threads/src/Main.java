import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        int[] tableau = new int[1000];
        for (int i = 0; i < tableau.length; i++) {
            tableau[i] = i + 1;
        }
        int nombreThreads = 4;

        int taille = tableau.length / nombreThreads;

        // Création du pool de threads
        ExecutorService pool = Executors.newFixedThreadPool(nombreThreads);


        List<Sommeur> sommeurs = new ArrayList<>();

        // Création et soumission des tâches
        for (int i = 0; i < nombreThreads; i++) {
            int debut = i * taille;
            int fin = (i == nombreThreads - 1) ? tableau.length : (i + 1) * taille;

            Sommeur sommeur = new Sommeur(tableau, debut, fin);
            sommeurs.add(sommeur);
            pool.submit(sommeur);
        }


        pool.shutdown();
        try {

            pool.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            System.err.println("Interruption pendant l'attente des threads");
        }

        // Calcul de la somme totale
        int sommeTotal = 0;
        for (Sommeur sommeur : sommeurs) {
            sommeTotal += sommeur.getSomme();
        }

        System.out.println("La somme totale est : " + sommeTotal);
    }
}
