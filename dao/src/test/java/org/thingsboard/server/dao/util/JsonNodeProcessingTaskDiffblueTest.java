package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class JsonNodeProcessingTaskDiffblueTest {
  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}, and {@link JsonNodeProcessingTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsonNodeProcessingTask#equals(Object)}
   *   <li>{@link JsonNodeProcessingTask#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonNodeProcessingTask.equals(Object)", "int JsonNodeProcessingTask.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask = new JsonNodeProcessingTask("Path", null);
    JsonNodeProcessingTask jsonNodeProcessingTask2 = new JsonNodeProcessingTask("Path", null);

    // Act and Assert
    assertEquals(jsonNodeProcessingTask, jsonNodeProcessingTask2);
    int expectedHashCodeResult = jsonNodeProcessingTask.hashCode();
    assertEquals(expectedHashCodeResult, jsonNodeProcessingTask2.hashCode());
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonNodeProcessingTask.equals(Object)", "int JsonNodeProcessingTask.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask = new JsonNodeProcessingTask(null,
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(jsonNodeProcessingTask,
        new JsonNodeProcessingTask("Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonNodeProcessingTask.equals(Object)", "int JsonNodeProcessingTask.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask = new JsonNodeProcessingTask(
        "org.thingsboard.server.dao.util.JsonNodeProcessingTask",
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(jsonNodeProcessingTask,
        new JsonNodeProcessingTask("Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonNodeProcessingTask.equals(Object)", "int JsonNodeProcessingTask.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask = new JsonNodeProcessingTask("Path", MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(jsonNodeProcessingTask,
        new JsonNodeProcessingTask("Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonNodeProcessingTask.equals(Object)", "int JsonNodeProcessingTask.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask = new JsonNodeProcessingTask("Path", null);

    // Act and Assert
    assertNotEquals(jsonNodeProcessingTask,
        new JsonNodeProcessingTask("Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonNodeProcessingTask.equals(Object)", "int JsonNodeProcessingTask.hashCode()"})
  public void testEquals_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask = new JsonNodeProcessingTask("Path",
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals(jsonNodeProcessingTask,
        new JsonNodeProcessingTask("Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonNodeProcessingTask.equals(Object)", "int JsonNodeProcessingTask.hashCode()"})
  public void testEquals_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    JsonNodeProcessingTask jsonNodeProcessingTask = new JsonNodeProcessingTask(null,
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals(jsonNodeProcessingTask,
        new JsonNodeProcessingTask(null, CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonNodeProcessingTask.equals(Object)", "int JsonNodeProcessingTask.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonNodeProcessingTask("Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON), null);
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonNodeProcessingTask.equals(Object)", "int JsonNodeProcessingTask.hashCode()"})
  public void testEquals_whenOtherIsSame_thenReturnEqual() {
    // Arrange, Act and Assert
    assertEquals(new JsonNodeProcessingTask("Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON),
        new JsonNodeProcessingTask("Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonNodeProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonNodeProcessingTask#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean JsonNodeProcessingTask.equals(Object)", "int JsonNodeProcessingTask.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonNodeProcessingTask("Path", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON),
        "Different type to JsonNodeProcessingTask");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsonNodeProcessingTask#JsonNodeProcessingTask(String, JsonNode)}
   *   <li>{@link JsonNodeProcessingTask#getNode()}
   *   <li>{@link JsonNodeProcessingTask#getPath()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void JsonNodeProcessingTask.<init>(String, JsonNode)",
      "JsonNode JsonNodeProcessingTask.getNode()", "String JsonNodeProcessingTask.getPath()",
      "String JsonNodeProcessingTask.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    JsonNode node = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    JsonNodeProcessingTask actualJsonNodeProcessingTask = new JsonNodeProcessingTask("Path", node);
    JsonNode actualNode = actualJsonNodeProcessingTask.getNode();

    // Assert
    assertEquals("Path", actualJsonNodeProcessingTask.getPath());
    assertSame(node, actualNode);
  }
}
