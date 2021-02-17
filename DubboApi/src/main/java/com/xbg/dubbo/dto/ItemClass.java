package com.xbg.dubbo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class ItemClass implements Serializable {

    private String name;

    private String desc;
}
