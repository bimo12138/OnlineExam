package com.bimo.OnlineExam.service;

import com.bimo.OnlineExam.pojo.SubjectiveQuestion;
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
public interface SubjectiveQuestionService extends IService<SubjectiveQuestion> {
    public List<SubjectiveQuestion> getSubjectiveQuestionByExamId(Integer examId);
    public List<SubjectiveQuestion> getSubjectiveQuestionWithRandom(Integer num, Integer examId);
}
