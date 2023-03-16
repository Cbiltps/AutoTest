package com.example03;

import org.junit.jupiter.api.AfterAll;

/**
 * Created with IntelliJ IDEA.
 * Description: junit5
 * User: cbiltps
 * Date: 2023-03-15
 * Time: 18:10
 */
public class AutoTest {
    // 创建一个驱动来打开浏览器后进入百度
//    private FirefoxDriver driver = new FirefoxDriver();

    /**
     * @Test 注解: 表示一个方法/用例, 不依赖main函数入口
     */
//    @Test
//    void noMainTest() {
//        driver.get("https://www.baidu.com");
//        driver.findElement(By.cssSelector("#kw")).sendKeys("鞠婧祎");
//        driver.findElement(By.cssSelector("#su")).click();
//        driver.quit();
//    }

    /**
     * @Test 注解: 表示一个方法/用例
     * @BeforeEach 注解: 表示被注解的方法应该在其他方法之 前 (其他方法执行前都要执行一遍)
     * @AfterEach 注解: 表示被注解的方法应该在其他方法之 后 (其他方法执行后都要执行一遍)
     */
    @org.junit.jupiter.api.Test
//    @BeforeEach
//    @AfterEach
    void aaa() {
        System.out.println("aaa");
    }

    /**
     * @BeforeAll 表示被注解的方法应该在其他方法之 前 (其他所有方法执行之前只需要执行一遍), 被注解的方法必须用static修饰!
     * @AfterAll 表示被注解的方法应该在其他方法之 后 (其他所有方法执行之后只需要执行一遍), 被注解的方法必须用static修饰!
     */
//    @Test
//    @BeforeAll
    @AfterAll
    static void bbb() {
        System.out.println("bbb");
    }

    @org.junit.jupiter.api.Test
    void ccc() {
        System.out.println("ccc");
    }
}
