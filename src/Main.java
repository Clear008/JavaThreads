public class Main {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
            Talkative talkative = new Talkative(i);
            threads[i] = new Thread(talkative);
            threads[i].start();
        }
    }
}