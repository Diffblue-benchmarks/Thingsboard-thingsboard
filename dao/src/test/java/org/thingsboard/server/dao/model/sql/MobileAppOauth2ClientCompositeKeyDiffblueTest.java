package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.dao.model.ModelConstants;

public class MobileAppOauth2ClientCompositeKeyDiffblueTest {
  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}, and
   * {@link MobileAppOauth2ClientCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey();
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey2 = new MobileAppOauth2ClientCompositeKey();

    // Act and Assert
    assertEquals(mobileAppOauth2ClientCompositeKey, mobileAppOauth2ClientCompositeKey2);
    int expectedHashCodeResult = mobileAppOauth2ClientCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientCompositeKey2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}, and
   * {@link MobileAppOauth2ClientCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey2 = new MobileAppOauth2ClientCompositeKey(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(mobileAppOauth2ClientCompositeKey, mobileAppOauth2ClientCompositeKey2);
    int expectedHashCodeResult = mobileAppOauth2ClientCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientCompositeKey2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}, and
   * {@link MobileAppOauth2ClientCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey();

    // Act and Assert
    assertEquals(mobileAppOauth2ClientCompositeKey, mobileAppOauth2ClientCompositeKey);
    int expectedHashCodeResult = mobileAppOauth2ClientCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientCompositeKey.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientCompositeKey, new MobileAppOauth2ClientCompositeKey());
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey();

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientCompositeKey,
        new MobileAppOauth2ClientCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID));
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey();
    mobileAppOauth2ClientCompositeKey.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientCompositeKey, new MobileAppOauth2ClientCompositeKey());
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey();

    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey2 = new MobileAppOauth2ClientCompositeKey();
    mobileAppOauth2ClientCompositeKey2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientCompositeKey, mobileAppOauth2ClientCompositeKey2);
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2ClientCompositeKey(), null);
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link MobileAppOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2ClientCompositeKey(), "Different type to MobileAppOauth2ClientCompositeKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MobileAppOauth2ClientCompositeKey#MobileAppOauth2ClientCompositeKey()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#setMobileAppId(UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#setOauth2ClientId(UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#toString()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#getMobileAppId()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#getOauth2ClientId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    MobileAppOauth2ClientCompositeKey actualMobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey();
    actualMobileAppOauth2ClientCompositeKey.setMobileAppId(ModelConstants.NULL_UUID);
    UUID oauth2ClientId = ModelConstants.NULL_UUID;
    actualMobileAppOauth2ClientCompositeKey.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualMobileAppOauth2ClientCompositeKey.toString();
    UUID actualMobileAppId = actualMobileAppOauth2ClientCompositeKey.getMobileAppId();
    UUID actualOauth2ClientId = actualMobileAppOauth2ClientCompositeKey.getOauth2ClientId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualMobileAppId.toString());
    assertEquals("MobileAppOauth2ClientCompositeKey(mobileAppId=13814000-1dd2-11b2-8080-808080808080, oauth2ClientId"
        + "=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertSame(oauth2ClientId, actualMobileAppId);
    assertSame(oauth2ClientId, actualOauth2ClientId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When {@link ModelConstants#NULL_UUID}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>
   * {@link MobileAppOauth2ClientCompositeKey#MobileAppOauth2ClientCompositeKey(UUID, UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#setMobileAppId(UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#setOauth2ClientId(UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#toString()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#getMobileAppId()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#getOauth2ClientId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    MobileAppOauth2ClientCompositeKey actualMobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    actualMobileAppOauth2ClientCompositeKey.setMobileAppId(ModelConstants.NULL_UUID);
    UUID oauth2ClientId = ModelConstants.NULL_UUID;
    actualMobileAppOauth2ClientCompositeKey.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualMobileAppOauth2ClientCompositeKey.toString();
    UUID actualMobileAppId = actualMobileAppOauth2ClientCompositeKey.getMobileAppId();
    UUID actualOauth2ClientId = actualMobileAppOauth2ClientCompositeKey.getOauth2ClientId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualMobileAppId.toString());
    assertEquals("MobileAppOauth2ClientCompositeKey(mobileAppId=13814000-1dd2-11b2-8080-808080808080, oauth2ClientId"
        + "=13814000-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertSame(oauth2ClientId, actualMobileAppId);
    assertSame(oauth2ClientId, actualOauth2ClientId);
  }
}
