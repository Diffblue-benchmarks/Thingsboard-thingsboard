package org.thingsboard.server.service.edge.rpc.processor.relation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.RelationUpdateMsg;

class BaseRelationProcessorDiffblueTest {
  /**
   * Test
   * {@link BaseRelationProcessor#processRelationMsg(TenantId, RelationUpdateMsg)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationProcessor#processRelationMsg(TenantId, RelationUpdateMsg)}
   */
  @Test
  @DisplayName("Test processRelationMsg(TenantId, RelationUpdateMsg); when TenantId(UUID) with id is 'null'")
  void testProcessRelationMsg_whenTenantIdWithIdIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelationEdgeProcessorV1 relationEdgeProcessorV1 = new RelationEdgeProcessorV1();
    TenantId tenantId = new TenantId(null);

    // Act and Assert
    assertTrue(relationEdgeProcessorV1.processRelationMsg(tenantId, RelationUpdateMsg.getDefaultInstance()).isDone());
  }

  /**
   * Test
   * {@link BaseRelationProcessor#processRelationMsg(TenantId, RelationUpdateMsg)}.
   * <ul>
   *   <li>When {@link TenantId#TenantId(UUID)} with id is randomUUID.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link BaseRelationProcessor#processRelationMsg(TenantId, RelationUpdateMsg)}
   */
  @Test
  @DisplayName("Test processRelationMsg(TenantId, RelationUpdateMsg); when TenantId(UUID) with id is randomUUID")
  void testProcessRelationMsg_whenTenantIdWithIdIsRandomUUID() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    RelationEdgeProcessorV1 relationEdgeProcessorV1 = new RelationEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.randomUUID());

    // Act and Assert
    assertTrue(relationEdgeProcessorV1.processRelationMsg(tenantId, RelationUpdateMsg.getDefaultInstance()).isDone());
  }
}
