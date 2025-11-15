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
package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.input.DefaultCharAppender;
import org.mockito.Mockito;

class StringUtilsDiffblueTest {
  /**
   * Method under test: {@link StringUtils#isEmpty(String)}
   */
  @Test
  void testIsEmpty() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isEmpty("Source"));
    assertTrue(StringUtils.isEmpty(null));
    assertTrue(StringUtils.isEmpty(StringUtils.EMPTY));
  }

  /**
   * Method under test: {@link StringUtils#isBlank(String)}
   */
  @Test
  void testIsBlank() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isBlank("Source"));
    assertTrue(StringUtils.isBlank(null));
    assertTrue(StringUtils.isBlank(StringUtils.EMPTY));
    assertTrue(StringUtils.isBlank("\u0000"));
  }

  /**
   * Method under test: {@link StringUtils#isNotEmpty(String)}
   */
  @Test
  void testIsNotEmpty() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isNotEmpty("Source"));
    assertFalse(StringUtils.isNotEmpty(null));
    assertFalse(StringUtils.isNotEmpty(StringUtils.EMPTY));
  }

  /**
   * Method under test: {@link StringUtils#isNotBlank(String)}
   */
  @Test
  void testIsNotBlank() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isNotBlank("Source"));
    assertFalse(StringUtils.isNotBlank(null));
    assertFalse(StringUtils.isNotBlank(StringUtils.EMPTY));
    assertFalse(StringUtils.isNotBlank("\u0000"));
  }

  /**
   * Method under test: {@link StringUtils#notBlankOrDefault(String, String)}
   */
  @Test
  void testNotBlankOrDefault() {
    // Arrange, Act and Assert
    assertEquals("Src", StringUtils.notBlankOrDefault("Src", "Def"));
    assertEquals("Def", StringUtils.notBlankOrDefault(null, "Def"));
    assertEquals("Def", StringUtils.notBlankOrDefault(StringUtils.EMPTY, "Def"));
    assertEquals("Def", StringUtils.notBlankOrDefault("\u0000", "Def"));
  }

  /**
   * Method under test: {@link StringUtils#removeStart(String, String)}
   */
  @Test
  void testRemoveStart() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtils.removeStart("Str", "Remove"));
    assertNull(StringUtils.removeStart(null, null));
    assertEquals(StringUtils.EMPTY, StringUtils.removeStart(StringUtils.EMPTY, null));
    assertEquals("Str", StringUtils.removeStart("Str", null));
    assertEquals(StringUtils.EMPTY, StringUtils.removeStart("\u0000", "\u0000"));
  }

  /**
   * Method under test: {@link StringUtils#substringBefore(String, String)}
   */
  @Test
  void testSubstringBefore() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtils.substringBefore("Str", "Separator"));
    assertNull(StringUtils.substringBefore(null, null));
    assertEquals(StringUtils.EMPTY, StringUtils.substringBefore(StringUtils.EMPTY, null));
    assertEquals("Str", StringUtils.substringBefore("Str", null));
    assertEquals(StringUtils.EMPTY, StringUtils.substringBefore("Str", StringUtils.EMPTY));
    assertEquals(StringUtils.EMPTY, StringUtils.substringBefore("\u0000", "\u0000"));
  }

  /**
   * Method under test:
   * {@link StringUtils#substringBetween(String, String, String)}
   */
  @Test
  void testSubstringBetween() {
    // Arrange, Act and Assert
    assertNull(StringUtils.substringBetween("Str", "Open", "Close"));
    assertNull(StringUtils.substringBetween(null, null, null));
    assertNull(StringUtils.substringBetween("Str", null, null));
    assertNull(StringUtils.substringBetween("Str", "Open", null));
    assertNull(StringUtils.substringBetween("Str", StringUtils.EMPTY, "Close"));
    assertEquals(StringUtils.EMPTY, StringUtils.substringBetween("Str", StringUtils.EMPTY, StringUtils.EMPTY));
  }

  /**
   * Method under test: {@link StringUtils#obfuscate(String, int, char, int, int)}
   */
  @Test
  void testObfuscate() {
    // Arrange, Act and Assert
    assertEquals("IAAut", StringUtils.obfuscate("Input", 1, 'A', 1, 3));
    assertEquals("IAAut", StringUtils.obfuscate("Input", 0, 'A', 1, 3));
    assertEquals("Input", StringUtils.obfuscate("Input", 1, 'A', 1, 1));
  }

  /**
   * Method under test: {@link StringUtils#split(String, int)}
   */
  @Test
  void testSplit() {
    // Arrange and Act
    Iterable<String> actualSplitResult = StringUtils.split("42", 3);
    Iterator<String> actualIteratorResult = actualSplitResult.iterator();

    // Assert
    assertEquals("42", actualIteratorResult.next());
    assertFalse(actualIteratorResult.hasNext());
  }

  /**
   * Method under test: {@link StringUtils#equalsIgnoreCase(String, String)}
   */
  @Test
  void testEqualsIgnoreCase() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.equalsIgnoreCase("Str1", "Str2"));
    assertTrue(StringUtils.equalsIgnoreCase(null, null));
    assertFalse(StringUtils.equalsIgnoreCase(null, "Str2"));
  }

  /**
   * Method under test: {@link StringUtils#join(String[], String)}
   */
  @Test
  void testJoin() {
    // Arrange, Act and Assert
    assertEquals("Key Array", StringUtils.join(new String[]{"Key Array"}, "Lwm2m Separator Path"));
    assertNull(StringUtils.join(null, "Lwm2m Separator Path"));
  }

  /**
   * Method under test: {@link StringUtils#trimToNull(String)}
   */
  @Test
  void testTrimToNull() {
    // Arrange, Act and Assert
    assertEquals("To String", StringUtils.trimToNull("To String"));
    assertNull(StringUtils.trimToNull(null));
    assertNull(StringUtils.trimToNull("\u0000"));
  }

  /**
   * Method under test: {@link StringUtils#isNoneEmpty(String)}
   */
  @Test
  void testIsNoneEmpty() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isNoneEmpty("Str"));
    assertFalse(StringUtils.isNoneEmpty(StringUtils.EMPTY));
  }

  /**
   * Method under test: {@link StringUtils#endsWith(String, String)}
   */
  @Test
  void testEndsWith() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.endsWith("Str", "Suffix"));
    assertTrue(StringUtils.endsWith(null, null));
    assertFalse(StringUtils.endsWith(null, "Suffix"));
    assertFalse(StringUtils.endsWith("Str", null));
    assertFalse(StringUtils.endsWith("\\s*,\\s*", "Suffix"));
  }

  /**
   * Method under test: {@link StringUtils#hasLength(String)}
   */
  @Test
  void testHasLength() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.hasLength("Str"));
    assertFalse(StringUtils.hasLength(null));
  }

  /**
   * Method under test: {@link StringUtils#isNoneBlank(String[])}
   */
  @Test
  void testIsNoneBlank() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.isNoneBlank("Str"));
    assertFalse(StringUtils.isNoneBlank(StringUtils.EMPTY));
    assertTrue(StringUtils.isNoneBlank());
  }

  /**
   * Method under test: {@link StringUtils#hasText(String)}
   */
  @Test
  void testHasText() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.hasText("Str"));
    assertFalse(StringUtils.hasText(null));
  }

  /**
   * Method under test: {@link StringUtils#defaultString(String, String)}
   */
  @Test
  void testDefaultString() {
    // Arrange, Act and Assert
    assertEquals("foo", StringUtils.defaultString("foo", "42"));
  }

  /**
   * Method under test: {@link StringUtils#isNumeric(String)}
   */
  @Test
  void testIsNumeric() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.isNumeric("Str"));
    assertFalse(StringUtils.isNumeric(null));
    assertTrue(StringUtils.isNumeric("42"));
    assertFalse(StringUtils.isNumeric(StringUtils.EMPTY));
  }

  /**
   * Method under test: {@link StringUtils#equals(String, String)}
   */
  @Test
  void testEquals() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.equals("Str1", "Str2"));
    assertFalse(StringUtils.equals("\u0000", "Str2"));
    assertTrue(StringUtils.equals("\u0000", "\u0000"));
  }

  /**
   * Method under test: {@link StringUtils#equalsAny(String, List)}
   */
  @Test
  void testEqualsAny() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.equalsAny("String", new ArrayList<>()));
    assertFalse(StringUtils.equalsAny("String", "Other Strings"));
    assertTrue(StringUtils.equalsAny("\u0000", "\u0000"));
  }

  /**
   * Method under test: {@link StringUtils#equalsAny(String, List)}
   */
  @Test
  void testEqualsAny2() {
    // Arrange
    ArrayList<String> otherStrings = new ArrayList<>();
    otherStrings.add("foo");

    // Act and Assert
    assertFalse(StringUtils.equalsAny("String", otherStrings));
  }

  /**
   * Method under test: {@link StringUtils#equalsAny(String, List)}
   */
  @Test
  void testEqualsAny3() {
    // Arrange
    ArrayList<String> otherStrings = new ArrayList<>();
    otherStrings.add("42");
    otherStrings.add("foo");

    // Act and Assert
    assertFalse(StringUtils.equalsAny("String", otherStrings));
  }

  /**
   * Method under test: {@link StringUtils#equalsAny(String, List)}
   */
  @Test
  void testEqualsAny4() {
    // Arrange
    ArrayList<String> otherStrings = new ArrayList<>();
    otherStrings.add("42");
    otherStrings.add("foo");

    // Act and Assert
    assertTrue(StringUtils.equalsAny("42", otherStrings));
  }

  /**
   * Method under test: {@link StringUtils#equalsAnyIgnoreCase(String, String[])}
   */
  @Test
  void testEqualsAnyIgnoreCase() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.equalsAnyIgnoreCase("String", "Other Strings"));
    assertFalse(StringUtils.equalsAnyIgnoreCase(null, "Other Strings"));
  }

  /**
   * Method under test: {@link StringUtils#substringBeforeLast(String, String)}
   */
  @Test
  void testSubstringBeforeLast() {
    // Arrange, Act and Assert
    assertEquals("Str", StringUtils.substringBeforeLast("Str", "Separator"));
    assertNull(StringUtils.substringBeforeLast(null, null));
    assertEquals("Str", StringUtils.substringBeforeLast("Str", null));
    assertEquals(StringUtils.EMPTY, StringUtils.substringBeforeLast(StringUtils.EMPTY, "Separator"));
    assertEquals(StringUtils.EMPTY, StringUtils.substringBeforeLast("\u0000", "\u0000"));
  }

  /**
   * Method under test: {@link StringUtils#substringAfterLast(String, String)}
   */
  @Test
  void testSubstringAfterLast() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.substringAfterLast("Str", "Sep"));
    assertNull(StringUtils.substringAfterLast(null, null));
    assertEquals(StringUtils.EMPTY, StringUtils.substringAfterLast("Str", null));
    assertEquals(StringUtils.EMPTY, StringUtils.substringAfterLast(StringUtils.EMPTY, "Sep"));
    assertEquals(StringUtils.EMPTY, StringUtils.substringAfterLast("\u0000", "\u0000"));
  }

  /**
   * Method under test: {@link StringUtils#containedByAny(String, String[])}
   */
  @Test
  void testContainedByAny() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.containedByAny("Search String", "Strings"));
    assertFalse(StringUtils.containedByAny(null, "Strings"));
    assertTrue(StringUtils.containedByAny(StringUtils.EMPTY, "Strings"));
  }

  /**
   * Method under test: {@link StringUtils#contains(CharSequence, CharSequence)}
   */
  @Test
  void testContains() {
    // Arrange, Act and Assert
    assertTrue(StringUtils.contains(StringUtils.EMPTY, StringUtils.EMPTY));
    assertFalse(StringUtils.contains(null, null));
    assertFalse(StringUtils.contains(StringUtils.EMPTY, null));
    assertTrue(StringUtils.contains(new StringBuilder("foo"), StringUtils.EMPTY));
    assertTrue(StringUtils.contains(new StringBuffer("foo"), StringUtils.EMPTY));
    assertTrue(StringUtils.contains(new DefaultCharAppender(3, "42", 4), StringUtils.EMPTY));
    assertFalse(StringUtils.contains(StringUtils.EMPTY, CacheConstants.ALARM_TYPES_CACHE));
  }

  /**
   * Method under test: {@link StringUtils#contains0x00(String)}
   */
  @Test
  void testContains0x00() {
    // Arrange, Act and Assert
    assertFalse(StringUtils.contains0x00("foo"));
    assertFalse(StringUtils.contains0x00(null));
    assertTrue(StringUtils.contains0x00("\u0000"));
  }

  /**
   * Method under test: {@link StringUtils#randomNumeric(int)}
   */
  @Test
  void testRandomNumeric() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.randomNumeric(0));
  }

  /**
   * Method under test: {@link StringUtils#random(int)}
   */
  @Test
  void testRandom() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.random(0));
    assertEquals(StringUtils.EMPTY, StringUtils.random(0, null));
  }

  /**
   * Method under test: {@link StringUtils#randomAlphanumeric(int)}
   */
  @Test
  void testRandomAlphanumeric() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.randomAlphanumeric(0));
  }

  /**
   * Method under test: {@link StringUtils#randomAlphabetic(int)}
   */
  @Test
  void testRandomAlphabetic() {
    // Arrange, Act and Assert
    assertEquals(StringUtils.EMPTY, StringUtils.randomAlphabetic(0));
  }

  /**
   * Method under test: {@link StringUtils#truncate(String, int)}
   */
  @Test
  void testTruncate() {
    // Arrange, Act and Assert
    assertEquals("Str...[truncated 3 symbols]", StringUtils.truncate("String", 3));
    assertNull(StringUtils.truncate(null, 0));
    assertEquals("String", StringUtils.truncate("String", 0));
    assertEquals("\u0000", StringUtils.truncate("\u0000", 3));
    assertNull(StringUtils.truncate(null, 0, mock(Function.class)));
    assertEquals("String", StringUtils.truncate("String", 0, mock(Function.class)));
    assertEquals("\u0000", StringUtils.truncate("\u0000", 3, mock(Function.class)));
  }

  /**
   * Method under test: {@link StringUtils#truncate(String, int, Function)}
   */
  @Test
  void testTruncate2() {
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
   * Method under test: {@link StringUtils#splitByCommaWithoutQuotes(String)}
   */
  @Test
  void testSplitByCommaWithoutQuotes() {
    // Arrange and Act
    List<String> actualSplitByCommaWithoutQuotesResult = StringUtils.splitByCommaWithoutQuotes("42");

    // Assert
    assertEquals(1, actualSplitByCommaWithoutQuotesResult.size());
    assertEquals("42", actualSplitByCommaWithoutQuotesResult.get(0));
  }
}
