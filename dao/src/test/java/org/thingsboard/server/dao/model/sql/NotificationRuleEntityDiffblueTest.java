package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationRuleId;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationRuleEntityDiffblueTest {
  /**
   * Test {@link NotificationRuleEntity#equals(Object)}, and
   * {@link NotificationRuleEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleEntity#equals(Object)}
   *   <li>{@link NotificationRuleEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRuleEntity, notificationRuleEntity2);
    int expectedHashCodeResult = notificationRuleEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}, and
   * {@link NotificationRuleEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleEntity#equals(Object)}
   *   <li>{@link NotificationRuleEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getExternalId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRuleInfoEntity.getAdditionalConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getRecipientsConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfoEntity.getTemplateId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRuleInfoEntity.getName()).thenReturn("Name");
    when(notificationRuleInfoEntity.getTenantId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRuleInfoEntity.isEnabled()).thenReturn(true);
    when(notificationRuleInfoEntity.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRuleInfoEntity.getCreatedTime()).thenReturn(1L);
    when(notificationRuleInfoEntity.canEqual(Mockito.<Object>any())).thenReturn(true);
    doNothing().when(notificationRuleInfoEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRuleInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleInfoEntity).setEnabled(anyBoolean());
    doNothing().when(notificationRuleInfoEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setName(Mockito.<String>any());
    doNothing().when(notificationRuleInfoEntity).setRecipientsConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleInfoEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setTriggerConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleInfoEntity).setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleInfoEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleInfoEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRuleEntity, notificationRuleInfoEntity);
    int notExpectedHashCodeResult = notificationRuleEntity.hashCode();
    assertNotEquals(notExpectedHashCodeResult, notificationRuleInfoEntity.hashCode());
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}, and
   * {@link NotificationRuleEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleEntity#equals(Object)}
   *   <li>{@link NotificationRuleEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationRuleEntity, notificationRuleEntity);
    int expectedHashCodeResult = notificationRuleEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleEntity.hashCode());
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(MissingNode.getInstance());
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(null);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(mock(JsonNode.class));
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(3L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(false);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.randomUUID());
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(null);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName(null);
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("org.thingsboard.server.dao.model.sql.NotificationRuleEntity");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(null);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.randomUUID());
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(null);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(UUID.randomUUID());
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(null);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(MissingNode.getInstance());
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(null);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(null);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ALARM);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity2.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getExternalId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRuleInfoEntity.getAdditionalConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getRecipientsConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerType()).thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfoEntity.getTemplateId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRuleInfoEntity.getName()).thenReturn("Name");
    when(notificationRuleInfoEntity.getTenantId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRuleInfoEntity.isEnabled()).thenReturn(true);
    when(notificationRuleInfoEntity.getId()).thenReturn(ModelConstants.NULL_UUID);
    when(notificationRuleInfoEntity.getCreatedTime()).thenReturn(1L);
    when(notificationRuleInfoEntity.canEqual(Mockito.<Object>any())).thenReturn(false);
    doNothing().when(notificationRuleInfoEntity).setCreatedTime(anyLong());
    doNothing().when(notificationRuleInfoEntity).setId(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setUuid(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setAdditionalConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleInfoEntity).setEnabled(anyBoolean());
    doNothing().when(notificationRuleInfoEntity).setExternalId(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setName(Mockito.<String>any());
    doNothing().when(notificationRuleInfoEntity).setRecipientsConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleInfoEntity).setTemplateId(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setTenantId(Mockito.<UUID>any());
    doNothing().when(notificationRuleInfoEntity).setTriggerConfig(Mockito.<JsonNode>any());
    doNothing().when(notificationRuleInfoEntity).setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleInfoEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleInfoEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleInfoEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleInfoEntity);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, null);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationRuleEntity, "Different type to NotificationRuleEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationRuleEntity#NotificationRuleEntity()}
   *   <li>{@link NotificationRuleEntity#setAdditionalConfig(JsonNode)}
   *   <li>{@link NotificationRuleEntity#setEnabled(boolean)}
   *   <li>{@link NotificationRuleEntity#setExternalId(UUID)}
   *   <li>{@link NotificationRuleEntity#setName(String)}
   *   <li>{@link NotificationRuleEntity#setRecipientsConfig(JsonNode)}
   *   <li>{@link NotificationRuleEntity#setTemplateId(UUID)}
   *   <li>{@link NotificationRuleEntity#setTenantId(UUID)}
   *   <li>{@link NotificationRuleEntity#setTriggerConfig(JsonNode)}
   *   <li>
   * {@link NotificationRuleEntity#setTriggerType(NotificationRuleTriggerType)}
   *   <li>{@link NotificationRuleEntity#toString()}
   *   <li>{@link NotificationRuleEntity#getAdditionalConfig()}
   *   <li>{@link NotificationRuleEntity#getExternalId()}
   *   <li>{@link NotificationRuleEntity#getName()}
   *   <li>{@link NotificationRuleEntity#getRecipientsConfig()}
   *   <li>{@link NotificationRuleEntity#getTemplateId()}
   *   <li>{@link NotificationRuleEntity#getTenantId()}
   *   <li>{@link NotificationRuleEntity#getTriggerConfig()}
   *   <li>{@link NotificationRuleEntity#getTriggerType()}
   *   <li>{@link NotificationRuleEntity#isEnabled()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationRuleEntity actualNotificationRuleEntity = new NotificationRuleEntity();
    actualNotificationRuleEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRuleEntity.setEnabled(true);
    actualNotificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    actualNotificationRuleEntity.setName("Name");
    actualNotificationRuleEntity.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualNotificationRuleEntity.setTenantId(tenantId);
    JsonNode triggerConfig = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationRuleEntity.setTriggerConfig(triggerConfig);
    actualNotificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    String actualToStringResult = actualNotificationRuleEntity.toString();
    JsonNode actualAdditionalConfig = actualNotificationRuleEntity.getAdditionalConfig();
    UUID actualExternalId = actualNotificationRuleEntity.getExternalId();
    String actualName = actualNotificationRuleEntity.getName();
    JsonNode actualRecipientsConfig = actualNotificationRuleEntity.getRecipientsConfig();
    UUID actualTemplateId = actualNotificationRuleEntity.getTemplateId();
    UUID actualTenantId = actualNotificationRuleEntity.getTenantId();
    JsonNode actualTriggerConfig = actualNotificationRuleEntity.getTriggerConfig();
    NotificationRuleTriggerType actualTriggerType = actualNotificationRuleEntity.getTriggerType();
    boolean actualIsEnabledResult = actualNotificationRuleEntity.isEnabled();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Name", actualName);
    assertEquals("NotificationRuleEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, enabled=true,"
        + " templateId=13814000-1dd2-11b2-8080-808080808080, triggerType=ENTITY_ACTION, triggerConfig={\"isPublic\":true},"
        + " recipientsConfig={\"isPublic\":true}, additionalConfig={\"isPublic\":true}, externalId=13814000-1dd2-11b2"
        + "-8080-808080808080)", actualToStringResult);
    assertEquals(0L, actualNotificationRuleEntity.getCreatedTime());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualTriggerType);
    assertTrue(actualIsEnabledResult);
    assertSame(triggerConfig, actualAdditionalConfig);
    assertSame(triggerConfig, actualRecipientsConfig);
    assertSame(triggerConfig, actualTriggerConfig);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTemplateId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}.
   * <p>
   * Method under test:
   * {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  public void testNewNotificationRuleEntity() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTemplateId(new NotificationTemplateId(ModelConstants.NULL_UUID));

    // Act
    NotificationRuleEntity actualNotificationRuleEntity = new NotificationRuleEntity(notificationRule);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationRuleEntity.getTemplateId().toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationRuleEntity.getTenantId().toString());
    assertNull(actualNotificationRuleEntity.getAdditionalConfig());
    assertNull(actualNotificationRuleEntity.getRecipientsConfig());
    assertNull(actualNotificationRuleEntity.getTriggerConfig());
    assertNull(actualNotificationRuleEntity.getName());
    assertNull(actualNotificationRuleEntity.getId());
    assertNull(actualNotificationRuleEntity.getUuid());
    assertNull(actualNotificationRuleEntity.getExternalId());
    assertNull(actualNotificationRuleEntity.getTriggerType());
    assertEquals(0L, actualNotificationRuleEntity.getCreatedTime());
    assertFalse(actualNotificationRuleEntity.isEnabled());
  }

  /**
   * Test
   * {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRuleEntity)}.
   * <p>
   * Method under test:
   * {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRuleEntity)}
   */
  @Test
  public void testNewNotificationRuleEntity2() {
    // Arrange
    NotificationRuleEntity other = new NotificationRuleEntity();
    other.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setCreatedTime(1L);
    other.setEnabled(true);
    other.setExternalId(ModelConstants.NULL_UUID);
    other.setId(ModelConstants.NULL_UUID);
    other.setName("Name");
    other.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setTemplateId(ModelConstants.NULL_UUID);
    other.setTenantId(ModelConstants.NULL_UUID);
    other.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    other.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(other, new NotificationRuleEntity(other));
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  public void testNewNotificationRuleEntity_givenSystem_tenant() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    NotificationRuleEntity actualNotificationRuleEntity = new NotificationRuleEntity(notificationRule);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationRuleEntity.getTenantId().toString());
    assertNull(actualNotificationRuleEntity.getAdditionalConfig());
    assertNull(actualNotificationRuleEntity.getRecipientsConfig());
    assertNull(actualNotificationRuleEntity.getTriggerConfig());
    assertNull(actualNotificationRuleEntity.getName());
    assertNull(actualNotificationRuleEntity.getId());
    assertNull(actualNotificationRuleEntity.getUuid());
    assertNull(actualNotificationRuleEntity.getExternalId());
    assertNull(actualNotificationRuleEntity.getTemplateId());
    assertNull(actualNotificationRuleEntity.getTriggerType());
    assertEquals(0L, actualNotificationRuleEntity.getCreatedTime());
    assertFalse(actualNotificationRuleEntity.isEnabled());
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}.
   * <ul>
   *   <li>Given three.</li>
   *   <li>Then return CreatedTime is three.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  public void testNewNotificationRuleEntity_givenThree_thenReturnCreatedTimeIsThree() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setCreatedTime(3L);

    // Act
    NotificationRuleEntity actualNotificationRuleEntity = new NotificationRuleEntity(notificationRule);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationRuleEntity.getTenantId().toString());
    assertNull(actualNotificationRuleEntity.getAdditionalConfig());
    assertNull(actualNotificationRuleEntity.getRecipientsConfig());
    assertNull(actualNotificationRuleEntity.getTriggerConfig());
    assertNull(actualNotificationRuleEntity.getName());
    assertNull(actualNotificationRuleEntity.getId());
    assertNull(actualNotificationRuleEntity.getUuid());
    assertNull(actualNotificationRuleEntity.getExternalId());
    assertNull(actualNotificationRuleEntity.getTemplateId());
    assertNull(actualNotificationRuleEntity.getTriggerType());
    assertEquals(3L, actualNotificationRuleEntity.getCreatedTime());
    assertFalse(actualNotificationRuleEntity.isEnabled());
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}.
   * <ul>
   *   <li>When {@link NotificationRule#NotificationRule()}.</li>
   *   <li>Then return TemplateId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  public void testNewNotificationRuleEntity_whenNotificationRule_thenReturnTemplateIdIsNull() {
    // Arrange and Act
    NotificationRuleEntity actualNotificationRuleEntity = new NotificationRuleEntity(new NotificationRule());

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationRuleEntity.getTenantId().toString());
    assertNull(actualNotificationRuleEntity.getAdditionalConfig());
    assertNull(actualNotificationRuleEntity.getRecipientsConfig());
    assertNull(actualNotificationRuleEntity.getTriggerConfig());
    assertNull(actualNotificationRuleEntity.getName());
    assertNull(actualNotificationRuleEntity.getId());
    assertNull(actualNotificationRuleEntity.getUuid());
    assertNull(actualNotificationRuleEntity.getExternalId());
    assertNull(actualNotificationRuleEntity.getTemplateId());
    assertNull(actualNotificationRuleEntity.getTriggerType());
    assertEquals(0L, actualNotificationRuleEntity.getCreatedTime());
    assertFalse(actualNotificationRuleEntity.isEnabled());
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   * <ul>
   *   <li>Given {@link NotificationRuleEntity#NotificationRuleEntity()}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  public void testToData_givenNotificationRuleEntity() {
    // Arrange and Act
    NotificationRule actualToDataResult = (new NotificationRuleEntity()).toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    NotificationRuleId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTemplateId());
    assertNull(actualToDataResult.getAdditionalConfig());
    assertNull(actualToDataResult.getRecipientsConfig());
    assertNull(actualToDataResult.getTriggerConfig());
    assertNull(actualToDataResult.getTriggerType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.NOTIFICATION_RULE, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(id.isNullUid());
    assertFalse(actualToDataResult.isEnabled());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   * <ul>
   *   <li>Given {@link NotificationRuleEntity#NotificationRuleEntity()}
   * RecipientsConfig is Instance.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  public void testToData_givenNotificationRuleEntityRecipientsConfigIsInstance() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());

    // Act
    NotificationRule actualToDataResult = notificationRuleEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    NotificationRuleId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getTemplateId());
    assertNull(actualToDataResult.getAdditionalConfig());
    assertNull(actualToDataResult.getRecipientsConfig());
    assertNull(actualToDataResult.getTriggerConfig());
    assertNull(actualToDataResult.getTriggerType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.NOTIFICATION_RULE, id.getEntityType());
    assertEquals(EntityType.TENANT, tenantId.getEntityType());
    assertFalse(id.isNullUid());
    assertFalse(actualToDataResult.isEnabled());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
