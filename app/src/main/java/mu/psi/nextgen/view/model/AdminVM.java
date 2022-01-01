package mu.psi.nextgen.view.model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import mu.psi.nextgen.firebase.CompanyFirestore;
import mu.psi.nextgen.models.company.Admin;

public class AdminVM extends AndroidViewModel {

    CompanyFirestore companyFirestore = new CompanyFirestore();

    private static AdminVM instance;

    public static AdminVM getInstance(Application application) {
        if(instance == null) {
            instance =new AdminVM(application);
        }
        return instance;
    }

    public AdminVM(@NonNull Application application) {
        super(application);
    }

    public void writeAdminToCFS(String uuid, Admin admin) {
        companyFirestore.createAdmin(uuid, admin);
    }
}