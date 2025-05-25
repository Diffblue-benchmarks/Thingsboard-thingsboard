package org.thingsboard.server.dao.sql.notification;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import jakarta.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
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
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.model.sql.NotificationTemplateEntity;
import org.thingsboard.server.dao.sql.JpaExecutorService;

@ContextConfiguration(classes = {JpaNotificationTemplateDao.class})
@DisabledInAotMode
@EnableConfigurationProperties
@PropertySource("classpath:application-test.properties")
@RunWith(SpringJUnit4ClassRunner.class)
public class JpaNotificationTemplateDaoDiffblueTest {
  @MockBean
  private DataSource dataSource;

  @MockBean
  private EntityManagerFactory entityManagerFactory;

  @MockBean
  private JdbcTemplate jdbcTemplate;

  @MockBean
  private JpaExecutorService jpaExecutorService;

  @Autowired
  private JpaNotificationTemplateDao jpaNotificationTemplateDao;

  @MockBean
  private NotificationTemplateRepository notificationTemplateRepository;

  @MockBean
  private TransactionTemplate transactionTemplate;

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JpaNotificationTemplateDao#getEntityClass()}
   *   <li>{@link JpaNotificationTemplateDao#getEntityType()}
   *   <li>{@link JpaNotificationTemplateDao#getRepository()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"Class JpaNotificationTemplateDao.getEntityClass()",
      "EntityType JpaNotificationTemplateDao.getEntityType()",
      "org.springframework.data.jpa.repository.JpaRepository JpaNotificationTemplateDao.getRepository()"})
  public void testGettersAndSetters() {
    // Arrange
    JpaNotificationTemplateDao jpaNotificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));

    // Act
    Class<NotificationTemplateEntity> actualEntityClass = jpaNotificationTemplateDao.getEntityClass();
    EntityType actualEntityType = jpaNotificationTemplateDao.getEntityType();
    jpaNotificationTemplateDao.getRepository();

    // Assert
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, actualEntityType);
    Class<NotificationTemplateEntity> expectedEntityClass = NotificationTemplateEntity.class;
    assertEquals(expectedEntityClass, actualEntityClass);
  }

  /**
   * Test {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}.
   * <ul>
   *   <li>Given {@code ALARM}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JpaNotificationTemplateDao.countByTenantIdAndNotificationTypes(TenantId, List)"})
  public void testCountByTenantIdAndNotificationTypes_givenAlarm_whenArrayListAddAlarm() {
    // Arrange
    when(notificationTemplateRepository.countByTenantIdAndNotificationTypes(Mockito.<UUID>any(),
        Mockito.<List<NotificationType>>any())).thenReturn(1);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.ALARM);
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    int actualCountByTenantIdAndNotificationTypesResult = jpaNotificationTemplateDao
        .countByTenantIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT, notificationTypes);

    // Assert
    verify(notificationTemplateRepository).countByTenantIdAndNotificationTypes(isA(UUID.class), isA(List.class));
    assertEquals(1, actualCountByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}.
   * <ul>
   *   <li>Given {@code GENERAL}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code GENERAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JpaNotificationTemplateDao.countByTenantIdAndNotificationTypes(TenantId, List)"})
  public void testCountByTenantIdAndNotificationTypes_givenGeneral_whenArrayListAddGeneral() {
    // Arrange
    when(notificationTemplateRepository.countByTenantIdAndNotificationTypes(Mockito.<UUID>any(),
        Mockito.<List<NotificationType>>any())).thenReturn(1);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    int actualCountByTenantIdAndNotificationTypesResult = jpaNotificationTemplateDao
        .countByTenantIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT, notificationTypes);

    // Assert
    verify(notificationTemplateRepository).countByTenantIdAndNotificationTypes(isA(UUID.class), isA(List.class));
    assertEquals(1, actualCountByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link JpaNotificationTemplateDao#countByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"int JpaNotificationTemplateDao.countByTenantIdAndNotificationTypes(TenantId, List)"})
  public void testCountByTenantIdAndNotificationTypes_whenArrayList_thenReturnOne() {
    // Arrange
    when(notificationTemplateRepository.countByTenantIdAndNotificationTypes(Mockito.<UUID>any(),
        Mockito.<List<NotificationType>>any())).thenReturn(1);

    // Act
    int actualCountByTenantIdAndNotificationTypesResult = jpaNotificationTemplateDao
        .countByTenantIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(notificationTemplateRepository).countByTenantIdAndNotificationTypes(isA(UUID.class), isA(List.class));
    assertEquals(1, actualCountByTenantIdAndNotificationTypesResult);
  }
}
