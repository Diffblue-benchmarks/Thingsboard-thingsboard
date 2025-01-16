package org.thingsboard.server.service.apiusage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.TenantProfileType;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;

@DisabledInAotMode
class TenantApiUsageStateDiffblueTest {
  @MockBean
  private TenantApiUsageState tenantApiUsageState;

  /**
   * Test
   * {@link TenantApiUsageState#TenantApiUsageState(TenantProfile, ApiUsageState)}.
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#TenantApiUsageState(TenantProfile, ApiUsageState)}
   */
  @Test
  @DisplayName("Test new TenantApiUsageState(TenantProfile, ApiUsageState)")
  void testNewTenantApiUsageState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    ApiUsageState apiUsageState = new ApiUsageState();

    // Act
    TenantApiUsageState actualTenantApiUsageState = new TenantApiUsageState(tenantProfile, apiUsageState);

    // Assert
    TenantProfileData tenantProfileData = actualTenantApiUsageState.getTenantProfileData();
    TenantProfileConfiguration configuration = tenantProfileData.getConfiguration();
    assertTrue(configuration instanceof DefaultTenantProfileConfiguration);
    assertNull(((DefaultTenantProfileConfiguration) configuration).getSmsEnabled());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCassandraQueryTenantRateLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getCustomerServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeEventRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimits());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getEdgeUplinkMessagesRateLimitsPerEdge());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityExportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantEntityImportRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsPerRuleRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantNotificationRequestsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTenantServerRestLimitsConfiguration());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceMsgRateLimit());
    assertNull(
        ((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayDeviceTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportGatewayTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryDataPointsRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getTransportTenantTelemetryMsgRateLimit());
    assertNull(((DefaultTenantProfileConfiguration) configuration).getWsUpdatesPerSessionRateLimit());
    assertNull(tenantProfileData.getQueueConfiguration());
    assertNull(actualTenantApiUsageState.getEntityId());
    assertNull(actualTenantApiUsageState.getTenantId());
    assertNull(actualTenantApiUsageState.getTenantProfileId());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getAlarmsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getDefaultStorageTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleNodeExecutionsPerMessage());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerCustomer());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerPublicUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerRegularUser());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSessionsPerTenant());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getQueueStatsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRpcTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getRuleEngineExceptionsTtlDays());
    assertEquals(0, ((DefaultTenantProfileConfiguration) configuration).getWsMsgQueueLimitPerSession());
    assertEquals(0, configuration.getMaxRuleNodeExecsPerMessage());
    assertEquals(0.0d, ((DefaultTenantProfileConfiguration) configuration).getWarnThreshold());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxAssets());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCreatedAlarms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxCustomers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDPStorageDays());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDashboards());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxDevices());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxEmails());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxJSExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxOtaPackagesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxREExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourceSize());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxResourcesInBytes());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxRuleChains());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxSms());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTbelExecutions());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportDataPoints());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxTransportMessages());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxUsers());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerCustomer());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerPublicUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerRegularUser());
    assertEquals(0L, ((DefaultTenantProfileConfiguration) configuration).getMaxWsSubscriptionsPerTenant());
    assertEquals(EntityType.TENANT, actualTenantApiUsageState.getEntityType());
    assertEquals(TenantProfileType.DEFAULT, configuration.getType());
    assertSame(apiUsageState, actualTenantApiUsageState.getApiUsageState());
  }

  /**
   * Test {@link TenantApiUsageState#TenantApiUsageState(ApiUsageState)}.
   * <ul>
   *   <li>Then return ApiUsageState is {@link ApiUsageState#ApiUsageState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#TenantApiUsageState(ApiUsageState)}
   */
  @Test
  @DisplayName("Test new TenantApiUsageState(ApiUsageState); then return ApiUsageState is ApiUsageState()")
  void testNewTenantApiUsageState_thenReturnApiUsageStateIsApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();

    // Act
    TenantApiUsageState actualTenantApiUsageState = new TenantApiUsageState(apiUsageState);

    // Assert
    assertNull(actualTenantApiUsageState.getEntityId());
    assertNull(actualTenantApiUsageState.getTenantId());
    assertNull(actualTenantApiUsageState.getTenantProfileId());
    assertNull(actualTenantApiUsageState.getTenantProfileData());
    assertEquals(EntityType.TENANT, actualTenantApiUsageState.getEntityType());
    assertSame(apiUsageState, actualTenantApiUsageState.getApiUsageState());
  }

  /**
   * Test
   * {@link TenantApiUsageState#TenantApiUsageState(TenantProfile, ApiUsageState)}.
   * <ul>
   *   <li>Then return TenantProfileData is {@link TenantProfileData} (default
   * constructor).</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#TenantApiUsageState(TenantProfile, ApiUsageState)}
   */
  @Test
  @DisplayName("Test new TenantApiUsageState(TenantProfile, ApiUsageState); then return TenantProfileData is TenantProfileData (default constructor)")
  void testNewTenantApiUsageState_thenReturnTenantProfileDataIsTenantProfileData() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());
    TenantProfile tenantProfile = mock(TenantProfile.class);
    when(tenantProfile.getId()).thenReturn(null);
    when(tenantProfile.getProfileData()).thenReturn(tenantProfileData);
    ApiUsageState apiUsageState = new ApiUsageState();

    // Act
    TenantApiUsageState actualTenantApiUsageState = new TenantApiUsageState(tenantProfile, apiUsageState);

    // Assert
    verify(tenantProfile).getId();
    verify(tenantProfile).getProfileData();
    assertNull(actualTenantApiUsageState.getEntityId());
    assertNull(actualTenantApiUsageState.getTenantId());
    assertNull(actualTenantApiUsageState.getTenantProfileId());
    assertEquals(EntityType.TENANT, actualTenantApiUsageState.getEntityType());
    assertSame(apiUsageState, actualTenantApiUsageState.getApiUsageState());
    assertSame(tenantProfileData, actualTenantApiUsageState.getTenantProfileData());
  }

  /**
   * Test {@link TenantApiUsageState#TenantApiUsageState(ApiUsageState)}.
   * <ul>
   *   <li>When {@link ApiUsageState}.</li>
   *   <li>Then return {@link ApiUsageState}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#TenantApiUsageState(ApiUsageState)}
   */
  @Test
  @DisplayName("Test new TenantApiUsageState(ApiUsageState); when ApiUsageState; then return ApiUsageState")
  void testNewTenantApiUsageState_whenApiUsageState_thenReturnApiUsageState() {
    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);

    // Act
    TenantApiUsageState actualTenantApiUsageState = new TenantApiUsageState(apiUsageState);

    // Assert
    assertNull(actualTenantApiUsageState.getEntityId());
    assertNull(actualTenantApiUsageState.getTenantId());
    assertNull(actualTenantApiUsageState.getTenantProfileId());
    assertNull(actualTenantApiUsageState.getTenantProfileData());
    assertEquals(EntityType.TENANT, actualTenantApiUsageState.getEntityType());
    assertSame(apiUsageState, actualTenantApiUsageState.getApiUsageState());
  }

  /**
   * Test {@link TenantApiUsageState#getProfileThreshold(ApiUsageRecordKey)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#getProfileThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileThreshold(ApiUsageRecordKey); then return zero")
  void testGetProfileThreshold_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(new ApiUsageState());
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act and Assert
    assertEquals(0L, tenantApiUsageState.getProfileThreshold(ApiUsageRecordKey.TRANSPORT_MSG_COUNT));
  }

  /**
   * Test {@link TenantApiUsageState#getProfileFeatureEnabled(ApiUsageRecordKey)}.
   * <ul>
   *   <li>Then return {@code false}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#getProfileFeatureEnabled(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileFeatureEnabled(ApiUsageRecordKey); then return 'false'")
  void testGetProfileFeatureEnabled_thenReturnFalse() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(false);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(new ApiUsageState());
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act
    boolean actualProfileFeatureEnabled = tenantApiUsageState
        .getProfileFeatureEnabled(ApiUsageRecordKey.TRANSPORT_MSG_COUNT);

    // Assert
    verify(defaultTenantProfileConfiguration).getProfileFeatureEnabled(eq(ApiUsageRecordKey.TRANSPORT_MSG_COUNT));
    verify(tenantProfileData).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertFalse(actualProfileFeatureEnabled);
  }

  /**
   * Test {@link TenantApiUsageState#getProfileFeatureEnabled(ApiUsageRecordKey)}.
   * <ul>
   *   <li>Then return {@code true}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#getProfileFeatureEnabled(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileFeatureEnabled(ApiUsageRecordKey); then return 'true'")
  void testGetProfileFeatureEnabled_thenReturnTrue() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(new ApiUsageState());
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act and Assert
    assertTrue(tenantApiUsageState.getProfileFeatureEnabled(ApiUsageRecordKey.TRANSPORT_MSG_COUNT));
  }

  /**
   * Test {@link TenantApiUsageState#getProfileWarnThreshold(ApiUsageRecordKey)}.
   * <ul>
   *   <li>Then return zero.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#getProfileWarnThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileWarnThreshold(ApiUsageRecordKey); then return zero")
  void testGetProfileWarnThreshold_thenReturnZero() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(new ApiUsageState());
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act and Assert
    assertEquals(0L, tenantApiUsageState.getProfileWarnThreshold(ApiUsageRecordKey.TRANSPORT_MSG_COUNT));
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with
   * {@code features}.
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'")
  void testCheckStateUpdatedDueToThresholdWithFeatures() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(mock(ApiUsageState.class));

    // Act and Assert
    assertTrue(tenantApiUsageState.checkStateUpdatedDueToThreshold(new HashSet<>()).isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with
   * {@code features}.
   * <ul>
   *   <li>Given {@code RE}.</li>
   *   <li>Then calls {@link ApiUsageState#getReExecState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'; given 'RE'; then calls getReExecState()")
  void testCheckStateUpdatedDueToThresholdWithFeatures_givenRe_thenCallsGetReExecState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setReExecState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any())).thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.RE);
    features.add(ApiFeature.DB);
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult = tenantApiUsageState
        .checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setReExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with
   * {@code features}.
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getAlarmExecState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'; then calls getAlarmExecState()")
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenCallsGetAlarmExecState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getAlarmExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setAlarmExecState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any())).thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.ALARM);
    features.add(ApiFeature.DB);
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult = tenantApiUsageState
        .checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getAlarmExecState();
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).setAlarmExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with
   * {@code features}.
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getEmailExecState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'; then calls getEmailExecState()")
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenCallsGetEmailExecState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setEmailExecState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any())).thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.EMAIL);
    features.add(ApiFeature.DB);
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult = tenantApiUsageState
        .checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setEmailExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with
   * {@code features}.
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getJsExecState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'; then calls getJsExecState()")
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenCallsGetJsExecState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setJsExecState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any())).thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.JS);
    features.add(ApiFeature.DB);
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult = tenantApiUsageState
        .checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setJsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with
   * {@code features}.
   * <ul>
   *   <li>Then calls
   * {@link DefaultTenantProfileConfiguration#getProfileThreshold(ApiUsageRecordKey)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'; then calls getProfileThreshold(ApiUsageRecordKey)")
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenCallsGetProfileThreshold() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any())).thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.DB);
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult = tenantApiUsageState
        .checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with
   * {@code features}.
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getSmsExecState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'; then calls getSmsExecState()")
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenCallsGetSmsExecState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getSmsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setSmsExecState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any())).thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.SMS);
    features.add(ApiFeature.DB);
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult = tenantApiUsageState
        .checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getSmsExecState();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setSmsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with
   * {@code features}.
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getTbelExecState()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'; then calls getTbelExecState()")
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenCallsGetTbelExecState() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setTbelExecState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any())).thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.TBEL);
    features.add(ApiFeature.DB);
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult = tenantApiUsageState
        .checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTbelExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with
   * {@code features}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'; then return size is one")
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.WARNING);
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any())).thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.DB);
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult = tenantApiUsageState
        .checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertEquals(1, actualCheckStateUpdatedDueToThresholdResult.size());
    assertEquals(ApiUsageStateValue.ENABLED, actualCheckStateUpdatedDueToThresholdResult.get(ApiFeature.TRANSPORT));
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with
   * {@code features}.
   * <ul>
   *   <li>Then return size is two.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'; then return size is two")
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenReturnSizeIsTwo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getTransportState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(false);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.DB);
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult = tenantApiUsageState
        .checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getTransportState();
    verify(apiUsageState).setDbStorageState(eq(ApiUsageStateValue.DISABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.DISABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertEquals(2, actualCheckStateUpdatedDueToThresholdResult.size());
    assertEquals(ApiUsageStateValue.DISABLED, actualCheckStateUpdatedDueToThresholdResult.get(ApiFeature.DB));
    assertEquals(ApiUsageStateValue.DISABLED, actualCheckStateUpdatedDueToThresholdResult.get(ApiFeature.TRANSPORT));
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with
   * {@code features}.
   * <ul>
   *   <li>When {@link HashSet#HashSet()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'; when HashSet()")
  void testCheckStateUpdatedDueToThresholdWithFeatures_whenHashSet() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(new ApiUsageState());

    // Act and Assert
    assertTrue(tenantApiUsageState.checkStateUpdatedDueToThreshold(new HashSet<>()).isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}.
   * <ul>
   *   <li>Then return Empty.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThresholds(); then return Empty")
  void testCheckStateUpdatedDueToThresholds_thenReturnEmpty() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageState.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageState.setJsExecState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any())).thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdsResult = tenantApiUsageState
        .checkStateUpdatedDueToThresholds();

    // Assert
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    ApiUsageState apiUsageState2 = tenantApiUsageState.getApiUsageState();
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getAlarmExecState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getDbStorageState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getEmailExecState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getJsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getReExecState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getSmsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getTbelExecState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getTransportState());
    assertTrue(actualCheckStateUpdatedDueToThresholdsResult.isEmpty());
    assertTrue(apiUsageState2.isAlarmCreationEnabled());
    assertTrue(apiUsageState2.isDbStorageEnabled());
    assertTrue(apiUsageState2.isEmailSendEnabled());
    assertTrue(apiUsageState2.isJsExecEnabled());
    assertTrue(apiUsageState2.isReExecEnabled());
    assertTrue(apiUsageState2.isSmsSendEnabled());
    assertTrue(apiUsageState2.isTbelExecEnabled());
    assertTrue(apiUsageState2.isTransportEnabled());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}.
   * <ul>
   *   <li>Then return size is eight.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThresholds(); then return size is eight")
  void testCheckStateUpdatedDueToThresholds_thenReturnSizeIsEight() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageState.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageState.setJsExecState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(false);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdsResult = tenantApiUsageState
        .checkStateUpdatedDueToThresholds();

    // Assert
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertEquals(8, actualCheckStateUpdatedDueToThresholdsResult.size());
    assertEquals(ApiUsageStateValue.DISABLED, actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.ALARM));
    assertEquals(ApiUsageStateValue.DISABLED, actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.DB));
    assertEquals(ApiUsageStateValue.DISABLED, actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.EMAIL));
    assertEquals(ApiUsageStateValue.DISABLED, actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.JS));
    assertEquals(ApiUsageStateValue.DISABLED, actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.RE));
    assertEquals(ApiUsageStateValue.DISABLED, actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.SMS));
    assertEquals(ApiUsageStateValue.DISABLED, actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.TBEL));
    assertEquals(ApiUsageStateValue.DISABLED, actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.TRANSPORT));
    ApiUsageState apiUsageState2 = tenantApiUsageState.getApiUsageState();
    assertEquals(ApiUsageStateValue.DISABLED, apiUsageState2.getAlarmExecState());
    assertEquals(ApiUsageStateValue.DISABLED, apiUsageState2.getDbStorageState());
    assertEquals(ApiUsageStateValue.DISABLED, apiUsageState2.getEmailExecState());
    assertEquals(ApiUsageStateValue.DISABLED, apiUsageState2.getJsExecState());
    assertEquals(ApiUsageStateValue.DISABLED, apiUsageState2.getReExecState());
    assertEquals(ApiUsageStateValue.DISABLED, apiUsageState2.getSmsExecState());
    assertEquals(ApiUsageStateValue.DISABLED, apiUsageState2.getTbelExecState());
    assertEquals(ApiUsageStateValue.DISABLED, apiUsageState2.getTransportState());
    assertFalse(apiUsageState2.isAlarmCreationEnabled());
    assertFalse(apiUsageState2.isDbStorageEnabled());
    assertFalse(apiUsageState2.isEmailSendEnabled());
    assertFalse(apiUsageState2.isJsExecEnabled());
    assertFalse(apiUsageState2.isReExecEnabled());
    assertFalse(apiUsageState2.isSmsSendEnabled());
    assertFalse(apiUsageState2.isTbelExecEnabled());
    assertFalse(apiUsageState2.isTransportEnabled());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}.
   * <ul>
   *   <li>Then return size is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThresholds(); then return size is one")
  void testCheckStateUpdatedDueToThresholds_thenReturnSizeIsOne() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTransportState(ApiUsageStateValue.WARNING);
    apiUsageState.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setSmsExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageState.setJsExecState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration = mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any())).thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any())).thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing().when(tenantProfileData).setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdsResult = tenantApiUsageState
        .checkStateUpdatedDueToThresholds();

    // Assert
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1)).getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertEquals(1, actualCheckStateUpdatedDueToThresholdsResult.size());
    assertEquals(ApiUsageStateValue.ENABLED, actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.TRANSPORT));
    ApiUsageState apiUsageState2 = tenantApiUsageState.getApiUsageState();
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getAlarmExecState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getDbStorageState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getEmailExecState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getJsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getReExecState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getSmsExecState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getTbelExecState());
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getTransportState());
    assertTrue(apiUsageState2.isAlarmCreationEnabled());
    assertTrue(apiUsageState2.isDbStorageEnabled());
    assertTrue(apiUsageState2.isEmailSendEnabled());
    assertTrue(apiUsageState2.isJsExecEnabled());
    assertTrue(apiUsageState2.isReExecEnabled());
    assertTrue(apiUsageState2.isSmsSendEnabled());
    assertTrue(apiUsageState2.isTbelExecEnabled());
    assertTrue(apiUsageState2.isTransportEnabled());
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantApiUsageState#setTenantProfileData(TenantProfileData)}
   *   <li>{@link TenantApiUsageState#getEntityType()}
   *   <li>{@link TenantApiUsageState#getTenantProfileData()}
   *   <li>{@link TenantApiUsageState#getTenantProfileId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  void testGettersAndSetters() {
    // Arrange
    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(new ApiUsageState());

    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    // Act
    tenantApiUsageState.setTenantProfileData(tenantProfileData);
    EntityType actualEntityType = tenantApiUsageState.getEntityType();
    TenantProfileData actualTenantProfileData = tenantApiUsageState.getTenantProfileData();
    tenantApiUsageState.getTenantProfileId();

    // Assert that nothing has changed
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(tenantProfileData, actualTenantProfileData);
  }
}
