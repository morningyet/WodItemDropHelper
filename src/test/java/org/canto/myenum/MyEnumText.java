package org.canto.myenum;

import org.apache.commons.lang3.StringUtils;
import org.canto.crawler.commons.MyHero;
import org.junit.Test;

/**
 * @author morningyet
 * @create 2019-09-04 14:45
 */
public class MyEnumText {

    @Test
    public void myenumtest(){

        System.out.println(MyHero.Myhero04.getDesc());
        System.out.println(MyHero.Myhero04.name());
        System.out.println(StringUtils.right(MyHero.Myhero04.name(),4));


    }
}
