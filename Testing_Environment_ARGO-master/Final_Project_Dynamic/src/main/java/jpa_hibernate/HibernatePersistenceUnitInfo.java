package jpa_hibernate;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import javax.persistence.SharedCacheMode;
import javax.persistence.ValidationMode;
import javax.persistence.spi.ClassTransformer;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.persistence.spi.PersistenceUnitTransactionType;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;

public class HibernatePersistenceUnitInfo implements PersistenceUnitInfo {

	public static final String JPA_VERSION = "2.2";
	private final String persistenceUnitName;
	private PersistenceUnitTransactionType transactionType = PersistenceUnitTransactionType.RESOURCE_LOCAL;
	private final List<String> managedClassNames;
	private final List<String> mappingFileNames = new ArrayList<String>();
	private final Properties properties;
	private DataSource jtaDataSource;
	private DataSource nonjtaDataSource;
	private final List<ClassTransformer> transformers = new ArrayList<ClassTransformer>();

	public HibernatePersistenceUnitInfo(String persistenceUnitName, List<String> managedClassNames,
			Properties properties) {
		this.persistenceUnitName = persistenceUnitName;
		this.managedClassNames = managedClassNames;
		this.properties = properties;
	}

	public String getPersistenceUnitName() {
		return persistenceUnitName;
	}

	public String getPersistenceProviderClassName() {
		return HibernatePersistenceProvider.class.getName();
	}

	public PersistenceUnitTransactionType getTransactionType() {
		return transactionType;
	}

	public HibernatePersistenceUnitInfo setJtaDataSource(DataSource jtaDataSource) {
		this.jtaDataSource = jtaDataSource;
		this.nonjtaDataSource = null;
		transactionType = PersistenceUnitTransactionType.JTA;
		return this;
	}

	public DataSource getJtaDataSource() {
		return jtaDataSource;
	}

	public HibernatePersistenceUnitInfo setNonJtaDataSource(DataSource nonJtaDataSource) {
		this.nonjtaDataSource = nonJtaDataSource;
		this.jtaDataSource = null;
		transactionType = PersistenceUnitTransactionType.RESOURCE_LOCAL;
		return this;
	}

	public DataSource getNonJtaDataSource() {
		return nonjtaDataSource;
	}

	public List<String> getMappingFileNames() {
		return mappingFileNames;
	}

	public List<URL> getJarFileUrls() {
		return Collections.emptyList();
	}

	public URL getPersistenceUnitRootUrl() {
		return null;
	}

	public List<String> getManagedClassNames() {
		return managedClassNames;
	}

	public boolean excludeUnlistedClasses() {
		return false;
	}

	public SharedCacheMode getSharedCacheMode() {
		return SharedCacheMode.UNSPECIFIED;
	}

	public ValidationMode getValidationMode() {
		return ValidationMode.AUTO;
	}

	public Properties getProperties() {
		return properties;
	}

	public String getPersistenceXMLSchemaVersion() {
		return JPA_VERSION;
	}

	public ClassLoader getClassLoader() {
		return Thread.currentThread().getContextClassLoader();
	}

	public void addTransformer(ClassTransformer transformer) {
		transformers.add(transformer);
	}

	public ClassLoader getNewTempClassLoader() {
		return null;
	}
}
