package edu.springboot.sbmuc.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * 新闻猫
 *
 * @author Yefl
 * @date 2022/11/21
 */
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NewsCat implements Serializable {
    private static final long serialVersionUID = -5328275127880780713L;


    private Long catId;
    private String catName;
    private String catDesc;
    private Long parentId;
    private String status;
    private String remark;
    private Long sortNum;
    private Long isDeleted;
    private Long createBy;
    private Long updateBy;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createOn;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateOn;


}
