public class Sommeur implements Runnable {
    private final int[] tableau;
    private final int debut;
    private final int fin;
    private int somme = 0;

    public Sommeur(int[] tableau, int debut, int fin) {
        this.tableau = tableau;
        this.debut = debut;
        this.fin = fin;
    }

    @Override
    public void run() {
        for (int i = debut; i < fin; i++) {
            somme += tableau[i];
        }
    }

    public int getSomme() {
        return somme;
    }
}