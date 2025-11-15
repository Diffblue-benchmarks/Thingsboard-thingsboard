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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import java.util.UUID;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeEventUpdateMsgDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEventUpdateMsg#equals(Object)}
   *   <li>{@link EdgeEventUpdateMsg#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, null);
    EdgeEventUpdateMsg edgeEventUpdateMsg2 = new EdgeEventUpdateMsg(null, null);

    // Act and Assert
    assertEquals(edgeEventUpdateMsg, edgeEventUpdateMsg2);
    int expectedHashCodeResult = edgeEventUpdateMsg.hashCode();
    assertEquals(expectedHashCodeResult, edgeEventUpdateMsg2.hashCode());
  }

  /**
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), mock(EdgeId.class));

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), mock(EdgeId.class)), "42");
  }

  /**
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, mock(EdgeId.class));

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, new EdgeEventUpdateMsg(new TenantId(UUID.randomUUID()), null));
  }

  /**
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, mock(EdgeId.class));

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, new EdgeEventUpdateMsg(null, null));
  }

  /**
   * Method under test: {@link EdgeEventUpdateMsg#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeEventUpdateMsg edgeEventUpdateMsg = new EdgeEventUpdateMsg(null, null);

    // Act and Assert
    assertNotEquals(edgeEventUpdateMsg, new EdgeEventUpdateMsg(null, new EdgeId(UUID.randomUUID())));
  }
}
