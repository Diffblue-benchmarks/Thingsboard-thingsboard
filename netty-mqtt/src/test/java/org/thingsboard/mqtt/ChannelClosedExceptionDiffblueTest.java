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
package org.thingsboard.mqtt;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class ChannelClosedExceptionDiffblueTest {
  /**
   * Test {@link ChannelClosedException#ChannelClosedException(String, Throwable)}.
   * <ul>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChannelClosedException#ChannelClosedException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new ChannelClosedException(String, Throwable); then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChannelClosedException.<init>()", "void ChannelClosedException.<init>(String)",
      "void ChannelClosedException.<init>(String, Throwable)",
      "void ChannelClosedException.<init>(String, Throwable, boolean, boolean)",
      "void ChannelClosedException.<init>(Throwable)"})
  void testNewChannelClosedException_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualChannelClosedException.getMessage());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
    assertSame(cause, actualChannelClosedException.getCause());
  }

  /**
   * Test {@link ChannelClosedException#ChannelClosedException()}.
   * <ul>
   *   <li>Then return Message is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChannelClosedException#ChannelClosedException()}
   */
  @Test
  @DisplayName("Test new ChannelClosedException(); then return Message is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChannelClosedException.<init>()", "void ChannelClosedException.<init>(String)",
      "void ChannelClosedException.<init>(String, Throwable)",
      "void ChannelClosedException.<init>(String, Throwable, boolean, boolean)",
      "void ChannelClosedException.<init>(Throwable)"})
  void testNewChannelClosedException_thenReturnMessageIsNull() {
    // Arrange and Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException();

    // Assert
    assertNull(actualChannelClosedException.getMessage());
    assertNull(actualChannelClosedException.getCause());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
  }

  /**
   * Test {@link ChannelClosedException#ChannelClosedException(String)}.
   * <ul>
   *   <li>When {@code An error occurred}.</li>
   *   <li>Then return Cause is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChannelClosedException#ChannelClosedException(String)}
   */
  @Test
  @DisplayName("Test new ChannelClosedException(String); when 'An error occurred'; then return Cause is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChannelClosedException.<init>()", "void ChannelClosedException.<init>(String)",
      "void ChannelClosedException.<init>(String, Throwable)",
      "void ChannelClosedException.<init>(String, Throwable, boolean, boolean)",
      "void ChannelClosedException.<init>(Throwable)"})
  void testNewChannelClosedException_whenAnErrorOccurred_thenReturnCauseIsNull() {
    // Arrange and Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualChannelClosedException.getMessage());
    assertNull(actualChannelClosedException.getCause());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
  }

  /**
   * Test {@link ChannelClosedException#ChannelClosedException(Throwable)}.
   * <ul>
   *   <li>When {@link Throwable#Throwable()}.</li>
   *   <li>Then return Message is {@code Throwable}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChannelClosedException#ChannelClosedException(Throwable)}
   */
  @Test
  @DisplayName("Test new ChannelClosedException(Throwable); when Throwable(); then return Message is 'java.lang.Throwable'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChannelClosedException.<init>()", "void ChannelClosedException.<init>(String)",
      "void ChannelClosedException.<init>(String, Throwable)",
      "void ChannelClosedException.<init>(String, Throwable, boolean, boolean)",
      "void ChannelClosedException.<init>(Throwable)"})
  void testNewChannelClosedException_whenThrowable_thenReturnMessageIsJavaLangThrowable() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualChannelClosedException.getMessage());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
    assertSame(cause, actualChannelClosedException.getCause());
  }

  /**
   * Test {@link ChannelClosedException#ChannelClosedException(String, Throwable, boolean, boolean)}.
   * <ul>
   *   <li>When {@code true}.</li>
   *   <li>Then return Message is {@code An error occurred}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ChannelClosedException#ChannelClosedException(String, Throwable, boolean, boolean)}
   */
  @Test
  @DisplayName("Test new ChannelClosedException(String, Throwable, boolean, boolean); when 'true'; then return Message is 'An error occurred'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ChannelClosedException.<init>()", "void ChannelClosedException.<init>(String)",
      "void ChannelClosedException.<init>(String, Throwable)",
      "void ChannelClosedException.<init>(String, Throwable, boolean, boolean)",
      "void ChannelClosedException.<init>(Throwable)"})
  void testNewChannelClosedException_whenTrue_thenReturnMessageIsAnErrorOccurred() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException("An error occurred", cause, true,
        true);

    // Assert
    assertEquals("An error occurred", actualChannelClosedException.getMessage());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
    assertSame(cause, actualChannelClosedException.getCause());
  }
}
