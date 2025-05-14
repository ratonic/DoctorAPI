package com.example.medapi.doctorsapi.infraestructure.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.InheritInverseConfiguration;

import com.example.medapi.doctorsapi.domain.dto.DoctorDTO;
import com.example.medapi.doctorsapi.infraestructure.entity.Doctor;

@Mapper(componentModel = "spring")
public interface DoctorMapper {

    @Mappings({
        @Mapping(source = "id", target = "id"),
        @Mapping(source = "nombre", target = "name"),
        @Mapping(source = "especialidad", target = "specialty"),
        @Mapping(source = "email", target = "email"),
        @Mapping(source = "telefono", target = "phone")
    })
    DoctorDTO toDoctorDTO(Doctor doctor);
    List<DoctorDTO> toDoctorsDTO(List<Doctor> doctors);

    @InheritInverseConfiguration
    Doctor toDoctor(DoctorDTO doctorDTO);
    List<Doctor> toDoctors(List<DoctorDTO> doctorDTOs);
}
