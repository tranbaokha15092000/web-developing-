package security.demo.SecurityDemo;

import javax.persistence.*;

@Entity
public class Manager {
    @Id
    private int id;
    @OneToOne
    @JoinColumn(name = "id")
    private Employee employee;

    public Manager(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
