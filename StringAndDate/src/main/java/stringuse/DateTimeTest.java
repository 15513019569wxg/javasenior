package stringuse;

import org.junit.Test;

import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 * @author shkstart
 * @create 2019 下午 4:30
 */
public class DateTimeTest {

    /**
    java.util.Date类<br>
    &nbsp;&nbsp;&nbsp;&nbsp;|---java.sql.Date类<br>
    1.两个构造器的使用<br>
    &nbsp;&nbsp;&nbsp;&nbsp;构造器一：Date()：创建一个对应当前时间的Date对象<br>
    &nbsp;&nbsp;&nbsp;&nbsp;构造器二：创建指定毫秒数的Date对象<br>
    2.两个方法的使用<br>
    &nbsp;&nbsp;&nbsp;&nbsp;toString():显示当前的年、月、日、时、分、秒<br>
    &nbsp;&nbsp;&nbsp;&nbsp;getTime():获取当前Date对象对应的毫秒数。（时间戳）<br>
    3. java.sql.Date对应着数据库中的日期类型的变量<br>
    &nbsp;&nbsp;&nbsp;&nbsp;如何实例化<br>
    &nbsp;&nbsp;&nbsp;&nbsp;如何将java.util.Date对象转换为java.sql.Date对象
     */
    @Test
    public void test2(){
        //构造器一：Date()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        //Sat Feb 16 16:35:31 GMT+08:00 2019
        System.out.println(date1.toString());
        //1550306204104
        System.out.println(date1.getTime());

        //构造器二：创建指定毫秒数的Date对象
        Date date2 = new Date(155030620410L);
        System.out.println(date2.toString());
        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(35235325345L);
        //1971-02-13
        System.out.println(date3);

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
        Date date4 = new java.sql.Date(2343243242323L);
        java.sql.Date date5 = (java.sql.Date) date4;
        //情况二：
        Date date6 = new Date();
        java.sql.Date date7 = new java.sql.Date(date6.getTime());


    }

    /** 1.System类中的currentTimeMillis() */
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        //称为时间戳
        System.out.println(time);
    }
}
