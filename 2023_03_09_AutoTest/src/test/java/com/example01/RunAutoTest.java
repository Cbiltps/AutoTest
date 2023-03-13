package com.example01;

/**
 * Created with IntelliJ IDEA.
 * Description: selenium的基础操作
 * User: cbiltps
 * Date: 2023-03-09
 * Time: 18:23
 */
public class RunAutoTest {
    public static void main(String[] args) throws InterruptedException {
        /*com.example01.FirstAutoTest test = new com.example01.FirstAutoTest();
        test.baiduAutoTest();*/

        AutoTest test = new AutoTest();
        test.startDriver();
//        test.positioning();
//        test.operate();
//        test.testWait();
        test.testImplicitAndDisplayWait();
        test.closeDriver();
    }
}