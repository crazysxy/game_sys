package com.situ.bean;

import com.alibaba.excel.annotation.ExcelProperty;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameInfoVo {
    @ExcelProperty(value = "游戏id")
    private Integer gid;
    @ExcelProperty(value = "游戏序号")
    private String gno;
    @ExcelProperty(value = "游戏名字")
    private  String gameName;
    @ExcelProperty(value = "游戏类型")
    private String gameType;
    @ExcelProperty(value = "发售状态0：未入库 1：已入库")
    private  String status;
    @ExcelProperty(value = "游戏厂商")
    private String cname;
    @ExcelProperty(value = "游戏厂商编号")
    private String cid;
    @ExcelProperty(value = "发售时间")
    @JsonFormat(pattern = "yyyy年MM月dd日" ,timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy年MM月dd日 ")
    private Date releaseDate;
    @ExcelProperty(value = "游戏价格")
    private BigDecimal price;


}
