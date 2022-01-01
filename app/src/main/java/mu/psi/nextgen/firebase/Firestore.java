package mu.psi.nextgen.firebase;

import com.google.firebase.firestore.FirebaseFirestore;

public class Firestore {

    private final FirebaseFirestore fStore;

    public Firestore() {
        this.fStore =FirebaseFirestore.getInstance();
    }
}
