package com.itcast.mybatis.io;

import java.io.InputStream;

public class Resources
{
    /**
     * 使用类加载器读取配置文件
     * @return
     */
    public static InputStream getResourceAsStream(String filepath) {
        return Resources.class.getClassLoader().getResourceAsStream(filepath);
    }
}
