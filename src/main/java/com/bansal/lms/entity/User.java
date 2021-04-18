package com.bansal.lms.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author shaifibansal
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="user_id")
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long userId;

    @Column(name = "username")
    private String userName;

    @Column(name = "created_date")
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name = "is_membership_active")
    private boolean isMembershipActive;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isMembershipActive() {
        return isMembershipActive;
    }

    public void setMembershipActive(boolean membershipActive) {
        isMembershipActive = membershipActive;
    }
}
