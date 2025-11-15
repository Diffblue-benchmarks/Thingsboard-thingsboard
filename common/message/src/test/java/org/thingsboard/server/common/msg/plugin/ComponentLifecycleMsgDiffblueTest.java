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
package org.thingsboard.server.common.msg.plugin;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;

class ComponentLifecycleMsgDiffblueTest {
  /**
   * Method under test: {@link ComponentLifecycleMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ComponentLifecycleMsg componentLifecycleMsg = new ComponentLifecycleMsg(new TenantId(UUID.randomUUID()),
        mock(AlarmId.class), ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(componentLifecycleMsg,
        new ComponentLifecycleMsg(new TenantId(UUID.randomUUID()), null, ComponentLifecycleEvent.CREATED));
  }

  /**
   * Method under test: {@link ComponentLifecycleMsg#getRuleChainId()}
   */
  @Test
  void testGetRuleChainId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertFalse((new ComponentLifecycleMsg(tenantId, new AlarmId(UUID.randomUUID()), ComponentLifecycleEvent.CREATED))
        .getRuleChainId()
        .isPresent());
  }

  /**
   * Method under test: {@link ComponentLifecycleMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new ComponentLifecycleMsg(new TenantId(UUID.randomUUID()), mock(AlarmId.class),
        ComponentLifecycleEvent.CREATED), "42");
  }

  /**
   * Method under test: {@link ComponentLifecycleMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ComponentLifecycleMsg componentLifecycleMsg = new ComponentLifecycleMsg(null, mock(AlarmId.class),
        ComponentLifecycleEvent.CREATED);

    // Act and Assert
    assertNotEquals(componentLifecycleMsg,
        new ComponentLifecycleMsg(new TenantId(UUID.randomUUID()), null, ComponentLifecycleEvent.CREATED));
  }
}
