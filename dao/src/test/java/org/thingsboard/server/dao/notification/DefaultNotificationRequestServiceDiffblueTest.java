package org.thingsboard.server.dao.notification;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationEventPublisher;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.sql.notification.JpaNotificationDao;
import org.thingsboard.server.dao.sql.notification.JpaNotificationRequestDao;
import org.thingsboard.server.dao.sql.notification.NotificationRepository;
import org.thingsboard.server.dao.sql.notification.NotificationRequestRepository;
import org.thingsboard.server.dao.sqlts.insert.sql.SqlPartitioningRepository;

class DefaultNotificationRequestServiceDiffblueTest {
  /**
   * Test {@link DefaultNotificationRequestService#getEntityType()}.
   *
   * <p>Method under test: {@link DefaultNotificationRequestService#getEntityType()}
   */
  @Test
  @DisplayName("Test getEntityType()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"EntityType DefaultNotificationRequestService.getEntityType()"})
  void testGetEntityType() {
    // Arrange
    JpaNotificationRequestDao notificationRequestDao =
        new JpaNotificationRequestDao(mock(NotificationRequestRepository.class));

    // Act and Assert
    assertEquals(
        EntityType.NOTIFICATION_REQUEST,
        new DefaultNotificationRequestService(
                notificationRequestDao,
                new JpaNotificationDao(
                    mock(NotificationRepository.class), mock(SqlPartitioningRepository.class)),
                mock(ApplicationEventPublisher.class))
            .getEntityType());
  }
}
