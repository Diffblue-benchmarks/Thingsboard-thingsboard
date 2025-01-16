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
import org.thingsboard.server.common.data.domain.DomainOauth2Client;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.dao.model.ModelConstants;

public class DomainOauth2ClientEntityDiffblueTest {
  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and
   * {@link DomainOauth2ClientEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
    int expectedHashCodeResult = domainOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and
   * {@link DomainOauth2ClientEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(null);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(null);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
    int expectedHashCodeResult = domainOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and
   * {@link DomainOauth2ClientEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(null);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(null);

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
    int expectedHashCodeResult = domainOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and
   * {@link DomainOauth2ClientEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    DomainOauth2Client domainOauth2Client = mock(DomainOauth2Client.class);
    when(domainOauth2Client.getOAuth2ClientId()).thenReturn(new OAuth2ClientId(ModelConstants.NULL_UUID));
    when(domainOauth2Client.getDomainId()).thenReturn(new DomainId(ModelConstants.NULL_UUID));

    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity(domainOauth2Client);
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
    int expectedHashCodeResult = domainOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and
   * {@link DomainOauth2ClientEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity);
    int expectedHashCodeResult = domainOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientEntity.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(UUID.randomUUID());
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(null);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(UUID.randomUUID());

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(null);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity2.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, null);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, "Different type to DomainOauth2ClientEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#DomainOauth2ClientEntity()}
   *   <li>{@link DomainOauth2ClientEntity#setDomainId(UUID)}
   *   <li>{@link DomainOauth2ClientEntity#setOauth2ClientId(UUID)}
   *   <li>{@link DomainOauth2ClientEntity#toString()}
   *   <li>{@link DomainOauth2ClientEntity#getDomainId()}
   *   <li>{@link DomainOauth2ClientEntity#getOauth2ClientId()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    DomainOauth2ClientEntity actualDomainOauth2ClientEntity = new DomainOauth2ClientEntity();
    actualDomainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    UUID oauth2ClientId = ModelConstants.NULL_UUID;
    actualDomainOauth2ClientEntity.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualDomainOauth2ClientEntity.toString();
    UUID actualDomainId = actualDomainOauth2ClientEntity.getDomainId();
    UUID actualOauth2ClientId = actualDomainOauth2ClientEntity.getOauth2ClientId();

    // Assert that nothing has changed
    assertEquals("13814000-1dd2-11b2-8080-808080808080", actualDomainId.toString());
    assertEquals("DomainOauth2ClientEntity(domainId=13814000-1dd2-11b2-8080-808080808080, oauth2ClientId=13814000-1dd2"
        + "-11b2-8080-808080808080)", actualToStringResult);
    assertSame(oauth2ClientId, actualDomainId);
    assertSame(oauth2ClientId, actualOauth2ClientId);
  }

  /**
   * Test
   * {@link DomainOauth2ClientEntity#DomainOauth2ClientEntity(DomainOauth2Client)}.
   * <p>
   * Method under test:
   * {@link DomainOauth2ClientEntity#DomainOauth2ClientEntity(DomainOauth2Client)}
   */
  @Test
  public void testNewDomainOauth2ClientEntity() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    domainOauth2Client.setOAuth2ClientId(new OAuth2ClientId(ModelConstants.NULL_UUID));
    domainOauth2Client.setDomainId(new DomainId(ModelConstants.NULL_UUID));

    // Act
    DomainOauth2ClientEntity actualDomainOauth2ClientEntity = new DomainOauth2ClientEntity(domainOauth2Client);

    // Assert
    UUID domainId = actualDomainOauth2ClientEntity.getDomainId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", domainId.toString());
    assertSame(domainId, actualDomainOauth2ClientEntity.getOauth2ClientId());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#toData()}.
   * <p>
   * Method under test: {@link DomainOauth2ClientEntity#toData()}
   */
  @Test
  public void testToData() {
    // Arrange and Act
    DomainOauth2Client actualToDataResult = (new DomainOauth2ClientEntity()).toData();

    // Assert
    DomainId domainId = actualToDataResult.getDomainId();
    assertNull(domainId.getId());
    OAuth2ClientId oAuth2ClientId = actualToDataResult.getOAuth2ClientId();
    assertNull(oAuth2ClientId.getId());
    assertEquals(EntityType.DOMAIN, domainId.getEntityType());
    assertEquals(EntityType.OAUTH2_CLIENT, oAuth2ClientId.getEntityType());
    assertFalse(domainId.isNullUid());
    assertFalse(oAuth2ClientId.isNullUid());
  }
}
