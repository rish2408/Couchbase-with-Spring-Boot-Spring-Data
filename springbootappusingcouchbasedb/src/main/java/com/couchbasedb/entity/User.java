package com.couchbasedb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class User {

	@Id
	private Integer id;
	
	private String name;
	
	private String mobile;
}
