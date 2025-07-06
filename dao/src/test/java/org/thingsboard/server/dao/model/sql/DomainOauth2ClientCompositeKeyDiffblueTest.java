package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class DomainOauth2ClientCompositeKeyDiffblueTest {
  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}, and {@link
   * DomainOauth2ClientCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link DomainOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey();
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey2 =
        new DomainOauth2ClientCompositeKey();

    // Act and Assert
    assertEquals(domainOauth2ClientCompositeKey, domainOauth2ClientCompositeKey2);
    int expectedHashCodeResult = domainOauth2ClientCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientCompositeKey2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}, and {@link
   * DomainOauth2ClientCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link DomainOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    UUID domainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey(
            domainId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID domainId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey2 =
        new DomainOauth2ClientCompositeKey(
            domainId2, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(domainOauth2ClientCompositeKey, domainOauth2ClientCompositeKey2);
    int expectedHashCodeResult = domainOauth2ClientCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientCompositeKey2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}, and {@link
   * DomainOauth2ClientCompositeKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#equals(Object)}
   *   <li>{@link DomainOauth2ClientCompositeKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey();

    // Act and Assert
    assertEquals(domainOauth2ClientCompositeKey, domainOauth2ClientCompositeKey);
    int expectedHashCodeResult = domainOauth2ClientCompositeKey.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientCompositeKey.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    UUID domainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey(
            domainId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(domainOauth2ClientCompositeKey, new DomainOauth2ClientCompositeKey());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey();
    UUID domainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act and Assert
    assertNotEquals(
        domainOauth2ClientCompositeKey,
        new DomainOauth2ClientCompositeKey(
            domainId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")));
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey();
    domainOauth2ClientCompositeKey.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(domainOauth2ClientCompositeKey, new DomainOauth2ClientCompositeKey());
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey();

    DomainOauth2ClientCompositeKey domainOauth2ClientCompositeKey2 =
        new DomainOauth2ClientCompositeKey();
    domainOauth2ClientCompositeKey2.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(domainOauth2ClientCompositeKey, domainOauth2ClientCompositeKey2);
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new DomainOauth2ClientCompositeKey(), null);
  }

  /**
   * Test {@link DomainOauth2ClientCompositeKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientCompositeKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientCompositeKey.equals(Object)",
    "int DomainOauth2ClientCompositeKey.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new DomainOauth2ClientCompositeKey(), "Different type to DomainOauth2ClientCompositeKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DomainOauth2ClientCompositeKey.<init>()",
    "void DomainOauth2ClientCompositeKey.<init>(UUID, UUID)",
    "UUID DomainOauth2ClientCompositeKey.getDomainId()",
    "UUID DomainOauth2ClientCompositeKey.getOauth2ClientId()",
    "void DomainOauth2ClientCompositeKey.setDomainId(UUID)",
    "void DomainOauth2ClientCompositeKey.setOauth2ClientId(UUID)",
    "String DomainOauth2ClientCompositeKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DomainOauth2ClientCompositeKey actualDomainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey();
    UUID domainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDomainOauth2ClientCompositeKey.setDomainId(domainId);
    UUID oauth2ClientId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDomainOauth2ClientCompositeKey.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualDomainOauth2ClientCompositeKey.toString();
    UUID actualDomainId = actualDomainOauth2ClientCompositeKey.getDomainId();
    UUID actualOauth2ClientId = actualDomainOauth2ClientCompositeKey.getOauth2ClientId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDomainId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualOauth2ClientId.toString());
    assertEquals(
        "DomainOauth2ClientCompositeKey(domainId=784f394c-42b6-435a-983c-b7beff2784f9, oauth2ClientId=784f394c"
            + "-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertSame(domainId, actualDomainId);
    assertSame(oauth2ClientId, actualOauth2ClientId);
  }

  /**
   * Test getters and setters.
   *
   * <ul>
   *   <li>When fromString {@code 784f394c-42b6-435a-983c-b7beff2784f9}.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientCompositeKey#DomainOauth2ClientCompositeKey(UUID, UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#setDomainId(UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#setOauth2ClientId(UUID)}
   *   <li>{@link DomainOauth2ClientCompositeKey#toString()}
   *   <li>{@link DomainOauth2ClientCompositeKey#getDomainId()}
   *   <li>{@link DomainOauth2ClientCompositeKey#getOauth2ClientId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DomainOauth2ClientCompositeKey.<init>()",
    "void DomainOauth2ClientCompositeKey.<init>(UUID, UUID)",
    "UUID DomainOauth2ClientCompositeKey.getDomainId()",
    "UUID DomainOauth2ClientCompositeKey.getOauth2ClientId()",
    "void DomainOauth2ClientCompositeKey.setDomainId(UUID)",
    "void DomainOauth2ClientCompositeKey.setOauth2ClientId(UUID)",
    "String DomainOauth2ClientCompositeKey.toString()"
  })
  public void testGettersAndSetters_whenFromString784f394c42b6435a983cB7beff2784f9() {
    // Arrange
    UUID domainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");

    // Act
    DomainOauth2ClientCompositeKey actualDomainOauth2ClientCompositeKey =
        new DomainOauth2ClientCompositeKey(
            domainId, UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    UUID domainId2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDomainOauth2ClientCompositeKey.setDomainId(domainId2);
    UUID oauth2ClientId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDomainOauth2ClientCompositeKey.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualDomainOauth2ClientCompositeKey.toString();
    UUID actualDomainId = actualDomainOauth2ClientCompositeKey.getDomainId();
    UUID actualOauth2ClientId = actualDomainOauth2ClientCompositeKey.getOauth2ClientId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDomainId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualOauth2ClientId.toString());
    assertEquals(
        "DomainOauth2ClientCompositeKey(domainId=784f394c-42b6-435a-983c-b7beff2784f9, oauth2ClientId=784f394c"
            + "-42b6-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertSame(domainId2, actualDomainId);
    assertSame(oauth2ClientId, actualOauth2ClientId);
  }
}
