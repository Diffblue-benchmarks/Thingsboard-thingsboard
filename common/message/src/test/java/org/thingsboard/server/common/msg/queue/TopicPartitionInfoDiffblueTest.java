package org.thingsboard.server.common.msg.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo.TopicPartitionInfoBuilder;

class TopicPartitionInfoDiffblueTest {
  /**
   * Test
   * {@link TopicPartitionInfo#TopicPartitionInfo(String, TenantId, Integer, boolean)}.
   * <ul>
   *   <li>Then return Partition intValue is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TopicPartitionInfo#TopicPartitionInfo(String, TenantId, Integer, boolean)}
   */
  @Test
  @DisplayName("Test new TopicPartitionInfo(String, TenantId, Integer, boolean); then return Partition intValue is one")
  void testNewTopicPartitionInfo_thenReturnPartitionIntValueIsOne() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TopicPartitionInfo actualTopicPartitionInfo = new TopicPartitionInfo("Topic", tenantId, 1, true);

    // Assert
    Optional<Integer> partition = actualTopicPartitionInfo.getPartition();
    assertEquals(1, partition.get().intValue());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualTopicPartitionInfo.getTenantId();
    assertTrue(tenantId2.isPresent());
    assertSame(tenantId, tenantId2.get());
  }

  /**
   * Test
   * {@link TopicPartitionInfo#TopicPartitionInfo(String, TenantId, Integer, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return FullTopicName is {@code Topic}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TopicPartitionInfo#TopicPartitionInfo(String, TenantId, Integer, boolean)}
   */
  @Test
  @DisplayName("Test new TopicPartitionInfo(String, TenantId, Integer, boolean); when 'null'; then return FullTopicName is 'Topic'")
  void testNewTopicPartitionInfo_whenNull_thenReturnFullTopicNameIsTopic() {
    // Arrange and Act
    TopicPartitionInfo actualTopicPartitionInfo = new TopicPartitionInfo("Topic", null, null, true);

    // Assert
    assertEquals("Topic", actualTopicPartitionInfo.getFullTopicName());
    assertEquals("Topic", actualTopicPartitionInfo.getTopic());
    Optional<Integer> partition = actualTopicPartitionInfo.getPartition();
    assertFalse(partition.isPresent());
    assertTrue(actualTopicPartitionInfo.isMyPartition());
    assertSame(partition, actualTopicPartitionInfo.getTenantId());
  }

  /**
   * Test {@link TopicPartitionInfo#newByTopic(String)}.
   * <p>
   * Method under test: {@link TopicPartitionInfo#newByTopic(String)}
   */
  @Test
  @DisplayName("Test newByTopic(String)")
  void testNewByTopic() {
    // Arrange
    TopicPartitionInfo topicPartitionInfo = new TopicPartitionInfo("Topic", new TenantId(UUID.randomUUID()), 1, true);

    // Act and Assert
    assertEquals(topicPartitionInfo, topicPartitionInfo.newByTopic("Topic"));
  }

  /**
   * Test {@link TopicPartitionInfo#newByTopic(String)}.
   * <p>
   * Method under test: {@link TopicPartitionInfo#newByTopic(String)}
   */
  @Test
  @DisplayName("Test newByTopic(String)")
  void testNewByTopic2() {
    // Arrange
    TopicPartitionInfo topicPartitionInfo = new TopicPartitionInfo("Topic", null, 1, true);

    // Act
    TopicPartitionInfo actualNewByTopicResult = topicPartitionInfo.newByTopic("Topic");

    // Assert
    assertEquals("Topic.1", topicPartitionInfo.getFullTopicName());
    assertEquals(topicPartitionInfo, actualNewByTopicResult);
  }

  /**
   * Test {@link TopicPartitionInfo#newByTopic(String)}.
   * <ul>
   *   <li>Then return not Partition Present.</li>
   * </ul>
   * <p>
   * Method under test: {@link TopicPartitionInfo#newByTopic(String)}
   */
  @Test
  @DisplayName("Test newByTopic(String); then return not Partition Present")
  void testNewByTopic_thenReturnNotPartitionPresent() {
    // Arrange, Act and Assert
    assertFalse((new TopicPartitionInfo("Topic", new TenantId(UUID.randomUUID()), null, true)).newByTopic("Topic")
        .getPartition()
        .isPresent());
  }

  /**
   * Test {@link TopicPartitionInfo#getTenantId()}.
   * <p>
   * Method under test: {@link TopicPartitionInfo#getTenantId()}
   */
  @Test
  @DisplayName("Test getTenantId()")
  void testGetTenantId() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    Optional<TenantId> actualTenantId = (new TopicPartitionInfo("Topic", tenantId, 1, true)).getTenantId();

    // Assert
    assertTrue(actualTenantId.isPresent());
    assertSame(tenantId, actualTenantId.get());
  }

  /**
   * Test {@link TopicPartitionInfo#getPartition()}.
   * <p>
   * Method under test: {@link TopicPartitionInfo#getPartition()}
   */
  @Test
  @DisplayName("Test getPartition()")
  void testGetPartition() {
    // Arrange and Act
    Optional<Integer> actualPartition = (new TopicPartitionInfo("Topic", new TenantId(UUID.randomUUID()), 1, true))
        .getPartition();

    // Assert
    assertEquals(1, actualPartition.get().intValue());
    assertTrue(actualPartition.isPresent());
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}, and
   * {@link TopicPartitionInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TopicPartitionInfo#equals(Object)}
   *   <li>{@link TopicPartitionInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult2 = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult2 = partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder topicPartitionInfoBuilder = mock(
        TopicPartitionInfo.TopicPartitionInfoBuilder.class);
    when(topicPartitionInfoBuilder.myPartition(anyBoolean())).thenReturn(TopicPartitionInfo.builder());
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = topicPartitionInfoBuilder.myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult2 = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult2 = partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder topicPartitionInfoBuilder = mock(
        TopicPartitionInfo.TopicPartitionInfoBuilder.class);
    when(topicPartitionInfoBuilder.myPartition(anyBoolean())).thenReturn(TopicPartitionInfo.builder());
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = topicPartitionInfoBuilder.myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("42").build();
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult2 = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult2 = partitionResult2.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link TopicPartitionInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TopicPartitionInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to TopicPartitionInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TopicPartitionInfo#toString()}
   *   <li>{@link TopicPartitionInfo#getFullTopicName()}
   *   <li>{@link TopicPartitionInfo#getTopic()}
   *   <li>{@link TopicPartitionInfo#isMyPartition()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();

    // Act
    buildResult.toString();
    buildResult.getFullTopicName();
    String actualTopic = buildResult.getTopic();

    // Assert
    assertEquals("Topic", actualTopic);
    assertTrue(buildResult.isMyPartition());
  }

  /**
   * Test TopicPartitionInfoBuilder {@link TopicPartitionInfoBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TopicPartitionInfo.TopicPartitionInfoBuilder#build()}
   *   <li>{@link TopicPartitionInfo.TopicPartitionInfoBuilder#myPartition(boolean)}
   *   <li>{@link TopicPartitionInfo.TopicPartitionInfoBuilder#partition(Integer)}
   *   <li>{@link TopicPartitionInfo.TopicPartitionInfoBuilder#tenantId(TenantId)}
   *   <li>{@link TopicPartitionInfo.TopicPartitionInfoBuilder#topic(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test TopicPartitionInfoBuilder build()")
  void testTopicPartitionInfoBuilderBuild() {
    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act
    TopicPartitionInfo actualBuildResult = partitionResult.tenantId(tenantId).topic("Topic").build();

    // Assert
    assertEquals("Topic", actualBuildResult.getTopic());
    Optional<Integer> partition = actualBuildResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertTrue(partition.isPresent());
    Optional<TenantId> tenantId2 = actualBuildResult.getTenantId();
    assertTrue(tenantId2.isPresent());
    assertTrue(actualBuildResult.isMyPartition());
    assertSame(tenantId, tenantId2.get());
  }
}
