package edu.springboot.sbmuc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @TableName member
 */
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Data
public class Member implements java.io.Serializable {
    private Long userId;
    private String userName;
    private String userPass;
    private String nickName;
    private String email;
    private String mobile;
    private String myId;
    private String myIdKey;
    private String regIp;
    private java.util.Date regDate;
    private String lastLoginIp;
    private java.util.Date lastLoginTime;
    private String salt;
    private String secques;
    private String status;
    private String remark;
    private Long sortNum;
    private Long isDeleted;
    private Long createBy;
    private Long updateBy;
    private java.util.Date createOn;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private java.util.Date updateOn;
}
