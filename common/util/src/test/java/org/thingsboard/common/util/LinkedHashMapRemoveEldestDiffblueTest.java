package org.thingsboard.common.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.function.BiConsumer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LinkedHashMapRemoveEldestDiffblueTest {
  /**
   * Test
   * {@link LinkedHashMapRemoveEldest#LinkedHashMapRemoveEldest(long, BiConsumer)}.
   * <p>
   * Method under test:
   * {@link LinkedHashMapRemoveEldest#LinkedHashMapRemoveEldest(long, BiConsumer)}
   */
  @Test
  @DisplayName("Test new LinkedHashMapRemoveEldest(long, BiConsumer)")
  void testNewLinkedHashMapRemoveEldest() {
    // Arrange and Act
    LinkedHashMapRemoveEldest<Object, Object> actualObjectObjectMap = new LinkedHashMapRemoveEldest<>(1L,
        mock(BiConsumer.class));

    // Assert
    assertTrue(actualObjectObjectMap.isEmpty());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link LinkedHashMapRemoveEldest#toString()}
   *   <li>{@link LinkedHashMapRemoveEldest#getMaxEntries()}
   *   <li>{@link LinkedHashMapRemoveEldest#getRemovalConsumer()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    LinkedHashMapRemoveEldest<Object, Object> objectObjectMap = new LinkedHashMapRemoveEldest<>(1L,
        mock(BiConsumer.class));

    // Act
    objectObjectMap.toString();
    long actualMaxEntries = objectObjectMap.getMaxEntries();
    objectObjectMap.getRemovalConsumer();

    // Assert
    assertEquals(1L, actualMaxEntries);
  }
}
