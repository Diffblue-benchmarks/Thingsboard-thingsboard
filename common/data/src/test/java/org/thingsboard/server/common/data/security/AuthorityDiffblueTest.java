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
package org.thingsboard.server.common.data.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;

class AuthorityDiffblueTest {
  /**
   * Method under test: {@link Authority#getCode()}
   */
  @Test
  void testGetCode() {
    // Arrange, Act and Assert
    assertEquals(0, Authority.valueOf("SYS_ADMIN").getCode());
  }

  /**
   * Method under test: {@link Authority#parse(String)}
   */
  @Test
  void testParse() {
    // Arrange, Act and Assert
    assertNull(Authority.parse("42"));
    assertNull(Authority.parse(null));
    assertEquals(Authority.CUSTOMER_USER, Authority.parse("CUSTOMER_USER"));
    assertNull(Authority.parse(""));
  }
}
