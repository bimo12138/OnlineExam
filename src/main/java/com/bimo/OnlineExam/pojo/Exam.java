package com.bimo.OnlineExam.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author bimo
 * @since 2020-07-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Exam extends Model<Exam> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String name;

    private LocalDateTime uploadTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endTime;

    private Integer availableScore;

    private Integer uploader;
    /**
     * 0 上传 -> 解析中
     * 1 解析成功
     * 2 结束考试
     * 3 废弃
     */
    private String status;

    private String rawFile;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
