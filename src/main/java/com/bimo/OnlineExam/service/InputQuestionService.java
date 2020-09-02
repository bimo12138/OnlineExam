package com.bimo.OnlineExam.service;

import com.bimo.OnlineExam.pojo.InputQuestion;
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
public interface InputQuestionService extends IService<InputQuestion> {
    public List<InputQuestion> getInputQuestionByExamId(Integer examId);
    public List<InputQuestion> getInputQuestionWithRandom(Integer num, Integer examId);
}
