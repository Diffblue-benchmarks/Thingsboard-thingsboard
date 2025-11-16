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
package org.thingsboard.rule.engine.api.sms.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SmsParseExceptionDiffblueTest {
  /**
   * Test {@link SmsParseException#SmsParseException(String)}.
   *
   * <ul>
   *   <li>When {@code Msg}.
   *   <li>Then return Cause is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link SmsParseException#SmsParseException(String)}
   */
  @Test
  @DisplayName("Test new SmsParseException(String); when 'Msg'; then return Cause is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmsParseException.<init>(String)",
    "void SmsParseException.<init>(String, Throwable)"
  })
  void testNewSmsParseException_whenMsg_thenReturnCauseIsNull() {
    // Arrange and Act
    SmsParseException actualSmsParseException = new SmsParseException("Msg");

    // Assert
    assertEquals("Msg", actualSmsParseException.getMessage());
    assertNull(actualSmsParseException.getCause());
    assertEquals(0, actualSmsParseException.getSuppressed().length);
  }

  /**
   * Test {@link SmsParseException#SmsParseException(String, Throwable)}.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Cause is {@link Throwable#Throwable()}.
   * </ul>
   *
   * <p>Method under test: {@link SmsParseException#SmsParseException(String, Throwable)}
   */
  @Test
  @DisplayName(
      "Test new SmsParseException(String, Throwable); when Throwable(); then return Cause is Throwable()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SmsParseException.<init>(String)",
    "void SmsParseException.<init>(String, Throwable)"
  })
  void testNewSmsParseException_whenThrowable_thenReturnCauseIsThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    SmsParseException actualSmsParseException = new SmsParseException("Msg", cause);

    // Assert
    assertEquals("Msg", actualSmsParseException.getMessage());
    assertEquals(0, actualSmsParseException.getSuppressed().length);
    assertSame(cause, actualSmsParseException.getCause());
  }
}
