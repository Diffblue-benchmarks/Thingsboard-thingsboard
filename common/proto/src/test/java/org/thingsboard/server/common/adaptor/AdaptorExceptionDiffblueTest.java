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
package org.thingsboard.server.common.adaptor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class AdaptorExceptionDiffblueTest {
  /**
   * Method under test: {@link AdaptorException#AdaptorException()}
   */
  @Test
  void testNewAdaptorException() {
    // Arrange and Act
    AdaptorException actualAdaptorException = new AdaptorException();

    // Assert
    assertNull(actualAdaptorException.getMessage());
    assertNull(actualAdaptorException.getCause());
    assertEquals(0, actualAdaptorException.getSuppressed().length);
  }

  /**
   * Method under test: {@link AdaptorException#AdaptorException(Exception)}
   */
  @Test
  void testNewAdaptorException2() {
    // Arrange
    Exception cause = new Exception("foo");

    // Act
    AdaptorException actualAdaptorException = new AdaptorException(cause);

    // Assert
    assertEquals("java.lang.Exception: foo", actualAdaptorException.getMessage());
    assertEquals(0, actualAdaptorException.getSuppressed().length);
    assertSame(cause, actualAdaptorException.getCause());
  }

  /**
   * Method under test: {@link AdaptorException#AdaptorException(String)}
   */
  @Test
  void testNewAdaptorException3() {
    // Arrange and Act
    AdaptorException actualAdaptorException = new AdaptorException("Cause");

    // Assert
    assertEquals("Cause", actualAdaptorException.getMessage());
    assertNull(actualAdaptorException.getCause());
    assertEquals(0, actualAdaptorException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link AdaptorException#AdaptorException(String, Exception)}
   */
  @Test
  void testNewAdaptorException4() {
    // Arrange
    Exception cause = new Exception("foo");

    // Act
    AdaptorException actualAdaptorException = new AdaptorException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualAdaptorException.getMessage());
    assertEquals(0, actualAdaptorException.getSuppressed().length);
    assertSame(cause, actualAdaptorException.getCause());
  }
}
