package com.bansal.lms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author shaifibansal
 */
@Entity
@Table(name = "book_issue")
public class BookIssue implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="book_issue_id")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long bookIssueId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "book_id")
    private Long bookId;

    @Column(name = "issue_date")
    private Date issueDate;

    @Column(name = "return_date")
    private Date returnDate;

    public Long getBookIssueId() {
        return bookIssueId;
    }

    public void setBookIssueId(Long bookIssueId) {
        this.bookIssueId = bookIssueId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }
}
