package org.thingsboard.server.dao.sql.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
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
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationRequestEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaNotificationRequestDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaNotificationRequestDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaNotificationRequestDao jpaNotificationRequestDao;

  @MockBean
  private NotificationRequestRepository notificationRequestRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)"})
  public void testExistsByTenantIdAndStatusAndTargetId_thenCallsGetId() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTargetsContaining(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<String>any())).thenReturn(true);
    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualExistsByTenantIdAndStatusAndTargetIdResult = jpaNotificationRequestDao
        .existsByTenantIdAndStatusAndTargetId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
            targetId);

    // Assert
    verify(targetId).getId();
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTargetsContaining(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), eq("784f394c-42b6-435a-983c-b7beff2784f9"));
    assertTrue(actualExistsByTenantIdAndStatusAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)"})
  public void testExistsByTenantIdAndStatusAndTargetId_thenReturnFalse() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTargetsContaining(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTargetIdResult = jpaNotificationRequestDao
        .existsByTenantIdAndStatusAndTargetId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
            new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTargetsContaining(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), eq("784f394c-42b6-435a-983c-b7beff2784f9"));
    assertFalse(actualExistsByTenantIdAndStatusAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTargetId(TenantId, NotificationRequestStatus, NotificationTargetId)"})
  public void testExistsByTenantIdAndStatusAndTargetId_thenReturnTrue() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTargetsContaining(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTargetIdResult = jpaNotificationRequestDao
        .existsByTenantIdAndStatusAndTargetId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
            new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTargetsContaining(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), eq("784f394c-42b6-435a-983c-b7beff2784f9"));
    assertTrue(actualExistsByTenantIdAndStatusAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)"})
  public void testExistsByTenantIdAndStatusAndTemplateId_thenCallsGetId() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTemplateId(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any())).thenReturn(true);
    NotificationTemplateId templateId = mock(NotificationTemplateId.class);
    when(templateId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualExistsByTenantIdAndStatusAndTemplateIdResult = jpaNotificationRequestDao
        .existsByTenantIdAndStatusAndTemplateId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
            templateId);

    // Assert
    verify(templateId).getId();
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTemplateId(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndStatusAndTemplateIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)"})
  public void testExistsByTenantIdAndStatusAndTemplateId_thenReturnFalse() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTemplateId(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any())).thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTemplateIdResult = jpaNotificationRequestDao
        .existsByTenantIdAndStatusAndTemplateId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTemplateId(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertFalse(actualExistsByTenantIdAndStatusAndTemplateIdResult);
  }

  /**
   * Test {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationRequestDao#existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "boolean JpaNotificationRequestDao.existsByTenantIdAndStatusAndTemplateId(TenantId, NotificationRequestStatus, NotificationTemplateId)"})
  public void testExistsByTenantIdAndStatusAndTemplateId_thenReturnTrue() {
    // Arrange
    when(notificationRequestRepository.existsByTenantIdAndStatusAndTemplateId(Mockito.<UUID>any(),
        Mockito.<NotificationRequestStatus>any(), Mockito.<UUID>any())).thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndStatusAndTemplateIdResult = jpaNotificationRequestDao
        .existsByTenantIdAndStatusAndTemplateId(ModelConstants.SYSTEM_TENANT, NotificationRequestStatus.PROCESSING,
            new NotificationTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRequestRepository).existsByTenantIdAndStatusAndTemplateId(isA(UUID.class),
        eq(NotificationRequestStatus.PROCESSING), isA(UUID.class));
    assertTrue(actualExistsByTenantIdAndStatusAndTemplateIdResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaNotificationRequestDao#getEntityClass()}
   *   <li>{@link JpaNotificationRequestDao#getEntityType()}
   *   <li>{@link JpaNotificationRequestDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaNotificationRequestDao.getEntityClass()",
      "EntityType JpaNotificationRequestDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaNotificationRequestDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationRequestDao jpaNotificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));

    // Act
    Class<NotificationRequestEntity> actualEntityClass = jpaNotificationRequestDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationRequestDao.getEntityType();
    jpaNotificationRequestDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION_REQUEST, actualEntityType);
    Class<NotificationRequestEntity> expectedEntityClass = NotificationRequestEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
