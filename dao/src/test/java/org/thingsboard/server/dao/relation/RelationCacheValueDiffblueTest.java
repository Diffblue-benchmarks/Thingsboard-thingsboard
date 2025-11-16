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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.relation.RelationCacheValue.RelationCacheValueBuilder;

@ContextConfiguration(classes = {RelationCacheValueBuilder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RelationCacheValueDiffblueTest {
  @Autowired private RelationCacheValueBuilder relationCacheValueBuilder;

  /**
   * Test {@link RelationCacheValue#equals(Object)}, and {@link RelationCacheValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheValue#equals(Object)}
   *   <li>{@link RelationCacheValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCacheValue.equals(Object)",
    "int RelationCacheValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();

    RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
    RelationCacheValue relationCacheValue = relationResult.relations(new ArrayList<>()).build();

    RelationCacheValueBuilder builderResult2 = RelationCacheValue.builder();

    RelationCacheValueBuilder relationResult2 = builderResult2.relation(new EntityRelation());
    RelationCacheValue relationCacheValue2 = relationResult2.relations(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(relationCacheValue, relationCacheValue2);
    assertEquals(relationCacheValue.hashCode(), relationCacheValue2.hashCode());
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}, and {@link RelationCacheValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheValue#equals(Object)}
   *   <li>{@link RelationCacheValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCacheValue.equals(Object)",
    "int RelationCacheValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationCacheValueBuilder relationResult = RelationCacheValue.builder().relation(null);
    RelationCacheValue relationCacheValue = relationResult.relations(new ArrayList<>()).build();

    RelationCacheValueBuilder relationResult2 = RelationCacheValue.builder().relation(null);
    RelationCacheValue relationCacheValue2 = relationResult2.relations(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(relationCacheValue, relationCacheValue2);
    assertEquals(relationCacheValue.hashCode(), relationCacheValue2.hashCode());
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}, and {@link RelationCacheValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheValue#equals(Object)}
   *   <li>{@link RelationCacheValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCacheValue.equals(Object)",
    "int RelationCacheValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();

    RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
    RelationCacheValue relationCacheValue = relationResult.relations(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(relationCacheValue, relationCacheValue);
    int expectedHashCodeResult = relationCacheValue.hashCode();
    assertEquals(expectedHashCodeResult, relationCacheValue.hashCode());
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheValue#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCacheValue.equals(Object)",
    "int RelationCacheValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationCacheValueBuilder relationResult = RelationCacheValue.builder().relation(null);
    RelationCacheValue relationCacheValue = relationResult.relations(new ArrayList<>()).build();

    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();

    RelationCacheValueBuilder relationResult2 = builderResult.relation(new EntityRelation());

    // Act and Assert
    assertNotEquals(relationCacheValue, relationResult2.relations(new ArrayList<>()).build());
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheValue#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCacheValue.equals(Object)",
    "int RelationCacheValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    EntityRelation relation =
        new EntityRelation(
            BaseEntityService.NULL_CUSTOMER_ID, BaseEntityService.NULL_CUSTOMER_ID, "Type");

    RelationCacheValueBuilder relationResult = builderResult.relation(relation);
    RelationCacheValue relationCacheValue = relationResult.relations(new ArrayList<>()).build();

    RelationCacheValueBuilder builderResult2 = RelationCacheValue.builder();

    RelationCacheValueBuilder relationResult2 = builderResult2.relation(new EntityRelation());

    // Act and Assert
    assertNotEquals(relationCacheValue, relationResult2.relations(new ArrayList<>()).build());
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheValue#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCacheValue.equals(Object)",
    "int RelationCacheValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation());

    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValue relationCacheValue =
        builderResult.relation(new EntityRelation()).relations(relations).build();

    RelationCacheValueBuilder builderResult2 = RelationCacheValue.builder();

    RelationCacheValueBuilder relationResult = builderResult2.relation(new EntityRelation());

    // Act and Assert
    assertNotEquals(relationCacheValue, relationResult.relations(new ArrayList<>()).build());
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheValue#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCacheValue.equals(Object)",
    "int RelationCacheValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();

    RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());

    // Act and Assert
    assertNotEquals(relationResult.relations(new ArrayList<>()).build(), null);
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RelationCacheValue#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RelationCacheValue.equals(Object)",
    "int RelationCacheValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();

    RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());

    // Act and Assert
    assertNotEquals(
        relationResult.relations(new ArrayList<>()).build(),
        "Different type to RelationCacheValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheValue#RelationCacheValue(EntityRelation, List)}
   *   <li>{@link RelationCacheValue#getRelation()}
   *   <li>{@link RelationCacheValue#getRelations()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationCacheValue.<init>(EntityRelation, List)",
    "EntityRelation RelationCacheValue.getRelation()",
    "List RelationCacheValue.getRelations()"
  })
  public void testGettersAndSetters() {
    // Arrange
    EntityRelation relation = new EntityRelation();
    ArrayList<EntityRelation> relations = new ArrayList<>();

    // Act
    RelationCacheValue actualRelationCacheValue = new RelationCacheValue(relation, relations);
    EntityRelation actualRelation = actualRelationCacheValue.getRelation();
    List<EntityRelation> actualRelations = actualRelationCacheValue.getRelations();

    // Assert
    assertTrue(actualRelations.isEmpty());
    assertSame(relations, actualRelations);
    assertSame(relation, actualRelation);
  }

  /**
   * Test RelationCacheValueBuilder {@link RelationCacheValueBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RelationCacheValueBuilder#build()}
   *   <li>{@link RelationCacheValueBuilder#relation(EntityRelation)}
   *   <li>{@link RelationCacheValueBuilder#relations(List)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RelationCacheValueBuilder.<init>()",
    "RelationCacheValue RelationCacheValueBuilder.build()",
    "RelationCacheValueBuilder RelationCacheValueBuilder.relation(EntityRelation)",
    "RelationCacheValueBuilder RelationCacheValueBuilder.relations(List)",
    "java.lang.String RelationCacheValueBuilder.toString()"
  })
  public void testRelationCacheValueBuilderBuild() {
    // Arrange and Act
    RelationCacheValueBuilder actualBuilderResult = RelationCacheValue.builder();
    EntityRelation relation = new EntityRelation();
    RelationCacheValueBuilder actualRelationResult = actualBuilderResult.relation(relation);
    ArrayList<EntityRelation> relations = new ArrayList<>();
    RelationCacheValue actualRelationCacheValue = actualRelationResult.relations(relations).build();

    // Assert
    List<EntityRelation> relations2 = actualRelationCacheValue.getRelations();
    assertTrue(relations2.isEmpty());
    assertSame(relations, relations2);
    assertSame(relation, actualRelationCacheValue.getRelation());
  }
}
