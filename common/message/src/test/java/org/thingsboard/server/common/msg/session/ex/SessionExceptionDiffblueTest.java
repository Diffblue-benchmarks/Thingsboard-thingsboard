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
package org.thingsboard.server.common.msg.session.ex;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SessionExceptionDiffblueTest {
  /**
   * Test {@link SessionException#SessionException(Exception)}.
   * <ul>
   *   <li>Then return Message is {@code Exception: foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionException#SessionException(Exception)}
   */
  @Test
  @DisplayName("Test new SessionException(Exception); then return Message is 'java.lang.Exception: foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionException.<init>(Exception)", "void SessionException.<init>(String)",
      "void SessionException.<init>(String, Exception)"})
  void testNewSessionException_thenReturnMessageIsJavaLangExceptionFoo() {
    // Arrange
    Exception cause = new Exception("foo");

    // Act
    SessionException actualSessionException = new SessionException(cause);

    // Assert
    assertEquals("java.lang.Exception: foo", actualSessionException.getMessage());
    assertEquals(0, actualSessionException.getSuppressed().length);
    assertSame(cause, actualSessionException.getCause());
  }

  /**
   * Test {@link SessionException#SessionException(String)}.
   * <ul>
   *   <li>When {@code Msg}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionException#SessionException(String)}
   */
  @Test
  @DisplayName("Test new SessionException(String); when 'Msg'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionException.<init>(Exception)", "void SessionException.<init>(String)",
      "void SessionException.<init>(String, Exception)"})
  void testNewSessionException_whenMsg_thenReturnCauseIsNull() {
    // Arrange and Act
    SessionException actualSessionException = new SessionException("Msg");

    // Assert
    assertEquals("Msg", actualSessionException.getMessage());
    assertNull(actualSessionException.getCause());
    assertEquals(0, actualSessionException.getSuppressed().length);
  }

  /**
   * Test {@link SessionException#SessionException(String, Exception)}.
   * <ul>
   *   <li>When {@code Msg}.</li>
   *   <li>Then return Message is {@code Msg}.</li>
   * </ul>
   * <p>
   * Method under test: {@link SessionException#SessionException(String, Exception)}
   */
  @Test
  @DisplayName("Test new SessionException(String, Exception); when 'Msg'; then return Message is 'Msg'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void SessionException.<init>(Exception)", "void SessionException.<init>(String)",
      "void SessionException.<init>(String, Exception)"})
  void testNewSessionException_whenMsg_thenReturnMessageIsMsg() {
    // Arrange
    Exception cause = new Exception("foo");

    // Act
    SessionException actualSessionException = new SessionException("Msg", cause);

    // Assert
    assertEquals("Msg", actualSessionException.getMessage());
    assertEquals(0, actualSessionException.getSuppressed().length);
    assertSame(cause, actualSessionException.getCause());
  }
}
