package id.my.avmmartin.matched.factory;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import id.my.avmmartin.matched.data.network.firestore.model.PermissionApproval;
import id.my.avmmartin.matched.exception.ApprovalStatusSetException;

public class PermissionApprovalFactory {
    public static List<PermissionApproval> getPendingApproval() {
        List<PermissionApproval> result = new Vector<>();
        Calendar date = Calendar.getInstance();

        date.set(2020, 5, 15);
        result.add(new PermissionApproval((Calendar) date.clone(), "avm_martin", "ekeitaro"));

        date.set(2020,5, 10);
        result.add(new PermissionApproval((Calendar) date.clone(), "ekeitaro", "avm_martin"));

        return result;
    }

    public static List<PermissionApproval> getApprovedApproval() {
        List<PermissionApproval> result = new Vector<>();

        try {
            Calendar date = Calendar.getInstance();

            date.set(2020, 5, 6);
            PermissionApproval a = new PermissionApproval((Calendar) date.clone(), "avm_martin", "ekeitaro");
            a.approve();
            result.add(a);

            date.set(2020,5, 3);
            PermissionApproval b = new PermissionApproval((Calendar) date.clone(), "ekeitaro", "avm_martin");
            b.approve();
            result.add(b);

        } catch (ApprovalStatusSetException e) {
            //
        }

        return result;
    }

    private PermissionApprovalFactory() {
        // none
    }
}
