package stringuse;

import org.junit.Test;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * 涉及到String类与其他结构之间的转换
 * @author shkstart
 * @create 2019 下午 2:39
 */
@SuppressWarnings({"AlibabaTestClassShouldEndWithTestNaming", "StringEquality"})
public class StringTest1 {
    /**
    String 与 byte[]之间的转换
        <p>编码：String --> byte[]:调用String的getBytes()</p>
        <p>解码：byte[] --> String:调用String的构造器</p>
        <hr>
        <p>编码：字符串-->字节(看得懂 --->看不懂的二进制数据)</p>
        <p>解码：编码的逆过程，字节--> 字符串(看不懂的二进制数据---> 看得懂)</p>
    <em>说明：解码时，要求解码使用的字符集必须与编码时使用的字符集一致，否则会出现乱码。</em>
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        //使用默认的字符集进行编码。
        byte[] bytes = str1.getBytes();
        System.out.println(Arrays.toString(bytes));
        //使用gbk字符集进行编码。
        byte[] gbks = str1.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));
        System.out.println("**********************************************************************************************");
        //使用默认的字符集，进行解码。
        String str2 = new String(bytes);
        System.out.println(str2);
        String str3 = new String(gbks);
        //出现乱码。原因：编码集和解码集不一致！
        System.out.println(str3);
        String str4 = new String(gbks, "gbk");
        //没有出现乱码。原因：编码集和解码集一致！
        System.out.println(str4);
    }

    /**
        String 与 char[]之间的转换
        <p>String --> char[]:调用String的toCharArray()</p>
        char[] --> String:调用String的构造器
     */
    @Test
    public void test2(){
        //题目：a21cb3
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        IntStream.range(0, charArray.length).map(i -> charArray[i]).forEach(System.out::println);
        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    /**
    复习：<br>
        String 与基本数据类型、包装类之间的转换。
        <p>String --> 基本数据类型、包装类：调用包装类的静态方法：parseXxx(str)</p>
        基本数据类型、包装类 --> String:调用String重载的valueOf(xxx)
     */
    @Test
    public void test1(){
        String str1 = "123";
//      int num = (int)str1;//错误的
        int num = Integer.parseInt(str1);
        //"123"
        String str2 = String.valueOf(num);
        String str3 = num + "";
        System.out.println(str1 == str3);
    }
}
