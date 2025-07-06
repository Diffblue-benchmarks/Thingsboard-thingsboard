package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RateLimitsNotificationInfo.getTemplateData()"})
  void testGetTemplateData() {
    // Arrange
    RateLimitsNotificationInfo buildResult =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act
    Map<String, String> actualTemplateData = buildResult.getTemplateData();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map RateLimitsNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnLimitLevelEntityIdIsNull() {
    // Arrange and Act
    Map<String, String> actualTemplateData =
        new RateLimitsNotificationInfo(
                TenantId.SYS_TENANT_ID,
                "Tenant Name",
                LimitedApi.ENTITY_EXPORT,
                null,
                "Limit Level Entity Name")
            .getTemplateData();

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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    RateLimitsNotificationInfo buildResult =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfo buildResult2 =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult =
        rateLimitsNotificationInfoBuilder
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult2 =
        rateLimitsNotificationInfoBuilder2
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfo buildResult =
        rateLimitsNotificationInfoBuilder2
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder3);
    RateLimitsNotificationInfo buildResult2 =
        rateLimitsNotificationInfoBuilder4
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder2);
    RateLimitsNotificationInfo buildResult =
        rateLimitsNotificationInfoBuilder3
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder5 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder5.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder4);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder6 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder6.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder5);
    RateLimitsNotificationInfo buildResult2 =
        rateLimitsNotificationInfoBuilder6
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    RateLimitsNotificationInfo buildResult =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult =
        rateLimitsNotificationInfoBuilder
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfo buildResult2 =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfoBuilder limitLevelEntityNameResult =
        rateLimitsNotificationInfoBuilder
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name");
    RateLimitsNotificationInfo buildResult =
        limitLevelEntityNameResult
            .tenantId(new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")))
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfo buildResult2 =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult =
        rateLimitsNotificationInfoBuilder
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(null)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfo buildResult2 =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult =
        rateLimitsNotificationInfoBuilder
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName(null)
            .build();
    RateLimitsNotificationInfo buildResult2 =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult =
        rateLimitsNotificationInfoBuilder
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("42")
            .build();
    RateLimitsNotificationInfo buildResult2 =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfo buildResult =
        rateLimitsNotificationInfoBuilder2
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.api(Mockito.<LimitedApi>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfo buildResult2 =
        rateLimitsNotificationInfoBuilder3
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder2);
    RateLimitsNotificationInfo buildResult =
        rateLimitsNotificationInfoBuilder3
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder5 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder5.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder4);
    RateLimitsNotificationInfo buildResult2 =
        rateLimitsNotificationInfoBuilder5
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    RateLimitsNotificationInfoBuilder builderResult = RateLimitsNotificationInfo.builder();
    builderResult.api(LimitedApi.ENTITY_EXPORT);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(builderResult);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder2);
    RateLimitsNotificationInfo buildResult =
        rateLimitsNotificationInfoBuilder3
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder5 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder5.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder4);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder6 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder6.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder5);
    RateLimitsNotificationInfo buildResult2 =
        rateLimitsNotificationInfoBuilder6
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    RateLimitsNotificationInfoBuilder builderResult = RateLimitsNotificationInfo.builder();
    builderResult.limitLevel(TenantId.SYS_TENANT_ID);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(builderResult);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder2);
    RateLimitsNotificationInfo buildResult =
        rateLimitsNotificationInfoBuilder3
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder5 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder5.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder4);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder6 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder6.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder5);
    RateLimitsNotificationInfo buildResult2 =
        rateLimitsNotificationInfoBuilder6
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    RateLimitsNotificationInfoBuilder builderResult = RateLimitsNotificationInfo.builder();
    builderResult.limitLevelEntityName("Tenant Name");
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(builderResult);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder2 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder2.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder3 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder3.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder2);
    RateLimitsNotificationInfo buildResult =
        rateLimitsNotificationInfoBuilder3
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder4 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder4.limitLevelEntityName(Mockito.<String>any()))
        .thenReturn(RateLimitsNotificationInfo.builder());
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder5 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder5.limitLevel(Mockito.<EntityId>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder4);
    RateLimitsNotificationInfoBuilder rateLimitsNotificationInfoBuilder6 =
        mock(RateLimitsNotificationInfoBuilder.class);
    when(rateLimitsNotificationInfoBuilder6.api(Mockito.<LimitedApi>any()))
        .thenReturn(rateLimitsNotificationInfoBuilder5);
    RateLimitsNotificationInfo buildResult2 =
        rateLimitsNotificationInfoBuilder6
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationInfo buildResult =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "boolean RateLimitsNotificationInfo.equals(Object)",
    "int RateLimitsNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    RateLimitsNotificationInfo buildResult =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to RateLimitsNotificationInfo");
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
  @Tag("MaintainedByDiffblue")
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
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
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
  @Tag("MaintainedByDiffblue")
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
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
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
  @Tag("MaintainedByDiffblue")
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
    RateLimitsNotificationInfo actualBuildResult =
        RateLimitsNotificationInfo.builder()
            .api(LimitedApi.ENTITY_EXPORT)
            .limitLevel(TenantId.SYS_TENANT_ID)
            .limitLevelEntityName("Limit Level Entity Name")
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Assert
    Map<String, String> templateData = actualBuildResult.getTemplateData();
    assertEquals(6, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("limitLevelEntityId"));
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("tenantId"));
    TenantId affectedTenantId = actualBuildResult.getAffectedTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", affectedTenantId.getId().toString());
    assertEquals("Limit Level Entity Name", templateData.get("limitLevelEntityName"));
    assertEquals("Limit Level Entity Name", actualBuildResult.getLimitLevelEntityName());
    assertEquals("Tenant Name", templateData.get("tenantName"));
    assertEquals("Tenant Name", actualBuildResult.getTenantName());
    assertEquals("Tenant", templateData.get("limitLevelEntityType"));
    assertEquals("entity version creation", templateData.get("api"));
    assertNull(actualBuildResult.getAffectedCustomerId());
    assertNull(actualBuildResult.getDashboardId());
    assertNull(actualBuildResult.getStateEntityId());
    assertNull(actualBuildResult.getAffectedUserId());
    assertEquals(EntityType.TENANT, affectedTenantId.getEntityType());
    assertEquals(LimitedApi.ENTITY_EXPORT, actualBuildResult.getApi());
    assertTrue(affectedTenantId.isNullUid());
    assertTrue(affectedTenantId.isSysTenantId());
  }
}
