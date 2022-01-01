package mu.psi.nextgen.models.company;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

public class Branches implements Serializable {
    List<Branch> branches;

    public Branches() {
    }

    public Branches(List<Branch> branches) {
        this.branches = branches;
    }

    public List<Branch> getBranches() {
        return branches;
    }

    public void setBranches(List<Branch> branches) {
        this.branches = branches;
    }

    @NonNull
    @Override
    public String toString() {
        return "Branches{" +
                "branches=" + branches +
                '}';
    }
}
