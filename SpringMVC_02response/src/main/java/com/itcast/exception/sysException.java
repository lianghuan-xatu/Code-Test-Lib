package com.itcast.exception;

public class sysException extends Exception
{
    //存储提示信息的
    private String messages;

    public sysException(String message) {

        this.messages = messages;
    }

    public String getMessages() {
        return messages;
    }

    public void setMessages(String messages) {
        this.messages = messages;
    }
}
