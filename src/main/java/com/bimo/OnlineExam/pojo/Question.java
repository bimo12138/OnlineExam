package com.bimo.OnlineExam.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: Question
 * @Author: 13716
 * @Date: 2020/7/26 10:46
 * @Version: 1.0
 **/

@Getter
@Setter
public class Question {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField(value = "title")
    private String title;

    @TableField(value = "exam_id")
    private Exam exam;

    public Question() {
    }

    public Question(String title, Exam exam) {
        this.title = title;
        this.exam = exam;
    }
}
