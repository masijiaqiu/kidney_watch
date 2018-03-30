package KW;

import org.springframework.data.repository.CrudRepository;

import KW.LabTest;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface LabTestRepository extends CrudRepository<LabTest, Long> {

}