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
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationRuleEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaNotificationRuleDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaNotificationRuleDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaNotificationRuleDao jpaNotificationRuleDao;

  @MockBean
  private NotificationRuleRepository notificationRuleRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JpaNotificationRuleDao.existsByTenantIdAndTargetId(TenantId, NotificationTargetId)"})
  public void testExistsByTenantIdAndTargetId_thenCallsGetId() {
    // Arrange
    when(notificationRuleRepository.existsByTenantIdAndRecipientsConfigContaining(Mockito.<UUID>any(),
        Mockito.<String>any())).thenReturn(true);
    NotificationTargetId targetId = mock(NotificationTargetId.class);
    when(targetId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    boolean actualExistsByTenantIdAndTargetIdResult = jpaNotificationRuleDao
        .existsByTenantIdAndTargetId(ModelConstants.SYSTEM_TENANT, targetId);

    // Assert
    verify(targetId).getId();
    verify(notificationRuleRepository).existsByTenantIdAndRecipientsConfigContaining(isA(UUID.class),
        eq("784f394c-42b6-435a-983c-b7beff2784f9"));
    assertTrue(actualExistsByTenantIdAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JpaNotificationRuleDao.existsByTenantIdAndTargetId(TenantId, NotificationTargetId)"})
  public void testExistsByTenantIdAndTargetId_thenReturnFalse() {
    // Arrange
    when(notificationRuleRepository.existsByTenantIdAndRecipientsConfigContaining(Mockito.<UUID>any(),
        Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualExistsByTenantIdAndTargetIdResult = jpaNotificationRuleDao.existsByTenantIdAndTargetId(
        ModelConstants.SYSTEM_TENANT,
        new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRuleRepository).existsByTenantIdAndRecipientsConfigContaining(isA(UUID.class),
        eq("784f394c-42b6-435a-983c-b7beff2784f9"));
    assertFalse(actualExistsByTenantIdAndTargetIdResult);
  }

  /**
   * Test {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationRuleDao#existsByTenantIdAndTargetId(TenantId, NotificationTargetId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JpaNotificationRuleDao.existsByTenantIdAndTargetId(TenantId, NotificationTargetId)"})
  public void testExistsByTenantIdAndTargetId_thenReturnTrue() {
    // Arrange
    when(notificationRuleRepository.existsByTenantIdAndRecipientsConfigContaining(Mockito.<UUID>any(),
        Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualExistsByTenantIdAndTargetIdResult = jpaNotificationRuleDao.existsByTenantIdAndTargetId(
        ModelConstants.SYSTEM_TENANT,
        new NotificationTargetId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationRuleRepository).existsByTenantIdAndRecipientsConfigContaining(isA(UUID.class),
        eq("784f394c-42b6-435a-983c-b7beff2784f9"));
    assertTrue(actualExistsByTenantIdAndTargetIdResult);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaNotificationRuleDao#getEntityClass()}
   *   <li>{@link JpaNotificationRuleDao#getEntityType()}
   *   <li>{@link JpaNotificationRuleDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaNotificationRuleDao.getEntityClass()",
      "EntityType JpaNotificationRuleDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaNotificationRuleDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationRuleDao jpaNotificationRuleDao = new JpaNotificationRuleDao(mock(NotificationRuleRepository.class));

    // Act
    Class<NotificationRuleEntity> actualEntityClass = jpaNotificationRuleDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationRuleDao.getEntityType();
    jpaNotificationRuleDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION_RULE, actualEntityType);
    Class<NotificationRuleEntity> expectedEntityClass = NotificationRuleEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }
}
