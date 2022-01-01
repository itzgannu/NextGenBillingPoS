package mu.psi.nextgen.firebase;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import mu.psi.nextgen.models.company.Admin;

public class Realtime {

    private final DatabaseReference dBase;
    private final String start_node = "stores";

    public Realtime() {
        this.dBase = FirebaseDatabase.getInstance().getReference();
    }

    public void writeAdminData(Admin admin) {
        String company_name = admin.getAdmin_company_name();
        dBase.child(start_node).child(company_name).setValue(admin);
    }

    public void readAdminData() {

    }

    public void writeWorkerData() {

    }

    public void readWorkerData() {

    }

    public void writeBranchData() {

    }

    public void readBranchData() {

    }

    public void updateBranchData() {

    }
}