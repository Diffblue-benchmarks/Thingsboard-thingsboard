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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeCommunicationFailureTriggerDiffblueTest {
  /**
   * Test {@link EdgeCommunicationFailureTrigger#deduplicate()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCommunicationFailureTrigger#deduplicate()}
   */
  @Test
  @DisplayName("Test deduplicate(); then return 'true'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean EdgeCommunicationFailureTrigger.deduplicate()"})
  void testDeduplicate_thenReturnTrue() {
    // Arrange
    EdgeCommunicationFailureTrigger edgeCommunicationFailureTrigger =
        new EdgeCommunicationFailureTrigger(
            TenantId.SYS_TENANT_ID,
            new CustomerId(EntityId.NULL_UUID),
            null,
            "Edge Name",
            "Failure Msg",
            "An error occurred");

    // Act and Assert
    assertTrue(edgeCommunicationFailureTrigger.deduplicate());
  }

  /**
   * Test {@link EdgeCommunicationFailureTrigger#getDeduplicationKey()}.
   *
   * <p>Method under test: {@link EdgeCommunicationFailureTrigger#getDeduplicationKey()}
   */
  @Test
  @DisplayName("Test getDeduplicationKey()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.String EdgeCommunicationFailureTrigger.getDeduplicationKey()"})
  void testGetDeduplicationKey() {
    // Arrange
    CustomerId customerId = new CustomerId(EntityId.NULL_UUID);
    EdgeCommunicationFailureTrigger edgeCommunicationFailureTrigger =
        new EdgeCommunicationFailureTrigger(
            TenantId.SYS_TENANT_ID,
            customerId,
            new EdgeId(EntityId.NULL_UUID),
            "Edge Name",
            "Failure Msg",
            "An error occurred");

    // Act and Assert
    assertEquals(
        "EDGE_COMMUNICATION_FAILURE:EDGE:13814000-1dd2-11b2-8080-808080808080:An error occurred",
        edgeCommunicationFailureTrigger.getDeduplicationKey());
  }

  /**
   * Test {@link EdgeCommunicationFailureTrigger#getDefaultDeduplicationDuration()}.
   *
   * <ul>
   *   <li>Then return {@code 1800000}.
   * </ul>
   *
   * <p>Method under test: {@link EdgeCommunicationFailureTrigger#getDefaultDeduplicationDuration()}
   */
  @Test
  @DisplayName("Test getDefaultDeduplicationDuration(); then return '1800000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long EdgeCommunicationFailureTrigger.getDefaultDeduplicationDuration()"})
  void testGetDefaultDeduplicationDuration_thenReturn1800000() {
    // Arrange
    EdgeCommunicationFailureTrigger edgeCommunicationFailureTrigger =
        new EdgeCommunicationFailureTrigger(
            TenantId.SYS_TENANT_ID,
            new CustomerId(EntityId.NULL_UUID),
            null,
            "Edge Name",
            "Failure Msg",
            "An error occurred");

    // Act and Assert
    assertEquals(1800000L, edgeCommunicationFailureTrigger.getDefaultDeduplicationDuration());
  }
}
