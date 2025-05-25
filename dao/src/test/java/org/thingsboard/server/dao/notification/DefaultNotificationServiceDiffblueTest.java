package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
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
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.UserId;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {DefaultNotificationService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNotificationServiceDiffblueTest {
  @Autowired
  private DefaultNotificationService defaultNotificationService;

  @MockBean
  private NotificationDao notificationDao;

  /**
   * Test {@link DefaultNotificationService#countUnreadNotificationsByRecipientId(TenantId, NotificationDeliveryMethod, UserId)}.
   * <ul>
   *   <li>Then return one.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationService#countUnreadNotificationsByRecipientId(TenantId, NotificationDeliveryMethod, UserId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
      "int DefaultNotificationService.countUnreadNotificationsByRecipientId(TenantId, NotificationDeliveryMethod, UserId)"})
  public void testCountUnreadNotificationsByRecipientId_thenReturnOne() {
    // Arrange
    when(notificationDao.countUnreadByDeliveryMethodAndRecipientId(Mockito.<TenantId>any(),
        Mockito.<NotificationDeliveryMethod>any(), Mockito.<UserId>any())).thenReturn(1);

    // Act
    int actualCountUnreadNotificationsByRecipientIdResult = defaultNotificationService
        .countUnreadNotificationsByRecipientId(ModelConstants.SYSTEM_TENANT, NotificationDeliveryMethod.WEB, null);

    // Assert
    verify(notificationDao).countUnreadByDeliveryMethodAndRecipientId(isA(TenantId.class),
        eq(NotificationDeliveryMethod.WEB), isNull());
    assertEquals(1, actualCountUnreadNotificationsByRecipientIdResult);
  }

  /**
   * Test {@link DefaultNotificationService#deleteNotification(TenantId, UserId, NotificationId)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationService#deleteNotification(TenantId, UserId, NotificationId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotificationService.deleteNotification(TenantId, UserId, NotificationId)"})
  public void testDeleteNotification_thenReturnFalse() {
    // Arrange
    when(notificationDao.deleteByIdAndRecipientId(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<NotificationId>any())).thenReturn(false);

    // Act
    boolean actualDeleteNotificationResult = defaultNotificationService.deleteNotification(ModelConstants.SYSTEM_TENANT,
        null, new NotificationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationDao).deleteByIdAndRecipientId(isA(TenantId.class), isNull(), isA(NotificationId.class));
    assertFalse(actualDeleteNotificationResult);
  }

  /**
   * Test {@link DefaultNotificationService#deleteNotification(TenantId, UserId, NotificationId)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultNotificationService#deleteNotification(TenantId, UserId, NotificationId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean DefaultNotificationService.deleteNotification(TenantId, UserId, NotificationId)"})
  public void testDeleteNotification_thenReturnTrue() {
    // Arrange
    when(notificationDao.deleteByIdAndRecipientId(Mockito.<TenantId>any(), Mockito.<UserId>any(),
        Mockito.<NotificationId>any())).thenReturn(true);

    // Act
    boolean actualDeleteNotificationResult = defaultNotificationService.deleteNotification(ModelConstants.SYSTEM_TENANT,
        null, new NotificationId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(notificationDao).deleteByIdAndRecipientId(isA(TenantId.class), isNull(), isA(NotificationId.class));
    assertTrue(actualDeleteNotificationResult);
  }

  /**
   * Test {@link DefaultNotificationService#getEntityType()}.
   * <p>
   * Method under test: {@link DefaultNotificationService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DefaultNotificationService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange, Act and Assert
    assertEquals(EntityType.NOTIFICATION,
        (new DefaultNotificationService(
            new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class))))
            .getEntityType());
  }
}
