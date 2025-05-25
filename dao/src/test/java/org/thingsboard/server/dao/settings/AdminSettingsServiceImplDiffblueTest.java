package org.thingsboard.server.dao.settings;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
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
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.DataValidator;

@ContextConfiguration(classes = {AdminSettingsServiceImpl.class})
@DisabledInAotMode
@RunWith(SpringJUnit4ClassRunner.class)
public class AdminSettingsServiceImplDiffblueTest {
  @MockBean
  private AdminSettingsDao adminSettingsDao;

  @Autowired
  private AdminSettingsServiceImpl adminSettingsServiceImpl;

  @MockBean
  private DataValidator<AdminSettings> dataValidator;

  /**
   * Test {@link AdminSettingsServiceImpl#findAdminSettingsById(TenantId, AdminSettingsId)}.
   * <p>
   * Method under test: {@link AdminSettingsServiceImpl#findAdminSettingsById(TenantId, AdminSettingsId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSettings AdminSettingsServiceImpl.findAdminSettingsById(TenantId, AdminSettingsId)"})
  public void testFindAdminSettingsById() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(adminSettings);

    // Act
    AdminSettings actualFindAdminSettingsByIdResult = adminSettingsServiceImpl.findAdminSettingsById(
        ModelConstants.SYSTEM_TENANT, new AdminSettingsId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));

    // Assert
    verify(adminSettingsDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(adminSettings, actualFindAdminSettingsByIdResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#findAdminSettingsById(TenantId, AdminSettingsId)}.
   * <ul>
   *   <li>Then calls {@link UUIDBased#getId()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsServiceImpl#findAdminSettingsById(TenantId, AdminSettingsId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSettings AdminSettingsServiceImpl.findAdminSettingsById(TenantId, AdminSettingsId)"})
  public void testFindAdminSettingsById_thenCallsGetId() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(adminSettings);
    AdminSettingsId adminSettingsId = mock(AdminSettingsId.class);
    when(adminSettingsId.getId()).thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    AdminSettings actualFindAdminSettingsByIdResult = adminSettingsServiceImpl
        .findAdminSettingsById(ModelConstants.SYSTEM_TENANT, adminSettingsId);

    // Assert
    verify(adminSettingsId, atLeast(1)).getId();
    verify(adminSettingsDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(adminSettings, actualFindAdminSettingsByIdResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#findAdminSettingsByKey(TenantId, String)}.
   * <ul>
   *   <li>Then return {@link AdminSettings#AdminSettings()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsServiceImpl#findAdminSettingsByKey(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSettings AdminSettingsServiceImpl.findAdminSettingsByKey(TenantId, String)"})
  public void testFindAdminSettingsByKey_thenReturnAdminSettings() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(adminSettings);

    // Act
    AdminSettings actualFindAdminSettingsByKeyResult = adminSettingsServiceImpl
        .findAdminSettingsByKey(ModelConstants.SYSTEM_TENANT, "Key");

    // Assert
    verify(adminSettingsDao).findByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertSame(adminSettings, actualFindAdminSettingsByKeyResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#findAdminSettingsByTenantIdAndKey(TenantId, String)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then return {@link AdminSettings#AdminSettings()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsServiceImpl#findAdminSettingsByTenantIdAndKey(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSettings AdminSettingsServiceImpl.findAdminSettingsByTenantIdAndKey(TenantId, String)"})
  public void testFindAdminSettingsByTenantIdAndKey_whenSystem_tenant_thenReturnAdminSettings() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(adminSettings);

    // Act
    AdminSettings actualFindAdminSettingsByTenantIdAndKeyResult = adminSettingsServiceImpl
        .findAdminSettingsByTenantIdAndKey(ModelConstants.SYSTEM_TENANT, "Key");

    // Assert
    verify(adminSettingsDao).findByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertSame(adminSettings, actualFindAdminSettingsByTenantIdAndKeyResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId, AdminSettings)}.
   * <ul>
   *   <li>Given {@link AdminSettingsDao} {@link AdminSettingsDao#findByTenantIdAndKey(UUID, String)} return {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId, AdminSettings)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSettings AdminSettingsServiceImpl.saveAdminSettings(TenantId, AdminSettings)"})
  public void testSaveAdminSettings_givenAdminSettingsDaoFindByTenantIdAndKeyReturnNull() {
    // Arrange
    when(adminSettingsDao.findByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(null);
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.save(Mockito.<TenantId>any(), Mockito.<AdminSettings>any())).thenReturn(adminSettings);
    when(dataValidator.validate(Mockito.<AdminSettings>any(), Mockito.<Function<AdminSettings, TenantId>>any()))
        .thenReturn(new AdminSettings());
    AdminSettings adminSettings2 = mock(AdminSettings.class);
    when(adminSettings2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(adminSettings2.getKey()).thenReturn("mail");

    // Act
    AdminSettings actualSaveAdminSettingsResult = adminSettingsServiceImpl
        .saveAdminSettings(ModelConstants.SYSTEM_TENANT, adminSettings2);

    // Assert
    verify(adminSettings2).getKey();
    verify(adminSettings2).getTenantId();
    verify(dataValidator).validate(isA(AdminSettings.class), isA(Function.class));
    verify(adminSettingsDao).findByTenantIdAndKey(isA(UUID.class), eq("mail"));
    verify(adminSettingsDao).save(isA(TenantId.class), isA(AdminSettings.class));
    assertSame(adminSettings, actualSaveAdminSettingsResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId, AdminSettings)}.
   * <ul>
   *   <li>Given {@code Key}.</li>
   *   <li>When {@link AdminSettings} {@link AdminSettings#getKey()} return {@code Key}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId, AdminSettings)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSettings AdminSettingsServiceImpl.saveAdminSettings(TenantId, AdminSettings)"})
  public void testSaveAdminSettings_givenKey_whenAdminSettingsGetKeyReturnKey() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.save(Mockito.<TenantId>any(), Mockito.<AdminSettings>any())).thenReturn(adminSettings);
    when(dataValidator.validate(Mockito.<AdminSettings>any(), Mockito.<Function<AdminSettings, TenantId>>any()))
        .thenReturn(new AdminSettings());
    AdminSettings adminSettings2 = mock(AdminSettings.class);
    when(adminSettings2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(adminSettings2.getKey()).thenReturn("Key");

    // Act
    AdminSettings actualSaveAdminSettingsResult = adminSettingsServiceImpl
        .saveAdminSettings(ModelConstants.SYSTEM_TENANT, adminSettings2);

    // Assert
    verify(adminSettings2).getKey();
    verify(adminSettings2).getTenantId();
    verify(dataValidator).validate(isA(AdminSettings.class), isA(Function.class));
    verify(adminSettingsDao).save(isA(TenantId.class), isA(AdminSettings.class));
    assertSame(adminSettings, actualSaveAdminSettingsResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId, AdminSettings)}.
   * <ul>
   *   <li>Then calls {@link AdminSettings#setTenantId(TenantId)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsServiceImpl#saveAdminSettings(TenantId, AdminSettings)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"AdminSettings AdminSettingsServiceImpl.saveAdminSettings(TenantId, AdminSettings)"})
  public void testSaveAdminSettings_thenCallsSetTenantId() {
    // Arrange
    AdminSettings adminSettings = new AdminSettings();
    when(adminSettingsDao.save(Mockito.<TenantId>any(), Mockito.<AdminSettings>any())).thenReturn(adminSettings);
    when(dataValidator.validate(Mockito.<AdminSettings>any(), Mockito.<Function<AdminSettings, TenantId>>any()))
        .thenReturn(new AdminSettings());
    AdminSettings adminSettings2 = mock(AdminSettings.class);
    when(adminSettings2.getTenantId()).thenReturn(null);
    doNothing().when(adminSettings2).setTenantId(Mockito.<TenantId>any());
    when(adminSettings2.getKey()).thenReturn("Key");

    // Act
    AdminSettings actualSaveAdminSettingsResult = adminSettingsServiceImpl
        .saveAdminSettings(ModelConstants.SYSTEM_TENANT, adminSettings2);

    // Assert
    verify(adminSettings2).getKey();
    verify(adminSettings2).getTenantId();
    verify(adminSettings2).setTenantId(isA(TenantId.class));
    verify(dataValidator).validate(isA(AdminSettings.class), isA(Function.class));
    verify(adminSettingsDao).save(isA(TenantId.class), isA(AdminSettings.class));
    assertSame(adminSettings, actualSaveAdminSettingsResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantIdAndKey(TenantId, String)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantIdAndKey(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminSettingsServiceImpl.deleteAdminSettingsByTenantIdAndKey(TenantId, String)"})
  public void testDeleteAdminSettingsByTenantIdAndKey_thenReturnFalse() {
    // Arrange
    when(adminSettingsDao.removeByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(false);

    // Act
    boolean actualDeleteAdminSettingsByTenantIdAndKeyResult = adminSettingsServiceImpl
        .deleteAdminSettingsByTenantIdAndKey(ModelConstants.SYSTEM_TENANT, "Key");

    // Assert
    verify(adminSettingsDao).removeByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertFalse(actualDeleteAdminSettingsByTenantIdAndKeyResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantIdAndKey(TenantId, String)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantIdAndKey(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AdminSettingsServiceImpl.deleteAdminSettingsByTenantIdAndKey(TenantId, String)"})
  public void testDeleteAdminSettingsByTenantIdAndKey_thenReturnTrue() {
    // Arrange
    when(adminSettingsDao.removeByTenantIdAndKey(Mockito.<UUID>any(), Mockito.<String>any())).thenReturn(true);

    // Act
    boolean actualDeleteAdminSettingsByTenantIdAndKeyResult = adminSettingsServiceImpl
        .deleteAdminSettingsByTenantIdAndKey(ModelConstants.SYSTEM_TENANT, "Key");

    // Assert
    verify(adminSettingsDao).removeByTenantIdAndKey(isA(UUID.class), eq("Key"));
    assertTrue(actualDeleteAdminSettingsByTenantIdAndKeyResult);
  }

  /**
   * Test {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantId(TenantId)}.
   * <ul>
   *   <li>When {@link ModelConstants#SYSTEM_TENANT}.</li>
   *   <li>Then calls {@link AdminSettingsDao#removeByTenantId(UUID)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link AdminSettingsServiceImpl#deleteAdminSettingsByTenantId(TenantId)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
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
