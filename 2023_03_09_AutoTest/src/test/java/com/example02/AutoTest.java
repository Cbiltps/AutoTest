package com.example02;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-13
 * Time: 16:33
 */
public class AutoTest {
    // 创建一个驱动来打开浏览器后进入百度
    private FirefoxDriver driver = new FirefoxDriver();

    public void startDriver() throws InterruptedException {
        driver.get("https://www.baidu.com");
//        driver.get("https://news.baidu.com/");
//        driver.get("https://tool.lu/");
//        driver.get("file:///Users/cbiltps/Downloads/ClassCode/selenium4html/modal.html");
//        driver.get("file:///Users/cbiltps/Downloads/ClassCode/selenium4html/alert.html");
//        driver.get("file:////Users/cbiltps/Downloads/ClassCode/selenium4html/confirm.html");
//        driver.get("file:///Users/cbiltps/Downloads/ClassCode/selenium4html/Prompt.html");
//        driver.get("file:///Users/cbiltps/Downloads/ClassCode/selenium4html/level_locate.html");
//        driver.get("file:///Users/cbiltps/Downloads/ClassCode/selenium4html/select.html");
//        driver.get("file:///Users/cbiltps/Downloads/ClassCode/selenium4html/upload.html");

//        Thread.sleep(2000);
    }

    public void testPrint() throws InterruptedException {
        Thread.sleep(2000);
        // 进入到百度首页之后, 点击新闻超链接
        driver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();
        Thread.sleep(2000);
        String curUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println("expect: 百度新闻——海量中文资讯平台");
        System.out.println("actual: " + title);
        System.out.println();
        System.out.println("expect: https://news.baidu.com/");
        System.out.println("actual: " + curUrl);
        /**
         * 为什么打印出来的结果不符合预期?
         * 因为, 点击超链接之后打开了一个新的标签页, selenium不知道展示哪一个页面!
         * 但是, selenium对每一个标签页都记录了一个 唯一标识 (虽然不会 主动 跳到我们预期的页面), 称为句柄!
         * 通过 唯一标识 才可以跳到我们想要的页面!
         *
         * 问题: 如何打印句柄?
         */
    }

    /**
     * 通过 唯一标识 才可以跳到我们想要的页面!
     * 跳到我们想要的页面, 下面才打印出了我们想要的标题和URL!
     * @throws InterruptedException
     */
    public void jumpWindow() throws InterruptedException {
        // 获取当前页面的句柄
        String curWindow1 = driver.getWindowHandle();
//        System.out.println("curWindow1-handle: " + curWindow1);

        driver.findElement(By.cssSelector("#s-top-left > a:nth-child(1)")).click();
        Thread.sleep(2000);

        // 获取当前页面的句柄
        String curWindow2 = driver.getWindowHandle();
//        System.out.println("curWindow2-handle: " + curWindow2);

        // 获取所有页面的句柄
        Set<String> allWindow = driver.getWindowHandles();

        // 如何跳转到我想去的页面呢? 从allWindow挑选出我想去的页面.
        for (String windows : allWindow){
            if(windows != curWindow1){
                // 跳转(手动)到该句柄(页面)
                driver.switchTo().window(windows);
//                System.out.println("everyWindow-handle: " + windows);
            }
        }

        String curUrl = driver.getCurrentUrl();
        String title = driver.getTitle();
        System.out.println("expect: 百度新闻——海量中文资讯平台");
        System.out.println("actual: " + title);
        System.out.println();
        System.out.println("expect: https://news.baidu.com/");
        System.out.println("actual: " + curUrl);
    }

    public void sizeOfWindow() throws InterruptedException {
        // 窗口最大化
//        driver.manage().window().maximize();
//        Thread.sleep(2000);
//        driver.manage().window().minimize();
//        Thread.sleep(2000);
//        driver.manage().window().setSize(new Dimension(1000, 800));
//        Thread.sleep(2000);

        /**
         * selenium不能直接编译js语言, 但是可以通过方法来执行js语言!
         * 下面是通过executeScript()方法来控制执行js进行页面滑动至底/上, 其参数为js语言的字符串!
         */
        driver.executeScript("window.scroll(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        driver.executeScript("window.scroll(0, document.body.scrollTop)");
        Thread.sleep(2000);
    }

    /**
     * 导航(针对一个页面的前进和后退).
     * 注意: 点击连接进入一个新的标签页, 是无法前进和后退的!
     * @throws InterruptedException
     */
    public void navigate() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#nav > div > div > ul > li:nth-child(1) > a")).click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
    }

    public void alert() throws InterruptedException {
        /**
         * 普通弹窗的操作思路
         */
//        Thread.sleep(1000);
//        driver.findElement(By.cssSelector("#show_modal")).click();
//        Thread.sleep(1000);
//        // 关闭弹窗
//        driver.findElement(By.cssSelector("#myModal > div.modal-footer > button:nth-child(1)")).click();
//        Thread.sleep(1000);

        /**
         * 警告弹窗的处理
         */
//        Thread.sleep(1000);
//        driver.findElement(By.xpath("//*[@id=\"tooltip\"]")).click();
//        // 切换到警告弹窗上
//        Alert alert = driver.switchTo().alert();
//        // 点击确认按钮
//        Thread.sleep(1000);
//        alert.accept();
//        Thread.sleep(1000);

        /**
         * 确认弹窗
         */
 /*       Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/input")).click();
        // 切换到确认弹窗
        Alert alert =  driver.switchTo().alert();
        Thread.sleep(1000);
        // 点击弹窗上的确认按钮/取消按钮
//        alert.dismiss();
        alert.accept();
        Thread.sleep(3000);*/

        /**
         * 提示输入弹窗
         */
        driver.findElement(By.xpath("/html/body/input")).click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("祥子天下无敌");
        Thread.sleep(1000);
        alert.accept();
        Thread.sleep(3000);
    }

    /**
     * 鼠标和键盘的操作
     * @throws InterruptedException
     */
    public void mouseAndKeyboard() throws InterruptedException {
        Thread.sleep(2000);
     /*   driver.findElement(By.cssSelector("body > div:nth-child(2) > div > div > a")).click();
        // 模拟鼠标移动到我们想要的元素上并点击
        WebElement element = driver.findElement(By.cssSelector("#dropdown1 > li:nth-child(2) > a"));
        Actions actions = new Actions(driver);
        actions.clickAndHold(element).perform();// 点击左键不松手
//        actions.click(element).perform();// 点击左键
        Thread.sleep(3000);*/

        // 键盘的操作
        WebElement element = driver.findElement(By.cssSelector("#kw"));
        element.sendKeys("selenium");
    }

    /**
     * 下拉菜单的操作
     * @throws InterruptedException
     */
    public void select() throws InterruptedException {
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.cssSelector("#ShippingMethod"));
        Select select = new Select(element);
        select.selectByIndex(0);// 通过索引来定位选项
        Thread.sleep(2000);
        select.selectByValue("10.69");// 通过value属性定位选项
        Thread.sleep(2000);
        select.selectByVisibleText("USPS Priority Mail ==> $7.45");// 通过可见文本定位选项
        Thread.sleep(5000);
    }

    public void fileUpload() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("body > div > div > input[type=file]"));
        element.sendKeys("/Users/cbiltps/Downloads/ClassCode/selenium4html/upload.html");// 上传文件时键盘输入文件路径
        Thread.sleep(3000);
    }

    public void screenshot() throws IOException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.findElement(By.cssSelector("#kw")).sendKeys("鞠婧祎");
        driver.findElement(By.cssSelector("#su")).click();
        // 屏幕截图
        File screenFile = driver.getScreenshotAs(OutputType.FILE);
        // 将截图文件保存至指定路径下
        File targetFile = new File("./src/test/ScreenFile/b.png");
        FileUtils.copyFile(screenFile, targetFile);
        driver.findElement(By.cssSelector(".paragraph_Hq6qX > span:nth-child(1) > span:nth-child(1)"));
    }

    /**
     * 释放驱动对象并关闭浏览器
     * @throws InterruptedException
     */
    public void closeDriver() {
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        AutoTest test = new AutoTest();
        test.startDriver();
//        test.testPrint();
//        test.jumpWindow();
//        test.sizeOfWindow();
//        test.navigate();
//        test.alert();
//        test.mouseAndKeyboard();
//        test.select();
//        test.fileUpload();
        test.screenshot();
        test.closeDriver();
    }
}
