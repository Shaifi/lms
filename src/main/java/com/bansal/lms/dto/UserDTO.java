package com.bansal.lms.dto;

import java.util.Date;

/**
 * @author shaifibansal
 */

public class UserDTO {

    private Long userId;
    private String userName;
    private Date createdDate;
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
