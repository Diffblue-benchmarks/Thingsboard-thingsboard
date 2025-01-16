package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import com.fasterxml.jackson.databind.JsonNode;
import java.util.UUID;
import org.junit.Test;
import org.mockito.Mockito;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.NotificationId;
import org.thingsboard.server.common.data.id.NotificationRequestId;
import org.thingsboard.server.common.data.notification.Notification;
import org.thingsboard.server.common.data.notification.NotificationDeliveryMethod;
import org.thingsboard.server.common.data.notification.NotificationStatus;
import org.thingsboard.server.common.data.notification.NotificationType;
import org.thingsboard.server.common.data.notification.info.NotificationInfo;
import org.thingsboard.server.dao.customer.CustomerServiceImpl;
import org.thingsboard.server.dao.model.ModelConstants;

public class NotificationEntityDiffblueTest {
  /**
   * Test {@link NotificationEntity#equals(Object)}, and
   * {@link NotificationEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationEntity#equals(Object)}
   *   <li>{@link NotificationEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(ModelConstants.NULL_UUID);
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity2.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationEntity, notificationEntity2);
    int expectedHashCodeResult = notificationEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationEntity2.hashCode());
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}, and
   * {@link NotificationEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationEntity#equals(Object)}
   *   <li>{@link NotificationEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    Notification.NotificationBuilder notificationBuilder = mock(Notification.NotificationBuilder.class);
    when(notificationBuilder.info(Mockito.<NotificationInfo>any())).thenReturn(Notification.builder());
    Notification.NotificationBuilder notificationBuilder2 = mock(Notification.NotificationBuilder.class);
    when(notificationBuilder2.deliveryMethod(Mockito.<NotificationDeliveryMethod>any()))
        .thenReturn(notificationBuilder);
    Notification.NotificationBuilder recipientIdResult = notificationBuilder2
        .deliveryMethod(NotificationDeliveryMethod.WEB)
        .info(mock(NotificationInfo.class))
        .recipientId(null);
    Notification notification = recipientIdResult.requestId(new NotificationRequestId(ModelConstants.NULL_UUID))
        .status(NotificationStatus.SENT)
        .subject("Hello from the Dreaming Spires")
        .text("Text")
        .type(NotificationType.GENERAL)
        .build();

    NotificationEntity notificationEntity = new NotificationEntity(notification);
    notificationEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    NotificationEntity notificationEntity2 = new NotificationEntity();
    notificationEntity2.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setCreatedTime(1L);
    notificationEntity2.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity2.setId(ModelConstants.NULL_UUID);
    notificationEntity2.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity2.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity2.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity2.setStatus(NotificationStatus.SENT);
    notificationEntity2.setSubject("Hello from the Dreaming Spires");
    notificationEntity2.setText("Text");
    notificationEntity2.setType(NotificationType.GENERAL);
    notificationEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationEntity, notificationEntity2);
    int expectedHashCodeResult = notificationEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationEntity2.hashCode());
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}, and
   * {@link NotificationEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationEntity#equals(Object)}
   *   <li>{@link NotificationEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(notificationEntity, notificationEntity);
    int expectedHashCodeResult = notificationEntity.hashCode();
    assertEquals(expectedHashCodeResult, notificationEntity.hashCode());
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationEntity, null);
  }

  /**
   * Test {@link NotificationEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    NotificationEntity notificationEntity = new NotificationEntity();
    notificationEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setCreatedTime(1L);
    notificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    notificationEntity.setId(ModelConstants.NULL_UUID);
    notificationEntity.setInfo(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    notificationEntity.setRecipientId(ModelConstants.NULL_UUID);
    notificationEntity.setRequestId(ModelConstants.NULL_UUID);
    notificationEntity.setStatus(NotificationStatus.SENT);
    notificationEntity.setSubject("Hello from the Dreaming Spires");
    notificationEntity.setText("Text");
    notificationEntity.setType(NotificationType.GENERAL);
    notificationEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(notificationEntity, "Different type to NotificationEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link NotificationEntity#NotificationEntity()}
   *   <li>{@link NotificationEntity#setAdditionalConfig(JsonNode)}
   *   <li>{@link NotificationEntity#setDeliveryMethod(NotificationDeliveryMethod)}
   *   <li>{@link NotificationEntity#setInfo(JsonNode)}
   *   <li>{@link NotificationEntity#setRecipientId(UUID)}
   *   <li>{@link NotificationEntity#setRequestId(UUID)}
   *   <li>{@link NotificationEntity#setStatus(NotificationStatus)}
   *   <li>{@link NotificationEntity#setSubject(String)}
   *   <li>{@link NotificationEntity#setText(String)}
   *   <li>{@link NotificationEntity#setType(NotificationType)}
   *   <li>{@link NotificationEntity#toString()}
   *   <li>{@link NotificationEntity#getAdditionalConfig()}
   *   <li>{@link NotificationEntity#getDeliveryMethod()}
   *   <li>{@link NotificationEntity#getInfo()}
   *   <li>{@link NotificationEntity#getRecipientId()}
   *   <li>{@link NotificationEntity#getRequestId()}
   *   <li>{@link NotificationEntity#getStatus()}
   *   <li>{@link NotificationEntity#getSubject()}
   *   <li>{@link NotificationEntity#getText()}
   *   <li>{@link NotificationEntity#getType()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    NotificationEntity actualNotificationEntity = new NotificationEntity();
    actualNotificationEntity.setAdditionalConfig(CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON);
    actualNotificationEntity.setDeliveryMethod(NotificationDeliveryMethod.WEB);
    JsonNode info = CustomerServiceImpl.PUBLIC_CUSTOMER_ADDITIONAL_INFO_JSON;
    actualNotificationEntity.setInfo(info);
    actualNotificationEntity.setRecipientId(ModelConstants.NULL_UUID);
    UUID requestId = ModelConstants.NULL_UUID;
    actualNotificationEntity.setRequestId(requestId);
    actualNotificationEntity.setStatus(NotificationStatus.SENT);
    actualNotificationEntity.setSubject("Hello from the Dreaming Spires");
    actualNotificationEntity.setText("Text");
    actualNotificationEntity.setType(NotificationType.GENERAL);
    String actualToStringResult = actualNotificationEntity.toString();
    JsonNode actualAdditionalConfig = actualNotificationEntity.getAdditionalConfig();
    NotificationDeliveryMethod actualDeliveryMethod = actualNotificationEntity.getDeliveryMethod();
    JsonNode actualInfo = actualNotificationEntity.getInfo();
    UUID actualRecipientId = actualNotificationEntity.getRecipientId();
    UUID actualRequestId = actualNotificationEntity.getRequestId();
    NotificationStatus actualStatus = actualNotificationEntity.getStatus();
    String actualSubject = actualNotificationEntity.getSubject();
    String actualText = actualNotificationEntity.getText();
    NotificationType actualType = actualNotificationEntity.getType();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualRecipientId.toString());
    assertEquals("Hello from the Dreaming Spires", actualSubject);
    assertEquals(
        "NotificationEntity(requestId=13814000-1dd2-11b2-8080-808080808080, recipientId=13814000-1dd2-11b2-8080"
            + "-808080808080, type=GENERAL, deliveryMethod=WEB, subject=Hello from the Dreaming Spires, text=Text,"
            + " additionalConfig={\"isPublic\":true}, info={\"isPublic\":true}, status=SENT)",
        actualToStringResult);
    assertEquals("Text", actualText);
    assertEquals(0L, actualNotificationEntity.getCreatedTime());
    assertEquals(NotificationDeliveryMethod.WEB, actualDeliveryMethod);
    assertEquals(NotificationStatus.SENT, actualStatus);
    assertEquals(NotificationType.GENERAL, actualType);
    assertSame(info, actualAdditionalConfig);
    assertSame(info, actualInfo);
    assertSame(requestId, actualRecipientId);
    assertSame(requestId, actualRequestId);
  }

  /**
   * Test {@link NotificationEntity#NotificationEntity(Notification)}.
   * <p>
   * Method under test:
   * {@link NotificationEntity#NotificationEntity(Notification)}
   */
  @Test
  public void testNewNotificationEntity() {
    // Arrange and Act
    NotificationEntity actualNotificationEntity = new NotificationEntity(new Notification());

    // Assert
    assertNull(actualNotificationEntity.getAdditionalConfig());
    assertNull(actualNotificationEntity.getInfo());
    assertNull(actualNotificationEntity.getSubject());
    assertNull(actualNotificationEntity.getText());
    assertNull(actualNotificationEntity.getId());
    assertNull(actualNotificationEntity.getUuid());
    assertNull(actualNotificationEntity.getRecipientId());
    assertNull(actualNotificationEntity.getRequestId());
    assertNull(actualNotificationEntity.getDeliveryMethod());
    assertNull(actualNotificationEntity.getStatus());
    assertNull(actualNotificationEntity.getType());
    assertEquals(0L, actualNotificationEntity.getCreatedTime());
  }

  /**
   * Test {@link NotificationEntity#toData()}.
   * <ul>
   *   <li>Given {@link NotificationEntity#NotificationEntity()}.</li>
   *   <li>Then return AdditionalConfig is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link NotificationEntity#toData()}
   */
  @Test
  public void testToData_givenNotificationEntity_thenReturnAdditionalConfigIsNull() {
    // Arrange and Act
    Notification actualToDataResult = (new NotificationEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getAdditionalConfig());
    assertNull(actualToDataResult.getSubject());
    assertNull(actualToDataResult.getText());
    assertNull(actualToDataResult.getUuidId());
    NotificationId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertNull(actualToDataResult.getRequestId());
    assertNull(actualToDataResult.getRecipientId());
    assertNull(actualToDataResult.getDeliveryMethod());
    assertNull(actualToDataResult.getStatus());
    assertNull(actualToDataResult.getType());
    assertNull(actualToDataResult.getInfo());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertEquals(EntityType.NOTIFICATION, id.getEntityType());
    assertFalse(id.isNullUid());
  }
}
