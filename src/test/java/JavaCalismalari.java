import enums.ENUM_CLASS;
import enums.NormalClass;
import io.cucumber.java.hu.De;
import org.junit.Test;
import pojos.Deneme;

import static stepDefinitions.Hooks.deneme;

public class JavaCalismalari {
    @Test
    public void enumCalismalari() {

        // way 1 class kullanimi
        NormalClass normalClass = new NormalClass("url",0);
        normalClass.assertUrl();

        // way 2 enum kullanimi
        ENUM_CLASS.HOME_PAGE.assertUrl();
        System.out.println(ENUM_CLASS.HOME_PAGE.getUrl());
    }

    @Test
    public void getterCalismasi() {

        System.out.println("deneme.getId() = " + deneme.getId());
    }
}
