package org.thingsboard.server.dao.eventsourcing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.SaveEntityEvent.SaveEntityEventBuilder;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {SaveEntityEventBuilder.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class SaveEntityEventDiffblueTest {
  @Autowired private SaveEntityEventBuilder<Object> saveEntityEventBuilder;

  /**
   * Test {@link SaveEntityEvent#equals(Object)}, and {@link SaveEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult =
        builderResult
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult2 =
        builderResult2
            .created(true)
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
   * Test {@link SaveEntityEvent#equals(Object)}, and {@link SaveEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.created(Mockito.<Boolean>any())).thenReturn(builderResult);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder2.created(Mockito.<Boolean>any())).thenReturn(builderResult2);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder2
            .created(true)
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
   * Test {@link SaveEntityEvent#equals(Object)}, and {@link SaveEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.entity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder4
            .created(true)
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
   * Test {@link SaveEntityEvent#equals(Object)}, and {@link SaveEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any()))
        .thenReturn(saveEntityEventBuilder);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder4
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entityId(Mockito.<EntityId>any())).thenReturn(builderResult2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder7 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder7.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder6);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder7
            .created(true)
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
   * Test {@link SaveEntityEvent#equals(Object)}, and {@link SaveEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#equals(Object)}
   *   <li>{@link SaveEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult =
        builderResult
            .created(true)
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.created(Mockito.<Boolean>any())).thenReturn(builderResult);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult2 =
        builderResult2
            .created(true)
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.entity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder3.created(Mockito.<Boolean>any())).thenReturn(builderResult2);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder3
            .created(true)
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.entity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder);
    SaveEntityEventBuilder<Object> oldEntityResult =
        saveEntityEventBuilder2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity");
    SaveEntityEvent<Object> buildResult =
        oldEntityResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder3.created(Mockito.<Boolean>any())).thenReturn(builderResult2);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder3
            .created(true)
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.entity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(null)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder3.created(Mockito.<Boolean>any())).thenReturn(builderResult2);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder3
            .created(true)
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.entityId(Mockito.<EntityId>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder2);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder3
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder4.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder5.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder4);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder5
            .created(true)
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any()))
        .thenReturn(saveEntityEventBuilder);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder4
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder6
            .created(true)
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any()))
        .thenReturn(saveEntityEventBuilder);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder4
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder6
            .created(true)
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    builderResult.entity("Entity");
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any()))
        .thenReturn(saveEntityEventBuilder);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder4
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder6
            .created(true)
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    builderResult.created(true);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any()))
        .thenReturn(saveEntityEventBuilder);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder4
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entity(Mockito.<Object>any())).thenReturn(builderResult2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder5);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder6
            .created(true)
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    builderResult.oldEntity("Old Entity");
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any()))
        .thenReturn(saveEntityEventBuilder);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder4
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entityId(Mockito.<EntityId>any())).thenReturn(builderResult2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder7 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder7.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder6);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder7
            .created(true)
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    builderResult.entityId(BaseEntityService.NULL_CUSTOMER_ID);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any()))
        .thenReturn(saveEntityEventBuilder);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult =
        saveEntityEventBuilder4
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entityId(Mockito.<EntityId>any())).thenReturn(builderResult2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder7 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder7.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder6);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder7
            .created(true)
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEventBuilder<Object> builderResult2 = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult =
        builderResult2
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    builderResult.oldEntity(buildResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder.oldEntity(Mockito.<Object>any())).thenReturn(builderResult);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder2 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder2.entityId(Mockito.<EntityId>any()))
        .thenReturn(saveEntityEventBuilder);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder3 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder3.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder2);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder4 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder4.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder3);
    SaveEntityEvent<Object> buildResult2 =
        saveEntityEventBuilder4
            .created(true)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .oldEntity("Old Entity")
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    SaveEntityEventBuilder<Object> saveEntityEventBuilder5 = mock(SaveEntityEventBuilder.class);
    SaveEntityEventBuilder<Object> builderResult3 = SaveEntityEvent.builder();
    when(saveEntityEventBuilder5.entityId(Mockito.<EntityId>any())).thenReturn(builderResult3);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder6 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder6.entity(Mockito.<Object>any())).thenReturn(saveEntityEventBuilder5);
    SaveEntityEventBuilder<Object> saveEntityEventBuilder7 = mock(SaveEntityEventBuilder.class);
    when(saveEntityEventBuilder7.created(Mockito.<Boolean>any()))
        .thenReturn(saveEntityEventBuilder6);
    SaveEntityEvent<Object> buildResult3 =
        saveEntityEventBuilder7
            .created(true)
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult =
        builderResult
            .created(true)
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SaveEntityEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean SaveEntityEvent.equals(Object)", "int SaveEntityEvent.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();
    SaveEntityEvent<Object> buildResult =
        builderResult
            .created(true)
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEvent#SaveEntityEvent(TenantId, Object, Object, EntityId, Boolean)}
   *   <li>{@link SaveEntityEvent#toString()}
   *   <li>{@link SaveEntityEvent#getCreated()}
   *   <li>{@link SaveEntityEvent#getEntity()}
   *   <li>{@link SaveEntityEvent#getEntityId()}
   *   <li>{@link SaveEntityEvent#getOldEntity()}
   *   <li>{@link SaveEntityEvent#getTenantId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SaveEntityEvent.<init>(TenantId, Object, Object, EntityId, Boolean)",
    "Boolean SaveEntityEvent.getCreated()",
    "Object SaveEntityEvent.getEntity()",
    "EntityId SaveEntityEvent.getEntityId()",
    "Object SaveEntityEvent.getOldEntity()",
    "TenantId SaveEntityEvent.getTenantId()",
    "String SaveEntityEvent.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    SaveEntityEvent<Object> actualSaveEntityEvent =
        new SaveEntityEvent<>(ModelConstants.SYSTEM_TENANT, "Entity", "Old Entity", entityId, true);
    String actualToStringResult = actualSaveEntityEvent.toString();
    Boolean actualCreated = actualSaveEntityEvent.getCreated();
    Object actualEntity = actualSaveEntityEvent.getEntity();
    EntityId actualEntityId = actualSaveEntityEvent.getEntityId();
    Object actualOldEntity = actualSaveEntityEvent.getOldEntity();
    TenantId actualTenantId = actualSaveEntityEvent.getTenantId();

    // Assert
    assertEquals("Entity", actualEntity);
    assertEquals("Old Entity", actualOldEntity);
    assertEquals(
        "SaveEntityEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, entity=Entity, oldEntity=Old Entity,"
            + " entityId=13814000-1dd2-11b2-8080-808080808080, created=true)",
        actualToStringResult);
    assertTrue(actualCreated);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
    assertSame(entityId, actualEntityId);
  }

  /**
   * Test SaveEntityEventBuilder {@link SaveEntityEventBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SaveEntityEventBuilder#build()}
   *   <li>{@link SaveEntityEventBuilder#created(Boolean)}
   *   <li>{@link SaveEntityEventBuilder#entity(Object)}
   *   <li>{@link SaveEntityEventBuilder#entityId(EntityId)}
   *   <li>{@link SaveEntityEventBuilder#oldEntity(Object)}
   *   <li>{@link SaveEntityEventBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void SaveEntityEventBuilder.<init>()",
    "SaveEntityEvent SaveEntityEventBuilder.build()",
    "SaveEntityEventBuilder SaveEntityEventBuilder.created(Boolean)",
    "SaveEntityEventBuilder SaveEntityEventBuilder.entity(Object)",
    "SaveEntityEventBuilder SaveEntityEventBuilder.entityId(EntityId)",
    "SaveEntityEventBuilder SaveEntityEventBuilder.oldEntity(Object)",
    "SaveEntityEventBuilder SaveEntityEventBuilder.tenantId(TenantId)",
    "String SaveEntityEventBuilder.toString()"
  })
  public void testSaveEntityEventBuilderBuild() {
    // Arrange
    SaveEntityEventBuilder<Object> builderResult = SaveEntityEvent.builder();

    // Act
    SaveEntityEvent<Object> actualBuildResult =
        builderResult
            .created(true)
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
