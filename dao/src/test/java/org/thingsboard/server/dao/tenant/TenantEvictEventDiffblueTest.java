package org.thingsboard.server.dao.tenant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.model.ModelConstants;

public class TenantEvictEventDiffblueTest {
  /**
   * Test {@link TenantEvictEvent#equals(Object)}, and {@link TenantEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantEvictEvent#equals(Object)}
   *   <li>{@link TenantEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantEvictEvent tenantEvictEvent = new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true);
    TenantEvictEvent tenantEvictEvent2 = new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true);

    // Act and Assert
    assertEquals(tenantEvictEvent, tenantEvictEvent2);
    int expectedHashCodeResult = tenantEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, tenantEvictEvent2.hashCode());
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}, and {@link TenantEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantEvictEvent#equals(Object)}
   *   <li>{@link TenantEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantEvictEvent tenantEvictEvent = new TenantEvictEvent(null, true);
    TenantEvictEvent tenantEvictEvent2 = new TenantEvictEvent(null, true);

    // Act and Assert
    assertEquals(tenantEvictEvent, tenantEvictEvent2);
    int expectedHashCodeResult = tenantEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, tenantEvictEvent2.hashCode());
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}, and {@link TenantEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantEvictEvent#equals(Object)}
   *   <li>{@link TenantEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    TenantEvictEvent tenantEvictEvent = new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true);

    // Act and Assert
    assertEquals(tenantEvictEvent, tenantEvictEvent);
    int expectedHashCodeResult = tenantEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, tenantEvictEvent.hashCode());
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantEvictEvent tenantEvictEvent = new TenantEvictEvent(
        new TenantId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true);

    // Act and Assert
    assertNotEquals(tenantEvictEvent, new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true));
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantEvictEvent tenantEvictEvent = new TenantEvictEvent(null, true);

    // Act and Assert
    assertNotEquals(tenantEvictEvent, new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true));
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    TenantEvictEvent tenantEvictEvent = new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, false);

    // Act and Assert
    assertNotEquals(tenantEvictEvent, new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true));
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true), null);
  }

  /**
   * Test {@link TenantEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantEvictEvent.equals(Object)", "int TenantEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true), "Different type to TenantEvictEvent");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantEvictEvent#TenantEvictEvent(TenantId, boolean)}
   *   <li>{@link TenantEvictEvent#toString()}
   *   <li>{@link TenantEvictEvent#getTenantId()}
   *   <li>{@link TenantEvictEvent#isInvalidateExists()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"void TenantEvictEvent.<init>(TenantId, boolean)", "TenantId TenantEvictEvent.getTenantId()",
      "boolean TenantEvictEvent.isInvalidateExists()", "String TenantEvictEvent.toString()"})
  public void testGettersAndSetters() {
    // Arrange and Act
    TenantEvictEvent actualTenantEvictEvent = new TenantEvictEvent(ModelConstants.SYSTEM_TENANT, true);
    String actualToStringResult = actualTenantEvictEvent.toString();
    TenantId actualTenantId = actualTenantEvictEvent.getTenantId();

    // Assert
    assertEquals("TenantEvictEvent(tenantId=13814000-1dd2-11b2-8080-808080808080, invalidateExists=true)",
        actualToStringResult);
    assertTrue(actualTenantEvictEvent.isInvalidateExists());
    assertSame(actualTenantId.SYS_TENANT_ID, actualTenantId);
  }
}
