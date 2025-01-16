package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.EntitiesLimitNotificationInfo.EntitiesLimitNotificationInfoBuilder;

class EntitiesLimitNotificationInfoDiffblueTest {
  /**
   * Test EntitiesLimitNotificationInfoBuilder
   * {@link EntitiesLimitNotificationInfoBuilder#build()}.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link EntitiesLimitNotificationInfo.EntitiesLimitNotificationInfoBuilder#build()}
   *   <li>
   * {@link EntitiesLimitNotificationInfo.EntitiesLimitNotificationInfoBuilder#currentCount(long)}
   *   <li>
   * {@link EntitiesLimitNotificationInfo.EntitiesLimitNotificationInfoBuilder#entityType(EntityType)}
   *   <li>
   * {@link EntitiesLimitNotificationInfo.EntitiesLimitNotificationInfoBuilder#limit(long)}
   *   <li>
   * {@link EntitiesLimitNotificationInfo.EntitiesLimitNotificationInfoBuilder#percents(int)}
   *   <li>
   * {@link EntitiesLimitNotificationInfo.EntitiesLimitNotificationInfoBuilder#tenantId(TenantId)}
   *   <li>
   * {@link EntitiesLimitNotificationInfo.EntitiesLimitNotificationInfoBuilder#tenantName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntitiesLimitNotificationInfoBuilder build()")
  void testEntitiesLimitNotificationInfoBuilderBuild() {
    // Arrange and Act
    EntitiesLimitNotificationInfo actualBuildResult = EntitiesLimitNotificationInfo.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .percents(1)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Assert
    Map<String, String> templateData = actualBuildResult.getTemplateData();
    assertEquals(6, templateData.size());
    assertEquals("1", templateData.get("limit"));
    assertEquals("1", templateData.get("percents"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("tenantId"));
    TenantId affectedTenantId = actualBuildResult.getAffectedTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", affectedTenantId.getId().toString());
    assertEquals("3", templateData.get("currentCount"));
    assertEquals("Tenant Name", templateData.get("tenantName"));
    assertEquals("Tenant Name", actualBuildResult.getTenantName());
    assertEquals("Tenant", templateData.get("entityType"));
    assertNull(actualBuildResult.getAffectedCustomerId());
    assertNull(actualBuildResult.getDashboardId());
    assertNull(actualBuildResult.getStateEntityId());
    assertNull(actualBuildResult.getAffectedUserId());
    assertEquals(1, actualBuildResult.getPercents());
    assertEquals(1L, actualBuildResult.getLimit());
    assertEquals(3L, actualBuildResult.getCurrentCount());
    assertEquals(EntityType.TENANT, affectedTenantId.getEntityType());
    assertEquals(EntityType.TENANT, actualBuildResult.getEntityType());
    assertTrue(affectedTenantId.isNullUid());
    assertTrue(affectedTenantId.isSysTenantId());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#getTemplateData()}.
   * <ul>
   *   <li>Then return size is six.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesLimitNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is six")
  void testGetTemplateData_thenReturnSizeIsSix() {
    // Arrange
    EntitiesLimitNotificationInfo buildResult = EntitiesLimitNotificationInfo.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .percents(1)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act
    Map<String, String> actualTemplateData = buildResult.getTemplateData();

    // Assert
    assertEquals(6, actualTemplateData.size());
    assertEquals("1", actualTemplateData.get("limit"));
    assertEquals("1", actualTemplateData.get("percents"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("tenantId"));
    assertEquals("3", actualTemplateData.get("currentCount"));
    assertEquals("Tenant Name", actualTemplateData.get("tenantName"));
    assertEquals("Tenant", actualTemplateData.get("entityType"));
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}, and
   * {@link EntitiesLimitNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfo#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitiesLimitNotificationInfo buildResult = EntitiesLimitNotificationInfo.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .percents(1)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    EntitiesLimitNotificationInfo buildResult2 = EntitiesLimitNotificationInfo.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .percents(1)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}, and
   * {@link EntitiesLimitNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfo#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitiesLimitNotificationInfo buildResult = EntitiesLimitNotificationInfo.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .percents(1)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitNotificationInfo.EntitiesLimitNotificationInfoBuilder entitiesLimitNotificationInfoBuilder = mock(
        EntitiesLimitNotificationInfo.EntitiesLimitNotificationInfoBuilder.class);
    when(entitiesLimitNotificationInfoBuilder.currentCount(anyLong()))
        .thenReturn(EntitiesLimitNotificationInfo.builder());
    EntitiesLimitNotificationInfo buildResult = entitiesLimitNotificationInfoBuilder.currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .percents(1)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    EntitiesLimitNotificationInfo buildResult2 = EntitiesLimitNotificationInfo.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .percents(1)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitNotificationInfo buildResult = EntitiesLimitNotificationInfo.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .percents(1)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitNotificationInfo buildResult = EntitiesLimitNotificationInfo.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L)
        .percents(1)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to EntitiesLimitNotificationInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfo#EntitiesLimitNotificationInfo()}
   *   <li>{@link EntitiesLimitNotificationInfo#setCurrentCount(long)}
   *   <li>{@link EntitiesLimitNotificationInfo#setEntityType(EntityType)}
   *   <li>{@link EntitiesLimitNotificationInfo#setLimit(long)}
   *   <li>{@link EntitiesLimitNotificationInfo#setPercents(int)}
   *   <li>{@link EntitiesLimitNotificationInfo#setTenantId(TenantId)}
   *   <li>{@link EntitiesLimitNotificationInfo#setTenantName(String)}
   *   <li>{@link EntitiesLimitNotificationInfo#toString()}
   *   <li>{@link EntitiesLimitNotificationInfo#getAffectedTenantId()}
   *   <li>{@link EntitiesLimitNotificationInfo#getCurrentCount()}
   *   <li>{@link EntitiesLimitNotificationInfo#getEntityType()}
   *   <li>{@link EntitiesLimitNotificationInfo#getLimit()}
   *   <li>{@link EntitiesLimitNotificationInfo#getPercents()}
   *   <li>{@link EntitiesLimitNotificationInfo#getTenantId()}
   *   <li>{@link EntitiesLimitNotificationInfo#getTenantName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange and Act
    EntitiesLimitNotificationInfo actualEntitiesLimitNotificationInfo = new EntitiesLimitNotificationInfo();
    actualEntitiesLimitNotificationInfo.setCurrentCount(3L);
    actualEntitiesLimitNotificationInfo.setEntityType(EntityType.TENANT);
    actualEntitiesLimitNotificationInfo.setLimit(1L);
    actualEntitiesLimitNotificationInfo.setPercents(1);
    actualEntitiesLimitNotificationInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualEntitiesLimitNotificationInfo.setTenantName("Tenant Name");
    String actualToStringResult = actualEntitiesLimitNotificationInfo.toString();
    TenantId actualAffectedTenantId = actualEntitiesLimitNotificationInfo.getAffectedTenantId();
    long actualCurrentCount = actualEntitiesLimitNotificationInfo.getCurrentCount();
    EntityType actualEntityType = actualEntitiesLimitNotificationInfo.getEntityType();
    long actualLimit = actualEntitiesLimitNotificationInfo.getLimit();
    int actualPercents = actualEntitiesLimitNotificationInfo.getPercents();
    TenantId actualTenantId = actualEntitiesLimitNotificationInfo.getTenantId();

    // Assert that nothing has changed
    assertEquals(
        "EntitiesLimitNotificationInfo(entityType=TENANT, currentCount=3, limit=1, percents=1, tenantId=13814000"
            + "-1dd2-11b2-8080-808080808080, tenantName=Tenant Name)",
        actualToStringResult);
    assertEquals("Tenant Name", actualEntitiesLimitNotificationInfo.getTenantName());
    assertEquals(1, actualPercents);
    assertEquals(1L, actualLimit);
    assertEquals(3L, actualCurrentCount);
    assertEquals(EntityType.TENANT, actualEntityType);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test
   * {@link EntitiesLimitNotificationInfo#EntitiesLimitNotificationInfo(EntityType, long, long, int, TenantId, String)}.
   * <p>
   * Method under test:
   * {@link EntitiesLimitNotificationInfo#EntitiesLimitNotificationInfo(EntityType, long, long, int, TenantId, String)}
   */
  @Test
  @DisplayName("Test new EntitiesLimitNotificationInfo(EntityType, long, long, int, TenantId, String)")
  void testNewEntitiesLimitNotificationInfo() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    EntitiesLimitNotificationInfo actualEntitiesLimitNotificationInfo = new EntitiesLimitNotificationInfo(
        EntityType.TENANT, 3L, 1L, 1, tenantId, "Tenant Name");

    // Assert
    Map<String, String> templateData = actualEntitiesLimitNotificationInfo.getTemplateData();
    assertEquals(6, templateData.size());
    assertEquals("1", templateData.get("limit"));
    assertEquals("1", templateData.get("percents"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("tenantId"));
    assertEquals("3", templateData.get("currentCount"));
    assertEquals("Tenant Name", templateData.get("tenantName"));
    assertEquals("Tenant Name", actualEntitiesLimitNotificationInfo.getTenantName());
    assertEquals("Tenant", templateData.get("entityType"));
    assertNull(actualEntitiesLimitNotificationInfo.getAffectedCustomerId());
    assertNull(actualEntitiesLimitNotificationInfo.getDashboardId());
    assertNull(actualEntitiesLimitNotificationInfo.getStateEntityId());
    assertNull(actualEntitiesLimitNotificationInfo.getAffectedUserId());
    assertEquals(1, actualEntitiesLimitNotificationInfo.getPercents());
    assertEquals(1L, actualEntitiesLimitNotificationInfo.getLimit());
    assertEquals(3L, actualEntitiesLimitNotificationInfo.getCurrentCount());
    assertEquals(EntityType.TENANT, actualEntitiesLimitNotificationInfo.getEntityType());
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, actualEntitiesLimitNotificationInfo.getAffectedTenantId());
    assertSame(tenantId2, actualEntitiesLimitNotificationInfo.getTenantId());
  }
}
