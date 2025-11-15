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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEvent;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.MsgType;

class EdgeHighPriorityMsgDiffblueTest {
  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}, and {@link EdgeHighPriorityMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeHighPriorityMsg#equals(Object)}
   *   <li>{@link EdgeHighPriorityMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeHighPriorityMsg.equals(Object)", "int EdgeHighPriorityMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(null, new EdgeEvent());
    EdgeHighPriorityMsg edgeHighPriorityMsg2 = new EdgeHighPriorityMsg(null, new EdgeEvent());

    // Act and Assert
    assertEquals(edgeHighPriorityMsg, edgeHighPriorityMsg2);
    int expectedHashCodeResult = edgeHighPriorityMsg.hashCode();
    assertEquals(expectedHashCodeResult, edgeHighPriorityMsg2.hashCode());
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}, and {@link EdgeHighPriorityMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeHighPriorityMsg#equals(Object)}
   *   <li>{@link EdgeHighPriorityMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeHighPriorityMsg.equals(Object)", "int EdgeHighPriorityMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(null, null);
    EdgeHighPriorityMsg edgeHighPriorityMsg2 = new EdgeHighPriorityMsg(null, null);

    // Act and Assert
    assertEquals(edgeHighPriorityMsg, edgeHighPriorityMsg2);
    int expectedHashCodeResult = edgeHighPriorityMsg.hashCode();
    assertEquals(expectedHashCodeResult, edgeHighPriorityMsg2.hashCode());
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}, and {@link EdgeHighPriorityMsg#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeHighPriorityMsg#equals(Object)}
   *   <li>{@link EdgeHighPriorityMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeHighPriorityMsg.equals(Object)", "int EdgeHighPriorityMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TenantId tenantId = new TenantId(null);
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(tenantId, new EdgeEvent());
    TenantId tenantId2 = new TenantId(null);
    EdgeHighPriorityMsg edgeHighPriorityMsg2 = new EdgeHighPriorityMsg(tenantId2, new EdgeEvent());

    // Act and Assert
    assertEquals(edgeHighPriorityMsg, edgeHighPriorityMsg2);
    int expectedHashCodeResult = edgeHighPriorityMsg.hashCode();
    assertEquals(expectedHashCodeResult, edgeHighPriorityMsg2.hashCode());
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}, and {@link EdgeHighPriorityMsg#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeHighPriorityMsg#equals(Object)}
   *   <li>{@link EdgeHighPriorityMsg#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeHighPriorityMsg.equals(Object)", "int EdgeHighPriorityMsg.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(tenantId, new EdgeEvent());

    // Act and Assert
    assertEquals(edgeHighPriorityMsg, edgeHighPriorityMsg);
    int expectedHashCodeResult = edgeHighPriorityMsg.hashCode();
    assertEquals(expectedHashCodeResult, edgeHighPriorityMsg.hashCode());
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeHighPriorityMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeHighPriorityMsg.equals(Object)", "int EdgeHighPriorityMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(tenantId, new EdgeEvent());
    TenantId tenantId2 = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(edgeHighPriorityMsg, new EdgeHighPriorityMsg(tenantId2, new EdgeEvent()));
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeHighPriorityMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeHighPriorityMsg.equals(Object)", "int EdgeHighPriorityMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(null, new EdgeEvent());
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(edgeHighPriorityMsg, new EdgeHighPriorityMsg(tenantId, new EdgeEvent()));
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeHighPriorityMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeHighPriorityMsg.equals(Object)", "int EdgeHighPriorityMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(null, null);

    // Act and Assert
    assertNotEquals(edgeHighPriorityMsg, new EdgeHighPriorityMsg(null, new EdgeEvent()));
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeHighPriorityMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeHighPriorityMsg.equals(Object)", "int EdgeHighPriorityMsg.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeHighPriorityMsg edgeHighPriorityMsg = new EdgeHighPriorityMsg(null, mock(EdgeEvent.class));

    // Act and Assert
    assertNotEquals(edgeHighPriorityMsg, new EdgeHighPriorityMsg(null, new EdgeEvent()));
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeHighPriorityMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeHighPriorityMsg.equals(Object)", "int EdgeHighPriorityMsg.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(new EdgeHighPriorityMsg(tenantId, new EdgeEvent()), null);
  }

  /**
   * Test {@link EdgeHighPriorityMsg#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeHighPriorityMsg#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean EdgeHighPriorityMsg.equals(Object)", "int EdgeHighPriorityMsg.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNotEquals(new EdgeHighPriorityMsg(tenantId, new EdgeEvent()), "Different type to EdgeHighPriorityMsg");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeHighPriorityMsg#EdgeHighPriorityMsg(TenantId, EdgeEvent)}
   *   <li>{@link EdgeHighPriorityMsg#toString()}
   *   <li>{@link EdgeHighPriorityMsg#getEdgeEvent()}
   *   <li>{@link EdgeHighPriorityMsg#getMsgType()}
   *   <li>{@link EdgeHighPriorityMsg#getTenantId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void EdgeHighPriorityMsg.<init>(TenantId, EdgeEvent)",
      "EdgeEvent EdgeHighPriorityMsg.getEdgeEvent()", "MsgType EdgeHighPriorityMsg.getMsgType()",
      "TenantId EdgeHighPriorityMsg.getTenantId()", "java.lang.String EdgeHighPriorityMsg.toString()"})
  void testGettersAndSetters() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EdgeEvent edgeEvent = new EdgeEvent();

    // Act
    EdgeHighPriorityMsg actualEdgeHighPriorityMsg = new EdgeHighPriorityMsg(tenantId, edgeEvent);
    actualEdgeHighPriorityMsg.toString();
    EdgeEvent actualEdgeEvent = actualEdgeHighPriorityMsg.getEdgeEvent();
    MsgType actualMsgType = actualEdgeHighPriorityMsg.getMsgType();

    // Assert
    assertEquals(MsgType.EDGE_HIGH_PRIORITY_TO_EDGE_SESSION_MSG, actualMsgType);
    assertSame(edgeEvent, actualEdgeEvent);
    assertSame(tenantId, actualEdgeHighPriorityMsg.getTenantId());
  }
}
