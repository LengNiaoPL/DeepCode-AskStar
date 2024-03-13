package com.gdut.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

//这个包里是表的实体类

//用注解添加javabean  <lombok>
@AllArgsConstructor//全参
@NoArgsConstructor//无参
@Data//get set equals hashcode toString

public class Ans implements Serializable {
    Integer aid;
    String anses;
    Integer whatans;

}
