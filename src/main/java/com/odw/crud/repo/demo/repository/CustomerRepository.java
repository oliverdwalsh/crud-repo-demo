package com.odw.crud.repo.demo.repository;

import com.odw.crud.repo.demo.model.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    List<Customer> findByCustomerId(int customerId);

}
