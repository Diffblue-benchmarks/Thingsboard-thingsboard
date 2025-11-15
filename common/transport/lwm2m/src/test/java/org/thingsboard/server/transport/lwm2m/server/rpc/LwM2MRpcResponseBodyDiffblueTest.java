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
package org.thingsboard.server.transport.lwm2m.server.rpc;

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
import org.thingsboard.server.transport.lwm2m.server.rpc.LwM2MRpcResponseBody.LwM2MRpcResponseBodyBuilder;

@ContextConfiguration(classes = {LwM2MRpcResponseBodyBuilder.class})
@ExtendWith(SpringExtension.class)
class LwM2MRpcResponseBodyDiffblueTest {
  @Autowired
  private LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder;

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}, and {@link LwM2MRpcResponseBody#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MRpcResponseBody#equals(Object)}
   *   <li>{@link LwM2MRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcResponseBody.equals(Object)", "int LwM2MRpcResponseBody.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    LwM2MRpcResponseBody buildResult = LwM2MRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    LwM2MRpcResponseBody buildResult2 = LwM2MRpcResponseBody.builder()
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
   * Test {@link LwM2MRpcResponseBody#equals(Object)}, and {@link LwM2MRpcResponseBody#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MRpcResponseBody#equals(Object)}
   *   <li>{@link LwM2MRpcResponseBody#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcResponseBody.equals(Object)", "int LwM2MRpcResponseBody.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    LwM2MRpcResponseBody buildResult = LwM2MRpcResponseBody.builder()
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
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcResponseBody.equals(Object)", "int LwM2MRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder.error(Mockito.<String>any())).thenReturn(LwM2MRpcResponseBody.builder());
    LwM2MRpcResponseBody buildResult = lwM2MRpcResponseBodyBuilder.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    LwM2MRpcResponseBody buildResult2 = LwM2MRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcResponseBody.equals(Object)", "int LwM2MRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder.result(Mockito.<String>any())).thenReturn(LwM2MRpcResponseBody.builder());
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder2 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder2.error(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder);
    LwM2MRpcResponseBody buildResult = lwM2MRpcResponseBodyBuilder2.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    LwM2MRpcResponseBody buildResult2 = LwM2MRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcResponseBody.equals(Object)", "int LwM2MRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder.result(Mockito.<String>any())).thenReturn(LwM2MRpcResponseBody.builder());
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder2 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder2.error(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder);
    LwM2MRpcResponseBody buildResult = lwM2MRpcResponseBodyBuilder2.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    LwM2MRpcResponseBody buildResult2 = LwM2MRpcResponseBody.builder()
        .error("An error occurred")
        .result(null)
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcResponseBody.equals(Object)", "int LwM2MRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder.value(Mockito.<String>any())).thenReturn(LwM2MRpcResponseBody.builder());
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder2 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder2.result(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder);
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder3 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder3.error(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder2);
    LwM2MRpcResponseBody buildResult = lwM2MRpcResponseBodyBuilder3.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    LwM2MRpcResponseBody buildResult2 = LwM2MRpcResponseBody.builder()
        .error("An error occurred")
        .result(null)
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcResponseBody.equals(Object)", "int LwM2MRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder = mock(LwM2MRpcResponseBodyBuilder.class);
    LwM2MRpcResponseBody buildResult = LwM2MRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    when(lwM2MRpcResponseBodyBuilder.build()).thenReturn(buildResult);
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder2 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder2.value(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder);
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder3 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder3.result(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder2);
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder4 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder4.error(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder3);
    LwM2MRpcResponseBody buildResult2 = lwM2MRpcResponseBodyBuilder4.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    LwM2MRpcResponseBody buildResult3 = LwM2MRpcResponseBody.builder()
        .error("An error occurred")
        .result(null)
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcResponseBody.equals(Object)", "int LwM2MRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder = mock(LwM2MRpcResponseBodyBuilder.class);
    LwM2MRpcResponseBody buildResult = LwM2MRpcResponseBody.builder()
        .error("Error")
        .result("Result")
        .value("42")
        .build();
    when(lwM2MRpcResponseBodyBuilder.build()).thenReturn(buildResult);
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder2 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder2.value(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder);
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder3 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder3.result(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder2);
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder4 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder4.error(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder3);
    LwM2MRpcResponseBody buildResult2 = lwM2MRpcResponseBodyBuilder4.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    LwM2MRpcResponseBody buildResult3 = LwM2MRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcResponseBody.equals(Object)", "int LwM2MRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder = mock(LwM2MRpcResponseBodyBuilder.class);
    LwM2MRpcResponseBody buildResult = LwM2MRpcResponseBody.builder()
        .error("Error")
        .result("Result")
        .value("Result")
        .build();
    when(lwM2MRpcResponseBodyBuilder.build()).thenReturn(buildResult);
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder2 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder2.value(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder);
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder3 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder3.result(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder2);
    LwM2MRpcResponseBodyBuilder lwM2MRpcResponseBodyBuilder4 = mock(LwM2MRpcResponseBodyBuilder.class);
    when(lwM2MRpcResponseBodyBuilder4.error(Mockito.<String>any())).thenReturn(lwM2MRpcResponseBodyBuilder3);
    LwM2MRpcResponseBody buildResult2 = lwM2MRpcResponseBodyBuilder4.error("An error occurred")
        .result("Result")
        .value("42")
        .build();
    LwM2MRpcResponseBody buildResult3 = LwM2MRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcResponseBody.equals(Object)", "int LwM2MRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    LwM2MRpcResponseBody buildResult = LwM2MRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link LwM2MRpcResponseBody#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MRpcResponseBody#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean LwM2MRpcResponseBody.equals(Object)", "int LwM2MRpcResponseBody.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    LwM2MRpcResponseBody buildResult = LwM2MRpcResponseBody.builder()
        .error("An error occurred")
        .result("Result")
        .value("42")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to LwM2MRpcResponseBody");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MRpcResponseBody.<init>(String, String, String)",
      "String LwM2MRpcResponseBody.getError()", "String LwM2MRpcResponseBody.getResult()",
      "String LwM2MRpcResponseBody.getValue()", "void LwM2MRpcResponseBody.setError(String)",
      "void LwM2MRpcResponseBody.setResult(String)", "void LwM2MRpcResponseBody.setValue(String)",
      "String LwM2MRpcResponseBody.toString()"})
  void testGettersAndSetters() {
    // Arrange and Act
    LwM2MRpcResponseBody actualLwM2MRpcResponseBody = new LwM2MRpcResponseBody("Result", "42", "An error occurred");
    actualLwM2MRpcResponseBody.setError("An error occurred");
    actualLwM2MRpcResponseBody.setResult("Result");
    actualLwM2MRpcResponseBody.setValue("42");
    String actualToStringResult = actualLwM2MRpcResponseBody.toString();
    String actualError = actualLwM2MRpcResponseBody.getError();
    String actualResult = actualLwM2MRpcResponseBody.getResult();

    // Assert
    assertEquals("42", actualLwM2MRpcResponseBody.getValue());
    assertEquals("An error occurred", actualError);
    assertEquals("LwM2MRpcResponseBody(result=Result, value=42, error=An error occurred)", actualToStringResult);
    assertEquals("Result", actualResult);
  }

  /**
   * Test LwM2MRpcResponseBodyBuilder {@link LwM2MRpcResponseBodyBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MRpcResponseBodyBuilder#build()}
   *   <li>{@link LwM2MRpcResponseBodyBuilder#error(String)}
   *   <li>{@link LwM2MRpcResponseBodyBuilder#result(String)}
   *   <li>{@link LwM2MRpcResponseBodyBuilder#value(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test LwM2MRpcResponseBodyBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void LwM2MRpcResponseBodyBuilder.<init>()",
      "LwM2MRpcResponseBody LwM2MRpcResponseBodyBuilder.build()",
      "LwM2MRpcResponseBodyBuilder LwM2MRpcResponseBodyBuilder.error(String)",
      "LwM2MRpcResponseBodyBuilder LwM2MRpcResponseBodyBuilder.result(String)",
      "String LwM2MRpcResponseBodyBuilder.toString()",
      "LwM2MRpcResponseBodyBuilder LwM2MRpcResponseBodyBuilder.value(String)"})
  void testLwM2MRpcResponseBodyBuilderBuild() {
    // Arrange and Act
    LwM2MRpcResponseBody actualBuildResult = LwM2MRpcResponseBody.builder()
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
