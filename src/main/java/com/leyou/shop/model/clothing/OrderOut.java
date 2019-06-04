package com.leyou.shop.model.clothing;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "order_out")
public class OrderOut {
    @Id
    private String order_no;
    private Date out_date;
    private String person;
    private String rperson;
    private Integer warehouse;
    private String tel;  //接收人电话
    private String address;
    private String remark;
    private Boolean flag;
}
