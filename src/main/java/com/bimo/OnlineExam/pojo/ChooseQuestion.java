package com.bimo.OnlineExam.pojo;

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
public class ChooseQuestion extends Model<ChooseQuestion> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String title;

    private String chooseA;

    private String chooseB;

    private String chooseC;

    private String chooseD;

    private String answer;

    private String analyse;

    private Integer examId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
