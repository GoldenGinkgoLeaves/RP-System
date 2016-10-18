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
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void uploadDocument(List<Document> documents) {

    }

    public void downloadDocument(List<Document> documents) {

    }
}
