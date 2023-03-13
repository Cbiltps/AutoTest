package com.example01;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-09
 * Time: 18:26
 */
public class FirstAutoTest {
    public void baiduAutoTest() throws InterruptedException {
        FirefoxDriver driver = new FirefoxDriver();
        driver.get("https://www.baidu.com");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#kw")).sendKeys("黑大帅");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#su")).click();
        Thread.sleep(5000);
        driver.quit();
    }
}