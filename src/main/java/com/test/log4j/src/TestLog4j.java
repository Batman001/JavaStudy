package com.test.log4j.src;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by Batman on 2018/10/31.
 *
 * @author Batman
 */

public class TestLog4j {
    static Logger logger = Logger.getLogger(TestLog4j.class);
    public static void main(String[] args) throws InterruptedException {
        PropertyConfigurator.configure(
                "/Users/Batman/JavaProjects/JavaStudy/src/com/company/caini/log4j/src/log4j.xml");
        for (int i = 0; i < 100; i++) {
            logger.trace("跟踪信息");
            logger.debug("调试信息");
            logger.info("输出信息");
            logger.warn("警告信息");
            logger.error("错误信息");
            logger.fatal("致命信息");
        }
    }
}

