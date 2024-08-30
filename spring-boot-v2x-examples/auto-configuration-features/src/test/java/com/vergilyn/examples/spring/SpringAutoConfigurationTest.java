package com.vergilyn.examples.spring;

import com.vergilyn.examples.UserInfoBeanConstants.UserInfoBeanExpected;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_GridThemes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = AutoConfigurationFeatureApplication.class)
class SpringAutoConfigurationTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void test_autoConfiguration() {

        UserInfoBeanExpected[] values = UserInfoBeanExpected.values();
        print(values);

        for (UserInfoBeanExpected expected : values) {
            assertThat(context.containsBean(expected.beanName))
                    .as("%s 期望 %s" , expected.beanName, expected.expected)
                    .isEqualTo(expected.expected);
        }
    }

    private void print(UserInfoBeanExpected[] values) {

        AsciiTable ascii = new AsciiTable();
        ascii.getContext().setGridTheme(TA_GridThemes.FULL);

        ascii.getContext().setWidth(120);

        ascii.addRule();
        ascii.addRow("Bean Name", "Expected", "Actual");

        ascii.addRule();
        for (UserInfoBeanExpected expected : values) {

            ascii.addRow(expected.beanName, expected.expected, context.containsBean(expected.beanName));
            ascii.addRule();
        }

        String render = ascii.render();
        System.out.println(render);
    }
}
