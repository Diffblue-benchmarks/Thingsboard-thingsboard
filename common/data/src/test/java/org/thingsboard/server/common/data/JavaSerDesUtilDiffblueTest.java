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
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class JavaSerDesUtilDiffblueTest {
  /**
   * Test {@link JavaSerDesUtil#encode(Object)}, and {@link JavaSerDesUtil#decode(byte[])}.
   * <ul>
   *   <li>When {@code Msq}.</li>
   *   <li>Then return decode is {@code Msq}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JavaSerDesUtil#encode(Object)}
   *   <li>{@link JavaSerDesUtil#decode(byte[])}
   * </ul>
   */
  @Test
  @DisplayName("Test encode(Object), and decode(byte[]); when 'Msq'; then return decode is 'Msq'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JavaSerDesUtil.encode(Object)", "Object JavaSerDesUtil.decode(byte[])"})
  void testEncodeAndDecode_whenMsq_thenReturnDecodeIsMsq() {
    // Arrange, Act and Assert
    assertEquals("Msq", JavaSerDesUtil.decode(JavaSerDesUtil.encode("Msq")));
  }

  /**
   * Test {@link JavaSerDesUtil#encode(Object)}, and {@link JavaSerDesUtil#decode(byte[])}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return decode is {@code null}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link JavaSerDesUtil#encode(Object)}
   *   <li>{@link JavaSerDesUtil#decode(byte[])}
   * </ul>
   */
  @Test
  @DisplayName("Test encode(Object), and decode(byte[]); when 'null'; then return decode is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"byte[] JavaSerDesUtil.encode(Object)", "Object JavaSerDesUtil.decode(byte[])"})
  void testEncodeAndDecode_whenNull_thenReturnDecodeIsNull() {
    // Arrange, Act and Assert
    assertNull(JavaSerDesUtil.decode(JavaSerDesUtil.encode(null)));
  }
}
