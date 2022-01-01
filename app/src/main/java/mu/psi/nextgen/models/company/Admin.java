package mu.psi.nextgen.models.company;

import androidx.annotation.NonNull;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Admin implements Serializable {
    String admin_email, admin_full_name, admin_company_name;

    public Admin() {
    }

    public Admin(String admin_email, String admin_full_name, String admin_company_name) {
        this.admin_email = admin_email;
        this.admin_full_name = admin_full_name;
        this.admin_company_name = admin_company_name;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

    public String getAdmin_full_name() {
        return admin_full_name;
    }

    public void setAdmin_full_name(String admin_full_name) {
        this.admin_full_name = admin_full_name;
    }

    public String getAdmin_company_name() {
        return admin_company_name;
    }

    public void setAdmin_company_name(String admin_company_name) {
        this.admin_company_name = admin_company_name;
    }

    @NonNull
    @Override
    public String toString() {
        return "Admin{" +
                "admin_email='" + admin_email + '\'' +
                ", admin_full_name='" + admin_full_name + '\'' +
                ", admin_company_name='" + admin_company_name + '\'' +
                '}';
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();

        result.put("admin_email", admin_email);
        result.put("admin_full_name", admin_full_name);
        result.put("admin_company_name", admin_company_name);

        return result;
    }
}