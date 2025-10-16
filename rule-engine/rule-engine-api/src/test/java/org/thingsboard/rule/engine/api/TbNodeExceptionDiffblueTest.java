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
package org.thingsboard.rule.engine.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbNodeExceptionDiffblueTest {
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
   *   <li>{@link TbNodeException#TbNodeException(String)}
   *   <li>{@link TbNodeException#isUnrecoverable()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbNodeException.<init>(Exception)",
    "void TbNodeException.<init>(Exception, boolean)",
    "void TbNodeException.<init>(String)",
    "void TbNodeException.<init>(String, boolean)",
    "boolean TbNodeException.isUnrecoverable()"
  })
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred() {
    // Arrange and Act
    TbNodeException actualTbNodeException = new TbNodeException("An error occurred");
    boolean actualIsUnrecoverableResult = actualTbNodeException.isUnrecoverable();

    // Assert
    assertEquals("An error occurred", actualTbNodeException.getMessage());
    assertNull(actualTbNodeException.getCause());
    assertEquals(0, actualTbNodeException.getSuppressed().length);
    assertFalse(actualIsUnrecoverableResult);
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
   *   <li>{@link TbNodeException#TbNodeException(String, boolean)}
   *   <li>{@link TbNodeException#isUnrecoverable()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when 'An error occurred'; then return Message is 'An error occurred'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbNodeException.<init>(Exception)",
    "void TbNodeException.<init>(Exception, boolean)",
    "void TbNodeException.<init>(String)",
    "void TbNodeException.<init>(String, boolean)",
    "boolean TbNodeException.isUnrecoverable()"
  })
  void testGettersAndSetters_whenAnErrorOccurred_thenReturnMessageIsAnErrorOccurred2() {
    // Arrange and Act
    TbNodeException actualTbNodeException = new TbNodeException("An error occurred", true);
    boolean actualIsUnrecoverableResult = actualTbNodeException.isUnrecoverable();

    // Assert
    assertEquals("An error occurred", actualTbNodeException.getMessage());
    assertNull(actualTbNodeException.getCause());
    assertEquals(0, actualTbNodeException.getSuppressed().length);
    assertTrue(actualIsUnrecoverableResult);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then return Message is {@code Exception}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeException#TbNodeException(Exception)}
   *   <li>{@link TbNodeException#isUnrecoverable()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when Exception(); then return Message is 'java.lang.Exception'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbNodeException.<init>(Exception)",
    "void TbNodeException.<init>(Exception, boolean)",
    "void TbNodeException.<init>(String)",
    "void TbNodeException.<init>(String, boolean)",
    "boolean TbNodeException.isUnrecoverable()"
  })
  void testGettersAndSetters_whenException_thenReturnMessageIsJavaLangException() {
    // Arrange
    Exception e = new Exception();

    // Act
    TbNodeException actualTbNodeException = new TbNodeException(e);
    boolean actualIsUnrecoverableResult = actualTbNodeException.isUnrecoverable();

    // Assert
    assertEquals("java.lang.Exception", actualTbNodeException.getMessage());
    assertEquals(0, actualTbNodeException.getSuppressed().length);
    assertFalse(actualIsUnrecoverableResult);
    assertSame(e, actualTbNodeException.getCause());
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link Exception#Exception()}.
   *   <li>Then return Message is {@code Exception}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TbNodeException#TbNodeException(Exception, boolean)}
   *   <li>{@link TbNodeException#isUnrecoverable()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test getters and setters; when Exception(); then return Message is 'java.lang.Exception'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void TbNodeException.<init>(Exception)",
    "void TbNodeException.<init>(Exception, boolean)",
    "void TbNodeException.<init>(String)",
    "void TbNodeException.<init>(String, boolean)",
    "boolean TbNodeException.isUnrecoverable()"
  })
  void testGettersAndSetters_whenException_thenReturnMessageIsJavaLangException2() {
    // Arrange
    Exception e = new Exception();

    // Act
    TbNodeException actualTbNodeException = new TbNodeException(e, true);
    boolean actualIsUnrecoverableResult = actualTbNodeException.isUnrecoverable();

    // Assert
    assertEquals("java.lang.Exception", actualTbNodeException.getMessage());
    assertEquals(0, actualTbNodeException.getSuppressed().length);
    assertTrue(actualIsUnrecoverableResult);
    assertSame(e, actualTbNodeException.getCause());
  }
}
