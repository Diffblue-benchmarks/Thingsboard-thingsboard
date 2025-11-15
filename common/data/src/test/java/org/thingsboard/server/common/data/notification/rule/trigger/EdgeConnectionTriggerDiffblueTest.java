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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeConnectionTriggerDiffblueTest {
  /**
   * Test {@link EdgeConnectionTrigger#deduplicate()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeConnectionTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate(); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeConnectionTrigger.deduplicate()"})
  void testDeduplicate_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(
        (new EdgeConnectionTrigger(TenantId.SYS_TENANT_ID, new CustomerId(EntityId.NULL_UUID), null, true, "Edge Name"))
            .deduplicate());
  }

  /**
   * Test {@link EdgeConnectionTrigger#getDeduplicationKey()}.
   * <p>
   * Method under test: {@link EdgeConnectionTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String EdgeConnectionTrigger.getDeduplicationKey()"})
  void testGetDeduplicationKey() {
    // Arrange
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);

    // Act and Assert
    assertEquals("EDGE_CONNECTION:EDGE:13814000-1dd2-11b2-8080-808080808080:true",
        (new EdgeConnectionTrigger(TenantId.SYS_TENANT_ID, customerId, new EdgeId(EntityId.NULL_UUID), true,
            "Edge Name")).getDeduplicationKey());
  }

  /**
   * Test {@link EdgeConnectionTrigger#getDefaultDeduplicationDuration()}.
   * <ul>
   *   <li>Then return {@code 60000}.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeConnectionTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration(); then return '60000'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long EdgeConnectionTrigger.getDefaultDeduplicationDuration()"})
  void testGetDefaultDeduplicationDuration_thenReturn60000() {
    // Arrange, Act and Assert
    assertEquals(60000L,
        (new EdgeConnectionTrigger(TenantId.SYS_TENANT_ID, new CustomerId(EntityId.NULL_UUID), null, true, "Edge Name"))
            .getDefaultDeduplicationDuration());
  }
}
