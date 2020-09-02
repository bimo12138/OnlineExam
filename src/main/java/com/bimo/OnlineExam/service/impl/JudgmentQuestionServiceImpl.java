package com.bimo.OnlineExam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bimo.OnlineExam.pojo.JudgmentQuestion;
import com.bimo.OnlineExam.mapper.JudgmentQuestionMapper;
import com.bimo.OnlineExam.service.JudgmentQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bimo.OnlineExam.utils.StringAndIntConversion;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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
public class JudgmentQuestionServiceImpl extends ServiceImpl<JudgmentQuestionMapper, JudgmentQuestion> implements JudgmentQuestionService {
    @Override
    public List<JudgmentQuestion> getJudgmentQuestionByExamId(Integer examId) {
        QueryWrapper<JudgmentQuestion> judgmentQuestionQueryWrapper =
                new QueryWrapper<JudgmentQuestion>().eq("exam_id", examId);
        return list(judgmentQuestionQueryWrapper);
    }

    @Override
    public List<JudgmentQuestion> getJudgmentQuestionWithRandom(Integer num, String level, Integer examId) {
        int[] res = StringAndIntConversion.getInts(level);
        if (res == null) res = new int[] {7, 2, 1};
        int easy = 0, medium = 0, difficult = 0;
        if (num == 5) {
            easy = 3;
            medium = 1;
            difficult = 1;
        } else if (num >= 10) {
            difficult = (num / 10) * res[2];
            medium = (num / 10) * res[1];
            easy = num - difficult - medium;
        } else {
            easy = num;
        }
        QueryWrapper<JudgmentQuestion> judgmentQuestionQueryWrapper =
                new QueryWrapper<JudgmentQuestion>().eq("exam_id", examId);
        List<JudgmentQuestion> judges = list(judgmentQuestionQueryWrapper
                .last("and level = " + 1 + " order by rand() limit " + easy));
        judges.addAll(list(judgmentQuestionQueryWrapper
                .last("and level = " + 2 + " order by rand() limit " + medium)));
        judges.addAll(list(judgmentQuestionQueryWrapper
                .last("and level = " + 3 + " order by rand() limit " + difficult)));
        return judges;
    }
}
