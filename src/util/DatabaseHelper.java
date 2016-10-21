package util;

import sun.jdbc.rowset.CachedRowSet;

import java.sql.*;

public class DatabaseHelper {

    //根据数据库连接协议定义连接URL
    private static final String URL = "jdbc:mysql://120.27.105.171:3306/self_print?"
            + "user=root&password=password&useUnicode=true&characterEncoding=UTF8";

    //在使用java代码访问数据库前，需要将目标数据库的JDBC驱动载入
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对数据库执行更新操作，即是没有返回结果的操作
     * 先通过定义好的连接URL获得一个对数据库的连接
     * 然后用此连接建立一个可以定义数据库操作语句的statement对象
     * 接下来用statement对象进行更新或查询任务
     * 最后释放对数据库的连接
     *
     * @param sql 要执行的sql语句
     */
    public static void executeUpdate(String sql) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseConnection(connection);
        }
    }

    /**
     * 对数据库进行查询操作，即是有返回结果集的操作
     *
     * @param sql 要执行的sql语句
     * @return 返回一个查询结果集
     */
    public static ResultSet executeQuery(String sql) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            CachedRowSet cachedRowSet = new CachedRowSet();
            cachedRowSet.populate(resultSet);
            return cachedRowSet;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseConnection(connection);
        }
        return null;
    }

    /**
     * 对数据库的操作完成后要关闭对数据库的连接以释放资源
     *
     * @param connection 要关闭的连接
     */
    private static void releaseConnection(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
