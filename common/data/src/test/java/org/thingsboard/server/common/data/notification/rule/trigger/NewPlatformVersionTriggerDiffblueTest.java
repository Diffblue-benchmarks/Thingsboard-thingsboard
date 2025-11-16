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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.UpdateMessage;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.trigger.NewPlatformVersionTrigger.NewPlatformVersionTriggerBuilder;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {NewPlatformVersionTriggerBuilder.class})
@ExtendWith(SpringExtension.class)
class NewPlatformVersionTriggerDiffblueTest {
  @Autowired private NewPlatformVersionTriggerBuilder newPlatformVersionTriggerBuilder;

  /**
   * Test {@link NewPlatformVersionTrigger#deduplicate()}.
   *
   * <p>Method under test: {@link NewPlatformVersionTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean NewPlatformVersionTrigger.deduplicate()"})
  void testDeduplicate() {
    // Arrange
    UpdateMessage updateInfo =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Act and Assert
    assertTrue(new NewPlatformVersionTrigger(updateInfo).deduplicate());
  }

  /**
   * Test {@link NewPlatformVersionTrigger#getDeduplicationKey()}.
   *
   * <p>Method under test: {@link NewPlatformVersionTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String NewPlatformVersionTrigger.getDeduplicationKey()"})
  void testGetDeduplicationKey() {
    // Arrange
    UpdateMessage updateInfo =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Act and Assert
    assertEquals(
        "NEW_PLATFORM_VERSION:TENANT:13814000-1dd2-11b2-8080-808080808080:1.0.2:1.0.2",
        new NewPlatformVersionTrigger(updateInfo).getDeduplicationKey());
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}, and {@link
   * NewPlatformVersionTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionTrigger#equals(Object)}
   *   <li>{@link NewPlatformVersionTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionTrigger.equals(Object)",
    "int NewPlatformVersionTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    UpdateMessage updateInfo =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");
    NewPlatformVersionTrigger newPlatformVersionTrigger =
        builderResult.updateInfo(updateInfo).build();

    NewPlatformVersionTriggerBuilder builderResult2 = NewPlatformVersionTrigger.builder();
    UpdateMessage updateInfo2 =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");
    NewPlatformVersionTrigger newPlatformVersionTrigger2 =
        builderResult2.updateInfo(updateInfo2).build();

    // Act and Assert
    assertEquals(newPlatformVersionTrigger, newPlatformVersionTrigger2);
    assertEquals(newPlatformVersionTrigger.hashCode(), newPlatformVersionTrigger2.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}, and {@link
   * NewPlatformVersionTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionTrigger#equals(Object)}
   *   <li>{@link NewPlatformVersionTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionTrigger.equals(Object)",
    "int NewPlatformVersionTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NewPlatformVersionTrigger newPlatformVersionTrigger =
        NewPlatformVersionTrigger.builder().updateInfo(null).build();
    NewPlatformVersionTrigger newPlatformVersionTrigger2 =
        NewPlatformVersionTrigger.builder().updateInfo(null).build();

    // Act and Assert
    assertEquals(newPlatformVersionTrigger, newPlatformVersionTrigger2);
    assertEquals(newPlatformVersionTrigger.hashCode(), newPlatformVersionTrigger2.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}, and {@link
   * NewPlatformVersionTrigger#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionTrigger#equals(Object)}
   *   <li>{@link NewPlatformVersionTrigger#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionTrigger.equals(Object)",
    "int NewPlatformVersionTrigger.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    UpdateMessage updateInfo =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");
    NewPlatformVersionTrigger newPlatformVersionTrigger =
        builderResult.updateInfo(updateInfo).build();

    // Act and Assert
    assertEquals(newPlatformVersionTrigger, newPlatformVersionTrigger);
    int expectedHashCodeResult = newPlatformVersionTrigger.hashCode();
    assertEquals(expectedHashCodeResult, newPlatformVersionTrigger.hashCode());
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionTrigger.equals(Object)",
    "int NewPlatformVersionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    UpdateMessage updateInfo =
        new UpdateMessage(
            false,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");
    NewPlatformVersionTrigger newPlatformVersionTrigger =
        builderResult.updateInfo(updateInfo).build();

    NewPlatformVersionTriggerBuilder builderResult2 = NewPlatformVersionTrigger.builder();
    UpdateMessage updateInfo2 =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Act and Assert
    assertNotEquals(newPlatformVersionTrigger, builderResult2.updateInfo(updateInfo2).build());
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionTrigger.equals(Object)",
    "int NewPlatformVersionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NewPlatformVersionTrigger newPlatformVersionTrigger =
        NewPlatformVersionTrigger.builder().updateInfo(null).build();

    NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    UpdateMessage updateInfo =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Act and Assert
    assertNotEquals(newPlatformVersionTrigger, builderResult.updateInfo(updateInfo).build());
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionTrigger.equals(Object)",
    "int NewPlatformVersionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    UpdateMessage updateInfo =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Act and Assert
    assertNotEquals(builderResult.updateInfo(updateInfo).build(), null);
  }

  /**
   * Test {@link NewPlatformVersionTrigger#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NewPlatformVersionTrigger#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean NewPlatformVersionTrigger.equals(Object)",
    "int NewPlatformVersionTrigger.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NewPlatformVersionTriggerBuilder builderResult = NewPlatformVersionTrigger.builder();
    UpdateMessage updateInfo =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Act and Assert
    assertNotEquals(
        builderResult.updateInfo(updateInfo).build(),
        "Different type to NewPlatformVersionTrigger");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionTrigger#NewPlatformVersionTrigger(UpdateMessage)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NewPlatformVersionTrigger.<init>(UpdateMessage)",
    "long NewPlatformVersionTrigger.getDefaultDeduplicationDuration()",
    "EntityId NewPlatformVersionTrigger.getOriginatorEntityId()",
    "TenantId NewPlatformVersionTrigger.getTenantId()",
    "NotificationRuleTriggerType NewPlatformVersionTrigger.getType()",
    "UpdateMessage NewPlatformVersionTrigger.getUpdateInfo()",
    "String NewPlatformVersionTrigger.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    UpdateMessage updateInfo =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");

    // Act
    NewPlatformVersionTrigger actualNewPlatformVersionTrigger =
        new NewPlatformVersionTrigger(updateInfo);
    String actualToStringResult = actualNewPlatformVersionTrigger.toString();
    long actualDefaultDeduplicationDuration =
        actualNewPlatformVersionTrigger.getDefaultDeduplicationDuration();
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
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test NewPlatformVersionTriggerBuilder {@link NewPlatformVersionTriggerBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NewPlatformVersionTriggerBuilder#build()}
   *   <li>{@link NewPlatformVersionTriggerBuilder#updateInfo(UpdateMessage)}
   * </ul>
   */
  @Test
  @DisplayName("Test NewPlatformVersionTriggerBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void NewPlatformVersionTriggerBuilder.<init>()",
    "NewPlatformVersionTrigger NewPlatformVersionTriggerBuilder.build()",
    "String NewPlatformVersionTriggerBuilder.toString()",
    "NewPlatformVersionTriggerBuilder NewPlatformVersionTriggerBuilder.updateInfo(UpdateMessage)"
  })
  void testNewPlatformVersionTriggerBuilderBuild() {
    // Arrange and Act
    NewPlatformVersionTriggerBuilder actualBuilderResult = NewPlatformVersionTrigger.builder();
    UpdateMessage updateInfo =
        new UpdateMessage(
            true,
            "1.0.2",
            "1.0.2",
            "https://example.org/example",
            "https://example.org/example",
            "https://example.org/example");
    NewPlatformVersionTrigger actualNewPlatformVersionTrigger =
        actualBuilderResult.updateInfo(updateInfo).build();

    // Assert
    EntityId originatorEntityId = actualNewPlatformVersionTrigger.getOriginatorEntityId();
    assertTrue(originatorEntityId instanceof TenantId);
    assertEquals(
        "NEW_PLATFORM_VERSION:TENANT:13814000-1dd2-11b2-8080-808080808080:1.0.2:1.0.2",
        actualNewPlatformVersionTrigger.getDeduplicationKey());
    assertEquals(0L, actualNewPlatformVersionTrigger.getDefaultDeduplicationDuration());
    assertEquals(
        NotificationRuleTriggerType.NEW_PLATFORM_VERSION,
        actualNewPlatformVersionTrigger.getType());
    assertTrue(actualNewPlatformVersionTrigger.deduplicate());
    assertSame(updateInfo, actualNewPlatformVersionTrigger.getUpdateInfo());
    assertSame(originatorEntityId, actualNewPlatformVersionTrigger.getTenantId());
  }
}
