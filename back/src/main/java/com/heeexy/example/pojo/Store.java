package com.heeexy.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("dc_store")
public class Store extends BasePojo{
    @TableId(type = IdType.AUTO)
    private Integer storeId;
    private String storeName;
    private String addr;
    private String tel;
    private String ownerName;
    private String ownerTel;
    private Date openTime;
    private Date endTime;
    private Integer totalMoney;
    private int status;
    private String creator;
    private String updater;
    private String description;
}
