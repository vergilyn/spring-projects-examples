package com.vergilyn.examples;

public interface UserInfoBeanConstants {

    String no_scan_packages = "no_scan_packages";

    String no_scan_packages_but_factories = "no_scan_packages_but_factories";

    String scanned_packages = "scanned_packages";

    String condition_matched = "condition_matched";
    String condition_matched_import = "condition_matched_import";

    String condition_mismatch = "condition_mismatch";
    String condition_mismatch_import = "condition_mismatch_import";

    String condition_mismatch_import_but_scanned = "condition_mismatch_import_also_scanned";

    String inner_class_bean = "inner_class_bean";
    String scan_package_out_mismatch = "scan_package_out_mismatch";
    String scan_package_out_mismatch_inner = "scan_package_out_mismatch_inner";
    String inner_class_but_out_mismatch = "inner_class_but_out_mismatch";

    String no_scan_but_factories_out_mismatch_inner = "no_scan_but_factories_out_mismatch_inner";

    static enum UserInfoBeanExpected {
        no_scan_packages(UserInfoBeanConstants.no_scan_packages, false),
        no_scan_packages_but_factories(UserInfoBeanConstants.no_scan_packages_but_factories, true),

        scanned_packages(UserInfoBeanConstants.scanned_packages, true),

        condition_matched(UserInfoBeanConstants.condition_matched, true),
        condition_matched_import(UserInfoBeanConstants.condition_matched_import, true),

        condition_mismatch(UserInfoBeanConstants.condition_mismatch, false),
        condition_mismatch_import(UserInfoBeanConstants.condition_mismatch_import, false),

        condition_mismatch_import_but_scanned(UserInfoBeanConstants.condition_mismatch_import_but_scanned, true),

        inner_class_bean(UserInfoBeanConstants.inner_class_bean, true),
        scan_package_out_mismatch_inner(UserInfoBeanConstants.scan_package_out_mismatch_inner, false),
        scan_package_out_mismatch(UserInfoBeanConstants.scan_package_out_mismatch, false),
        inner_class_but_out_mismatch(UserInfoBeanConstants.inner_class_but_out_mismatch, false),

        no_scan_but_factories_out_mismatch_inner(UserInfoBeanConstants.no_scan_but_factories_out_mismatch_inner, false)
        ;

        public final String beanName;
        public final boolean expected;

        UserInfoBeanExpected(String beanName, boolean expected) {
            this.beanName = beanName;
            this.expected = expected;
        }
    }

}
