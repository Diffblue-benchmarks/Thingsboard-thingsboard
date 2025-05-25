package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.edge.EdgeEventActionType;
import org.thingsboard.server.common.data.edge.EdgeEventType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;

public class EdgeEventEntityDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeEventEntity#EdgeEventEntity()}
   *   <li>{@link EdgeEventEntity#setEdgeEventAction(EdgeEventActionType)}
   *   <li>{@link EdgeEventEntity#setEdgeEventType(EdgeEventType)}
   *   <li>{@link EdgeEventEntity#setEdgeEventUid(String)}
   *   <li>{@link EdgeEventEntity#setEdgeId(UUID)}
   *   <li>{@link EdgeEventEntity#setEntityBody(JsonNode)}
   *   <li>{@link EdgeEventEntity#setEntityId(UUID)}
   *   <li>{@link EdgeEventEntity#setSeqId(long)}
   *   <li>{@link EdgeEventEntity#setTenantId(UUID)}
   *   <li>{@link EdgeEventEntity#setTs(long)}
   *   <li>{@link EdgeEventEntity#toString()}
   *   <li>{@link EdgeEventEntity#getEdgeEventAction()}
   *   <li>{@link EdgeEventEntity#getEdgeEventType()}
   *   <li>{@link EdgeEventEntity#getEdgeEventUid()}
   *   <li>{@link EdgeEventEntity#getEdgeId()}
   *   <li>{@link EdgeEventEntity#getEntityBody()}
   *   <li>{@link EdgeEventEntity#getEntityId()}
   *   <li>{@link EdgeEventEntity#getSeqId()}
   *   <li>{@link EdgeEventEntity#getTenantId()}
   *   <li>{@link EdgeEventEntity#getTs()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeEventEntity.<init>()", "EdgeEventActionType EdgeEventEntity.getEdgeEventAction()",
      "EdgeEventType EdgeEventEntity.getEdgeEventType()", "String EdgeEventEntity.getEdgeEventUid()",
      "UUID EdgeEventEntity.getEdgeId()", "JsonNode EdgeEventEntity.getEntityBody()",
      "UUID EdgeEventEntity.getEntityId()", "long EdgeEventEntity.getSeqId()", "UUID EdgeEventEntity.getTenantId()",
      "long EdgeEventEntity.getTs()", "void EdgeEventEntity.setEdgeEventAction(EdgeEventActionType)",
      "void EdgeEventEntity.setEdgeEventType(EdgeEventType)", "void EdgeEventEntity.setEdgeEventUid(String)",
      "void EdgeEventEntity.setEdgeId(UUID)", "void EdgeEventEntity.setEntityBody(JsonNode)",
      "void EdgeEventEntity.setEntityId(UUID)", "void EdgeEventEntity.setSeqId(long)",
      "void EdgeEventEntity.setTenantId(UUID)", "void EdgeEventEntity.setTs(long)",
      "String EdgeEventEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    EdgeEventEntity actualEdgeEventEntity = new EdgeEventEntity();
    actualEdgeEventEntity.setEdgeEventAction(EdgeEventActionType.ADDED);
    actualEdgeEventEntity.setEdgeEventType(EdgeEventType.DASHBOARD);
    actualEdgeEventEntity.setEdgeEventUid("1234");
    UUID edgeId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEdgeEventEntity.setEdgeId(edgeId);
    JsonNode entityBody = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualEdgeEventEntity.setEntityBody(entityBody);
    UUID entityId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEdgeEventEntity.setEntityId(entityId);
    actualEdgeEventEntity.setSeqId(1L);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEdgeEventEntity.setTenantId(tenantId);
    actualEdgeEventEntity.setTs(1L);
    String actualToStringResult = actualEdgeEventEntity.toString();
    EdgeEventActionType actualEdgeEventAction = actualEdgeEventEntity.getEdgeEventAction();
    EdgeEventType actualEdgeEventType = actualEdgeEventEntity.getEdgeEventType();
    String actualEdgeEventUid = actualEdgeEventEntity.getEdgeEventUid();
    UUID actualEdgeId = actualEdgeEventEntity.getEdgeId();
    JsonNode actualEntityBody = actualEdgeEventEntity.getEntityBody();
    UUID actualEntityId = actualEdgeEventEntity.getEntityId();
    long actualSeqId = actualEdgeEventEntity.getSeqId();
    UUID actualTenantId = actualEdgeEventEntity.getTenantId();
    long actualTs = actualEdgeEventEntity.getTs();

    // Assert
    assertEquals("1234", actualEdgeEventUid);
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEdgeId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualEntityId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals(
        "EdgeEventEntity(seqId=1, tenantId=784f394c-42b6-435a-983c-b7beff2784f9, edgeId=784f394c-42b6-435a-983c"
            + "-b7beff2784f9, entityId=784f394c-42b6-435a-983c-b7beff2784f9, edgeEventType=DASHBOARD, edgeEventAction=ADDED,"
            + " entityBody={\"isPublic\":true}, edgeEventUid=1234, ts=1)",
        actualToStringResult);
    assertNull(actualEdgeEventEntity.getId());
    assertNull(actualEdgeEventEntity.getUuid());
    assertEquals(0L, actualEdgeEventEntity.getCreatedTime());
    assertEquals(1L, actualSeqId);
    assertEquals(1L, actualTs);
    assertEquals(EdgeEventActionType.ADDED, actualEdgeEventAction);
    assertEquals(EdgeEventType.DASHBOARD, actualEdgeEventType);
    assertSame(edgeId, actualEdgeId);
    assertSame(entityId, actualEntityId);
    assertSame(tenantId, actualTenantId);
    assertSame(entityBody, actualEntityBody);
  }
}
