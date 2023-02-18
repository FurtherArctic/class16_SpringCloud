package com.powernode.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wangjunchen
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Users implements Serializable {
    private Integer id;
    private String name;
    private String phone;
}
