package com.leyou.shop.model;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.leyou.shop.util.JsonLongSerializer;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@Table(name = "tb_order")
public class Order {
    @Id
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long order_id;
    private Long total_pay;
    private Long actual_pay;
    private String promotion_ids;
    private Boolean payment_type;
    private Long post_fee;
    private Date create_time;
    private String shipping_name;
    private String shipping_code;
    @JsonSerialize(using = JsonLongSerializer.class)
    private String user_id;
    private String buyer_message;
    private String buyer_nick;
    private Boolean buyer_rate;
    private String receiver_state;
    private String receiver_city;
    private String receiver_district;
    private String receiver_address;
    private String receiver_mobile;
    private String receiver_zip;
    private String receiver;
    private Integer invoice_type;
    private Integer source_type;

}
