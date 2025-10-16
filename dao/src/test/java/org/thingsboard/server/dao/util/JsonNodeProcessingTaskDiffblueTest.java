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
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.node.DoubleNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class JsonNodeProcessingTaskDiffblueTest {
  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}, and {@link
   * JsonNodeProcessingTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonNodeProcessingTask#equals(Object)}
   *   <li>{@link JsonNodeProcessingTask#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonNodeProcessingTask.equals(Object)",
    "int JsonNodeProcessingTask.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask =
        new JsonNodeProcessingTask(
            "Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNodeProcessingTask jsonNodeProcessingTask2 =
        new JsonNodeProcessingTask(
            "Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals(jsonNodeProcessingTask, jsonNodeProcessingTask2);
    assertEquals(jsonNodeProcessingTask.hashCode(), jsonNodeProcessingTask2.hashCode());
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}, and {@link
   * JsonNodeProcessingTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonNodeProcessingTask#equals(Object)}
   *   <li>{@link JsonNodeProcessingTask#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonNodeProcessingTask.equals(Object)",
    "int JsonNodeProcessingTask.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask =
        new JsonNodeProcessingTask(null, CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNodeProcessingTask jsonNodeProcessingTask2 =
        new JsonNodeProcessingTask(null, CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals(jsonNodeProcessingTask, jsonNodeProcessingTask2);
    assertEquals(jsonNodeProcessingTask.hashCode(), jsonNodeProcessingTask2.hashCode());
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}, and {@link
   * JsonNodeProcessingTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonNodeProcessingTask#equals(Object)}
   *   <li>{@link JsonNodeProcessingTask#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonNodeProcessingTask.equals(Object)",
    "int JsonNodeProcessingTask.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask = new JsonNodeProcessingTask("Path", null);
    JsonNodeProcessingTask jsonNodeProcessingTask2 = new JsonNodeProcessingTask("Path", null);

    // Act and Assert
    assertEquals(jsonNodeProcessingTask, jsonNodeProcessingTask2);
    assertEquals(jsonNodeProcessingTask.hashCode(), jsonNodeProcessingTask2.hashCode());
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}, and {@link
   * JsonNodeProcessingTask#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link JsonNodeProcessingTask#equals(Object)}
   *   <li>{@link JsonNodeProcessingTask#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonNodeProcessingTask.equals(Object)",
    "int JsonNodeProcessingTask.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask =
        new JsonNodeProcessingTask(
            "Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals(jsonNodeProcessingTask, jsonNodeProcessingTask);
    int expectedHashCodeResult = jsonNodeProcessingTask.hashCode();
    assertEquals(expectedHashCodeResult, jsonNodeProcessingTask.hashCode());
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonNodeProcessingTask.equals(Object)",
    "int JsonNodeProcessingTask.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask =
        new JsonNodeProcessingTask(null, CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(
        jsonNodeProcessingTask,
        new JsonNodeProcessingTask(
            "Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonNodeProcessingTask.equals(Object)",
    "int JsonNodeProcessingTask.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask =
        new JsonNodeProcessingTask(
            "org.thingsboard.server.dao.util.JsonNodeProcessingTask",
            CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(
        jsonNodeProcessingTask,
        new JsonNodeProcessingTask(
            "Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonNodeProcessingTask.equals(Object)",
    "int JsonNodeProcessingTask.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask =
        new JsonNodeProcessingTask("Path", DoubleNode.valueOf(10.0d));

    // Act and Assert
    assertNotEquals(
        jsonNodeProcessingTask,
        new JsonNodeProcessingTask(
            "Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonNodeProcessingTask.equals(Object)",
    "int JsonNodeProcessingTask.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask = new JsonNodeProcessingTask("Path", null);

    // Act and Assert
    assertNotEquals(
        jsonNodeProcessingTask,
        new JsonNodeProcessingTask(
            "Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonNodeProcessingTask.equals(Object)",
    "int JsonNodeProcessingTask.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new JsonNodeProcessingTask(
            "Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON),
        null);
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean JsonNodeProcessingTask.equals(Object)",
    "int JsonNodeProcessingTask.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new JsonNodeProcessingTask(
            "Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON),
        "Different type to JsonNodeProcessingTask");
  }
}
