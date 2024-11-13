package org.thingsboard.server.service.notification.rule.trigger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.TenantProfile;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.info.EntitiesLimitNotificationInfo;
import org.thingsboard.server.common.data.notification.info.RuleOriginatedNotificationInfo;
import org.thingsboard.server.common.data.notification.rule.trigger.EntitiesLimitTrigger;
import org.thingsboard.server.common.data.notification.rule.trigger.config.EntitiesLimitNotificationRuleTriggerConfig;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.entity.BaseEntityCountService;
import org.thingsboard.server.dao.entity.EntityCountService;
import org.thingsboard.server.dao.tenant.DefaultTbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TbTenantProfileCache;
import org.thingsboard.server.dao.tenant.TenantProfileServiceImpl;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.dao.tenant.TenantServiceImpl;

@ContextConfiguration(classes = {EntitiesLimitTriggerProcessor.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class EntitiesLimitTriggerProcessorDiffblueTest {
  @Autowired
  private EntitiesLimitTriggerProcessor entitiesLimitTriggerProcessor;

  @MockBean
  private EntityCountService entityCountService;

  @MockBean
  private TbTenantProfileCache tbTenantProfileCache;

  @MockBean
  private TenantService tenantService;

  /**
   * Test
   * {@link EntitiesLimitTriggerProcessor#matchesFilter(EntitiesLimitTrigger, EntitiesLimitNotificationRuleTriggerConfig)}
   * with {@code EntitiesLimitTrigger},
   * {@code EntitiesLimitNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link EntitiesLimitTriggerProcessor#matchesFilter(EntitiesLimitTrigger, EntitiesLimitNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntitiesLimitTrigger, EntitiesLimitNotificationRuleTriggerConfig) with 'EntitiesLimitTrigger', 'EntitiesLimitNotificationRuleTriggerConfig'")
  void testMatchesFilterWithEntitiesLimitTriggerEntitiesLimitNotificationRuleTriggerConfig() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile());
    EntitiesLimitTrigger.EntitiesLimitTriggerBuilder limitResult = EntitiesLimitTrigger.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L);
    EntitiesLimitTrigger trigger = limitResult.tenantId(new TenantId(UUID.randomUUID())).build();
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult = EntitiesLimitNotificationRuleTriggerConfig
        .builder();
    EntitiesLimitNotificationRuleTriggerConfig triggerConfig = builderResult.entityTypes(new HashSet<>())
        .threshold(10.0f)
        .build();

    // Act
    boolean actualMatchesFilterResult = entitiesLimitTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link EntitiesLimitTriggerProcessor#matchesFilter(EntitiesLimitTrigger, EntitiesLimitNotificationRuleTriggerConfig)}
   * with {@code EntitiesLimitTrigger},
   * {@code EntitiesLimitNotificationRuleTriggerConfig}.
   * <p>
   * Method under test:
   * {@link EntitiesLimitTriggerProcessor#matchesFilter(EntitiesLimitTrigger, EntitiesLimitNotificationRuleTriggerConfig)}
   */
  @Test
  @DisplayName("Test matchesFilter(EntitiesLimitTrigger, EntitiesLimitNotificationRuleTriggerConfig) with 'EntitiesLimitTrigger', 'EntitiesLimitNotificationRuleTriggerConfig'")
  void testMatchesFilterWithEntitiesLimitTriggerEntitiesLimitNotificationRuleTriggerConfig2() {
    // Arrange
    when(tbTenantProfileCache.get(Mockito.<TenantId>any())).thenReturn(new TenantProfile(new TenantProfile()));
    EntitiesLimitTrigger.EntitiesLimitTriggerBuilder limitResult = EntitiesLimitTrigger.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L);
    EntitiesLimitTrigger trigger = limitResult.tenantId(new TenantId(UUID.randomUUID())).build();
    EntitiesLimitNotificationRuleTriggerConfig.EntitiesLimitNotificationRuleTriggerConfigBuilder builderResult = EntitiesLimitNotificationRuleTriggerConfig
        .builder();
    EntitiesLimitNotificationRuleTriggerConfig triggerConfig = builderResult.entityTypes(new HashSet<>())
        .threshold(10.0f)
        .build();

    // Act
    boolean actualMatchesFilterResult = entitiesLimitTriggerProcessor.matchesFilter(trigger, triggerConfig);

    // Assert
    verify(tbTenantProfileCache).get(isA(TenantId.class));
    assertFalse(actualMatchesFilterResult);
  }

  /**
   * Test
   * {@link EntitiesLimitTriggerProcessor#constructNotificationInfo(EntitiesLimitTrigger)}
   * with {@code EntitiesLimitTrigger}.
   * <p>
   * Method under test:
   * {@link EntitiesLimitTriggerProcessor#constructNotificationInfo(EntitiesLimitTrigger)}
   */
  @Test
  @DisplayName("Test constructNotificationInfo(EntitiesLimitTrigger) with 'EntitiesLimitTrigger'")
  void testConstructNotificationInfoWithEntitiesLimitTrigger() {
    // Arrange
    when(tenantService.findTenantById(Mockito.<TenantId>any())).thenReturn(new Tenant());
    EntitiesLimitTrigger.EntitiesLimitTriggerBuilder limitResult = EntitiesLimitTrigger.builder()
        .currentCount(3L)
        .entityType(EntityType.TENANT)
        .limit(1L);
    TenantId tenantId = new TenantId(UUID.randomUUID());
    EntitiesLimitTrigger trigger = limitResult.tenantId(tenantId).build();

    // Act
    RuleOriginatedNotificationInfo actualConstructNotificationInfoResult = entitiesLimitTriggerProcessor
        .constructNotificationInfo(trigger);

    // Assert
    verify(tenantService).findTenantById(isA(TenantId.class));
    assertTrue(actualConstructNotificationInfoResult instanceof EntitiesLimitNotificationInfo);
    Map<String, String> templateData = actualConstructNotificationInfoResult.getTemplateData();
    assertEquals(6, templateData.size());
    assertEquals("1", templateData.get("limit"));
    assertEquals("3", templateData.get("currentCount"));
    assertEquals("300", templateData.get("percents"));
    assertEquals("Tenant", templateData.get("entityType"));
    assertNull(templateData.get("tenantName"));
    assertNull(((EntitiesLimitNotificationInfo) actualConstructNotificationInfoResult).getTenantName());
    assertNull(actualConstructNotificationInfoResult.getAffectedCustomerId());
    assertNull(actualConstructNotificationInfoResult.getDashboardId());
    assertNull(actualConstructNotificationInfoResult.getStateEntityId());
    assertNull(actualConstructNotificationInfoResult.getAffectedUserId());
    assertEquals(1L, ((EntitiesLimitNotificationInfo) actualConstructNotificationInfoResult).getLimit());
    assertEquals(300, ((EntitiesLimitNotificationInfo) actualConstructNotificationInfoResult).getPercents());
    assertEquals(3L, ((EntitiesLimitNotificationInfo) actualConstructNotificationInfoResult).getCurrentCount());
    assertEquals(EntityType.TENANT,
        ((EntitiesLimitNotificationInfo) actualConstructNotificationInfoResult).getEntityType());
    assertTrue(templateData.containsKey("tenantId"));
    assertSame(tenantId, ((EntitiesLimitNotificationInfo) actualConstructNotificationInfoResult).getTenantId());
    assertSame(tenantId, actualConstructNotificationInfoResult.getAffectedTenantId());
  }

  /**
   * Test {@link EntitiesLimitTriggerProcessor#getTriggerType()}.
   * <p>
   * Method under test: {@link EntitiesLimitTriggerProcessor#getTriggerType()}
   */
  @Test
  @DisplayName("Test getTriggerType()")
  void testGetTriggerType() {
    // Arrange
    BaseEntityCountService entityCountService = new BaseEntityCountService();
    TenantProfileServiceImpl tenantProfileService = new TenantProfileServiceImpl();
    DefaultTbTenantProfileCache tenantProfileCache = new DefaultTbTenantProfileCache(tenantProfileService,
        new TenantServiceImpl());

    // Act and Assert
    assertEquals(NotificationRuleTriggerType.ENTITIES_LIMIT,
        (new EntitiesLimitTriggerProcessor(entityCountService, tenantProfileCache, new TenantServiceImpl()))
            .getTriggerType());
  }
}
