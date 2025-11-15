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
package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;

class KvUtilDiffblueTest {
  /**
   * Test {@link KvUtil#getStringValue(KvEntry)}.
   * <ul>
   *   <li>Then return {@link Boolean#TRUE} toString.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getStringValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getStringValue(KvEntry); then return TRUE toString")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String KvUtil.getStringValue(KvEntry)"})
  void testGetStringValue_thenReturnTrueToString() {
    // Arrange and Act
    String actualStringValue = KvUtil.getStringValue(new BooleanDataEntry("Key", true));

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualStringValue);
  }

  /**
   * Test {@link KvUtil#getStringValue(KvEntry)}.
   * <ul>
   *   <li>When {@link DoubleDataEntry#DoubleDataEntry(String, Double)} with {@code Key} and value is ten.</li>
   *   <li>Then return {@code 10.0}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getStringValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getStringValue(KvEntry); when DoubleDataEntry(String, Double) with 'Key' and value is ten; then return '10.0'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String KvUtil.getStringValue(KvEntry)"})
  void testGetStringValue_whenDoubleDataEntryWithKeyAndValueIsTen_thenReturn100() {
    // Arrange, Act and Assert
    assertEquals("10.0", KvUtil.getStringValue(new DoubleDataEntry("Key", 10.0d)));
  }

  /**
   * Test {@link KvUtil#getStringValue(KvEntry)}.
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getStringValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getStringValue(KvEntry); when JsonDataEntry(String, String) with 'Key' and value is '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String KvUtil.getStringValue(KvEntry)"})
  void testGetStringValue_whenJsonDataEntryWithKeyAndValueIs42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", KvUtil.getStringValue(new JsonDataEntry("Key", "42")));
  }

  /**
   * Test {@link KvUtil#getStringValue(KvEntry)}.
   * <ul>
   *   <li>When {@link LongDataEntry#LongDataEntry(String, Long)} with {@code Key} and value is forty-two.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getStringValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getStringValue(KvEntry); when LongDataEntry(String, Long) with 'Key' and value is forty-two; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String KvUtil.getStringValue(KvEntry)"})
  void testGetStringValue_whenLongDataEntryWithKeyAndValueIsFortyTwo_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", KvUtil.getStringValue(new LongDataEntry("Key", 42L)));
  }

  /**
   * Test {@link KvUtil#getStringValue(KvEntry)}.
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and value is {@code 42}.</li>
   *   <li>Then return {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getStringValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getStringValue(KvEntry); when StringDataEntry(String, String) with 'Key' and value is '42'; then return '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String KvUtil.getStringValue(KvEntry)"})
  void testGetStringValue_whenStringDataEntryWithKeyAndValueIs42_thenReturn42() {
    // Arrange, Act and Assert
    assertEquals("42", KvUtil.getStringValue(new StringDataEntry("Key", "42")));
  }

  /**
   * Test {@link KvUtil#getDoubleValue(KvEntry)}.
   * <ul>
   *   <li>Then return doubleValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getDoubleValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getDoubleValue(KvEntry); then return doubleValue is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Double KvUtil.getDoubleValue(KvEntry)"})
  void testGetDoubleValue_thenReturnDoubleValueIsOne() {
    // Arrange, Act and Assert
    assertEquals(1.0d, KvUtil.getDoubleValue(new BooleanDataEntry("Key", true)).doubleValue());
  }

  /**
   * Test {@link KvUtil#getDoubleValue(KvEntry)}.
   * <ul>
   *   <li>Then return doubleValue is ten.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getDoubleValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getDoubleValue(KvEntry); then return doubleValue is ten")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Double KvUtil.getDoubleValue(KvEntry)"})
  void testGetDoubleValue_thenReturnDoubleValueIsTen() {
    // Arrange, Act and Assert
    assertEquals(10.0d, KvUtil.getDoubleValue(new DoubleDataEntry("Key", 10.0d)).doubleValue());
  }

  /**
   * Test {@link KvUtil#getDoubleValue(KvEntry)}.
   * <ul>
   *   <li>Then return doubleValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getDoubleValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getDoubleValue(KvEntry); then return doubleValue is zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Double KvUtil.getDoubleValue(KvEntry)"})
  void testGetDoubleValue_thenReturnDoubleValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0.0d, KvUtil.getDoubleValue(new BooleanDataEntry("Key", false)).doubleValue());
  }

  /**
   * Test {@link KvUtil#getDoubleValue(KvEntry)}.
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getDoubleValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getDoubleValue(KvEntry); when JsonDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Double KvUtil.getDoubleValue(KvEntry)"})
  void testGetDoubleValue_whenJsonDataEntryWithKeyAndValueIs42() {
    // Arrange, Act and Assert
    assertEquals(42.0d, KvUtil.getDoubleValue(new JsonDataEntry("Key", "42")).doubleValue());
  }

  /**
   * Test {@link KvUtil#getDoubleValue(KvEntry)}.
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and {@code Value}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getDoubleValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getDoubleValue(KvEntry); when JsonDataEntry(String, String) with 'Key' and 'Value'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Double KvUtil.getDoubleValue(KvEntry)"})
  void testGetDoubleValue_whenJsonDataEntryWithKeyAndValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(KvUtil.getDoubleValue(new JsonDataEntry("Key", "Value")));
  }

  /**
   * Test {@link KvUtil#getDoubleValue(KvEntry)}.
   * <ul>
   *   <li>When {@link LongDataEntry#LongDataEntry(String, Long)} with {@code Key} and value is forty-two.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getDoubleValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getDoubleValue(KvEntry); when LongDataEntry(String, Long) with 'Key' and value is forty-two")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Double KvUtil.getDoubleValue(KvEntry)"})
  void testGetDoubleValue_whenLongDataEntryWithKeyAndValueIsFortyTwo() {
    // Arrange, Act and Assert
    assertEquals(42.0d, KvUtil.getDoubleValue(new LongDataEntry("Key", 42L)).doubleValue());
  }

  /**
   * Test {@link KvUtil#getDoubleValue(KvEntry)}.
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and value is {@code 42}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getDoubleValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getDoubleValue(KvEntry); when StringDataEntry(String, String) with 'Key' and value is '42'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Double KvUtil.getDoubleValue(KvEntry)"})
  void testGetDoubleValue_whenStringDataEntryWithKeyAndValueIs42() {
    // Arrange, Act and Assert
    assertEquals(42.0d, KvUtil.getDoubleValue(new StringDataEntry("Key", "42")).doubleValue());
  }

  /**
   * Test {@link KvUtil#getDoubleValue(KvEntry)}.
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and {@code Value}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getDoubleValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getDoubleValue(KvEntry); when StringDataEntry(String, String) with 'Key' and 'Value'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.Double KvUtil.getDoubleValue(KvEntry)"})
  void testGetDoubleValue_whenStringDataEntryWithKeyAndValue_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(KvUtil.getDoubleValue(new StringDataEntry("Key", "Value")));
  }

  /**
   * Test {@link KvUtil#getBoolValue(KvEntry)}.
   * <ul>
   *   <li>When {@link BooleanDataEntry#BooleanDataEntry(String, Boolean)} with {@code Key} and value is {@code true}.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getBoolValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getBoolValue(KvEntry); when BooleanDataEntry(String, Boolean) with 'Key' and value is 'true'; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean KvUtil.getBoolValue(KvEntry)"})
  void testGetBoolValue_whenBooleanDataEntryWithKeyAndValueIsTrue_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KvUtil.getBoolValue(new BooleanDataEntry("Key", true)));
  }

  /**
   * Test {@link KvUtil#getBoolValue(KvEntry)}.
   * <ul>
   *   <li>When {@link DoubleDataEntry#DoubleDataEntry(String, Double)} with {@code Key} and value is ten.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getBoolValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getBoolValue(KvEntry); when DoubleDataEntry(String, Double) with 'Key' and value is ten; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean KvUtil.getBoolValue(KvEntry)"})
  void testGetBoolValue_whenDoubleDataEntryWithKeyAndValueIsTen_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KvUtil.getBoolValue(new DoubleDataEntry("Key", 10.0d)));
  }

  /**
   * Test {@link KvUtil#getBoolValue(KvEntry)}.
   * <ul>
   *   <li>When {@link DoubleDataEntry#DoubleDataEntry(String, Double)} with {@code Key} and value is zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getBoolValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getBoolValue(KvEntry); when DoubleDataEntry(String, Double) with 'Key' and value is zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean KvUtil.getBoolValue(KvEntry)"})
  void testGetBoolValue_whenDoubleDataEntryWithKeyAndValueIsZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(KvUtil.getBoolValue(new DoubleDataEntry("Key", 0.0d)));
  }

  /**
   * Test {@link KvUtil#getBoolValue(KvEntry)}.
   * <ul>
   *   <li>When {@link JsonDataEntry#JsonDataEntry(String, String)} with {@code Key} and value is {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getBoolValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getBoolValue(KvEntry); when JsonDataEntry(String, String) with 'Key' and value is '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean KvUtil.getBoolValue(KvEntry)"})
  void testGetBoolValue_whenJsonDataEntryWithKeyAndValueIs42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(KvUtil.getBoolValue(new JsonDataEntry("Key", "42")));
  }

  /**
   * Test {@link KvUtil#getBoolValue(KvEntry)}.
   * <ul>
   *   <li>When {@link LongDataEntry#LongDataEntry(String, Long)} with {@code Key} and value is forty-two.</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getBoolValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getBoolValue(KvEntry); when LongDataEntry(String, Long) with 'Key' and value is forty-two; then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean KvUtil.getBoolValue(KvEntry)"})
  void testGetBoolValue_whenLongDataEntryWithKeyAndValueIsFortyTwo_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(KvUtil.getBoolValue(new LongDataEntry("Key", 42L)));
  }

  /**
   * Test {@link KvUtil#getBoolValue(KvEntry)}.
   * <ul>
   *   <li>When {@link LongDataEntry#LongDataEntry(String, Long)} with {@code Key} and value is zero.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getBoolValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getBoolValue(KvEntry); when LongDataEntry(String, Long) with 'Key' and value is zero; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean KvUtil.getBoolValue(KvEntry)"})
  void testGetBoolValue_whenLongDataEntryWithKeyAndValueIsZero_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(KvUtil.getBoolValue(new LongDataEntry("Key", 0L)));
  }

  /**
   * Test {@link KvUtil#getBoolValue(KvEntry)}.
   * <ul>
   *   <li>When {@link StringDataEntry#StringDataEntry(String, String)} with {@code Key} and value is {@code 42}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link KvUtil#getBoolValue(KvEntry)}
   */
  @Test
  @DisplayName("Test getBoolValue(KvEntry); when StringDataEntry(String, String) with 'Key' and value is '42'; then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Boolean KvUtil.getBoolValue(KvEntry)"})
  void testGetBoolValue_whenStringDataEntryWithKeyAndValueIs42_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(KvUtil.getBoolValue(new StringDataEntry("Key", "42")));
  }
}
