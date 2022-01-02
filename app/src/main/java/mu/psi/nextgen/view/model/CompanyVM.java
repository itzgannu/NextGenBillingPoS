package mu.psi.nextgen.view.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import mu.psi.nextgen.firebase.CompanyFirestore;
import mu.psi.nextgen.models.company.Admin;
import mu.psi.nextgen.models.company.Branch;

public class CompanyVM extends AndroidViewModel {

    CompanyFirestore companyFirestore = new CompanyFirestore();

    private static CompanyVM instance;

    public static CompanyVM getInstance(Application application) {
        if(instance == null) {
            instance =new CompanyVM(application);
        }
        return instance;
    }

    public CompanyVM(@NonNull Application application) {
        super(application);
    }

    public void writeAdminToCFS(String uuid, Admin admin) {
        String company_name = admin.getCompany_name();
        companyFirestore.createAdmin(uuid, admin);
        companyFirestore.createBranchRegistration(company_name);
    }

    public void writeFirstBranchToCFS(Branch branch) {
        String company_name = branch.getCompany_name();
        companyFirestore.deleteBranchRegistration(company_name);
        companyFirestore.createBranch(branch);
    }

    public void writeBranchToCFS(Branch branch) {
        companyFirestore.createBranch(branch);
    }
}