package com.bimo.OnlineExam.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.bimo.OnlineExam.utils.PasswordUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;
import sun.security.util.Password;

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
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    private String sex;

    private Boolean isUploader;

    private Boolean isSuperuser;

    private String email;

    private LocalDateTime createTime;

    private String icon;

    public User() {

    }

    public User(String username, String password) {
        this.username = username;
        this.password = PasswordUtils.encode(password);
        this.sex = "0";
        this.isUploader = false;
        this.isSuperuser = false;
        this.createTime = LocalDateTime.now();
        this.icon = "demo.icon";
    }

    public User(String username, String password, boolean isUploader) {
        this.username = username;
        this.password = PasswordUtils.encode(password);
        this.sex = "0";
        this.isUploader = isUploader;
        this.isUploader = false;
        this.createTime = LocalDateTime.now();
        this.icon = "demo.icon";
    }

    public User(String username, String password, boolean isUploader, String email) {
        this.username = username;
        this.password = PasswordUtils.encode(password);
        this.sex = "0";
        this.isUploader = isUploader;
        this.isUploader = false;
        this.createTime = LocalDateTime.now();
        this.icon = "demo.icon";
        this.email = email;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public boolean checkPassword(String encoded) {
        return PasswordUtils.match(this.password, encoded);
    }

    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();
        if (this.isSuperuser) {
            roles.add("SUPERUSER");
        }
        if (this.isUploader) {
            roles.add("UPLOADER");
        }
        return roles;
    }
}
