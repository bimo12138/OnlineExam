package com.bimo.OnlineExam.service.impl;

import com.baomidou.mybatisplus.core.conditions.SharedString;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bimo.OnlineExam.pojo.ChooseQuestion;
import com.bimo.OnlineExam.mapper.ChooseQuestionMapper;
import com.bimo.OnlineExam.service.ChooseQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bimo.OnlineExam.utils.StringAndIntConversion;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
public class ChooseQuestionServiceImpl extends ServiceImpl<ChooseQuestionMapper, ChooseQuestion> implements ChooseQuestionService {

    @Override
    public List<ChooseQuestion> getChooseQuestionsByExamId(Integer examId) {
        QueryWrapper<ChooseQuestion> chooseQuestionQueryWrapper =
                new QueryWrapper<ChooseQuestion>().eq("exam_id", examId);
        return list(chooseQuestionQueryWrapper);
    }

    @Override
    public List<ChooseQuestion> getChooseQuestionWithRandom(Integer num, String level, Integer examId) {
        // 把 level 转化为 正常的 比例
        int[] res = StringAndIntConversion.getInts(level);
        // default action
        if (res == null) {
            res = new int[] {7, 2, 1};
        }
        int easy = 0;
        int medium = 0;
        int difficult = 0;
        // 如果需要获取的题目数量大于10 【按照比例来说是 10 份】
        if (num >= 10) {
            difficult = (num / 10) * res[2];
            medium = (num / 10) * res[1];
            easy = num - difficult - medium;
        } else {
            // 9 份 7 1 2
            if (num > (res[0] + res[1])) {
                easy = res[0];
                medium = res[1];
                difficult = num - res[0] - res[1];
            } else if (num > res[0]) {
                easy = res[0];
                medium = num - res[0];
            } else {
                easy = num;
            }
        }
        QueryWrapper<ChooseQuestion> chooseQuestionQueryWrapper =
                new QueryWrapper<ChooseQuestion>().eq("exam_id", examId);

        List<ChooseQuestion> chooses = list(chooseQuestionQueryWrapper
                .last("and level = " + 1 + " order by rand() limit " + easy));
        chooses.addAll(list(chooseQuestionQueryWrapper
                .last("and level = " + 2 + " order by rand() limit " + medium)));
        chooses.addAll(list(chooseQuestionQueryWrapper
                .last("and level = " + 3 + " order by rand() limit " + medium)));
        return chooses;
    }
}
