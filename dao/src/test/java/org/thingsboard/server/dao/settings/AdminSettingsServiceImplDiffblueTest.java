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
package org.thingsboard.server.dao.settings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.BooleanNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import java.util.function.Function;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.id.AdminSettingsId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {AdminSettingsServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminSettingsServiceImplDiffblueTest {
  @MockBean private AdminSettingsDao adminSettingsDao;

  @Autowired private AdminSettingsServiceImpl adminSettingsServiceImpl;

  @MockBean private DataValidator<AdminSettings> dataValidator;

  /**
   * Test {@link AdminSettingsServiceImpl#findAdminSettingsById(TenantId, AdminSettingsId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link AdminSettingsId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsServiceImpl#findAdminSettingsById(TenantId,
   * AdminSettingsId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsServiceImpl.findAdminSettingsById(TenantId, AdminSettingsId)"
  })
  public void testFindAdminSettingsById_givenNull_uuid_thenCallsGetId() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(adminSettings);

    AdminSettingsId adminSettingsId = mock(AdminSettingsId.class);
    when(adminSettingsId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    AdminSettings actualFindAdminSettingsByIdResult =
        adminSettingsServiceImpl.findAdminSettingsById(
            ModelConstants.SYSTEM_TENANT, adminSettingsId);

    // Assert
    verify(adminSettingsId, atLeast(1)).getId();
    verify(adminSettingsDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(adminSettings, actualFindAdminSettingsByIdResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#findAdminSettingsById(TenantId, AdminSettingsId)}.
   *
   * <ul>
   *   <li>When {@link AdminSettingsId#AdminSettingsId(UUID)} with id is {@link
   *       ModelConstants#NULL_UUID}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsServiceImpl#findAdminSettingsById(TenantId,
   * AdminSettingsId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsServiceImpl.findAdminSettingsById(TenantId, AdminSettingsId)"
  })
  public void testFindAdminSettingsById_whenAdminSettingsIdWithIdIsNull_uuid() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenReturn(adminSettings);

    // Act
    AdminSettings actualFindAdminSettingsByIdResult =
        adminSettingsServiceImpl.findAdminSettingsById(
            ModelConstants.SYSTEM_TENANT, new AdminSettingsId(ModelConstants.NULL_UUID));

    // Assert
    verify(adminSettingsDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(adminSettings, actualFindAdminSettingsByIdResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#findAdminSettingsByKey(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@link AdminSettings#AdminSettings()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsServiceImpl#findAdminSettingsByKey(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsServiceImpl.findAdminSettingsByKey(TenantId, String)"
  })
  public void testFindAdminSettingsByKey_thenReturnAdminSettings() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    AdminSettings actualFindAdminSettingsByKeyResult =
        adminSettingsServiceImpl.findAdminSettingsByKey(ModelConstants.SYSTEM_TENANT, "Key");

    // Assert
    verify(adminSettingsDao).findByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertSame(adminSettings, actualFindAdminSettingsByKeyResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#findAdminSettingsByTenantIdAndKey(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSettingsServiceImpl#findAdminSettingsByTenantIdAndKey(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsServiceImpl.findAdminSettingsByTenantIdAndKey(TenantId, String)"
  })
  public void testFindAdminSettingsByTenantIdAndKey_givenNull_uuid_thenCallsGetId() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    AdminSettings actualFindAdminSettingsByTenantIdAndKeyResult =
        adminSettingsServiceImpl.findAdminSettingsByTenantIdAndKey(tenantId, "Key");

    // Assert
    verify(tenantId).getId();
    verify(adminSettingsDao).findByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertSame(adminSettings, actualFindAdminSettingsByTenantIdAndKeyResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#findAdminSettingsByTenantIdAndKey(TenantId, String)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then return {@link AdminSettings#AdminSettings()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSettingsServiceImpl#findAdminSettingsByTenantIdAndKey(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsServiceImpl.findAdminSettingsByTenantIdAndKey(TenantId, String)"
  })
  public void testFindAdminSettingsByTenantIdAndKey_whenSystem_tenant_thenReturnAdminSettings() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);

    // Act
    AdminSettings actualFindAdminSettingsByTenantIdAndKeyResult =
        adminSettingsServiceImpl.findAdminSettingsByTenantIdAndKey(
            ModelConstants.SYSTEM_TENANT, "Key");

    // Assert
    verify(adminSettingsDao).findByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertSame(adminSettings, actualFindAdminSettingsByTenantIdAndKeyResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId, AdminSettings)}.
   *
   * <p>Method under test: {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsServiceImpl.saveAdminSettings(TenantId, AdminSettings)"
  })
  public void testSaveAdminSettings() {
    // Arrange
    when(adminSettingsDao.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.save(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(adminSettings);
    when(dataValidator.validate(
            Mockito.<AdminSettings>any(), Mockito.<Function<AdminSettings, TenantId>>any()))
        .thenReturn(new AdminSettings());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode jsonValue = new ObjectNode(nc);
    jsonValue.put("password", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("tokenGenerated", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    AdminSettings adminSettings2 = new AdminSettings(new AdminSettings());
    adminSettings2.setKey("mail");
    adminSettings2.setJsonValue(jsonValue);
    adminSettings2.setTenantId(null);
    adminSettings2.setId(null);

    // Act
    AdminSettings actualSaveAdminSettingsResult =
        adminSettingsServiceImpl.saveAdminSettings(ModelConstants.SYSTEM_TENANT, adminSettings2);

    // Assert
    verify(dataValidator).validate(isA(AdminSettings.class), isA(Function.class));
    verify(adminSettingsDao).findByTenantIdAndKey(isA(UUID.class), eq("mail"));
    verify(adminSettingsDao).save(isA(TenantId.class), isA(AdminSettings.class));
    assertSame(adminSettings, actualSaveAdminSettingsResult);
    assertSame(TenantId.SYS_TENANT_ID, adminSettings2.getTenantId());
  }

  /**
   * Test {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId, AdminSettings)}.
   *
   * <p>Method under test: {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsServiceImpl.saveAdminSettings(TenantId, AdminSettings)"
  })
  public void testSaveAdminSettings2() {
    // Arrange
    when(adminSettingsDao.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.save(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(adminSettings);
    when(dataValidator.validate(
            Mockito.<AdminSettings>any(), Mockito.<Function<AdminSettings, TenantId>>any()))
        .thenReturn(new AdminSettings());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode jsonValue = new ObjectNode(nc);
    jsonValue.put("password", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("tokenGenerated", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    JsonNodeFactory nc2 = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode objectNode = new ObjectNode(nc2);
    objectNode.put("password", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("tokenGenerated", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    AdminSettings adminSettings2 = mock(AdminSettings.class);
    when(adminSettings2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(adminSettings2.getJsonValue()).thenReturn(objectNode);
    when(adminSettings2.getKey()).thenReturn("mail");
    doNothing().when(adminSettings2).setJsonValue(Mockito.<JsonNode>any());
    doNothing().when(adminSettings2).setKey(Mockito.<String>any());
    doNothing().when(adminSettings2).setTenantId(Mockito.<TenantId>any());
    doNothing().when(adminSettings2).setId(Mockito.<AdminSettingsId>any());
    adminSettings2.setKey("mail");
    adminSettings2.setJsonValue(jsonValue);
    adminSettings2.setTenantId(null);
    adminSettings2.setId(null);

    // Act
    AdminSettings actualSaveAdminSettingsResult =
        adminSettingsServiceImpl.saveAdminSettings(ModelConstants.SYSTEM_TENANT, adminSettings2);

    // Assert
    verify(adminSettings2).getJsonValue();
    verify(adminSettings2).getKey();
    verify(adminSettings2).getTenantId();
    verify(adminSettings2).setJsonValue(isA(JsonNode.class));
    verify(adminSettings2).setKey("mail");
    verify(adminSettings2).setTenantId(isNull());
    verify(adminSettings2).setId(isNull());
    verify(dataValidator).validate(isA(AdminSettings.class), isA(Function.class));
    verify(adminSettingsDao).findByTenantIdAndKey(isA(UUID.class), eq("mail"));
    verify(adminSettingsDao).save(isA(TenantId.class), isA(AdminSettings.class));
    assertSame(adminSettings, actualSaveAdminSettingsResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId, AdminSettings)}.
   *
   * <p>Method under test: {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsServiceImpl.saveAdminSettings(TenantId, AdminSettings)"
  })
  public void testSaveAdminSettings3() {
    // Arrange
    when(adminSettingsDao.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.save(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(adminSettings);
    when(dataValidator.validate(
            Mockito.<AdminSettings>any(), Mockito.<Function<AdminSettings, TenantId>>any()))
        .thenReturn(new AdminSettings());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode jsonValue = new ObjectNode(nc);
    jsonValue.put("password", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("tokenGenerated", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    ObjectNode objectNode = mock(ObjectNode.class);
    when(objectNode.get(Mockito.<String>any()))
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(objectNode.has(Mockito.<String>any())).thenReturn(true);
    when(objectNode.put(Mockito.<String>any(), Mockito.<JsonNode>any()))
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("password", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("tokenGenerated", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    AdminSettings adminSettings2 = mock(AdminSettings.class);
    when(adminSettings2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(adminSettings2.getJsonValue()).thenReturn(objectNode);
    when(adminSettings2.getKey()).thenReturn("mail");
    doNothing().when(adminSettings2).setJsonValue(Mockito.<JsonNode>any());
    doNothing().when(adminSettings2).setKey(Mockito.<String>any());
    doNothing().when(adminSettings2).setTenantId(Mockito.<TenantId>any());
    doNothing().when(adminSettings2).setId(Mockito.<AdminSettingsId>any());
    adminSettings2.setKey("mail");
    adminSettings2.setJsonValue(jsonValue);
    adminSettings2.setTenantId(null);
    adminSettings2.setId(null);

    // Act
    AdminSettings actualSaveAdminSettingsResult =
        adminSettingsServiceImpl.saveAdminSettings(ModelConstants.SYSTEM_TENANT, adminSettings2);

    // Assert
    verify(objectNode, atLeast(1)).has(Mockito.<String>any());
    verify(objectNode).get("enableOauth2");
    verify(objectNode, atLeast(1)).put(Mockito.<String>any(), isA(JsonNode.class));
    verify(adminSettings2).getJsonValue();
    verify(adminSettings2).getKey();
    verify(adminSettings2).getTenantId();
    verify(adminSettings2).setJsonValue(isA(JsonNode.class));
    verify(adminSettings2).setKey("mail");
    verify(adminSettings2).setTenantId(isNull());
    verify(adminSettings2).setId(isNull());
    verify(dataValidator).validate(isA(AdminSettings.class), isA(Function.class));
    verify(adminSettingsDao).findByTenantIdAndKey(isA(UUID.class), eq("mail"));
    verify(adminSettingsDao).save(isA(TenantId.class), isA(AdminSettings.class));
    assertSame(adminSettings, actualSaveAdminSettingsResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId, AdminSettings)}.
   *
   * <ul>
   *   <li>Given {@link AdminSettingsDao} {@link AdminSettingsDao#findByTenantIdAndKey(UUID,
   *       String)} return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsServiceImpl.saveAdminSettings(TenantId, AdminSettings)"
  })
  public void testSaveAdminSettings_givenAdminSettingsDaoFindByTenantIdAndKeyReturnNull() {
    // Arrange
    when(adminSettingsDao.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(null);
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.save(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(adminSettings);
    when(dataValidator.validate(
            Mockito.<AdminSettings>any(), Mockito.<Function<AdminSettings, TenantId>>any()))
        .thenReturn(new AdminSettings());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode jsonValue = new ObjectNode(nc);
    jsonValue.put("password", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("tokenGenerated", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    AdminSettings adminSettings2 = new AdminSettings(new AdminSettings());
    adminSettings2.setKey("mail");
    adminSettings2.setJsonValue(jsonValue);
    adminSettings2.setTenantId(null);
    adminSettings2.setId(null);

    // Act
    AdminSettings actualSaveAdminSettingsResult =
        adminSettingsServiceImpl.saveAdminSettings(ModelConstants.SYSTEM_TENANT, adminSettings2);

    // Assert
    verify(dataValidator).validate(isA(AdminSettings.class), isA(Function.class));
    verify(adminSettingsDao).findByTenantIdAndKey(isA(UUID.class), eq("mail"));
    verify(adminSettingsDao).save(isA(TenantId.class), isA(AdminSettings.class));
    assertSame(adminSettings, actualSaveAdminSettingsResult);
    assertSame(TenantId.SYS_TENANT_ID, adminSettings2.getTenantId());
  }

  /**
   * Test {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId, AdminSettings)}.
   *
   * <ul>
   *   <li>Given {@link ObjectNode} {@link ObjectNode#get(String)} return False.
   *   <li>Then calls {@link ObjectNode#has(String)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsServiceImpl.saveAdminSettings(TenantId, AdminSettings)"
  })
  public void testSaveAdminSettings_givenObjectNodeGetReturnFalse_thenCallsHas() {
    // Arrange
    when(adminSettingsDao.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.save(Mockito.<TenantId>any(), Mockito.<AdminSettings>any()))
        .thenReturn(adminSettings);
    when(dataValidator.validate(
            Mockito.<AdminSettings>any(), Mockito.<Function<AdminSettings, TenantId>>any()))
        .thenReturn(new AdminSettings());
    JsonNodeFactory nc = JsonNodeFactory.withExactBigDecimals(true);

    ObjectNode jsonValue = new ObjectNode(nc);
    jsonValue.put("password", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("tokenGenerated", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    jsonValue.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    ObjectNode objectNode = mock(ObjectNode.class);
    when(objectNode.get(Mockito.<String>any())).thenReturn(BooleanNode.getFalse());
    when(objectNode.has(Mockito.<String>any())).thenReturn(true);
    when(objectNode.put(Mockito.<String>any(), Mockito.<JsonNode>any()))
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("password", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("tokenGenerated", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("refreshToken", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    objectNode.put("refreshTokenExpires", CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);

    AdminSettings adminSettings2 = mock(AdminSettings.class);
    when(adminSettings2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(adminSettings2.getJsonValue()).thenReturn(objectNode);
    when(adminSettings2.getKey()).thenReturn("mail");
    doNothing().when(adminSettings2).setJsonValue(Mockito.<JsonNode>any());
    doNothing().when(adminSettings2).setKey(Mockito.<String>any());
    doNothing().when(adminSettings2).setTenantId(Mockito.<TenantId>any());
    doNothing().when(adminSettings2).setId(Mockito.<AdminSettingsId>any());
    adminSettings2.setKey("mail");
    adminSettings2.setJsonValue(jsonValue);
    adminSettings2.setTenantId(null);
    adminSettings2.setId(null);

    // Act
    AdminSettings actualSaveAdminSettingsResult =
        adminSettingsServiceImpl.saveAdminSettings(ModelConstants.SYSTEM_TENANT, adminSettings2);

    // Assert
    verify(objectNode, atLeast(1)).has(Mockito.<String>any());
    verify(objectNode).get("enableOauth2");
    verify(objectNode, atLeast(1)).put(Mockito.<String>any(), isA(JsonNode.class));
    verify(adminSettings2).getJsonValue();
    verify(adminSettings2).getKey();
    verify(adminSettings2).getTenantId();
    verify(adminSettings2).setJsonValue(isA(JsonNode.class));
    verify(adminSettings2).setKey("mail");
    verify(adminSettings2).setTenantId(isNull());
    verify(adminSettings2).setId(isNull());
    verify(dataValidator).validate(isA(AdminSettings.class), isA(Function.class));
    verify(adminSettingsDao).findByTenantIdAndKey(isA(UUID.class), eq("mail"));
    verify(adminSettingsDao).save(isA(TenantId.class), isA(AdminSettings.class));
    assertSame(adminSettings, actualSaveAdminSettingsResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantIdAndKey(TenantId, String)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSettingsServiceImpl#deleteAdminSettingsByTenantIdAndKey(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsServiceImpl.deleteAdminSettingsByTenantIdAndKey(TenantId, String)"
  })
  public void testDeleteAdminSettingsByTenantIdAndKey_givenNull_uuid_thenReturnTrue() {
    // Arrange
    when(adminSettingsDao.removeByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(true);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualDeleteAdminSettingsByTenantIdAndKeyResult =
        adminSettingsServiceImpl.deleteAdminSettingsByTenantIdAndKey(tenantId, "Key");

    // Assert
    verify(tenantId).getId();
    verify(adminSettingsDao).removeByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertTrue(actualDeleteAdminSettingsByTenantIdAndKeyResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantIdAndKey(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSettingsServiceImpl#deleteAdminSettingsByTenantIdAndKey(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsServiceImpl.deleteAdminSettingsByTenantIdAndKey(TenantId, String)"
  })
  public void testDeleteAdminSettingsByTenantIdAndKey_thenReturnFalse() {
    // Arrange
    when(adminSettingsDao.removeByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(false);

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    boolean actualDeleteAdminSettingsByTenantIdAndKeyResult =
        adminSettingsServiceImpl.deleteAdminSettingsByTenantIdAndKey(tenantId, "Key");

    // Assert
    verify(tenantId).getId();
    verify(adminSettingsDao).removeByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertFalse(actualDeleteAdminSettingsByTenantIdAndKeyResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantIdAndKey(TenantId, String)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link
   * AdminSettingsServiceImpl#deleteAdminSettingsByTenantIdAndKey(TenantId, String)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "boolean AdminSettingsServiceImpl.deleteAdminSettingsByTenantIdAndKey(TenantId, String)"
  })
  public void testDeleteAdminSettingsByTenantIdAndKey_thenReturnTrue() {
    // Arrange
    when(adminSettingsDao.removeByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any()))
        .thenReturn(true);

    // Act
    boolean actualDeleteAdminSettingsByTenantIdAndKeyResult =
        adminSettingsServiceImpl.deleteAdminSettingsByTenantIdAndKey(
            ModelConstants.SYSTEM_TENANT, "Key");

    // Assert
    verify(adminSettingsDao).removeByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertTrue(actualDeleteAdminSettingsByTenantIdAndKeyResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#NULL_UUID}.
   *   <li>Then calls {@link TenantId#getId()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSettingsServiceImpl.deleteAdminSettingsByTenantId(TenantId)"})
  public void testDeleteAdminSettingsByTenantId_givenNull_uuid_thenCallsGetId() {
    // Arrange
    doNothing().when(adminSettingsDao).removeByTenantId(Mockito.<UUID>any());

    TenantId tenantId = mock(TenantId.class);
    when(tenantId.getId()).thenReturn(ModelConstants.NULL_UUID);

    // Act
    adminSettingsServiceImpl.deleteAdminSettingsByTenantId(tenantId);

    // Assert
    verify(tenantId).getId();
    verify(adminSettingsDao).removeByTenantId(isA(UUID.class));
  }

  /**
   * Test {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantId(TenantId)}.
   *
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.
   *   <li>Then calls {@link AdminSettingsDao#removeByTenantId(UUID)}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantId(TenantId)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSettingsServiceImpl.deleteAdminSettingsByTenantId(TenantId)"})
  public void testDeleteAdminSettingsByTenantId_whenSystem_tenant_thenCallsRemoveByTenantId() {
    // Arrange
    doNothing().when(adminSettingsDao).removeByTenantId(Mockito.<UUID>any());

    // Act
    adminSettingsServiceImpl.deleteAdminSettingsByTenantId(ModelConstants.SYSTEM_TENANT);

    // Assert
    verify(adminSettingsDao).removeByTenantId(isA(UUID.class));
  }
}
