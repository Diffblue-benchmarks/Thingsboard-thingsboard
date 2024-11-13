package org.thingsboard.server.dao.service.validator;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.thingsboard.server.common.data.asset.AssetProfile;
import org.thingsboard.server.common.data.id.AssetProfileId;
import org.thingsboard.server.common.data.id.RuleChainId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.queue.Queue;
import org.thingsboard.server.common.data.rule.RuleChain;
import org.thingsboard.server.dao.asset.AssetProfileDao;
import org.thingsboard.server.dao.asset.AssetProfileService;
import org.thingsboard.server.dao.dashboard.DashboardService;
import org.thingsboard.server.dao.exception.DataValidationException;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.queue.QueueService;
import org.thingsboard.server.dao.rule.RuleChainService;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.usagerecord.ApiLimitService;

@ContextConfiguration(classes = {AssetProfileDataValidator.class})
@RunWith(SpringJUnit4ClassRunner.class)
@DisabledInAotMode
public class AssetProfileDataValidatorDiffblueTest {
  @MockBean
  private ApiLimitService apiLimitService;

  @MockBean
  private AssetProfileDao assetProfileDao;

  @Autowired
  private AssetProfileDataValidator assetProfileDataValidator;

  @MockBean
  private AssetProfileService assetProfileService;

  @MockBean
  private DashboardService dashboardService;

  @MockBean
  private QueueService queueService;

  @MockBean
  private RuleChainService ruleChainService;

  @MockBean
  private TenantService tenantService;

  /**
   * Test
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAssetProfile() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenThrow(new DataValidationException("An error occurred"));
    when(assetProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(assetProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile));
    verify(assetProfile).getName();
    verify(assetProfile, atLeast(1)).getTenantId();
    verify(assetProfile).isDefault();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAssetProfile2() {
    // Arrange
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(null);
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());
    when(ruleChainService.findRuleChainById(Mockito.<TenantId>any(), Mockito.<RuleChainId>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenReturn(true);
    when(assetProfile.getDefaultQueueName()).thenReturn("Default Queue Name");
    when(assetProfile.getDefaultRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    when(assetProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(assetProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile));
    verify(assetProfile, atLeast(1)).getDefaultQueueName();
    verify(assetProfile, atLeast(1)).getDefaultRuleChainId();
    verify(assetProfile).getName();
    verify(assetProfile, atLeast(1)).getTenantId();
    verify(assetProfile).isDefault();
    verify(assetProfileService).findDefaultAssetProfile(isA(TenantId.class));
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("Default Queue Name"));
    verify(ruleChainService).findRuleChainById(isA(TenantId.class), isA(RuleChainId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAssetProfile3() {
    // Arrange
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(null);
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenReturn(true);
    when(assetProfile.getDefaultQueueName()).thenReturn("Default Queue Name");
    when(assetProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(assetProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile));
    verify(assetProfile, atLeast(1)).getDefaultQueueName();
    verify(assetProfile).getName();
    verify(assetProfile, atLeast(1)).getTenantId();
    verify(assetProfile).isDefault();
    verify(assetProfileService).findDefaultAssetProfile(isA(TenantId.class));
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("Default Queue Name"));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAssetProfile4() {
    // Arrange
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(null);
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());
    when(ruleChainService.findRuleChainById(Mockito.<TenantId>any(), Mockito.<RuleChainId>any())).thenReturn(null);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenReturn(true);
    when(assetProfile.getDefaultQueueName()).thenReturn("Default Queue Name");
    when(assetProfile.getDefaultRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    when(assetProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(assetProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile));
    verify(assetProfile, atLeast(1)).getDefaultQueueName();
    verify(assetProfile, atLeast(1)).getDefaultRuleChainId();
    verify(assetProfile).getName();
    verify(assetProfile, atLeast(1)).getTenantId();
    verify(assetProfile).isDefault();
    verify(assetProfileService).findDefaultAssetProfile(isA(TenantId.class));
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("Default Queue Name"));
    verify(ruleChainService).findRuleChainById(isA(TenantId.class), isA(RuleChainId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAssetProfile5() {
    // Arrange
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(false);
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(assetProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile));
    verify(assetProfile).getName();
    verify(assetProfile, atLeast(1)).getTenantId();
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <ul>
   *   <li>Given {@code Asset profile name}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAssetProfile_givenAssetProfileName() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    assetProfile.setName("Asset profile name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile));
  }

  /**
   * Test
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <ul>
   *   <li>Given {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAssetProfile_givenFalse() {
    // Arrange
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(ruleChainService.findRuleChainById(Mockito.<TenantId>any(), Mockito.<RuleChainId>any())).thenReturn(ruleChain);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenReturn(false);
    when(assetProfile.getDefaultQueueName()).thenReturn("Default Queue Name");
    when(assetProfile.getDefaultDashboardId()).thenReturn(null);
    when(assetProfile.getDefaultRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    when(assetProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(assetProfile.getName()).thenReturn("Name");

    // Act
    assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile);

    // Assert
    verify(assetProfile).getDefaultDashboardId();
    verify(assetProfile, atLeast(1)).getDefaultQueueName();
    verify(assetProfile, atLeast(1)).getDefaultRuleChainId();
    verify(assetProfile).getName();
    verify(assetProfile, atLeast(1)).getTenantId();
    verify(assetProfile).isDefault();
    verify(ruleChain).getTenantId();
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("Default Queue Name"));
    verify(ruleChainService).findRuleChainById(isA(TenantId.class), isA(RuleChainId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <ul>
   *   <li>Then calls {@link AssetProfile#getDefaultDashboardId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAssetProfile_thenCallsGetDefaultDashboardId() {
    // Arrange
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(null);
    when(queueService.findQueueByTenantIdAndName(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(new Queue());
    RuleChain ruleChain = mock(RuleChain.class);
    when(ruleChain.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(ruleChainService.findRuleChainById(Mockito.<TenantId>any(), Mockito.<RuleChainId>any())).thenReturn(ruleChain);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.isDefault()).thenReturn(true);
    when(assetProfile.getDefaultQueueName()).thenReturn("Default Queue Name");
    when(assetProfile.getDefaultDashboardId()).thenReturn(null);
    when(assetProfile.getDefaultRuleChainId()).thenReturn(new RuleChainId(ModelConstants.NULL_UUID));
    when(assetProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(assetProfile.getName()).thenReturn("Name");

    // Act
    assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile);

    // Assert
    verify(assetProfile).getDefaultDashboardId();
    verify(assetProfile, atLeast(1)).getDefaultQueueName();
    verify(assetProfile, atLeast(1)).getDefaultRuleChainId();
    verify(assetProfile).getName();
    verify(assetProfile, atLeast(1)).getTenantId();
    verify(assetProfile).isDefault();
    verify(ruleChain).getTenantId();
    verify(assetProfileService).findDefaultAssetProfile(isA(TenantId.class));
    verify(queueService).findQueueByTenantIdAndName(isA(TenantId.class), eq("Default Queue Name"));
    verify(ruleChainService).findRuleChainById(isA(TenantId.class), isA(RuleChainId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <ul>
   *   <li>Then calls {@link AssetProfile#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAssetProfile_thenCallsGetId() {
    // Arrange
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(new AssetProfile());
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(assetProfile.isDefault()).thenReturn(true);
    when(assetProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(assetProfile.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile));
    verify(assetProfile).getId();
    verify(assetProfile).getName();
    verify(assetProfile, atLeast(1)).getTenantId();
    verify(assetProfile).isDefault();
    verify(assetProfileService).findDefaultAssetProfile(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <ul>
   *   <li>Then calls {@link AssetProfile#getId()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateDataImpl(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateDataImplWithTenantIdAssetProfile_thenCallsGetId2() {
    // Arrange
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(assetProfileService.findDefaultAssetProfile(Mockito.<TenantId>any())).thenReturn(assetProfile);
    when(tenantService.tenantExists(Mockito.<TenantId>any())).thenReturn(true);
    AssetProfile assetProfile2 = mock(AssetProfile.class);
    when(assetProfile2.getId()).thenThrow(new DataValidationException("An error occurred"));
    when(assetProfile2.isDefault()).thenReturn(true);
    when(assetProfile2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);
    when(assetProfile2.getName()).thenReturn("Name");

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileDataValidator.validateDataImpl(ModelConstants.SYSTEM_TENANT, assetProfile2));
    verify(assetProfile).getId();
    verify(assetProfile2).getName();
    verify(assetProfile2, atLeast(1)).getTenantId();
    verify(assetProfile2).isDefault();
    verify(assetProfileService).findDefaultAssetProfile(isA(TenantId.class));
    verify(tenantService).tenantExists(isA(TenantId.class));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateUpdate(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateUpdate(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdAssetProfile() {
    // Arrange
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(null);
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.getId()).thenReturn(new AssetProfileId(ModelConstants.NULL_UUID));
    when(assetProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, assetProfile));
    verify(assetProfile).getId();
    verify(assetProfile).getTenantId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateUpdate(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateUpdate(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdAssetProfile2() {
    // Arrange
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any()))
        .thenThrow(new DataValidationException("An error occurred"));
    AssetProfile assetProfile = mock(AssetProfile.class);
    when(assetProfile.getId()).thenReturn(new AssetProfileId(ModelConstants.NULL_UUID));
    when(assetProfile.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act and Assert
    assertThrows(DataValidationException.class,
        () -> assetProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT, assetProfile));
    verify(assetProfile).getId();
    verify(assetProfile).getTenantId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
  }

  /**
   * Test {@link AssetProfileDataValidator#validateUpdate(TenantId, AssetProfile)}
   * with {@code TenantId}, {@code AssetProfile}.
   * <ul>
   *   <li>Then return {@link AssetProfile#AssetProfile()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link AssetProfileDataValidator#validateUpdate(TenantId, AssetProfile)}
   */
  @Test
  public void testValidateUpdateWithTenantIdAssetProfile_thenReturnAssetProfile() {
    // Arrange
    AssetProfile assetProfile = new AssetProfile();
    when(assetProfileDao.findById(Mockito.<TenantId>any(), Mockito.<UUID>any())).thenReturn(assetProfile);
    AssetProfile assetProfile2 = mock(AssetProfile.class);
    when(assetProfile2.getId()).thenReturn(new AssetProfileId(ModelConstants.NULL_UUID));
    when(assetProfile2.getTenantId()).thenReturn(ModelConstants.SYSTEM_TENANT);

    // Act
    AssetProfile actualValidateUpdateResult = assetProfileDataValidator.validateUpdate(ModelConstants.SYSTEM_TENANT,
        assetProfile2);

    // Assert
    verify(assetProfile2).getId();
    verify(assetProfile2).getTenantId();
    verify(assetProfileDao).findById(isA(TenantId.class), isA(UUID.class));
    assertSame(assetProfile, actualValidateUpdateResult);
  }
}
