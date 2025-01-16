package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
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
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.limit.LimitedApi;
import org.thingsboard.server.common.data.notification.info.RateLimitsNotificationInfo;
import org.thingsboard.server.common.data.notification.info.RuleOriginatedNotificationInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.RateLimitsTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.common.data.notification.rule.trigger.config.RateLimitsNotificationRuleTriggerConfig;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.entity.EntityService;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

@ContextConfiguration(classes = {RateLimitsTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class RateLimitsTriggerProcessorDiffblueTest {
  @MockBean
  private EntityService entityService;

  @Autowired
  private RateLimitsTriggerProcessor rateLimitsTriggerProcessor;

  @MockBean
  private TenantService tenantService;

  /**
   * Test
   * {@link RateLimitsTriggerProcessor#matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig)}
   * with {@code RateLimitsTrigger},
   * {@code RateLimitsNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link RateLimitsTriggerProcessor#matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig) with 'RateLimitsTrigger', 'RateLimitsNotificationRuleTriggerConfig'")
  void testMatchesFilterWithRateLimitsTriggerRateLimitsNotificationRuleTriggerConfig() {
    // Arrange
    RateLimitsTrigger trigger = mock(RateLimitsTrigger.class);
    when(trigger.getLimitLevel()).thenReturn(null);

    // Act
    boolean actualMatchesFilterResult = rateLimitsTriggerProcessor.matchesFilter(trigger,
        new RateLimitsNotificationRuleTriggerConfig());

    // Assert
    verify(trigger).getLimitLevel();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link RateLimitsTriggerProcessor#matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig)}
   * with {@code RateLimitsTrigger},
   * {@code RateLimitsNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link RateLimitsTriggerProcessor#matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig) with 'RateLimitsTrigger', 'RateLimitsNotificationRuleTriggerConfig'")
  void testMatchesFilterWithRateLimitsTriggerRateLimitsNotificationRuleTriggerConfig2() {
    // Arrange
    RateLimitsTrigger trigger = mock(RateLimitsTrigger.class);
    when(trigger.getApi()).thenReturn(LimitedApi.ENTITY_EXPORT);
    when(trigger.getLimitLevel()).thenReturn(new AlarmId(UUID.randomUUID()));

    // Act
    boolean actualMatchesFilterResult = rateLimitsTriggerProcessor.matchesFilter(trigger,
        new RateLimitsNotificationRuleTriggerConfig());

    // Assert
    verify(trigger, atLeast(1)).getApi();
    verify(trigger).getLimitLevel();
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link RateLimitsTriggerProcessor#matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig)}
   * with {@code RateLimitsTrigger},
   * {@code RateLimitsNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link RateLimitsTriggerProcessor#matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig) with 'RateLimitsTrigger', 'RateLimitsNotificationRuleTriggerConfig'")
  void testMatchesFilterWithRateLimitsTriggerRateLimitsNotificationRuleTriggerConfig3() {
    // Arrange
    RateLimitsTrigger trigger = mock(RateLimitsTrigger.class);
    when(trigger.getApi()).thenReturn(LimitedApi.ENTITY_EXPORT);
    when(trigger.getLimitLevel()).thenReturn(new AlarmId(UUID.randomUUID()));
    RateLimitsNotificationRuleTriggerConfig.RateLimitsNotificationRuleTriggerConfigBuilder builderResult = RateLimitsNotificationRuleTriggerConfig
        .builder();
    RateLimitsNotificationRuleTriggerConfig triggerConfig = builderResult.apis(new HashSet<>()).build();

    // Act
    boolean actualMatchesFilterResult = rateLimitsTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger, atLeast(1)).getApi();
    verify(trigger).getLimitLevel();
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link RateLimitsTriggerProcessor#matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig)}
   * with {@code RateLimitsTrigger},
   * {@code RateLimitsNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link RateLimitsTriggerProcessor#matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig) with 'RateLimitsTrigger', 'RateLimitsNotificationRuleTriggerConfig'")
  void testMatchesFilterWithRateLimitsTriggerRateLimitsNotificationRuleTriggerConfig4() {
    // Arrange
    RateLimitsTrigger trigger = mock(RateLimitsTrigger.class);
    when(trigger.getApi()).thenReturn(LimitedApi.ENTITY_EXPORT);
    when(trigger.getLimitLevel()).thenReturn(new AlarmId(UUID.randomUUID()));

    HashSet<LimitedApi> apis = new HashSet<>();
    apis.add(LimitedApi.ENTITY_EXPORT);
    RateLimitsNotificationRuleTriggerConfig triggerConfig = RateLimitsNotificationRuleTriggerConfig.builder()
        .apis(apis)
        .build();

    // Act
    boolean actualMatchesFilterResult = rateLimitsTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger, atLeast(1)).getApi();
    verify(trigger).getLimitLevel();
    assertTrue(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link RateLimitsTriggerProcessor#matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig)}
   * with {@code RateLimitsTrigger},
   * {@code RateLimitsNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link RateLimitsTriggerProcessor#matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(RateLimitsTrigger, RateLimitsNotificationRuleTriggerConfig) with 'RateLimitsTrigger', 'RateLimitsNotificationRuleTriggerConfig'")
  void testMatchesFilterWithRateLimitsTriggerRateLimitsNotificationRuleTriggerConfig5() {
    // Arrange
    RateLimitsTrigger trigger = mock(RateLimitsTrigger.class);
    when(trigger.getApi()).thenReturn(LimitedApi.ENTITY_IMPORT);
    when(trigger.getLimitLevel()).thenReturn(new AlarmId(UUID.randomUUID()));

    HashSet<LimitedApi> apis = new HashSet<>();
    apis.add(LimitedApi.ENTITY_EXPORT);
    RateLimitsNotificationRuleTriggerConfig triggerConfig = RateLimitsNotificationRuleTriggerConfig.builder()
        .apis(apis)
        .build();

    // Act
    boolean actualMatchesFilterResult = rateLimitsTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(trigger, atLeast(1)).getApi();
    verify(trigger).getLimitLevel();
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link RateLimitsTriggerProcessor#constructNotificationInfo(RateLimitsTrigger)}
   * with {@code RateLimitsTrigger}.
   * <p>
   * Method under test:
   * {@link RateLimitsTriggerProcessor#constructNotificationInfo(RateLimitsTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(RateLimitsTrigger) with 'RateLimitsTrigger'")
  void testConstructNotificationInfoWithRateLimitsTrigger() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());
    RateLimitsTrigger trigger = mock(RateLimitsTrigger.class);
    when(trigger.getLimitLevel()).thenReturn(null);
    when(trigger.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(trigger.getApi()).thenReturn(LimitedApi.ENTITY_EXPORT);

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = rateLimitsTriggerProcessor
        .constructNotificationInfo(trigger);

    // Assert
    verify(trigger).getApi();
    verify(trigger).getLimitLevel();
    verify(trigger, atLeast(1)).getTenantId();
    verify(tenantService).findTenantById(isA(TenantId.class));
    assertTrue(actualConstructNotificationInfoResult instanceof RateLimitsNotificationInfo);
    Map<String, String> templateData = actualConstructNotificationInfoResult.getTemplateData();
    assertEquals(6, templateData.size());
    assertNull(templateData.get("limitLevelEntityId"));
    assertNull(templateData.get("limitLevelEntityName"));
    assertNull(templateData.get("limitLevelEntityType"));
    assertNull(((RateLimitsNotificationInfo) actualConstructNotificationInfoResult).getLimitLevelEntityName());
    assertNull(((RateLimitsNotificationInfo) actualConstructNotificationInfoResult).getLimitLevel());
    assertTrue(templateData.containsKey("api"));
    assertTrue(templateData.containsKey("tenantId"));
    assertTrue(templateData.containsKey("tenantName"));
  }

  /**
   * Test
   * {@link RateLimitsTriggerProcessor#constructNotificationInfo(RateLimitsTrigger)}
   * with {@code RateLimitsTrigger}.
   * <p>
   * Method under test:
   * {@link RateLimitsTriggerProcessor#constructNotificationInfo(RateLimitsTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(RateLimitsTrigger) with 'RateLimitsTrigger'")
  void testConstructNotificationInfoWithRateLimitsTrigger2() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());
    RateLimitsTrigger trigger = mock(RateLimitsTrigger.class);
    when(trigger.getLimitLevelEntityName()).thenReturn("Limit Level Entity Name");
    when(trigger.getLimitLevel()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(trigger.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(trigger.getApi()).thenReturn(LimitedApi.ENTITY_EXPORT);

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = rateLimitsTriggerProcessor
        .constructNotificationInfo(trigger);

    // Assert
    verify(trigger).getApi();
    verify(trigger).getLimitLevel();
    verify(trigger).getLimitLevelEntityName();
    verify(trigger, atLeast(1)).getTenantId();
    verify(tenantService).findTenantById(isA(TenantId.class));
    assertTrue(actualConstructNotificationInfoResult instanceof RateLimitsNotificationInfo);
    Map<String, String> templateData = actualConstructNotificationInfoResult.getTemplateData();
    assertEquals(6, templateData.size());
    assertEquals("Limit Level Entity Name", templateData.get("limitLevelEntityName"));
    assertEquals("Limit Level Entity Name",
        ((RateLimitsNotificationInfo) actualConstructNotificationInfoResult).getLimitLevelEntityName());
    assertTrue(templateData.containsKey("api"));
    assertTrue(templateData.containsKey("limitLevelEntityId"));
    assertTrue(templateData.containsKey("limitLevelEntityType"));
    assertTrue(templateData.containsKey("tenantId"));
    assertTrue(templateData.containsKey("tenantName"));
  }

  /**
   * Test
   * {@link RateLimitsTriggerProcessor#constructNotificationInfo(RateLimitsTrigger)}
   * with {@code RateLimitsTrigger}.
   * <p>
   * Method under test:
   * {@link RateLimitsTriggerProcessor#constructNotificationInfo(RateLimitsTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(RateLimitsTrigger) with 'RateLimitsTrigger'")
  void testConstructNotificationInfoWithRateLimitsTrigger3() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());
    Optional<String> ofResult = Optional.of("foo");
    when(entityService.fetchEntityName(Mockito.<TenantId>any(), Mockito.<EntityId>any())).thenReturn(ofResult);
    RateLimitsTrigger trigger = mock(RateLimitsTrigger.class);
    when(trigger.getLimitLevelEntityName()).thenReturn(null);
    when(trigger.getLimitLevel()).thenReturn(new AlarmId(UUID.randomUUID()));
    when(trigger.getTenantId()).thenReturn(new TenantId(UUID.randomUUID()));
    when(trigger.getApi()).thenReturn(LimitedApi.ENTITY_EXPORT);

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = rateLimitsTriggerProcessor
        .constructNotificationInfo(trigger);

    // Assert
    verify(trigger).getApi();
    verify(trigger).getLimitLevel();
    verify(trigger).getLimitLevelEntityName();
    verify(trigger, atLeast(1)).getTenantId();
    verify(entityService).fetchEntityName(isA(TenantId.class), isA(EntityId.class));
    verify(tenantService).findTenantById(isA(TenantId.class));
    assertTrue(actualConstructNotificationInfoResult instanceof RateLimitsNotificationInfo);
    Map<String, String> templateData = actualConstructNotificationInfoResult.getTemplateData();
    assertEquals(6, templateData.size());
    assertEquals("foo", templateData.get("limitLevelEntityName"));
    assertEquals("foo", ((RateLimitsNotificationInfo) actualConstructNotificationInfoResult).getLimitLevelEntityName());
    assertTrue(templateData.containsKey("api"));
    assertTrue(templateData.containsKey("limitLevelEntityId"));
    assertTrue(templateData.containsKey("limitLevelEntityType"));
    assertTrue(templateData.containsKey("tenantId"));
    assertTrue(templateData.containsKey("tenantName"));
  }

  /**
   * Test {@link RateLimitsTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link RateLimitsTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  void testGetTriggerType() {
    // Arrange
    TenantServiceImpl tenantService = new TenantServiceImpl();

    // Act and Assert
    assertEquals(NotificationRuleTriggerType.RATE_LIMITS,
        (new RateLimitsTriggerProcessor(tenantService, new BaseEntityService())).getTriggerType());
  }
}
