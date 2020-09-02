package com.bimo.OnlineExam.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bimo.OnlineExam.pojo.JudgmentQuestion;
import com.bimo.OnlineExam.pojo.SubjectiveQuestion;
import com.bimo.OnlineExam.service.JudgmentQuestionService;
import com.bimo.OnlineExam.service.SubjectiveQuestionService;
import com.bimo.OnlineExam.service.impl.JudgmentQuestionServiceImpl;
import com.bimo.OnlineExam.service.impl.SubjectiveQuestionServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SubjectiveListener
 * @Author: 13716
 * @Date: 2020/7/31 13:04
 * @Version: 1.0
 **/


public class SubjectiveListener extends AnalysisEventListener<SubjectiveQuestion> {
    private static final int BATCH_COUNT = 10;
    List<SubjectiveQuestion> subjectiveQuestions = new ArrayList<SubjectiveQuestion>();
    private final SubjectiveQuestionService subjectiveQuestionService;

    private Integer examId;

    public SubjectiveListener() {
        this.subjectiveQuestionService = new SubjectiveQuestionServiceImpl();
    }

    public SubjectiveListener(SubjectiveQuestionService subjectiveQuestionService, Integer examId) {
        this.subjectiveQuestionService = subjectiveQuestionService;
        this.examId = examId;
    }

    @Override
    public void invoke(SubjectiveQuestion subjectiveQuestion, AnalysisContext analysisContext) {
        subjectiveQuestion.setExamId(examId);
        subjectiveQuestions.add(subjectiveQuestion);
        if (subjectiveQuestions.size() >= BATCH_COUNT) {
            subjectiveQuestionService.saveBatch(subjectiveQuestions);
            subjectiveQuestions.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        subjectiveQuestionService.saveBatch(subjectiveQuestions);
    }
}
