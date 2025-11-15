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
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class NotificationTargetTypeDiffblueTest {
  /**
   * Test {@link NotificationTargetType#forDeliveryMethod(NotificationDeliveryMethod)}.
   * <ul>
   *   <li>When {@code SLACK}.</li>
   *   <li>Then return {@code SLACK}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetType#forDeliveryMethod(NotificationDeliveryMethod)}
   */
  @Test
  @DisplayName("Test forDeliveryMethod(NotificationDeliveryMethod); when 'SLACK'; then return 'SLACK'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTargetType NotificationTargetType.forDeliveryMethod(NotificationDeliveryMethod)"})
  void testForDeliveryMethod_whenSlack_thenReturnSlack() {
    // Arrange, Act and Assert
    assertEquals(NotificationTargetType.SLACK,
        NotificationTargetType.forDeliveryMethod(NotificationDeliveryMethod.SLACK));
  }

  /**
   * Test {@link NotificationTargetType#forDeliveryMethod(NotificationDeliveryMethod)}.
   * <ul>
   *   <li>When {@code WEB}.</li>
   *   <li>Then return {@code PLATFORM_USERS}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetType#forDeliveryMethod(NotificationDeliveryMethod)}
   */
  @Test
  @DisplayName("Test forDeliveryMethod(NotificationDeliveryMethod); when 'WEB'; then return 'PLATFORM_USERS'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"NotificationTargetType NotificationTargetType.forDeliveryMethod(NotificationDeliveryMethod)"})
  void testForDeliveryMethod_whenWeb_thenReturnPlatformUsers() {
    // Arrange, Act and Assert
    assertEquals(NotificationTargetType.PLATFORM_USERS,
        NotificationTargetType.forDeliveryMethod(NotificationDeliveryMethod.WEB));
  }

  /**
   * Test {@link NotificationTargetType#getSupportedDeliveryMethods()}.
   * <p>
   * Method under test: {@link NotificationTargetType#getSupportedDeliveryMethods()}
   */
  @Test
  @DisplayName("Test getSupportedDeliveryMethods()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Set NotificationTargetType.getSupportedDeliveryMethods()"})
  void testGetSupportedDeliveryMethods() {
    // Arrange and Act
    Set<NotificationDeliveryMethod> actualSupportedDeliveryMethods = NotificationTargetType.valueOf("PLATFORM_USERS")
        .getSupportedDeliveryMethods();

    // Assert
    assertEquals(4, actualSupportedDeliveryMethods.size());
    assertTrue(actualSupportedDeliveryMethods.contains(NotificationDeliveryMethod.EMAIL));
    assertTrue(actualSupportedDeliveryMethods.contains(NotificationDeliveryMethod.MOBILE_APP));
    assertTrue(actualSupportedDeliveryMethods.contains(NotificationDeliveryMethod.SMS));
    assertTrue(actualSupportedDeliveryMethods.contains(NotificationDeliveryMethod.WEB));
  }
}
