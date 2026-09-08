package com.common;

import static com.util.LoadProperty.loadProperty;
import static java.lang.System.getProperty;

public class Constants {

    public static final String URL = loadProperty("url");
    public static final String EMAIL = loadProperty("email");
    public static final String PASSWORD = loadProperty("password");
}
