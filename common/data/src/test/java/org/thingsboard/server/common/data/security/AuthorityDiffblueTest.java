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
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class AuthorityDiffblueTest {
  /**
   * Test {@link Authority#getCode()}.
   *
   * <p>Method under test: {@link Authority#getCode()}
   */
  @Test
  @DisplayName("Test getCode()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"int Authority.getCode()"})
  void testGetCode() {
    // Arrange, Act and Assert
    assertEquals(0, Authority.valueOf("SYS_ADMIN").getCode());
  }

  /**
   * Test {@link Authority#parse(String)}.
   *
   * <ul>
   *   <li>When {@code 42}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Authority#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String); when '42'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Authority Authority.parse(String)"})
  void testParse_when42_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Authority.parse("42"));
  }

  /**
   * Test {@link Authority#parse(String)}.
   *
   * <ul>
   *   <li>When {@code CUSTOMER_USER}.
   *   <li>Then return {@code CUSTOMER_USER}.
   * </ul>
   *
   * <p>Method under test: {@link Authority#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String); when 'CUSTOMER_USER'; then return 'CUSTOMER_USER'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Authority Authority.parse(String)"})
  void testParse_whenCustomerUser_thenReturnCustomerUser() {
    // Arrange, Act and Assert
    assertEquals(Authority.CUSTOMER_USER, Authority.parse("CUSTOMER_USER"));
  }

  /**
   * Test {@link Authority#parse(String)}.
   *
   * <ul>
   *   <li>When empty string.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Authority#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String); when empty string; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Authority Authority.parse(String)"})
  void testParse_whenEmptyString_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Authority.parse(""));
  }

  /**
   * Test {@link Authority#parse(String)}.
   *
   * <ul>
   *   <li>When {@code null}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link Authority#parse(String)}
   */
  @Test
  @DisplayName("Test parse(String); when 'null'; then return 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Authority Authority.parse(String)"})
  void testParse_whenNull_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(Authority.parse(null));
  }
}
