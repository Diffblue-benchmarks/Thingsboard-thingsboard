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
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.tenant.profile.DefaultTenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileConfiguration;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileData;
import org.thingsboard.server.common.data.tenant.profile.TenantProfileQueueConfiguration;

@DirtiesContext(classMode = ClassMode.AFTER_EACH_TEST_METHOD)
class TenantApiUsageStateDiffblueTest {
  /**
   * Test {@link TenantApiUsageState#TenantApiUsageState(TenantProfile, ApiUsageState)}.
   *
   * <p>Method under test: {@link TenantApiUsageState#TenantApiUsageState(TenantProfile,
   * ApiUsageState)}
   */
  @Test
  @DisplayName("Test new TenantApiUsageState(TenantProfile, ApiUsageState)")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantApiUsageState.<init>(TenantProfile, ApiUsageState)"})
  void testNewTenantApiUsageState() {
    // Arrange
    TenantProfile tenantProfile = new TenantProfile();
    ApiUsageState apiUsageState = new ApiUsageState();

    // Act
    TenantApiUsageState actualTenantApiUsageState =
        new TenantApiUsageState(tenantProfile, apiUsageState);

    // Assert
    TenantProfileData tenantProfileData = actualTenantApiUsageState.getTenantProfileData();
    assertTrue(tenantProfileData.getConfiguration() instanceof DefaultTenantProfileConfiguration);
    assertNull(tenantProfileData.getQueueConfiguration());
    assertNull(actualTenantApiUsageState.getEntityId());
    assertNull(actualTenantApiUsageState.getTenantId());
    assertNull(actualTenantApiUsageState.getTenantProfileId());
    assertEquals(EntityType.TENANT, actualTenantApiUsageState.getEntityType());
    assertSame(apiUsageState, actualTenantApiUsageState.getApiUsageState());
  }

  /**
   * Test {@link TenantApiUsageState#TenantApiUsageState(ApiUsageState)}.
   *
   * <ul>
   *   <li>Then return EntityId is {@code null}.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#TenantApiUsageState(ApiUsageState)}
   */
  @Test
  @DisplayName("Test new TenantApiUsageState(ApiUsageState); then return EntityId is 'null'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"void TenantApiUsageState.<init>(ApiUsageState)"})
  void testNewTenantApiUsageState_thenReturnEntityIdIsNull() {
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
   * Test {@link TenantApiUsageState#getProfileThreshold(ApiUsageRecordKey)}.
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#getProfileThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileThreshold(ApiUsageRecordKey); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TenantApiUsageState.getProfileThreshold(ApiUsageRecordKey)"})
  void testGetProfileThreshold_thenReturnZero() {
    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(new ApiUsageState());
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act and Assert
    assertEquals(
        0L, tenantApiUsageState.getProfileThreshold(ApiUsageRecordKey.TRANSPORT_MSG_COUNT));
  }

  /**
   * Test {@link TenantApiUsageState#getProfileFeatureEnabled(ApiUsageRecordKey)}.
   *
   * <ul>
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#getProfileFeatureEnabled(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileFeatureEnabled(ApiUsageRecordKey); then return 'false'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantApiUsageState.getProfileFeatureEnabled(ApiUsageRecordKey)"})
  void testGetProfileFeatureEnabled_thenReturnFalse() {
    // Arrange
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(false);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(new ApiUsageState());
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act
    boolean actualProfileFeatureEnabled =
        tenantApiUsageState.getProfileFeatureEnabled(ApiUsageRecordKey.TRANSPORT_MSG_COUNT);

    // Assert
    verify(defaultTenantProfileConfiguration)
        .getProfileFeatureEnabled(eq(ApiUsageRecordKey.TRANSPORT_MSG_COUNT));
    verify(tenantProfileData).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertFalse(actualProfileFeatureEnabled);
  }

  /**
   * Test {@link TenantApiUsageState#getProfileFeatureEnabled(ApiUsageRecordKey)}.
   *
   * <ul>
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#getProfileFeatureEnabled(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileFeatureEnabled(ApiUsageRecordKey); then return 'true'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"boolean TenantApiUsageState.getProfileFeatureEnabled(ApiUsageRecordKey)"})
  void testGetProfileFeatureEnabled_thenReturnTrue() {
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
   *
   * <ul>
   *   <li>Then return zero.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#getProfileWarnThreshold(ApiUsageRecordKey)}
   */
  @Test
  @DisplayName("Test getProfileWarnThreshold(ApiUsageRecordKey); then return zero")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"long TenantApiUsageState.getProfileWarnThreshold(ApiUsageRecordKey)"})
  void testGetProfileWarnThreshold_thenReturnZero() {
    // Arrange
    TenantProfileData tenantProfileData = new TenantProfileData();
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(new ApiUsageState());
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act and Assert
    assertEquals(
        0L, tenantApiUsageState.getProfileWarnThreshold(ApiUsageRecordKey.TRANSPORT_MSG_COUNT));
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with {@code features}.
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThreshold(Set)"})
  void testCheckStateUpdatedDueToThresholdWithFeatures() {
    // Arrange
    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(new ApiUsageState());

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult =
        tenantApiUsageState.checkStateUpdatedDueToThreshold(new HashSet<>());

    // Assert
    ApiUsageState apiUsageState = tenantApiUsageState.getApiUsageState();
    assertNull(apiUsageState.getTransportState());
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
    assertTrue(apiUsageState.isTransportEnabled());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with {@code features}.
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThreshold(Set)"})
  void testCheckStateUpdatedDueToThresholdWithFeatures2() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult =
        tenantApiUsageState.checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    ApiUsageState apiUsageState2 = tenantApiUsageState.getApiUsageState();
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getTransportState());
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
    assertTrue(apiUsageState2.isTransportEnabled());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with {@code features}.
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThreshold(Set) with 'features'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThreshold(Set)"})
  void testCheckStateUpdatedDueToThresholdWithFeatures3() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(0L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult =
        tenantApiUsageState.checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    ApiUsageState apiUsageState2 = tenantApiUsageState.getApiUsageState();
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getTransportState());
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
    assertTrue(apiUsageState2.isTransportEnabled());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with {@code features}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getDbStorageState()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName(
      "Test checkStateUpdatedDueToThreshold(Set) with 'features'; then calls getDbStorageState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThreshold(Set)"})
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenCallsGetDbStorageState() {
    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getDbStorageState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setDbStorageState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setReExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.DB);
    features.add(ApiFeature.RE);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult =
        tenantApiUsageState.checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getDbStorageState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).setDbStorageState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setReExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with {@code features}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getEmailExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName(
      "Test checkStateUpdatedDueToThreshold(Set) with 'features'; then calls getEmailExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThreshold(Set)"})
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenCallsGetEmailExecState() {
    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getEmailExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setEmailExecState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setReExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.EMAIL);
    features.add(ApiFeature.RE);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult =
        tenantApiUsageState.checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getEmailExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).setEmailExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setReExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with {@code features}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getJsExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName(
      "Test checkStateUpdatedDueToThreshold(Set) with 'features'; then calls getJsExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThreshold(Set)"})
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenCallsGetJsExecState() {
    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getJsExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setJsExecState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setReExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.JS);
    features.add(ApiFeature.RE);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult =
        tenantApiUsageState.checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getJsExecState();
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).setJsExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setReExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with {@code features}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getReExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName(
      "Test checkStateUpdatedDueToThreshold(Set) with 'features'; then calls getReExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThreshold(Set)"})
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenCallsGetReExecState() {
    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setReExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.RE);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult =
        tenantApiUsageState.checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).setReExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration)
        .getProfileFeatureEnabled(eq(ApiUsageRecordKey.RE_EXEC_COUNT));
    verify(defaultTenantProfileConfiguration)
        .getProfileThreshold(eq(ApiUsageRecordKey.RE_EXEC_COUNT));
    verify(defaultTenantProfileConfiguration).getWarnThreshold(eq(ApiUsageRecordKey.RE_EXEC_COUNT));
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with {@code features}.
   *
   * <ul>
   *   <li>Then calls {@link ApiUsageState#getTbelExecState()}.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName(
      "Test checkStateUpdatedDueToThreshold(Set) with 'features'; then calls getTbelExecState()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThreshold(Set)"})
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenCallsGetTbelExecState() {
    // Arrange
    ApiUsageState apiUsageState = mock(ApiUsageState.class);
    when(apiUsageState.getTbelExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setTbelExecState(Mockito.<ApiUsageStateValue>any());
    when(apiUsageState.getReExecState()).thenReturn(ApiUsageStateValue.ENABLED);
    doNothing().when(apiUsageState).setReExecState(Mockito.<ApiUsageStateValue>any());
    doNothing().when(apiUsageState).setTransportState(Mockito.<ApiUsageStateValue>any());
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.TBEL);
    features.add(ApiFeature.RE);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult =
        tenantApiUsageState.checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(apiUsageState).getReExecState();
    verify(apiUsageState).getTbelExecState();
    verify(apiUsageState).setReExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTbelExecState(eq(ApiUsageStateValue.ENABLED));
    verify(apiUsageState).setTransportState(eq(ApiUsageStateValue.ENABLED));
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertTrue(actualCheckStateUpdatedDueToThresholdResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with {@code features}.
   *
   * <ul>
   *   <li>Then return {@code TRANSPORT} is {@code DISABLED}.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName(
      "Test checkStateUpdatedDueToThreshold(Set) with 'features'; then return 'TRANSPORT' is 'DISABLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThreshold(Set)"})
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenReturnTransportIsDisabled() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(false);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult =
        tenantApiUsageState.checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertEquals(1, actualCheckStateUpdatedDueToThresholdResult.size());
    assertEquals(
        ApiUsageStateValue.DISABLED,
        actualCheckStateUpdatedDueToThresholdResult.get(ApiFeature.TRANSPORT));
    ApiUsageState apiUsageState2 = tenantApiUsageState.getApiUsageState();
    assertEquals(ApiUsageStateValue.DISABLED, apiUsageState2.getTransportState());
    assertFalse(apiUsageState2.isTransportEnabled());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)} with {@code features}.
   *
   * <ul>
   *   <li>Then return {@code TRANSPORT} is {@code ENABLED}.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThreshold(Set)}
   */
  @Test
  @DisplayName(
      "Test checkStateUpdatedDueToThreshold(Set) with 'features'; then return 'TRANSPORT' is 'ENABLED'")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThreshold(Set)"})
  void testCheckStateUpdatedDueToThresholdWithFeatures_thenReturnTransportIsEnabled() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setTransportState(ApiUsageStateValue.WARNING);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    HashSet<ApiFeature> features = new HashSet<>();
    features.add(ApiFeature.TRANSPORT);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdResult =
        tenantApiUsageState.checkStateUpdatedDueToThreshold(features);

    // Assert
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertEquals(1, actualCheckStateUpdatedDueToThresholdResult.size());
    assertEquals(
        ApiUsageStateValue.ENABLED,
        actualCheckStateUpdatedDueToThresholdResult.get(ApiFeature.TRANSPORT));
    ApiUsageState apiUsageState2 = tenantApiUsageState.getApiUsageState();
    assertEquals(ApiUsageStateValue.ENABLED, apiUsageState2.getTransportState());
    assertTrue(apiUsageState2.isTransportEnabled());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}.
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThresholds()")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThresholds()"})
  void testCheckStateUpdatedDueToThresholds() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageState.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageState.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setSmsExecState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(0L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdsResult =
        tenantApiUsageState.checkStateUpdatedDueToThresholds();

    // Assert
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertEquals(
        ApiUsageStateValue.ENABLED, tenantApiUsageState.getApiUsageState().getDbStorageState());
    assertTrue(actualCheckStateUpdatedDueToThresholdsResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}.
   *
   * <ul>
   *   <li>Then return Empty.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThresholds(); then return Empty")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThresholds()"})
  void testCheckStateUpdatedDueToThresholds_thenReturnEmpty() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageState.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageState.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setSmsExecState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdsResult =
        tenantApiUsageState.checkStateUpdatedDueToThresholds();

    // Assert
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertEquals(
        ApiUsageStateValue.ENABLED, tenantApiUsageState.getApiUsageState().getDbStorageState());
    assertTrue(actualCheckStateUpdatedDueToThresholdsResult.isEmpty());
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}.
   *
   * <ul>
   *   <li>Then return size is eight.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThresholds(); then return size is eight")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThresholds()"})
  void testCheckStateUpdatedDueToThresholds_thenReturnSizeIsEight() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setDbStorageState(ApiUsageStateValue.ENABLED);
    apiUsageState.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageState.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setSmsExecState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(false);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdsResult =
        tenantApiUsageState.checkStateUpdatedDueToThresholds();

    // Assert
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertEquals(8, actualCheckStateUpdatedDueToThresholdsResult.size());
    assertEquals(
        ApiUsageStateValue.DISABLED,
        actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.ALARM));
    assertEquals(
        ApiUsageStateValue.DISABLED,
        actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.DB));
    assertEquals(
        ApiUsageStateValue.DISABLED,
        actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.EMAIL));
    assertEquals(
        ApiUsageStateValue.DISABLED,
        actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.JS));
    assertEquals(
        ApiUsageStateValue.DISABLED,
        actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.RE));
    assertEquals(
        ApiUsageStateValue.DISABLED,
        actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.SMS));
    assertEquals(
        ApiUsageStateValue.DISABLED,
        actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.TBEL));
    assertEquals(
        ApiUsageStateValue.DISABLED,
        actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.TRANSPORT));
  }

  /**
   * Test {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}.
   *
   * <ul>
   *   <li>Then return size is one.
   * </ul>
   *
   * <p>Method under test: {@link TenantApiUsageState#checkStateUpdatedDueToThresholds()}
   */
  @Test
  @DisplayName("Test checkStateUpdatedDueToThresholds(); then return size is one")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({"Map TenantApiUsageState.checkStateUpdatedDueToThresholds()"})
  void testCheckStateUpdatedDueToThresholds_thenReturnSizeIsOne() {
    // Arrange
    ApiUsageState apiUsageState = new ApiUsageState();
    apiUsageState.setDbStorageState(ApiUsageStateValue.WARNING);
    apiUsageState.setEmailExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setReExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setJsExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setTransportState(ApiUsageStateValue.ENABLED);
    apiUsageState.setAlarmExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setTbelExecState(ApiUsageStateValue.ENABLED);
    apiUsageState.setSmsExecState(ApiUsageStateValue.ENABLED);
    DefaultTenantProfileConfiguration defaultTenantProfileConfiguration =
        mock(DefaultTenantProfileConfiguration.class);
    when(defaultTenantProfileConfiguration.getProfileThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getWarnThreshold(Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(1L);
    when(defaultTenantProfileConfiguration.getProfileFeatureEnabled(
            Mockito.<ApiUsageRecordKey>any()))
        .thenReturn(true);
    TenantProfileData tenantProfileData = mock(TenantProfileData.class);
    when(tenantProfileData.getConfiguration()).thenReturn(defaultTenantProfileConfiguration);
    doNothing().when(tenantProfileData).setConfiguration(Mockito.<TenantProfileConfiguration>any());
    doNothing()
        .when(tenantProfileData)
        .setQueueConfiguration(Mockito.<List<TenantProfileQueueConfiguration>>any());
    tenantProfileData.setConfiguration(new DefaultTenantProfileConfiguration());
    tenantProfileData.setQueueConfiguration(new ArrayList<>());

    TenantApiUsageState tenantApiUsageState = new TenantApiUsageState(apiUsageState);
    tenantApiUsageState.setTenantProfileData(tenantProfileData);

    // Act
    Map<ApiFeature, ApiUsageStateValue> actualCheckStateUpdatedDueToThresholdsResult =
        tenantApiUsageState.checkStateUpdatedDueToThresholds();

    // Assert
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileFeatureEnabled(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getProfileThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(defaultTenantProfileConfiguration, atLeast(1))
        .getWarnThreshold(Mockito.<ApiUsageRecordKey>any());
    verify(tenantProfileData, atLeast(1)).getConfiguration();
    verify(tenantProfileData).setConfiguration(isA(TenantProfileConfiguration.class));
    verify(tenantProfileData).setQueueConfiguration(isA(List.class));
    assertEquals(1, actualCheckStateUpdatedDueToThresholdsResult.size());
    assertEquals(
        ApiUsageStateValue.ENABLED,
        actualCheckStateUpdatedDueToThresholdsResult.get(ApiFeature.DB));
    assertEquals(
        ApiUsageStateValue.ENABLED, tenantApiUsageState.getApiUsageState().getDbStorageState());
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link TenantApiUsageState#setTenantProfileData(TenantProfileData)}
   *   <li>{@link TenantApiUsageState#getEntityType()}
   *   <li>{@link TenantApiUsageState#getTenantProfileData()}
   *   <li>{@link TenantApiUsageState#getTenantProfileId()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("MaintainedByDiffblue")
  @MethodsUnderTest({
    "EntityType TenantApiUsageState.getEntityType()",
    "TenantProfileData TenantApiUsageState.getTenantProfileData()",
    "org.thingsboard.server.common.data.id.TenantProfileId TenantApiUsageState.getTenantProfileId()",
    "void TenantApiUsageState.setTenantProfileData(TenantProfileData)",
    "void TenantApiUsageState.setTenantProfileId(org.thingsboard.server.common.data.id.TenantProfileId)"
  })
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

    // Assert
    assertNull(tenantApiUsageState.getTenantProfileId());
    assertEquals(EntityType.TENANT, actualEntityType);
    assertSame(tenantProfileData, actualTenantProfileData);
  }
}
