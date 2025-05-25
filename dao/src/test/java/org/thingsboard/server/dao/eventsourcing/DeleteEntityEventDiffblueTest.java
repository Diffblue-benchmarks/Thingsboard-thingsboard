package org.thingsboard.server.dao.eventsourcing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeleteEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeleteEntityEvent#DeleteEntityEvent(TenantId, EntityId, Object, String, ActionCause, long)}
   *   <li>{@link DeleteEntityEvent#toString()}
   *   <li>{@link DeleteEntityEvent#getBody()}
   *   <li>{@link DeleteEntityEvent#getCause()}
   *   <li>{@link DeleteEntityEvent#getEntity()}
   *   <li>{@link DeleteEntityEvent#getEntityId()}
   *   <li>{@link DeleteEntityEvent#getTenantId()}
   *   <li>{@link DeleteEntityEvent#getTs()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DeleteEntityEvent.<init>(TenantId, EntityId, Object, String, ActionCause, long)",
      "String DeleteEntityEvent.getBody()", "ActionCause DeleteEntityEvent.getCause()",
      "Object DeleteEntityEvent.getEntity()", "EntityId DeleteEntityEvent.getEntityId()",
      "TenantId DeleteEntityEvent.getTenantId()", "long DeleteEntityEvent.getTs()",
      "String DeleteEntityEvent.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    DeleteEntityEvent<Object> actualDeleteEntityEvent = new DeleteEntityEvent<>(ModelConstants.SYSTEM_TENANT, entityId,
        "Entity", "Not all who wander are lost", ActionCause.TENANT_DELETION, 1L);
    String actualToStringResult = actualDeleteEntityEvent.toString();
    String actualBody = actualDeleteEntityEvent.getBody();
    ActionCause actualCause = actualDeleteEntityEvent.getCause();
    Object actualEntity = actualDeleteEntityEvent.getEntity();
    EntityId actualEntityId = actualDeleteEntityEvent.getEntityId();
    TenantId actualTenantId = actualDeleteEntityEvent.getTenantId();

    // Assert
    assertEquals(
        "DeleteEntityEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, entityId=13814000-1dd2-11b2-8080"
            + "-808080808080, entity=Entity, body=Not all who wander are lost, cause=TENANT_DELETION, ts=1)",
        actualToStringResult);
    assertEquals("Entity", actualEntity);
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals(1L, actualDeleteEntityEvent.getTs());
    assertEquals(ActionCause.TENANT_DELETION, actualCause);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(entityId, actualEntityId);
  }
}
