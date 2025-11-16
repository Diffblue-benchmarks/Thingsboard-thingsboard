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
package org.thingsboard.server.dao.util.mapping;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BinaryNode;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.UnsupportedEncodingException;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class JsonConverterDiffblueTest {
  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with {@code JsonNode}.
   *
   * <p>Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonConverter.convertToDatabaseColumn(JsonNode)"})
  public void testConvertToDatabaseColumnWithJsonNode() {
    // Arrange
    JsonConverter jsonConverter = new JsonConverter();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    // Act
    String actualConvertToDatabaseColumnResult =
        jsonConverter.convertToDatabaseColumn(new ArrayNode(nf));

    // Assert
    assertEquals("[]", actualConvertToDatabaseColumnResult);
  }

  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with {@code JsonNode}.
   *
   * <p>Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonConverter.convertToDatabaseColumn(JsonNode)"})
  public void testConvertToDatabaseColumnWithJsonNode2() {
    // Arrange
    JsonConverter jsonConverter = new JsonConverter();
    JsonNodeFactory nf = JsonNodeFactory.withExactBigDecimals(true);

    // Act
    String actualConvertToDatabaseColumnResult =
        jsonConverter.convertToDatabaseColumn(new ArrayNode(nf, 3));

    // Assert
    assertEquals("[]", actualConvertToDatabaseColumnResult);
  }

  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with {@code JsonNode}.
   *
   * <ul>
   *   <li>Then return {@code "QVhB"}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonConverter.convertToDatabaseColumn(JsonNode)"})
  public void testConvertToDatabaseColumnWithJsonNode_thenReturnQVhB()
      throws UnsupportedEncodingException {
    // Arrange
    JsonConverter jsonConverter = new JsonConverter();

    // Act
    String actualConvertToDatabaseColumnResult =
        jsonConverter.convertToDatabaseColumn(new BinaryNode("AXAXAXAX".getBytes("UTF-8"), 2, 3));

    // Assert
    assertEquals("\"QVhB\"", actualConvertToDatabaseColumnResult);
  }

  /**
   * Test {@link JsonConverter#convertToDatabaseColumn(JsonNode)} with {@code JsonNode}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToDatabaseColumn(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonConverter.convertToDatabaseColumn(JsonNode)"})
  public void testConvertToDatabaseColumnWithJsonNode_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JsonConverter().convertToDatabaseColumn(null));
  }

  /**
   * Test {@link JsonConverter#convertToEntityAttribute(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link IntNode}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToEntityAttribute(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JsonConverter.convertToEntityAttribute(String)"})
  public void testConvertToEntityAttributeWithString_when42_thenReturnIntNode() {
    // Arrange and Act
    JsonNode actualConvertToEntityAttributeResult =
        new JsonConverter().convertToEntityAttribute("42");

    // Assert
    assertTrue(actualConvertToEntityAttributeResult instanceof IntNode);
    assertTrue(actualConvertToEntityAttributeResult.traverse() instanceof TreeTraversingParser);
    assertEquals(0, actualConvertToEntityAttributeResult.size());
    assertEquals(JsonNodeType.NUMBER, actualConvertToEntityAttributeResult.getNodeType());
    assertFalse(actualConvertToEntityAttributeResult.isArray());
    assertFalse(actualConvertToEntityAttributeResult.isBigDecimal());
    assertFalse(actualConvertToEntityAttributeResult.isBigInteger());
    assertFalse(actualConvertToEntityAttributeResult.isBinary());
    assertFalse(actualConvertToEntityAttributeResult.isBoolean());
    assertFalse(actualConvertToEntityAttributeResult.isContainerNode());
    assertFalse(actualConvertToEntityAttributeResult.isDouble());
    assertFalse(actualConvertToEntityAttributeResult.isFloat());
    assertFalse(actualConvertToEntityAttributeResult.isFloatingPointNumber());
    assertFalse(actualConvertToEntityAttributeResult.isLong());
    assertFalse(actualConvertToEntityAttributeResult.isMissingNode());
    assertFalse(actualConvertToEntityAttributeResult.isNull());
    assertFalse(actualConvertToEntityAttributeResult.isObject());
    assertFalse(actualConvertToEntityAttributeResult.isPojo());
    assertFalse(actualConvertToEntityAttributeResult.isShort());
    assertFalse(actualConvertToEntityAttributeResult.isTextual());
    assertFalse(((IntNode) actualConvertToEntityAttributeResult).isNaN());
    assertFalse(actualConvertToEntityAttributeResult.iterator().hasNext());
    assertTrue(actualConvertToEntityAttributeResult.isEmpty());
    assertTrue(actualConvertToEntityAttributeResult.isInt());
    assertTrue(actualConvertToEntityAttributeResult.isIntegralNumber());
    assertTrue(actualConvertToEntityAttributeResult.isNumber());
    assertTrue(actualConvertToEntityAttributeResult.isValueNode());
  }

  /**
   * Test {@link JsonConverter#convertToEntityAttribute(String)} with {@code String}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToEntityAttribute(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JsonConverter.convertToEntityAttribute(String)"})
  public void testConvertToEntityAttributeWithString_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JsonConverter().convertToEntityAttribute(""));
  }

  /**
   * Test {@link JsonConverter#convertToEntityAttribute(String)} with {@code String}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link JsonConverter#convertToEntityAttribute(String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonNode JsonConverter.convertToEntityAttribute(String)"})
  public void testConvertToEntityAttributeWithString_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(new JsonConverter().convertToEntityAttribute(null));
  }
}
