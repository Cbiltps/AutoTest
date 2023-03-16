package com.example03;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * 场景举例: 登录的时候, 需要多个(常规及非常规)用户名及密码登录, 不用写多条测试用例(冗余)代码!
 * User: cbiltps
 * Date: 2023-03-16
 * Time: 05:16
 */
public class ParameterTest {
//    @ParameterizedTest // 标注方法类型为参数化, 不需要再添加@Test注解, 如果添加该用例会多执行一遍
//    @ValueSource(strings = {"鞠婧祎", "迪丽热巴", "Lisa"}) // 单参数
//    void printName(String name) {
//        System.out.println("name: " + name);
//    }

//    @ParameterizedTest //如果名字有"逗号", 用'单引号'转义, 看下面的'迪丽,热巴'
//    @CsvSource(value = {"鞠婧祎, 21", "'迪丽,热巴', 30", "Lisa, 25"}) // 多参数, 默认的分隔符是逗号, 分隔符可以自己设置
//    void printNameAndAge(String name, int age) {
//        System.out.println("name: " + name + " age: " + age);
//    }

    // 手动指定分隔符
//    @ParameterizedTest // 下面数字类型的参数必须有值, 否则会导致用例执行失败
//    @CsvSource(value = {"鞠婧祎-21", "迪丽热巴-30", "Lisa-25"}, delimiterString = "-") // 多参数, 默认的分隔符是逗号, 分隔符可以自己设置
//    void printNameAndAge(String name, int age) {
//        System.out.println("name: " + name + " age: " + age);
//    }

//    @ParameterizedTest //如果名字有"逗号", 用'单引号'转义, 看下面的'迪丽,热巴'
//    @CsvFileSource(resources = "/NameAndAge.csv")
//    void printNameAndAge(String name, int age) {
//        System.out.println("name: " + name + " age: " + age);
//    }

    // 动态参数(单参数)
//    @ParameterizedTest
//    @MethodSource("data") // 参数是数据来源的方法名
//    void dynamicTest(String str) {
//        System.out.println(str);
//    }
//
//     static Stream<String> data() {
//        return Stream.of("鞠婧祎", "蔡徐坤", "张天爱");
//    }

    // 动态参数(单参数)另外还有一个写法: 如果不指定数据来源, 则默认找跟用例 同名 的静态方法!
//    @ParameterizedTest
//    @MethodSource
//    void dynamicTest(String str) {
//        System.out.println(str);
//    }
//
//    static Stream<String> dynamicTest() {
//        return Stream.of("鞠婧祎", "蔡徐坤", "张天爱");
//    }

    // 动态参数(多参数)
    @ParameterizedTest
    @MethodSource
    void dynamicTest2(String name, int age) {
        System.out.println("name: " + name + " age: " + age);
    }

    static Stream<Arguments> dynamicTest2() {
        return  Stream.of(Arguments.arguments("鞠婧祎", 21),
                Arguments.arguments("迪丽热巴", 30),
                Arguments.arguments("Lisa", 25)
        );
    }
}