package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder;

@ContextConfiguration(classes = {SparkplugRpcResponseBodyBuilder.class})
@ExtendWith(SpringExtension.class)
class SparkplugRpcResponseBodyDiffblueTest {
  @Autowired private SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder;

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}, and {@link
   * SparkplugRpcResponseBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugRpcResponseBody#equals(Object)}
   *   <li>{@link SparkplugRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SparkplugRpcResponseBody sparkplugRpcResponseBody =
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build();
    SparkplugRpcResponseBody sparkplugRpcResponseBody2 =
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(sparkplugRpcResponseBody, sparkplugRpcResponseBody2);
    assertEquals(sparkplugRpcResponseBody.hashCode(), sparkplugRpcResponseBody2.hashCode());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}, and {@link
   * SparkplugRpcResponseBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugRpcResponseBody#equals(Object)}
   *   <li>{@link SparkplugRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SparkplugRpcResponseBody sparkplugRpcResponseBody =
        SparkplugRpcResponseBody.builder().error(null).result("Result").value("42").build();
    SparkplugRpcResponseBody sparkplugRpcResponseBody2 =
        SparkplugRpcResponseBody.builder().error(null).result("Result").value("42").build();

    // Act and Assert
    assertEquals(sparkplugRpcResponseBody, sparkplugRpcResponseBody2);
    assertEquals(sparkplugRpcResponseBody.hashCode(), sparkplugRpcResponseBody2.hashCode());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}, and {@link
   * SparkplugRpcResponseBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugRpcResponseBody#equals(Object)}
   *   <li>{@link SparkplugRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SparkplugRpcResponseBody sparkplugRpcResponseBody =
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result(null)
            .value("42")
            .build();
    SparkplugRpcResponseBody sparkplugRpcResponseBody2 =
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result(null)
            .value("42")
            .build();

    // Act and Assert
    assertEquals(sparkplugRpcResponseBody, sparkplugRpcResponseBody2);
    assertEquals(sparkplugRpcResponseBody.hashCode(), sparkplugRpcResponseBody2.hashCode());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}, and {@link
   * SparkplugRpcResponseBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugRpcResponseBody#equals(Object)}
   *   <li>{@link SparkplugRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SparkplugRpcResponseBody sparkplugRpcResponseBody =
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value(null)
            .build();
    SparkplugRpcResponseBody sparkplugRpcResponseBody2 =
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value(null)
            .build();

    // Act and Assert
    assertEquals(sparkplugRpcResponseBody, sparkplugRpcResponseBody2);
    assertEquals(sparkplugRpcResponseBody.hashCode(), sparkplugRpcResponseBody2.hashCode());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}, and {@link
   * SparkplugRpcResponseBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugRpcResponseBody#equals(Object)}
   *   <li>{@link SparkplugRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SparkplugRpcResponseBody sparkplugRpcResponseBody =
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(sparkplugRpcResponseBody, sparkplugRpcResponseBody);
    int expectedHashCodeResult = sparkplugRpcResponseBody.hashCode();
    assertEquals(expectedHashCodeResult, sparkplugRpcResponseBody.hashCode());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SparkplugRpcResponseBody sparkplugRpcResponseBody =
        SparkplugRpcResponseBody.builder().error("Result").result("Result").value("42").build();

    // Act and Assert
    assertNotEquals(
        sparkplugRpcResponseBody,
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SparkplugRpcResponseBody sparkplugRpcResponseBody =
        SparkplugRpcResponseBody.builder().error(null).result("Result").value("42").build();

    // Act and Assert
    assertNotEquals(
        sparkplugRpcResponseBody,
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SparkplugRpcResponseBody sparkplugRpcResponseBody =
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("42")
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        sparkplugRpcResponseBody,
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SparkplugRpcResponseBody sparkplugRpcResponseBody =
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result(null)
            .value("42")
            .build();

    // Act and Assert
    assertNotEquals(
        sparkplugRpcResponseBody,
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SparkplugRpcResponseBody sparkplugRpcResponseBody =
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("Result")
            .build();

    // Act and Assert
    assertNotEquals(
        sparkplugRpcResponseBody,
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SparkplugRpcResponseBody sparkplugRpcResponseBody =
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value(null)
            .build();

    // Act and Assert
    assertNotEquals(
        sparkplugRpcResponseBody,
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build());
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build(),
        null);
  }

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SparkplugRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean SparkplugRpcResponseBody.equals(Object)",
    "int SparkplugRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build(),
        "Different type to SparkplugRpcResponseBody");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugRpcResponseBody#SparkplugRpcResponseBody(String, String, String)}
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
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugRpcResponseBody.<init>(String, String, String)",
    "String SparkplugRpcResponseBody.getError()",
    "String SparkplugRpcResponseBody.getResult()",
    "String SparkplugRpcResponseBody.getValue()",
    "void SparkplugRpcResponseBody.setError(String)",
    "void SparkplugRpcResponseBody.setResult(String)",
    "void SparkplugRpcResponseBody.setValue(String)",
    "String SparkplugRpcResponseBody.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SparkplugRpcResponseBody actualSparkplugRpcResponseBody =
        new SparkplugRpcResponseBody("Result", "42", "An error occurred");
    actualSparkplugRpcResponseBody.setError("An error occurred");
    actualSparkplugRpcResponseBody.setResult("Result");
    actualSparkplugRpcResponseBody.setValue("42");
    String actualToStringResult = actualSparkplugRpcResponseBody.toString();
    String actualError = actualSparkplugRpcResponseBody.getError();
    String actualResult = actualSparkplugRpcResponseBody.getResult();

    // Assert
    assertEquals("42", actualSparkplugRpcResponseBody.getValue());
    assertEquals("An error occurred", actualError);
    assertEquals("Result", actualResult);
    assertEquals(
        "SparkplugRpcResponseBody(result=Result, value=42, error=An error occurred)",
        actualToStringResult);
  }

  /**
   * Test SparkplugRpcResponseBodyBuilder {@link SparkplugRpcResponseBodyBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SparkplugRpcResponseBodyBuilder#build()}
   *   <li>{@link SparkplugRpcResponseBodyBuilder#error(String)}
   *   <li>{@link SparkplugRpcResponseBodyBuilder#result(String)}
   *   <li>{@link SparkplugRpcResponseBodyBuilder#value(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test SparkplugRpcResponseBodyBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SparkplugRpcResponseBodyBuilder.<init>()",
    "SparkplugRpcResponseBody SparkplugRpcResponseBodyBuilder.build()",
    "SparkplugRpcResponseBodyBuilder SparkplugRpcResponseBodyBuilder.error(String)",
    "SparkplugRpcResponseBodyBuilder SparkplugRpcResponseBodyBuilder.result(String)",
    "String SparkplugRpcResponseBodyBuilder.toString()",
    "SparkplugRpcResponseBodyBuilder SparkplugRpcResponseBodyBuilder.value(String)"
  })
  void testSparkplugRpcResponseBodyBuilderBuild() {
    // Arrange and Act
    SparkplugRpcResponseBody actualSparkplugRpcResponseBody =
        SparkplugRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build();

    // Assert
    assertEquals("42", actualSparkplugRpcResponseBody.getValue());
    assertEquals("An error occurred", actualSparkplugRpcResponseBody.getError());
    assertEquals("Result", actualSparkplugRpcResponseBody.getResult());
  }
}
