package com.app.WorkAssign.persistence.util;

public enum Permission {
    CREATE_CUSTOMER_USER, //Crear usuario Customer
    READ_CUSTOMER_USERS, //Listar usuarios Customer
    READ_ALL_CATEGORIES_TASK, //Ver categorias de tarea
    CREATE_CATEGORIES_TASK, //Cear categorias de tarea
    CREATE_USER_TASK, //Crear tarea asignada a user
    READ_USER_TASKS, //Ver tareas asignadas por id user
    EDIT_OWN_TASKS, //Editar tareas propias creación
    EDIT_ASSIGNED_TASKS, //Editar tareas después de asignadas
    ASSIGN_TASKS, //Asignar tareas a usuarios
    CHANGE_STATUS_TASKS, //Cambiar estado de tareas
    REMOVE_TASKS, //Eliminar tareas
    VIEW_DASHBOARD_STATS, //Ver tablero de estadísticas
    VIEW_USER_PROFILE, //Ver perfil de usuarios
}
