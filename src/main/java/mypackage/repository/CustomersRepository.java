package mypackage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mypackage.model.*;

public interface CustomersRepository extends JpaRepository<Customers, Integer> {

}
