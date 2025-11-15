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
package org.thingsboard.server.transport.lwm2m.server;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class LwM2MOperationTypeDiffblueTest {
  /**
   * Method under test: {@link LwM2MOperationType#fromType(String)}
   */
  @Test
  void testFromType() {
    // Arrange, Act and Assert
    assertNull(LwM2MOperationType.fromType("Type"));
    assertEquals(LwM2MOperationType.READ, LwM2MOperationType.fromType("Read"));
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MOperationType#getCode()}
   *   <li>{@link LwM2MOperationType#getType()}
   *   <li>{@link LwM2MOperationType#isComposite()}
   *   <li>{@link LwM2MOperationType#isHasObjectId()}
   * </ul>
   */
  @Test
  void testGettersAndSetters() {
    // Arrange
    LwM2MOperationType valueOfResult = LwM2MOperationType.valueOf("READ");

    // Act
    int actualCode = valueOfResult.getCode();
    String actualType = valueOfResult.getType();
    boolean actualIsCompositeResult = valueOfResult.isComposite();

    // Assert
    assertEquals("Read", actualType);
    assertEquals(0, actualCode);
    assertFalse(actualIsCompositeResult);
    assertTrue(valueOfResult.isHasObjectId());
  }
}
