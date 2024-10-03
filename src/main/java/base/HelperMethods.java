package base;

public class HelperMethods extends BaseMethods {

    public void waitFor(int seconds) {
        try {
            Thread.sleep(seconds *1000);
        } catch (InterruptedException e) {
            // e.printStackTrace();
        }
    }

}