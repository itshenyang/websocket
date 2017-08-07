package com.keruis.report.utils;

import org.apache.log4j.Logger;

/**
 * Created by Administrator on 2016/11/4.
 */
public class L {

    private static Logger logger = Logger.getLogger(L.class);

    public static void f(String message){
        logger.fatal(message);
    }

    public static void e(String message){
        logger.error(message);
    }

    public static void w(String message){
        logger.warn(message);
    }

    public static void i(String message){
        logger.info(message);
    }

    public static void d(String message){
        logger.debug(message);
    }

    public static void t(String message){
        logger.trace(message);
    }

}
