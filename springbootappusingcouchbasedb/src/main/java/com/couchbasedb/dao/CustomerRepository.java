package com.couchbasedb.dao;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.couchbasedb.entity.Customer;

@Repository
public interface CustomerRepository extends CouchbaseRepository<Customer, Integer>{

}
