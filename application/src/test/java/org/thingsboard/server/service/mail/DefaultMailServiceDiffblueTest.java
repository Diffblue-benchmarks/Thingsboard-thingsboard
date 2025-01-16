package org.thingsboard.server.service.mail;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.BigIntegerNode;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.IOException;
import java.io.StringReader;
import java.io.Writer;
import java.math.BigInteger;
import java.util.Locale;
import java.util.UUID;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.thingsboard.server.common.data.AdminSettings;
import org.thingsboard.server.common.data.ApiFeature;
import org.thingsboard.server.common.data.ApiUsageRecordKey;
import org.thingsboard.server.common.data.ApiUsageRecordState;
import org.thingsboard.server.common.data.ApiUsageStateValue;
import org.thingsboard.server.common.data.exception.ThingsboardErrorCode;
import org.thingsboard.server.common.data.exception.ThingsboardException;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.exception.IncorrectParameterException;
import org.thingsboard.server.dao.settings.AdminSettingsServiceImpl;
import org.thingsboard.server.queue.discovery.DefaultTbServiceInfoProvider;
import org.thingsboard.server.queue.discovery.HashPartitionService;
import org.thingsboard.server.queue.discovery.QueueRoutingInfoService;
import org.thingsboard.server.queue.discovery.TenantRoutingInfoService;
import org.thingsboard.server.queue.discovery.TopicService;
import org.thingsboard.server.queue.memory.DefaultInMemoryStorage;
import org.thingsboard.server.queue.provider.InMemoryMonolithQueueFactory;
import org.thingsboard.server.queue.provider.TbCoreQueueProducerProvider;
import org.thingsboard.server.queue.scheduler.DefaultSchedulerComponent;
import org.thingsboard.server.queue.settings.TbQueueCoreSettings;
import org.thingsboard.server.queue.settings.TbQueueEdgeSettings;
import org.thingsboard.server.queue.settings.TbQueueRuleEngineSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportApiSettings;
import org.thingsboard.server.queue.settings.TbQueueTransportNotificationSettings;
import org.thingsboard.server.queue.settings.TbQueueVersionControlSettings;
import org.thingsboard.server.queue.usagestats.DefaultTbApiUsageReportClient;

class DefaultMailServiceDiffblueTest {
  /**
   * Test {@link DefaultMailService#updateMailConfiguration()}.
   * <p>
   * Method under test: {@link DefaultMailService#updateMailConfiguration()}
   */
  @Test
  @DisplayName("Test updateMailConfiguration()")
  void testUpdateMailConfiguration() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayNode jsonValue = mock(ArrayNode.class);
    when(jsonValue.has(Mockito.<String>any())).thenReturn(true);
    when(jsonValue.get(Mockito.<String>any())).thenReturn(new BigIntegerNode(BigInteger.valueOf(1L)));

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(jsonValue);
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act
    defaultMailService.updateMailConfiguration();

    // Assert
    verify(jsonValue, atLeast(1)).has(Mockito.<String>any());
    verify(jsonValue, atLeast(1)).get(Mockito.<String>any());
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("mail"));
    assertTrue(defaultMailService.isConfigured(null));
  }

  /**
   * Test {@link DefaultMailService#updateMailConfiguration()}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link JsonNode#asBoolean()} return
   * {@code false}.</li>
   *   <li>Then calls {@link JsonNode#isNull()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#updateMailConfiguration()}
   */
  @Test
  @DisplayName("Test updateMailConfiguration(); given ArrayNode asBoolean() return 'false'; then calls isNull()")
  void testUpdateMailConfiguration_givenArrayNodeAsBooleanReturnFalse_thenCallsIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.isNull()).thenReturn(true);
    when(arrayNode.booleanValue()).thenReturn(true);
    when(arrayNode.isBoolean()).thenReturn(true);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.asBoolean()).thenReturn(false);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonValue = mock(ArrayNode.class);
    when(jsonValue.has(Mockito.<String>any())).thenReturn(true);
    when(jsonValue.get(Mockito.<String>any())).thenReturn(arrayNode);

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(jsonValue);
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act
    defaultMailService.updateMailConfiguration();

    // Assert
    verify(arrayNode, atLeast(1)).asBoolean();
    verify(arrayNode).asLong(eq(10000L));
    verify(arrayNode).booleanValue();
    verify(jsonValue, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode).isBoolean();
    verify(arrayNode).isNull();
    verify(jsonValue, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("mail"));
    assertTrue(defaultMailService.isConfigured(null));
  }

  /**
   * Test {@link DefaultMailService#updateMailConfiguration()}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link JsonNode#has(String)} return
   * {@code false}.</li>
   *   <li>Then calls {@link JsonNode#asLong(long)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#updateMailConfiguration()}
   */
  @Test
  @DisplayName("Test updateMailConfiguration(); given ArrayNode has(String) return 'false'; then calls asLong(long)")
  void testUpdateMailConfiguration_givenArrayNodeHasReturnFalse_thenCallsAsLong() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonValue = mock(ArrayNode.class);
    when(jsonValue.has(Mockito.<String>any())).thenReturn(false);
    when(jsonValue.get(Mockito.<String>any())).thenReturn(arrayNode);

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(jsonValue);
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act
    defaultMailService.updateMailConfiguration();

    // Assert
    verify(arrayNode).asLong(eq(10000L));
    verify(jsonValue, atLeast(1)).has(Mockito.<String>any());
    verify(jsonValue, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("mail"));
    assertTrue(defaultMailService.isConfigured(null));
  }

  /**
   * Test {@link DefaultMailService#updateMailConfiguration()}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link JsonNode#isNull()} return
   * {@code false}.</li>
   *   <li>Then calls {@link JsonNode#isNull()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#updateMailConfiguration()}
   */
  @Test
  @DisplayName("Test updateMailConfiguration(); given ArrayNode isNull() return 'false'; then calls isNull()")
  void testUpdateMailConfiguration_givenArrayNodeIsNullReturnFalse_thenCallsIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.isNull()).thenReturn(false);
    when(arrayNode.booleanValue()).thenReturn(true);
    when(arrayNode.isBoolean()).thenReturn(true);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.asBoolean()).thenReturn(true);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonValue = mock(ArrayNode.class);
    when(jsonValue.has(Mockito.<String>any())).thenReturn(true);
    when(jsonValue.get(Mockito.<String>any())).thenReturn(arrayNode);

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(jsonValue);
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act
    defaultMailService.updateMailConfiguration();

    // Assert
    verify(arrayNode, atLeast(1)).asBoolean();
    verify(arrayNode).asLong(eq(10000L));
    verify(arrayNode).booleanValue();
    verify(jsonValue, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode).isBoolean();
    verify(arrayNode).isNull();
    verify(jsonValue, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("mail"));
    assertTrue(defaultMailService.isConfigured(null));
  }

  /**
   * Test {@link DefaultMailService#updateMailConfiguration()}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link JsonNode#isNull()} return
   * {@code true}.</li>
   *   <li>Then calls {@link JsonNode#isNull()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#updateMailConfiguration()}
   */
  @Test
  @DisplayName("Test updateMailConfiguration(); given ArrayNode isNull() return 'true'; then calls isNull()")
  void testUpdateMailConfiguration_givenArrayNodeIsNullReturnTrue_thenCallsIsNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.isNull()).thenReturn(true);
    when(arrayNode.booleanValue()).thenReturn(true);
    when(arrayNode.isBoolean()).thenReturn(true);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.asBoolean()).thenReturn(true);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonValue = mock(ArrayNode.class);
    when(jsonValue.has(Mockito.<String>any())).thenReturn(true);
    when(jsonValue.get(Mockito.<String>any())).thenReturn(arrayNode);

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(jsonValue);
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act
    defaultMailService.updateMailConfiguration();

    // Assert
    verify(arrayNode, atLeast(1)).asBoolean();
    verify(arrayNode).asLong(eq(10000L));
    verify(arrayNode).booleanValue();
    verify(jsonValue, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode).isBoolean();
    verify(arrayNode).isNull();
    verify(jsonValue, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("mail"));
    assertTrue(defaultMailService.isConfigured(null));
  }

  /**
   * Test {@link DefaultMailService#updateMailConfiguration()}.
   * <ul>
   *   <li>Then calls {@link JsonNode#isTextual()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#updateMailConfiguration()}
   */
  @Test
  @DisplayName("Test updateMailConfiguration(); then calls isTextual()")
  void testUpdateMailConfiguration_thenCallsIsTextual() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.booleanValue()).thenReturn(false);
    when(arrayNode.isBoolean()).thenReturn(true);
    when(arrayNode.isTextual()).thenReturn(true);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.asBoolean()).thenReturn(true);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonValue = mock(ArrayNode.class);
    when(jsonValue.has(Mockito.<String>any())).thenReturn(true);
    when(jsonValue.get(Mockito.<String>any())).thenReturn(arrayNode);

    AdminSettings adminSettings = new AdminSettings();
    adminSettings.setJsonValue(jsonValue);
    AdminSettingsServiceImpl adminSettingsService = mock(AdminSettingsServiceImpl.class);
    when(adminSettingsService.findAdminSettingsByKey(Mockito.<TenantId>any(), Mockito.<String>any()))
        .thenReturn(adminSettings);
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act
    defaultMailService.updateMailConfiguration();

    // Assert
    verify(arrayNode, atLeast(1)).asBoolean();
    verify(arrayNode).asLong(eq(10000L));
    verify(arrayNode).booleanValue();
    verify(jsonValue, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode).isBoolean();
    verify(arrayNode).isTextual();
    verify(jsonValue, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(adminSettingsService).findAdminSettingsByKey(isA(TenantId.class), eq("mail"));
    assertTrue(defaultMailService.isConfigured(null));
  }

  /**
   * Test {@link DefaultMailService#sendEmail(TenantId, String, String, String)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendEmail(TenantId, String, String, String)}
   */
  @Test
  @DisplayName("Test sendEmail(TenantId, String, String, String)")
  void testSendEmail() throws ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendEmail(new TenantId(UUID.randomUUID()),
        "jane.doe@example.org", "Hello from the Dreaming Spires", "Not all who wander are lost"));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String)")
  void testSendTestMail() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.isNull()).thenReturn(true);
    when(arrayNode.booleanValue()).thenReturn(true);
    when(arrayNode.isBoolean()).thenReturn(true);
    when(arrayNode.asBoolean()).thenReturn(true);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(true);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(arrayNode, atLeast(1)).asBoolean();
    verify(arrayNode).asLong(eq(10000L));
    verify(arrayNode).booleanValue();
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode).isBoolean();
    verify(arrayNode).isNull();
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(messages).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String)")
  void testSendTestMail2() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.isNull()).thenReturn(true);
    when(arrayNode.booleanValue()).thenReturn(true);
    when(arrayNode.isBoolean()).thenReturn(true);
    when(arrayNode.asBoolean()).thenReturn(true);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(true);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(arrayNode, atLeast(1)).asBoolean();
    verify(arrayNode).asLong(eq(10000L));
    verify(arrayNode).booleanValue();
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode).isBoolean();
    verify(arrayNode).isNull();
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(messages).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link JsonNode#asBoolean()} return
   * {@code false}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String); given ArrayNode asBoolean() return 'false'; then calls process(Object, Writer)")
  void testSendTestMail_givenArrayNodeAsBooleanReturnFalse_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.isNull()).thenReturn(true);
    when(arrayNode.booleanValue()).thenReturn(true);
    when(arrayNode.isBoolean()).thenReturn(true);
    when(arrayNode.asBoolean()).thenReturn(false);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(true);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(arrayNode, atLeast(1)).asBoolean();
    verify(arrayNode).asLong(eq(10000L));
    verify(arrayNode).booleanValue();
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode).isBoolean();
    verify(arrayNode).isNull();
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(freemarkerConfig).getTemplate(eq("test.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link JsonNode#booleanValue()} return
   * {@code false}.</li>
   *   <li>Then calls {@link JsonNode#isTextual()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String); given ArrayNode booleanValue() return 'false'; then calls isTextual()")
  void testSendTestMail_givenArrayNodeBooleanValueReturnFalse_thenCallsIsTextual()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.booleanValue()).thenReturn(false);
    when(arrayNode.isBoolean()).thenReturn(true);
    when(arrayNode.isTextual()).thenReturn(true);
    when(arrayNode.asBoolean()).thenReturn(true);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(true);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(arrayNode, atLeast(1)).asBoolean();
    verify(arrayNode).asLong(eq(10000L));
    verify(arrayNode).booleanValue();
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode).isBoolean();
    verify(arrayNode).isTextual();
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(freemarkerConfig).getTemplate(eq("test.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <ul>
   *   <li>Given {@link ArrayNode} {@link JsonNode#isNull()} return
   * {@code false}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String); given ArrayNode isNull() return 'false'; then calls process(Object, Writer)")
  void testSendTestMail_givenArrayNodeIsNullReturnFalse_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.isNull()).thenReturn(false);
    when(arrayNode.booleanValue()).thenReturn(true);
    when(arrayNode.isBoolean()).thenReturn(true);
    when(arrayNode.asBoolean()).thenReturn(true);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(true);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(arrayNode, atLeast(1)).asBoolean();
    verify(arrayNode).asLong(eq(10000L));
    verify(arrayNode).booleanValue();
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode).isBoolean();
    verify(arrayNode).isNull();
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(freemarkerConfig).getTemplate(eq("test.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <ul>
   *   <li>Given {@link Configuration#Configuration(Version)} with
   * incompatibleImprovements is Version.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String); given Configuration(Version) with incompatibleImprovements is Version")
  void testSendTestMail_givenConfigurationWithIncompatibleImprovementsIsVersion()
      throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration(Configuration.getVersion());
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.isNull()).thenReturn(true);
    when(arrayNode.booleanValue()).thenReturn(true);
    when(arrayNode.isBoolean()).thenReturn(true);
    when(arrayNode.asBoolean()).thenReturn(true);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(true);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(arrayNode, atLeast(1)).asBoolean();
    verify(arrayNode).asLong(eq(10000L));
    verify(arrayNode).booleanValue();
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode).isBoolean();
    verify(arrayNode).isNull();
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(messages).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <ul>
   *   <li>Given {@code false}.</li>
   *   <li>When {@link ArrayNode} {@link JsonNode#has(String)} return
   * {@code false}.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String); given 'false'; when ArrayNode has(String) return 'false'; then calls process(Object, Writer)")
  void testSendTestMail_givenFalse_whenArrayNodeHasReturnFalse_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(false);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(arrayNode).asLong(eq(10000L));
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(freemarkerConfig).getTemplate(eq("test.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  void testSendTestMail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.isNull()).thenReturn(true);
    when(arrayNode.booleanValue()).thenReturn(true);
    when(arrayNode.isBoolean()).thenReturn(true);
    when(arrayNode.asBoolean()).thenReturn(true);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(true);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(arrayNode, atLeast(1)).asBoolean();
    verify(arrayNode).asLong(eq(10000L));
    verify(arrayNode).booleanValue();
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode).isBoolean();
    verify(arrayNode).isNull();
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(freemarkerConfig).getTemplate(eq("test.ftl"));
    verify(messages).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendTestMail(JsonNode, String)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does
   * nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#sendTestMail(JsonNode, String)}
   */
  @Test
  @DisplayName("Test sendTestMail(JsonNode, String); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  void testSendTestMail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));
    ArrayNode arrayNode = mock(ArrayNode.class);
    when(arrayNode.asLong(anyLong())).thenReturn(1L);
    when(arrayNode.isNull()).thenReturn(true);
    when(arrayNode.booleanValue()).thenReturn(true);
    when(arrayNode.isBoolean()).thenReturn(true);
    when(arrayNode.asBoolean()).thenReturn(true);
    when(arrayNode.asText()).thenReturn("42");
    ArrayNode jsonConfig = mock(ArrayNode.class);
    when(jsonConfig.has(Mockito.<String>any())).thenReturn(true);
    when(jsonConfig.get(Mockito.<String>any())).thenReturn(arrayNode);

    // Act and Assert
    assertThrows(ThingsboardException.class, () -> defaultMailService.sendTestMail(jsonConfig, "jane.doe@example.org"));
    verify(arrayNode, atLeast(1)).asBoolean();
    verify(arrayNode).asLong(eq(10000L));
    verify(arrayNode).booleanValue();
    verify(jsonConfig, atLeast(1)).has(Mockito.<String>any());
    verify(arrayNode).isBoolean();
    verify(arrayNode).isNull();
    verify(jsonConfig, atLeast(1)).get(Mockito.<String>any());
    verify(arrayNode, atLeast(1)).asText();
    verify(freemarkerConfig).getTemplate(eq("test.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("test.message.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendActivationEmail(String, long, String)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendActivationEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendActivationEmail(String, long, String)")
  void testSendActivationEmail() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendActivationEmail("Activation Link", 1L, "jane.doe@example.org"));
    verify(messages).getMessage(eq("activation.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendActivationEmail(String, long, String)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendActivationEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendActivationEmail(String, long, String)")
  void testSendActivationEmail2() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendActivationEmail("Activation Link", 1L, "jane.doe@example.org"));
    verify(messages).getMessage(eq("activation.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendActivationEmail(String, long, String)}.
   * <ul>
   *   <li>Given {@link Configuration#Configuration(Version)} with
   * incompatibleImprovements is Version.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendActivationEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendActivationEmail(String, long, String); given Configuration(Version) with incompatibleImprovements is Version")
  void testSendActivationEmail_givenConfigurationWithIncompatibleImprovementsIsVersion()
      throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration(Configuration.getVersion());
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendActivationEmail("Activation Link", 1L, "jane.doe@example.org"));
    verify(messages).getMessage(eq("activation.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendActivationEmail(String, long, String)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendActivationEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendActivationEmail(String, long, String); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  void testSendActivationEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendActivationEmail("Activation Link", 1L, "jane.doe@example.org"));
    verify(freemarkerConfig).getTemplate(eq("activation.ftl"));
    verify(messages).getMessage(eq("activation.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendActivationEmail(String, long, String)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does
   * nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendActivationEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendActivationEmail(String, long, String); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  void testSendActivationEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendActivationEmail("Activation Link", 1L, "jane.doe@example.org"));
    verify(freemarkerConfig).getTemplate(eq("activation.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("activation.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendAccountActivatedEmail(String, String)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendAccountActivatedEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendAccountActivatedEmail(String, String)")
  void testSendAccountActivatedEmail() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendAccountActivatedEmail("Login Link", "jane.doe@example.org"));
    verify(messages).getMessage(eq("account.activated.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendAccountActivatedEmail(String, String)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendAccountActivatedEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendAccountActivatedEmail(String, String)")
  void testSendAccountActivatedEmail2() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendAccountActivatedEmail("Login Link", "jane.doe@example.org"));
    verify(messages).getMessage(eq("account.activated.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendAccountActivatedEmail(String, String)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendAccountActivatedEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendAccountActivatedEmail(String, String)")
  void testSendAccountActivatedEmail3() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration(Configuration.getVersion());
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendAccountActivatedEmail("Login Link", "jane.doe@example.org"));
    verify(messages).getMessage(eq("account.activated.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendAccountActivatedEmail(String, String)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendAccountActivatedEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendAccountActivatedEmail(String, String); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  void testSendAccountActivatedEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendAccountActivatedEmail("Login Link", "jane.doe@example.org"));
    verify(freemarkerConfig).getTemplate(eq("account.activated.ftl"));
    verify(messages).getMessage(eq("account.activated.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendAccountActivatedEmail(String, String)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does
   * nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendAccountActivatedEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendAccountActivatedEmail(String, String); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  void testSendAccountActivatedEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendAccountActivatedEmail("Login Link", "jane.doe@example.org"));
    verify(freemarkerConfig).getTemplate(eq("account.activated.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("account.activated.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendResetPasswordEmail(String, long, String)")
  void testSendResetPasswordEmail() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendResetPasswordEmail("Password Reset Link", 1L, "jane.doe@example.org"));
    verify(messages).getMessage(eq("reset.password.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendResetPasswordEmail(String, long, String)")
  void testSendResetPasswordEmail2() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendResetPasswordEmail("Password Reset Link", 1L, "jane.doe@example.org"));
    verify(messages).getMessage(eq("reset.password.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendResetPasswordEmail(String, long, String)")
  void testSendResetPasswordEmail3() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration(Configuration.getVersion());
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendResetPasswordEmail("Password Reset Link", 1L, "jane.doe@example.org"));
    verify(messages).getMessage(eq("reset.password.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendResetPasswordEmail(String, long, String); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  void testSendResetPasswordEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendResetPasswordEmail("Password Reset Link", 1L, "jane.doe@example.org"));
    verify(freemarkerConfig).getTemplate(eq("reset.password.ftl"));
    verify(messages).getMessage(eq("reset.password.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does
   * nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendResetPasswordEmail(String, long, String)}
   */
  @Test
  @DisplayName("Test sendResetPasswordEmail(String, long, String); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  void testSendResetPasswordEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendResetPasswordEmail("Password Reset Link", 1L, "jane.doe@example.org"));
    verify(freemarkerConfig).getTemplate(eq("reset.password.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("reset.password.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendPasswordWasResetEmail(String, String)")
  void testSendPasswordWasResetEmail() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendPasswordWasResetEmail("Login Link", "jane.doe@example.org"));
    verify(messages).getMessage(eq("password.was.reset.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendPasswordWasResetEmail(String, String)")
  void testSendPasswordWasResetEmail2() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendPasswordWasResetEmail("Login Link", "jane.doe@example.org"));
    verify(messages).getMessage(eq("password.was.reset.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendPasswordWasResetEmail(String, String)")
  void testSendPasswordWasResetEmail3() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration(Configuration.getVersion());
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendPasswordWasResetEmail("Login Link", "jane.doe@example.org"));
    verify(messages).getMessage(eq("password.was.reset.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendPasswordWasResetEmail(String, String); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  void testSendPasswordWasResetEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendPasswordWasResetEmail("Login Link", "jane.doe@example.org"));
    verify(freemarkerConfig).getTemplate(eq("password.was.reset.ftl"));
    verify(messages).getMessage(eq("password.was.reset.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does
   * nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendPasswordWasResetEmail(String, String)}
   */
  @Test
  @DisplayName("Test sendPasswordWasResetEmail(String, String); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  void testSendPasswordWasResetEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendPasswordWasResetEmail("Login Link", "jane.doe@example.org"));
    verify(freemarkerConfig).getTemplate(eq("password.was.reset.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("password.was.reset.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}
   */
  @Test
  @DisplayName("Test sendAccountLockoutEmail(String, String, Integer)")
  void testSendAccountLockoutEmail() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendAccountLockoutEmail("jane.doe@example.org", "jane.doe@example.org", 3));
    verify(messages).getMessage(eq("account.lockout.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}
   */
  @Test
  @DisplayName("Test sendAccountLockoutEmail(String, String, Integer)")
  void testSendAccountLockoutEmail2() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendAccountLockoutEmail("jane.doe@example.org", "jane.doe@example.org", 3));
    verify(messages).getMessage(eq("account.lockout.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}
   */
  @Test
  @DisplayName("Test sendAccountLockoutEmail(String, String, Integer)")
  void testSendAccountLockoutEmail3() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration(Configuration.getVersion());
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendAccountLockoutEmail("jane.doe@example.org", "jane.doe@example.org", 3));
    verify(messages).getMessage(eq("account.lockout.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}
   */
  @Test
  @DisplayName("Test sendAccountLockoutEmail(String, String, Integer); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  void testSendAccountLockoutEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendAccountLockoutEmail("jane.doe@example.org", "jane.doe@example.org", 3));
    verify(freemarkerConfig).getTemplate(eq("account.lockout.ftl"));
    verify(messages).getMessage(eq("account.lockout.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does
   * nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendAccountLockoutEmail(String, String, Integer)}
   */
  @Test
  @DisplayName("Test sendAccountLockoutEmail(String, String, Integer); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  void testSendAccountLockoutEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendAccountLockoutEmail("jane.doe@example.org", "jane.doe@example.org", 3));
    verify(freemarkerConfig).getTemplate(eq("account.lockout.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("account.lockout.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}
   */
  @Test
  @DisplayName("Test sendTwoFaVerificationEmail(String, String, int)")
  void testSendTwoFaVerificationEmail() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendTwoFaVerificationEmail("jane.doe@example.org", "Verification Code", 1));
    verify(messages).getMessage(eq("2fa.verification.code.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}
   */
  @Test
  @DisplayName("Test sendTwoFaVerificationEmail(String, String, int)")
  void testSendTwoFaVerificationEmail2() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendTwoFaVerificationEmail("jane.doe@example.org", "Verification Code", 1));
    verify(messages).getMessage(eq("2fa.verification.code.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}
   */
  @Test
  @DisplayName("Test sendTwoFaVerificationEmail(String, String, int)")
  void testSendTwoFaVerificationEmail3() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration(Configuration.getVersion());
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendTwoFaVerificationEmail("jane.doe@example.org", "Verification Code", 1));
    verify(messages).getMessage(eq("2fa.verification.code.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}
   */
  @Test
  @DisplayName("Test sendTwoFaVerificationEmail(String, String, int); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  void testSendTwoFaVerificationEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendTwoFaVerificationEmail("jane.doe@example.org", "Verification Code", 1));
    verify(freemarkerConfig).getTemplate(eq("2fa.verification.code.ftl"));
    verify(messages).getMessage(eq("2fa.verification.code.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does
   * nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendTwoFaVerificationEmail(String, String, int)}
   */
  @Test
  @DisplayName("Test sendTwoFaVerificationEmail(String, String, int); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  void testSendTwoFaVerificationEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> (new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
            new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
                new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                    ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                    transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage())))))
            .sendTwoFaVerificationEmail("jane.doe@example.org", "Verification Code", 1));
    verify(freemarkerConfig).getTemplate(eq("2fa.verification.code.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("2fa.verification.code.subject"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)")
  void testSendApiFeatureStateEmail() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(messages).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)")
  void testSendApiFeatureStateEmail2() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(messages).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)")
  void testSendApiFeatureStateEmail3() throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = new Configuration(Configuration.getVersion());
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(messages).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>Given {@link StringReader#StringReader(String)} with {@code foo}.</li>
   *   <li>Then calls {@link Configuration#getTemplate(String)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); given StringReader(String) with 'foo'; then calls getTemplate(String)")
  void testSendApiFeatureStateEmail_givenStringReaderWithFoo_thenCallsGetTemplate()
      throws IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(new Template("Name", new StringReader("foo")));
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(freemarkerConfig).getTemplate(eq("state.enabled.ftl"));
    verify(messages).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>Given {@link Template} {@link Template#process(Object, Writer)} does
   * nothing.</li>
   *   <li>Then calls {@link Template#process(Object, Writer)}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); given Template process(Object, Writer) does nothing; then calls process(Object, Writer)")
  void testSendApiFeatureStateEmail_givenTemplateProcessDoesNothing_thenCallsProcess()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doNothing().when(template).process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(freemarkerConfig).getTemplate(eq("state.enabled.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code DB}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'DB'")
  void testSendApiFeatureStateEmail_whenDb()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.DB, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(freemarkerConfig).getTemplate(eq("state.enabled.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code DISABLED}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'DISABLED'")
  void testSendApiFeatureStateEmail_whenDisabled()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.DISABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(freemarkerConfig).getTemplate(eq("state.disabled.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code JS}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'JS'")
  void testSendApiFeatureStateEmail_whenJs()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.JS, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(freemarkerConfig).getTemplate(eq("state.enabled.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code RE}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'RE'")
  void testSendApiFeatureStateEmail_whenRe()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.RE, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(freemarkerConfig).getTemplate(eq("state.enabled.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code TBEL}.</li>
   *   <li>Then throw {@link RuntimeException}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'TBEL'; then throw RuntimeException")
  void testSendApiFeatureStateEmail_whenTbel_thenThrowRuntimeException()
      throws NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Configuration freemarkerConfig = mock(Configuration.class);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertThrows(RuntimeException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TBEL, ApiUsageStateValue.ENABLED,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(messages).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}.
   * <ul>
   *   <li>When {@code WARNING}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link DefaultMailService#sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState)}
   */
  @Test
  @DisplayName("Test sendApiFeatureStateEmail(ApiFeature, ApiUsageStateValue, String, ApiUsageRecordState); when 'WARNING'")
  void testSendApiFeatureStateEmail_whenWarning()
      throws TemplateException, IOException, NoSuchMessageException, ThingsboardException {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigApplicationContext messages = mock(AnnotationConfigApplicationContext.class);
    when(messages.getMessage(Mockito.<String>any(), Mockito.<Object[]>any(), Mockito.<Locale>any()))
        .thenReturn("Not all who wander are lost");
    Template template = mock(Template.class);
    doThrow(new IncorrectParameterException("An error occurred")).when(template)
        .process(Mockito.<Object>any(), Mockito.<Writer>any());
    Configuration freemarkerConfig = mock(Configuration.class);
    when(freemarkerConfig.getTemplate(Mockito.<String>any())).thenReturn(template);
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertThrows(ThingsboardException.class,
        () -> defaultMailService.sendApiFeatureStateEmail(ApiFeature.TRANSPORT, ApiUsageStateValue.WARNING,
            "jane.doe@example.org",
            new ApiUsageRecordState(ApiFeature.TRANSPORT, ApiUsageRecordKey.TRANSPORT_MSG_COUNT, 1L, 42L)));
    verify(freemarkerConfig).getTemplate(eq("state.warning.ftl"));
    verify(template).process(isA(Object.class), isA(Writer.class));
    verify(messages).getMessage(eq("api.usage.state"), isNull(), isA(Locale.class));
  }

  /**
   * Test {@link DefaultMailService#isConfigured(TenantId)}.
   * <p>
   * Method under test: {@link DefaultMailService#isConfigured(TenantId)}
   */
  @Test
  @DisplayName("Test isConfigured(TenantId)")
  void testIsConfigured() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act and Assert
    assertFalse(defaultMailService.isConfigured(new TenantId(UUID.randomUUID())));
  }

  /**
   * Test {@link DefaultMailService#handleException(Throwable)}.
   * <ul>
   *   <li>Then return LocalizedMessage is {@code Unable to send mail: null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link DefaultMailService#handleException(Throwable)}
   */
  @Test
  @DisplayName("Test handleException(Throwable); then return LocalizedMessage is 'Unable to send mail: null'")
  void testHandleException_thenReturnLocalizedMessageIsUnableToSendMailNull() {
    //   Diffblue Cover was unable to create a Spring-specific test for this Spring method.

    // Arrange
    AnnotationConfigReactiveWebApplicationContext messages = new AnnotationConfigReactiveWebApplicationContext();
    Configuration freemarkerConfig = Configuration.getDefaultConfiguration();
    AdminSettingsServiceImpl adminSettingsService = new AdminSettingsServiceImpl();
    DefaultTbServiceInfoProvider serviceInfoProvider = new DefaultTbServiceInfoProvider();
    TenantRoutingInfoService tenantRoutingInfoService = mock(TenantRoutingInfoService.class);
    ApplicationEventPublisher applicationEventPublisher = mock(ApplicationEventPublisher.class);
    QueueRoutingInfoService queueRoutingInfoService = mock(QueueRoutingInfoService.class);
    HashPartitionService partitionService = new HashPartitionService(serviceInfoProvider, tenantRoutingInfoService,
        applicationEventPublisher, queueRoutingInfoService, new TopicService());

    DefaultTbServiceInfoProvider serviceInfoProvider2 = new DefaultTbServiceInfoProvider();
    DefaultSchedulerComponent scheduler = new DefaultSchedulerComponent();
    TopicService topicService = new TopicService();
    TbQueueCoreSettings coreSettings = new TbQueueCoreSettings();
    TbQueueRuleEngineSettings ruleEngineSettings = new TbQueueRuleEngineSettings();
    TbQueueVersionControlSettings vcSettings = new TbQueueVersionControlSettings();
    DefaultTbServiceInfoProvider serviceInfoProvider3 = new DefaultTbServiceInfoProvider();
    TbQueueTransportApiSettings transportApiSettings = new TbQueueTransportApiSettings();
    TbQueueTransportNotificationSettings transportNotificationSettings = new TbQueueTransportNotificationSettings();
    TbQueueEdgeSettings edgeSettings = new TbQueueEdgeSettings();
    DefaultMailService defaultMailService = new DefaultMailService(messages, freemarkerConfig, adminSettingsService,
        new DefaultTbApiUsageReportClient(partitionService, serviceInfoProvider2, scheduler,
            new TbCoreQueueProducerProvider(new InMemoryMonolithQueueFactory(topicService, coreSettings,
                ruleEngineSettings, vcSettings, serviceInfoProvider3, transportApiSettings,
                transportNotificationSettings, edgeSettings, new DefaultInMemoryStorage()))));

    // Act
    ThingsboardException actualHandleExceptionResult = defaultMailService.handleException(new Throwable());

    // Assert
    assertEquals("Unable to send mail: null", actualHandleExceptionResult.getLocalizedMessage());
    assertEquals("Unable to send mail: null", actualHandleExceptionResult.getMessage());
    assertNull(actualHandleExceptionResult.getCause());
    assertEquals(0, actualHandleExceptionResult.getSuppressed().length);
    assertEquals(ThingsboardErrorCode.GENERAL, actualHandleExceptionResult.getErrorCode());
  }
}
