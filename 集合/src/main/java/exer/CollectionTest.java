package exer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

/**
 * @author shkstart
 * @create 2019 上午 9:36
 */
public class CollectionTest {
    @Test
    public void test1(){
        ArrayList coll = new ArrayList();

        coll.add(123);
        coll.add(456);
        coll.add(343);
        coll.add(343);

        coll.forEach(System.out::println);
    }


    //练习：在List内去除重复数字值，要求尽量简单
    public static List<Integer> duplicateList(List<Integer> list) {
        HashSet<Integer> set = new HashSet<Integer>(list);
        return new ArrayList<Integer>(set);
    }
    @Test
    public void test2(){
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        for (int i : new int[]{2, 4, 4}) {
            list.add(i);
        }
        List<Integer> list2 = duplicateList(list);
        for (Object integer : list2) {
            System.out.println(integer);
        }
    }

    @Test
    public void test3(){
        HashSet<Person> set = new HashSet<Person>();
        Person p1 = new Person(1001,"AA");
        Person p2 = new Person(1002,"BB");

        set.add(p1);
        set.add(p2);
        System.out.println(set);

        p1.name = "CC";
        set.remove(p1);
        System.out.println(set);
        set.add(new Person(1001,"CC"));
        System.out.println(set);
        set.add(new Person(1001,"AA"));
        System.out.println(set);

    }


}
