package com.vergilyn.examples.spring.common;

public interface UserBeanNameConstants {

    String scanned_out_class_mismatch = "scanned_out_class_mismatch";

    String scanned_out_class_mismatch_inner_class = "scanned_out_class_mismatch_inner_class";

    String no_scan_but_factories_out_class_mismatch = "no_scan_but_factories_out_class_mismatch";
    String no_scan_but_factories_out_class_mismatch_inner_class = "no_scan_but_factories_out_class_mismatch_inner_class";

    String no_scan_only_inner_class = "no_scan_only_inner_class";

    String scanned_only_inner_class = "scanned_only_inner_class";


    static enum Expected {

        scanned_out_class_mismatch(false),
        scanned_out_class_mismatch_inner_class(false),

        no_scan_but_factories_out_class_mismatch(false),
        no_scan_but_factories_out_class_mismatch_inner_class(false),

        no_scan_only_inner_class(false),
        scanned_only_inner_class(false)
        ;

        public final boolean expected;

        Expected(boolean expected) {
            this.expected = expected;
        }
    }
}
