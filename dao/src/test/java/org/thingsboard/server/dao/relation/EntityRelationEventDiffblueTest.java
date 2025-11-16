/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.relation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.dao.entity.BaseEntityService;

public class EntityRelationEventDiffblueTest {
  /**
   * Test {@link EntityRelationEvent#from(EntityRelation)}.
   *
   * <ul>
   *   <li>When {@link EntityRelation#EntityRelation()}.
   *   <li>Then return Type is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link EntityRelationEvent#from(EntityRelation)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"EntityRelationEvent EntityRelationEvent.from(EntityRelation)"})
  public void testFrom_whenEntityRelation_thenReturnTypeIsNull() {
    // Arrange and Act
    EntityRelationEvent actualFromResult = EntityRelationEvent.from(new EntityRelation());

    // Assert
    assertNull(actualFromResult.getType());
    assertNull(actualFromResult.getFrom());
    assertNull(actualFromResult.getTo());
    assertNull(actualFromResult.getTypeGroup());
  }

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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
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
