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

    public Role(boolean viewAll, boolean editAll, boolean addAll, boolean deleteAll) {
        this.viewAll = viewAll;
        this.editAll = editAll;
        this.addAll = addAll;
        this.deleteAll = deleteAll;

    }

    public static Role generateRole(String roleType) {
        return switch (roleType.toLowerCase()) {
            case "admin" -> new Role(true, true, true, true);
            case "viewer" -> new Role(true, false, false, false);
            case "main customer" -> new Role(true, true, true, false);
            case "customer" -> new Role(true, false, true, false);
            default -> null;
        };
    }

    public static Role generateRole(RoleTypes roleType) {
        return switch (roleType) {
            case ADMIN -> new Role(true, true, true, true);
            case VIEWER -> new Role(true, false, false, false);
            case MAIN_CUSTOMER -> new Role(true, true, true, false);
            case CUSTOMER -> new Role(true, false, true, false);
           // default -> null;
        };
    }

    @Override
    public String toString() {
        return "User role Permissions{ " +
                "viewAll=" + viewAll +
                ", editAll=" + editAll +
                ", addAll=" + addAll +
                ", deleteAll=" + deleteAll +
                '}';
    }
}