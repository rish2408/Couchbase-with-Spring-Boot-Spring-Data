package com.couchbasedb.dao;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.couchbasedb.entity.User;

@Repository
public interface UserRepository extends CouchbaseRepository<User, Integer>{

}
