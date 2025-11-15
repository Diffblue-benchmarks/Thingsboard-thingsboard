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
package org.thingsboard.server.transport.mqtt.util.sparkplug;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.transport.mqtt.util.sparkplug.SparkplugRpcResponseBody.SparkplugRpcResponseBodyBuilder;

@ContextConfiguration(classes = {SparkplugRpcResponseBodyBuilder.class})
@ExtendWith(SpringExtension.class)
class SparkplugRpcResponseBodyDiffblueTest {
  @Autowired
  private SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder;

  /**
   * Test {@link SparkplugRpcResponseBody#equals(Object)}, and {@link SparkplugRpcResponseBody#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugRpcResponseBody.equals(Object)", "int SparkplugRpcResponseBody.hashCode()"})
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
   * Test {@link SparkplugRpcResponseBody#equals(Object)}, and {@link SparkplugRpcResponseBody#hashCode()}.
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugRpcResponseBody.equals(Object)", "int SparkplugRpcResponseBody.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugRpcResponseBody.equals(Object)", "int SparkplugRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(SparkplugRpcResponseBodyBuilder.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugRpcResponseBody.equals(Object)", "int SparkplugRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder.result(Mockito.<String>any())).thenReturn(SparkplugRpcResponseBody.builder());
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder2 = mock(SparkplugRpcResponseBodyBuilder.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugRpcResponseBody.equals(Object)", "int SparkplugRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder.result(Mockito.<String>any())).thenReturn(SparkplugRpcResponseBody.builder());
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder2 = mock(SparkplugRpcResponseBodyBuilder.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugRpcResponseBody.equals(Object)", "int SparkplugRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder.value(Mockito.<String>any())).thenReturn(SparkplugRpcResponseBody.builder());
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder2 = mock(SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder2.result(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder);
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder3 = mock(SparkplugRpcResponseBodyBuilder.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugRpcResponseBody.equals(Object)", "int SparkplugRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(SparkplugRpcResponseBodyBuilder.class);
    SparkplugRpcResponseBody buildResult = SparkplugRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    when(sparkplugRpcResponseBodyBuilder.build()).thenReturn(buildResult);
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder2 = mock(SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder2.value(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder);
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder3 = mock(SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder3.result(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder2);
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder4 = mock(SparkplugRpcResponseBodyBuilder.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugRpcResponseBody.equals(Object)", "int SparkplugRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(SparkplugRpcResponseBodyBuilder.class);
    SparkplugRpcResponseBody buildResult = SparkplugRpcResponseBody.builder()
        .error("Error")
        .result("Result")
        .value("42")
        .build();
    when(sparkplugRpcResponseBodyBuilder.build()).thenReturn(buildResult);
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder2 = mock(SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder2.value(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder);
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder3 = mock(SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder3.result(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder2);
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder4 = mock(SparkplugRpcResponseBodyBuilder.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugRpcResponseBody.equals(Object)", "int SparkplugRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder = mock(SparkplugRpcResponseBodyBuilder.class);
    SparkplugRpcResponseBody buildResult = SparkplugRpcResponseBody.builder()
        .error("Error")
        .result("Result")
        .value("Result")
        .build();
    when(sparkplugRpcResponseBodyBuilder.build()).thenReturn(buildResult);
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder2 = mock(SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder2.value(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder);
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder3 = mock(SparkplugRpcResponseBodyBuilder.class);
    when(sparkplugRpcResponseBodyBuilder3.result(Mockito.<String>any())).thenReturn(sparkplugRpcResponseBodyBuilder2);
    SparkplugRpcResponseBodyBuilder sparkplugRpcResponseBodyBuilder4 = mock(SparkplugRpcResponseBodyBuilder.class);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugRpcResponseBody.equals(Object)", "int SparkplugRpcResponseBody.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean SparkplugRpcResponseBody.equals(Object)", "int SparkplugRpcResponseBody.hashCode()"})
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SparkplugRpcResponseBody.<init>(String, String, String)",
      "String SparkplugRpcResponseBody.getError()", "String SparkplugRpcResponseBody.getResult()",
      "String SparkplugRpcResponseBody.getValue()", "void SparkplugRpcResponseBody.setError(String)",
      "void SparkplugRpcResponseBody.setResult(String)", "void SparkplugRpcResponseBody.setValue(String)",
      "String SparkplugRpcResponseBody.toString()"})
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

    // Assert
    assertEquals("42", actualSparkplugRpcResponseBody.getValue());
    assertEquals("An error occurred", actualError);
    assertEquals("Result", actualResult);
    assertEquals("SparkplugRpcResponseBody(result=Result, value=42, error=An error occurred)", actualToStringResult);
  }

  /**
   * Test SparkplugRpcResponseBodyBuilder {@link SparkplugRpcResponseBodyBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SparkplugRpcResponseBodyBuilder#build()}
   *   <li>{@link SparkplugRpcResponseBodyBuilder#error(String)}
   *   <li>{@link SparkplugRpcResponseBodyBuilder#result(String)}
   *   <li>{@link SparkplugRpcResponseBodyBuilder#value(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test SparkplugRpcResponseBodyBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SparkplugRpcResponseBodyBuilder.<init>()",
      "SparkplugRpcResponseBody SparkplugRpcResponseBodyBuilder.build()",
      "SparkplugRpcResponseBodyBuilder SparkplugRpcResponseBodyBuilder.error(String)",
      "SparkplugRpcResponseBodyBuilder SparkplugRpcResponseBodyBuilder.result(String)",
      "String SparkplugRpcResponseBodyBuilder.toString()",
      "SparkplugRpcResponseBodyBuilder SparkplugRpcResponseBodyBuilder.value(String)"})
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
