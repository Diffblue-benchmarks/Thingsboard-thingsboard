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
package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;

class TenantRoutingInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TenantRoutingInfo#equals(Object)}
   *   <li>{@link TenantRoutingInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(null, null, true);
    TenantRoutingInfo tenantRoutingInfo2 = new TenantRoutingInfo(null, null, true);

    // Act and Assert
    assertEquals(tenantRoutingInfo, tenantRoutingInfo2);
    int expectedHashCodeResult = tenantRoutingInfo.hashCode();
    assertEquals(expectedHashCodeResult, tenantRoutingInfo2.hashCode());
  }

  /**
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(new TenantId(UUID.randomUUID()),
        mock(TenantProfileId.class), true);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true));
  }

  /**
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantRoutingInfo(new TenantId(UUID.randomUUID()), mock(TenantProfileId.class), true), "42");
  }

  /**
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(null, mock(TenantProfileId.class), true);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true));
  }

  /**
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(new TenantId(UUID.randomUUID()),
        mock(TenantProfileId.class), false);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(new TenantId(UUID.randomUUID()), null, true));
  }

  /**
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(null, mock(TenantProfileId.class), true);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(null, null, true));
  }

  /**
   * Method under test: {@link TenantRoutingInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    TenantRoutingInfo tenantRoutingInfo = new TenantRoutingInfo(null, null, true);

    // Act and Assert
    assertNotEquals(tenantRoutingInfo, new TenantRoutingInfo(null, new TenantProfileId(UUID.randomUUID()), true));
  }
}
