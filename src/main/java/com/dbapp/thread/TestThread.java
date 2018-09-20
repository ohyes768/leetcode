package com.dbapp.thread;

/**
 * @author: jackson.tang
 * @version: 1.0
 * @Date: Created in 2018/3/28 9:41
 * @Modified:
 */
public class TestThread {

    public static void main(String args[]) {
        ThreadDemo T1 = new ThreadDemo( "Thread-1");
        T1.start();

        ThreadDemo T2 = new ThreadDemo( "Thread-2");
        T2.start();

        ThreadDemo T3 = new ThreadDemo( "Thread-3");
        T3.start();

        ThreadDemo T4 = new ThreadDemo( "Thread-4");
        T4.start();

    }
}
