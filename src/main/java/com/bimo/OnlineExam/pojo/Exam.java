package com.bimo.OnlineExam.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

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

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    private Integer availableScore;

    private Integer uploader;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
