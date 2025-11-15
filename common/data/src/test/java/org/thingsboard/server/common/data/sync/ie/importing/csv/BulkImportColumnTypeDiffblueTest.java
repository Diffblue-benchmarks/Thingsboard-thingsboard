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
package org.thingsboard.server.common.data.sync.ie.importing.csv;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class BulkImportColumnTypeDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link BulkImportColumnType#getDefaultValue()}
   *   <li>{@link BulkImportColumnType#getKey()}
   *   <li>{@link BulkImportColumnType#isKv()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"String BulkImportColumnType.getDefaultValue()", "String BulkImportColumnType.getKey()",
      "boolean BulkImportColumnType.isKv()"})
  void testGettersAndSetters() {
    // Arrange
    BulkImportColumnType valueOfResult = BulkImportColumnType.valueOf("NAME");

    // Act
    String actualDefaultValue = valueOfResult.getDefaultValue();
    String actualKey = valueOfResult.getKey();

    // Assert
    assertNull(actualDefaultValue);
    assertNull(actualKey);
    assertFalse(valueOfResult.isKv());
  }
}
