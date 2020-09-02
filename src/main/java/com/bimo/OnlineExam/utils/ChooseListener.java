package com.bimo.OnlineExam.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bimo.OnlineExam.pojo.ChooseQuestion;
import com.bimo.OnlineExam.service.ChooseQuestionService;
import com.bimo.OnlineExam.service.impl.ChooseQuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: ExcelUtils
 * @Author: 13716
 * @Date: 2020/7/29 23:09
 * @Version: 1.0
 **/


public class ChooseListener extends AnalysisEventListener<ChooseQuestion> {
    private static final int BATCH_COUNT = 10;
    List<ChooseQuestion> chooseQuestions = new ArrayList<ChooseQuestion>();
    private final ChooseQuestionService chooseQuestionService;
    private Integer examId;

    public ChooseListener() {
        this.chooseQuestionService = new ChooseQuestionServiceImpl();
    }

    public ChooseListener(ChooseQuestionService chooseQuestionService, Integer examId) {
        this.chooseQuestionService = chooseQuestionService;
        this.examId = examId;
    }


    @Override
    public void invoke(ChooseQuestion chooseQuestion, AnalysisContext analysisContext) {
        chooseQuestion.setExamId(examId);
        chooseQuestions.add(chooseQuestion);
        if (chooseQuestions.size() >= BATCH_COUNT) {
            chooseQuestionService.saveBatch(chooseQuestions);
            chooseQuestions.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        chooseQuestionService.saveBatch(chooseQuestions);
    }
}
