package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EdgeId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.EdgeCommunicationFailureNotificationInfo;
import org.thingsboard.server.common.data.notification.info.RuleOriginatedNotificationInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.EdgeCommunicationFailureTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EdgeCommunicationFailureNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;

@ContextConfiguration(classes = {EdgeCommunicationFailureTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
class EdgeCommunicationFailureTriggerProcessorDiffblueTest {
  @Autowired
  private EdgeCommunicationFailureTriggerProcessor edgeCommunicationFailureTriggerProcessor;

  /**
   * Test
   * {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   * with {@code EdgeCommunicationFailureTrigger},
   * {@code EdgeCommunicationFailureNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig) with 'EdgeCommunicationFailureTrigger', 'EdgeCommunicationFailureNotificationRuleTriggerConfig'")
  void testMatchesFilterWithEdgeCommunicationFailureTriggerEdgeCommunicationFailureNotificationRuleTriggerConfig() {
    // Arrange, Act and Assert
    assertTrue(edgeCommunicationFailureTriggerProcessor.matchesFilter(null,
        new EdgeCommunicationFailureNotificationRuleTriggerConfig()));
  }

  /**
   * Test
   * {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   * with {@code EdgeCommunicationFailureTrigger},
   * {@code EdgeCommunicationFailureNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig) with 'EdgeCommunicationFailureTrigger', 'EdgeCommunicationFailureNotificationRuleTriggerConfig'")
  void testMatchesFilterWithEdgeCommunicationFailureTriggerEdgeCommunicationFailureNotificationRuleTriggerConfig2() {
    // Arrange
    EdgeCommunicationFailureTrigger trigger = mock(EdgeCommunicationFailureTrigger.class);

    // Act and Assert
    assertTrue(edgeCommunicationFailureTriggerProcessor.matchesFilter(trigger,
        new EdgeCommunicationFailureNotificationRuleTriggerConfig()));
  }

  /**
   * Test
   * {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   * with {@code EdgeCommunicationFailureTrigger},
   * {@code EdgeCommunicationFailureNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig) with 'EdgeCommunicationFailureTrigger', 'EdgeCommunicationFailureNotificationRuleTriggerConfig'")
  void testMatchesFilterWithEdgeCommunicationFailureTriggerEdgeCommunicationFailureNotificationRuleTriggerConfig3() {
    // Arrange
    EdgeCommunicationFailureNotificationRuleTriggerConfig.EdgeCommunicationFailureNotificationRuleTriggerConfigBuilder builderResult = EdgeCommunicationFailureNotificationRuleTriggerConfig
        .builder();
    EdgeCommunicationFailureNotificationRuleTriggerConfig triggerConfig = builderResult.edges(new HashSet<>()).build();

    // Act and Assert
    assertTrue(edgeCommunicationFailureTriggerProcessor.matchesFilter(null, triggerConfig));
  }

  /**
   * Test
   * {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   * with {@code EdgeCommunicationFailureTrigger},
   * {@code EdgeCommunicationFailureNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig) with 'EdgeCommunicationFailureTrigger', 'EdgeCommunicationFailureNotificationRuleTriggerConfig'")
  void testMatchesFilterWithEdgeCommunicationFailureTriggerEdgeCommunicationFailureNotificationRuleTriggerConfig4() {
    // Arrange
    EdgeCommunicationFailureTrigger trigger = mock(EdgeCommunicationFailureTrigger.class);
    when(trigger.getEdgeId()).thenReturn(new EdgeId(UUID.randomUUID()));

    HashSet<UUID> edges = new HashSet<>();
    edges.add(UUID.randomUUID());
    EdgeCommunicationFailureNotificationRuleTriggerConfig triggerConfig = EdgeCommunicationFailureNotificationRuleTriggerConfig
        .builder()
        .edges(edges)
        .build();

    // Act
    boolean actualMatchesFilterResult = edgeCommunicationFailureTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).getEdgeId();
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   * with {@code EdgeCommunicationFailureTrigger},
   * {@code EdgeCommunicationFailureNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link EdgeCommunicationFailureTriggerProcessor#matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EdgeCommunicationFailureTrigger, EdgeCommunicationFailureNotificationRuleTriggerConfig) with 'EdgeCommunicationFailureTrigger', 'EdgeCommunicationFailureNotificationRuleTriggerConfig'")
  void testMatchesFilterWithEdgeCommunicationFailureTriggerEdgeCommunicationFailureNotificationRuleTriggerConfig5() {
    // Arrange
    EdgeId edgeId = mock(EdgeId.class);
    when(edgeId.getId()).thenReturn(null);
    EdgeCommunicationFailureTrigger trigger = mock(EdgeCommunicationFailureTrigger.class);
    when(trigger.getEdgeId()).thenReturn(edgeId);

    HashSet<UUID> edges = new HashSet<>();
    edges.add(null);
    EdgeCommunicationFailureNotificationRuleTriggerConfig triggerConfig = EdgeCommunicationFailureNotificationRuleTriggerConfig
        .builder()
        .edges(edges)
        .build();

    // Act
    boolean actualMatchesFilterResult = edgeCommunicationFailureTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(edgeId).getId();
    verify(trigger).getEdgeId();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link EdgeCommunicationFailureTriggerProcessor#constructNotificationInfo(EdgeCommunicationFailureTrigger)}
   * with {@code EdgeCommunicationFailureTrigger}.
   * <p>
   * Method under test:
   * {@link EdgeCommunicationFailureTriggerProcessor#constructNotificationInfo(EdgeCommunicationFailureTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(EdgeCommunicationFailureTrigger) with 'EdgeCommunicationFailureTrigger'")
  void testConstructNotificationInfoWithEdgeCommunicationFailureTrigger() {
    // Arrange
    EdgeCommunicationFailureTrigger trigger = mock(EdgeCommunicationFailureTrigger.class);
    when(trigger.getEdgeName()).thenReturn("Edge Name");
    when(trigger.getFailureMsg()).thenReturn("Failure Msg");
    CustomerId customerId = new CustomerId(UUID.randomUUID());
    when(trigger.getCustomerId()).thenReturn(customerId);
    when(trigger.getEdgeId()).thenReturn(null);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    when(trigger.getTenantId()).thenReturn(tenantId);

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = edgeCommunicationFailureTriggerProcessor
        .constructNotificationInfo(trigger);

    // Assert
    verify(trigger).getCustomerId();
    verify(trigger).getEdgeId();
    verify(trigger).getEdgeName();
    verify(trigger).getFailureMsg();
    verify(trigger).getTenantId();
    assertTrue(actualConstructNotificationInfoResult instanceof EdgeCommunicationFailureNotificationInfo);
    assertEquals("Edge Name",
        ((EdgeCommunicationFailureNotificationInfo) actualConstructNotificationInfoResult).getEdgeName());
    assertEquals("Failure Msg",
        ((EdgeCommunicationFailureNotificationInfo) actualConstructNotificationInfoResult).getFailureMsg());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(((EdgeCommunicationFailureNotificationInfo) actualConstructNotificationInfoResult).getEdgeId());
    assertNull(actualConstructNotificationInfoResult.getStateEntityId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    assertSame(customerId,
        ((EdgeCommunicationFailureNotificationInfo) actualConstructNotificationInfoResult).getCustomerId());
    assertSame(customerId, actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertSame(tenantId,
        ((EdgeCommunicationFailureNotificationInfo) actualConstructNotificationInfoResult).getTenantId());
    assertSame(tenantId, actualConstructNotificationInfoResult.getAffectedTenantId());
  }

  /**
   * Test {@link EdgeCommunicationFailureTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test:
   * {@link EdgeCommunicationFailureTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertEquals(NotificationRuleTriggerType.EDGE_COMMUNICATION_FAILURE,
        (new EdgeCommunicationFailureTriggerProcessor()).getTriggerType());
  }
}
