package com.example03;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Created with IntelliJ IDEA.
 * Description: 断言
 * User: cbiltps
 * Date: 2023-03-15
 * Time: 19:26
 */
public class AssertTest {

//    private FirefoxDriver driver = new FirefoxDriver();

    /**
     * 测试百度首页元素是否正确
     */
//    @Test
//    void detectionElement() {
//        driver.get("https://www.baidu.com");
//        String value = driver.findElement(By.cssSelector("#su")).getAttribute("value");
//        Assertions.assertEquals("百度一下", value);
////        Assertions.assertNotEquals("百度1一下", value);
//        driver.quit();
//    }

    /**
     * 学习Assertions.assertTrue();和Assertions.assertFalse();方法
     */
//    @Test
//    void assertTrueTest() {
//        Assertions.assertTrue(true);
////        Assertions.assertFalse(false);
//    }

    /**
     * 学习Assertions.assertNull();方法
     */
    @Test
    void assertNullTest() {
        Assertions.assertNull(null);
    }

    /**
     * 学习Assertions.assertNotNull();方法
     */
    @Test
    void assertNotNullTest() {
        String str = "a";
        Assertions.assertNotNull(str);
    }
    /**
     * 执行上面两个用例的时候, 发现先执行assertNotNullTest()后执行assertNullTest(), 这是为什么?
     * 注意: junit的默认执行顺序是不确定的, 官方文档也没有明确给出!
     * 但是, 我们仍然可以使用junit里提供的方法来手动设置用例的执行顺序!
     */
}
