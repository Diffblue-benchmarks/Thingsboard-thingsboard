package org.thingsboard.server.dao.model.sql;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.Test;
import org.junit.experimental.categories.Category;

public class EntityViewInfoEntityDiffblueTest {
  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}, and {@link EntityViewInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewInfoEntity#equals(Object)}
   *   <li>{@link EntityViewInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityViewInfoEntity.equals(Object)", "int EntityViewInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();
    EntityViewInfoEntity entityViewInfoEntity2 = new EntityViewInfoEntity();

    // Act and Assert
    assertEquals(entityViewInfoEntity, entityViewInfoEntity2);
    int expectedHashCodeResult = entityViewInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewInfoEntity2.hashCode());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}, and {@link EntityViewInfoEntity#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewInfoEntity#equals(Object)}
   *   <li>{@link EntityViewInfoEntity#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityViewInfoEntity.equals(Object)", "int EntityViewInfoEntity.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    EntityViewInfoEntity entityViewInfoEntity = new EntityViewInfoEntity();

    // Act and Assert
    assertEquals(entityViewInfoEntity, entityViewInfoEntity);
    int expectedHashCodeResult = entityViewInfoEntity.hashCode();
    assertEquals(expectedHashCodeResult, entityViewInfoEntity.hashCode());
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityViewInfoEntity.equals(Object)", "int EntityViewInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewInfoEntity(), null);
  }

  /**
   * Test {@link EntityViewInfoEntity#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link EntityViewInfoEntity#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean EntityViewInfoEntity.equals(Object)", "int EntityViewInfoEntity.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new EntityViewInfoEntity(), "Different type to EntityViewInfoEntity");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link EntityViewInfoEntity#EntityViewInfoEntity()}
   *   <li>{@link EntityViewInfoEntity#setCustomerIsPublic(boolean)}
   *   <li>{@link EntityViewInfoEntity#setCustomerTitle(String)}
   *   <li>{@link EntityViewInfoEntity#toString()}
   *   <li>{@link EntityViewInfoEntity#getCustomerTitle()}
   *   <li>{@link EntityViewInfoEntity#isCustomerIsPublic()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void EntityViewInfoEntity.<init>()", "String EntityViewInfoEntity.getCustomerTitle()",
      "boolean EntityViewInfoEntity.isCustomerIsPublic()", "void EntityViewInfoEntity.setCustomerIsPublic(boolean)",
      "void EntityViewInfoEntity.setCustomerTitle(String)", "String EntityViewInfoEntity.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    EntityViewInfoEntity actualEntityViewInfoEntity = new EntityViewInfoEntity();
    actualEntityViewInfoEntity.setCustomerIsPublic(true);
    actualEntityViewInfoEntity.setCustomerTitle("Dr");
    String actualToStringResult = actualEntityViewInfoEntity.toString();
    String actualCustomerTitle = actualEntityViewInfoEntity.getCustomerTitle();
    boolean actualIsCustomerIsPublicResult = actualEntityViewInfoEntity.isCustomerIsPublic();

    // Assert
    assertEquals("Dr", actualCustomerTitle);
    assertEquals("EntityViewInfoEntity(customerTitle=Dr, customerIsPublic=true)", actualToStringResult);
    assertNull(actualEntityViewInfoEntity.getAdditionalInfo());
    assertNull(actualEntityViewInfoEntity.getVersion());
    assertNull(actualEntityViewInfoEntity.getKeys());
    assertNull(actualEntityViewInfoEntity.getName());
    assertNull(actualEntityViewInfoEntity.getType());
    assertNull(actualEntityViewInfoEntity.getId());
    assertNull(actualEntityViewInfoEntity.getUuid());
    assertNull(actualEntityViewInfoEntity.getCustomerId());
    assertNull(actualEntityViewInfoEntity.getEntityId());
    assertNull(actualEntityViewInfoEntity.getExternalId());
    assertNull(actualEntityViewInfoEntity.getTenantId());
    assertNull(actualEntityViewInfoEntity.getEntityType());
    assertEquals(0L, actualEntityViewInfoEntity.getCreatedTime());
    assertEquals(0L, actualEntityViewInfoEntity.getEndTs());
    assertEquals(0L, actualEntityViewInfoEntity.getStartTs());
    assertTrue(actualIsCustomerIsPublicResult);
  }
}
