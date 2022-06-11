package DateUse;

import org.junit.Test;

/**
 * @author shkstart
 * @create 2019 上午 11:23
 */
@SuppressWarnings("AlibabaTestClassShouldEndWithTestNaming")
public class IDEADebug {
    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        //4
        System.out.println(sb.length());

        //"null"
        System.out.println(sb);

        //抛异常NullPointerException
        StringBuffer sb1 = new StringBuffer(str);
        System.out.println(sb1);

    }
}
