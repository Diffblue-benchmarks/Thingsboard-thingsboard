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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;

class EventInfoDiffblueTest {
  /**
   * Method under test: {@link EventInfo#getCreatedTime()}
   */
  @Test
  void testGetCreatedTime() {
    // Arrange, Act and Assert
    assertEquals(0L, (new EventInfo()).getCreatedTime());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EventInfo#equals(Object)}
   *   <li>{@link EventInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    EventInfo eventInfo2 = new EventInfo();

    // Act and Assert
    assertEquals(eventInfo, eventInfo2);
    int expectedHashCodeResult = eventInfo.hashCode();
    assertEquals(expectedHashCodeResult, eventInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EventInfo#equals(Object)}
   *   <li>{@link EventInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setTenantId(TenantId.SYS_TENANT_ID);

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(eventInfo, eventInfo2);
    int expectedHashCodeResult = eventInfo.hashCode();
    assertEquals(expectedHashCodeResult, eventInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EventInfo#equals(Object)}
   *   <li>{@link EventInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setType("Type");

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setType("Type");

    // Act and Assert
    assertEquals(eventInfo, eventInfo2);
    int expectedHashCodeResult = eventInfo.hashCode();
    assertEquals(expectedHashCodeResult, eventInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EventInfo#equals(Object)}
   *   <li>{@link EventInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setUid("1234");

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setUid("1234");

    // Act and Assert
    assertEquals(eventInfo, eventInfo2);
    int expectedHashCodeResult = eventInfo.hashCode();
    assertEquals(expectedHashCodeResult, eventInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EventInfo#equals(Object)}
   *   <li>{@link EventInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setEntityId(TenantId.SYS_TENANT_ID);

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertEquals(eventInfo, eventInfo2);
    int expectedHashCodeResult = eventInfo.hashCode();
    assertEquals(expectedHashCodeResult, eventInfo2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EventInfo#equals(Object)}
   *   <li>{@link EventInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EventInfo eventInfo = new EventInfo();

    // Act and Assert
    assertEquals(eventInfo, eventInfo);
    int expectedHashCodeResult = eventInfo.hashCode();
    assertEquals(expectedHashCodeResult, eventInfo.hashCode());
  }

  /**
   * Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EventInfo(), 1);
  }

  /**
   * Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(eventInfo, new EventInfo());
  }

  /**
   * Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setType("Type");

    // Act and Assert
    assertNotEquals(eventInfo, new EventInfo());
  }

  /**
   * Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setUid("1234");

    // Act and Assert
    assertNotEquals(eventInfo, new EventInfo());
  }

  /**
   * Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(eventInfo, new EventInfo());
  }

  /**
   * Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EventInfo eventInfo = new EventInfo();

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setTenantId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(eventInfo, eventInfo2);
  }

  /**
   * Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EventInfo eventInfo = new EventInfo();

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setType("Type");

    // Act and Assert
    assertNotEquals(eventInfo, eventInfo2);
  }

  /**
   * Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EventInfo eventInfo = new EventInfo();

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setUid("1234");

    // Act and Assert
    assertNotEquals(eventInfo, eventInfo2);
  }

  /**
   * Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EventInfo eventInfo = new EventInfo();

    EventInfo eventInfo2 = new EventInfo();
    eventInfo2.setEntityId(TenantId.SYS_TENANT_ID);

    // Act and Assert
    assertNotEquals(eventInfo, eventInfo2);
  }

  /**
   * Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EventInfo eventInfo = new EventInfo();
    eventInfo.setEntityId(mock(EntityId.class));

    // Act and Assert
    assertNotEquals(eventInfo, new EventInfo());
  }

  /**
   * Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EventInfo(), null);
  }

  /**
   * Method under test: {@link EventInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EventInfo(), "Different type to EventInfo");
  }

  /**
   * Method under test: {@link EventInfo#EventInfo(EventInfo)}
   */
  @Test
  void testNewEventInfo() {
    // Arrange
    EventInfo event = new EventInfo();

    // Act and Assert
    assertEquals(event, new EventInfo(event));
  }
}
