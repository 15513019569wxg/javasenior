package stringuse;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 *
 * @author shkstart
 * @create 2019 下午 3:32
 */
@SuppressWarnings({"StringBufferMayBeStringBuilder", "MismatchedQueryAndUpdateOfStringBuilder", "StringConcatenationInLoop", "AlibabaUndefineMagicConstant", "UnnecessaryCallToStringValueOf"})
public class StringBufferBuilderTest {
    /**
        对比String、StringBuffer、StringBuilder三者的效率? <br>
        从高到低排列：<Strong>StringBuilder > StringBuffer > String</Strong>
     */
    @Test
    public void test3(){
        //初始设置
        long startTime, endTime;
        String text = "";
        StringBuffer buffer = new StringBuffer();
        StringBuilder builder = new StringBuilder();
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间：" + (endTime - startTime));

    }

    /**
    StringBuffer的常用方法：<br>
        &nbsp;&nbsp;StringBuffer append(xxx)：提供了很多的append()方法，用于进行字符串拼接                            <br>
        &nbsp;&nbsp;StringBuffer delete(int start,int end)：删除指定位置的内容<br>
        &nbsp;&nbsp;StringBuffer replace(int start, int end, String str)：把[start,end)位置替换为str<br>
        &nbsp;&nbsp;StringBuffer insert(int offset, xxx)：在指定位置插入xxx<br>
        &nbsp;&nbsp;StringBuffer reverse() ：把当前字符序列逆转<br>
        &nbsp;&nbsp;public int indexOf(String str)<br>
        &nbsp;&nbsp;public String substring(int start,int end):返回一个从start开始到end索引结束的左闭右开区间的子字符串<br>
        &nbsp;&nbsp;public int length()<br>
        &nbsp;&nbsp;public char charAt(int n )<br>
        &nbsp;&nbsp;public void setCharAt(int n ,char ch)<br>
        总结：<br>
        &nbsp;&nbsp;增：append(xxx)                <br>
        &nbsp;&nbsp;删：delete(int start,int end)<br>
        &nbsp;&nbsp;改：setCharAt(int n ,char ch) / replace(int start, int end, String str)<br>
        &nbsp;&nbsp;查：charAt(int n )<br>
        &nbsp;&nbsp;插：insert(int offset, xxx)<br>
        &nbsp;&nbsp;长度：length();<br>
        &nbsp;&nbsp;*遍历：for() + charAt() / toString()<br>
     */
    @Test
    public void test2(){
        StringBuffer s1 = new StringBuffer("abc");
        s1.append(1);
        s1.append('1');
        System.out.println(s1);
        s1.replace(2,4,"hello");
        s1.delete(2,4);
        s1.insert(2,false);
        s1.reverse();
        String s2 = s1.substring(1, 3);
        System.out.println(s1);
        System.out.println(s1.length());
        System.out.println(s2);
    }


    /**
    String、StringBuffer、StringBuilder三者的异同？<br>
    &nbsp;&nbsp;String:不可变的字符序列；底层使用char[]存储  <br>
    &nbsp;&nbsp;StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]存储<br>
    &nbsp;&nbsp;StringBuilder:可变的字符序列；jdk5.0新增的，线程不安全的，效率高；底层使用char[]存储<br>

    源码分析：<br>
    &nbsp;&nbsp;String str = new String();//char[] value = new char[0];                 <br>
    &nbsp;&nbsp;String str1 = new String("abc");//char[] value = new char[]{'a','b','c'};    <br>
    <h2>
                        StringBuffer
     </h2>
     &nbsp;&nbsp;StringBuffer sb1 = new StringBuffer();//char[] value = new char[16];底层创建了一个长度是16的数组。<br>
     &nbsp;&nbsp;System.out.println(sb1.length());//<br>
     &nbsp;&nbsp;sb1.append('a');//value[0] = 'a';<br>
     &nbsp;&nbsp;sb1.append('b');//value[1] = 'b';<br>
     <h2>
                            StringBuffer
     </h2>
    &nbsp;&nbsp;StringBuffer sb2 = new StringBuffer("abc");//char[] value = new char["abc".length() + 16];<br>
    <em><br>
    //问题1. System.out.println(sb2.length());//3 <br>
    //问题2. 扩容问题:如果要添加的数据底层数组盛不下了，那就需要扩容底层的数组。<br>
    &nbsp;&nbsp;默认情况下，扩容为原来容量的<font color="red">2倍 + 2</font>，同时将原有数组中的元素复制到新的数组中。<br>
    &nbsp;&nbsp;指导意义：开发中建议大家使用：StringBuffer(int capacity) 或 StringBuilder(int capacity) <br>
     </em>
     */
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
        StringBuffer sb2 = new StringBuffer();
        //0
        System.out.println(sb2.length());
    }

}
