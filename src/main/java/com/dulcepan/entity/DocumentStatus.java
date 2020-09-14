package com.dulcepan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@Entity
@Table(name = "document_status")
public class DocumentStatus {

    public static final Integer CREATED = 1;
    public static final Integer DEBT= 3;
    public static final Integer FINALLY = 4;
    private Integer documentStatusId;
    private String description;


    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "document_status_id", unique = true, nullable = false)
    public Integer getDocumentStatusId() {
        return documentStatusId;
    }

    @Column(name = "description")
    public String getDescription(){
        return description;
    }

}
