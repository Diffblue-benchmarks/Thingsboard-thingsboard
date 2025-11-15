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
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LwM2MOperationTypeDiffblueTest {
  /**
   * Test {@link LwM2MOperationType#fromType(String)}.
   * <ul>
   *   <li>When {@code Read}.</li>
   *   <li>Then return {@code READ}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MOperationType#fromType(String)}
   */
  @Test
  @DisplayName("Test fromType(String); when 'Read'; then return 'READ'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2MOperationType LwM2MOperationType.fromType(String)"})
  void testFromType_whenRead_thenReturnRead() {
    // Arrange, Act and Assert
    assertEquals(LwM2MOperationType.READ, LwM2MOperationType.fromType("Read"));
  }

  /**
   * Test {@link LwM2MOperationType#fromType(String)}.
   * <ul>
   *   <li>When {@code Type}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link LwM2MOperationType#fromType(String)}
   */
  @Test
  @DisplayName("Test fromType(String); when 'Type'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"LwM2MOperationType LwM2MOperationType.fromType(String)"})
  void testFromType_whenType_thenReturnNull() {
    // Arrange, Act and Assert
    assertNull(LwM2MOperationType.fromType("Type"));
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LwM2MOperationType#getCode()}
   *   <li>{@link LwM2MOperationType#getType()}
   *   <li>{@link LwM2MOperationType#isComposite()}
   *   <li>{@link LwM2MOperationType#isHasObjectId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int LwM2MOperationType.getCode()", "String LwM2MOperationType.getType()",
      "boolean LwM2MOperationType.isComposite()", "boolean LwM2MOperationType.isHasObjectId()"})
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
