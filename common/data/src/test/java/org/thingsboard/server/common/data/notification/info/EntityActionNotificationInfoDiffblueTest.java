package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.EntityActionNotificationInfo.EntityActionNotificationInfoBuilder;

@ContextConfiguration(classes = {EntityActionNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class EntityActionNotificationInfoDiffblueTest {
  @Autowired private EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder;

  /**
   * Test EntityActionNotificationInfoBuilder {@link EntityActionNotificationInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionNotificationInfoBuilder#build()}
   *   <li>{@link EntityActionNotificationInfoBuilder#actionType(ActionType)}
   *   <li>{@link EntityActionNotificationInfoBuilder#entityCustomerId(CustomerId)}
   *   <li>{@link EntityActionNotificationInfoBuilder#entityId(EntityId)}
   *   <li>{@link EntityActionNotificationInfoBuilder#entityName(String)}
   *   <li>{@link EntityActionNotificationInfoBuilder#userEmail(String)}
   *   <li>{@link EntityActionNotificationInfoBuilder#userFirstName(String)}
   *   <li>{@link EntityActionNotificationInfoBuilder#userId(UUID)}
   *   <li>{@link EntityActionNotificationInfoBuilder#userLastName(String)}
   *   <li>{@link EntityActionNotificationInfoBuilder#userTitle(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityActionNotificationInfoBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityActionNotificationInfoBuilder.<init>()",
    "EntityActionNotificationInfoBuilder EntityActionNotificationInfoBuilder.actionType(ActionType)",
    "EntityActionNotificationInfo EntityActionNotificationInfoBuilder.build()",
    "EntityActionNotificationInfoBuilder EntityActionNotificationInfoBuilder.entityCustomerId(CustomerId)",
    "EntityActionNotificationInfoBuilder EntityActionNotificationInfoBuilder.entityId(EntityId)",
    "EntityActionNotificationInfoBuilder EntityActionNotificationInfoBuilder.entityName(String)",
    "String EntityActionNotificationInfoBuilder.toString()",
    "EntityActionNotificationInfoBuilder EntityActionNotificationInfoBuilder.userEmail(String)",
    "EntityActionNotificationInfoBuilder EntityActionNotificationInfoBuilder.userFirstName(String)",
    "EntityActionNotificationInfoBuilder EntityActionNotificationInfoBuilder.userId(UUID)",
    "EntityActionNotificationInfoBuilder EntityActionNotificationInfoBuilder.userLastName(String)",
    "EntityActionNotificationInfoBuilder EntityActionNotificationInfoBuilder.userTitle(String)"
  })
  void testEntityActionNotificationInfoBuilderBuild() {
    // Arrange and Act
    EntityActionNotificationInfoBuilder actualActionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);
    CustomerId entityCustomerId =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityActionNotificationInfoBuilder actualUserFirstNameResult =
        actualActionTypeResult
            .entityCustomerId(entityCustomerId)
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    EntityActionNotificationInfo actualEntityActionNotificationInfo =
        actualUserFirstNameResult.userId(userId).userLastName("Doe").userTitle("Dr").build();

    // Assert
    Map<String, String> templateData = actualEntityActionNotificationInfo.getTemplateData();
    assertEquals(9, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("entityId"));
    UUID userId2 = actualEntityActionNotificationInfo.getUserId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", userId2.toString());
    assertEquals("Doe", templateData.get("userLastName"));
    assertEquals("Doe", actualEntityActionNotificationInfo.getUserLastName());
    assertEquals("Dr", templateData.get("userTitle"));
    assertEquals("Dr", actualEntityActionNotificationInfo.getUserTitle());
    assertEquals("Entity Name", templateData.get("entityName"));
    assertEquals("Entity Name", actualEntityActionNotificationInfo.getEntityName());
    assertEquals("Jane", actualEntityActionNotificationInfo.getUserFirstName());
    assertEquals("Tenant", templateData.get("entityType"));
    assertEquals("added", templateData.get("actionType"));
    assertEquals("jane.doe@example.org", actualEntityActionNotificationInfo.getUserEmail());
    assertNull(actualEntityActionNotificationInfo.getDashboardId());
    assertNull(actualEntityActionNotificationInfo.getAffectedTenantId());
    assertNull(actualEntityActionNotificationInfo.getAffectedUserId());
    assertEquals(ActionType.ADDED, actualEntityActionNotificationInfo.getActionType());
    assertSame(entityCustomerId, actualEntityActionNotificationInfo.getAffectedCustomerId());
    assertSame(entityCustomerId, actualEntityActionNotificationInfo.getEntityCustomerId());
    assertSame(userId, userId2);
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualEntityActionNotificationInfo.getEntityId());
    assertSame(tenantId, actualEntityActionNotificationInfo.getStateEntityId());
  }

  /**
   * Test {@link EntityActionNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return size is nine.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is nine")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map EntityActionNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsNine() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act
    Map<String, String> actualTemplateData =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build()
            .getTemplateData();

    // Assert
    assertEquals(9, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("entityId"));
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTemplateData.get("userId"));
    assertEquals("Doe", actualTemplateData.get("userLastName"));
    assertEquals("Dr", actualTemplateData.get("userTitle"));
    assertEquals("Entity Name", actualTemplateData.get("entityName"));
    assertEquals("Jane", actualTemplateData.get("userFirstName"));
    assertEquals("Tenant", actualTemplateData.get("entityType"));
    assertEquals("added", actualTemplateData.get("actionType"));
    assertEquals("jane.doe@example.org", actualTemplateData.get("userEmail"));
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}, and {@link
   * EntityActionNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionNotificationInfo#equals(Object)}
   *   <li>{@link EntityActionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo2 =
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    // Act and Assert
    assertEquals(entityActionNotificationInfo, entityActionNotificationInfo2);
    assertEquals(entityActionNotificationInfo.hashCode(), entityActionNotificationInfo2.hashCode());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}, and {@link
   * EntityActionNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionNotificationInfo#equals(Object)}
   *   <li>{@link EntityActionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityActionNotificationInfoBuilder userFirstNameResult =
        EntityActionNotificationInfo.builder()
            .actionType(ActionType.ADDED)
            .entityCustomerId(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        EntityActionNotificationInfo.builder()
            .actionType(ActionType.ADDED)
            .entityCustomerId(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo2 =
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    // Act and Assert
    assertEquals(entityActionNotificationInfo, entityActionNotificationInfo2);
    assertEquals(entityActionNotificationInfo.hashCode(), entityActionNotificationInfo2.hashCode());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}, and {@link
   * EntityActionNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionNotificationInfo#equals(Object)}
   *   <li>{@link EntityActionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(null);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(null);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo2 =
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    // Act and Assert
    assertEquals(entityActionNotificationInfo, entityActionNotificationInfo2);
    assertEquals(entityActionNotificationInfo.hashCode(), entityActionNotificationInfo2.hashCode());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}, and {@link
   * EntityActionNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionNotificationInfo#equals(Object)}
   *   <li>{@link EntityActionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    // Act and Assert
    assertEquals(entityActionNotificationInfo, entityActionNotificationInfo);
    int expectedHashCodeResult = entityActionNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, entityActionNotificationInfo.hashCode());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(new CustomerId(EntityId.NULL_UUID))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityActionNotificationInfoBuilder userFirstNameResult =
        EntityActionNotificationInfo.builder()
            .actionType(ActionType.ADDED)
            .entityCustomerId(null)
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(null);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.DELETED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(null)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder entityCustomerIdResult =
        actionTypeResult.entityCustomerId(
            new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    EntityActionNotificationInfoBuilder userFirstNameResult =
        entityCustomerIdResult
            .entityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Dr")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName(null)
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("john.smith@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail(null)
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("John");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName(null);
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);
    EntityActionNotificationInfo entityActionNotificationInfo =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane")
            .userId(EntityId.NULL_UUID)
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);
    EntityActionNotificationInfo entityActionNotificationInfo =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane")
            .userId(null)
            .userLastName("Doe")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Smith")
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName(null)
            .userTitle("Dr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Mr")
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");
    EntityActionNotificationInfo entityActionNotificationInfo =
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle(null)
            .build();

    EntityActionNotificationInfoBuilder actionTypeResult2 =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult2 =
        actionTypeResult2
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        entityActionNotificationInfo,
        userFirstNameResult2
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build(),
        null);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean EntityActionNotificationInfo.equals(Object)",
    "int EntityActionNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityActionNotificationInfoBuilder actionTypeResult =
        EntityActionNotificationInfo.builder().actionType(ActionType.ADDED);

    EntityActionNotificationInfoBuilder userFirstNameResult =
        actionTypeResult
            .entityCustomerId(
                new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .entityId(TenantId.SYS_TENANT_ID)
            .entityName("Entity Name")
            .userEmail("jane.doe@example.org")
            .userFirstName("Jane");

    // Act and Assert
    assertNotEquals(
        userFirstNameResult
            .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
            .userLastName("Doe")
            .userTitle("Dr")
            .build(),
        "Different type to EntityActionNotificationInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionNotificationInfo#EntityActionNotificationInfo()}
   *   <li>{@link EntityActionNotificationInfo#setActionType(ActionType)}
   *   <li>{@link EntityActionNotificationInfo#setEntityCustomerId(CustomerId)}
   *   <li>{@link EntityActionNotificationInfo#setEntityId(EntityId)}
   *   <li>{@link EntityActionNotificationInfo#setEntityName(String)}
   *   <li>{@link EntityActionNotificationInfo#setUserEmail(String)}
   *   <li>{@link EntityActionNotificationInfo#setUserFirstName(String)}
   *   <li>{@link EntityActionNotificationInfo#setUserId(UUID)}
   *   <li>{@link EntityActionNotificationInfo#setUserLastName(String)}
   *   <li>{@link EntityActionNotificationInfo#setUserTitle(String)}
   *   <li>{@link EntityActionNotificationInfo#toString()}
   *   <li>{@link EntityActionNotificationInfo#getActionType()}
   *   <li>{@link EntityActionNotificationInfo#getAffectedCustomerId()}
   *   <li>{@link EntityActionNotificationInfo#getEntityCustomerId()}
   *   <li>{@link EntityActionNotificationInfo#getEntityId()}
   *   <li>{@link EntityActionNotificationInfo#getEntityName()}
   *   <li>{@link EntityActionNotificationInfo#getStateEntityId()}
   *   <li>{@link EntityActionNotificationInfo#getUserEmail()}
   *   <li>{@link EntityActionNotificationInfo#getUserFirstName()}
   *   <li>{@link EntityActionNotificationInfo#getUserId()}
   *   <li>{@link EntityActionNotificationInfo#getUserLastName()}
   *   <li>{@link EntityActionNotificationInfo#getUserTitle()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityActionNotificationInfo.<init>()",
    "void EntityActionNotificationInfo.<init>(EntityId, String, ActionType, CustomerId, UUID, String, String, String, String)",
    "ActionType EntityActionNotificationInfo.getActionType()",
    "CustomerId EntityActionNotificationInfo.getAffectedCustomerId()",
    "CustomerId EntityActionNotificationInfo.getEntityCustomerId()",
    "EntityId EntityActionNotificationInfo.getEntityId()",
    "String EntityActionNotificationInfo.getEntityName()",
    "EntityId EntityActionNotificationInfo.getStateEntityId()",
    "String EntityActionNotificationInfo.getUserEmail()",
    "String EntityActionNotificationInfo.getUserFirstName()",
    "UUID EntityActionNotificationInfo.getUserId()",
    "String EntityActionNotificationInfo.getUserLastName()",
    "String EntityActionNotificationInfo.getUserTitle()",
    "void EntityActionNotificationInfo.setActionType(ActionType)",
    "void EntityActionNotificationInfo.setEntityCustomerId(CustomerId)",
    "void EntityActionNotificationInfo.setEntityId(EntityId)",
    "void EntityActionNotificationInfo.setEntityName(String)",
    "void EntityActionNotificationInfo.setUserEmail(String)",
    "void EntityActionNotificationInfo.setUserFirstName(String)",
    "void EntityActionNotificationInfo.setUserId(UUID)",
    "void EntityActionNotificationInfo.setUserLastName(String)",
    "void EntityActionNotificationInfo.setUserTitle(String)",
    "String EntityActionNotificationInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntityActionNotificationInfo actualEntityActionNotificationInfo =
        new EntityActionNotificationInfo();
    actualEntityActionNotificationInfo.setActionType(ActionType.ADDED);
    CustomerId entityCustomerId =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualEntityActionNotificationInfo.setEntityCustomerId(entityCustomerId);
    actualEntityActionNotificationInfo.setEntityId(TenantId.SYS_TENANT_ID);
    actualEntityActionNotificationInfo.setEntityName("Entity Name");
    actualEntityActionNotificationInfo.setUserEmail("jane.doe@example.org");
    actualEntityActionNotificationInfo.setUserFirstName("Jane");
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEntityActionNotificationInfo.setUserId(userId);
    actualEntityActionNotificationInfo.setUserLastName("Doe");
    actualEntityActionNotificationInfo.setUserTitle("Dr");
    String actualToStringResult = actualEntityActionNotificationInfo.toString();
    ActionType actualActionType = actualEntityActionNotificationInfo.getActionType();
    CustomerId actualAffectedCustomerId =
        actualEntityActionNotificationInfo.getAffectedCustomerId();
    CustomerId actualEntityCustomerId = actualEntityActionNotificationInfo.getEntityCustomerId();
    EntityId actualEntityId = actualEntityActionNotificationInfo.getEntityId();
    String actualEntityName = actualEntityActionNotificationInfo.getEntityName();
    EntityId actualStateEntityId = actualEntityActionNotificationInfo.getStateEntityId();
    String actualUserEmail = actualEntityActionNotificationInfo.getUserEmail();
    String actualUserFirstName = actualEntityActionNotificationInfo.getUserFirstName();
    UUID actualUserId = actualEntityActionNotificationInfo.getUserId();
    String actualUserLastName = actualEntityActionNotificationInfo.getUserLastName();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUserId.toString());
    assertEquals("Doe", actualUserLastName);
    assertEquals("Dr", actualEntityActionNotificationInfo.getUserTitle());
    assertEquals("Entity Name", actualEntityName);
    assertEquals(
        "EntityActionNotificationInfo(entityId=13814000-1dd2-11b2-8080-808080808080, entityName=Entity Name,"
            + " actionType=ADDED, entityCustomerId=784f394c-42b6-435a-983c-b7beff2784f9, userId=784f394c-42b6-435a"
            + "-983c-b7beff2784f9, userTitle=Dr, userEmail=jane.doe@example.org, userFirstName=Jane, userLastName"
            + "=Doe)",
        actualToStringResult);
    assertEquals("Jane", actualUserFirstName);
    assertEquals("jane.doe@example.org", actualUserEmail);
    assertEquals(ActionType.ADDED, actualActionType);
    assertSame(entityCustomerId, actualAffectedCustomerId);
    assertSame(entityCustomerId, actualEntityCustomerId);
    assertSame(userId, actualUserId);
    TenantId tenantId = ((TenantId) actualStateEntityId).SYS_TENANT_ID;
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualStateEntityId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntityActionNotificationInfo#EntityActionNotificationInfo(EntityId, String,
   *       ActionType, CustomerId, UUID, String, String, String, String)}
   *   <li>{@link EntityActionNotificationInfo#setActionType(ActionType)}
   *   <li>{@link EntityActionNotificationInfo#setEntityCustomerId(CustomerId)}
   *   <li>{@link EntityActionNotificationInfo#setEntityId(EntityId)}
   *   <li>{@link EntityActionNotificationInfo#setEntityName(String)}
   *   <li>{@link EntityActionNotificationInfo#setUserEmail(String)}
   *   <li>{@link EntityActionNotificationInfo#setUserFirstName(String)}
   *   <li>{@link EntityActionNotificationInfo#setUserId(UUID)}
   *   <li>{@link EntityActionNotificationInfo#setUserLastName(String)}
   *   <li>{@link EntityActionNotificationInfo#setUserTitle(String)}
   *   <li>{@link EntityActionNotificationInfo#toString()}
   *   <li>{@link EntityActionNotificationInfo#getActionType()}
   *   <li>{@link EntityActionNotificationInfo#getAffectedCustomerId()}
   *   <li>{@link EntityActionNotificationInfo#getEntityCustomerId()}
   *   <li>{@link EntityActionNotificationInfo#getEntityId()}
   *   <li>{@link EntityActionNotificationInfo#getEntityName()}
   *   <li>{@link EntityActionNotificationInfo#getStateEntityId()}
   *   <li>{@link EntityActionNotificationInfo#getUserEmail()}
   *   <li>{@link EntityActionNotificationInfo#getUserFirstName()}
   *   <li>{@link EntityActionNotificationInfo#getUserId()}
   *   <li>{@link EntityActionNotificationInfo#getUserLastName()}
   *   <li>{@link EntityActionNotificationInfo#getUserTitle()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when SYS_TENANT_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void EntityActionNotificationInfo.<init>()",
    "void EntityActionNotificationInfo.<init>(EntityId, String, ActionType, CustomerId, UUID, String, String, String, String)",
    "ActionType EntityActionNotificationInfo.getActionType()",
    "CustomerId EntityActionNotificationInfo.getAffectedCustomerId()",
    "CustomerId EntityActionNotificationInfo.getEntityCustomerId()",
    "EntityId EntityActionNotificationInfo.getEntityId()",
    "String EntityActionNotificationInfo.getEntityName()",
    "EntityId EntityActionNotificationInfo.getStateEntityId()",
    "String EntityActionNotificationInfo.getUserEmail()",
    "String EntityActionNotificationInfo.getUserFirstName()",
    "UUID EntityActionNotificationInfo.getUserId()",
    "String EntityActionNotificationInfo.getUserLastName()",
    "String EntityActionNotificationInfo.getUserTitle()",
    "void EntityActionNotificationInfo.setActionType(ActionType)",
    "void EntityActionNotificationInfo.setEntityCustomerId(CustomerId)",
    "void EntityActionNotificationInfo.setEntityId(EntityId)",
    "void EntityActionNotificationInfo.setEntityName(String)",
    "void EntityActionNotificationInfo.setUserEmail(String)",
    "void EntityActionNotificationInfo.setUserFirstName(String)",
    "void EntityActionNotificationInfo.setUserId(UUID)",
    "void EntityActionNotificationInfo.setUserLastName(String)",
    "void EntityActionNotificationInfo.setUserTitle(String)",
    "String EntityActionNotificationInfo.toString()"
  })
  void testGettersAndSetters_whenSys_tenant_id() {
    // Arrange
    CustomerId entityCustomerId =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EntityActionNotificationInfo actualEntityActionNotificationInfo =
        new EntityActionNotificationInfo(
            TenantId.SYS_TENANT_ID,
            "Entity Name",
            ActionType.ADDED,
            entityCustomerId,
            UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"),
            "Dr",
            "jane.doe@example.org",
            "Jane",
            "Doe");
    actualEntityActionNotificationInfo.setActionType(ActionType.ADDED);
    CustomerId entityCustomerId2 =
        new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    actualEntityActionNotificationInfo.setEntityCustomerId(entityCustomerId2);
    actualEntityActionNotificationInfo.setEntityId(TenantId.SYS_TENANT_ID);
    actualEntityActionNotificationInfo.setEntityName("Entity Name");
    actualEntityActionNotificationInfo.setUserEmail("jane.doe@example.org");
    actualEntityActionNotificationInfo.setUserFirstName("Jane");
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualEntityActionNotificationInfo.setUserId(userId);
    actualEntityActionNotificationInfo.setUserLastName("Doe");
    actualEntityActionNotificationInfo.setUserTitle("Dr");
    String actualToStringResult = actualEntityActionNotificationInfo.toString();
    ActionType actualActionType = actualEntityActionNotificationInfo.getActionType();
    CustomerId actualAffectedCustomerId =
        actualEntityActionNotificationInfo.getAffectedCustomerId();
    CustomerId actualEntityCustomerId = actualEntityActionNotificationInfo.getEntityCustomerId();
    EntityId actualEntityId = actualEntityActionNotificationInfo.getEntityId();
    String actualEntityName = actualEntityActionNotificationInfo.getEntityName();
    EntityId actualStateEntityId = actualEntityActionNotificationInfo.getStateEntityId();
    String actualUserEmail = actualEntityActionNotificationInfo.getUserEmail();
    String actualUserFirstName = actualEntityActionNotificationInfo.getUserFirstName();
    UUID actualUserId = actualEntityActionNotificationInfo.getUserId();
    String actualUserLastName = actualEntityActionNotificationInfo.getUserLastName();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUserId.toString());
    assertEquals("Doe", actualUserLastName);
    assertEquals("Dr", actualEntityActionNotificationInfo.getUserTitle());
    assertEquals("Entity Name", actualEntityName);
    assertEquals(
        "EntityActionNotificationInfo(entityId=13814000-1dd2-11b2-8080-808080808080, entityName=Entity Name,"
            + " actionType=ADDED, entityCustomerId=784f394c-42b6-435a-983c-b7beff2784f9, userId=784f394c-42b6-435a"
            + "-983c-b7beff2784f9, userTitle=Dr, userEmail=jane.doe@example.org, userFirstName=Jane, userLastName"
            + "=Doe)",
        actualToStringResult);
    assertEquals("Jane", actualUserFirstName);
    assertEquals("jane.doe@example.org", actualUserEmail);
    assertEquals(ActionType.ADDED, actualActionType);
    assertSame(entityCustomerId2, actualAffectedCustomerId);
    assertSame(entityCustomerId2, actualEntityCustomerId);
    assertSame(userId, actualUserId);
    TenantId tenantId = ((TenantId) actualStateEntityId).SYS_TENANT_ID;
    assertSame(tenantId, actualEntityId);
    assertSame(tenantId, actualStateEntityId);
  }
}
