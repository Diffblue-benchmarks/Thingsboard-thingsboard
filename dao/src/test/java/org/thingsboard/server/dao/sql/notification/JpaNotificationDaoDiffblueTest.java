package org.thingsboard.server.dao.sql.notification;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
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
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationStatus;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {JpaNotificationDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaNotificationDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaNotificationDao jpaNotificationDao;

  @MockBean
  private NotificationRepository notificationRepository;

  @MockBean
  private SqlPartitioningRepository sqlPartitioningRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)}.
   * <p>
   * Method under test: {@link JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "int JpaNotificationDao.countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)"})
  public void testCountUnreadByDeliveryMethodAndRecipientId() {
    // Arrange
    when(notificationRepository.countByDeliveryMethodAndRecipientIdAndStatusNot(
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UUID>any(), Mockito.<NotificationStatus>any()))
        .thenReturn(1);

    // Act
    int actualCountUnreadByDeliveryMethodAndRecipientIdResult = jpaNotificationDao
        .countUnreadByDeliveryMethodAndRecipientId(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB,
            new UserId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRepository).countByDeliveryMethodAndRecipientIdAndStatusNot(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), eq(NotificationStatus.READ));
    assertEquals(1, actualCountUnreadByDeliveryMethodAndRecipientIdResult);
  }

  /**
   * Test {@link JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationDao#countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "int JpaNotificationDao.countUnreadByDeliveryMethodAndRecipientId(TenantId, NotificationDeliveryMethod, UserId)"})
  public void testCountUnreadByDeliveryMethodAndRecipientId_thenCallsGetId() {
    // Arrange
    when(notificationRepository.countByDeliveryMethodAndRecipientIdAndStatusNot(
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UUID>any(), Mockito.<NotificationStatus>any()))
        .thenReturn(1);
    UserId recipientId = mock(UserId.class);
    when(recipientId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    int actualCountUnreadByDeliveryMethodAndRecipientIdResult = jpaNotificationDao
        .countUnreadByDeliveryMethodAndRecipientId(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB,
            recipientId);

    // Assert
    verify(recipientId).getId();
    verify(notificationRepository).countByDeliveryMethodAndRecipientIdAndStatusNot(eq(NotificationDeliveryMethod.WEB),
        isA(UUID.class), eq(NotificationStatus.READ));
    assertEquals(1, actualCountUnreadByDeliveryMethodAndRecipientIdResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaNotificationDao#getEntityClass()}
   *   <li>{@link JpaNotificationDao#getEntityType()}
   *   <li>{@link JpaNotificationDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaNotificationDao.getEntityClass()", "EntityType JpaNotificationDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaNotificationDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationDao jpaNotificationDao = new JpaNotificationDao(mock(NotificationRepository.class),
        mock(SqlPartitioningRepository.class));

    // Act
    Class<NotificationEntity> actualEntityClass = jpaNotificationDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationDao.getEntityType();
    jpaNotificationDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION, actualEntityType);
    Class<NotificationEntity> expectedEntityClass = NotificationEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
