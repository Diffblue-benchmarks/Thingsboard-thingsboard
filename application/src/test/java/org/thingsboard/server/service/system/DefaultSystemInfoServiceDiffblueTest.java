package org.thingsboard.server.service.system;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.google.common.util.concurrent.FutureCallback;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.thingsboard.rule.engine.api.MailService;
import org.thingsboard.rule.engine.api.SmsService;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.ApiUsageState;
import org.thingsboard.server.common.data.FeaturesInfo;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.msg.queue.ServiceType;
import org.thingsboard.server.common.msg.queue.TopicPartitionInfo;
import org.thingsboard.server.common.stats.TbApiUsageStateClient;
import org.thingsboard.server.dao.domain.DomainService;
import org.thingsboard.server.dao.settings.AdminSettingsService;
import org.thingsboard.server.queue.discovery.DiscoveryService;
import org.thingsboard.server.queue.discovery.PartitionService;
import org.thingsboard.server.queue.discovery.TbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.event.PartitionChangeEvent;
import org.thingsboard.server.service.telemetry.TelemetrySubscriptionService;

class DefaultSystemInfoServiceDiffblueTest {
  /**
   * Test
   * {@link DefaultSystemInfoService#onTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   * <p>
   * Method under test:
   * {@link DefaultSystemInfoService#onTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test onTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'")
  void testOnTbApplicationEventWithPartitionChangeEvent() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder topicPartitionInfoBuilder = mock(
        TopicPartitionInfo.TopicPartitionInfoBuilder.class);
    when(topicPartitionInfoBuilder.myPartition(anyBoolean())).thenReturn(TopicPartitionInfo.builder());
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = topicPartitionInfoBuilder.myPartition(true)
        .partition(1);
    partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    DefaultSystemInfoService defaultSystemInfoService = new DefaultSystemInfoService(mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(DiscoveryService.class), mock(TelemetrySubscriptionService.class),
        mock(TbApiUsageStateClient.class), mock(AdminSettingsService.class), mock(DomainService.class),
        mock(MailService.class), mock(SmsService.class));

    // Act
    defaultSystemInfoService.onTbApplicationEvent(new PartitionChangeEvent("Source", null, new HashMap<>()));

    // Assert that nothing has changed
    verify(topicPartitionInfoBuilder).myPartition(eq(true));
  }

  /**
   * Test
   * {@link DefaultSystemInfoService#onTbApplicationEvent(PartitionChangeEvent)}
   * with {@code PartitionChangeEvent}.
   * <ul>
   *   <li>Then calls
   * {@link PartitionService#resolve(ServiceType, TenantId, EntityId)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultSystemInfoService#onTbApplicationEvent(PartitionChangeEvent)}
   */
  @Test
  @DisplayName("Test onTbApplicationEvent(PartitionChangeEvent) with 'PartitionChangeEvent'; then calls resolve(ServiceType, TenantId, EntityId)")
  void testOnTbApplicationEventWithPartitionChangeEvent_thenCallsResolve() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    TopicPartitionInfo.TopicPartitionInfoBuilder topicPartitionInfoBuilder = mock(
        TopicPartitionInfo.TopicPartitionInfoBuilder.class);
    when(topicPartitionInfoBuilder.myPartition(anyBoolean())).thenReturn(TopicPartitionInfo.builder());
    TopicPartitionInfo.TopicPartitionInfoBuilder partitionResult = topicPartitionInfoBuilder.myPartition(true)
        .partition(1);
    TopicPartitionInfo buildResult = partitionResult.tenantId(new TenantId(UUID.randomUUID())).topic("Topic").build();
    PartitionService partitionService = mock(PartitionService.class);
    when(partitionService.resolve(Mockito.<ServiceType>any(), Mockito.<TenantId>any(), Mockito.<EntityId>any()))
        .thenReturn(buildResult);
    DefaultSystemInfoService defaultSystemInfoService = new DefaultSystemInfoService(mock(TbServiceInfoProvider.class),
        partitionService, mock(DiscoveryService.class), mock(TelemetrySubscriptionService.class),
        mock(TbApiUsageStateClient.class), mock(AdminSettingsService.class), mock(DomainService.class),
        mock(MailService.class), mock(SmsService.class));

    // Act
    defaultSystemInfoService
        .onTbApplicationEvent(new PartitionChangeEvent("Source", ServiceType.TB_CORE, new HashMap<>()));

    // Assert
    verify(topicPartitionInfoBuilder).myPartition(eq(true));
    verify(partitionService).resolve(eq(ServiceType.TB_CORE), isA(TenantId.class), isA(EntityId.class));
  }

  /**
   * Test {@link DefaultSystemInfoService#saveCurrentSystemInfo()}.
   * <p>
   * Method under test: {@link DefaultSystemInfoService#saveCurrentSystemInfo()}
   */
  @Test
  @DisplayName("Test saveCurrentSystemInfo()")
  void testSaveCurrentSystemInfo() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    DiscoveryService discoveryService = mock(DiscoveryService.class);
    when(discoveryService.isMonolith()).thenReturn(true);
    TelemetrySubscriptionService telemetryService = mock(TelemetrySubscriptionService.class);
    doNothing().when(telemetryService)
        .saveAndNotifyInternal(Mockito.<TenantId>any(), Mockito.<EntityId>any(), Mockito.<List<TsKvEntry>>any(),
            anyLong(), Mockito.<FutureCallback<Integer>>any());
    TbApiUsageStateClient apiUsageStateClient = mock(TbApiUsageStateClient.class);
    when(apiUsageStateClient.getApiUsageState(Mockito.<TenantId>any())).thenReturn(new ApiUsageState());

    // Act
    (new DefaultSystemInfoService(mock(TbServiceInfoProvider.class), mock(PartitionService.class), discoveryService,
        telemetryService, apiUsageStateClient, mock(AdminSettingsService.class), mock(DomainService.class),
        mock(MailService.class), mock(SmsService.class))).saveCurrentSystemInfo();

    // Assert
    verify(apiUsageStateClient).getApiUsageState(isA(TenantId.class));
    verify(discoveryService).isMonolith();
    verify(telemetryService).saveAndNotifyInternal(isA(TenantId.class), isNull(), isA(List.class), eq(0L),
        isA(FutureCallback.class));
  }

  /**
   * Test {@link DefaultSystemInfoService#getFeaturesInfo()}.
   * <ul>
   *   <li>Given {@link AdminSettingsService}
   * {@link AdminSettingsService#findAdminSettingsByKey(TenantId, String)} return
   * {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemInfoService#getFeaturesInfo()}
   */
  @Test
  @DisplayName("Test getFeaturesInfo(); given AdminSettingsService findAdminSettingsByKey(TenantId, String) return 'null'")
  void testGetFeaturesInfo_givenAdminSettingsServiceFindAdminSettingsByKeyReturnNull() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any())).thenReturn(null);
    DomainService domainService = mock(DomainService.class);
    when(domainService.isOauth2Enabled(Mockito.<TenantId>any())).thenReturn(true);
    MailService mailService = mock(MailService.class);
    doNothing().when(mailService).testConnection(Mockito.<TenantId>any());
    SmsService smsService = mock(SmsService.class);
    when(smsService.isConfigured(Mockito.<TenantId>any())).thenReturn(true);

    // Act
    FeaturesInfo actualFeaturesInfo = (new DefaultSystemInfoService(mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(DiscoveryService.class), mock(TelemetrySubscriptionService.class),
        mock(TbApiUsageStateClient.class), adminSettingsService, domainService, mailService, smsService))
        .getFeaturesInfo();

    // Assert
    verify(mailService).testConnection(isA(TenantId.class));
    verify(smsService).isConfigured(isA(TenantId.class));
    verify(domainService).isOauth2Enabled(isA(TenantId.class));
    verify(adminSettingsService, atLeast(1)).findAdminSettingsByKey(isA(TenantId.class), Mockito.<String>any());
    assertFalse(actualFeaturesInfo.isNotificationEnabled());
    assertFalse(actualFeaturesInfo.isTwoFaEnabled());
    assertTrue(actualFeaturesInfo.isEmailEnabled());
    assertTrue(actualFeaturesInfo.isOauthEnabled());
    assertTrue(actualFeaturesInfo.isSmsEnabled());
  }

  /**
   * Test {@link DefaultSystemInfoService#getFeaturesInfo()}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#get(String)} return Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemInfoService#getFeaturesInfo()}
   */
  @Test
  @DisplayName("Test getFeaturesInfo(); given JsonNode get(String) return Instance")
  void testGetFeaturesInfo_givenJsonNodeGetReturnInstance() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.get(Mockito.<String>any())).thenReturn(MissingNode.getInstance());
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(jsonNode);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DomainService domainService = mock(DomainService.class);
    when(domainService.isOauth2Enabled(Mockito.<TenantId>any())).thenReturn(true);
    MailService mailService = mock(MailService.class);
    doNothing().when(mailService).testConnection(Mockito.<TenantId>any());
    SmsService smsService = mock(SmsService.class);
    when(smsService.isConfigured(Mockito.<TenantId>any())).thenReturn(true);

    // Act
    FeaturesInfo actualFeaturesInfo = (new DefaultSystemInfoService(mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(DiscoveryService.class), mock(TelemetrySubscriptionService.class),
        mock(TbApiUsageStateClient.class), adminSettingsService, domainService, mailService, smsService))
        .getFeaturesInfo();

    // Assert
    verify(jsonNode, atLeast(1)).get(Mockito.<String>any());
    verify(mailService).testConnection(isA(TenantId.class));
    verify(smsService).isConfigured(isA(TenantId.class));
    verify(adminSettings, atLeast(1)).getJsonValue();
    verify(domainService).isOauth2Enabled(isA(TenantId.class));
    verify(adminSettingsService, atLeast(1)).findAdminSettingsByKey(isA(TenantId.class), Mockito.<String>any());
    assertFalse(actualFeaturesInfo.isNotificationEnabled());
    assertFalse(actualFeaturesInfo.isTwoFaEnabled());
    assertTrue(actualFeaturesInfo.isEmailEnabled());
    assertTrue(actualFeaturesInfo.isOauthEnabled());
    assertTrue(actualFeaturesInfo.isSmsEnabled());
  }

  /**
   * Test {@link DefaultSystemInfoService#getFeaturesInfo()}.
   * <ul>
   *   <li>Given {@link JsonNode} {@link JsonNode#has(String)} return
   * {@code true}.</li>
   *   <li>Then return NotificationEnabled.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultSystemInfoService#getFeaturesInfo()}
   */
  @Test
  @DisplayName("Test getFeaturesInfo(); given JsonNode has(String) return 'true'; then return NotificationEnabled")
  void testGetFeaturesInfo_givenJsonNodeHasReturnTrue_thenReturnNotificationEnabled() throws Exception {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    JsonNode jsonNode = mock(JsonNode.class);
    when(jsonNode.has(Mockito.<String>any())).thenReturn(true);
    when(jsonNode.size()).thenReturn(3);
    JsonNode jsonNode2 = mock(JsonNode.class);
    when(jsonNode2.get(Mockito.<String>any())).thenReturn(jsonNode);
    AdminSettings adminSettings = mock(AdminSettings.class);
    when(adminSettings.getJsonValue()).thenReturn(jsonNode2);
    AdminSettingsService adminSettingsService = mock(AdminSettingsService.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    DomainService domainService = mock(DomainService.class);
    when(domainService.isOauth2Enabled(Mockito.<TenantId>any())).thenReturn(true);
    MailService mailService = mock(MailService.class);
    doNothing().when(mailService).testConnection(Mockito.<TenantId>any());
    SmsService smsService = mock(SmsService.class);
    when(smsService.isConfigured(Mockito.<TenantId>any())).thenReturn(true);

    // Act
    FeaturesInfo actualFeaturesInfo = (new DefaultSystemInfoService(mock(TbServiceInfoProvider.class),
        mock(PartitionService.class), mock(DiscoveryService.class), mock(TelemetrySubscriptionService.class),
        mock(TbApiUsageStateClient.class), adminSettingsService, domainService, mailService, smsService))
        .getFeaturesInfo();

    // Assert
    verify(jsonNode2, atLeast(1)).get(Mockito.<String>any());
    verify(jsonNode).has(eq("SLACK"));
    verify(jsonNode).size();
    verify(mailService).testConnection(isA(TenantId.class));
    verify(smsService).isConfigured(isA(TenantId.class));
    verify(adminSettings, atLeast(1)).getJsonValue();
    verify(domainService).isOauth2Enabled(isA(TenantId.class));
    verify(adminSettingsService, atLeast(1)).findAdminSettingsByKey(isA(TenantId.class), Mockito.<String>any());
    assertTrue(actualFeaturesInfo.isEmailEnabled());
    assertTrue(actualFeaturesInfo.isNotificationEnabled());
    assertTrue(actualFeaturesInfo.isOauthEnabled());
    assertTrue(actualFeaturesInfo.isSmsEnabled());
    assertTrue(actualFeaturesInfo.isTwoFaEnabled());
  }
}
