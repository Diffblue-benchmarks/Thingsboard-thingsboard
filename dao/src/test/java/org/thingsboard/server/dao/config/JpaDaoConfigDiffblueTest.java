package org.thingsboard.server.dao.config;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import jakarta.persistence.EntityManagerFactory;
import java.util.HashMap;
import javax.sql.DataSource;
import org.junit.Test;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.data.jpa.support.MergingPersistenceUnitManager;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.SQLExceptionSubclassTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.support.TransactionTemplate;

public class JpaDaoConfigDiffblueTest {
  /**
   * Test {@link JpaDaoConfig#dataSourceProperties()}.
   * <p>
   * Method under test: {@link JpaDaoConfig#dataSourceProperties()}
   */
  @Test
  public void testDataSourceProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    DataSourceProperties actualDataSourcePropertiesResult = (new JpaDaoConfig()).dataSourceProperties();

    // Assert
    assertNull(actualDataSourcePropertiesResult.getType());
    assertNull(actualDataSourcePropertiesResult.getClassLoader());
    assertNull(actualDataSourcePropertiesResult.getDriverClassName());
    assertNull(actualDataSourcePropertiesResult.getJndiName());
    assertNull(actualDataSourcePropertiesResult.getName());
    assertNull(actualDataSourcePropertiesResult.getPassword());
    assertNull(actualDataSourcePropertiesResult.getUrl());
    assertNull(actualDataSourcePropertiesResult.getUsername());
    DataSourceProperties.Xa xa = actualDataSourcePropertiesResult.getXa();
    assertNull(xa.getDataSourceClassName());
    assertNull(actualDataSourcePropertiesResult.getEmbeddedDatabaseConnection());
    assertTrue(xa.getProperties().isEmpty());
    assertTrue(actualDataSourcePropertiesResult.isGenerateUniqueName());
  }

  /**
   * Test
   * {@link JpaDaoConfig#entityManagerFactory(DataSource, EntityManagerFactoryBuilder, SqlTsLatestDaoConfig, SqlTsDaoConfig, TimescaleDaoConfig, TimescaleTsLatestDaoConfig)}.
   * <ul>
   *   <li>Then return PersistenceUnitName is {@code default}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDaoConfig#entityManagerFactory(DataSource, EntityManagerFactoryBuilder, SqlTsLatestDaoConfig, SqlTsDaoConfig, TimescaleDaoConfig, TimescaleTsLatestDaoConfig)}
   */
  @Test
  public void testEntityManagerFactory_thenReturnPersistenceUnitNameIsDefault() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDaoConfig jpaDaoConfig = new JpaDaoConfig();
    DataSource dataSource = mock(DataSource.class);
    JpaVendorAdapter jpaVendorAdapter = mock(JpaVendorAdapter.class);
    HashMap<String, Object> jpaProperties = new HashMap<>();
    EntityManagerFactoryBuilder builder = new EntityManagerFactoryBuilder(jpaVendorAdapter, jpaProperties,
        new MergingPersistenceUnitManager());

    SqlTsLatestDaoConfig tsLatestDaoConfig = new SqlTsLatestDaoConfig();
    SqlTsDaoConfig tsDaoConfig = new SqlTsDaoConfig();
    TimescaleDaoConfig timescaleDaoConfig = new TimescaleDaoConfig();

    // Act
    LocalContainerEntityManagerFactoryBean actualEntityManagerFactoryResult = jpaDaoConfig.entityManagerFactory(
        dataSource, builder, tsLatestDaoConfig, tsDaoConfig, timescaleDaoConfig, new TimescaleTsLatestDaoConfig());

    // Assert
    assertEquals("default", actualEntityManagerFactoryResult.getPersistenceUnitName());
    assertNull(actualEntityManagerFactoryResult.getObject());
    assertNull(actualEntityManagerFactoryResult.getPersistenceProvider());
    assertNull(actualEntityManagerFactoryResult.getPersistenceUnitInfo());
    assertNull(actualEntityManagerFactoryResult.getEntityManagerInterface());
    assertNull(actualEntityManagerFactoryResult.getBootstrapExecutor());
    assertNull(actualEntityManagerFactoryResult.getJpaDialect());
    assertTrue(actualEntityManagerFactoryResult.getJpaPropertyMap().isEmpty());
    assertTrue(actualEntityManagerFactoryResult.isSingleton());
    Class<EntityManagerFactory> expectedObjectType = EntityManagerFactory.class;
    assertEquals(expectedObjectType, actualEntityManagerFactoryResult.getObjectType());
    assertSame(dataSource, actualEntityManagerFactoryResult.getDataSource());
  }

  /**
   * Test
   * {@link JpaDaoConfig#entityManagerFactory(DataSource, EntityManagerFactoryBuilder, SqlTsLatestDaoConfig, SqlTsDaoConfig, TimescaleDaoConfig, TimescaleTsLatestDaoConfig)}.
   * <ul>
   *   <li>Then return PersistenceUnitName is {@code default}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDaoConfig#entityManagerFactory(DataSource, EntityManagerFactoryBuilder, SqlTsLatestDaoConfig, SqlTsDaoConfig, TimescaleDaoConfig, TimescaleTsLatestDaoConfig)}
   */
  @Test
  public void testEntityManagerFactory_thenReturnPersistenceUnitNameIsDefault2() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDaoConfig jpaDaoConfig = new JpaDaoConfig();
    DataSource dataSource = mock(DataSource.class);
    JpaVendorAdapter jpaVendorAdapter = mock(JpaVendorAdapter.class);
    HashMap<String, Object> jpaProperties = new HashMap<>();

    // Act
    LocalContainerEntityManagerFactoryBean actualEntityManagerFactoryResult = jpaDaoConfig.entityManagerFactory(
        dataSource,
        new EntityManagerFactoryBuilder(jpaVendorAdapter, jpaProperties, new MergingPersistenceUnitManager()), null,
        null, null, null);

    // Assert
    assertEquals("default", actualEntityManagerFactoryResult.getPersistenceUnitName());
    assertNull(actualEntityManagerFactoryResult.getObject());
    assertNull(actualEntityManagerFactoryResult.getPersistenceProvider());
    assertNull(actualEntityManagerFactoryResult.getPersistenceUnitInfo());
    assertNull(actualEntityManagerFactoryResult.getEntityManagerInterface());
    assertNull(actualEntityManagerFactoryResult.getBootstrapExecutor());
    assertNull(actualEntityManagerFactoryResult.getJpaDialect());
    assertTrue(actualEntityManagerFactoryResult.getJpaPropertyMap().isEmpty());
    assertTrue(actualEntityManagerFactoryResult.isSingleton());
    Class<EntityManagerFactory> expectedObjectType = EntityManagerFactory.class;
    assertEquals(expectedObjectType, actualEntityManagerFactoryResult.getObjectType());
    assertSame(dataSource, actualEntityManagerFactoryResult.getDataSource());
  }

  /**
   * Test {@link JpaDaoConfig#transactionTemplate(JpaTransactionManager)}.
   * <ul>
   *   <li>Then return TransactionManager is
   * {@link JpaTransactionManager#JpaTransactionManager()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDaoConfig#transactionTemplate(JpaTransactionManager)}
   */
  @Test
  public void testTransactionTemplate_thenReturnTransactionManagerIsJpaTransactionManager() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaDaoConfig jpaDaoConfig = new JpaDaoConfig();
    JpaTransactionManager transactionManager = new JpaTransactionManager();

    // Act and Assert
    assertSame(transactionManager, jpaDaoConfig.transactionTemplate(transactionManager).getTransactionManager());
  }

  /**
   * Test {@link JpaDaoConfig#transactionTemplate(JpaTransactionManager)}.
   * <ul>
   *   <li>When {@link JpaTransactionManager}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDaoConfig#transactionTemplate(JpaTransactionManager)}
   */
  @Test
  public void testTransactionTemplate_whenJpaTransactionManager_thenReturnNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTransactionManager transactionManager = mock(JpaTransactionManager.class);

    // Act
    TransactionTemplate actualTransactionTemplateResult = (new JpaDaoConfig()).transactionTemplate(transactionManager);

    // Assert
    assertNull(actualTransactionTemplateResult.getName());
    assertEquals(-1, actualTransactionTemplateResult.getIsolationLevel());
    assertEquals(-1, actualTransactionTemplateResult.getTimeout());
    assertEquals(0, actualTransactionTemplateResult.getPropagationBehavior());
    assertFalse(actualTransactionTemplateResult.isReadOnly());
    assertSame(transactionManager, actualTransactionTemplateResult.getTransactionManager());
  }

  /**
   * Test {@link JpaDaoConfig#jdbcTemplate(DataSource)}.
   * <ul>
   *   <li>Then ExceptionTranslator return
   * {@link SQLExceptionSubclassTranslator}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaDaoConfig#jdbcTemplate(DataSource)}
   */
  @Test
  public void testJdbcTemplate_thenExceptionTranslatorReturnSQLExceptionSubclassTranslator() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DataSource dataSource = mock(DataSource.class);

    // Act
    JdbcTemplate actualJdbcTemplateResult = (new JpaDaoConfig()).jdbcTemplate(dataSource);

    // Assert
    SQLExceptionTranslator exceptionTranslator = actualJdbcTemplateResult.getExceptionTranslator();
    assertTrue(exceptionTranslator instanceof SQLExceptionSubclassTranslator);
    SQLExceptionTranslator fallbackTranslator = ((SQLExceptionSubclassTranslator) exceptionTranslator)
        .getFallbackTranslator();
    assertTrue(fallbackTranslator instanceof SQLStateSQLExceptionTranslator);
    assertNull(((SQLExceptionSubclassTranslator) exceptionTranslator).getCustomTranslator());
    assertNull(((SQLStateSQLExceptionTranslator) fallbackTranslator).getCustomTranslator());
    assertNull(((SQLStateSQLExceptionTranslator) fallbackTranslator).getFallbackTranslator());
    assertEquals(-1, actualJdbcTemplateResult.getFetchSize());
    assertEquals(-1, actualJdbcTemplateResult.getMaxRows());
    assertEquals(-1, actualJdbcTemplateResult.getQueryTimeout());
    assertFalse(actualJdbcTemplateResult.isResultsMapCaseInsensitive());
    assertFalse(actualJdbcTemplateResult.isSkipResultsProcessing());
    assertFalse(actualJdbcTemplateResult.isSkipUndeclaredResults());
    assertTrue(actualJdbcTemplateResult.isIgnoreWarnings());
    assertTrue(actualJdbcTemplateResult.isLazyInit());
    assertSame(dataSource, actualJdbcTemplateResult.getDataSource());
  }

  /**
   * Test {@link JpaDaoConfig#namedParameterJdbcTemplate(DataSource)}.
   * <ul>
   *   <li>Then JdbcOperations return {@link JdbcTemplate}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JpaDaoConfig#namedParameterJdbcTemplate(DataSource)}
   */
  @Test
  public void testNamedParameterJdbcTemplate_thenJdbcOperationsReturnJdbcTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DataSource dataSource = mock(DataSource.class);

    // Act
    NamedParameterJdbcTemplate actualNamedParameterJdbcTemplateResult = (new JpaDaoConfig())
        .namedParameterJdbcTemplate(dataSource);

    // Assert
    JdbcOperations jdbcOperations = actualNamedParameterJdbcTemplateResult.getJdbcOperations();
    assertTrue(jdbcOperations instanceof JdbcTemplate);
    SQLExceptionTranslator exceptionTranslator = ((JdbcTemplate) jdbcOperations).getExceptionTranslator();
    assertTrue(exceptionTranslator instanceof SQLExceptionSubclassTranslator);
    SQLExceptionTranslator fallbackTranslator = ((SQLExceptionSubclassTranslator) exceptionTranslator)
        .getFallbackTranslator();
    assertTrue(fallbackTranslator instanceof SQLStateSQLExceptionTranslator);
    assertNull(((SQLExceptionSubclassTranslator) exceptionTranslator).getCustomTranslator());
    assertNull(((SQLStateSQLExceptionTranslator) fallbackTranslator).getCustomTranslator());
    assertNull(((SQLStateSQLExceptionTranslator) fallbackTranslator).getFallbackTranslator());
    assertEquals(-1, ((JdbcTemplate) jdbcOperations).getFetchSize());
    assertEquals(-1, ((JdbcTemplate) jdbcOperations).getMaxRows());
    assertEquals(-1, ((JdbcTemplate) jdbcOperations).getQueryTimeout());
    assertEquals(256, actualNamedParameterJdbcTemplateResult.getCacheLimit());
    assertFalse(((JdbcTemplate) jdbcOperations).isResultsMapCaseInsensitive());
    assertFalse(((JdbcTemplate) jdbcOperations).isSkipResultsProcessing());
    assertFalse(((JdbcTemplate) jdbcOperations).isSkipUndeclaredResults());
    assertTrue(((JdbcTemplate) jdbcOperations).isIgnoreWarnings());
    assertTrue(((JdbcTemplate) jdbcOperations).isLazyInit());
    assertSame(dataSource, ((JdbcTemplate) jdbcOperations).getDataSource());
    assertSame(jdbcOperations, actualNamedParameterJdbcTemplateResult.getJdbcTemplate());
  }
}
