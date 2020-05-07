package id.my.avmmartin.matched.factory;

import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import id.my.avmmartin.matched.data.network.firestore.model.PermissionApproval;
import id.my.avmmartin.matched.exception.ApprovalStatusSetException;

public class PermissionApprovalFactory {
    private List<PermissionApproval> allApproval = new Vector<>();
    private List<PermissionApproval> pendingApproval = new Vector<>();
    private List<PermissionApproval> approvedApproval = new Vector<>();

    public static List<PermissionApproval> getAllApproval() {
        return instance.allApproval;
    }

    public static List<PermissionApproval> getPendingApproval() {
        return instance.pendingApproval;
    }

    public static List<PermissionApproval> getApprovedApproval() {
        return instance.approvedApproval;
    }

    // creator

    private void createPendingApproval() {
        pendingApproval = new Vector<>();
        Calendar date = Calendar.getInstance();

        date.set(2020, 5, 15);
        pendingApproval.add(new PermissionApproval((Calendar) date.clone(), "avm_martin", "ekeitaro"));
        allApproval.add(new PermissionApproval((Calendar) date.clone(), "avm_martin", "ekeitaro"));

        date.set(2020,5, 10);
        pendingApproval.add(new PermissionApproval((Calendar) date.clone(), "ekeitaro", "avm_martin"));
        allApproval.add(new PermissionApproval((Calendar) date.clone(), "ekeitaro", "avm_martin"));
    }

    private void createApprovedApproval() {
        approvedApproval = new Vector<>();

        try {
            Calendar date = Calendar.getInstance();

            date.set(2020, 5, 6);
            PermissionApproval a = new PermissionApproval((Calendar) date.clone(), "avm_martin", "ekeitaro");
            a.approve();
            approvedApproval.add(a);
            allApproval.add(a);

            date.set(2020,5, 3);
            PermissionApproval b = new PermissionApproval((Calendar) date.clone(), "ekeitaro", "avm_martin");
            b.approve();
            approvedApproval.add(b);
            allApproval.add(b);

        } catch (ApprovalStatusSetException e) {
            //
        }
    }

    // singleton

    private static PermissionApprovalFactory instance = new PermissionApprovalFactory();

    private PermissionApprovalFactory() {
        createPendingApproval();
        createApprovedApproval();
    }
}
