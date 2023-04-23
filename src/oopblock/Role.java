package oopblock;

import java.util.EnumSet;

/**
 * Role is an object that contains next private fields:
 * viewAll; editAll; addAll; deleteAll.
 * All this values must be added in process of creation Role object and never changed again.
 * Admin - all true;
 * viewer - only first true;
 * customer - viewAll=true, addAll=true;
 * main customer - viewAll=true, addAll=true, editAll=true.
 * Role object must be generated in process of creation a user depend on role type, mentioned before.
 */
public class Role {

    private boolean viewAll;
    private boolean editAll;
    private boolean addAll;
    private boolean deleteAll;
    private RoleTypes type;

    public Role(RoleTypes type) {
        this.type = type;
        if (type.equals(RoleTypes.ADMIN)) {
            this.viewAll = true;
            this.editAll = true;
            this.addAll = true;
            this.deleteAll = true;
        }
        if (type.equals(RoleTypes.MAIN_CUSTOMER)) {
            this.viewAll = true;
            this.editAll = true;
            this.addAll = true;
            this.deleteAll = false;
        }
        if (type.equals(RoleTypes.CUSTOMER)) {
            this.viewAll = true;
            this.editAll = false;
            this.addAll = true;
            this.deleteAll = false;
        }
        if (type.equals(RoleTypes.VIEWER)) {
            this.viewAll = true;
            this.editAll = false;
            this.addAll = false;
            this.deleteAll = false;
        }
    }

    public Role(int id) {
        EnumSet<RoleTypes> set = EnumSet.allOf(RoleTypes.class);
        for (RoleTypes i : set) {
            if (i.id == id) {
                this.type = i;
            }
        }
        if (type.equals(RoleTypes.ADMIN)) {
            this.viewAll = true;
            this.editAll = true;
            this.addAll = true;
            this.deleteAll = true;
        }
        if (type.equals(RoleTypes.MAIN_CUSTOMER)) {
            this.viewAll = true;
            this.editAll = true;
            this.addAll = true;
            this.deleteAll = false;
        }
        if (type.equals(RoleTypes.CUSTOMER)) {
            this.viewAll = true;
            this.editAll = false;
            this.addAll = true;
            this.deleteAll = false;
        }
        if (type.equals(RoleTypes.VIEWER)) {
            this.viewAll = true;
            this.editAll = false;
            this.addAll = false;
            this.deleteAll = false;
        }
    }

    @Override
    public String toString() {
        return "RolePermissions{" +
                "viewAll=" + viewAll +
                ", editAll=" + editAll +
                ", addAll=" + addAll +
                ", deleteAll=" + deleteAll +
                '}';
    }
}