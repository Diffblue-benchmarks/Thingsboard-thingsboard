package org.thingsboard.server.service.edge.rpc.processor.telemetry;

import static org.junit.jupiter.api.Assertions.assertNull;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.TenantId;

class BaseTelemetryProcessorDiffblueTest {
  /**
   * Test {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType,
   * UUID, EdgeEventActionType, JsonNode)}.
   *
   * <ul>
   *   <li>When {@code ASSET}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID,
   * EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'ASSET'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.gen.edge.v1.EntityDataProto BaseTelemetryProcessor.convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)"
  })
  void testConvertTelemetryEventToEntityDataProto_whenAsset_thenReturnNull() {
    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNull(
        telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(
            tenantId,
            EntityType.ASSET,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            EdgeEventActionType.TIMESERIES_UPDATED,
            null));
  }

  /**
   * Test {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType,
   * UUID, EdgeEventActionType, JsonNode)}.
   *
   * <ul>
   *   <li>When {@code CUSTOMER}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID,
   * EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'CUSTOMER'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.gen.edge.v1.EntityDataProto BaseTelemetryProcessor.convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)"
  })
  void testConvertTelemetryEventToEntityDataProto_whenCustomer_thenReturnNull() {
    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNull(
        telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(
            tenantId,
            EntityType.CUSTOMER,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            EdgeEventActionType.TIMESERIES_UPDATED,
            null));
  }

  /**
   * Test {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType,
   * UUID, EdgeEventActionType, JsonNode)}.
   *
   * <ul>
   *   <li>When {@code DASHBOARD}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID,
   * EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'DASHBOARD'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.gen.edge.v1.EntityDataProto BaseTelemetryProcessor.convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)"
  })
  void testConvertTelemetryEventToEntityDataProto_whenDashboard_thenReturnNull() {
    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNull(
        telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(
            tenantId,
            EntityType.DASHBOARD,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            EdgeEventActionType.TIMESERIES_UPDATED,
            null));
  }

  /**
   * Test {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType,
   * UUID, EdgeEventActionType, JsonNode)}.
   *
   * <ul>
   *   <li>When {@code DEVICE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID,
   * EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'DEVICE'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.gen.edge.v1.EntityDataProto BaseTelemetryProcessor.convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)"
  })
  void testConvertTelemetryEventToEntityDataProto_whenDevice_thenReturnNull() {
    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNull(
        telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(
            tenantId,
            EntityType.DEVICE,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            EdgeEventActionType.TIMESERIES_UPDATED,
            null));
  }

  /**
   * Test {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType,
   * UUID, EdgeEventActionType, JsonNode)}.
   *
   * <ul>
   *   <li>When {@code EDGE}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID,
   * EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'EDGE'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.gen.edge.v1.EntityDataProto BaseTelemetryProcessor.convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)"
  })
  void testConvertTelemetryEventToEntityDataProto_whenEdge_thenReturnNull() {
    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNull(
        telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(
            tenantId,
            EntityType.EDGE,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            EdgeEventActionType.TIMESERIES_UPDATED,
            null));
  }

  /**
   * Test {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType,
   * UUID, EdgeEventActionType, JsonNode)}.
   *
   * <ul>
   *   <li>When {@code ENTITY_VIEW}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID,
   * EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'ENTITY_VIEW'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.gen.edge.v1.EntityDataProto BaseTelemetryProcessor.convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)"
  })
  void testConvertTelemetryEventToEntityDataProto_whenEntityView_thenReturnNull() {
    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNull(
        telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(
            tenantId,
            EntityType.ENTITY_VIEW,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            EdgeEventActionType.TIMESERIES_UPDATED,
            null));
  }

  /**
   * Test {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType,
   * UUID, EdgeEventActionType, JsonNode)}.
   *
   * <ul>
   *   <li>When {@code TENANT}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID,
   * EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'TENANT'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.gen.edge.v1.EntityDataProto BaseTelemetryProcessor.convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)"
  })
  void testConvertTelemetryEventToEntityDataProto_whenTenant_thenReturnNull() {
    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNull(
        telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(
            tenantId,
            EntityType.TENANT,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            EdgeEventActionType.TIMESERIES_UPDATED,
            null));
  }

  /**
   * Test {@link BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType,
   * UUID, EdgeEventActionType, JsonNode)}.
   *
   * <ul>
   *   <li>When {@code USER}.
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link
   * BaseTelemetryProcessor#convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID,
   * EdgeEventActionType, JsonNode)}
   */
  @Test
  @DisplayName(
      "Test convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode); when 'USER'; then return 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "org.thingsboard.server.gen.edge.v1.EntityDataProto BaseTelemetryProcessor.convertTelemetryEventToEntityDataProto(TenantId, EntityType, UUID, EdgeEventActionType, JsonNode)"
  })
  void testConvertTelemetryEventToEntityDataProto_whenUser_thenReturnNull() {
    // Arrange
    TelemetryEdgeProcessor telemetryEdgeProcessor = new TelemetryEdgeProcessor();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNull(
        telemetryEdgeProcessor.convertTelemetryEventToEntityDataProto(
            tenantId,
            EntityType.USER,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            EdgeEventActionType.TIMESERIES_UPDATED,
            null));
  }
}
