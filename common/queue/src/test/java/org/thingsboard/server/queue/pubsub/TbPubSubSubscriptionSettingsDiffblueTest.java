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
package org.thingsboard.server.queue.pubsub;

import static org.junit.jupiter.api.Assertions.assertNull;
import java.util.Map;
import org.junit.jupiter.api.Test;

class TbPubSubSubscriptionSettingsDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link TbPubSubSubscriptionSettings#getCoreSettings()}
   *   <li>{@link TbPubSubSubscriptionSettings#getEdgeSettings()}
   *   <li>{@link TbPubSubSubscriptionSettings#getJsExecutorSettings()}
   *   <li>{@link TbPubSubSubscriptionSettings#getNotificationsSettings()}
   *   <li>{@link TbPubSubSubscriptionSettings#getRuleEngineSettings()}
   *   <li>{@link TbPubSubSubscriptionSettings#getTransportApiSettings()}
   *   <li>{@link TbPubSubSubscriptionSettings#getVcSettings()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbPubSubSubscriptionSettings tbPubSubSubscriptionSettings = new TbPubSubSubscriptionSettings();

    // Act
    Map<String, String> actualCoreSettings = tbPubSubSubscriptionSettings.getCoreSettings();
    Map<String, String> actualEdgeSettings = tbPubSubSubscriptionSettings.getEdgeSettings();
    Map<String, String> actualJsExecutorSettings = tbPubSubSubscriptionSettings.getJsExecutorSettings();
    Map<String, String> actualNotificationsSettings = tbPubSubSubscriptionSettings.getNotificationsSettings();
    Map<String, String> actualRuleEngineSettings = tbPubSubSubscriptionSettings.getRuleEngineSettings();
    Map<String, String> actualTransportApiSettings = tbPubSubSubscriptionSettings.getTransportApiSettings();

    // Assert
    assertNull(actualCoreSettings);
    assertNull(actualEdgeSettings);
    assertNull(actualJsExecutorSettings);
    assertNull(actualNotificationsSettings);
    assertNull(actualRuleEngineSettings);
    assertNull(actualTransportApiSettings);
    assertNull(tbPubSubSubscriptionSettings.getVcSettings());
  }
}
