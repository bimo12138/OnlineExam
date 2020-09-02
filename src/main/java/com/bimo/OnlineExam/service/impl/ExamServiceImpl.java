package com.bimo.OnlineExam.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bimo.OnlineExam.pojo.Exam;
import com.bimo.OnlineExam.mapper.ExamMapper;
import com.bimo.OnlineExam.pojo.User;
import com.bimo.OnlineExam.service.ExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {
    private final QueryWrapper<Exam> queryWrapper = new QueryWrapper<>();
    private final UpdateWrapper<Exam> updateWrapper = new UpdateWrapper<>();

    @Override
    public List<Exam> getNewExam() {
        return list(queryWrapper.orderByDesc("upload_time").last("LIMIT 5"));
    }

    @Override
    public boolean loadExamMessage(MultipartFile file) {
        return false;
    }

    @Override
    public boolean changeExamStatus(Integer examId, String status) {
        return update(updateWrapper.set("status", status).eq("id", examId));
    }

    @Override
    public int getIdByFile(String filename) {
        return getOne(queryWrapper.eq("raw_file", filename)).getId();
    }

    @Override
    public List<Exam> getMyExam(Integer userId) {
        return list(queryWrapper.eq("uploader", userId));
    }
}
