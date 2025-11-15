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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.junit.jupiter.api.Test;

class EntityFieldsDataDiffblueTest {
  /**
   * Method under test: {@link EntityFieldsData#getFieldValue(String)}
   */
  @Test
  void testGetFieldValue() {
    // Arrange, Act and Assert
    assertNull(
        (new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)))).getFieldValue("Field"));
    assertNull((new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)))).getFieldValue("Field",
        true));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFieldsData#equals(Object)}
   *   <li>{@link EntityFieldsData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityFieldsData entityFieldsData = new EntityFieldsData(
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    EntityFieldsData entityFieldsData2 = new EntityFieldsData(
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertEquals(entityFieldsData, entityFieldsData2);
    int expectedHashCodeResult = entityFieldsData.hashCode();
    assertEquals(expectedHashCodeResult, entityFieldsData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFieldsData#equals(Object)}
   *   <li>{@link EntityFieldsData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityFieldsData entityFieldsData = new EntityFieldsData(new ObjectNode(mock(JsonNodeFactory.class)));
    EntityFieldsData entityFieldsData2 = new EntityFieldsData(
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertEquals(entityFieldsData, entityFieldsData2);
    int expectedHashCodeResult = entityFieldsData.hashCode();
    assertEquals(expectedHashCodeResult, entityFieldsData2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFieldsData#equals(Object)}
   *   <li>{@link EntityFieldsData#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityFieldsData entityFieldsData = new EntityFieldsData(
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));

    // Act and Assert
    assertEquals(entityFieldsData, entityFieldsData);
    int expectedHashCodeResult = entityFieldsData.hashCode();
    assertEquals(expectedHashCodeResult, entityFieldsData.hashCode());
  }

  /**
   * Method under test: {@link EntityFieldsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityFieldsData entityFieldsData = new EntityFieldsData((ObjectNode) null);

    // Act and Assert
    assertNotEquals(entityFieldsData, new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Method under test: {@link EntityFieldsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ObjectNode fieldsData = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    fieldsData.put("Property Name", MissingNode.getInstance());
    EntityFieldsData entityFieldsData = new EntityFieldsData(fieldsData);

    // Act and Assert
    assertNotEquals(entityFieldsData, new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))));
  }

  /**
   * Method under test: {@link EntityFieldsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))), null);
  }

  /**
   * Method under test: {@link EntityFieldsData#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityFieldsData(new ObjectNode(JsonNodeFactory.withExactBigDecimals(true))),
        "Different type to EntityFieldsData");
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link EntityFieldsData#EntityFieldsData(ObjectNode)}
   *   <li>{@link EntityFieldsData#setFieldsData(ObjectNode)}
   *   <li>{@link EntityFieldsData#toString()}
   *   <li>{@link EntityFieldsData#getFieldsData()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    EntityFieldsData actualEntityFieldsData = new EntityFieldsData(
        new ObjectNode(JsonNodeFactory.withExactBigDecimals(true)));
    ObjectNode fieldsData = new ObjectNode(JsonNodeFactory.withExactBigDecimals(true));
    actualEntityFieldsData.setFieldsData(fieldsData);
    String actualToStringResult = actualEntityFieldsData.toString();

    // Assert that nothing has changed
    assertEquals("EntityFieldsData(fieldsData={})", actualToStringResult);
    assertSame(fieldsData, actualEntityFieldsData.getFieldsData());
  }
}
