package com.dulcepan.entity;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "document")
public class Document  {

    private Integer documentId;
    private DocumentStatus statusDocument;
    private Date dateDocument;
    private String comment;
    private Integer debtPending;
    private Integer totalPayment;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "document_id", unique = true, nullable = false)
    public Integer getDocumentId()   {
        return documentId;
    }
    @ManyToOne()
    @JsonManagedReference("payment_debt")
    @JoinColumn(name = "status_document", nullable = false)
    public DocumentStatus getStatusDocument() {
        return statusDocument;
    }
    @Column(name = "date_document")
    public Date getDateDocument() {
        return dateDocument;
    }
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    @Column(name = "debt_pending")
    public Integer getDebtPending() {
        return debtPending;
    }

    @Column(name = "total_payment")
    public Integer getTotalPayment() {
        return totalPayment;
    }

}
