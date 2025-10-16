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
package org.thingsboard.server.common.data.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ThingsboardExceptionDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>Then return ErrorCode is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ThingsboardException#ThingsboardException()}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; then return ErrorCode is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThingsboardException.<init>()",
    "void ThingsboardException.<init>(String, Throwable, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(String, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(Throwable, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(ThingsboardErrorCode)",
    "ThingsboardErrorCode ThingsboardException.getErrorCode()"
  })
  void testGettersAndSetters_thenReturnErrorCodeIsNull() {
    // Arrange and Act
    ThingsboardException actualThingsboardException = new ThingsboardException();
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertNull(actualThingsboardException.getMessage());
    assertNull(actualThingsboardException.getCause());
    assertNull(actualErrorCode);
    assertEquals(0, actualThingsboardException.getSuppressed().length);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ThingsboardException#ThingsboardException(String, Throwable,
   *       ThingsboardErrorCode)}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThingsboardException.<init>()",
    "void ThingsboardException.<init>(String, Throwable, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(String, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(Throwable, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(ThingsboardErrorCode)",
    "ThingsboardErrorCode ThingsboardException.getErrorCode()"
  })
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ThingsboardException actualThingsboardException =
        new ThingsboardException("An error occurred", cause, ThingsboardErrorCode.GENERAL);
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertEquals("An error occurred", actualThingsboardException.getMessage());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
    assertSame(cause, actualThingsboardException.getCause());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code An error occurred}.
   *   <li>Then return Message is {@code An error occurred}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ThingsboardException#ThingsboardException(String, ThingsboardErrorCode)}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThingsboardException.<init>()",
    "void ThingsboardException.<init>(String, Throwable, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(String, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(Throwable, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(ThingsboardErrorCode)",
    "ThingsboardErrorCode ThingsboardException.getErrorCode()"
  })
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange and Act
    ThingsboardException actualThingsboardException =
        new ThingsboardException("An error occurred", ThingsboardErrorCode.GENERAL);
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertEquals("An error occurred", actualThingsboardException.getMessage());
    assertNull(actualThingsboardException.getCause());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code GENERAL}.
   *   <li>Then return Message is {@code null}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ThingsboardException#ThingsboardException(ThingsboardErrorCode)}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'GENERAL'; then return Message is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThingsboardException.<init>()",
    "void ThingsboardException.<init>(String, Throwable, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(String, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(Throwable, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(ThingsboardErrorCode)",
    "ThingsboardErrorCode ThingsboardException.getErrorCode()"
  })
  void testGettersAndSetters_whenGeneral_thenReturnMessageIsNull() {
    // Arrange and Act
    ThingsboardException actualThingsboardException =
        new ThingsboardException(ThingsboardErrorCode.GENERAL);
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertNull(actualThingsboardException.getMessage());
    assertNull(actualThingsboardException.getCause());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.
   *   <li>Then return Message is {@code Throwable}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ThingsboardException#ThingsboardException(Throwable, ThingsboardErrorCode)}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ThingsboardException.<init>()",
    "void ThingsboardException.<init>(String, Throwable, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(String, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(Throwable, ThingsboardErrorCode)",
    "void ThingsboardException.<init>(ThingsboardErrorCode)",
    "ThingsboardErrorCode ThingsboardException.getErrorCode()"
  })
  void testGettersAndSetters_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ThingsboardException actualThingsboardException =
        new ThingsboardException(cause, ThingsboardErrorCode.GENERAL);
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertEquals("java.lang.Throwable", actualThingsboardException.getMessage());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
    assertSame(cause, actualThingsboardException.getCause());
  }
}
