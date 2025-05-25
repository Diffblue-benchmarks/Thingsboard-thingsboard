package org.thingsboard.server.dao.sql.entityview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.support.TransactionTemplate;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.model.sql.EntityViewEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaEntityViewDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaEntityViewDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private EntityViewRepository entityViewRepository;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @Autowired
  private JpaEntityViewDao jpaEntityViewDao;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaEntityViewDao#getEntityClass()}
   *   <li>{@link JpaEntityViewDao#getEntityType()}
   *   <li>{@link JpaEntityViewDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaEntityViewDao.getEntityClass()", "EntityType JpaEntityViewDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaEntityViewDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaEntityViewDao jpaEntityViewDao = new JpaEntityViewDao();

    // Act
    Class<EntityViewEntity> actualEntityClass = jpaEntityViewDao.getEntityClass();
    EntityType actualEntityType = jpaEntityViewDao.getEntityType();

    // Assert
    assertNull(jpaEntityViewDao.getRepository());
    assertEquals(EntityType.ENTITY_VIEW, actualEntityType);
    Class<EntityViewEntity> expectedEntityClass = EntityViewEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaEntityViewDao#existsByTenantIdAndEntityId(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEntityViewDao#existsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JpaEntityViewDao.existsByTenantIdAndEntityId(UUID, UUID)"})
  public void testExistsByTenantIdAndEntityId_thenReturnFalse() {
    // Arrange
    when(entityViewRepository.existsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(false);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    boolean actualExistsByTenantIdAndEntityIdResult = jpaEntityViewDao.existsByTenantIdAndEntityId(tenantId,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(entityViewRepository).existsByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertFalse(actualExistsByTenantIdAndEntityIdResult);
  }

  /**
   * Test {@link JpaEntityViewDao#existsByTenantIdAndEntityId(UUID, UUID)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaEntityViewDao#existsByTenantIdAndEntityId(UUID, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JpaEntityViewDao.existsByTenantIdAndEntityId(UUID, UUID)"})
  public void testExistsByTenantIdAndEntityId_thenReturnTrue() {
    // Arrange
    when(entityViewRepository.existsByTenantIdAndEntityId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(true);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    boolean actualExistsByTenantIdAndEntityIdResult = jpaEntityViewDao.existsByTenantIdAndEntityId(tenantId,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(entityViewRepository).existsByTenantIdAndEntityId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndEntityIdResult);
  }
}
