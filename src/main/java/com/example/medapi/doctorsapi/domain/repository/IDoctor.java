package com.example.medapi.doctorsapi.domain.repository;

import java.util.List;
import java.util.Optional;

import com.example.medapi.doctorsapi.domain.dto.DoctorDTO;

public interface IDoctor {
    List<DoctorDTO> getAll();
    Optional<DoctorDTO> getDoctor(Long id);
    DoctorDTO save(DoctorDTO doctor);
    void delete(Long id);
    List<DoctorDTO> getDoctorsBySpecialty(String specialty);
}
