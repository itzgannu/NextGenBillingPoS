package mu.psi.nextgen.models.company;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Branch implements Serializable {
    String company_name, branch_name, branch_location;

    public Branch() {
    }

    public Branch(String company_name, String branch_name, String branch_location) {
        this.company_name = company_name;
        this.branch_name = branch_name;
        this.branch_location = branch_location;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public String getBranch_location() {
        return branch_location;
    }

    public void setBranch_location(String branch_location) {
        this.branch_location = branch_location;
    }

    @NonNull
    @Override
    public String toString() {
        return "Branch{" +
                "company_name='" + company_name + '\'' +
                ", branch_name='" + branch_name + '\'' +
                ", branch_location='" + branch_location + '\'' +
                '}';
    }
}