package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.mobile.MobileAppOauth2Client;
import org.thingsboard.server.dao.model.ModelConstants;

public class MobileAppOauth2ClientEntityDiffblueTest {
  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and
   * {@link MobileAppOauth2ClientEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2ClientEntity#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
    int expectedHashCodeResult = mobileAppOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and
   * {@link MobileAppOauth2ClientEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2ClientEntity#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(null);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(null);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
    int expectedHashCodeResult = mobileAppOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and
   * {@link MobileAppOauth2ClientEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2ClientEntity#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(null);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(null);

    // Act and Assert
    assertEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
    int expectedHashCodeResult = mobileAppOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and
   * {@link MobileAppOauth2ClientEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2ClientEntity#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    MobileAppOauth2Client domainOauth2Provider = mock(MobileAppOauth2Client.class);
    when(domainOauth2Provider.getOAuth2ClientId()).thenReturn(new OAuth2ClientId(ModelConstants.NULL_UUID));
    when(domainOauth2Provider.getMobileAppId()).thenReturn(new MobileAppId(ModelConstants.NULL_UUID));

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity(domainOauth2Provider);
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
    int expectedHashCodeResult = mobileAppOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and
   * {@link MobileAppOauth2ClientEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2ClientEntity#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity);
    int expectedHashCodeResult = mobileAppOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientEntity.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2ClientEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(UUID.randomUUID());
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2ClientEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(null);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2ClientEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(UUID.randomUUID());

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2ClientEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(null);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2ClientEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientEntity, null);
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2ClientEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientEntity, "Different type to MobileAppOauth2ClientEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2ClientEntity#MobileAppOauth2ClientEntity()}
   *   <li>{@link MobileAppOauth2ClientEntity#setMobileAppId(UUID)}
   *   <li>{@link MobileAppOauth2ClientEntity#setOauth2ClientId(UUID)}
   *   <li>{@link MobileAppOauth2ClientEntity#toString()}
   *   <li>{@link MobileAppOauth2ClientEntity#getMobileAppId()}
   *   <li>{@link MobileAppOauth2ClientEntity#getOauth2ClientId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MobileAppOauth2ClientEntity actualMobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    actualMobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    UUID oauth2ClientId = ModelConstants.NULL_UUID;
    actualMobileAppOauth2ClientEntity.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualMobileAppOauth2ClientEntity.toString();
    UUID actualMobileAppId = actualMobileAppOauth2ClientEntity.getMobileAppId();
    UUID actualOauth2ClientId = actualMobileAppOauth2ClientEntity.getOauth2ClientId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualMobileAppId.toString());
    assertEquals("MobileAppOauth2ClientEntity(mobileAppId=13814000-1dd2-11b2-8080-808080808080, oauth2ClientId=13814000"
        + "-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertSame(oauth2ClientId, actualMobileAppId);
    assertSame(oauth2ClientId, actualOauth2ClientId);
  }

  /**
   * Test
   * {@link MobileAppOauth2ClientEntity#MobileAppOauth2ClientEntity(MobileAppOauth2Client)}.
   * <p>
   * Method under test:
   * {@link MobileAppOauth2ClientEntity#MobileAppOauth2ClientEntity(MobileAppOauth2Client)}
   */
  @Test
  public void testNewMobileAppOauth2ClientEntity() {
    // Arrange
    MobileAppOauth2Client domainOauth2Provider = new MobileAppOauth2Client();
    domainOauth2Provider.setOAuth2ClientId(new OAuth2ClientId(ModelConstants.NULL_UUID));
    domainOauth2Provider.setMobileAppId(new MobileAppId(ModelConstants.NULL_UUID));

    // Act
    MobileAppOauth2ClientEntity actualMobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity(
        domainOauth2Provider);

    // Assert
    UUID mobileAppId = actualMobileAppOauth2ClientEntity.getMobileAppId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", mobileAppId.toString());
    assertSame(mobileAppId, actualMobileAppOauth2ClientEntity.getOauth2ClientId());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#toData()}.
   * <p>
   * Method under test: {@link MobileAppOauth2ClientEntity#toData()}
   */
  @Test
  public void testToData() {
    // Arrange and Act
    MobileAppOauth2Client actualToDataResult = (new MobileAppOauth2ClientEntity()).toData();

    // Assert
    MobileAppId mobileAppId = actualToDataResult.getMobileAppId();
    assertNull(mobileAppId.getId());
    OAuth2ClientId oAuth2ClientId = actualToDataResult.getOAuth2ClientId();
    assertNull(oAuth2ClientId.getId());
    assertEquals(EntityType.MOBILE_APP, mobileAppId.getEntityType());
    assertEquals(EntityType.OAUTH2_CLIENT, oAuth2ClientId.getEntityType());
    assertFalse(mobileAppId.isNullUid());
    assertFalse(oAuth2ClientId.isNullUid());
  }
}
