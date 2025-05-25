package org.thingsboard.server.service.edge.rpc.processor.relation;

import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.gen.edge.v1.RelationUpdateMsg;

@ExtendWith(MockitoExtension.class)
class BaseRelationProcessorDiffblueTest {
  @InjectMocks
  private RelationEdgeProcessorV1 relationEdgeProcessorV1;

  /**
   * Test {@link BaseRelationProcessor#processRelationMsg(TenantId, RelationUpdateMsg)}.
   * <ul>
   *   <li>Given {@link RelationEdgeProcessorV1} (default constructor).</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationProcessor#processRelationMsg(TenantId, RelationUpdateMsg)}
   */
  @Test
  @DisplayName("Test processRelationMsg(TenantId, RelationUpdateMsg); given RelationEdgeProcessorV1 (default constructor)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.google.common.util.concurrent.ListenableFuture BaseRelationProcessor.processRelationMsg(TenantId, RelationUpdateMsg)"})
  void testProcessRelationMsg_givenRelationEdgeProcessorV1() {
    // Arrange
    RelationEdgeProcessorV1 relationEdgeProcessorV1 = new RelationEdgeProcessorV1();
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertTrue(relationEdgeProcessorV1.processRelationMsg(tenantId, RelationUpdateMsg.getDefaultInstance()).isDone());
  }

  /**
   * Test {@link BaseRelationProcessor#processRelationMsg(TenantId, RelationUpdateMsg)}.
   * <ul>
   *   <li>Given {@link RelationEdgeProcessorV1}.</li>
   * </ul>
   * <p>
   * Method under test: {@link BaseRelationProcessor#processRelationMsg(TenantId, RelationUpdateMsg)}
   */
  @Test
  @DisplayName("Test processRelationMsg(TenantId, RelationUpdateMsg); given RelationEdgeProcessorV1")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
      "com.google.common.util.concurrent.ListenableFuture BaseRelationProcessor.processRelationMsg(TenantId, RelationUpdateMsg)"})
  void testProcessRelationMsg_givenRelationEdgeProcessorV12() {
    // Arrange
    TenantId tenantId = new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertTrue(relationEdgeProcessorV1.processRelationMsg(tenantId, RelationUpdateMsg.getDefaultInstance()).isDone());
  }
}
