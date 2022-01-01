package mu.psi.nextgen.models.company;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.List;

public class Workers implements Serializable {
    List<Worker> workers;

    public Workers() {
    }

    public Workers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Worker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    @NonNull
    @Override
    public String toString() {
        return "Workers{" +
                "workers=" + workers +
                '}';
    }
}