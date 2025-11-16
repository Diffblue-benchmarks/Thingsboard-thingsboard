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
package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.settings.AdminSettingsService;

@ContextConfiguration(classes = {AdminSettingsDataValidator.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminSettingsDataValidatorDiffblueTest {
  @Autowired private AdminSettingsDataValidator adminSettingsDataValidator;

  @MockBean private AdminSettingsService adminSettingsService;

  /**
   * Test {@link AdminSettingsDataValidator#validateCreate(TenantId, AdminSettings)} with {@code
   * TenantId}, {@code AdminSettings}.
   *
   * <p>Method under test: {@link AdminSettingsDataValidator#validateCreate(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSettingsDataValidator.validateCreate(TenantId, AdminSettings)"})
  public void testValidateCreateWithTenantIdAdminSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            adminSettingsDataValidator.validateCreate(
                ModelConstants.SYSTEM_TENANT, new AdminSettings()));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link AdminSettingsDataValidator#validateCreate(TenantId, AdminSettings)} with {@code
   * TenantId}, {@code AdminSettings}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsDataValidator#validateCreate(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSettingsDataValidator.validateCreate(TenantId, AdminSettings)"})
  public void testValidateCreateWithTenantIdAdminSettings_thenThrowDataValidationException() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(
            Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            adminSettingsDataValidator.validateCreate(
                ModelConstants.SYSTEM_TENANT, new AdminSettings()));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link AdminSettingsDataValidator#validateUpdate(TenantId, AdminSettings)} with {@code
   * TenantId}, {@code AdminSettings}.
   *
   * <p>Method under test: {@link AdminSettingsDataValidator#validateUpdate(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsDataValidator.validateUpdate(TenantId, AdminSettings)"
  })
  public void testValidateUpdateWithTenantIdAdminSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsById(
            Mockito.<TenantId>any(), Mockito.<AdminSettingsId>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            adminSettingsDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, new AdminSettings()));
    verify(adminSettingsService).findAdminSettingsById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link AdminSettingsDataValidator#validateUpdate(TenantId, AdminSettings)} with {@code
   * TenantId}, {@code AdminSettings}.
   *
   * <ul>
   *   <li>Given {@link AdminSettings#AdminSettings()} Key is {@code Key}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsDataValidator#validateUpdate(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsDataValidator.validateUpdate(TenantId, AdminSettings)"
  })
  public void testValidateUpdateWithTenantIdAdminSettings_givenAdminSettingsKeyIsKey() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setKey("Key");
    when(adminSettingsService.findAdminSettingsById(
            Mockito.<TenantId>any(), Mockito.<AdminSettingsId>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            adminSettingsDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, new AdminSettings()));
    verify(adminSettingsService).findAdminSettingsById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link AdminSettingsDataValidator#validateUpdate(TenantId, AdminSettings)} with {@code
   * TenantId}, {@code AdminSettings}.
   *
   * <ul>
   *   <li>Then calls {@link AdminSettings#getKey()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsDataValidator#validateUpdate(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsDataValidator.validateUpdate(TenantId, AdminSettings)"
  })
  public void testValidateUpdateWithTenantIdAdminSettings_thenCallsGetKey() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getKey()).thenThrow(new DataValidationException("An error occurred"));
    when(adminSettingsService.findAdminSettingsById(
            Mockito.<TenantId>any(), Mockito.<AdminSettingsId>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            adminSettingsDataValidator.validateUpdate(
                ModelConstants.SYSTEM_TENANT, new AdminSettings()));
    verify(adminSettings).getKey();
    verify(adminSettingsService).findAdminSettingsById(isA(TenantId.class), isNull());
  }

  /**
   * Test {@link AdminSettingsDataValidator#validateUpdate(TenantId, AdminSettings)} with {@code
   * TenantId}, {@code AdminSettings}.
   *
   * <ul>
   *   <li>Then return {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsDataValidator#validateUpdate(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "AdminSettings AdminSettingsDataValidator.validateUpdate(TenantId, AdminSettings)"
  })
  public void testValidateUpdateWithTenantIdAdminSettings_thenReturnNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsById(
            Mockito.<TenantId>any(), Mockito.<AdminSettingsId>any()))
        .thenReturn(null);

    // Act
    AdminSettings actualValidateUpdateResult =
        adminSettingsDataValidator.validateUpdate(
            ModelConstants.SYSTEM_TENANT, new AdminSettings());

    // Assert
    verify(adminSettingsService).findAdminSettingsById(isA(TenantId.class), isNull());
    assertNull(actualValidateUpdateResult);
  }

  /**
   * Test {@link AdminSettingsDataValidator#validateDataImpl(TenantId, AdminSettings)} with {@code
   * TenantId}, {@code AdminSettings}.
   *
   * <ul>
   *   <li>Then does not throw.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsDataValidator#validateDataImpl(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSettingsDataValidator.validateDataImpl(TenantId, AdminSettings)"})
  public void testValidateDataImplWithTenantIdAdminSettings_thenDoesNotThrow() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    adminSettings.setKey("Key");

    // Act and Assert
    adminSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, adminSettings);
  }

  /**
   * Test {@link AdminSettingsDataValidator#validateDataImpl(TenantId, AdminSettings)} with {@code
   * TenantId}, {@code AdminSettings}.
   *
   * <ul>
   *   <li>Then throw {@link DataValidationException}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsDataValidator#validateDataImpl(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSettingsDataValidator.validateDataImpl(TenantId, AdminSettings)"})
  public void testValidateDataImplWithTenantIdAdminSettings_thenThrowDataValidationException() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setKey("Key");

    // Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            adminSettingsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, adminSettings));
  }

  /**
   * Test {@link AdminSettingsDataValidator#validateDataImpl(TenantId, AdminSettings)} with {@code
   * TenantId}, {@code AdminSettings}.
   *
   * <ul>
   *   <li>When {@link AdminSettings#AdminSettings()}.
   * </ul>
   *
   * <p>Method under test: {@link AdminSettingsDataValidator#validateDataImpl(TenantId,
   * AdminSettings)}
   */
  @Test
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"void AdminSettingsDataValidator.validateDataImpl(TenantId, AdminSettings)"})
  public void testValidateDataImplWithTenantIdAdminSettings_whenAdminSettings() {
    // Arrange, Act and Assert
    assertThrows(
        DataValidationException.class,
        () ->
            adminSettingsDataValidator.validateDataImpl(
                ModelConstants.SYSTEM_TENANT, new AdminSettings()));
  }
}
