package com.bimo.OnlineExam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bimo.OnlineExam.pojo.SubjectiveQuestion;
import com.bimo.OnlineExam.mapper.SubjectiveQuestionMapper;
import com.bimo.OnlineExam.service.SubjectiveQuestionService;
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
public class SubjectiveQuestionServiceImpl extends ServiceImpl<SubjectiveQuestionMapper, SubjectiveQuestion> implements SubjectiveQuestionService {
    @Override
    public List<SubjectiveQuestion> getSubjectiveQuestionByExamId(Integer examId) {
        QueryWrapper<SubjectiveQuestion> subjectiveQuestionQueryWrapper =
                new QueryWrapper<SubjectiveQuestion>().eq("exam_id", examId);
        return list(subjectiveQuestionQueryWrapper);
    }

    @Override
    public List<SubjectiveQuestion> getSubjectiveQuestionWithRandom(Integer num, Integer examId) {
        QueryWrapper<SubjectiveQuestion> subjectiveQuestionQueryWrapper =
                new QueryWrapper<SubjectiveQuestion>().eq("exam_id", examId);
        return list(subjectiveQuestionQueryWrapper.last("order by rand() limit " + num));
    }
}
