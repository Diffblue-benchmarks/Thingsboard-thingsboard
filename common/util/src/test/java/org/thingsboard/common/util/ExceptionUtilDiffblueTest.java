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
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class ExceptionUtilDiffblueTest {
  /**
   * Method under test: {@link ExceptionUtil#lookupException(Throwable, Class)}
   */
  @Test
  void testLookupException() {
    // Arrange
    Throwable source = new Throwable();
    Class<Exception> clazz = Exception.class;

    // Act and Assert
    assertNull(ExceptionUtil.lookupException(source, clazz));
  }

  /**
   * Method under test: {@link ExceptionUtil#lookupException(Throwable, Class)}
   */
  @Test
  void testLookupException2() {
    // Arrange
    IOException source = new IOException("foo");
    Class<Exception> clazz = Exception.class;

    // Act
    Exception actualLookupExceptionResult = ExceptionUtil.lookupException(source, clazz);

    // Assert
    assertEquals("foo", actualLookupExceptionResult.getLocalizedMessage());
    assertEquals("foo", actualLookupExceptionResult.getMessage());
    assertNull(actualLookupExceptionResult.getCause());
    assertEquals(0, actualLookupExceptionResult.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ExceptionUtil#lookupExceptionInCause(Throwable, Class[])}
   */
  @Test
  void testLookupExceptionInCause() {
    // Arrange
    Throwable source = new Throwable();
    Class<Exception> forNameResult = Exception.class;

    // Act and Assert
    assertNull(ExceptionUtil.lookupExceptionInCause(source, forNameResult));
  }

  /**
   * Method under test:
   * {@link ExceptionUtil#lookupExceptionInCause(Throwable, Class[])}
   */
  @Test
  void testLookupExceptionInCause2() {
    // Arrange
    IOException source = new IOException("foo");
    Class<Exception> forNameResult = Exception.class;

    // Act
    Exception actualLookupExceptionInCauseResult = ExceptionUtil.lookupExceptionInCause(source, forNameResult);

    // Assert
    assertEquals("foo", actualLookupExceptionInCauseResult.getLocalizedMessage());
    assertEquals("foo", actualLookupExceptionInCauseResult.getMessage());
    assertNull(actualLookupExceptionInCauseResult.getCause());
    assertEquals(0, actualLookupExceptionInCauseResult.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ExceptionUtil#toString(Exception, EntityId, boolean)}
   */
  @Test
  void testToString() {
    // Arrange, Act and Assert
    assertEquals("Please contact system administrator", ExceptionUtil.toString(new Exception("foo"), null, false));
  }
}
