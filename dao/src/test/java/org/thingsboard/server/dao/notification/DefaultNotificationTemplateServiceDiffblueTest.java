package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationTemplateDao;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sql.notification.NotificationTemplateRepository;

@ContextConfiguration(classes = {DefaultNotificationTemplateService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNotificationTemplateServiceDiffblueTest {
  @Autowired
  private DefaultNotificationTemplateService defaultNotificationTemplateService;

  @MockBean
  private NotificationRequestDao notificationRequestDao;

  @MockBean
  private NotificationTemplateDao notificationTemplateDao;

  /**
   * Test {@link DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)}.
   * <p>
   * Method under test: {@link DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "int DefaultNotificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)"})
  public void testCountNotificationTemplatesByTenantIdAndNotificationTypes() {
    // Arrange
    when(notificationTemplateDao.countByTenantIdAndNotificationTypes(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any())).thenThrow(new IllegalArgumentException("foo"));

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> defaultNotificationTemplateService
        .countNotificationTemplatesByTenantIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT, new ArrayList<>()));
    verify(notificationTemplateDao).countByTenantIdAndNotificationTypes(isA(TenantId.class), isA(List.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)}.
   * <ul>
   *   <li>Given {@code ALARM}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "int DefaultNotificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)"})
  public void testCountNotificationTemplatesByTenantIdAndNotificationTypes_givenAlarm() {
    // Arrange
    when(notificationTemplateDao.countByTenantIdAndNotificationTypes(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any())).thenReturn(1);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.ALARM);
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    int actualCountNotificationTemplatesByTenantIdAndNotificationTypesResult = defaultNotificationTemplateService
        .countNotificationTemplatesByTenantIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT, notificationTypes);

    // Assert
    verify(notificationTemplateDao).countByTenantIdAndNotificationTypes(isA(TenantId.class), isA(List.class));
    assertEquals(1, actualCountNotificationTemplatesByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)}.
   * <ul>
   *   <li>Given {@code GENERAL}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "int DefaultNotificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)"})
  public void testCountNotificationTemplatesByTenantIdAndNotificationTypes_givenGeneral() {
    // Arrange
    when(notificationTemplateDao.countByTenantIdAndNotificationTypes(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any())).thenReturn(1);

    ArrayList<NotificationType> notificationTypes = new ArrayList<>();
    notificationTypes.add(NotificationType.GENERAL);

    // Act
    int actualCountNotificationTemplatesByTenantIdAndNotificationTypesResult = defaultNotificationTemplateService
        .countNotificationTemplatesByTenantIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT, notificationTypes);

    // Assert
    verify(notificationTemplateDao).countByTenantIdAndNotificationTypes(isA(TenantId.class), isA(List.class));
    assertEquals(1, actualCountNotificationTemplatesByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationTemplateService#countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "int DefaultNotificationTemplateService.countNotificationTemplatesByTenantIdAndNotificationTypes(TenantId, List)"})
  public void testCountNotificationTemplatesByTenantIdAndNotificationTypes_whenArrayList() {
    // Arrange
    when(notificationTemplateDao.countByTenantIdAndNotificationTypes(Mockito.<TenantId>any(),
        Mockito.<List<NotificationType>>any())).thenReturn(1);

    // Act
    int actualCountNotificationTemplatesByTenantIdAndNotificationTypesResult = defaultNotificationTemplateService
        .countNotificationTemplatesByTenantIdAndNotificationTypes(ModelConstants.SYSTEM_TENANT, new ArrayList<>());

    // Assert
    verify(notificationTemplateDao).countByTenantIdAndNotificationTypes(isA(TenantId.class), isA(List.class));
    assertEquals(1, actualCountNotificationTemplatesByTenantIdAndNotificationTypesResult);
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Given {@link NotificationTemplateDao} {@link NotificationTemplateDao#removeByTenantId(TenantId)} does nothing.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationTemplateService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationTemplateService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_givenNotificationTemplateDaoRemoveByTenantIdDoesNothing() {
    // Arrange
    doNothing().when(notificationTemplateDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationTemplateService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationTemplateDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#deleteByTenantId(TenantId)}.
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationTemplateService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationTemplateService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId_thenThrowIllegalArgumentException() {
    // Arrange
    doThrow(new IllegalArgumentException("foo")).when(notificationTemplateDao)
        .removeByTenantId(Mockito.<TenantId>any());

    // Act and Assert
    assertThrows(IllegalArgumentException.class,
        () -> defaultNotificationTemplateService.deleteByTenantId(ModelConstants.SYSTEM_TENANT));
    verify(notificationTemplateDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationTemplateService#getEntityType()}.
   * <p>
   * Method under test: {@link DefaultNotificationTemplateService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DefaultNotificationTemplateService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaNotificationTemplateDao notificationTemplateDao = new JpaNotificationTemplateDao(
        mock(NotificationTemplateRepository.class));

    // Act and Assert
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, (new DefaultNotificationTemplateService(notificationTemplateDao,
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class)))).getEntityType());
  }
}
