package org.thingsboard.server.queue.azure.servicebus;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class TbServiceBusQueueConfigsDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TbServiceBusQueueConfigs#getCoreConfigs()}
   *   <li>{@link TbServiceBusQueueConfigs#getEdgeConfigs()}
   *   <li>{@link TbServiceBusQueueConfigs#getJsExecutorConfigs()}
   *   <li>{@link TbServiceBusQueueConfigs#getNotificationsConfigs()}
   *   <li>{@link TbServiceBusQueueConfigs#getRuleEngineConfigs()}
   *   <li>{@link TbServiceBusQueueConfigs#getTransportApiConfigs()}
   *   <li>{@link TbServiceBusQueueConfigs#getVcConfigs()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TbServiceBusQueueConfigs.getCoreConfigs()", "Map TbServiceBusQueueConfigs.getEdgeConfigs()",
      "Map TbServiceBusQueueConfigs.getJsExecutorConfigs()", "Map TbServiceBusQueueConfigs.getNotificationsConfigs()",
      "Map TbServiceBusQueueConfigs.getRuleEngineConfigs()", "Map TbServiceBusQueueConfigs.getTransportApiConfigs()",
      "Map TbServiceBusQueueConfigs.getVcConfigs()"})
  void testGettersAndSetters() {
    // Arrange
    TbServiceBusQueueConfigs tbServiceBusQueueConfigs = new TbServiceBusQueueConfigs();

    // Act
    Map<String, String> actualCoreConfigs = tbServiceBusQueueConfigs.getCoreConfigs();
    Map<String, String> actualEdgeConfigs = tbServiceBusQueueConfigs.getEdgeConfigs();
    Map<String, String> actualJsExecutorConfigs = tbServiceBusQueueConfigs.getJsExecutorConfigs();
    Map<String, String> actualNotificationsConfigs = tbServiceBusQueueConfigs.getNotificationsConfigs();
    Map<String, String> actualRuleEngineConfigs = tbServiceBusQueueConfigs.getRuleEngineConfigs();
    Map<String, String> actualTransportApiConfigs = tbServiceBusQueueConfigs.getTransportApiConfigs();

    // Assert
    assertNull(actualCoreConfigs);
    assertNull(actualEdgeConfigs);
    assertNull(actualJsExecutorConfigs);
    assertNull(actualNotificationsConfigs);
    assertNull(actualRuleEngineConfigs);
    assertNull(actualTransportApiConfigs);
    assertNull(tbServiceBusQueueConfigs.getVcConfigs());
  }
}
