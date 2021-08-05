package Test02;

import java.util.TimerTask;

/**
 * @className Task
 * @author:ShanXuerui
 * @date 2020/10/16 15:57
 */
public class Task extends TimerTask {
    @Override
    public void run() {
        System.out.println("继承TimerTask");
    }
}
