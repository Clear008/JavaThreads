public class Talkative implements Runnable {
    private int value;

    // Constructeur
    public Talkative(int value) {
        this.value = value;
    }

    // Méthode run
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("Thread Value: " + value);
        }
    }
}