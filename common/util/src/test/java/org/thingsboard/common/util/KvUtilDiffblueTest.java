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
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.kv.BooleanDataEntry;
import org.thingsboard.server.common.data.kv.DoubleDataEntry;
import org.thingsboard.server.common.data.kv.JsonDataEntry;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.data.kv.LongDataEntry;
import org.thingsboard.server.common.data.kv.StringDataEntry;

class KvUtilDiffblueTest {
  /**
   * Method under test: {@link KvUtil#getStringValue(KvEntry)}
   */
  @Test
  void testGetStringValue() {
    // Arrange, Act and Assert
    assertEquals("42", KvUtil.getStringValue(new JsonDataEntry("Key", "42")));
    assertEquals("42", KvUtil.getStringValue(new StringDataEntry("Key", "42")));
    assertEquals("10.0", KvUtil.getStringValue(new DoubleDataEntry("Key", 10.0d)));
    assertEquals("42", KvUtil.getStringValue(new LongDataEntry("Key", 42L)));
  }

  /**
   * Method under test: {@link KvUtil#getStringValue(KvEntry)}
   */
  @Test
  void testGetStringValue2() {
    // Arrange and Act
    String actualStringValue = KvUtil.getStringValue(new BooleanDataEntry("Key", true));

    // Assert
    assertEquals(Boolean.TRUE.toString(), actualStringValue);
  }

  /**
   * Method under test: {@link KvUtil#getDoubleValue(KvEntry)}
   */
  @Test
  void testGetDoubleValue() {
    // Arrange, Act and Assert
    assertEquals(42.0d, KvUtil.getDoubleValue(new JsonDataEntry("Key", "42")).doubleValue());
    assertNull(KvUtil.getDoubleValue(new JsonDataEntry("Key", "Value")));
    assertEquals(42.0d, KvUtil.getDoubleValue(new StringDataEntry("Key", "42")).doubleValue());
    assertNull(KvUtil.getDoubleValue(new StringDataEntry("Key", "Value")));
    assertEquals(1.0d, KvUtil.getDoubleValue(new BooleanDataEntry("Key", true)).doubleValue());
    assertEquals(0.0d, KvUtil.getDoubleValue(new BooleanDataEntry("Key", false)).doubleValue());
    assertEquals(10.0d, KvUtil.getDoubleValue(new DoubleDataEntry("Key", 10.0d)).doubleValue());
    assertEquals(42.0d, KvUtil.getDoubleValue(new LongDataEntry("Key", 42L)).doubleValue());
  }

  /**
   * Method under test: {@link KvUtil#getBoolValue(KvEntry)}
   */
  @Test
  void testGetBoolValue() {
    // Arrange, Act and Assert
    assertFalse(KvUtil.getBoolValue(new JsonDataEntry("Key", "42")));
    assertFalse(KvUtil.getBoolValue(new StringDataEntry("Key", "42")));
    assertTrue(KvUtil.getBoolValue(new BooleanDataEntry("Key", true)));
    assertTrue(KvUtil.getBoolValue(new DoubleDataEntry("Key", 10.0d)));
    assertFalse(KvUtil.getBoolValue(new DoubleDataEntry("Key", 0.0d)));
    assertTrue(KvUtil.getBoolValue(new LongDataEntry("Key", 42L)));
    assertFalse(KvUtil.getBoolValue(new LongDataEntry("Key", 0L)));
  }
}
