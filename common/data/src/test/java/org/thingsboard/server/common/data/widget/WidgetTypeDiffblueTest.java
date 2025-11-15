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
package org.thingsboard.server.common.data.widget;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.WidgetTypeId;

class WidgetTypeDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetType#equals(Object)}
   *   <li>{@link WidgetType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    WidgetType widgetType2 = new WidgetType();

    // Act and Assert
    assertEquals(widgetType, widgetType2);
    int expectedHashCodeResult = widgetType.hashCode();
    assertEquals(expectedHashCodeResult, widgetType2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetType#equals(Object)}
   *   <li>{@link WidgetType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    WidgetTypeDetails widgetTypeDetails = mock(WidgetTypeDetails.class);
    when(widgetTypeDetails.canEqual(Mockito.<Object>any())).thenReturn(true);

    // Act and Assert
    assertEquals(widgetType, widgetTypeDetails);
    int notExpectedHashCodeResult = widgetType.hashCode();
    assertNotEquals(notExpectedHashCodeResult, widgetTypeDetails.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetType#equals(Object)}
   *   <li>{@link WidgetType#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    WidgetType widgetType = new WidgetType();

    // Act and Assert
    assertEquals(widgetType, widgetType);
    int expectedHashCodeResult = widgetType.hashCode();
    assertEquals(expectedHashCodeResult, widgetType.hashCode());
  }

  /**
   * Method under test: {@link WidgetType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    WidgetTypeDetails widgetTypeDetails = new WidgetTypeDetails();

    // Act and Assert
    assertNotEquals(widgetTypeDetails, new WidgetType());
  }

  /**
   * Method under test: {@link WidgetType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    WidgetType widgetType = new WidgetType();

    // Act and Assert
    assertNotEquals(widgetType, new WidgetTypeDetails());
  }

  /**
   * Method under test: {@link WidgetType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetType(), null);
  }

  /**
   * Method under test: {@link WidgetType#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new WidgetType(), "Different type to WidgetType");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetType#WidgetType()}
   *   <li>{@link WidgetType#setDescriptor(JsonNode)}
   *   <li>{@link WidgetType#toString()}
   *   <li>{@link WidgetType#getDescriptor()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    WidgetType actualWidgetType = new WidgetType();
    MissingNode descriptor = MissingNode.getInstance();
    actualWidgetType.setDescriptor(descriptor);
    String actualToStringResult = actualWidgetType.toString();
    JsonNode actualDescriptor = actualWidgetType.getDescriptor();

    // Assert that nothing has changed
    assertEquals("WidgetType(descriptor=)", actualToStringResult);
    assertEquals(0L, actualWidgetType.getCreatedTime());
    assertFalse(actualWidgetType.isDeprecated());
    assertFalse(actualWidgetType.isScada());
    assertSame(descriptor, actualDescriptor);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link WidgetType#WidgetType(WidgetTypeId)}
   *   <li>{@link WidgetType#setDescriptor(JsonNode)}
   *   <li>{@link WidgetType#toString()}
   *   <li>{@link WidgetType#getDescriptor()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    WidgetTypeId id = new WidgetTypeId(EntityId.NULL_UUID);

    // Act
    WidgetType actualWidgetType = new WidgetType(id);
    MissingNode descriptor = MissingNode.getInstance();
    actualWidgetType.setDescriptor(descriptor);
    String actualToStringResult = actualWidgetType.toString();
    JsonNode actualDescriptor = actualWidgetType.getDescriptor();

    // Assert that nothing has changed
    assertEquals("WidgetType(descriptor=)", actualToStringResult);
    assertEquals(0L, actualWidgetType.getCreatedTime());
    assertFalse(actualWidgetType.isDeprecated());
    assertFalse(actualWidgetType.isScada());
    assertSame(id, actualWidgetType.getId());
    assertSame(descriptor, actualDescriptor);
  }

  /**
   * Method under test: {@link WidgetType#WidgetType(BaseWidgetType)}
   */
  @Test
  void testNewWidgetType() {
    // Arrange and Act
    WidgetType actualWidgetType = new WidgetType(new BaseWidgetType());

    // Assert
    assertNull(actualWidgetType.getDescriptor());
    assertNull(actualWidgetType.getVersion());
    assertNull(actualWidgetType.getFqn());
    assertNull(actualWidgetType.getName());
    assertNull(actualWidgetType.getUuidId());
    assertNull(actualWidgetType.getTenantId());
    assertNull(actualWidgetType.getId());
    assertEquals(0L, actualWidgetType.getCreatedTime());
    assertFalse(actualWidgetType.isDeprecated());
    assertFalse(actualWidgetType.isScada());
  }

  /**
   * Method under test: {@link WidgetType#WidgetType(BaseWidgetType)}
   */
  @Test
  void testNewWidgetType2() {
    // Arrange
    BaseWidgetType baseWidgetType = new BaseWidgetType();
    baseWidgetType.setDeprecated(true);

    // Act
    WidgetType actualWidgetType = new WidgetType(baseWidgetType);

    // Assert
    assertNull(actualWidgetType.getDescriptor());
    assertNull(actualWidgetType.getVersion());
    assertNull(actualWidgetType.getFqn());
    assertNull(actualWidgetType.getName());
    assertNull(actualWidgetType.getUuidId());
    assertNull(actualWidgetType.getTenantId());
    assertNull(actualWidgetType.getId());
    assertEquals(0L, actualWidgetType.getCreatedTime());
    assertFalse(actualWidgetType.isScada());
    assertTrue(actualWidgetType.isDeprecated());
  }

  /**
   * Method under test: {@link WidgetType#WidgetType(WidgetType)}
   */
  @Test
  void testNewWidgetType3() {
    // Arrange
    WidgetType widgetType = new WidgetType();

    // Act and Assert
    assertEquals(widgetType, new WidgetType(widgetType));
  }

  /**
   * Method under test: {@link WidgetType#WidgetType(WidgetType)}
   */
  @Test
  void testNewWidgetType4() {
    // Arrange
    WidgetType widgetType = new WidgetType();
    widgetType.setDeprecated(true);

    // Act and Assert
    assertEquals(widgetType, new WidgetType(widgetType));
  }
}
