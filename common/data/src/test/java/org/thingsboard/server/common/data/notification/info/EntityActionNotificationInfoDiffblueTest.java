package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.audit.ActionType;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.EntityActionNotificationInfo.EntityActionNotificationInfoBuilder;

class EntityActionNotificationInfoDiffblueTest {
  /**
   * Test EntityActionNotificationInfoBuilder
   * {@link EntityActionNotificationInfoBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityActionNotificationInfo.EntityActionNotificationInfoBuilder#build()}
   *   <li>
   * {@link EntityActionNotificationInfo.EntityActionNotificationInfoBuilder#actionType(ActionType)}
   *   <li>
   * {@link EntityActionNotificationInfo.EntityActionNotificationInfoBuilder#entityCustomerId(CustomerId)}
   *   <li>
   * {@link EntityActionNotificationInfo.EntityActionNotificationInfoBuilder#entityId(EntityId)}
   *   <li>
   * {@link EntityActionNotificationInfo.EntityActionNotificationInfoBuilder#entityName(String)}
   *   <li>
   * {@link EntityActionNotificationInfo.EntityActionNotificationInfoBuilder#userEmail(String)}
   *   <li>
   * {@link EntityActionNotificationInfo.EntityActionNotificationInfoBuilder#userFirstName(String)}
   *   <li>
   * {@link EntityActionNotificationInfo.EntityActionNotificationInfoBuilder#userId(UUID)}
   *   <li>
   * {@link EntityActionNotificationInfo.EntityActionNotificationInfoBuilder#userLastName(String)}
   *   <li>
   * {@link EntityActionNotificationInfo.EntityActionNotificationInfoBuilder#userTitle(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntityActionNotificationInfoBuilder build()")
  void testEntityActionNotificationInfoBuilderBuild() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = EntityActionNotificationInfo
        .builder()
        .actionType(ActionType.ADDED);
    CustomerId entityCustomerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(entityCustomerId)
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    UUID userId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    EntityActionNotificationInfo actualBuildResult = userFirstNameResult.userId(userId)
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Assert
    EntityId entityId = actualBuildResult.getEntityId();
    assertTrue(entityId instanceof TenantId);
    Map<String, String> templateData = actualBuildResult.getTemplateData();
    assertEquals(9, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("entityId"));
    UUID userId2 = actualBuildResult.getUserId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", userId2.toString());
    assertEquals("Doe", templateData.get("userLastName"));
    assertEquals("Doe", actualBuildResult.getUserLastName());
    assertEquals("Dr", templateData.get("userTitle"));
    assertEquals("Dr", actualBuildResult.getUserTitle());
    assertEquals("Entity Name", templateData.get("entityName"));
    assertEquals("Entity Name", actualBuildResult.getEntityName());
    assertEquals("Jane", actualBuildResult.getUserFirstName());
    assertEquals("Tenant", templateData.get("entityType"));
    assertEquals("added", templateData.get("actionType"));
    assertEquals("jane.doe@example.org", actualBuildResult.getUserEmail());
    assertNull(actualBuildResult.getDashboardId());
    assertNull(actualBuildResult.getAffectedTenantId());
    assertNull(actualBuildResult.getAffectedUserId());
    assertEquals(ActionType.ADDED, actualBuildResult.getActionType());
    assertSame(entityCustomerId, actualBuildResult.getAffectedCustomerId());
    assertSame(entityCustomerId, actualBuildResult.getEntityCustomerId());
    assertSame(userId, userId2);
    assertSame(entityId, actualBuildResult.getStateEntityId());
  }

  /**
   * Test {@link EntityActionNotificationInfo#getTemplateData()}.
   * <ul>
   *   <li>Then return size is nine.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is nine")
  void testGetTemplateData_thenReturnSizeIsNine() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = EntityActionNotificationInfo
        .builder()
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act
    Map<String, String> actualTemplateData = buildResult.getTemplateData();

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
   * Test {@link EntityActionNotificationInfo#equals(Object)}, and
   * {@link EntityActionNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityActionNotificationInfo#equals(Object)}
   *   <li>{@link EntityActionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = EntityActionNotificationInfo
        .builder()
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = EntityActionNotificationInfo
        .builder()
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}, and
   * {@link EntityActionNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityActionNotificationInfo#equals(Object)}
   *   <li>{@link EntityActionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.actionType(Mockito.<ActionType>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}, and
   * {@link EntityActionNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityActionNotificationInfo#equals(Object)}
   *   <li>{@link EntityActionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}, and
   * {@link EntityActionNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityActionNotificationInfo#equals(Object)}
   *   <li>{@link EntityActionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail(null)
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail(null)
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}, and
   * {@link EntityActionNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityActionNotificationInfo#equals(Object)}
   *   <li>{@link EntityActionNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = EntityActionNotificationInfo
        .builder()
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.actionType(Mockito.<ActionType>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = EntityActionNotificationInfo
        .builder()
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.actionType(Mockito.<ActionType>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(null)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = EntityActionNotificationInfo
        .builder()
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.actionType(Mockito.<ActionType>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityCustomerIdResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = entityCustomerIdResult
        .entityId(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = EntityActionNotificationInfo
        .builder()
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.actionType(Mockito.<ActionType>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName(null)
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = EntityActionNotificationInfo
        .builder()
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.actionType(Mockito.<ActionType>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("42")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = EntityActionNotificationInfo
        .builder()
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.actionType(Mockito.<ActionType>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder3
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("john.smith@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail(null)
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("John");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName(null);
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo buildResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane")
        .userId(EntityId.NULL_UUID)
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo buildResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane")
        .userId(null)
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Smith")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName(null)
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Mr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle(null)
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder builderResult = EntityActionNotificationInfo
        .builder();
    builderResult.actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any())).thenReturn(builderResult);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder builderResult = EntityActionNotificationInfo
        .builder();
    builderResult.entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder.entityCustomerId(Mockito.<CustomerId>any())).thenReturn(builderResult);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder2 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder2.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = entityActionNotificationInfoBuilder2
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder3 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder3.entityCustomerId(Mockito.<CustomerId>any()))
        .thenReturn(EntityActionNotificationInfo.builder());
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder entityActionNotificationInfoBuilder4 = mock(
        EntityActionNotificationInfo.EntityActionNotificationInfoBuilder.class);
    when(entityActionNotificationInfoBuilder4.actionType(Mockito.<ActionType>any()))
        .thenReturn(entityActionNotificationInfoBuilder3);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult2 = entityActionNotificationInfoBuilder4
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult2 = actionTypeResult2
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult2 = userFirstNameResult2
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = EntityActionNotificationInfo
        .builder()
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link EntityActionNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityActionNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder actionTypeResult = EntityActionNotificationInfo
        .builder()
        .actionType(ActionType.ADDED);
    EntityActionNotificationInfo.EntityActionNotificationInfoBuilder userFirstNameResult = actionTypeResult
        .entityCustomerId(new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
        .entityId(TenantId.SYS_TENANT_ID)
        .entityName("Entity Name")
        .userEmail("jane.doe@example.org")
        .userFirstName("Jane");
    EntityActionNotificationInfo buildResult = userFirstNameResult
        .userId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"))
        .userLastName("Doe")
        .userTitle("Dr")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntityActionNotificationInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    EntityActionNotificationInfo actualEntityActionNotificationInfo = new EntityActionNotificationInfo();
    actualEntityActionNotificationInfo.setActionType(ActionType.ADDED);
    CustomerId entityCustomerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    CustomerId actualAffectedCustomerId = actualEntityActionNotificationInfo.getAffectedCustomerId();
    CustomerId actualEntityCustomerId = actualEntityActionNotificationInfo.getEntityCustomerId();
    EntityId actualEntityId = actualEntityActionNotificationInfo.getEntityId();
    String actualEntityName = actualEntityActionNotificationInfo.getEntityName();
    EntityId actualStateEntityId = actualEntityActionNotificationInfo.getStateEntityId();
    String actualUserEmail = actualEntityActionNotificationInfo.getUserEmail();
    String actualUserFirstName = actualEntityActionNotificationInfo.getUserFirstName();
    UUID actualUserId = actualEntityActionNotificationInfo.getUserId();
    String actualUserLastName = actualEntityActionNotificationInfo.getUserLastName();
    String actualUserTitle = actualEntityActionNotificationInfo.getUserTitle();

    // Assert that nothing has changed
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUserId.toString());
    assertEquals("Doe", actualUserLastName);
    assertEquals("Dr", actualUserTitle);
    assertEquals("Entity Name", actualEntityName);
    assertEquals("EntityActionNotificationInfo(entityId=13814000-1dd2-11b2-8080-808080808080, entityName=Entity Name,"
        + " actionType=ADDED, entityCustomerId=784f394c-42b6-435a-983c-b7beff2784f9, userId=784f394c-42b6-435a"
        + "-983c-b7beff2784f9, userTitle=Dr, userEmail=jane.doe@example.org, userFirstName=Jane, userLastName"
        + "=Doe)", actualToStringResult);
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
   * <ul>
   *   <li>When {@link TenantId#SYS_TENANT_ID}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntityActionNotificationInfo#EntityActionNotificationInfo(EntityId, String, ActionType, CustomerId, UUID, String, String, String, String)}
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
  void testGettersAndSetters_whenSys_tenant_id() {
    // Arrange
    CustomerId entityCustomerId = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    EntityActionNotificationInfo actualEntityActionNotificationInfo = new EntityActionNotificationInfo(
        TenantId.SYS_TENANT_ID, "Entity Name", ActionType.ADDED, entityCustomerId,
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"), "Dr", "jane.doe@example.org", "Jane", "Doe");
    actualEntityActionNotificationInfo.setActionType(ActionType.ADDED);
    CustomerId entityCustomerId2 = new CustomerId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    CustomerId actualAffectedCustomerId = actualEntityActionNotificationInfo.getAffectedCustomerId();
    CustomerId actualEntityCustomerId = actualEntityActionNotificationInfo.getEntityCustomerId();
    EntityId actualEntityId = actualEntityActionNotificationInfo.getEntityId();
    String actualEntityName = actualEntityActionNotificationInfo.getEntityName();
    EntityId actualStateEntityId = actualEntityActionNotificationInfo.getStateEntityId();
    String actualUserEmail = actualEntityActionNotificationInfo.getUserEmail();
    String actualUserFirstName = actualEntityActionNotificationInfo.getUserFirstName();
    UUID actualUserId = actualEntityActionNotificationInfo.getUserId();
    String actualUserLastName = actualEntityActionNotificationInfo.getUserLastName();
    String actualUserTitle = actualEntityActionNotificationInfo.getUserTitle();

    // Assert that nothing has changed
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualUserId.toString());
    assertEquals("Doe", actualUserLastName);
    assertEquals("Dr", actualUserTitle);
    assertEquals("Entity Name", actualEntityName);
    assertEquals("EntityActionNotificationInfo(entityId=13814000-1dd2-11b2-8080-808080808080, entityName=Entity Name,"
        + " actionType=ADDED, entityCustomerId=784f394c-42b6-435a-983c-b7beff2784f9, userId=784f394c-42b6-435a"
        + "-983c-b7beff2784f9, userTitle=Dr, userEmail=jane.doe@example.org, userFirstName=Jane, userLastName"
        + "=Doe)", actualToStringResult);
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
