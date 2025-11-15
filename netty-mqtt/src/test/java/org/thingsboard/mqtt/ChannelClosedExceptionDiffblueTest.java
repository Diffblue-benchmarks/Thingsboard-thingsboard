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
import org.junit.jupiter.api.Test;

class ChannelClosedExceptionDiffblueTest {
  /**
   * Method under test: {@link ChannelClosedException#ChannelClosedException()}
   */
  @Test
  void testNewChannelClosedException() {
    // Arrange and Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException();

    // Assert
    assertNull(actualChannelClosedException.getMessage());
    assertNull(actualChannelClosedException.getCause());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ChannelClosedException#ChannelClosedException(String)}
   */
  @Test
  void testNewChannelClosedException2() {
    // Arrange and Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException("An error occurred");

    // Assert
    assertEquals("An error occurred", actualChannelClosedException.getMessage());
    assertNull(actualChannelClosedException.getCause());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
  }

  /**
   * Method under test:
   * {@link ChannelClosedException#ChannelClosedException(String, Throwable)}
   */
  @Test
  void testNewChannelClosedException3() {
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
   * Method under test:
   * {@link ChannelClosedException#ChannelClosedException(String, Throwable, boolean, boolean)}
   */
  @Test
  void testNewChannelClosedException4() {
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

  /**
   * Method under test:
   * {@link ChannelClosedException#ChannelClosedException(Throwable)}
   */
  @Test
  void testNewChannelClosedException5() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    ChannelClosedException actualChannelClosedException = new ChannelClosedException(cause);

    // Assert
    assertEquals("java.lang.Throwable", actualChannelClosedException.getMessage());
    assertEquals(0, actualChannelClosedException.getSuppressed().length);
    assertSame(cause, actualChannelClosedException.getCause());
  }
}
