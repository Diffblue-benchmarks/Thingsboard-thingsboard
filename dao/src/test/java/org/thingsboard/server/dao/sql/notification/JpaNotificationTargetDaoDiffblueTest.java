package org.thingsboard.server.dao.sql.notification;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
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
import org.thingsboard.server.dao.model.sql.NotificationTargetEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaNotificationTargetDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaNotificationTargetDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaNotificationTargetDao jpaNotificationTargetDao;

  @MockBean
  private NotificationTargetRepository notificationTargetRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaNotificationTargetDao#countByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationTargetDao#countByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Long JpaNotificationTargetDao.countByTenantId(TenantId)"})
  public void testCountByTenantId_whenSystem_tenant_thenReturnLongValueIsOne() {
    // Arrange
    when(notificationTargetRepository.countByTenantId(Mockito.<UUID>any())).thenReturn(1L);

    // Act
    Long actualCountByTenantIdResult = jpaNotificationTargetDao.countByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTargetRepository).countByTenantId(isA(UUID.class));
    assertEquals(1L, actualCountByTenantIdResult.longValue());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaNotificationTargetDao#getEntityClass()}
   *   <li>{@link JpaNotificationTargetDao#getEntityType()}
   *   <li>{@link JpaNotificationTargetDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaNotificationTargetDao.getEntityClass()",
      "EntityType JpaNotificationTargetDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaNotificationTargetDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationTargetDao jpaNotificationTargetDao = new JpaNotificationTargetDao(
        mock(NotificationTargetRepository.class));

    // Act
    Class<NotificationTargetEntity> actualEntityClass = jpaNotificationTargetDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationTargetDao.getEntityType();
    jpaNotificationTargetDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION_TARGET, actualEntityType);
    Class<NotificationTargetEntity> expectedEntityClass = NotificationTargetEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
