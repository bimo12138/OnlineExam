package com.bimo.OnlineExam.mapper;

import com.bimo.OnlineExam.VO.ExamTransport;
import com.bimo.OnlineExam.pojo.Exam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
public interface ExamMapper extends BaseMapper<Exam> {
     @Select("SELECT exam.id, exam.name, exam.upload_time, exam.start_time, exam.end_time, exam.available_score, user.username as uploader, exam.status FROM exam LEFT JOIN user on user.id = exam.uploader ORDER BY upload_time DESC LIMIT 6 ")
     public List<ExamTransport> getNewExams();
}
