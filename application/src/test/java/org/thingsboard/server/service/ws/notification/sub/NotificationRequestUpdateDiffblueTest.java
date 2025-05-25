package org.thingsboard.server.service.ws.notification.sub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.service.ws.notification.sub.NotificationRequestUpdate.NotificationRequestUpdateBuilder;

@ContextConfiguration(classes = {NotificationRequestUpdateBuilder.class})
@ExtendWith(SpringExtension.class)
class NotificationRequestUpdateDiffblueTest {
  @Autowired
  private NotificationRequestUpdateBuilder notificationRequestUpdateBuilder;

  /**
   * Test {@link NotificationRequestUpdate#equals(Object)}, and {@link NotificationRequestUpdate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestUpdate.equals(Object)", "int NotificationRequestUpdate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder().deleted(true);
    NotificationRequestUpdate buildResult = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    NotificationRequestUpdateBuilder deletedResult2 = NotificationRequestUpdate.builder().deleted(true);
    NotificationRequestUpdate buildResult2 = deletedResult2
        .notificationRequestId(new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link NotificationRequestUpdate#equals(Object)}, and {@link NotificationRequestUpdate#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestUpdate.equals(Object)", "int NotificationRequestUpdate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationRequestUpdateBuilder notificationRequestUpdateBuilder = mock(NotificationRequestUpdateBuilder.class);
    when(notificationRequestUpdateBuilder.notificationRequestId(Mockito.<NotificationRequestId>any()))
        .thenReturn(NotificationRequestUpdate.builder());
    NotificationRequestUpdateBuilder notificationRequestUpdateBuilder2 = mock(NotificationRequestUpdateBuilder.class);
    when(notificationRequestUpdateBuilder2.deleted(anyBoolean())).thenReturn(notificationRequestUpdateBuilder);
    NotificationRequestUpdateBuilder deletedResult = notificationRequestUpdateBuilder2.deleted(true);
    NotificationRequestUpdate buildResult = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();
    NotificationRequestUpdate buildResult2 = NotificationRequestUpdate.builder()
        .deleted(false)
        .notificationRequestId(null)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link NotificationRequestUpdate#equals(Object)}, and {@link NotificationRequestUpdate#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestUpdate.equals(Object)", "int NotificationRequestUpdate.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder().deleted(true);
    NotificationRequestUpdate buildResult = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestUpdate.equals(Object)", "int NotificationRequestUpdate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequestUpdateBuilder notificationRequestUpdateBuilder = mock(NotificationRequestUpdateBuilder.class);
    when(notificationRequestUpdateBuilder.deleted(anyBoolean())).thenReturn(NotificationRequestUpdate.builder());
    NotificationRequestUpdateBuilder deletedResult = notificationRequestUpdateBuilder.deleted(true);
    NotificationRequestUpdate buildResult = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();
    NotificationRequestUpdateBuilder deletedResult2 = NotificationRequestUpdate.builder().deleted(true);
    NotificationRequestUpdate buildResult2 = deletedResult2
        .notificationRequestId(new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestUpdate.equals(Object)", "int NotificationRequestUpdate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRequestUpdateBuilder notificationRequestUpdateBuilder = mock(NotificationRequestUpdateBuilder.class);
    when(notificationRequestUpdateBuilder.deleted(anyBoolean())).thenReturn(NotificationRequestUpdate.builder());
    NotificationRequestUpdateBuilder deletedResult = notificationRequestUpdateBuilder.deleted(true);
    NotificationRequestUpdate buildResult = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();
    NotificationRequestUpdateBuilder deletedResult2 = NotificationRequestUpdate.builder().deleted(false);
    NotificationRequestUpdate buildResult2 = deletedResult2
        .notificationRequestId(new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestUpdate.equals(Object)", "int NotificationRequestUpdate.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRequestUpdateBuilder notificationRequestUpdateBuilder = mock(NotificationRequestUpdateBuilder.class);
    when(notificationRequestUpdateBuilder.notificationRequestId(Mockito.<NotificationRequestId>any()))
        .thenReturn(NotificationRequestUpdate.builder());
    NotificationRequestUpdateBuilder notificationRequestUpdateBuilder2 = mock(NotificationRequestUpdateBuilder.class);
    when(notificationRequestUpdateBuilder2.deleted(anyBoolean())).thenReturn(notificationRequestUpdateBuilder);
    NotificationRequestUpdateBuilder deletedResult = notificationRequestUpdateBuilder2.deleted(true);
    NotificationRequestUpdate buildResult = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.randomUUID()))
        .build();
    NotificationRequestUpdateBuilder deletedResult2 = NotificationRequestUpdate.builder().deleted(false);
    NotificationRequestUpdate buildResult2 = deletedResult2
        .notificationRequestId(new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestUpdate.equals(Object)", "int NotificationRequestUpdate.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder().deleted(true);
    NotificationRequestUpdate buildResult = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean NotificationRequestUpdate.equals(Object)", "int NotificationRequestUpdate.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder().deleted(true);
    NotificationRequestUpdate buildResult = deletedResult
        .notificationRequestId(new NotificationRequestId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to NotificationRequestUpdate");
  }

  /**
   * Test NotificationRequestUpdateBuilder {@link NotificationRequestUpdateBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestUpdateBuilder#build()}
   *   <li>{@link NotificationRequestUpdateBuilder#deleted(boolean)}
   *   <li>{@link NotificationRequestUpdateBuilder#notificationRequestId(NotificationRequestId)}
   * </ul>
   */
  @Test
  @DisplayName("Test NotificationRequestUpdateBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void NotificationRequestUpdateBuilder.<init>()",
      "NotificationRequestUpdate NotificationRequestUpdateBuilder.build()",
      "NotificationRequestUpdateBuilder NotificationRequestUpdateBuilder.deleted(boolean)",
      "NotificationRequestUpdateBuilder NotificationRequestUpdateBuilder.notificationRequestId(NotificationRequestId)",
      "java.lang.String NotificationRequestUpdateBuilder.toString()"})
  void testNotificationRequestUpdateBuilderBuild() {
    // Arrange
    NotificationRequestUpdateBuilder deletedResult = NotificationRequestUpdate.builder().deleted(true);
    NotificationRequestId notificationRequestId = new NotificationRequestId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    NotificationRequestUpdate actualBuildResult = deletedResult.notificationRequestId(notificationRequestId).build();

    // Assert
    assertTrue(actualBuildResult.isDeleted());
    assertSame(notificationRequestId, actualBuildResult.getNotificationRequestId());
  }
}
