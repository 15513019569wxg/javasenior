package stringuse;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author shkstart
 * @create 2019 上午 11:52
 */
@SuppressWarnings({"ConstantConditions", "StringOperationCanBeSimplified"})
public class StringMethodTest {
    /**
        <p>替换:</p>
        &nbsp;&nbsp;String replace(char oldChar, char newChar)：返回一个新的字符串，它是通过用 newChar 替换此字符串中出现的所有 oldChar 得到的。            <br>
        &nbsp;&nbsp;String replace(CharSequence target, CharSequence replacement)：使用指定的字面值替换序列替换此字符串所有匹配字面值目标序列的子字符串。<br>
        &nbsp;&nbsp;String replaceAll(String regex, String replacement)：使用给定的 replacement 替换此字符串所有匹配给定的正则表达式的子字符串。<br>
        &nbsp;&nbsp;String replaceFirst(String regex, String replacement)：使用给定的 replacement 替换此字符串匹配给定的正则表达式的第一个子字符串。<br>
        <p>匹配:</p>
        &nbsp;&nbsp;boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
        <p>切片:</p>
        &nbsp;&nbsp;String[] split(String regex)：根据给定正则表达式的匹配拆分此字符串。<br>
        &nbsp;&nbsp;String[] split(String regex, int limit)：根据匹配给定的正则表达式来拆分此字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
     */
    @Test
    public void test4(){
        System.out.println("**************************************  replace()  **********************************************************");
        String str1 = "北京尚硅谷教育北京";
        String str2 = str1.replace('北', '东');
        System.out.println(str1);
        System.out.println(str2);
        String str3 = str1.replace("北京", "上海");
        System.out.println(str3);
        System.out.println("***************************************** replace() ***********************************************************");
        System.out.println("******************************************* replaceAll() **********************************************************");
        String str = "12hello34world5java7891mysql456";
        //把字符串中的数字替换成,，如果结果中开头和结尾有，的话去掉
        String string = str.replaceAll("\\d+", ",").replaceAll("^,|,$", "");
        System.out.println(string);
        System.out.println("******************************************* replaceAll() **********************************************************");
        System.out.println("******************************************* matches() **********************************************************");
        str = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        System.out.println(matches);
        String tel = "0571-4534289";
        //判断这是否是一个杭州的固定电话
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);
        System.out.println("******************************************* matches() **********************************************************");
        System.out.println("******************************************* split() **********************************************************");
        str = "hello|world|java";
        String[] strs = str.split("\\|");
        Arrays.stream(strs).forEach(System.out::println);
        str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        Arrays.stream(strs2).forEach(System.out::println);
        System.out.println("******************************************* split() **********************************************************");

    }

    /**
        &nbsp;&nbsp;boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束                                                        <br>
        &nbsp;&nbsp;boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始<br>
        &nbsp;&nbsp;boolean startsWith(String prefix, int toOffset)：测试此字符串从指定索引开始的子字符串是否以指定前缀开始<br>
        &nbsp;&nbsp;boolean contains(CharSequence s)：当且仅当此字符串包含指定的 char 值序列时，返回 true<br>
        &nbsp;&nbsp;int indexOf(String str)：返回指定子字符串在此字符串中第一次出现处的索引<br>
        &nbsp;&nbsp;int indexOf(String str, int fromIndex)：返回指定子字符串在此字符串中第一次出现处的索引，从指定的索引开始<br>
        &nbsp;&nbsp;int lastIndexOf(String str)：返回指定子字符串在此字符串中最右边出现处的索引<br>
        &nbsp;&nbsp;int lastIndexOf(String str, int fromIndex)：返回指定子字符串在此字符串中最后一次出现处的索引，从指定的索引开始反向搜索<br>
        <Strong>注：indexOf和lastIndexOf方法如果未找到都是返回-1</Strong>

     */
    @Test
    public void test3(){
        System.out.println("==================endsWith()/startsWith()/startsWith() ================================");
        String str1 = "helloWorld";
        boolean b1 = str1.endsWith("rld");
        System.out.println(b1);
        boolean b2 = str1.startsWith("He");
        System.out.println(b2);
        boolean b3 = str1.startsWith("ll",2);
        System.out.println(b3);
        System.out.println("==================endsWith()/startsWith()/startsWith() ================================");
        System.out.println("==================contains()/indexOf()/lastIndexOf() ================================");
        String str2 = "wor";
        System.out.println(str1.contains(str2));
        System.out.println(str1.indexOf("lol"));
        System.out.println(str1.indexOf("lo",5));
        String str3 = "hellorworld";
        System.out.println(str3.lastIndexOf("or"));
        System.out.println(str3.lastIndexOf("or",6));
        System.out.println("==================contains()/indexOf()/lastIndexOf() ================================");
        //什么情况下，indexOf(str)和lastIndexOf(str)返回值相同？
        //情况一：存在唯一的一个str。情况二：不存在str
    }


    /**
        &nbsp;&nbsp;int length()：返回字符串的长度： return value.length <br>
        &nbsp;&nbsp;char charAt(int index)： 返回某索引处的字符return value[index]<br>
        &nbsp;&nbsp;boolean isEmpty()：判断是否是空字符串：return value.length ==<< 0<br>
        &nbsp;&nbsp;String toLowerCase()：使用默认语言环境，将 String 中的所有字符转换为小写<br>
        &nbsp;&nbsp;String toUpperCase()：使用默认语言环境，将 String 中的所有字符转换为大写<br>
        &nbsp;&nbsp;String trim()：返回字符串的副本，忽略前导空白和尾部空白<br>
        &nbsp;&nbsp;boolean equals(Object obj)：比较字符串的内容是否相同<br>
        &nbsp;&nbsp;boolean equalsIgnoreCase(String anotherString)：与equals方法类似，忽略大小写<br>
        &nbsp;&nbsp;String concat(String str)：将指定字符串连接到此字符串的结尾。 等价于用“+”<br>
        &nbsp;&nbsp;int compareTo(String anotherString)：比较两个字符串的大小<br>
        &nbsp;&nbsp;String substring(int beginIndex)：返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串。<br>
        &nbsp;&nbsp;String substring(int beginIndex, int endIndex) ：返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex(不包含)的一个子字符串。<br>

     */
    @Test
    public void test2() {
        System.out.println("=========================== equals()/equalsIgnoreCase() ===================================");
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));
        System.out.println("=========================== equals()/equalsIgnoreCase() ===================================");
        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);
        String s5 = "abc";
        String s6 = new String("abe");
        System.out.println("================================= compareTo() ===================================");
        System.out.println(s5.compareTo(s6));
        System.out.println("================================= compareTo() ===================================");
        System.out.println("=================================== subString()  ===================================");
        String s7 = "北京尚硅谷教育";
        String s8 = s7.substring(2);
        System.out.println(s7);
        System.out.println(s8);
        String s9 = s7.substring(2, 5);
        System.out.println(s9);
        System.out.println("=================================== subString()  ===================================");
    }

    @Test
    public void test1() {
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println("----------------------------------------------- charAt() --------------------------------------------------");
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));
        System.out.println("----------------------------------------------- charAt() --------------------------------------------------");
        /* System.out.println(s1.charAt(10)); */
        String nullString = "";
        System.out.println(nullString.isEmpty());
        String s2 = s1.toLowerCase();
        //s1不可变的，仍然为原来的字符串
        System.out.println(s1);
        //改成小写以后的字符串
        System.out.println(s2);
        String s3 = "   he  llo   world   ";
        String s4 = s3.trim();
        System.out.println("-----" + s3 + "-----");
        System.out.println("-----" + s4 + "-----");
    }
}
