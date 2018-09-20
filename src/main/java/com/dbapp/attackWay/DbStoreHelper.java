package com.dbapp.attackWay;

import scala.Int;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: jackson.tang
 * @version: 1.0
 * @Date: Created in 2018/3/20 21:59
 * @Modified:
 */
public class DbStoreHelper {
    private static String insert_sql;
    private static String charset;
    private static boolean debug;

    private static String connectStr;
    private static String username;
    private static String password;

    static {
        connectStr = "jdbc:mysql://172.16.100.56/dev_incidents";
        // connectStr += "?useServerPrepStmts=false&rewriteBatchedStatements=true";
        insert_sql = "INSERT INTO ice_attack (intent,strategy,method) VALUES (?,?,?)";
        charset = "utf8";
        debug = true;
        username = "root";
        password = "1qazCDE#5tgb";
    }

    public static void storeToDb(String srcFile) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile), charset));
        try {
            doStore(bfr);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bfr.close();
        }
    }

    private static void doStore(BufferedReader bfr) throws ClassNotFoundException, SQLException, IOException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection(connectStr, username,password);
        conn.setAutoCommit(false); // 设置手动提交
        int count = 0;
        PreparedStatement psts = conn.prepareStatement(insert_sql);
        String line = null;
        while (null != (line = bfr.readLine())) {
            String[] infos = line.split(",");
            if (infos.length != 3)   continue;
            if (debug) {
                System.out.println(line);
            }
            psts.setString(1, infos[0]);
            psts.setString(2, infos[1]);
            psts.setString(3, infos[2]);

            psts.addBatch();          // 加入批量处理
            count++;
        }
        psts.executeBatch(); // 执行批量处理
        conn.commit();  // 提交
        System.out.println("All down : " + count);
        conn.close();
    }

    public static void main(String[] args) {
        String x = "2";
        int s = Integer.parseInt(x);
        try {
            storeToDb("E:\\DBAPP\\2018.03\\dictionary_v2.2\\attackIntent,attackStrategy,attackMethod层级关系.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
