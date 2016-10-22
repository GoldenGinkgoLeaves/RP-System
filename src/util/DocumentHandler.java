package util;

import pojo.Document;
import pojo.User;

import java.util.List;

public class DocumentHandler {
    User user;

    public DocumentHandler(User user) {
        this.user = user;
    }

    public DocumentHandler() {

        System.out.println();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void uploadDocument(List<Document> documents) {

    }

    public void downloadDocument(List<Document> documents) {

    }
}
