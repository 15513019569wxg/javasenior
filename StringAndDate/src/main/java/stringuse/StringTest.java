package stringuse;

import org.junit.Test;
/**
 * String的使用
 * @author shkstart
 * @create 2019 上午 10:26
 */
@SuppressWarnings({"StringEquality", "NewObjectEquality", "ConstantConditions", "UnusedAssignment", "StringOperationCanBeSimplified"})
public class StringTest {
    /**
    结论：
     <blockquote>
        <p>1.通过字面量定义的变量型字符串放在常量池中。</p>
        <p>2.常量与常量的拼接结果在常量池, 而且常量池中不会存在相同内容的常量。</p>
        <p>3.只要其中有一个是变量，结果就在堆中。</p>
        4.如果拼接的结果调用intern()方法，返回值就在常量池中
     </blockquote>
     */
    @Test
    public void test4(){
        String s1 = "javaEEhadoop";
        String s2 = "javaEE";
        String s3 = s2 + "hadoop";
        //false
        System.out.println(s1 == s3);
        //s4:常量
        final String s4 = "javaEE";
        String s5 = s4 + "hadoop";
        //true
        System.out.println(s1 == s5);

    }

    @Test
    public void test3(){
        String s1 = "javaEE";
        String s2 = "hadoop";
        String s3 = "javaEEhadoop";
        String s4 = "javaEE" + "hadoop";
        String s5 = s1 + "hadoop";
        String s6 = "javaEE" + s2;
        String s7 = s1 + s2;

        //true
        System.out.println(s3 == s4);
        //false
        System.out.println(s3 == s5);
        //false
        System.out.println(s3 == s6);
        //false
        System.out.println(s3 == s7);
        //false
        System.out.println(s5 == s6);
        //false
        System.out.println(s5 == s7);
        //false
        System.out.println(s6 == s7);
        //返回值得到的s8使用的常量值中已经存在的“javaEEhadoop”
        String s8 = s6.intern();
        //true
        System.out.println(s3 == s8);


    }

    /**
    String的实例化方式：
    <blockquote>
        <p>方式一：通过字面量定义的方式</p>
        <p>方式二：通过new + 构造器的方式</p>
        <hr>
         <Strong>面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对象？<br>
         &nbsp;&nbsp; 两个: 一个是堆空间中new结构，另一个是char[]对应的常量池中的数据："abc" </Strong>
     </blockquote>
     */
    @Test
    public void test2(){
        //通过字面量定义的方式：此时的s1和s2的数据javaEE声明在方法区中的字符串常量池中。
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new + 构造器的方式:此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值。
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");
        //true
        System.out.println(s1 == s2);
        //false
        System.out.println(s1 == s3);
        //false
        System.out.println(s1 == s4);
        //false
        System.out.println(s3 == s4);

        System.out.println("***********************************************************************************************");
        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Tom",12);

        //true
        System.out.println(p1.name.equals(p2.name));
        //true
        System.out.println(p1.name == p2.name);
        p1.name = "Jerry";
        //Tom
        System.out.println(p2.name);
    }


    /**
    String:字符串，使用一对""引起来表示。
    <p>
        <em>1.String声明为final的，不可被继承</em><br>
        2.String实现了<font color="yellow">Serializable</font>接口：表示字符串是支持序列化的; 实现了
         <font color="yellow">Comparable</font>接口：表示String可以比较大小<br>
        <Strong style="color: red;">
        3. String内部定义了final char[] value用于存储字符串数据
         </Strong><br>
        4.String:代表不可变的字符序列。简称：不可变性。
         <blockquote>
            <Strong>
            体现: 1.当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。<br>
                 2. 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。<br>
                 3. 当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。<br>
            </Strong>
         </blockquote>
        5.通过字面量的方式（区别于new）给一个字符串赋值，此时的字符串值声明在字符串常量池中。<br>
        6.字符串常量池中是不会存储相同内容的字符串的。<br>
     </p>
     */
    @Test
    public void test1(){
        //字面量的定义方式
        String s1 = "abc";
        // TODO-1 当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值。
        String s2 = "abc";
        s1 = "hello";
        //比较s1和s2的地址值 false
        System.out.println(s1 == s2);
        //hello
        System.out.println(s1);
        //abc
        System.out.println(s2);
        System.out.println("********************************************************************************************");
        // TODO-2 当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
        String s3 = "abc";
        s3 += "def";
        //abcdef
        System.out.println(s3);
        System.out.println(s2);
        System.out.println("********************************************************************************************");
        // TODO-3 当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值。
        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        //abc
        System.out.println(s4);
        //mbc
        System.out.println(s5);
    }

}
