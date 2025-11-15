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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class RegexUtilsDiffblueTest {
  /**
   * Method under test: {@link RegexUtils#replace(String, String, Function)}
   */
  @Test
  void testReplace() {
    // Arrange, Act and Assert
    assertEquals("Input", RegexUtils.replace("Input", "Pattern", mock(Function.class)));
    assertEquals("foo", RegexUtils.replace("foo", RegexUtils.UUID_PATTERN, mock(UnaryOperator.class)));
  }

  /**
   * Method under test: {@link RegexUtils#replace(String, Pattern, UnaryOperator)}
   */
  @Test
  void testReplace2() {
    // Arrange
    UnaryOperator<String> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    String actualReplaceResult = RegexUtils.replace("99999999-9999-9999-9999-999999999999", RegexUtils.UUID_PATTERN,
        replacer);

    // Assert
    verify(replacer).apply(eq("99999999-9999-9999-9999-999999999999"));
    assertEquals("Apply", actualReplaceResult);
  }

  /**
   * Method under test: {@link RegexUtils#replace(String, Pattern, UnaryOperator)}
   */
  @Test
  void testReplace3() {
    // Arrange
    Pattern pattern = Pattern.compile("");
    UnaryOperator<String> replacer = mock(UnaryOperator.class);
    when(replacer.apply(Mockito.<String>any())).thenReturn("Apply");

    // Act
    String actualReplaceResult = RegexUtils.replace("99999999-9999-9999-9999-999999999999", pattern, replacer);

    // Assert
    verify(replacer, atLeast(1)).apply(eq(""));
    assertEquals("Apply9Apply9Apply9Apply9Apply9Apply9Apply9Apply9Apply-Apply9Apply9Apply9Apply9Apply-Apply9Apply9Appl"
        + "y9Apply9Apply-Apply9Apply9Apply9Apply9Apply-Apply9Apply9Apply9Apply9Apply9Apply9Apply9Apply9Apply9Ap"
        + "ply9Apply9Apply9Apply", actualReplaceResult);
  }

  /**
   * Method under test: {@link RegexUtils#matches(String, Pattern)}
   */
  @Test
  void testMatches() {
    // Arrange, Act and Assert
    assertFalse(RegexUtils.matches("Input", RegexUtils.UUID_PATTERN));
    assertTrue(RegexUtils.matches("99999999-9999-9999-9999-999999999999", RegexUtils.UUID_PATTERN));
  }

  /**
   * Method under test: {@link RegexUtils#getMatch(String, Pattern, int)}
   */
  @Test
  void testGetMatch() {
    // Arrange, Act and Assert
    assertNull(RegexUtils.getMatch("Input", RegexUtils.UUID_PATTERN, 1));
    assertNull(RegexUtils.getMatch("99999999-9999-9999-9999-999999999999", RegexUtils.UUID_PATTERN, 1));
    assertEquals("99999999-9999-9999-9999-999999999999",
        RegexUtils.getMatch("99999999-9999-9999-9999-999999999999", RegexUtils.UUID_PATTERN, 0));
  }
}
