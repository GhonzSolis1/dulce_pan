package com.dulcepan.service;

import com.dulcepan.entity.Document;
import com.dulcepan.entity.DocumentStatus;

import java.util.Date;
import java.util.List;

public interface DocumentStatusService {

    DocumentStatus findByDocumentStatus(Integer documentStatus);

    List<DocumentStatus> findAllDocumentStatus();

}
