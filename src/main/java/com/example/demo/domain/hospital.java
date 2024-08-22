package com.example.demo.domain;



import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;
    private String hospitalName;

    @ManyToMany
    @JoinTable(name="hospitals_doctors",joinColumns = @JoinColumn(name="hospital_id")
            ,inverseJoinColumns=@JoinColumn(name = "doctor_Id"))
    private Set<doctor> doctors=new HashSet<>();

    public hospital() {
    }

    public hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public Set<doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        hospital hospital = (hospital) o;
        return Id == hospital.Id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(Id);
    }

    @Override
    public String toString() {
        return "hospital{" +
                "Id=" + Id +
                ", hospitalName='" + hospitalName + '\'' +
                '}';
    }
}
