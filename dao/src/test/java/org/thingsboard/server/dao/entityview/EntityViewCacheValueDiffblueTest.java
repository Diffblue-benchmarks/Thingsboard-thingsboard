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
package org.thingsboard.server.dao.entityview;

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
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.EntityViewInfo;
import org.thingsboard.server.dao.entityview.EntityViewCacheValue.EntityViewCacheValueBuilder;

@ContextConfiguration(classes = {EntityViewCacheValueBuilder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class EntityViewCacheValueDiffblueTest {
  @Autowired private EntityViewCacheValueBuilder entityViewCacheValueBuilder;

  /**
   * Test EntityViewCacheValueBuilder {@link EntityViewCacheValueBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewCacheValueBuilder#build()}
   *   <li>{@link EntityViewCacheValueBuilder#entityView(EntityView)}
   *   <li>{@link EntityViewCacheValueBuilder#entityViews(List)}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityViewCacheValueBuilder.<init>()",
    "EntityViewCacheValue EntityViewCacheValueBuilder.build()",
    "EntityViewCacheValueBuilder EntityViewCacheValueBuilder.entityView(EntityView)",
    "EntityViewCacheValueBuilder EntityViewCacheValueBuilder.entityViews(List)",
    "java.lang.String EntityViewCacheValueBuilder.toString()"
  })
  public void testEntityViewCacheValueBuilderBuild() {
    // Arrange and Act
    EntityViewCacheValueBuilder actualBuilderResult = EntityViewCacheValue.builder();
    EntityView entityView = new EntityView();
    EntityViewCacheValueBuilder actualEntityViewResult = actualBuilderResult.entityView(entityView);
    ArrayList<EntityView> entityViews = new ArrayList<>();
    EntityViewCacheValue actualEntityViewCacheValue =
        actualEntityViewResult.entityViews(entityViews).build();

    // Assert
    List<EntityView> entityViews2 = actualEntityViewCacheValue.getEntityViews();
    assertTrue(entityViews2.isEmpty());
    assertSame(entityViews, entityViews2);
    assertSame(entityView, actualEntityViewCacheValue.getEntityView());
  }

  /**
   * Test {@link EntityViewCacheValue#getVersion()}.
   *
   * <ul>
   *   <li>Given {@link EntityView#EntityView()} Version is one.
   *   <li>Then return longValue is one.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheValue#getVersion()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long EntityViewCacheValue.getVersion()"})
  public void testGetVersion_givenEntityViewVersionIsOne_thenReturnLongValueIsOne() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setVersion(1L);
    EntityViewCacheValue entityViewCacheValue =
        new EntityViewCacheValue(entityView, new ArrayList<>());

    // Act and Assert
    assertEquals(1L, entityViewCacheValue.getVersion().longValue());
  }

  /**
   * Test {@link EntityViewCacheValue#getVersion()}.
   *
   * <ul>
   *   <li>Then return longValue is zero.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheValue#getVersion()}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long EntityViewCacheValue.getVersion()"})
  public void testGetVersion_thenReturnLongValueIsZero() {
    // Arrange
    EntityViewCacheValue entityViewCacheValue = new EntityViewCacheValue(null, new ArrayList<>());

    // Act and Assert
    assertEquals(0L, entityViewCacheValue.getVersion().longValue());
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}, and {@link EntityViewCacheValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewCacheValue#equals(Object)}
   *   <li>{@link EntityViewCacheValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();

    EntityViewCacheValueBuilder entityViewResult = builderResult.entityView(new EntityView());
    EntityViewCacheValue entityViewCacheValue =
        entityViewResult.entityViews(new ArrayList<>()).build();

    EntityViewCacheValueBuilder builderResult2 = EntityViewCacheValue.builder();

    EntityViewCacheValueBuilder entityViewResult2 = builderResult2.entityView(new EntityView());
    EntityViewCacheValue entityViewCacheValue2 =
        entityViewResult2.entityViews(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(entityViewCacheValue, entityViewCacheValue2);
    assertEquals(entityViewCacheValue.hashCode(), entityViewCacheValue2.hashCode());
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}, and {@link EntityViewCacheValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewCacheValue#equals(Object)}
   *   <li>{@link EntityViewCacheValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityViewCacheValueBuilder entityViewResult = EntityViewCacheValue.builder().entityView(null);
    EntityViewCacheValue entityViewCacheValue =
        entityViewResult.entityViews(new ArrayList<>()).build();

    EntityViewCacheValueBuilder entityViewResult2 = EntityViewCacheValue.builder().entityView(null);
    EntityViewCacheValue entityViewCacheValue2 =
        entityViewResult2.entityViews(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(entityViewCacheValue, entityViewCacheValue2);
    assertEquals(entityViewCacheValue.hashCode(), entityViewCacheValue2.hashCode());
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}, and {@link EntityViewCacheValue#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewCacheValue#equals(Object)}
   *   <li>{@link EntityViewCacheValue#hashCode()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();

    EntityViewCacheValueBuilder entityViewResult = builderResult.entityView(new EntityView());
    EntityViewCacheValue entityViewCacheValue =
        entityViewResult.entityViews(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(entityViewCacheValue, entityViewCacheValue);
    int expectedHashCodeResult = entityViewCacheValue.hashCode();
    assertEquals(expectedHashCodeResult, entityViewCacheValue.hashCode());
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheValue#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewCacheValueBuilder entityViewResult = EntityViewCacheValue.builder().entityView(null);
    EntityViewCacheValue entityViewCacheValue =
        entityViewResult.entityViews(new ArrayList<>()).build();

    EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();

    EntityViewCacheValueBuilder entityViewResult2 = builderResult.entityView(new EntityView());

    // Act and Assert
    assertNotEquals(entityViewCacheValue, entityViewResult2.entityViews(new ArrayList<>()).build());
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheValue#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();

    EntityViewCacheValueBuilder entityViewResult = builderResult.entityView(new EntityViewInfo());
    EntityViewCacheValue entityViewCacheValue =
        entityViewResult.entityViews(new ArrayList<>()).build();

    EntityViewCacheValueBuilder builderResult2 = EntityViewCacheValue.builder();

    EntityViewCacheValueBuilder entityViewResult2 = builderResult2.entityView(new EntityView());

    // Act and Assert
    assertNotEquals(entityViewCacheValue, entityViewResult2.entityViews(new ArrayList<>()).build());
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheValue#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<EntityView> entityViews = new ArrayList<>();
    entityViews.add(new EntityView());

    EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();
    EntityViewCacheValue entityViewCacheValue =
        builderResult.entityView(new EntityView()).entityViews(entityViews).build();

    EntityViewCacheValueBuilder builderResult2 = EntityViewCacheValue.builder();

    EntityViewCacheValueBuilder entityViewResult = builderResult2.entityView(new EntityView());

    // Act and Assert
    assertNotEquals(entityViewCacheValue, entityViewResult.entityViews(new ArrayList<>()).build());
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheValue#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();

    EntityViewCacheValueBuilder entityViewResult = builderResult.entityView(new EntityView());

    // Act and Assert
    assertNotEquals(entityViewResult.entityViews(new ArrayList<>()).build(), null);
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityViewCacheValue#equals(Object)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();

    EntityViewCacheValueBuilder entityViewResult = builderResult.entityView(new EntityView());

    // Act and Assert
    assertNotEquals(
        entityViewResult.entityViews(new ArrayList<>()).build(),
        "Different type to EntityViewCacheValue");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityViewCacheValue#EntityViewCacheValue(EntityView, List)}
   *   <li>{@link EntityViewCacheValue#getEntityView()}
   *   <li>{@link EntityViewCacheValue#getEntityViews()}
   * </ul>
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityViewCacheValue.<init>(EntityView, List)",
    "EntityView EntityViewCacheValue.getEntityView()",
    "List EntityViewCacheValue.getEntityViews()"
  })
  public void testGettersAndSetters() {
    // Arrange
    EntityView entityView = new EntityView();
    ArrayList<EntityView> entityViews = new ArrayList<>();

    // Act
    EntityViewCacheValue actualEntityViewCacheValue =
        new EntityViewCacheValue(entityView, entityViews);
    EntityView actualEntityView = actualEntityViewCacheValue.getEntityView();
    List<EntityView> actualEntityViews = actualEntityViewCacheValue.getEntityViews();

    // Assert
    assertTrue(actualEntityViews.isEmpty());
    assertSame(entityViews, actualEntityViews);
    assertSame(entityView, actualEntityView);
  }
}
