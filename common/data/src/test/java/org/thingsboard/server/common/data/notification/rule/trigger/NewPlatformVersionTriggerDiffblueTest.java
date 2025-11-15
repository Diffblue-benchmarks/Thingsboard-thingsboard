/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.UpdateMessage;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

class NewPlatformVersionTriggerDiffblueTest {
  /**
   * Method under test: {@link NewPlatformVersionTrigger#deduplicate()}
   */
  @Test
  void testDeduplicate() {
    // Arrange, Act and Assert
    assertTrue((new NewPlatformVersionTrigger(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
        "https://example.org/example", "https://example.org/example"))).deduplicate());
  }

  /**
   * Method under test: {@link NewPlatformVersionTrigger#getDeduplicationKey()}
   */
  @Test
  void testGetDeduplicationKey() {
    // Arrange, Act and Assert
    assertEquals("NEW_PLATFORM_VERSION:TENANT:13814000-1dd2-11b2-8080-808080808080:1.0.2:1.0.2",
        (new NewPlatformVersionTrigger(new UpdateMessage(true, "1.0.2", "1.0.2", "https://example.org/example",
            "https://example.org/example", "https://example.org/example"))).getDeduplicationKey());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NewPlatformVersionTrigger#equals(Object)}
   *   <li>{@link NewPlatformVersionTrigger#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link NewPlatformVersionTrigger#equals(Object)}
   *   <li>{@link NewPlatformVersionTrigger#hashCode()}
   * </ul>
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>{@link NewPlatformVersionTrigger#equals(Object)}
   *   <li>{@link NewPlatformVersionTrigger#hashCode()}
   * </ul>
   */
  @Test
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
   * Method under test: {@link NewPlatformVersionTrigger#equals(Object)}
   */
  @Test
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
   * Method under test: {@link NewPlatformVersionTrigger#equals(Object)}
   */
  @Test
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
   * Method under test: {@link NewPlatformVersionTrigger#equals(Object)}
   */
  @Test
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
   * Method under test: {@link NewPlatformVersionTrigger#equals(Object)}
   */
  @Test
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
   * Methods under test:
   * <ul>
   *   <li>
   * {@link NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder#build()}
   *   <li>
   * {@link NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder#updateInfo(UpdateMessage)}
   * </ul>
   */
  @Test
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
