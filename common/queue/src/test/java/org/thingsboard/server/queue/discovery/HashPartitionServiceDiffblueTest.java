package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.queue.discovery.HashPartitionService.QueueConfig;

@ContextConfiguration(classes = {HashPartitionService.class})
@DisabledInAotMode
@ExtendWith(SpringExtension.class)
class HashPartitionServiceDiffblueTest {
  @Autowired private HashPartitionService hashPartitionService;

  @MockBean private QueueRoutingInfoService queueRoutingInfoService;

  @MockBean private TbServiceInfoProvider tbServiceInfoProvider;

  @MockBean private TenantRoutingInfoService tenantRoutingInfoService;

  @MockBean private TopicService topicService;

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
   * Test QueueConfig getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link QueueConfig#setDuplicateMsgToAllPartitions(boolean)}
   *   <li>{@link QueueConfig#toString()}
   *   <li>{@link QueueConfig#isDuplicateMsgToAllPartitions()}
   * </ul>
   */
  @Test
  @DisplayName("Test QueueConfig getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean QueueConfig.isDuplicateMsgToAllPartitions()",
    "void QueueConfig.setDuplicateMsgToAllPartitions(boolean)",
    "String QueueConfig.toString()"
  })
  void testQueueConfigGettersAndSetters() {
    // Arrange
    QueueConfig queueConfig = new QueueConfig(new QueueRoutingInfo(new Queue()));

    // Act
    queueConfig.setDuplicateMsgToAllPartitions(true);
    String actualToStringResult = queueConfig.toString();

    // Assert
    assertEquals(
        "HashPartitionService.QueueConfig(duplicateMsgToAllPartitions=true)", actualToStringResult);
    assertTrue(queueConfig.isDuplicateMsgToAllPartitions());
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

  /**
   * Test {@link HashPartitionService#resolvePartitionIndex(UUID, int)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link HashPartitionService#resolvePartitionIndex(UUID, int)}
   */
  @Test
  @DisplayName("Test resolvePartitionIndex(UUID, int); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int HashPartitionService.resolvePartitionIndex(UUID, int)"})
  void testResolvePartitionIndex_thenReturnZero() {
    // Arrange, Act and Assert
    assertEquals(
        0,
        hashPartitionService.resolvePartitionIndex(
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), 1));
  }

  /**
   * Test {@link HashPartitionService#countTransportsByType(String)}.
   *
   * <p>Method under test: {@link HashPartitionService#countTransportsByType(String)}
   */
  @Test
  @DisplayName("Test countTransportsByType(String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"int HashPartitionService.countTransportsByType(String)"})
  void testCountTransportsByType() {
    // Arrange, Act and Assert
    assertEquals(0, hashPartitionService.countTransportsByType("Type"));
  }

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
}
