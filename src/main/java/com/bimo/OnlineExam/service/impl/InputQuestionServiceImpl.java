package com.bimo.OnlineExam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bimo.OnlineExam.pojo.InputQuestion;
import com.bimo.OnlineExam.mapper.InputQuestionMapper;
import com.bimo.OnlineExam.service.InputQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
@Service
public class InputQuestionServiceImpl extends ServiceImpl<InputQuestionMapper, InputQuestion> implements InputQuestionService {
    @Override
    public List<InputQuestion> getInputQuestionByExamId(Integer examId) {
        QueryWrapper<InputQuestion> inputQuestionQueryWrapper =
                new QueryWrapper<InputQuestion>().eq("exam_id", examId);
        return list(inputQuestionQueryWrapper);
    }

    @Override
    public List<InputQuestion> getInputQuestionWithRandom(Integer num, Integer examId) {
        QueryWrapper<InputQuestion> inputQuestionQueryWrapper =
                new QueryWrapper<InputQuestion>().eq("exam_id", examId);
        return list(inputQuestionQueryWrapper.last("order by rand() limit " + num));
    }
}
