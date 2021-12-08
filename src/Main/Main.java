package Main;


public class Main {

    public static void main(String[] args) {
        final int width = 800;
        final int height = 600;
        Window window = new Window("JavaGFX", width, height);
        int status = 0;
        window.run();
        System.exit(status);
    }
}
