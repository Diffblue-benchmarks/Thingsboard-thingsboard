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
package org.thingsboard.server.actors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbActorExceptionDiffblueTest {
  /**
   * Test {@link TbActorException#TbActorException(String, Throwable)}.
   * <p>
   * Method under test: {@link TbActorException#TbActorException(String, Throwable)}
   */
  @Test
  @DisplayName("Test new TbActorException(String, Throwable)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TbActorException.<init>(String, Throwable)"})
  void testNewTbActorException() {
    // Arrange
    Throwable cause = new Throwable();

    // Act
    TbActorException actualTbActorException = new TbActorException("An error occurred", cause);

    // Assert
    assertEquals("An error occurred", actualTbActorException.getMessage());
    assertEquals(0, actualTbActorException.getSuppressed().length);
    assertSame(cause, actualTbActorException.getCause());
  }
}
