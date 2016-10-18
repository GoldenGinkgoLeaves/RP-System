package dao;

import pojo.Customer;
import pojo.Document;
import service.UserManager;
import util.DatabaseHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DocumentDao {

    /**
     * 获得一个订单中的所有文件的列表
     */
    public List<Document> getOrderAllDocuments(int orderId) {
        return findDocumentsByForeignKey(orderId);
    }

    /**
     * 获得某用户的所有文件列表
     */
    public List<Document> getCustomerAllDocument() {
        return findDocumentsByForeignKey(UserManager.getCurrentUser().getId());
    }

    /**
     * 在文件表中根据外键选出部分文件
     */
    private List<Document> findDocumentsByForeignKey(int foreignKey) {
        String sql = "select * from document where order_id=" + foreignKey;
        List<Document> documents = new ArrayList<>();
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        try {
            if (resultSet != null) {
                while (resultSet.next()) {
                    Document document = new Document();
                    document.setId(resultSet.getInt("id"));
                    document.setName(resultSet.getString("name"));
                    document.setFormat(resultSet.getInt("format"));
                    document.setPages(resultSet.getInt("pages"));
                    document.setPath(resultSet.getString("path"));
                    Customer customer = new CustomerInfoDao().getCustomerInfo(resultSet.getInt("customer"));
                    document.setCustomer(customer);
                    documents.add(document);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documents;
    }

    /**
     * 根据文件id获取一个精确地文件
     */
    public Document getExactDocument(int documentId) {
        String sql = "select * from document where id=" + documentId;
        ResultSet resultSet = DatabaseHelper.executeQuery(sql);
        Document document = new Document();
        try {
            if (resultSet != null && resultSet.next()) {
                document.setId(resultSet.getInt("id"));
                document.setName(resultSet.getString("name"));
                document.setFormat(resultSet.getInt("format"));
                document.setPages(resultSet.getInt("pages"));
                document.setPath(resultSet.getString("path"));
                Customer customer = new CustomerInfoDao().getCustomerInfo(resultSet.getInt("customer"));
                document.setCustomer(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return document;
    }
}
