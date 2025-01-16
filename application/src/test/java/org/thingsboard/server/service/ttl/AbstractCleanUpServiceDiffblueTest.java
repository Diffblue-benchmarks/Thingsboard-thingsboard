package org.thingsboard.server.service.ttl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.dao.event.BaseEventService;
import org.thingsboard.server.queue.discovery.PartitionService;

class AbstractCleanUpServiceDiffblueTest {
  /**
   * Test {@link AbstractCleanUpService#isSystemTenantPartitionMine()}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCleanUpService#isSystemTenantPartitionMine()}
   */
  @Test
  @DisplayName("Test isSystemTenantPartitionMine(); then return 'false'")
  void testIsSystemTenantPartitionMine_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder topicPartitionInfoBuilder = mock(
        TopicPartitionInfo.TopicPartitionInfoBuilder.class);
    when(topicPartitionInfoBuilder.myPartition(anyBoolean())).thenReturn(TopicPartitionInfo.builder());
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = topicPartitionInfoBuilder.myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    PartitionService partitionService = mock(PartitionService.class);
    when(partitionService.resolve(Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(buildResult);

    // Act
    boolean actualIsSystemTenantPartitionMineResult = (new EventsCleanUpService(partitionService,
        new BaseEventService())).isSystemTenantPartitionMine();

    // Assert
    verify(topicPartitionInfoBuilder).myPartition(eq(true));
    verify(partitionService).resolve(eq(ServiceType.TB_CORE), isA(TenantId.class), isA(EntityId.class));
    assertFalse(actualIsSystemTenantPartitionMineResult);
  }

  /**
   * Test {@link AbstractCleanUpService#isSystemTenantPartitionMine()}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AbstractCleanUpService#isSystemTenantPartitionMine()}
   */
  @Test
  @DisplayName("Test isSystemTenantPartitionMine(); then return 'true'")
  void testIsSystemTenantPartitionMine_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    PartitionService partitionService = mock(PartitionService.class);
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = TopicPartitionInfo.builder()
        .myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    when(partitionService.resolve(Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(buildResult);

    // Act
    boolean actualIsSystemTenantPartitionMineResult = (new EventsCleanUpService(partitionService,
        new BaseEventService())).isSystemTenantPartitionMine();

    // Assert
    verify(partitionService).resolve(eq(ServiceType.TB_CORE), isA(TenantId.class), isA(EntityId.class));
    assertTrue(actualIsSystemTenantPartitionMineResult);
  }
}
