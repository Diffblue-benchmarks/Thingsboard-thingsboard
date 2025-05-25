package org.thingsboard.server.dao.tenant;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import com.diffblue.cover.annotations.MaintainedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.UUID;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.common.data.id.TenantProfileId;

public class TenantProfileEvictEventDiffblueTest {
  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}, and {@link TenantProfileEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileEvictEvent#equals(Object)}
   *   <li>{@link TenantProfileEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileEvictEvent.equals(Object)", "int TenantProfileEvictEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(null, true);
    TenantProfileEvictEvent tenantProfileEvictEvent2 = new TenantProfileEvictEvent(null, true);

    // Act and Assert
    assertEquals(tenantProfileEvictEvent, tenantProfileEvictEvent2);
    int expectedHashCodeResult = tenantProfileEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileEvictEvent2.hashCode());
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}, and {@link TenantProfileEvictEvent#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link TenantProfileEvictEvent#equals(Object)}
   *   <li>{@link TenantProfileEvictEvent#hashCode()}
   * </ul>
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileEvictEvent.equals(Object)", "int TenantProfileEvictEvent.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true);
    TenantProfileEvictEvent tenantProfileEvictEvent2 = new TenantProfileEvictEvent(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true);

    // Act and Assert
    assertEquals(tenantProfileEvictEvent, tenantProfileEvictEvent2);
    int expectedHashCodeResult = tenantProfileEvictEvent.hashCode();
    assertEquals(expectedHashCodeResult, tenantProfileEvictEvent2.hashCode());
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileEvictEvent.equals(Object)", "int TenantProfileEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true);

    // Act and Assert
    assertNotEquals(tenantProfileEvictEvent, new TenantProfileEvictEvent(null, true));
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileEvictEvent.equals(Object)", "int TenantProfileEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(null, false);

    // Act and Assert
    assertNotEquals(tenantProfileEvictEvent, new TenantProfileEvictEvent(null, true));
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileEvictEvent.equals(Object)", "int TenantProfileEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange, Act and Assert
    assertNotEquals(new TenantProfileEvictEvent(null, true), 1);
  }

  /**
   * Test {@link TenantProfileEvictEvent#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link TenantProfileEvictEvent#equals(Object)}
   */
  @Test
  @Category(MaintainedByDiffblue.class)
  @MethodsUnderTest({"boolean TenantProfileEvictEvent.equals(Object)", "int TenantProfileEvictEvent.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    TenantProfileEvictEvent tenantProfileEvictEvent = new TenantProfileEvictEvent(null, true);

    // Act and Assert
    assertNotEquals(tenantProfileEvictEvent, new TenantProfileEvictEvent(
        new TenantProfileId(UUID.fromString("784f394c-42b6-435a-983c-b7beff2784f9")), true));
  }
}
