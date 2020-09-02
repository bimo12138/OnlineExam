package com.bimo.OnlineExam.controller;


import com.bimo.OnlineExam.VO.BaseResponse;
import com.bimo.OnlineExam.pojo.AnswerStatus;
import com.bimo.OnlineExam.service.AnswerStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
@RestController
@RequestMapping("/answerStatus")
public class AnswerStatusController {
    private AnswerStatusService answerStatusService;

    @Autowired
    public void setAnswerStatusService(AnswerStatusService answerStatusService) {
        this.answerStatusService = answerStatusService;
    }

    @GetMapping
    public void getMyAnswer(Integer userId, Integer examId) {
        AnswerStatus answerStatus = answerStatusService.getAnswerByUserIdAndExamId(userId, examId);
    }

    @PostMapping
    public BaseResponse saveMyAnswer(AnswerStatus answerStatus) {
        boolean result = answerStatusService.save(answerStatus);
        if (result) {
            return new BaseResponse(HttpStatus.OK, "保存成功！");
        }
        return new BaseResponse(HttpStatus.BAD_REQUEST, "保存失败！请重试");
    }
}

