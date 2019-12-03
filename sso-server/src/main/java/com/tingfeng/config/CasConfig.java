package com.tingfeng.config;

public class CasConfig {

    /**
     * CAS登录地址的token
     */
    public static String GET_TOKEN_URL = "http://cas.server.com:8003/cas/v1/tickets";

    /**
     * 设置Cookie的有效时长（1小时）
     */
    public static int COOKIE_VALID_TIME = 1 * 60 * 10;

    /*
     * 设置Cookie的有效时长（1小时）
     */
    public static String COOKIE_NAME = "UToken";

    /**
     * CAS登出服务器地址
     */
//    public static String CAS_SERVER_LOGOUT_PATH = "https://cas.server.com:8003/cas/logout";
    public static String CAS_SERVER_LOGOUT_PATH = "http://cas.server.com:8003/cas";


}
