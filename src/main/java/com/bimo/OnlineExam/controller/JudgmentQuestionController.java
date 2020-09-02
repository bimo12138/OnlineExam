package com.bimo.OnlineExam.controller;


import com.bimo.OnlineExam.VO.BaseResponse;
import com.bimo.OnlineExam.pojo.JudgmentQuestion;
import com.bimo.OnlineExam.service.JudgmentQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
@RestController
@RequestMapping("/judgmentQuestion")
public class JudgmentQuestionController {
    private JudgmentQuestionService judgmentQuestionService;

    @Autowired
    public void setJudgmentQuestionService(JudgmentQuestionService judgmentQuestionService) {
        this.judgmentQuestionService = judgmentQuestionService;
    }

    @GetMapping
    public BaseResponse getJudgementList(Integer examId) {
        List<JudgmentQuestion> judgmentQuestions = judgmentQuestionService.getJudgmentQuestionByExamId(examId);
        if (judgmentQuestions.size() <= 0) {
            return new BaseResponse(HttpStatus.NO_CONTENT, "当前考试没有判断题！");
        }
        return new BaseResponse(HttpStatus.OK, judgmentQuestions);
    }
}

