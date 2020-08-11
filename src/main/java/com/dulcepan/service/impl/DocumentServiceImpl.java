package com.dulcepan.service.impl;

import com.dulcepan.entity.Client;
import com.dulcepan.entity.Document;
import com.dulcepan.dao.DocumentDao;
import com.dulcepan.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service("documentService")
public class DocumentServiceImpl implements DocumentService {

    private DocumentDao documentDao;

    @Autowired
    public DocumentServiceImpl(DocumentDao documentDao) {
    this.documentDao = documentDao;
    }

    @Override
    public Document createDocument(Document document) {
      return documentDao.saveAndFlush(document);
    }


    @Override
    public Document findByDocumentId(Integer documentId) {
        return documentDao.findByDocumentId(documentId);
    }


    @Override
    public Document updateDocumentFinally(Document document) {
        return documentDao.saveAndFlush(document);
    }


    @Override
    public List<Document> findByTotalPayment(Integer totalPayment) {
        return documentDao.findByTotalPayment(totalPayment);
    }

    @Override
    public List<Document> findByDistinctDocument(Client client) {
        return documentDao.findByDistinctDocument(client);
    }

    @Override
    public List<Document> distinctDetailDailySaleByClient(Client client) {
        return documentDao.findByDistinctDocument(client);
    }
}

