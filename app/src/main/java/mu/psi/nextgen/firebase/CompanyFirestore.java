package mu.psi.nextgen.firebase;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

import mu.psi.nextgen.models.company.Admin;
import mu.psi.nextgen.models.company.Branch;
import mu.psi.nextgen.models.company.Cashier;
import mu.psi.nextgen.models.company.Staff;

public class CompanyFirestore {

    private final FirebaseFirestore fStore;

    public CompanyFirestore() {
        this.fStore =FirebaseFirestore.getInstance();
    }

    public void createBranchRegistration(String company_name) {
        Branch branch = new Branch(company_name, "NR", "NR");
        Map<String, Object> branchMap = branch.toMap();
        String branch_name = branch.getBranch_name();

        fStore.collection(company_name)
                .document(branch_name)
                .set(branchMap);
    }

    public void deleteBranchRegistration(String company_name) {
        String branch_name = "NR";

        fStore.collection(company_name)
                .document(branch_name)
                .delete();
    }

    public void createAdmin(String uuid, Admin admin) {
        Map<String, Object> adminMap = admin.toMap();
        String company_name = admin.getCompany_name();

        fStore.collection(company_name)
                .document(uuid)
                .set(adminMap);
    }

    public void createCashier(String uuid, Cashier cashier) {
        Map<String, Object> cashierMap = cashier.toMap();
        String company_name = cashier.getCompany_name();

        fStore.collection(company_name)
                .document(uuid)
                .set(cashierMap);
    }

    public void createWorker(String uuid, Staff staff) {
        Map<String, Object> workerMap = staff.toMap();
        String company_name = staff.getCompany_name();

        fStore.collection(company_name)
                .document(uuid)
                .set(workerMap);
    }

    public void createBranch(Branch branch) {
        Map<String, Object> branchMap = branch.toMap();
        String company_name = branch.getCompany_name();
        String branch_name = branch.getBranch_name();

        fStore.collection(company_name)
                .document(branch_name)
                .set(branchMap);
    }
}
