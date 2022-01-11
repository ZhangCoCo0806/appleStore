package com.coco.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleTable {
    private Integer id;
    private String role;
    private List<PermissionTable> permissionTable;
}
