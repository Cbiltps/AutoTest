package com.example01;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;

/**
 * Created with IntelliJ IDEA.
 * Description: selenium的基础操作
 * User: cbiltps
 * Date: 2023-03-09
 * Time: 18:23
 */
public class AutoTest {
    // 创建一个驱动来打开浏览器后进入百度
    private FirefoxDriver driver = new FirefoxDriver();
    public void startDriver() throws InterruptedException {
        driver.get("https://www.baidu.com");

//        Thread.sleep(2000);
    }

    /**
     * 定位元素
     * @throws InterruptedException
     */
    public void positioning() throws InterruptedException {
        // 通过 css选择器 寻找
//        String news = driver.findElement(By.cssSelector("a.mnav:nth-child(1)")).getText();
//        System.out.println("news: " + news);

        // 通过 xpath路径 寻找
//        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("鞠婧祎");
//        driver.findElement(By.xpath("//*[@id=\"su\"]")).click();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[1]/div[3]/div[1]/div[1]/div/div/div/div/div[1]/div/" +
//                "a/div/p/span/span"));

        String text = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/div/div/div[3]/ul/li/a/span[2" +
                "]")).getText();
        System.out.println("预期: " + "国务院秘书长、各部部长等名单");
        System.out.println("实际: " + text);
        /**
         * 上面为什么打印出来的不一样?
         * 注意: 定位的元素, 一定要唯一!
         * 如果定位元素不唯一, 可能导致定位失败或者定位的不是想要的元素!
         */
    }

    /**
     * 操作元素
     */
    public void operate() throws InterruptedException {
        // 点击行为 click()
//        driver.findElement(By.xpath("//*[@id=\"su\"]")).click();
//        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/div/div/div[3]/ul/li[1]/a/span[2]")).click();

        // 提交行为 submit()
//        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("鞠婧祎");
//        driver.findElement(By.xpath("//*[@id=\"su\"]")).submit();

//        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[5]/div/div/div[3]/ul/li/a/span[2]")).submit();// error
        /**
         * 虽然click和submit都可以有点击的作用;
         * 但是, 非按钮使用提交操作会报错!
         * Exception in thread "main" org.openqa.selenium.JavascriptException: Error: Unable to find owning document
         * 所以, 官方文档不建议使用submit, click可以走天下!
         */

        // 模拟键盘输入 sendKeys("鞠婧祎")
//        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("鞠婧祎");
//        Thread.sleep(3000);

        // 清楚对象输入的文本内容
//        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("鞠婧祎");
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//*[@id=\"kw\"]")).clear();
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//*[@id=\"kw\"]")).sendKeys("倪妮");

        // 获取文本 getText()
//        String text = driver.findElement(By.cssSelector("li.hotsearch-item:nth-child(3) > a:nth-child(1) > span:nth-child(4)")).getText();
//        System.out.println("预期: " + "国务院副总理等集体进行宪法宣誓");
//        System.out.println("实际: " + text);

//        String text = driver.findElement(By.cssSelector("#su")).getText();
//        System.out.println("预期: " + "百度一下");
//        System.out.println("实际: " + text);
        /**
         * value="百度一下"
         * 注意: 上面的"百度一下"是value的属性! 不是文本!
         */
        // 如何获取属性? getAttribute()
        String value = driver.findElement(By.cssSelector("#su")).getAttribute("value");
        System.out.println("预期: " + "百度一下");
        System.out.println("实际: " + value);

        Thread.sleep(2000);
    }

    public void testWait() throws InterruptedException {
        //强制等待
//        driver.findElement(By.cssSelector("#kw")).sendKeys("鞠婧祎");
//        driver.findElement(By.cssSelector("#su")).click();
//        Thread.sleep(3000);// 没有这段代码的时候就会抛异常??? 为什么?
        /**
         * 原因是代码的执行速度比较快, 前端网页渲染的速度相对比较慢一点!
         * 这就导致了代码执行到下一步了, 页面还没有渲染出来, 元素到找不到!
         */
//        driver.findElement(By.cssSelector(".paragraph_Hq6qX > span:nth-child(1) > span:nth-child(1)"));

        // 隐式等待
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        driver.findElement(By.cssSelector("#kw")).sendKeys("鞠婧祎");
//        driver.findElement(By.cssSelector("#su")).click();
//        driver.findElement(By.cssSelector(".paragraph_Hq6qX > span:nth-child(1) > span:nth-child(1)"));

        // 显示等待
        driver.findElement(By.cssSelector("#kw")).sendKeys("鞠婧祎");
        driver.findElement(By.cssSelector("#su")).click();
        WebDriverWait o = new WebDriverWait(driver, Duration.ofSeconds(3));// 实例化一个等待对象并设置强制等待的时间为三秒
        // 轮询等待对象, 如果在 强制等待的时间 内没有 满足条件 既 抛出异常!
        // 下面的条件是: 检查页面是否存在对应的元素
//        o.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".paragraph_Hq6qX > span:nth-child(1) > s" +
//                "pan:nth-child(1)")));
        // 检查页面元素对应的文本信息是否正确
        o.until(ExpectedConditions.textToBe(By.cssSelector(".paragraph_Hq6qX > span:nth-child(1) > s" +
                "pan:nth-child(1)"), "鞠婧祎"));
    }

    /**
     * 同时使用隐式等待和显示等待, 隐式等待为3秒, 显示等待为10秒, 最终执行时间是多少?
     *     打印出来的时间是10秒左右!
     *
     * 所以, 执行结果并不会想预期的那样, 不建议同时使用!
     */
    public void testImplicitAndDisplayWait() {
        // 设置时间格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 打印时间戳
        System.out.println(dateFormat.format(System.currentTimeMillis()));
        // 隐式等待
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // 输入
        driver.findElement(By.cssSelector("#kw")).sendKeys("鞠婧祎");
        // 点击
        driver.findElement(By.cssSelector("#su")).click();
        // 显示等待
        WebDriverWait o = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            o.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".paragraph_Hq6qX > span:nth-child(1) > s" +
                    "pan:nth-child(10)")));
        } catch (Exception e) {
            // 没有找到抛出TimeoutException异常
            System.out.println("TimeoutException");
        }
        System.out.println(dateFormat.format(System.currentTimeMillis()));
    }

    /**
     * 释放驱动对象并关闭浏览器
     * @throws InterruptedException
     */
    public void closeDriver() {
        driver.quit();
    }
}
