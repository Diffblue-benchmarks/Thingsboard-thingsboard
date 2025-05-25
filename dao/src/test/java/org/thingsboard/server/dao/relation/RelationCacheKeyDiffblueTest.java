package org.thingsboard.server.dao.relation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.dao.entity.BaseEntityService;

public class RelationCacheKeyDiffblueTest {
  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationCacheKey#RelationCacheKey(EntityId, EntityId, String, RelationTypeGroup)}
   *   <li>{@link RelationCacheKey#toString()}
   *   <li>{@link RelationCacheKey#getDirection()}
   *   <li>{@link RelationCacheKey#getFrom()}
   *   <li>{@link RelationCacheKey#getTo()}
   *   <li>{@link RelationCacheKey#getType()}
   *   <li>{@link RelationCacheKey#getTypeGroup()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RelationCacheKey.<init>(EntityId, EntityId, String, RelationTypeGroup)",
      "void RelationCacheKey.<init>(EntityId, EntityId, String, RelationTypeGroup, EntitySearchDirection)",
      "EntitySearchDirection RelationCacheKey.getDirection()", "EntityId RelationCacheKey.getFrom()",
      "EntityId RelationCacheKey.getTo()", "String RelationCacheKey.getType()",
      "RelationTypeGroup RelationCacheKey.getTypeGroup()", "String RelationCacheKey.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    CustomerId resultTo = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    RelationCacheKey actualRelationCacheKey = new RelationCacheKey(BaseEntityService.NULL_CUSTOMER_ID, resultTo, "Type",
        RelationTypeGroup.COMMON);
    String actualToStringResult = actualRelationCacheKey.toString();
    EntitySearchDirection actualDirection = actualRelationCacheKey.getDirection();
    EntityId actualFrom = actualRelationCacheKey.getFrom();
    EntityId actualTo = actualRelationCacheKey.getTo();
    String actualType = actualRelationCacheKey.getType();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080_13814000-1dd2-11b2-8080-808080808080_Type_COMMON",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertNull(actualDirection);
    assertEquals(RelationTypeGroup.COMMON, actualRelationCacheKey.getTypeGroup());
    assertSame(resultTo, actualFrom);
    assertSame(resultTo, actualTo);
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationCacheKey#RelationCacheKey(EntityId, EntityId, String, RelationTypeGroup, EntitySearchDirection)}
   *   <li>{@link RelationCacheKey#toString()}
   *   <li>{@link RelationCacheKey#getDirection()}
   *   <li>{@link RelationCacheKey#getFrom()}
   *   <li>{@link RelationCacheKey#getTo()}
   *   <li>{@link RelationCacheKey#getType()}
   *   <li>{@link RelationCacheKey#getTypeGroup()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RelationCacheKey.<init>(EntityId, EntityId, String, RelationTypeGroup)",
      "void RelationCacheKey.<init>(EntityId, EntityId, String, RelationTypeGroup, EntitySearchDirection)",
      "EntitySearchDirection RelationCacheKey.getDirection()", "EntityId RelationCacheKey.getFrom()",
      "EntityId RelationCacheKey.getTo()", "String RelationCacheKey.getType()",
      "RelationTypeGroup RelationCacheKey.getTypeGroup()", "String RelationCacheKey.toString()"})
  public void testGettersAndSetters2() {
    // Arrange
    CustomerId resultTo = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    RelationCacheKey actualRelationCacheKey = new RelationCacheKey(BaseEntityService.NULL_CUSTOMER_ID, resultTo, "Type",
        RelationTypeGroup.COMMON, EntitySearchDirection.FROM);
    String actualToStringResult = actualRelationCacheKey.toString();
    EntitySearchDirection actualDirection = actualRelationCacheKey.getDirection();
    EntityId actualFrom = actualRelationCacheKey.getFrom();
    EntityId actualTo = actualRelationCacheKey.getTo();
    String actualType = actualRelationCacheKey.getType();

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080_13814000-1dd2-11b2-8080-808080808080_Type_COMMON_FROM",
        actualToStringResult);
    assertEquals("Type", actualType);
    assertEquals(EntitySearchDirection.FROM, actualDirection);
    assertEquals(RelationTypeGroup.COMMON, actualRelationCacheKey.getTypeGroup());
    assertSame(resultTo, actualFrom);
    assertSame(resultTo, actualTo);
  }
}
