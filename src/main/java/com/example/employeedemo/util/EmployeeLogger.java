package com.example.employeedemo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author Momen Magdy
 * singleton Application Logger
 */
public class EmployeeLogger {

    private static final Logger employeeLogger = LoggerFactory.getLogger(EmployeeLogger.class);


    /**
     * @author Momen Magdy
     * @return single logger instance to use
     */
    public static Logger LOGGER(){
        return employeeLogger;
    }
}
