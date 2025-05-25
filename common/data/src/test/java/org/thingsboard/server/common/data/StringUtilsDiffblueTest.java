package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.DefaultCharAppender;
import org.mockito.Mockito;

class StringUtilsDiffblueTest {
  /**
   * Test {@link StringUtils#isEmpty(String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isEmpty(String)}
   */
  @Test
  @DisplayName("Test isEmpty(String); when EMPTY; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isEmpty(String)"})
  void testIsEmpty_whenEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isEmpty(StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#isEmpty(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isEmpty(String)}
   */
  @Test
  @DisplayName("Test isEmpty(String); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isEmpty(String)"})
  void testIsEmpty_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isEmpty(null));
  }

  /**
   * Test {@link StringUtils#isEmpty(String)}.
   * <ul>
   *   <li>When {@code Source}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isEmpty(String)}
   */
  @Test
  @DisplayName("Test isEmpty(String); when 'Source'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isEmpty(String)"})
  void testIsEmpty_whenSource_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isEmpty("Source"));
  }

  /**
   * Test {@link StringUtils#isBlank(String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isBlank(String)}
   */
  @Test
  @DisplayName("Test isBlank(String); when EMPTY; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isBlank(String)"})
  void testIsBlank_whenEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isBlank(StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#isBlank(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isBlank(String)}
   */
  @Test
  @DisplayName("Test isBlank(String); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isBlank(String)"})
  void testIsBlank_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isBlank(null));
  }

  /**
   * Test {@link StringUtils#isBlank(String)}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isBlank(String)}
   */
  @Test
  @DisplayName("Test isBlank(String); when null; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isBlank(String)"})
  void testIsBlank_whenNull_thenReturnTrue2() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isBlank("\u0000"));
  }

  /**
   * Test {@link StringUtils#isBlank(String)}.
   * <ul>
   *   <li>When {@code Source}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isBlank(String)}
   */
  @Test
  @DisplayName("Test isBlank(String); when 'Source'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isBlank(String)"})
  void testIsBlank_whenSource_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isBlank("Source"));
  }

  /**
   * Test {@link StringUtils#isNotEmpty(String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNotEmpty(String)}
   */
  @Test
  @DisplayName("Test isNotEmpty(String); when EMPTY; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNotEmpty(String)"})
  void testIsNotEmpty_whenEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isNotEmpty(StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#isNotEmpty(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNotEmpty(String)}
   */
  @Test
  @DisplayName("Test isNotEmpty(String); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNotEmpty(String)"})
  void testIsNotEmpty_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isNotEmpty(null));
  }

  /**
   * Test {@link StringUtils#isNotEmpty(String)}.
   * <ul>
   *   <li>When {@code Source}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNotEmpty(String)}
   */
  @Test
  @DisplayName("Test isNotEmpty(String); when 'Source'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNotEmpty(String)"})
  void testIsNotEmpty_whenSource_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isNotEmpty("Source"));
  }

  /**
   * Test {@link StringUtils#isNotBlank(String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNotBlank(String)}
   */
  @Test
  @DisplayName("Test isNotBlank(String); when EMPTY; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNotBlank(String)"})
  void testIsNotBlank_whenEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isNotBlank(StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#isNotBlank(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNotBlank(String)}
   */
  @Test
  @DisplayName("Test isNotBlank(String); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNotBlank(String)"})
  void testIsNotBlank_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isNotBlank(null));
  }

  /**
   * Test {@link StringUtils#isNotBlank(String)}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNotBlank(String)}
   */
  @Test
  @DisplayName("Test isNotBlank(String); when null; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNotBlank(String)"})
  void testIsNotBlank_whenNull_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isNotBlank("\u0000"));
  }

  /**
   * Test {@link StringUtils#isNotBlank(String)}.
   * <ul>
   *   <li>When {@code Source}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNotBlank(String)}
   */
  @Test
  @DisplayName("Test isNotBlank(String); when 'Source'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNotBlank(String)"})
  void testIsNotBlank_whenSource_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isNotBlank("Source"));
  }

  /**
   * Test {@link StringUtils#notBlankOrDefault(String, String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@code Def}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#notBlankOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test notBlankOrDefault(String, String); when EMPTY; then return 'Def'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.notBlankOrDefault(String, String)"})
  void testNotBlankOrDefault_whenEmpty_thenReturnDef() {
    // Arrange, Act and Assert
    assertEquals("Def", StringUtils.notBlankOrDefault(StringUtils.EMPTY, "Def"));
  }

  /**
   * Test {@link StringUtils#notBlankOrDefault(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Def}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#notBlankOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test notBlankOrDefault(String, String); when 'null'; then return 'Def'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.notBlankOrDefault(String, String)"})
  void testNotBlankOrDefault_whenNull_thenReturnDef() {
    // Arrange, Act and Assert
    assertEquals("Def", StringUtils.notBlankOrDefault(null, "Def"));
  }

  /**
   * Test {@link StringUtils#notBlankOrDefault(String, String)}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return {@code Def}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#notBlankOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test notBlankOrDefault(String, String); when null; then return 'Def'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.notBlankOrDefault(String, String)"})
  void testNotBlankOrDefault_whenNull_thenReturnDef2() {
    // Arrange, Act and Assert
    assertEquals("Def", StringUtils.notBlankOrDefault("\u0000", "Def"));
  }

  /**
   * Test {@link StringUtils#notBlankOrDefault(String, String)}.
   * <ul>
   *   <li>When {@code Src}.</li>
   *   <li>Then return {@code Src}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#notBlankOrDefault(String, String)}
   */
  @Test
  @DisplayName("Test notBlankOrDefault(String, String); when 'Src'; then return 'Src'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.notBlankOrDefault(String, String)"})
  void testNotBlankOrDefault_whenSrc_thenReturnSrc() {
    // Arrange, Act and Assert
    assertEquals("Src", StringUtils.notBlankOrDefault("Src", "Def"));
  }

  /**
   * Test {@link StringUtils#removeStart(String, String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#removeStart(String, String)}
   */
  @Test
  @DisplayName("Test removeStart(String, String); when EMPTY; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.removeStart(String, String)"})
  void testRemoveStart_whenEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.removeStart(StringUtils.EMPTY, StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#removeStart(String, String)}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#removeStart(String, String)}
   */
  @Test
  @DisplayName("Test removeStart(String, String); when null; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.removeStart(String, String)"})
  void testRemoveStart_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.removeStart("\u0000", "\u0000"));
  }

  /**
   * Test {@link StringUtils#removeStart(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#removeStart(String, String)}
   */
  @Test
  @DisplayName("Test removeStart(String, String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.removeStart(String, String)"})
  void testRemoveStart_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtils.removeStart(null, StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#removeStart(String, String)}.
   * <ul>
   *   <li>When {@code Remove}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#removeStart(String, String)}
   */
  @Test
  @DisplayName("Test removeStart(String, String); when 'Remove'; then return 'Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.removeStart(String, String)"})
  void testRemoveStart_whenRemove_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtils.removeStart("Str", "Remove"));
  }

  /**
   * Test {@link StringUtils#removeStart(String, String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#removeStart(String, String)}
   */
  @Test
  @DisplayName("Test removeStart(String, String); when 'Str'; then return 'Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.removeStart(String, String)"})
  void testRemoveStart_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtils.removeStart("Str", StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#substringBefore(String, String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBefore(String, String)}
   */
  @Test
  @DisplayName("Test substringBefore(String, String); when EMPTY; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBefore(String, String)"})
  void testSubstringBefore_whenEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.substringBefore(StringUtils.EMPTY, null));
  }

  /**
   * Test {@link StringUtils#substringBefore(String, String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBefore(String, String)}
   */
  @Test
  @DisplayName("Test substringBefore(String, String); when EMPTY; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBefore(String, String)"})
  void testSubstringBefore_whenEmpty_thenReturnEmpty2() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.substringBefore("Str", StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#substringBefore(String, String)}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBefore(String, String)}
   */
  @Test
  @DisplayName("Test substringBefore(String, String); when null; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBefore(String, String)"})
  void testSubstringBefore_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.substringBefore("\u0000", "\u0000"));
  }

  /**
   * Test {@link StringUtils#substringBefore(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBefore(String, String)}
   */
  @Test
  @DisplayName("Test substringBefore(String, String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBefore(String, String)"})
  void testSubstringBefore_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtils.substringBefore(null, null));
  }

  /**
   * Test {@link StringUtils#substringBefore(String, String)}.
   * <ul>
   *   <li>When {@code Separator}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBefore(String, String)}
   */
  @Test
  @DisplayName("Test substringBefore(String, String); when 'Separator'; then return 'Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBefore(String, String)"})
  void testSubstringBefore_whenSeparator_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtils.substringBefore("Str", "Separator"));
  }

  /**
   * Test {@link StringUtils#substringBefore(String, String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBefore(String, String)}
   */
  @Test
  @DisplayName("Test substringBefore(String, String); when 'Str'; then return 'Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBefore(String, String)"})
  void testSubstringBefore_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtils.substringBefore("Str", null));
  }

  /**
   * Test {@link StringUtils#substringBetween(String, String, String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBetween(String, String, String)}
   */
  @Test
  @DisplayName("Test substringBetween(String, String, String); when EMPTY; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBetween(String, String, String)"})
  void testSubstringBetween_whenEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.substringBetween("Str", StringUtils.EMPTY, StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#substringBetween(String, String, String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBetween(String, String, String)}
   */
  @Test
  @DisplayName("Test substringBetween(String, String, String); when EMPTY; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBetween(String, String, String)"})
  void testSubstringBetween_whenEmpty_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtils.substringBetween("Str", StringUtils.EMPTY, "Close"));
  }

  /**
   * Test {@link StringUtils#substringBetween(String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBetween(String, String, String)}
   */
  @Test
  @DisplayName("Test substringBetween(String, String, String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBetween(String, String, String)"})
  void testSubstringBetween_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtils.substringBetween(null, null, null));
  }

  /**
   * Test {@link StringUtils#substringBetween(String, String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBetween(String, String, String)}
   */
  @Test
  @DisplayName("Test substringBetween(String, String, String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBetween(String, String, String)"})
  void testSubstringBetween_whenNull_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(StringUtils.substringBetween("Str", null, null));
  }

  /**
   * Test {@link StringUtils#substringBetween(String, String, String)}.
   * <ul>
   *   <li>When {@code Open}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBetween(String, String, String)}
   */
  @Test
  @DisplayName("Test substringBetween(String, String, String); when 'Open'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBetween(String, String, String)"})
  void testSubstringBetween_whenOpen_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtils.substringBetween("Str", "Open", "Close"));
  }

  /**
   * Test {@link StringUtils#substringBetween(String, String, String)}.
   * <ul>
   *   <li>When {@code Open}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBetween(String, String, String)}
   */
  @Test
  @DisplayName("Test substringBetween(String, String, String); when 'Open'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBetween(String, String, String)"})
  void testSubstringBetween_whenOpen_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(StringUtils.substringBetween("Str", "Open", null));
  }

  /**
   * Test {@link StringUtils#obfuscate(String, int, char, int, int)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code IAAut}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#obfuscate(String, int, char, int, int)}
   */
  @Test
  @DisplayName("Test obfuscate(String, int, char, int, int); when 'Input'; then return 'IAAut'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.obfuscate(String, int, char, int, int)"})
  void testObfuscate_whenInput_thenReturnIAAut() {
    // Arrange, Act and Assert
    assertEquals("IAAut", StringUtils.obfuscate("Input", 1, 'A', 1, 3));
  }

  /**
   * Test {@link StringUtils#obfuscate(String, int, char, int, int)}.
   * <ul>
   *   <li>When {@code Input}.</li>
   *   <li>Then return {@code Input}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#obfuscate(String, int, char, int, int)}
   */
  @Test
  @DisplayName("Test obfuscate(String, int, char, int, int); when 'Input'; then return 'Input'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.obfuscate(String, int, char, int, int)"})
  void testObfuscate_whenInput_thenReturnInput() {
    // Arrange, Act and Assert
    assertEquals("Input", StringUtils.obfuscate("Input", 1, 'A', 1, 1));
  }

  /**
   * Test {@link StringUtils#obfuscate(String, int, char, int, int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@code IAAut}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#obfuscate(String, int, char, int, int)}
   */
  @Test
  @DisplayName("Test obfuscate(String, int, char, int, int); when zero; then return 'IAAut'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.obfuscate(String, int, char, int, int)"})
  void testObfuscate_whenZero_thenReturnIAAut() {
    // Arrange, Act and Assert
    assertEquals("IAAut", StringUtils.obfuscate("Input", 0, 'A', 1, 3));
  }

  /**
   * Test {@link StringUtils#split(String, int)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return iterator next is {@code 2}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#split(String, int)}
   */
  @Test
  @DisplayName("Test split(String, int); when '42'; then return iterator next is '2'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable StringUtils.split(String, int)"})
  void testSplit_when42_thenReturnIteratorNextIs2() {
    // Arrange and Act
    Iterable<String> actualSplitResult = StringUtils.split("42", 1);
    Iterator<String> actualIteratorResult = actualSplitResult.iterator();

    // Assert
    String actualNextResult = actualIteratorResult.next();
    String actualNextResult2 = actualIteratorResult.next();
    assertEquals("2", actualNextResult2);
    assertEquals("4", actualNextResult);
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link StringUtils#split(String, int)}.
   * <ul>
   *   <li>When three.</li>
   *   <li>Then return iterator next is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#split(String, int)}
   */
  @Test
  @DisplayName("Test split(String, int); when three; then return iterator next is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Iterable StringUtils.split(String, int)"})
  void testSplit_whenThree_thenReturnIteratorNextIs42() {
    // Arrange and Act
    Iterable<String> actualSplitResult = StringUtils.split("42", 3);
    Iterator<String> actualIteratorResult = actualSplitResult.iterator();

    // Assert
    assertEquals("42", actualIteratorResult.next());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Test {@link StringUtils#equalsIgnoreCase(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equalsIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test equalsIgnoreCase(String, String); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equalsIgnoreCase(String, String)"})
  void testEqualsIgnoreCase_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.equalsIgnoreCase(null, "Str2"));
  }

  /**
   * Test {@link StringUtils#equalsIgnoreCase(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equalsIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test equalsIgnoreCase(String, String); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equalsIgnoreCase(String, String)"})
  void testEqualsIgnoreCase_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.equalsIgnoreCase(null, null));
  }

  /**
   * Test {@link StringUtils#equalsIgnoreCase(String, String)}.
   * <ul>
   *   <li>When {@code Str1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equalsIgnoreCase(String, String)}
   */
  @Test
  @DisplayName("Test equalsIgnoreCase(String, String); when 'Str1'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equalsIgnoreCase(String, String)"})
  void testEqualsIgnoreCase_whenStr1_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.equalsIgnoreCase("Str1", "Str2"));
  }

  /**
   * Test {@link StringUtils#join(String[], String)}.
   * <ul>
   *   <li>When array of {@link String} with {@code Key Array}.</li>
   *   <li>Then return {@code Key Array}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#join(String[], String)}
   */
  @Test
  @DisplayName("Test join(String[], String); when array of String with 'Key Array'; then return 'Key Array'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.join(String[], String)"})
  void testJoin_whenArrayOfStringWithKeyArray_thenReturnKeyArray() {
    // Arrange, Act and Assert
    assertEquals("Key Array", StringUtils.join(new String[]{"Key Array"}, "Lwm2m Separator Path"));
  }

  /**
   * Test {@link StringUtils#join(String[], String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#join(String[], String)}
   */
  @Test
  @DisplayName("Test join(String[], String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.join(String[], String)"})
  void testJoin_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtils.join(null, "Lwm2m Separator Path"));
  }

  /**
   * Test {@link StringUtils#trimToNull(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#trimToNull(String)}
   */
  @Test
  @DisplayName("Test trimToNull(String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.trimToNull(String)"})
  void testTrimToNull_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtils.trimToNull(null));
  }

  /**
   * Test {@link StringUtils#trimToNull(String)}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#trimToNull(String)}
   */
  @Test
  @DisplayName("Test trimToNull(String); when null; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.trimToNull(String)"})
  void testTrimToNull_whenNull_thenReturnNull2() {
    // Arrange, Act and Assert
    assertNull(StringUtils.trimToNull("\u0000"));
  }

  /**
   * Test {@link StringUtils#trimToNull(String)}.
   * <ul>
   *   <li>When {@code To String}.</li>
   *   <li>Then return {@code To String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#trimToNull(String)}
   */
  @Test
  @DisplayName("Test trimToNull(String); when 'To String'; then return 'To String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.trimToNull(String)"})
  void testTrimToNull_whenToString_thenReturnToString() {
    // Arrange, Act and Assert
    assertEquals("To String", StringUtils.trimToNull("To String"));
  }

  /**
   * Test {@link StringUtils#isNoneEmpty(String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNoneEmpty(String)}
   */
  @Test
  @DisplayName("Test isNoneEmpty(String); when EMPTY; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNoneEmpty(String)"})
  void testIsNoneEmpty_whenEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isNoneEmpty(StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#isNoneEmpty(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNoneEmpty(String)}
   */
  @Test
  @DisplayName("Test isNoneEmpty(String); when 'Str'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNoneEmpty(String)"})
  void testIsNoneEmpty_whenStr_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isNoneEmpty("Str"));
  }

  /**
   * Test {@link StringUtils#endsWith(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#endsWith(String, String)}
   */
  @Test
  @DisplayName("Test endsWith(String, String); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.endsWith(String, String)"})
  void testEndsWith_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.endsWith(null, "Suffix"));
  }

  /**
   * Test {@link StringUtils#endsWith(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#endsWith(String, String)}
   */
  @Test
  @DisplayName("Test endsWith(String, String); when 'null'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.endsWith(String, String)"})
  void testEndsWith_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.endsWith(null, null));
  }

  /**
   * Test {@link StringUtils#endsWith(String, String)}.
   * <ul>
   *   <li>When {@code \s*,\s*}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#endsWith(String, String)}
   */
  @Test
  @DisplayName("Test endsWith(String, String); when '\\s*,\\s*'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.endsWith(String, String)"})
  void testEndsWith_whenSS_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.endsWith("\\s*,\\s*", "Suffix"));
  }

  /**
   * Test {@link StringUtils#endsWith(String, String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#endsWith(String, String)}
   */
  @Test
  @DisplayName("Test endsWith(String, String); when 'Str'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.endsWith(String, String)"})
  void testEndsWith_whenStr_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.endsWith("Str", "Suffix"));
  }

  /**
   * Test {@link StringUtils#endsWith(String, String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#endsWith(String, String)}
   */
  @Test
  @DisplayName("Test endsWith(String, String); when 'Str'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.endsWith(String, String)"})
  void testEndsWith_whenStr_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.endsWith("Str", null));
  }

  /**
   * Test {@link StringUtils#hasLength(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#hasLength(String)}
   */
  @Test
  @DisplayName("Test hasLength(String); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.hasLength(String)"})
  void testHasLength_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.hasLength(null));
  }

  /**
   * Test {@link StringUtils#hasLength(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#hasLength(String)}
   */
  @Test
  @DisplayName("Test hasLength(String); when 'Str'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.hasLength(String)"})
  void testHasLength_whenStr_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.hasLength("Str"));
  }

  /**
   * Test {@link StringUtils#isNoneBlank(String[])}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNoneBlank(String[])}
   */
  @Test
  @DisplayName("Test isNoneBlank(String[]); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNoneBlank(String[])"})
  void testIsNoneBlank_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isNoneBlank());
  }

  /**
   * Test {@link StringUtils#isNoneBlank(String[])}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNoneBlank(String[])}
   */
  @Test
  @DisplayName("Test isNoneBlank(String[]); when EMPTY; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNoneBlank(String[])"})
  void testIsNoneBlank_whenEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isNoneBlank(StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#isNoneBlank(String[])}.
   * <ul>
   *   <li>When space and space.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNoneBlank(String[])}
   */
  @Test
  @DisplayName("Test isNoneBlank(String[]); when space and space; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNoneBlank(String[])"})
  void testIsNoneBlank_whenSpaceAndSpace_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isNoneBlank(" ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
        " ", " "));
  }

  /**
   * Test {@link StringUtils#isNoneBlank(String[])}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNoneBlank(String[])}
   */
  @Test
  @DisplayName("Test isNoneBlank(String[]); when 'Str'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNoneBlank(String[])"})
  void testIsNoneBlank_whenStr_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isNoneBlank("Str"));
  }

  /**
   * Test {@link StringUtils#hasText(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#hasText(String)}
   */
  @Test
  @DisplayName("Test hasText(String); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.hasText(String)"})
  void testHasText_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.hasText(null));
  }

  /**
   * Test {@link StringUtils#hasText(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#hasText(String)}
   */
  @Test
  @DisplayName("Test hasText(String); when 'Str'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.hasText(String)"})
  void testHasText_whenStr_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.hasText("Str"));
  }

  /**
   * Test {@link StringUtils#defaultString(String, String)}.
   * <p>
   * Method under test: {@link StringUtils#defaultString(String, String)}
   */
  @Test
  @DisplayName("Test defaultString(String, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.defaultString(String, String)"})
  void testDefaultString() {
    // Arrange, Act and Assert
    assertEquals("foo", StringUtils.defaultString("foo", "42"));
  }

  /**
   * Test {@link StringUtils#isNumeric(String)}.
   * <ul>
   *   <li>When {@code 12345}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNumeric(String)}
   */
  @Test
  @DisplayName("Test isNumeric(String); when '12345'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNumeric(String)"})
  void testIsNumeric_when12345_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isNumeric("12345"));
  }

  /**
   * Test {@link StringUtils#isNumeric(String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNumeric(String)}
   */
  @Test
  @DisplayName("Test isNumeric(String); when EMPTY; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNumeric(String)"})
  void testIsNumeric_whenEmpty_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isNumeric(StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#isNumeric(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNumeric(String)}
   */
  @Test
  @DisplayName("Test isNumeric(String); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNumeric(String)"})
  void testIsNumeric_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isNumeric(null));
  }

  /**
   * Test {@link StringUtils#isNumeric(String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#isNumeric(String)}
   */
  @Test
  @DisplayName("Test isNumeric(String); when 'Str'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.isNumeric(String)"})
  void testIsNumeric_whenStr_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isNumeric("Str"));
  }

  /**
   * Test {@link StringUtils#equals(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equals(String, String)}
   */
  @Test
  @DisplayName("Test equals(String, String) with 'String', 'String'; when null; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equals(String, String)"})
  void testEqualsWithStringString_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.equals("\u0000", "Str2"));
  }

  /**
   * Test {@link StringUtils#equals(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equals(String, String)}
   */
  @Test
  @DisplayName("Test equals(String, String) with 'String', 'String'; when null; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equals(String, String)"})
  void testEqualsWithStringString_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.equals("\u0000", "\u0000"));
  }

  /**
   * Test {@link StringUtils#equals(String, String)} with {@code String}, {@code String}.
   * <ul>
   *   <li>When {@code Str1}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equals(String, String)}
   */
  @Test
  @DisplayName("Test equals(String, String) with 'String', 'String'; when 'Str1'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equals(String, String)"})
  void testEqualsWithStringString_whenStr1_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.equals("Str1", "Str2"));
  }

  /**
   * Test {@link StringUtils#equalsAny(String, List)} with {@code String}, {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@code 42}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equalsAny(String, List)}
   */
  @Test
  @DisplayName("Test equalsAny(String, List) with 'String', 'List'; given '42'; when '42'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equalsAny(String, List)"})
  void testEqualsAnyWithStringList_given42_when42_thenReturnTrue() {
    // Arrange
    ArrayList<String> otherStrings = new ArrayList<>();
    otherStrings.add("42");
    otherStrings.add("foo");

    // Act and Assert
    assertTrue(StringUtils.equalsAny("42", otherStrings));
  }

  /**
   * Test {@link StringUtils#equalsAny(String, List)} with {@code String}, {@code List}.
   * <ul>
   *   <li>Given {@code 42}.</li>
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equalsAny(String, List)}
   */
  @Test
  @DisplayName("Test equalsAny(String, List) with 'String', 'List'; given '42'; when ArrayList() add '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equalsAny(String, List)"})
  void testEqualsAnyWithStringList_given42_whenArrayListAdd42_thenReturnFalse() {
    // Arrange
    ArrayList<String> otherStrings = new ArrayList<>();
    otherStrings.add("42");
    otherStrings.add("foo");

    // Act and Assert
    assertFalse(StringUtils.equalsAny("String", otherStrings));
  }

  /**
   * Test {@link StringUtils#equalsAny(String, List)} with {@code String}, {@code List}.
   * <ul>
   *   <li>Given {@code foo}.</li>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equalsAny(String, List)}
   */
  @Test
  @DisplayName("Test equalsAny(String, List) with 'String', 'List'; given 'foo'; when 'String'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equalsAny(String, List)"})
  void testEqualsAnyWithStringList_givenFoo_whenString_thenReturnFalse() {
    // Arrange
    ArrayList<String> otherStrings = new ArrayList<>();
    otherStrings.add("foo");

    // Act and Assert
    assertFalse(StringUtils.equalsAny("String", otherStrings));
  }

  /**
   * Test {@link StringUtils#equalsAny(String, List)} with {@code String}, {@code List}.
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equalsAny(String, List)}
   */
  @Test
  @DisplayName("Test equalsAny(String, List) with 'String', 'List'; when ArrayList(); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equalsAny(String, List)"})
  void testEqualsAnyWithStringList_whenArrayList_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.equalsAny("String", new ArrayList<>()));
  }

  /**
   * Test {@link StringUtils#equalsAny(String, String[])} with {@code String}, {@code String[]}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equalsAny(String, String[])}
   */
  @Test
  @DisplayName("Test equalsAny(String, String[]) with 'String', 'String[]'; when null; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equalsAny(String, String[])"})
  void testEqualsAnyWithStringString_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.equalsAny("\u0000", "\u0000"));
  }

  /**
   * Test {@link StringUtils#equalsAny(String, String[])} with {@code String}, {@code String[]}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equalsAny(String, String[])}
   */
  @Test
  @DisplayName("Test equalsAny(String, String[]) with 'String', 'String[]'; when 'String'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equalsAny(String, String[])"})
  void testEqualsAnyWithStringString_whenString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.equalsAny("String", "Other Strings"));
  }

  /**
   * Test {@link StringUtils#equalsAnyIgnoreCase(String, String[])}.
   * <ul>
   *   <li>When {@code Other Strings}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equalsAnyIgnoreCase(String, String[])}
   */
  @Test
  @DisplayName("Test equalsAnyIgnoreCase(String, String[]); when 'Other Strings'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equalsAnyIgnoreCase(String, String[])"})
  void testEqualsAnyIgnoreCase_whenOtherStrings_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.equalsAnyIgnoreCase(null, "Other Strings"));
  }

  /**
   * Test {@link StringUtils#equalsAnyIgnoreCase(String, String[])}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#equalsAnyIgnoreCase(String, String[])}
   */
  @Test
  @DisplayName("Test equalsAnyIgnoreCase(String, String[]); when 'String'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.equalsAnyIgnoreCase(String, String[])"})
  void testEqualsAnyIgnoreCase_whenString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.equalsAnyIgnoreCase("String", "Other Strings"));
  }

  /**
   * Test {@link StringUtils#substringBeforeLast(String, String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBeforeLast(String, String)}
   */
  @Test
  @DisplayName("Test substringBeforeLast(String, String); when EMPTY; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBeforeLast(String, String)"})
  void testSubstringBeforeLast_whenEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.substringBeforeLast(StringUtils.EMPTY, null));
  }

  /**
   * Test {@link StringUtils#substringBeforeLast(String, String)}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBeforeLast(String, String)}
   */
  @Test
  @DisplayName("Test substringBeforeLast(String, String); when null; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBeforeLast(String, String)"})
  void testSubstringBeforeLast_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.substringBeforeLast("\u0000", "\u0000"));
  }

  /**
   * Test {@link StringUtils#substringBeforeLast(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBeforeLast(String, String)}
   */
  @Test
  @DisplayName("Test substringBeforeLast(String, String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBeforeLast(String, String)"})
  void testSubstringBeforeLast_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtils.substringBeforeLast(null, null));
  }

  /**
   * Test {@link StringUtils#substringBeforeLast(String, String)}.
   * <ul>
   *   <li>When {@code Separator}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBeforeLast(String, String)}
   */
  @Test
  @DisplayName("Test substringBeforeLast(String, String); when 'Separator'; then return 'Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBeforeLast(String, String)"})
  void testSubstringBeforeLast_whenSeparator_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtils.substringBeforeLast("Str", "Separator"));
  }

  /**
   * Test {@link StringUtils#substringBeforeLast(String, String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@code Str}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringBeforeLast(String, String)}
   */
  @Test
  @DisplayName("Test substringBeforeLast(String, String); when 'Str'; then return 'Str'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringBeforeLast(String, String)"})
  void testSubstringBeforeLast_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtils.substringBeforeLast("Str", null));
  }

  /**
   * Test {@link StringUtils#substringAfterLast(String, String)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringAfterLast(String, String)}
   */
  @Test
  @DisplayName("Test substringAfterLast(String, String); when EMPTY; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringAfterLast(String, String)"})
  void testSubstringAfterLast_whenEmpty_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.substringAfterLast(StringUtils.EMPTY, null));
  }

  /**
   * Test {@link StringUtils#substringAfterLast(String, String)}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringAfterLast(String, String)}
   */
  @Test
  @DisplayName("Test substringAfterLast(String, String); when null; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringAfterLast(String, String)"})
  void testSubstringAfterLast_whenNull_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.substringAfterLast("\u0000", "\u0000"));
  }

  /**
   * Test {@link StringUtils#substringAfterLast(String, String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringAfterLast(String, String)}
   */
  @Test
  @DisplayName("Test substringAfterLast(String, String); when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringAfterLast(String, String)"})
  void testSubstringAfterLast_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtils.substringAfterLast(null, null));
  }

  /**
   * Test {@link StringUtils#substringAfterLast(String, String)}.
   * <ul>
   *   <li>When {@code Sep}.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringAfterLast(String, String)}
   */
  @Test
  @DisplayName("Test substringAfterLast(String, String); when 'Sep'; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringAfterLast(String, String)"})
  void testSubstringAfterLast_whenSep_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.substringAfterLast("Str", "Sep"));
  }

  /**
   * Test {@link StringUtils#substringAfterLast(String, String)}.
   * <ul>
   *   <li>When {@code Str}.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#substringAfterLast(String, String)}
   */
  @Test
  @DisplayName("Test substringAfterLast(String, String); when 'Str'; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.substringAfterLast(String, String)"})
  void testSubstringAfterLast_whenStr_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.substringAfterLast("Str", null));
  }

  /**
   * Test {@link StringUtils#containedByAny(String, String[])}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#containedByAny(String, String[])}
   */
  @Test
  @DisplayName("Test containedByAny(String, String[]); when EMPTY; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.containedByAny(String, String[])"})
  void testContainedByAny_whenEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.containedByAny(StringUtils.EMPTY, "Strings"));
  }

  /**
   * Test {@link StringUtils#containedByAny(String, String[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#containedByAny(String, String[])}
   */
  @Test
  @DisplayName("Test containedByAny(String, String[]); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.containedByAny(String, String[])"})
  void testContainedByAny_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.containedByAny(null, "Strings"));
  }

  /**
   * Test {@link StringUtils#containedByAny(String, String[])}.
   * <ul>
   *   <li>When {@code Search String}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#containedByAny(String, String[])}
   */
  @Test
  @DisplayName("Test containedByAny(String, String[]); when 'Search String'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.containedByAny(String, String[])"})
  void testContainedByAny_whenSearchString_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.containedByAny("Search String", "Strings"));
  }

  /**
   * Test {@link StringUtils#contains(CharSequence, CharSequence)}.
   * <p>
   * Method under test: {@link StringUtils#contains(CharSequence, CharSequence)}
   */
  @Test
  @DisplayName("Test contains(CharSequence, CharSequence)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.contains(CharSequence, CharSequence)"})
  void testContains() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.contains(new DefaultCharAppender(3, "42", 4), StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#contains(CharSequence, CharSequence)}.
   * <ul>
   *   <li>When {@link CacheConstants#ALARM_TYPES_CACHE}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#contains(CharSequence, CharSequence)}
   */
  @Test
  @DisplayName("Test contains(CharSequence, CharSequence); when ALARM_TYPES_CACHE; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.contains(CharSequence, CharSequence)"})
  void testContains_whenAlarm_types_cache_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.contains(StringUtils.EMPTY, CacheConstants.ALARM_TYPES_CACHE));
  }

  /**
   * Test {@link StringUtils#contains(CharSequence, CharSequence)}.
   * <ul>
   *   <li>When {@link StringUtils#EMPTY}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#contains(CharSequence, CharSequence)}
   */
  @Test
  @DisplayName("Test contains(CharSequence, CharSequence); when EMPTY; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.contains(CharSequence, CharSequence)"})
  void testContains_whenEmpty_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.contains(StringUtils.EMPTY, StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#contains(CharSequence, CharSequence)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#contains(CharSequence, CharSequence)}
   */
  @Test
  @DisplayName("Test contains(CharSequence, CharSequence); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.contains(CharSequence, CharSequence)"})
  void testContains_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.contains(null, null));
  }

  /**
   * Test {@link StringUtils#contains(CharSequence, CharSequence)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#contains(CharSequence, CharSequence)}
   */
  @Test
  @DisplayName("Test contains(CharSequence, CharSequence); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.contains(CharSequence, CharSequence)"})
  void testContains_whenNull_thenReturnFalse2() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.contains(StringUtils.EMPTY, null));
  }

  /**
   * Test {@link StringUtils#contains(CharSequence, CharSequence)}.
   * <ul>
   *   <li>When {@link StringBuffer#StringBuffer(String)} with {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#contains(CharSequence, CharSequence)}
   */
  @Test
  @DisplayName("Test contains(CharSequence, CharSequence); when StringBuffer(String) with 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.contains(CharSequence, CharSequence)"})
  void testContains_whenStringBufferWithFoo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.contains(new StringBuffer("foo"), StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#contains(CharSequence, CharSequence)}.
   * <ul>
   *   <li>When {@link StringBuilder#StringBuilder(String)} with {@code foo}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#contains(CharSequence, CharSequence)}
   */
  @Test
  @DisplayName("Test contains(CharSequence, CharSequence); when StringBuilder(String) with 'foo'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.contains(CharSequence, CharSequence)"})
  void testContains_whenStringBuilderWithFoo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.contains(new StringBuilder("foo"), StringUtils.EMPTY));
  }

  /**
   * Test {@link StringUtils#contains0x00(String)}.
   * <ul>
   *   <li>When {@code foo}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#contains0x00(String)}
   */
  @Test
  @DisplayName("Test contains0x00(String); when 'foo'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.contains0x00(String)"})
  void testContains0x00_whenFoo_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.contains0x00("foo"));
  }

  /**
   * Test {@link StringUtils#contains0x00(String)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#contains0x00(String)}
   */
  @Test
  @DisplayName("Test contains0x00(String); when 'null'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.contains0x00(String)"})
  void testContains0x00_whenNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.contains0x00(null));
  }

  /**
   * Test {@link StringUtils#contains0x00(String)}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#contains0x00(String)}
   */
  @Test
  @DisplayName("Test contains0x00(String); when null; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean StringUtils.contains0x00(String)"})
  void testContains0x00_whenNull_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.contains0x00("\u0000"));
  }

  /**
   * Test {@link StringUtils#randomNumeric(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#randomNumeric(int)}
   */
  @Test
  @DisplayName("Test randomNumeric(int); when zero; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.randomNumeric(int)"})
  void testRandomNumeric_whenZero_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.randomNumeric(0));
  }

  /**
   * Test {@link StringUtils#random(int, String)} with {@code length}, {@code chars}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#random(int, String)}
   */
  @Test
  @DisplayName("Test random(int, String) with 'length', 'chars'; when zero; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.random(int, String)"})
  void testRandomWithLengthChars_whenZero_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.random(0, null));
  }

  /**
   * Test {@link StringUtils#random(int)} with {@code length}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#random(int)}
   */
  @Test
  @DisplayName("Test random(int) with 'length'; when zero; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.random(int)"})
  void testRandomWithLength_whenZero_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.random(0));
  }

  /**
   * Test {@link StringUtils#randomAlphanumeric(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#randomAlphanumeric(int)}
   */
  @Test
  @DisplayName("Test randomAlphanumeric(int); when zero; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.randomAlphanumeric(int)"})
  void testRandomAlphanumeric_whenZero_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.randomAlphanumeric(0));
  }

  /**
   * Test {@link StringUtils#randomAlphabetic(int)}.
   * <ul>
   *   <li>When zero.</li>
   *   <li>Then return {@link StringUtils#EMPTY}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#randomAlphabetic(int)}
   */
  @Test
  @DisplayName("Test randomAlphabetic(int); when zero; then return EMPTY")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.randomAlphabetic(int)"})
  void testRandomAlphabetic_whenZero_thenReturnEmpty() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.randomAlphabetic(0));
  }

  /**
   * Test {@link StringUtils#truncate(String, int, Function)} with {@code string}, {@code maxLength}, {@code truncationMarkerFunc}.
   * <ul>
   *   <li>Then return {@code StrApply}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#truncate(String, int, Function)}
   */
  @Test
  @DisplayName("Test truncate(String, int, Function) with 'string', 'maxLength', 'truncationMarkerFunc'; then return 'StrApply'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.truncate(String, int, Function)"})
  void testTruncateWithStringMaxLengthTruncationMarkerFunc_thenReturnStrApply() {
    // Arrange
    Function<Integer, String> truncationMarkerFunc = mock(Function.class);
    when(truncationMarkerFunc.apply(Mockito.<Integer>any())).thenReturn("Apply");

    // Act
    String actualTruncateResult = StringUtils.truncate("String", 3, truncationMarkerFunc);

    // Assert
    verify(truncationMarkerFunc).apply(eq(3));
    assertEquals("StrApply", actualTruncateResult);
  }

  /**
   * Test {@link StringUtils#truncate(String, int, Function)} with {@code string}, {@code maxLength}, {@code truncationMarkerFunc}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#truncate(String, int, Function)}
   */
  @Test
  @DisplayName("Test truncate(String, int, Function) with 'string', 'maxLength', 'truncationMarkerFunc'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.truncate(String, int, Function)"})
  void testTruncateWithStringMaxLengthTruncationMarkerFunc_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtils.truncate(null, 0, mock(Function.class)));
  }

  /**
   * Test {@link StringUtils#truncate(String, int, Function)} with {@code string}, {@code maxLength}, {@code truncationMarkerFunc}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return null.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#truncate(String, int, Function)}
   */
  @Test
  @DisplayName("Test truncate(String, int, Function) with 'string', 'maxLength', 'truncationMarkerFunc'; when null; then return null")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.truncate(String, int, Function)"})
  void testTruncateWithStringMaxLengthTruncationMarkerFunc_whenNull_thenReturnNull2() {
    // Arrange, Act and Assert
    assertEquals("\u0000", StringUtils.truncate("\u0000", 3, mock(Function.class)));
  }

  /**
   * Test {@link StringUtils#truncate(String, int, Function)} with {@code string}, {@code maxLength}, {@code truncationMarkerFunc}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#truncate(String, int, Function)}
   */
  @Test
  @DisplayName("Test truncate(String, int, Function) with 'string', 'maxLength', 'truncationMarkerFunc'; when 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.truncate(String, int, Function)"})
  void testTruncateWithStringMaxLengthTruncationMarkerFunc_whenString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String", StringUtils.truncate("String", 0, mock(Function.class)));
  }

  /**
   * Test {@link StringUtils#truncate(String, int)} with {@code string}, {@code maxLength}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#truncate(String, int)}
   */
  @Test
  @DisplayName("Test truncate(String, int) with 'string', 'maxLength'; when 'null'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.truncate(String, int)"})
  void testTruncateWithStringMaxLength_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(StringUtils.truncate(null, 0));
  }

  /**
   * Test {@link StringUtils#truncate(String, int)} with {@code string}, {@code maxLength}.
   * <ul>
   *   <li>When null.</li>
   *   <li>Then return null.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#truncate(String, int)}
   */
  @Test
  @DisplayName("Test truncate(String, int) with 'string', 'maxLength'; when null; then return null")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.truncate(String, int)"})
  void testTruncateWithStringMaxLength_whenNull_thenReturnNull2() {
    // Arrange, Act and Assert
    assertEquals("\u0000", StringUtils.truncate("\u0000", 3));
  }

  /**
   * Test {@link StringUtils#truncate(String, int)} with {@code string}, {@code maxLength}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code Str...[truncated 3 symbols]}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#truncate(String, int)}
   */
  @Test
  @DisplayName("Test truncate(String, int) with 'string', 'maxLength'; when 'String'; then return 'Str...[truncated 3 symbols]'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.truncate(String, int)"})
  void testTruncateWithStringMaxLength_whenString_thenReturnStrTruncated3Symbols() {
    // Arrange, Act and Assert
    assertEquals("Str...[truncated 3 symbols]", StringUtils.truncate("String", 3));
  }

  /**
   * Test {@link StringUtils#truncate(String, int)} with {@code string}, {@code maxLength}.
   * <ul>
   *   <li>When {@code String}.</li>
   *   <li>Then return {@code String}.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#truncate(String, int)}
   */
  @Test
  @DisplayName("Test truncate(String, int) with 'string', 'maxLength'; when 'String'; then return 'String'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String StringUtils.truncate(String, int)"})
  void testTruncateWithStringMaxLength_whenString_thenReturnString() {
    // Arrange, Act and Assert
    assertEquals("String", StringUtils.truncate("String", 0));
  }

  /**
   * Test {@link StringUtils#splitByCommaWithoutQuotes(String)}.
   * <ul>
   *   <li>When {@code 42}.</li>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link StringUtils#splitByCommaWithoutQuotes(String)}
   */
  @Test
  @DisplayName("Test splitByCommaWithoutQuotes(String); when '42'; then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"List StringUtils.splitByCommaWithoutQuotes(String)"})
  void testSplitByCommaWithoutQuotes_when42_thenReturnSizeIsOne() {
    // Arrange and Act
    List<String> actualSplitByCommaWithoutQuotesResult = StringUtils.splitByCommaWithoutQuotes("42");

    // Assert
    assertEquals(1, actualSplitByCommaWithoutQuotesResult.size());
    assertEquals("42", actualSplitByCommaWithoutQuotesResult.get(0));
  }
}
