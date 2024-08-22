package com.example.demo.domain;



import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    private String Name;
    private String Gender;
    private int Age;

    @OneToMany()
    @JoinColumn(name = "doctor_id")
    private Set<patient> patients=new HashSet<>();

    @ManyToMany(mappedBy = "doctors")
    private Set<hospital> hospitals=new HashSet<>();



    public doctor() {
    }

    public doctor(String name, String gender, int age) {
        Name = name;
        Gender = gender;
        Age = age;
    }

    public Set<hospital> getHospitals() {
        return hospitals;
    }

    public void setHospitals(Set<hospital> hospitals) {
        this.hospitals = hospitals;
    }


    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public Integer getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Set<patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<patient> patients) {
        this.patients = patients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        doctor doctor = (doctor) o;
        return Id == doctor.Id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(Id);
    }

    @Override
    public String toString() {
        return "doctor{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Gender='" + Gender + '\'' +
                ", Age='" + Age + '\'' +
                '}';
    }


}
