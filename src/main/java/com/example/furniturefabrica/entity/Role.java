package com.example.furniturefabrica.entity;

import com.example.furniturefabrica.entity.enums.Permission;
import com.example.furniturefabrica.entity.templete.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.util.List;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Data

public class Role extends AbsEntity {
    @Column(nullable = false, unique = true)
    private String name;

    private String description;
    @ElementCollection(fetch = FetchType.LAZY)
    @Enumerated(EnumType.STRING)
    private List<Permission> permissions;

    @CreatedBy
    private Long createdBy;

    @LastModifiedBy
    private Long updateBy;

    public Role(String name, String description, List<Permission> permissions) {
        this.name = name;
        this.permissions = permissions;
        this.description = description;

    }


}
