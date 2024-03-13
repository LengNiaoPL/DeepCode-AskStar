package com.gdut.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


//用注解添加javabean  <lombok>
@AllArgsConstructor//全参
@NoArgsConstructor//无参
@Data//get set equals hashcode toString

public class Question implements Serializable {
    Integer qid;
    String questionchar;
    String username;
}
