package com.heeexy.example.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("dc_order")
@Accessors(chain = true)
public class Order extends BasePojo{
    @TableId
    private Integer orderId;

    @TableField(exist = false)
    private String orderNum;

    private Integer orderTotal;
    private String orderInfo;
    private String orderPayType;
    private Integer orderState;
    private Integer orderItemId;
    private Integer orderUserId;
    private Integer deleteState;
}
