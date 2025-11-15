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
package org.thingsboard.server.transport.coap.client;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class TbCoapContentFormatUtilDiffblueTest {
  /**
   * Method under test: {@link TbCoapContentFormatUtil#getContentFormat(int, int)}
   */
  @Test
  void testGetContentFormat() {
    // Arrange, Act and Assert
    assertEquals(3, TbCoapContentFormatUtil.getContentFormat(3, 3));
    assertEquals(42, TbCoapContentFormatUtil.getContentFormat(-1, 42));
    assertEquals(42, TbCoapContentFormatUtil.getContentFormat(42, 3));
    assertEquals(3, TbCoapContentFormatUtil.getContentFormat(-1, 3));
  }

  /**
   * Method under test: {@link TbCoapContentFormatUtil#isStrict(int)}
   */
  @Test
  void testIsStrict() {
    // Arrange, Act and Assert
    assertFalse(TbCoapContentFormatUtil.isStrict(1));
    assertTrue(TbCoapContentFormatUtil.isStrict(42));
  }
}
