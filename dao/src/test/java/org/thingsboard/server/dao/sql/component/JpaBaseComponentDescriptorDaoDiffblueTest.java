package org.thingsboard.server.dao.sql.component;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.UUID;
import javax.sql.DataSource;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.id.ComponentDescriptorId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.ComponentDescriptorEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaBaseComponentDescriptorDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaBaseComponentDescriptorDaoDiffblueTest {
  @MockBean
  private ComponentDescriptorInsertRepository componentDescriptorInsertRepository;

  @MockBean
  private ComponentDescriptorRepository componentDescriptorRepository;

  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaBaseComponentDescriptorDao jpaBaseComponentDescriptorDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaBaseComponentDescriptorDao#getEntityClass()}
   *   <li>{@link JpaBaseComponentDescriptorDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaBaseComponentDescriptorDao.getEntityClass()",
      "JpaRepository JpaBaseComponentDescriptorDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaBaseComponentDescriptorDao jpaBaseComponentDescriptorDao = new JpaBaseComponentDescriptorDao();

    // Act
    Class<ComponentDescriptorEntity> actualEntityClass = jpaBaseComponentDescriptorDao.getEntityClass();

    // Assert
    assertNull(jpaBaseComponentDescriptorDao.getRepository());
    Class<ComponentDescriptorEntity> expectedEntityClass = ComponentDescriptorEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#deleteById(TenantId, ComponentDescriptorId)}.
   * <ul>
   *   <li>Then calls {@link JpaRepository#flush()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaBaseComponentDescriptorDao#deleteById(TenantId, ComponentDescriptorId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaBaseComponentDescriptorDao.deleteById(TenantId, ComponentDescriptorId)"})
  public void testDeleteById_thenCallsFlush() {
    // Arrange
    doNothing().when(componentDescriptorRepository).flush();
    doNothing().when(componentDescriptorRepository).deleteById(Mockito.<UUID>any());

    // Act
    jpaBaseComponentDescriptorDao.deleteById(ModelConstants.SYSTEM_TENANT,
        new ComponentDescriptorId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(componentDescriptorRepository).flush();
    verify(componentDescriptorRepository).deleteById(isA(UUID.class));
  }

  /**
   * Test {@link JpaBaseComponentDescriptorDao#deleteByClazz(TenantId, String)}.
   * <p>
   * Method under test: {@link JpaBaseComponentDescriptorDao#deleteByClazz(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JpaBaseComponentDescriptorDao.deleteByClazz(TenantId, String)"})
  public void testDeleteByClazz() {
    // Arrange
    doNothing().when(componentDescriptorRepository).deleteByClazz(Mockito.<String>any());

    // Act
    jpaBaseComponentDescriptorDao.deleteByClazz(ModelConstants.SYSTEM_TENANT, "Clazz");

    // Assert
    verify(componentDescriptorRepository).deleteByClazz(eq("Clazz"));
  }
}
