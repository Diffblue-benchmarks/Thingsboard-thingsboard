package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class MobileAppOauth2ClientCompositeKeyDiffblueTest {
  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}, and {@link MobileAppOauth2ClientCompositeKey#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
      "int MobileAppOauth2ClientCompositeKey.hashCode()"})
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
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}, and {@link MobileAppOauth2ClientCompositeKey#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
      "int MobileAppOauth2ClientCompositeKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UUID mobileAppId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey(
        mobileAppId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID mobileAppId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey2 = new MobileAppOauth2ClientCompositeKey(
        mobileAppId2, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(mobileAppOauth2ClientCompositeKey, mobileAppOauth2ClientCompositeKey2);
    int expectedHashCodeResult = mobileAppOauth2ClientCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, mobileAppOauth2ClientCompositeKey2.hashCode());
  }

  /**
   * Test {@link MobileAppOauth2ClientCompositeKey#equals(Object)}, and {@link MobileAppOauth2ClientCompositeKey#hashCode()}.
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
      "int MobileAppOauth2ClientCompositeKey.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
      "int MobileAppOauth2ClientCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID mobileAppId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey(
        mobileAppId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
      "int MobileAppOauth2ClientCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey();
    UUID mobileAppId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(mobileAppOauth2ClientCompositeKey,
        new MobileAppOauth2ClientCompositeKey(mobileAppId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
      "int MobileAppOauth2ClientCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey();
    mobileAppOauth2ClientCompositeKey.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
      "int MobileAppOauth2ClientCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey();

    MobileAppOauth2ClientCompositeKey mobileAppOauth2ClientCompositeKey2 = new MobileAppOauth2ClientCompositeKey();
    mobileAppOauth2ClientCompositeKey2.setOauth2ClientId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
      "int MobileAppOauth2ClientCompositeKey.hashCode()"})
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean MobileAppOauth2ClientCompositeKey.equals(Object)",
      "int MobileAppOauth2ClientCompositeKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new MobileAppOauth2ClientCompositeKey(), "Different type to MobileAppOauth2ClientCompositeKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2ClientCompositeKey#MobileAppOauth2ClientCompositeKey()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#setMobileAppId(UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#setOauth2ClientId(UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#toString()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#getMobileAppId()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#getOauth2ClientId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppOauth2ClientCompositeKey.<init>()",
      "void MobileAppOauth2ClientCompositeKey.<init>(UUID, UUID)",
      "UUID MobileAppOauth2ClientCompositeKey.getMobileAppId()",
      "UUID MobileAppOauth2ClientCompositeKey.getOauth2ClientId()",
      "void MobileAppOauth2ClientCompositeKey.setMobileAppId(UUID)",
      "void MobileAppOauth2ClientCompositeKey.setOauth2ClientId(UUID)",
      "String MobileAppOauth2ClientCompositeKey.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    MobileAppOauth2ClientCompositeKey actualMobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey();
    UUID mobileAppId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualMobileAppOauth2ClientCompositeKey.setMobileAppId(mobileAppId);
    UUID oauth2ClientId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualMobileAppOauth2ClientCompositeKey.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualMobileAppOauth2ClientCompositeKey.toString();
    UUID actualMobileAppId = actualMobileAppOauth2ClientCompositeKey.getMobileAppId();
    UUID actualOauth2ClientId = actualMobileAppOauth2ClientCompositeKey.getOauth2ClientId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualMobileAppId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualOauth2ClientId.toString());
    assertEquals("MobileAppOauth2ClientCompositeKey(mobileAppId=784f394c-42b6-435a-983c-b7beff2784f9, oauth2ClientId"
        + "=784f394c-42b6-435a-983c-b7beff2784f9)", actualToStringResult);
    assertSame(mobileAppId, actualMobileAppId);
    assertSame(oauth2ClientId, actualOauth2ClientId);
  }

  /**
   * Test getters and setters.
   * <ul>
   *   <li>When fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link MobileAppOauth2ClientCompositeKey#MobileAppOauth2ClientCompositeKey(UUID, UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#setMobileAppId(UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#setOauth2ClientId(UUID)}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#toString()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#getMobileAppId()}
   *   <li>{@link MobileAppOauth2ClientCompositeKey#getOauth2ClientId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void MobileAppOauth2ClientCompositeKey.<init>()",
      "void MobileAppOauth2ClientCompositeKey.<init>(UUID, UUID)",
      "UUID MobileAppOauth2ClientCompositeKey.getMobileAppId()",
      "UUID MobileAppOauth2ClientCompositeKey.getOauth2ClientId()",
      "void MobileAppOauth2ClientCompositeKey.setMobileAppId(UUID)",
      "void MobileAppOauth2ClientCompositeKey.setOauth2ClientId(UUID)",
      "String MobileAppOauth2ClientCompositeKey.toString()"})
  public void testGettersAndSetters_whenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UUID mobileAppId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    MobileAppOauth2ClientCompositeKey actualMobileAppOauth2ClientCompositeKey = new MobileAppOauth2ClientCompositeKey(
        mobileAppId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID mobileAppId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualMobileAppOauth2ClientCompositeKey.setMobileAppId(mobileAppId2);
    UUID oauth2ClientId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualMobileAppOauth2ClientCompositeKey.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualMobileAppOauth2ClientCompositeKey.toString();
    UUID actualMobileAppId = actualMobileAppOauth2ClientCompositeKey.getMobileAppId();
    UUID actualOauth2ClientId = actualMobileAppOauth2ClientCompositeKey.getOauth2ClientId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualMobileAppId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualOauth2ClientId.toString());
    assertEquals("MobileAppOauth2ClientCompositeKey(mobileAppId=784f394c-42b6-435a-983c-b7beff2784f9, oauth2ClientId"
        + "=784f394c-42b6-435a-983c-b7beff2784f9)", actualToStringResult);
    assertSame(mobileAppId2, actualMobileAppId);
    assertSame(oauth2ClientId, actualOauth2ClientId);
  }
}
