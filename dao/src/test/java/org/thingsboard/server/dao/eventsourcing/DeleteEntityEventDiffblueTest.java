package org.thingsboard.server.dao.eventsourcing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.eventsourcing.DeleteEntityEvent.DeleteEntityEventBuilder;
import org.thingsboard.server.dao.model.ModelConstants;

@ContextConfiguration(classes = {DeleteEntityEventBuilder.class})
@ExtendWith(SpringExtension.class)
class DeleteEntityEventDiffblueTest {
  @Autowired private DeleteEntityEventBuilder<Object> deleteEntityEventBuilder;

  /**
   * Test DeleteEntityEventBuilder {@link DeleteEntityEventBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeleteEntityEventBuilder#build()}
   *   <li>{@link DeleteEntityEventBuilder#body(String)}
   *   <li>{@link DeleteEntityEventBuilder#cause(ActionCause)}
   *   <li>{@link DeleteEntityEventBuilder#entity(Object)}
   *   <li>{@link DeleteEntityEventBuilder#entityId(EntityId)}
   *   <li>{@link DeleteEntityEventBuilder#tenantId(TenantId)}
   * </ul>
   */
  @Test
  @DisplayName("Test DeleteEntityEventBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeleteEntityEventBuilder.<init>()",
    "DeleteEntityEventBuilder DeleteEntityEventBuilder.body(String)",
    "DeleteEntityEvent DeleteEntityEventBuilder.build()",
    "DeleteEntityEventBuilder DeleteEntityEventBuilder.cause(ActionCause)",
    "DeleteEntityEventBuilder DeleteEntityEventBuilder.entity(Object)",
    "DeleteEntityEventBuilder DeleteEntityEventBuilder.entityId(EntityId)",
    "DeleteEntityEventBuilder DeleteEntityEventBuilder.tenantId(TenantId)",
    "String DeleteEntityEventBuilder.toString()"
  })
  void testDeleteEntityEventBuilderBuild() {
    // Arrange
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();

    // Act
    DeleteEntityEvent<Object> actualBuildResult =
        builderResult
            .body("Not all who wander are lost")
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
   *
   * <p>Method under test: {@link DeleteEntityEventBuilder#ts(long)}
   */
  @Test
  @DisplayName("Test DeleteEntityEventBuilder ts(long)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"DeleteEntityEventBuilder DeleteEntityEventBuilder.ts(long)"})
  void testDeleteEntityEventBuilderTs() {
    // Arrange
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();

    // Act
    DeleteEntityEventBuilder<Object> actualTsResult = builderResult.ts(1L);

    // Assert
    assertEquals(1L, builderResult.build().getTs());
    assertSame(builderResult, actualTsResult);
  }

  /**
   * Test {@link DeleteEntityEvent#equals(Object)}, and {@link DeleteEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeleteEntityEvent#equals(Object)}
   *   <li>{@link DeleteEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult =
        builderResult
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 =
        builderResult2
            .body("Not all who wander are lost")
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
   * Test {@link DeleteEntityEvent#equals(Object)}, and {@link DeleteEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeleteEntityEvent#equals(Object)}
   *   <li>{@link DeleteEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder = new DeleteEntityEventBuilder<>();
    DeleteEntityEvent<Object> buildResult =
        deleteEntityEventBuilder
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 =
        builderResult
            .body("Not all who wander are lost")
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
   * Test {@link DeleteEntityEvent#equals(Object)}, and {@link DeleteEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeleteEntityEvent#equals(Object)}
   *   <li>{@link DeleteEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult =
        deleteEntityEventBuilder
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder2 =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder2.body(Mockito.<String>any())).thenReturn(builderResult2);
    DeleteEntityEvent<Object> buildResult2 =
        deleteEntityEventBuilder2
            .body("Not all who wander are lost")
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
   * Test {@link DeleteEntityEvent#equals(Object)}, and {@link DeleteEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeleteEntityEvent#equals(Object)}
   *   <li>{@link DeleteEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.cause(Mockito.<ActionCause>any())).thenReturn(builderResult);
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder2 =
        mock(DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder2.body(Mockito.<String>any()))
        .thenReturn(deleteEntityEventBuilder);
    DeleteEntityEvent<Object> buildResult =
        deleteEntityEventBuilder2
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder3 =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder3.cause(Mockito.<ActionCause>any())).thenReturn(builderResult2);
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder4 =
        mock(DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder4.body(Mockito.<String>any()))
        .thenReturn(deleteEntityEventBuilder3);
    DeleteEntityEvent<Object> buildResult2 =
        deleteEntityEventBuilder4
            .body("Not all who wander are lost")
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
   * Test {@link DeleteEntityEvent#equals(Object)}, and {@link DeleteEntityEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeleteEntityEvent#equals(Object)}
   *   <li>{@link DeleteEntityEvent#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult =
        builderResult
            .body("Not all who wander are lost")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult =
        deleteEntityEventBuilder
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 =
        builderResult2
            .body("Not all who wander are lost")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult =
        deleteEntityEventBuilder
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity(1)
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 =
        builderResult2
            .body("Not all who wander are lost")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEventBuilder<Object> causeResult =
        deleteEntityEventBuilder
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION);
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult =
        builderResult2
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEvent<Object> buildResult2 =
        causeResult
            .entity(buildResult)
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEventBuilder<Object> builderResult3 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult3 =
        builderResult3
            .body("Not all who wander are lost")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult =
        deleteEntityEventBuilder
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity(null)
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 =
        builderResult2
            .body("Not all who wander are lost")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult =
        deleteEntityEventBuilder
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity("Entity")
            .entityId(ModelConstants.SYSTEM_TENANT)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 =
        builderResult2
            .body("Not all who wander are lost")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult =
        deleteEntityEventBuilder
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity("Entity")
            .entityId(null)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 =
        builderResult2
            .body("Not all who wander are lost")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEventBuilder<Object> entityIdResult =
        deleteEntityEventBuilder
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID);
    DeleteEntityEvent<Object> buildResult =
        entityIdResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .build();
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 =
        builderResult2
            .body("Not all who wander are lost")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.body(Mockito.<String>any())).thenReturn(builderResult);
    DeleteEntityEvent<Object> buildResult =
        deleteEntityEventBuilder
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(null)
            .build();
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult2 =
        builderResult2
            .body("Not all who wander are lost")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder.cause(Mockito.<ActionCause>any())).thenReturn(builderResult);
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder2 =
        mock(DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder2.body(Mockito.<String>any()))
        .thenReturn(deleteEntityEventBuilder);
    DeleteEntityEvent<Object> buildResult =
        deleteEntityEventBuilder2
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder3 =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder3.body(Mockito.<String>any())).thenReturn(builderResult2);
    DeleteEntityEvent<Object> buildResult2 =
        deleteEntityEventBuilder3
            .body("Not all who wander are lost")
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    builderResult.body("Not all who wander are lost");
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder =
        mock(DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder.cause(Mockito.<ActionCause>any())).thenReturn(builderResult);
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder2 =
        mock(DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder2.body(Mockito.<String>any()))
        .thenReturn(deleteEntityEventBuilder);
    DeleteEntityEvent<Object> buildResult =
        deleteEntityEventBuilder2
            .body("Not all who wander are lost")
            .cause(ActionCause.TENANT_DELETION)
            .entity("Entity")
            .entityId(BaseEntityService.NULL_CUSTOMER_ID)
            .tenantId(ModelConstants.SYSTEM_TENANT)
            .build();
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder3 =
        mock(DeleteEntityEventBuilder.class);
    DeleteEntityEventBuilder<Object> builderResult2 = DeleteEntityEvent.builder();
    when(deleteEntityEventBuilder3.cause(Mockito.<ActionCause>any())).thenReturn(builderResult2);
    DeleteEntityEventBuilder<Object> deleteEntityEventBuilder4 =
        mock(DeleteEntityEventBuilder.class);
    when(deleteEntityEventBuilder4.body(Mockito.<String>any()))
        .thenReturn(deleteEntityEventBuilder3);
    DeleteEntityEvent<Object> buildResult2 =
        deleteEntityEventBuilder4
            .body("Not all who wander are lost")
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult =
        builderResult
            .body("Not all who wander are lost")
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DeleteEntityEvent#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean DeleteEntityEvent.equals(Object)",
    "int DeleteEntityEvent.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DeleteEntityEventBuilder<Object> builderResult = DeleteEntityEvent.builder();
    DeleteEntityEvent<Object> buildResult =
        builderResult
            .body("Not all who wander are lost")
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
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DeleteEntityEvent#DeleteEntityEvent(TenantId, EntityId, Object, String,
   *       ActionCause, long)}
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void DeleteEntityEvent.<init>(TenantId, EntityId, Object, String, ActionCause, long)",
    "String DeleteEntityEvent.getBody()",
    "ActionCause DeleteEntityEvent.getCause()",
    "Object DeleteEntityEvent.getEntity()",
    "EntityId DeleteEntityEvent.getEntityId()",
    "TenantId DeleteEntityEvent.getTenantId()",
    "long DeleteEntityEvent.getTs()",
    "String DeleteEntityEvent.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    DeleteEntityEvent<Object> actualDeleteEntityEvent =
        new DeleteEntityEvent<>(
            ModelConstants.SYSTEM_TENANT,
            entityId,
            "Entity",
            "Not all who wander are lost",
            ActionCause.TENANT_DELETION,
            1L);
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
