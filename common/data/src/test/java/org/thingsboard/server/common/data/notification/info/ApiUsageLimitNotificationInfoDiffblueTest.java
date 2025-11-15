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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.ApiUsageLimitNotificationInfo.ApiUsageLimitNotificationInfoBuilder;

@ContextConfiguration(classes = {ApiUsageLimitNotificationInfoBuilder.class})
@ExtendWith(SpringExtension.class)
class ApiUsageLimitNotificationInfoDiffblueTest {
  @Autowired
  private ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder;

  /**
   * Test ApiUsageLimitNotificationInfoBuilder {@link ApiUsageLimitNotificationInfoBuilder#build()}.
   * <p>
   * Methods under test:
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageLimitNotificationInfoBuilder.<init>()",
      "ApiUsageLimitNotificationInfo ApiUsageLimitNotificationInfoBuilder.build()",
      "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.currentValue(String)",
      "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.feature(ApiFeature)",
      "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.limit(String)",
      "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.recordKey(ApiUsageRecordKey)",
      "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.status(ApiUsageStateValue)",
      "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.tenantId(TenantId)",
      "ApiUsageLimitNotificationInfoBuilder ApiUsageLimitNotificationInfoBuilder.tenantName(String)",
      "String ApiUsageLimitNotificationInfoBuilder.toString()"})
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
   * Test {@link ApiUsageLimitNotificationInfo#getTemplateData()}.
   * <ul>
   *   <li>Then return size is seven.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#getTemplateData()}
   */
  @Test
  @DisplayName("Test getTemplateData(); then return size is seven")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map ApiUsageLimitNotificationInfo.getTemplateData()"})
  void testGetTemplateData_thenReturnSizeIsSeven() {
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}, and {@link ApiUsageLimitNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}, and {@link ApiUsageLimitNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder6 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}, and {@link ApiUsageLimitNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.tenantId(Mockito.<TenantId>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder6 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder7 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}, and {@link ApiUsageLimitNotificationInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#equals(Object)}
   *   <li>{@link ApiUsageLimitNotificationInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.feature(Mockito.<ApiFeature>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.feature(Mockito.<ApiFeature>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.limit(Mockito.<String>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder builderResult = ApiUsageLimitNotificationInfo.builder();
    builderResult.feature(ApiFeature.TRANSPORT);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.recordKey(Mockito.<ApiUsageRecordKey>any())).thenReturn(builderResult);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder builderResult = ApiUsageLimitNotificationInfo.builder();
    builderResult.recordKey(ApiUsageRecordKey.TRANSPORT_MSG_COUNT);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.status(Mockito.<ApiUsageStateValue>any())).thenReturn(builderResult);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder builderResult = ApiUsageLimitNotificationInfo.builder();
    builderResult.status(ApiUsageStateValue.ENABLED);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.status(Mockito.<ApiUsageStateValue>any())).thenReturn(builderResult);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.tenantId(Mockito.<TenantId>any()))
        .thenReturn(ApiUsageLimitNotificationInfo.builder());
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder6 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder7 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder builderResult = ApiUsageLimitNotificationInfo.builder();
    builderResult.limit("Limit");
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder6 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder7 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    ApiUsageLimitNotificationInfoBuilder builderResult = ApiUsageLimitNotificationInfo.builder();
    builderResult.currentValue("42");
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder.tenantId(Mockito.<TenantId>any())).thenReturn(builderResult);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder2 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder2.status(Mockito.<ApiUsageStateValue>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder3 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder3.recordKey(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder2);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder4 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder4.limit(Mockito.<String>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder3);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder5 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
    when(apiUsageLimitNotificationInfoBuilder5.feature(Mockito.<ApiFeature>any()))
        .thenReturn(apiUsageLimitNotificationInfoBuilder4);
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder6 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
    ApiUsageLimitNotificationInfoBuilder apiUsageLimitNotificationInfoBuilder7 = mock(
        ApiUsageLimitNotificationInfoBuilder.class);
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
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
   * Test {@link ApiUsageLimitNotificationInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ApiUsageLimitNotificationInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean ApiUsageLimitNotificationInfo.equals(Object)",
      "int ApiUsageLimitNotificationInfo.hashCode()"})
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
   * Test getters and setters.
   * <p>
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
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageLimitNotificationInfo.<init>()",
      "void ApiUsageLimitNotificationInfo.<init>(ApiFeature, ApiUsageRecordKey, ApiUsageStateValue, String, String, TenantId, String)",
      "TenantId ApiUsageLimitNotificationInfo.getAffectedTenantId()",
      "String ApiUsageLimitNotificationInfo.getCurrentValue()", "ApiFeature ApiUsageLimitNotificationInfo.getFeature()",
      "String ApiUsageLimitNotificationInfo.getLimit()",
      "ApiUsageRecordKey ApiUsageLimitNotificationInfo.getRecordKey()",
      "ApiUsageStateValue ApiUsageLimitNotificationInfo.getStatus()",
      "TenantId ApiUsageLimitNotificationInfo.getTenantId()", "String ApiUsageLimitNotificationInfo.getTenantName()",
      "void ApiUsageLimitNotificationInfo.setCurrentValue(String)",
      "void ApiUsageLimitNotificationInfo.setFeature(ApiFeature)",
      "void ApiUsageLimitNotificationInfo.setLimit(String)",
      "void ApiUsageLimitNotificationInfo.setRecordKey(ApiUsageRecordKey)",
      "void ApiUsageLimitNotificationInfo.setStatus(ApiUsageStateValue)",
      "void ApiUsageLimitNotificationInfo.setTenantId(TenantId)",
      "void ApiUsageLimitNotificationInfo.setTenantName(String)", "String ApiUsageLimitNotificationInfo.toString()"})
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

    // Assert
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
   * Test getters and setters.
   * <ul>
   *   <li>When {@code TRANSPORT}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ApiUsageLimitNotificationInfo#ApiUsageLimitNotificationInfo(ApiFeature, ApiUsageRecordKey, ApiUsageStateValue, String, String, TenantId, String)}
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
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void ApiUsageLimitNotificationInfo.<init>()",
      "void ApiUsageLimitNotificationInfo.<init>(ApiFeature, ApiUsageRecordKey, ApiUsageStateValue, String, String, TenantId, String)",
      "TenantId ApiUsageLimitNotificationInfo.getAffectedTenantId()",
      "String ApiUsageLimitNotificationInfo.getCurrentValue()", "ApiFeature ApiUsageLimitNotificationInfo.getFeature()",
      "String ApiUsageLimitNotificationInfo.getLimit()",
      "ApiUsageRecordKey ApiUsageLimitNotificationInfo.getRecordKey()",
      "ApiUsageStateValue ApiUsageLimitNotificationInfo.getStatus()",
      "TenantId ApiUsageLimitNotificationInfo.getTenantId()", "String ApiUsageLimitNotificationInfo.getTenantName()",
      "void ApiUsageLimitNotificationInfo.setCurrentValue(String)",
      "void ApiUsageLimitNotificationInfo.setFeature(ApiFeature)",
      "void ApiUsageLimitNotificationInfo.setLimit(String)",
      "void ApiUsageLimitNotificationInfo.setRecordKey(ApiUsageRecordKey)",
      "void ApiUsageLimitNotificationInfo.setStatus(ApiUsageStateValue)",
      "void ApiUsageLimitNotificationInfo.setTenantId(TenantId)",
      "void ApiUsageLimitNotificationInfo.setTenantName(String)", "String ApiUsageLimitNotificationInfo.toString()"})
  void testGettersAndSetters_whenTransport() {
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

    // Assert
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
