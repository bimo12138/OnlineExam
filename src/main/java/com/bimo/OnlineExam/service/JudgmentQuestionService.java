package com.bimo.OnlineExam.service;

import com.bimo.OnlineExam.pojo.ChooseQuestion;
import com.bimo.OnlineExam.pojo.JudgmentQuestion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
public interface JudgmentQuestionService extends IService<JudgmentQuestion> {
    public List<JudgmentQuestion> getJudgmentQuestionByExamId(Integer examId);
    public List<JudgmentQuestion> getJudgmentQuestionWithRandom(Integer num, String level, Integer examId);
}
