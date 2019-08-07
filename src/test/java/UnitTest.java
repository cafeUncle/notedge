import org.junit.Test;

/**
 * Created by yangyao on 2019/3/14.
 */
public class UnitTest {

    @Test
    public void testWhenDebugDoesOtherThreadAlreadyRunnable() {
        new Thread(() -> {
            while (true) {
                System.out.println(1);
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(2);

        // when debugging suspend this line, other threads will be suspended too.
        System.out.println(3);
    }
}
