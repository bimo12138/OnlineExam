package com.bimo.OnlineExam.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bimo.OnlineExam.pojo.ChooseQuestion;
import com.bimo.OnlineExam.pojo.JudgmentQuestion;
import com.bimo.OnlineExam.service.ChooseQuestionService;
import com.bimo.OnlineExam.service.JudgmentQuestionService;
import com.bimo.OnlineExam.service.impl.ChooseQuestionServiceImpl;
import com.bimo.OnlineExam.service.impl.JudgmentQuestionServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: JudgmentListener
 * @Author: 13716
 * @Date: 2020/7/31 11:32
 * @Version: 1.0
 **/


public class JudgmentListener extends AnalysisEventListener<JudgmentQuestion> {
    private static final int BATCH_COUNT = 10;
    List<JudgmentQuestion> judgmentQuestions = new ArrayList<JudgmentQuestion>();
    private final JudgmentQuestionService judgmentQuestionService;

    private Integer examId;

    public JudgmentListener() {
        this.judgmentQuestionService = new JudgmentQuestionServiceImpl();
    }

    public JudgmentListener(JudgmentQuestionService judgmentQuestionService, Integer examId) {
        this.judgmentQuestionService = judgmentQuestionService;
        this.examId = examId;
    }

    @Override
    public void invoke(JudgmentQuestion judgmentQuestion, AnalysisContext analysisContext) {
        judgmentQuestion.setExamId(examId);
        judgmentQuestions.add(judgmentQuestion);
        if (judgmentQuestions.size() >= BATCH_COUNT) {
            judgmentQuestionService.saveBatch(judgmentQuestions);
            judgmentQuestions.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        judgmentQuestionService.saveBatch(judgmentQuestions);
    }
}
