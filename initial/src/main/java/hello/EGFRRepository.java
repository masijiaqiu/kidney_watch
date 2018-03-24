package hello;

import org.springframework.data.repository.CrudRepository;

import hello.EGFR;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EGFRRepository extends CrudRepository<EGFR, Long> {

}