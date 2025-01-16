package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.ArrayList;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.NotificationRequest;
import org.thingsboard.server.common.data.notification.NotificationRequestStats;
import org.thingsboard.server.common.data.notification.NotificationRequestStatus;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationRequestEntityDiffblueTest {
  /**
   * Test {@link NotificationRequestEntity#equals(Object)}, and
   * {@link NotificationRequestEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestEntity#equals(Object)}
   *   <li>{@link NotificationRequestEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRequestEntity, notificationRequestEntity2);
    int expectedHashCodeResult = notificationRequestEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}, and
   * {@link NotificationRequestEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestEntity#equals(Object)}
   *   <li>{@link NotificationRequestEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRequestEntity, notificationRequestEntity2);
    int expectedHashCodeResult = notificationRequestEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}, and
   * {@link NotificationRequestEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestEntity#equals(Object)}
   *   <li>{@link NotificationRequestEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);
    NotificationRequestInfoEntity notificationRequestInfoEntity = mock(NotificationRequestInfoEntity.class);
    when(notificationRequestInfoEntity.getStats()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRequestInfoEntity.getStatus()).thenReturn(NotificationRequestStatus.PROCESSING);
    when(notificationRequestInfoEntity.getRuleId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRequestInfoEntity.getOriginatorEntityType()).thenReturn(EntityType.TENANT);
    when(notificationRequestInfoEntity.getOriginatorEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRequestInfoEntity.getAdditionalConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRequestInfoEntity.getInfo()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRequestInfoEntity.getTemplate())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRequestInfoEntity.getTemplateId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRequestInfoEntity.getTargets()).thenReturn("Targets");
    when(notificationRequestInfoEntity.getTenantId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRequestInfoEntity.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRequestInfoEntity.getCreatedTime()).thenReturn(1L);
    when(notificationRequestInfoEntity.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(notificationRequestInfoEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRequestInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRequestInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRequestInfoEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestInfoEntity).setInfo(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestInfoEntity).setOriginatorEntityId(Mockito.<UUID>any());
    doNothing().when(notificationRequestInfoEntity).setOriginatorEntityType(Mockito.<EntityType>any());
    doNothing().when(notificationRequestInfoEntity).setRuleId(Mockito.<UUID>any());
    doNothing().when(notificationRequestInfoEntity).setStats(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestInfoEntity).setStatus(Mockito.<NotificationRequestStatus>any());
    doNothing().when(notificationRequestInfoEntity).setTargets(Mockito.<String>any());
    doNothing().when(notificationRequestInfoEntity).setTemplate(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestInfoEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRequestInfoEntity).setTenantId(Mockito.<UUID>any());
    notificationRequestInfoEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestInfoEntity.setCreatedTime(1L);
    notificationRequestInfoEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestInfoEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestInfoEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestInfoEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestInfoEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestInfoEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestInfoEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestInfoEntity.setTargets("Targets");
    notificationRequestInfoEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestInfoEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRequestEntity, notificationRequestInfoEntity);
    int notExpectedHashCodeResult = notificationRequestEntity.hashCode();
    assertNotEquals(notExpectedHashCodeResult, notificationRequestInfoEntity.hashCode());
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}, and
   * {@link NotificationRequestEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestEntity#equals(Object)}
   *   <li>{@link NotificationRequestEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRequestEntity, notificationRequestEntity);
    int expectedHashCodeResult = notificationRequestEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationRequestEntity.hashCode());
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(null);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(3L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(MissingNode.getInstance());
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(null);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(UUID.randomUUID());
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(null);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(null);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.CUSTOMER);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(UUID.randomUUID());
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(null);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(MissingNode.getInstance());
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(null);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(null);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.SENT);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets(null);
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("org.thingsboard.server.dao.model.sql.NotificationRequestEntity");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(MissingNode.getInstance());
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(null);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(UUID.randomUUID());
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(null);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(UUID.randomUUID());
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(null);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRequestEntity notificationRequestEntity2 = new NotificationRequestEntity();
    notificationRequestEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setCreatedTime(1L);
    notificationRequestEntity2.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity2.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity2.setTargets("Targets");
    notificationRequestEntity2.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestEntity2);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    NotificationRequest.NotificationRequestBuilder notificationRequestBuilder = mock(
        NotificationRequest.NotificationRequestBuilder.class);
    when(notificationRequestBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(NotificationRequest.builder());
    NotificationRequest.NotificationRequestBuilder originatorEntityIdResult = notificationRequestBuilder
        .info(mock(NotificationInfo.class))
        .originatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);
    NotificationRequest.NotificationRequestBuilder ruleIdResult = originatorEntityIdResult
        .ruleId(new NotificationRuleId(ModelConstants.NULL_UUID));
    NotificationRequest.NotificationRequestBuilder statusResult = ruleIdResult.stats(new NotificationRequestStats())
        .status(NotificationRequestStatus.PROCESSING);
    NotificationRequest.NotificationRequestBuilder targetsResult = statusResult.targets(new ArrayList<>());
    NotificationRequest.NotificationRequestBuilder templateResult = targetsResult.template(new NotificationTemplate());
    NotificationRequest notificationRequest = templateResult
        .templateId(new NotificationTemplateId(ModelConstants.NULL_UUID))
        .tenantId(ModelConstants.SYSTEM_TENANT)
        .build();

    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity(notificationRequest);
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);
    NotificationRequestInfoEntity notificationRequestInfoEntity = mock(NotificationRequestInfoEntity.class);
    when(notificationRequestInfoEntity.getStats()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRequestInfoEntity.getStatus()).thenReturn(NotificationRequestStatus.PROCESSING);
    when(notificationRequestInfoEntity.getRuleId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRequestInfoEntity.getOriginatorEntityType()).thenReturn(EntityType.TENANT);
    when(notificationRequestInfoEntity.getOriginatorEntityId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRequestInfoEntity.getAdditionalConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRequestInfoEntity.getInfo()).thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRequestInfoEntity.getTemplate())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRequestInfoEntity.getTemplateId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRequestInfoEntity.getTargets()).thenReturn("Targets");
    when(notificationRequestInfoEntity.getTenantId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRequestInfoEntity.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRequestInfoEntity.getCreatedTime()).thenReturn(1L);
    when(notificationRequestInfoEntity.canEqual(Mockito.<Object>any())).thenReturn(false);
    doNothing().when(notificationRequestInfoEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRequestInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRequestInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRequestInfoEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestInfoEntity).setInfo(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestInfoEntity).setOriginatorEntityId(Mockito.<UUID>any());
    doNothing().when(notificationRequestInfoEntity).setOriginatorEntityType(Mockito.<EntityType>any());
    doNothing().when(notificationRequestInfoEntity).setRuleId(Mockito.<UUID>any());
    doNothing().when(notificationRequestInfoEntity).setStats(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestInfoEntity).setStatus(Mockito.<NotificationRequestStatus>any());
    doNothing().when(notificationRequestInfoEntity).setTargets(Mockito.<String>any());
    doNothing().when(notificationRequestInfoEntity).setTemplate(Mockito.<JsonNode>any());
    doNothing().when(notificationRequestInfoEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRequestInfoEntity).setTenantId(Mockito.<UUID>any());
    notificationRequestInfoEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestInfoEntity.setCreatedTime(1L);
    notificationRequestInfoEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestInfoEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestInfoEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestInfoEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestInfoEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestInfoEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestInfoEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestInfoEntity.setTargets("Targets");
    notificationRequestInfoEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestInfoEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, notificationRequestInfoEntity);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, null);
  }

  /**
   * Test {@link NotificationRequestEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRequestEntity notificationRequestEntity = new NotificationRequestEntity();
    notificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setCreatedTime(1L);
    notificationRequestEntity.setId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    notificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    notificationRequestEntity.setTargets("Targets");
    notificationRequestEntity.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRequestEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRequestEntity, "Different type to NotificationRequestEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRequestEntity#NotificationRequestEntity()}
   *   <li>{@link NotificationRequestEntity#setAdditionalConfig(JsonNode)}
   *   <li>{@link NotificationRequestEntity#setInfo(JsonNode)}
   *   <li>{@link NotificationRequestEntity#setOriginatorEntityId(UUID)}
   *   <li>{@link NotificationRequestEntity#setOriginatorEntityType(EntityType)}
   *   <li>{@link NotificationRequestEntity#setRuleId(UUID)}
   *   <li>{@link NotificationRequestEntity#setStats(JsonNode)}
   *   <li>{@link NotificationRequestEntity#setStatus(NotificationRequestStatus)}
   *   <li>{@link NotificationRequestEntity#setTargets(String)}
   *   <li>{@link NotificationRequestEntity#setTemplate(JsonNode)}
   *   <li>{@link NotificationRequestEntity#setTemplateId(UUID)}
   *   <li>{@link NotificationRequestEntity#setTenantId(UUID)}
   *   <li>{@link NotificationRequestEntity#toString()}
   *   <li>{@link NotificationRequestEntity#getAdditionalConfig()}
   *   <li>{@link NotificationRequestEntity#getInfo()}
   *   <li>{@link NotificationRequestEntity#getOriginatorEntityId()}
   *   <li>{@link NotificationRequestEntity#getOriginatorEntityType()}
   *   <li>{@link NotificationRequestEntity#getRuleId()}
   *   <li>{@link NotificationRequestEntity#getStats()}
   *   <li>{@link NotificationRequestEntity#getStatus()}
   *   <li>{@link NotificationRequestEntity#getTargets()}
   *   <li>{@link NotificationRequestEntity#getTemplate()}
   *   <li>{@link NotificationRequestEntity#getTemplateId()}
   *   <li>{@link NotificationRequestEntity#getTenantId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationRequestEntity actualNotificationRequestEntity = new NotificationRequestEntity();
    actualNotificationRequestEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRequestEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRequestEntity.setOriginatorEntityId(ModelConstants.NULL_UUID);
    actualNotificationRequestEntity.setOriginatorEntityType(EntityType.TENANT);
    actualNotificationRequestEntity.setRuleId(ModelConstants.NULL_UUID);
    actualNotificationRequestEntity.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRequestEntity.setStatus(NotificationRequestStatus.PROCESSING);
    actualNotificationRequestEntity.setTargets("Targets");
    JsonNode template = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationRequestEntity.setTemplate(template);
    actualNotificationRequestEntity.setTemplateId(ModelConstants.NULL_UUID);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualNotificationRequestEntity.setTenantId(tenantId);
    String actualToStringResult = actualNotificationRequestEntity.toString();
    JsonNode actualAdditionalConfig = actualNotificationRequestEntity.getAdditionalConfig();
    JsonNode actualInfo = actualNotificationRequestEntity.getInfo();
    UUID actualOriginatorEntityId = actualNotificationRequestEntity.getOriginatorEntityId();
    EntityType actualOriginatorEntityType = actualNotificationRequestEntity.getOriginatorEntityType();
    UUID actualRuleId = actualNotificationRequestEntity.getRuleId();
    JsonNode actualStats = actualNotificationRequestEntity.getStats();
    NotificationRequestStatus actualStatus = actualNotificationRequestEntity.getStatus();
    String actualTargets = actualNotificationRequestEntity.getTargets();
    JsonNode actualTemplate = actualNotificationRequestEntity.getTemplate();
    UUID actualTemplateId = actualNotificationRequestEntity.getTemplateId();
    UUID actualTenantId = actualNotificationRequestEntity.getTenantId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualOriginatorEntityId.toString());
    assertEquals("NotificationRequestEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, targets=Targets,"
        + " templateId=13814000-1dd2-11b2-8080-808080808080, template={\"isPublic\":true}, info={\"isPublic\":true},"
        + " additionalConfig={\"isPublic\":true}, originatorEntityId=13814000-1dd2-11b2-8080-808080808080,"
        + " originatorEntityType=TENANT, ruleId=13814000-1dd2-11b2-8080-808080808080, status=PROCESSING,"
        + " stats={\"isPublic\":true})", actualToStringResult);
    assertEquals("Targets", actualTargets);
    assertEquals(0L, actualNotificationRequestEntity.getCreatedTime());
    assertEquals(EntityType.TENANT, actualOriginatorEntityType);
    assertEquals(NotificationRequestStatus.PROCESSING, actualStatus);
    assertSame(template, actualAdditionalConfig);
    assertSame(template, actualInfo);
    assertSame(template, actualStats);
    assertSame(template, actualTemplate);
    assertSame(tenantId, actualOriginatorEntityId);
    assertSame(tenantId, actualRuleId);
    assertSame(tenantId, actualTemplateId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test
   * {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   * <p>
   * Method under test:
   * {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  public void testNewNotificationRequestEntity() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setOriginatorEntityId(BaseEntityService.NULL_CUSTOMER_ID);

    // Act
    NotificationRequestEntity actualNotificationRequestEntity = new NotificationRequestEntity(notificationRequest);

    // Assert
    UUID originatorEntityId = actualNotificationRequestEntity.getOriginatorEntityId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", originatorEntityId.toString());
    assertNull(actualNotificationRequestEntity.getInfo());
    assertNull(actualNotificationRequestEntity.getStats());
    assertNull(actualNotificationRequestEntity.getTemplate());
    assertNull(actualNotificationRequestEntity.getRuleId());
    assertNull(actualNotificationRequestEntity.getTemplateId());
    assertNull(actualNotificationRequestEntity.getStatus());
    assertEquals(EntityType.CUSTOMER, actualNotificationRequestEntity.getOriginatorEntityType());
    assertSame(originatorEntityId, actualNotificationRequestEntity.getTenantId());
  }

  /**
   * Test
   * {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequestEntity)}.
   * <p>
   * Method under test:
   * {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequestEntity)}
   */
  @Test
  public void testNewNotificationRequestEntity2() {
    // Arrange
    NotificationRequestEntity other = new NotificationRequestEntity();
    other.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setCreatedTime(1L);
    other.setId(ModelConstants.NULL_UUID);
    other.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setOriginatorEntityId(ModelConstants.NULL_UUID);
    other.setOriginatorEntityType(EntityType.TENANT);
    other.setRuleId(ModelConstants.NULL_UUID);
    other.setStats(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setStatus(NotificationRequestStatus.PROCESSING);
    other.setTargets("Targets");
    other.setTemplate(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setTemplateId(ModelConstants.NULL_UUID);
    other.setTenantId(ModelConstants.NULL_UUID);
    other.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(other, new NotificationRequestEntity(other));
  }

  /**
   * Test
   * {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return CreatedTime is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  public void testNewNotificationRequestEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    NotificationRequest notificationRequest = new NotificationRequest();
    notificationRequest.setCreatedTime(1L);

    // Act
    NotificationRequestEntity actualNotificationRequestEntity = new NotificationRequestEntity(notificationRequest);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationRequestEntity.getTenantId().toString());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityId());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityType());
    assertEquals(1L, actualNotificationRequestEntity.getCreatedTime());
  }

  /**
   * Test
   * {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}.
   * <ul>
   *   <li>When {@link NotificationRequest#NotificationRequest()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRequestEntity#NotificationRequestEntity(NotificationRequest)}
   */
  @Test
  public void testNewNotificationRequestEntity_whenNotificationRequest() {
    // Arrange and Act
    NotificationRequestEntity actualNotificationRequestEntity = new NotificationRequestEntity(
        new NotificationRequest());

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationRequestEntity.getTenantId().toString());
    assertNull(actualNotificationRequestEntity.getInfo());
    assertNull(actualNotificationRequestEntity.getStats());
    assertNull(actualNotificationRequestEntity.getTemplate());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityId());
    assertNull(actualNotificationRequestEntity.getRuleId());
    assertNull(actualNotificationRequestEntity.getTemplateId());
    assertNull(actualNotificationRequestEntity.getOriginatorEntityType());
    assertNull(actualNotificationRequestEntity.getStatus());
  }

  /**
   * Test {@link NotificationRequestEntity#toData()}.
   * <ul>
   *   <li>Then return TenantId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRequestEntity#toData()}
   */
  @Test
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange and Act
    NotificationRequest actualToDataResult = (new NotificationRequestEntity()).toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertEquals("To targets []", actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    NotificationRequestId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getOriginatorEntityId());
    assertNull(actualToDataResult.getRuleId());
    assertNull(actualToDataResult.getTemplateId());
    assertNull(actualToDataResult.getSenderId());
    assertNull(actualToDataResult.getAdditionalConfig());
    assertNull(actualToDataResult.getStats());
    assertNull(actualToDataResult.getStatus());
    assertNull(actualToDataResult.getInfo());
    assertNull(actualToDataResult.getTemplate());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.NOTIFICATION_REQUEST, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(id.isNullUid());
    assertFalse(actualToDataResult.isScheduled());
    assertFalse(actualToDataResult.isSent());
    assertTrue(actualToDataResult.getTargets().isEmpty());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
