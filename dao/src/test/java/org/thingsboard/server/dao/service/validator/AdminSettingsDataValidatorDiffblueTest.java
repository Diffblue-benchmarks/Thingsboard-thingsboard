package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.junit.Test;
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
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {AdminSettingsDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class AdminSettingsDataValidatorDiffblueTest {
  @Autowired
  private AdminSettingsDataValidator adminSettingsDataValidator;

  @MockBean
  private AdminSettingsService adminSettingsService;

  @MockBean
  private ApiLimitService apiLimitService;

  /**
   * Test
   * {@link AdminSettingsDataValidator#validateCreate(TenantId, AdminSettings)}
   * with {@code TenantId}, {@code AdminSettings}.
   * <p>
   * Method under test:
   * {@link AdminSettingsDataValidator#validateCreate(TenantId, AdminSettings)}
   */
  @Test
  public void testValidateCreateWithTenantIdAdminSettings() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(null);

    // Act
    adminSettingsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new AdminSettings());

    // Assert that nothing has changed
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link AdminSettingsDataValidator#validateCreate(TenantId, AdminSettings)}
   * with {@code TenantId}, {@code AdminSettings}.
   * <p>
   * Method under test:
   * {@link AdminSettingsDataValidator#validateCreate(TenantId, AdminSettings)}
   */
  @Test
  public void testValidateCreateWithTenantIdAdminSettings2() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenThrow(new DataValidationException("An error occurred"));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> adminSettingsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new AdminSettings()));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link AdminSettingsDataValidator#validateCreate(TenantId, AdminSettings)}
   * with {@code TenantId}, {@code AdminSettings}.
   * <ul>
   *   <li>Then throw {@link DataValidationException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSettingsDataValidator#validateCreate(TenantId, AdminSettings)}
   */
  @Test
  public void testValidateCreateWithTenantIdAdminSettings_thenThrowDataValidationException() {
    // Arrange
    when(adminSettingsService.findAdminSettingsByTenantIdAndKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new AdminSettings());

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> adminSettingsDataValidator.validateCreate(ModelConstants.SYSTEM_TENANT, new AdminSettings()));
    verify(adminSettingsService).findAdminSettingsByTenantIdAndKey(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link AdminSettingsDataValidator#validateUpdate(TenantId, AdminSettings)}
   * with {@code TenantId}, {@code AdminSettings}.
   * <ul>
   *   <li>Given {@link AdminSettings#AdminSettings()} Key is {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSettingsDataValidator#validateUpdate(TenantId, AdminSettings)}
   */
  @Test
  public void testValidateUpdateWithTenantIdAdminSettings_givenAdminSettingsKeyIsKey() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setKey("Key");
    when(adminSettingsService.findAdminSettingsById(Mockito.<TenantId>any(), Mockito.<AdminSettingsId>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> adminSettingsDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new AdminSettings()));
    verify(adminSettingsService).findAdminSettingsById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link AdminSettingsDataValidator#validateUpdate(TenantId, AdminSettings)}
   * with {@code TenantId}, {@code AdminSettings}.
   * <ul>
   *   <li>Then calls {@link AdminSettings#getKey()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSettingsDataValidator#validateUpdate(TenantId, AdminSettings)}
   */
  @Test
  public void testValidateUpdateWithTenantIdAdminSettings_thenCallsGetKey() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getKey()).thenThrow(new DataValidationException("An error occurred"));
    when(adminSettingsService.findAdminSettingsById(Mockito.<TenantId>any(), Mockito.<AdminSettingsId>any()))
        .thenReturn(adminSettings);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> adminSettingsDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, new AdminSettings()));
    verify(adminSettings).getKey();
    verify(adminSettingsService).findAdminSettingsById(isA(TenantId.class), isNull());
  }

  /**
   * Test
   * {@link AdminSettingsDataValidator#validateUpdate(TenantId, AdminSettings)}
   * with {@code TenantId}, {@code AdminSettings}.
   * <ul>
   *   <li>Then return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSettingsDataValidator#validateUpdate(TenantId, AdminSettings)}
   */
  @Test
  public void testValidateUpdateWithTenantIdAdminSettings_thenReturnNull() {
    // Arrange
    when(adminSettingsService.findAdminSettingsById(Mockito.<TenantId>any(), Mockito.<AdminSettingsId>any()))
        .thenReturn(null);

    // Act
    AdminSettings actualValidateUpdateResult = adminSettingsDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT,
        new AdminSettings());

    // Assert
    verify(adminSettingsService).findAdminSettingsById(isA(TenantId.class), isNull());
    assertNull(actualValidateUpdateResult);
  }

  /**
   * Test
   * {@link AdminSettingsDataValidator#validateDataImpl(TenantId, AdminSettings)}
   * with {@code TenantId}, {@code AdminSettings}.
   * <p>
   * Method under test:
   * {@link AdminSettingsDataValidator#validateDataImpl(TenantId, AdminSettings)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAdminSettings() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(adminSettings.getKey()).thenReturn("Key");

    // Act
    adminSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, adminSettings);

    // Assert that nothing has changed
    verify(adminSettings).getJsonValue();
    verify(adminSettings).getKey();
  }

  /**
   * Test
   * {@link AdminSettingsDataValidator#validateDataImpl(TenantId, AdminSettings)}
   * with {@code TenantId}, {@code AdminSettings}.
   * <p>
   * Method under test:
   * {@link AdminSettingsDataValidator#validateDataImpl(TenantId, AdminSettings)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAdminSettings2() {
    // Arrange
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenThrow(new DataValidationException("An error occurred"));
    when(adminSettings.getKey()).thenReturn("Key");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> adminSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, adminSettings));
    verify(adminSettings).getJsonValue();
    verify(adminSettings).getKey();
  }

  /**
   * Test
   * {@link AdminSettingsDataValidator#validateDataImpl(TenantId, AdminSettings)}
   * with {@code TenantId}, {@code AdminSettings}.
   * <ul>
   *   <li>When {@link AdminSettings#AdminSettings()} Key is {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AdminSettingsDataValidator#validateDataImpl(TenantId, AdminSettings)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAdminSettings_whenAdminSettingsKeyIsKey() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setKey("Key");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> adminSettingsDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, adminSettings));
  }
}
