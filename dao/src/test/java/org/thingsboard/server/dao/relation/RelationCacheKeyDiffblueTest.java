package org.thingsboard.server.dao.relation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.relation.EntitySearchDirection;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.relation.RelationCacheKey.RelationCacheKeyBuilder;

public class RelationCacheKeyDiffblueTest {
  /**
   * Test {@link RelationCacheKey#equals(Object)}, and
   * {@link RelationCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationCacheKey#equals(Object)}
   *   <li>{@link RelationCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RelationCacheKey buildResult = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}, and
   * {@link RelationCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationCacheKey#equals(Object)}
   *   <li>{@link RelationCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.typeGroup(Mockito.<RelationTypeGroup>any())).thenReturn(RelationCacheKey.builder());
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.type(Mockito.<String>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder3 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder3.to(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder2);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder4 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder4.from(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder3);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder5 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder5.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder4);
    RelationCacheKey buildResult = relationCacheKeyBuilder5.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder6 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder6.direction(Mockito.<EntitySearchDirection>any()))
        .thenReturn(RelationCacheKey.builder());
    RelationCacheKey buildResult2 = relationCacheKeyBuilder6.direction(EntitySearchDirection.FROM)
        .from(null)
        .to(null)
        .type(null)
        .typeGroup(null)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}, and
   * {@link RelationCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationCacheKey#equals(Object)}
   *   <li>{@link RelationCacheKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RelationCacheKey buildResult = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.direction(Mockito.<EntitySearchDirection>any()))
        .thenReturn(RelationCacheKey.builder());
    RelationCacheKey buildResult = relationCacheKeyBuilder.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.from(Mockito.<EntityId>any())).thenReturn(RelationCacheKey.builder());
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey buildResult = relationCacheKeyBuilder2.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.from(Mockito.<EntityId>any())).thenReturn(RelationCacheKey.builder());
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey buildResult = relationCacheKeyBuilder2.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(null)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.to(Mockito.<EntityId>any())).thenReturn(RelationCacheKey.builder());
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.from(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder3 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder3.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder2);
    RelationCacheKey buildResult = relationCacheKeyBuilder3.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(null)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.to(Mockito.<EntityId>any())).thenReturn(RelationCacheKey.builder());
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.from(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder3 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder3.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder2);
    RelationCacheKey buildResult = relationCacheKeyBuilder3.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(null)
        .to(null)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder builderResult = RelationCacheKey.builder();
    builderResult.from(BaseEntityService.NULL_CUSTOMER_ID);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.to(Mockito.<EntityId>any())).thenReturn(builderResult);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.from(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder3 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder3.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder2);
    RelationCacheKey buildResult = relationCacheKeyBuilder3.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(null)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.type(Mockito.<String>any())).thenReturn(RelationCacheKey.builder());
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.to(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder3 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder3.from(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder2);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder4 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder4.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder3);
    RelationCacheKey buildResult = relationCacheKeyBuilder4.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(null)
        .to(null)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.type(Mockito.<String>any())).thenReturn(RelationCacheKey.builder());
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.to(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder3 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder3.from(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder2);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder4 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder4.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder3);
    RelationCacheKey buildResult = relationCacheKeyBuilder4.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(null)
        .to(null)
        .type(null)
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder builderResult = RelationCacheKey.builder();
    builderResult.to(BaseEntityService.NULL_CUSTOMER_ID);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.type(Mockito.<String>any())).thenReturn(builderResult);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.to(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder3 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder3.from(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder2);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder4 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder4.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder3);
    RelationCacheKey buildResult = relationCacheKeyBuilder4.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(null)
        .to(null)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.typeGroup(Mockito.<RelationTypeGroup>any())).thenReturn(RelationCacheKey.builder());
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.type(Mockito.<String>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder3 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder3.to(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder2);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder4 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder4.from(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder3);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder5 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder5.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder4);
    RelationCacheKey buildResult = relationCacheKeyBuilder5.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(null)
        .to(null)
        .type(null)
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.typeGroup(Mockito.<RelationTypeGroup>any())).thenReturn(RelationCacheKey.builder());
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.type(Mockito.<String>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder3 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder3.to(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder2);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder4 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder4.from(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder3);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder5 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder5.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder4);
    RelationCacheKey buildResult = relationCacheKeyBuilder5.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(null)
        .to(null)
        .type(null)
        .typeGroup(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder builderResult = RelationCacheKey.builder();
    builderResult.type("Type");
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.typeGroup(Mockito.<RelationTypeGroup>any())).thenReturn(builderResult);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.type(Mockito.<String>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder3 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder3.to(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder2);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder4 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder4.from(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder3);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder5 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder5.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder4);
    RelationCacheKey buildResult = relationCacheKeyBuilder5.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey buildResult2 = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(null)
        .to(null)
        .type(null)
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder builderResult = RelationCacheKey.builder();
    builderResult.typeGroup(RelationTypeGroup.COMMON);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.typeGroup(Mockito.<RelationTypeGroup>any())).thenReturn(builderResult);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.type(Mockito.<String>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder3 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder3.to(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder2);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder4 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder4.from(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder3);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder5 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder5.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder4);
    RelationCacheKey buildResult = relationCacheKeyBuilder5.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder6 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder6.direction(Mockito.<EntitySearchDirection>any()))
        .thenReturn(RelationCacheKey.builder());
    RelationCacheKey buildResult2 = relationCacheKeyBuilder6.direction(EntitySearchDirection.FROM)
        .from(null)
        .to(null)
        .type(null)
        .typeGroup(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    RelationCacheKey.RelationCacheKeyBuilder builderResult = RelationCacheKey.builder();
    builderResult.direction(EntitySearchDirection.FROM);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder.typeGroup(Mockito.<RelationTypeGroup>any())).thenReturn(builderResult);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder2 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder2.type(Mockito.<String>any())).thenReturn(relationCacheKeyBuilder);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder3 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder3.to(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder2);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder4 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder4.from(Mockito.<EntityId>any())).thenReturn(relationCacheKeyBuilder3);
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder5 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder5.direction(Mockito.<EntitySearchDirection>any())).thenReturn(relationCacheKeyBuilder4);
    RelationCacheKey buildResult = relationCacheKeyBuilder5.direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();
    RelationCacheKey.RelationCacheKeyBuilder relationCacheKeyBuilder6 = mock(
        RelationCacheKey.RelationCacheKeyBuilder.class);
    when(relationCacheKeyBuilder6.direction(Mockito.<EntitySearchDirection>any()))
        .thenReturn(RelationCacheKey.builder());
    RelationCacheKey buildResult2 = relationCacheKeyBuilder6.direction(EntitySearchDirection.FROM)
        .from(null)
        .to(null)
        .type(null)
        .typeGroup(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RelationCacheKey buildResult = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link RelationCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link RelationCacheKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RelationCacheKey buildResult = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RelationCacheKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link RelationCacheKey#RelationCacheKey(EntityId, EntityId, String, RelationTypeGroup)}
   *   <li>{@link RelationCacheKey#toString()}
   *   <li>{@link RelationCacheKey#getDirection()}
   *   <li>{@link RelationCacheKey#getFrom()}
   *   <li>{@link RelationCacheKey#getTo()}
   *   <li>{@link RelationCacheKey#getType()}
   *   <li>{@link RelationCacheKey#getTypeGroup()}
   * </ul>
   */
  @Test
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
   *   <li>
   * {@link RelationCacheKey#RelationCacheKey(EntityId, EntityId, String, RelationTypeGroup, EntitySearchDirection)}
   *   <li>{@link RelationCacheKey#toString()}
   *   <li>{@link RelationCacheKey#getDirection()}
   *   <li>{@link RelationCacheKey#getFrom()}
   *   <li>{@link RelationCacheKey#getTo()}
   *   <li>{@link RelationCacheKey#getType()}
   *   <li>{@link RelationCacheKey#getTypeGroup()}
   * </ul>
   */
  @Test
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

  /**
   * Test RelationCacheKeyBuilder {@link RelationCacheKeyBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link RelationCacheKey.RelationCacheKeyBuilder#build()}
   *   <li>
   * {@link RelationCacheKey.RelationCacheKeyBuilder#direction(EntitySearchDirection)}
   *   <li>{@link RelationCacheKey.RelationCacheKeyBuilder#from(EntityId)}
   *   <li>{@link RelationCacheKey.RelationCacheKeyBuilder#to(EntityId)}
   *   <li>{@link RelationCacheKey.RelationCacheKeyBuilder#type(String)}
   *   <li>
   * {@link RelationCacheKey.RelationCacheKeyBuilder#typeGroup(RelationTypeGroup)}
   * </ul>
   */
  @Test
  public void testRelationCacheKeyBuilderBuild() {
    // Arrange and Act
    RelationCacheKey actualBuildResult = RelationCacheKey.builder()
        .direction(EntitySearchDirection.FROM)
        .from(BaseEntityService.NULL_CUSTOMER_ID)
        .to(BaseEntityService.NULL_CUSTOMER_ID)
        .type("Type")
        .typeGroup(RelationTypeGroup.COMMON)
        .build();

    // Assert
    EntityId from = actualBuildResult.getFrom();
    assertTrue(from instanceof CustomerId);
    assertEquals("Type", actualBuildResult.getType());
    assertEquals(EntitySearchDirection.FROM, actualBuildResult.getDirection());
    assertEquals(RelationTypeGroup.COMMON, actualBuildResult.getTypeGroup());
    assertSame(from, actualBuildResult.getTo());
  }
}
