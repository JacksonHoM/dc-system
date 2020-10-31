package com.heeexy.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("dc_order_userinfo")
@Accessors(chain = true)
public class OrderUser extends BasePojo {

    @TableId
    private Integer ouId;

    private Integer storeId;

    private Integer userId;

    private String userAddr;

    private String userName;

    private String userTel;




}
