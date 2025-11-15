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
package org.thingsboard.server.common.data.notification.targets.platform;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.targets.NotificationTargetType;

class PlatformUsersNotificationTargetConfigDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformUsersNotificationTargetConfig#equals(Object)}
   *   <li>{@link PlatformUsersNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(null);

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig2 = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig2.setUsersFilter(null);

    // Act and Assert
    assertEquals(platformUsersNotificationTargetConfig, platformUsersNotificationTargetConfig2);
    int expectedHashCodeResult = platformUsersNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, platformUsersNotificationTargetConfig2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link PlatformUsersNotificationTargetConfig#equals(Object)}
   *   <li>{@link PlatformUsersNotificationTargetConfig#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertEquals(platformUsersNotificationTargetConfig, platformUsersNotificationTargetConfig);
    int expectedHashCodeResult = platformUsersNotificationTargetConfig.hashCode();
    assertEquals(expectedHashCodeResult, platformUsersNotificationTargetConfig.hashCode());
  }

  /**
   * Method under test:
   * {@link PlatformUsersNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig2 = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig2.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertNotEquals(platformUsersNotificationTargetConfig, platformUsersNotificationTargetConfig2);
  }

  /**
   * Method under test:
   * {@link PlatformUsersNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("Description");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig2 = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig2.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertNotEquals(platformUsersNotificationTargetConfig, platformUsersNotificationTargetConfig2);
  }

  /**
   * Method under test:
   * {@link PlatformUsersNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(null);

    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig2 = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig2.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig2.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertNotEquals(platformUsersNotificationTargetConfig, platformUsersNotificationTargetConfig2);
  }

  /**
   * Method under test:
   * {@link PlatformUsersNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertNotEquals(platformUsersNotificationTargetConfig, null);
  }

  /**
   * Method under test:
   * {@link PlatformUsersNotificationTargetConfig#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    PlatformUsersNotificationTargetConfig platformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    platformUsersNotificationTargetConfig.setDescription("The characteristics of someone or something");
    platformUsersNotificationTargetConfig.setUsersFilter(mock(UsersFilter.class));

    // Act and Assert
    assertNotEquals(platformUsersNotificationTargetConfig, "Different type to PlatformUsersNotificationTargetConfig");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>default or parameterless constructor of
   * {@link PlatformUsersNotificationTargetConfig}
   *   <li>{@link PlatformUsersNotificationTargetConfig#setUsersFilter(UsersFilter)}
   *   <li>{@link PlatformUsersNotificationTargetConfig#toString()}
   *   <li>{@link PlatformUsersNotificationTargetConfig#getType()}
   *   <li>{@link PlatformUsersNotificationTargetConfig#getUsersFilter()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    PlatformUsersNotificationTargetConfig actualPlatformUsersNotificationTargetConfig = new PlatformUsersNotificationTargetConfig();
    UsersFilter usersFilter = mock(UsersFilter.class);
    actualPlatformUsersNotificationTargetConfig.setUsersFilter(usersFilter);
    actualPlatformUsersNotificationTargetConfig.toString();
    NotificationTargetType actualType = actualPlatformUsersNotificationTargetConfig.getType();

    // Assert that nothing has changed
    assertEquals(NotificationTargetType.PLATFORM_USERS, actualType);
    assertSame(usersFilter, actualPlatformUsersNotificationTargetConfig.getUsersFilter());
  }
}
