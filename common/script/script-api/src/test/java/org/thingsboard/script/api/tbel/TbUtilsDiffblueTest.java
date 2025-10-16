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

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.google.common.cache.RemovalNotification;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mvel2.ExecutionContext;
import org.mvel2.ParserConfiguration;
import org.mvel2.ParserContext;
import org.mvel2.execution.ExecutionArrayList;
import org.mvel2.execution.ExecutionHashMap;
import org.mvel2.execution.ExecutionObject;
import org.mvel2.util.MethodStub;

class TbUtilsDiffblueTest {
  /**
   * Test {@link TbUtils#register(ParserConfiguration)}.
   *
   * <ul>
   *   <li>Then {@link ParserConfiguration#ParserConfiguration()} Imports size is fifty-seven.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#register(ParserConfiguration)}
   */
  @Test
  @DisplayName(
      "Test register(ParserConfiguration); then ParserConfiguration() Imports size is fifty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbUtils.register(ParserConfiguration)"})
  void testRegister_thenParserConfigurationImportsSizeIsFiftySeven() throws Exception {
    // Arrange
    ParserConfiguration parserConfig = new ParserConfiguration();

    // Act
    TbUtils.register(parserConfig);

    // Assert
    Map<String, Object> imports = parserConfig.getImports();
    assertEquals(57, imports.size());
    assertTrue(imports.get("base64ToHex") instanceof MethodStub);
    assertTrue(imports.get("decodeToJson") instanceof MethodStub);
    assertTrue(imports.get("longToHex") instanceof MethodStub);
    assertTrue(imports.get("parseBigEndianHexToLong") instanceof MethodStub);
    assertTrue(imports.get("parseHexToFloat") instanceof MethodStub);
    assertTrue(imports.get("parseHexToLong") instanceof MethodStub);
    assertTrue(parserConfig.hasImports());
  }

  /**
   * Test {@link TbUtils#btoa(String)}.
   *
   * <p>Method under test: {@link TbUtils#btoa(String)}
   */
  @Test
  @DisplayName("Test btoa(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.btoa(String)"})
  void testBtoa() {
    // Arrange, Act and Assert
    assertEquals("SW5wdXQ=", TbUtils.btoa("Input"));
  }

  /**
   * Test {@link TbUtils#atob(String)}.
   *
   * <ul>
   *   <li>When {@code secret}.
   *   <li>Then return replacement character replacement character +z.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#atob(String)}
   */
  @Test
  @DisplayName(
      "Test atob(String); when 'secret'; then return replacement character replacement character +z")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.atob(String)"})
  void testAtob_whenSecret_thenReturnReplacementCharacterReplacementCharacterZ() {
    // Arrange, Act and Assert
    assertEquals("��+z", TbUtils.atob("secret"));
  }

  /**
   * Test {@link TbUtils#decodeToJson(ExecutionContext, String)} with {@code ctx}, {@code jsonStr}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#decodeToJson(ExecutionContext, String)}
   */
  @Test
  @DisplayName(
      "Test decodeToJson(ExecutionContext, String) with 'ctx', 'jsonStr'; when '42'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbUtils.decodeToJson(ExecutionContext, String)"})
  void testDecodeToJsonWithCtxJsonStr_when42_thenReturnIntValueIsFortyTwo() throws IOException {
    // Arrange, Act and Assert
    assertEquals(
        42,
        ((Integer)
                TbUtils.decodeToJson(
                    new ExecutionContext(ParserContext.enableSandboxedMode()), "42"))
            .intValue());
  }

  /**
   * Test {@link TbUtils#decodeToJson(ExecutionContext, String)} with {@code ctx}, {@code jsonStr}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#decodeToJson(ExecutionContext, String)}
   */
  @Test
  @DisplayName(
      "Test decodeToJson(ExecutionContext, String) with 'ctx', 'jsonStr'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Object TbUtils.decodeToJson(ExecutionContext, String)"})
  void testDecodeToJsonWithCtxJsonStr_whenNull_thenReturnNull() throws IOException {
    // Arrange, Act and Assert
    assertNull(
        TbUtils.decodeToJson(
            new ExecutionContext(ParserContext.enableSandboxedMode()), (String) null));
  }

  /**
   * Test {@link TbUtils#bytesToString(List, String)} with {@code bytesList}, {@code charsetName}.
   *
   * <ul>
   *   <li>Given {@code 0x}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List, String)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List, String) with 'bytesList', 'charsetName'; given '0x'; when ArrayList() add '0x'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List, String)"})
  void testBytesToStringWithBytesListCharsetName_given0x_whenArrayListAdd0x()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add("0x");

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.bytesToString(bytesList, "UTF-8"));
  }

  /**
   * Test {@link TbUtils#bytesToString(List, String)} with {@code bytesList}, {@code charsetName}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List, String)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List, String) with 'bytesList', 'charsetName'; given '42'; then return '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List, String)"})
  void testBytesToStringWithBytesListCharsetName_given42_thenReturnAsterisk()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add("42");

    // Act and Assert
    assertEquals("*", TbUtils.bytesToString(bytesList, "UTF-8"));
  }

  /**
   * Test {@link TbUtils#bytesToString(List, String)} with {@code bytesList}, {@code charsetName}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code **}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List, String)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List, String) with 'bytesList', 'charsetName'; given '42'; then return '**'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List, String)"})
  void testBytesToStringWithBytesListCharsetName_given42_thenReturnAsteriskAsterisk()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add("42");
    bytesList.add("42");

    // Act and Assert
    assertEquals("**", TbUtils.bytesToString(bytesList, "UTF-8"));
  }

  /**
   * Test {@link TbUtils#bytesToString(List, String)} with {@code bytesList}, {@code charsetName}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code A}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List, String)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List, String) with 'bytesList', 'charsetName'; given 'A'; when ArrayList() add 'A'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List, String)"})
  void testBytesToStringWithBytesListCharsetName_givenA_whenArrayListAddA_thenReturnA()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add((byte) 'A');

    // Act and Assert
    assertEquals("A", TbUtils.bytesToString(bytesList, "UTF-8"));
  }

  /**
   * Test {@link TbUtils#bytesToString(List, String)} with {@code bytesList}, {@code charsetName}.
   *
   * <ul>
   *   <li>Given {@code ,}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List, String)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List, String) with 'bytesList', 'charsetName'; given ','; when ArrayList() add ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List, String)"})
  void testBytesToStringWithBytesListCharsetName_givenComma_whenArrayListAddComma()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add(",");

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.bytesToString(bytesList, "UTF-8"));
  }

  /**
   * Test {@link TbUtils#bytesToString(List, String)} with {@code bytesList}, {@code charsetName}.
   *
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List, String)}
   */
  @Test
  @DisplayName("Test bytesToString(List, String) with 'bytesList', 'charsetName'; given MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List, String)"})
  void testBytesToStringWithBytesListCharsetName_givenMin_value()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add(Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.bytesToString(bytesList, "UTF-8"));
  }

  /**
   * Test {@link TbUtils#bytesToString(List, String)} with {@code bytesList}, {@code charsetName}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List, String)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List, String) with 'bytesList', 'charsetName'; given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List, String)"})
  void testBytesToStringWithBytesListCharsetName_givenNull_whenArrayListAddNull()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add(null);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.bytesToString(bytesList, "UTF-8"));
  }

  /**
   * Test {@link TbUtils#bytesToString(List, String)} with {@code bytesList}, {@code charsetName}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then return start of text.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List, String)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List, String) with 'bytesList', 'charsetName'; given two; then return start of text")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List, String)"})
  void testBytesToStringWithBytesListCharsetName_givenTwo_thenReturnStartOfText()
      throws UnsupportedEncodingException {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add(2);

    // Act and Assert
    assertEquals("\u0002", TbUtils.bytesToString(bytesList, "UTF-8"));
  }

  /**
   * Test {@link TbUtils#bytesToString(List, String)} with {@code bytesList}, {@code charsetName}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List, String)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List, String) with 'bytesList', 'charsetName'; when ArrayList(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List, String)"})
  void testBytesToStringWithBytesListCharsetName_whenArrayList_thenReturnEmptyString()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("", TbUtils.bytesToString(new ArrayList<>(), "UTF-8"));
  }

  /**
   * Test {@link TbUtils#bytesToString(List)} with {@code bytesList}.
   *
   * <ul>
   *   <li>Given {@code 0x}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 0x}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List)}
   */
  @Test
  @DisplayName("Test bytesToString(List) with 'bytesList'; given '0x'; when ArrayList() add '0x'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List)"})
  void testBytesToStringWithBytesList_given0x_whenArrayListAdd0x() {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add("0x");

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.bytesToString(bytesList));
  }

  /**
   * Test {@link TbUtils#bytesToString(List)} with {@code bytesList}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code **}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List)}
   */
  @Test
  @DisplayName("Test bytesToString(List) with 'bytesList'; given '42'; then return '**'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List)"})
  void testBytesToStringWithBytesList_given42_thenReturnAsteriskAsterisk() {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add("42");
    bytesList.add("42");

    // Act and Assert
    assertEquals("**", TbUtils.bytesToString(bytesList));
  }

  /**
   * Test {@link TbUtils#bytesToString(List)} with {@code bytesList}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code 42}.
   *   <li>Then return {@code *}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List) with 'bytesList'; given '42'; when ArrayList() add '42'; then return '*'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List)"})
  void testBytesToStringWithBytesList_given42_whenArrayListAdd42_thenReturnAsterisk() {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add("42");

    // Act and Assert
    assertEquals("*", TbUtils.bytesToString(bytesList));
  }

  /**
   * Test {@link TbUtils#bytesToString(List)} with {@code bytesList}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code A}.
   *   <li>Then return {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List) with 'bytesList'; given 'A'; when ArrayList() add 'A'; then return 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List)"})
  void testBytesToStringWithBytesList_givenA_whenArrayListAddA_thenReturnA() {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add((byte) 'A');

    // Act and Assert
    assertEquals("A", TbUtils.bytesToString(bytesList));
  }

  /**
   * Test {@link TbUtils#bytesToString(List)} with {@code bytesList}.
   *
   * <ul>
   *   <li>Given {@code ,}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code ,}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List)}
   */
  @Test
  @DisplayName("Test bytesToString(List) with 'bytesList'; given ','; when ArrayList() add ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List)"})
  void testBytesToStringWithBytesList_givenComma_whenArrayListAddComma() {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add(",");

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.bytesToString(bytesList));
  }

  /**
   * Test {@link TbUtils#bytesToString(List)} with {@code bytesList}.
   *
   * <ul>
   *   <li>Given {@link Integer#MIN_VALUE}.
   *   <li>When {@link ArrayList#ArrayList()} add {@link Integer#MIN_VALUE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List) with 'bytesList'; given MIN_VALUE; when ArrayList() add MIN_VALUE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List)"})
  void testBytesToStringWithBytesList_givenMin_value_whenArrayListAddMin_value() {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add(Integer.MIN_VALUE);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.bytesToString(bytesList));
  }

  /**
   * Test {@link TbUtils#bytesToString(List)} with {@code bytesList}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List) with 'bytesList'; given 'null'; when ArrayList() add 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List)"})
  void testBytesToStringWithBytesList_givenNull_whenArrayListAddNull() {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add(null);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.bytesToString(bytesList));
  }

  /**
   * Test {@link TbUtils#bytesToString(List)} with {@code bytesList}.
   *
   * <ul>
   *   <li>Given two.
   *   <li>Then return start of text.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List)}
   */
  @Test
  @DisplayName("Test bytesToString(List) with 'bytesList'; given two; then return start of text")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List)"})
  void testBytesToStringWithBytesList_givenTwo_thenReturnStartOfText() {
    // Arrange
    ArrayList<Object> bytesList = new ArrayList<>();
    bytesList.add(2);

    // Act and Assert
    assertEquals("\u0002", TbUtils.bytesToString(bytesList));
  }

  /**
   * Test {@link TbUtils#bytesToString(List)} with {@code bytesList}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToString(List)}
   */
  @Test
  @DisplayName(
      "Test bytesToString(List) with 'bytesList'; when ArrayList(); then return empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToString(List)"})
  void testBytesToStringWithBytesList_whenArrayList_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", TbUtils.bytesToString(new ArrayList<>()));
  }

  /**
   * Test {@link TbUtils#stringToBytes(ExecutionContext, Object)} with {@code ctx}, {@code str}.
   *
   * <p>Method under test: {@link TbUtils#stringToBytes(ExecutionContext, Object)}
   */
  @Test
  @DisplayName("Test stringToBytes(ExecutionContext, Object) with 'ctx', 'str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbUtils.stringToBytes(ExecutionContext, Object)"})
  void testStringToBytesWithCtxStr() throws IllegalAccessException {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    // Act
    List<Byte> actualStringToBytesResult = TbUtils.stringToBytes(ctx, "Str");

    // Assert
    assertEquals(15L, ctx.getMemorySize());
    assertEquals(3, actualStringToBytesResult.size());
    assertEquals('S', actualStringToBytesResult.get(0).byteValue());
    assertEquals('r', actualStringToBytesResult.get(2).byteValue());
    assertEquals('t', actualStringToBytesResult.get(1).byteValue());
  }

  /**
   * Test {@link TbUtils#stringToBytes(ExecutionContext, Object)} with {@code ctx}, {@code str}.
   *
   * <p>Method under test: {@link TbUtils#stringToBytes(ExecutionContext, Object)}
   */
  @Test
  @DisplayName("Test stringToBytes(ExecutionContext, Object) with 'ctx', 'str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbUtils.stringToBytes(ExecutionContext, Object)"})
  void testStringToBytesWithCtxStr2() throws IllegalAccessException {
    // Arrange
    ExecutionContext ctx =
        new ExecutionContext(ParserContext.enableSandboxedMode(), Long.MAX_VALUE);

    // Act
    List<Byte> actualStringToBytesResult = TbUtils.stringToBytes(ctx, "Str");

    // Assert
    assertEquals(15L, ctx.getMemorySize());
    assertEquals(3, actualStringToBytesResult.size());
    assertEquals('S', actualStringToBytesResult.get(0).byteValue());
    assertEquals('r', actualStringToBytesResult.get(2).byteValue());
    assertEquals('t', actualStringToBytesResult.get(1).byteValue());
  }

  /**
   * Test {@link TbUtils#stringToBytes(ExecutionContext, Object, String)} with {@code ctx}, {@code
   * str}, {@code charsetName}.
   *
   * <p>Method under test: {@link TbUtils#stringToBytes(ExecutionContext, Object, String)}
   */
  @Test
  @DisplayName(
      "Test stringToBytes(ExecutionContext, Object, String) with 'ctx', 'str', 'charsetName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbUtils.stringToBytes(ExecutionContext, Object, String)"})
  void testStringToBytesWithCtxStrCharsetName()
      throws UnsupportedEncodingException, IllegalAccessException {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    // Act
    List<Byte> actualStringToBytesResult = TbUtils.stringToBytes(ctx, "Str", "UTF-8");

    // Assert
    assertEquals(15L, ctx.getMemorySize());
    assertEquals(3, actualStringToBytesResult.size());
    assertEquals('S', actualStringToBytesResult.get(0).byteValue());
    assertEquals('r', actualStringToBytesResult.get(2).byteValue());
    assertEquals('t', actualStringToBytesResult.get(1).byteValue());
  }

  /**
   * Test {@link TbUtils#stringToBytes(ExecutionContext, Object, String)} with {@code ctx}, {@code
   * str}, {@code charsetName}.
   *
   * <p>Method under test: {@link TbUtils#stringToBytes(ExecutionContext, Object, String)}
   */
  @Test
  @DisplayName(
      "Test stringToBytes(ExecutionContext, Object, String) with 'ctx', 'str', 'charsetName'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbUtils.stringToBytes(ExecutionContext, Object, String)"})
  void testStringToBytesWithCtxStrCharsetName2()
      throws UnsupportedEncodingException, IllegalAccessException {
    // Arrange
    ExecutionContext ctx =
        new ExecutionContext(ParserContext.enableSandboxedMode(), Long.MAX_VALUE);

    // Act
    List<Byte> actualStringToBytesResult = TbUtils.stringToBytes(ctx, "Str", "UTF-8");

    // Assert
    assertEquals(15L, ctx.getMemorySize());
    assertEquals(3, actualStringToBytesResult.size());
    assertEquals('S', actualStringToBytesResult.get(0).byteValue());
    assertEquals('r', actualStringToBytesResult.get(2).byteValue());
    assertEquals('t', actualStringToBytesResult.get(1).byteValue());
  }

  /**
   * Test {@link TbUtils#stringToBytes(ExecutionContext, Object, String)} with {@code ctx}, {@code
   * str}, {@code charsetName}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#stringToBytes(ExecutionContext, Object, String)}
   */
  @Test
  @DisplayName(
      "Test stringToBytes(ExecutionContext, Object, String) with 'ctx', 'str', 'charsetName'; when one; then throw IllegalAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbUtils.stringToBytes(ExecutionContext, Object, String)"})
  void testStringToBytesWithCtxStrCharsetName_whenOne_thenThrowIllegalAccessException()
      throws UnsupportedEncodingException, IllegalAccessException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalAccessException.class,
        () ->
            TbUtils.stringToBytes(
                new ExecutionContext(ParserContext.enableSandboxedMode()), 1, "UTF-8"));
  }

  /**
   * Test {@link TbUtils#stringToBytes(ExecutionContext, Object)} with {@code ctx}, {@code str}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalAccessException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#stringToBytes(ExecutionContext, Object)}
   */
  @Test
  @DisplayName(
      "Test stringToBytes(ExecutionContext, Object) with 'ctx', 'str'; when one; then throw IllegalAccessException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbUtils.stringToBytes(ExecutionContext, Object)"})
  void testStringToBytesWithCtxStr_whenOne_thenThrowIllegalAccessException()
      throws IllegalAccessException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalAccessException.class,
        () -> TbUtils.stringToBytes(new ExecutionContext(ParserContext.enableSandboxedMode()), 1));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when '0'; then return intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_when0_thenReturnIntValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0, TbUtils.parseInt("0", 8).intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return intValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when '0'; then return intValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_when0_thenReturnIntValueIsZero2() {
    // Arrange, Act and Assert
    assertEquals(0, TbUtils.parseInt("0", 2).intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("0X9", Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("0x", 8));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_when0x_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("0x", 10));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_when0x_thenThrowNumberFormatException3() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("0x", Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when '0123456789ABCDEF'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_when0123456789abcdef_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("0123456789ABCDEF", 25));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return intValue is thirty-four.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when eight; then return intValue is thirty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenEight_thenReturnIntValueIsThirtyFour() {
    // Arrange, Act and Assert
    assertEquals(34, TbUtils.parseInt("42", 8).intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when eight; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenEight_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("not blank", 8));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseInt("", 25));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName("Test parseInt(String, int) with 'value', 'radix'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseInt(null, 25));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseInt("42", 1));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return intValue is sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when SIZE; then return intValue is sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenSize_thenReturnIntValueIsSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66, TbUtils.parseInt("42", Short.SIZE).intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when SIZE; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenSize_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("not blank", Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when ten; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenTen_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, TbUtils.parseInt("42", 10).intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when ten; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenTen_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("not blank", 10));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When thirty-seven.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when thirty-seven; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenThirtySeven_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseInt("not blank", 37));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When twenty-five.
   *   <li>Then return intValue is one hundred two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when twenty-five; then return intValue is one hundred two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenTwentyFive_thenReturnIntValueIsOneHundredTwo() {
    // Arrange, Act and Assert
    assertEquals(102, TbUtils.parseInt("42", 25).intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when two; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenTwo_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("not blank", 2));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when two; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenTwo_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("0x", 2));
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when zero; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenZero_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, TbUtils.parseInt("42", 0).intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String, int) with 'value', 'radix'; when zero; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String, int)"})
  void testParseIntWithValueRadix_whenZero_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("not blank", 0));
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code -0X9}.
   *   <li>Then return intValue is minus nine.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String) with 'value'; when '-0X9'; then return intValue is minus nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_when0x9_thenReturnIntValueIsMinusNine() {
    // Arrange, Act and Assert
    assertEquals(-9, TbUtils.parseInt("-0X9").intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then return intValue is nine.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName("Test parseInt(String) with 'value'; when '0X9'; then return intValue is nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_when0x9_thenReturnIntValueIsNine() {
    // Arrange, Act and Assert
    assertEquals(9, TbUtils.parseInt("0X9").intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0x42}.
   *   <li>Then return intValue is sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName("Test parseInt(String) with 'value'; when '0x42'; then return intValue is sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_when0x42_thenReturnIntValueIsSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66, TbUtils.parseInt("0x42").intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return intValue is ninety-nine.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String) with 'value'; when '0X90X9'; then return intValue is ninety-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_when0x90x9_thenReturnIntValueIsNinetyNine() {
    // Arrange, Act and Assert
    assertEquals(99, TbUtils.parseInt("0X90X9").intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0x9.9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName("Test parseInt(String) with 'value'; when '0x9.9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_when0x99_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("0x9.9"));
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X942}.
   *   <li>Then return intValue is nine hundred forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String) with 'value'; when '0X942'; then return intValue is nine hundred forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_when0x942_thenReturnIntValueIsNineHundredFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(942, TbUtils.parseInt("0X942").intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String) with 'value'; when '0X90123456789ABCDEF'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_when0x90123456789abcdef_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName("Test parseInt(String) with 'value'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("0x"));
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return intValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName("Test parseInt(String) with 'value'; when '42'; then return intValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_when42_thenReturnIntValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42, TbUtils.parseInt("42").intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return intValue is minus forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String) with 'value'; when '-42'; then return intValue is minus forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_when42_thenReturnIntValueIsMinusFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(-42, TbUtils.parseInt("-42").intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 420X9}.
   *   <li>Then return intValue is four hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String) with 'value'; when '420X9'; then return intValue is four hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_when420x9_thenReturnIntValueIsFourHundredTwentyNine() {
    // Arrange, Act and Assert
    assertEquals(429, TbUtils.parseInt("420X9").intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return intValue is {@code 4242}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName("Test parseInt(String) with 'value'; when '4242'; then return intValue is '4242'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_when4242_thenReturnIntValueIs4242() {
    // Arrange, Act and Assert
    assertEquals(4242, TbUtils.parseInt("4242").intValue());
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName("Test parseInt(String) with 'value'; when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseInt(""));
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseInt(String) with 'value'; when 'not blank'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_whenNotBlank_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseInt("not blank"));
  }

  /**
   * Test {@link TbUtils#parseInt(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseInt(String)}
   */
  @Test
  @DisplayName("Test parseInt(String) with 'value'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseInt(String)"})
  void testParseIntWithValue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseInt(null));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>Then return longValue is {@code 81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; then return longValue is '81985529216486895'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_thenReturnLongValueIs81985529216486895() {
    // Arrange, Act and Assert
    assertEquals(81985529216486895L, TbUtils.parseLong("0123456789ABCDEF", 0).longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when '0'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_when0_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, TbUtils.parseLong("0", 8).longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when '0'; then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_when0_thenReturnLongValueIsZero2() {
    // Arrange, Act and Assert
    assertEquals(0L, TbUtils.parseLong("0", 2).longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("0X9", Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("0x", 8));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_when0x_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("0x", 10));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_when0x_thenThrowNumberFormatException3() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("0x", Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when '0123456789ABCDEF'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_when0123456789abcdef_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("0123456789ABCDEF", 25));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return longValue is thirty-four.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when eight; then return longValue is thirty-four")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenEight_thenReturnLongValueIsThirtyFour() {
    // Arrange, Act and Assert
    assertEquals(34L, TbUtils.parseLong("42", 8).longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when eight; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenEight_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("not blank", 8));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseLong("", 25));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName("Test parseLong(String, int) with 'value', 'radix'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseLong(null, 25));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseLong("42", 1));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return longValue is sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when SIZE; then return longValue is sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenSize_thenReturnLongValueIsSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66L, TbUtils.parseLong("42", Short.SIZE).longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when SIZE; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenSize_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("not blank", Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when ten; then return longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenTen_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, TbUtils.parseLong("42", 10).longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when ten; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenTen_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("not blank", 10));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When thirty-seven.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when thirty-seven; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenThirtySeven_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseLong("not blank", 37));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When twenty-five.
   *   <li>Then return longValue is one hundred two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when twenty-five; then return longValue is one hundred two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenTwentyFive_thenReturnLongValueIsOneHundredTwo() {
    // Arrange, Act and Assert
    assertEquals(102L, TbUtils.parseLong("42", 25).longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when two; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenTwo_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("not blank", 2));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when two; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenTwo_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("0x", 2));
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when zero; then return longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenZero_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, TbUtils.parseLong("42", 0).longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String, int) with 'value', 'radix'; when zero; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String, int)"})
  void testParseLongWithValueRadix_whenZero_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("not blank", 0));
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return longValue is {@code 81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName("Test parseLong(String) with 'value'; then return longValue is '81985529216486895'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_thenReturnLongValueIs81985529216486895() {
    // Arrange, Act and Assert
    assertEquals(81985529216486895L, TbUtils.parseLong("0123456789ABCDEF").longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>Then return longValue is {@code -81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName("Test parseLong(String) with 'value'; then return longValue is '-81985529216486895'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_thenReturnLongValueIs819855292164868952() {
    // Arrange, Act and Assert
    assertEquals(-81985529216486895L, TbUtils.parseLong("-0123456789ABCDEF").longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code -0X9}.
   *   <li>Then return longValue is minus nine.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String) with 'value'; when '-0X9'; then return longValue is minus nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_when0x9_thenReturnLongValueIsMinusNine() {
    // Arrange, Act and Assert
    assertEquals(-9L, TbUtils.parseLong("-0X9").longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then return longValue is nine.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName("Test parseLong(String) with 'value'; when '0X9'; then return longValue is nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_when0x9_thenReturnLongValueIsNine() {
    // Arrange, Act and Assert
    assertEquals(9L, TbUtils.parseLong("0X9").longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0x42}.
   *   <li>Then return longValue is sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String) with 'value'; when '0x42'; then return longValue is sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_when0x42_thenReturnLongValueIsSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66L, TbUtils.parseLong("0x42").longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return longValue is ninety-nine.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String) with 'value'; when '0X90X9'; then return longValue is ninety-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_when0x90x9_thenReturnLongValueIsNinetyNine() {
    // Arrange, Act and Assert
    assertEquals(99L, TbUtils.parseLong("0X90X9").longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0x9.9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String) with 'value'; when '0x9.9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_when0x99_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("0x9.9"));
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X942}.
   *   <li>Then return longValue is nine hundred forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String) with 'value'; when '0X942'; then return longValue is nine hundred forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_when0x942_thenReturnLongValueIsNineHundredFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(942L, TbUtils.parseLong("0X942").longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String) with 'value'; when '0X90123456789ABCDEF'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_when0x90123456789abcdef_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName("Test parseLong(String) with 'value'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("0x"));
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return longValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName("Test parseLong(String) with 'value'; when '42'; then return longValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_when42_thenReturnLongValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42L, TbUtils.parseLong("42").longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return longValue is minus forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String) with 'value'; when '-42'; then return longValue is minus forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_when42_thenReturnLongValueIsMinusFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(-42L, TbUtils.parseLong("-42").longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 420X9}.
   *   <li>Then return longValue is four hundred twenty-nine.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String) with 'value'; when '420X9'; then return longValue is four hundred twenty-nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_when420x9_thenReturnLongValueIsFourHundredTwentyNine() {
    // Arrange, Act and Assert
    assertEquals(429L, TbUtils.parseLong("420X9").longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return longValue is {@code 4242}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName("Test parseLong(String) with 'value'; when '4242'; then return longValue is '4242'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_when4242_thenReturnLongValueIs4242() {
    // Arrange, Act and Assert
    assertEquals(4242L, TbUtils.parseLong("4242").longValue());
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName("Test parseLong(String) with 'value'; when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseLong(""));
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLong(String) with 'value'; when 'not blank'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_whenNotBlank_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLong("not blank"));
  }

  /**
   * Test {@link TbUtils#parseLong(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLong(String)}
   */
  @Test
  @DisplayName("Test parseLong(String) with 'value'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseLong(String)"})
  void testParseLongWithValue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseLong(null));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>Then return floatValue is {@code -4.136041E-33}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; then return floatValue is '-4.136041E-33'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_thenReturnFloatValueIs4136041e33() {
    // Arrange, Act and Assert
    assertEquals(-4.136041E-33f, TbUtils.parseFloat("0123456789ABCDEF", 0).floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when '0'; then return floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_when0_thenReturnFloatValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0.0f, TbUtils.parseFloat("0", 8).floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return floatValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when '0'; then return floatValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_when0_thenReturnFloatValueIsZero2() {
    // Arrange, Act and Assert
    assertEquals(0.0f, TbUtils.parseFloat("0", 2).floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("0X9", Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("0x", Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_when0x_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("0x", 0));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_when0x_thenThrowNumberFormatException3() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("0x", 8));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return floatValue is {@code 9.2E-44}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when '42'; then return floatValue is '9.2E-44'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_when42_thenReturnFloatValueIs92e44() {
    // Arrange, Act and Assert
    assertEquals(9.2E-44f, TbUtils.parseFloat("42", Short.SIZE).floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 9.9}.
   *   <li>Then return floatValue is {@code 9.9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when '9.9'; then return floatValue is '9.9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_when99_thenReturnFloatValueIs99() {
    // Arrange, Act and Assert
    assertEquals(9.9f, TbUtils.parseFloat("9.9", 10).floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return floatValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when eight; then return floatValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenEight_thenReturnFloatValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f, TbUtils.parseFloat("42", 8).floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when eight; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenEight_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("not blank", 8));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseFloat("", Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseFloat(null, Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseFloat("42", 1));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when SIZE; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenSize_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("not blank", Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return floatValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when ten; then return floatValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenTen_thenReturnFloatValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f, TbUtils.parseFloat("42", 10).floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when ten; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenTen_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("not blank", 10));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When thirty-seven.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when thirty-seven; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenThirtySeven_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseFloat("not blank", 37));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When twenty-five.
   *   <li>Then return floatValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when twenty-five; then return floatValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenTwentyFive_thenReturnFloatValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f, TbUtils.parseFloat("42", 25).floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when two; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenTwo_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("not blank", 2));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when two; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenTwo_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("0x", 2));
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return floatValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when zero; then return floatValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenZero_thenReturnFloatValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f, TbUtils.parseFloat("42", 0).floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String, int) with 'value', 'radix'; when zero; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String, int)"})
  void testParseFloatWithValueRadix_whenZero_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("not blank", 0));
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0x42}.
   *   <li>Then return floatValue is {@code 9.2E-44}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String) with 'value'; when '0x42'; then return floatValue is '9.2E-44'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when0x42_thenReturnFloatValueIs92e44() {
    // Arrange, Act and Assert
    assertEquals(9.2E-44f, TbUtils.parseFloat("0x42").floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0x9.9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String) with 'value'; when '0x9.9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when0x99_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("0x9.9"));
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String) with 'value'; when '0X90123456789ABCDEF'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when0x90123456789abcdef_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName("Test parseFloat(String) with 'value'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("0x"));
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return floatValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String) with 'value'; when '42'; then return floatValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when42_thenReturnFloatValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0f, TbUtils.parseFloat("42").floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return floatValue is minus forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String) with 'value'; when '-42'; then return floatValue is minus forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when42_thenReturnFloatValueIsMinusFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(-42.0f, TbUtils.parseFloat("-42").floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 9.9}.
   *   <li>Then return floatValue is {@code 9.9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName("Test parseFloat(String) with 'value'; when '9.9'; then return floatValue is '9.9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when99_thenReturnFloatValueIs99() {
    // Arrange, Act and Assert
    assertEquals(9.9f, TbUtils.parseFloat("9.9").floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code -9.9}.
   *   <li>Then return floatValue is {@code -9.9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String) with 'value'; when '-9.9'; then return floatValue is '-9.9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when99_thenReturnFloatValueIs992() {
    // Arrange, Act and Assert
    assertEquals(-9.9f, TbUtils.parseFloat("-9.9").floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return floatValue is {@code 4242.0}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String) with 'value'; when '4242'; then return floatValue is '4242.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when4242_thenReturnFloatValueIs42420() {
    // Arrange, Act and Assert
    assertEquals(4242.0f, TbUtils.parseFloat("4242").floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 429.9}.
   *   <li>Then return floatValue is {@code 429.9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String) with 'value'; when '429.9'; then return floatValue is '429.9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when4299_thenReturnFloatValueIs4299() {
    // Arrange, Act and Assert
    assertEquals(429.9f, TbUtils.parseFloat("429.9").floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 9.942}.
   *   <li>Then return floatValue is {@code 9.942}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String) with 'value'; when '9.942'; then return floatValue is '9.942'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when9942_thenReturnFloatValueIs9942() {
    // Arrange, Act and Assert
    assertEquals(9.942f, TbUtils.parseFloat("9.942").floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return floatValue is {@code -4.136041E-33}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String) with 'value'; when '0123456789ABCDEF'; then return floatValue is '-4.136041E-33'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when0123456789abcdef_thenReturnFloatValueIs4136041e33() {
    // Arrange, Act and Assert
    assertEquals(-4.136041E-33f, TbUtils.parseFloat("0123456789ABCDEF").floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code -0123456789ABCDEF}.
   *   <li>Then return floatValue is {@code 1.0759594E33}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String) with 'value'; when '-0123456789ABCDEF'; then return floatValue is '1.0759594E33'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_when0123456789abcdef_thenReturnFloatValueIs10759594e33() {
    // Arrange, Act and Assert
    assertEquals(1.0759594E33f, TbUtils.parseFloat("-0123456789ABCDEF").floatValue());
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName("Test parseFloat(String) with 'value'; when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseFloat(""));
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseFloat(String) with 'value'; when 'not blank'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_whenNotBlank_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseFloat("not blank"));
  }

  /**
   * Test {@link TbUtils#parseFloat(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseFloat(String)}
   */
  @Test
  @DisplayName("Test parseFloat(String) with 'value'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseFloat(String)"})
  void testParseFloatWithValue_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseFloat(null));
  }

  /**
   * Test {@link TbUtils#parseHexIntLongToFloat(String, boolean)}.
   *
   * <ul>
   *   <li>Then return floatValue is {@code -1.98522931E9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexIntLongToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexIntLongToFloat(String, boolean); then return floatValue is '-1.98522931E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexIntLongToFloat(String, boolean)"})
  void testParseHexIntLongToFloat_thenReturnFloatValueIs198522931e9() {
    // Arrange, Act and Assert
    assertEquals(
        -1.98522931E9f, TbUtils.parseHexIntLongToFloat("0123456789ABCDEF", true).floatValue());
  }

  /**
   * Test {@link TbUtils#parseHexIntLongToFloat(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code ^-?(0[xX])?[0-9a-fA-F]+$}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexIntLongToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexIntLongToFloat(String, boolean); when '^-?(0[xX])?[0-9a-fA-F]+$'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexIntLongToFloat(String, boolean)"})
  void testParseHexIntLongToFloat_when0XX09aFAF_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.parseHexIntLongToFloat("^-?(0[xX])?[0-9a-fA-F]+$", false));
  }

  /**
   * Test {@link TbUtils#parseHexIntLongToFloat(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexIntLongToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexIntLongToFloat(String, boolean); when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexIntLongToFloat(String, boolean)"})
  void testParseHexIntLongToFloat_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexIntLongToFloat("0X9", true));
  }

  /**
   * Test {@link TbUtils#parseHexIntLongToFloat(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexIntLongToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexIntLongToFloat(String, boolean); when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexIntLongToFloat(String, boolean)"})
  void testParseHexIntLongToFloat_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexIntLongToFloat("0x", false));
  }

  /**
   * Test {@link TbUtils#parseHexIntLongToFloat(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return floatValue is sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexIntLongToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexIntLongToFloat(String, boolean); when '42'; then return floatValue is sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexIntLongToFloat(String, boolean)"})
  void testParseHexIntLongToFloat_when42_thenReturnFloatValueIsSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66.0f, TbUtils.parseHexIntLongToFloat("42", false).floatValue());
  }

  /**
   * Test {@link TbUtils#parseHexIntLongToFloat(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexIntLongToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexIntLongToFloat(String, boolean); when '-'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexIntLongToFloat(String, boolean)"})
  void testParseHexIntLongToFloat_whenDash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseHexIntLongToFloat("-", false));
  }

  /**
   * Test {@link TbUtils#parseHexIntLongToFloat(String, boolean)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexIntLongToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexIntLongToFloat(String, boolean); when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexIntLongToFloat(String, boolean)"})
  void testParseHexIntLongToFloat_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseHexIntLongToFloat("", false));
  }

  /**
   * Test {@link TbUtils#parseHexIntLongToFloat(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexIntLongToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexIntLongToFloat(String, boolean); when 'not blank'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexIntLongToFloat(String, boolean)"})
  void testParseHexIntLongToFloat_whenNotBlank_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseHexIntLongToFloat("not blank", false));
  }

  /**
   * Test {@link TbUtils#parseHexIntLongToFloat(String, boolean)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexIntLongToFloat(String, boolean)}
   */
  @Test
  @DisplayName("Test parseHexIntLongToFloat(String, boolean); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexIntLongToFloat(String, boolean)"})
  void testParseHexIntLongToFloat_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseHexIntLongToFloat(null, false));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>Then return doubleValue is {@code 3.512700564088504E-303}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; then return doubleValue is '3.512700564088504E-303'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_thenReturnDoubleValueIs3512700564088504e303() {
    // Arrange, Act and Assert
    assertEquals(3.512700564088504E-303d, TbUtils.parseDouble("0123456789ABCDEF", 0).doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when '0'; then return doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_when0_thenReturnDoubleValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, TbUtils.parseDouble("0", 8).doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return doubleValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when '0'; then return doubleValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_when0_thenReturnDoubleValueIsZero2() {
    // Arrange, Act and Assert
    assertEquals(0.0d, TbUtils.parseDouble("0", 2).doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("0X9", Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("0x", 10));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_when0x_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("0x", 0));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_when0x_thenThrowNumberFormatException3() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("0x", 8));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return doubleValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when '42'; then return doubleValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_when42_thenReturnDoubleValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0d, TbUtils.parseDouble("42", 10).doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code 9.9}.
   *   <li>Then return doubleValue is {@code 9.9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when '9.9'; then return doubleValue is '9.9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_when99_thenReturnDoubleValueIs99() {
    // Arrange, Act and Assert
    assertEquals(9.9d, TbUtils.parseDouble("9.9", 10).doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return doubleValue is {@code 3.26E-322}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when eight; then return doubleValue is '3.26E-322'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenEight_thenReturnDoubleValueIs326e322() {
    // Arrange, Act and Assert
    assertEquals(3.26E-322d, TbUtils.parseDouble("42", 8).doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when eight; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenEight_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("not blank", 8));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseDouble("", 10));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseDouble(null, 10));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when one; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenOne_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseDouble("42", 1));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return doubleValue is {@code 3.26E-322}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when SIZE; then return doubleValue is '3.26E-322'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenSize_thenReturnDoubleValueIs326e322() {
    // Arrange, Act and Assert
    assertEquals(3.26E-322d, TbUtils.parseDouble("42", Short.SIZE).doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when SIZE; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenSize_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("not blank", Short.SIZE));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when ten; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenTen_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("not blank", 10));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When thirty-seven.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when thirty-seven; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenThirtySeven_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseDouble("not blank", 37));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When twenty-five.
   *   <li>Then return doubleValue is {@code 3.26E-322}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when twenty-five; then return doubleValue is '3.26E-322'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenTwentyFive_thenReturnDoubleValueIs326e322() {
    // Arrange, Act and Assert
    assertEquals(3.26E-322d, TbUtils.parseDouble("42", 25).doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when two; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenTwo_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("not blank", 2));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when two; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenTwo_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("0x", 2));
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then return doubleValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when zero; then return doubleValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenZero_thenReturnDoubleValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0d, TbUtils.parseDouble("42", 0).doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String, int)} with {@code value}, {@code radix}.
   *
   * <ul>
   *   <li>When zero.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String, int)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String, int) with 'value', 'radix'; when zero; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String, int)"})
  void testParseDoubleWithValueRadix_whenZero_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("not blank", 0));
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("0X9"));
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code -0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '-0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when0x9_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("-0X9"));
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0x42}.
   *   <li>Then return doubleValue is {@code 3.26E-322}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '0x42'; then return doubleValue is '3.26E-322'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when0x42_thenReturnDoubleValueIs326e322() {
    // Arrange, Act and Assert
    assertEquals(3.26E-322d, TbUtils.parseDouble("0x42").doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X42}.
   *   <li>Then return doubleValue is {@code 3.26E-322}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '0X42'; then return doubleValue is '3.26E-322'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when0x42_thenReturnDoubleValueIs326e3222() {
    // Arrange, Act and Assert
    assertEquals(3.26E-322d, TbUtils.parseDouble("0X42").doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X942}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '0X942'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when0x942_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("0X942"));
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0x0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName("Test parseDouble(String) with 'value'; when '0x0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when0x0123456789ABCDEF() {
    // Arrange, Act and Assert
    assertEquals(3.512700564088504E-303d, TbUtils.parseDouble("0x0123456789ABCDEF").doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName("Test parseDouble(String) with 'value'; when '0X0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when0x0123456789abcdef() {
    // Arrange, Act and Assert
    assertEquals(3.512700564088504E-303d, TbUtils.parseDouble("0X0123456789ABCDEF").doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '0X90123456789ABCDEF'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when0x90123456789abcdef_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return doubleValue is forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '42'; then return doubleValue is forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when42_thenReturnDoubleValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0d, TbUtils.parseDouble("42").doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return doubleValue is minus forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '-42'; then return doubleValue is minus forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when42_thenReturnDoubleValueIsMinusFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(-42.0d, TbUtils.parseDouble("-42").doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 9.9}.
   *   <li>Then return doubleValue is {@code 9.9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '9.9'; then return doubleValue is '9.9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when99_thenReturnDoubleValueIs99() {
    // Arrange, Act and Assert
    assertEquals(9.9d, TbUtils.parseDouble("9.9").doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code -9.9}.
   *   <li>Then return doubleValue is {@code -9.9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '-9.9'; then return doubleValue is '-9.9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when99_thenReturnDoubleValueIs992() {
    // Arrange, Act and Assert
    assertEquals(-9.9d, TbUtils.parseDouble("-9.9").doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return doubleValue is {@code 4242.0}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '4242'; then return doubleValue is '4242.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when4242_thenReturnDoubleValueIs42420() {
    // Arrange, Act and Assert
    assertEquals(4242.0d, TbUtils.parseDouble("4242").doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 429.9}.
   *   <li>Then return doubleValue is {@code 429.9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '429.9'; then return doubleValue is '429.9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when4299_thenReturnDoubleValueIs4299() {
    // Arrange, Act and Assert
    assertEquals(429.9d, TbUtils.parseDouble("429.9").doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 9.942}.
   *   <li>Then return doubleValue is {@code 9.942}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when '9.942'; then return doubleValue is '9.942'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when9942_thenReturnDoubleValueIs9942() {
    // Arrange, Act and Assert
    assertEquals(9.942d, TbUtils.parseDouble("9.942").doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName("Test parseDouble(String) with 'value'; when '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_when0123456789abcdef() {
    // Arrange, Act and Assert
    assertEquals(3.512700564088504E-303d, TbUtils.parseDouble("0123456789ABCDEF").doubleValue());
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when empty string; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_whenEmptyString_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble(""));
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when 'not blank'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_whenNotBlank_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble("not blank"));
  }

  /**
   * Test {@link TbUtils#parseDouble(String)} with {@code value}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseDouble(String) with 'value'; when 'null'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Double TbUtils.parseDouble(String)"})
  void testParseDoubleWithValue_whenNull_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseDouble(null));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code ^-?(0[xX])?[0-9a-fA-F]+$}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToInt(String); when '^-?(0[xX])?[0-9a-fA-F]+$'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseLittleEndianHexToInt(String)"})
  void testParseLittleEndianHexToInt_when0XX09aFAF_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.parseLittleEndianHexToInt("^-?(0[xX])?[0-9a-fA-F]+$"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 0x42}.
   *   <li>Then return sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToInt(String); when '0x42'; then return sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseLittleEndianHexToInt(String)"})
  void testParseLittleEndianHexToInt_when0x42_thenReturnSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66, TbUtils.parseLittleEndianHexToInt("0x42"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return one hundred fifty-three.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToInt(String); when '0X90X9'; then return one hundred fifty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseLittleEndianHexToInt(String)"})
  void testParseLittleEndianHexToInt_when0x90x9_thenReturnOneHundredFiftyThree() {
    // Arrange, Act and Assert
    assertEquals(153, TbUtils.parseLittleEndianHexToInt("0X90X9"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToInt(String); when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseLittleEndianHexToInt(String)"})
  void testParseLittleEndianHexToInt_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLittleEndianHexToInt("0x"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToInt(String); when '42'; then return sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseLittleEndianHexToInt(String)"})
  void testParseLittleEndianHexToInt_when42_thenReturnSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66, TbUtils.parseLittleEndianHexToInt("42"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 16962}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToInt(String); when '4242'; then return '16962'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseLittleEndianHexToInt(String)"})
  void testParseLittleEndianHexToInt_when4242_thenReturn16962() {
    // Arrange, Act and Assert
    assertEquals(16962, TbUtils.parseLittleEndianHexToInt("4242"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToInt(String); when '-'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseLittleEndianHexToInt(String)"})
  void testParseLittleEndianHexToInt_whenDash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseLittleEndianHexToInt("-"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToInt(String); when 'not blank'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseLittleEndianHexToInt(String)"})
  void testParseLittleEndianHexToInt_whenNotBlank_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseLittleEndianHexToInt("not blank"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToInt(String); when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToInt("0X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code -0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToInt(String); when '-0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_when0x9_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToInt("-0X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 0x42}.
   *   <li>Then return sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToInt(String); when '0x42'; then return sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_when0x42_thenReturnSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66, TbUtils.parseBigEndianHexToInt("0x42"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return one hundred fifty-three.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToInt(String); when '0X90X9'; then return one hundred fifty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_when0x90x9_thenReturnOneHundredFiftyThree() {
    // Arrange, Act and Assert
    assertEquals(153, TbUtils.parseBigEndianHexToInt("0X90X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 0X942}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToInt(String); when '0X942'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_when0x942_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToInt("0X942"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToInt(String); when '0X90123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_when0x90123456789abcdef() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class, () -> TbUtils.parseBigEndianHexToInt("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToInt(String); when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToInt("0x"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return minus sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToInt(String); when '-42'; then return minus sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_when42_thenReturnMinusSixtySix() {
    // Arrange, Act and Assert
    assertEquals(-66, TbUtils.parseBigEndianHexToInt("-42"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToInt(String); when '42'; then return sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_when42_thenReturnSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66, TbUtils.parseBigEndianHexToInt("42"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 420X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToInt(String); when '420X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_when420x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToInt("420X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 16962}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToInt(String); when '4242'; then return '16962'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_when4242_thenReturn16962() {
    // Arrange, Act and Assert
    assertEquals(16962, TbUtils.parseBigEndianHexToInt("4242"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF0X9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToInt(String); when '0123456789ABCDEF0X9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_when0123456789abcdef0x9() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class, () -> TbUtils.parseBigEndianHexToInt("0123456789ABCDEF0X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToInt(String)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToInt(String); when 'not blank'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBigEndianHexToInt(String)"})
  void testParseBigEndianHexToInt_whenNotBlank_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToInt("not blank"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String) with 'hex'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToInt("0X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code -0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String) with 'hex'; when '-0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_when0x9_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToInt("-0X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0x42}.
   *   <li>Then return sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseHexToInt(String) with 'hex'; when '0x42'; then return sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_when0x42_thenReturnSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66, TbUtils.parseHexToInt("0x42"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return one hundred fifty-three.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String) with 'hex'; when '0X90X9'; then return one hundred fifty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_when0x90x9_thenReturnOneHundredFiftyThree() {
    // Arrange, Act and Assert
    assertEquals(153, TbUtils.parseHexToInt("0X90X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X942}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String) with 'hex'; when '0X942'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_when0x942_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToInt("0X942"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String) with 'hex'; when '0X90123456789ABCDEF'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_when0x90123456789abcdef_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToInt("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseHexToInt(String) with 'hex'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToInt("0x"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return minus sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseHexToInt(String) with 'hex'; when '-42'; then return minus sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_when42_thenReturnMinusSixtySix() {
    // Arrange, Act and Assert
    assertEquals(-66, TbUtils.parseHexToInt("-42"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseHexToInt(String) with 'hex'; when '42'; then return sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_when42_thenReturnSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66, TbUtils.parseHexToInt("42"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 420X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String) with 'hex'; when '420X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_when420x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToInt("420X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 16962}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName("Test parseHexToInt(String) with 'hex'; when '4242'; then return '16962'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_when4242_thenReturn16962() {
    // Arrange, Act and Assert
    assertEquals(16962, TbUtils.parseHexToInt("4242"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String) with 'hex'; when '0123456789ABCDEF0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_when0123456789abcdef0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToInt("0123456789ABCDEF0X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String) with 'hex'; when 'not blank'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseHexToInt(String)"})
  void testParseHexToIntWithHex_whenNotBlank_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToInt("not blank"));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code ^-?(0[xX])?[0-9a-fA-F]+$}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String, boolean) with 'value', 'bigEndian'; when '^-?(0[xX])?[0-9a-fA-F]+$'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseHexToInt(String, boolean)"})
  void testParseHexToIntWithValueBigEndian_when0XX09aFAF_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.parseHexToInt("^-?(0[xX])?[0-9a-fA-F]+$", false));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String, boolean) with 'value', 'bigEndian'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseHexToInt(String, boolean)"})
  void testParseHexToIntWithValueBigEndian_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToInt("0X9", true));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String, boolean) with 'value', 'bigEndian'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseHexToInt(String, boolean)"})
  void testParseHexToIntWithValueBigEndian_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToInt("0x", false));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return intValue is sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String, boolean) with 'value', 'bigEndian'; when '42'; then return intValue is sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseHexToInt(String, boolean)"})
  void testParseHexToIntWithValueBigEndian_when42_thenReturnIntValueIsSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66, TbUtils.parseHexToInt("42", false).intValue());
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return intValue is sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String, boolean) with 'value', 'bigEndian'; when '42'; then return intValue is sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseHexToInt(String, boolean)"})
  void testParseHexToIntWithValueBigEndian_when42_thenReturnIntValueIsSixtySix2() {
    // Arrange, Act and Assert
    assertEquals(66, TbUtils.parseHexToInt("42", true).intValue());
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String, boolean) with 'value', 'bigEndian'; when '-'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseHexToInt(String, boolean)"})
  void testParseHexToIntWithValueBigEndian_whenDash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseHexToInt("-", false));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String, boolean) with 'value', 'bigEndian'; when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseHexToInt(String, boolean)"})
  void testParseHexToIntWithValueBigEndian_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseHexToInt("", false));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String, boolean)}
   */
  @Test
  @DisplayName("Test parseHexToInt(String, boolean) with 'value', 'bigEndian'; when 'not blank'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseHexToInt(String, boolean)"})
  void testParseHexToIntWithValueBigEndian_whenNotBlank() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseHexToInt("not blank", false));
  }

  /**
   * Test {@link TbUtils#parseHexToInt(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToInt(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToInt(String, boolean) with 'value', 'bigEndian'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Integer TbUtils.parseHexToInt(String, boolean)"})
  void testParseHexToIntWithValueBigEndian_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseHexToInt(null, false));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code ^-?(0[xX])?[0-9a-fA-F]+$}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToLong(String); when '^-?(0[xX])?[0-9a-fA-F]+$'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseLittleEndianHexToLong(String)"})
  void testParseLittleEndianHexToLong_when0XX09aFAF_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.parseLittleEndianHexToLong("^-?(0[xX])?[0-9a-fA-F]+$"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0x42}.
   *   <li>Then return sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToLong(String); when '0x42'; then return sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseLittleEndianHexToLong(String)"})
  void testParseLittleEndianHexToLong_when0x42_thenReturnSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66L, TbUtils.parseLittleEndianHexToLong("0x42"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return one hundred fifty-three.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToLong(String); when '0X90X9'; then return one hundred fifty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseLittleEndianHexToLong(String)"})
  void testParseLittleEndianHexToLong_when0x90x9_thenReturnOneHundredFiftyThree() {
    // Arrange, Act and Assert
    assertEquals(153L, TbUtils.parseLittleEndianHexToLong("0X90X9"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToLong(String); when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseLittleEndianHexToLong(String)"})
  void testParseLittleEndianHexToLong_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLittleEndianHexToLong("0x"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToLong(String); when '42'; then return sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseLittleEndianHexToLong(String)"})
  void testParseLittleEndianHexToLong_when42_thenReturnSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66L, TbUtils.parseLittleEndianHexToLong("42"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 16962}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToLong(String); when '4242'; then return '16962'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseLittleEndianHexToLong(String)"})
  void testParseLittleEndianHexToLong_when4242_thenReturn16962() {
    // Arrange, Act and Assert
    assertEquals(16962L, TbUtils.parseLittleEndianHexToLong("4242"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToLong(String); when '-'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseLittleEndianHexToLong(String)"})
  void testParseLittleEndianHexToLong_whenDash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseLittleEndianHexToLong("-"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToLong(String); when 'not blank'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseLittleEndianHexToLong(String)"})
  void testParseLittleEndianHexToLong_whenNotBlank_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseLittleEndianHexToLong("not blank"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToLong(String); when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToLong("0X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code -0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToLong(String); when '-0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when0x9_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToLong("-0X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return one hundred fifty-three.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToLong(String); when '0X90X9'; then return one hundred fifty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when0x90x9_thenReturnOneHundredFiftyThree() {
    // Arrange, Act and Assert
    assertEquals(153L, TbUtils.parseBigEndianHexToLong("0X90X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0X942}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToLong(String); when '0X942'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when0x942_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToLong("0X942"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0x0123456789ABCDEF}.
   *   <li>Then return {@code 81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToLong(String); when '0x0123456789ABCDEF'; then return '81985529216486895'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when0x0123456789ABCDEF_thenReturn81985529216486895() {
    // Arrange, Act and Assert
    assertEquals(81985529216486895L, TbUtils.parseBigEndianHexToLong("0x0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToLong(String); when '0X90123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when0x90123456789abcdef() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class, () -> TbUtils.parseBigEndianHexToLong("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToLong(String); when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToLong("0x"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return minus sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToLong(String); when '-42'; then return minus sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when42_thenReturnMinusSixtySix() {
    // Arrange, Act and Assert
    assertEquals(-66L, TbUtils.parseBigEndianHexToLong("-42"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToLong(String); when '42'; then return sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when42_thenReturnSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66L, TbUtils.parseBigEndianHexToLong("42"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 420X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToLong(String); when '420X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when420x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToLong("420X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 16962}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToLong(String); when '4242'; then return '16962'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when4242_thenReturn16962() {
    // Arrange, Act and Assert
    assertEquals(16962L, TbUtils.parseBigEndianHexToLong("4242"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF0X9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToLong(String); when '0123456789ABCDEF0X9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when0123456789abcdef0x9() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class, () -> TbUtils.parseBigEndianHexToLong("0123456789ABCDEF0X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code 81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToLong(String); when '0123456789ABCDEF'; then return '81985529216486895'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when0123456789abcdef_thenReturn81985529216486895() {
    // Arrange, Act and Assert
    assertEquals(81985529216486895L, TbUtils.parseBigEndianHexToLong("0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code -0123456789ABCDEF}.
   *   <li>Then return {@code -81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToLong(String); when '-0123456789ABCDEF'; then return '-81985529216486895'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_when0123456789abcdef_thenReturn819855292164868952() {
    // Arrange, Act and Assert
    assertEquals(-81985529216486895L, TbUtils.parseBigEndianHexToLong("-0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToLong(String)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToLong(String); when 'not blank'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBigEndianHexToLong(String)"})
  void testParseBigEndianHexToLong_whenNotBlank_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToLong("not blank"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String) with 'hex'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToLong("0X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code -0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String) with 'hex'; when '-0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when0x9_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToLong("-0X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return one hundred fifty-three.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String) with 'hex'; when '0X90X9'; then return one hundred fifty-three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when0x90x9_thenReturnOneHundredFiftyThree() {
    // Arrange, Act and Assert
    assertEquals(153L, TbUtils.parseHexToLong("0X90X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X942}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String) with 'hex'; when '0X942'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when0x942_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToLong("0X942"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0x0123456789ABCDEF}.
   *   <li>Then return {@code 81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String) with 'hex'; when '0x0123456789ABCDEF'; then return '81985529216486895'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when0x0123456789ABCDEF_thenReturn81985529216486895() {
    // Arrange, Act and Assert
    assertEquals(81985529216486895L, TbUtils.parseHexToLong("0x0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String) with 'hex'; when '0X90123456789ABCDEF'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when0x90123456789abcdef_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToLong("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String) with 'hex'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToLong("0x"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return minus sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseHexToLong(String) with 'hex'; when '-42'; then return minus sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when42_thenReturnMinusSixtySix() {
    // Arrange, Act and Assert
    assertEquals(-66L, TbUtils.parseHexToLong("-42"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseHexToLong(String) with 'hex'; when '42'; then return sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when42_thenReturnSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66L, TbUtils.parseHexToLong("42"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 420X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String) with 'hex'; when '420X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when420x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToLong("420X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 16962}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName("Test parseHexToLong(String) with 'hex'; when '4242'; then return '16962'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when4242_thenReturn16962() {
    // Arrange, Act and Assert
    assertEquals(16962L, TbUtils.parseHexToLong("4242"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String) with 'hex'; when '0123456789ABCDEF0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when0123456789abcdef0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToLong("0123456789ABCDEF0X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code 81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String) with 'hex'; when '0123456789ABCDEF'; then return '81985529216486895'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when0123456789abcdef_thenReturn81985529216486895() {
    // Arrange, Act and Assert
    assertEquals(81985529216486895L, TbUtils.parseHexToLong("0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code -0123456789ABCDEF}.
   *   <li>Then return {@code -81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String) with 'hex'; when '-0123456789ABCDEF'; then return '-81985529216486895'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_when0123456789abcdef_thenReturn819855292164868952() {
    // Arrange, Act and Assert
    assertEquals(-81985529216486895L, TbUtils.parseHexToLong("-0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String) with 'hex'; when 'not blank'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseHexToLong(String)"})
  void testParseHexToLongWithHex_whenNotBlank_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToLong("not blank"));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>Then return longValue is {@code 81985529216486895}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String, boolean) with 'value', 'bigEndian'; then return longValue is '81985529216486895'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseHexToLong(String, boolean)"})
  void testParseHexToLongWithValueBigEndian_thenReturnLongValueIs81985529216486895() {
    // Arrange, Act and Assert
    assertEquals(81985529216486895L, TbUtils.parseHexToLong("0123456789ABCDEF", true).longValue());
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code ^-?(0[xX])?[0-9a-fA-F]+$}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String, boolean) with 'value', 'bigEndian'; when '^-?(0[xX])?[0-9a-fA-F]+$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseHexToLong(String, boolean)"})
  void testParseHexToLongWithValueBigEndian_when0XX09aFAF() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.parseHexToLong("^-?(0[xX])?[0-9a-fA-F]+$", false));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String, boolean) with 'value', 'bigEndian'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseHexToLong(String, boolean)"})
  void testParseHexToLongWithValueBigEndian_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToLong("0X9", true));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String, boolean) with 'value', 'bigEndian'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseHexToLong(String, boolean)"})
  void testParseHexToLongWithValueBigEndian_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToLong("0x", false));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return longValue is sixty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String, boolean) with 'value', 'bigEndian'; when '42'; then return longValue is sixty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseHexToLong(String, boolean)"})
  void testParseHexToLongWithValueBigEndian_when42_thenReturnLongValueIsSixtySix() {
    // Arrange, Act and Assert
    assertEquals(66L, TbUtils.parseHexToLong("42", false).longValue());
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String, boolean) with 'value', 'bigEndian'; when '-'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseHexToLong(String, boolean)"})
  void testParseHexToLongWithValueBigEndian_whenDash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseHexToLong("-", false));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String, boolean) with 'value', 'bigEndian'; when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseHexToLong(String, boolean)"})
  void testParseHexToLongWithValueBigEndian_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseHexToLong("", false));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String, boolean)}
   */
  @Test
  @DisplayName("Test parseHexToLong(String, boolean) with 'value', 'bigEndian'; when 'not blank'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseHexToLong(String, boolean)"})
  void testParseHexToLongWithValueBigEndian_whenNotBlank() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseHexToLong("not blank", false));
  }

  /**
   * Test {@link TbUtils#parseHexToLong(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToLong(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToLong(String, boolean) with 'value', 'bigEndian'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Long TbUtils.parseHexToLong(String, boolean)"})
  void testParseHexToLongWithValueBigEndian_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseHexToLong(null, false));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code ^-?(0[xX])?[0-9a-fA-F]+$}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToFloat(String); when '^-?(0[xX])?[0-9a-fA-F]+$'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseLittleEndianHexToFloat(String)"})
  void testParseLittleEndianHexToFloat_when0XX09aFAF_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.parseLittleEndianHexToFloat("^-?(0[xX])?[0-9a-fA-F]+$"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 0x42}.
   *   <li>Then return {@code 9.2E-44}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToFloat(String); when '0x42'; then return '9.2E-44'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseLittleEndianHexToFloat(String)"})
  void testParseLittleEndianHexToFloat_when0x42_thenReturn92e44() {
    // Arrange, Act and Assert
    assertEquals(9.2E-44f, TbUtils.parseLittleEndianHexToFloat("0x42"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return {@code 2.14E-43}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToFloat(String); when '0X90X9'; then return '2.14E-43'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseLittleEndianHexToFloat(String)"})
  void testParseLittleEndianHexToFloat_when0x90x9_thenReturn214e43() {
    // Arrange, Act and Assert
    assertEquals(2.14E-43f, TbUtils.parseLittleEndianHexToFloat("0X90X9"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToFloat(String); when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseLittleEndianHexToFloat(String)"})
  void testParseLittleEndianHexToFloat_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLittleEndianHexToFloat("0x"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 9.2E-44}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToFloat(String); when '42'; then return '9.2E-44'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseLittleEndianHexToFloat(String)"})
  void testParseLittleEndianHexToFloat_when42_thenReturn92e44() {
    // Arrange, Act and Assert
    assertEquals(9.2E-44f, TbUtils.parseLittleEndianHexToFloat("42"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 2.3769E-41}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToFloat(String); when '4242'; then return '2.3769E-41'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseLittleEndianHexToFloat(String)"})
  void testParseLittleEndianHexToFloat_when4242_thenReturn23769e41() {
    // Arrange, Act and Assert
    assertEquals(2.3769E-41f, TbUtils.parseLittleEndianHexToFloat("4242"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToFloat(String); when '-'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseLittleEndianHexToFloat(String)"})
  void testParseLittleEndianHexToFloat_whenDash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseLittleEndianHexToFloat("-"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToFloat(String); when 'not blank'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseLittleEndianHexToFloat(String)"})
  void testParseLittleEndianHexToFloat_whenNotBlank_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseLittleEndianHexToFloat("not blank"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToFloat(String); when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToFloat("0X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code -0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToFloat(String); when '-0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when0x9_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToFloat("-0X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return {@code 2.14E-43}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToFloat(String); when '0X90X9'; then return '2.14E-43'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when0x90x9_thenReturn214e43() {
    // Arrange, Act and Assert
    assertEquals(2.14E-43f, TbUtils.parseBigEndianHexToFloat("0X90X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 0X942}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToFloat(String); when '0X942'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when0x942_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToFloat("0X942"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 0x0123456789ABCDEF}.
   *   <li>Then return {@code -4.136041E-33}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToFloat(String); when '0x0123456789ABCDEF'; then return '-4.136041E-33'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when0x0123456789ABCDEF_thenReturn4136041e33() {
    // Arrange, Act and Assert
    assertEquals(-4.136041E-33f, TbUtils.parseBigEndianHexToFloat("0x0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToFloat(String); when '0X90123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when0x90123456789abcdef() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class, () -> TbUtils.parseBigEndianHexToFloat("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToFloat(String); when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToFloat("0x"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 9.2E-44}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToFloat(String); when '42'; then return '9.2E-44'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when42_thenReturn92e44() {
    // Arrange, Act and Assert
    assertEquals(9.2E-44f, TbUtils.parseBigEndianHexToFloat("42"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToFloat(String); when '-42'; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when42_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Float.NaN, TbUtils.parseBigEndianHexToFloat("-42"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 420X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToFloat(String); when '420X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when420x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToFloat("420X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 2.3769E-41}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToFloat(String); when '4242'; then return '2.3769E-41'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when4242_thenReturn23769e41() {
    // Arrange, Act and Assert
    assertEquals(2.3769E-41f, TbUtils.parseBigEndianHexToFloat("4242"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF0X9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToFloat(String); when '0123456789ABCDEF0X9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when0123456789abcdef0x9() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class, () -> TbUtils.parseBigEndianHexToFloat("0123456789ABCDEF0X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code -4.136041E-33}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToFloat(String); when '0123456789ABCDEF'; then return '-4.136041E-33'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when0123456789abcdef_thenReturn4136041e33() {
    // Arrange, Act and Assert
    assertEquals(-4.136041E-33f, TbUtils.parseBigEndianHexToFloat("0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code -0123456789ABCDEF}.
   *   <li>Then return {@code 1.0759594E33}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToFloat(String); when '-0123456789ABCDEF'; then return '1.0759594E33'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_when0123456789abcdef_thenReturn10759594e33() {
    // Arrange, Act and Assert
    assertEquals(1.0759594E33f, TbUtils.parseBigEndianHexToFloat("-0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToFloat(String)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToFloat(String); when 'not blank'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBigEndianHexToFloat(String)"})
  void testParseBigEndianHexToFloat_whenNotBlank_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToFloat("not blank"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String) with 'hex'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToFloat("0X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code -0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String) with 'hex'; when '-0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when0x9_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToFloat("-0X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return {@code 2.14E-43}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseHexToFloat(String) with 'hex'; when '0X90X9'; then return '2.14E-43'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when0x90x9_thenReturn214e43() {
    // Arrange, Act and Assert
    assertEquals(2.14E-43f, TbUtils.parseHexToFloat("0X90X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X942}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String) with 'hex'; when '0X942'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when0x942_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToFloat("0X942"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0x0123456789ABCDEF}.
   *   <li>Then return {@code -4.136041E-33}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String) with 'hex'; when '0x0123456789ABCDEF'; then return '-4.136041E-33'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when0x0123456789ABCDEF_thenReturn4136041e33() {
    // Arrange, Act and Assert
    assertEquals(-4.136041E-33f, TbUtils.parseHexToFloat("0x0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseHexToFloat(String) with 'hex'; when '0X90123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when0x90123456789abcdef() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToFloat("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String) with 'hex'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToFloat("0x"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 9.2E-44}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseHexToFloat(String) with 'hex'; when '42'; then return '9.2E-44'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when42_thenReturn92e44() {
    // Arrange, Act and Assert
    assertEquals(9.2E-44f, TbUtils.parseHexToFloat("42"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return {@link Float#NaN}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseHexToFloat(String) with 'hex'; when '-42'; then return NaN")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when42_thenReturnNaN() {
    // Arrange, Act and Assert
    assertEquals(Float.NaN, TbUtils.parseHexToFloat("-42"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 420X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String) with 'hex'; when '420X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when420x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToFloat("420X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 2.3769E-41}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseHexToFloat(String) with 'hex'; when '4242'; then return '2.3769E-41'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when4242_thenReturn23769e41() {
    // Arrange, Act and Assert
    assertEquals(2.3769E-41f, TbUtils.parseHexToFloat("4242"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF0X9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName("Test parseHexToFloat(String) with 'hex'; when '0123456789ABCDEF0X9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when0123456789abcdef0x9() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToFloat("0123456789ABCDEF0X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code -4.136041E-33}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String) with 'hex'; when '0123456789ABCDEF'; then return '-4.136041E-33'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when0123456789abcdef_thenReturn4136041e33() {
    // Arrange, Act and Assert
    assertEquals(-4.136041E-33f, TbUtils.parseHexToFloat("0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code -0123456789ABCDEF}.
   *   <li>Then return {@code 1.0759594E33}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String) with 'hex'; when '-0123456789ABCDEF'; then return '1.0759594E33'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_when0123456789abcdef_thenReturn10759594e33() {
    // Arrange, Act and Assert
    assertEquals(1.0759594E33f, TbUtils.parseHexToFloat("-0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String) with 'hex'; when 'not blank'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseHexToFloat(String)"})
  void testParseHexToFloatWithHex_whenNotBlank_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToFloat("not blank"));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>Then return floatValue is {@code -4.136041E-33}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String, boolean) with 'value', 'bigEndian'; then return floatValue is '-4.136041E-33'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexToFloat(String, boolean)"})
  void testParseHexToFloatWithValueBigEndian_thenReturnFloatValueIs4136041e33() {
    // Arrange, Act and Assert
    assertEquals(-4.136041E-33f, TbUtils.parseHexToFloat("0123456789ABCDEF", true).floatValue());
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code ^-?(0[xX])?[0-9a-fA-F]+$}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String, boolean) with 'value', 'bigEndian'; when '^-?(0[xX])?[0-9a-fA-F]+$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexToFloat(String, boolean)"})
  void testParseHexToFloatWithValueBigEndian_when0XX09aFAF() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.parseHexToFloat("^-?(0[xX])?[0-9a-fA-F]+$", false));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String, boolean) with 'value', 'bigEndian'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexToFloat(String, boolean)"})
  void testParseHexToFloatWithValueBigEndian_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToFloat("0X9", true));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String, boolean) with 'value', 'bigEndian'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexToFloat(String, boolean)"})
  void testParseHexToFloatWithValueBigEndian_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToFloat("0x", false));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return floatValue is {@code 9.2E-44}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String, boolean) with 'value', 'bigEndian'; when '42'; then return floatValue is '9.2E-44'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexToFloat(String, boolean)"})
  void testParseHexToFloatWithValueBigEndian_when42_thenReturnFloatValueIs92e44() {
    // Arrange, Act and Assert
    assertEquals(9.2E-44f, TbUtils.parseHexToFloat("42", false).floatValue());
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String, boolean) with 'value', 'bigEndian'; when '-'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexToFloat(String, boolean)"})
  void testParseHexToFloatWithValueBigEndian_whenDash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseHexToFloat("-", false));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String, boolean) with 'value', 'bigEndian'; when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexToFloat(String, boolean)"})
  void testParseHexToFloatWithValueBigEndian_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseHexToFloat("", false));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String, boolean)}
   */
  @Test
  @DisplayName("Test parseHexToFloat(String, boolean) with 'value', 'bigEndian'; when 'not blank'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexToFloat(String, boolean)"})
  void testParseHexToFloatWithValueBigEndian_whenNotBlank() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseHexToFloat("not blank", false));
  }

  /**
   * Test {@link TbUtils#parseHexToFloat(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToFloat(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToFloat(String, boolean) with 'value', 'bigEndian'; when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Float TbUtils.parseHexToFloat(String, boolean)"})
  void testParseHexToFloatWithValueBigEndian_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(TbUtils.parseHexToFloat(null, false));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code ^-?(0[xX])?[0-9a-fA-F]+$}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToDouble(String); when '^-?(0[xX])?[0-9a-fA-F]+$'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseLittleEndianHexToDouble(String)"})
  void testParseLittleEndianHexToDouble_when0XX09aFAF_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.parseLittleEndianHexToDouble("^-?(0[xX])?[0-9a-fA-F]+$"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return {@code 7.56E-322}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToDouble(String); when '0X90X9'; then return '7.56E-322'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseLittleEndianHexToDouble(String)"})
  void testParseLittleEndianHexToDouble_when0x90x9_thenReturn756e322() {
    // Arrange, Act and Assert
    assertEquals(7.56E-322d, TbUtils.parseLittleEndianHexToDouble("0X90X9"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 0x0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToDouble(String); when '0x0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseLittleEndianHexToDouble(String)"})
  void testParseLittleEndianHexToDouble_when0x0123456789ABCDEF() {
    // Arrange, Act and Assert
    assertEquals(
        -3.598696349244748E230d, TbUtils.parseLittleEndianHexToDouble("0x0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToDouble(String); when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseLittleEndianHexToDouble(String)"})
  void testParseLittleEndianHexToDouble_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseLittleEndianHexToDouble("0x"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 3.26E-322}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToDouble(String); when '42'; then return '3.26E-322'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseLittleEndianHexToDouble(String)"})
  void testParseLittleEndianHexToDouble_when42_thenReturn326e322() {
    // Arrange, Act and Assert
    assertEquals(3.26E-322d, TbUtils.parseLittleEndianHexToDouble("42"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 8.3803E-320}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToDouble(String); when '4242'; then return '8.3803E-320'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseLittleEndianHexToDouble(String)"})
  void testParseLittleEndianHexToDouble_when4242_thenReturn83803e320() {
    // Arrange, Act and Assert
    assertEquals(8.3803E-320d, TbUtils.parseLittleEndianHexToDouble("4242"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseLittleEndianHexToDouble(String); when '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseLittleEndianHexToDouble(String)"})
  void testParseLittleEndianHexToDouble_when0123456789abcdef() {
    // Arrange, Act and Assert
    assertEquals(-3.598696349244748E230d, TbUtils.parseLittleEndianHexToDouble("0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code -}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToDouble(String); when '-'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseLittleEndianHexToDouble(String)"})
  void testParseLittleEndianHexToDouble_whenDash_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseLittleEndianHexToDouble("-"));
  }

  /**
   * Test {@link TbUtils#parseLittleEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseLittleEndianHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseLittleEndianHexToDouble(String); when 'not blank'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseLittleEndianHexToDouble(String)"})
  void testParseLittleEndianHexToDouble_whenNotBlank_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseLittleEndianHexToDouble("not blank"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToDouble(String); when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToDouble("0X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code -0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToDouble(String); when '-0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_when0x9_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToDouble("-0X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return {@code 7.56E-322}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToDouble(String); when '0X90X9'; then return '7.56E-322'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_when0x90x9_thenReturn756e322() {
    // Arrange, Act and Assert
    assertEquals(7.56E-322d, TbUtils.parseBigEndianHexToDouble("0X90X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 0X942}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToDouble(String); when '0X942'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_when0x942_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToDouble("0X942"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 0x0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToDouble(String); when '0x0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_when0x0123456789ABCDEF() {
    // Arrange, Act and Assert
    assertEquals(3.512700564088504E-303d, TbUtils.parseBigEndianHexToDouble("0x0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToDouble(String); when '0X90123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_when0x90123456789abcdef() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.parseBigEndianHexToDouble("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToDouble(String); when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToDouble("0x"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 3.26E-322}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToDouble(String); when '42'; then return '3.26E-322'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_when42_thenReturn326e322() {
    // Arrange, Act and Assert
    assertEquals(3.26E-322d, TbUtils.parseBigEndianHexToDouble("42"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 420X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToDouble(String); when '420X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_when420x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToDouble("420X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 8.3803E-320}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToDouble(String); when '4242'; then return '8.3803E-320'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_when4242_thenReturn83803e320() {
    // Arrange, Act and Assert
    assertEquals(8.3803E-320d, TbUtils.parseBigEndianHexToDouble("4242"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToDouble(String); when '0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_when0123456789abcdef() {
    // Arrange, Act and Assert
    assertEquals(3.512700564088504E-303d, TbUtils.parseBigEndianHexToDouble("0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF0X9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseBigEndianHexToDouble(String); when '0123456789ABCDEF0X9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_when0123456789abcdef0x9() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.parseBigEndianHexToDouble("0123456789ABCDEF0X9"));
  }

  /**
   * Test {@link TbUtils#parseBigEndianHexToDouble(String)}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBigEndianHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseBigEndianHexToDouble(String); when 'not blank'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBigEndianHexToDouble(String)"})
  void testParseBigEndianHexToDouble_whenNotBlank_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseBigEndianHexToDouble("not blank"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String) with 'hex'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToDouble("0X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code -0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String) with 'hex'; when '-0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_when0x9_thenThrowNumberFormatException2() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToDouble("-0X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X90X9}.
   *   <li>Then return {@code 7.56E-322}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseHexToDouble(String) with 'hex'; when '0X90X9'; then return '7.56E-322'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_when0x90x9_thenReturn756e322() {
    // Arrange, Act and Assert
    assertEquals(7.56E-322d, TbUtils.parseHexToDouble("0X90X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X942}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String) with 'hex'; when '0X942'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_when0x942_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToDouble("0X942"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0x0123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseHexToDouble(String) with 'hex'; when '0x0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_when0x0123456789ABCDEF() {
    // Arrange, Act and Assert
    assertEquals(3.512700564088504E-303d, TbUtils.parseHexToDouble("0x0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseHexToDouble(String) with 'hex'; when '0X90123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_when0x90123456789abcdef() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class, () -> TbUtils.parseHexToDouble("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String) with 'hex'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToDouble("0x"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 3.26E-322}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseHexToDouble(String) with 'hex'; when '42'; then return '3.26E-322'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_when42_thenReturn326e322() {
    // Arrange, Act and Assert
    assertEquals(3.26E-322d, TbUtils.parseHexToDouble("42"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 420X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String) with 'hex'; when '420X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_when420x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToDouble("420X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@code 8.3803E-320}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseHexToDouble(String) with 'hex'; when '4242'; then return '8.3803E-320'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_when4242_thenReturn83803e320() {
    // Arrange, Act and Assert
    assertEquals(8.3803E-320d, TbUtils.parseHexToDouble("4242"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF0X9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName("Test parseHexToDouble(String) with 'hex'; when '0123456789ABCDEF0X9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_when0123456789abcdef0x9() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class, () -> TbUtils.parseHexToDouble("0123456789ABCDEF0X9"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code 3.512700564088504E-303}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String) with 'hex'; when '0123456789ABCDEF'; then return '3.512700564088504E-303'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_when0123456789abcdef_thenReturn3512700564088504e303() {
    // Arrange, Act and Assert
    assertEquals(3.512700564088504E-303d, TbUtils.parseHexToDouble("0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String)} with {@code hex}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String) with 'hex'; when 'not blank'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String)"})
  void testParseHexToDoubleWithHex_whenNotBlank_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToDouble("not blank"));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>Then return {@code 3.512700564088504E-303}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String, boolean) with 'value', 'bigEndian'; then return '3.512700564088504E-303'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String, boolean)"})
  void testParseHexToDoubleWithValueBigEndian_thenReturn3512700564088504e303() {
    // Arrange, Act and Assert
    assertEquals(3.512700564088504E-303d, TbUtils.parseHexToDouble("0123456789ABCDEF", true));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>Then return {@code -3.598696349244748E230}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String, boolean) with 'value', 'bigEndian'; then return '-3.598696349244748E230'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String, boolean)"})
  void testParseHexToDoubleWithValueBigEndian_thenReturn3598696349244748e230() {
    // Arrange, Act and Assert
    assertEquals(-3.598696349244748E230d, TbUtils.parseHexToDouble("0123456789ABCDEF", false));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code ^-?(0[xX])?[0-9a-fA-F]+$}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String, boolean) with 'value', 'bigEndian'; when '^-?(0[xX])?[0-9a-fA-F]+$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String, boolean)"})
  void testParseHexToDoubleWithValueBigEndian_when0XX09aFAF() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.parseHexToDouble("^-?(0[xX])?[0-9a-fA-F]+$", false));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String, boolean) with 'value', 'bigEndian'; when '0X9'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String, boolean)"})
  void testParseHexToDoubleWithValueBigEndian_when0x9_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToDouble("0X9", true));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String, boolean) with 'value', 'bigEndian'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String, boolean)"})
  void testParseHexToDoubleWithValueBigEndian_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.parseHexToDouble("0x", false));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code 3.26E-322}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseHexToDouble(String, boolean) with 'value', 'bigEndian'; when '42'; then return '3.26E-322'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String, boolean)"})
  void testParseHexToDoubleWithValueBigEndian_when42_thenReturn326e322() {
    // Arrange, Act and Assert
    assertEquals(3.26E-322d, TbUtils.parseHexToDouble("42", false));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code -}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String, boolean)}
   */
  @Test
  @DisplayName("Test parseHexToDouble(String, boolean) with 'value', 'bigEndian'; when '-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String, boolean)"})
  void testParseHexToDoubleWithValueBigEndian_whenDash() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseHexToDouble("-", false));
  }

  /**
   * Test {@link TbUtils#parseHexToDouble(String, boolean)} with {@code value}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseHexToDouble(String, boolean)}
   */
  @Test
  @DisplayName("Test parseHexToDouble(String, boolean) with 'value', 'bigEndian'; when 'not blank'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseHexToDouble(String, boolean)"})
  void testParseHexToDoubleWithValueBigEndian_whenNotBlank() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseHexToDouble("not blank", false));
  }

  /**
   * Test {@link TbUtils#hexToBytes(ExecutionContext, String)} with {@code ctx}, {@code value}.
   *
   * <ul>
   *   <li>When {@code 0x}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#hexToBytes(ExecutionContext, String)}
   */
  @Test
  @DisplayName(
      "Test hexToBytes(ExecutionContext, String) with 'ctx', 'value'; when '0x'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionArrayList TbUtils.hexToBytes(ExecutionContext, String)"})
  void testHexToBytesWithCtxValue_when0x_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.hexToBytes(new ExecutionContext(ParserContext.enableSandboxedMode()), "0x"));
  }

  /**
   * Test {@link TbUtils#hexToBytes(ExecutionContext, String)} with {@code ctx}, {@code value}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#hexToBytes(ExecutionContext, String)}
   */
  @Test
  @DisplayName(
      "Test hexToBytes(ExecutionContext, String) with 'ctx', 'value'; when empty string; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionArrayList TbUtils.hexToBytes(ExecutionContext, String)"})
  void testHexToBytesWithCtxValue_whenEmptyString_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.hexToBytes(new ExecutionContext(ParserContext.enableSandboxedMode()), ""));
  }

  /**
   * Test {@link TbUtils#hexToBytes(ExecutionContext, String)} with {@code ctx}, {@code value}.
   *
   * <ul>
   *   <li>When {@code not blank}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#hexToBytes(ExecutionContext, String)}
   */
  @Test
  @DisplayName(
      "Test hexToBytes(ExecutionContext, String) with 'ctx', 'value'; when 'not blank'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionArrayList TbUtils.hexToBytes(ExecutionContext, String)"})
  void testHexToBytesWithCtxValue_whenNotBlank_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            TbUtils.hexToBytes(
                new ExecutionContext(ParserContext.enableSandboxedMode()), "not blank"));
  }

  /**
   * Test {@link TbUtils#hexToBytes(ExecutionContext, String)} with {@code ctx}, {@code value}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#hexToBytes(ExecutionContext, String)}
   */
  @Test
  @DisplayName(
      "Test hexToBytes(ExecutionContext, String) with 'ctx', 'value'; when 'null'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionArrayList TbUtils.hexToBytes(ExecutionContext, String)"})
  void testHexToBytesWithCtxValue_whenNull_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.hexToBytes(new ExecutionContext(ParserContext.enableSandboxedMode()), null));
  }

  /**
   * Test {@link TbUtils#printUnsignedBytes(ExecutionContext, List)}.
   *
   * <p>Method under test: {@link TbUtils#printUnsignedBytes(ExecutionContext, List)}
   */
  @Test
  @DisplayName("Test printUnsignedBytes(ExecutionContext, List)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbUtils.printUnsignedBytes(ExecutionContext, List)"})
  void testPrintUnsignedBytes() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    // Act
    List<Integer> actualPrintUnsignedBytesResult =
        TbUtils.printUnsignedBytes(ctx, new ArrayList<>());

    // Assert
    assertEquals(0L, ctx.getMemorySize());
    assertTrue(actualPrintUnsignedBytesResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#printUnsignedBytes(ExecutionContext, List)}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then return first intValue is sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#printUnsignedBytes(ExecutionContext, List)}
   */
  @Test
  @DisplayName(
      "Test printUnsignedBytes(ExecutionContext, List); given 'A'; then return first intValue is sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbUtils.printUnsignedBytes(ExecutionContext, List)"})
  void testPrintUnsignedBytes_givenA_thenReturnFirstIntValueIsSixtyFive() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    ArrayList<Byte> byteArray = new ArrayList<>();
    byteArray.add((byte) 'A');

    // Act
    List<Integer> actualPrintUnsignedBytesResult = TbUtils.printUnsignedBytes(ctx, byteArray);

    // Assert
    assertEquals(1, actualPrintUnsignedBytesResult.size());
    assertEquals(65, actualPrintUnsignedBytesResult.get(0).intValue());
    assertEquals(8L, ctx.getMemorySize());
  }

  /**
   * Test {@link TbUtils#printUnsignedBytes(ExecutionContext, List)}.
   *
   * <ul>
   *   <li>Then return first intValue is eighty-eight.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#printUnsignedBytes(ExecutionContext, List)}
   */
  @Test
  @DisplayName(
      "Test printUnsignedBytes(ExecutionContext, List); then return first intValue is eighty-eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"List TbUtils.printUnsignedBytes(ExecutionContext, List)"})
  void testPrintUnsignedBytes_thenReturnFirstIntValueIsEightyEight() {
    // Arrange
    ExecutionContext ctx =
        new ExecutionContext(ParserContext.enableSandboxedMode(), Long.MAX_VALUE);

    ArrayList<Byte> byteArray = new ArrayList<>();
    byteArray.add((byte) 'X');

    // Act
    List<Integer> actualPrintUnsignedBytesResult = TbUtils.printUnsignedBytes(ctx, byteArray);

    // Assert
    assertEquals(1, actualPrintUnsignedBytesResult.size());
    assertEquals(88, actualPrintUnsignedBytesResult.get(0).intValue());
    assertEquals(8L, ctx.getMemorySize());
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean, int)} with {@code i}, {@code
   * bigEndian}, {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return {@code 0x000}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean, int) with 'i', 'bigEndian', 'pref', 'len'; when MIN_VALUE; then return '0x000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean, int)"})
  void testIntToHexWithIBigEndianPrefLen_whenMin_value_thenReturn0x000() {
    // Arrange and Act
    String actualIntToHexResult = TbUtils.intToHex(Integer.MIN_VALUE, true, true, 3);

    // Assert
    assertEquals("0x000", actualIntToHexResult);
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean, int)} with {@code i}, {@code
   * bigEndian}, {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   *   <li>Then return {@code 0xF80}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean, int) with 'i', 'bigEndian', 'pref', 'len'; when minus one hundred twenty-eight; then return '0xF80'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean, int)"})
  void testIntToHexWithIBigEndianPrefLen_whenMinusOneHundredTwentyEight_thenReturn0xF80() {
    // Arrange and Act
    String actualIntToHexResult = TbUtils.intToHex(-128, true, true, 3);

    // Assert
    assertEquals("0xF80", actualIntToHexResult);
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean, int)} with {@code i}, {@code
   * bigEndian}, {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code 0xFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean, int) with 'i', 'bigEndian', 'pref', 'len'; when minus one; then return '0xFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean, int)"})
  void testIntToHexWithIBigEndianPrefLen_whenMinusOne_thenReturn0xFFF() {
    // Arrange and Act
    String actualIntToHexResult = TbUtils.intToHex(-1, true, true, 3);

    // Assert
    assertEquals("0xFFF", actualIntToHexResult);
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean, int)} with {@code i}, {@code
   * bigEndian}, {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code 0xFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean, int) with 'i', 'bigEndian', 'pref', 'len'; when minus one; then return '0xFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean, int)"})
  void testIntToHexWithIBigEndianPrefLen_whenMinusOne_thenReturn0xFFF2() {
    // Arrange and Act
    String actualIntToHexResult = TbUtils.intToHex(-1, false, true, 3);

    // Assert
    assertEquals("0xFFF", actualIntToHexResult);
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean, int)} with {@code i}, {@code
   * bigEndian}, {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code FFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean, int) with 'i', 'bigEndian', 'pref', 'len'; when minus one; then return 'FFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean, int)"})
  void testIntToHexWithIBigEndianPrefLen_whenMinusOne_thenReturnFff() {
    // Arrange and Act
    String actualIntToHexResult = TbUtils.intToHex(-1, true, false, 3);

    // Assert
    assertEquals("FFF", actualIntToHexResult);
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean, int)} with {@code i}, {@code
   * bigEndian}, {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When minus two.
   *   <li>Then return {@code 0xEFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean, int) with 'i', 'bigEndian', 'pref', 'len'; when minus two; then return '0xEFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean, int)"})
  void testIntToHexWithIBigEndianPrefLen_whenMinusTwo_thenReturn0xEFF() {
    // Arrange and Act
    String actualIntToHexResult = TbUtils.intToHex(-2, false, true, 3);

    // Assert
    assertEquals("0xEFF", actualIntToHexResult);
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean, int)} with {@code i}, {@code
   * bigEndian}, {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 0x01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean, int) with 'i', 'bigEndian', 'pref', 'len'; when one; then return '0x01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean, int)"})
  void testIntToHexWithIBigEndianPrefLen_whenOne_thenReturn0x01() {
    // Arrange and Act
    String actualIntToHexResult = TbUtils.intToHex(1, true, true, -1);

    // Assert
    assertEquals("0x01", actualIntToHexResult);
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean, int)} with {@code i}, {@code
   * bigEndian}, {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 0x01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean, int) with 'i', 'bigEndian', 'pref', 'len'; when two; then return '0x01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean, int)"})
  void testIntToHexWithIBigEndianPrefLen_whenTwo_thenReturn0x01() {
    // Arrange and Act
    String actualIntToHexResult = TbUtils.intToHex(1, true, true, 2);

    // Assert
    assertEquals("0x01", actualIntToHexResult);
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean)} with {@code i}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return {@code 0x80000000}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean) with 'i', 'bigEndian', 'pref'; when MIN_VALUE; then return '0x80000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean)"})
  void testIntToHexWithIBigEndianPref_whenMin_value_thenReturn0x80000000() {
    // Arrange, Act and Assert
    assertEquals("0x80000000", TbUtils.intToHex(Integer.MIN_VALUE, true, true));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean)} with {@code i}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   *   <li>Then return {@code 0xFF80}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean) with 'i', 'bigEndian', 'pref'; when minus one hundred twenty-eight; then return '0xFF80'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean)"})
  void testIntToHexWithIBigEndianPref_whenMinusOneHundredTwentyEight_thenReturn0xFF80() {
    // Arrange, Act and Assert
    assertEquals("0xFF80", TbUtils.intToHex(-128, true, true));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean)} with {@code i}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code 0xFFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean) with 'i', 'bigEndian', 'pref'; when minus one; then return '0xFFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean)"})
  void testIntToHexWithIBigEndianPref_whenMinusOne_thenReturn0xFFFF() {
    // Arrange, Act and Assert
    assertEquals("0xFFFF", TbUtils.intToHex(-1, true, true));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean)} with {@code i}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When minus two.
   *   <li>Then return {@code 0xFEFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean) with 'i', 'bigEndian', 'pref'; when minus two; then return '0xFEFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean)"})
  void testIntToHexWithIBigEndianPref_whenMinusTwo_thenReturn0xFEFF() {
    // Arrange, Act and Assert
    assertEquals("0xFEFF", TbUtils.intToHex(-2, false, true));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean)} with {@code i}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 0x01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean) with 'i', 'bigEndian', 'pref'; when one; then return '0x01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean)"})
  void testIntToHexWithIBigEndianPref_whenOne_thenReturn0x01() {
    // Arrange, Act and Assert
    assertEquals("0x01", TbUtils.intToHex(1, true, true));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean)} with {@code i}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 0x01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean) with 'i', 'bigEndian', 'pref'; when one; then return '0x01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean)"})
  void testIntToHexWithIBigEndianPref_whenOne_thenReturn0x012() {
    // Arrange, Act and Assert
    assertEquals("0x01", TbUtils.intToHex(1, false, true));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean, boolean)} with {@code i}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean, boolean) with 'i', 'bigEndian', 'pref'; when one; then return '01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean, boolean)"})
  void testIntToHexWithIBigEndianPref_whenOne_thenReturn01() {
    // Arrange, Act and Assert
    assertEquals("01", TbUtils.intToHex(1, true, false));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean)} with {@code i}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return {@code 80000000}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean) with 'i', 'bigEndian'; when MIN_VALUE; then return '80000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean)"})
  void testIntToHexWithIBigEndian_whenMin_value_thenReturn80000000() {
    // Arrange, Act and Assert
    assertEquals("80000000", TbUtils.intToHex(Integer.MIN_VALUE, true));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean)} with {@code i}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   *   <li>Then return {@code FF80}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean) with 'i', 'bigEndian'; when minus one hundred twenty-eight; then return 'FF80'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean)"})
  void testIntToHexWithIBigEndian_whenMinusOneHundredTwentyEight_thenReturnFf80() {
    // Arrange, Act and Assert
    assertEquals("FF80", TbUtils.intToHex(-128, true));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean)} with {@code i}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code FFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean) with 'i', 'bigEndian'; when minus one; then return 'FFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean)"})
  void testIntToHexWithIBigEndian_whenMinusOne_thenReturnFfff() {
    // Arrange, Act and Assert
    assertEquals("FFFF", TbUtils.intToHex(-1, true));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean)} with {@code i}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When minus two.
   *   <li>Then return {@code FEFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer, boolean) with 'i', 'bigEndian'; when minus two; then return 'FEFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean)"})
  void testIntToHexWithIBigEndian_whenMinusTwo_thenReturnFeff() {
    // Arrange, Act and Assert
    assertEquals("FEFF", TbUtils.intToHex(-2, false));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean)} with {@code i}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean)}
   */
  @Test
  @DisplayName("Test intToHex(Integer, boolean) with 'i', 'bigEndian'; when one; then return '01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean)"})
  void testIntToHexWithIBigEndian_whenOne_thenReturn01() {
    // Arrange, Act and Assert
    assertEquals("01", TbUtils.intToHex(1, true));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer, boolean)} with {@code i}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer, boolean)}
   */
  @Test
  @DisplayName("Test intToHex(Integer, boolean) with 'i', 'bigEndian'; when one; then return '01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer, boolean)"})
  void testIntToHexWithIBigEndian_whenOne_thenReturn012() {
    // Arrange, Act and Assert
    assertEquals("01", TbUtils.intToHex(1, false));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer)} with {@code i}.
   *
   * <ul>
   *   <li>When {@link Integer#MIN_VALUE}.
   *   <li>Then return {@code 80000000}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer)}
   */
  @Test
  @DisplayName("Test intToHex(Integer) with 'i'; when MIN_VALUE; then return '80000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer)"})
  void testIntToHexWithI_whenMin_value_thenReturn80000000() {
    // Arrange, Act and Assert
    assertEquals("80000000", TbUtils.intToHex(Integer.MIN_VALUE));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer)} with {@code i}.
   *
   * <ul>
   *   <li>When minus one hundred twenty-eight.
   *   <li>Then return {@code FF80}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer)}
   */
  @Test
  @DisplayName(
      "Test intToHex(Integer) with 'i'; when minus one hundred twenty-eight; then return 'FF80'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer)"})
  void testIntToHexWithI_whenMinusOneHundredTwentyEight_thenReturnFf80() {
    // Arrange, Act and Assert
    assertEquals("FF80", TbUtils.intToHex(-128));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer)} with {@code i}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code FFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer)}
   */
  @Test
  @DisplayName("Test intToHex(Integer) with 'i'; when minus one; then return 'FFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer)"})
  void testIntToHexWithI_whenMinusOne_thenReturnFfff() {
    // Arrange, Act and Assert
    assertEquals("FFFF", TbUtils.intToHex(-1));
  }

  /**
   * Test {@link TbUtils#intToHex(Integer)} with {@code i}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intToHex(Integer)}
   */
  @Test
  @DisplayName("Test intToHex(Integer) with 'i'; when one; then return '01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intToHex(Integer)"})
  void testIntToHexWithI_whenOne_thenReturn01() {
    // Arrange, Act and Assert
    assertEquals("01", TbUtils.intToHex(1));
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean, int)} with {@code l}, {@code bigEndian},
   * {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When {@link Long#MAX_VALUE}.
   *   <li>Then return {@code 0xFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean, int) with 'l', 'bigEndian', 'pref', 'len'; when MAX_VALUE; then return '0xFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean, int)"})
  void testLongToHexWithLBigEndianPrefLen_whenMax_value_thenReturn0xFFF() {
    // Arrange and Act
    String actualLongToHexResult = TbUtils.longToHex(Long.MAX_VALUE, true, true, 3);

    // Assert
    assertEquals("0xFFF", actualLongToHexResult);
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean, int)} with {@code l}, {@code bigEndian},
   * {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then return {@code 0x000}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean, int) with 'l', 'bigEndian', 'pref', 'len'; when MIN_VALUE; then return '0x000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean, int)"})
  void testLongToHexWithLBigEndianPrefLen_whenMin_value_thenReturn0x000() {
    // Arrange and Act
    String actualLongToHexResult = TbUtils.longToHex(Long.MIN_VALUE, true, true, 3);

    // Assert
    assertEquals("0x000", actualLongToHexResult);
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean, int)} with {@code l}, {@code bigEndian},
   * {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code 0xFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean, int) with 'l', 'bigEndian', 'pref', 'len'; when minus one; then return '0xFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean, int)"})
  void testLongToHexWithLBigEndianPrefLen_whenMinusOne_thenReturn0xFFF() {
    // Arrange and Act
    String actualLongToHexResult = TbUtils.longToHex(-1L, true, true, 3);

    // Assert
    assertEquals("0xFFF", actualLongToHexResult);
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean, int)} with {@code l}, {@code bigEndian},
   * {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code 0xFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean, int) with 'l', 'bigEndian', 'pref', 'len'; when minus one; then return '0xFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean, int)"})
  void testLongToHexWithLBigEndianPrefLen_whenMinusOne_thenReturn0xFFF2() {
    // Arrange and Act
    String actualLongToHexResult = TbUtils.longToHex(-1L, false, true, 3);

    // Assert
    assertEquals("0xFFF", actualLongToHexResult);
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean, int)} with {@code l}, {@code bigEndian},
   * {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code FFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean, int) with 'l', 'bigEndian', 'pref', 'len'; when minus one; then return 'FFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean, int)"})
  void testLongToHexWithLBigEndianPrefLen_whenMinusOne_thenReturnFff() {
    // Arrange and Act
    String actualLongToHexResult = TbUtils.longToHex(-1L, true, false, 3);

    // Assert
    assertEquals("FFF", actualLongToHexResult);
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean, int)} with {@code l}, {@code bigEndian},
   * {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When minus two.
   *   <li>Then return {@code 0xEFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean, int) with 'l', 'bigEndian', 'pref', 'len'; when minus two; then return '0xEFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean, int)"})
  void testLongToHexWithLBigEndianPrefLen_whenMinusTwo_thenReturn0xEFF() {
    // Arrange and Act
    String actualLongToHexResult = TbUtils.longToHex(-2L, false, true, 3);

    // Assert
    assertEquals("0xEFF", actualLongToHexResult);
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean, int)} with {@code l}, {@code bigEndian},
   * {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 0x01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean, int) with 'l', 'bigEndian', 'pref', 'len'; when one; then return '0x01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean, int)"})
  void testLongToHexWithLBigEndianPrefLen_whenOne_thenReturn0x01() {
    // Arrange and Act
    String actualLongToHexResult = TbUtils.longToHex(1L, true, true, -1);

    // Assert
    assertEquals("0x01", actualLongToHexResult);
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean, int)} with {@code l}, {@code bigEndian},
   * {@code pref}, {@code len}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 0x01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean, int)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean, int) with 'l', 'bigEndian', 'pref', 'len'; when two; then return '0x01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean, int)"})
  void testLongToHexWithLBigEndianPrefLen_whenTwo_thenReturn0x01() {
    // Arrange and Act
    String actualLongToHexResult = TbUtils.longToHex(1L, true, true, 2);

    // Assert
    assertEquals("0x01", actualLongToHexResult);
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean)} with {@code l}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then return {@code 0x8000000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean) with 'l', 'bigEndian', 'pref'; when MIN_VALUE; then return '0x8000000000000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean)"})
  void testLongToHexWithLBigEndianPref_whenMin_value_thenReturn0x8000000000000000() {
    // Arrange, Act and Assert
    assertEquals("0x8000000000000000", TbUtils.longToHex(Long.MIN_VALUE, true, true));
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean)} with {@code l}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code 0xFFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean) with 'l', 'bigEndian', 'pref'; when minus one; then return '0xFFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean)"})
  void testLongToHexWithLBigEndianPref_whenMinusOne_thenReturn0xFFFF() {
    // Arrange, Act and Assert
    assertEquals("0xFFFF", TbUtils.longToHex(-1L, true, true));
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean)} with {@code l}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When minus two.
   *   <li>Then return {@code 0xFEFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean) with 'l', 'bigEndian', 'pref'; when minus two; then return '0xFEFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean)"})
  void testLongToHexWithLBigEndianPref_whenMinusTwo_thenReturn0xFEFF() {
    // Arrange, Act and Assert
    assertEquals("0xFEFF", TbUtils.longToHex(-2L, false, true));
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean)} with {@code l}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 0x01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean) with 'l', 'bigEndian', 'pref'; when one; then return '0x01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean)"})
  void testLongToHexWithLBigEndianPref_whenOne_thenReturn0x01() {
    // Arrange, Act and Assert
    assertEquals("0x01", TbUtils.longToHex(1L, true, true));
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean)} with {@code l}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 0x01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean) with 'l', 'bigEndian', 'pref'; when one; then return '0x01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean)"})
  void testLongToHexWithLBigEndianPref_whenOne_thenReturn0x012() {
    // Arrange, Act and Assert
    assertEquals("0x01", TbUtils.longToHex(1L, false, true));
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean, boolean)} with {@code l}, {@code bigEndian},
   * {@code pref}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean, boolean) with 'l', 'bigEndian', 'pref'; when one; then return '01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean, boolean)"})
  void testLongToHexWithLBigEndianPref_whenOne_thenReturn01() {
    // Arrange, Act and Assert
    assertEquals("01", TbUtils.longToHex(1L, true, false));
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean)} with {@code l}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then return {@code 8000000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean) with 'l', 'bigEndian'; when MIN_VALUE; then return '8000000000000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean)"})
  void testLongToHexWithLBigEndian_whenMin_value_thenReturn8000000000000000() {
    // Arrange, Act and Assert
    assertEquals("8000000000000000", TbUtils.longToHex(Long.MIN_VALUE, true));
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean)} with {@code l}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code FFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean) with 'l', 'bigEndian'; when minus one; then return 'FFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean)"})
  void testLongToHexWithLBigEndian_whenMinusOne_thenReturnFfff() {
    // Arrange, Act and Assert
    assertEquals("FFFF", TbUtils.longToHex(-1L, true));
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean)} with {@code l}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When minus two.
   *   <li>Then return {@code FEFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean)}
   */
  @Test
  @DisplayName(
      "Test longToHex(Long, boolean) with 'l', 'bigEndian'; when minus two; then return 'FEFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean)"})
  void testLongToHexWithLBigEndian_whenMinusTwo_thenReturnFeff() {
    // Arrange, Act and Assert
    assertEquals("FEFF", TbUtils.longToHex(-2L, false));
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean)} with {@code l}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean)}
   */
  @Test
  @DisplayName("Test longToHex(Long, boolean) with 'l', 'bigEndian'; when one; then return '01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean)"})
  void testLongToHexWithLBigEndian_whenOne_thenReturn01() {
    // Arrange, Act and Assert
    assertEquals("01", TbUtils.longToHex(1L, true));
  }

  /**
   * Test {@link TbUtils#longToHex(Long, boolean)} with {@code l}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long, boolean)}
   */
  @Test
  @DisplayName("Test longToHex(Long, boolean) with 'l', 'bigEndian'; when one; then return '01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long, boolean)"})
  void testLongToHexWithLBigEndian_whenOne_thenReturn012() {
    // Arrange, Act and Assert
    assertEquals("01", TbUtils.longToHex(1L, false));
  }

  /**
   * Test {@link TbUtils#longToHex(Long)} with {@code l}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then return {@code 8000000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long)}
   */
  @Test
  @DisplayName("Test longToHex(Long) with 'l'; when MIN_VALUE; then return '8000000000000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long)"})
  void testLongToHexWithL_whenMin_value_thenReturn8000000000000000() {
    // Arrange, Act and Assert
    assertEquals("8000000000000000", TbUtils.longToHex(Long.MIN_VALUE));
  }

  /**
   * Test {@link TbUtils#longToHex(Long)} with {@code l}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code FFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long)}
   */
  @Test
  @DisplayName("Test longToHex(Long) with 'l'; when minus one; then return 'FFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long)"})
  void testLongToHexWithL_whenMinusOne_thenReturnFfff() {
    // Arrange, Act and Assert
    assertEquals("FFFF", TbUtils.longToHex(-1L));
  }

  /**
   * Test {@link TbUtils#longToHex(Long)} with {@code l}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return {@code 01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#longToHex(Long)}
   */
  @Test
  @DisplayName("Test longToHex(Long) with 'l'; when one; then return '01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.longToHex(Long)"})
  void testLongToHexWithL_whenOne_thenReturn01() {
    // Arrange, Act and Assert
    assertEquals("01", TbUtils.longToHex(1L));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long)} with {@code number}.
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long)}
   */
  @Test
  @DisplayName("Test intLongToRadixString(Long) with 'number'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long)"})
  void testIntLongToRadixStringWithNumber() {
    // Arrange, Act and Assert
    assertEquals("1", TbUtils.intLongToRadixString(1L));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int)} with {@code number}, {@code radix}.
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int)}
   */
  @Test
  @DisplayName("Test intLongToRadixString(Long, int) with 'number', 'radix'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int)"})
  void testIntLongToRadixStringWithNumberRadix() {
    // Arrange, Act and Assert
    assertEquals(
        "0111111111111111111111111111111111111111111111111111111111111111",
        TbUtils.intLongToRadixString(Long.MAX_VALUE, 2));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName("Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.intLongToRadixString(1L, 1, true));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName("Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian2() {
    // Arrange, Act and Assert
    assertEquals(
        "1111111111111111111111111111111111111111111111111111111111111111",
        TbUtils.intLongToRadixString(-1L, 2, true));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName("Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian3() {
    // Arrange, Act and Assert
    assertEquals(
        "0111111111111111111111111111111111111111111111111111111111111111",
        TbUtils.intLongToRadixString(Long.MAX_VALUE, 2, true));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.intLongToRadixString(1L, 1, true, true));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref2() {
    // Arrange and Act
    String actualIntLongToRadixStringResult =
        TbUtils.intLongToRadixString(Long.MIN_VALUE, Short.SIZE, true, true);

    // Assert
    assertEquals("0x8000000000000000", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref3() {
    // Arrange and Act
    String actualIntLongToRadixStringResult = TbUtils.intLongToRadixString(-1L, 2, true, true);

    // Assert
    assertEquals(
        "1111111111111111111111111111111111111111111111111111111111111111",
        actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref4() {
    // Arrange and Act
    String actualIntLongToRadixStringResult =
        TbUtils.intLongToRadixString(Long.MAX_VALUE, 2, true, true);

    // Assert
    assertEquals(
        "0111111111111111111111111111111111111111111111111111111111111111",
        actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <ul>
   *   <li>Then return {@code 0x19}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'; then return '0x19'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref_thenReturn0x19() {
    // Arrange and Act
    String actualIntLongToRadixStringResult =
        TbUtils.intLongToRadixString(25L, Short.SIZE, true, true);

    // Assert
    assertEquals("0x19", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <ul>
   *   <li>Then return {@code 0xFFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'; then return '0xFFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref_thenReturn0xFFFF() {
    // Arrange and Act
    String actualIntLongToRadixStringResult =
        TbUtils.intLongToRadixString(-1L, Short.SIZE, true, true);

    // Assert
    assertEquals("0xFFFF", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'; when eight; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref_whenEight_thenReturn1() {
    // Arrange and Act
    String actualIntLongToRadixStringResult = TbUtils.intLongToRadixString(1L, 8, false, false);

    // Assert
    assertEquals("1", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <ul>
   *   <li>When minus two.
   *   <li>Then return {@code FEFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'; when minus two; then return 'FEFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref_whenMinusTwo_thenReturnFeff() {
    // Arrange and Act
    String actualIntLongToRadixStringResult =
        TbUtils.intLongToRadixString(-2L, Short.SIZE, false, false);

    // Assert
    assertEquals("FEFF", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return {@code 0x01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'; when SIZE; then return '0x01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref_whenSize_thenReturn0x01() {
    // Arrange and Act
    String actualIntLongToRadixStringResult =
        TbUtils.intLongToRadixString(1L, Short.SIZE, true, true);

    // Assert
    assertEquals("0x01", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return {@code 01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'; when SIZE; then return '01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref_whenSize_thenReturn01() {
    // Arrange and Act
    String actualIntLongToRadixStringResult =
        TbUtils.intLongToRadixString(1L, Short.SIZE, false, false);

    // Assert
    assertEquals("01", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'; when ten; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref_whenTen_thenReturn1() {
    // Arrange and Act
    String actualIntLongToRadixStringResult = TbUtils.intLongToRadixString(1L, 10, false, false);

    // Assert
    assertEquals("1", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <ul>
   *   <li>When thirty-seven.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'; when thirty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref_whenThirtySeven() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.intLongToRadixString(1L, 37, false, false));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <ul>
   *   <li>When twenty-five.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'; when twenty-five; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref_whenTwentyFive_thenReturn1() {
    // Arrange and Act
    String actualIntLongToRadixStringResult = TbUtils.intLongToRadixString(1L, 25, false, false);

    // Assert
    assertEquals("1", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)} with {@code number},
   * {@code radix}, {@code bigEndian}, {@code pref}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 00000001}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean, boolean) with 'number', 'radix', 'bigEndian', 'pref'; when two; then return '00000001'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndianPref_whenTwo_thenReturn00000001() {
    // Arrange and Act
    String actualIntLongToRadixStringResult = TbUtils.intLongToRadixString(1L, 2, false, false);

    // Assert
    assertEquals("00000001", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <ul>
   *   <li>Then return {@code 8000000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'; then return '8000000000000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian_thenReturn8000000000000000() {
    // Arrange and Act
    String actualIntLongToRadixStringResult =
        TbUtils.intLongToRadixString(Long.MIN_VALUE, Short.SIZE, true);

    // Assert
    assertEquals("8000000000000000", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'; when eight; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian_whenEight_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("1", TbUtils.intLongToRadixString(1L, 8, false));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code FFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'; when minus one; then return 'FFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian_whenMinusOne_thenReturnFfff() {
    // Arrange and Act
    String actualIntLongToRadixStringResult = TbUtils.intLongToRadixString(-1L, Short.SIZE, true);

    // Assert
    assertEquals("FFFF", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When minus two.
   *   <li>Then return {@code FEFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'; when minus two; then return 'FEFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian_whenMinusTwo_thenReturnFeff() {
    // Arrange and Act
    String actualIntLongToRadixStringResult = TbUtils.intLongToRadixString(-2L, Short.SIZE, false);

    // Assert
    assertEquals("FEFF", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return {@code 01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'; when SIZE; then return '01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian_whenSize_thenReturn01() {
    // Arrange and Act
    String actualIntLongToRadixStringResult = TbUtils.intLongToRadixString(1L, Short.SIZE, false);

    // Assert
    assertEquals("01", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return {@code 01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'; when SIZE; then return '01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian_whenSize_thenReturn012() {
    // Arrange and Act
    String actualIntLongToRadixStringResult = TbUtils.intLongToRadixString(1L, Short.SIZE, true);

    // Assert
    assertEquals("01", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'; when ten; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian_whenTen_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("1", TbUtils.intLongToRadixString(1L, 10, false));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When thirty-seven.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'; when thirty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian_whenThirtySeven() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.intLongToRadixString(1L, 37, false));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When twenty-five.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'; when twenty-five; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian_whenTwentyFive_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("1", TbUtils.intLongToRadixString(1L, 25, false));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When twenty-five.
   *   <li>Then return {@code 19}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'; when twenty-five; then return '19'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian_whenTwentyFive_thenReturn19() {
    // Arrange and Act
    String actualIntLongToRadixStringResult = TbUtils.intLongToRadixString(25L, Short.SIZE, true);

    // Assert
    assertEquals("19", actualIntLongToRadixStringResult);
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int, boolean)} with {@code number}, {@code
   * radix}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 00000001}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int, boolean) with 'number', 'radix', 'bigEndian'; when two; then return '00000001'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int, boolean)"})
  void testIntLongToRadixStringWithNumberRadixBigEndian_whenTwo_thenReturn00000001() {
    // Arrange, Act and Assert
    assertEquals("00000001", TbUtils.intLongToRadixString(1L, 2, false));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int)} with {@code number}, {@code radix}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int) with 'number', 'radix'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int)"})
  void testIntLongToRadixStringWithNumberRadix_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.intLongToRadixString(1L, 1));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int)} with {@code number}, {@code radix}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int) with 'number', 'radix'; when eight; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int)"})
  void testIntLongToRadixStringWithNumberRadix_whenEight_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("1", TbUtils.intLongToRadixString(1L, 8));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int)} with {@code number}, {@code radix}.
   *
   * <ul>
   *   <li>When {@link Long#MIN_VALUE}.
   *   <li>Then return {@code 8000000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int) with 'number', 'radix'; when MIN_VALUE; then return '8000000000000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int)"})
  void testIntLongToRadixStringWithNumberRadix_whenMin_value_thenReturn8000000000000000() {
    // Arrange, Act and Assert
    assertEquals("8000000000000000", TbUtils.intLongToRadixString(Long.MIN_VALUE, Short.SIZE));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int)} with {@code number}, {@code radix}.
   *
   * <ul>
   *   <li>When minus one.
   *   <li>Then return {@code FFFF}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int) with 'number', 'radix'; when minus one; then return 'FFFF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int)"})
  void testIntLongToRadixStringWithNumberRadix_whenMinusOne_thenReturnFfff() {
    // Arrange, Act and Assert
    assertEquals("FFFF", TbUtils.intLongToRadixString(-1L, Short.SIZE));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int)} with {@code number}, {@code radix}.
   *
   * <ul>
   *   <li>When {@link Short#SIZE}.
   *   <li>Then return {@code 01}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int) with 'number', 'radix'; when SIZE; then return '01'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int)"})
  void testIntLongToRadixStringWithNumberRadix_whenSize_thenReturn01() {
    // Arrange, Act and Assert
    assertEquals("01", TbUtils.intLongToRadixString(1L, Short.SIZE));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int)} with {@code number}, {@code radix}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int) with 'number', 'radix'; when ten; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int)"})
  void testIntLongToRadixStringWithNumberRadix_whenTen_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("1", TbUtils.intLongToRadixString(1L, 10));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int)} with {@code number}, {@code radix}.
   *
   * <ul>
   *   <li>When thirty-seven.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int)}
   */
  @Test
  @DisplayName("Test intLongToRadixString(Long, int) with 'number', 'radix'; when thirty-seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int)"})
  void testIntLongToRadixStringWithNumberRadix_whenThirtySeven() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.intLongToRadixString(1L, 37));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int)} with {@code number}, {@code radix}.
   *
   * <ul>
   *   <li>When twenty-five.
   *   <li>Then return {@code 1}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int) with 'number', 'radix'; when twenty-five; then return '1'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int)"})
  void testIntLongToRadixStringWithNumberRadix_whenTwentyFive_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("1", TbUtils.intLongToRadixString(1L, 25));
  }

  /**
   * Test {@link TbUtils#intLongToRadixString(Long, int)} with {@code number}, {@code radix}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 00000001}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#intLongToRadixString(Long, int)}
   */
  @Test
  @DisplayName(
      "Test intLongToRadixString(Long, int) with 'number', 'radix'; when two; then return '00000001'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.intLongToRadixString(Long, int)"})
  void testIntLongToRadixStringWithNumberRadix_whenTwo_thenReturn00000001() {
    // Arrange, Act and Assert
    assertEquals("00000001", TbUtils.intLongToRadixString(1L, 2));
  }

  /**
   * Test {@link TbUtils#floatToHex(Float)} with {@code f}.
   *
   * <p>Method under test: {@link TbUtils#floatToHex(Float)}
   */
  @Test
  @DisplayName("Test floatToHex(Float) with 'f'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.floatToHex(Float)"})
  void testFloatToHexWithF() {
    // Arrange, Act and Assert
    assertEquals("0x41200000", TbUtils.floatToHex(10.0f));
  }

  /**
   * Test {@link TbUtils#floatToHex(Float, boolean)} with {@code f}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code 0x00002041}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#floatToHex(Float, boolean)}
   */
  @Test
  @DisplayName(
      "Test floatToHex(Float, boolean) with 'f', 'bigEndian'; when 'false'; then return '0x00002041'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.floatToHex(Float, boolean)"})
  void testFloatToHexWithFBigEndian_whenFalse_thenReturn0x00002041() {
    // Arrange, Act and Assert
    assertEquals("0x00002041", TbUtils.floatToHex(10.0f, false));
  }

  /**
   * Test {@link TbUtils#floatToHex(Float, boolean)} with {@code f}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code 0x41200000}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#floatToHex(Float, boolean)}
   */
  @Test
  @DisplayName(
      "Test floatToHex(Float, boolean) with 'f', 'bigEndian'; when 'true'; then return '0x41200000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.floatToHex(Float, boolean)"})
  void testFloatToHexWithFBigEndian_whenTrue_thenReturn0x41200000() {
    // Arrange, Act and Assert
    assertEquals("0x41200000", TbUtils.floatToHex(10.0f, true));
  }

  /**
   * Test {@link TbUtils#doubleToHex(Double)} with {@code d}.
   *
   * <p>Method under test: {@link TbUtils#doubleToHex(Double)}
   */
  @Test
  @DisplayName("Test doubleToHex(Double) with 'd'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.doubleToHex(Double)"})
  void testDoubleToHexWithD() {
    // Arrange, Act and Assert
    assertEquals("0x4024000000000000", TbUtils.doubleToHex(10.0d));
  }

  /**
   * Test {@link TbUtils#doubleToHex(Double, boolean)} with {@code d}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code 0x0000000000002440}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#doubleToHex(Double, boolean)}
   */
  @Test
  @DisplayName(
      "Test doubleToHex(Double, boolean) with 'd', 'bigEndian'; when 'false'; then return '0x0000000000002440'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.doubleToHex(Double, boolean)"})
  void testDoubleToHexWithDBigEndian_whenFalse_thenReturn0x0000000000002440() {
    // Arrange, Act and Assert
    assertEquals("0x0000000000002440", TbUtils.doubleToHex(10.0d, false));
  }

  /**
   * Test {@link TbUtils#doubleToHex(Double, boolean)} with {@code d}, {@code bigEndian}.
   *
   * <ul>
   *   <li>When {@code true}.
   *   <li>Then return {@code 0x4024000000000000}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#doubleToHex(Double, boolean)}
   */
  @Test
  @DisplayName(
      "Test doubleToHex(Double, boolean) with 'd', 'bigEndian'; when 'true'; then return '0x4024000000000000'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.doubleToHex(Double, boolean)"})
  void testDoubleToHexWithDBigEndian_whenTrue_thenReturn0x4024000000000000() {
    // Arrange, Act and Assert
    assertEquals("0x4024000000000000", TbUtils.doubleToHex(10.0d, true));
  }

  /**
   * Test {@link TbUtils#base64ToHex(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code D35DB7E39EBBF3D001083105}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#base64ToHex(String)}
   */
  @Test
  @DisplayName(
      "Test base64ToHex(String); when '0123456789ABCDEF'; then return 'D35DB7E39EBBF3D001083105'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.base64ToHex(String)"})
  void testBase64ToHex_when0123456789abcdef_thenReturnD35db7e39ebbf3d001083105() {
    // Arrange, Act and Assert
    assertEquals("D35DB7E39EBBF3D001083105", TbUtils.base64ToHex("0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#hexToBase64(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@code ASNFZ4mrze8=}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#hexToBase64(String)}
   */
  @Test
  @DisplayName("Test hexToBase64(String); when '0123456789ABCDEF'; then return 'ASNFZ4mrze8='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.hexToBase64(String)"})
  void testHexToBase64_when0123456789abcdef_thenReturnASNFZ4mrze8() {
    // Arrange, Act and Assert
    assertEquals("ASNFZ4mrze8=", TbUtils.hexToBase64("0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#bytesToBase64(byte[])}.
   *
   * <p>Method under test: {@link TbUtils#bytesToBase64(byte[])}
   */
  @Test
  @DisplayName("Test bytesToBase64(byte[])")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToBase64(byte[])"})
  void testBytesToBase64() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("QVhBWEFYQVg=", TbUtils.bytesToBase64("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TbUtils#base64ToBytes(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#base64ToBytes(String)}
   */
  @Test
  @DisplayName("Test base64ToBytes(String); when empty string; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbUtils.base64ToBytes(String)"})
  void testBase64ToBytes_whenEmptyString_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, TbUtils.base64ToBytes(""));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(byte[])}
   */
  @Test
  @DisplayName("Test parseBytesToInt(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(byte[])"})
  void testParseBytesToIntWithByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1096302936, TbUtils.parseBytesToInt("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return {@code 4282433}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; then return '4282433'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(byte[], int, int, boolean)"})
  void testParseBytesToIntWithByteIntIntBoolean_thenReturn4282433()
      throws UnsupportedEncodingException {
    // Arrange and Act
    int actualParseBytesToIntResult =
        TbUtils.parseBytesToInt("AXAXAXAX".getBytes("UTF-8"), 2, 3, true);

    // Assert
    assertEquals(4282433, actualParseBytesToIntResult);
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When eight.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(byte[], int, int, boolean)"})
  void testParseBytesToIntWithByteIntIntBoolean_whenEight() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesToInt("AXAXAXAX".getBytes("UTF-8"), 8, 3, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(byte[], int, int, boolean)"})
  void testParseBytesToIntWithByteIntIntBoolean_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesToInt(new byte[] {}, 2, 3, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(byte[], int, int, boolean)"})
  void testParseBytesToIntWithByteIntIntBoolean_whenFive() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            TbUtils.parseBytesToInt(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 5, false));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code 1480677441}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when four; then return '1480677441'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(byte[], int, int, boolean)"})
  void testParseBytesToIntWithByteIntIntBoolean_whenFour_thenReturn1480677441() {
    // Arrange and Act
    int actualParseBytesToIntResult =
        TbUtils.parseBytesToInt(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 4, false);

    // Assert
    assertEquals(1480677441, actualParseBytesToIntResult);
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(byte[], int, int) with 'byte[]', 'int', 'int'; when 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(byte[], int, int)"})
  void testParseBytesToIntWithByteIntInt_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesToInt(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 5));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 4282433}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(byte[], int, int) with 'byte[]', 'int', 'int'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return '4282433'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(byte[], int, int)"})
  void testParseBytesToIntWithByteIntInt_whenAxaxaxaxBytesIsUtf8_thenReturn4282433()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4282433, TbUtils.parseBytesToInt("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>When eight.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(byte[], int, int) with 'byte[]', 'int', 'int'; when eight; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(byte[], int, int)"})
  void testParseBytesToIntWithByteIntInt_whenEight_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesToInt("AXAXAXAX".getBytes("UTF-8"), 8, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(byte[], int, int)} with {@code byte[]}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(byte[], int, int) with 'byte[]', 'int', 'int'; when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(byte[], int, int)"})
  void testParseBytesToIntWithByteIntInt_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesToInt(new byte[] {}, 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(byte[], int)} with {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(byte[], int) with 'byte[]', 'int'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(byte[], int)"})
  void testParseBytesToIntWithByteInt_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseBytesToInt(new byte[] {}, 2));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(byte[], int)} with {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 1096302936}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(byte[], int) with 'byte[]', 'int'; when two; then return '1096302936'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(byte[], int)"})
  void testParseBytesToIntWithByteInt_whenTwo_thenReturn1096302936()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1096302936, TbUtils.parseBytesToInt("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int, int, boolean)} with {@code List}, {@code int},
   * {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Given four.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'; given four; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int, int, boolean)"})
  void testParseBytesToIntWithListIntIntBoolean_givenFour_whenZero_thenReturnZero() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 4);
    data.add((byte) 'A');

    // Act
    int actualParseBytesToIntResult = TbUtils.parseBytesToInt(data, 2, 0, true);

    // Assert
    assertEquals(0, actualParseBytesToIntResult);
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int, int, boolean)} with {@code List}, {@code int},
   * {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Given four.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'; given four; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int, int, boolean)"})
  void testParseBytesToIntWithListIntIntBoolean_givenFour_whenZero_thenReturnZero2() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 4);
    data.add((byte) 'A');

    // Act
    int actualParseBytesToIntResult = TbUtils.parseBytesToInt(data, 2, 0, false);

    // Assert
    assertEquals(0, actualParseBytesToIntResult);
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int, int, boolean)} with {@code List}, {@code int},
   * {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int, int, boolean)"})
  void testParseBytesToIntWithListIntIntBoolean_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesToInt(new ArrayList<>(), 2, 3, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int, int, boolean)} with {@code List}, {@code int},
   * {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int, int, boolean)"})
  void testParseBytesToIntWithListIntIntBoolean_thenThrowIllegalArgumentException2() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseBytesToInt(data, 2, 3, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int, int, boolean)} with {@code List}, {@code int},
   * {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int, int, boolean)"})
  void testParseBytesToIntWithListIntIntBoolean_thenThrowIllegalArgumentException3() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 4);
    data.add((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseBytesToInt(data, 2, 3, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int, int, boolean)} with {@code List}, {@code int},
   * {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'; when five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int, int, boolean)"})
  void testParseBytesToIntWithListIntIntBoolean_whenFive() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesToInt(new ArrayList<>(), Integer.MIN_VALUE, 5, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int, int)} with {@code List}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int, int) with 'List', 'int', 'int'; given 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int, int)"})
  void testParseBytesToIntWithListIntInt_givenA_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseBytesToInt(data, 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int, int)} with {@code List}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int, int) with 'List', 'int', 'int'; given one; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int, int)"})
  void testParseBytesToIntWithListIntInt_givenOne_whenArrayListAddOne() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 1);
    data.add((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseBytesToInt(data, 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int, int)} with {@code List}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int, int) with 'List', 'int', 'int'; given one; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int, int)"})
  void testParseBytesToIntWithListIntInt_givenOne_whenZero_thenReturnZero() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 1);
    data.add((byte) 'A');

    // Act and Assert
    assertEquals(0, TbUtils.parseBytesToInt(data, 2, 0));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int, int)} with {@code List}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int, int)}
   */
  @Test
  @DisplayName("Test parseBytesToInt(List, int, int) with 'List', 'int', 'int'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int, int)"})
  void testParseBytesToIntWithListIntInt_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesToInt(new ArrayList<>(), 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int, int)} with {@code List}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>When five.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int, int) with 'List', 'int', 'int'; when five; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int, int)"})
  void testParseBytesToIntWithListIntInt_whenFive_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesToInt(new ArrayList<>(), Integer.MIN_VALUE, 5));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int)} with {@code List}, {@code int}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int) with 'List', 'int'; given 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int)"})
  void testParseBytesToIntWithListInt_givenA_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseBytesToInt(data, 2));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int)} with {@code List}, {@code int}.
   *
   * <ul>
   *   <li>Given four.
   *   <li>When {@link ArrayList#ArrayList()} add four.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int) with 'List', 'int'; given four; when ArrayList() add four; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int)"})
  void testParseBytesToIntWithListInt_givenFour_whenArrayListAddFour_thenReturnZero() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 4);
    data.add((byte) 'A');

    // Act and Assert
    assertEquals(0, TbUtils.parseBytesToInt(data, 2));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List, int)} with {@code List}, {@code int}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List, int) with 'List', 'int'; when ArrayList(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List, int)"})
  void testParseBytesToIntWithListInt_whenArrayList_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesToInt(new ArrayList<>(), 2));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code A}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List) with 'List'; given 'A'; when ArrayList() add 'A'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List)"})
  void testParseBytesToIntWithList_givenA_whenArrayListAddA_thenReturnSixtyFive() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 'A');

    // Act and Assert
    assertEquals(65, TbUtils.parseBytesToInt(data));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given four.
   *   <li>When {@link ArrayList#ArrayList()} add four.
   *   <li>Then return {@code 1089}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToInt(List) with 'List'; given four; when ArrayList() add four; then return '1089'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List)"})
  void testParseBytesToIntWithList_givenFour_whenArrayListAddFour_thenReturn1089() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 4);
    data.add((byte) 'A');

    // Act and Assert
    assertEquals(1089, TbUtils.parseBytesToInt(data));
  }

  /**
   * Test {@link TbUtils#parseBytesToInt(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToInt(List)}
   */
  @Test
  @DisplayName("Test parseBytesToInt(List) with 'List'; when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBytesToInt(List)"})
  void testParseBytesToIntWithList_whenArrayList_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, TbUtils.parseBytesToInt(new ArrayList<>()));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(byte[])}
   */
  @Test
  @DisplayName("Test parseBytesToLong(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(byte[])"})
  void testParseBytesToLongWithByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4708585257725083992L, TbUtils.parseBytesToLong("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(byte[], int, int, boolean)"})
  void testParseBytesToLongWithByteIntIntBoolean_whenA() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            TbUtils.parseBytesToLong(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 8, false));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(byte[], int, int, boolean)"})
  void testParseBytesToLongWithByteIntIntBoolean_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesToLong(new byte[] {}, 2, 3, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code 4282433}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when 'false'; then return '4282433'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(byte[], int, int, boolean)"})
  void testParseBytesToLongWithByteIntIntBoolean_whenFalse_thenReturn4282433()
      throws UnsupportedEncodingException {
    // Arrange and Act
    long actualParseBytesToLongResult =
        TbUtils.parseBytesToLong("AXAXAXAX".getBytes("UTF-8"), 2, 3, false);

    // Assert
    assertEquals(4282433L, actualParseBytesToLongResult);
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When nine.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(byte[], int, int, boolean)"})
  void testParseBytesToLongWithByteIntIntBoolean_whenNine() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesToLong("AXAXAXAX".getBytes("UTF-8"), Integer.MIN_VALUE, 9, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 4282433}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when three; then return '4282433'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(byte[], int, int, boolean)"})
  void testParseBytesToLongWithByteIntIntBoolean_whenThree_thenReturn4282433()
      throws UnsupportedEncodingException {
    // Arrange and Act
    long actualParseBytesToLongResult =
        TbUtils.parseBytesToLong("AXAXAXAX".getBytes("UTF-8"), 2, 3, true);

    // Assert
    assertEquals(4282433L, actualParseBytesToLongResult);
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(byte[], int, int) with 'byte[]', 'int', 'int'; when 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(byte[], int, int)"})
  void testParseBytesToLongWithByteIntInt_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesToLong(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 8));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(byte[], int, int) with 'byte[]', 'int', 'int'; when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(byte[], int, int)"})
  void testParseBytesToLongWithByteIntInt_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesToLong(new byte[] {}, 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When nine.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(byte[], int, int) with 'byte[]', 'int', 'int'; when nine; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(byte[], int, int)"})
  void testParseBytesToLongWithByteIntInt_whenNine_thenThrowIllegalArgumentException()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesToLong("AXAXAXAX".getBytes("UTF-8"), Integer.MIN_VALUE, 9));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When three.
   *   <li>Then return {@code 4282433}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(byte[], int, int) with 'byte[]', 'int', 'int'; when three; then return '4282433'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(byte[], int, int)"})
  void testParseBytesToLongWithByteIntInt_whenThree_thenReturn4282433()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4282433L, TbUtils.parseBytesToLong("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(byte[], int)} with {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(byte[], int) with 'byte[]', 'int'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(byte[], int)"})
  void testParseBytesToLongWithByteInt_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseBytesToLong(new byte[] {}, 2));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(byte[], int)} with {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return {@code 71847309230424}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(byte[], int) with 'byte[]', 'int'; when two; then return '71847309230424'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(byte[], int)"})
  void testParseBytesToLongWithByteInt_whenTwo_thenReturn71847309230424()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(71847309230424L, TbUtils.parseBytesToLong("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int, int, boolean)} with {@code List}, {@code int},
   * {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Given backspace.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'; given backspace; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int, int, boolean)"})
  void testParseBytesToLongWithListIntIntBoolean_givenBackspace_whenZero_thenReturnZero() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) '\b');
    data.add((byte) 'A');

    // Act
    long actualParseBytesToLongResult = TbUtils.parseBytesToLong(data, 2, 0, true);

    // Assert
    assertEquals(0L, actualParseBytesToLongResult);
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int, int, boolean)} with {@code List}, {@code int},
   * {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Given backspace.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'; given backspace; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int, int, boolean)"})
  void testParseBytesToLongWithListIntIntBoolean_givenBackspace_whenZero_thenReturnZero2() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) '\b');
    data.add((byte) 'A');

    // Act
    long actualParseBytesToLongResult = TbUtils.parseBytesToLong(data, 2, 0, false);

    // Assert
    assertEquals(0L, actualParseBytesToLongResult);
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int, int, boolean)} with {@code List}, {@code int},
   * {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int, int, boolean)"})
  void testParseBytesToLongWithListIntIntBoolean_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesToLong(new ArrayList<>(), 2, 3, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int, int, boolean)} with {@code List}, {@code int},
   * {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int, int, boolean)"})
  void testParseBytesToLongWithListIntIntBoolean_thenThrowIllegalArgumentException2() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseBytesToLong(data, 2, 3, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int, int, boolean)} with {@code List}, {@code int},
   * {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int, int, boolean)"})
  void testParseBytesToLongWithListIntIntBoolean_thenThrowIllegalArgumentException3() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) '\b');
    data.add((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseBytesToLong(data, 2, 3, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int, int, boolean)} with {@code List}, {@code int},
   * {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When nine.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'; when nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int, int, boolean)"})
  void testParseBytesToLongWithListIntIntBoolean_whenNine() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesToLong(new ArrayList<>(), Integer.MIN_VALUE, 9, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int, int)} with {@code List}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int, int) with 'List', 'int', 'int'; given 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int, int)"})
  void testParseBytesToLongWithListIntInt_givenA_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseBytesToLong(data, 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int, int)} with {@code List}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link ArrayList#ArrayList()} add one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int, int) with 'List', 'int', 'int'; given one; when ArrayList() add one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int, int)"})
  void testParseBytesToLongWithListIntInt_givenOne_whenArrayListAddOne() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 1);
    data.add((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseBytesToLong(data, 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int, int)} with {@code List}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When zero.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int, int) with 'List', 'int', 'int'; given one; when zero; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int, int)"})
  void testParseBytesToLongWithListIntInt_givenOne_whenZero_thenReturnZero() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 1);
    data.add((byte) 'A');

    // Act and Assert
    assertEquals(0L, TbUtils.parseBytesToLong(data, 2, 0));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int, int)} with {@code List}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int, int)}
   */
  @Test
  @DisplayName("Test parseBytesToLong(List, int, int) with 'List', 'int', 'int'; when ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int, int)"})
  void testParseBytesToLongWithListIntInt_whenArrayList() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesToLong(new ArrayList<>(), 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int, int)} with {@code List}, {@code int}, {@code
   * int}.
   *
   * <ul>
   *   <li>When nine.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int, int) with 'List', 'int', 'int'; when nine; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int, int)"})
  void testParseBytesToLongWithListIntInt_whenNine_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesToLong(new ArrayList<>(), Integer.MIN_VALUE, 9));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int)} with {@code List}, {@code int}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int) with 'List', 'int'; given 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int)"})
  void testParseBytesToLongWithListInt_givenA_thenThrowIllegalArgumentException() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 'A');

    // Act and Assert
    assertThrows(IllegalArgumentException.class, () -> TbUtils.parseBytesToLong(data, 2));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int)} with {@code List}, {@code int}.
   *
   * <ul>
   *   <li>Given backspace.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int) with 'List', 'int'; given backspace; then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int)"})
  void testParseBytesToLongWithListInt_givenBackspace_thenReturnZero() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) '\b');
    data.add((byte) 'A');

    // Act and Assert
    assertEquals(0L, TbUtils.parseBytesToLong(data, 2));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List, int)} with {@code List}, {@code int}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List, int) with 'List', 'int'; when ArrayList(); then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List, int)"})
  void testParseBytesToLongWithListInt_whenArrayList_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesToLong(new ArrayList<>(), 2));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given {@code A}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code A}.
   *   <li>Then return sixty-five.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToLong(List) with 'List'; given 'A'; when ArrayList() add 'A'; then return sixty-five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List)"})
  void testParseBytesToLongWithList_givenA_whenArrayListAddA_thenReturnSixtyFive() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) 'A');

    // Act and Assert
    assertEquals(65L, TbUtils.parseBytesToLong(data));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List)} with {@code List}.
   *
   * <ul>
   *   <li>Given backspace.
   *   <li>Then return {@code 2113}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List)}
   */
  @Test
  @DisplayName("Test parseBytesToLong(List) with 'List'; given backspace; then return '2113'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List)"})
  void testParseBytesToLongWithList_givenBackspace_thenReturn2113() {
    // Arrange
    ArrayList<Byte> data = new ArrayList<>();
    data.add((byte) '\b');
    data.add((byte) 'A');

    // Act and Assert
    assertEquals(2113L, TbUtils.parseBytesToLong(data));
  }

  /**
   * Test {@link TbUtils#parseBytesToLong(List)} with {@code List}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToLong(List)}
   */
  @Test
  @DisplayName("Test parseBytesToLong(List) with 'List'; when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"long TbUtils.parseBytesToLong(List)"})
  void testParseBytesToLongWithList_whenArrayList_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0L, TbUtils.parseBytesToLong(new ArrayList<>()));
  }

  /**
   * Test {@link TbUtils#parseBytesToFloat(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return {@code 6.000967E-39}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToFloat(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToFloat(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; then return '6.000967E-39'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesToFloat(byte[], int, int, boolean)"})
  void testParseBytesToFloatWithByteIntIntBoolean_thenReturn6000967e39()
      throws UnsupportedEncodingException {
    // Arrange and Act
    float actualParseBytesToFloatResult =
        TbUtils.parseBytesToFloat("AXAXAXAX".getBytes("UTF-8"), 2, 3, true);

    // Assert
    assertEquals(6.000967E-39f, actualParseBytesToFloatResult);
  }

  /**
   * Test {@link TbUtils#parseBytesToFloat(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code 6.000967E-39}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToFloat(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToFloat(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when 'A'; then return '6.000967E-39'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesToFloat(byte[], int, int, boolean)"})
  void testParseBytesToFloatWithByteIntIntBoolean_whenA_thenReturn6000967e39() {
    // Arrange and Act
    float actualParseBytesToFloatResult =
        TbUtils.parseBytesToFloat(new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 3, false);

    // Assert
    assertEquals(6.000967E-39f, actualParseBytesToFloatResult);
  }

  /**
   * Test {@link TbUtils#parseBytesToFloat(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 6.000967E-39}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToFloat(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToFloat(byte[], int, int) with 'byte[]', 'int', 'int'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return '6.000967E-39'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesToFloat(byte[], int, int)"})
  void testParseBytesToFloatWithByteIntInt_whenAxaxaxaxBytesIsUtf8_thenReturn6000967e39()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(6.000967E-39f, TbUtils.parseBytesToFloat("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToFloat(byte[], int)} with {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 13.515953}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToFloat(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToFloat(byte[], int) with 'byte[]', 'int'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return '13.515953'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesToFloat(byte[], int)"})
  void testParseBytesToFloatWithByteInt_whenAxaxaxaxBytesIsUtf8_thenReturn13515953()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(13.515953f, TbUtils.parseBytesToFloat("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link TbUtils#parseBytesToFloat(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToFloat(byte[])}
   */
  @Test
  @DisplayName(
      "Test parseBytesToFloat(byte[]) with 'byte[]'; when 'A'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesToFloat(byte[])"})
  void testParseBytesToFloatWithByte_whenA_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () ->
            TbUtils.parseBytesToFloat(
                new byte[] {-1, Byte.MIN_VALUE, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TbUtils#parseBytesToFloat(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code AXAXAXAX} Bytes is {@code UTF-8}.
   *   <li>Then return {@code 13.515953}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToFloat(byte[])}
   */
  @Test
  @DisplayName(
      "Test parseBytesToFloat(byte[]) with 'byte[]'; when 'AXAXAXAX' Bytes is 'UTF-8'; then return '13.515953'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesToFloat(byte[])"})
  void testParseBytesToFloatWithByte_whenAxaxaxaxBytesIsUtf8_thenReturn13515953()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(13.515953f, TbUtils.parseBytesToFloat("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TbUtils#parseBytesToFloat(List)} with {@code List}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesToFloat(List)}
   */
  @Test
  @DisplayName("Test parseBytesToFloat(List) with 'List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesToFloat(List)"})
  void testParseBytesToFloatWithList() {
    // Arrange, Act and Assert
    assertEquals(0.0f, TbUtils.parseBytesToFloat(new ArrayList<>()));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(byte[])}
   */
  @Test
  @DisplayName("Test parseBytesIntToFloat(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(byte[])"})
  void testParseBytesIntToFloatWithByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1.09630298E9f, TbUtils.parseBytesIntToFloat("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(byte[], int, int, boolean)} with {@code byte[]},
   * {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return {@code 4282433.0}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesIntToFloat(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; then return '4282433.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(byte[], int, int, boolean)"})
  void testParseBytesIntToFloatWithByteIntIntBoolean_thenReturn42824330()
      throws UnsupportedEncodingException {
    // Arrange and Act
    float actualParseBytesIntToFloatResult =
        TbUtils.parseBytesIntToFloat("AXAXAXAX".getBytes("UTF-8"), 2, 3, true);

    // Assert
    assertEquals(4282433.0f, actualParseBytesIntToFloatResult);
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(byte[], int, int, boolean)} with {@code byte[]},
   * {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When eight.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesIntToFloat(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(byte[], int, int, boolean)"})
  void testParseBytesIntToFloatWithByteIntIntBoolean_whenEight() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            TbUtils.parseBytesIntToFloat(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 8, false));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(byte[], int, int, boolean)} with {@code byte[]},
   * {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesIntToFloat(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(byte[], int, int, boolean)"})
  void testParseBytesIntToFloatWithByteIntIntBoolean_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesIntToFloat(new byte[] {}, 2, 3, true));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(byte[], int, int, boolean)} with {@code byte[]},
   * {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesIntToFloat(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(byte[], int, int, boolean)"})
  void testParseBytesIntToFloatWithByteIntIntBoolean_whenFive() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            TbUtils.parseBytesIntToFloat(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 5, false));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(byte[], int, int, boolean)} with {@code byte[]},
   * {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When four.
   *   <li>Then return {@code 1.4806775E9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesIntToFloat(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when four; then return '1.4806775E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(byte[], int, int, boolean)"})
  void testParseBytesIntToFloatWithByteIntIntBoolean_whenFour_thenReturn14806775e9() {
    // Arrange and Act
    float actualParseBytesIntToFloatResult =
        TbUtils.parseBytesIntToFloat(
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 4, false);

    // Assert
    assertEquals(1.4806775E9f, actualParseBytesIntToFloatResult);
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Then return {@code 4282433.0}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesIntToFloat(byte[], int, int) with 'byte[]', 'int', 'int'; then return '4282433.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(byte[], int, int)"})
  void testParseBytesIntToFloatWithByteIntInt_thenReturn42824330()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4282433.0f, TbUtils.parseBytesIntToFloat("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When eight.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesIntToFloat(byte[], int, int) with 'byte[]', 'int', 'int'; when eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(byte[], int, int)"})
  void testParseBytesIntToFloatWithByteIntInt_whenEight() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            TbUtils.parseBytesIntToFloat(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 8));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesIntToFloat(byte[], int, int) with 'byte[]', 'int', 'int'; when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(byte[], int, int)"})
  void testParseBytesIntToFloatWithByteIntInt_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesIntToFloat(new byte[] {}, 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When five.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(byte[], int, int)}
   */
  @Test
  @DisplayName("Test parseBytesIntToFloat(byte[], int, int) with 'byte[]', 'int', 'int'; when five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(byte[], int, int)"})
  void testParseBytesIntToFloatWithByteIntInt_whenFive() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            TbUtils.parseBytesIntToFloat(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 5));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(byte[], int)} with {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return {@code 1.09630298E9}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesIntToFloat(byte[], int) with 'byte[]', 'int'; then return '1.09630298E9'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(byte[], int)"})
  void testParseBytesIntToFloatWithByteInt_thenReturn109630298e9()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(1.09630298E9f, TbUtils.parseBytesIntToFloat("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(byte[], int)} with {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesIntToFloat(byte[], int) with 'byte[]', 'int'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(byte[], int)"})
  void testParseBytesIntToFloatWithByteInt_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesIntToFloat(new byte[] {}, 2));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(List)} with {@code List}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(List)}
   */
  @Test
  @DisplayName("Test parseBytesIntToFloat(List) with 'List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(List)"})
  void testParseBytesIntToFloatWithList() {
    // Arrange, Act and Assert
    assertEquals(0.0f, TbUtils.parseBytesIntToFloat(new ArrayList<>()));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(List, int)} with {@code List}, {@code int}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(List, int)}
   */
  @Test
  @DisplayName("Test parseBytesIntToFloat(List, int) with 'List', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(List, int)"})
  void testParseBytesIntToFloatWithListInt() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesIntToFloat(new ArrayList<>(), 2));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(List, int, int)} with {@code List}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(List, int, int)}
   */
  @Test
  @DisplayName("Test parseBytesIntToFloat(List, int, int) with 'List', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(List, int, int)"})
  void testParseBytesIntToFloatWithListIntInt() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesIntToFloat(new ArrayList<>(), 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesIntToFloat(List, int, int, boolean)} with {@code List}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesIntToFloat(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesIntToFloat(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.parseBytesIntToFloat(List, int, int, boolean)"})
  void testParseBytesIntToFloatWithListIntIntBoolean() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesIntToFloat(new ArrayList<>(), 2, 3, true));
  }

  /**
   * Test {@link TbUtils#parseBytesToDouble(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return {@code 2.115803E-317}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToDouble(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToDouble(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; then return '2.115803E-317'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesToDouble(byte[], int, int, boolean)"})
  void testParseBytesToDoubleWithByteIntIntBoolean_thenReturn2115803e317()
      throws UnsupportedEncodingException {
    // Arrange and Act
    double actualParseBytesToDoubleResult =
        TbUtils.parseBytesToDouble("AXAXAXAX".getBytes("UTF-8"), 2, 3, true);

    // Assert
    assertEquals(2.115803E-317d, actualParseBytesToDoubleResult);
  }

  /**
   * Test {@link TbUtils#parseBytesToDouble(byte[], int, int, boolean)} with {@code byte[]}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return {@code 2.115803E-317}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToDouble(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToDouble(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when 'A'; then return '2.115803E-317'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesToDouble(byte[], int, int, boolean)"})
  void testParseBytesToDoubleWithByteIntIntBoolean_whenA_thenReturn2115803e317() {
    // Arrange and Act
    double actualParseBytesToDoubleResult =
        TbUtils.parseBytesToDouble(
            new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 3, false);

    // Assert
    assertEquals(2.115803E-317d, actualParseBytesToDoubleResult);
  }

  /**
   * Test {@link TbUtils#parseBytesToDouble(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Then return {@code 2.115803E-317}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToDouble(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToDouble(byte[], int, int) with 'byte[]', 'int', 'int'; then return '2.115803E-317'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesToDouble(byte[], int, int)"})
  void testParseBytesToDoubleWithByteIntInt_thenReturn2115803e317()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(2.115803E-317d, TbUtils.parseBytesToDouble("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToDouble(byte[], int)} with {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return {@code 3.5497287236885E-310}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToDouble(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToDouble(byte[], int) with 'byte[]', 'int'; then return '3.5497287236885E-310'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesToDouble(byte[], int)"})
  void testParseBytesToDoubleWithByteInt_thenReturn35497287236885e310()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        3.5497287236885E-310d, TbUtils.parseBytesToDouble("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link TbUtils#parseBytesToDouble(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>Then return {@code 6358369.021011673}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToDouble(byte[])}
   */
  @Test
  @DisplayName("Test parseBytesToDouble(byte[]) with 'byte[]'; then return '6358369.021011673'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesToDouble(byte[])"})
  void testParseBytesToDoubleWithByte_thenReturn6358369021011673()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(6358369.021011673d, TbUtils.parseBytesToDouble("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TbUtils#parseBytesToDouble(byte[])} with {@code byte[]}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToDouble(byte[])}
   */
  @Test
  @DisplayName(
      "Test parseBytesToDouble(byte[]) with 'byte[]'; when 'A'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesToDouble(byte[])"})
  void testParseBytesToDoubleWithByte_whenA_thenThrowNumberFormatException() {
    // Arrange, Act and Assert
    assertThrows(
        NumberFormatException.class,
        () -> TbUtils.parseBytesToDouble(new byte[] {-1, -1, 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TbUtils#parseBytesToDouble(List)} with {@code List}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesToDouble(List)}
   */
  @Test
  @DisplayName("Test parseBytesToDouble(List) with 'List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesToDouble(List)"})
  void testParseBytesToDoubleWithList() {
    // Arrange, Act and Assert
    assertEquals(0.0d, TbUtils.parseBytesToDouble(new ArrayList<>()));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(byte[])} with {@code byte[]}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(byte[])}
   */
  @Test
  @DisplayName("Test parseBytesLongToDouble(byte[]) with 'byte[]'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(byte[])"})
  void testParseBytesLongToDoubleWithByte() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        4.7085852577250836E18d, TbUtils.parseBytesLongToDouble("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(byte[], int, int, boolean)} with {@code byte[]},
   * {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>Then return {@code 4282433.0}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesLongToDouble(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; then return '4282433.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(byte[], int, int, boolean)"})
  void testParseBytesLongToDoubleWithByteIntIntBoolean_thenReturn42824330()
      throws UnsupportedEncodingException {
    // Arrange and Act
    double actualParseBytesLongToDoubleResult =
        TbUtils.parseBytesLongToDouble("AXAXAXAX".getBytes("UTF-8"), 2, 3, true);

    // Assert
    assertEquals(4282433.0d, actualParseBytesLongToDoubleResult);
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(byte[], int, int, boolean)} with {@code byte[]},
   * {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code A}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesLongToDouble(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when 'A'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(byte[], int, int, boolean)"})
  void testParseBytesLongToDoubleWithByteIntIntBoolean_whenA() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            TbUtils.parseBytesLongToDouble(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 8, false));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(byte[], int, int, boolean)} with {@code byte[]},
   * {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesLongToDouble(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(byte[], int, int, boolean)"})
  void testParseBytesLongToDoubleWithByteIntIntBoolean_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesLongToDouble(new byte[] {}, 2, 3, true));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(byte[], int, int, boolean)} with {@code byte[]},
   * {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When {@code false}.
   *   <li>Then return {@code 4282433.0}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesLongToDouble(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when 'false'; then return '4282433.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(byte[], int, int, boolean)"})
  void testParseBytesLongToDoubleWithByteIntIntBoolean_whenFalse_thenReturn42824330()
      throws UnsupportedEncodingException {
    // Arrange and Act
    double actualParseBytesLongToDoubleResult =
        TbUtils.parseBytesLongToDouble("AXAXAXAX".getBytes("UTF-8"), 2, 3, false);

    // Assert
    assertEquals(4282433.0d, actualParseBytesLongToDoubleResult);
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(byte[], int, int, boolean)} with {@code byte[]},
   * {@code int}, {@code int}, {@code boolean}.
   *
   * <ul>
   *   <li>When nine.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(byte[], int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesLongToDouble(byte[], int, int, boolean) with 'byte[]', 'int', 'int', 'boolean'; when nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(byte[], int, int, boolean)"})
  void testParseBytesLongToDoubleWithByteIntIntBoolean_whenNine()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            TbUtils.parseBytesLongToDouble(
                "AXAXAXAX".getBytes("UTF-8"), Integer.MIN_VALUE, 9, true));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>Then return {@code 4282433.0}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesLongToDouble(byte[], int, int) with 'byte[]', 'int', 'int'; then return '4282433.0'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(byte[], int, int)"})
  void testParseBytesLongToDoubleWithByteIntInt_thenReturn42824330()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(4282433.0d, TbUtils.parseBytesLongToDouble("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesLongToDouble(byte[], int, int) with 'byte[]', 'int', 'int'; when 'A'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(byte[], int, int)"})
  void testParseBytesLongToDoubleWithByteIntInt_whenA_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () ->
            TbUtils.parseBytesLongToDouble(
                new byte[] {'A', 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 2, 8));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesLongToDouble(byte[], int, int) with 'byte[]', 'int', 'int'; when empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(byte[], int, int)"})
  void testParseBytesLongToDoubleWithByteIntInt_whenEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesLongToDouble(new byte[] {}, 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(byte[], int, int)} with {@code byte[]}, {@code int},
   * {@code int}.
   *
   * <ul>
   *   <li>When nine.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesLongToDouble(byte[], int, int) with 'byte[]', 'int', 'int'; when nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(byte[], int, int)"})
  void testParseBytesLongToDoubleWithByteIntInt_whenNine() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesLongToDouble("AXAXAXAX".getBytes("UTF-8"), Integer.MIN_VALUE, 9));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(byte[], int)} with {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>Then return {@code 7.1847309230424E13}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesLongToDouble(byte[], int) with 'byte[]', 'int'; then return '7.1847309230424E13'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(byte[], int)"})
  void testParseBytesLongToDoubleWithByteInt_thenReturn71847309230424e13()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(
        7.1847309230424E13d, TbUtils.parseBytesLongToDouble("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(byte[], int)} with {@code byte[]}, {@code int}.
   *
   * <ul>
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBytesLongToDouble(byte[], int) with 'byte[]', 'int'; then throw IllegalArgumentException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(byte[], int)"})
  void testParseBytesLongToDoubleWithByteInt_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesLongToDouble(new byte[] {}, 2));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(List)} with {@code List}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(List)}
   */
  @Test
  @DisplayName("Test parseBytesLongToDouble(List) with 'List'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(List)"})
  void testParseBytesLongToDoubleWithList() {
    // Arrange, Act and Assert
    assertEquals(0.0d, TbUtils.parseBytesLongToDouble(new ArrayList<>()));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(List, int)} with {@code List}, {@code int}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(List, int)}
   */
  @Test
  @DisplayName("Test parseBytesLongToDouble(List, int) with 'List', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(List, int)"})
  void testParseBytesLongToDoubleWithListInt() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class, () -> TbUtils.parseBytesLongToDouble(new ArrayList<>(), 2));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(List, int, int)} with {@code List}, {@code int},
   * {@code int}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(List, int, int)}
   */
  @Test
  @DisplayName("Test parseBytesLongToDouble(List, int, int) with 'List', 'int', 'int'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(List, int, int)"})
  void testParseBytesLongToDoubleWithListIntInt() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesLongToDouble(new ArrayList<>(), 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBytesLongToDouble(List, int, int, boolean)} with {@code List}, {@code
   * int}, {@code int}, {@code boolean}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesLongToDouble(List, int, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseBytesLongToDouble(List, int, int, boolean) with 'List', 'int', 'int', 'boolean'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.parseBytesLongToDouble(List, int, int, boolean)"})
  void testParseBytesLongToDoubleWithListIntIntBoolean() {
    // Arrange, Act and Assert
    assertThrows(
        IllegalArgumentException.class,
        () -> TbUtils.parseBytesLongToDouble(new ArrayList<>(), 2, 3, true));
  }

  /**
   * Test {@link TbUtils#bytesToHex(byte[])} with {@code bytes}.
   *
   * <p>Method under test: {@link TbUtils#bytesToHex(byte[])}
   */
  @Test
  @DisplayName("Test bytesToHex(byte[]) with 'bytes'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.bytesToHex(byte[])"})
  void testBytesToHexWithBytes() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals("4158415841584158", TbUtils.bytesToHex("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TbUtils#toFixed(double, int)} with {@code double}, {@code int}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFixed(double, int)}
   */
  @Test
  @DisplayName("Test toFixed(double, int) with 'double', 'int'; when '0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.toFixed(double, int)"})
  void testToFixedWithDoubleInt_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(0.5d, TbUtils.toFixed(0.5d, 3));
  }

  /**
   * Test {@link TbUtils#toFixed(double, int)} with {@code double}, {@code int}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFixed(double, int)}
   */
  @Test
  @DisplayName("Test toFixed(double, int) with 'double', 'int'; when '-0.5'; then return '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.toFixed(double, int)"})
  void testToFixedWithDoubleInt_when05_thenReturn052() {
    // Arrange, Act and Assert
    assertEquals(-0.5d, TbUtils.toFixed(-0.5d, 3));
  }

  /**
   * Test {@link TbUtils#toFixed(double, int)} with {@code double}, {@code int}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFixed(double, int)}
   */
  @Test
  @DisplayName("Test toFixed(double, int) with 'double', 'int'; when one; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.toFixed(double, int)"})
  void testToFixedWithDoubleInt_whenOne_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0d, TbUtils.toFixed(10.0d, 1));
  }

  /**
   * Test {@link TbUtils#toFixed(double, int)} with {@code double}, {@code int}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFixed(double, int)}
   */
  @Test
  @DisplayName("Test toFixed(double, int) with 'double', 'int'; when ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"double TbUtils.toFixed(double, int)"})
  void testToFixedWithDoubleInt_whenTen_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0d, TbUtils.toFixed(10.0d, 3));
  }

  /**
   * Test {@link TbUtils#toFixed(float, int)} with {@code float}, {@code int}.
   *
   * <ul>
   *   <li>When {@code 0.5}.
   *   <li>Then return {@code 0.5}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFixed(float, int)}
   */
  @Test
  @DisplayName("Test toFixed(float, int) with 'float', 'int'; when '0.5'; then return '0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.toFixed(float, int)"})
  void testToFixedWithFloatInt_when05_thenReturn05() {
    // Arrange, Act and Assert
    assertEquals(0.5f, TbUtils.toFixed(0.5f, 3));
  }

  /**
   * Test {@link TbUtils#toFixed(float, int)} with {@code float}, {@code int}.
   *
   * <ul>
   *   <li>When {@code -0.5}.
   *   <li>Then return {@code -0.5}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFixed(float, int)}
   */
  @Test
  @DisplayName("Test toFixed(float, int) with 'float', 'int'; when '-0.5'; then return '-0.5'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.toFixed(float, int)"})
  void testToFixedWithFloatInt_when05_thenReturn052() {
    // Arrange, Act and Assert
    assertEquals(-0.5f, TbUtils.toFixed(-0.5f, 3));
  }

  /**
   * Test {@link TbUtils#toFixed(float, int)} with {@code float}, {@code int}.
   *
   * <ul>
   *   <li>When one.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFixed(float, int)}
   */
  @Test
  @DisplayName("Test toFixed(float, int) with 'float', 'int'; when one; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.toFixed(float, int)"})
  void testToFixedWithFloatInt_whenOne_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, TbUtils.toFixed(10.0f, 1));
  }

  /**
   * Test {@link TbUtils#toFixed(float, int)} with {@code float}, {@code int}.
   *
   * <ul>
   *   <li>When ten.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFixed(float, int)}
   */
  @Test
  @DisplayName("Test toFixed(float, int) with 'float', 'int'; when ten; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"float TbUtils.toFixed(float, int)"})
  void testToFixedWithFloatInt_whenTen_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10.0f, TbUtils.toFixed(10.0f, 3));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map)} with {@code ctx}, {@code json}.
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map)}
   */
  @Test
  @DisplayName("Test toFlatMap(ExecutionContext, Map) with 'ctx', 'json'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map)"})
  void testToFlatMapWithCtxJson() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode(), 16L);

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", "42");

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List)} with {@code ctx}, {@code json},
   * {@code excludeList}.
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List)}
   */
  @Test
  @DisplayName("Test toFlatMap(ExecutionContext, Map, List) with 'ctx', 'json', 'excludeList'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List)"})
  void testToFlatMapWithCtxJsonExcludeList() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode(), 16L);

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", "42");

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>());

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)} with {@code ctx}, {@code
   * json}, {@code excludeList}, {@code pathInKey}.
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List, boolean) with 'ctx', 'json', 'excludeList', 'pathInKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List, boolean)"})
  void testToFlatMapWithCtxJsonExcludeListPathInKey() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode(), 16L);

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", "42");

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>(), true);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)} with {@code ctx}, {@code
   * json}, {@code excludeList}, {@code pathInKey}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>Then return {@code foo} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List, boolean) with 'ctx', 'json', 'excludeList', 'pathInKey'; given '42'; then return 'foo' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List, boolean)"})
  void testToFlatMapWithCtxJsonExcludeListPathInKey_given42_thenReturnFooIs42() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", "42");

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>(), true);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)} with {@code ctx}, {@code
   * json}, {@code excludeList}, {@code pathInKey}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List, boolean) with 'ctx', 'json', 'excludeList', 'pathInKey'; given ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List, boolean)"})
  void testToFlatMapWithCtxJsonExcludeListPathInKey_givenArrayList() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", new ArrayList<>());

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>(), true);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)} with {@code ctx}, {@code
   * json}, {@code excludeList}, {@code pathInKey}.
   *
   * <ul>
   *   <li>Given empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List, boolean) with 'ctx', 'json', 'excludeList', 'pathInKey'; given empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List, boolean)"})
  void testToFlatMapWithCtxJsonExcludeListPathInKey_givenEmptyString() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", "42");

    ArrayList<String> excludeList = new ArrayList<>();
    excludeList.add("");
    excludeList.add("foo");

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, excludeList, true);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)} with {@code ctx}, {@code
   * json}, {@code excludeList}, {@code pathInKey}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List, boolean) with 'ctx', 'json', 'excludeList', 'pathInKey'; given HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List, boolean)"})
  void testToFlatMapWithCtxJsonExcludeListPathInKey_givenHashSet_thenReturnEmpty() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", new HashSet<>());

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>(), true);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)} with {@code ctx}, {@code
   * json}, {@code excludeList}, {@code pathInKey}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List, boolean) with 'ctx', 'json', 'excludeList', 'pathInKey'; given 'null'; when HashMap() 'foo' is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List, boolean)"})
  void testToFlatMapWithCtxJsonExcludeListPathInKey_givenNull_whenHashMapFooIsNull() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", null);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>(), true);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)} with {@code ctx}, {@code
   * json}, {@code excludeList}, {@code pathInKey}.
   *
   * <ul>
   *   <li>Then return {@code foo.0} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List, boolean) with 'ctx', 'json', 'excludeList', 'pathInKey'; then return 'foo.0' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List, boolean)"})
  void testToFlatMapWithCtxJsonExcludeListPathInKey_thenReturnFoo0Is42() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add("42");

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", objectSet);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>(), true);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo.0"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)} with {@code ctx}, {@code
   * json}, {@code excludeList}, {@code pathInKey}.
   *
   * <ul>
   *   <li>Then return {@code foo.0.42} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List, boolean) with 'ctx', 'json', 'excludeList', 'pathInKey'; then return 'foo.0.42' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List, boolean)"})
  void testToFlatMapWithCtxJsonExcludeListPathInKey_thenReturnFoo042Is42() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(new SimpleEntry<>("42", "42"));

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", objectSet);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>(), true);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo.0.42"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)} with {@code ctx}, {@code
   * json}, {@code excludeList}, {@code pathInKey}.
   *
   * <ul>
   *   <li>Then return {@code foo} intValue is {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List, boolean) with 'ctx', 'json', 'excludeList', 'pathInKey'; then return 'foo' intValue is SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List, boolean)"})
  void testToFlatMapWithCtxJsonExcludeListPathInKey_thenReturnFooIntValueIsSize() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", Short.SIZE);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>(), true);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals(Short.SIZE, ((Integer) actualToFlatMapResult.get("foo")).intValue());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)} with {@code ctx}, {@code
   * json}, {@code excludeList}, {@code pathInKey}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List, boolean) with 'ctx', 'json', 'excludeList', 'pathInKey'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List, boolean)"})
  void testToFlatMapWithCtxJsonExcludeListPathInKey_thenThrowNumberFormatException() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    RemovalNotification<Object, Object> removalNotification = mock(RemovalNotification.class);
    when(removalNotification.getKey()).thenThrow(new NumberFormatException());

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(removalNotification);

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", objectSet);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> TbUtils.toFlatMap(ctx, json, new ArrayList<>(), true));
    verify(removalNotification).getKey();
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)} with {@code ctx}, {@code
   * json}, {@code excludeList}, {@code pathInKey}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List, boolean) with 'ctx', 'json', 'excludeList', 'pathInKey'; when ArrayList() add 'foo'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List, boolean)"})
  void testToFlatMapWithCtxJsonExcludeListPathInKey_whenArrayListAddFoo_thenReturnEmpty() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", "42");

    ArrayList<String> excludeList = new ArrayList<>();
    excludeList.add("foo");

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, excludeList, true);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)} with {@code ctx}, {@code
   * json}, {@code excludeList}, {@code pathInKey}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List, boolean) with 'ctx', 'json', 'excludeList', 'pathInKey'; when HashMap(); then return HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List, boolean)"})
  void testToFlatMapWithCtxJsonExcludeListPathInKey_whenHashMap_thenReturnHashMap() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());
    HashMap<String, Object> json = new HashMap<>();

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>(), true);

    // Assert
    assertEquals(json, actualToFlatMapResult);
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List)} with {@code ctx}, {@code json},
   * {@code excludeList}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link ArrayList#ArrayList()} add {@code foo}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List) with 'ctx', 'json', 'excludeList'; given '42'; when ArrayList() add 'foo'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List)"})
  void testToFlatMapWithCtxJsonExcludeList_given42_whenArrayListAddFoo_thenReturnEmpty() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", "42");

    ArrayList<String> excludeList = new ArrayList<>();
    excludeList.add("foo");

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, excludeList);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List)} with {@code ctx}, {@code json},
   * {@code excludeList}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.
   *   <li>Then return {@code foo} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List) with 'ctx', 'json', 'excludeList'; given '42'; when HashMap() 'foo' is '42'; then return 'foo' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List)"})
  void testToFlatMapWithCtxJsonExcludeList_given42_whenHashMapFooIs42_thenReturnFooIs42() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", "42");

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>());

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List)} with {@code ctx}, {@code json},
   * {@code excludeList}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List) with 'ctx', 'json', 'excludeList'; given ArrayList(); when HashMap() 'foo' is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List)"})
  void testToFlatMapWithCtxJsonExcludeList_givenArrayList_whenHashMapFooIsArrayList() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", new ArrayList<>());

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>());

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List)} with {@code ctx}, {@code json},
   * {@code excludeList}.
   *
   * <ul>
   *   <li>Given empty string.
   *   <li>When {@link ArrayList#ArrayList()} add empty string.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List) with 'ctx', 'json', 'excludeList'; given empty string; when ArrayList() add empty string")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List)"})
  void testToFlatMapWithCtxJsonExcludeList_givenEmptyString_whenArrayListAddEmptyString() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", "42");

    ArrayList<String> excludeList = new ArrayList<>();
    excludeList.add("");
    excludeList.add("foo");

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, excludeList);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List)} with {@code ctx}, {@code json},
   * {@code excludeList}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@code foo.0} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List) with 'ctx', 'json', 'excludeList'; given HashSet() add '42'; then return 'foo.0' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List)"})
  void testToFlatMapWithCtxJsonExcludeList_givenHashSetAdd42_thenReturnFoo0Is42() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add("42");

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", objectSet);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>());

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo.0"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List)} with {@code ctx}, {@code json},
   * {@code excludeList}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List) with 'ctx', 'json', 'excludeList'; given HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List)"})
  void testToFlatMapWithCtxJsonExcludeList_givenHashSet_thenReturnEmpty() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", new HashSet<>());

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>());

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List)} with {@code ctx}, {@code json},
   * {@code excludeList}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List) with 'ctx', 'json', 'excludeList'; given 'null'; when HashMap() 'foo' is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List)"})
  void testToFlatMapWithCtxJsonExcludeList_givenNull_whenHashMapFooIsNull() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", null);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>());

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List)} with {@code ctx}, {@code json},
   * {@code excludeList}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return {@code foo} intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List) with 'ctx', 'json', 'excludeList'; given one; then return 'foo' intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List)"})
  void testToFlatMapWithCtxJsonExcludeList_givenOne_thenReturnFooIntValueIsOne() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", 1);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>());

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals(1, ((Integer) actualToFlatMapResult.get("foo")).intValue());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List)} with {@code ctx}, {@code json},
   * {@code excludeList}.
   *
   * <ul>
   *   <li>Then return {@code foo.0.42} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List) with 'ctx', 'json', 'excludeList'; then return 'foo.0.42' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List)"})
  void testToFlatMapWithCtxJsonExcludeList_thenReturnFoo042Is42() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(new SimpleEntry<>("42", "42"));

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", objectSet);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>());

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo.0.42"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List)} with {@code ctx}, {@code json},
   * {@code excludeList}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List) with 'ctx', 'json', 'excludeList'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List)"})
  void testToFlatMapWithCtxJsonExcludeList_thenThrowNumberFormatException() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    RemovalNotification<Object, Object> removalNotification = mock(RemovalNotification.class);
    when(removalNotification.getKey()).thenThrow(new NumberFormatException());

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(removalNotification);

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", objectSet);

    // Act and Assert
    assertThrows(
        NumberFormatException.class, () -> TbUtils.toFlatMap(ctx, json, new ArrayList<>()));
    verify(removalNotification).getKey();
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, List)} with {@code ctx}, {@code json},
   * {@code excludeList}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, List)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, List) with 'ctx', 'json', 'excludeList'; when HashMap(); then return HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, List)"})
  void testToFlatMapWithCtxJsonExcludeList_whenHashMap_thenReturnHashMap() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());
    HashMap<String, Object> json = new HashMap<>();

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult =
        TbUtils.toFlatMap(ctx, json, new ArrayList<>());

    // Assert
    assertEquals(json, actualToFlatMapResult);
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)} with {@code ctx}, {@code json},
   * {@code pathInKey}.
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)}
   */
  @Test
  @DisplayName("Test toFlatMap(ExecutionContext, Map, boolean) with 'ctx', 'json', 'pathInKey'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, boolean)"})
  void testToFlatMapWithCtxJsonPathInKey() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode(), 16L);

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", "42");

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json, true);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)} with {@code ctx}, {@code json},
   * {@code pathInKey}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.
   *   <li>Then return {@code foo} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, boolean) with 'ctx', 'json', 'pathInKey'; given '42'; when HashMap() 'foo' is '42'; then return 'foo' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, boolean)"})
  void testToFlatMapWithCtxJsonPathInKey_given42_whenHashMapFooIs42_thenReturnFooIs42() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", "42");

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json, true);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)} with {@code ctx}, {@code json},
   * {@code pathInKey}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, boolean) with 'ctx', 'json', 'pathInKey'; given ArrayList(); when HashMap() 'foo' is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, boolean)"})
  void testToFlatMapWithCtxJsonPathInKey_givenArrayList_whenHashMapFooIsArrayList() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", new ArrayList<>());

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json, true);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)} with {@code ctx}, {@code json},
   * {@code pathInKey}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@code foo.0} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, boolean) with 'ctx', 'json', 'pathInKey'; given HashSet() add '42'; then return 'foo.0' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, boolean)"})
  void testToFlatMapWithCtxJsonPathInKey_givenHashSetAdd42_thenReturnFoo0Is42() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add("42");

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", objectSet);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json, true);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo.0"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)} with {@code ctx}, {@code json},
   * {@code pathInKey}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, boolean) with 'ctx', 'json', 'pathInKey'; given HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, boolean)"})
  void testToFlatMapWithCtxJsonPathInKey_givenHashSet_thenReturnEmpty() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", new HashSet<>());

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json, true);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)} with {@code ctx}, {@code json},
   * {@code pathInKey}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, boolean) with 'ctx', 'json', 'pathInKey'; given 'null'; when HashMap() 'foo' is 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, boolean)"})
  void testToFlatMapWithCtxJsonPathInKey_givenNull_whenHashMapFooIsNull_thenReturnEmpty() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", null);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json, true);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)} with {@code ctx}, {@code json},
   * {@code pathInKey}.
   *
   * <ul>
   *   <li>Given {@link Short#SIZE}.
   *   <li>Then return {@code foo} intValue is {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, boolean) with 'ctx', 'json', 'pathInKey'; given SIZE; then return 'foo' intValue is SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, boolean)"})
  void testToFlatMapWithCtxJsonPathInKey_givenSize_thenReturnFooIntValueIsSize() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", Short.SIZE);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json, true);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals(Short.SIZE, ((Integer) actualToFlatMapResult.get("foo")).intValue());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)} with {@code ctx}, {@code json},
   * {@code pathInKey}.
   *
   * <ul>
   *   <li>Then return {@code foo.0.42} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, boolean) with 'ctx', 'json', 'pathInKey'; then return 'foo.0.42' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, boolean)"})
  void testToFlatMapWithCtxJsonPathInKey_thenReturnFoo042Is42() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(new SimpleEntry<>("42", "42"));

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", objectSet);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json, true);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo.0.42"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)} with {@code ctx}, {@code json},
   * {@code pathInKey}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, boolean) with 'ctx', 'json', 'pathInKey'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, boolean)"})
  void testToFlatMapWithCtxJsonPathInKey_thenThrowNumberFormatException() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    RemovalNotification<Object, Object> removalNotification = mock(RemovalNotification.class);
    when(removalNotification.getKey()).thenThrow(new NumberFormatException());

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(removalNotification);

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", objectSet);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.toFlatMap(ctx, json, true));
    verify(removalNotification).getKey();
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)} with {@code ctx}, {@code json},
   * {@code pathInKey}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map, boolean)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map, boolean) with 'ctx', 'json', 'pathInKey'; when HashMap(); then return HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map, boolean)"})
  void testToFlatMapWithCtxJsonPathInKey_whenHashMap_thenReturnHashMap() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());
    HashMap<String, Object> json = new HashMap<>();

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json, true);

    // Assert
    assertEquals(json, actualToFlatMapResult);
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map)} with {@code ctx}, {@code json}.
   *
   * <ul>
   *   <li>Given {@code 42}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code 42}.
   *   <li>Then return {@code foo} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map) with 'ctx', 'json'; given '42'; when HashMap() 'foo' is '42'; then return 'foo' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map)"})
  void testToFlatMapWithCtxJson_given42_whenHashMapFooIs42_thenReturnFooIs42() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", "42");

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map)} with {@code ctx}, {@code json}.
   *
   * <ul>
   *   <li>Given {@link ArrayList#ArrayList()}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@link ArrayList#ArrayList()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map) with 'ctx', 'json'; given ArrayList(); when HashMap() 'foo' is ArrayList()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map)"})
  void testToFlatMapWithCtxJson_givenArrayList_whenHashMapFooIsArrayList() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", new ArrayList<>());

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map)} with {@code ctx}, {@code json}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()} add {@code 42}.
   *   <li>Then return {@code foo.0} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map) with 'ctx', 'json'; given HashSet() add '42'; then return 'foo.0' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map)"})
  void testToFlatMapWithCtxJson_givenHashSetAdd42_thenReturnFoo0Is42() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add("42");

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", objectSet);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo.0"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map)} with {@code ctx}, {@code json}.
   *
   * <ul>
   *   <li>Given {@link HashSet#HashSet()}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@link HashSet#HashSet()}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map) with 'ctx', 'json'; given HashSet(); when HashMap() 'foo' is HashSet(); then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map)"})
  void testToFlatMapWithCtxJson_givenHashSet_whenHashMapFooIsHashSet_thenReturnEmpty() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", new HashSet<>());

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map)} with {@code ctx}, {@code json}.
   *
   * <ul>
   *   <li>Given {@code null}.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is {@code null}.
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map) with 'ctx', 'json'; given 'null'; when HashMap() 'foo' is 'null'; then return Empty")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map)"})
  void testToFlatMapWithCtxJson_givenNull_whenHashMapFooIsNull_thenReturnEmpty() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", null);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json);

    // Assert
    assertTrue(actualToFlatMapResult.isEmpty());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map)} with {@code ctx}, {@code json}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>When {@link HashMap#HashMap()} {@code foo} is one.
   *   <li>Then return {@code foo} intValue is one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map) with 'ctx', 'json'; given one; when HashMap() 'foo' is one; then return 'foo' intValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map)"})
  void testToFlatMapWithCtxJson_givenOne_whenHashMapFooIsOne_thenReturnFooIntValueIsOne() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", 1);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals(1, ((Integer) actualToFlatMapResult.get("foo")).intValue());
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map)} with {@code ctx}, {@code json}.
   *
   * <ul>
   *   <li>Then return {@code foo.0.42} is {@code 42}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map) with 'ctx', 'json'; then return 'foo.0.42' is '42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map)"})
  void testToFlatMapWithCtxJson_thenReturnFoo042Is42() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(new SimpleEntry<>("42", "42"));

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", objectSet);

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json);

    // Assert
    assertEquals(1, actualToFlatMapResult.size());
    assertEquals("42", actualToFlatMapResult.get("foo.0.42"));
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map)} with {@code ctx}, {@code json}.
   *
   * <ul>
   *   <li>Then throw {@link NumberFormatException}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map) with 'ctx', 'json'; then throw NumberFormatException")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map)"})
  void testToFlatMapWithCtxJson_thenThrowNumberFormatException() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());

    RemovalNotification<Object, Object> removalNotification = mock(RemovalNotification.class);
    when(removalNotification.getKey()).thenThrow(new NumberFormatException());

    HashSet<Object> objectSet = new HashSet<>();
    objectSet.add(removalNotification);

    HashMap<String, Object> json = new HashMap<>();
    json.put("foo", objectSet);

    // Act and Assert
    assertThrows(NumberFormatException.class, () -> TbUtils.toFlatMap(ctx, json));
    verify(removalNotification).getKey();
  }

  /**
   * Test {@link TbUtils#toFlatMap(ExecutionContext, Map)} with {@code ctx}, {@code json}.
   *
   * <ul>
   *   <li>When {@link HashMap#HashMap()}.
   *   <li>Then return {@link HashMap#HashMap()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#toFlatMap(ExecutionContext, Map)}
   */
  @Test
  @DisplayName(
      "Test toFlatMap(ExecutionContext, Map) with 'ctx', 'json'; when HashMap(); then return HashMap()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"ExecutionHashMap TbUtils.toFlatMap(ExecutionContext, Map)"})
  void testToFlatMapWithCtxJson_whenHashMap_thenReturnHashMap() {
    // Arrange
    ExecutionContext ctx = new ExecutionContext(ParserContext.enableSandboxedMode());
    HashMap<String, Object> json = new HashMap<>();

    // Act
    ExecutionHashMap<String, Object> actualToFlatMapResult = TbUtils.toFlatMap(ctx, json);

    // Assert
    assertEquals(json, actualToFlatMapResult);
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #0123456789ABCDEF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); then return decodeURI is '#0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIs0123456789abcdef() {
    // Arrange, Act and Assert
    assertEquals("#0123456789ABCDEF", TbUtils.decodeURI(TbUtils.encodeURI("#0123456789ABCDEF")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $0123456789ABCDEF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); then return decodeURI is '$0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIs0123456789abcdef2() {
    // Arrange, Act and Assert
    assertEquals("$0123456789ABCDEF", TbUtils.decodeURI(TbUtils.encodeURI("$0123456789ABCDEF")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code +0123456789ABCDEF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); then return decodeURI is '+0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIs0123456789abcdef3() {
    // Arrange, Act and Assert
    assertEquals("+0123456789ABCDEF", TbUtils.decodeURI(TbUtils.encodeURI("+0123456789ABCDEF")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =0123456789ABCDEF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); then return decodeURI is '=0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIs0123456789abcdef4() {
    // Arrange, Act and Assert
    assertEquals("=0123456789ABCDEF", TbUtils.decodeURI(TbUtils.encodeURI("=0123456789ABCDEF")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code &0123456789ABCDEF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); then return decodeURI is '&0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIs0123456789abcdef5() {
    // Arrange, Act and Assert
    assertEquals("&0123456789ABCDEF", TbUtils.decodeURI(TbUtils.encodeURI("&0123456789ABCDEF")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @0123456789ABCDEF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); then return decodeURI is '@0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIs0123456789abcdef6() {
    // Arrange, Act and Assert
    assertEquals("@0123456789ABCDEF", TbUtils.decodeURI(TbUtils.encodeURI("@0123456789ABCDEF")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code :0123456789ABCDEF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); then return decodeURI is ':0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIs0123456789abcdef7() {
    // Arrange, Act and Assert
    assertEquals(":0123456789ABCDEF", TbUtils.decodeURI(TbUtils.encodeURI(":0123456789ABCDEF")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?0123456789ABCDEF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); then return decodeURI is '?0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIs0123456789abcdef8() {
    // Arrange, Act and Assert
    assertEquals("?0123456789ABCDEF", TbUtils.decodeURI(TbUtils.encodeURI("?0123456789ABCDEF")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code /0123456789ABCDEF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); then return decodeURI is '/0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIs0123456789abcdef9() {
    // Arrange, Act and Assert
    assertEquals("/0123456789ABCDEF", TbUtils.decodeURI(TbUtils.encodeURI("/0123456789ABCDEF")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ,0123456789ABCDEF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); then return decodeURI is ',0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIs0123456789abcdef10() {
    // Arrange, Act and Assert
    assertEquals(",0123456789ABCDEF", TbUtils.decodeURI(TbUtils.encodeURI(",0123456789ABCDEF")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ;0123456789ABCDEF}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); then return decodeURI is ';0123456789ABCDEF'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIs0123456789abcdef11() {
    // Arrange, Act and Assert
    assertEquals(";0123456789ABCDEF", TbUtils.decodeURI(TbUtils.encodeURI(";0123456789ABCDEF")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code &&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '&&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsAmpersandAmpersand() {
    // Arrange, Act and Assert
    assertEquals("&&", TbUtils.decodeURI(TbUtils.encodeURI("&&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code &@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '&@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsAmpersandCommercialAt() {
    // Arrange, Act and Assert
    assertEquals("&@", TbUtils.decodeURI(TbUtils.encodeURI("&@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code &$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '&$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsAmpersandDollarSign() {
    // Arrange, Act and Assert
    assertEquals("&$", TbUtils.decodeURI(TbUtils.encodeURI("&$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code &=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '&='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsAmpersandEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("&=", TbUtils.decodeURI(TbUtils.encodeURI("&=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code &#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '&#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsAmpersandNumberSign() {
    // Arrange, Act and Assert
    assertEquals("&#", TbUtils.decodeURI(TbUtils.encodeURI("&#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code &+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '&+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsAmpersandPlusSign() {
    // Arrange, Act and Assert
    assertEquals("&+", TbUtils.decodeURI(TbUtils.encodeURI("&+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code &?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '&?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsAmpersandQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("&?", TbUtils.decodeURI(TbUtils.encodeURI("&?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code &)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '&)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsAmpersandRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("&)", TbUtils.decodeURI(TbUtils.encodeURI("&)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code &;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '&;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsAmpersandSemicolon() {
    // Arrange, Act and Assert
    assertEquals("&;", TbUtils.decodeURI(TbUtils.encodeURI("&;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code :@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ':@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsColonCommercialAt() {
    // Arrange, Act and Assert
    assertEquals(":@", TbUtils.decodeURI(TbUtils.encodeURI(":@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code :$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ':$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsColonDollarSign() {
    // Arrange, Act and Assert
    assertEquals(":$", TbUtils.decodeURI(TbUtils.encodeURI(":$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code :=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ':='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsColonEqualsSign() {
    // Arrange, Act and Assert
    assertEquals(":=", TbUtils.decodeURI(TbUtils.encodeURI(":=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code :#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ':#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsColonNumberSign() {
    // Arrange, Act and Assert
    assertEquals(":#", TbUtils.decodeURI(TbUtils.encodeURI(":#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code :?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ':?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsColonQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(":?", TbUtils.decodeURI(TbUtils.encodeURI(":?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code :)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ':)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsColonRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals(":)", TbUtils.decodeURI(TbUtils.encodeURI(":)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ,@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ',@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommaCommercialAt() {
    // Arrange, Act and Assert
    assertEquals(",@", TbUtils.decodeURI(TbUtils.encodeURI(",@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ,$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ',$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommaDollarSign() {
    // Arrange, Act and Assert
    assertEquals(",$", TbUtils.decodeURI(TbUtils.encodeURI(",$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ,=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ',='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommaEqualsSign() {
    // Arrange, Act and Assert
    assertEquals(",=", TbUtils.decodeURI(TbUtils.encodeURI(",=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ,#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ',#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommaNumberSign() {
    // Arrange, Act and Assert
    assertEquals(",#", TbUtils.decodeURI(TbUtils.encodeURI(",#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ,?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ',?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommaQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(",?", TbUtils.decodeURI(TbUtils.encodeURI(",?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ,)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ',)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommaRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals(",)", TbUtils.decodeURI(TbUtils.encodeURI(",)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtAmpersand() {
    // Arrange, Act and Assert
    assertEquals("@&", TbUtils.decodeURI(TbUtils.encodeURI("@&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtColon() {
    // Arrange, Act and Assert
    assertEquals("@:", TbUtils.decodeURI(TbUtils.encodeURI("@:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtComma() {
    // Arrange, Act and Assert
    assertEquals("@,", TbUtils.decodeURI(TbUtils.encodeURI("@,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtCommercialAt() {
    // Arrange, Act and Assert
    assertEquals("@@", TbUtils.decodeURI(TbUtils.encodeURI("@@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @-}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtDash() {
    // Arrange, Act and Assert
    assertEquals("@-", TbUtils.decodeURI(TbUtils.encodeURI("@-")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtDollarSign() {
    // Arrange, Act and Assert
    assertEquals("@$", TbUtils.decodeURI(TbUtils.encodeURI("@$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @.}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtDot() {
    // Arrange, Act and Assert
    assertEquals("@.", TbUtils.decodeURI(TbUtils.encodeURI("@.")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("@=", TbUtils.decodeURI(TbUtils.encodeURI("@=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtNumberSign() {
    // Arrange, Act and Assert
    assertEquals("@#", TbUtils.decodeURI(TbUtils.encodeURI("@#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtPlusSign() {
    // Arrange, Act and Assert
    assertEquals("@+", TbUtils.decodeURI(TbUtils.encodeURI("@+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("@?", TbUtils.decodeURI(TbUtils.encodeURI("@?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("@)", TbUtils.decodeURI(TbUtils.encodeURI("@)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtSemicolon() {
    // Arrange, Act and Assert
    assertEquals("@;", TbUtils.decodeURI(TbUtils.encodeURI("@;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtSlash() {
    // Arrange, Act and Assert
    assertEquals("@/", TbUtils.decodeURI(TbUtils.encodeURI("@/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code @~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '@~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsCommercialAtTilde() {
    // Arrange, Act and Assert
    assertEquals("@~", TbUtils.decodeURI(TbUtils.encodeURI("@~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code -@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '-@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDashCommercialAt() {
    // Arrange, Act and Assert
    assertEquals("-@", TbUtils.decodeURI(TbUtils.encodeURI("-@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code -?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '-?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDashQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("-?", TbUtils.decodeURI(TbUtils.encodeURI("-?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code -)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '-)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDashRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("-)", TbUtils.decodeURI(TbUtils.encodeURI("-)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignAmpersand() {
    // Arrange, Act and Assert
    assertEquals("$&", TbUtils.decodeURI(TbUtils.encodeURI("$&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignColon() {
    // Arrange, Act and Assert
    assertEquals("$:", TbUtils.decodeURI(TbUtils.encodeURI("$:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignComma() {
    // Arrange, Act and Assert
    assertEquals("$,", TbUtils.decodeURI(TbUtils.encodeURI("$,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignCommercialAt() {
    // Arrange, Act and Assert
    assertEquals("$@", TbUtils.decodeURI(TbUtils.encodeURI("$@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignDollarSign() {
    // Arrange, Act and Assert
    assertEquals("$$", TbUtils.decodeURI(TbUtils.encodeURI("$$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("$=", TbUtils.decodeURI(TbUtils.encodeURI("$=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignNumberSign() {
    // Arrange, Act and Assert
    assertEquals("$#", TbUtils.decodeURI(TbUtils.encodeURI("$#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignPlusSign() {
    // Arrange, Act and Assert
    assertEquals("$+", TbUtils.decodeURI(TbUtils.encodeURI("$+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("$?", TbUtils.decodeURI(TbUtils.encodeURI("$?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("$)", TbUtils.decodeURI(TbUtils.encodeURI("$)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignSemicolon() {
    // Arrange, Act and Assert
    assertEquals("$;", TbUtils.decodeURI(TbUtils.encodeURI("$;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignSlash() {
    // Arrange, Act and Assert
    assertEquals("$/", TbUtils.decodeURI(TbUtils.encodeURI("$/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code $~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '$~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsDollarSignTilde() {
    // Arrange, Act and Assert
    assertEquals("$~", TbUtils.decodeURI(TbUtils.encodeURI("$~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignAmpersand() {
    // Arrange, Act and Assert
    assertEquals("=&", TbUtils.decodeURI(TbUtils.encodeURI("=&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignColon() {
    // Arrange, Act and Assert
    assertEquals("=:", TbUtils.decodeURI(TbUtils.encodeURI("=:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignComma() {
    // Arrange, Act and Assert
    assertEquals("=,", TbUtils.decodeURI(TbUtils.encodeURI("=,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignCommercialAt() {
    // Arrange, Act and Assert
    assertEquals("=@", TbUtils.decodeURI(TbUtils.encodeURI("=@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignDollarSign() {
    // Arrange, Act and Assert
    assertEquals("=$", TbUtils.decodeURI(TbUtils.encodeURI("=$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ==}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("==", TbUtils.decodeURI(TbUtils.encodeURI("==")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignNumberSign() {
    // Arrange, Act and Assert
    assertEquals("=#", TbUtils.decodeURI(TbUtils.encodeURI("=#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignPlusSign() {
    // Arrange, Act and Assert
    assertEquals("=+", TbUtils.decodeURI(TbUtils.encodeURI("=+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("=?", TbUtils.decodeURI(TbUtils.encodeURI("=?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("=)", TbUtils.decodeURI(TbUtils.encodeURI("=)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignSemicolon() {
    // Arrange, Act and Assert
    assertEquals("=;", TbUtils.decodeURI(TbUtils.encodeURI("=;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignSlash() {
    // Arrange, Act and Assert
    assertEquals("=/", TbUtils.decodeURI(TbUtils.encodeURI("=/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code =~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '=~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsEqualsSignTilde() {
    // Arrange, Act and Assert
    assertEquals("=~", TbUtils.decodeURI(TbUtils.encodeURI("=~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '#&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignAmpersand() {
    // Arrange, Act and Assert
    assertEquals("#&", TbUtils.decodeURI(TbUtils.encodeURI("#&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '#:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignColon() {
    // Arrange, Act and Assert
    assertEquals("#:", TbUtils.decodeURI(TbUtils.encodeURI("#:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '#,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignComma() {
    // Arrange, Act and Assert
    assertEquals("#,", TbUtils.decodeURI(TbUtils.encodeURI("#,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '#@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignCommercialAt() {
    // Arrange, Act and Assert
    assertEquals("#@", TbUtils.decodeURI(TbUtils.encodeURI("#@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '#$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignDollarSign() {
    // Arrange, Act and Assert
    assertEquals("#$", TbUtils.decodeURI(TbUtils.encodeURI("#$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '#='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("#=", TbUtils.decodeURI(TbUtils.encodeURI("#=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ##}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '##'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignNumberSign() {
    // Arrange, Act and Assert
    assertEquals("##", TbUtils.decodeURI(TbUtils.encodeURI("##")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '#+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignPlusSign() {
    // Arrange, Act and Assert
    assertEquals("#+", TbUtils.decodeURI(TbUtils.encodeURI("#+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '#?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("#?", TbUtils.decodeURI(TbUtils.encodeURI("#?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '#)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("#)", TbUtils.decodeURI(TbUtils.encodeURI("#)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '#;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignSemicolon() {
    // Arrange, Act and Assert
    assertEquals("#;", TbUtils.decodeURI(TbUtils.encodeURI("#;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '#/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignSlash() {
    // Arrange, Act and Assert
    assertEquals("#/", TbUtils.decodeURI(TbUtils.encodeURI("#/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code #~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '#~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsNumberSignTilde() {
    // Arrange, Act and Assert
    assertEquals("#~", TbUtils.decodeURI(TbUtils.encodeURI("#~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code +&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '+&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsPlusSignAmpersand() {
    // Arrange, Act and Assert
    assertEquals("+&", TbUtils.decodeURI(TbUtils.encodeURI("+&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code +@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '+@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsPlusSignCommercialAt() {
    // Arrange, Act and Assert
    assertEquals("+@", TbUtils.decodeURI(TbUtils.encodeURI("+@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code +$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '+$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsPlusSignDollarSign() {
    // Arrange, Act and Assert
    assertEquals("+$", TbUtils.decodeURI(TbUtils.encodeURI("+$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code +=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '+='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsPlusSignEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("+=", TbUtils.decodeURI(TbUtils.encodeURI("+=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code +#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '+#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsPlusSignNumberSign() {
    // Arrange, Act and Assert
    assertEquals("+#", TbUtils.decodeURI(TbUtils.encodeURI("+#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ++}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '++'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsPlusSignPlusSign() {
    // Arrange, Act and Assert
    assertEquals("++", TbUtils.decodeURI(TbUtils.encodeURI("++")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code +?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '+?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsPlusSignQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("+?", TbUtils.decodeURI(TbUtils.encodeURI("+?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code +)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '+)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsPlusSignRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("+)", TbUtils.decodeURI(TbUtils.encodeURI("+)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code +;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '+;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsPlusSignSemicolon() {
    // Arrange, Act and Assert
    assertEquals("+;", TbUtils.decodeURI(TbUtils.encodeURI("+;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkAmpersand() {
    // Arrange, Act and Assert
    assertEquals("?&", TbUtils.decodeURI(TbUtils.encodeURI("?&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkColon() {
    // Arrange, Act and Assert
    assertEquals("?:", TbUtils.decodeURI(TbUtils.encodeURI("?:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkComma() {
    // Arrange, Act and Assert
    assertEquals("?,", TbUtils.decodeURI(TbUtils.encodeURI("?,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkCommercialAt() {
    // Arrange, Act and Assert
    assertEquals("?@", TbUtils.decodeURI(TbUtils.encodeURI("?@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?-}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkDash() {
    // Arrange, Act and Assert
    assertEquals("?-", TbUtils.decodeURI(TbUtils.encodeURI("?-")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkDollarSign() {
    // Arrange, Act and Assert
    assertEquals("?$", TbUtils.decodeURI(TbUtils.encodeURI("?$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?.}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkDot() {
    // Arrange, Act and Assert
    assertEquals("?.", TbUtils.decodeURI(TbUtils.encodeURI("?.")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("?=", TbUtils.decodeURI(TbUtils.encodeURI("?=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkNumberSign() {
    // Arrange, Act and Assert
    assertEquals("?#", TbUtils.decodeURI(TbUtils.encodeURI("?#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkPlusSign() {
    // Arrange, Act and Assert
    assertEquals("?+", TbUtils.decodeURI(TbUtils.encodeURI("?+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ??}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '??'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("??", TbUtils.decodeURI(TbUtils.encodeURI("??")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("?)", TbUtils.decodeURI(TbUtils.encodeURI("?)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkSemicolon() {
    // Arrange, Act and Assert
    assertEquals("?;", TbUtils.decodeURI(TbUtils.encodeURI("?;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkSlash() {
    // Arrange, Act and Assert
    assertEquals("?/", TbUtils.decodeURI(TbUtils.encodeURI("?/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ?~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '?~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsQuestionMarkTilde() {
    // Arrange, Act and Assert
    assertEquals("?~", TbUtils.decodeURI(TbUtils.encodeURI("?~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code )}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ')'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals(")", TbUtils.decodeURI(TbUtils.encodeURI(")")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ;&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ';&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSemicolonAmpersand() {
    // Arrange, Act and Assert
    assertEquals(";&", TbUtils.decodeURI(TbUtils.encodeURI(";&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ;@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ';@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSemicolonCommercialAt() {
    // Arrange, Act and Assert
    assertEquals(";@", TbUtils.decodeURI(TbUtils.encodeURI(";@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ;$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ';$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSemicolonDollarSign() {
    // Arrange, Act and Assert
    assertEquals(";$", TbUtils.decodeURI(TbUtils.encodeURI(";$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ;=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ';='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSemicolonEqualsSign() {
    // Arrange, Act and Assert
    assertEquals(";=", TbUtils.decodeURI(TbUtils.encodeURI(";=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ;#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ';#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSemicolonNumberSign() {
    // Arrange, Act and Assert
    assertEquals(";#", TbUtils.decodeURI(TbUtils.encodeURI(";#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ;+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ';+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSemicolonPlusSign() {
    // Arrange, Act and Assert
    assertEquals(";+", TbUtils.decodeURI(TbUtils.encodeURI(";+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ;?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ';?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSemicolonQuestionMark() {
    // Arrange, Act and Assert
    assertEquals(";?", TbUtils.decodeURI(TbUtils.encodeURI(";?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ;)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ';)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSemicolonRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals(";)", TbUtils.decodeURI(TbUtils.encodeURI(";)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ;;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is ';;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSemicolonSemicolon() {
    // Arrange, Act and Assert
    assertEquals(";;", TbUtils.decodeURI(TbUtils.encodeURI(";;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code /@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '/@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSlashCommercialAt() {
    // Arrange, Act and Assert
    assertEquals("/@", TbUtils.decodeURI(TbUtils.encodeURI("/@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code /$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '/$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSlashDollarSign() {
    // Arrange, Act and Assert
    assertEquals("/$", TbUtils.decodeURI(TbUtils.encodeURI("/$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code /=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '/='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSlashEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("/=", TbUtils.decodeURI(TbUtils.encodeURI("/=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code /#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '/#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSlashNumberSign() {
    // Arrange, Act and Assert
    assertEquals("/#", TbUtils.decodeURI(TbUtils.encodeURI("/#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code /?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '/?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSlashQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("/?", TbUtils.decodeURI(TbUtils.encodeURI("/?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code /)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '/)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsSlashRightParenthesis() {
    // Arrange, Act and Assert
    assertEquals("/)", TbUtils.decodeURI(TbUtils.encodeURI("/)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ~@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '~@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsTildeCommercialAt() {
    // Arrange, Act and Assert
    assertEquals("~@", TbUtils.decodeURI(TbUtils.encodeURI("~@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ~$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '~$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsTildeDollarSign() {
    // Arrange, Act and Assert
    assertEquals("~$", TbUtils.decodeURI(TbUtils.encodeURI("~$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ~=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '~='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsTildeEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("~=", TbUtils.decodeURI(TbUtils.encodeURI("~=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ~#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '~#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsTildeNumberSign() {
    // Arrange, Act and Assert
    assertEquals("~#", TbUtils.decodeURI(TbUtils.encodeURI("~#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>Then return decodeURI is {@code ~?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test encodeURI(String), and decodeURI(String); then return decodeURI is '~?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_thenReturnDecodeURIIsTildeQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("~?", TbUtils.decodeURI(TbUtils.encodeURI("~?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code #%23}.
   *   <li>Then return decodeURI is {@code #%23}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '#%23'; then return decodeURI is '#%23'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs23() {
    // Arrange, Act and Assert
    assertEquals("#%23", TbUtils.decodeURI(TbUtils.encodeURI("#%23")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code $%23}.
   *   <li>Then return decodeURI is {@code $%23}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '$%23'; then return decodeURI is '$%23'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs232() {
    // Arrange, Act and Assert
    assertEquals("$%23", TbUtils.decodeURI(TbUtils.encodeURI("$%23")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code +%23}.
   *   <li>Then return decodeURI is {@code +%23}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '+%23'; then return decodeURI is '+%23'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs233() {
    // Arrange, Act and Assert
    assertEquals("+%23", TbUtils.decodeURI(TbUtils.encodeURI("+%23")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code =%23}.
   *   <li>Then return decodeURI is {@code =%23}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '=%23'; then return decodeURI is '=%23'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs234() {
    // Arrange, Act and Assert
    assertEquals("=%23", TbUtils.decodeURI(TbUtils.encodeURI("=%23")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code &%23}.
   *   <li>Then return decodeURI is {@code &%23}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '&%23'; then return decodeURI is '&%23'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs235() {
    // Arrange, Act and Assert
    assertEquals("&%23", TbUtils.decodeURI(TbUtils.encodeURI("&%23")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code @%23}.
   *   <li>Then return decodeURI is {@code @%23}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '@%23'; then return decodeURI is '@%23'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs236() {
    // Arrange, Act and Assert
    assertEquals("@%23", TbUtils.decodeURI(TbUtils.encodeURI("@%23")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code :%23}.
   *   <li>Then return decodeURI is {@code :%23}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ':%23'; then return decodeURI is ':%23'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs237() {
    // Arrange, Act and Assert
    assertEquals(":%23", TbUtils.decodeURI(TbUtils.encodeURI(":%23")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ?%23}.
   *   <li>Then return decodeURI is {@code ?%23}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '?%23'; then return decodeURI is '?%23'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs238() {
    // Arrange, Act and Assert
    assertEquals("?%23", TbUtils.decodeURI(TbUtils.encodeURI("?%23")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code /%23}.
   *   <li>Then return decodeURI is {@code /%23}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '/%23'; then return decodeURI is '/%23'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs239() {
    // Arrange, Act and Assert
    assertEquals("/%23", TbUtils.decodeURI(TbUtils.encodeURI("/%23")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23#}.
   *   <li>Then return decodeURI is {@code %23#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23#'; then return decodeURI is '%23#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2310() {
    // Arrange, Act and Assert
    assertEquals("%23#", TbUtils.decodeURI(TbUtils.encodeURI("%23#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23$}.
   *   <li>Then return decodeURI is {@code %23$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23$'; then return decodeURI is '%23$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2311() {
    // Arrange, Act and Assert
    assertEquals("%23$", TbUtils.decodeURI(TbUtils.encodeURI("%23$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23+}.
   *   <li>Then return decodeURI is {@code %23+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23+'; then return decodeURI is '%23+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2312() {
    // Arrange, Act and Assert
    assertEquals("%23+", TbUtils.decodeURI(TbUtils.encodeURI("%23+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23=}.
   *   <li>Then return decodeURI is {@code %23=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23='; then return decodeURI is '%23='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2313() {
    // Arrange, Act and Assert
    assertEquals("%23=", TbUtils.decodeURI(TbUtils.encodeURI("%23=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23&}.
   *   <li>Then return decodeURI is {@code %23&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23&'; then return decodeURI is '%23&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2314() {
    // Arrange, Act and Assert
    assertEquals("%23&", TbUtils.decodeURI(TbUtils.encodeURI("%23&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23@}.
   *   <li>Then return decodeURI is {@code %23@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23@'; then return decodeURI is '%23@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2315() {
    // Arrange, Act and Assert
    assertEquals("%23@", TbUtils.decodeURI(TbUtils.encodeURI("%23@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23:}.
   *   <li>Then return decodeURI is {@code %23:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23:'; then return decodeURI is '%23:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2316() {
    // Arrange, Act and Assert
    assertEquals("%23:", TbUtils.decodeURI(TbUtils.encodeURI("%23:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23?}.
   *   <li>Then return decodeURI is {@code %23?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23?'; then return decodeURI is '%23?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2317() {
    // Arrange, Act and Assert
    assertEquals("%23?", TbUtils.decodeURI(TbUtils.encodeURI("%23?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23/}.
   *   <li>Then return decodeURI is {@code %23/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23/'; then return decodeURI is '%23/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2318() {
    // Arrange, Act and Assert
    assertEquals("%23/", TbUtils.decodeURI(TbUtils.encodeURI("%23/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23,}.
   *   <li>Then return decodeURI is {@code %23,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23,'; then return decodeURI is '%23,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2319() {
    // Arrange, Act and Assert
    assertEquals("%23,", TbUtils.decodeURI(TbUtils.encodeURI("%23,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23;}.
   *   <li>Then return decodeURI is {@code %23;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23;'; then return decodeURI is '%23;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2320() {
    // Arrange, Act and Assert
    assertEquals("%23;", TbUtils.decodeURI(TbUtils.encodeURI("%23;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23~}.
   *   <li>Then return decodeURI is {@code %23~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23~'; then return decodeURI is '%23~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2321() {
    // Arrange, Act and Assert
    assertEquals("%23~", TbUtils.decodeURI(TbUtils.encodeURI("%23~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code %23)}.
   *   <li>Then return decodeURI is {@code %23)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '%23)'; then return decodeURI is '%23)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2322() {
    // Arrange, Act and Assert
    assertEquals("%23)", TbUtils.decodeURI(TbUtils.encodeURI("%23)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,%23}.
   *   <li>Then return decodeURI is {@code ,%23}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ',%23'; then return decodeURI is ',%23'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2323() {
    // Arrange, Act and Assert
    assertEquals(",%23", TbUtils.decodeURI(TbUtils.encodeURI(",%23")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ;%23}.
   *   <li>Then return decodeURI is {@code ;%23}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ';%23'; then return decodeURI is ';%23'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2324() {
    // Arrange, Act and Assert
    assertEquals(";%23", TbUtils.decodeURI(TbUtils.encodeURI(";%23")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ~%23}.
   *   <li>Then return decodeURI is {@code ~%23}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '~%23'; then return decodeURI is '~%23'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when23_thenReturnDecodeURIIs2325() {
    // Arrange, Act and Assert
    assertEquals("~%23", TbUtils.decodeURI(TbUtils.encodeURI("~%23")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code #42}.
   *   <li>Then return decodeURI is {@code #42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '#42'; then return decodeURI is '#42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs42() {
    // Arrange, Act and Assert
    assertEquals("#42", TbUtils.decodeURI(TbUtils.encodeURI("#42")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code $42}.
   *   <li>Then return decodeURI is {@code $42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '$42'; then return decodeURI is '$42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs422() {
    // Arrange, Act and Assert
    assertEquals("$42", TbUtils.decodeURI(TbUtils.encodeURI("$42")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code +42}.
   *   <li>Then return decodeURI is {@code +42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '+42'; then return decodeURI is '+42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs423() {
    // Arrange, Act and Assert
    assertEquals("+42", TbUtils.decodeURI(TbUtils.encodeURI("+42")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code =42}.
   *   <li>Then return decodeURI is {@code =42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '=42'; then return decodeURI is '=42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs424() {
    // Arrange, Act and Assert
    assertEquals("=42", TbUtils.decodeURI(TbUtils.encodeURI("=42")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code &42}.
   *   <li>Then return decodeURI is {@code &42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '&42'; then return decodeURI is '&42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs425() {
    // Arrange, Act and Assert
    assertEquals("&42", TbUtils.decodeURI(TbUtils.encodeURI("&42")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code @42}.
   *   <li>Then return decodeURI is {@code @42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '@42'; then return decodeURI is '@42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs426() {
    // Arrange, Act and Assert
    assertEquals("@42", TbUtils.decodeURI(TbUtils.encodeURI("@42")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code :42}.
   *   <li>Then return decodeURI is {@code :42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ':42'; then return decodeURI is ':42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs427() {
    // Arrange, Act and Assert
    assertEquals(":42", TbUtils.decodeURI(TbUtils.encodeURI(":42")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42#}.
   *   <li>Then return decodeURI is {@code 42#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42#'; then return decodeURI is '42#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs428() {
    // Arrange, Act and Assert
    assertEquals("42#", TbUtils.decodeURI(TbUtils.encodeURI("42#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42$}.
   *   <li>Then return decodeURI is {@code 42$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42$'; then return decodeURI is '42$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs429() {
    // Arrange, Act and Assert
    assertEquals("42$", TbUtils.decodeURI(TbUtils.encodeURI("42$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42+}.
   *   <li>Then return decodeURI is {@code 42+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42+'; then return decodeURI is '42+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4210() {
    // Arrange, Act and Assert
    assertEquals("42+", TbUtils.decodeURI(TbUtils.encodeURI("42+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42=}.
   *   <li>Then return decodeURI is {@code 42=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42='; then return decodeURI is '42='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4211() {
    // Arrange, Act and Assert
    assertEquals("42=", TbUtils.decodeURI(TbUtils.encodeURI("42=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42&}.
   *   <li>Then return decodeURI is {@code 42&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42&'; then return decodeURI is '42&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4212() {
    // Arrange, Act and Assert
    assertEquals("42&", TbUtils.decodeURI(TbUtils.encodeURI("42&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42@}.
   *   <li>Then return decodeURI is {@code 42@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42@'; then return decodeURI is '42@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4213() {
    // Arrange, Act and Assert
    assertEquals("42@", TbUtils.decodeURI(TbUtils.encodeURI("42@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42:}.
   *   <li>Then return decodeURI is {@code 42:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42:'; then return decodeURI is '42:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4214() {
    // Arrange, Act and Assert
    assertEquals("42:", TbUtils.decodeURI(TbUtils.encodeURI("42:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42?}.
   *   <li>Then return decodeURI is {@code 42?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42?'; then return decodeURI is '42?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4215() {
    // Arrange, Act and Assert
    assertEquals("42?", TbUtils.decodeURI(TbUtils.encodeURI("42?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42/}.
   *   <li>Then return decodeURI is {@code 42/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42/'; then return decodeURI is '42/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4216() {
    // Arrange, Act and Assert
    assertEquals("42/", TbUtils.decodeURI(TbUtils.encodeURI("42/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42,}.
   *   <li>Then return decodeURI is {@code 42,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42,'; then return decodeURI is '42,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4217() {
    // Arrange, Act and Assert
    assertEquals("42,", TbUtils.decodeURI(TbUtils.encodeURI("42,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42;}.
   *   <li>Then return decodeURI is {@code 42;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42;'; then return decodeURI is '42;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4218() {
    // Arrange, Act and Assert
    assertEquals("42;", TbUtils.decodeURI(TbUtils.encodeURI("42;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42~}.
   *   <li>Then return decodeURI is {@code 42~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42~'; then return decodeURI is '42~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4219() {
    // Arrange, Act and Assert
    assertEquals("42~", TbUtils.decodeURI(TbUtils.encodeURI("42~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code 42)}.
   *   <li>Then return decodeURI is {@code 42)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '42)'; then return decodeURI is '42)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4220() {
    // Arrange, Act and Assert
    assertEquals("42)", TbUtils.decodeURI(TbUtils.encodeURI("42)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ?42}.
   *   <li>Then return decodeURI is {@code ?42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '?42'; then return decodeURI is '?42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4221() {
    // Arrange, Act and Assert
    assertEquals("?42", TbUtils.decodeURI(TbUtils.encodeURI("?42")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code /42}.
   *   <li>Then return decodeURI is {@code /42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '/42'; then return decodeURI is '/42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4222() {
    // Arrange, Act and Assert
    assertEquals("/42", TbUtils.decodeURI(TbUtils.encodeURI("/42")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,42}.
   *   <li>Then return decodeURI is {@code ,42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ',42'; then return decodeURI is ',42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4223() {
    // Arrange, Act and Assert
    assertEquals(",42", TbUtils.decodeURI(TbUtils.encodeURI(",42")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ;42}.
   *   <li>Then return decodeURI is {@code ;42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ';42'; then return decodeURI is ';42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4224() {
    // Arrange, Act and Assert
    assertEquals(";42", TbUtils.decodeURI(TbUtils.encodeURI(";42")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ~42}.
   *   <li>Then return decodeURI is {@code ~42}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '~42'; then return decodeURI is '~42'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_when42_thenReturnDecodeURIIs4225() {
    // Arrange, Act and Assert
    assertEquals("~42", TbUtils.decodeURI(TbUtils.encodeURI("~42")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code &:}.
   *   <li>Then return decodeURI is {@code &:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '&:'; then return decodeURI is '&:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenAmpersandColon_thenReturnDecodeURIIsAmpersandColon() {
    // Arrange, Act and Assert
    assertEquals("&:", TbUtils.decodeURI(TbUtils.encodeURI("&:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code &,}.
   *   <li>Then return decodeURI is {@code &,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '&,'; then return decodeURI is '&,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenAmpersandComma_thenReturnDecodeURIIsAmpersandComma() {
    // Arrange, Act and Assert
    assertEquals("&,", TbUtils.decodeURI(TbUtils.encodeURI("&,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code &-}.
   *   <li>Then return decodeURI is {@code &-}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '&-'; then return decodeURI is '&-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenAmpersandDash_thenReturnDecodeURIIsAmpersandDash() {
    // Arrange, Act and Assert
    assertEquals("&-", TbUtils.decodeURI(TbUtils.encodeURI("&-")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code &.}.
   *   <li>Then return decodeURI is {@code &.}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '&.'; then return decodeURI is '&.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenAmpersandDot_thenReturnDecodeURIIsAmpersandDot() {
    // Arrange, Act and Assert
    assertEquals("&.", TbUtils.decodeURI(TbUtils.encodeURI("&.")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code &/}.
   *   <li>Then return decodeURI is {@code &/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '&/'; then return decodeURI is '&/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenAmpersandSlash_thenReturnDecodeURIIsAmpersandSlash() {
    // Arrange, Act and Assert
    assertEquals("&/", TbUtils.decodeURI(TbUtils.encodeURI("&/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code &~}.
   *   <li>Then return decodeURI is {@code &~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '&~'; then return decodeURI is '&~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenAmpersandTilde_thenReturnDecodeURIIsAmpersandTilde() {
    // Arrange, Act and Assert
    assertEquals("&~", TbUtils.decodeURI(TbUtils.encodeURI("&~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code &}.
   *   <li>Then return decodeURI is {@code &}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '&'; then return decodeURI is '&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenAmpersand_thenReturnDecodeURIIsAmpersand() {
    // Arrange, Act and Assert
    assertEquals("&", TbUtils.decodeURI(TbUtils.encodeURI("&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code :&}.
   *   <li>Then return decodeURI is {@code :&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ':&'; then return decodeURI is ':&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenColonAmpersand_thenReturnDecodeURIIsColonAmpersand() {
    // Arrange, Act and Assert
    assertEquals(":&", TbUtils.decodeURI(TbUtils.encodeURI(":&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ::}.
   *   <li>Then return decodeURI is {@code ::}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '::'; then return decodeURI is '::'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenColonColon_thenReturnDecodeURIIsColonColon() {
    // Arrange, Act and Assert
    assertEquals("::", TbUtils.decodeURI(TbUtils.encodeURI("::")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code :,}.
   *   <li>Then return decodeURI is {@code :,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ':,'; then return decodeURI is ':,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenColonComma_thenReturnDecodeURIIsColonComma() {
    // Arrange, Act and Assert
    assertEquals(":,", TbUtils.decodeURI(TbUtils.encodeURI(":,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code :-}.
   *   <li>Then return decodeURI is {@code :-}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ':-'; then return decodeURI is ':-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenColonDash_thenReturnDecodeURIIsColonDash() {
    // Arrange, Act and Assert
    assertEquals(":-", TbUtils.decodeURI(TbUtils.encodeURI(":-")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code :.}.
   *   <li>Then return decodeURI is {@code :.}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ':.'; then return decodeURI is ':.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenColonDot_thenReturnDecodeURIIsColonDot() {
    // Arrange, Act and Assert
    assertEquals(":.", TbUtils.decodeURI(TbUtils.encodeURI(":.")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code :+}.
   *   <li>Then return decodeURI is {@code :+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ':+'; then return decodeURI is ':+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenColonPlusSign_thenReturnDecodeURIIsColonPlusSign() {
    // Arrange, Act and Assert
    assertEquals(":+", TbUtils.decodeURI(TbUtils.encodeURI(":+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code :;}.
   *   <li>Then return decodeURI is {@code :;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ':;'; then return decodeURI is ':;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenColonSemicolon_thenReturnDecodeURIIsColonSemicolon() {
    // Arrange, Act and Assert
    assertEquals(":;", TbUtils.decodeURI(TbUtils.encodeURI(":;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code :/}.
   *   <li>Then return decodeURI is {@code :/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ':/'; then return decodeURI is ':/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenColonSlash_thenReturnDecodeURIIsColonSlash() {
    // Arrange, Act and Assert
    assertEquals(":/", TbUtils.decodeURI(TbUtils.encodeURI(":/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code :~}.
   *   <li>Then return decodeURI is {@code :~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ':~'; then return decodeURI is ':~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenColonTilde_thenReturnDecodeURIIsColonTilde() {
    // Arrange, Act and Assert
    assertEquals(":~", TbUtils.decodeURI(TbUtils.encodeURI(":~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code :}.
   *   <li>Then return decodeURI is {@code :}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ':'; then return decodeURI is ':'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenColon_thenReturnDecodeURIIsColon() {
    // Arrange, Act and Assert
    assertEquals(":", TbUtils.decodeURI(TbUtils.encodeURI(":")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,&}.
   *   <li>Then return decodeURI is {@code ,&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ',&'; then return decodeURI is ',&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenCommaAmpersand_thenReturnDecodeURIIsCommaAmpersand() {
    // Arrange, Act and Assert
    assertEquals(",&", TbUtils.decodeURI(TbUtils.encodeURI(",&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,:}.
   *   <li>Then return decodeURI is {@code ,:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ',:'; then return decodeURI is ',:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenCommaColon_thenReturnDecodeURIIsCommaColon() {
    // Arrange, Act and Assert
    assertEquals(",:", TbUtils.decodeURI(TbUtils.encodeURI(",:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,,}.
   *   <li>Then return decodeURI is {@code ,,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ',,'; then return decodeURI is ',,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenCommaComma_thenReturnDecodeURIIsCommaComma() {
    // Arrange, Act and Assert
    assertEquals(",,", TbUtils.decodeURI(TbUtils.encodeURI(",,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,-}.
   *   <li>Then return decodeURI is {@code ,-}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ',-'; then return decodeURI is ',-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenCommaDash_thenReturnDecodeURIIsCommaDash() {
    // Arrange, Act and Assert
    assertEquals(",-", TbUtils.decodeURI(TbUtils.encodeURI(",-")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,.}.
   *   <li>Then return decodeURI is {@code ,.}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ',.'; then return decodeURI is ',.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenCommaDot_thenReturnDecodeURIIsCommaDot() {
    // Arrange, Act and Assert
    assertEquals(",.", TbUtils.decodeURI(TbUtils.encodeURI(",.")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,+}.
   *   <li>Then return decodeURI is {@code ,+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ',+'; then return decodeURI is ',+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenCommaPlusSign_thenReturnDecodeURIIsCommaPlusSign() {
    // Arrange, Act and Assert
    assertEquals(",+", TbUtils.decodeURI(TbUtils.encodeURI(",+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,;}.
   *   <li>Then return decodeURI is {@code ,;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ',;'; then return decodeURI is ',;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenCommaSemicolon_thenReturnDecodeURIIsCommaSemicolon() {
    // Arrange, Act and Assert
    assertEquals(",;", TbUtils.decodeURI(TbUtils.encodeURI(",;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,/}.
   *   <li>Then return decodeURI is {@code ,/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ',/'; then return decodeURI is ',/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenCommaSlash_thenReturnDecodeURIIsCommaSlash() {
    // Arrange, Act and Assert
    assertEquals(",/", TbUtils.decodeURI(TbUtils.encodeURI(",/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,~}.
   *   <li>Then return decodeURI is {@code ,~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ',~'; then return decodeURI is ',~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenCommaTilde_thenReturnDecodeURIIsCommaTilde() {
    // Arrange, Act and Assert
    assertEquals(",~", TbUtils.decodeURI(TbUtils.encodeURI(",~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,}.
   *   <li>Then return decodeURI is {@code ,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ','; then return decodeURI is ','")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenComma_thenReturnDecodeURIIsComma() {
    // Arrange, Act and Assert
    assertEquals(",", TbUtils.decodeURI(TbUtils.encodeURI(",")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code @}.
   *   <li>Then return decodeURI is {@code @}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '@'; then return decodeURI is '@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenCommercialAt_thenReturnDecodeURIIsCommercialAt() {
    // Arrange, Act and Assert
    assertEquals("@", TbUtils.decodeURI(TbUtils.encodeURI("@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code -&}.
   *   <li>Then return decodeURI is {@code -&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '-&'; then return decodeURI is '-&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDashAmpersand_thenReturnDecodeURIIsDashAmpersand() {
    // Arrange, Act and Assert
    assertEquals("-&", TbUtils.decodeURI(TbUtils.encodeURI("-&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code -:}.
   *   <li>Then return decodeURI is {@code -:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '-:'; then return decodeURI is '-:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDashColon_thenReturnDecodeURIIsDashColon() {
    // Arrange, Act and Assert
    assertEquals("-:", TbUtils.decodeURI(TbUtils.encodeURI("-:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code -,}.
   *   <li>Then return decodeURI is {@code -,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '-,'; then return decodeURI is '-,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDashComma_thenReturnDecodeURIIsDashComma() {
    // Arrange, Act and Assert
    assertEquals("-,", TbUtils.decodeURI(TbUtils.encodeURI("-,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code -$}.
   *   <li>Then return decodeURI is {@code -$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '-$'; then return decodeURI is '-$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDashDollarSign_thenReturnDecodeURIIsDashDollarSign() {
    // Arrange, Act and Assert
    assertEquals("-$", TbUtils.decodeURI(TbUtils.encodeURI("-$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code -=}.
   *   <li>Then return decodeURI is {@code -=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '-='; then return decodeURI is '-='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDashEqualsSign_thenReturnDecodeURIIsDashEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("-=", TbUtils.decodeURI(TbUtils.encodeURI("-=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code -#}.
   *   <li>Then return decodeURI is {@code -#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '-#'; then return decodeURI is '-#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDashNumberSign_thenReturnDecodeURIIsDashNumberSign() {
    // Arrange, Act and Assert
    assertEquals("-#", TbUtils.decodeURI(TbUtils.encodeURI("-#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code -+}.
   *   <li>Then return decodeURI is {@code -+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '-+'; then return decodeURI is '-+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDashPlusSign_thenReturnDecodeURIIsDashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("-+", TbUtils.decodeURI(TbUtils.encodeURI("-+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code -;}.
   *   <li>Then return decodeURI is {@code -;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '-;'; then return decodeURI is '-;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDashSemicolon_thenReturnDecodeURIIsDashSemicolon() {
    // Arrange, Act and Assert
    assertEquals("-;", TbUtils.decodeURI(TbUtils.encodeURI("-;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code -/}.
   *   <li>Then return decodeURI is {@code -/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '-/'; then return decodeURI is '-/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDashSlash_thenReturnDecodeURIIsDashSlash() {
    // Arrange, Act and Assert
    assertEquals("-/", TbUtils.decodeURI(TbUtils.encodeURI("-/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code -~}.
   *   <li>Then return decodeURI is {@code -~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '-~'; then return decodeURI is '-~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDashTilde_thenReturnDecodeURIIsDashTilde() {
    // Arrange, Act and Assert
    assertEquals("-~", TbUtils.decodeURI(TbUtils.encodeURI("-~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code $-}.
   *   <li>Then return decodeURI is {@code $-}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '$-'; then return decodeURI is '$-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDollarSignDash_thenReturnDecodeURIIsDollarSignDash() {
    // Arrange, Act and Assert
    assertEquals("$-", TbUtils.decodeURI(TbUtils.encodeURI("$-")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code $.}.
   *   <li>Then return decodeURI is {@code $.}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '$.'; then return decodeURI is '$.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDollarSignDot_thenReturnDecodeURIIsDollarSignDot() {
    // Arrange, Act and Assert
    assertEquals("$.", TbUtils.decodeURI(TbUtils.encodeURI("$.")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code $}.
   *   <li>Then return decodeURI is {@code $}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '$'; then return decodeURI is '$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenDollarSign_thenReturnDecodeURIIsDollarSign() {
    // Arrange, Act and Assert
    assertEquals("$", TbUtils.decodeURI(TbUtils.encodeURI("$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code =-}.
   *   <li>Then return decodeURI is {@code =-}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '=-'; then return decodeURI is '=-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenEqualsSignDash_thenReturnDecodeURIIsEqualsSignDash() {
    // Arrange, Act and Assert
    assertEquals("=-", TbUtils.decodeURI(TbUtils.encodeURI("=-")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code =.}.
   *   <li>Then return decodeURI is {@code =.}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '=.'; then return decodeURI is '=.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenEqualsSignDot_thenReturnDecodeURIIsEqualsSignDot() {
    // Arrange, Act and Assert
    assertEquals("=.", TbUtils.decodeURI(TbUtils.encodeURI("=.")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code =}.
   *   <li>Then return decodeURI is {@code =}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '='; then return decodeURI is '='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenEqualsSign_thenReturnDecodeURIIsEqualsSign() {
    // Arrange, Act and Assert
    assertEquals("=", TbUtils.decodeURI(TbUtils.encodeURI("=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code #-}.
   *   <li>Then return decodeURI is {@code #-}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '#-'; then return decodeURI is '#-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenNumberSignDash_thenReturnDecodeURIIsNumberSignDash() {
    // Arrange, Act and Assert
    assertEquals("#-", TbUtils.decodeURI(TbUtils.encodeURI("#-")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code #.}.
   *   <li>Then return decodeURI is {@code #.}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '#.'; then return decodeURI is '#.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenNumberSignDot_thenReturnDecodeURIIsNumberSignDot() {
    // Arrange, Act and Assert
    assertEquals("#.", TbUtils.decodeURI(TbUtils.encodeURI("#.")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code #}.
   *   <li>Then return decodeURI is {@code #}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '#'; then return decodeURI is '#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenNumberSign_thenReturnDecodeURIIsNumberSign() {
    // Arrange, Act and Assert
    assertEquals("#", TbUtils.decodeURI(TbUtils.encodeURI("#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code +:}.
   *   <li>Then return decodeURI is {@code +:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '+:'; then return decodeURI is '+:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenPlusSignColon_thenReturnDecodeURIIsPlusSignColon() {
    // Arrange, Act and Assert
    assertEquals("+:", TbUtils.decodeURI(TbUtils.encodeURI("+:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code +,}.
   *   <li>Then return decodeURI is {@code +,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '+,'; then return decodeURI is '+,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenPlusSignComma_thenReturnDecodeURIIsPlusSignComma() {
    // Arrange, Act and Assert
    assertEquals("+,", TbUtils.decodeURI(TbUtils.encodeURI("+,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code +-}.
   *   <li>Then return decodeURI is {@code +-}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '+-'; then return decodeURI is '+-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenPlusSignDash_thenReturnDecodeURIIsPlusSignDash() {
    // Arrange, Act and Assert
    assertEquals("+-", TbUtils.decodeURI(TbUtils.encodeURI("+-")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code +.}.
   *   <li>Then return decodeURI is {@code +.}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '+.'; then return decodeURI is '+.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenPlusSignDot_thenReturnDecodeURIIsPlusSignDot() {
    // Arrange, Act and Assert
    assertEquals("+.", TbUtils.decodeURI(TbUtils.encodeURI("+.")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code +/}.
   *   <li>Then return decodeURI is {@code +/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '+/'; then return decodeURI is '+/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenPlusSignSlash_thenReturnDecodeURIIsPlusSignSlash() {
    // Arrange, Act and Assert
    assertEquals("+/", TbUtils.decodeURI(TbUtils.encodeURI("+/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code +~}.
   *   <li>Then return decodeURI is {@code +~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '+~'; then return decodeURI is '+~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenPlusSignTilde_thenReturnDecodeURIIsPlusSignTilde() {
    // Arrange, Act and Assert
    assertEquals("+~", TbUtils.decodeURI(TbUtils.encodeURI("+~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code +}.
   *   <li>Then return decodeURI is {@code +}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '+'; then return decodeURI is '+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenPlusSign_thenReturnDecodeURIIsPlusSign() {
    // Arrange, Act and Assert
    assertEquals("+", TbUtils.decodeURI(TbUtils.encodeURI("+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ?}.
   *   <li>Then return decodeURI is {@code ?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '?'; then return decodeURI is '?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenQuestionMark_thenReturnDecodeURIIsQuestionMark() {
    // Arrange, Act and Assert
    assertEquals("?", TbUtils.decodeURI(TbUtils.encodeURI("?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ;:}.
   *   <li>Then return decodeURI is {@code ;:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ';:'; then return decodeURI is ';:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSemicolonColon_thenReturnDecodeURIIsSemicolonColon() {
    // Arrange, Act and Assert
    assertEquals(";:", TbUtils.decodeURI(TbUtils.encodeURI(";:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ;,}.
   *   <li>Then return decodeURI is {@code ;,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ';,'; then return decodeURI is ';,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSemicolonComma_thenReturnDecodeURIIsSemicolonComma() {
    // Arrange, Act and Assert
    assertEquals(";,", TbUtils.decodeURI(TbUtils.encodeURI(";,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ;-}.
   *   <li>Then return decodeURI is {@code ;-}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ';-'; then return decodeURI is ';-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSemicolonDash_thenReturnDecodeURIIsSemicolonDash() {
    // Arrange, Act and Assert
    assertEquals(";-", TbUtils.decodeURI(TbUtils.encodeURI(";-")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ;.}.
   *   <li>Then return decodeURI is {@code ;.}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ';.'; then return decodeURI is ';.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSemicolonDot_thenReturnDecodeURIIsSemicolonDot() {
    // Arrange, Act and Assert
    assertEquals(";.", TbUtils.decodeURI(TbUtils.encodeURI(";.")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ;/}.
   *   <li>Then return decodeURI is {@code ;/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ';/'; then return decodeURI is ';/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSemicolonSlash_thenReturnDecodeURIIsSemicolonSlash() {
    // Arrange, Act and Assert
    assertEquals(";/", TbUtils.decodeURI(TbUtils.encodeURI(";/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ;~}.
   *   <li>Then return decodeURI is {@code ;~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ';~'; then return decodeURI is ';~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSemicolonTilde_thenReturnDecodeURIIsSemicolonTilde() {
    // Arrange, Act and Assert
    assertEquals(";~", TbUtils.decodeURI(TbUtils.encodeURI(";~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ;}.
   *   <li>Then return decodeURI is {@code ;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ';'; then return decodeURI is ';'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSemicolon_thenReturnDecodeURIIsSemicolon() {
    // Arrange, Act and Assert
    assertEquals(";", TbUtils.decodeURI(TbUtils.encodeURI(";")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code /&}.
   *   <li>Then return decodeURI is {@code /&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '/&'; then return decodeURI is '/&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSlashAmpersand_thenReturnDecodeURIIsSlashAmpersand() {
    // Arrange, Act and Assert
    assertEquals("/&", TbUtils.decodeURI(TbUtils.encodeURI("/&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code /:}.
   *   <li>Then return decodeURI is {@code /:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '/:'; then return decodeURI is '/:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSlashColon_thenReturnDecodeURIIsSlashColon() {
    // Arrange, Act and Assert
    assertEquals("/:", TbUtils.decodeURI(TbUtils.encodeURI("/:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code /,}.
   *   <li>Then return decodeURI is {@code /,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '/,'; then return decodeURI is '/,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSlashComma_thenReturnDecodeURIIsSlashComma() {
    // Arrange, Act and Assert
    assertEquals("/,", TbUtils.decodeURI(TbUtils.encodeURI("/,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code /-}.
   *   <li>Then return decodeURI is {@code /-}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '/-'; then return decodeURI is '/-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSlashDash_thenReturnDecodeURIIsSlashDash() {
    // Arrange, Act and Assert
    assertEquals("/-", TbUtils.decodeURI(TbUtils.encodeURI("/-")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code /.}.
   *   <li>Then return decodeURI is {@code /.}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '/.'; then return decodeURI is '/.'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSlashDot_thenReturnDecodeURIIsSlashDot() {
    // Arrange, Act and Assert
    assertEquals("/.", TbUtils.decodeURI(TbUtils.encodeURI("/.")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code /+}.
   *   <li>Then return decodeURI is {@code /+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '/+'; then return decodeURI is '/+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSlashPlusSign_thenReturnDecodeURIIsSlashPlusSign() {
    // Arrange, Act and Assert
    assertEquals("/+", TbUtils.decodeURI(TbUtils.encodeURI("/+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code /;}.
   *   <li>Then return decodeURI is {@code /;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '/;'; then return decodeURI is '/;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSlashSemicolon_thenReturnDecodeURIIsSlashSemicolon() {
    // Arrange, Act and Assert
    assertEquals("/;", TbUtils.decodeURI(TbUtils.encodeURI("/;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code //}.
   *   <li>Then return decodeURI is {@code //}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '//'; then return decodeURI is '//'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSlashSlash_thenReturnDecodeURIIsSlashSlash() {
    // Arrange, Act and Assert
    assertEquals("//", TbUtils.decodeURI(TbUtils.encodeURI("//")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code /~}.
   *   <li>Then return decodeURI is {@code /~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '/~'; then return decodeURI is '/~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSlashTilde_thenReturnDecodeURIIsSlashTilde() {
    // Arrange, Act and Assert
    assertEquals("/~", TbUtils.decodeURI(TbUtils.encodeURI("/~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code /}.
   *   <li>Then return decodeURI is {@code /}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '/'; then return decodeURI is '/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenSlash_thenReturnDecodeURIIsSlash() {
    // Arrange, Act and Assert
    assertEquals("/", TbUtils.decodeURI(TbUtils.encodeURI("/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ~&}.
   *   <li>Then return decodeURI is {@code ~&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '~&'; then return decodeURI is '~&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenTildeAmpersand_thenReturnDecodeURIIsTildeAmpersand() {
    // Arrange, Act and Assert
    assertEquals("~&", TbUtils.decodeURI(TbUtils.encodeURI("~&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ~:}.
   *   <li>Then return decodeURI is {@code ~:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '~:'; then return decodeURI is '~:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenTildeColon_thenReturnDecodeURIIsTildeColon() {
    // Arrange, Act and Assert
    assertEquals("~:", TbUtils.decodeURI(TbUtils.encodeURI("~:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ~,}.
   *   <li>Then return decodeURI is {@code ~,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '~,'; then return decodeURI is '~,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenTildeComma_thenReturnDecodeURIIsTildeComma() {
    // Arrange, Act and Assert
    assertEquals("~,", TbUtils.decodeURI(TbUtils.encodeURI("~,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ~-}.
   *   <li>Then return decodeURI is {@code ~-}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '~-'; then return decodeURI is '~-'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenTildeDash_thenReturnDecodeURIIsTildeDash() {
    // Arrange, Act and Assert
    assertEquals("~-", TbUtils.decodeURI(TbUtils.encodeURI("~-")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ~+}.
   *   <li>Then return decodeURI is {@code ~+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '~+'; then return decodeURI is '~+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenTildePlusSign_thenReturnDecodeURIIsTildePlusSign() {
    // Arrange, Act and Assert
    assertEquals("~+", TbUtils.decodeURI(TbUtils.encodeURI("~+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ~;}.
   *   <li>Then return decodeURI is {@code ~;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '~;'; then return decodeURI is '~;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenTildeSemicolon_thenReturnDecodeURIIsTildeSemicolon() {
    // Arrange, Act and Assert
    assertEquals("~;", TbUtils.decodeURI(TbUtils.encodeURI("~;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ~/}.
   *   <li>Then return decodeURI is {@code ~/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '~/'; then return decodeURI is '~/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenTildeSlash_thenReturnDecodeURIIsTildeSlash() {
    // Arrange, Act and Assert
    assertEquals("~/", TbUtils.decodeURI(TbUtils.encodeURI("~/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ~}.
   *   <li>Then return decodeURI is {@code ~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '~'; then return decodeURI is '~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenTilde_thenReturnDecodeURIIsTilde() {
    // Arrange, Act and Assert
    assertEquals("~", TbUtils.decodeURI(TbUtils.encodeURI("~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri}.
   *   <li>Then return decodeURI is {@code Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri'; then return decodeURI is 'Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri() {
    // Arrange, Act and Assert
    assertEquals("Uri", TbUtils.decodeURI(TbUtils.encodeURI("Uri")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code #Uri}.
   *   <li>Then return decodeURI is {@code #Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '#Uri'; then return decodeURI is '#Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri2() {
    // Arrange, Act and Assert
    assertEquals("#Uri", TbUtils.decodeURI(TbUtils.encodeURI("#Uri")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code $Uri}.
   *   <li>Then return decodeURI is {@code $Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '$Uri'; then return decodeURI is '$Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri3() {
    // Arrange, Act and Assert
    assertEquals("$Uri", TbUtils.decodeURI(TbUtils.encodeURI("$Uri")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code +Uri}.
   *   <li>Then return decodeURI is {@code +Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '+Uri'; then return decodeURI is '+Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri4() {
    // Arrange, Act and Assert
    assertEquals("+Uri", TbUtils.decodeURI(TbUtils.encodeURI("+Uri")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code =Uri}.
   *   <li>Then return decodeURI is {@code =Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '=Uri'; then return decodeURI is '=Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri5() {
    // Arrange, Act and Assert
    assertEquals("=Uri", TbUtils.decodeURI(TbUtils.encodeURI("=Uri")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code &Uri}.
   *   <li>Then return decodeURI is {@code &Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '&Uri'; then return decodeURI is '&Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri6() {
    // Arrange, Act and Assert
    assertEquals("&Uri", TbUtils.decodeURI(TbUtils.encodeURI("&Uri")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code @Uri}.
   *   <li>Then return decodeURI is {@code @Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '@Uri'; then return decodeURI is '@Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri7() {
    // Arrange, Act and Assert
    assertEquals("@Uri", TbUtils.decodeURI(TbUtils.encodeURI("@Uri")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri#}.
   *   <li>Then return decodeURI is {@code Uri#}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri#'; then return decodeURI is 'Uri#'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri8() {
    // Arrange, Act and Assert
    assertEquals("Uri#", TbUtils.decodeURI(TbUtils.encodeURI("Uri#")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri$}.
   *   <li>Then return decodeURI is {@code Uri$}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri$'; then return decodeURI is 'Uri$'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri9() {
    // Arrange, Act and Assert
    assertEquals("Uri$", TbUtils.decodeURI(TbUtils.encodeURI("Uri$")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri+}.
   *   <li>Then return decodeURI is {@code Uri+}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri+'; then return decodeURI is 'Uri+'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri10() {
    // Arrange, Act and Assert
    assertEquals("Uri+", TbUtils.decodeURI(TbUtils.encodeURI("Uri+")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri=}.
   *   <li>Then return decodeURI is {@code Uri=}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri='; then return decodeURI is 'Uri='")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri11() {
    // Arrange, Act and Assert
    assertEquals("Uri=", TbUtils.decodeURI(TbUtils.encodeURI("Uri=")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri&}.
   *   <li>Then return decodeURI is {@code Uri&}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri&'; then return decodeURI is 'Uri&'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri12() {
    // Arrange, Act and Assert
    assertEquals("Uri&", TbUtils.decodeURI(TbUtils.encodeURI("Uri&")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri@}.
   *   <li>Then return decodeURI is {@code Uri@}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri@'; then return decodeURI is 'Uri@'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri13() {
    // Arrange, Act and Assert
    assertEquals("Uri@", TbUtils.decodeURI(TbUtils.encodeURI("Uri@")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri:}.
   *   <li>Then return decodeURI is {@code Uri:}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri:'; then return decodeURI is 'Uri:'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri14() {
    // Arrange, Act and Assert
    assertEquals("Uri:", TbUtils.decodeURI(TbUtils.encodeURI("Uri:")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri?}.
   *   <li>Then return decodeURI is {@code Uri?}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri?'; then return decodeURI is 'Uri?'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri15() {
    // Arrange, Act and Assert
    assertEquals("Uri?", TbUtils.decodeURI(TbUtils.encodeURI("Uri?")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri/}.
   *   <li>Then return decodeURI is {@code Uri/}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri/'; then return decodeURI is 'Uri/'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri16() {
    // Arrange, Act and Assert
    assertEquals("Uri/", TbUtils.decodeURI(TbUtils.encodeURI("Uri/")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri,}.
   *   <li>Then return decodeURI is {@code Uri,}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri,'; then return decodeURI is 'Uri,'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri17() {
    // Arrange, Act and Assert
    assertEquals("Uri,", TbUtils.decodeURI(TbUtils.encodeURI("Uri,")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri;}.
   *   <li>Then return decodeURI is {@code Uri;}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri;'; then return decodeURI is 'Uri;'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri18() {
    // Arrange, Act and Assert
    assertEquals("Uri;", TbUtils.decodeURI(TbUtils.encodeURI("Uri;")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri~}.
   *   <li>Then return decodeURI is {@code Uri~}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri~'; then return decodeURI is 'Uri~'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri19() {
    // Arrange, Act and Assert
    assertEquals("Uri~", TbUtils.decodeURI(TbUtils.encodeURI("Uri~")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code Uri)}.
   *   <li>Then return decodeURI is {@code Uri)}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when 'Uri)'; then return decodeURI is 'Uri)'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri20() {
    // Arrange, Act and Assert
    assertEquals("Uri)", TbUtils.decodeURI(TbUtils.encodeURI("Uri)")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code :Uri}.
   *   <li>Then return decodeURI is {@code :Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ':Uri'; then return decodeURI is ':Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri21() {
    // Arrange, Act and Assert
    assertEquals(":Uri", TbUtils.decodeURI(TbUtils.encodeURI(":Uri")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ?Uri}.
   *   <li>Then return decodeURI is {@code ?Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '?Uri'; then return decodeURI is '?Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri22() {
    // Arrange, Act and Assert
    assertEquals("?Uri", TbUtils.decodeURI(TbUtils.encodeURI("?Uri")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code /Uri}.
   *   <li>Then return decodeURI is {@code /Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '/Uri'; then return decodeURI is '/Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri23() {
    // Arrange, Act and Assert
    assertEquals("/Uri", TbUtils.decodeURI(TbUtils.encodeURI("/Uri")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ,Uri}.
   *   <li>Then return decodeURI is {@code ,Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ',Uri'; then return decodeURI is ',Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri24() {
    // Arrange, Act and Assert
    assertEquals(",Uri", TbUtils.decodeURI(TbUtils.encodeURI(",Uri")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ;Uri}.
   *   <li>Then return decodeURI is {@code ;Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when ';Uri'; then return decodeURI is ';Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri25() {
    // Arrange, Act and Assert
    assertEquals(";Uri", TbUtils.decodeURI(TbUtils.encodeURI(";Uri")));
  }

  /**
   * Test {@link TbUtils#encodeURI(String)}, and {@link TbUtils#decodeURI(String)}.
   *
   * <ul>
   *   <li>When {@code ~Uri}.
   *   <li>Then return decodeURI is {@code ~Uri}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbUtils#encodeURI(String)}
   *   <li>{@link TbUtils#decodeURI(String)}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test encodeURI(String), and decodeURI(String); when '~Uri'; then return decodeURI is '~Uri'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.encodeURI(String)", "String TbUtils.decodeURI(String)"})
  void testEncodeURIAndDecodeURI_whenUri_thenReturnDecodeURIIsUri26() {
    // Arrange, Act and Assert
    assertEquals("~Uri", TbUtils.decodeURI(TbUtils.encodeURI("~Uri")));
  }

  /**
   * Test {@link TbUtils#raiseError(String)}.
   *
   * <p>Method under test: {@link TbUtils#raiseError(String)}
   */
  @Test
  @DisplayName("Test raiseError(String)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void TbUtils.raiseError(String)"})
  void testRaiseError() {
    // Arrange, Act and Assert
    assertThrows(RuntimeException.class, () -> TbUtils.raiseError("Not all who wander are lost"));
  }

  /**
   * Test {@link TbUtils#isBinary(String)}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isBinary(String)}
   */
  @Test
  @DisplayName("Test isBinary(String); when '0'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isBinary(String)"})
  void testIsBinary_when0_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, TbUtils.isBinary("0"));
  }

  /**
   * Test {@link TbUtils#isBinary(String)}.
   *
   * <ul>
   *   <li>When {@code 00}.
   *   <li>Then return two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isBinary(String)}
   */
  @Test
  @DisplayName("Test isBinary(String); when '00'; then return two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isBinary(String)"})
  void testIsBinary_when00_thenReturnTwo() {
    // Arrange, Act and Assert
    assertEquals(2, TbUtils.isBinary("00"));
  }

  /**
   * Test {@link TbUtils#isBinary(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isBinary(String)}
   */
  @Test
  @DisplayName("Test isBinary(String); when empty string; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isBinary(String)"})
  void testIsBinary_whenEmptyString_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, TbUtils.isBinary(""));
  }

  /**
   * Test {@link TbUtils#isBinary(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isBinary(String)}
   */
  @Test
  @DisplayName("Test isBinary(String); when 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isBinary(String)"})
  void testIsBinary_whenNull_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, TbUtils.isBinary(null));
  }

  /**
   * Test {@link TbUtils#isBinary(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isBinary(String)}
   */
  @Test
  @DisplayName("Test isBinary(String); when 'Str'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isBinary(String)"})
  void testIsBinary_whenStr_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, TbUtils.isBinary("Str"));
  }

  /**
   * Test {@link TbUtils#isOctal(String)}.
   *
   * <ul>
   *   <li>When {@code 0}.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isOctal(String)}
   */
  @Test
  @DisplayName("Test isOctal(String); when '0'; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isOctal(String)"})
  void testIsOctal_when0_thenReturnEight() {
    // Arrange, Act and Assert
    assertEquals(8, TbUtils.isOctal("0"));
  }

  /**
   * Test {@link TbUtils#isOctal(String)}.
   *
   * <ul>
   *   <li>When {@code 00}.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isOctal(String)}
   */
  @Test
  @DisplayName("Test isOctal(String); when '00'; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isOctal(String)"})
  void testIsOctal_when00_thenReturnEight() {
    // Arrange, Act and Assert
    assertEquals(8, TbUtils.isOctal("00"));
  }

  /**
   * Test {@link TbUtils#isOctal(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isOctal(String)}
   */
  @Test
  @DisplayName("Test isOctal(String); when '42'; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isOctal(String)"})
  void testIsOctal_when42_thenReturnEight() {
    // Arrange, Act and Assert
    assertEquals(8, TbUtils.isOctal("42"));
  }

  /**
   * Test {@link TbUtils#isOctal(String)}.
   *
   * <ul>
   *   <li>When {@code 042}.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isOctal(String)}
   */
  @Test
  @DisplayName("Test isOctal(String); when '042'; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isOctal(String)"})
  void testIsOctal_when042_thenReturnEight() {
    // Arrange, Act and Assert
    assertEquals(8, TbUtils.isOctal("042"));
  }

  /**
   * Test {@link TbUtils#isOctal(String)}.
   *
   * <ul>
   *   <li>When {@code 420}.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isOctal(String)}
   */
  @Test
  @DisplayName("Test isOctal(String); when '420'; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isOctal(String)"})
  void testIsOctal_when420_thenReturnEight() {
    // Arrange, Act and Assert
    assertEquals(8, TbUtils.isOctal("420"));
  }

  /**
   * Test {@link TbUtils#isOctal(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return eight.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isOctal(String)}
   */
  @Test
  @DisplayName("Test isOctal(String); when '4242'; then return eight")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isOctal(String)"})
  void testIsOctal_when4242_thenReturnEight() {
    // Arrange, Act and Assert
    assertEquals(8, TbUtils.isOctal("4242"));
  }

  /**
   * Test {@link TbUtils#isOctal(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isOctal(String)}
   */
  @Test
  @DisplayName("Test isOctal(String); when empty string; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isOctal(String)"})
  void testIsOctal_whenEmptyString_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, TbUtils.isOctal(""));
  }

  /**
   * Test {@link TbUtils#isOctal(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isOctal(String)}
   */
  @Test
  @DisplayName("Test isOctal(String); when 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isOctal(String)"})
  void testIsOctal_whenNull_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, TbUtils.isOctal(null));
  }

  /**
   * Test {@link TbUtils#isOctal(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isOctal(String)}
   */
  @Test
  @DisplayName("Test isOctal(String); when 'Str'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isOctal(String)"})
  void testIsOctal_whenStr_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, TbUtils.isOctal("Str"));
  }

  /**
   * Test {@link TbUtils#isDecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isDecimal(String)}
   */
  @Test
  @DisplayName("Test isDecimal(String); when '42'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isDecimal(String)"})
  void testIsDecimal_when42_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10, TbUtils.isDecimal("42"));
  }

  /**
   * Test {@link TbUtils#isDecimal(String)}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isDecimal(String)}
   */
  @Test
  @DisplayName("Test isDecimal(String); when '-42'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isDecimal(String)"})
  void testIsDecimal_when42_thenReturnTen2() {
    // Arrange, Act and Assert
    assertEquals(10, TbUtils.isDecimal("-42"));
  }

  /**
   * Test {@link TbUtils#isDecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 9.9}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isDecimal(String)}
   */
  @Test
  @DisplayName("Test isDecimal(String); when '9.9'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isDecimal(String)"})
  void testIsDecimal_when99_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10, TbUtils.isDecimal("9.9"));
  }

  /**
   * Test {@link TbUtils#isDecimal(String)}.
   *
   * <ul>
   *   <li>When {@code -9.9}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isDecimal(String)}
   */
  @Test
  @DisplayName("Test isDecimal(String); when '-9.9'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isDecimal(String)"})
  void testIsDecimal_when99_thenReturnTen2() {
    // Arrange, Act and Assert
    assertEquals(10, TbUtils.isDecimal("-9.9"));
  }

  /**
   * Test {@link TbUtils#isDecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isDecimal(String)}
   */
  @Test
  @DisplayName("Test isDecimal(String); when '4242'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isDecimal(String)"})
  void testIsDecimal_when4242_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10, TbUtils.isDecimal("4242"));
  }

  /**
   * Test {@link TbUtils#isDecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 429.9}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isDecimal(String)}
   */
  @Test
  @DisplayName("Test isDecimal(String); when '429.9'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isDecimal(String)"})
  void testIsDecimal_when4299_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10, TbUtils.isDecimal("429.9"));
  }

  /**
   * Test {@link TbUtils#isDecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 9.942}.
   *   <li>Then return ten.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isDecimal(String)}
   */
  @Test
  @DisplayName("Test isDecimal(String); when '9.942'; then return ten")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isDecimal(String)"})
  void testIsDecimal_when9942_thenReturnTen() {
    // Arrange, Act and Assert
    assertEquals(10, TbUtils.isDecimal("9.942"));
  }

  /**
   * Test {@link TbUtils#isDecimal(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isDecimal(String)}
   */
  @Test
  @DisplayName("Test isDecimal(String); when empty string; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isDecimal(String)"})
  void testIsDecimal_whenEmptyString_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, TbUtils.isDecimal(""));
  }

  /**
   * Test {@link TbUtils#isDecimal(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isDecimal(String)}
   */
  @Test
  @DisplayName("Test isDecimal(String); when 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isDecimal(String)"})
  void testIsDecimal_whenNull_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, TbUtils.isDecimal(null));
  }

  /**
   * Test {@link TbUtils#isDecimal(String)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isDecimal(String)}
   */
  @Test
  @DisplayName("Test isDecimal(String); when 'Str'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isDecimal(String)"})
  void testIsDecimal_whenStr_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, TbUtils.isDecimal("Str"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code ^-?(0[xX])?[0-9a-fA-F]+$}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '^-?(0[xX])?[0-9a-fA-F]+$'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when0XX09aFAF_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, TbUtils.isHexadecimal("^-?(0[xX])?[0-9a-fA-F]+$"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 0X9}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '0X9'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when0x9_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("0X9"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code -0X9}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '-0X9'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when0x9_thenReturnSize2() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("-0X9"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 0x42}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '0x42'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when0x42_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("0x42"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 0X942}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '0X942'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when0x942_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("0X942"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 0x0123456789ABCDEF}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '0x0123456789ABCDEF'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when0x0123456789ABCDEF_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("0x0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 0X90123456789ABCDEF}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '0X90123456789ABCDEF'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when0x90123456789abcdef_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("0X90123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '42'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when42_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("42"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code -42}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '-42'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when42_thenReturnSize2() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("-42"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 4242}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '4242'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when4242_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("4242"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF42}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '0123456789ABCDEF42'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when0123456789abcdef42_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("0123456789ABCDEF42"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF0123456789ABCDEF}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName(
      "Test isHexadecimal(String); when '0123456789ABCDEF0123456789ABCDEF'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when0123456789abcdef0123456789abcdef_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("0123456789ABCDEF0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 0123456789ABCDEF}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '0123456789ABCDEF'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when0123456789abcdef_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code -0123456789ABCDEF}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '-0123456789ABCDEF'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when0123456789abcdef_thenReturnSize2() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("-0123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code 420123456789ABCDEF}.
   *   <li>Then return {@link Short#SIZE}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when '420123456789ABCDEF'; then return SIZE")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_when420123456789abcdef_thenReturnSize() {
    // Arrange, Act and Assert
    assertEquals(Short.SIZE, TbUtils.isHexadecimal("420123456789ABCDEF"));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when empty string; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_whenEmptyString_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, TbUtils.isHexadecimal(""));
  }

  /**
   * Test {@link TbUtils#isHexadecimal(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return minus one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#isHexadecimal(String)}
   */
  @Test
  @DisplayName("Test isHexadecimal(String); when 'null'; then return minus one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.isHexadecimal(String)"})
  void testIsHexadecimal_whenNull_thenReturnMinusOne() {
    // Arrange, Act and Assert
    assertEquals(-1, TbUtils.isHexadecimal(null));
  }

  /**
   * Test {@link TbUtils#bytesToExecutionArrayList(ExecutionContext, byte[])}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then calls {@link ExecutionContext#nextId()}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#bytesToExecutionArrayList(ExecutionContext, byte[])}
   */
  @Test
  @DisplayName(
      "Test bytesToExecutionArrayList(ExecutionContext, byte[]); given one; then calls nextId()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "ExecutionArrayList TbUtils.bytesToExecutionArrayList(ExecutionContext, byte[])"
  })
  void testBytesToExecutionArrayList_givenOne_thenCallsNextId()
      throws UnsupportedEncodingException {
    // Arrange
    ExecutionContext ctx = mock(ExecutionContext.class);
    when(ctx.nextId()).thenReturn(1);
    when(ctx.onValAdd(Mockito.<ExecutionObject>any(), Mockito.<Object>any(), Mockito.<Object>any()))
        .thenReturn(42L);

    // Act
    ExecutionArrayList<Byte> actualBytesToExecutionArrayListResult =
        TbUtils.bytesToExecutionArrayList(ctx, "AXAXAXAX".getBytes("UTF-8"));

    // Assert
    verify(ctx).nextId();
    verify(ctx, atLeast(1))
        .onValAdd(isA(ExecutionObject.class), Mockito.<Object>any(), Mockito.<Object>any());
    assertEquals(8, actualBytesToExecutionArrayListResult.size());
    assertEquals('A', actualBytesToExecutionArrayListResult.get(0).byteValue());
    assertEquals('A', actualBytesToExecutionArrayListResult.get(2).byteValue());
    assertEquals('A', actualBytesToExecutionArrayListResult.get(4).byteValue());
    assertEquals('A', actualBytesToExecutionArrayListResult.get(6).byteValue());
    assertEquals('X', actualBytesToExecutionArrayListResult.get(1).byteValue());
    assertEquals('X', actualBytesToExecutionArrayListResult.get(3).byteValue());
    assertEquals('X', actualBytesToExecutionArrayListResult.get(5).byteValue());
    assertEquals('X', actualBytesToExecutionArrayListResult.get(7).byteValue());
  }

  /**
   * Test {@link TbUtils#padStart(String, int, char)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code AAA}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#padStart(String, int, char)}
   */
  @Test
  @DisplayName("Test padStart(String, int, char); when empty string; then return 'AAA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.padStart(String, int, char)"})
  void testPadStart_whenEmptyString_thenReturnAaa() {
    // Arrange, Act and Assert
    assertEquals("AAA", TbUtils.padStart("", 3, 'A'));
  }

  /**
   * Test {@link TbUtils#padStart(String, int, char)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code Str}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#padStart(String, int, char)}
   */
  @Test
  @DisplayName("Test padStart(String, int, char); when 'Str'; then return 'Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.padStart(String, int, char)"})
  void testPadStart_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", TbUtils.padStart("Str", 3, 'A'));
  }

  /**
   * Test {@link TbUtils#padEnd(String, int, char)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code AAA}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#padEnd(String, int, char)}
   */
  @Test
  @DisplayName("Test padEnd(String, int, char); when empty string; then return 'AAA'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.padEnd(String, int, char)"})
  void testPadEnd_whenEmptyString_thenReturnAaa() {
    // Arrange, Act and Assert
    assertEquals("AAA", TbUtils.padEnd("", 3, 'A'));
  }

  /**
   * Test {@link TbUtils#padEnd(String, int, char)}.
   *
   * <ul>
   *   <li>When {@code Str}.
   *   <li>Then return {@code Str}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#padEnd(String, int, char)}
   */
  @Test
  @DisplayName("Test padEnd(String, int, char); when 'Str'; then return 'Str'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"String TbUtils.padEnd(String, int, char)"})
  void testPadEnd_whenStr_thenReturnStr() {
    // Arrange, Act and Assert
    assertEquals("Str", TbUtils.padEnd("Str", 3, 'A'));
  }

  /**
   * Test {@link TbUtils#parseByteToBinaryArray(byte)} with {@code byteValue}.
   *
   * <p>Method under test: {@link TbUtils#parseByteToBinaryArray(byte)}
   */
  @Test
  @DisplayName("Test parseByteToBinaryArray(byte) with 'byteValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbUtils.parseByteToBinaryArray(byte)"})
  void testParseByteToBinaryArrayWithByteValue() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {0, 1, 0, 0, 0, 0, 0, 1}, TbUtils.parseByteToBinaryArray((byte) 'A'));
  }

  /**
   * Test {@link TbUtils#parseByteToBinaryArray(byte, int)} with {@code byteValue}, {@code
   * binLength}.
   *
   * <p>Method under test: {@link TbUtils#parseByteToBinaryArray(byte, int)}
   */
  @Test
  @DisplayName("Test parseByteToBinaryArray(byte, int) with 'byteValue', 'binLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbUtils.parseByteToBinaryArray(byte, int)"})
  void testParseByteToBinaryArrayWithByteValueBinLength() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0, 0, 1}, TbUtils.parseByteToBinaryArray((byte) 'A', 3));
  }

  /**
   * Test {@link TbUtils#parseByteToBinaryArray(byte, int, boolean)} with {@code byteValue}, {@code
   * binLength}, {@code bigEndian}.
   *
   * <p>Method under test: {@link TbUtils#parseByteToBinaryArray(byte, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseByteToBinaryArray(byte, int, boolean) with 'byteValue', 'binLength', 'bigEndian'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbUtils.parseByteToBinaryArray(byte, int, boolean)"})
  void testParseByteToBinaryArrayWithByteValueBinLengthBigEndian() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0, 0, 1}, TbUtils.parseByteToBinaryArray((byte) 'A', 3, true));
  }

  /**
   * Test {@link TbUtils#parseByteToBinaryArray(byte, int, boolean)} with {@code byteValue}, {@code
   * binLength}, {@code bigEndian}.
   *
   * <p>Method under test: {@link TbUtils#parseByteToBinaryArray(byte, int, boolean)}
   */
  @Test
  @DisplayName(
      "Test parseByteToBinaryArray(byte, int, boolean) with 'byteValue', 'binLength', 'bigEndian'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbUtils.parseByteToBinaryArray(byte, int, boolean)"})
  void testParseByteToBinaryArrayWithByteValueBinLengthBigEndian2() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {1}, TbUtils.parseByteToBinaryArray((byte) 'A', 1, false));
  }

  /**
   * Test {@link TbUtils#parseBytesToBinaryArray(byte[])} with {@code bytesValue}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesToBinaryArray(byte[])}
   */
  @Test
  @DisplayName("Test parseBytesToBinaryArray(byte[]) with 'bytesValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbUtils.parseBytesToBinaryArray(byte[])"})
  void testParseBytesToBinaryArrayWithBytesValue() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0,
          0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1,
          1, 0, 0, 0
        },
        TbUtils.parseBytesToBinaryArray("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TbUtils#parseBytesToBinaryArray(byte[], int)} with {@code bytesValue}, {@code
   * binLength}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesToBinaryArray(byte[], int)}
   */
  @Test
  @DisplayName("Test parseBytesToBinaryArray(byte[], int) with 'bytesValue', 'binLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbUtils.parseBytesToBinaryArray(byte[], int)"})
  void testParseBytesToBinaryArrayWithBytesValueBinLength() throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {0, 0, 0}, TbUtils.parseBytesToBinaryArray("AXAXAXAX".getBytes("UTF-8"), 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToBinaryArray(List, int)} with {@code listValue}, {@code
   * binLength}.
   *
   * <p>Method under test: {@link TbUtils#parseBytesToBinaryArray(List, int)}
   */
  @Test
  @DisplayName("Test parseBytesToBinaryArray(List, int) with 'listValue', 'binLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbUtils.parseBytesToBinaryArray(List, int)"})
  void testParseBytesToBinaryArrayWithListValueBinLength() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0, 0, 0}, TbUtils.parseBytesToBinaryArray(new ArrayList<>(), 3));
  }

  /**
   * Test {@link TbUtils#parseBytesToBinaryArray(List)} with {@code listValue}.
   *
   * <ul>
   *   <li>Then return empty array of {@code byte}.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBytesToBinaryArray(List)}
   */
  @Test
  @DisplayName(
      "Test parseBytesToBinaryArray(List) with 'listValue'; then return empty array of byte")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbUtils.parseBytesToBinaryArray(List)"})
  void testParseBytesToBinaryArrayWithListValue_thenReturnEmptyArrayOfByte() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {}, TbUtils.parseBytesToBinaryArray(new ArrayList<>()));
  }

  /**
   * Test {@link TbUtils#parseLongToBinaryArray(long)} with {@code longValue}.
   *
   * <p>Method under test: {@link TbUtils#parseLongToBinaryArray(long)}
   */
  @Test
  @DisplayName("Test parseLongToBinaryArray(long) with 'longValue'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbUtils.parseLongToBinaryArray(long)"})
  void testParseLongToBinaryArrayWithLongValue() {
    // Arrange, Act and Assert
    assertArrayEquals(
        new byte[] {
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
          0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0,
          1, 0, 1, 0
        },
        TbUtils.parseLongToBinaryArray(42L));
  }

  /**
   * Test {@link TbUtils#parseLongToBinaryArray(long, int)} with {@code longValue}, {@code
   * binLength}.
   *
   * <p>Method under test: {@link TbUtils#parseLongToBinaryArray(long, int)}
   */
  @Test
  @DisplayName("Test parseLongToBinaryArray(long, int) with 'longValue', 'binLength'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"byte[] TbUtils.parseLongToBinaryArray(long, int)"})
  void testParseLongToBinaryArrayWithLongValueBinLength() {
    // Arrange, Act and Assert
    assertArrayEquals(new byte[] {0, 1, 0}, TbUtils.parseLongToBinaryArray(42L, 3));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(byte[], int, int)} with {@code bytesValue}, {@code
   * offset}, {@code length}.
   *
   * <ul>
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(byte[], int, int) with 'bytesValue', 'offset', 'length'; then return five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(byte[], int, int)"})
  void testParseBinaryArrayToIntWithBytesValueOffsetLength_thenReturnFive()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(5, TbUtils.parseBinaryArrayToInt("AXAXAXAX".getBytes("UTF-8"), 0, 3));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(byte[], int, int)} with {@code bytesValue}, {@code
   * offset}, {@code length}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(byte[], int, int) with 'bytesValue', 'offset', 'length'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(byte[], int, int)"})
  void testParseBinaryArrayToIntWithBytesValueOffsetLength_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, TbUtils.parseBinaryArrayToInt(new byte[] {1}, 0, 3));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(byte[], int, int)} with {@code bytesValue}, {@code
   * offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return minus three.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(byte[], int, int) with 'bytesValue', 'offset', 'length'; when 'A'; then return minus three")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(byte[], int, int)"})
  void testParseBinaryArrayToIntWithBytesValueOffsetLength_whenA_thenReturnMinusThree() {
    // Arrange, Act and Assert
    assertEquals(
        -3, TbUtils.parseBinaryArrayToInt(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0, 3));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(byte[], int, int)} with {@code bytesValue}, {@code
   * offset}, {@code length}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return five.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(byte[], int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(byte[], int, int) with 'bytesValue', 'offset', 'length'; when two; then return five")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(byte[], int, int)"})
  void testParseBinaryArrayToIntWithBytesValueOffsetLength_whenTwo_thenReturnFive()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(5, TbUtils.parseBinaryArrayToInt("AXAXAXAX".getBytes("UTF-8"), 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(byte[], int)} with {@code bytesValue}, {@code
   * offset}.
   *
   * <ul>
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(byte[], int) with 'bytesValue', 'offset'; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(byte[], int)"})
  void testParseBinaryArrayToIntWithBytesValueOffset_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, TbUtils.parseBinaryArrayToInt(new byte[] {1}, 0));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(byte[], int)} with {@code bytesValue}, {@code
   * offset}.
   *
   * <ul>
   *   <li>Then return one hundred seventy.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(byte[], int) with 'bytesValue', 'offset'; then return one hundred seventy")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(byte[], int)"})
  void testParseBinaryArrayToIntWithBytesValueOffset_thenReturnOneHundredSeventy()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(170, TbUtils.parseBinaryArrayToInt("AXAXAXAX".getBytes("UTF-8"), 0));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(byte[], int)} with {@code bytesValue}, {@code
   * offset}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return minus eighty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(byte[], int) with 'bytesValue', 'offset'; when 'A'; then return minus eighty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(byte[], int)"})
  void testParseBinaryArrayToIntWithBytesValueOffset_whenA_thenReturnMinusEightySix() {
    // Arrange, Act and Assert
    assertEquals(
        -86, TbUtils.parseBinaryArrayToInt(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}, 0));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(byte[], int)} with {@code bytesValue}, {@code
   * offset}.
   *
   * <ul>
   *   <li>When two.
   *   <li>Then return forty-two.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(byte[], int)}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(byte[], int) with 'bytesValue', 'offset'; when two; then return forty-two")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(byte[], int)"})
  void testParseBinaryArrayToIntWithBytesValueOffset_whenTwo_thenReturnFortyTwo()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(42, TbUtils.parseBinaryArrayToInt("AXAXAXAX".getBytes("UTF-8"), 2));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(byte[])} with {@code bytesValue}.
   *
   * <ul>
   *   <li>Then return one hundred seventy.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(byte[])}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(byte[]) with 'bytesValue'; then return one hundred seventy")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(byte[])"})
  void testParseBinaryArrayToIntWithBytesValue_thenReturnOneHundredSeventy()
      throws UnsupportedEncodingException {
    // Arrange, Act and Assert
    assertEquals(170, TbUtils.parseBinaryArrayToInt("AXAXAXAX".getBytes("UTF-8")));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(byte[])} with {@code bytesValue}.
   *
   * <ul>
   *   <li>When {@code A}.
   *   <li>Then return minus eighty-six.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(byte[])}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(byte[]) with 'bytesValue'; when 'A'; then return minus eighty-six")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(byte[])"})
  void testParseBinaryArrayToIntWithBytesValue_whenA_thenReturnMinusEightySix() {
    // Arrange, Act and Assert
    assertEquals(
        -86, TbUtils.parseBinaryArrayToInt(new byte[] {1, 'X', 'A', 'X', 'A', 'X', 'A', 'X'}));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(byte[])} with {@code bytesValue}.
   *
   * <ul>
   *   <li>When array of {@code byte} with one.
   *   <li>Then return one.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(byte[])}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(byte[]) with 'bytesValue'; when array of byte with one; then return one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(byte[])"})
  void testParseBinaryArrayToIntWithBytesValue_whenArrayOfByteWithOne_thenReturnOne() {
    // Arrange, Act and Assert
    assertEquals(1, TbUtils.parseBinaryArrayToInt(new byte[] {1}));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(List, int, int)} with {@code listValue}, {@code
   * offset}, {@code length}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(List, int, int)}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(List, int, int) with 'listValue', 'offset', 'length'; when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(List, int, int)"})
  void testParseBinaryArrayToIntWithListValueOffsetLength_whenArrayList_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, TbUtils.parseBinaryArrayToInt(new ArrayList<>(), 2, 3));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(List, int)} with {@code listValue}, {@code offset}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(List, int)}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(List, int) with 'listValue', 'offset'; when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(List, int)"})
  void testParseBinaryArrayToIntWithListValueOffset_whenArrayList_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, TbUtils.parseBinaryArrayToInt(new ArrayList<>(), 2));
  }

  /**
   * Test {@link TbUtils#parseBinaryArrayToInt(List)} with {@code listValue}.
   *
   * <ul>
   *   <li>When {@link ArrayList#ArrayList()}.
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TbUtils#parseBinaryArrayToInt(List)}
   */
  @Test
  @DisplayName(
      "Test parseBinaryArrayToInt(List) with 'listValue'; when ArrayList(); then return zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int TbUtils.parseBinaryArrayToInt(List)"})
  void testParseBinaryArrayToIntWithListValue_whenArrayList_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(0, TbUtils.parseBinaryArrayToInt(new ArrayList<>()));
  }
}
