package com.example.demo.bootStrap;

import com.example.demo.domain.doctor;
import com.example.demo.domain.hospital;
import com.example.demo.domain.patient;
import com.example.demo.repositories.doctorRepo;
import com.example.demo.repositories.hospitalRepo;
import com.example.demo.repositories.patientRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootStrapData implements CommandLineRunner {

    private final doctorRepo doctorRepository;
    private final patientRepo patientRepository;
    private final hospitalRepo hospitalRepository;


    public bootStrapData(com.example.demo.repositories.doctorRepo doctorRepository, patientRepo patientRepository, hospitalRepo hospitalRepository) {
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
        this.hospitalRepository = hospitalRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        System.out.println("startup in bootStrap");

        doctor osama=new doctor("osama","male",35);
        doctor samera=new doctor("samera","female",30);
        patient ahmad=new patient("ahmad",20,"male",osama);
        patient aws=new patient("aws",20,"male",osama);
        hospital alamal=new hospital("alAmal");
        hospital kalamon=new hospital("kalamon");



        alamal.getDoctors().add(osama);
        osama.getHospitals().add(alamal);

        alamal.getDoctors().add(samera);
        samera.getHospitals().add(alamal);

        kalamon.getDoctors().add(samera);
        samera.getHospitals().add(kalamon);

        osama.getPatients().add(ahmad);
        ahmad.setDoctor(osama);

        samera.getPatients().add(aws);
        aws.setDoctor(samera);





        doctorRepository.save(samera);
        doctorRepository.save(osama);
        patientRepository.save(ahmad);
        patientRepository.save(aws);
        hospitalRepository.save(alamal);
        hospitalRepository.save(kalamon);
        System.out.println("finished bootStrap");

    }

}
