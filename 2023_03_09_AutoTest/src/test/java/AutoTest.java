import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-09
 * Time: 18:23
 */
public class AutoTest {
    // 创建一个驱动来打开浏览器
    private FirefoxDriver driver = new FirefoxDriver();

    public void startDriver() throws InterruptedException {
        driver.get("https://www.baidu.com");
//        driver.get("http://news.baidu.com/");
//        driver.get("https://tool.lu/");
//        driver.get("file:///D:/selenium4html/selenium4html/modal.html");
//        driver.get("file:///D:/selenium4html/selenium4html/alert.html#");
//        driver.get("file:///D:/selenium4html/selenium4html/confirm.html");
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        driver.get("file:///D:/selenium4html/selenium4html/Prompt.html");
//        driver.get("file:///D:/selenium4html/selenium4html/level_locate.html#");
//        driver.get("file:///D:/selenium4html/selenium4html/select.html");
//        driver.get("file:///D:/selenium4html/selenium4html/upload.html");

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
         *
         */
    }

    /**
     * 释放驱动对象并关闭浏览器
     * @throws InterruptedException
     */
    public void closeDriver() {

        driver.quit();
    }


    public static void main(String[] args) throws InterruptedException {
        /*FirstAutoTest test = new FirstAutoTest();
        test.baiduAutoTest();*/

        AutoTest test = new AutoTest();
        test.startDriver();
        test.positioning();
        test.closeDriver();
    }
}
