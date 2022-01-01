package mu.psi.nextgen.models.company;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Worker implements Serializable {
    String worker_email, worker_full_name, worker_company_name, worker_branch_name;

    public Worker() {
    }

    public Worker(String worker_email, String worker_full_name, String worker_company_name, String worker_branch_name) {
        this.worker_email = worker_email;
        this.worker_full_name = worker_full_name;
        this.worker_company_name = worker_company_name;
        this.worker_branch_name = worker_branch_name;
    }

    public String getWorker_email() {
        return worker_email;
    }

    public void setWorker_email(String worker_email) {
        this.worker_email = worker_email;
    }

    public String getWorker_full_name() {
        return worker_full_name;
    }

    public void setWorker_full_name(String worker_full_name) {
        this.worker_full_name = worker_full_name;
    }

    public String getWorker_company_name() {
        return worker_company_name;
    }

    public void setWorker_company_name(String worker_company_name) {
        this.worker_company_name = worker_company_name;
    }

    public String getWorker_branch_name() {
        return worker_branch_name;
    }

    public void setWorker_branch_name(String worker_branch_name) {
        this.worker_branch_name = worker_branch_name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Worker{" +
                "worker_email='" + worker_email + '\'' +
                ", worker_full_name='" + worker_full_name + '\'' +
                ", worker_company_name='" + worker_company_name + '\'' +
                ", worker_branch_name='" + worker_branch_name + '\'' +
                '}';
    }
}