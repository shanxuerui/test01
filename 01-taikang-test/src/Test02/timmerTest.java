package Test02;

import java.util.Timer;

/**
 * @className timmerTest
 * @author:ShanXuerui
 * @date 2020/10/16 15:59
 */
public class timmerTest {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
//        从1秒后，每过3秒执行一次
         timer.schedule(new Task(), 1000, 3000);

    }
}
