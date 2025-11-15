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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.io.IOException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.EntityId;

class ExceptionUtilDiffblueTest {
  /**
   * Test {@link ExceptionUtil#lookupException(Throwable, Class)}.
   * <ul>
   *   <li>When {@link IOException#IOException(String)} with {@code foo}.</li>
   *   <li>Then return LocalizedMessage is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionUtil#lookupException(Throwable, Class)}
   */
  @Test
  @DisplayName("Test lookupException(Throwable, Class); when IOException(String) with 'foo'; then return LocalizedMessage is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Exception ExceptionUtil.lookupException(Throwable, Class)"})
  void testLookupException_whenIOExceptionWithFoo_thenReturnLocalizedMessageIsFoo() {
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
   * Test {@link ExceptionUtil#lookupException(Throwable, Class)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionUtil#lookupException(Throwable, Class)}
   */
  @Test
  @DisplayName("Test lookupException(Throwable, Class); when Throwable(); then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Exception ExceptionUtil.lookupException(Throwable, Class)"})
  void testLookupException_whenThrowable_thenReturnNull() {
    // Arrange
    Throwable source = new Throwable();
    Class<Exception> clazz = Exception.class;

    // Act and Assert
    assertNull(ExceptionUtil.lookupException(source, clazz));
  }

  /**
   * Test {@link ExceptionUtil#lookupExceptionInCause(Throwable, Class[])}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code foo}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionUtil#lookupExceptionInCause(Throwable, Class[])}
   */
  @Test
  @DisplayName("Test lookupExceptionInCause(Throwable, Class[]); then return LocalizedMessage is 'foo'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Exception ExceptionUtil.lookupExceptionInCause(Throwable, Class[])"})
  void testLookupExceptionInCause_thenReturnLocalizedMessageIsFoo() {
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
   * Test {@link ExceptionUtil#lookupExceptionInCause(Throwable, Class[])}.
   * <ul>
   *   <li>When {@code Exception}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ExceptionUtil#lookupExceptionInCause(Throwable, Class[])}
   */
  @Test
  @DisplayName("Test lookupExceptionInCause(Throwable, Class[]); when 'java.lang.Exception'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Exception ExceptionUtil.lookupExceptionInCause(Throwable, Class[])"})
  void testLookupExceptionInCause_whenJavaLangException_thenReturnNull() {
    // Arrange
    Throwable source = new Throwable();
    Class<Exception> forNameResult = Exception.class;

    // Act and Assert
    assertNull(ExceptionUtil.lookupExceptionInCause(source, forNameResult));
  }

  /**
   * Test {@link ExceptionUtil#toString(Exception, EntityId, boolean)} with {@code Exception}, {@code EntityId}, {@code boolean}.
   * <p>
   * Method under test: {@link ExceptionUtil#toString(Exception, EntityId, boolean)}
   */
  @Test
  @DisplayName("Test toString(Exception, EntityId, boolean) with 'Exception', 'EntityId', 'boolean'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"java.lang.String ExceptionUtil.toString(Exception, EntityId, boolean)"})
  void testToStringWithExceptionEntityIdBoolean() {
    // Arrange, Act and Assert
    assertEquals("Please contact system administrator", ExceptionUtil.toString(new Exception("foo"), null, false));
  }
}
