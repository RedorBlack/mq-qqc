package com.red.black.model;


import java.io.Serializable;
import lombok.Data;
import lombok.experimental.Accessors;

/** @Author: Red @Descpription: @Date: 11:14 2019/11/22 */
@Data
@Accessors(chain = true)
public class Red  {


  private String name;
  private int version;
  private String message;

}
