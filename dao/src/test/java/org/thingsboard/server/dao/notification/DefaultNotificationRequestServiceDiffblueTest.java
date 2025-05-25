package org.thingsboard.server.dao.notification;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

@ContextConfiguration(classes = {DefaultNotificationRequestService.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class DefaultNotificationRequestServiceDiffblueTest {
  @Autowired
  private DefaultNotificationRequestService defaultNotificationRequestService;

  @MockBean
  private NotificationDao notificationDao;

  @MockBean
  private NotificationRequestDao notificationRequestDao;

  /**
   * Test {@link DefaultNotificationRequestService#deleteByTenantId(TenantId)}.
   * <p>
   * Method under test: {@link DefaultNotificationRequestService#deleteByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DefaultNotificationRequestService.deleteByTenantId(TenantId)"})
  public void testDeleteByTenantId() {
    // Arrange
    doNothing().when(notificationRequestDao).removeByTenantId(Mockito.<TenantId>any());

    // Act
    defaultNotificationRequestService.deleteByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(notificationRequestDao).removeByTenantId(isA(TenantId.class));
  }

  /**
   * Test {@link DefaultNotificationRequestService#getEntityType()}.
   * <p>
   * Method under test: {@link DefaultNotificationRequestService#getEntityType()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"EntityType DefaultNotificationRequestService.getEntityType()"})
  public void testGetEntityType() {
    // Arrange
    JpaNotificationRequestDao notificationRequestDao = new JpaNotificationRequestDao(
        mock(NotificationRequestRepository.class));

    // Act and Assert
    assertEquals(EntityType.NOTIFICATION_REQUEST,
        (new DefaultNotificationRequestService(notificationRequestDao,
            new JpaNotificationDao(mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
            mock(ApplicationEventPublisher.class))).getEntityType());
  }
}
