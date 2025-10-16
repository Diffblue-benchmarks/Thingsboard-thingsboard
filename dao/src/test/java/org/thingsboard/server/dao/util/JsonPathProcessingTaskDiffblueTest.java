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
package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class JsonPathProcessingTaskDiffblueTest {
  /**
   * Test {@link JsonPathProcessingTask#isLast()}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPathProcessingTask#isLast()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonPathProcessingTask.isLast()"})
  public void testIsLast_thenReturnFalse() {
    // Arrange
    JsonPathProcessingTask jsonPathProcessingTask =
        new JsonPathProcessingTask(
            new String[] {},
            new HashMap<>(),
            CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertFalse(jsonPathProcessingTask.isLast());
  }

  /**
   * Test {@link JsonPathProcessingTask#isLast()}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPathProcessingTask#isLast()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean JsonPathProcessingTask.isLast()"})
  public void testIsLast_thenReturnTrue() {
    // Arrange
    String[] tokens = new String[] {"ABC123"};
    JsonPathProcessingTask jsonPathProcessingTask =
        new JsonPathProcessingTask(
            tokens, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertTrue(jsonPathProcessingTask.isLast());
  }

  /**
   * Test {@link JsonPathProcessingTask#currentToken()}.
   *
   * <ul>
   *   <li>Then return {@code ABC123}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPathProcessingTask#currentToken()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"String JsonPathProcessingTask.currentToken()"})
  public void testCurrentToken_thenReturnAbc123() {
    // Arrange
    String[] tokens = new String[] {"ABC123"};
    JsonPathProcessingTask jsonPathProcessingTask =
        new JsonPathProcessingTask(
            tokens, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals("ABC123", jsonPathProcessingTask.currentToken());
  }

  /**
   * Test {@link JsonPathProcessingTask#next(JsonNode, String, String)} with {@code next}, {@code
   * key}, {@code value}.
   *
   * <ul>
   *   <li>Then Node return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPathProcessingTask#next(JsonNode, String, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "JsonPathProcessingTask JsonPathProcessingTask.next(JsonNode, String, String)"
  })
  public void testNextWithNextKeyValue_thenNodeReturnObjectNode() {
    // Arrange
    String[] tokens = new String[] {"ABC123"};
    JsonPathProcessingTask jsonPathProcessingTask =
        new JsonPathProcessingTask(
            tokens, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode next = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    JsonPathProcessingTask actualNextResult = jsonPathProcessingTask.next(next, "Key", "42");

    // Assert
    JsonNode node = actualNextResult.getNode();
    assertTrue(node instanceof ObjectNode);
    assertEquals(0, actualNextResult.getTokens().length);
    Map<String, String> variables = actualNextResult.getVariables();
    assertEquals(1, variables.size());
    assertFalse(actualNextResult.isLast());
    assertTrue(variables.containsKey("Key"));
    assertSame(next, node);
  }

  /**
   * Test {@link JsonPathProcessingTask#next(JsonNode)} with {@code next}.
   *
   * <ul>
   *   <li>Then Node return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link JsonPathProcessingTask#next(JsonNode)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"JsonPathProcessingTask JsonPathProcessingTask.next(JsonNode)"})
  public void testNextWithNext_thenNodeReturnObjectNode() {
    // Arrange
    String[] tokens = new String[] {"ABC123"};
    JsonPathProcessingTask jsonPathProcessingTask =
        new JsonPathProcessingTask(
            tokens, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNode next = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    JsonPathProcessingTask actualNextResult = jsonPathProcessingTask.next(next);

    // Assert
    JsonNode node = actualNextResult.getNode();
    assertTrue(node instanceof ObjectNode);
    assertEquals(0, actualNextResult.getTokens().length);
    assertFalse(actualNextResult.isLast());
    assertTrue(actualNextResult.getVariables().isEmpty());
    assertSame(next, node);
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}, and {@link
   * JsonPathProcessingTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonPathProcessingTask#equals(Object)}
   *   <li>{@link JsonPathProcessingTask#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonPathProcessingTask.equals(Object)",
    "int JsonPathProcessingTask.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    String[] tokens = new String[] {"ABC123"};
    JsonPathProcessingTask jsonPathProcessingTask =
        new JsonPathProcessingTask(
            tokens, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    String[] tokens2 = new String[] {"ABC123"};
    JsonPathProcessingTask jsonPathProcessingTask2 =
        new JsonPathProcessingTask(
            tokens2, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals(jsonPathProcessingTask, jsonPathProcessingTask2);
    assertEquals(jsonPathProcessingTask.hashCode(), jsonPathProcessingTask2.hashCode());
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}, and {@link
   * JsonPathProcessingTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonPathProcessingTask#equals(Object)}
   *   <li>{@link JsonPathProcessingTask#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonPathProcessingTask.equals(Object)",
    "int JsonPathProcessingTask.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    String[] tokens = new String[] {"ABC123"};
    JsonPathProcessingTask jsonPathProcessingTask =
        new JsonPathProcessingTask(tokens, new HashMap<>(), null);
    String[] tokens2 = new String[] {"ABC123"};
    JsonPathProcessingTask jsonPathProcessingTask2 =
        new JsonPathProcessingTask(tokens2, new HashMap<>(), null);

    // Act and Assert
    assertEquals(jsonPathProcessingTask, jsonPathProcessingTask2);
    assertEquals(jsonPathProcessingTask.hashCode(), jsonPathProcessingTask2.hashCode());
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}, and {@link
   * JsonPathProcessingTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonPathProcessingTask#equals(Object)}
   *   <li>{@link JsonPathProcessingTask#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonPathProcessingTask.equals(Object)",
    "int JsonPathProcessingTask.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    String[] tokens = new String[] {"ABC123"};
    JsonPathProcessingTask jsonPathProcessingTask =
        new JsonPathProcessingTask(
            tokens, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals(jsonPathProcessingTask, jsonPathProcessingTask);
    int expectedHashCodeResult = jsonPathProcessingTask.hashCode();
    assertEquals(expectedHashCodeResult, jsonPathProcessingTask.hashCode());
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonPathProcessingTask.equals(Object)",
    "int JsonPathProcessingTask.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonPathProcessingTask jsonPathProcessingTask =
        new JsonPathProcessingTask(
            null, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    String[] tokens = new String[] {"ABC123"};

    // Act and Assert
    assertNotEquals(
        jsonPathProcessingTask,
        new JsonPathProcessingTask(
            tokens, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonPathProcessingTask.equals(Object)",
    "int JsonPathProcessingTask.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, String> variables = new HashMap<>();
    variables.put("foo", "foo");
    String[] tokens = new String[] {"ABC123"};

    JsonPathProcessingTask jsonPathProcessingTask =
        new JsonPathProcessingTask(
            tokens, variables, CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    String[] tokens2 = new String[] {"ABC123"};

    // Act and Assert
    assertNotEquals(
        jsonPathProcessingTask,
        new JsonPathProcessingTask(
            tokens2, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonPathProcessingTask.equals(Object)",
    "int JsonPathProcessingTask.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    String[] tokens = new String[] {"ABC123"};
    JsonPathProcessingTask jsonPathProcessingTask =
        new JsonPathProcessingTask(tokens, new HashMap<>(), DoubleNode.valueOf(10.0d));
    String[] tokens2 = new String[] {"ABC123"};

    // Act and Assert
    assertNotEquals(
        jsonPathProcessingTask,
        new JsonPathProcessingTask(
            tokens2, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonPathProcessingTask.equals(Object)",
    "int JsonPathProcessingTask.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    String[] tokens = new String[] {"ABC123"};
    JsonPathProcessingTask jsonPathProcessingTask =
        new JsonPathProcessingTask(tokens, new HashMap<>(), null);
    String[] tokens2 = new String[] {"ABC123"};

    // Act and Assert
    assertNotEquals(
        jsonPathProcessingTask,
        new JsonPathProcessingTask(
            tokens2, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonPathProcessingTask.equals(Object)",
    "int JsonPathProcessingTask.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    String[] tokens = new String[] {"ABC123"};

    // Act and Assert
    assertNotEquals(
        new JsonPathProcessingTask(
            tokens, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON),
        null);
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonPathProcessingTask.equals(Object)",
    "int JsonPathProcessingTask.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    String[] tokens = new String[] {"ABC123"};

    // Act and Assert
    assertNotEquals(
        new JsonPathProcessingTask(
            tokens, new HashMap<>(), CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON),
        "Different type to JsonPathProcessingTask");
  }
}
