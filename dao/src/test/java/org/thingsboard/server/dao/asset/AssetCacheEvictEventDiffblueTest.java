package org.thingsboard.server.dao.asset;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class AssetCacheEvictEventDiffblueTest {
  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}, and {@link AssetCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheEvictEvent#equals(Object)}
   *   <li>{@link AssetCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    AssetCacheEvictEvent assetCacheEvictEvent =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name");
    AssetCacheEvictEvent assetCacheEvictEvent2 =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name");

    // Act and Assert
    assertEquals(assetCacheEvictEvent, assetCacheEvictEvent2);
    int expectedHashCodeResult = assetCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, assetCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}, and {@link AssetCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheEvictEvent#equals(Object)}
   *   <li>{@link AssetCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    AssetCacheEvictEvent assetCacheEvictEvent =
        new AssetCacheEvictEvent(null, "New Name", "Old Name");
    AssetCacheEvictEvent assetCacheEvictEvent2 =
        new AssetCacheEvictEvent(null, "New Name", "Old Name");

    // Act and Assert
    assertEquals(assetCacheEvictEvent, assetCacheEvictEvent2);
    int expectedHashCodeResult = assetCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, assetCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}, and {@link AssetCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheEvictEvent#equals(Object)}
   *   <li>{@link AssetCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    AssetCacheEvictEvent assetCacheEvictEvent =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, null, "Old Name");
    AssetCacheEvictEvent assetCacheEvictEvent2 =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, null, "Old Name");

    // Act and Assert
    assertEquals(assetCacheEvictEvent, assetCacheEvictEvent2);
    int expectedHashCodeResult = assetCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, assetCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}, and {@link AssetCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheEvictEvent#equals(Object)}
   *   <li>{@link AssetCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    AssetCacheEvictEvent assetCacheEvictEvent =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", null);
    AssetCacheEvictEvent assetCacheEvictEvent2 =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", null);

    // Act and Assert
    assertEquals(assetCacheEvictEvent, assetCacheEvictEvent2);
    int expectedHashCodeResult = assetCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, assetCacheEvictEvent2.hashCode());
  }

  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}, and {@link AssetCacheEvictEvent#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheEvictEvent#equals(Object)}
   *   <li>{@link AssetCacheEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    AssetCacheEvictEvent assetCacheEvictEvent =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name");

    // Act and Assert
    assertEquals(assetCacheEvictEvent, assetCacheEvictEvent);
    int expectedHashCodeResult = assetCacheEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, assetCacheEvictEvent.hashCode());
  }

  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    AssetCacheEvictEvent assetCacheEvictEvent =
        new AssetCacheEvictEvent(
            new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")),
            "New Name",
            "Old Name");

    // Act and Assert
    assertNotEquals(
        assetCacheEvictEvent,
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name"));
  }

  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    AssetCacheEvictEvent assetCacheEvictEvent =
        new AssetCacheEvictEvent(null, "New Name", "Old Name");

    // Act and Assert
    assertNotEquals(
        assetCacheEvictEvent,
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name"));
  }

  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    AssetCacheEvictEvent assetCacheEvictEvent =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "Old Name", "Old Name");

    // Act and Assert
    assertNotEquals(
        assetCacheEvictEvent,
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name"));
  }

  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    AssetCacheEvictEvent assetCacheEvictEvent =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, null, "Old Name");

    // Act and Assert
    assertNotEquals(
        assetCacheEvictEvent,
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name"));
  }

  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    AssetCacheEvictEvent assetCacheEvictEvent =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "New Name");

    // Act and Assert
    assertNotEquals(
        assetCacheEvictEvent,
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name"));
  }

  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    AssetCacheEvictEvent assetCacheEvictEvent =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", null);

    // Act and Assert
    assertNotEquals(
        assetCacheEvictEvent,
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name"));
  }

  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name"), null);
  }

  /**
   * Test {@link AssetCacheEvictEvent#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link AssetCacheEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "boolean AssetCacheEvictEvent.equals(Object)",
    "int AssetCacheEvictEvent.hashCode()"
  })
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name"),
        "Different type to AssetCacheEvictEvent");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link AssetCacheEvictEvent#AssetCacheEvictEvent(TenantId, String, String)}
   *   <li>{@link AssetCacheEvictEvent#toString()}
   *   <li>{@link AssetCacheEvictEvent#getNewName()}
   *   <li>{@link AssetCacheEvictEvent#getOldName()}
   *   <li>{@link AssetCacheEvictEvent#getTenantId()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({
    "void AssetCacheEvictEvent.<init>(TenantId, String, String)",
    "String AssetCacheEvictEvent.getNewName()",
    "String AssetCacheEvictEvent.getOldName()",
    "TenantId AssetCacheEvictEvent.getTenantId()",
    "String AssetCacheEvictEvent.toString()"
  })
  public void testGettersAndSetters() {
    // Arrange and Act
    AssetCacheEvictEvent actualAssetCacheEvictEvent =
        new AssetCacheEvictEvent(ModelConstants.SYSTEM_TENANT, "New Name", "Old Name");
    String actualToStringResult = actualAssetCacheEvictEvent.toString();
    String actualNewName = actualAssetCacheEvictEvent.getNewName();
    String actualOldName = actualAssetCacheEvictEvent.getOldName();
    TenantId actualTenantId = actualAssetCacheEvictEvent.getTenantId();

    // Assert
    assertEquals(
        "AssetCacheEvictEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, newName=New Name, oldName=Old"
            + " Name)",
        actualToStringResult);
    assertEquals("New Name", actualNewName);
    assertEquals("Old Name", actualOldName);
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
