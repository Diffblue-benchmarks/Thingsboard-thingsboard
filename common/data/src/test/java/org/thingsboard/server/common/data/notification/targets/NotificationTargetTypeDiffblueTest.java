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
import java.util.Set;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;

class NotificationTargetTypeDiffblueTest {
  /**
   * Method under test:
   * {@link NotificationTargetType#forDeliveryMethod(NotificationDeliveryMethod)}
   */
  @Test
  void testForDeliveryMethod() {
    // Arrange, Act and Assert
    assertEquals(NotificationTargetType.PLATFORM_USERS,
        NotificationTargetType.forDeliveryMethod(NotificationDeliveryMethod.WEB));
    assertEquals(NotificationTargetType.SLACK,
        NotificationTargetType.forDeliveryMethod(NotificationDeliveryMethod.SLACK));
  }

  /**
   * Method under test:
   * {@link NotificationTargetType#getSupportedDeliveryMethods()}
   */
  @Test
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
