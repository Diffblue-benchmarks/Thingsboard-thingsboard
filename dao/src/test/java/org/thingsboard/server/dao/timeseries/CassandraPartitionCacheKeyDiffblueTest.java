package org.thingsboard.server.dao.timeseries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.dao.entity.BaseEntityService;
import org.thingsboard.server.dao.model.ModelConstants;

public class CassandraPartitionCacheKeyDiffblueTest {
  /**
   * Test {@link CassandraPartitionCacheKey#equals(Object)}, and {@link CassandraPartitionCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraPartitionCacheKey#equals(Object)}
   *   <li>{@link CassandraPartitionCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraPartitionCacheKey.equals(Object)", "int CassandraPartitionCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    CassandraPartitionCacheKey cassandraPartitionCacheKey = new CassandraPartitionCacheKey(
        BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);
    CassandraPartitionCacheKey cassandraPartitionCacheKey2 = new CassandraPartitionCacheKey(
        BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);

    // Act and Assert
    assertEquals(cassandraPartitionCacheKey, cassandraPartitionCacheKey2);
    int expectedHashCodeResult = cassandraPartitionCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, cassandraPartitionCacheKey2.hashCode());
  }

  /**
   * Test {@link CassandraPartitionCacheKey#equals(Object)}, and {@link CassandraPartitionCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraPartitionCacheKey#equals(Object)}
   *   <li>{@link CassandraPartitionCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraPartitionCacheKey.equals(Object)", "int CassandraPartitionCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    CassandraPartitionCacheKey cassandraPartitionCacheKey = new CassandraPartitionCacheKey(null, "Key", 1L);
    CassandraPartitionCacheKey cassandraPartitionCacheKey2 = new CassandraPartitionCacheKey(null, "Key", 1L);

    // Act and Assert
    assertEquals(cassandraPartitionCacheKey, cassandraPartitionCacheKey2);
    int expectedHashCodeResult = cassandraPartitionCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, cassandraPartitionCacheKey2.hashCode());
  }

  /**
   * Test {@link CassandraPartitionCacheKey#equals(Object)}, and {@link CassandraPartitionCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraPartitionCacheKey#equals(Object)}
   *   <li>{@link CassandraPartitionCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraPartitionCacheKey.equals(Object)", "int CassandraPartitionCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    CassandraPartitionCacheKey cassandraPartitionCacheKey = new CassandraPartitionCacheKey(
        BaseEntityService.NULL_CUSTOMER_ID, null, 1L);
    CassandraPartitionCacheKey cassandraPartitionCacheKey2 = new CassandraPartitionCacheKey(
        BaseEntityService.NULL_CUSTOMER_ID, null, 1L);

    // Act and Assert
    assertEquals(cassandraPartitionCacheKey, cassandraPartitionCacheKey2);
    int expectedHashCodeResult = cassandraPartitionCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, cassandraPartitionCacheKey2.hashCode());
  }

  /**
   * Test {@link CassandraPartitionCacheKey#equals(Object)}, and {@link CassandraPartitionCacheKey#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraPartitionCacheKey#equals(Object)}
   *   <li>{@link CassandraPartitionCacheKey#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraPartitionCacheKey.equals(Object)", "int CassandraPartitionCacheKey.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    CassandraPartitionCacheKey cassandraPartitionCacheKey = new CassandraPartitionCacheKey(
        BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);

    // Act and Assert
    assertEquals(cassandraPartitionCacheKey, cassandraPartitionCacheKey);
    int expectedHashCodeResult = cassandraPartitionCacheKey.hashCode();
    assertEquals(expectedHashCodeResult, cassandraPartitionCacheKey.hashCode());
  }

  /**
   * Test {@link CassandraPartitionCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraPartitionCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraPartitionCacheKey.equals(Object)", "int CassandraPartitionCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    CassandraPartitionCacheKey cassandraPartitionCacheKey = new CassandraPartitionCacheKey(ModelConstants.SYSTEM_TENANT,
        "Key", 1L);

    // Act and Assert
    assertNotEquals(cassandraPartitionCacheKey,
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L));
  }

  /**
   * Test {@link CassandraPartitionCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraPartitionCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraPartitionCacheKey.equals(Object)", "int CassandraPartitionCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    CassandraPartitionCacheKey cassandraPartitionCacheKey = new CassandraPartitionCacheKey(null, "Key", 1L);

    // Act and Assert
    assertNotEquals(cassandraPartitionCacheKey,
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L));
  }

  /**
   * Test {@link CassandraPartitionCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraPartitionCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraPartitionCacheKey.equals(Object)", "int CassandraPartitionCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    CassandraPartitionCacheKey cassandraPartitionCacheKey = new CassandraPartitionCacheKey(
        BaseEntityService.NULL_CUSTOMER_ID, null, 1L);

    // Act and Assert
    assertNotEquals(cassandraPartitionCacheKey,
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L));
  }

  /**
   * Test {@link CassandraPartitionCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraPartitionCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraPartitionCacheKey.equals(Object)", "int CassandraPartitionCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    CassandraPartitionCacheKey cassandraPartitionCacheKey = new CassandraPartitionCacheKey(
        BaseEntityService.NULL_CUSTOMER_ID, "org.thingsboard.server.dao.timeseries.CassandraPartitionCacheKey", 1L);

    // Act and Assert
    assertNotEquals(cassandraPartitionCacheKey,
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L));
  }

  /**
   * Test {@link CassandraPartitionCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraPartitionCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraPartitionCacheKey.equals(Object)", "int CassandraPartitionCacheKey.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    CassandraPartitionCacheKey cassandraPartitionCacheKey = new CassandraPartitionCacheKey(
        BaseEntityService.NULL_CUSTOMER_ID, "Key", 3L);

    // Act and Assert
    assertNotEquals(cassandraPartitionCacheKey,
        new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L));
  }

  /**
   * Test {@link CassandraPartitionCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraPartitionCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraPartitionCacheKey.equals(Object)", "int CassandraPartitionCacheKey.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L), null);
  }

  /**
   * Test {@link CassandraPartitionCacheKey#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link CassandraPartitionCacheKey#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean CassandraPartitionCacheKey.equals(Object)", "int CassandraPartitionCacheKey.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new CassandraPartitionCacheKey(BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L),
        "Different type to CassandraPartitionCacheKey");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link CassandraPartitionCacheKey#CassandraPartitionCacheKey(EntityId, String, long)}
   *   <li>{@link CassandraPartitionCacheKey#setEntityId(EntityId)}
   *   <li>{@link CassandraPartitionCacheKey#setKey(String)}
   *   <li>{@link CassandraPartitionCacheKey#setPartition(long)}
   *   <li>{@link CassandraPartitionCacheKey#toString()}
   *   <li>{@link CassandraPartitionCacheKey#getEntityId()}
   *   <li>{@link CassandraPartitionCacheKey#getKey()}
   *   <li>{@link CassandraPartitionCacheKey#getPartition()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void CassandraPartitionCacheKey.<init>(EntityId, String, long)",
      "EntityId CassandraPartitionCacheKey.getEntityId()", "String CassandraPartitionCacheKey.getKey()",
      "long CassandraPartitionCacheKey.getPartition()", "void CassandraPartitionCacheKey.setEntityId(EntityId)",
      "void CassandraPartitionCacheKey.setKey(String)", "void CassandraPartitionCacheKey.setPartition(long)",
      "String CassandraPartitionCacheKey.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    CassandraPartitionCacheKey actualCassandraPartitionCacheKey = new CassandraPartitionCacheKey(
        BaseEntityService.NULL_CUSTOMER_ID, "Key", 1L);
    CustomerId entityId = BaseEntityService.NULL_CUSTOMER_ID;
    actualCassandraPartitionCacheKey.setEntityId(entityId);
    actualCassandraPartitionCacheKey.setKey("Key");
    actualCassandraPartitionCacheKey.setPartition(1L);
    String actualToStringResult = actualCassandraPartitionCacheKey.toString();
    EntityId actualEntityId = actualCassandraPartitionCacheKey.getEntityId();
    String actualKey = actualCassandraPartitionCacheKey.getKey();

    // Assert
    assertEquals("CassandraPartitionCacheKey(entityId=13814000-1dd2-11b2-8080-808080808080, key=Key, partition=1)",
        actualToStringResult);
    assertEquals("Key", actualKey);
    assertEquals(1L, actualCassandraPartitionCacheKey.getPartition());
    assertSame(entityId, actualEntityId);
  }
}
