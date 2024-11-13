package org.thingsboard.server.dao.eventsourcing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent.DeleteEntityEventBuilder;
import org.thingsboard.server.dao.model.ModelConstants;

public class DeleteEntityEventDiffblueTest {
  /**
   * Test DeleteEntityEventBuilder {@link DeleteEntityEventBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeleteEntityEvent.DeleteEntityEventBuilder#build()}
   *   <li>{@link DeleteEntityEvent.DeleteEntityEventBuilder#body(String)}
   *   <li>{@link DeleteEntityEvent.DeleteEntityEventBuilder#cause(ActionCause)}
   *   <li>{@link DeleteEntityEvent.DeleteEntityEventBuilder#entity(Object)}
   *   <li>{@link DeleteEntityEvent.DeleteEntityEventBuilder#entityId(EntityId)}
   *   <li>{@link DeleteEntityEvent.DeleteEntityEventBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  public void testDeleteEntityEventBuilderBuild() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();

    // Act
    DeleteEntityEvent<Object> actualBuildResult = builderResult.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Assert
    assertTrue(actualBuildResult.getEntityId() instanceof CustomerId);
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Entity", actualBuildResult.getEntity());
    assertEquals("Not all who wander are lost", actualBuildResult.getBody());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertEquals(ActionCause.TENANT_DELETION, actualBuildResult.getCause());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test DeleteEntityEventBuilder {@link DeleteEntityEventBuilder#ts(long)}.
   * <p>
   * Method under test:
   * {@link DeleteEntityEvent.DeleteEntityEventBuilder#ts(long)}
   */
  @Test
  public void testDeleteEntityEventBuilderTs() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();

    // Act
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> actualTsResult = builderResult.ts(1L);

    // Assert
    assertEquals(1L, builderResult.build().getTs());
    assertSame(builderResult, actualTsResult);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}, and
   * {@link DeleteEntityEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeleteEntityEvent#equals(Object)}
   *   <li>{@link DeleteEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult = builderResult.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 = builderResult2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}, and
   * {@link DeleteEntityEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeleteEntityEvent#equals(Object)}
   *   <li>{@link DeleteEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder2 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder2.body(Mockito.<String>any())).thenReturn(builderResult2);
    DeleteEntityEvent<Object> buildResult2 = deleteEntityEventBuilder2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}, and
   * {@link DeleteEntityEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeleteEntityEvent#equals(Object)}
   *   <li>{@link DeleteEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.cause(Mockito.<ActionCause>any())).thenReturn(builderResult);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder2 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder2.body(Mockito.<String>any())).thenReturn(deleteEntityEventBuilder);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(null)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder3 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder3.cause(Mockito.<ActionCause>any())).thenReturn(builderResult2);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder4 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder4.body(Mockito.<String>any())).thenReturn(deleteEntityEventBuilder3);
    DeleteEntityEvent<Object> buildResult2 = deleteEntityEventBuilder4.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(null)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}, and
   * {@link DeleteEntityEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DeleteEntityEvent#equals(Object)}
   *   <li>{@link DeleteEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult = builderResult.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 = builderResult2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity(1)
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 = builderResult2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> causeResult = deleteEntityEventBuilder
        .body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult = builderResult2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent<Object> buildResult2 = causeResult.entity(buildResult)
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult3 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult3 = builderResult3.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity(null)
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 = builderResult2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(ModelConstants.SYSTEM_TENANT)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 = builderResult2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(null)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 = builderResult2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(null)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 = builderResult2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.cause(Mockito.<ActionCause>any())).thenReturn(builderResult);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder2 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder2.body(Mockito.<String>any())).thenReturn(deleteEntityEventBuilder);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder3 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder3.body(Mockito.<String>any())).thenReturn(builderResult2);
    DeleteEntityEvent<Object> buildResult2 = deleteEntityEventBuilder3.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.cause(Mockito.<ActionCause>any())).thenReturn(builderResult);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder2 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder2.body(Mockito.<String>any())).thenReturn(deleteEntityEventBuilder);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder3 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder3.cause(Mockito.<ActionCause>any())).thenReturn(builderResult2);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder4 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder4.body(Mockito.<String>any())).thenReturn(deleteEntityEventBuilder3);
    DeleteEntityEvent<Object> buildResult2 = deleteEntityEventBuilder4.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity(-1)
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.cause(Mockito.<ActionCause>any())).thenReturn(builderResult);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder2 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder2.body(Mockito.<String>any())).thenReturn(deleteEntityEventBuilder);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder3 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder3.cause(Mockito.<ActionCause>any())).thenReturn(builderResult2);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder4 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder4.body(Mockito.<String>any())).thenReturn(deleteEntityEventBuilder3);
    DeleteEntityEvent<Object> buildResult2 = deleteEntityEventBuilder4.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    builderResult.body("Not all who wander are lost");
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder.cause(Mockito.<ActionCause>any())).thenReturn(builderResult);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder2 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder2.body(Mockito.<String>any())).thenReturn(deleteEntityEventBuilder);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder3 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder3.cause(Mockito.<ActionCause>any())).thenReturn(builderResult2);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder4 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder4.body(Mockito.<String>any())).thenReturn(deleteEntityEventBuilder3);
    DeleteEntityEvent<Object> buildResult2 = deleteEntityEventBuilder4.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    builderResult.cause(ActionCause.TENANT_DELETION);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder.cause(Mockito.<ActionCause>any())).thenReturn(builderResult);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder2 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder2.body(Mockito.<String>any())).thenReturn(deleteEntityEventBuilder);
    DeleteEntityEvent<Object> buildResult = deleteEntityEventBuilder2.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder3 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder3.cause(Mockito.<ActionCause>any())).thenReturn(builderResult2);
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> deleteEntityEventBuilder4 = mock(
        DeleteEntityEvent.DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder4.body(Mockito.<String>any())).thenReturn(deleteEntityEventBuilder3);
    DeleteEntityEvent<Object> buildResult2 = deleteEntityEventBuilder4.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult = builderResult.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeleteEntityEvent.DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult = builderResult.body("Not all who wander are lost")
        .cause(ActionCause.TENANT_DELETION)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to DeleteEntityEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link DeleteEntityEvent#DeleteEntityEvent(TenantId, EntityId, Object, String, ActionCause, long)}
   *   <li>{@link DeleteEntityEvent#toString()}
   *   <li>{@link DeleteEntityEvent#getBody()}
   *   <li>{@link DeleteEntityEvent#getCause()}
   *   <li>{@link DeleteEntityEvent#getEntity()}
   *   <li>{@link DeleteEntityEvent#getEntityId()}
   *   <li>{@link DeleteEntityEvent#getTenantId()}
   *   <li>{@link DeleteEntityEvent#getTs()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    DeleteEntityEvent<Object> actualDeleteEntityEvent = new DeleteEntityEvent<>(ModelConstants.SYSTEM_TENANT, entityId,
        "Entity", "Not all who wander are lost", ActionCause.TENANT_DELETION, 1L);
    String actualToStringResult = actualDeleteEntityEvent.toString();
    String actualBody = actualDeleteEntityEvent.getBody();
    ActionCause actualCause = actualDeleteEntityEvent.getCause();
    Object actualEntity = actualDeleteEntityEvent.getEntity();
    EntityId actualEntityId = actualDeleteEntityEvent.getEntityId();
    TenantId actualTenantId = actualDeleteEntityEvent.getTenantId();

    // Assert
    assertEquals(
        "DeleteEntityEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, entityId=13814000-1dd2-11b2-8080"
            + "-808080808080, entity=Entity, body=Not all who wander are lost, cause=TENANT_DELETION, ts=1)",
        actualToStringResult);
    assertEquals("Entity", actualEntity);
    assertEquals("Not all who wander are lost", actualBody);
    assertEquals(1L, actualDeleteEntityEvent.getTs());
    assertEquals(ActionCause.TENANT_DELETION, actualCause);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(entityId, actualEntityId);
  }
}
