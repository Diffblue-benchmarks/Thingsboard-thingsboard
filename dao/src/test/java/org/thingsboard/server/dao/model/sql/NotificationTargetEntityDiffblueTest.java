package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.DoubleNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.notification.targets.MicrosoftTeamsNotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.NotificationTargetConfig;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversation;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversationType;
import org.thingsboard.server.common.data.notification.targets.slack.SlackNotificationTargetConfig;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationTargetEntityDiffblueTest {
  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and {@link
   * NotificationTargetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity2);
    int expectedHashCodeResult = notificationTargetEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTargetEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and {@link
   * NotificationTargetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(null);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity2);
    int expectedHashCodeResult = notificationTargetEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTargetEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and {@link
   * NotificationTargetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(null);
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(null);
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity2);
    int expectedHashCodeResult = notificationTargetEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTargetEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and {@link
   * NotificationTargetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName(null);
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName(null);
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity2);
    int expectedHashCodeResult = notificationTargetEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTargetEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and {@link
   * NotificationTargetEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity);
    int expectedHashCodeResult = notificationTargetEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTargetEntity.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(DoubleNode.valueOf(10.0d));
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(null);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(3L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(null);
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName(null);
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName(
        "org.thingsboard.server.dao.model.sql.NotificationTargetEntity");
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(null);
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity2.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTargetEntity, null);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean NotificationTargetEntity.equals(Object)",
    "int NotificationTargetEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(
        CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    notificationTargetEntity.setUuid(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(notificationTargetEntity, "Different type to NotificationTargetEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link NotificationTargetEntity#NotificationTargetEntity()}
   *   <li>{@link NotificationTargetEntity#setConfiguration(JsonNode)}
   *   <li>{@link NotificationTargetEntity#setExternalId(UUID)}
   *   <li>{@link NotificationTargetEntity#setName(String)}
   *   <li>{@link NotificationTargetEntity#setTenantId(UUID)}
   *   <li>{@link NotificationTargetEntity#toString()}
   *   <li>{@link NotificationTargetEntity#getConfiguration()}
   *   <li>{@link NotificationTargetEntity#getExternalId()}
   *   <li>{@link NotificationTargetEntity#getName()}
   *   <li>{@link NotificationTargetEntity#getTenantId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void NotificationTargetEntity.<init>()",
    "JsonNode NotificationTargetEntity.getConfiguration()",
    "UUID NotificationTargetEntity.getExternalId()",
    "String NotificationTargetEntity.getName()",
    "UUID NotificationTargetEntity.getTenantId()",
    "void NotificationTargetEntity.setConfiguration(JsonNode)",
    "void NotificationTargetEntity.setExternalId(UUID)",
    "void NotificationTargetEntity.setName(String)",
    "void NotificationTargetEntity.setTenantId(UUID)",
    "String NotificationTargetEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationTargetEntity actualNotificationTargetEntity = new NotificationTargetEntity();
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationTargetEntity.setConfiguration(configuration);
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationTargetEntity.setExternalId(externalId);
    actualNotificationTargetEntity.setName("Name");
    UUID tenantId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualNotificationTargetEntity.setTenantId(tenantId);
    String actualToStringResult = actualNotificationTargetEntity.toString();
    JsonNode actualConfiguration = actualNotificationTargetEntity.getConfiguration();
    UUID actualExternalId = actualNotificationTargetEntity.getExternalId();
    String actualName = actualNotificationTargetEntity.getName();
    UUID actualTenantId = actualNotificationTargetEntity.getTenantId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualExternalId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualTenantId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "NotificationTargetEntity(tenantId=784f394c-42b6-435a-983c-b7beff2784f9, name=Name, configuration={"
            + "\"isPublic\":true}, externalId=784f394c-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
    assertSame(externalId, actualExternalId);
    assertSame(tenantId, actualTenantId);
    assertSame(configuration, actualConfiguration);
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(new MicrosoftTeamsNotificationTargetConfig());

    // Act and Assert
    JsonNode configuration = new NotificationTargetEntity(notificationTarget).getConfiguration();
    assertTrue(configuration instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = configuration.iterator();
    assertTrue(iteratorResult.hasNext());
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    assertEquals("\"MICROSOFT_TEAMS\"", nextResult.toPrettyString());
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof NullNode);
    assertEquals(JsonNodeType.NULL, nextResult2.getNodeType());
    assertTrue(nextResult2.isNull());
    assertFalse(nextResult2.isTextual());
    assertEquals("null", nextResult2.toPrettyString());
    assertSame(nextResult2, iteratorResult.next());
    assertEquals(10, configuration.size());
    assertEquals(
        "{\r\n"
            + "  \"type\" : \"MICROSOFT_TEAMS\",\r\n"
            + "  \"description\" : null,\r\n"
            + "  \"webhookUrl\" : null,\r\n"
            + "  \"channelName\" : null,\r\n"
            + "  \"useOldApi\" : true,\r\n"
            + "  \"id\" : null,\r\n"
            + "  \"title\" : null,\r\n"
            + "  \"email\" : null,\r\n"
            + "  \"firstName\" : null,\r\n"
            + "  \"lastName\" : null\r\n"
            + "}",
        configuration.toPrettyString());
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity2() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    notificationTarget.setExternalId(new NotificationTargetId(id));

    // Act
    NotificationTargetEntity actualNotificationTargetEntity =
        new NotificationTargetEntity(notificationTarget);

    // Assert
    UUID externalId = actualNotificationTargetEntity.getExternalId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", externalId.toString());
    assertNull(actualNotificationTargetEntity.getConfiguration());
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
    assertSame(id, externalId);
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity3() {
    // Arrange
    SlackNotificationTargetConfig configuration = new SlackNotificationTargetConfig();
    SlackConversation conversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("Whole Name")
            .build();
    configuration.setConversation(conversation);
    configuration.setConversationType(SlackConversationType.DIRECT);
    configuration.setDescription("The characteristics of someone or something");

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    JsonNode configuration2 = new NotificationTargetEntity(notificationTarget).getConfiguration();
    assertTrue(configuration2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = configuration2.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals(
        "{\r\n"
            + "  \"type\" : \"SLACK\",\r\n"
            + "  \"description\" : \"The characteristics of someone or something\",\r\n"
            + "  \"conversationType\" : \"DIRECT\",\r\n"
            + "  \"conversation\" : {\r\n"
            + "    \"type\" : \"DIRECT\",\r\n"
            + "    \"id\" : \"42\",\r\n"
            + "    \"name\" : \"Name\",\r\n"
            + "    \"wholeName\" : \"Whole Name\",\r\n"
            + "    \"email\" : \"jane.doe@example.org\",\r\n"
            + "    \"title\" : \"Whole Name\"\r\n"
            + "  }\r\n"
            + "}",
        configuration2.toPrettyString());
    assertEquals(4, configuration2.size());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity4() {
    // Arrange
    SlackNotificationTargetConfig configuration = new SlackNotificationTargetConfig();
    SlackConversation conversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName("")
            .build();
    configuration.setConversation(conversation);
    configuration.setConversationType(SlackConversationType.DIRECT);
    configuration.setDescription("The characteristics of someone or something");

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    JsonNode configuration2 = new NotificationTargetEntity(notificationTarget).getConfiguration();
    assertTrue(configuration2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = configuration2.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals(
        "{\r\n"
            + "  \"type\" : \"SLACK\",\r\n"
            + "  \"description\" : \"The characteristics of someone or something\",\r\n"
            + "  \"conversationType\" : \"DIRECT\",\r\n"
            + "  \"conversation\" : {\r\n"
            + "    \"type\" : \"DIRECT\",\r\n"
            + "    \"id\" : \"42\",\r\n"
            + "    \"name\" : \"Name\",\r\n"
            + "    \"wholeName\" : \"\",\r\n"
            + "    \"email\" : \"jane.doe@example.org\",\r\n"
            + "    \"title\" : \"Name\"\r\n"
            + "  }\r\n"
            + "}",
        configuration2.toPrettyString());
    assertEquals(4, configuration2.size());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity5() {
    // Arrange
    SlackNotificationTargetConfig configuration = new SlackNotificationTargetConfig();
    SlackConversation conversation =
        SlackConversation.builder()
            .email("jane.doe@example.org")
            .id("42")
            .name("Name")
            .type(SlackConversationType.DIRECT)
            .wholeName(null)
            .build();
    configuration.setConversation(conversation);
    configuration.setConversationType(SlackConversationType.DIRECT);
    configuration.setDescription("The characteristics of someone or something");

    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    JsonNode configuration2 = new NotificationTargetEntity(notificationTarget).getConfiguration();
    assertTrue(configuration2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = configuration2.iterator();
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertTrue(iteratorResult.next() instanceof TextNode);
    assertEquals(
        "{\r\n"
            + "  \"type\" : \"SLACK\",\r\n"
            + "  \"description\" : \"The characteristics of someone or something\",\r\n"
            + "  \"conversationType\" : \"DIRECT\",\r\n"
            + "  \"conversation\" : {\r\n"
            + "    \"type\" : \"DIRECT\",\r\n"
            + "    \"id\" : \"42\",\r\n"
            + "    \"name\" : \"Name\",\r\n"
            + "    \"wholeName\" : null,\r\n"
            + "    \"email\" : \"jane.doe@example.org\",\r\n"
            + "    \"title\" : \"Name\"\r\n"
            + "  }\r\n"
            + "}",
        configuration2.toPrettyString());
    assertEquals(4, configuration2.size());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <ul>
   *   <li>Given one.
   *   <li>Then return CreatedTime is one.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setCreatedTime(1L);

    // Act
    NotificationTargetEntity actualNotificationTargetEntity =
        new NotificationTargetEntity(notificationTarget);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTargetEntity.getTenantId().toString());
    assertNull(actualNotificationTargetEntity.getName());
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertNull(actualNotificationTargetEntity.getExternalId());
    assertEquals(1L, actualNotificationTargetEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity_givenSystem_tenant() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    NotificationTargetEntity actualNotificationTargetEntity =
        new NotificationTargetEntity(notificationTarget);

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTargetEntity.getTenantId().toString());
    assertNull(actualNotificationTargetEntity.getName());
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertNull(actualNotificationTargetEntity.getExternalId());
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   *
   * <ul>
   *   <li>When {@link NotificationTarget#NotificationTarget()}.
   * </ul>
   *
   * <p>Method under test: {@link
   * NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void NotificationTargetEntity.<init>(NotificationTarget)"})
  public void testNewNotificationTargetEntity_whenNotificationTarget() {
    // Arrange and Act
    NotificationTargetEntity actualNotificationTargetEntity =
        new NotificationTargetEntity(new NotificationTarget());

    // Assert
    assertEquals(
        "13814000-1dd2-11b2-8080-808080808080",
        actualNotificationTargetEntity.getTenantId().toString());
    assertNull(actualNotificationTargetEntity.getName());
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertNull(actualNotificationTargetEntity.getExternalId());
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   *
   * <ul>
   *   <li>Given {@link NotificationTargetEntity#NotificationTargetEntity()}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationTarget NotificationTargetEntity.toData()"})
  public void testToData_givenNotificationTargetEntity() {
    // Arrange and Act
    NotificationTarget actualToDataResult = new NotificationTargetEntity().toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getConfiguration());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   *
   * <ul>
   *   <li>Then Configuration return {@link MicrosoftTeamsNotificationTargetConfig}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationTarget NotificationTargetEntity.toData()"})
  public void testToData_thenConfigurationReturnMicrosoftTeamsNotificationTargetConfig() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    MicrosoftTeamsNotificationTargetConfig configuration =
        new MicrosoftTeamsNotificationTargetConfig();
    notificationTarget.setConfiguration(configuration);

    // Act and Assert
    NotificationTargetConfig configuration2 =
        new NotificationTargetEntity(notificationTarget).toData().getConfiguration();
    assertTrue(configuration2 instanceof MicrosoftTeamsNotificationTargetConfig);
    assertEquals(configuration, configuration2);
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return ExternalId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationTarget NotificationTargetEntity.toData()"})
  public void testToData_thenReturnExternalIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    UUID externalId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    notificationTargetEntity.setExternalId(externalId);

    // Act and Assert
    NotificationTargetId externalId2 = notificationTargetEntity.toData().getExternalId();
    UUID id = externalId2.getId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", id.toString());
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId2.getEntityType());
    assertFalse(externalId2.isNullUid());
    assertSame(externalId, id);
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id is randomUUID.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationTarget NotificationTargetEntity.toData()"})
  public void testToData_thenReturnTenantIdIdIsRandomUUID() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    UUID tenantId = UUID.randomUUID();
    notificationTargetEntity.setTenantId(tenantId);

    // Act
    NotificationTarget actualToDataResult = notificationTargetEntity.toData();

    // Assert
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getConfiguration());
    TenantId tenantId2 = actualToDataResult.getTenantId();
    assertFalse(tenantId2.isNullUid());
    assertFalse(tenantId2.isSysTenantId());
    assertSame(tenantId, tenantId2.getId());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationTarget NotificationTargetEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setTenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act
    NotificationTarget actualToDataResult = notificationTargetEntity.toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getConfiguration());
    assertFalse(tenantId.isNullUid());
    assertFalse(tenantId.isSysTenantId());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   *
   * <ul>
   *   <li>Then return TenantId Id toString is {@code 13814000-1dd2-11b2-8080-808080808080}.
   * </ul>
   *
   * <p>Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"NotificationTarget NotificationTargetEntity.toData()"})
  public void testToData_thenReturnTenantIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange and Act
    NotificationTarget actualToDataResult =
        new NotificationTargetEntity(new NotificationTarget()).toData();

    // Assert
    TenantId tenantId = actualToDataResult.getTenantId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", tenantId.getId().toString());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getConfiguration());
    assertTrue(tenantId.isNullUid());
    assertTrue(tenantId.isSysTenantId());
  }
}
