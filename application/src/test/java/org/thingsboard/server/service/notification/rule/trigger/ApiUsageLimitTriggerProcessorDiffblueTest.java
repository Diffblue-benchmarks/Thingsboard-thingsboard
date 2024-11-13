package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageRecordState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.ApiUsageLimitNotificationInfo;
import org.thingsboard.server.common.data.notification.info.RuleOriginatedNotificationInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.ApiUsageLimitTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.ApiUsageLimitNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

@ContextConfiguration(classes = {ApiUsageLimitTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class ApiUsageLimitTriggerProcessorDiffblueTest {
  @Autowired
  private ApiUsageLimitTriggerProcessor apiUsageLimitTriggerProcessor;

  @MockBean
  private TenantService tenantService;

  /**
   * Test
   * {@link ApiUsageLimitTriggerProcessor#matchesFilter(ApiUsageLimitTrigger, ApiUsageLimitNotificationRuleTriggerConfig)}
   * with {@code ApiUsageLimitTrigger},
   * {@code ApiUsageLimitNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link ApiUsageLimitTriggerProcessor#matchesFilter(ApiUsageLimitTrigger, ApiUsageLimitNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(ApiUsageLimitTrigger, ApiUsageLimitNotificationRuleTriggerConfig) with 'ApiUsageLimitTrigger', 'ApiUsageLimitNotificationRuleTriggerConfig'")
  void testMatchesFilterWithApiUsageLimitTriggerApiUsageLimitNotificationRuleTriggerConfig() {
    // Arrange
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder statusResult = builderResult
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED);
    ApiUsageLimitTrigger trigger = statusResult.tenantId(new TenantId(UUID.randomUUID())).build();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder builderResult2 = ApiUsageLimitNotificationRuleTriggerConfig
        .builder();
    ApiUsageLimitNotificationRuleTriggerConfig.ApiUsageLimitNotificationRuleTriggerConfigBuilder apiFeaturesResult = builderResult2
        .apiFeatures(new HashSet<>());
    ApiUsageLimitNotificationRuleTriggerConfig triggerConfig = apiFeaturesResult.notifyOn(new HashSet<>()).build();

    // Act and Assert
    assertTrue(apiUsageLimitTriggerProcessor.matchesFilter(trigger, triggerConfig));
  }

  /**
   * Test
   * {@link ApiUsageLimitTriggerProcessor#matchesFilter(ApiUsageLimitTrigger, ApiUsageLimitNotificationRuleTriggerConfig)}
   * with {@code ApiUsageLimitTrigger},
   * {@code ApiUsageLimitNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link ApiUsageLimitTriggerProcessor#matchesFilter(ApiUsageLimitTrigger, ApiUsageLimitNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(ApiUsageLimitTrigger, ApiUsageLimitNotificationRuleTriggerConfig) with 'ApiUsageLimitTrigger', 'ApiUsageLimitNotificationRuleTriggerConfig'")
  void testMatchesFilterWithApiUsageLimitTriggerApiUsageLimitNotificationRuleTriggerConfig2() {
    // Arrange
    ApiUsageLimitTrigger trigger = mock(ApiUsageLimitTrigger.class);
    when(trigger.getStatus()).thenReturn(ApiUsageStateValue.ENABLED);
    when(trigger.getState())
        .thenReturn(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L));

    HashSet<ApiFeature> apiFeatureSet = new HashSet<>();
    apiFeatureSet.add(ApiFeature.TRANSPORT);
    ApiUsageLimitNotificationRuleTriggerConfig triggerConfig = mock(ApiUsageLimitNotificationRuleTriggerConfig.class);
    when(triggerConfig.getNotifyOn()).thenReturn(new HashSet<>());
    when(triggerConfig.getApiFeatures()).thenReturn(apiFeatureSet);

    // Act
    boolean actualMatchesFilterResult = apiUsageLimitTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).getState();
    verify(trigger).getStatus();
    verify(triggerConfig).getApiFeatures();
    verify(triggerConfig).getNotifyOn();
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link ApiUsageLimitTriggerProcessor#matchesFilter(ApiUsageLimitTrigger, ApiUsageLimitNotificationRuleTriggerConfig)}
   * with {@code ApiUsageLimitTrigger},
   * {@code ApiUsageLimitNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link ApiUsageLimitTriggerProcessor#matchesFilter(ApiUsageLimitTrigger, ApiUsageLimitNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(ApiUsageLimitTrigger, ApiUsageLimitNotificationRuleTriggerConfig) with 'ApiUsageLimitTrigger', 'ApiUsageLimitNotificationRuleTriggerConfig'")
  void testMatchesFilterWithApiUsageLimitTriggerApiUsageLimitNotificationRuleTriggerConfig3() {
    // Arrange
    ApiUsageLimitTrigger trigger = mock(ApiUsageLimitTrigger.class);
    when(trigger.getState())
        .thenReturn(new ApiUsageRecordState(ApiFeature.DB, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L));

    HashSet<ApiFeature> apiFeatureSet = new HashSet<>();
    apiFeatureSet.add(ApiFeature.TRANSPORT);
    ApiUsageLimitNotificationRuleTriggerConfig triggerConfig = mock(ApiUsageLimitNotificationRuleTriggerConfig.class);
    when(triggerConfig.getApiFeatures()).thenReturn(apiFeatureSet);

    // Act
    boolean actualMatchesFilterResult = apiUsageLimitTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).getState();
    verify(triggerConfig).getApiFeatures();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link ApiUsageLimitTriggerProcessor#matchesFilter(ApiUsageLimitTrigger, ApiUsageLimitNotificationRuleTriggerConfig)}
   * with {@code ApiUsageLimitTrigger},
   * {@code ApiUsageLimitNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link ApiUsageLimitTriggerProcessor#matchesFilter(ApiUsageLimitTrigger, ApiUsageLimitNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(ApiUsageLimitTrigger, ApiUsageLimitNotificationRuleTriggerConfig) with 'ApiUsageLimitTrigger', 'ApiUsageLimitNotificationRuleTriggerConfig'")
  void testMatchesFilterWithApiUsageLimitTriggerApiUsageLimitNotificationRuleTriggerConfig4() {
    // Arrange
    ApiUsageLimitTrigger trigger = mock(ApiUsageLimitTrigger.class);
    when(trigger.getStatus()).thenReturn(ApiUsageStateValue.ENABLED);
    when(trigger.getState())
        .thenReturn(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L));

    HashSet<ApiFeature> apiFeatureSet = new HashSet<>();
    apiFeatureSet.add(ApiFeature.TRANSPORT);

    HashSet<ApiUsageStateValue> apiUsageStateValueSet = new HashSet<>();
    apiUsageStateValueSet.add(ApiUsageStateValue.WARNING);
    apiUsageStateValueSet.addAll(new ArrayList<>());
    ApiUsageLimitNotificationRuleTriggerConfig triggerConfig = mock(ApiUsageLimitNotificationRuleTriggerConfig.class);
    when(triggerConfig.getNotifyOn()).thenReturn(apiUsageStateValueSet);
    when(triggerConfig.getApiFeatures()).thenReturn(apiFeatureSet);

    // Act
    boolean actualMatchesFilterResult = apiUsageLimitTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger).getState();
    verify(trigger).getStatus();
    verify(triggerConfig).getApiFeatures();
    verify(triggerConfig).getNotifyOn();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link ApiUsageLimitTriggerProcessor#constructNotificationInfo(ApiUsageLimitTrigger)}
   * with {@code ApiUsageLimitTrigger}.
   * <p>
   * Method under test:
   * {@link ApiUsageLimitTriggerProcessor#constructNotificationInfo(ApiUsageLimitTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(ApiUsageLimitTrigger) with 'ApiUsageLimitTrigger'")
  void testConstructNotificationInfoWithApiUsageLimitTrigger() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder builderResult = ApiUsageLimitTrigger.builder();
    ApiUsageLimitTrigger.ApiUsageLimitTriggerBuilder statusResult = builderResult
        .state(new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L))
        .status(ApiUsageStateValue.ENABLED);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    ApiUsageLimitTrigger trigger = statusResult.tenantId(tenantId).build();

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = apiUsageLimitTriggerProcessor
        .constructNotificationInfo(trigger);

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
    assertTrue(actualConstructNotificationInfoResult instanceof ApiUsageLimitNotificationInfo);
    Map<String, String> templateData = actualConstructNotificationInfoResult.getTemplateData();
    assertEquals(7, templateData.size());
    assertEquals("1", templateData.get("limit"));
    assertEquals("1", ((ApiUsageLimitNotificationInfo) actualConstructNotificationInfoResult).getLimit());
    assertEquals("42", templateData.get("currentValue"));
    assertEquals("42", ((ApiUsageLimitNotificationInfo) actualConstructNotificationInfoResult).getCurrentValue());
    assertEquals("Device API", templateData.get("feature"));
    assertEquals("message", templateData.get("unitLabel"));
    assertNull(templateData.get("tenantName"));
    assertNull(((ApiUsageLimitNotificationInfo) actualConstructNotificationInfoResult).getTenantName());
    assertNull(actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(actualConstructNotificationInfoResult.getStateEntityId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    assertEquals(ApiFeature.TRANSPORT,
        ((ApiUsageLimitNotificationInfo) actualConstructNotificationInfoResult).getFeature());
    assertEquals(ApiUsageRecordKey.TRANSPORT_MSG_COUNT,
        ((ApiUsageLimitNotificationInfo) actualConstructNotificationInfoResult).getRecordKey());
    assertEquals(ApiUsageStateValue.ENABLED,
        ((ApiUsageLimitNotificationInfo) actualConstructNotificationInfoResult).getStatus());
    assertTrue(templateData.containsKey("tenantId"));
    assertSame(tenantId, ((ApiUsageLimitNotificationInfo) actualConstructNotificationInfoResult).getTenantId());
    assertSame(tenantId, actualConstructNotificationInfoResult.getAffectedTenantId());
  }

  /**
   * Test {@link ApiUsageLimitTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link ApiUsageLimitTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  void testGetTriggerType() {
    // Arrange, Act and Assert
    assertEquals(NotificationRuleTriggerType.API_USAGE_LIMIT,
        (new ApiUsageLimitTriggerProcessor(new TenantServiceImpl())).getTriggerType());
  }
}
