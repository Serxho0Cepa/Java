package com.serxho.util;

public final class Queries {

    public static String FIND_ALL_USERS = "SELECT u FROM User u";
    public static String FIND_USER_BY_USERNAME = "SELECT u FROM User u WHERE u.username = ?1";
    public static String FIND_USER_BY_USERNAME_METHOD_2 = "SELECT u FROM User u WHERE u.username = :username";

    private Queries() {}

}
