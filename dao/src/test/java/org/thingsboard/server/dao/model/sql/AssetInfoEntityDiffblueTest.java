package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class AssetInfoEntityDiffblueTest {
  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and {@link AssetInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();
    AssetInfoEntity assetInfoEntity2 = new AssetInfoEntity();

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity2);
    int expectedHashCodeResult = assetInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetInfoEntity2.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}, and {@link AssetInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetInfoEntity#equals(Object)}
   *   <li>{@link AssetInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetInfoEntity assetInfoEntity = new AssetInfoEntity();

    // Act and Assert
    assertEquals(assetInfoEntity, assetInfoEntity);
    int expectedHashCodeResult = assetInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, assetInfoEntity.hashCode());
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetInfoEntity(), null);
  }

  /**
   * Test {@link AssetInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link AssetInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean AssetInfoEntity.equals(Object)", "int AssetInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new AssetInfoEntity(), "Different type to AssetInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link AssetInfoEntity#AssetInfoEntity()}
   *   <li>{@link AssetInfoEntity#setAssetProfileName(String)}
   *   <li>{@link AssetInfoEntity#setCustomerIsPublic(boolean)}
   *   <li>{@link AssetInfoEntity#setCustomerTitle(String)}
   *   <li>{@link AssetInfoEntity#toString()}
   *   <li>{@link AssetInfoEntity#getAssetProfileName()}
   *   <li>{@link AssetInfoEntity#getCustomerTitle()}
   *   <li>{@link AssetInfoEntity#isCustomerIsPublic()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void AssetInfoEntity.<init>()", "String AssetInfoEntity.getAssetProfileName()",
      "String AssetInfoEntity.getCustomerTitle()", "boolean AssetInfoEntity.isCustomerIsPublic()",
      "void AssetInfoEntity.setAssetProfileName(String)", "void AssetInfoEntity.setCustomerIsPublic(boolean)",
      "void AssetInfoEntity.setCustomerTitle(String)", "String AssetInfoEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    AssetInfoEntity actualAssetInfoEntity = new AssetInfoEntity();
    actualAssetInfoEntity.setAssetProfileName("foo.txt");
    actualAssetInfoEntity.setCustomerIsPublic(true);
    actualAssetInfoEntity.setCustomerTitle("Dr");
    String actualToStringResult = actualAssetInfoEntity.toString();
    String actualAssetProfileName = actualAssetInfoEntity.getAssetProfileName();
    String actualCustomerTitle = actualAssetInfoEntity.getCustomerTitle();
    boolean actualIsCustomerIsPublicResult = actualAssetInfoEntity.isCustomerIsPublic();

    // Assert
    assertEquals("AssetInfoEntity(customerTitle=Dr, customerIsPublic=true, assetProfileName=foo.txt)",
        actualToStringResult);
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("foo.txt", actualAssetProfileName);
    assertNull(actualAssetInfoEntity.getAdditionalInfo());
    assertNull(actualAssetInfoEntity.getVersion());
    assertNull(actualAssetInfoEntity.getLabel());
    assertNull(actualAssetInfoEntity.getName());
    assertNull(actualAssetInfoEntity.getType());
    assertNull(actualAssetInfoEntity.getId());
    assertNull(actualAssetInfoEntity.getUuid());
    assertNull(actualAssetInfoEntity.getAssetProfileId());
    assertNull(actualAssetInfoEntity.getCustomerId());
    assertNull(actualAssetInfoEntity.getExternalId());
    assertNull(actualAssetInfoEntity.getTenantId());
    assertEquals(0L, actualAssetInfoEntity.getCreatedTime());
    assertTrue(actualIsCustomerIsPublicResult);
  }
}
