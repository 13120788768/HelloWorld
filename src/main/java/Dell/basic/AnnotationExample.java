package Dell.basic;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//表示作用的类型， TYPE这里表示可作用在类、接口、枚举身上
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME) // 运行时
@Inherited // 可继承
@Documented //表示是否生成Java doc，一般我们都会把它加上
public @interface AnnotationExample { //@interface 语法声明
    String info() default "";
}
/**
 * 注解
 * 比较抽象的理解就是，用来标记程序的，这些标记在类加载，编译，运行时被读取，最后做出响应的处理。
 * 注解的本身其实也是一种配置，在传统开发中，我们会通过各种配置文件比如xml,yml这些文件来配置我们的程序，当大量配置时，无疑代码可读性会很差。
 * 通过注解，我们就可以很方便的给程序打上标签，很清楚的表名它是干嘛用。
 *
 * 我们先看一个完整的注解定义:
 * @Target({ElementType.TYPE, ElementType.METHOD}) // 可作用类接口枚举
 * @Retention(RetentionPolicy.RUNTIME) // 运行时
 * @Inherited // 可继承
 * @Documented
 * public @interface Log1 {
 *     String info() default "";
 * }
 * 「@Target(ElementType.TYPE)」 表示作用的类型， TYPE这里表示可作用在类、接口、枚举身上
 * 「@Retention(RetentionPolicy.RUNTIME)」 表示作用在运行时
 * 「@Inherited」 表明可继承，Spring源码中有出现过，还可以跟 「@AliasFor(value="xx")」 结合去使用,后边也会举例
 * 「@Documented」 表示是否生成Java doc，一般我们都会把它加上
 * 「@interface」 语法声明，没啥好说的
 * 「String info() default "";」 这里要说明一下，这个不是Log1注解的方法，它是它的一个属性，你可以理解为字段，String表明类型， default是默认值。
 */
