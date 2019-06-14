package com.leyou.shop.model.mongo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.leyou.shop.util.JsonLongSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Comment {
    @Id
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long id;
    private Integer spu_id;
    private String detail;
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long parent_id;
    @JsonSerialize(using = JsonLongSerializer.class)
    private Long user_id;
    private String user_name;
    private Integer star;
    private Date create_time;
}
