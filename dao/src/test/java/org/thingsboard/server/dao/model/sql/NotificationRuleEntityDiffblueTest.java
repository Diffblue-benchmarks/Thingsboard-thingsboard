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
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.rule.DefaultNotificationRuleRecipientsConfig;
import org.thingsboard.server.common.data.notification.rule.NotificationRule;
import org.thingsboard.server.common.data.notification.rule.trigger.config.NotificationRuleTriggerType;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationRuleEntityDiffblueTest {
  /**
   * Test {@link NotificationRuleEntity#equals(Object)}, and {@link
   * NotificationRuleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRuleEntity#equals(Object)}
   *   <li>{@link NotificationRuleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationRuleEntity, notificationRuleEntity2);
    int expectedHashCodeResult = notificationRuleEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleEntity2.hashCode());
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}, and {@link
   * NotificationRuleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRuleEntity#equals(Object)}
   *   <li>{@link NotificationRuleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(null);
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getExternalId()).thenReturn(null);
    when(notificationRuleInfoEntity.getAdditionalConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getRecipientsConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfoEntity.getTemplateId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.getName()).thenReturn("Name");
    when(notificationRuleInfoEntity.getTenantId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.isEnabled()).thenReturn(true);
    when(notificationRuleInfoEntity.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    doNothing()
        .when(notificationRuleInfoEntity)
        .setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationRuleEntity, notificationRuleInfoEntity);
    int notExpectedHashCodeResult = notificationRuleEntity.hashCode();
    assertNotEquals(notExpectedHashCodeResult, notificationRuleInfoEntity.hashCode());
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}, and {@link
   * NotificationRuleEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationRuleEntity#equals(Object)}
   *   <li>{@link NotificationRuleEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationRuleEntity, notificationRuleEntity);
    int expectedHashCodeResult = notificationRuleEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationRuleEntity.hashCode());
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(DoubleNode.valueOf(10.0d));
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(null);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(3L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(false);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(null);
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName(null);
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("org.thingsboard.server.dao.model.sql.NotificationRuleEntity");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(DoubleNode.valueOf(10.0d));
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(null);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(null);
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(null);
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(DoubleNode.valueOf(10.0d));
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(null);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual17() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(null);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual18() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ALARM);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationRuleEntity notificationRuleEntity2 = new NotificationRuleEntity();
    notificationRuleEntity2.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setCreatedTime(1L);
    notificationRuleEntity2.setEnabled(true);
    notificationRuleEntity2.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setName("Name");
    notificationRuleEntity2.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity2.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity2.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleEntity2);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual19() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getId()).thenReturn(null);
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
    doNothing()
        .when(notificationRuleInfoEntity)
        .setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleInfoEntity);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual20() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getTenantId()).thenReturn(null);
    when(notificationRuleInfoEntity.isEnabled()).thenReturn(true);
    when(notificationRuleInfoEntity.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    doNothing()
        .when(notificationRuleInfoEntity)
        .setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleInfoEntity);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual21() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getName()).thenReturn(null);
    when(notificationRuleInfoEntity.getTenantId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.isEnabled()).thenReturn(true);
    when(notificationRuleInfoEntity.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    doNothing()
        .when(notificationRuleInfoEntity)
        .setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleInfoEntity);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual22() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getTemplateId()).thenReturn(null);
    when(notificationRuleInfoEntity.getName()).thenReturn("Name");
    when(notificationRuleInfoEntity.getTenantId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.isEnabled()).thenReturn(true);
    when(notificationRuleInfoEntity.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    doNothing()
        .when(notificationRuleInfoEntity)
        .setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleInfoEntity);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual23() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getTriggerType()).thenReturn(null);
    when(notificationRuleInfoEntity.getTemplateId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.getName()).thenReturn("Name");
    when(notificationRuleInfoEntity.getTenantId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.isEnabled()).thenReturn(true);
    when(notificationRuleInfoEntity.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    doNothing()
        .when(notificationRuleInfoEntity)
        .setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleInfoEntity);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual24() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getTriggerConfig()).thenReturn(null);
    when(notificationRuleInfoEntity.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfoEntity.getTemplateId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.getName()).thenReturn("Name");
    when(notificationRuleInfoEntity.getTenantId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.isEnabled()).thenReturn(true);
    when(notificationRuleInfoEntity.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    doNothing()
        .when(notificationRuleInfoEntity)
        .setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleInfoEntity);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual25() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getRecipientsConfig()).thenReturn(null);
    when(notificationRuleInfoEntity.getTriggerConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfoEntity.getTemplateId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.getName()).thenReturn("Name");
    when(notificationRuleInfoEntity.getTenantId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.isEnabled()).thenReturn(true);
    when(notificationRuleInfoEntity.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    doNothing()
        .when(notificationRuleInfoEntity)
        .setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleInfoEntity);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual26() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getAdditionalConfig()).thenReturn(null);
    when(notificationRuleInfoEntity.getRecipientsConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfoEntity.getTemplateId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.getName()).thenReturn("Name");
    when(notificationRuleInfoEntity.getTenantId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.isEnabled()).thenReturn(true);
    when(notificationRuleInfoEntity.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    doNothing()
        .when(notificationRuleInfoEntity)
        .setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleInfoEntity);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual27() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getExternalId()).thenReturn(null);
    when(notificationRuleInfoEntity.getAdditionalConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getRecipientsConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfoEntity.getTemplateId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.getName()).thenReturn("Name");
    when(notificationRuleInfoEntity.getTenantId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.isEnabled()).thenReturn(true);
    when(notificationRuleInfoEntity.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    doNothing()
        .when(notificationRuleInfoEntity)
        .setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleInfoEntity);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual28() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    NotificationRuleInfoEntity notificationRuleInfoEntity = mock(NotificationRuleInfoEntity.class);
    when(notificationRuleInfoEntity.getExternalId()).thenReturn(null);
    when(notificationRuleInfoEntity.getAdditionalConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getRecipientsConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerConfig())
        .thenReturn(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    when(notificationRuleInfoEntity.getTriggerType())
        .thenReturn(NotificationRuleTriggerType.ENTITY_ACTION);
    when(notificationRuleInfoEntity.getTemplateId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.getName()).thenReturn("Name");
    when(notificationRuleInfoEntity.getTenantId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    when(notificationRuleInfoEntity.isEnabled()).thenReturn(true);
    when(notificationRuleInfoEntity.getId())
        .thenReturn(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
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
    doNothing()
        .when(notificationRuleInfoEntity)
        .setTriggerType(Mockito.<NotificationRuleTriggerType>any());
    notificationRuleInfoEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setCreatedTime(1L);
    notificationRuleInfoEntity.setEnabled(true);
    notificationRuleInfoEntity.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setName("Name");
    notificationRuleInfoEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTemplateId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleInfoEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleInfoEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleInfoEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, notificationRuleInfoEntity);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, null);
  }

  /**
   * Test {@link NotificationRuleEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationRuleEntity.equals(Object)",
    "int NotificationRuleEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setCreatedTime(1L);
    notificationRuleEntity.setEnabled(true);
    notificationRuleEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setName("Name");
    notificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationRuleEntity.setTriggerConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationRuleEntity.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    notificationRuleEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationRuleEntity, "Different type to NotificationRuleEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
   *   <li>{@link NotificationRuleEntity#setTriggerType(NotificationRuleTriggerType)}
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NotificationRuleEntity.<init>()",
    "JsonNode NotificationRuleEntity.getAdditionalConfig()",
    "UUID NotificationRuleEntity.getExternalId()",
    "String NotificationRuleEntity.getName()",
    "JsonNode NotificationRuleEntity.getRecipientsConfig()",
    "UUID NotificationRuleEntity.getTemplateId()",
    "UUID NotificationRuleEntity.getTenantId()",
    "JsonNode NotificationRuleEntity.getTriggerConfig()",
    "NotificationRuleTriggerType NotificationRuleEntity.getTriggerType()",
    "boolean NotificationRuleEntity.isEnabled()",
    "void NotificationRuleEntity.setAdditionalConfig(JsonNode)",
    "void NotificationRuleEntity.setEnabled(boolean)",
    "void NotificationRuleEntity.setExternalId(UUID)",
    "void NotificationRuleEntity.setName(String)",
    "void NotificationRuleEntity.setRecipientsConfig(JsonNode)",
    "void NotificationRuleEntity.setTemplateId(UUID)",
    "void NotificationRuleEntity.setTenantId(UUID)",
    "void NotificationRuleEntity.setTriggerConfig(JsonNode)",
    "void NotificationRuleEntity.setTriggerType(NotificationRuleTriggerType)",
    "String NotificationRuleEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationRuleEntity actualNotificationRuleEntity = new NotificationRuleEntity();
    actualNotificationRuleEntity.setAdditionalConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationRuleEntity.setEnabled(true);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationRuleEntity.setExternalId(externalId);
    actualNotificationRuleEntity.setName("Name");
    actualNotificationRuleEntity.setRecipientsConfig(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    UUID templateId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationRuleEntity.setTemplateId(templateId);
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
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

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTemplateId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "NotificationRuleEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, name=Name, enabled=true,"
            + " templateId=784f394c-42b6-435a-983c-b7beff2784f9, triggerType=ENTITY_ACTION, triggerConfig={\"isPublic\":true},"
            + " recipientsConfig={\"isPublic\":true}, additionalConfig={\"isPublic\":true}, externalId=784f394c-42b6-435a"
            + "-983c-b7beff2784f9)",
        actualToStringResult);
    assertNull(actualNotificationRuleEntity.getId());
    assertNull(actualNotificationRuleEntity.getUuid());
    assertEquals(0L, actualNotificationRuleEntity.getCreatedTime());
    assertEquals(NotificationRuleTriggerType.ENTITY_ACTION, actualTriggerType);
    assertTrue(actualIsEnabledResult);
    assertSame(externalId, actualExternalId);
    assertSame(templateId, actualTemplateId);
    assertSame(tenantId, actualTenantId);
    assertSame(triggerConfig, actualAdditionalConfig);
    assertSame(triggerConfig, actualRecipientsConfig);
    assertSame(triggerConfig, actualTriggerConfig);
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}.
   *
   * <p>Method under test: {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationRuleEntity.<init>(NotificationRule)"})
  public void testNewNotificationRuleEntity() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    notificationRule.setTemplateId(new NotificationTemplateId(id));

    // Act
    NotificationRuleEntity actualNotificationRuleEntity =
        new NotificationRuleEntity(notificationRule);

    // Assert
    UUID templateId = actualNotificationRuleEntity.getTemplateId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", templateId.toString());
    assertNull(actualNotificationRuleEntity.getRecipientsConfig());
    assertEquals(0L, actualNotificationRuleEntity.getCreatedTime());
    assertSame(id, templateId);
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRuleEntity)}.
   *
   * <p>Method under test: {@link
   * NotificationRuleEntity#NotificationRuleEntity(NotificationRuleEntity)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationRuleEntity.<init>(NotificationRuleEntity)"})
  public void testNewNotificationRuleEntity2() {
    // Arrange
    NotificationRuleEntity other = new NotificationRuleEntity();
    other.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setCreatedTime(1L);
    other.setEnabled(true);
    other.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    other.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    other.setName("Name");
    other.setRecipientsConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setTemplateId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    other.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    other.setTriggerConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    other.setTriggerType(NotificationRuleTriggerType.ENTITY_ACTION);
    other.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(other, new NotificationRuleEntity(other));
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationRuleEntity.<init>(NotificationRule)"})
  public void testNewNotificationRuleEntity_givenSystem_tenant() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    NotificationRuleEntity actualNotificationRuleEntity =
        new NotificationRuleEntity(notificationRule);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRuleEntity.getTenantId().toString());
    assertNull(actualNotificationRuleEntity.getAdditionalConfig());
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
   *
   * <ul>
   *   <li>Given three.
   *   <li>Then return CreatedTime is three.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationRuleEntity.<init>(NotificationRule)"})
  public void testNewNotificationRuleEntity_givenThree_thenReturnCreatedTimeIsThree() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setCreatedTime(3L);

    // Act
    NotificationRuleEntity actualNotificationRuleEntity =
        new NotificationRuleEntity(notificationRule);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRuleEntity.getTenantId().toString());
    assertNull(actualNotificationRuleEntity.getAdditionalConfig());
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
   *
   * <ul>
   *   <li>Then RecipientsConfig return {@link ObjectNode}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationRuleEntity.<init>(NotificationRule)"})
  public void testNewNotificationRuleEntity_thenRecipientsConfigReturnObjectNode() {
    // Arrange
    NotificationRule notificationRule = new NotificationRule();
    notificationRule.setRecipientsConfig(new DefaultNotificationRuleRecipientsConfig());

    // Act and Assert
    assertTrue(
        new NotificationRuleEntity(notificationRule).getRecipientsConfig() instanceof ObjectNode);
  }

  /**
   * Test {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}.
   *
   * <ul>
   *   <li>When {@link NotificationRule#NotificationRule()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationRuleEntity.<init>(NotificationRule)"})
  public void testNewNotificationRuleEntity_whenNotificationRule() {
    // Arrange and Act
    NotificationRuleEntity actualNotificationRuleEntity =
        new NotificationRuleEntity(new NotificationRule());

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationRuleEntity.getTenantId().toString());
    assertNull(actualNotificationRuleEntity.getAdditionalConfig());
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
   *
   * <ul>
   *   <li>Given {@link NotificationRuleEntity#NotificationRuleEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationRule NotificationRuleEntity.toData()"})
  public void testToData_givenNotificationRuleEntity() {
    // Arrange and Act
    NotificationRule actualToDataResult = new NotificationRuleEntity().toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getTemplateId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleEntity#NotificationRuleEntity()} RecipientsConfig is
   *       Instance.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationRule NotificationRuleEntity.toData()"})
  public void testToData_givenNotificationRuleEntityRecipientsConfigIsInstance() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setRecipientsConfig(MissingNode.getInstance());

    // Act
    NotificationRule actualToDataResult = notificationRuleEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getTemplateId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link NotificationRuleEntity#NotificationRuleEntity(NotificationRule)} with
   *       notificationRule is {@link NotificationRule#NotificationRule()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationRule NotificationRuleEntity.toData()"})
  public void testToData_givenNotificationRuleEntityWithNotificationRuleIsNotificationRule() {
    // Arrange and Act
    NotificationRule actualToDataResult =
        new NotificationRuleEntity(new NotificationRule()).toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getTemplateId());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TemplateId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationRule NotificationRuleEntity.toData()"})
  public void testToData_thenReturnTemplateIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    UUID templateId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    notificationRuleEntity.setTemplateId(templateId);

    // Act and Assert
    NotificationTemplateId templateId2 = notificationRuleEntity.toData().getTemplateId();
    UUID id = templateId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, templateId2.getEntityType());
    assertFalse(templateId2.isNullUid());
    assertSame(templateId, id);
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationRule NotificationRuleEntity.toData()"})
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    UUID tenantId = UUID.randomUUID();
    notificationRuleEntity.setTenantId(tenantId);

    // Act
    NotificationRule actualToDataResult = notificationRuleEntity.toData();

    // Assert
    assertNull(actualToDataResult.getTemplateId());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link NotificationRuleEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationRuleEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationRule NotificationRuleEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    NotificationRuleEntity notificationRuleEntity = new NotificationRuleEntity();
    notificationRuleEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    NotificationRule actualToDataResult = notificationRuleEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertNull(actualToDataResult.getTemplateId());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }
}
