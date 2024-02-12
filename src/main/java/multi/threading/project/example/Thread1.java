package multi.threading.project.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Thread1 extends Thread{

    WebDriver driver;
    @Override
    public void run(){

        driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        System.out.println("Thread name is " +Thread.currentThread().getName());
        driver.close();
    }

    public static void main(String[] args) {

        Thread1 th = new Thread1();
        th.setName("Himanshu Thread");
        th.start();
        Thread1 th1 = new Thread1();
        th1.setName("Swati Thread");
        th1.start();


    }
}
