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
import org.junit.jupiter.api.Test;

class SessionExceptionDiffblueTest {
  /**
   * Method under test: {@link SessionException#SessionException(Exception)}
   */
  @Test
  void testNewSessionException() {
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
   * Method under test: {@link SessionException#SessionException(String)}
   */
  @Test
  void testNewSessionException2() {
    // Arrange and Act
    SessionException actualSessionException = new SessionException("Msg");

    // Assert
    assertEquals("Msg", actualSessionException.getMessage());
    assertNull(actualSessionException.getCause());
    assertEquals(0, actualSessionException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link SessionException#SessionException(String, Exception)}
   */
  @Test
  void testNewSessionException3() {
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
