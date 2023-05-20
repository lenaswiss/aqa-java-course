package oopblock;

import java.util.EnumSet;
import java.util.Set;

/**
 * There are 4 types of roles: Admin, Main Customer, Customer and Viewer.
 */
public enum RoleTypes {

    ADMIN(1),
    MAIN_CUSTOMER(2),
    CUSTOMER(3),
    VIEWER(4);

    int id;
    RoleTypes(int id){
        this.id = id;
    }

    public int getId(int p){
        return this.id;
    }
}
