package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.id.MobileAppId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.common.data.mobile.MobileAppOauth2Client;
import org.thingsboard.server.dao.model.ModelConstants;

public class MobileAppOauth2ClientEntityDiffblueTest {
  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and {@link MobileAppOauth2ClientEntity#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientEntity.equals(Object)",
      "int MobileAppOauth2ClientEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity2.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
    int expectedHashCodeResult = mobileAppOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and {@link MobileAppOauth2ClientEntity#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientEntity.equals(Object)",
      "int MobileAppOauth2ClientEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(null);
    mobileAppOauth2ClientEntity.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(null);
    mobileAppOauth2ClientEntity2.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
    int expectedHashCodeResult = mobileAppOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and {@link MobileAppOauth2ClientEntity#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientEntity.equals(Object)",
      "int MobileAppOauth2ClientEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity.setOauth2ClientId(null);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity2.setOauth2ClientId(null);

    // Act and Assert
    assertEquals(mobileAppOauth2ClientEntity, mobileAppOauth2ClientEntity2);
    int expectedHashCodeResult = mobileAppOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#equals(Object)}, and {@link MobileAppOauth2ClientEntity#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientEntity.equals(Object)",
      "int MobileAppOauth2ClientEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientEntity.equals(Object)",
      "int MobileAppOauth2ClientEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(ModelConstants.NULL_UUID);
    mobileAppOauth2ClientEntity.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity2.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientEntity.equals(Object)",
      "int MobileAppOauth2ClientEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(null);
    mobileAppOauth2ClientEntity.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity2.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientEntity.equals(Object)",
      "int MobileAppOauth2ClientEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity2.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientEntity.equals(Object)",
      "int MobileAppOauth2ClientEntity.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity.setOauth2ClientId(null);

    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity2 = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity2.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity2.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientEntity.equals(Object)",
      "int MobileAppOauth2ClientEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientEntity.equals(Object)",
      "int MobileAppOauth2ClientEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    MobileAppOauth2ClientEntity mobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    mobileAppOauth2ClientEntity.setMobileAppId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    mobileAppOauth2ClientEntity.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppOauth2ClientEntity.<init>()", "UUID MobileAppOauth2ClientEntity.getMobileAppId()",
      "UUID MobileAppOauth2ClientEntity.getOauth2ClientId()", "void MobileAppOauth2ClientEntity.setMobileAppId(UUID)",
      "void MobileAppOauth2ClientEntity.setOauth2ClientId(UUID)", "String MobileAppOauth2ClientEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    MobileAppOauth2ClientEntity actualMobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity();
    UUID mobileAppId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualMobileAppOauth2ClientEntity.setMobileAppId(mobileAppId);
    UUID oauth2ClientId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualMobileAppOauth2ClientEntity.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualMobileAppOauth2ClientEntity.toString();
    UUID actualMobileAppId = actualMobileAppOauth2ClientEntity.getMobileAppId();
    UUID actualOauth2ClientId = actualMobileAppOauth2ClientEntity.getOauth2ClientId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualMobileAppId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualOauth2ClientId.toString());
    assertEquals("MobileAppOauth2ClientEntity(mobileAppId=784f394c-42b6-435a-983c-b7beff2784f9, oauth2ClientId=784f394c"
        + "-42b6-435a-983c-b7beff2784f9)", actualToStringResult);
    assertSame(mobileAppId, actualMobileAppId);
    assertSame(oauth2ClientId, actualOauth2ClientId);
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#MobileAppOauth2ClientEntity(MobileAppOauth2Client)}.
   * <p>
   * Method under test: {@link MobileAppOauth2ClientEntity#MobileAppOauth2ClientEntity(MobileAppOauth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppOauth2ClientEntity.<init>(MobileAppOauth2Client)"})
  public void testNewMobileAppOauth2ClientEntity() {
    // Arrange
    MobileAppOauth2Client domainOauth2Provider = new MobileAppOauth2Client();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    domainOauth2Provider.setOAuth2ClientId(new OAuth2ClientId(id));
    UUID id2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    domainOauth2Provider.setMobileAppId(new MobileAppId(id2));

    // Act
    MobileAppOauth2ClientEntity actualMobileAppOauth2ClientEntity = new MobileAppOauth2ClientEntity(
        domainOauth2Provider);

    // Assert
    UUID mobileAppId = actualMobileAppOauth2ClientEntity.getMobileAppId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", mobileAppId.toString());
    UUID oauth2ClientId = actualMobileAppOauth2ClientEntity.getOauth2ClientId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", oauth2ClientId.toString());
    assertSame(id2, mobileAppId);
    assertSame(id, oauth2ClientId);
  }

  /**
   * Test {@link MobileAppOauth2ClientEntity#toData()}.
   * <p>
   * Method under test: {@link MobileAppOauth2ClientEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"MobileAppOauth2Client MobileAppOauth2ClientEntity.toData()"})
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
