package org.thingsboard.server.service.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbTopicWithConsumerPerPartitionDiffblueTest {
  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}, and {@link TbTopicWithConsumerPerPartition#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbTopicWithConsumerPerPartition#equals(Object)}
   *   <li>{@link TbTopicWithConsumerPerPartition#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTopicWithConsumerPerPartition.equals(Object)",
      "int TbTopicWithConsumerPerPartition.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TbTopicWithConsumerPerPartition tbTopicWithConsumerPerPartition = new TbTopicWithConsumerPerPartition("Topic");

    // Act and Assert
    assertEquals(tbTopicWithConsumerPerPartition, tbTopicWithConsumerPerPartition);
    int expectedHashCodeResult = tbTopicWithConsumerPerPartition.hashCode();
    assertEquals(expectedHashCodeResult, tbTopicWithConsumerPerPartition.hashCode());
  }

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTopicWithConsumerPerPartition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTopicWithConsumerPerPartition.equals(Object)",
      "int TbTopicWithConsumerPerPartition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TbTopicWithConsumerPerPartition tbTopicWithConsumerPerPartition = new TbTopicWithConsumerPerPartition("Topic");

    // Act and Assert
    assertNotEquals(tbTopicWithConsumerPerPartition, new TbTopicWithConsumerPerPartition("Topic"));
  }

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTopicWithConsumerPerPartition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTopicWithConsumerPerPartition.equals(Object)",
      "int TbTopicWithConsumerPerPartition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TbTopicWithConsumerPerPartition tbTopicWithConsumerPerPartition = new TbTopicWithConsumerPerPartition(null);

    // Act and Assert
    assertNotEquals(tbTopicWithConsumerPerPartition, new TbTopicWithConsumerPerPartition("Topic"));
  }

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTopicWithConsumerPerPartition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTopicWithConsumerPerPartition.equals(Object)",
      "int TbTopicWithConsumerPerPartition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TbTopicWithConsumerPerPartition tbTopicWithConsumerPerPartition = new TbTopicWithConsumerPerPartition(
        "org.thingsboard.server.service.queue.TbTopicWithConsumerPerPartition");

    // Act and Assert
    assertNotEquals(tbTopicWithConsumerPerPartition, new TbTopicWithConsumerPerPartition("Topic"));
  }

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTopicWithConsumerPerPartition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTopicWithConsumerPerPartition.equals(Object)",
      "int TbTopicWithConsumerPerPartition.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TbTopicWithConsumerPerPartition tbTopicWithConsumerPerPartition = new TbTopicWithConsumerPerPartition(null);

    // Act and Assert
    assertNotEquals(tbTopicWithConsumerPerPartition, new TbTopicWithConsumerPerPartition(null));
  }

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTopicWithConsumerPerPartition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTopicWithConsumerPerPartition.equals(Object)",
      "int TbTopicWithConsumerPerPartition.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbTopicWithConsumerPerPartition("Topic"), null);
  }

  /**
   * Test {@link TbTopicWithConsumerPerPartition#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TbTopicWithConsumerPerPartition#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TbTopicWithConsumerPerPartition.equals(Object)",
      "int TbTopicWithConsumerPerPartition.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TbTopicWithConsumerPerPartition("Topic"), "Different type to TbTopicWithConsumerPerPartition");
  }
}
