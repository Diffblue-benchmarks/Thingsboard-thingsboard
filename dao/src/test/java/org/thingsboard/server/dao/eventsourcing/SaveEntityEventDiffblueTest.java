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
import org.thingsboard.server.dao.eventsourcing.SaveEntityEvent.SaveEntityEventBuilder;
import org.thingsboard.server.dao.model.ModelConstants;

public class SaveEntityEventDiffblueTest {
  /**
   * Test {@link SaveEntityEvent#equals(Object)}, and
   * {@link SaveEntityEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult = builderResult.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult2 = builderResult2.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}, and
   * {@link SaveEntityEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.created(Mockito.<Boolean>any())).thenReturn(builderResult);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder2.created(Mockito.<Boolean>any())).thenReturn(builderResult2);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder2.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}, and
   * {@link SaveEntityEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.entity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder2.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder4.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}, and
   * {@link SaveEntityEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder4.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entityId(Mockito.<EntityId>any())).thenReturn(builderResult2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder7 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder7.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder6);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder7.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity(null)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}, and
   * {@link SaveEntityEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult = builderResult.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.created(Mockito.<Boolean>any())).thenReturn(builderResult);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult2 = builderResult2.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.entity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder2.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder3.created(Mockito.<Boolean>any())).thenReturn(builderResult2);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder3.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.entity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder2.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(null)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder3.created(Mockito.<Boolean>any())).thenReturn(builderResult2);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder3.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.entityId(Mockito.<EntityId>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder3.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder4.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder5.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder4);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder5.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder4.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder6.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder4.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder6.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity(null)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder4.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder6.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(null)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    builderResult.entity("Entity");
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder4.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder6.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    builderResult.created(true);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder4.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder6.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    builderResult.oldEntity("Old Entity");
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder4.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entityId(Mockito.<EntityId>any())).thenReturn(builderResult2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder7 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder7.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder6);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder7.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity(null)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    builderResult.entityId(BaseEntityService.NULL_CUSTOMER_ID);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult = saveEntityEventBuilder4.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entityId(Mockito.<EntityId>any())).thenReturn(builderResult2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder7 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder7.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder6);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder7.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity(null)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult = builderResult2.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    builderResult.oldEntity(buildResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult2 = saveEntityEventBuilder4.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult3 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entityId(Mockito.<EntityId>any())).thenReturn(builderResult3);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent.SaveEntityEventBuilder<Object> saveEntityEventBuilder7 = mock(
        SaveEntityEvent.SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder7.created(Mockito.<Boolean>any())).thenReturn(saveEntityEventBuilder6);
    SaveEntityEvent<Object> buildResult3 = saveEntityEventBuilder7.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity(null)
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult2, buildResult3);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult = builderResult.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link SaveEntityEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult = builderResult.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to SaveEntityEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link SaveEntityEvent#SaveEntityEvent(TenantId, Object, Object, EntityId, Boolean)}
   *   <li>{@link SaveEntityEvent#toString()}
   *   <li>{@link SaveEntityEvent#getCreated()}
   *   <li>{@link SaveEntityEvent#getEntity()}
   *   <li>{@link SaveEntityEvent#getEntityId()}
   *   <li>{@link SaveEntityEvent#getOldEntity()}
   *   <li>{@link SaveEntityEvent#getTenantId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    SaveEntityEvent<Object> actualSaveEntityEvent = new SaveEntityEvent<>(ModelConstants.SYSTEM_TENANT, "Entity",
        "Old Entity", entityId, true);
    String actualToStringResult = actualSaveEntityEvent.toString();
    Boolean actualCreated = actualSaveEntityEvent.getCreated();
    Object actualEntity = actualSaveEntityEvent.getEntity();
    EntityId actualEntityId = actualSaveEntityEvent.getEntityId();
    Object actualOldEntity = actualSaveEntityEvent.getOldEntity();
    TenantId actualTenantId = actualSaveEntityEvent.getTenantId();

    // Assert
    assertEquals("Entity", actualEntity);
    assertEquals("Old Entity", actualOldEntity);
    assertEquals("SaveEntityEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, entity=Entity, oldEntity=Old Entity,"
        + " entityId=13814000-1dd2-11b2-8080-808080808080, created=true)", actualToStringResult);
    assertTrue(actualCreated);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(entityId, actualEntityId);
  }

  /**
   * Test SaveEntityEventBuilder {@link SaveEntityEventBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link SaveEntityEvent.SaveEntityEventBuilder#build()}
   *   <li>{@link SaveEntityEvent.SaveEntityEventBuilder#created(Boolean)}
   *   <li>{@link SaveEntityEvent.SaveEntityEventBuilder#entity(Object)}
   *   <li>{@link SaveEntityEvent.SaveEntityEventBuilder#entityId(EntityId)}
   *   <li>{@link SaveEntityEvent.SaveEntityEventBuilder#oldEntity(Object)}
   *   <li>{@link SaveEntityEvent.SaveEntityEventBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  public void testSaveEntityEventBuilderBuild() {
    // Arrange
    SaveEntityEvent.SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();

    // Act
    SaveEntityEvent<Object> actualBuildResult = builderResult.created(true)
        .entity("Entity")
        .entityId(BaseEntityService.NULL_CUSTOMER_ID)
        .oldEntity("Old Entity")
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    // Assert
    assertTrue(actualBuildResult.getEntityId() instanceof CustomerId);
    TenantId tenantId = actualBuildResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("Entity", actualBuildResult.getEntity());
    assertEquals("Old Entity", actualBuildResult.getOldEntity());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
    assertTrue(actualBuildResult.getCreated());
  }
}
