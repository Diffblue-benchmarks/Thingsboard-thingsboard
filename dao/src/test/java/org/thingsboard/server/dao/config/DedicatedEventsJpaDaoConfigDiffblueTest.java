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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.SQLExceptionSubclassTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.jdbc.support.SQLStateSQLExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.support.TransactionTemplate;

public class DedicatedEventsJpaDaoConfigDiffblueTest {
  /**
   * Test {@link DedicatedEventsJpaDaoConfig#eventsDataSourceProperties()}.
   * <p>
   * Method under test:
   * {@link DedicatedEventsJpaDaoConfig#eventsDataSourceProperties()}
   */
  @Test
  public void testEventsDataSourceProperties() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange and Act
    DataSourceProperties actualEventsDataSourcePropertiesResult = (new DedicatedEventsJpaDaoConfig())
        .eventsDataSourceProperties();

    // Assert
    assertNull(actualEventsDataSourcePropertiesResult.getType());
    assertNull(actualEventsDataSourcePropertiesResult.getClassLoader());
    assertNull(actualEventsDataSourcePropertiesResult.getDriverClassName());
    assertNull(actualEventsDataSourcePropertiesResult.getJndiName());
    assertNull(actualEventsDataSourcePropertiesResult.getName());
    assertNull(actualEventsDataSourcePropertiesResult.getPassword());
    assertNull(actualEventsDataSourcePropertiesResult.getUrl());
    assertNull(actualEventsDataSourcePropertiesResult.getUsername());
    DataSourceProperties.Xa xa = actualEventsDataSourcePropertiesResult.getXa();
    assertNull(xa.getDataSourceClassName());
    assertNull(actualEventsDataSourcePropertiesResult.getEmbeddedDatabaseConnection());
    assertTrue(xa.getProperties().isEmpty());
    assertTrue(actualEventsDataSourcePropertiesResult.isGenerateUniqueName());
  }

  /**
   * Test
   * {@link DedicatedEventsJpaDaoConfig#eventsEntityManagerFactory(DataSource, EntityManagerFactoryBuilder)}.
   * <ul>
   *   <li>Then return Object is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DedicatedEventsJpaDaoConfig#eventsEntityManagerFactory(DataSource, EntityManagerFactoryBuilder)}
   */
  @Test
  public void testEventsEntityManagerFactory_thenReturnObjectIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DedicatedEventsJpaDaoConfig dedicatedEventsJpaDaoConfig = new DedicatedEventsJpaDaoConfig();
    DataSource eventsDataSource = mock(DataSource.class);
    JpaVendorAdapter jpaVendorAdapter = mock(JpaVendorAdapter.class);
    HashMap<String, Object> jpaProperties = new HashMap<>();

    // Act
    LocalContainerEntityManagerFactoryBean actualEventsEntityManagerFactoryResult = dedicatedEventsJpaDaoConfig
        .eventsEntityManagerFactory(eventsDataSource,
            new EntityManagerFactoryBuilder(jpaVendorAdapter, jpaProperties, new MergingPersistenceUnitManager()));

    // Assert
    assertNull(actualEventsEntityManagerFactoryResult.getObject());
    assertNull(actualEventsEntityManagerFactoryResult.getPersistenceProvider());
    assertNull(actualEventsEntityManagerFactoryResult.getPersistenceUnitInfo());
    assertNull(actualEventsEntityManagerFactoryResult.getEntityManagerInterface());
    assertNull(actualEventsEntityManagerFactoryResult.getBootstrapExecutor());
    assertNull(actualEventsEntityManagerFactoryResult.getJpaDialect());
    assertTrue(actualEventsEntityManagerFactoryResult.getJpaPropertyMap().isEmpty());
    assertTrue(actualEventsEntityManagerFactoryResult.isSingleton());
    Class<EntityManagerFactory> expectedObjectType = EntityManagerFactory.class;
    assertEquals(expectedObjectType, actualEventsEntityManagerFactoryResult.getObjectType());
    assertEquals(DedicatedEventsJpaDaoConfig.EVENTS_PERSISTENCE_UNIT,
        actualEventsEntityManagerFactoryResult.getPersistenceUnitName());
    assertSame(eventsDataSource, actualEventsEntityManagerFactoryResult.getDataSource());
  }

  /**
   * Test
   * {@link DedicatedEventsJpaDaoConfig#eventsTransactionTemplate(JpaTransactionManager)}.
   * <p>
   * Method under test:
   * {@link DedicatedEventsJpaDaoConfig#eventsTransactionTemplate(JpaTransactionManager)}
   */
  @Test
  public void testEventsTransactionTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DedicatedEventsJpaDaoConfig dedicatedEventsJpaDaoConfig = new DedicatedEventsJpaDaoConfig();
    JpaTransactionManager eventsTransactionManager = new JpaTransactionManager();

    // Act and Assert
    assertSame(eventsTransactionManager,
        dedicatedEventsJpaDaoConfig.eventsTransactionTemplate(eventsTransactionManager).getTransactionManager());
  }

  /**
   * Test
   * {@link DedicatedEventsJpaDaoConfig#eventsTransactionTemplate(JpaTransactionManager)}.
   * <ul>
   *   <li>When {@link JpaTransactionManager}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DedicatedEventsJpaDaoConfig#eventsTransactionTemplate(JpaTransactionManager)}
   */
  @Test
  public void testEventsTransactionTemplate_whenJpaTransactionManager_thenReturnNameIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JpaTransactionManager eventsTransactionManager = mock(JpaTransactionManager.class);

    // Act
    TransactionTemplate actualEventsTransactionTemplateResult = (new DedicatedEventsJpaDaoConfig())
        .eventsTransactionTemplate(eventsTransactionManager);

    // Assert
    assertNull(actualEventsTransactionTemplateResult.getName());
    assertEquals(-1, actualEventsTransactionTemplateResult.getIsolationLevel());
    assertEquals(-1, actualEventsTransactionTemplateResult.getTimeout());
    assertEquals(0, actualEventsTransactionTemplateResult.getPropagationBehavior());
    assertFalse(actualEventsTransactionTemplateResult.isReadOnly());
    assertSame(eventsTransactionManager, actualEventsTransactionTemplateResult.getTransactionManager());
  }

  /**
   * Test {@link DedicatedEventsJpaDaoConfig#eventsJdbcTemplate(DataSource)}.
   * <p>
   * Method under test:
   * {@link DedicatedEventsJpaDaoConfig#eventsJdbcTemplate(DataSource)}
   */
  @Test
  public void testEventsJdbcTemplate() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DataSource eventsDataSource = mock(DataSource.class);

    // Act
    JdbcTemplate actualEventsJdbcTemplateResult = (new DedicatedEventsJpaDaoConfig())
        .eventsJdbcTemplate(eventsDataSource);

    // Assert
    SQLExceptionTranslator exceptionTranslator = actualEventsJdbcTemplateResult.getExceptionTranslator();
    assertTrue(exceptionTranslator instanceof SQLExceptionSubclassTranslator);
    SQLExceptionTranslator fallbackTranslator = ((SQLExceptionSubclassTranslator) exceptionTranslator)
        .getFallbackTranslator();
    assertTrue(fallbackTranslator instanceof SQLStateSQLExceptionTranslator);
    assertNull(((SQLExceptionSubclassTranslator) exceptionTranslator).getCustomTranslator());
    assertNull(((SQLStateSQLExceptionTranslator) fallbackTranslator).getCustomTranslator());
    assertNull(((SQLStateSQLExceptionTranslator) fallbackTranslator).getFallbackTranslator());
    assertEquals(-1, actualEventsJdbcTemplateResult.getFetchSize());
    assertEquals(-1, actualEventsJdbcTemplateResult.getMaxRows());
    assertEquals(-1, actualEventsJdbcTemplateResult.getQueryTimeout());
    assertFalse(actualEventsJdbcTemplateResult.isResultsMapCaseInsensitive());
    assertFalse(actualEventsJdbcTemplateResult.isSkipResultsProcessing());
    assertFalse(actualEventsJdbcTemplateResult.isSkipUndeclaredResults());
    assertTrue(actualEventsJdbcTemplateResult.isIgnoreWarnings());
    assertTrue(actualEventsJdbcTemplateResult.isLazyInit());
    assertSame(eventsDataSource, actualEventsJdbcTemplateResult.getDataSource());
  }
}
