package org.thingsboard.server.dao.util;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import org.junit.Test;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class JsonPathProcessingTaskDiffblueTest {
  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}, and
   * {@link JsonPathProcessingTask#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsonPathProcessingTask#equals(Object)}
   *   <li>{@link JsonPathProcessingTask#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    JsonPathProcessingTask jsonPathProcessingTask = new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonPathProcessingTask jsonPathProcessingTask2 = new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals(jsonPathProcessingTask, jsonPathProcessingTask2);
    int expectedHashCodeResult = jsonPathProcessingTask.hashCode();
    assertEquals(expectedHashCodeResult, jsonPathProcessingTask2.hashCode());
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}, and
   * {@link JsonPathProcessingTask#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JsonPathProcessingTask#equals(Object)}
   *   <li>{@link JsonPathProcessingTask#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    JsonPathProcessingTask jsonPathProcessingTask = new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertEquals(jsonPathProcessingTask, jsonPathProcessingTask);
    int expectedHashCodeResult = jsonPathProcessingTask.hashCode();
    assertEquals(expectedHashCodeResult, jsonPathProcessingTask.hashCode());
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    JsonPathProcessingTask jsonPathProcessingTask = new JsonPathProcessingTask(new String[]{"Tokens"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(jsonPathProcessingTask, new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    HashMap<String, String> variables = new HashMap<>();
    variables.put("foo", "foo");
    JsonPathProcessingTask jsonPathProcessingTask = new JsonPathProcessingTask(new String[]{"ABC123"}, variables,
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(jsonPathProcessingTask, new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    HashMap<String, String> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));
    variables.put("foo", "foo");
    JsonPathProcessingTask jsonPathProcessingTask = new JsonPathProcessingTask(new String[]{"ABC123"}, variables,
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    // Act and Assert
    assertNotEquals(jsonPathProcessingTask, new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    HashMap<String, String> variables = new HashMap<>();
    JsonPathProcessingTask jsonPathProcessingTask = new JsonPathProcessingTask(new String[]{"ABC123"}, variables,
        MissingNode.getInstance());

    // Act and Assert
    assertNotEquals(jsonPathProcessingTask, new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    JsonPathProcessingTask jsonPathProcessingTask = new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        null);

    // Act and Assert
    assertNotEquals(jsonPathProcessingTask, new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON));
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON), null);
  }

  /**
   * Test {@link JsonPathProcessingTask#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON), "Different type to JsonPathProcessingTask");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link JsonPathProcessingTask#JsonPathProcessingTask(String[], Map, JsonNode)}
   *   <li>{@link JsonPathProcessingTask#getNode()}
   *   <li>{@link JsonPathProcessingTask#getTokens()}
   *   <li>{@link JsonPathProcessingTask#getVariables()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    String[] tokens = new String[]{"ABC123"};
    HashMap<String, String> variables = new HashMap<>();
    JsonNode node = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    JsonPathProcessingTask actualJsonPathProcessingTask = new JsonPathProcessingTask(tokens, variables, node);
    JsonNode actualNode = actualJsonPathProcessingTask.getNode();
    String[] actualTokens = actualJsonPathProcessingTask.getTokens();
    Map<String, String> actualVariables = actualJsonPathProcessingTask.getVariables();

    // Assert
    assertTrue(actualVariables.isEmpty());
    assertSame(variables, actualVariables);
    assertSame(tokens, actualTokens);
    assertSame(node, actualNode);
    assertArrayEquals(new String[]{"ABC123"}, actualTokens);
  }

  /**
   * Test {@link JsonPathProcessingTask#isLast()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#isLast()}
   */
  @Test
  public void testIsLast_givenHashMapComputeIfPresentFooAndBiFunction_thenReturnTrue() {
    // Arrange
    HashMap<String, String> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertTrue((new JsonPathProcessingTask(new String[]{"ABC123"}, variables,
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)).isLast());
  }

  /**
   * Test {@link JsonPathProcessingTask#isLast()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#isLast()}
   */
  @Test
  public void testIsLast_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse((new JsonPathProcessingTask(new String[]{}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)).isLast());
  }

  /**
   * Test {@link JsonPathProcessingTask#isLast()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#isLast()}
   */
  @Test
  public void testIsLast_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue((new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)).isLast());
  }

  /**
   * Test {@link JsonPathProcessingTask#currentToken()}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   *   <li>Then return {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#currentToken()}
   */
  @Test
  public void testCurrentToken_givenHashMapComputeIfPresentFooAndBiFunction_thenReturnAbc123() {
    // Arrange
    HashMap<String, String> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));

    // Act and Assert
    assertEquals("ABC123", (new JsonPathProcessingTask(new String[]{"ABC123"}, variables,
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)).currentToken());
  }

  /**
   * Test {@link JsonPathProcessingTask#currentToken()}.
   * <ul>
   *   <li>Then return {@code ABC123}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#currentToken()}
   */
  @Test
  public void testCurrentToken_thenReturnAbc123() {
    // Arrange, Act and Assert
    assertEquals("ABC123", (new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)).currentToken());
  }

  /**
   * Test {@link JsonPathProcessingTask#next(JsonNode, String, String)} with
   * {@code next}, {@code key}, {@code value}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonPathProcessingTask#next(JsonNode, String, String)}
   */
  @Test
  public void testNextWithNextKeyValue_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));
    JsonNode next = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    JsonPathProcessingTask actualNextResult = (new JsonPathProcessingTask(new String[]{"ABC123"}, variables,
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)).next(next, "Key", "42");

    // Assert
    Map<String, String> variables2 = actualNextResult.getVariables();
    assertEquals(1, variables2.size());
    assertEquals("42", variables2.get("Key"));
    assertEquals(0, actualNextResult.getTokens().length);
    assertFalse(actualNextResult.isLast());
    assertSame(next, actualNextResult.getNode());
  }

  /**
   * Test {@link JsonPathProcessingTask#next(JsonNode, String, String)} with
   * {@code next}, {@code key}, {@code value}.
   * <ul>
   *   <li>Then return Variables size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link JsonPathProcessingTask#next(JsonNode, String, String)}
   */
  @Test
  public void testNextWithNextKeyValue_thenReturnVariablesSizeIsOne() {
    // Arrange
    JsonNode next = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    JsonPathProcessingTask actualNextResult = (new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)).next(next, "Key", "42");

    // Assert
    Map<String, String> variables = actualNextResult.getVariables();
    assertEquals(1, variables.size());
    assertEquals("42", variables.get("Key"));
    assertEquals(0, actualNextResult.getTokens().length);
    assertFalse(actualNextResult.isLast());
    assertSame(next, actualNextResult.getNode());
  }

  /**
   * Test {@link JsonPathProcessingTask#next(JsonNode)} with {@code next}.
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} computeIfPresent {@code foo} and
   * {@link BiFunction}.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#next(JsonNode)}
   */
  @Test
  public void testNextWithNext_givenHashMapComputeIfPresentFooAndBiFunction() {
    // Arrange
    HashMap<String, String> variables = new HashMap<>();
    variables.computeIfPresent("foo", mock(BiFunction.class));
    JsonNode next = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    JsonPathProcessingTask actualNextResult = (new JsonPathProcessingTask(new String[]{"ABC123"}, variables,
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)).next(next);

    // Assert
    assertEquals(0, actualNextResult.getTokens().length);
    assertFalse(actualNextResult.isLast());
    assertTrue(actualNextResult.getVariables().isEmpty());
    assertSame(next, actualNextResult.getNode());
  }

  /**
   * Test {@link JsonPathProcessingTask#next(JsonNode)} with {@code next}.
   * <ul>
   *   <li>Then return array length is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link JsonPathProcessingTask#next(JsonNode)}
   */
  @Test
  public void testNextWithNext_thenReturnArrayLengthIsZero() {
    // Arrange
    JsonNode next = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;

    // Act
    JsonPathProcessingTask actualNextResult = (new JsonPathProcessingTask(new String[]{"ABC123"}, new HashMap<>(),
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON)).next(next);

    // Assert
    assertEquals(0, actualNextResult.getTokens().length);
    assertFalse(actualNextResult.isLast());
    assertTrue(actualNextResult.getVariables().isEmpty());
    assertSame(next, actualNextResult.getNode());
  }
}
