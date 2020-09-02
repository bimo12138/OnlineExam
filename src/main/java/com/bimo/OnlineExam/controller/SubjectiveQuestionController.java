package com.bimo.OnlineExam.controller;


import com.bimo.OnlineExam.VO.BaseResponse;
import com.bimo.OnlineExam.pojo.SubjectiveQuestion;
import com.bimo.OnlineExam.service.SubjectiveQuestionService;
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
@RequestMapping("/subjectiveQuestion")
public class SubjectiveQuestionController {
    private SubjectiveQuestionService subjectiveQuestionService;

    @Autowired
    public void setSubjectiveQuestionService(SubjectiveQuestionService subjectiveQuestionService) {
        this.subjectiveQuestionService = subjectiveQuestionService;
    }

    @GetMapping
    public BaseResponse getSubjectiveList(Integer examId) {
        List<SubjectiveQuestion> subjectiveQuestionList =
                subjectiveQuestionService.getSubjectiveQuestionByExamId(examId);
        if (subjectiveQuestionList.size() <= 0) {
            return new BaseResponse(HttpStatus.NO_CONTENT, "当前考试没有主观题");
        }
        return new BaseResponse(HttpStatus.OK, subjectiveQuestionList);
    }
}

