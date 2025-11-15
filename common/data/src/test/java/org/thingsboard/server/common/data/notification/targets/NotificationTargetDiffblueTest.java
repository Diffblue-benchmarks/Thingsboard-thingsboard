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
package org.thingsboard.server.common.data.notification.targets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.targets.platform.PlatformUsersNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.platform.UsersFilter;

class NotificationTargetDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#equals(Object)}
   *   <li>{@link NotificationTarget#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    NotificationTarget notificationTarget2 = new NotificationTarget();

    // Act and Assert
    assertEquals(notificationTarget, notificationTarget2);
    int expectedHashCodeResult = notificationTarget.hashCode();
    assertEquals(expectedHashCodeResult, notificationTarget2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#equals(Object)}
   *   <li>{@link NotificationTarget#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setTenantId(TenantId.SYS_TENANT_ID);

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(notificationTarget, notificationTarget2);
    int expectedHashCodeResult = notificationTarget.hashCode();
    assertEquals(expectedHashCodeResult, notificationTarget2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#equals(Object)}
   *   <li>{@link NotificationTarget#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setName("Name");

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setName("Name");

    // Act and Assert
    assertEquals(notificationTarget, notificationTarget2);
    int expectedHashCodeResult = notificationTarget.hashCode();
    assertEquals(expectedHashCodeResult, notificationTarget2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#equals(Object)}
   *   <li>{@link NotificationTarget#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());

    // Act and Assert
    assertEquals(notificationTarget, notificationTarget2);
    int expectedHashCodeResult = notificationTarget.hashCode();
    assertEquals(expectedHashCodeResult, notificationTarget2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#equals(Object)}
   *   <li>{@link NotificationTarget#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setExternalId(new NotificationTargetId(EntityId.NULL_UUID));

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setExternalId(new NotificationTargetId(EntityId.NULL_UUID));

    // Act and Assert
    assertEquals(notificationTarget, notificationTarget2);
    int expectedHashCodeResult = notificationTarget.hashCode();
    assertEquals(expectedHashCodeResult, notificationTarget2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#equals(Object)}
   *   <li>{@link NotificationTarget#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();

    // Act and Assert
    assertEquals(notificationTarget, notificationTarget);
    int expectedHashCodeResult = notificationTarget.hashCode();
    assertEquals(expectedHashCodeResult, notificationTarget.hashCode());
  }

  /**
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTarget(), 1);
    assertNotEquals(new NotificationTarget(), mock(AdminSettings.class));
  }

  /**
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(notificationTarget, new NotificationTarget());
  }

  /**
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setName("Name");

    // Act and Assert
    assertNotEquals(notificationTarget, new NotificationTarget());
  }

  /**
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());

    // Act and Assert
    assertNotEquals(notificationTarget, new NotificationTarget());
  }

  /**
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setExternalId(new NotificationTargetId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(notificationTarget, new NotificationTarget());
  }

  /**
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(notificationTarget, new NotificationTarget());
  }

  /**
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(notificationTarget, notificationTarget2);
  }

  /**
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setName("Name");

    // Act and Assert
    assertNotEquals(notificationTarget, notificationTarget2);
  }

  /**
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());

    // Act and Assert
    assertNotEquals(notificationTarget, notificationTarget2);
  }

  /**
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();

    NotificationTarget notificationTarget2 = new NotificationTarget();
    notificationTarget2.setExternalId(new NotificationTargetId(EntityId.NULL_UUID));

    // Act and Assert
    assertNotEquals(notificationTarget, notificationTarget2);
  }

  /**
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTarget(), null);
  }

  /**
   * Method under test: {@link NotificationTarget#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new NotificationTarget(), "Different type to NotificationTarget");
  }

  /**
   * Method under test: {@link NotificationTarget#getExternalId()}
   */
  @Test
  void testGetExternalId() {
    // Arrange, Act and Assert
    assertNull((new NotificationTarget()).getExternalId());
  }

  /**
   * Method under test: {@link NotificationTarget#getExternalId()}
   */
  @Test
  void testGetExternalId2() {
    // Arrange
    PlatformUsersNotificationTargetConfig configuration = new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(mock(UsersFilter.class));

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    assertNull(notificationTarget.getExternalId());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTarget#NotificationTarget()}
   *   <li>{@link NotificationTarget#setConfiguration(NotificationTargetConfig)}
   *   <li>{@link NotificationTarget#setExternalId(NotificationTargetId)}
   *   <li>{@link NotificationTarget#setName(String)}
   *   <li>{@link NotificationTarget#setTenantId(TenantId)}
   *   <li>{@link NotificationTarget#toString()}
   *   <li>{@link NotificationTarget#getConfiguration()}
   *   <li>{@link NotificationTarget#getName()}
   *   <li>{@link NotificationTarget#getTenantId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    NotificationTarget actualNotificationTarget = new NotificationTarget();
    MicrosoftTeamsNotificationTargetConfig configuration = new MicrosoftTeamsNotificationTargetConfig();
    actualNotificationTarget.setConfiguration(configuration);
    NotificationTargetId externalId = new NotificationTargetId(EntityId.NULL_UUID);
    actualNotificationTarget.setExternalId(externalId);
    actualNotificationTarget.setName("Name");
    actualNotificationTarget.setTenantId(TenantId.SYS_TENANT_ID);
    String actualToStringResult = actualNotificationTarget.toString();
    NotificationTargetConfig actualConfiguration = actualNotificationTarget.getConfiguration();
    String actualName = actualNotificationTarget.getName();
    TenantId actualTenantId = actualNotificationTarget.getTenantId();

    // Assert that nothing has changed
    assertEquals("Name", actualName);
    assertEquals("NotificationTarget(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, configuration=Microsoft"
        + "TeamsNotificationTargetConfig(webhookUrl=null, channelName=null, useOldApi=true), externalId=13814000"
        + "-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals(0L, actualNotificationTarget.getCreatedTime());
    assertSame(externalId, actualNotificationTarget.getExternalId());
    assertSame(configuration, actualConfiguration);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }

  /**
   * Method under test:
   * {@link NotificationTarget#NotificationTarget(NotificationTarget)}
   */
  @Test
  void testNewNotificationTarget() {
    // Arrange
    NotificationTarget other = new NotificationTarget();

    // Act and Assert
    assertEquals(other, new NotificationTarget(other));
  }

  /**
   * Method under test:
   * {@link NotificationTarget#NotificationTarget(NotificationTarget)}
   */
  @Test
  void testNewNotificationTarget2() {
    // Arrange
    PlatformUsersNotificationTargetConfig configuration = new PlatformUsersNotificationTargetConfig();
    configuration.setDescription("The characteristics of someone or something");
    configuration.setUsersFilter(mock(UsersFilter.class));

    NotificationTarget other = new NotificationTarget();
    other.setConfiguration(configuration);

    // Act and Assert
    assertEquals(other, new NotificationTarget(other));
  }
}
