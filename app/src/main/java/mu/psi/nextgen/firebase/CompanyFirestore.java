package mu.psi.nextgen.firebase;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;
import java.util.Objects;

import mu.psi.nextgen.models.company.Admin;

public class CompanyFirestore {

    private final FirebaseFirestore fStore;
    private final String FIRST_COLLECTION_NAME = "production";
    private final String FIRST_DOCUMENT_NAME = "company";

    public CompanyFirestore() {
        this.fStore =FirebaseFirestore.getInstance();
    }

    public void createAdmin(String uuid, Admin admin) {
        Map<String, Object> adminMap = admin.toMap();
        String company_name = admin.getAdmin_company_name().toLowerCase();

        fStore.collection(FIRST_COLLECTION_NAME)
                .document(FIRST_DOCUMENT_NAME)
                .collection(company_name)
                .document(uuid)
                .set(adminMap);
    }
}
