package com.dbapp.attackWay;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: jackson.tang
 * @version: 1.0
 * @Date: Created in 2018/3/25 17:15
 * @Modified:
 */
public class RelationTest {
    private static String charset;
    private static String connectStr;
    private static String username;
    private static String password;

    static {
        connectStr = "jdbc:mysql://localhost:3306/hibernate?autoReconnect=true&autoReconnectForPools=true&useUnicode=true&characterEncoding=utf-8";
        // connectStr += "?useServerPrepStmts=false&rewriteBatchedStatements=true";
        charset = "utf8";
        username = "root";
        password = "199366";
    }

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(connectStr, username, password);
            String path = "C:\\Users\\tangl\\Desktop\\dictionary_2.2(3)\\attack_relation.csv";
            String tableName = "ice_attack";
            BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(path), charset));
            doStoreRelation(con, bfr, tableName);
            List<Attack> list = getmysql(con);
            List<Attack> menus = AttackParser.getTreeList("0", list);
            System.out.println("finish");


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void doStoreRelation(Connection conn, BufferedReader bfr, String tableName) throws ClassNotFoundException, SQLException, IOException {
        conn.setAutoCommit(false); // 设置手动提交
        int count = 0;
        String sql = "INSERT INTO " + tableName +" (intent,strategy,method) VALUES (?,?,?)";
        PreparedStatement psts = conn.prepareStatement(sql);
        String line = null;
        while (null != (line = bfr.readLine()) ) {
            count++;
            if(count == 1 ) continue;
            String[] infos = line.split(",");
            if (infos.length != 3)   continue;
            if (true) {
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
//        conn.close();
    }

    public static List<Attack> getmysql(Connection con) throws SQLException {
        List<Attack> list=new ArrayList<>();
        try {
            Statement stms = con.createStatement();
            ResultSet set = stms.executeQuery("select * from ice_attack");

            ResultSetMetaData metaData = set.getMetaData();
            int columnCount = metaData.getColumnCount();
            int count = 0;
            while (set.next()) {
                for (int i = 2; i <= columnCount; i++) {
                    count ++ ;
                    if(i == 2){
                        Attack menu=new Attack();
                        String columnName = metaData.getColumnLabel(i);
                        String value = set.getString(columnName);
                        menu.setName(value);
                        menu.setKey(value);
                        menu.setId(1);
                        menu.setCount(count);
                        list.add(menu);
                    }else if(i > 2){
                        Attack menu=new Attack();
                        String parentName = metaData.getColumnLabel(i-1);
                        String columnName = metaData.getColumnLabel(i);
                        String parentvalue = set.getString(parentName);
                        String value = set.getString(columnName);
                        menu.setName(value);
                        menu.setKey(value);
                        menu.setParentName(parentvalue);
                        menu.setParentCount(count - 1);
                        menu.setId(i - 1);
                        menu.setCount(count);
                        list.add(menu);
                    }
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            con.close();
        }
        return list;
    }
}
