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
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.data.notification.info.RateLimitsNotificationInfo.RateLimitsNotificationInfoBuilder;

@ContextConfiguration(classes = {RateLimitsNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class RateLimitsNotificationInfoDiffblueTest {
  @Autowired private RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder;

  /**
   * Test {@link RateLimitsNotificationInfo#getTemplateData()}.
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map RateLimitsNotificationInfo.getTemplateData()"})
  void testGetTemplateData() {
    // Arrange and Act
    Map<String, String> actualTemplateData =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build()
            .getTemplateData();

    // Assert
    assertEquals(6, actualTemplateData.size());
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("limitLevelEntityId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("tenantId"));
    assertEquals("Limit Level Entity Name", actualTemplateData.get("limitLevelEntityName"));
    assertEquals("Tenant Name", actualTemplateData.get("tenantName"));
    assertEquals("Tenant", actualTemplateData.get("limitLevelEntityType"));
    assertEquals("entity version creation", actualTemplateData.get("api"));
  }

  /**
   * Test {@link RateLimitsNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return {@code limitLevelEntityId} is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return 'limitLevelEntityId' is 'null'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map RateLimitsNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnLimitLevelEntityIdIsNull() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        new RateLimitsNotificationInfo(
            TenantId.SYS_TENANT_ID,
            "Tenant Name",
            LimitedApi.ENTITY_EXPORT,
            null,
            "Limit Level Entity Name");

    // Act
    Map<String, String> actualTemplateData = rateLimitsNotificationInfo.getTemplateData();

    // Assert
    assertEquals(6, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("tenantId"));
    assertEquals("Limit Level Entity Name", actualTemplateData.get("limitLevelEntityName"));
    assertEquals("Tenant Name", actualTemplateData.get("tenantName"));
    assertEquals("entity version creation", actualTemplateData.get("api"));
    assertNull(actualTemplateData.get("limitLevelEntityId"));
    assertNull(actualTemplateData.get("limitLevelEntityType"));
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}, and {@link
   * RateLimitsNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfo rateLimitsNotificationInfo2 =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(rateLimitsNotificationInfo, rateLimitsNotificationInfo2);
    assertEquals(rateLimitsNotificationInfo.hashCode(), rateLimitsNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}, and {@link
   * RateLimitsNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(null)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfo rateLimitsNotificationInfo2 =
        RateLimitsNotificationInfo.builder()
            .api(null)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(rateLimitsNotificationInfo, rateLimitsNotificationInfo2);
    assertEquals(rateLimitsNotificationInfo.hashCode(), rateLimitsNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}, and {@link
   * RateLimitsNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(null)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfo rateLimitsNotificationInfo2 =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(null)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(rateLimitsNotificationInfo, rateLimitsNotificationInfo2);
    assertEquals(rateLimitsNotificationInfo.hashCode(), rateLimitsNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}, and {@link
   * RateLimitsNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfo rateLimitsNotificationInfo2 =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(rateLimitsNotificationInfo, rateLimitsNotificationInfo2);
    assertEquals(rateLimitsNotificationInfo.hashCode(), rateLimitsNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}, and {@link
   * RateLimitsNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(null)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfo rateLimitsNotificationInfo2 =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(null)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(rateLimitsNotificationInfo, rateLimitsNotificationInfo2);
    assertEquals(rateLimitsNotificationInfo.hashCode(), rateLimitsNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}, and {@link
   * RateLimitsNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName(null)
            .build();
    RateLimitsNotificationInfo rateLimitsNotificationInfo2 =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName(null)
            .build();

    // Act and Assert
    assertEquals(rateLimitsNotificationInfo, rateLimitsNotificationInfo2);
    assertEquals(rateLimitsNotificationInfo.hashCode(), rateLimitsNotificationInfo2.hashCode());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}, and {@link
   * RateLimitsNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#equals(Object)}
   *   <li>{@link RateLimitsNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(rateLimitsNotificationInfo, rateLimitsNotificationInfo);
    int expectedHashCodeResult = rateLimitsNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, rateLimitsNotificationInfo.hashCode());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(null)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsNotificationInfo,
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_IMPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsNotificationInfo,
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(null)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsNotificationInfo,
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RateLimitsNotificationInfoBuilder apiResult =
        RateLimitsNotificationInfo.builder().api(LimitedApi.ENTITY_EXPORT);
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        apiResult
            .limitLevel(new AlarmId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsNotificationInfo,
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Tenant Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsNotificationInfo,
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsNotificationInfo,
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RateLimitsNotificationInfoBuilder limitLevelEntityNameResult =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name");
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        limitLevelEntityNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsNotificationInfo,
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(null)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsNotificationInfo,
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Limit Level Entity Name")
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsNotificationInfo,
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RateLimitsNotificationInfo rateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName(null)
            .build();

    // Act and Assert
    assertNotEquals(
        rateLimitsNotificationInfo,
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build(),
        null);
  }

  /**
   * Test {@link RateLimitsNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link RateLimitsNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build(),
        "Different type to RateLimitsNotificationInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsNotificationInfo#RateLimitsNotificationInfo()}
   *   <li>{@link RateLimitsNotificationInfo#setApi(LimitedApi)}
   *   <li>{@link RateLimitsNotificationInfo#setLimitLevel(EntityId)}
   *   <li>{@link RateLimitsNotificationInfo#setLimitLevelEntityName(String)}
   *   <li>{@link RateLimitsNotificationInfo#setTenantId(TenantId)}
   *   <li>{@link RateLimitsNotificationInfo#setTenantName(String)}
   *   <li>{@link RateLimitsNotificationInfo#toString()}
   *   <li>{@link RateLimitsNotificationInfo#getAffectedTenantId()}
   *   <li>{@link RateLimitsNotificationInfo#getApi()}
   *   <li>{@link RateLimitsNotificationInfo#getLimitLevel()}
   *   <li>{@link RateLimitsNotificationInfo#getLimitLevelEntityName()}
   *   <li>{@link RateLimitsNotificationInfo#getTenantId()}
   *   <li>{@link RateLimitsNotificationInfo#getTenantName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RateLimitsNotificationInfo.<init>()",
    "void RateLimitsNotificationInfo.<init>(TenantId, String, LimitedApi, EntityId, String)",
    "TenantId RateLimitsNotificationInfo.getAffectedTenantId()",
    "LimitedApi RateLimitsNotificationInfo.getApi()",
    "EntityId RateLimitsNotificationInfo.getLimitLevel()",
    "String RateLimitsNotificationInfo.getLimitLevelEntityName()",
    "TenantId RateLimitsNotificationInfo.getTenantId()",
    "String RateLimitsNotificationInfo.getTenantName()",
    "void RateLimitsNotificationInfo.setApi(LimitedApi)",
    "void RateLimitsNotificationInfo.setLimitLevel(EntityId)",
    "void RateLimitsNotificationInfo.setLimitLevelEntityName(String)",
    "void RateLimitsNotificationInfo.setTenantId(TenantId)",
    "void RateLimitsNotificationInfo.setTenantName(String)",
    "String RateLimitsNotificationInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    RateLimitsNotificationInfo actualRateLimitsNotificationInfo = new RateLimitsNotificationInfo();
    actualRateLimitsNotificationInfo.setApi(LimitedApi.ENTITY_EXPORT);
    actualRateLimitsNotificationInfo.setLimitLevel(TenantId.SYS_TENANT_ID);
    actualRateLimitsNotificationInfo.setLimitLevelEntityName("Limit Level Entity Name");
    actualRateLimitsNotificationInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualRateLimitsNotificationInfo.setTenantName("Tenant Name");
    String actualToStringResult = actualRateLimitsNotificationInfo.toString();
    TenantId actualAffectedTenantId = actualRateLimitsNotificationInfo.getAffectedTenantId();
    LimitedApi actualApi = actualRateLimitsNotificationInfo.getApi();
    EntityId actualLimitLevel = actualRateLimitsNotificationInfo.getLimitLevel();
    String actualLimitLevelEntityName = actualRateLimitsNotificationInfo.getLimitLevelEntityName();
    TenantId actualTenantId = actualRateLimitsNotificationInfo.getTenantId();

    // Assert
    assertEquals("Limit Level Entity Name", actualLimitLevelEntityName);
    assertEquals(
        "RateLimitsNotificationInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, tenantName=Tenant Name,"
            + " api=ENTITY_EXPORT, limitLevel=13814000-1dd2-11b2-8080-808080808080, limitLevelEntityName=Limit Level"
            + " Entity Name)",
        actualToStringResult);
    assertEquals("Tenant Name", actualRateLimitsNotificationInfo.getTenantName());
    assertEquals(LimitedApi.ENTITY_EXPORT, actualApi);
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualLimitLevel);
    assertSame(tenantId, actualTenantId);
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
   *   <li>{@link RateLimitsNotificationInfo#RateLimitsNotificationInfo(TenantId, String,
   *       LimitedApi, EntityId, String)}
   *   <li>{@link RateLimitsNotificationInfo#setApi(LimitedApi)}
   *   <li>{@link RateLimitsNotificationInfo#setLimitLevel(EntityId)}
   *   <li>{@link RateLimitsNotificationInfo#setLimitLevelEntityName(String)}
   *   <li>{@link RateLimitsNotificationInfo#setTenantId(TenantId)}
   *   <li>{@link RateLimitsNotificationInfo#setTenantName(String)}
   *   <li>{@link RateLimitsNotificationInfo#toString()}
   *   <li>{@link RateLimitsNotificationInfo#getAffectedTenantId()}
   *   <li>{@link RateLimitsNotificationInfo#getApi()}
   *   <li>{@link RateLimitsNotificationInfo#getLimitLevel()}
   *   <li>{@link RateLimitsNotificationInfo#getLimitLevelEntityName()}
   *   <li>{@link RateLimitsNotificationInfo#getTenantId()}
   *   <li>{@link RateLimitsNotificationInfo#getTenantName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when SYS_TENANT_ID")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RateLimitsNotificationInfo.<init>()",
    "void RateLimitsNotificationInfo.<init>(TenantId, String, LimitedApi, EntityId, String)",
    "TenantId RateLimitsNotificationInfo.getAffectedTenantId()",
    "LimitedApi RateLimitsNotificationInfo.getApi()",
    "EntityId RateLimitsNotificationInfo.getLimitLevel()",
    "String RateLimitsNotificationInfo.getLimitLevelEntityName()",
    "TenantId RateLimitsNotificationInfo.getTenantId()",
    "String RateLimitsNotificationInfo.getTenantName()",
    "void RateLimitsNotificationInfo.setApi(LimitedApi)",
    "void RateLimitsNotificationInfo.setLimitLevel(EntityId)",
    "void RateLimitsNotificationInfo.setLimitLevelEntityName(String)",
    "void RateLimitsNotificationInfo.setTenantId(TenantId)",
    "void RateLimitsNotificationInfo.setTenantName(String)",
    "String RateLimitsNotificationInfo.toString()"
  })
  void testGettersAndSetters_whenSys_tenant_id() {
    // Arrange and Act
    RateLimitsNotificationInfo actualRateLimitsNotificationInfo =
        new RateLimitsNotificationInfo(
            TenantId.SYS_TENANT_ID,
            "Tenant Name",
            LimitedApi.ENTITY_EXPORT,
            TenantId.SYS_TENANT_ID,
            "Limit Level Entity Name");
    actualRateLimitsNotificationInfo.setApi(LimitedApi.ENTITY_EXPORT);
    actualRateLimitsNotificationInfo.setLimitLevel(TenantId.SYS_TENANT_ID);
    actualRateLimitsNotificationInfo.setLimitLevelEntityName("Limit Level Entity Name");
    actualRateLimitsNotificationInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualRateLimitsNotificationInfo.setTenantName("Tenant Name");
    String actualToStringResult = actualRateLimitsNotificationInfo.toString();
    TenantId actualAffectedTenantId = actualRateLimitsNotificationInfo.getAffectedTenantId();
    LimitedApi actualApi = actualRateLimitsNotificationInfo.getApi();
    EntityId actualLimitLevel = actualRateLimitsNotificationInfo.getLimitLevel();
    String actualLimitLevelEntityName = actualRateLimitsNotificationInfo.getLimitLevelEntityName();
    TenantId actualTenantId = actualRateLimitsNotificationInfo.getTenantId();

    // Assert
    assertEquals("Limit Level Entity Name", actualLimitLevelEntityName);
    assertEquals(
        "RateLimitsNotificationInfo(tenantId=13814000-1dd2-11b2-8080-808080808080, tenantName=Tenant Name,"
            + " api=ENTITY_EXPORT, limitLevel=13814000-1dd2-11b2-8080-808080808080, limitLevelEntityName=Limit Level"
            + " Entity Name)",
        actualToStringResult);
    assertEquals("Tenant Name", actualRateLimitsNotificationInfo.getTenantName());
    assertEquals(LimitedApi.ENTITY_EXPORT, actualApi);
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualLimitLevel);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test RateLimitsNotificationInfoBuilder {@link RateLimitsNotificationInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link RateLimitsNotificationInfoBuilder#build()}
   *   <li>{@link RateLimitsNotificationInfoBuilder#api(LimitedApi)}
   *   <li>{@link RateLimitsNotificationInfoBuilder#limitLevel(EntityId)}
   *   <li>{@link RateLimitsNotificationInfoBuilder#limitLevelEntityName(String)}
   *   <li>{@link RateLimitsNotificationInfoBuilder#tenantId(TenantId)}
   *   <li>{@link RateLimitsNotificationInfoBuilder#tenantName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test RateLimitsNotificationInfoBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void RateLimitsNotificationInfoBuilder.<init>()",
    "RateLimitsNotificationInfoBuilder RateLimitsNotificationInfoBuilder.api(LimitedApi)",
    "RateLimitsNotificationInfo RateLimitsNotificationInfoBuilder.build()",
    "RateLimitsNotificationInfoBuilder RateLimitsNotificationInfoBuilder.limitLevel(EntityId)",
    "RateLimitsNotificationInfoBuilder RateLimitsNotificationInfoBuilder.limitLevelEntityName(String)",
    "RateLimitsNotificationInfoBuilder RateLimitsNotificationInfoBuilder.tenantId(TenantId)",
    "RateLimitsNotificationInfoBuilder RateLimitsNotificationInfoBuilder.tenantName(String)",
    "String RateLimitsNotificationInfoBuilder.toString()"
  })
  void testRateLimitsNotificationInfoBuilderBuild() {
    // Arrange and Act
    RateLimitsNotificationInfo actualRateLimitsNotificationInfo =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Assert
    Map<String, String> templateData = actualRateLimitsNotificationInfo.getTemplateData();
    assertEquals(6, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("limitLevelEntityId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("tenantId"));
    assertEquals("Limit Level Entity Name", templateData.get("limitLevelEntityName"));
    assertEquals(
        "Limit Level Entity Name", actualRateLimitsNotificationInfo.getLimitLevelEntityName());
    assertEquals("Tenant Name", templateData.get("tenantName"));
    assertEquals("Tenant Name", actualRateLimitsNotificationInfo.getTenantName());
    assertEquals("Tenant", templateData.get("limitLevelEntityType"));
    assertEquals("entity version creation", templateData.get("api"));
    assertNull(actualRateLimitsNotificationInfo.getAffectedCustomerId());
    assertNull(actualRateLimitsNotificationInfo.getDashboardId());
    assertNull(actualRateLimitsNotificationInfo.getStateEntityId());
    assertNull(actualRateLimitsNotificationInfo.getAffectedUserId());
    assertEquals(LimitedApi.ENTITY_EXPORT, actualRateLimitsNotificationInfo.getApi());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualRateLimitsNotificationInfo.getAffectedTenantId());
    assertSame(tenantId, actualRateLimitsNotificationInfo.getLimitLevel());
    assertSame(tenantId, actualRateLimitsNotificationInfo.getTenantId());
  }
}
