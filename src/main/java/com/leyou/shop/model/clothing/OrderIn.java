package com.leyou.shop.model.clothing;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Table(name = "order_in")
public class OrderIn {
    @Id
    private String order_no;
    private Date in_date;
    private String person;
    private Integer warehouse;
    private String befrom;
    private String remark;
    private Boolean flag;
}
