package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsistentHashCircleDiffblueTest {
  /**
   * Test {@link ConsistentHashCircle#put(long, Object)}.
   * <p>
   * Method under test: {@link ConsistentHashCircle#put(long, Object)}
   */
  @Test
  @DisplayName("Test put(long, Object)")
  void testPut() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();

    // Act
    consistentHashCircle.put(81985529216486895L, "Instance");

    // Assert
    assertFalse(consistentHashCircle.isEmpty());
  }

  /**
   * Test {@link ConsistentHashCircle#remove(long)}.
   * <p>
   * Method under test: {@link ConsistentHashCircle#remove(long)}
   */
  @Test
  @DisplayName("Test remove(long)")
  void testRemove() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();

    // Act
    consistentHashCircle.remove(81985529216486895L);
  }

  /**
   * Test {@link ConsistentHashCircle#isEmpty()}.
   * <ul>
   *   <li>Given {@link ConsistentHashCircle} (default constructor)
   * {@code 81985529216486895} is {@code Instance}.</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsistentHashCircle#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given ConsistentHashCircle (default constructor) '81985529216486895' is 'Instance'; then return 'false'")
  void testIsEmpty_givenConsistentHashCircle81985529216486895IsInstance_thenReturnFalse() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();
    consistentHashCircle.put(81985529216486895L, "Instance");

    // Act and Assert
    assertFalse(consistentHashCircle.isEmpty());
  }

  /**
   * Test {@link ConsistentHashCircle#isEmpty()}.
   * <ul>
   *   <li>Given {@link ConsistentHashCircle} (default constructor).</li>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsistentHashCircle#isEmpty()}
   */
  @Test
  @DisplayName("Test isEmpty(); given ConsistentHashCircle (default constructor); then return 'true'")
  void testIsEmpty_givenConsistentHashCircle_thenReturnTrue() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();

    // Act and Assert
    assertTrue(consistentHashCircle.isEmpty());
  }

  /**
   * Test {@link ConsistentHashCircle#containsKey(Long)}.
   * <ul>
   *   <li>Given {@link ConsistentHashCircle} (default constructor).</li>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsistentHashCircle#containsKey(Long)}
   */
  @Test
  @DisplayName("Test containsKey(Long); given ConsistentHashCircle (default constructor); then return 'false'")
  void testContainsKey_givenConsistentHashCircle_thenReturnFalse() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();

    // Act and Assert
    assertFalse(consistentHashCircle.containsKey(81985529216486895L));
  }

  /**
   * Test {@link ConsistentHashCircle#containsKey(Long)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsistentHashCircle#containsKey(Long)}
   */
  @Test
  @DisplayName("Test containsKey(Long); then return 'true'")
  void testContainsKey_thenReturnTrue() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();
    consistentHashCircle.put(81985529216486895L, "Instance");

    // Act and Assert
    assertTrue(consistentHashCircle.containsKey(81985529216486895L));
  }

  /**
   * Test {@link ConsistentHashCircle#tailMap(Long)}.
   * <p>
   * Method under test: {@link ConsistentHashCircle#tailMap(Long)}
   */
  @Test
  @DisplayName("Test tailMap(Long)")
  void testTailMap() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();

    // Act and Assert
    assertTrue(consistentHashCircle.tailMap(81985529216486895L).isEmpty());
  }

  /**
   * Test {@link ConsistentHashCircle#firstKey()}.
   * <ul>
   *   <li>Then return longValue is {@code 81985529216486895}.</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsistentHashCircle#firstKey()}
   */
  @Test
  @DisplayName("Test firstKey(); then return longValue is '81985529216486895'")
  void testFirstKey_thenReturnLongValueIs81985529216486895() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();
    consistentHashCircle.put(81985529216486895L, "Instance");

    // Act and Assert
    assertEquals(81985529216486895L, consistentHashCircle.firstKey().longValue());
  }

  /**
   * Test {@link ConsistentHashCircle#get(Long)}.
   * <p>
   * Method under test: {@link ConsistentHashCircle#get(Long)}
   */
  @Test
  @DisplayName("Test get(Long)")
  void testGet() {
    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();

    // Act and Assert
    assertNull(consistentHashCircle.get(81985529216486895L));
  }

  /**
   * Test {@link ConsistentHashCircle#log()}.
   * <ul>
   *   <li>Given {@link ConsistentHashCircle} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link ConsistentHashCircle#log()}
   */
  @Test
  @DisplayName("Test log(); given ConsistentHashCircle (default constructor)")
  void testLog_givenConsistentHashCircle() {
    // TODO: Diffblue Cover was only able to create a partial test for this method:
    //   Diffblue AI was unable to find a test

    // Arrange
    ConsistentHashCircle<Object> consistentHashCircle = new ConsistentHashCircle<>();

    // Act
    consistentHashCircle.log();
  }

  /**
   * Test new {@link ConsistentHashCircle} (default constructor).
   * <p>
   * Method under test: default or parameterless constructor of
   * {@link ConsistentHashCircle}
   */
  @Test
  @DisplayName("Test new ConsistentHashCircle (default constructor)")
  void testNewConsistentHashCircle() {
    // Arrange and Act
    ConsistentHashCircle<Object> actualConsistentHashCircle = new ConsistentHashCircle<>();

    // Assert
    assertTrue(actualConsistentHashCircle.isEmpty());
  }
}
