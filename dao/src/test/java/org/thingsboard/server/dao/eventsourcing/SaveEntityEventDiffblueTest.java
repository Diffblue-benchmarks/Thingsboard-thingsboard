package org.thingsboard.server.dao.eventsourcing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class SaveEntityEventDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveEntityEvent#SaveEntityEvent(TenantId, Object, Object, EntityId, Boolean)}
   *   <li>{@link SaveEntityEvent#toString()}
   *   <li>{@link SaveEntityEvent#getCreated()}
   *   <li>{@link SaveEntityEvent#getEntity()}
   *   <li>{@link SaveEntityEvent#getEntityId()}
   *   <li>{@link SaveEntityEvent#getOldEntity()}
   *   <li>{@link SaveEntityEvent#getTenantId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void SaveEntityEvent.<init>(TenantId, Object, Object, EntityId, Boolean)",
      "Boolean SaveEntityEvent.getCreated()", "Object SaveEntityEvent.getEntity()",
      "EntityId SaveEntityEvent.getEntityId()", "Object SaveEntityEvent.getOldEntity()",
      "TenantId SaveEntityEvent.getTenantId()", "String SaveEntityEvent.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    SaveEntityEvent<Object> actualSaveEntityEvent = new SaveEntityEvent<>(ModelConstants.SYSTEM_TENANT, "Entity",
        "Old Entity", entityId, true);
    String actualToStringResult = actualSaveEntityEvent.toString();
    Boolean actualCreated = actualSaveEntityEvent.getCreated();
    Object actualEntity = actualSaveEntityEvent.getEntity();
    EntityId actualEntityId = actualSaveEntityEvent.getEntityId();
    Object actualOldEntity = actualSaveEntityEvent.getOldEntity();
    TenantId actualTenantId = actualSaveEntityEvent.getTenantId();

    // Assert
    assertEquals("Entity", actualEntity);
    assertEquals("Old Entity", actualOldEntity);
    assertEquals("SaveEntityEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, entity=Entity, oldEntity=Old Entity,"
        + " entityId=13814000-1dd2-11b2-8080-808080808080, created=true)", actualToStringResult);
    assertTrue(actualCreated);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(entityId, actualEntityId);
  }
}
