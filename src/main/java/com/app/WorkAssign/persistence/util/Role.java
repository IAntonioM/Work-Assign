package com.app.WorkAssign.persistence.util;

import java.util.Arrays;
import java.util.List;

public enum Role {
    CUSTOMER(Arrays.asList(
            Permission.READ_ALL_CATEGORIES_TASK,
            Permission.READ_CUSTOMER_USERS
    )
    ),

    ADMINISTRATOR(Arrays.asList(
            Permission.CREATE_CUSTOMER_USER,
            Permission.READ_ALL_CATEGORIES_TASK,
            Permission.CREATE_CATEGORIES_TASK,
            Permission.CREATE_USER_TASK,
            Permission.READ_USER_TASKS
    )
    );

    private List<Permission> permissions;

    Role(List<Permission> permissions) {
        this.permissions = permissions;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }
}
