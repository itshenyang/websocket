package com.keruis.report.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/1/4.
 */
public class SqlServerJDBCUtils {
    private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private String url = "jdbc:sqlserver://115.28.18.143:1433;DatabaseName=";
    public static String DatabaseName = "";
    private String user = "keruis";
    private String password = "Keruis@123";
    Connection connection = null;

    /**
     * 得到数据库连接
     *
     * @return
     */
    public Connection getConnection() {
        try {
            Class.forName(driver); // 加载驱动
            connection = DriverManager.getConnection(url + DatabaseName, user, password);
        } catch (Exception e) {
            return null;
        }
        return connection;
    }

    public void closeAll(Connection conn, PreparedStatement PS, ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
                rs = null;
            }
            if (PS != null) {
                PS.close();
                PS = null;
            }
            if (conn != null) {
                conn.close();
                conn = null;
            }
        } catch (SQLException e) {
            // TODO: handle exception
        }

    }

    /**
     * 得到结果集(reader)
     *
     * @param sql    要执行的sql语句
     * @param params 参数数组
     * @return 结果集
     */
    public List<Map<String,Object>> getResultSet(String sql, Object[] params) {
        ResultSet rs = null;
        connection = getConnection();        //得到连接对象
        PreparedStatement ps = null;
        List list = new ArrayList();
        try {
            System.out.println("BaseDao : sql=" + sql);
            ps = connection.prepareStatement(sql);        //预编译sql语句
            System.out.println("BaseDao : ps=" + ps);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                    System.out.println("BaseDao ： params[" + i + "]=" + params[i]);
                }
                System.out.println("BaseDao ： params[0]=" + params[0]);
            }
            System.out.println("BaseDao ： sql语句=" + ps);
            rs = ps.executeQuery();                //返回结果集

            while (rs.next()) {
                ResultSetMetaData md = rs.getMetaData();
                int columnCount = md.getColumnCount();
                Map<String,Object> rowData = new HashMap();
                for (int i = 1; i <=columnCount; i++) {
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(rowData);
            }
        } catch (Exception e) {
            System.out.println("BaseDao : catch异常");
            e.printStackTrace();
            return null;
        }finally {
            this.closeAll(connection, ps, null);
        }
        return list;
    }

    /**
     * 增删改操作
     *
     * @param sql    要执行的sql语句
     * @param params 参数数组
     * @return 影响的行数
     */
    public int updateData(String sql, Object[] params) {
        int result = 0;
        connection = getConnection();        //得到连接对象
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);        //预编译sql语句
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    ps.setObject(i + 1, params[i]);
                    System.out.println("BaseDao ： params[" + i + "]=" + params[i]);
                }
            }
            System.out.println("BaseDao ： sql语句=" + ps);
            result = ps.executeUpdate();
        } catch (Exception e) {
            // TODO: handle exception
            return 0;
        } finally {
            this.closeAll(connection, ps, null);
        }
        return result;
    }
}
