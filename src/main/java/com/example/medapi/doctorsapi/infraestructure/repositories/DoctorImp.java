package com.example.medapi.doctorsapi.infraestructure.repositories;
import org.springframework.stereotype.Repository;

import com.example.medapi.doctorsapi.domain.dto.DoctorDTO;
import com.example.medapi.doctorsapi.domain.repository.IDoctor;
import com.example.medapi.doctorsapi.infraestructure.crud.DoctorRepository;
import com.example.medapi.doctorsapi.infraestructure.entity.Doctor;
import com.example.medapi.doctorsapi.infraestructure.mapper.DoctorMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
public class DoctorImp implements IDoctor {

    private final DoctorRepository crud;
    private final DoctorMapper mapper;

    public DoctorImp(DoctorRepository crud, DoctorMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public List<DoctorDTO> getAll() {
        return StreamSupport.stream(crud.findAll().spliterator(), false)
                .map(mapper::toDoctorDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<DoctorDTO> getDoctor(Long id) {
        return crud.findById(id).map(mapper::toDoctorDTO);
    }

    @Override
    public DoctorDTO save(DoctorDTO doctorDTO) {
        Doctor doctor = mapper.toDoctor(doctorDTO);
        return mapper.toDoctorDTO(crud.save(doctor));
    }

    @Override
    public void delete(Long id) {
        crud.deleteById(id);
    }

    @Override
    public List<DoctorDTO> getDoctorsBySpecialty(String specialty) {
        return StreamSupport.stream(crud.findAll().spliterator(), false)
                .map(doctor -> mapper.toDoctorDTO(doctor))
                .filter(doctorDTO -> doctorDTO.getSpecialty().equalsIgnoreCase(specialty))
                .collect(Collectors.toList());
    }
}
