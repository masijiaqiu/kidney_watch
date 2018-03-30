package KW;

import org.springframework.data.repository.CrudRepository;

import KW.Patient;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PatientRepository extends CrudRepository<Patient, Long> {

}