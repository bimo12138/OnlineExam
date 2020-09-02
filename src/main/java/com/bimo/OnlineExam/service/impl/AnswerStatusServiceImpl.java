package com.bimo.OnlineExam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bimo.OnlineExam.pojo.AnswerStatus;
import com.bimo.OnlineExam.mapper.AnswerStatusMapper;
import com.bimo.OnlineExam.pojo.Exam;
import com.bimo.OnlineExam.service.AnswerStatusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
@Service
public class AnswerStatusServiceImpl extends ServiceImpl<AnswerStatusMapper, AnswerStatus> implements AnswerStatusService {
    private final QueryWrapper<AnswerStatus> queryWrapper = new QueryWrapper<>();

    @Override
    public AnswerStatus getAnswerByUserIdAndExamId(Integer userId, Integer examId) {
        return getOne(queryWrapper.eq("user_id", userId).eq("exam_id", examId));
    }
}
