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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;

class ApiUsageLimitNotificationInfoDiffblueTest {
  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder#build()}
   *   <li>
   * {@link ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder#currentValue(String)}
   *   <li>
   * {@link ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder#feature(ApiFeature)}
   *   <li>
   * {@link ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder#limit(String)}
   *   <li>
   * {@link ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder#recordKey(ApiUsageRecordKey)}
   *   <li>
   * {@link ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder#status(ApiUsageStateValue)}
   *   <li>
   * {@link ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder#tenantId(TenantId)}
   *   <li>
   * {@link ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder#tenantName(String)}
   * </ul>
   */
  @Test
  void testApiUsageLimitNotificationInfoBuilderBuild() {
    // Arrange and Act
    ApiUsageLimitNotificationInfo actualBuildResult = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Assert
    Map<String, String> templateData = actualBuildResult.getTemplateData();
    assertEquals(7, templateData.size());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", templateData.get("tenantId"));
    TenantId affectedTenantId = actualBuildResult.getAffectedTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", affectedTenantId.getId().toString());
    assertEquals("42", templateData.get("currentValue"));
    assertEquals("42", actualBuildResult.getCurrentValue());
    assertEquals("Device API", templateData.get("feature"));
    assertEquals("Limit", templateData.get("limit"));
    assertEquals("Limit", actualBuildResult.getLimit());
    assertEquals("Tenant Name", templateData.get("tenantName"));
    assertEquals("Tenant Name", actualBuildResult.getTenantName());
    assertEquals("message", templateData.get("unitLabel"));
    assertNull(actualBuildResult.getAffectedCustomerId());
    assertNull(actualBuildResult.getDashboardId());
    assertNull(actualBuildResult.getStateEntityId());
    assertNull(actualBuildResult.getAffectedUserId());
    assertEquals(ApiFeature.TRANSPORT, actualBuildResult.getFeature());
    assertEquals(ApiUsageRecordKey.TRANSPORT_MSG_COUNT, actualBuildResult.getRecordKey());
    assertEquals(ApiUsageStateValue.ENABLED, actualBuildResult.getStatus());
    assertEquals(EntityType.TENANT, affectedTenantId.getEntityType());
    assertTrue(affectedTenantId.isNullUid());
    assertTrue(affectedTenantId.isSysTenantId());
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#getTemplateData()}
   */
  @Test
  void testGetTemplateData() {
    // Arrange
    ApiUsageLimitNotificationInfo buildResult = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act
    Map<String, String> actualTemplateData = buildResult.getTemplateData();

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
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ApiUsageLimitNotificationInfo buildResult = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder5.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder6 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder6.currentValue(Mockito.<String>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo buildResult2 = apiUsageLimitNotificationInfoBuilder6.currentValue("42")
        .feature(null)
        .limit(null)
        .recordKey(null)
        .status(null)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.tenantId(Mockito.<TenantId>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder6 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder6.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder5);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder6.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder7 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder7.currentValue(Mockito.<String>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo buildResult2 = apiUsageLimitNotificationInfoBuilder7.currentValue("42")
        .feature(null)
        .limit(null)
        .recordKey(null)
        .status(null)
        .tenantId(null)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult2);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult2.hashCode());
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ApiUsageLimitNotificationInfo buildResult = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertEquals(buildResult, buildResult);
    int expectedHashCodeResult = buildResult.hashCode();
    assertEquals(expectedHashCodeResult, buildResult.hashCode());
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.currentValue(Mockito.<String>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.feature(Mockito.<ApiFeature>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder2.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.feature(Mockito.<ApiFeature>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder2.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(null)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.limit(Mockito.<String>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder3.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(null)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder4.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(null)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder4.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(null)
        .limit("Limit")
        .recordKey(null)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder builderResult = ApiUsageLimitNotificationInfo
        .builder();
    builderResult.feature(ApiFeature.TRANSPORT);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.recordKey(Mockito.<ApiUsageRecordKey>any())).thenReturn(builderResult);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder4.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(null)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder5.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(null)
        .limit("Limit")
        .recordKey(null)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder5.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(null)
        .limit("Limit")
        .recordKey(null)
        .status(null)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder builderResult = ApiUsageLimitNotificationInfo
        .builder();
    builderResult.recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.status(Mockito.<ApiUsageStateValue>any())).thenReturn(builderResult);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder5.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(null)
        .limit("Limit")
        .recordKey(null)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder5.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(null)
        .limit(null)
        .recordKey(null)
        .status(null)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder builderResult = ApiUsageLimitNotificationInfo
        .builder();
    builderResult.status(ApiUsageStateValue.ENABLED);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.status(Mockito.<ApiUsageStateValue>any())).thenReturn(builderResult);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder5.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo buildResult2 = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(null)
        .limit("Limit")
        .recordKey(null)
        .status(null)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.tenantId(Mockito.<TenantId>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder6 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder6.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder5);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder6.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder7 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder7.currentValue(Mockito.<String>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo buildResult2 = apiUsageLimitNotificationInfoBuilder7.currentValue("42")
        .feature(null)
        .limit(null)
        .recordKey(null)
        .status(null)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder builderResult = ApiUsageLimitNotificationInfo
        .builder();
    builderResult.limit("Limit");
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder6 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder6.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder5);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder6.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder7 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder7.currentValue(Mockito.<String>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo buildResult2 = apiUsageLimitNotificationInfoBuilder7.currentValue("42")
        .feature(null)
        .limit(null)
        .recordKey(null)
        .status(null)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder builderResult = ApiUsageLimitNotificationInfo
        .builder();
    builderResult.currentValue("42");
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder6 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder6.currentValue(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder5);
    ApiUsageLimitNotificationInfo buildResult = apiUsageLimitNotificationInfoBuilder6.currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();
    ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder7 = mock(
        ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder7.currentValue(Mockito.<String>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfo buildResult2 = apiUsageLimitNotificationInfoBuilder7.currentValue("42")
        .feature(null)
        .limit(null)
        .recordKey(null)
        .status(null)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, buildResult2);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitNotificationInfo buildResult = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, null);
  }

  /**
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitNotificationInfo buildResult = ApiUsageLimitNotificationInfo.builder()
        .currentValue("42")
        .feature(ApiFeature.TRANSPORT)
        .limit("Limit")
        .recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT)
        .status(ApiUsageStateValue.ENABLED)
        .tenantId(TenantId.SYS_TENANT_ID)
        .tenantName("Tenant Name")
        .build();

    // Act and Assert
    assertNotEquals(buildResult, "Different type to ApiUsageLimitNotificationInfo");
  }

  /**
   * Methods under test:
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
  void testGettersAndSetters() {
    // Arrange and Act
    ApiUsageLimitNotificationInfo actualApiUsageLimitNotificationInfo = new ApiUsageLimitNotificationInfo();
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

    // Assert that nothing has changed
    assertEquals("42", actualCurrentValue);
    assertEquals("ApiUsageLimitNotificationInfo(feature=TRANSPORT, recordKey=TRANSPORT_MSG_COUNT, status=ENABLED,"
        + " limit=Limit, currentValue=42, tenantId=13814000-1dd2-11b2-8080-808080808080, tenantName=Tenant" + " Name)",
        actualToStringResult);
    assertEquals("Limit", actualLimit);
    assertEquals("Tenant Name", actualApiUsageLimitNotificationInfo.getTenantName());
    assertEquals(ApiFeature.TRANSPORT, actualFeature);
    assertEquals(ApiUsageRecordKey.TRANSPORT_MSG_COUNT, actualRecordKey);
    assertEquals(ApiUsageStateValue.ENABLED, actualStatus);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Methods under test:
   * <ul>
   *   <li>
   * {@link ApiUsageLimitNotificationInfo#ApiUsageLimitNotificationInfo(ApiFeature, ApiUsageRecordKey, ApiUsageStateValue, String, String, TenantId, String)}
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
  void testGettersAndSetters2() {
    // Arrange and Act
    ApiUsageLimitNotificationInfo actualApiUsageLimitNotificationInfo = new ApiUsageLimitNotificationInfo(
        ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, ApiUsageStateValue.ENABLED, "Limit", "42",
        TenantId.SYS_TENANT_ID, "Tenant Name");
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

    // Assert that nothing has changed
    assertEquals("42", actualCurrentValue);
    assertEquals("ApiUsageLimitNotificationInfo(feature=TRANSPORT, recordKey=TRANSPORT_MSG_COUNT, status=ENABLED,"
        + " limit=Limit, currentValue=42, tenantId=13814000-1dd2-11b2-8080-808080808080, tenantName=Tenant" + " Name)",
        actualToStringResult);
    assertEquals("Limit", actualLimit);
    assertEquals("Tenant Name", actualApiUsageLimitNotificationInfo.getTenantName());
    assertEquals(ApiFeature.TRANSPORT, actualFeature);
    assertEquals(ApiUsageRecordKey.TRANSPORT_MSG_COUNT, actualRecordKey);
    assertEquals(ApiUsageStateValue.ENABLED, actualStatus);
    TenantId tenantId = actualTenantId.SYS_TENANT_ID;
    assertSame(tenantId, actualAffectedTenantId);
    assertSame(tenantId, actualTenantId);
  }
}
