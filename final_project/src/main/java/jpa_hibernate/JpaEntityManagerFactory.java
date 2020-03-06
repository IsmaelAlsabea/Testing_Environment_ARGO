package jpa_hibernate;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.spi.PersistenceUnitInfo;
import javax.sql.DataSource;

import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;


public class JpaEntityManagerFactory {
    
    protected 	final 	String 	url;
    protected 	final 	String 	username;
    protected 	final 	String 	password;
    @SuppressWarnings("rawtypes")
	protected 	final 	Class[]	entityClasses;
    
    public JpaEntityManagerFactory(@SuppressWarnings("rawtypes") Class[] entityClasses, String URL, String username, String password) {
        this.entityClasses = entityClasses;
        this.url=URL;
        this.username=username;
        this.password=password;
        
    }
            
    public EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
    
    protected EntityManagerFactory getEntityManagerFactory() {
        PersistenceUnitInfo persistenceUnitInfo = getPersistenceUnitInfo(getClass().getSimpleName());
        Map<String, Object> configuration = new HashMap<String, Object>();
        return new EntityManagerFactoryBuilderImpl(new PersistenceUnitInfoDescriptor(persistenceUnitInfo), configuration)
          .build();
    }
    
    protected HibernatePersistenceUnitInfo getPersistenceUnitInfo(String name) {
        return new HibernatePersistenceUnitInfo(name, getEntityClassNames(), getProperties());
    }
    
    protected List<String> getEntityClassNames() {
        return Arrays.asList(getEntities())
          .stream()
          .map(Class::getName)
          .collect(Collectors.toList());
    }
    
    protected Properties getProperties() {
        Properties properties = new Properties();
        properties.put("hibernate.dialect", "org.hibernate.dialect.SQLServerDialect");
        properties.put("hibernate.id.new_generator_mappings", false);
        properties.put("hibernate.connection.datasource", getSQLServerDataSource());
        return properties;
    }
    
    protected Class[] getEntities() {
        return entityClasses;
    }
    
    protected DataSource getSQLServerDataSource() {
    SQLServerDataSource dataSource = new SQLServerDataSource();
    dataSource.setURL(url);
    dataSource.setUser(username);
    dataSource.setPassword(password);
	return dataSource;
    }
}
