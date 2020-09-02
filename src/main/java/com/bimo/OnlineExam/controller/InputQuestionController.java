package com.bimo.OnlineExam.controller;


import com.bimo.OnlineExam.VO.BaseResponse;
import com.bimo.OnlineExam.pojo.InputQuestion;
import com.bimo.OnlineExam.service.InputQuestionService;
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
@RequestMapping("/inputQuestion")
public class InputQuestionController {
    private InputQuestionService inputQuestionService;

    @Autowired
    public void setInputQuestionService(InputQuestionService inputQuestionService) {
        this.inputQuestionService = inputQuestionService;
    }

    @GetMapping
    public BaseResponse getInput(Integer examId) {
        List<InputQuestion> inputQuestions = inputQuestionService.getInputQuestionByExamId(examId);
        if (inputQuestions.size() <= 0) {
            return new BaseResponse(HttpStatus.NO_CONTENT, "当前考试没有填空题！");
        }
        return new BaseResponse(HttpStatus.OK, inputQuestions);
    }
}

