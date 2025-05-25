package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EdgeInfoEntityDiffblueTest {
  /**
   * Test {@link EdgeInfoEntity#equals(Object)}, and {@link EdgeInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInfoEntity#equals(Object)}
   *   <li>{@link EdgeInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();
    EdgeInfoEntity edgeInfoEntity2 = new EdgeInfoEntity();

    // Act and Assert
    assertEquals(edgeInfoEntity, edgeInfoEntity2);
    int expectedHashCodeResult = edgeInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeInfoEntity2.hashCode());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}, and {@link EdgeInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInfoEntity#equals(Object)}
   *   <li>{@link EdgeInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EdgeInfoEntity edgeInfoEntity = new EdgeInfoEntity();

    // Act and Assert
    assertEquals(edgeInfoEntity, edgeInfoEntity);
    int expectedHashCodeResult = edgeInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, edgeInfoEntity.hashCode());
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInfoEntity(), null);
  }

  /**
   * Test {@link EdgeInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EdgeInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EdgeInfoEntity.equals(Object)", "int EdgeInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EdgeInfoEntity(), "Different type to EdgeInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EdgeInfoEntity#EdgeInfoEntity()}
   *   <li>{@link EdgeInfoEntity#setCustomerIsPublic(boolean)}
   *   <li>{@link EdgeInfoEntity#setCustomerTitle(String)}
   *   <li>{@link EdgeInfoEntity#toString()}
   *   <li>{@link EdgeInfoEntity#getCustomerTitle()}
   *   <li>{@link EdgeInfoEntity#isCustomerIsPublic()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EdgeInfoEntity.<init>()", "String EdgeInfoEntity.getCustomerTitle()",
      "boolean EdgeInfoEntity.isCustomerIsPublic()", "void EdgeInfoEntity.setCustomerIsPublic(boolean)",
      "void EdgeInfoEntity.setCustomerTitle(String)", "String EdgeInfoEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    EdgeInfoEntity actualEdgeInfoEntity = new EdgeInfoEntity();
    actualEdgeInfoEntity.setCustomerIsPublic(true);
    actualEdgeInfoEntity.setCustomerTitle("Dr");
    String actualToStringResult = actualEdgeInfoEntity.toString();
    String actualCustomerTitle = actualEdgeInfoEntity.getCustomerTitle();
    boolean actualIsCustomerIsPublicResult = actualEdgeInfoEntity.isCustomerIsPublic();

    // Assert
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("EdgeInfoEntity(customerTitle=Dr, customerIsPublic=true)", actualToStringResult);
    assertNull(actualEdgeInfoEntity.getAdditionalInfo());
    assertNull(actualEdgeInfoEntity.getVersion());
    assertNull(actualEdgeInfoEntity.getLabel());
    assertNull(actualEdgeInfoEntity.getName());
    assertNull(actualEdgeInfoEntity.getRoutingKey());
    assertNull(actualEdgeInfoEntity.getSecret());
    assertNull(actualEdgeInfoEntity.getType());
    assertNull(actualEdgeInfoEntity.getId());
    assertNull(actualEdgeInfoEntity.getUuid());
    assertNull(actualEdgeInfoEntity.getCustomerId());
    assertNull(actualEdgeInfoEntity.getRootRuleChainId());
    assertNull(actualEdgeInfoEntity.getTenantId());
    assertEquals(0L, actualEdgeInfoEntity.getCreatedTime());
    assertTrue(actualIsCustomerIsPublicResult);
  }
}
