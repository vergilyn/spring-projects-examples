package com.vergilyn.examples.spring;

import com.vergilyn.examples.spring.common.UserBeanNameConstants.Expected;
import de.vandermeer.asciitable.AsciiTable;
import de.vandermeer.asciithemes.TA_GridThemes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = SpecAutoConfigApplication.class)
class CreateBeanTest {

    @Autowired
    private ApplicationContext context;

    @Test
    void test_createBean(){

        Expected[] values = Expected.values();
        print(values);

        for (Expected expected : values) {
            Assertions.assertThat(context.containsBean(expected.name()))
                      .as("%s expected: %b", expected.name(), expected.expected)
                    .isEqualTo(expected.expected);
        }
    }

    private void print(Expected[] values) {

        AsciiTable ascii = new AsciiTable();
        ascii.getContext().setGridTheme(TA_GridThemes.FULL);

        ascii.getContext().setWidth(120);

        ascii.addRule();
        ascii.addRow("Bean Name", "Expected", "Actual");

        ascii.addRule();
        for (Expected expected : values) {

            ascii.addRow(expected.name(), expected.expected, context.containsBean(expected.name()));
            ascii.addRule();
        }

        String render = ascii.render();
        System.out.println(render);
    }
}
