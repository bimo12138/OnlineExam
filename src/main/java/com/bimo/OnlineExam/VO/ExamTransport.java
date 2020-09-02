package com.bimo.OnlineExam.VO;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

/**
 * @ClassName: ExamTransport
 * @Author: 13716
 * @Date: 2020/8/3 15:01
 * @Version: 1.0
 **/

@Data
public class ExamTransport {

    private Integer id;

    private String name;

    private LocalDateTime uploadTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    private Integer availableScore;

    private String uploader;
    /**
     * 0 上传 -> 解析中
     * 1 解析成功
     * 2 结束考试
     * 3 废弃
     */
    private String status;

}
