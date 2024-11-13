package org.thingsboard.server.service.edge.rpc.processor.telemetry;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DecimalNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.TenantId;

class BaseTelemetryProcessorDiffblueTest {
  /**
   * Test
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}.
   * <ul>
   *   <li>When {@code ALARM}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName("Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'ALARM'; then return 'null'")
  void testConvertTelemetryEventToEntityDataProto_whenAlarm_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull(telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(tenantId, EntityType.ALARM,
        UUID.randomUUID(), EdgeEventActionType.TIMESERIES_UPDATED, mock(DecimalNode.class)));
  }

  /**
   * Test
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}.
   * <ul>
   *   <li>When {@code ASSET}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName("Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'ASSET'; then return 'null'")
  void testConvertTelemetryEventToEntityDataProto_whenAsset_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull(telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(tenantId, EntityType.ASSET,
        UUID.randomUUID(), EdgeEventActionType.TIMESERIES_UPDATED, null));
  }

  /**
   * Test
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}.
   * <ul>
   *   <li>When {@code CUSTOMER}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName("Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'CUSTOMER'; then return 'null'")
  void testConvertTelemetryEventToEntityDataProto_whenCustomer_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull(telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(tenantId, EntityType.CUSTOMER,
        UUID.randomUUID(), EdgeEventActionType.TIMESERIES_UPDATED, null));
  }

  /**
   * Test
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}.
   * <ul>
   *   <li>When {@code DASHBOARD}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName("Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'DASHBOARD'; then return 'null'")
  void testConvertTelemetryEventToEntityDataProto_whenDashboard_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull(telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(tenantId, EntityType.DASHBOARD,
        UUID.randomUUID(), EdgeEventActionType.TIMESERIES_UPDATED, null));
  }

  /**
   * Test
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}.
   * <ul>
   *   <li>When {@code EDGE}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName("Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'EDGE'; then return 'null'")
  void testConvertTelemetryEventToEntityDataProto_whenEdge_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull(telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(tenantId, EntityType.EDGE,
        UUID.randomUUID(), EdgeEventActionType.TIMESERIES_UPDATED, null));
  }

  /**
   * Test
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}.
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName("Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'ENTITY_VIEW'; then return 'null'")
  void testConvertTelemetryEventToEntityDataProto_whenEntityView_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull(telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(tenantId, EntityType.ENTITY_VIEW,
        UUID.randomUUID(), EdgeEventActionType.TIMESERIES_UPDATED, null));
  }

  /**
   * Test
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName("Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'null'; then return 'null'")
  void testConvertTelemetryEventToEntityDataProto_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull(telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(tenantId, EntityType.DEVICE,
        UUID.randomUUID(), EdgeEventActionType.TIMESERIES_UPDATED, null));
  }
}
