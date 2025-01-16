package org.thingsboard.server.dao.relation;

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
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.dao.relation.RelationCacheValue.RelationCacheValueBuilder;

public class RelationCacheValueDiffblueTest {
  /**
   * Test {@link RelationCacheValue#equals(Object)}, and
   * {@link RelationCacheValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationCacheValue#equals(Object)}
   *   <li>{@link RelationCacheValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationCacheValue.RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValue.RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();
    RelationCacheValue.RelationCacheValueBuilder builderResult2 = RelationCacheValue.builder();
    RelationCacheValue.RelationCacheValueBuilder relationResult2 = builderResult2.relation(new EntityRelation());
    RelationCacheValue buildResult2 = relationResult2.relations(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}, and
   * {@link RelationCacheValue#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationCacheValue#equals(Object)}
   *   <li>{@link RelationCacheValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder.relation(Mockito.<EntityRelation>any())).thenReturn(RelationCacheValue.builder());
    RelationCacheValue.RelationCacheValueBuilder relationResult = relationCacheValueBuilder
        .relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder2 = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder2.relation(Mockito.<EntityRelation>any())).thenReturn(RelationCacheValue.builder());
    RelationCacheValue.RelationCacheValueBuilder relationResult2 = relationCacheValueBuilder2
        .relation(new EntityRelation());
    RelationCacheValue buildResult2 = relationResult2.relations(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}, and
   * {@link RelationCacheValue#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationCacheValue#equals(Object)}
   *   <li>{@link RelationCacheValue#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationCacheValue.RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValue.RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder.relation(Mockito.<EntityRelation>any())).thenReturn(RelationCacheValue.builder());
    RelationCacheValue.RelationCacheValueBuilder relationResult = relationCacheValueBuilder
        .relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();
    RelationCacheValue.RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValue.RelationCacheValueBuilder relationResult2 = builderResult.relation(new EntityRelation());
    RelationCacheValue buildResult2 = relationResult2.relations(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder.relations(Mockito.<List<EntityRelation>>any()))
        .thenReturn(RelationCacheValue.builder());
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder2 = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder2.relation(Mockito.<EntityRelation>any())).thenReturn(relationCacheValueBuilder);
    RelationCacheValue.RelationCacheValueBuilder relationResult = relationCacheValueBuilder2
        .relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder3 = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder3.relation(Mockito.<EntityRelation>any())).thenReturn(RelationCacheValue.builder());
    RelationCacheValue.RelationCacheValueBuilder relationResult2 = relationCacheValueBuilder3
        .relation(new EntityRelation());
    RelationCacheValue buildResult2 = relationResult2.relations(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    RelationCacheValue.RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValue.RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();
    when(relationCacheValueBuilder.build()).thenReturn(buildResult);
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder2 = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder2.relations(Mockito.<List<EntityRelation>>any()))
        .thenReturn(relationCacheValueBuilder);
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder3 = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder3.relation(Mockito.<EntityRelation>any())).thenReturn(relationCacheValueBuilder2);
    RelationCacheValue.RelationCacheValueBuilder relationResult2 = relationCacheValueBuilder3
        .relation(new EntityRelation());
    RelationCacheValue buildResult2 = relationResult2.relations(new ArrayList<>()).build();
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder4 = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder4.relation(Mockito.<EntityRelation>any())).thenReturn(RelationCacheValue.builder());
    RelationCacheValue.RelationCacheValueBuilder relationResult3 = relationCacheValueBuilder4
        .relation(new EntityRelation());
    RelationCacheValue buildResult3 = relationResult3.relations(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation());
    RelationCacheValue buildResult = RelationCacheValue.builder().relation(null).relations(relations).build();
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder.build()).thenReturn(buildResult);
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder2 = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder2.relations(Mockito.<List<EntityRelation>>any()))
        .thenReturn(relationCacheValueBuilder);
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder3 = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder3.relation(Mockito.<EntityRelation>any())).thenReturn(relationCacheValueBuilder2);
    RelationCacheValue.RelationCacheValueBuilder relationResult = relationCacheValueBuilder3
        .relation(new EntityRelation());
    RelationCacheValue buildResult2 = relationResult.relations(new ArrayList<>()).build();
    RelationCacheValue.RelationCacheValueBuilder relationCacheValueBuilder4 = mock(
        RelationCacheValue.RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder4.relation(Mockito.<EntityRelation>any())).thenReturn(RelationCacheValue.builder());
    RelationCacheValue.RelationCacheValueBuilder relationResult2 = relationCacheValueBuilder4
        .relation(new EntityRelation());
    RelationCacheValue buildResult3 = relationResult2.relations(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RelationCacheValue.RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValue.RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheValue#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RelationCacheValue.RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValue.RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RelationCacheValue");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationCacheValue#RelationCacheValue(EntityRelation, List)}
   *   <li>{@link RelationCacheValue#getRelation()}
   *   <li>{@link RelationCacheValue#getRelations()}
   * </ul>
   */
  @Test
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
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationCacheValue.RelationCacheValueBuilder#build()}
   *   <li>
   * {@link RelationCacheValue.RelationCacheValueBuilder#relation(EntityRelation)}
   *   <li>{@link RelationCacheValue.RelationCacheValueBuilder#relations(List)}
   * </ul>
   */
  @Test
  public void testRelationCacheValueBuilderBuild() {
    // Arrange
    RelationCacheValue.RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    EntityRelation relation = new EntityRelation();
    RelationCacheValue.RelationCacheValueBuilder relationResult = builderResult.relation(relation);
    ArrayList<EntityRelation> relations = new ArrayList<>();

    // Act
    RelationCacheValue actualBuildResult = relationResult.relations(relations).build();

    // Assert
    List<EntityRelation> relations2 = actualBuildResult.getRelations();
    assertTrue(relations2.isEmpty());
    assertSame(relations, relations2);
    assertSame(relation, actualBuildResult.getRelation());
  }
}
