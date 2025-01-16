package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.UpdateMessage;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class NewPlatformVersionTriggerDiffblueTest {
  /**
   * Test {@link NewPlatformVersionTrigger#deduplicate()}.
   * <p>
   * Method under test: {@link NewPlatformVersionTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate()")
  void testDeduplicate() {
    // Arrange, Act and Assert
    assertTrue((new NewPlatformVersionTrigger(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"))).deduplicate());
  }

  /**
   * Test {@link NewPlatformVersionTrigger#getDeduplicationKey()}.
   * <p>
   * Method under test: {@link NewPlatformVersionTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  void testGetDeduplicationKey() {
    // Arrange, Act and Assert
    assertEquals("NEW_PLATFORM_VERSION:TENANT:13814000-1dd2-11b2-8080-808080808080:1.0.2:1.0.2",
        (new NewPlatformVersionTrigger(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))).getDeduplicationKey());
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}, and
   * {@link NewPlatformVersionTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NewPlatformVersionTrigger#equals(Object)}
   *   <li>{@link NewPlatformVersionTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    NewPlatformVersionTrigger buildResult = builderResult
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder builderResult2 = NewPlatformVersionTrigger.builder();
    NewPlatformVersionTrigger buildResult2 = builderResult2
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}, and
   * {@link NewPlatformVersionTrigger#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NewPlatformVersionTrigger#equals(Object)}
   *   <li>{@link NewPlatformVersionTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder newPlatformVersionTriggerBuilder = mock(
        NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder.class);
    when(newPlatformVersionTriggerBuilder.updateInfo(Mockito.<UpdateMessage>any()))
        .thenReturn(NewPlatformVersionTrigger.builder());
    NewPlatformVersionTrigger buildResult = newPlatformVersionTriggerBuilder
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder newPlatformVersionTriggerBuilder2 = mock(
        NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder.class);
    when(newPlatformVersionTriggerBuilder2.updateInfo(Mockito.<UpdateMessage>any()))
        .thenReturn(NewPlatformVersionTrigger.builder());
    NewPlatformVersionTrigger buildResult2 = newPlatformVersionTriggerBuilder2
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}, and
   * {@link NewPlatformVersionTrigger#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NewPlatformVersionTrigger#equals(Object)}
   *   <li>{@link NewPlatformVersionTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    NewPlatformVersionTrigger buildResult = builderResult
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NewPlatformVersionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder newPlatformVersionTriggerBuilder = mock(
        NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder.class);
    when(newPlatformVersionTriggerBuilder.updateInfo(Mockito.<UpdateMessage>any()))
        .thenReturn(NewPlatformVersionTrigger.builder());
    NewPlatformVersionTrigger buildResult = newPlatformVersionTriggerBuilder
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    NewPlatformVersionTrigger buildResult2 = builderResult
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NewPlatformVersionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder newPlatformVersionTriggerBuilder = mock(
        NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder.class);
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    NewPlatformVersionTrigger buildResult = builderResult
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();
    when(newPlatformVersionTriggerBuilder.build()).thenReturn(buildResult);
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder newPlatformVersionTriggerBuilder2 = mock(
        NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder.class);
    when(newPlatformVersionTriggerBuilder2.updateInfo(Mockito.<UpdateMessage>any()))
        .thenReturn(newPlatformVersionTriggerBuilder);
    NewPlatformVersionTrigger buildResult2 = newPlatformVersionTriggerBuilder2
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder newPlatformVersionTriggerBuilder3 = mock(
        NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder.class);
    when(newPlatformVersionTriggerBuilder3.updateInfo(Mockito.<UpdateMessage>any()))
        .thenReturn(NewPlatformVersionTrigger.builder());
    NewPlatformVersionTrigger buildResult3 = newPlatformVersionTriggerBuilder3
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NewPlatformVersionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    NewPlatformVersionTrigger buildResult = builderResult
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NewPlatformVersionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    NewPlatformVersionTrigger buildResult = builderResult
        .updateInfo(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to NewPlatformVersionTrigger");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link NewPlatformVersionTrigger#NewPlatformVersionTrigger(UpdateMessage)}
   *   <li>{@link NewPlatformVersionTrigger#toString()}
   *   <li>{@link NewPlatformVersionTrigger#getDefaultDeduplicationDuration()}
   *   <li>{@link NewPlatformVersionTrigger#getOriginatorEntityId()}
   *   <li>{@link NewPlatformVersionTrigger#getTenantId()}
   *   <li>{@link NewPlatformVersionTrigger#getType()}
   *   <li>{@link NewPlatformVersionTrigger#getUpdateInfo()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    UpdateMessage updateInfo = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    // Act
    NewPlatformVersionTrigger actualNewPlatformVersionTrigger = new NewPlatformVersionTrigger(updateInfo);
    String actualToStringResult = actualNewPlatformVersionTrigger.toString();
    long actualDefaultDeduplicationDuration = actualNewPlatformVersionTrigger.getDefaultDeduplicationDuration();
    EntityId actualOriginatorEntityId = actualNewPlatformVersionTrigger.getOriginatorEntityId();
    TenantId actualTenantId = actualNewPlatformVersionTrigger.getTenantId();
    NotificationRuleTriggerType actualType = actualNewPlatformVersionTrigger.getType();

    // Assert
    assertEquals(
        "NewPlatformVersionTrigger(updateInfo=UpdateMessage(updateAvailable=true, currentVersion=1.0.2,"
            + " latestVersion=1.0.2, upgradeInstructionsUrl=https://example.org/example, currentVersionReleaseNotesUrl"
            + "=https://example.org/example, latestVersionReleaseNotesUrl=https://example.org/example))",
        actualToStringResult);
    assertEquals(0L, actualDefaultDeduplicationDuration);
    assertEquals(NotificationRuleTriggerType.NEW_PLATFORM_VERSION, actualType);
    assertSame(updateInfo, actualNewPlatformVersionTrigger.getUpdateInfo());
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test NewPlatformVersionTriggerBuilder
   * {@link NewPlatformVersionTriggerBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder#build()}
   *   <li>
   * {@link NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder#updateInfo(UpdateMessage)}
   * </ul>
   */
  @Test
  @DisplayName("Test NewPlatformVersionTriggerBuilder build()")
  void testNewPlatformVersionTriggerBuilderBuild() {
    // Arrange
    NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    UpdateMessage updateInfo = new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example");

    // Act
    NewPlatformVersionTrigger actualBuildResult = builderResult.updateInfo(updateInfo).build();

    // Assert
    EntityId originatorEntityId = actualBuildResult.getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof TenantId);
    assertEquals("NEW_PLATFORM_VERSION:TENANT:13814000-1dd2-11b2-8080-808080808080:1.0.2:1.0.2",
        actualBuildResult.getDeduplicationKey());
    assertEquals(0L, actualBuildResult.getDefaultDeduplicationDuration());
    assertEquals(NotificationRuleTriggerType.NEW_PLATFORM_VERSION, actualBuildResult.getType());
    assertTrue(actualBuildResult.deduplicate());
    assertSame(updateInfo, actualBuildResult.getUpdateInfo());
    assertSame(originatorEntityId, actualBuildResult.getTenantId());
  }
}
