package com.qf.mytt.domain;



import com.qf.mytt.common.RegexpUtils;
import com.qf.mytt.common.validatorInterface.InsertValidate;
import com.qf.mytt.common.validatorInterface.UpdateValidate;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class TbUser extends BaseEntity implements Serializable {

    private long fansId;
    private long focusId;
    private String status;

    @Length(min=6,max=20,message = "用户名长度必须为6-20位",groups ={InsertValidate.class, UpdateValidate.class})
    private String username;
    @Length(min=6,max=20,message = "密码长度必须为6-20位",groups ={InsertValidate.class})
    private String password;
    @Pattern(regexp = RegexpUtils.PHONE,message = "手机号码格式不正确",groups ={InsertValidate.class, UpdateValidate.class})
    private String phone;
    @Pattern(regexp = RegexpUtils.EMAIL,message = "邮箱格式不正确",groups ={InsertValidate.class, UpdateValidate.class})
    private String email;

    //拓展属性
    private String remember;
    private String autoLogin;


}
