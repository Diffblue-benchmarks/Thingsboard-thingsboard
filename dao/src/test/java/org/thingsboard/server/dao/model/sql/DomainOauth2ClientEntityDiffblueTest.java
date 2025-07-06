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
import org.thingsboard.server.common.data.domain.DomainOauth2Client;
import org.thingsboard.server.common.data.id.DomainId;
import org.thingsboard.server.common.data.id.OAuth2ClientId;
import org.thingsboard.server.dao.model.ModelConstants;

public class DomainOauth2ClientEntityDiffblueTest {
  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and {@link
   * DomainOauth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity2.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
    int expectedHashCodeResult = domainOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and {@link
   * DomainOauth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(null);
    domainOauth2ClientEntity.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(null);
    domainOauth2ClientEntity2.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
    int expectedHashCodeResult = domainOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and {@link
   * DomainOauth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity.setOauth2ClientId(null);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity2.setOauth2ClientId(null);

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
    int expectedHashCodeResult = domainOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientEntity2.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}, and {@link
   * DomainOauth2ClientEntity#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link DomainOauth2ClientEntity#equals(Object)}
   *   <li>{@link DomainOauth2ClientEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertEquals(domainOauth2ClientEntity, domainOauth2ClientEntity);
    int expectedHashCodeResult = domainOauth2ClientEntity.hashCode();
    assertEquals(expectedHashCodeResult, domainOauth2ClientEntity.hashCode());
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(ModelConstants.NULL_UUID);
    domainOauth2ClientEntity.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity2.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(null);
    domainOauth2ClientEntity.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity2.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity.setOauth2ClientId(ModelConstants.NULL_UUID);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity2.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity.setOauth2ClientId(null);

    DomainOauth2ClientEntity domainOauth2ClientEntity2 = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity2.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity2.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, domainOauth2ClientEntity2);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, null);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean DomainOauth2ClientEntity.equals(Object)",
    "int DomainOauth2ClientEntity.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    DomainOauth2ClientEntity domainOauth2ClientEntity = new DomainOauth2ClientEntity();
    domainOauth2ClientEntity.setDomainId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));
    domainOauth2ClientEntity.setOauth2ClientId(
        UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9"));

    // Act and Assert
    assertNotEquals(domainOauth2ClientEntity, "Different type to DomainOauth2ClientEntity");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
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
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void DomainOauth2ClientEntity.<init>()",
    "UUID DomainOauth2ClientEntity.getDomainId()",
    "UUID DomainOauth2ClientEntity.getOauth2ClientId()",
    "void DomainOauth2ClientEntity.setDomainId(UUID)",
    "void DomainOauth2ClientEntity.setOauth2ClientId(UUID)",
    "String DomainOauth2ClientEntity.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    DomainOauth2ClientEntity actualDomainOauth2ClientEntity = new DomainOauth2ClientEntity();
    UUID domainId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDomainOauth2ClientEntity.setDomainId(domainId);
    UUID oauth2ClientId = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    actualDomainOauth2ClientEntity.setOauth2ClientId(oauth2ClientId);
    String actualToStringResult = actualDomainOauth2ClientEntity.toString();
    UUID actualDomainId = actualDomainOauth2ClientEntity.getDomainId();
    UUID actualOauth2ClientId = actualDomainOauth2ClientEntity.getOauth2ClientId();

    // Assert
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualDomainId.toString());
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", actualOauth2ClientId.toString());
    assertEquals(
        "DomainOauth2ClientEntity(domainId=784f394c-42b6-435a-983c-b7beff2784f9, oauth2ClientId=784f394c-42b6"
            + "-435a-983c-b7beff2784f9)",
        actualToStringResult);
    assertSame(domainId, actualDomainId);
    assertSame(oauth2ClientId, actualOauth2ClientId);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#DomainOauth2ClientEntity(DomainOauth2Client)}.
   *
   * <p>Method under test: {@link
   * DomainOauth2ClientEntity#DomainOauth2ClientEntity(DomainOauth2Client)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void DomainOauth2ClientEntity.<init>(DomainOauth2Client)"})
  public void testNewDomainOauth2ClientEntity() {
    // Arrange
    DomainOauth2Client domainOauth2Client = new DomainOauth2Client();
    UUID id = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    domainOauth2Client.setOAuth2ClientId(new OAuth2ClientId(id));
    UUID id2 = UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9");
    domainOauth2Client.setDomainId(new DomainId(id2));

    // Act
    DomainOauth2ClientEntity actualDomainOauth2ClientEntity =
        new DomainOauth2ClientEntity(domainOauth2Client);

    // Assert
    UUID domainId = actualDomainOauth2ClientEntity.getDomainId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", domainId.toString());
    UUID oauth2ClientId = actualDomainOauth2ClientEntity.getOauth2ClientId();
    assertEquals("784f394c-42b6-435a-983c-b7beff2784f9", oauth2ClientId.toString());
    assertSame(id2, domainId);
    assertSame(id, oauth2ClientId);
  }

  /**
   * Test {@link DomainOauth2ClientEntity#toData()}.
   *
   * <p>Method under test: {@link DomainOauth2ClientEntity#toData()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"DomainOauth2Client DomainOauth2ClientEntity.toData()"})
  public void testToData() {
    // Arrange and Act
    DomainOauth2Client actualToDataResult = new DomainOauth2ClientEntity().toData();

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
