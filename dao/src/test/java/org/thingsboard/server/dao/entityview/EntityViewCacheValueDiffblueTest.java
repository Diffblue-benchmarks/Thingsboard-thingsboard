package org.thingsboard.server.dao.entityview;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.common.data.EntityViewInfo;
import org.thingsboard.server.dao.entityview.EntityViewCacheValue.EntityViewCacheValueBuilder;

@ContextConfiguration(classes = {EntityViewCacheValueBuilder.class})
@ExtendWith(SpringExtension.class)
class EntityViewCacheValueDiffblueTest {
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
  @DisplayName("Test EntityViewCacheValueBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityViewCacheValueBuilder.<init>()",
    "EntityViewCacheValue EntityViewCacheValueBuilder.build()",
    "EntityViewCacheValueBuilder EntityViewCacheValueBuilder.entityView(EntityView)",
    "EntityViewCacheValueBuilder EntityViewCacheValueBuilder.entityViews(List)",
    "java.lang.String EntityViewCacheValueBuilder.toString()"
  })
  void testEntityViewCacheValueBuilderBuild() {
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
  @DisplayName("Test getVersion(); given EntityView() Version is one; then return longValue is one")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long EntityViewCacheValue.getVersion()"})
  void testGetVersion_givenEntityViewVersionIsOne_thenReturnLongValueIsOne() {
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
  @DisplayName("Test getVersion(); then return longValue is zero")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"java.lang.Long EntityViewCacheValue.getVersion()"})
  void testGetVersion_thenReturnLongValueIsZero() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityViewCacheValue.equals(Object)",
    "int EntityViewCacheValue.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityViewCacheValue.<init>(EntityView, List)",
    "EntityView EntityViewCacheValue.getEntityView()",
    "List EntityViewCacheValue.getEntityViews()"
  })
  void testGettersAndSetters() {
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
