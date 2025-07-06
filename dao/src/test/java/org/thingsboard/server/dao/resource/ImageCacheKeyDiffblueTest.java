package org.thingsboard.server.dao.resource;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class ImageCacheKeyDiffblueTest {
  /**
   * Test {@link ImageCacheKey#forImage(TenantId, String)} with {@code tenantId}, {@code key}.
   *
   * <p>Method under test: {@link ImageCacheKey#forImage(TenantId, String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ImageCacheKey ImageCacheKey.forImage(TenantId, String)"})
  public void testForImageWithTenantIdKey() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    ImageCacheKey actualForImageResult = ImageCacheKey.forImage(tenantId, "Key");

    // Assert
    assertEquals("Key", actualForImageResult.getResourceKey());
    assertNull(actualForImageResult.getPublicResourceKey());
    assertFalse(actualForImageResult.isPreview());
    assertFalse(actualForImageResult.isPublic());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualForImageResult.getTenantId());
  }

  /**
   * Test {@link ImageCacheKey#forImage(TenantId, String, boolean)} with {@code tenantId}, {@code
   * key}, {@code preview}.
   *
   * <p>Method under test: {@link ImageCacheKey#forImage(TenantId, String, boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ImageCacheKey ImageCacheKey.forImage(TenantId, String, boolean)"})
  public void testForImageWithTenantIdKeyPreview() {
    // Arrange
    TenantId tenantId = ModelConstants.SYSTEM_TENANT;

    // Act
    ImageCacheKey actualForImageResult = ImageCacheKey.forImage(tenantId, "Key", true);

    // Assert
    assertEquals("Key", actualForImageResult.getResourceKey());
    assertNull(actualForImageResult.getPublicResourceKey());
    assertFalse(actualForImageResult.isPublic());
    assertTrue(actualForImageResult.isPreview());
    TenantId expectedTenantId = tenantId.SYS_TENANT_ID;
    assertSame(expectedTenantId, actualForImageResult.getTenantId());
  }

  /**
   * Test {@link ImageCacheKey#forPublicImage(String)}.
   *
   * <p>Method under test: {@link ImageCacheKey#forPublicImage(String)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ImageCacheKey ImageCacheKey.forPublicImage(String)"})
  public void testForPublicImage() {
    // Arrange and Act
    ImageCacheKey actualForPublicImageResult = ImageCacheKey.forPublicImage("Public Key");

    // Assert
    assertEquals("Public Key", actualForPublicImageResult.getPublicResourceKey());
    assertNull(actualForPublicImageResult.getResourceKey());
    assertNull(actualForPublicImageResult.getTenantId());
    assertFalse(actualForPublicImageResult.isPreview());
    assertTrue(actualForPublicImageResult.isPublic());
  }

  /**
   * Test {@link ImageCacheKey#isPublic()}.
   *
   * <ul>
   *   <li>Given forPublicImage {@code null}.
   *   <li>Then return {@code false}.
   * </ul>
   *
   * <p>Method under test: {@link ImageCacheKey#isPublic()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.isPublic()"})
  public void testIsPublic_givenForPublicImageNull_thenReturnFalse() {
    // Arrange, Act and Assert
    assertFalse(ImageCacheKey.forPublicImage(null).isPublic());
  }

  /**
   * Test {@link ImageCacheKey#isPublic()}.
   *
   * <ul>
   *   <li>Given forPublicImage {@code Public Key}.
   *   <li>Then return {@code true}.
   * </ul>
   *
   * <p>Method under test: {@link ImageCacheKey#isPublic()}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.isPublic()"})
  public void testIsPublic_givenForPublicImagePublicKey_thenReturnTrue() {
    // Arrange, Act and Assert
    assertTrue(ImageCacheKey.forPublicImage("Public Key").isPublic());
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}, and {@link ImageCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageCacheKey#equals(Object)}
   *   <li>{@link ImageCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ImageCacheKey forPublicImageResult = ImageCacheKey.forPublicImage("Public Key");
    ImageCacheKey forPublicImageResult2 = ImageCacheKey.forPublicImage("Public Key");

    // Act and Assert
    assertEquals(forPublicImageResult, forPublicImageResult2);
    int expectedHashCodeResult = forPublicImageResult.hashCode();
    assertEquals(expectedHashCodeResult, forPublicImageResult2.hashCode());
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}, and {@link ImageCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageCacheKey#equals(Object)}
   *   <li>{@link ImageCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ImageCacheKey forPublicImageResult = ImageCacheKey.forPublicImage(null);
    ImageCacheKey forPublicImageResult2 = ImageCacheKey.forPublicImage(null);

    // Act and Assert
    assertEquals(forPublicImageResult, forPublicImageResult2);
    int expectedHashCodeResult = forPublicImageResult.hashCode();
    assertEquals(expectedHashCodeResult, forPublicImageResult2.hashCode());
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}, and {@link ImageCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageCacheKey#equals(Object)}
   *   <li>{@link ImageCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    ImageCacheKey forImageResult =
        ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Public Key", true);
    ImageCacheKey forImageResult2 =
        ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Public Key", true);

    // Act and Assert
    assertEquals(forImageResult, forImageResult2);
    int expectedHashCodeResult = forImageResult.hashCode();
    assertEquals(expectedHashCodeResult, forImageResult2.hashCode());
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}, and {@link ImageCacheKey#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageCacheKey#equals(Object)}
   *   <li>{@link ImageCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ImageCacheKey forPublicImageResult = ImageCacheKey.forPublicImage("Public Key");

    // Act and Assert
    assertEquals(forPublicImageResult, forPublicImageResult);
    int expectedHashCodeResult = forPublicImageResult.hashCode();
    assertEquals(expectedHashCodeResult, forPublicImageResult.hashCode());
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ImageCacheKey forPublicImageResult = ImageCacheKey.forPublicImage(null);

    // Act and Assert
    assertNotEquals(forPublicImageResult, ImageCacheKey.forPublicImage("Public Key"));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ImageCacheKey forPublicImageResult =
        ImageCacheKey.forPublicImage("org.thingsboard.server.dao.resource.ImageCacheKey");

    // Act and Assert
    assertNotEquals(forPublicImageResult, ImageCacheKey.forPublicImage("Public Key"));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ImageCacheKey forImageResult =
        ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Public Key", true);

    // Act and Assert
    assertNotEquals(forImageResult, ImageCacheKey.forPublicImage("Public Key"));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ImageCacheKey forImageResult =
        ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Public Key", false);

    // Act and Assert
    assertNotEquals(forImageResult, ImageCacheKey.forPublicImage("Public Key"));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ImageCacheKey forImageResult = ImageCacheKey.forImage(null, "Public Key", false);

    // Act and Assert
    assertNotEquals(forImageResult, ImageCacheKey.forPublicImage("Public Key"));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ImageCacheKey forImageResult = ImageCacheKey.forImage(null, "Public Key", true);

    // Act and Assert
    assertNotEquals(
        forImageResult, ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Public Key", true));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    ImageCacheKey forImageResult = ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, null, true);

    // Act and Assert
    assertNotEquals(
        forImageResult, ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Public Key", true));
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImageCacheKey.forPublicImage("Public Key"), null);
  }

  /**
   * Test {@link ImageCacheKey#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ImageCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean ImageCacheKey.equals(Object)", "int ImageCacheKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(ImageCacheKey.forPublicImage("Public Key"), "Different type to ImageCacheKey");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ImageCacheKey#toString()}
   *   <li>{@link ImageCacheKey#getPublicResourceKey()}
   *   <li>{@link ImageCacheKey#getResourceKey()}
   *   <li>{@link ImageCacheKey#getTenantId()}
   *   <li>{@link ImageCacheKey#isPreview()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "String ImageCacheKey.getPublicResourceKey()",
    "String ImageCacheKey.getResourceKey()",
    "TenantId ImageCacheKey.getTenantId()",
    "boolean ImageCacheKey.isPreview()",
    "String ImageCacheKey.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange
    ImageCacheKey forPublicImageResult = ImageCacheKey.forPublicImage("Public Key");

    // Act
    String actualToStringResult = forPublicImageResult.toString();
    String actualPublicResourceKey = forPublicImageResult.getPublicResourceKey();
    String actualResourceKey = forPublicImageResult.getResourceKey();
    TenantId actualTenantId = forPublicImageResult.getTenantId();

    // Assert
    assertEquals(
        "ImageCacheKey(tenantId=null, resourceKey=null, preview=false, publicResourceKey=Public Key)",
        actualToStringResult);
    assertEquals("Public Key", actualPublicResourceKey);
    assertNull(actualResourceKey);
    assertNull(actualTenantId);
    assertFalse(forPublicImageResult.isPreview());
  }

  /**
   * Test {@link ImageCacheKey#withPreview(boolean)}.
   *
   * <p>Method under test: {@link ImageCacheKey#withPreview(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ImageCacheKey ImageCacheKey.withPreview(boolean)"})
  public void testWithPreview() {
    // Arrange
    ImageCacheKey forImageResult =
        ImageCacheKey.forImage(ModelConstants.SYSTEM_TENANT, "Key", true);

    // Act and Assert
    assertSame(forImageResult, forImageResult.withPreview(true));
  }

  /**
   * Test {@link ImageCacheKey#withPreview(boolean)}.
   *
   * <ul>
   *   <li>Then return PublicResourceKey is {@code Public Key}.
   * </ul>
   *
   * <p>Method under test: {@link ImageCacheKey#withPreview(boolean)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"ImageCacheKey ImageCacheKey.withPreview(boolean)"})
  public void testWithPreview_thenReturnPublicResourceKeyIsPublicKey() {
    // Arrange and Act
    ImageCacheKey actualWithPreviewResult =
        ImageCacheKey.forPublicImage("Public Key").withPreview(true);

    // Assert
    assertEquals("Public Key", actualWithPreviewResult.getPublicResourceKey());
    assertNull(actualWithPreviewResult.getResourceKey());
    assertNull(actualWithPreviewResult.getTenantId());
    assertTrue(actualWithPreviewResult.isPublic());
  }
}
