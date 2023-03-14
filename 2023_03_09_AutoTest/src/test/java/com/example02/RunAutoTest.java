package com.example02;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: cbiltps
 * Date: 2023-03-13
 * Time: 16:34
 */
public class RunAutoTest {
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
