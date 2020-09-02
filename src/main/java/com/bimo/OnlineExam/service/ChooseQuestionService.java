package com.bimo.OnlineExam.service;

import com.bimo.OnlineExam.pojo.ChooseQuestion;
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
public interface ChooseQuestionService extends IService<ChooseQuestion> {
    public List<ChooseQuestion> getChooseQuestionsByExamId(Integer examId);
    public List<ChooseQuestion> getChooseQuestionWithRandom(Integer num, String level, Integer examId);
}
