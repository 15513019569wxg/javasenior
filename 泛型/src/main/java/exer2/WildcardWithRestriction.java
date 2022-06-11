package exer2;/*
    @author wxg
    @date 2021/8/24-10:57
    */

import java.util.List;

public class WildcardWithRestriction {
    public static void main(String[] args) {
    }

    public static void addStrings1(List<? extends Object> list){
        //  所有对象的子类都可以赋予null
        list.add(null);
    }

    public static void addStrings2(List<? super A> list){
        //  必须加入A及A的子类
        list.add(new A());
        list.add(new Circle());
//        list.add(new GeometricObject());     public class A extends GeometricObject{//}
    }
}



