package com.example03;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

/**
 * Created with IntelliJ IDEA.
 * Description: 下面注解的意思是~标注当前类使用方法来进行排序.
 * 有一个问题: 为什么需要用到junit里的排序方法?
 *     如果用例之间存在关联关系(耦合), 那么就需要手动的指定用例的执行顺序.
 *     我们在编写测试用例的时候保持用例的独立性(低耦合)!
 * 举个例子: 用例A的选出来的结果是用例B的输入, 那就没必要在用例B中再次寻找"用例A的选出来的结果"(太冗余), 并且A在前B在后, junit无法保证顺序, 此注解
 *     即可保证顺序, 最后把"用例A的选出来的结果"调给B即可!
 * User: cbiltps
 * Date: 2023-03-16
 * Time: 01:02
 */
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderTest {
    @Test
    @Order(1)
    void one() {
        System.out.println("aaa");
    }

    @Test
    @Order(2)
    void two() {
        System.out.println("bbb");
    }

    @Test
    @Order(3)
    void three() {
        System.out.println("ccc");
    }

    @Test
    @Order(4)
    void four() {
        System.out.println("ddd");
    }

    @Test
    @Order(5)
    void five() {
        System.out.println("eee");
    }
}