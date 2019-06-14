package com.leyou.shop.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MongoDemo {
    @Id
    private Integer id;
    private String name;
    private Integer age;
}
