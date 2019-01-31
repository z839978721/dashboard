package com.cloud.model.role;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role implements Serializable {
    /**
     * 
     */
    private String id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 描述
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}