package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationTargetId;
import org.thingsboard.server.common.data.notification.targets.NotificationTarget;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversation;
import org.thingsboard.server.common.data.notification.targets.slack.SlackConversationType;
import org.thingsboard.server.common.data.notification.targets.slack.SlackNotificationTargetConfig;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationTargetEntityDiffblueTest {
  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and
   * {@link NotificationTargetEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity2);
    int expectedHashCodeResult = notificationTargetEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTargetEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and
   * {@link NotificationTargetEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(null);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(null);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity2);
    int expectedHashCodeResult = notificationTargetEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTargetEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}, and
   * {@link NotificationTargetEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTargetEntity#equals(Object)}
   *   <li>{@link NotificationTargetEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTargetEntity, notificationTargetEntity);
    int expectedHashCodeResult = notificationTargetEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTargetEntity.hashCode());
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(null);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(mock(JsonNode.class));
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(3L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(UUID.randomUUID());
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(null);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName(null);
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("org.thingsboard.server.dao.model.sql.NotificationTargetEntity");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(UUID.randomUUID());
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(null);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTargetEntity notificationTargetEntity2 = new NotificationTargetEntity();
    notificationTargetEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity2.setCreatedTime(1L);
    notificationTargetEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setName("Name");
    notificationTargetEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, notificationTargetEntity2);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, null);
  }

  /**
   * Test {@link NotificationTargetEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTargetEntity, "Different type to NotificationTargetEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
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
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationTargetEntity actualNotificationTargetEntity = new NotificationTargetEntity();
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationTargetEntity.setConfiguration(configuration);
    actualNotificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    actualNotificationTargetEntity.setName("Name");
    UUID tenantId = ModelConstants.NULL_UUID;
    actualNotificationTargetEntity.setTenantId(tenantId);
    String actualToStringResult = actualNotificationTargetEntity.toString();
    JsonNode actualConfiguration = actualNotificationTargetEntity.getConfiguration();
    UUID actualExternalId = actualNotificationTargetEntity.getExternalId();
    String actualName = actualNotificationTargetEntity.getName();
    UUID actualTenantId = actualNotificationTargetEntity.getTenantId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Name", actualName);
    assertEquals("NotificationTargetEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, configuration={"
        + "\"isPublic\":true}, externalId=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
    assertSame(configuration, actualConfiguration);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test
   * {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   * <p>
   * Method under test:
   * {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  public void testNewNotificationTargetEntity() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setExternalId(new NotificationTargetId(ModelConstants.NULL_UUID));

    // Act
    NotificationTargetEntity actualNotificationTargetEntity = new NotificationTargetEntity(notificationTarget);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationTargetEntity.getExternalId().toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationTargetEntity.getTenantId().toString());
    assertNull(actualNotificationTargetEntity.getConfiguration());
    assertNull(actualNotificationTargetEntity.getName());
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
  }

  /**
   * Test
   * {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   * <p>
   * Method under test:
   * {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  public void testNewNotificationTargetEntity2() throws IOException {
    // Arrange
    SlackNotificationTargetConfig configuration = new SlackNotificationTargetConfig();
    SlackConversation conversation = SlackConversation.builder()
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
    JsonNode configuration2 = (new NotificationTargetEntity(notificationTarget)).getConfiguration();
    assertTrue(configuration2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = configuration2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof TextNode);
    JsonParser traverseResult = nextResult3.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"DIRECT\"", nextResult3.toPrettyString());
    assertEquals("\"SLACK\"", nextResult.toPrettyString());
    assertEquals("\"The characteristics of someone or something\"", nextResult2.toPrettyString());
    assertEquals("{\r\n" + "  \"type\" : \"SLACK\",\r\n"
        + "  \"description\" : \"The characteristics of someone or something\",\r\n"
        + "  \"conversationType\" : \"DIRECT\",\r\n" + "  \"conversation\" : {\r\n" + "    \"type\" : \"DIRECT\",\r\n"
        + "    \"id\" : \"42\",\r\n" + "    \"name\" : \"Name\",\r\n" + "    \"wholeName\" : \"Whole Name\",\r\n"
        + "    \"email\" : \"jane.doe@example.org\",\r\n" + "    \"title\" : \"Whole Name\"\r\n" + "  }\r\n" + "}",
        configuration2.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult3.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(4, configuration2.size());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult3.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult3.isArray());
    assertFalse(nextResult3.isBigDecimal());
    assertFalse(nextResult3.isBigInteger());
    assertFalse(nextResult3.isBinary());
    assertFalse(nextResult3.isBoolean());
    assertFalse(nextResult3.isContainerNode());
    assertFalse(nextResult3.isDouble());
    assertFalse(nextResult3.isFloat());
    assertFalse(nextResult3.isFloatingPointNumber());
    assertFalse(nextResult3.isInt());
    assertFalse(nextResult3.isIntegralNumber());
    assertFalse(nextResult3.isLong());
    assertFalse(nextResult3.isMissingNode());
    assertFalse(nextResult2.isNull());
    assertFalse(nextResult3.isNull());
    assertFalse(nextResult3.isNumber());
    assertFalse(nextResult3.isObject());
    assertFalse(nextResult3.isPojo());
    assertFalse(nextResult3.isShort());
    assertTrue(nextResult3.isEmpty());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult3.isTextual());
    assertTrue(nextResult3.isValueNode());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test
   * {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   * <p>
   * Method under test:
   * {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  public void testNewNotificationTargetEntity3() throws IOException {
    // Arrange
    SlackNotificationTargetConfig configuration = new SlackNotificationTargetConfig();
    SlackConversation conversation = SlackConversation.builder()
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
    JsonNode configuration2 = (new NotificationTargetEntity(notificationTarget)).getConfiguration();
    assertTrue(configuration2 instanceof ObjectNode);
    Iterator<JsonNode> iteratorResult = configuration2.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof TextNode);
    JsonNode nextResult2 = iteratorResult.next();
    assertTrue(nextResult2 instanceof TextNode);
    JsonNode nextResult3 = iteratorResult.next();
    assertTrue(nextResult3 instanceof TextNode);
    JsonParser traverseResult = nextResult3.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    assertEquals("\"DIRECT\"", nextResult3.toPrettyString());
    assertEquals("\"SLACK\"", nextResult.toPrettyString());
    assertEquals("\"The characteristics of someone or something\"", nextResult2.toPrettyString());
    assertEquals("{\r\n" + "  \"type\" : \"SLACK\",\r\n"
        + "  \"description\" : \"The characteristics of someone or something\",\r\n"
        + "  \"conversationType\" : \"DIRECT\",\r\n" + "  \"conversation\" : {\r\n" + "    \"type\" : \"DIRECT\",\r\n"
        + "    \"id\" : \"42\",\r\n" + "    \"name\" : \"Name\",\r\n" + "    \"wholeName\" : \"\",\r\n"
        + "    \"email\" : \"jane.doe@example.org\",\r\n" + "    \"title\" : \"Name\"\r\n" + "  }\r\n" + "}",
        configuration2.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult.getValueAsString());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, nextResult3.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(4, configuration2.size());
    assertEquals(JsonNodeType.STRING, nextResult2.getNodeType());
    assertEquals(JsonNodeType.STRING, nextResult3.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(nextResult3.isArray());
    assertFalse(nextResult3.isBigDecimal());
    assertFalse(nextResult3.isBigInteger());
    assertFalse(nextResult3.isBinary());
    assertFalse(nextResult3.isBoolean());
    assertFalse(nextResult3.isContainerNode());
    assertFalse(nextResult3.isDouble());
    assertFalse(nextResult3.isFloat());
    assertFalse(nextResult3.isFloatingPointNumber());
    assertFalse(nextResult3.isInt());
    assertFalse(nextResult3.isIntegralNumber());
    assertFalse(nextResult3.isLong());
    assertFalse(nextResult3.isMissingNode());
    assertFalse(nextResult2.isNull());
    assertFalse(nextResult3.isNull());
    assertFalse(nextResult3.isNumber());
    assertFalse(nextResult3.isObject());
    assertFalse(nextResult3.isPojo());
    assertFalse(nextResult3.isShort());
    assertTrue(nextResult3.isEmpty());
    assertTrue(nextResult2.isTextual());
    assertTrue(nextResult3.isTextual());
    assertTrue(nextResult3.isValueNode());
    assertTrue(iteratorResult.hasNext());
  }

  /**
   * Test
   * {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return CreatedTime is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  public void testNewNotificationTargetEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setCreatedTime(1L);

    // Act
    NotificationTargetEntity actualNotificationTargetEntity = new NotificationTargetEntity(notificationTarget);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationTargetEntity.getTenantId().toString());
    assertNull(actualNotificationTargetEntity.getConfiguration());
    assertNull(actualNotificationTargetEntity.getName());
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertNull(actualNotificationTargetEntity.getExternalId());
    assertEquals(1L, actualNotificationTargetEntity.getCreatedTime());
  }

  /**
   * Test
   * {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  public void testNewNotificationTargetEntity_givenSystem_tenant() {
    // Arrange
    NotificationTarget notificationTarget = new NotificationTarget();
    notificationTarget.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    NotificationTargetEntity actualNotificationTargetEntity = new NotificationTargetEntity(notificationTarget);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationTargetEntity.getTenantId().toString());
    assertNull(actualNotificationTargetEntity.getConfiguration());
    assertNull(actualNotificationTargetEntity.getName());
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertNull(actualNotificationTargetEntity.getExternalId());
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
  }

  /**
   * Test
   * {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}.
   * <ul>
   *   <li>When {@link NotificationTarget#NotificationTarget()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTargetEntity#NotificationTargetEntity(NotificationTarget)}
   */
  @Test
  public void testNewNotificationTargetEntity_whenNotificationTarget() {
    // Arrange and Act
    NotificationTargetEntity actualNotificationTargetEntity = new NotificationTargetEntity(new NotificationTarget());

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationTargetEntity.getTenantId().toString());
    assertNull(actualNotificationTargetEntity.getConfiguration());
    assertNull(actualNotificationTargetEntity.getName());
    assertNull(actualNotificationTargetEntity.getId());
    assertNull(actualNotificationTargetEntity.getUuid());
    assertNull(actualNotificationTargetEntity.getExternalId());
    assertEquals(0L, actualNotificationTargetEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   * <ul>
   *   <li>Given {@link NotificationTargetEntity#NotificationTargetEntity()}.</li>
   *   <li>Then return ExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  public void testToData_givenNotificationTargetEntity_thenReturnExternalIdIsNull() {
    // Arrange and Act
    NotificationTarget actualToDataResult = (new NotificationTargetEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    NotificationTargetId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getExternalId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   * <ul>
   *   <li>Then return ExternalId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  public void testToData_thenReturnExternalIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    NotificationTarget actualToDataResult = notificationTargetEntity.toData();

    // Assert
    NotificationTargetId externalId = actualToDataResult.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.getId().toString());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    NotificationTargetId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.NOTIFICATION_TARGET, id.getEntityType());
    assertEquals(EntityType.NOTIFICATION_TARGET, externalId.getEntityType());
    assertFalse(id.isNullUid());
    assertTrue(externalId.isNullUid());
  }

  /**
   * Test {@link NotificationTargetEntity#toData()}.
   * <ul>
   *   <li>Then return UuidId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTargetEntity#toData()}
   */
  @Test
  public void testToData_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    NotificationTargetEntity notificationTargetEntity = new NotificationTargetEntity();
    notificationTargetEntity.setConfiguration(MissingNode.getInstance());
    notificationTargetEntity.setCreatedTime(1L);
    notificationTargetEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setName("Name");
    notificationTargetEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTargetEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    NotificationTarget actualToDataResult = notificationTargetEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    NotificationTargetId externalId = actualToDataResult.getExternalId();
    assertEquals(externalId, actualToDataResult.getId());
    assertSame(uuidId, externalId.getId());
  }
}
