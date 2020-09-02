package com.bimo.OnlineExam.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.bimo.OnlineExam.pojo.ChooseQuestion;
import com.bimo.OnlineExam.pojo.InputQuestion;
import com.bimo.OnlineExam.service.ChooseQuestionService;
import com.bimo.OnlineExam.service.InputQuestionService;
import com.bimo.OnlineExam.service.impl.ChooseQuestionServiceImpl;
import com.bimo.OnlineExam.service.impl.InputQuestionServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: InputListener
 * @Author: 13716
 * @Date: 2020/7/31 11:20
 * @Version: 1.0
 **/


public class InputListener extends AnalysisEventListener<InputQuestion> {
    private static final int BATCH_COUNT = 10;
    List<InputQuestion> inputQuestions = new ArrayList<InputQuestion>();
    private final InputQuestionService inputQuestionService;
    private Integer examId;

    public InputListener() {
        this.inputQuestionService = new InputQuestionServiceImpl();
    }

    public InputListener(InputQuestionService inputQuestionService, Integer examId) {
        this.inputQuestionService = inputQuestionService;
        this.examId = examId;
    }


    @Override
    public void invoke(InputQuestion inputQuestion, AnalysisContext analysisContext) {
        inputQuestion.setExamId(examId);
        inputQuestions.add(inputQuestion);
        if (inputQuestions.size() >= BATCH_COUNT) {
            inputQuestionService.saveBatch(inputQuestions);
            inputQuestions.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        inputQuestionService.saveBatch(inputQuestions);
    }
}
