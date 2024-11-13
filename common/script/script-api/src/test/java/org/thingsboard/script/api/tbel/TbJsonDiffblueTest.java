package org.thingsboard.script.api.tbel;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mvel2.ExecutionContext;
import org.mvel2.ParserContext;

class TbJsonDiffblueTest {
  /**
   * Test {@link TbJson#stringify(Object)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code "42"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJson#stringify(Object)}
   */
  @Test
  @DisplayName("Test stringify(Object); when '42'; then return '\"42\"'")
  void testStringify_when42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("\"42\"", TbJson.stringify("42"));
  }

  /**
   * Test {@link TbJson#stringify(Object)}.
   * <ul>
   *   <li>When forty-two.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJson#stringify(Object)}
   */
  @Test
  @DisplayName("Test stringify(Object); when forty-two; then return '42'")
  void testStringify_whenFortyTwo_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", TbJson.stringify(42));
  }

  /**
   * Test {@link TbJson#stringify(Object)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJson#stringify(Object)}
   */
  @Test
  @DisplayName("Test stringify(Object); when 'null'; then return 'null'")
  void testStringify_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertEquals("null", TbJson.stringify(null));
  }

  /**
   * Test {@link TbJson#stringify(Object)}.
   * <ul>
   *   <li>When {@code Value}.</li>
   *   <li>Then return {@code "Value"}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJson#stringify(Object)}
   */
  @Test
  @DisplayName("Test stringify(Object); when 'Value'; then return '\"Value\"'")
  void testStringify_whenValue_thenReturnValue() {
    // Arrange, Act and Assert
    assertEquals("\"Value\"", TbJson.stringify("Value"));
  }

  /**
   * Test {@link TbJson#parse(ExecutionContext, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbJson#parse(ExecutionContext, String)}
   */
  @Test
  @DisplayName("Test parse(ExecutionContext, String); when 'null'; then return 'null'")
  void testParse_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(TbJson.parse(new ExecutionContext(ParserContext.enableSandboxedMode()), null));
  }
}
