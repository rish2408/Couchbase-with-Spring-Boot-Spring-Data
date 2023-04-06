package com.couchbasedb.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.CouchbaseClientFactory;
import org.springframework.data.couchbase.SimpleCouchbaseClientFactory;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.data.couchbase.core.convert.CouchbaseCustomConversions;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

import com.couchbasedb.entity.Customer;

import lombok.SneakyThrows;

@Configuration
public class CouchbaseConfig extends AbstractCouchbaseConfiguration{

	@Autowired
    private ApplicationContext context;

    @Value("${app.couchbase.connection-string}")
    private String connectionString;

    @Value("${app.couchbase.user-name}")
    private String userName;

    @Value("${app.couchbase.password}")
    private String password;

    @Value("${app.couchbase.bucket-primary}")
    private String userBucket;

    @Value("${app.couchbase.bucket-user}")
    private String customerBucket;

    @Override
    public String getConnectionString() {
        return connectionString;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getBucketName() {
        return userBucket;
    }
	
	@Override
	public void configureRepositoryOperationsMapping(RepositoryOperationsMapping mapping) {
		mapping.mapEntity(Customer.class, getCouchbaseTemplate(customerBucket));
//		mapping.mapEntity(Address.class, getCouchbaseTemplate("address"));  // for other buckets we just need to change bucket name only
	}
	
	@SneakyThrows
	private CouchbaseTemplate getCouchbaseTemplate(String bucketName) {
		
		CouchbaseTemplate template = new CouchbaseTemplate(couchbaseClientFactory(bucketName), mappingCouchbaseConverter(couchbaseMappingContext(customConversions()), new CouchbaseCustomConversions(Collections.emptyList())));
		
		template.setApplicationContext(context);
		return template;
	}
	
	private CouchbaseClientFactory couchbaseClientFactory(String bucketName) {
		return new SimpleCouchbaseClientFactory(couchbaseCluster(couchbaseClusterEnvironment()), bucketName, this.getScopeName());
	}

}
