package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonStreamContext;
import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.fasterxml.jackson.databind.node.NullNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationTemplateId;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.template.NotificationTemplate;
import org.thingsboard.server.common.data.notification.template.NotificationTemplateConfig;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationTemplateEntityDiffblueTest {
  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}, and
   * {@link NotificationTemplateEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplateEntity#equals(Object)}
   *   <li>{@link NotificationTemplateEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity2);
    int expectedHashCodeResult = notificationTemplateEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}, and
   * {@link NotificationTemplateEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplateEntity#equals(Object)}
   *   <li>{@link NotificationTemplateEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(null);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(null);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity2);
    int expectedHashCodeResult = notificationTemplateEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateEntity2.hashCode());
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}, and
   * {@link NotificationTemplateEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplateEntity#equals(Object)}
   *   <li>{@link NotificationTemplateEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationTemplateEntity, notificationTemplateEntity);
    int expectedHashCodeResult = notificationTemplateEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationTemplateEntity.hashCode());
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(null);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(mock(JsonNode.class));
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(3L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(UUID.randomUUID());
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(null);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName(null);
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("org.thingsboard.server.dao.model.sql.NotificationTemplateEntity");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(null);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.ALARM);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(UUID.randomUUID());
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(null);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationTemplateEntity notificationTemplateEntity2 = new NotificationTemplateEntity();
    notificationTemplateEntity2.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity2.setCreatedTime(1L);
    notificationTemplateEntity2.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setName("Name");
    notificationTemplateEntity2.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity2.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, notificationTemplateEntity2);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, null);
  }

  /**
   * Test {@link NotificationTemplateEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationTemplateEntity, "Different type to NotificationTemplateEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationTemplateEntity#NotificationTemplateEntity()}
   *   <li>{@link NotificationTemplateEntity#setConfiguration(JsonNode)}
   *   <li>{@link NotificationTemplateEntity#setExternalId(UUID)}
   *   <li>{@link NotificationTemplateEntity#setName(String)}
   *   <li>{@link NotificationTemplateEntity#setNotificationType(NotificationType)}
   *   <li>{@link NotificationTemplateEntity#setTenantId(UUID)}
   *   <li>{@link NotificationTemplateEntity#toString()}
   *   <li>{@link NotificationTemplateEntity#getConfiguration()}
   *   <li>{@link NotificationTemplateEntity#getExternalId()}
   *   <li>{@link NotificationTemplateEntity#getName()}
   *   <li>{@link NotificationTemplateEntity#getNotificationType()}
   *   <li>{@link NotificationTemplateEntity#getTenantId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationTemplateEntity actualNotificationTemplateEntity = new NotificationTemplateEntity();
    JsonNode configuration = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationTemplateEntity.setConfiguration(configuration);
    actualNotificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    actualNotificationTemplateEntity.setName("Name");
    actualNotificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    UUID tenantId = ModelConstants.NULL_UUID;
    actualNotificationTemplateEntity.setTenantId(tenantId);
    String actualToStringResult = actualNotificationTemplateEntity.toString();
    JsonNode actualConfiguration = actualNotificationTemplateEntity.getConfiguration();
    UUID actualExternalId = actualNotificationTemplateEntity.getExternalId();
    String actualName = actualNotificationTemplateEntity.getName();
    NotificationType actualNotificationType = actualNotificationTemplateEntity.getNotificationType();
    UUID actualTenantId = actualNotificationTemplateEntity.getTenantId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualExternalId.toString());
    assertEquals("Name", actualName);
    assertEquals(
        "NotificationTemplateEntity(tenantId=13814000-1dd2-11b2-8080-808080808080, name=Name, notificationType"
            + "=GENERAL, configuration={\"isPublic\":true}, externalId=13814000-1dd2-11b2-8080-808080808080)",
        actualToStringResult);
    assertEquals(0L, actualNotificationTemplateEntity.getCreatedTime());
    assertEquals(NotificationType.GENERAL, actualNotificationType);
    assertSame(configuration, actualConfiguration);
    assertSame(tenantId, actualExternalId);
    assertSame(tenantId, actualTenantId);
  }

  /**
   * Test
   * {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}.
   * <p>
   * Method under test:
   * {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}
   */
  @Test
  public void testNewNotificationTemplateEntity() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setExternalId(new NotificationTemplateId(ModelConstants.NULL_UUID));

    // Act
    NotificationTemplateEntity actualNotificationTemplateEntity = new NotificationTemplateEntity(notificationTemplate);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationTemplateEntity.getExternalId().toString());
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationTemplateEntity.getTenantId().toString());
    assertNull(actualNotificationTemplateEntity.getConfiguration());
    assertNull(actualNotificationTemplateEntity.getName());
    assertNull(actualNotificationTemplateEntity.getId());
    assertNull(actualNotificationTemplateEntity.getUuid());
    assertNull(actualNotificationTemplateEntity.getNotificationType());
    assertEquals(0L, actualNotificationTemplateEntity.getCreatedTime());
  }

  /**
   * Test
   * {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}.
   * <ul>
   *   <li>Given one.</li>
   *   <li>Then return CreatedTime is one.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}
   */
  @Test
  public void testNewNotificationTemplateEntity_givenOne_thenReturnCreatedTimeIsOne() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setCreatedTime(1L);

    // Act
    NotificationTemplateEntity actualNotificationTemplateEntity = new NotificationTemplateEntity(notificationTemplate);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationTemplateEntity.getTenantId().toString());
    assertNull(actualNotificationTemplateEntity.getConfiguration());
    assertNull(actualNotificationTemplateEntity.getName());
    assertNull(actualNotificationTemplateEntity.getId());
    assertNull(actualNotificationTemplateEntity.getUuid());
    assertNull(actualNotificationTemplateEntity.getExternalId());
    assertNull(actualNotificationTemplateEntity.getNotificationType());
    assertEquals(1L, actualNotificationTemplateEntity.getCreatedTime());
  }

  /**
   * Test
   * {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}.
   * <ul>
   *   <li>Given {@link ModelConstants#SYSTEM_TENANT}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}
   */
  @Test
  public void testNewNotificationTemplateEntity_givenSystem_tenant() {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setTenantId(ModelConstants.SYSTEM_TENANT);

    // Act
    NotificationTemplateEntity actualNotificationTemplateEntity = new NotificationTemplateEntity(notificationTemplate);

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationTemplateEntity.getTenantId().toString());
    assertNull(actualNotificationTemplateEntity.getConfiguration());
    assertNull(actualNotificationTemplateEntity.getName());
    assertNull(actualNotificationTemplateEntity.getId());
    assertNull(actualNotificationTemplateEntity.getUuid());
    assertNull(actualNotificationTemplateEntity.getExternalId());
    assertNull(actualNotificationTemplateEntity.getNotificationType());
    assertEquals(0L, actualNotificationTemplateEntity.getCreatedTime());
  }

  /**
   * Test
   * {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}.
   * <ul>
   *   <li>Then Configuration iterator next return {@link NullNode}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}
   */
  @Test
  public void testNewNotificationTemplateEntity_thenConfigurationIteratorNextReturnNullNode() throws IOException {
    // Arrange
    NotificationTemplate notificationTemplate = new NotificationTemplate();
    notificationTemplate.setConfiguration(new NotificationTemplateConfig());

    // Act and Assert
    JsonNode configuration = (new NotificationTemplateEntity(notificationTemplate)).getConfiguration();
    Iterator<JsonNode> iteratorResult = configuration.iterator();
    JsonNode nextResult = iteratorResult.next();
    assertTrue(nextResult instanceof NullNode);
    assertTrue(configuration instanceof ObjectNode);
    JsonParser traverseResult = nextResult.traverse();
    assertTrue(traverseResult instanceof TreeTraversingParser);
    JsonParser traverseResult2 = configuration.traverse();
    assertTrue(traverseResult2 instanceof TreeTraversingParser);
    JsonStreamContext parsingContext = traverseResult.getParsingContext();
    assertEquals("ROOT", parsingContext.getTypeDesc());
    JsonStreamContext parsingContext2 = traverseResult2.getParsingContext();
    assertEquals("ROOT", parsingContext2.getTypeDesc());
    Version versionResult = traverseResult2.version();
    assertEquals("com.fasterxml.jackson.core", versionResult.getGroupId());
    assertEquals("com.fasterxml.jackson.core/jackson-databind/2.17.2", versionResult.toFullString());
    assertEquals("jackson-databind", versionResult.getArtifactId());
    assertEquals("null", nextResult.toPrettyString());
    assertEquals("{\r\n  \"deliveryMethodsTemplates\" : null\r\n}", configuration.toPrettyString());
    assertNull(traverseResult.getBinaryValue());
    assertNull(traverseResult2.getBinaryValue());
    assertNull(traverseResult.getSchema());
    assertNull(traverseResult2.getSchema());
    assertNull(traverseResult.getCurrentToken());
    assertNull(traverseResult2.getCurrentToken());
    assertNull(traverseResult.getLastClearedToken());
    assertNull(traverseResult2.getLastClearedToken());
    assertNull(traverseResult.getCodec());
    assertNull(traverseResult2.getCodec());
    assertNull(traverseResult.getNonBlockingInputFeeder());
    assertNull(traverseResult2.getNonBlockingInputFeeder());
    JsonLocation currentLocation = traverseResult2.getCurrentLocation();
    assertNull(currentLocation.getSourceRef());
    assertNull(traverseResult.getCurrentValue());
    assertNull(traverseResult2.getCurrentValue());
    assertNull(traverseResult.getEmbeddedObject());
    assertNull(traverseResult2.getEmbeddedObject());
    assertNull(traverseResult.getInputSource());
    assertNull(traverseResult2.getInputSource());
    assertNull(traverseResult.getObjectId());
    assertNull(traverseResult2.getObjectId());
    assertNull(traverseResult.getTypeId());
    assertNull(traverseResult2.getTypeId());
    assertNull(parsingContext.getCurrentValue());
    assertNull(parsingContext2.getCurrentValue());
    assertNull(traverseResult.getCurrentName());
    assertNull(traverseResult2.getCurrentName());
    assertNull(traverseResult.getText());
    assertNull(traverseResult2.getText());
    assertNull(traverseResult.getValueAsString());
    assertNull(traverseResult2.getValueAsString());
    assertEquals(-1, currentLocation.getColumnNr());
    assertEquals(-1, currentLocation.getLineNr());
    assertEquals(-1L, currentLocation.getByteOffset());
    assertEquals(-1L, currentLocation.getCharOffset());
    assertEquals(0, traverseResult.getCurrentTokenId());
    assertEquals(0, traverseResult2.getCurrentTokenId());
    assertEquals(0, traverseResult.getFeatureMask());
    assertEquals(0, traverseResult2.getFeatureMask());
    assertEquals(0, traverseResult.getFormatFeatures());
    assertEquals(0, traverseResult2.getFormatFeatures());
    assertEquals(0, traverseResult.getTextOffset());
    assertEquals(0, traverseResult2.getTextOffset());
    assertEquals(0, traverseResult.getValueAsInt());
    assertEquals(0, traverseResult2.getValueAsInt());
    assertEquals(0, parsingContext.getCurrentIndex());
    assertEquals(0, parsingContext2.getCurrentIndex());
    assertEquals(0, parsingContext.getEntryCount());
    assertEquals(0, parsingContext2.getEntryCount());
    assertEquals(0, parsingContext.getNestingDepth());
    assertEquals(0, parsingContext2.getNestingDepth());
    assertEquals(0, nextResult.size());
    assertEquals(0.0d, traverseResult.getValueAsDouble(), 0.0);
    assertEquals(0.0d, traverseResult2.getValueAsDouble(), 0.0);
    assertEquals(0L, traverseResult.getValueAsLong());
    assertEquals(0L, traverseResult2.getValueAsLong());
    assertEquals(1, configuration.size());
    assertEquals(17, versionResult.getMinorVersion());
    assertEquals(2, versionResult.getMajorVersion());
    assertEquals(2, versionResult.getPatchLevel());
    assertEquals(JsonNodeType.NULL, nextResult.getNodeType());
    assertEquals(JsonNodeType.OBJECT, configuration.getNodeType());
    assertFalse(traverseResult.getValueAsBoolean());
    assertFalse(traverseResult2.getValueAsBoolean());
    assertFalse(traverseResult.hasCurrentToken());
    assertFalse(traverseResult2.hasCurrentToken());
    assertFalse(traverseResult.hasTextCharacters());
    assertFalse(traverseResult2.hasTextCharacters());
    assertFalse(traverseResult.isClosed());
    assertFalse(traverseResult2.isClosed());
    assertFalse(traverseResult.isExpectedNumberIntToken());
    assertFalse(traverseResult2.isExpectedNumberIntToken());
    assertFalse(traverseResult.isExpectedStartArrayToken());
    assertFalse(traverseResult2.isExpectedStartArrayToken());
    assertFalse(traverseResult.isExpectedStartObjectToken());
    assertFalse(traverseResult2.isExpectedStartObjectToken());
    assertFalse(traverseResult.isNaN());
    assertFalse(traverseResult2.isNaN());
    assertFalse(parsingContext.hasCurrentIndex());
    assertFalse(parsingContext2.hasCurrentIndex());
    assertFalse(parsingContext.hasCurrentName());
    assertFalse(parsingContext2.hasCurrentName());
    assertFalse(parsingContext.hasPathSegment());
    assertFalse(parsingContext2.hasPathSegment());
    assertFalse(versionResult.isSnapshot());
    assertFalse(versionResult.isUknownVersion());
    assertFalse(versionResult.isUnknownVersion());
    assertFalse(nextResult.isArray());
    assertFalse(configuration.isArray());
    assertFalse(nextResult.isBigDecimal());
    assertFalse(configuration.isBigDecimal());
    assertFalse(nextResult.isBigInteger());
    assertFalse(configuration.isBigInteger());
    assertFalse(nextResult.isBinary());
    assertFalse(configuration.isBinary());
    assertFalse(nextResult.isBoolean());
    assertFalse(configuration.isBoolean());
    assertFalse(nextResult.isContainerNode());
    assertFalse(nextResult.isDouble());
    assertFalse(configuration.isDouble());
    assertFalse(configuration.isEmpty());
    assertFalse(nextResult.isFloat());
    assertFalse(configuration.isFloat());
    assertFalse(nextResult.isFloatingPointNumber());
    assertFalse(configuration.isFloatingPointNumber());
    assertFalse(nextResult.isInt());
    assertFalse(configuration.isInt());
    assertFalse(nextResult.isIntegralNumber());
    assertFalse(configuration.isIntegralNumber());
    assertFalse(nextResult.isLong());
    assertFalse(configuration.isLong());
    assertFalse(nextResult.isMissingNode());
    assertFalse(configuration.isMissingNode());
    assertFalse(configuration.isNull());
    assertFalse(nextResult.isNumber());
    assertFalse(configuration.isNumber());
    assertFalse(nextResult.isObject());
    assertFalse(nextResult.isPojo());
    assertFalse(configuration.isPojo());
    assertFalse(nextResult.isShort());
    assertFalse(configuration.isShort());
    assertFalse(nextResult.isTextual());
    assertFalse(configuration.isTextual());
    assertFalse(configuration.isValueNode());
    assertFalse(nextResult.iterator().hasNext());
    assertFalse(iteratorResult.hasNext());
    assertTrue(configuration.isContainerNode());
    assertTrue(nextResult.isEmpty());
    assertTrue(nextResult.isNull());
    assertTrue(configuration.isObject());
    assertTrue(nextResult.isValueNode());
    assertSame(currentLocation, traverseResult.getCurrentLocation());
    assertSame(currentLocation, traverseResult.getTokenLocation());
    assertSame(currentLocation, traverseResult2.getTokenLocation());
    assertSame(versionResult, traverseResult.version());
  }

  /**
   * Test
   * {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}.
   * <ul>
   *   <li>When {@link NotificationTemplate#NotificationTemplate()}.</li>
   * </ul>
   * <p>
   * Method under test:
   * {@link NotificationTemplateEntity#NotificationTemplateEntity(NotificationTemplate)}
   */
  @Test
  public void testNewNotificationTemplateEntity_whenNotificationTemplate() {
    // Arrange and Act
    NotificationTemplateEntity actualNotificationTemplateEntity = new NotificationTemplateEntity(
        new NotificationTemplate());

    // Assert
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualNotificationTemplateEntity.getTenantId().toString());
    assertNull(actualNotificationTemplateEntity.getConfiguration());
    assertNull(actualNotificationTemplateEntity.getName());
    assertNull(actualNotificationTemplateEntity.getId());
    assertNull(actualNotificationTemplateEntity.getUuid());
    assertNull(actualNotificationTemplateEntity.getExternalId());
    assertNull(actualNotificationTemplateEntity.getNotificationType());
    assertEquals(0L, actualNotificationTemplateEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   * <ul>
   *   <li>Given
   * {@link NotificationTemplateEntity#NotificationTemplateEntity()}.</li>
   *   <li>Then return ExternalId is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  public void testToData_givenNotificationTemplateEntity_thenReturnExternalIdIsNull() {
    // Arrange and Act
    NotificationTemplate actualToDataResult = (new NotificationTemplateEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    NotificationTemplateId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getExternalId());
    assertNull(actualToDataResult.getNotificationType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, id.getEntityType());
    assertFalse(id.isNullUid());
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   * <ul>
   *   <li>Then return ExternalId Id toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  public void testToData_thenReturnExternalIdIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);

    // Act
    NotificationTemplate actualToDataResult = notificationTemplateEntity.toData();

    // Assert
    NotificationTemplateId externalId = actualToDataResult.getExternalId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", externalId.getId().toString());
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getUuidId());
    NotificationTemplateId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getNotificationType());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, id.getEntityType());
    assertEquals(EntityType.NOTIFICATION_TEMPLATE, externalId.getEntityType());
    assertFalse(id.isNullUid());
    assertTrue(externalId.isNullUid());
  }

  /**
   * Test {@link NotificationTemplateEntity#toData()}.
   * <ul>
   *   <li>Then return UuidId toString is
   * {@code 13814000-1dd2-11b2-8080-808080808080}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationTemplateEntity#toData()}
   */
  @Test
  public void testToData_thenReturnUuidIdToStringIs138140001dd211b28080808080808080() {
    // Arrange
    NotificationTemplateEntity notificationTemplateEntity = new NotificationTemplateEntity();
    notificationTemplateEntity.setConfiguration(MissingNode.getInstance());
    notificationTemplateEntity.setCreatedTime(1L);
    notificationTemplateEntity.setExternalId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setName("Name");
    notificationTemplateEntity.setNotificationType(NotificationType.GENERAL);
    notificationTemplateEntity.setTenantId(ModelConstants.NULL_UUID);
    notificationTemplateEntity.setUuid(ModelConstants.NULL_UUID);

    // Act
    NotificationTemplate actualToDataResult = notificationTemplateEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Name", actualToDataResult.getName());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    assertEquals(NotificationType.GENERAL, actualToDataResult.getNotificationType());
    NotificationTemplateId externalId = actualToDataResult.getExternalId();
    assertEquals(externalId, actualToDataResult.getId());
    assertSame(uuidId, externalId.getId());
  }
}
