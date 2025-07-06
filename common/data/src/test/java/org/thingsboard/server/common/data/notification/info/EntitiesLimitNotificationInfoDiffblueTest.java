package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.EntitiesLimitNotificationInfo.EntitiesLimitNotificationInfoBuilder;

@ContextConfiguration(classes = {EntitiesLimitNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class EntitiesLimitNotificationInfoDiffblueTest {
  @Autowired private EntitiesLimitNotificationInfoBuilder entitiesLimitNotificationInfoBuilder;

  /**
   * Test EntitiesLimitNotificationInfoBuilder {@link EntitiesLimitNotificationInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#build()}
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#currentCount(long)}
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#entityType(EntityType)}
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#limit(long)}
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#percents(int)}
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#tenantId(TenantId)}
   *   <li>{@link EntitiesLimitNotificationInfoBuilder#tenantName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test EntitiesLimitNotificationInfoBuilder build()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntitiesLimitNotificationInfoBuilder.<init>()",
    "EntitiesLimitNotificationInfo EntitiesLimitNotificationInfoBuilder.build()",
    "EntitiesLimitNotificationInfoBuilder EntitiesLimitNotificationInfoBuilder.currentCount(long)",
    "EntitiesLimitNotificationInfoBuilder EntitiesLimitNotificationInfoBuilder.entityType(EntityType)",
    "EntitiesLimitNotificationInfoBuilder EntitiesLimitNotificationInfoBuilder.limit(long)",
    "EntitiesLimitNotificationInfoBuilder EntitiesLimitNotificationInfoBuilder.percents(int)",
    "EntitiesLimitNotificationInfoBuilder EntitiesLimitNotificationInfoBuilder.tenantId(TenantId)",
    "EntitiesLimitNotificationInfoBuilder EntitiesLimitNotificationInfoBuilder.tenantName(String)",
    "String EntitiesLimitNotificationInfoBuilder.toString()"
  })
  void testEntitiesLimitNotificationInfoBuilderBuild() {
    // Arrange and Act
    EntitiesLimitNotificationInfo actualBuildResult =
        EntitiesLimitNotificationInfo.builder()
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
   *
   * <ul>
   *   <li>Then return size is six.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is six")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map EntitiesLimitNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsSix() {
    // Arrange
    EntitiesLimitNotificationInfo buildResult =
        EntitiesLimitNotificationInfo.builder()
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
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}, and {@link
   * EntitiesLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfo#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntitiesLimitNotificationInfo buildResult =
        EntitiesLimitNotificationInfo.builder()
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    EntitiesLimitNotificationInfo buildResult2 =
        EntitiesLimitNotificationInfo.builder()
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
   * Test {@link EntitiesLimitNotificationInfo#equals(Object)}, and {@link
   * EntitiesLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link EntitiesLimitNotificationInfo#equals(Object)}
   *   <li>{@link EntitiesLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntitiesLimitNotificationInfo buildResult =
        EntitiesLimitNotificationInfo.builder()
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
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitNotificationInfoBuilder entitiesLimitNotificationInfoBuilder =
        mock(EntitiesLimitNotificationInfoBuilder.class);
    when(entitiesLimitNotificationInfoBuilder.currentCount(anyLong()))
        .thenReturn(EntitiesLimitNotificationInfo.builder());
    EntitiesLimitNotificationInfo buildResult =
        entitiesLimitNotificationInfoBuilder
            .currentCount(3L)
            .entityType(EntityType.TENANT)
            .limit(1L)
            .percents(1)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    EntitiesLimitNotificationInfo buildResult2 =
        EntitiesLimitNotificationInfo.builder()
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
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitNotificationInfo buildResult =
        EntitiesLimitNotificationInfo.builder()
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
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link EntitiesLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean EntitiesLimitNotificationInfo.equals(Object)",
    "int EntitiesLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    EntitiesLimitNotificationInfo buildResult =
        EntitiesLimitNotificationInfo.builder()
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
   *
   * <p>Methods under test:
   *
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntitiesLimitNotificationInfo.<init>()",
    "TenantId EntitiesLimitNotificationInfo.getAffectedTenantId()",
    "long EntitiesLimitNotificationInfo.getCurrentCount()",
    "EntityType EntitiesLimitNotificationInfo.getEntityType()",
    "long EntitiesLimitNotificationInfo.getLimit()",
    "int EntitiesLimitNotificationInfo.getPercents()",
    "TenantId EntitiesLimitNotificationInfo.getTenantId()",
    "String EntitiesLimitNotificationInfo.getTenantName()",
    "void EntitiesLimitNotificationInfo.setCurrentCount(long)",
    "void EntitiesLimitNotificationInfo.setEntityType(EntityType)",
    "void EntitiesLimitNotificationInfo.setLimit(long)",
    "void EntitiesLimitNotificationInfo.setPercents(int)",
    "void EntitiesLimitNotificationInfo.setTenantId(TenantId)",
    "void EntitiesLimitNotificationInfo.setTenantName(String)",
    "String EntitiesLimitNotificationInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    EntitiesLimitNotificationInfo actualEntitiesLimitNotificationInfo =
        new EntitiesLimitNotificationInfo();
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

    // Assert
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
   * Test {@link EntitiesLimitNotificationInfo#EntitiesLimitNotificationInfo(EntityType, long, long,
   * int, TenantId, String)}.
   *
   * <p>Method under test: {@link
   * EntitiesLimitNotificationInfo#EntitiesLimitNotificationInfo(EntityType, long, long, int,
   * TenantId, String)}
   */
  @Test
  @DisplayName(
      "Test new EntitiesLimitNotificationInfo(EntityType, long, long, int, TenantId, String)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "void EntitiesLimitNotificationInfo.<init>(EntityType, long, long, int, TenantId, String)"
  })
  void testNewEntitiesLimitNotificationInfo() {
    // Arrange
    TenantId tenantId = TenantId.SYS_TENANT_ID;

    // Act
    EntitiesLimitNotificationInfo actualEntitiesLimitNotificationInfo =
        new EntitiesLimitNotificationInfo(EntityType.TENANT, 3L, 1L, 1, tenantId, "Tenant Name");

    // Assert
    assertEquals("Tenant Name", actualEntitiesLimitNotificationInfo.getTenantName());
    assertNull(actualEntitiesLimitNotificationInfo.getAffectedCustomerId());
    assertNull(actualEntitiesLimitNotificationInfo.getDashboardId());
    assertNull(actualEntitiesLimitNotificationInfo.getStateEntityId());
    assertNull(actualEntitiesLimitNotificationInfo.getAffectedUserId());
    assertEquals(1, actualEntitiesLimitNotificationInfo.getPercents());
    assertEquals(1L, actualEntitiesLimitNotificationInfo.getLimit());
    assertEquals(3L, actualEntitiesLimitNotificationInfo.getCurrentCount());
    Map<String, String> templateData = actualEntitiesLimitNotificationInfo.getTemplateData();
    assertEquals(6, templateData.size());
    assertEquals(EntityType.TENANT, actualEntitiesLimitNotificationInfo.getEntityType());
    assertTrue(templateData.containsKey("currentCount"));
    assertTrue(templateData.containsKey("entityType"));
    assertTrue(templateData.containsKey("limit"));
    assertTrue(templateData.containsKey("percents"));
    assertTrue(templateData.containsKey("tenantId"));
    assertTrue(templateData.containsKey("tenantName"));
    TenantId tenantId2 = tenantId.SYS_TENANT_ID;
    assertSame(tenantId2, actualEntitiesLimitNotificationInfo.getAffectedTenantId());
    assertSame(tenantId2, actualEntitiesLimitNotificationInfo.getTenantId());
  }
}
