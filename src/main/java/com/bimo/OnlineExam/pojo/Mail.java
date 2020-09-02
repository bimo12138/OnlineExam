package com.bimo.OnlineExam.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName: Mail
 * @Author: 13716
 * @Date: 2020/8/1 13:40
 * @Version: 1.0
 **/

@Data
public class Mail implements Serializable {
    private Integer id;
    private String to;
    private String subject;
    private String content;

}
