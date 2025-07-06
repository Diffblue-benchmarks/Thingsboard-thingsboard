package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.queue.discovery.HashPartitionService.QueueConfig;

class HashPartitionServiceDiffblueTest {
  /**
   * Test {@link HashPartitionService#forName(String)}.
   *
   * <ul>
   *   <li>When {@code Name}.
   *   <li>Then throw {@link IllegalArgumentException}.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#forName(String)}
   */
  @Test
  @DisplayName("Test forName(String); when 'Name'; then throw IllegalArgumentException")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"com.google.common.hash.HashFunction HashPartitionService.forName(String)"})
  void testForName_whenName_thenThrowIllegalArgumentException() {
    // Arrange, Act and Assert
    assertThrows(IllegalArgumentException.class, () -> HashPartitionService.forName("Name"));
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}, and {@link QueueConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueConfig#equals(Object)}
   *   <li>{@link QueueConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test QueueConfig equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueConfig.equals(Object)", "int QueueConfig.hashCode()"})
  void testQueueConfigEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    QueueConfig queueConfig = new QueueConfig(new QueueRoutingInfo(new Queue()));
    QueueConfig queueConfig2 = new QueueConfig(new QueueRoutingInfo(new Queue()));

    // Act and Assert
    assertEquals(queueConfig, queueConfig2);
    int expectedHashCodeResult = queueConfig.hashCode();
    assertEquals(expectedHashCodeResult, queueConfig2.hashCode());
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}, and {@link QueueConfig#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueConfig#equals(Object)}
   *   <li>{@link QueueConfig#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName(
      "Test QueueConfig equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueConfig.equals(Object)", "int QueueConfig.hashCode()"})
  void testQueueConfigEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    QueueConfig queueConfig = new QueueConfig(new QueueRoutingInfo(new Queue()));

    // Act and Assert
    assertEquals(queueConfig, queueConfig);
    int expectedHashCodeResult = queueConfig.hashCode();
    assertEquals(expectedHashCodeResult, queueConfig.hashCode());
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueConfig.equals(Object)", "int QueueConfig.hashCode()"})
  void testQueueConfigEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    QueueRoutingInfo queueRoutingInfo = mock(QueueRoutingInfo.class);
    when(queueRoutingInfo.isDuplicateMsgToAllPartitions()).thenReturn(true);
    QueueConfig queueConfig = new QueueConfig(queueRoutingInfo);

    // Act and Assert
    assertNotEquals(queueConfig, new QueueConfig(new QueueRoutingInfo(new Queue())));
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueConfig.equals(Object)", "int QueueConfig.hashCode()"})
  void testQueueConfigEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new QueueConfig(new QueueRoutingInfo(new Queue())), null);
  }

  /**
   * Test QueueConfig {@link QueueConfig#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link QueueConfig#equals(Object)}
   */
  @Test
  @DisplayName("Test QueueConfig equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean QueueConfig.equals(Object)", "int QueueConfig.hashCode()"})
  void testQueueConfigEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new QueueConfig(new QueueRoutingInfo(new Queue())), "Different type to QueueConfig");
  }

  /**
   * Test QueueConfig {@link QueueConfig#QueueConfig(QueueRoutingInfo)}.
   *
   * <ul>
   *   <li>Then return not DuplicateMsgToAllPartitions.
   * </ul>
   *
   * <p>Method under test: {@link QueueConfig#QueueConfig(QueueRoutingInfo)}
   */
  @Test
  @DisplayName(
      "Test QueueConfig new QueueConfig(QueueRoutingInfo); then return not DuplicateMsgToAllPartitions")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void QueueConfig.<init>(QueueRoutingInfo)"})
  void testQueueConfigNewQueueConfig_thenReturnNotDuplicateMsgToAllPartitions() {
    // Arrange, Act and Assert
    assertFalse(new QueueConfig(new QueueRoutingInfo(new Queue())).isDuplicateMsgToAllPartitions());
  }
}
