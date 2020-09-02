package com.bimo.OnlineExam.service;

import com.alibaba.excel.EasyExcel;
import com.bimo.OnlineExam.pojo.ChooseQuestion;
import com.bimo.OnlineExam.pojo.InputQuestion;
import com.bimo.OnlineExam.pojo.JudgmentQuestion;
import com.bimo.OnlineExam.pojo.SubjectiveQuestion;
import com.bimo.OnlineExam.utils.ChooseListener;
import com.bimo.OnlineExam.utils.InputListener;
import com.bimo.OnlineExam.utils.JudgmentListener;
import com.bimo.OnlineExam.utils.SubjectiveListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @ClassName: AsyncTask
 * @Author: 13716
 * @Date: 2020/7/31 13:40
 * @Version: 1.0
 **/

@Component
public class AsyncTask {

    private ChooseQuestionService chooseQuestionService;
    private JudgmentQuestionService judgmentQuestionService;
    private InputQuestionService inputQuestionService;
    private SubjectiveQuestionService subjectiveQuestionService;
    private ExamService examService;

    @Autowired
    public void setChooseQuestionService(ChooseQuestionService chooseQuestionService) {
        this.chooseQuestionService = chooseQuestionService;
    }
    @Autowired
    public void setJudgmentQuestionService(JudgmentQuestionService judgmentQuestionService) {
        this.judgmentQuestionService = judgmentQuestionService;
    }
    @Autowired
    public void setInputQuestionService(InputQuestionService inputQuestionService) {
        this.inputQuestionService = inputQuestionService;
    }
    @Autowired
    public void setSubjectiveQuestionService(SubjectiveQuestionService subjectiveQuestionService) {
        this.subjectiveQuestionService = subjectiveQuestionService;
    }
    @Autowired
    public void setExamService(ExamService examService) {
        this.examService = examService;
    }

    @Async
    public void loadExam(String excelPath, String filename) {
        Integer examId = examService.getIdByFile(filename);
        // 读取选择题
        EasyExcel.read(excelPath, ChooseQuestion.class, new ChooseListener(chooseQuestionService, examId))
                .sheet().doRead();
        // 读取判断题
        EasyExcel.read(excelPath, JudgmentQuestion.class, new JudgmentListener(judgmentQuestionService, examId))
                .sheet(1).doRead();
        // 读取填空题
        EasyExcel.read(excelPath, InputQuestion.class, new InputListener(inputQuestionService, examId))
                .sheet(2).doRead();
        // 读取主观题
        EasyExcel.read(excelPath, SubjectiveQuestion.class, new SubjectiveListener(subjectiveQuestionService, examId))
                .sheet(3).doRead();
        examService.changeExamStatus(examId, "1");
    }
}
