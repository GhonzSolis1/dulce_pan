package com.dulcepan.dao;

import com.dulcepan.entity.DocumentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentStatusDao extends JpaRepository<DocumentStatus,Integer> {

    DocumentStatus findByDocumentStatusId(Integer documentStatus);

}
