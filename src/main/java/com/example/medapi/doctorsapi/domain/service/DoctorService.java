package com.example.medapi.doctorsapi.domain.service;

import org.springframework.stereotype.Service;

import com.example.medapi.doctorsapi.domain.dto.AvailabilityDTO;
import com.example.medapi.doctorsapi.domain.dto.DoctorDTO;
import com.example.medapi.doctorsapi.domain.repository.IDoctor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    private final IDoctor doctorRepo;

    public DoctorService(IDoctor doctorRepo) {
        this.doctorRepo = doctorRepo;
    }

    public List<DoctorDTO> getAll() {
        return doctorRepo.getAll();
    }

    public Optional<DoctorDTO> getDoctor(Long id) {
        return doctorRepo.getDoctor(id);
    }

    public DoctorDTO save(DoctorDTO doctor) {
        return doctorRepo.save(doctor);
    }

    public void delete(Long id) {
        doctorRepo.delete(id);
    }

    public List<DoctorDTO> getDoctorsBySpecialty(String specialty) {
        return doctorRepo.getDoctorsBySpecialty(specialty);
    }

    public List<AvailabilityDTO> getAvailableDoctors(String date) {
        LocalDate requestedDate = LocalDate.parse(date);
        List<AvailabilityDTO> availabilities = new ArrayList<>();
        
        // Get all doctors
        List<DoctorDTO> doctors = getAll();
        
        // Generate availability slots for each doctor
        for (DoctorDTO doctor : doctors) {
            // Generate slots from 7 AM to 7 PM
            for (int hour = 7; hour <= 19; hour++) {
                AvailabilityDTO slot = new AvailabilityDTO();
                slot.setDoctorId(doctor.getId());
                slot.setDoctorName(doctor.getName());
                slot.setSpecialty(doctor.getSpecialty());
                slot.setAvailableTime(requestedDate.atTime(hour, 0));
                availabilities.add(slot);
            }
        }
        
        return availabilities;
    }

    public List<AvailabilityDTO> getAvailableDoctorsBySpecialty(String date, String specialty) {
        LocalDate requestedDate = LocalDate.parse(date);
        List<AvailabilityDTO> availabilities = new ArrayList<>();
        
        // Get doctors filtered by specialty
        List<DoctorDTO> doctors = getDoctorsBySpecialty(specialty);
        
        // Generate availability slots for filtered doctors
        for (DoctorDTO doctor : doctors) {
            for (int hour = 7; hour <= 19; hour++) {
                AvailabilityDTO slot = new AvailabilityDTO();
                slot.setDoctorId(doctor.getId());
                slot.setDoctorName(doctor.getName());
                slot.setSpecialty(doctor.getSpecialty());
                slot.setAvailableTime(requestedDate.atTime(hour, 0));
                availabilities.add(slot);
            }
        }
        
        return availabilities;
    }

    public List<AvailabilityDTO> getAvailableDoctorById(String date, Long doctorId) {
        LocalDate requestedDate = LocalDate.parse(date);
        List<AvailabilityDTO> availabilities = new ArrayList<>();
        
        // Get specific doctor by ID
        Optional<DoctorDTO> doctorOpt = getDoctor(doctorId);
        
        if (doctorOpt.isPresent()) {
            DoctorDTO doctor = doctorOpt.get();
            // Generate availability slots for the specific doctor
            for (int hour = 7; hour <= 19; hour++) {
                AvailabilityDTO slot = new AvailabilityDTO();
                slot.setDoctorId(doctor.getId());
                slot.setDoctorName(doctor.getName());
                slot.setSpecialty(doctor.getSpecialty());
                slot.setAvailableTime(requestedDate.atTime(hour, 0));
                availabilities.add(slot);
            }
        }
        
        return availabilities;
    }
}
