package com.heeexy.example.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("dc_order_iteminfo")
@Accessors(chain = true)
public class OrderItem extends BasePojo {

    @TableId
    private Integer otId;

    private Integer itemId;

    private String itemName;

    private Integer itemPrice;

    private Integer itemNum;







}
