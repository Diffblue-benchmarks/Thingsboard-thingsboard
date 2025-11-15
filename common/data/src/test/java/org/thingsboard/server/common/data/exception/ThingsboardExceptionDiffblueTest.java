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
import org.junit.jupiter.api.Test;

class ThingsboardExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ThingsboardException#ThingsboardException()}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange and Act
    ThingsboardException actualThingsboardException = new ThingsboardException();

    // Assert
    assertNull(actualThingsboardException.getMessage());
    assertNull(actualThingsboardException.getCause());
    assertNull(actualThingsboardException.getErrorCode());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ThingsboardException#ThingsboardException(String, Throwable, ThingsboardErrorCode)}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters2() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ThingsboardException actualThingsboardException = new ThingsboardException("An error occurred", cause,
        ThingsboardErrorCode.GENERAL);
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertEquals("An error occurred", actualThingsboardException.getMessage());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
    assertSame(cause, actualThingsboardException.getCause());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ThingsboardException#ThingsboardException(String, ThingsboardErrorCode)}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters3() {
    // Arrange and Act
    ThingsboardException actualThingsboardException = new ThingsboardException("An error occurred",
        ThingsboardErrorCode.GENERAL);
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertEquals("An error occurred", actualThingsboardException.getMessage());
    assertNull(actualThingsboardException.getCause());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ThingsboardException#ThingsboardException(Throwable, ThingsboardErrorCode)}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters4() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ThingsboardException actualThingsboardException = new ThingsboardException(cause, ThingsboardErrorCode.GENERAL);
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertEquals("java.lang.Throwable", actualThingsboardException.getMessage());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
    assertSame(cause, actualThingsboardException.getCause());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ThingsboardException#ThingsboardException(ThingsboardErrorCode)}
   *   <li>{@link ThingsboardException#getErrorCode()}
   * </ul>
   */
  @Test
  void testGettersAndSetters5() {
    // Arrange and Act
    ThingsboardException actualThingsboardException = new ThingsboardException(ThingsboardErrorCode.GENERAL);
    ThingsboardErrorCode actualErrorCode = actualThingsboardException.getErrorCode();

    // Assert
    assertNull(actualThingsboardException.getMessage());
    assertNull(actualThingsboardException.getCause());
    assertEquals(0, actualThingsboardException.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualErrorCode);
  }
}
