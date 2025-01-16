package org.thingsboard.server.service.edge.rpc.processor.alarm;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.EdgeVersion;

class BaseAlarmProcessorDiffblueTest {
  /**
   * Test
   * {@link BaseAlarmProcessor#convertAlarmEventToAlarmMsg(TenantId, UUID, EdgeEventActionType, JsonNode, EdgeVersion)}.
   * <ul>
   *   <li>When {@code CREDENTIALS_UPDATED}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmProcessor#convertAlarmEventToAlarmMsg(TenantId, UUID, EdgeEventActionType, JsonNode, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmEventToAlarmMsg(TenantId, UUID, EdgeEventActionType, JsonNode, EdgeVersion); when 'CREDENTIALS_UPDATED'; then return 'null'")
  void testConvertAlarmEventToAlarmMsg_whenCredentialsUpdated_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmEventToAlarmMsg(tenantId, UUID.randomUUID(),
        EdgeEventActionType.CREDENTIALS_UPDATED, mock(JsonNode.class), EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link BaseAlarmProcessor#convertAlarmEventToAlarmMsg(TenantId, UUID, EdgeEventActionType, JsonNode, EdgeVersion)}.
   * <ul>
   *   <li>When Instance.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmProcessor#convertAlarmEventToAlarmMsg(TenantId, UUID, EdgeEventActionType, JsonNode, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmEventToAlarmMsg(TenantId, UUID, EdgeEventActionType, JsonNode, EdgeVersion); when Instance; then return 'null'")
  void testConvertAlarmEventToAlarmMsg_whenInstance_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());
    UUID entityId = UUID.randomUUID();

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmEventToAlarmMsg(tenantId, entityId, EdgeEventActionType.ALARM_DELETE,
        MissingNode.getInstance(), EdgeVersion.V_3_3_0));
  }

  /**
   * Test
   * {@link BaseAlarmProcessor#convertAlarmEventToAlarmMsg(TenantId, UUID, EdgeEventActionType, JsonNode, EdgeVersion)}.
   * <ul>
   *   <li>When {@code null}.</li>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseAlarmProcessor#convertAlarmEventToAlarmMsg(TenantId, UUID, EdgeEventActionType, JsonNode, EdgeVersion)}
   */
  @Test
  @DisplayName("Test convertAlarmEventToAlarmMsg(TenantId, UUID, EdgeEventActionType, JsonNode, EdgeVersion); when 'null'; then return 'null'")
  void testConvertAlarmEventToAlarmMsg_whenNull_thenReturnNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AlarmEdgeProcessorV1 alarmEdgeProcessorV1 = new AlarmEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertNull(alarmEdgeProcessorV1.convertAlarmEventToAlarmMsg(tenantId, UUID.randomUUID(),
        EdgeEventActionType.ALARM_DELETE, null, EdgeVersion.V_3_3_0));
  }
}
