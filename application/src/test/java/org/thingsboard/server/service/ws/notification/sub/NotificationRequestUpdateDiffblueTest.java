package org.thingsboard.server.service.ws.notification.sub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.service.ws.notification.sub.NotificationRequestUpdate.NotificationRequestUpdateBuilder;

class NotificationRequestUpdateDiffblueTest {
  /**
   * Test {@link NotificationRequestUpdate#equals(Object)}, and
   * {@link NotificationRequestUpdate#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestUpdate#equals(Object)}
   *   <li>{@link NotificationRequestUpdate#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate buildResult = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link NotificationRequestUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate buildResult = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult2 = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate buildResult2 = deletedResult2
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NotificationRequestUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate buildResult = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link NotificationRequestUpdate#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestUpdate#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestUpdate buildResult = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to NotificationRequestUpdate");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestUpdate#NotificationRequestUpdate()}
   *   <li>{@link NotificationRequestUpdate#setDeleted(boolean)}
   *   <li>
   * {@link NotificationRequestUpdate#setNotificationRequestId(NotificationRequestId)}
   *   <li>{@link NotificationRequestUpdate#toString()}
   *   <li>{@link NotificationRequestUpdate#getNotificationRequestId()}
   *   <li>{@link NotificationRequestUpdate#isDeleted()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationRequestUpdate actualNotificationRequestUpdate = new NotificationRequestUpdate();
    actualNotificationRequestUpdate.setDeleted(true);
    NotificationRequestId notificationRequestId = new NotificationRequestId(UUID.randomUUID());
    actualNotificationRequestUpdate.setNotificationRequestId(notificationRequestId);
    actualNotificationRequestUpdate.toString();
    NotificationRequestId actualNotificationRequestId = actualNotificationRequestUpdate.getNotificationRequestId();

    // Assert that nothing has changed
    assertTrue(actualNotificationRequestUpdate.isDeleted());
    assertSame(notificationRequestId, actualNotificationRequestId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link NotificationRequestId#NotificationRequestId(UUID)} with id is
   * randomUUID.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link NotificationRequestUpdate#NotificationRequestUpdate(NotificationRequestId, boolean)}
   *   <li>{@link NotificationRequestUpdate#setDeleted(boolean)}
   *   <li>
   * {@link NotificationRequestUpdate#setNotificationRequestId(NotificationRequestId)}
   *   <li>{@link NotificationRequestUpdate#toString()}
   *   <li>{@link NotificationRequestUpdate#getNotificationRequestId()}
   *   <li>{@link NotificationRequestUpdate#isDeleted()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when NotificationRequestId(UUID) with id is randomUUID")
  void testGettersAndSetters_whenNotificationRequestIdWithIdIsRandomUUID() {
    // Arrange and Act
    NotificationRequestUpdate actualNotificationRequestUpdate = new NotificationRequestUpdate(
        new NotificationRequestId(UUID.randomUUID()), true);
    actualNotificationRequestUpdate.setDeleted(true);
    NotificationRequestId notificationRequestId = new NotificationRequestId(UUID.randomUUID());
    actualNotificationRequestUpdate.setNotificationRequestId(notificationRequestId);
    actualNotificationRequestUpdate.toString();
    NotificationRequestId actualNotificationRequestId = actualNotificationRequestUpdate.getNotificationRequestId();

    // Assert that nothing has changed
    assertTrue(actualNotificationRequestUpdate.isDeleted());
    assertSame(notificationRequestId, actualNotificationRequestId);
  }

  /**
   * Test NotificationRequestUpdateBuilder
   * {@link NotificationRequestUpdateBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link NotificationRequestUpdate.NotificationRequestUpdateBuilder#build()}
   *   <li>
   * {@link NotificationRequestUpdate.NotificationRequestUpdateBuilder#deleted(boolean)}
   *   <li>
   * {@link NotificationRequestUpdate.NotificationRequestUpdateBuilder#notificationRequestId(NotificationRequestId)}
   * </ul>
   */
  @Test
  @DisplayName("Test NotificationRequestUpdateBuilder build()")
  void testNotificationRequestUpdateBuilderBuild() {
    // Arrange
    NotificationRequestUpdate.NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder()
        .deleted(true);
    NotificationRequestId notificationRequestId = new NotificationRequestId(UUID.randomUUID());

    // Act
    NotificationRequestUpdate actualBuildResult = deletedResult.notificationRequestId(notificationRequestId).build();

    // Assert
    assertTrue(actualBuildResult.isDeleted());
    assertSame(notificationRequestId, actualBuildResult.getNotificationRequestId());
  }
}
