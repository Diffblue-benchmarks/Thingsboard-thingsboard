/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.common.data.notification.info;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder;

@ContextConfiguration(classes = {ApiUsageLimitNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class ApiUsageLimitNotificationInfoDiffblueTest {
  @Autowired private ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder;

  /**
   * Test ApiUsageLimitNotificationInfoBuilder {@link ApiUsageLimitNotificationInfoBuilder#build()}.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfoBuilder#build()}
   *   <li>{@link ApiUsageLimitNotificationInfoBuilder#currentValue(String)}
   *   <li>{@link ApiUsageLimitNotificationInfoBuilder#feature(ApiFeature)}
   *   <li>{@link ApiUsageLimitNotificationInfoBuilder#limit(String)}
   *   <li>{@link ApiUsageLimitNotificationInfoBuilder#recordKey(ApiUsageRecordKey)}
   *   <li>{@link ApiUsageLimitNotificationInfoBuilder#status(ApiUsageStateValue)}
   *   <li>{@link ApiUsageLimitNotificationInfoBuilder#tenantId(TenantId)}
   *   <li>{@link ApiUsageLimitNotificationInfoBuilder#tenantName(String)}
   * </ul>
   */
  @Test
  @DisplayName("Test ApiUsageLimitNotificationInfoBuilder build()")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ApiUsageLimitNotificationInfoBuilder.<init>()",
    "ApiUsageLimitNotificationInfo ApiUsageLimitNotificationInfoBuilder.build()",
    "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.currentValue(String)",
    "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.feature(ApiFeature)",
    "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.limit(String)",
    "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.recordKey(ApiUsageRecordKey)",
    "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.status(ApiUsageStateValue)",
    "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.tenantId(TenantId)",
    "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.tenantName(String)",
    "String ApiUsageLimitNotificationInfoBuilder.toString()"
  })
  void testApiUsageLimitNotificationInfoBuilderBuild() {
    // Arrange and Act
    ApiUsageLimitNotificationInfo actualApiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Assert
    Map<String, String> templateData = actualApiUsageLimitNotificationInfo.getTemplateData();
    assertEquals(7, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("tenantId"));
    assertEquals("42", templateData.get("currentValue"));
    assertEquals("42", actualApiUsageLimitNotificationInfo.getCurrentValue());
    assertEquals("Device API", templateData.get("feature"));
    assertEquals("Limit", templateData.get("limit"));
    assertEquals("Limit", actualApiUsageLimitNotificationInfo.getLimit());
    assertEquals("Tenant Name", templateData.get("tenantName"));
    assertEquals("Tenant Name", actualApiUsageLimitNotificationInfo.getTenantName());
    assertEquals("message", templateData.get("unitLabel"));
    assertNull(actualApiUsageLimitNotificationInfo.getAffectedCustomerId());
    assertNull(actualApiUsageLimitNotificationInfo.getDashboardId());
    assertNull(actualApiUsageLimitNotificationInfo.getStateEntityId());
    assertNull(actualApiUsageLimitNotificationInfo.getAffectedUserId());
    assertEquals(ApiFeature.TRANSPORT, actualApiUsageLimitNotificationInfo.getFeature());
    assertEquals(
        ApiUsageRecordKey.TRANSPORT_MSG_COUNT, actualApiUsageLimitNotificationInfo.getRecordKey());
    assertEquals(ApiUsageStateValue.ENABLED, actualApiUsageLimitNotificationInfo.getStatus());
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualApiUsageLimitNotificationInfo.getAffectedTenantId());
    assertSame(tenantId, actualApiUsageLimitNotificationInfo.getTenantId());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#getTemplateData()}.
   *
   * <ul>
   *   <li>Then return size is seven.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is seven")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"Map ApiUsageLimitNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsSeven() {
    // Arrange and Act
    Map<String, String> actualTemplateData =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build()
            .getTemplateData();

    // Assert
    assertEquals(7, actualTemplateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualTemplateData.get("tenantId"));
    assertEquals("42", actualTemplateData.get("currentValue"));
    assertEquals("Device API", actualTemplateData.get("feature"));
    assertEquals("Limit", actualTemplateData.get("limit"));
    assertEquals("Tenant Name", actualTemplateData.get("tenantName"));
    assertEquals("enabled", actualTemplateData.get("status"));
    assertEquals("message", actualTemplateData.get("unitLabel"));
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}, and {@link
   * ApiUsageLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo2 =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(apiUsageLimitNotificationInfo, apiUsageLimitNotificationInfo2);
    assertEquals(
        apiUsageLimitNotificationInfo.hashCode(), apiUsageLimitNotificationInfo2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}, and {@link
   * ApiUsageLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue(null)
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo2 =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue(null)
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(apiUsageLimitNotificationInfo, apiUsageLimitNotificationInfo2);
    assertEquals(
        apiUsageLimitNotificationInfo.hashCode(), apiUsageLimitNotificationInfo2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}, and {@link
   * ApiUsageLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(null)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo2 =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(null)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(apiUsageLimitNotificationInfo, apiUsageLimitNotificationInfo2);
    assertEquals(
        apiUsageLimitNotificationInfo.hashCode(), apiUsageLimitNotificationInfo2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}, and {@link
   * ApiUsageLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit(null)
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo2 =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit(null)
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(apiUsageLimitNotificationInfo, apiUsageLimitNotificationInfo2);
    assertEquals(
        apiUsageLimitNotificationInfo.hashCode(), apiUsageLimitNotificationInfo2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}, and {@link
   * ApiUsageLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(null)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo2 =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(null)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(apiUsageLimitNotificationInfo, apiUsageLimitNotificationInfo2);
    assertEquals(
        apiUsageLimitNotificationInfo.hashCode(), apiUsageLimitNotificationInfo2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}, and {@link
   * ApiUsageLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo2 =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(apiUsageLimitNotificationInfo, apiUsageLimitNotificationInfo2);
    assertEquals(
        apiUsageLimitNotificationInfo.hashCode(), apiUsageLimitNotificationInfo2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}, and {@link
   * ApiUsageLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(null)
            .tenantName("Tenant Name")
            .build();
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo2 =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(null)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(apiUsageLimitNotificationInfo, apiUsageLimitNotificationInfo2);
    assertEquals(
        apiUsageLimitNotificationInfo.hashCode(), apiUsageLimitNotificationInfo2.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}, and {@link
   * ApiUsageLimitNotificationInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertEquals(apiUsageLimitNotificationInfo, apiUsageLimitNotificationInfo);
    int expectedHashCodeResult = apiUsageLimitNotificationInfo.hashCode();
    assertEquals(expectedHashCodeResult, apiUsageLimitNotificationInfo.hashCode());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("Limit")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue(null)
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(null)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.DB)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("42")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit(null)
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(null)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_DP_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(null)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.WARNING)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(null)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Limit")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName(null)
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ApiUsageLimitNotificationInfo apiUsageLimitNotificationInfo =
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build();

    // Act and Assert
    assertNotEquals(
        apiUsageLimitNotificationInfo,
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(null)
            .tenantName("Tenant Name")
            .build());
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build(),
        null);
  }

  /**
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean ApiUsageLimitNotificationInfo.equals(Object)",
    "int ApiUsageLimitNotificationInfo.hashCode()"
  })
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        ApiUsageLimitNotificationInfo.builder()
            .currentValue("42")
            .feature(ApiFeature.TRANSPORT)
            .limit("Limit")
            .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
            .status(ApiUsageStateValue.ENABLED)
            .tenantId(TenantId.SYS_TENANT_ID)
            .tenantName("Tenant Name")
            .build(),
        "Different type to ApiUsageLimitNotificationInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#ApiUsageLimitNotificationInfo()}
   *   <li>{@link ApiUsageLimitNotificationInfo#setCurrentValue(String)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setFeature(ApiFeature)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setLimit(String)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setRecordKey(ApiUsageRecordKey)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setStatus(ApiUsageStateValue)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setTenantId(TenantId)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setTenantName(String)}
   *   <li>{@link ApiUsageLimitNotificationInfo#toString()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getAffectedTenantId()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getCurrentValue()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getFeature()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getLimit()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getRecordKey()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getStatus()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getTenantId()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getTenantName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ApiUsageLimitNotificationInfo.<init>()",
    "void ApiUsageLimitNotificationInfo.<init>(ApiFeature, ApiUsageRecordKey, ApiUsageStateValue, String, String, TenantId, String)",
    "TenantId ApiUsageLimitNotificationInfo.getAffectedTenantId()",
    "String ApiUsageLimitNotificationInfo.getCurrentValue()",
    "ApiFeature ApiUsageLimitNotificationInfo.getFeature()",
    "String ApiUsageLimitNotificationInfo.getLimit()",
    "ApiUsageRecordKey ApiUsageLimitNotificationInfo.getRecordKey()",
    "ApiUsageStateValue ApiUsageLimitNotificationInfo.getStatus()",
    "TenantId ApiUsageLimitNotificationInfo.getTenantId()",
    "String ApiUsageLimitNotificationInfo.getTenantName()",
    "void ApiUsageLimitNotificationInfo.setCurrentValue(String)",
    "void ApiUsageLimitNotificationInfo.setFeature(ApiFeature)",
    "void ApiUsageLimitNotificationInfo.setLimit(String)",
    "void ApiUsageLimitNotificationInfo.setRecordKey(ApiUsageRecordKey)",
    "void ApiUsageLimitNotificationInfo.setStatus(ApiUsageStateValue)",
    "void ApiUsageLimitNotificationInfo.setTenantId(TenantId)",
    "void ApiUsageLimitNotificationInfo.setTenantName(String)",
    "String ApiUsageLimitNotificationInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    ApiUsageLimitNotificationInfo actualApiUsageLimitNotificationInfo =
        new ApiUsageLimitNotificationInfo();
    actualApiUsageLimitNotificationInfo.setCurrentValue("42");
    actualApiUsageLimitNotificationInfo.setFeature(ApiFeature.TRANSPORT);
    actualApiUsageLimitNotificationInfo.setLimit("Limit");
    actualApiUsageLimitNotificationInfo.setRecordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT);
    actualApiUsageLimitNotificationInfo.setStatus(ApiUsageStateValue.ENABLED);
    actualApiUsageLimitNotificationInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualApiUsageLimitNotificationInfo.setTenantName("Tenant Name");
    String actualToStringResult = actualApiUsageLimitNotificationInfo.toString();
    TenantId actualAffectedTenantId = actualApiUsageLimitNotificationInfo.getAffectedTenantId();
    String actualCurrentValue = actualApiUsageLimitNotificationInfo.getCurrentValue();
    ApiFeature actualFeature = actualApiUsageLimitNotificationInfo.getFeature();
    String actualLimit = actualApiUsageLimitNotificationInfo.getLimit();
    ApiUsageRecordKey actualRecordKey = actualApiUsageLimitNotificationInfo.getRecordKey();
    ApiUsageStateValue actualStatus = actualApiUsageLimitNotificationInfo.getStatus();
    TenantId actualTenantId = actualApiUsageLimitNotificationInfo.getTenantId();

    // Assert
    assertEquals("42", actualCurrentValue);
    assertEquals(
        "ApiUsageLimitNotificationInfo(feature=TRANSPORT, recordKey=TRANSPORT_MSG_COUNT, status=ENABLED,"
            + " limit=Limit, currentValue=42, tenantId=13814000-1dd2-11b2-8080-808080808080, tenantName=Tenant"
            + " Name)",
        actualToStringResult);
    assertEquals("Limit", actualLimit);
    assertEquals("Tenant Name", actualApiUsageLimitNotificationInfo.getTenantName());
    assertEquals(ApiFeature.TRANSPORT, actualFeature);
    assertEquals(ApiUsageRecordKey.TRANSPORT_MSG_COUNT, actualRecordKey);
    assertEquals(ApiUsageStateValue.ENABLED, actualStatus);
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When {@code TRANSPORT}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#ApiUsageLimitNotificationInfo(ApiFeature,
   *       ApiUsageRecordKey, ApiUsageStateValue, String, String, TenantId, String)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setCurrentValue(String)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setFeature(ApiFeature)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setLimit(String)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setRecordKey(ApiUsageRecordKey)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setStatus(ApiUsageStateValue)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setTenantId(TenantId)}
   *   <li>{@link ApiUsageLimitNotificationInfo#setTenantName(String)}
   *   <li>{@link ApiUsageLimitNotificationInfo#toString()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getAffectedTenantId()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getCurrentValue()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getFeature()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getLimit()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getRecordKey()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getStatus()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getTenantId()}
   *   <li>{@link ApiUsageLimitNotificationInfo#getTenantName()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters; when 'TRANSPORT'")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ApiUsageLimitNotificationInfo.<init>()",
    "void ApiUsageLimitNotificationInfo.<init>(ApiFeature, ApiUsageRecordKey, ApiUsageStateValue, String, String, TenantId, String)",
    "TenantId ApiUsageLimitNotificationInfo.getAffectedTenantId()",
    "String ApiUsageLimitNotificationInfo.getCurrentValue()",
    "ApiFeature ApiUsageLimitNotificationInfo.getFeature()",
    "String ApiUsageLimitNotificationInfo.getLimit()",
    "ApiUsageRecordKey ApiUsageLimitNotificationInfo.getRecordKey()",
    "ApiUsageStateValue ApiUsageLimitNotificationInfo.getStatus()",
    "TenantId ApiUsageLimitNotificationInfo.getTenantId()",
    "String ApiUsageLimitNotificationInfo.getTenantName()",
    "void ApiUsageLimitNotificationInfo.setCurrentValue(String)",
    "void ApiUsageLimitNotificationInfo.setFeature(ApiFeature)",
    "void ApiUsageLimitNotificationInfo.setLimit(String)",
    "void ApiUsageLimitNotificationInfo.setRecordKey(ApiUsageRecordKey)",
    "void ApiUsageLimitNotificationInfo.setStatus(ApiUsageStateValue)",
    "void ApiUsageLimitNotificationInfo.setTenantId(TenantId)",
    "void ApiUsageLimitNotificationInfo.setTenantName(String)",
    "String ApiUsageLimitNotificationInfo.toString()"
  })
  void testGettersAndSetters_whenTransport() {
    // Arrange and Act
    ApiUsageLimitNotificationInfo actualApiUsageLimitNotificationInfo =
        new ApiUsageLimitNotificationInfo(
            ApiFeature.TRANSPORT,
            ApiUsageRecordKey.TRANSPORT_MSG_COUNT,
            ApiUsageStateValue.ENABLED,
            "Limit",
            "42",
            TenantId.SYS_TENANT_ID,
            "Tenant Name");
    actualApiUsageLimitNotificationInfo.setCurrentValue("42");
    actualApiUsageLimitNotificationInfo.setFeature(ApiFeature.TRANSPORT);
    actualApiUsageLimitNotificationInfo.setLimit("Limit");
    actualApiUsageLimitNotificationInfo.setRecordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT);
    actualApiUsageLimitNotificationInfo.setStatus(ApiUsageStateValue.ENABLED);
    actualApiUsageLimitNotificationInfo.setTenantId(TenantId.SYS_TENANT_ID);
    actualApiUsageLimitNotificationInfo.setTenantName("Tenant Name");
    String actualToStringResult = actualApiUsageLimitNotificationInfo.toString();
    TenantId actualAffectedTenantId = actualApiUsageLimitNotificationInfo.getAffectedTenantId();
    String actualCurrentValue = actualApiUsageLimitNotificationInfo.getCurrentValue();
    ApiFeature actualFeature = actualApiUsageLimitNotificationInfo.getFeature();
    String actualLimit = actualApiUsageLimitNotificationInfo.getLimit();
    ApiUsageRecordKey actualRecordKey = actualApiUsageLimitNotificationInfo.getRecordKey();
    ApiUsageStateValue actualStatus = actualApiUsageLimitNotificationInfo.getStatus();
    TenantId actualTenantId = actualApiUsageLimitNotificationInfo.getTenantId();

    // Assert
    assertEquals("42", actualCurrentValue);
    assertEquals(
        "ApiUsageLimitNotificationInfo(feature=TRANSPORT, recordKey=TRANSPORT_MSG_COUNT, status=ENABLED,"
            + " limit=Limit, currentValue=42, tenantId=13814000-1dd2-11b2-8080-808080808080, tenantName=Tenant"
            + " Name)",
        actualToStringResult);
    assertEquals("Limit", actualLimit);
    assertEquals("Tenant Name", actualApiUsageLimitNotificationInfo.getTenantName());
    assertEquals(ApiFeature.TRANSPORT, actualFeature);
    assertEquals(ApiUsageRecordKey.TRANSPORT_MSG_COUNT, actualRecordKey);
    assertEquals(ApiUsageStateValue.ENABLED, actualStatus);
    TenantId tenantId = TenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualTenantId);
  }
}
