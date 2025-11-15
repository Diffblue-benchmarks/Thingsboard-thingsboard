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
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;
import org.junit.jupiter.api.Test;

class TbActorNotRegisteredExceptionDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link TbActorNotRegisteredException#TbActorNotRegisteredException(TbActorId, String)}
   *   <li>{@link TbActorNotRegisteredException#getTarget()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    TbActorId target = mock(TbActorId.class);

    // Act
    TbActorNotRegisteredException actualTbActorNotRegisteredException = new TbActorNotRegisteredException(target,
        "An error occurred");
    TbActorId actualTarget = actualTbActorNotRegisteredException.getTarget();

    // Assert
    assertEquals("An error occurred", actualTbActorNotRegisteredException.getMessage());
    assertNull(actualTbActorNotRegisteredException.getCause());
    assertEquals(0, actualTbActorNotRegisteredException.getSuppressed().length);
    assertSame(target, actualTarget);
  }
}
