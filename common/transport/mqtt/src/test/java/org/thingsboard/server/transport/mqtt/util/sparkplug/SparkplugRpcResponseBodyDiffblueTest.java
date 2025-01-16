package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder;

class SparkplugRpcResponseBodyDiffblueTest {
  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}, and
   * {@link SparkplugRpcResponseBody#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugRpcResponseBody#equals(Object)}
   *   <li>{@link SparkplugRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugRpcResponseBody buildResult = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    SparkplugRpcResponseBody buildResult2 = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}, and
   * {@link SparkplugRpcResponseBody#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugRpcResponseBody#equals(Object)}
   *   <li>{@link SparkplugRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugRpcResponseBody buildResult = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder.error(Mockito.<String>any())).thenReturn(SparkplugRpcResponseBody.builder());
    SparkplugRpcResponseBody buildResult = sparkplugRpcResponseBodyBuilder.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    SparkplugRpcResponseBody buildResult2 = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder.result(Mockito.<String>any())).thenReturn(SparkplugRpcResponseBody.builder());
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder2 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder2.error(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder);
    SparkplugRpcResponseBody buildResult = sparkplugRpcResponseBodyBuilder2.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    SparkplugRpcResponseBody buildResult2 = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder.result(Mockito.<String>any())).thenReturn(SparkplugRpcResponseBody.builder());
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder2 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder2.error(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder);
    SparkplugRpcResponseBody buildResult = sparkplugRpcResponseBodyBuilder2.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    SparkplugRpcResponseBody buildResult2 = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result(null)
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder.value(Mockito.<String>any())).thenReturn(SparkplugRpcResponseBody.builder());
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder2 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder2.result(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder);
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder3 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder3.error(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder2);
    SparkplugRpcResponseBody buildResult = sparkplugRpcResponseBodyBuilder3.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    SparkplugRpcResponseBody buildResult2 = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result(null)
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    SparkplugRpcResponseBody buildResult = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    when(sparkplugRpcResponseBodyBuilder.build()).thenReturn(buildResult);
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder2 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder2.value(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder);
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder3 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder3.result(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder2);
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder4 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder4.error(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder3);
    SparkplugRpcResponseBody buildResult2 = sparkplugRpcResponseBodyBuilder4.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    SparkplugRpcResponseBody buildResult3 = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result(null)
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    SparkplugRpcResponseBody buildResult = SparkplugRpcResponseBody.builder()
        .error("Error")
        .result("Result")
        .value("42")
        .build();
    when(sparkplugRpcResponseBodyBuilder.build()).thenReturn(buildResult);
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder2 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder2.value(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder);
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder3 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder3.result(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder2);
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder4 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder4.error(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder3);
    SparkplugRpcResponseBody buildResult2 = sparkplugRpcResponseBodyBuilder4.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    SparkplugRpcResponseBody buildResult3 = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    SparkplugRpcResponseBody buildResult = SparkplugRpcResponseBody.builder()
        .error("Error")
        .result("Result")
        .value("Result")
        .build();
    when(sparkplugRpcResponseBodyBuilder.build()).thenReturn(buildResult);
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder2 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder2.value(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder);
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder3 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder3.result(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder2);
    SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder4 = mock(
        SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder4.error(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder3);
    SparkplugRpcResponseBody buildResult2 = sparkplugRpcResponseBodyBuilder4.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    SparkplugRpcResponseBody buildResult3 = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SparkplugRpcResponseBody buildResult = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SparkplugRpcResponseBody buildResult = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to SparkplugRpcResponseBody");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SparkplugRpcResponseBody#SparkplugRpcResponseBody(String, String, String)}
   *   <li>{@link SparkplugRpcResponseBody#setError(String)}
   *   <li>{@link SparkplugRpcResponseBody#setResult(String)}
   *   <li>{@link SparkplugRpcResponseBody#setValue(String)}
   *   <li>{@link SparkplugRpcResponseBody#toString()}
   *   <li>{@link SparkplugRpcResponseBody#getError()}
   *   <li>{@link SparkplugRpcResponseBody#getResult()}
   *   <li>{@link SparkplugRpcResponseBody#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    SparkplugRpcResponseBody actualSparkplugRpcResponseBody = new SparkplugRpcResponseBody("Result", "42",
        "An error occurred");
    actualSparkplugRpcResponseBody.setError("An error occurred");
    actualSparkplugRpcResponseBody.setResult("Result");
    actualSparkplugRpcResponseBody.setValue("42");
    String actualToStringResult = actualSparkplugRpcResponseBody.toString();
    String actualError = actualSparkplugRpcResponseBody.getError();
    String actualResult = actualSparkplugRpcResponseBody.getResult();

    // Assert that nothing has changed
    assertEquals("42", actualSparkplugRpcResponseBody.getValue());
    assertEquals("An error occurred", actualError);
    assertEquals("Result", actualResult);
    assertEquals("SparkplugRpcResponseBody(result=Result, value=42, error=An error occurred)", actualToStringResult);
  }

  /**
   * Test SparkplugRpcResponseBodyBuilder
   * {@link SparkplugRpcResponseBodyBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder#build()}
   *   <li>
   * {@link SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder#error(String)}
   *   <li>
   * {@link SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder#result(String)}
   *   <li>
   * {@link SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder#value(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test SparkplugRpcResponseBodyBuilder build()")
  void testSparkplugRpcResponseBodyBuilderBuild() {
    // Arrange and Act
    SparkplugRpcResponseBody actualBuildResult = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Assert
    assertEquals("42", actualBuildResult.getValue());
    assertEquals("An error occurred", actualBuildResult.getError());
    assertEquals("Result", actualBuildResult.getResult());
  }
}
