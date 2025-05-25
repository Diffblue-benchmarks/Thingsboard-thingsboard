package org.thingsboard.server.dao.relation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.dao.relation.RelationCacheValue.RelationCacheValueBuilder;

@ContextConfiguration(classes = {RelationCacheValueBuilder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class RelationCacheValueDiffblueTest {
  @Autowired
  private RelationCacheValueBuilder relationCacheValueBuilder;

  /**
   * Test {@link RelationCacheValue#equals(Object)}, and {@link RelationCacheValue#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationCacheValue.equals(Object)", "int RelationCacheValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();
    RelationCacheValueBuilder builderResult2 = RelationCacheValue.builder();
    RelationCacheValueBuilder relationResult2 = builderResult2.relation(new EntityRelation());
    RelationCacheValue buildResult2 = relationResult2.relations(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}, and {@link RelationCacheValue#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationCacheValue.equals(Object)", "int RelationCacheValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationCacheValueBuilder relationCacheValueBuilder = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder.relation(Mockito.<EntityRelation>any())).thenReturn(RelationCacheValue.builder());
    RelationCacheValueBuilder relationResult = relationCacheValueBuilder.relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();
    RelationCacheValueBuilder relationCacheValueBuilder2 = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder2.relation(Mockito.<EntityRelation>any())).thenReturn(RelationCacheValue.builder());
    RelationCacheValueBuilder relationResult2 = relationCacheValueBuilder2.relation(new EntityRelation());
    RelationCacheValue buildResult2 = relationResult2.relations(new ArrayList<>()).build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RelationCacheValue#equals(Object)}, and {@link RelationCacheValue#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationCacheValue.equals(Object)", "int RelationCacheValue.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationCacheValue.equals(Object)", "int RelationCacheValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationCacheValueBuilder relationCacheValueBuilder = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder.relation(Mockito.<EntityRelation>any())).thenReturn(RelationCacheValue.builder());
    RelationCacheValueBuilder relationResult = relationCacheValueBuilder.relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();
    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValueBuilder relationResult2 = builderResult.relation(new EntityRelation());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationCacheValue.equals(Object)", "int RelationCacheValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationCacheValueBuilder relationCacheValueBuilder = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder.relations(Mockito.<List<EntityRelation>>any()))
        .thenReturn(RelationCacheValue.builder());
    RelationCacheValueBuilder relationCacheValueBuilder2 = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder2.relation(Mockito.<EntityRelation>any())).thenReturn(relationCacheValueBuilder);
    RelationCacheValueBuilder relationResult = relationCacheValueBuilder2.relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();
    RelationCacheValueBuilder relationCacheValueBuilder3 = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder3.relation(Mockito.<EntityRelation>any())).thenReturn(RelationCacheValue.builder());
    RelationCacheValueBuilder relationResult2 = relationCacheValueBuilder3.relation(new EntityRelation());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationCacheValue.equals(Object)", "int RelationCacheValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationCacheValueBuilder relationCacheValueBuilder = mock(RelationCacheValueBuilder.class);
    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
    RelationCacheValue buildResult = relationResult.relations(new ArrayList<>()).build();
    when(relationCacheValueBuilder.build()).thenReturn(buildResult);
    RelationCacheValueBuilder relationCacheValueBuilder2 = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder2.relations(Mockito.<List<EntityRelation>>any()))
        .thenReturn(relationCacheValueBuilder);
    RelationCacheValueBuilder relationCacheValueBuilder3 = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder3.relation(Mockito.<EntityRelation>any())).thenReturn(relationCacheValueBuilder2);
    RelationCacheValueBuilder relationResult2 = relationCacheValueBuilder3.relation(new EntityRelation());
    RelationCacheValue buildResult2 = relationResult2.relations(new ArrayList<>()).build();
    RelationCacheValueBuilder relationCacheValueBuilder4 = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder4.relation(Mockito.<EntityRelation>any())).thenReturn(RelationCacheValue.builder());
    RelationCacheValueBuilder relationResult3 = relationCacheValueBuilder4.relation(new EntityRelation());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationCacheValue.equals(Object)", "int RelationCacheValue.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ArrayList<EntityRelation> relations = new ArrayList<>();
    relations.add(new EntityRelation());
    RelationCacheValue buildResult = RelationCacheValue.builder().relation(null).relations(relations).build();
    RelationCacheValueBuilder relationCacheValueBuilder = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder.build()).thenReturn(buildResult);
    RelationCacheValueBuilder relationCacheValueBuilder2 = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder2.relations(Mockito.<List<EntityRelation>>any()))
        .thenReturn(relationCacheValueBuilder);
    RelationCacheValueBuilder relationCacheValueBuilder3 = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder3.relation(Mockito.<EntityRelation>any())).thenReturn(relationCacheValueBuilder2);
    RelationCacheValueBuilder relationResult = relationCacheValueBuilder3.relation(new EntityRelation());
    RelationCacheValue buildResult2 = relationResult.relations(new ArrayList<>()).build();
    RelationCacheValueBuilder relationCacheValueBuilder4 = mock(RelationCacheValueBuilder.class);
    when(relationCacheValueBuilder4.relation(Mockito.<EntityRelation>any())).thenReturn(RelationCacheValue.builder());
    RelationCacheValueBuilder relationResult2 = relationCacheValueBuilder4.relation(new EntityRelation());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationCacheValue.equals(Object)", "int RelationCacheValue.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean RelationCacheValue.equals(Object)", "int RelationCacheValue.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    RelationCacheValueBuilder relationResult = builderResult.relation(new EntityRelation());
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RelationCacheValue.<init>(EntityRelation, List)",
      "EntityRelation RelationCacheValue.getRelation()", "List RelationCacheValue.getRelations()"})
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
   *   <li>{@link RelationCacheValueBuilder#build()}
   *   <li>{@link RelationCacheValueBuilder#relation(EntityRelation)}
   *   <li>{@link RelationCacheValueBuilder#relations(List)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void RelationCacheValueBuilder.<init>()", "RelationCacheValue RelationCacheValueBuilder.build()",
      "RelationCacheValueBuilder RelationCacheValueBuilder.relation(EntityRelation)",
      "RelationCacheValueBuilder RelationCacheValueBuilder.relations(List)",
      "java.lang.String RelationCacheValueBuilder.toString()"})
  public void testRelationCacheValueBuilderBuild() {
    // Arrange
    RelationCacheValueBuilder builderResult = RelationCacheValue.builder();
    EntityRelation relation = new EntityRelation();
    RelationCacheValueBuilder relationResult = builderResult.relation(relation);
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
