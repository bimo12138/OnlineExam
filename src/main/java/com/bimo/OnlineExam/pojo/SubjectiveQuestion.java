package com.bimo.OnlineExam.pojo;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
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
public class SubjectiveQuestion extends Model<SubjectiveQuestion> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    @ExcelIgnore
    private Integer id;

    private String title;

    private String answer;
    @ExcelIgnore
    private Integer examId;

    private String level;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
