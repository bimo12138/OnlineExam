package com.bimo.OnlineExam.service;

import com.bimo.OnlineExam.pojo.Exam;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
public interface ExamService extends IService<Exam> {
    public List<Exam> getNewExam();
    public boolean loadExamMessage(MultipartFile file);
    public boolean changeExamStatus(Integer examId, String status);
    public int getIdByFile(String filename);
    public List<Exam> getMyExam(Integer userId);
}
