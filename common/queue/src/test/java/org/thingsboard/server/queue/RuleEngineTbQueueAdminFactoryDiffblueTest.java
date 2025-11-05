package org.thingsboard.server.queue;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.queue.kafka.TbKafkaAdmin;
import org.thingsboard.server.queue.kafka.TbKafkaSettings;
import org.thingsboard.server.queue.kafka.TbKafkaTopicConfigs;

@ExtendWith(MockitoExtension.class)
class RuleEngineTbQueueAdminFactoryDiffblueTest {
  @InjectMocks private RuleEngineTbQueueAdminFactory ruleEngineTbQueueAdminFactory;

  @Mock private TbKafkaSettings tbKafkaSettings;

  @Mock private TbKafkaTopicConfigs tbKafkaTopicConfigs;

  /**
   * Test {@link RuleEngineTbQueueAdminFactory#createKafkaAdmin()}.
   *
   * <ul>
   *   <li>Given {@link HashMap#HashMap()} {@code partitions} is {@code 42}.
   *   <li>Then return {@link TbKafkaAdmin}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineTbQueueAdminFactory#createKafkaAdmin()}
   */
  @Test
  @DisplayName(
      "Test createKafkaAdmin(); given HashMap() 'partitions' is '42'; then return TbKafkaAdmin")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueAdmin RuleEngineTbQueueAdminFactory.createKafkaAdmin()"})
  void testCreateKafkaAdmin_givenHashMapPartitionsIs42_thenReturnTbKafkaAdmin() {
    // Arrange
    when(tbKafkaSettings.getReplicationFactor()).thenReturn((short) 1);

    HashMap<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put("partitions", "42");
    when(tbKafkaTopicConfigs.getRuleEngineConfigs()).thenReturn(stringStringMap);

    // Act
    TbQueueAdmin actualCreateKafkaAdminResult = ruleEngineTbQueueAdminFactory.createKafkaAdmin();

    // Assert
    verify(tbKafkaSettings).getReplicationFactor();
    verify(tbKafkaTopicConfigs).getRuleEngineConfigs();
    assertTrue(actualCreateKafkaAdminResult instanceof TbKafkaAdmin);
  }

  /**
   * Test {@link RuleEngineTbQueueAdminFactory#createKafkaAdmin()}.
   *
   * <ul>
   *   <li>Then return {@link TbKafkaAdmin}.
   * </ul>
   *
   * <p>Method under test: {@link RuleEngineTbQueueAdminFactory#createKafkaAdmin()}
   */
  @Test
  @DisplayName("Test createKafkaAdmin(); then return TbKafkaAdmin")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"TbQueueAdmin RuleEngineTbQueueAdminFactory.createKafkaAdmin()"})
  void testCreateKafkaAdmin_thenReturnTbKafkaAdmin() {
    // Arrange
    when(tbKafkaSettings.getReplicationFactor()).thenReturn((short) 1);
    when(tbKafkaTopicConfigs.getRuleEngineConfigs()).thenReturn(new HashMap<>());

    // Act
    TbQueueAdmin actualCreateKafkaAdminResult = ruleEngineTbQueueAdminFactory.createKafkaAdmin();

    // Assert
    verify(tbKafkaSettings).getReplicationFactor();
    verify(tbKafkaTopicConfigs).getRuleEngineConfigs();
    assertTrue(actualCreateKafkaAdminResult instanceof TbKafkaAdmin);
  }
}
