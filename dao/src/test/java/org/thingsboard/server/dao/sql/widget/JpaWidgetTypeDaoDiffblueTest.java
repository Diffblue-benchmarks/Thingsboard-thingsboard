package org.thingsboard.server.dao.sql.widget;

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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.WidgetTypeDetailsEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaWidgetTypeDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaWidgetTypeDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaWidgetTypeDao jpaWidgetTypeDao;

  @MockBean
  private TransactionTemplate transactionTemplate;

  @MockBean
  private WidgetTypeInfoRepository widgetTypeInfoRepository;

  @MockBean
  private WidgetTypeRepository widgetTypeRepository;

  @MockBean
  private WidgetsBundleWidgetRepository widgetsBundleWidgetRepository;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaWidgetTypeDao#getEntityClass()}
   *   <li>{@link JpaWidgetTypeDao#getEntityType()}
   *   <li>{@link JpaWidgetTypeDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaWidgetTypeDao.getEntityClass()", "EntityType JpaWidgetTypeDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaWidgetTypeDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaWidgetTypeDao jpaWidgetTypeDao = new JpaWidgetTypeDao();

    // Act
    Class<WidgetTypeDetailsEntity> actualEntityClass = jpaWidgetTypeDao.getEntityClass();
    EntityType actualEntityType = jpaWidgetTypeDao.getEntityType();

    // Assert
    assertNull(jpaWidgetTypeDao.getRepository());
    assertEquals(EntityType.WIDGET_TYPE, actualEntityType);
    Class<WidgetTypeDetailsEntity> expectedEntityClass = WidgetTypeDetailsEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JpaWidgetTypeDao.existsByTenantIdAndId(TenantId, UUID)"})
  public void testExistsByTenantIdAndId_thenReturnFalse() {
    // Arrange
    when(widgetTypeRepository.existsByTenantIdAndId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndIdResult = jpaWidgetTypeDao.existsByTenantIdAndId(ModelConstants.SYSTEM_TENANT,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(widgetTypeRepository).existsByTenantIdAndId(isA(UUID.class), isA(UUID.class));
    assertFalse(actualExistsByTenantIdAndIdResult);
  }

  /**
   * Test {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaWidgetTypeDao#existsByTenantIdAndId(TenantId, UUID)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JpaWidgetTypeDao.existsByTenantIdAndId(TenantId, UUID)"})
  public void testExistsByTenantIdAndId_thenReturnTrue() {
    // Arrange
    when(widgetTypeRepository.existsByTenantIdAndId(Mockito.<UUID>any(), Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndIdResult = jpaWidgetTypeDao.existsByTenantIdAndId(ModelConstants.SYSTEM_TENANT,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Assert
    verify(widgetTypeRepository).existsByTenantIdAndId(isA(UUID.class), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndIdResult);
  }
}
