package org.thingsboard.server.dao.relation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.dao.entity.BaseEntityService;

public class EntityRelationEventDiffblueTest {
  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityRelationEvent#EntityRelationEvent(EntityId, EntityId, String,
   *       RelationTypeGroup)}
   *   <li>{@link EntityRelationEvent#toString()}
   *   <li>{@link EntityRelationEvent#getFrom()}
   *   <li>{@link EntityRelationEvent#getTo()}
   *   <li>{@link EntityRelationEvent#getType()}
   *   <li>{@link EntityRelationEvent#getTypeGroup()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void EntityRelationEvent.<init>(EntityId, EntityId, String, RelationTypeGroup)",
    "EntityId EntityRelationEvent.getFrom()",
    "EntityId EntityRelationEvent.getTo()",
    "String EntityRelationEvent.getType()",
    "RelationTypeGroup EntityRelationEvent.getTypeGroup()",
    "String EntityRelationEvent.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    CustomerId resultTo = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    EntityRelationEvent actualEntityRelationEvent =
        new EntityRelationEvent(
            BaseEntityService.NULL_CUSTOMER_ID, resultTo, "Type", RelationTypeGroup.COMMON);
    String actualToStringResult = actualEntityRelationEvent.toString();
    EntityId actualFrom = actualEntityRelationEvent.getFrom();
    EntityId actualTo = actualEntityRelationEvent.getTo();
    String actualType = actualEntityRelationEvent.getType();

    // Assert
    assertEquals(
        "EntityRelationEvent(from=13814000-1dd2-11b2-8080-808080808080, to=13814000-1dd2-11b2-8080-808080808080,"
            + " type=Type, typeGroup=COMMON)",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertEquals(RelationTypeGroup.COMMON, actualEntityRelationEvent.getTypeGroup());
    assertSame(resultTo, actualFrom);
    assertSame(resultTo, actualTo);
  }
}
