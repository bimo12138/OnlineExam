package com.bimo.OnlineExam.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName: JudgementQuestion
 * @Author: 13716
 * @Date: 2020/7/26 11:33
 * @Version: 1.0
 **/
@Getter
@Setter
@TableName("judgement_question")
public class JudgementQuestion extends Question {

    @TableField()
    private boolean answer;

    @TableField()
    private String analyse;

    public JudgementQuestion() {
        super();
    }

    public JudgementQuestion(String title, boolean answer, String analyse, Exam exam) {
        super(title, exam);
        this.answer = answer;
        this.analyse = analyse;
    }

}
