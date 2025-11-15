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
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeConnectionTriggerDiffblueTest {
  /**
   * Method under test: {@link EdgeConnectionTrigger#deduplicate()}
   */
  @Test
  void testDeduplicate() {
    // Arrange, Act and Assert
    assertTrue(
        (new EdgeConnectionTrigger(TenantId.SYS_TENANT_ID, new CustomerId(EntityId.NULL_UUID), null, true, "Edge Name"))
            .deduplicate());
  }

  /**
   * Method under test: {@link EdgeConnectionTrigger#getDeduplicationKey()}
   */
  @Test
  void testGetDeduplicationKey() {
    // Arrange
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);

    // Act and Assert
    assertEquals("EDGE_CONNECTION:EDGE:13814000-1dd2-11b2-8080-808080808080:true",
        (new EdgeConnectionTrigger(TenantId.SYS_TENANT_ID, customerId, new EdgeId(EntityId.NULL_UUID), true,
            "Edge Name")).getDeduplicationKey());
  }

  /**
   * Method under test:
   * {@link EdgeConnectionTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  void testGetDefaultDeduplicationDuration() {
    // Arrange, Act and Assert
    assertEquals(60000L,
        (new EdgeConnectionTrigger(TenantId.SYS_TENANT_ID, new CustomerId(EntityId.NULL_UUID), null, true, "Edge Name"))
            .getDefaultDeduplicationDuration());
  }
}
