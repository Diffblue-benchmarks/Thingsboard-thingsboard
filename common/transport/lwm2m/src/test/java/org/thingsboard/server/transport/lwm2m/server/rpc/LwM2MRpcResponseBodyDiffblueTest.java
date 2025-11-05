package org.thingsboard.server.transport.lwm2m.server.rpc;

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
import org.thingsboard.server.transport.lwm2m.server.rpc.LwM2MRpcResponseBody.LwM2MRpcResponseBodyBuilder;

@ContextConfiguration(classes = {LwM2MRpcResponseBodyBuilder.class})
@ExtendWith(SpringExtension.class)
class LwM2MRpcResponseBodyDiffblueTest {
  @Autowired private LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder;

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}, and {@link LwM2MRpcResponseBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MRpcResponseBody#equals(Object)}
   *   <li>{@link LwM2MRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MRpcResponseBody lwM2MRpcResponseBody =
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build();
    LwM2MRpcResponseBody lwM2MRpcResponseBody2 =
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(lwM2MRpcResponseBody, lwM2MRpcResponseBody2);
    assertEquals(lwM2MRpcResponseBody.hashCode(), lwM2MRpcResponseBody2.hashCode());
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}, and {@link LwM2MRpcResponseBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MRpcResponseBody#equals(Object)}
   *   <li>{@link LwM2MRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    LwM2MRpcResponseBody lwM2MRpcResponseBody =
        LwM2MRpcResponseBody.builder().error(null).result("Result").value("42").build();
    LwM2MRpcResponseBody lwM2MRpcResponseBody2 =
        LwM2MRpcResponseBody.builder().error(null).result("Result").value("42").build();

    // Act and Assert
    assertEquals(lwM2MRpcResponseBody, lwM2MRpcResponseBody2);
    assertEquals(lwM2MRpcResponseBody.hashCode(), lwM2MRpcResponseBody2.hashCode());
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}, and {@link LwM2MRpcResponseBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MRpcResponseBody#equals(Object)}
   *   <li>{@link LwM2MRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    LwM2MRpcResponseBody lwM2MRpcResponseBody =
        LwM2MRpcResponseBody.builder().error("An error occurred").result(null).value("42").build();
    LwM2MRpcResponseBody lwM2MRpcResponseBody2 =
        LwM2MRpcResponseBody.builder().error("An error occurred").result(null).value("42").build();

    // Act and Assert
    assertEquals(lwM2MRpcResponseBody, lwM2MRpcResponseBody2);
    assertEquals(lwM2MRpcResponseBody.hashCode(), lwM2MRpcResponseBody2.hashCode());
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}, and {@link LwM2MRpcResponseBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MRpcResponseBody#equals(Object)}
   *   <li>{@link LwM2MRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    LwM2MRpcResponseBody lwM2MRpcResponseBody =
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value(null)
            .build();
    LwM2MRpcResponseBody lwM2MRpcResponseBody2 =
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value(null)
            .build();

    // Act and Assert
    assertEquals(lwM2MRpcResponseBody, lwM2MRpcResponseBody2);
    assertEquals(lwM2MRpcResponseBody.hashCode(), lwM2MRpcResponseBody2.hashCode());
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}, and {@link LwM2MRpcResponseBody#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MRpcResponseBody#equals(Object)}
   *   <li>{@link LwM2MRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MRpcResponseBody lwM2MRpcResponseBody =
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build();

    // Act and Assert
    assertEquals(lwM2MRpcResponseBody, lwM2MRpcResponseBody);
    int expectedHashCodeResult = lwM2MRpcResponseBody.hashCode();
    assertEquals(expectedHashCodeResult, lwM2MRpcResponseBody.hashCode());
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MRpcResponseBody lwM2MRpcResponseBody =
        LwM2MRpcResponseBody.builder().error("Result").result("Result").value("42").build();

    // Act and Assert
    assertNotEquals(
        lwM2MRpcResponseBody,
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build());
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MRpcResponseBody lwM2MRpcResponseBody =
        LwM2MRpcResponseBody.builder().error(null).result("Result").value("42").build();

    // Act and Assert
    assertNotEquals(
        lwM2MRpcResponseBody,
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build());
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MRpcResponseBody lwM2MRpcResponseBody =
        LwM2MRpcResponseBody.builder().error("An error occurred").result("42").value("42").build();

    // Act and Assert
    assertNotEquals(
        lwM2MRpcResponseBody,
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build());
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MRpcResponseBody lwM2MRpcResponseBody =
        LwM2MRpcResponseBody.builder().error("An error occurred").result(null).value("42").build();

    // Act and Assert
    assertNotEquals(
        lwM2MRpcResponseBody,
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build());
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2MRpcResponseBody lwM2MRpcResponseBody =
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("Result")
            .build();

    // Act and Assert
    assertNotEquals(
        lwM2MRpcResponseBody,
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build());
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2MRpcResponseBody lwM2MRpcResponseBody =
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value(null)
            .build();

    // Act and Assert
    assertNotEquals(
        lwM2MRpcResponseBody,
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build());
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build(),
        null);
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean LwM2MRpcResponseBody.equals(Object)",
    "int LwM2MRpcResponseBody.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build(),
        "Different type to LwM2MRpcResponseBody");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MRpcResponseBody#LwM2MRpcResponseBody(String, String, String)}
   *   <li>{@link LwM2MRpcResponseBody#setError(String)}
   *   <li>{@link LwM2MRpcResponseBody#setResult(String)}
   *   <li>{@link LwM2MRpcResponseBody#setValue(String)}
   *   <li>{@link LwM2MRpcResponseBody#toString()}
   *   <li>{@link LwM2MRpcResponseBody#getError()}
   *   <li>{@link LwM2MRpcResponseBody#getResult()}
   *   <li>{@link LwM2MRpcResponseBody#getValue()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MRpcResponseBody.<init>(String, String, String)",
    "String LwM2MRpcResponseBody.getError()",
    "String LwM2MRpcResponseBody.getResult()",
    "String LwM2MRpcResponseBody.getValue()",
    "void LwM2MRpcResponseBody.setError(String)",
    "void LwM2MRpcResponseBody.setResult(String)",
    "void LwM2MRpcResponseBody.setValue(String)",
    "String LwM2MRpcResponseBody.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MRpcResponseBody actualLwM2MRpcResponseBody =
        new LwM2MRpcResponseBody("Result", "42", "An error occurred");
    actualLwM2MRpcResponseBody.setError("An error occurred");
    actualLwM2MRpcResponseBody.setResult("Result");
    actualLwM2MRpcResponseBody.setValue("42");
    String actualToStringResult = actualLwM2MRpcResponseBody.toString();
    String actualError = actualLwM2MRpcResponseBody.getError();
    String actualResult = actualLwM2MRpcResponseBody.getResult();

    // Assert
    assertEquals("42", actualLwM2MRpcResponseBody.getValue());
    assertEquals("An error occurred", actualError);
    assertEquals(
        "LwM2MRpcResponseBody(result=Result, value=42, error=An error occurred)",
        actualToStringResult);
    assertEquals("Result", actualResult);
  }

  /**
   * Test LwM2MRpcResponseBodyBuilder {@link LwM2MRpcResponseBodyBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LwM2MRpcResponseBodyBuilder#build()}
   *   <li>{@link LwM2MRpcResponseBodyBuilder#error(String)}
   *   <li>{@link LwM2MRpcResponseBodyBuilder#result(String)}
   *   <li>{@link LwM2MRpcResponseBodyBuilder#value(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test LwM2MRpcResponseBodyBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void LwM2MRpcResponseBodyBuilder.<init>()",
    "LwM2MRpcResponseBody LwM2MRpcResponseBodyBuilder.build()",
    "LwM2MRpcResponseBodyBuilder LwM2MRpcResponseBodyBuilder.error(String)",
    "LwM2MRpcResponseBodyBuilder LwM2MRpcResponseBodyBuilder.result(String)",
    "String LwM2MRpcResponseBodyBuilder.toString()",
    "LwM2MRpcResponseBodyBuilder LwM2MRpcResponseBodyBuilder.value(String)"
  })
  void testLwM2MRpcResponseBodyBuilderBuild() {
    // Arrange and Act
    LwM2MRpcResponseBody actualLwM2MRpcResponseBody =
        LwM2MRpcResponseBody.builder()
            .error("An error occurred")
            .result("Result")
            .value("42")
            .build();

    // Assert
    assertEquals("42", actualLwM2MRpcResponseBody.getValue());
    assertEquals("An error occurred", actualLwM2MRpcResponseBody.getError());
    assertEquals("Result", actualLwM2MRpcResponseBody.getResult());
  }
}
