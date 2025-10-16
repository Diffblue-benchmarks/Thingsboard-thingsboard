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
package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mvel2.ExecutionContext;
import org.mvel2.ParserContext;

class TbJsonDiffblueTest {
  /**
   * Test {@link TbJson#stringify(Object)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code "42"}.
   * </ul>
   *
   * <p>Method under test: {@link TbJson#stringify(Object)}
   */
  @Test
  @DisplayName("Test stringify(Object); when '42'; then return '\"42\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbJson.stringify(Object)"})
  void testStringify_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("\"42\"", TbJson.stringify("42"));
  }

  /**
   * Test {@link TbJson#stringify(Object)}.
   *
   * <ul>
   *   <li>When forty-two.
   *   <li>Then return {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbJson#stringify(Object)}
   */
  @Test
  @DisplayName("Test stringify(Object); when forty-two; then return '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbJson.stringify(Object)"})
  void testStringify_whenFortyTwo_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", TbJson.stringify(42));
  }

  /**
   * Test {@link TbJson#stringify(Object)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbJson#stringify(Object)}
   */
  @Test
  @DisplayName("Test stringify(Object); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbJson.stringify(Object)"})
  void testStringify_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", TbJson.stringify(null));
  }

  /**
   * Test {@link TbJson#stringify(Object)}.
   *
   * <ul>
   *   <li>When {@code Value}.
   *   <li>Then return {@code "Value"}.
   * </ul>
   *
   * <p>Method under test: {@link TbJson#stringify(Object)}
   */
  @Test
  @DisplayName("Test stringify(Object); when 'Value'; then return '\"Value\"'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbJson.stringify(Object)"})
  void testStringify_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("\"Value\"", TbJson.stringify("Value"));
  }

  /**
   * Test {@link TbJson#parse(ExecutionContext, String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbJson#parse(ExecutionContext, String)}
   */
  @Test
  @DisplayName("Test parse(ExecutionContext, String); when '42'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbJson.parse(ExecutionContext, String)"})
  void testParse_when42_thenReturnIntValueIsFortyTwo() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        42,
        ((Integer) TbJson.parse(new ExecutionContext(ParserContext.enableSandboxedMode()), "42"))
            .intValue());
  }

  /**
   * Test {@link TbJson#parse(ExecutionContext, String)}.
   *
   * <ul>
   *   <li>When {@link ExecutionContext#ExecutionContext(SandboxedParserConfiguration)} with
   *       parserConfig is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbJson#parse(ExecutionContext, String)}
   */
  @Test
  @DisplayName(
      "Test parse(ExecutionContext, String); when ExecutionContext(SandboxedParserConfiguration) with parserConfig is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbJson.parse(ExecutionContext, String)"})
  void testParse_whenExecutionContextWithParserConfigIsNull() throws IOException {
    // Arrange, Act and Assert
    assertEquals(42, ((Integer) TbJson.parse(new ExecutionContext(null), "42")).intValue());
  }

  /**
   * Test {@link TbJson#parse(ExecutionContext, String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbJson#parse(ExecutionContext, String)}
   */
  @Test
  @DisplayName("Test parse(ExecutionContext, String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbJson.parse(ExecutionContext, String)"})
  void testParse_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(TbJson.parse(new ExecutionContext(ParserContext.enableSandboxedMode()), null));
  }
}
