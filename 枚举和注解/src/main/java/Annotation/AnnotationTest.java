package Annotation;

import org.testng.annotations.Test;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

interface Info {
    void show();
}

/**
 * 注解的使用<br>
 * 1. 理解Annotation:<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;* ① jdk 5.0 新增的功能<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;* ② Annotation 其实就是代码里的特殊标记, 这些标记可以在编译时或者类加载时或者运行时被读取, 并执行相应的处理。通过使用Annotation,程序员可以在不改变原有逻辑的情况下, 在源文件中嵌入一些补充信息。<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;* ③在JavaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。在JavaEE/Android中注解占据了更重要的角色，例如用来配置应用程序的任何切面，代替JavaEE旧版中所遗留的繁冗代码和XML配置等。<br>
 * 2. Annotation的使用示例<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;* 示例一：生成文档相关的注解<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;* 示例二：在编译时进行格式检查(JDK内置的三个基本注解)<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;    @Override: 限定重写父类方法, 该注解只能用于方法<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;    @Deprecated: 用于表示所修饰的元素(类, 方法等)已过时。通常是因为所修饰的结构危险或存在更好的选择<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;    @SuppressWarnings: 抑制编译器警告<br>
 * 示例三：跟踪代码依赖性，实现替代配置文件功能<br>
 * 3. 如何自定义注解：参照@SuppressWarnings定义<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;* ① 注解声明为：@interface<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;* ② 内部定义成员，通常使用value表示<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;* ③ 可以指定成员的默认值，使用default定义<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;* ④ 如果自定义注解没有成员，表明是一个标识作用。<br>
 &nbsp;&nbsp;&nbsp;&nbsp;* 如果注解有成员，在使用注解时，需要指明成员的值。自定义注解必须配上注解的信息处理流程(使用反射)才有意义。自定义注解通过都会指明两个元注解：Retention、Target
 * <p>
 * 4. jdk 提供的4种元注解<br>
 * 元注解：对现有的注解进行解释说明的注解<br>
 &nbsp;&nbsp;&nbsp;&nbsp;* Retention：指定所修饰的 Annotation 的生命周期：SOURCE\CLASS(默认行为)\RUNTIME, 只有声明为RUNTIME生命周期的注解，才能通过反射获取。  <br>
 &nbsp;&nbsp;&nbsp;&nbsp;* Target:用于指定被修饰的 Annotation 能用于修饰哪些程序元素  <br>
 &nbsp;&nbsp;&nbsp;&nbsp;* ******出现的频率较低*******  <br>
 &nbsp;&nbsp;&nbsp;&nbsp;* Documented:表示所修饰的注解在被javadoc解析时，保留下来。  <br>
 &nbsp;&nbsp;&nbsp;&nbsp;* Inherited:被它修饰的 Annotation 将具有继承性。  <br>
 * 5.通过反射获取注解信息 ---到反射内容时系统讲解<br>
 * 6. jdk 8 中注解的新特性：可重复注解、类型注解<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;6.1 可重复注解：
 *  &nbsp;&nbsp;&nbsp;&nbsp;① 在MyAnnotation上声明@Repeatable，成员值为MyAnnotations.class<br>
 * &nbsp;&nbsp;&nbsp;&nbsp; ② MyAnnotation的Target和Retention等元注解与MyAnnotations相同。<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;6.2 类型注解：<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;ElementType.TYPE_PARAMETER 表示该注解能写在类型变量的声明语句中（如：泛型声明）。<br>
 * &nbsp;&nbsp;&nbsp;&nbsp;ElementType.TYPE_USE 表示该注解能写在使用类型的任何语句中。<br>
 *
 * @author shkstart
 * @create 2019 上午 11:37
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person p = new Student();
        p.walk();
        @Deprecated
        Date date = new Date(2020, Calendar.NOVEMBER, 11);
        System.out.println(date);
        @SuppressWarnings("unused")
        int num = 10;
        //System.out.println(num);
        @SuppressWarnings({"unused", "rawtypes"})
        ArrayList list = new ArrayList();
    }

    @Test
    public void testGetAnnotation() {
        Class<Student> clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        // 反射查看注解是否被继承
        Arrays.stream(annotations).forEach(System.out::println);
    }
}

//jdk 8之前的写法：
//@MyAnnotations({@MyAnnotation(value="hi"),@MyAnnotation(value="hi")})
@MyAnnotation(value = "hi")
@MyAnnotation(value = "abc")
class Person {
    private String name;
    private int age;

    public Person() {}

    @MyAnnotation
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @MyAnnotation
    public void walk() {
        System.out.println("人走路");
    }

    public void eat() {
        System.out.println("人吃饭");
    }
}

class Student extends Person implements Info {
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    public void show() {}
}

class Generic<@MyAnnotation T> {
    public void show() throws @MyAnnotation RuntimeException {
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }

}