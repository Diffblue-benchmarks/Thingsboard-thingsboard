package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import java.util.UUID;
import org.junit.Test;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.oauth2.OAuth2ClientInfo;
import org.thingsboard.server.dao.model.ModelConstants;

public class OAuth2ClientInfoEntityDiffblueTest {
  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}, and
   * {@link OAuth2ClientInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientInfoEntity#equals(Object)}
   *   <li>{@link OAuth2ClientInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
    int expectedHashCodeResult = oAuth2ClientInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientInfoEntity2.hashCode());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}, and
   * {@link OAuth2ClientInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientInfoEntity#equals(Object)}
   *   <li>{@link OAuth2ClientInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity);
    int expectedHashCodeResult = oAuth2ClientInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, oAuth2ClientInfoEntity.hashCode());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(3L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Dr");
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms(null);
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle("Mr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle(null);
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    OAuth2ClientInfoEntity oAuth2ClientInfoEntity2 = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity2.setCreatedTime(1L);
    oAuth2ClientInfoEntity2.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity2.setPlatforms("Platforms");
    oAuth2ClientInfoEntity2.setTitle("Dr");
    oAuth2ClientInfoEntity2.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, oAuth2ClientInfoEntity2);
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, null);
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientInfoEntity#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("Platforms");
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);

    // Act and Assert
    assertNotEquals(oAuth2ClientInfoEntity, "Different type to OAuth2ClientInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link OAuth2ClientInfoEntity#OAuth2ClientInfoEntity()}
   *   <li>{@link OAuth2ClientInfoEntity#setPlatforms(String)}
   *   <li>{@link OAuth2ClientInfoEntity#setTitle(String)}
   *   <li>{@link OAuth2ClientInfoEntity#toString()}
   *   <li>{@link OAuth2ClientInfoEntity#getPlatforms()}
   *   <li>{@link OAuth2ClientInfoEntity#getTitle()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
    // Arrange and Act
    OAuth2ClientInfoEntity actualOAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    actualOAuth2ClientInfoEntity.setPlatforms("Platforms");
    actualOAuth2ClientInfoEntity.setTitle("Dr");
    String actualToStringResult = actualOAuth2ClientInfoEntity.toString();
    String actualPlatforms = actualOAuth2ClientInfoEntity.getPlatforms();

    // Assert that nothing has changed
    assertEquals("Dr", actualOAuth2ClientInfoEntity.getTitle());
    assertEquals("OAuth2ClientInfoEntity(platforms=Platforms, title=Dr)", actualToStringResult);
    assertEquals("Platforms", actualPlatforms);
    assertEquals(0L, actualOAuth2ClientInfoEntity.getCreatedTime());
  }

  /**
   * Test
   * {@link OAuth2ClientInfoEntity#OAuth2ClientInfoEntity(UUID, long, String, String)}.
   * <p>
   * Method under test:
   * {@link OAuth2ClientInfoEntity#OAuth2ClientInfoEntity(UUID, long, String, String)}
   */
  @Test
  public void testNewOAuth2ClientInfoEntity() {
    // Arrange
    UUID id = ModelConstants.NULL_UUID;

    // Act
    OAuth2ClientInfoEntity actualOAuth2ClientInfoEntity = new OAuth2ClientInfoEntity(id, 1L, "Platforms", "Dr");

    // Assert
    assertEquals("Dr", actualOAuth2ClientInfoEntity.getTitle());
    assertEquals("Platforms", actualOAuth2ClientInfoEntity.getPlatforms());
    assertEquals(1L, actualOAuth2ClientInfoEntity.getCreatedTime());
    assertSame(id, actualOAuth2ClientInfoEntity.getId());
    assertSame(id, actualOAuth2ClientInfoEntity.getUuid());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link OAuth2ClientInfoEntity#OAuth2ClientInfoEntity()} Platforms
   * is {@code ,}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientInfoEntity#toData()}
   */
  @Test
  public void testToData_givenOAuth2ClientInfoEntityPlatformsIsComma() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms(",");

    // Act
    OAuth2ClientInfo actualToDataResult = oAuth2ClientInfoEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    OAuth2ClientId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link OAuth2ClientInfoEntity#OAuth2ClientInfoEntity()} Platforms
   * is empty string.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientInfoEntity#toData()}
   */
  @Test
  public void testToData_givenOAuth2ClientInfoEntityPlatformsIsEmptyString() {
    // Arrange
    OAuth2ClientInfoEntity oAuth2ClientInfoEntity = new OAuth2ClientInfoEntity();
    oAuth2ClientInfoEntity.setCreatedTime(1L);
    oAuth2ClientInfoEntity.setId(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setTitle("Dr");
    oAuth2ClientInfoEntity.setUuid(ModelConstants.NULL_UUID);
    oAuth2ClientInfoEntity.setPlatforms("");

    // Act
    OAuth2ClientInfo actualToDataResult = oAuth2ClientInfoEntity.toData();

    // Assert
    UUID uuidId = actualToDataResult.getUuidId();
    assertEquals("13814000-1dd2-11b2-8080-808080808080", uuidId.toString());
    assertEquals("Dr", actualToDataResult.getName());
    assertEquals("Dr", actualToDataResult.getTitle());
    assertEquals(1L, actualToDataResult.getCreatedTime());
    OAuth2ClientId id = actualToDataResult.getId();
    assertTrue(id.isNullUid());
    assertSame(uuidId, id.getId());
  }

  /**
   * Test {@link OAuth2ClientInfoEntity#toData()}.
   * <ul>
   *   <li>Given {@link OAuth2ClientInfoEntity#OAuth2ClientInfoEntity()}.</li>
   *   <li>Then return Name is {@code null}.</li>
   * </ul>
   * <p>
   * Method under test: {@link OAuth2ClientInfoEntity#toData()}
   */
  @Test
  public void testToData_givenOAuth2ClientInfoEntity_thenReturnNameIsNull() {
    // Arrange and Act
    OAuth2ClientInfo actualToDataResult = (new OAuth2ClientInfoEntity()).toData();

    // Assert
    assertNull(actualToDataResult.getName());
    assertNull(actualToDataResult.getTitle());
    assertNull(actualToDataResult.getUuidId());
    OAuth2ClientId id = actualToDataResult.getId();
    assertNull(id.getId());
    assertEquals(0L, actualToDataResult.getCreatedTime());
    assertFalse(id.isNullUid());
  }
}
