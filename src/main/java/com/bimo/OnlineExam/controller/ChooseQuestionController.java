package com.bimo.OnlineExam.controller;


import com.bimo.OnlineExam.VO.BaseResponse;
import com.bimo.OnlineExam.pojo.ChooseQuestion;
import com.bimo.OnlineExam.service.ChooseQuestionService;
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
@RequestMapping("/chooseQuestion")
public class ChooseQuestionController {

    private ChooseQuestionService chooseQuestionService;

    @Autowired
    public void setChooseQuestionService(ChooseQuestionService chooseQuestionService) {
        this.chooseQuestionService = chooseQuestionService;
    }

    @GetMapping
    public BaseResponse getChooseList(Integer examId) {
        List<ChooseQuestion> chooseQuestions = chooseQuestionService.getChooseQuestionsByExamId(examId);
        if (chooseQuestions.size() <= 0) {
            return new BaseResponse(HttpStatus.NO_CONTENT, "当前考试没有选择题！");
        }
        return new BaseResponse(HttpStatus.OK, chooseQuestions);
    }
}

