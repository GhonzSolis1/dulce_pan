package com.dulcepan.service;

import com.dulcepan.entity.Client;
import com.dulcepan.entity.DailySale;
import com.dulcepan.entity.Document;
import com.dulcepan.entity.DocumentStatus;

import java.util.Date;
import java.util.List;

public interface DocumentService {

    Document createDocument(Document document);

    Document findByDocumentId(Integer documentId);

    Document updateDocumentFinally(Document document);

    List<Document> findByTotalPayment(Integer totalPayment);

    List<Document> findByDistinctDocument(Client client);

    List<Document> distinctDetailDailySaleByClient(Client client);
}
