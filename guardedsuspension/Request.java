package com.shxz.guardedsuspension;

public class Request {
    private final String name;
    public Request(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String toString() {
        return "[ Request " + name + " ]";
    }
    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue, "�ͻ��˷�������").start();
        new ServerThread(requestQueue, "��������������").start();
    }
}