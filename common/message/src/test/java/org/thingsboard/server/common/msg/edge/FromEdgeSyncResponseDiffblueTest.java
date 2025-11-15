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
package org.thingsboard.server.common.msg.edge;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;

class FromEdgeSyncResponseDiffblueTest {
  /**
   * Method under test: {@link FromEdgeSyncResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID id = UUID.randomUUID();
    FromEdgeSyncResponse fromEdgeSyncResponse = new FromEdgeSyncResponse(id, new TenantId(UUID.randomUUID()),
        mock(EdgeId.class), true, "An error occurred");
    UUID id2 = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(fromEdgeSyncResponse,
        new FromEdgeSyncResponse(id2, new TenantId(UUID.randomUUID()), null, true, "An error occurred"));
  }

  /**
   * Method under test: {@link FromEdgeSyncResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    UUID id = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(
        new FromEdgeSyncResponse(id, new TenantId(UUID.randomUUID()), mock(EdgeId.class), true, "An error occurred"),
        "42");
  }

  /**
   * Method under test: {@link FromEdgeSyncResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    FromEdgeSyncResponse fromEdgeSyncResponse = new FromEdgeSyncResponse(null, new TenantId(UUID.randomUUID()),
        mock(EdgeId.class), true, "An error occurred");
    UUID id = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(fromEdgeSyncResponse,
        new FromEdgeSyncResponse(id, new TenantId(UUID.randomUUID()), null, true, "An error occurred"));
  }

  /**
   * Method under test: {@link FromEdgeSyncResponse#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    UUID id = UUID.randomUUID();
    FromEdgeSyncResponse fromEdgeSyncResponse = new FromEdgeSyncResponse(id, new TenantId(UUID.randomUUID()),
        mock(EdgeId.class), false, "An error occurred");
    UUID id2 = UUID.randomUUID();

    // Act and Assert
    assertNotEquals(fromEdgeSyncResponse,
        new FromEdgeSyncResponse(id2, new TenantId(UUID.randomUUID()), null, true, "An error occurred"));
  }
}
