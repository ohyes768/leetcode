package com.dbapp.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: jackson.tang
 * @version: 1.0
 * @Date: Created in 2018/3/28 9:40
 * @Modified:
 */
class ThreadDemo extends Thread {
    private Thread t;
    private String threadName;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static Long time = 0L;

    ThreadDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );

        for(int i = 0; i <10000; i++) {
            String timeStr ="";
            if(i%3==0){
                timeStr  = "2018-03-28 01:22:45";
            }else{
                timeStr  = "2018-03-28 21:20:45";
            }
            try {
                Date startdate = sdf.parse(timeStr);
                time = startdate.getTime();
                System.out.println(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            // 让线程睡眠一会
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}
