package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.dao.model.ModelConstants;

public class DomainOauth2ClientCompositeKeyDiffblueTest {
  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}, and
   * {@link DomainOauth2ClientCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link DomainOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey = new DomainOauth2ClientCompositeKey();
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey2 = new DomainOauth2ClientCompositeKey();

    // Act and Assert
    assertEquals(domainOauth2ClientCompositeKey, domainOauth2ClientCompositeKey2);
    int expectedHashCodeResult = domainOauth2ClientCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientCompositeKey2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}, and
   * {@link DomainOauth2ClientCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link DomainOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey = new DomainOauth2ClientCompositeKey(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey2 = new DomainOauth2ClientCompositeKey(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(domainOauth2ClientCompositeKey, domainOauth2ClientCompositeKey2);
    int expectedHashCodeResult = domainOauth2ClientCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientCompositeKey2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}, and
   * {@link DomainOauth2ClientCompositeKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link DomainOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey = new DomainOauth2ClientCompositeKey();

    // Act and Assert
    assertEquals(domainOauth2ClientCompositeKey, domainOauth2ClientCompositeKey);
    int expectedHashCodeResult = domainOauth2ClientCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientCompositeKey.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey = new DomainOauth2ClientCompositeKey(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientCompositeKey, new DomainOauth2ClientCompositeKey());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey = new DomainOauth2ClientCompositeKey();

    // Act and Assert
    assertNotEquals(domainOauth2ClientCompositeKey,
        new DomainOauth2ClientCompositeKey(ModelConstants.NULL_UUID, ModelConstants.NULL_UUID));
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey = new DomainOauth2ClientCompositeKey();
    domainOauth2ClientCompositeKey.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientCompositeKey, new DomainOauth2ClientCompositeKey());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey = new DomainOauth2ClientCompositeKey();

    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey2 = new DomainOauth2ClientCompositeKey();
    domainOauth2ClientCompositeKey2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientCompositeKey, domainOauth2ClientCompositeKey2);
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainOauth2ClientCompositeKey(), null);
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainOauth2ClientCompositeKey(), "Different type to DomainOauth2ClientCompositeKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#DomainOauth2ClientCompositeKey()}
   *   <li>{@link DomainOauth2ClientCompositeKey#setDomainId(UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#setOauth2ClientId(UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#toString()}
   *   <li>{@link DomainOauth2ClientCompositeKey#getDomainId()}
   *   <li>{@link DomainOauth2ClientCompositeKey#getOauth2ClientId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DomainOauth2ClientCompositeKey actualDomainOauth2ClientCompositeKey = new DomainOauth2ClientCompositeKey();
    actualDomainOauth2ClientCompositeKey.setDomainId(ModelConstants.NULL_UUID);
    UUID oauth2ClientId = ModelConstants.NULL_UUID;
    actualDomainOauth2ClientCompositeKey.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualDomainOauth2ClientCompositeKey.toString();
    UUID actualDomainId = actualDomainOauth2ClientCompositeKey.getDomainId();
    UUID actualOauth2ClientId = actualDomainOauth2ClientCompositeKey.getOauth2ClientId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDomainId.toString());
    assertEquals("DomainOauth2ClientCompositeKey(domainId=13814000-1dd2-11b2-8080-808080808080, oauth2ClientId=13814000"
        + "-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertSame(oauth2ClientId, actualDomainId);
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
   * {@link DomainOauth2ClientCompositeKey#DomainOauth2ClientCompositeKey(UUID, UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#setDomainId(UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#setOauth2ClientId(UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#toString()}
   *   <li>{@link DomainOauth2ClientCompositeKey#getDomainId()}
   *   <li>{@link DomainOauth2ClientCompositeKey#getOauth2ClientId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters_whenNull_uuid() {
    // Arrange and Act
    DomainOauth2ClientCompositeKey actualDomainOauth2ClientCompositeKey = new DomainOauth2ClientCompositeKey(
        ModelConstants.NULL_UUID, ModelConstants.NULL_UUID);
    actualDomainOauth2ClientCompositeKey.setDomainId(ModelConstants.NULL_UUID);
    UUID oauth2ClientId = ModelConstants.NULL_UUID;
    actualDomainOauth2ClientCompositeKey.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualDomainOauth2ClientCompositeKey.toString();
    UUID actualDomainId = actualDomainOauth2ClientCompositeKey.getDomainId();
    UUID actualOauth2ClientId = actualDomainOauth2ClientCompositeKey.getOauth2ClientId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDomainId.toString());
    assertEquals("DomainOauth2ClientCompositeKey(domainId=13814000-1dd2-11b2-8080-808080808080, oauth2ClientId=13814000"
        + "-1dd2-11b2-8080-808080808080)", actualToStringResult);
    assertSame(oauth2ClientId, actualDomainId);
    assertSame(oauth2ClientId, actualOauth2ClientId);
  }
}
