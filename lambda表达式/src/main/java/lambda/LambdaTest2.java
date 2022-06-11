package lambda;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * java内置的4大核心函数式接口<br>
 * &nbsp;&nbsp;* 消费型接口 Consumer<T>     void accept(T t)<br>
 * &nbsp;&nbsp;* 供给型接口 Supplier<T>     T get()<br>
 * &nbsp;&nbsp;* 函数型接口 Function<T,R>   R apply(T t)<br>
 * &nbsp;&nbsp;* 断定型接口 Predicate<T>    boolean test(T t)<br>
 * @author shkstart
 * @create 2019 下午 2:29
 */
public class LambdaTest2 {
    @Test
    public void test1() {
        happyTime(500, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("学习太累了，去天上人间买了瓶矿泉水，价格为：" + aDouble);
            }
        });
        System.out.println("************************************************************************************************************************");
        happyTime(400, money -> System.out.println("学习太累了，去天上人间喝了口水，价格为：" + money));
    }

    public void happyTime(double money, Consumer<Double> con) {
        con.accept(money);
    }

    @Test
    public void test2() {
        List<String> list = Arrays.asList("北京", "南京", "天津", "东京", "西京", "普京");
        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });
        System.out.println(filterStrs);
        List<String> filterStrs1 = filterString(list, s -> s.contains("京"));
        System.out.println(filterStrs1);
    }

    //根据给定的规则，过滤集合中的字符串。此规则由Predicate的方法决定
    public List<String> filterString(List<String> list, Predicate<String> pre) {
        ArrayList<String> strings;
        strings = list.stream().filter(pre).collect(Collectors.toCollection(ArrayList::new));
        return strings;
    }
}
