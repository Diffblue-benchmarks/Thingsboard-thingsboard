package org.thingsboard.server.dao.entityview;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityView;
import org.thingsboard.server.dao.entityview.EntityViewCacheValue.EntityViewCacheValueBuilder;

public class EntityViewCacheValueDiffblueTest {
  /**
   * Test EntityViewCacheValueBuilder {@link EntityViewCacheValueBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewCacheValue.EntityViewCacheValueBuilder#build()}
   *   <li>
   * {@link EntityViewCacheValue.EntityViewCacheValueBuilder#entityView(EntityView)}
   *   <li>
   * {@link EntityViewCacheValue.EntityViewCacheValueBuilder#entityViews(List)}
   * </ul>
   */
  @Test
  public void testEntityViewCacheValueBuilderBuild() {
    // Arrange
    EntityViewCacheValue.EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();
    EntityView entityView = new EntityView();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult = builderResult.entityView(entityView);
    ArrayList<EntityView> entityViews = new ArrayList<>();

    // Act
    EntityViewCacheValue actualBuildResult = entityViewResult.entityViews(entityViews).build();

    // Assert
    List<EntityView> entityViews2 = actualBuildResult.getEntityViews();
    assertTrue(entityViews2.isEmpty());
    assertSame(entityViews, entityViews2);
    assertSame(entityView, actualBuildResult.getEntityView());
  }

  /**
   * Test {@link EntityViewCacheValue#getVersion()}.
   * <ul>
   *   <li>Given {@link EntityView#EntityView()} Version is one.</li>
   *   <li>Then return longValue is one.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheValue#getVersion()}
   */
  @Test
  public void testGetVersion_givenEntityViewVersionIsOne_thenReturnLongValueIsOne() {
    // Arrange
    EntityView entityView = new EntityView();
    entityView.setVersion(1L);

    // Act and Assert
    assertEquals(1L, (new EntityViewCacheValue(entityView, new ArrayList<>())).getVersion().longValue());
  }

  /**
   * Test {@link EntityViewCacheValue#getVersion()}.
   * <ul>
   *   <li>Then return longValue is zero.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheValue#getVersion()}
   */
  @Test
  public void testGetVersion_thenReturnLongValueIsZero() {
    // Arrange, Act and Assert
    assertEquals(0L, (new EntityViewCacheValue(null, new ArrayList<>())).getVersion().longValue());
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}, and
   * {@link EntityViewCacheValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewCacheValue#equals(Object)}
   *   <li>{@link EntityViewCacheValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewCacheValue.EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult = builderResult.entityView(new EntityView());
    EntityViewCacheValue buildResult = entityViewResult.entityViews(new ArrayList<>()).build();
    EntityViewCacheValue.EntityViewCacheValueBuilder builderResult2 = EntityViewCacheValue.builder();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult2 = builderResult2.entityView(new EntityView());
    EntityViewCacheValue buildResult2 = entityViewResult2.entityViews(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}, and
   * {@link EntityViewCacheValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewCacheValue#equals(Object)}
   *   <li>{@link EntityViewCacheValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder.entityView(Mockito.<EntityView>any())).thenReturn(EntityViewCacheValue.builder());
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult = entityViewCacheValueBuilder
        .entityView(new EntityView());
    EntityViewCacheValue buildResult = entityViewResult.entityViews(new ArrayList<>()).build();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder2 = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder2.entityView(Mockito.<EntityView>any())).thenReturn(EntityViewCacheValue.builder());
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult2 = entityViewCacheValueBuilder2
        .entityView(new EntityView());
    EntityViewCacheValue buildResult2 = entityViewResult2.entityViews(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}, and
   * {@link EntityViewCacheValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewCacheValue#equals(Object)}
   *   <li>{@link EntityViewCacheValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewCacheValue.EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult = builderResult.entityView(new EntityView());
    EntityViewCacheValue buildResult = entityViewResult.entityViews(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder.entityView(Mockito.<EntityView>any())).thenReturn(EntityViewCacheValue.builder());
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult = entityViewCacheValueBuilder
        .entityView(new EntityView());
    EntityViewCacheValue buildResult = entityViewResult.entityViews(new ArrayList<>()).build();
    EntityViewCacheValue.EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult2 = builderResult.entityView(new EntityView());
    EntityViewCacheValue buildResult2 = entityViewResult2.entityViews(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder.entityViews(Mockito.<List<EntityView>>any()))
        .thenReturn(EntityViewCacheValue.builder());
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder2 = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder2.entityView(Mockito.<EntityView>any())).thenReturn(entityViewCacheValueBuilder);
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult = entityViewCacheValueBuilder2
        .entityView(new EntityView());
    EntityViewCacheValue buildResult = entityViewResult.entityViews(new ArrayList<>()).build();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder3 = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder3.entityView(Mockito.<EntityView>any())).thenReturn(EntityViewCacheValue.builder());
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult2 = entityViewCacheValueBuilder3
        .entityView(new EntityView());
    EntityViewCacheValue buildResult2 = entityViewResult2.entityViews(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    EntityViewCacheValue.EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult = builderResult.entityView(new EntityView());
    EntityViewCacheValue buildResult = entityViewResult.entityViews(new ArrayList<>()).build();
    when(entityViewCacheValueBuilder.build()).thenReturn(buildResult);
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder2 = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder2.entityViews(Mockito.<List<EntityView>>any()))
        .thenReturn(entityViewCacheValueBuilder);
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder3 = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder3.entityView(Mockito.<EntityView>any())).thenReturn(entityViewCacheValueBuilder2);
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult2 = entityViewCacheValueBuilder3
        .entityView(new EntityView());
    EntityViewCacheValue buildResult2 = entityViewResult2.entityViews(new ArrayList<>()).build();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder4 = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder4.entityView(Mockito.<EntityView>any())).thenReturn(EntityViewCacheValue.builder());
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult3 = entityViewCacheValueBuilder4
        .entityView(new EntityView());
    EntityViewCacheValue buildResult3 = entityViewResult3.entityViews(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<EntityView> entityViews = new ArrayList<>();
    entityViews.add(new EntityView());
    EntityViewCacheValue buildResult = EntityViewCacheValue.builder().entityView(null).entityViews(entityViews).build();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder.build()).thenReturn(buildResult);
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder2 = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder2.entityViews(Mockito.<List<EntityView>>any()))
        .thenReturn(entityViewCacheValueBuilder);
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder3 = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder3.entityView(Mockito.<EntityView>any())).thenReturn(entityViewCacheValueBuilder2);
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult = entityViewCacheValueBuilder3
        .entityView(new EntityView());
    EntityViewCacheValue buildResult2 = entityViewResult.entityViews(new ArrayList<>()).build();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewCacheValueBuilder4 = mock(
        EntityViewCacheValue.EntityViewCacheValueBuilder.class);
    when(entityViewCacheValueBuilder4.entityView(Mockito.<EntityView>any())).thenReturn(EntityViewCacheValue.builder());
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult2 = entityViewCacheValueBuilder4
        .entityView(new EntityView());
    EntityViewCacheValue buildResult3 = entityViewResult2.entityViews(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityViewCacheValue.EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult = builderResult.entityView(new EntityView());
    EntityViewCacheValue buildResult = entityViewResult.entityViews(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link EntityViewCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewCacheValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityViewCacheValue.EntityViewCacheValueBuilder builderResult = EntityViewCacheValue.builder();
    EntityViewCacheValue.EntityViewCacheValueBuilder entityViewResult = builderResult.entityView(new EntityView());
    EntityViewCacheValue buildResult = entityViewResult.entityViews(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntityViewCacheValue");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewCacheValue#EntityViewCacheValue(EntityView, List)}
   *   <li>{@link EntityViewCacheValue#getEntityView()}
   *   <li>{@link EntityViewCacheValue#getEntityViews()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    EntityView entityView = new EntityView();
    ArrayList<EntityView> entityViews = new ArrayList<>();

    // Act
    EntityViewCacheValue actualEntityViewCacheValue = new EntityViewCacheValue(entityView, entityViews);
    EntityView actualEntityView = actualEntityViewCacheValue.getEntityView();
    List<EntityView> actualEntityViews = actualEntityViewCacheValue.getEntityViews();

    // Assert
    assertTrue(actualEntityViews.isEmpty());
    assertSame(entityViews, actualEntityViews);
    assertSame(entityView, actualEntityView);
  }
}
