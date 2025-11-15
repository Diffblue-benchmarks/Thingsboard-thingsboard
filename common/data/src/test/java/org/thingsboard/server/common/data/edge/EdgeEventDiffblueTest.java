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
package org.thingsboard.server.common.data.edge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EdgeEventDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    EdgeEvent edgeEvent2 = new EdgeEvent();

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent2);
    int expectedHashCodeResult = edgeEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeEvent2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setTenantId(TenantId.SYS_TENANT_ID);

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent2);
    int expectedHashCodeResult = edgeEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeEvent2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent2);
    int expectedHashCodeResult = edgeEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeEvent2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setEntityId(EntityId.NULL_UUID);

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setEntityId(EntityId.NULL_UUID);

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent2);
    int expectedHashCodeResult = edgeEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeEvent2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setUid("1234");

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setUid("1234");

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent2);
    int expectedHashCodeResult = edgeEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeEvent2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setType(EdgeEventType.DASHBOARD);

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setType(EdgeEventType.DASHBOARD);

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent2);
    int expectedHashCodeResult = edgeEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeEvent2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEvent#equals(Object)}
   *   <li>{@link EdgeEvent#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();

    // Act and Assert
    assertEquals(edgeEvent, edgeEvent);
    int expectedHashCodeResult = edgeEvent.hashCode();
    assertEquals(expectedHashCodeResult, edgeEvent.hashCode());
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEvent(), 1);
    assertNotEquals(new EdgeEvent(), mock(Edge.class));
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setSeqId(1L);

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setEntityId(EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setUid("1234");

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setType(EdgeEventType.DASHBOARD);

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();
    edgeEvent.setCreatedTime(1L);

    // Act and Assert
    assertNotEquals(edgeEvent, new EdgeEvent());
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(edgeEvent, edgeEvent2);
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setAction(EdgeEventActionType.ADDED);

    // Act and Assert
    assertNotEquals(edgeEvent, edgeEvent2);
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setEntityId(EntityId.NULL_UUID);

    // Act and Assert
    assertNotEquals(edgeEvent, edgeEvent2);
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setUid("1234");

    // Act and Assert
    assertNotEquals(edgeEvent, edgeEvent2);
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EdgeEvent edgeEvent = new EdgeEvent();

    EdgeEvent edgeEvent2 = new EdgeEvent();
    edgeEvent2.setType(EdgeEventType.DASHBOARD);

    // Act and Assert
    assertNotEquals(edgeEvent, edgeEvent2);
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEvent(), null);
  }

  /**
   * Method under test: {@link EdgeEvent#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeEvent(), "Different type to EdgeEvent");
  }
}
