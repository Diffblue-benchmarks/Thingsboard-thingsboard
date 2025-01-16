package org.thingsboard.server.queue.discovery;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;

@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@ContextConfiguration(classes = {TopicService.class})
@ExtendWith(SpringExtension.class)
class TopicServiceDiffblueTest {
  @Autowired
  private TopicService topicService;

  /**
   * Test {@link TopicService#getNotificationsTopic(ServiceType, String)}.
   * <ul>
   *   <li>Then return FullTopicName is {@code tb_core.notifications.42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TopicService#getNotificationsTopic(ServiceType, String)}
   */
  @Test
  @DisplayName("Test getNotificationsTopic(ServiceType, String); then return FullTopicName is 'tb_core.notifications.42'")
  void testGetNotificationsTopic_thenReturnFullTopicNameIsTbCoreNotifications42() {
    // Arrange and Act
    TopicPartitionInfo actualNotificationsTopic = topicService.getNotificationsTopic(ServiceType.TB_CORE, "42");

    // Assert
    assertEquals("tb_core.notifications.42", actualNotificationsTopic.getFullTopicName());
    assertEquals("tb_core.notifications.42", actualNotificationsTopic.getTopic());
    Optional<Integer> partition = actualNotificationsTopic.getPartition();
    assertFalse(partition.isPresent());
    assertFalse(actualNotificationsTopic.isMyPartition());
    assertSame(partition, actualNotificationsTopic.getTenantId());
  }

  /**
   * Test {@link TopicService#getNotificationsTopic(ServiceType, String)}.
   * <ul>
   *   <li>Then return FullTopicName is
   * {@code tb_rule_engine.notifications.42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TopicService#getNotificationsTopic(ServiceType, String)}
   */
  @Test
  @DisplayName("Test getNotificationsTopic(ServiceType, String); then return FullTopicName is 'tb_rule_engine.notifications.42'")
  void testGetNotificationsTopic_thenReturnFullTopicNameIsTbRuleEngineNotifications42() {
    // Arrange and Act
    TopicPartitionInfo actualNotificationsTopic = topicService.getNotificationsTopic(ServiceType.TB_RULE_ENGINE, "42");

    // Assert
    assertEquals("tb_rule_engine.notifications.42", actualNotificationsTopic.getFullTopicName());
    assertEquals("tb_rule_engine.notifications.42", actualNotificationsTopic.getTopic());
    Optional<Integer> partition = actualNotificationsTopic.getPartition();
    assertFalse(partition.isPresent());
    assertFalse(actualNotificationsTopic.isMyPartition());
    assertSame(partition, actualNotificationsTopic.getTenantId());
  }

  /**
   * Test {@link TopicService#getNotificationsTopic(ServiceType, String)}.
   * <ul>
   *   <li>Then return FullTopicName is {@code tb_transport.notifications.42}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TopicService#getNotificationsTopic(ServiceType, String)}
   */
  @Test
  @DisplayName("Test getNotificationsTopic(ServiceType, String); then return FullTopicName is 'tb_transport.notifications.42'")
  void testGetNotificationsTopic_thenReturnFullTopicNameIsTbTransportNotifications42() {
    // Arrange and Act
    TopicPartitionInfo actualNotificationsTopic = topicService.getNotificationsTopic(ServiceType.TB_TRANSPORT, "42");

    // Assert
    assertEquals("tb_transport.notifications.42", actualNotificationsTopic.getFullTopicName());
    assertEquals("tb_transport.notifications.42", actualNotificationsTopic.getTopic());
    Optional<Integer> partition = actualNotificationsTopic.getPartition();
    assertFalse(partition.isPresent());
    assertFalse(actualNotificationsTopic.isMyPartition());
    assertSame(partition, actualNotificationsTopic.getTenantId());
  }

  /**
   * Test {@link TopicService#getEdgeNotificationsTopic(String)}.
   * <p>
   * Method under test: {@link TopicService#getEdgeNotificationsTopic(String)}
   */
  @Test
  @DisplayName("Test getEdgeNotificationsTopic(String)")
  void testGetEdgeNotificationsTopic() {
    // Arrange and Act
    TopicPartitionInfo actualEdgeNotificationsTopic = topicService.getEdgeNotificationsTopic("42");

    // Assert
    assertEquals("tb_edge.notifications.42", actualEdgeNotificationsTopic.getFullTopicName());
    assertEquals("tb_edge.notifications.42", actualEdgeNotificationsTopic.getTopic());
    Optional<Integer> partition = actualEdgeNotificationsTopic.getPartition();
    assertFalse(partition.isPresent());
    assertFalse(actualEdgeNotificationsTopic.isMyPartition());
    assertSame(partition, actualEdgeNotificationsTopic.getTenantId());
  }

  /**
   * Test
   * {@link TopicService#buildTopicPartitionInfo(String, TenantId, Integer, boolean)}.
   * <p>
   * Method under test:
   * {@link TopicService#buildTopicPartitionInfo(String, TenantId, Integer, boolean)}
   */
  @Test
  @DisplayName("Test buildTopicPartitionInfo(String, TenantId, Integer, boolean)")
  void testBuildTopicPartitionInfo() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    TopicPartitionInfo actualBuildTopicPartitionInfoResult = topicService.buildTopicPartitionInfo("Topic", tenantId, 1,
        true);

    // Assert
    assertEquals("Topic.isolated.784f394c-42b6-435a-983c-b7beff2784f9.1",
        actualBuildTopicPartitionInfoResult.getFullTopicName());
    Optional<TenantId> tenantId2 = actualBuildTopicPartitionInfoResult.getTenantId();
    assertTrue(tenantId2.isPresent());
    assertSame(tenantId, tenantId2.get());
  }

  /**
   * Test
   * {@link TopicService#buildTopicPartitionInfo(String, TenantId, Integer, boolean)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code Topic}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TopicService#buildTopicPartitionInfo(String, TenantId, Integer, boolean)}
   */
  @Test
  @DisplayName("Test buildTopicPartitionInfo(String, TenantId, Integer, boolean); when 'null'; then return 'Topic'")
  void testBuildTopicPartitionInfo_whenNull_thenReturnTopic() {
    // Arrange and Act
    TopicPartitionInfo actualBuildTopicPartitionInfoResult = topicService.buildTopicPartitionInfo("Topic", null, 1,
        true);

    // Assert
    assertEquals("Topic", actualBuildTopicPartitionInfoResult.getTopic());
    assertEquals("Topic.1", actualBuildTopicPartitionInfoResult.getFullTopicName());
    Optional<Integer> partition = actualBuildTopicPartitionInfoResult.getPartition();
    assertEquals(1, partition.get().intValue());
    assertFalse(actualBuildTopicPartitionInfoResult.getTenantId().isPresent());
    assertTrue(partition.isPresent());
    assertTrue(actualBuildTopicPartitionInfoResult.isMyPartition());
  }

  /**
   * Test {@link TopicService#buildTopicName(String)}.
   * <p>
   * Method under test: {@link TopicService#buildTopicName(String)}
   */
  @Test
  @DisplayName("Test buildTopicName(String)")
  void testBuildTopicName() {
    // Arrange, Act and Assert
    assertEquals("Topic", topicService.buildTopicName("Topic"));
  }

  /**
   * Test
   * {@link TopicService#buildConsumerGroupId(String, TenantId, String, Integer)}.
   * <p>
   * Method under test:
   * {@link TopicService#buildConsumerGroupId(String, TenantId, String, Integer)}
   */
  @Test
  @DisplayName("Test buildConsumerGroupId(String, TenantId, String, Integer)")
  void testBuildConsumerGroupId() {
    // Arrange, Act and Assert
    assertEquals("Service PrefixQueue Name-isolated-784f394c-42b6-435a-983c-b7beff2784f9-consumer-1",
        topicService.buildConsumerGroupId("Service Prefix",
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Queue Name", 1));
    assertEquals("Service PrefixQueue Name-isolated-784f394c-42b6-435a-983c-b7beff2784f9-consumer",
        topicService.buildConsumerGroupId("Service Prefix",
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), "Queue Name", null));
  }

  /**
   * Test {@link TopicService#suffix(Integer)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link TopicService#suffix(Integer)}
   */
  @Test
  @DisplayName("Test suffix(Integer); when 'null'; then return empty string")
  void testSuffix_whenNull_thenReturnEmptyString() {
    // Arrange, Act and Assert
    assertEquals("", topicService.suffix(null));
  }

  /**
   * Test {@link TopicService#suffix(Integer)}.
   * <ul>
   *   <li>When one.</li>
   *   <li>Then return {@code -1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link TopicService#suffix(Integer)}
   */
  @Test
  @DisplayName("Test suffix(Integer); when one; then return '-1'")
  void testSuffix_whenOne_thenReturn1() {
    // Arrange, Act and Assert
    assertEquals("-1", topicService.suffix(1));
  }
}
