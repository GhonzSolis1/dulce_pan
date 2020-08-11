package com.dulcepan.dao;

import com.dulcepan.entity.Client;
import com.dulcepan.entity.Document;
import com.dulcepan.entity.DocumentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface DocumentDao extends JpaRepository<Document,Integer> {

    Document findByDocumentId(Integer documentId);

    List<Document> findByStatusDocument(DocumentStatus documentStatus);

    List<Document> findByDateDocument(Date dateDocument);

    List<Document> findByDebtPending(Integer debtPending);

    List<Document> findByTotalPayment(Integer totalPayment);

   @Query(value = "select DISTINCT(ds.document) from DailySale ds where ds.client =:client")//where ds.client =:client")
    List<Document> findByDistinctDocument(Client client);

}
