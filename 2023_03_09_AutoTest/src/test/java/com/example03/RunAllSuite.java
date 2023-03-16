package com.example03;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

/**
 * Created with IntelliJ IDEA.
 * Description: 这是一个测试套件, 将我们所有的用例都执行起来
 *     测试套件有两个方法:
 *     1: 指定 类 添加到套件中并执行
 *     2: 指定 包 添加到套件中并执行~~~执行包下面所有以Test(开头或结尾)命名的文件且其中所有 @Test注解 的用例!
 * User: cbiltps
 * Date: 2023-03-16
 * Time: 02:35
 */
@Suite
//@SelectClasses({AutoTest.class, AssertTest.class, AssertTest.class})
@SelectPackages("com.example03")
public class RunAllSuite {
}