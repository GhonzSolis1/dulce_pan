package com.dulcepan.service.impl;


import com.dulcepan.entity.DocumentStatus;
import com.dulcepan.dao.DocumentStatusDao;
import com.dulcepan.service.DocumentStatusService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("documentStatusService")
public class DocumentStatusServiceImpl implements DocumentStatusService {

    private DocumentStatusDao documentStatusDao;

    public DocumentStatusServiceImpl( DocumentStatusDao documentStatusDao) {
        this.documentStatusDao = documentStatusDao;
    }

    @Override
    public DocumentStatus findByDocumentStatus(Integer documentStatus) {
        return documentStatusDao.findByDocumentStatusId(documentStatus);
    }

    @Override
    public List<DocumentStatus> findAllDocumentStatus() {
        return documentStatusDao.findAll();
    }
}
