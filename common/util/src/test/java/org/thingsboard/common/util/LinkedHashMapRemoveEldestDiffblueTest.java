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
package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class LinkedHashMapRemoveEldestDiffblueTest {
  /**
   * Test {@link LinkedHashMapRemoveEldest#LinkedHashMapRemoveEldest(long, BiConsumer)}.
   *
   * <p>Method under test: {@link LinkedHashMapRemoveEldest#LinkedHashMapRemoveEldest(long,
   * BiConsumer)}
   */
  @Test
  @DisplayName("Test new LinkedHashMapRemoveEldest(long, BiConsumer)")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"void LinkedHashMapRemoveEldest.<init>(long, BiConsumer)"})
  void testNewLinkedHashMapRemoveEldest() {
    // Arrange and Act
    LinkedHashMapRemoveEldest<Object, Object> actualObjectObjectMap =
        new LinkedHashMapRemoveEldest<>(1L, mock(BiConsumer.class));

    // Assert
    assertTrue(actualObjectObjectMap.isEmpty());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link LinkedHashMapRemoveEldest#toString()}
   *   <li>{@link LinkedHashMapRemoveEldest#getMaxEntries()}
   *   <li>{@link LinkedHashMapRemoveEldest#getRemovalConsumer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "long LinkedHashMapRemoveEldest.getMaxEntries()",
    "BiConsumer LinkedHashMapRemoveEldest.getRemovalConsumer()",
    "java.lang.String LinkedHashMapRemoveEldest.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    LinkedHashMapRemoveEldest<Object, Object> objectObjectMap =
        new LinkedHashMapRemoveEldest<>(1L, mock(BiConsumer.class));

    // Act
    objectObjectMap.toString();
    long actualMaxEntries = objectObjectMap.getMaxEntries();
    objectObjectMap.getRemovalConsumer();

    // Assert
    assertEquals(1L, actualMaxEntries);
  }
}
