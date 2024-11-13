package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.id.TenantProfileId;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.tenant.TenantProfileDao;
import org.thingsboard.server.dao.tenant.TenantProfileService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {TenantProfileDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class TenantProfileDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private TenantProfileDao tenantProfileDao;

  @Autowired
  private TenantProfileDataValidator tenantProfileDataValidator;

  @MockBean
  private TenantProfileService tenantProfileService;

  /**
   * Test
   * {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)}
   * with {@code TenantId}, {@code TenantProfile}.
   * <p>
   * Method under test:
   * {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTenantProfile() {
    // Arrange
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(tenantProfileService.findDefaultTenantProfile(Mockito.<TenantId>any())).thenReturn(tenantProfile);

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile tenantProfile2 = mock(TenantProfile.class);
    when(tenantProfile2.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(tenantProfile2.isDefault()).thenReturn(true);
    when(tenantProfile2.getProfileData()).thenReturn(tenantProfileData);
    when(tenantProfile2.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, tenantProfile2));
    verify(tenantProfile).getId();
    verify(tenantProfile2).getName();
    verify(tenantProfile2, atLeast(1)).getProfileData();
    verify(tenantProfile2).isDefault();
    verify(tenantProfileService).findDefaultTenantProfile(isA(TenantId.class));
  }

  /**
   * Test
   * {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)}
   * with {@code TenantId}, {@code TenantProfile}.
   * <ul>
   *   <li>Then calls {@link TenantProfileData#getConfiguration()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTenantProfile_thenCallsGetConfiguration() {
    // Arrange
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(null);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(tenantProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfile).getName();
    verify(tenantProfile, atLeast(1)).getProfileData();
    verify(tenantProfileData).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
  }

  /**
   * Test
   * {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)}
   * with {@code TenantId}, {@code TenantProfile}.
   * <ul>
   *   <li>Then calls {@link TenantProfile#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTenantProfile_thenCallsGetId() {
    // Arrange
    when(tenantProfileService.findDefaultTenantProfile(Mockito.<TenantId>any())).thenReturn(new TenantProfile());

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(tenantProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfile).getId();
    verify(tenantProfile).getName();
    verify(tenantProfile, atLeast(1)).getProfileData();
    verify(tenantProfile).isDefault();
    verify(tenantProfileService).findDefaultTenantProfile(isA(TenantId.class));
  }

  /**
   * Test
   * {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)}
   * with {@code TenantId}, {@code TenantProfile}.
   * <ul>
   *   <li>Then calls {@link TenantProfile#isIsolatedTbRuleEngine()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileDataValidator#validateDataImpl(TenantId, TenantProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdTenantProfile_thenCallsIsIsolatedTbRuleEngine() {
    // Arrange
    when(tenantProfileService.findDefaultTenantProfile(Mockito.<TenantId>any())).thenReturn(null);

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.isDefault()).thenReturn(true);
    when(tenantProfile.isIsolatedTbRuleEngine()).thenReturn(true);
    when(tenantProfile.getProfileData()).thenReturn(tenantProfileData);
    when(tenantProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfile).getName();
    verify(tenantProfile, atLeast(1)).getProfileData();
    verify(tenantProfile).isDefault();
    verify(tenantProfile).isIsolatedTbRuleEngine();
    verify(tenantProfileService).findDefaultTenantProfile(isA(TenantId.class));
  }

  /**
   * Test
   * {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)}
   * with {@code TenantId}, {@code TenantProfile}.
   * <p>
   * Method under test:
   * {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdTenantProfile() {
    // Arrange
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getId()).thenReturn(new TenantProfileId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfile).getId();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)}
   * with {@code TenantId}, {@code TenantProfile}.
   * <p>
   * Method under test:
   * {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdTenantProfile2() {
    // Arrange
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getId()).thenReturn(new TenantProfileId(ModelConstants.NULL_UUID));

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> tenantProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, tenantProfile));
    verify(tenantProfile).getId();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test
   * {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)}
   * with {@code TenantId}, {@code TenantProfile}.
   * <ul>
   *   <li>Then return {@link TenantProfile#TenantProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantProfileDataValidator#validateUpdate(TenantId, TenantProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdTenantProfile_thenReturnTenantProfile() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    when(tenantProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(tenantProfile);
    TenantProfile tenantProfile2 = mock(TenantProfile.class);
    when(tenantProfile2.getId()).thenReturn(new TenantProfileId(ModelConstants.NULL_UUID));

    // Act
    TenantProfile actualValidateUpdateResult = tenantProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT,
        tenantProfile2);

    // Assert
    verify(tenantProfile2).getId();
    verify(tenantProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(tenantProfile, actualValidateUpdateResult);
  }
}
