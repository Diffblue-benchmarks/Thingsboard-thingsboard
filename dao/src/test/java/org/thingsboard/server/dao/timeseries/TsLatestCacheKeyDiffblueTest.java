package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class TsLatestCacheKeyDiffblueTest {
  /**
   * Test {@link TsLatestCacheKey#equals(Object)}, and {@link TsLatestCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsLatestCacheKey#equals(Object)}
   *   <li>{@link TsLatestCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsLatestCacheKey.equals(Object)", "int TsLatestCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TsLatestCacheKey tsLatestCacheKey = new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key");
    TsLatestCacheKey tsLatestCacheKey2 = new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Act and Assert
    assertEquals(tsLatestCacheKey, tsLatestCacheKey2);
    int expectedHashCodeResult = tsLatestCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, tsLatestCacheKey2.hashCode());
  }

  /**
   * Test {@link TsLatestCacheKey#equals(Object)}, and {@link TsLatestCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsLatestCacheKey#equals(Object)}
   *   <li>{@link TsLatestCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsLatestCacheKey.equals(Object)", "int TsLatestCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TsLatestCacheKey tsLatestCacheKey = new TsLatestCacheKey(null, "Key");
    TsLatestCacheKey tsLatestCacheKey2 = new TsLatestCacheKey(null, "Key");

    // Act and Assert
    assertEquals(tsLatestCacheKey, tsLatestCacheKey2);
    int expectedHashCodeResult = tsLatestCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, tsLatestCacheKey2.hashCode());
  }

  /**
   * Test {@link TsLatestCacheKey#equals(Object)}, and {@link TsLatestCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsLatestCacheKey#equals(Object)}
   *   <li>{@link TsLatestCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsLatestCacheKey.equals(Object)", "int TsLatestCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    TsLatestCacheKey tsLatestCacheKey = new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID, null);
    TsLatestCacheKey tsLatestCacheKey2 = new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID, null);

    // Act and Assert
    assertEquals(tsLatestCacheKey, tsLatestCacheKey2);
    int expectedHashCodeResult = tsLatestCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, tsLatestCacheKey2.hashCode());
  }

  /**
   * Test {@link TsLatestCacheKey#equals(Object)}, and {@link TsLatestCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsLatestCacheKey#equals(Object)}
   *   <li>{@link TsLatestCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsLatestCacheKey.equals(Object)", "int TsLatestCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TsLatestCacheKey tsLatestCacheKey = new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key");

    // Act and Assert
    assertEquals(tsLatestCacheKey, tsLatestCacheKey);
    int expectedHashCodeResult = tsLatestCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, tsLatestCacheKey.hashCode());
  }

  /**
   * Test {@link TsLatestCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsLatestCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsLatestCacheKey.equals(Object)", "int TsLatestCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TsLatestCacheKey tsLatestCacheKey = new TsLatestCacheKey(ModelConstants.SYSTEM_TENANT, "Key");

    // Act and Assert
    assertNotEquals(tsLatestCacheKey, new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key"));
  }

  /**
   * Test {@link TsLatestCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsLatestCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsLatestCacheKey.equals(Object)", "int TsLatestCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TsLatestCacheKey tsLatestCacheKey = new TsLatestCacheKey(null, "Key");

    // Act and Assert
    assertNotEquals(tsLatestCacheKey, new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key"));
  }

  /**
   * Test {@link TsLatestCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsLatestCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsLatestCacheKey.equals(Object)", "int TsLatestCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TsLatestCacheKey tsLatestCacheKey = new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID, null);

    // Act and Assert
    assertNotEquals(tsLatestCacheKey, new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key"));
  }

  /**
   * Test {@link TsLatestCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsLatestCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsLatestCacheKey.equals(Object)", "int TsLatestCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TsLatestCacheKey tsLatestCacheKey = new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID,
        "org.thingsboard.server.dao.timeseries.TsLatestCacheKey");

    // Act and Assert
    assertNotEquals(tsLatestCacheKey, new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key"));
  }

  /**
   * Test {@link TsLatestCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsLatestCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsLatestCacheKey.equals(Object)", "int TsLatestCacheKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key"), null);
  }

  /**
   * Test {@link TsLatestCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TsLatestCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TsLatestCacheKey.equals(Object)", "int TsLatestCacheKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TsLatestCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key"),
        "Different type to TsLatestCacheKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TsLatestCacheKey#TsLatestCacheKey(EntityId, String)}
   *   <li>{@link TsLatestCacheKey#toString()}
   *   <li>{@link TsLatestCacheKey#getEntityId()}
   *   <li>{@link TsLatestCacheKey#getKey()}
   *   <li>{@link TsLatestCacheKey#isVersioned()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TsLatestCacheKey.<init>(EntityId, String)", "EntityId TsLatestCacheKey.getEntityId()",
      "String TsLatestCacheKey.getKey()", "boolean TsLatestCacheKey.isVersioned()",
      "String TsLatestCacheKey.toString()"})
  public void testGettersAndSetters() {
    // Arrange
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;

    // Act
    TsLatestCacheKey actualTsLatestCacheKey = new TsLatestCacheKey(entityId, "Key");
    String actualToStringResult = actualTsLatestCacheKey.toString();
    EntityId actualEntityId = actualTsLatestCacheKey.getEntityId();
    String actualKey = actualTsLatestCacheKey.getKey();

    // Assert
    assertEquals("Key", actualKey);
    assertEquals("{13814000-1dd2-11b2-8080-808080808080}Key", actualToStringResult);
    assertTrue(actualTsLatestCacheKey.isVersioned());
    assertSame(entityId, actualEntityId);
  }
}
