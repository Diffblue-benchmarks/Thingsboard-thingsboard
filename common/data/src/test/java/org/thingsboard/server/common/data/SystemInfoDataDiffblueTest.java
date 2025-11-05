package org.thingsboard.server.common.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class SystemInfoDataDiffblueTest {
  /**
   * Test {@link SystemInfoData#equals(Object)}, and {@link SystemInfoData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemInfoData#equals(Object)}
   *   <li>{@link SystemInfoData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertEquals(systemInfoData, systemInfoData2);
    assertEquals(systemInfoData.hashCode(), systemInfoData2.hashCode());
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}, and {@link SystemInfoData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemInfoData#equals(Object)}
   *   <li>{@link SystemInfoData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(null);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(null);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertEquals(systemInfoData, systemInfoData2);
    assertEquals(systemInfoData.hashCode(), systemInfoData2.hashCode());
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}, and {@link SystemInfoData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemInfoData#equals(Object)}
   *   <li>{@link SystemInfoData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual3() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(null);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(null);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertEquals(systemInfoData, systemInfoData2);
    assertEquals(systemInfoData.hashCode(), systemInfoData2.hashCode());
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}, and {@link SystemInfoData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemInfoData#equals(Object)}
   *   <li>{@link SystemInfoData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual4() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(null);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(null);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertEquals(systemInfoData, systemInfoData2);
    assertEquals(systemInfoData.hashCode(), systemInfoData2.hashCode());
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}, and {@link SystemInfoData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemInfoData#equals(Object)}
   *   <li>{@link SystemInfoData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual5() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(null);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(null);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertEquals(systemInfoData, systemInfoData2);
    assertEquals(systemInfoData.hashCode(), systemInfoData2.hashCode());
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}, and {@link SystemInfoData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemInfoData#equals(Object)}
   *   <li>{@link SystemInfoData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual6() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId(null);
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId(null);
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertEquals(systemInfoData, systemInfoData2);
    assertEquals(systemInfoData.hashCode(), systemInfoData2.hashCode());
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}, and {@link SystemInfoData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemInfoData#equals(Object)}
   *   <li>{@link SystemInfoData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual7() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType(null);
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType(null);
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertEquals(systemInfoData, systemInfoData2);
    assertEquals(systemInfoData.hashCode(), systemInfoData2.hashCode());
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}, and {@link SystemInfoData#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemInfoData#equals(Object)}
   *   <li>{@link SystemInfoData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual8() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(null);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(null);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertEquals(systemInfoData, systemInfoData2);
    assertEquals(systemInfoData.hashCode(), systemInfoData2.hashCode());
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}, and {@link SystemInfoData#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link SystemInfoData#equals(Object)}
   *   <li>{@link SystemInfoData#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    // Act and Assert
    assertEquals(systemInfoData, systemInfoData);
    int expectedHashCodeResult = systemInfoData.hashCode();
    assertEquals(expectedHashCodeResult, systemInfoData.hashCode());
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(1L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(null);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(3L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(null);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(3L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(null);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual7() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(3L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual8() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(null);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual9() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("Service Type");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual10() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId(null);
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual11() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("42");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual12() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType(null);
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual13() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(3L);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual14() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(null);
    systemInfoData.setTotalMemory(1L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual15() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(3L);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual16() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(null);

    SystemInfoData systemInfoData2 = new SystemInfoData();
    systemInfoData2.setCpuCount(3L);
    systemInfoData2.setCpuUsage(1L);
    systemInfoData2.setDiscUsage(1L);
    systemInfoData2.setMemoryUsage(1L);
    systemInfoData2.setServiceId("42");
    systemInfoData2.setServiceType("Service Type");
    systemInfoData2.setTotalDiscSpace(1L);
    systemInfoData2.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, systemInfoData2);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, null);
  }

  /**
   * Test {@link SystemInfoData#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link SystemInfoData#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean SystemInfoData.equals(Object)", "int SystemInfoData.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    SystemInfoData systemInfoData = new SystemInfoData();
    systemInfoData.setCpuCount(3L);
    systemInfoData.setCpuUsage(1L);
    systemInfoData.setDiscUsage(1L);
    systemInfoData.setMemoryUsage(1L);
    systemInfoData.setServiceId("42");
    systemInfoData.setServiceType("Service Type");
    systemInfoData.setTotalDiscSpace(1L);
    systemInfoData.setTotalMemory(1L);

    // Act and Assert
    assertNotEquals(systemInfoData, "Different type to SystemInfoData");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>default or parameterless constructor of {@link SystemInfoData}
   *   <li>{@link SystemInfoData#setCpuCount(Long)}
   *   <li>{@link SystemInfoData#setCpuUsage(Long)}
   *   <li>{@link SystemInfoData#setDiscUsage(Long)}
   *   <li>{@link SystemInfoData#setMemoryUsage(Long)}
   *   <li>{@link SystemInfoData#setServiceId(String)}
   *   <li>{@link SystemInfoData#setServiceType(String)}
   *   <li>{@link SystemInfoData#setTotalDiscSpace(Long)}
   *   <li>{@link SystemInfoData#setTotalMemory(Long)}
   *   <li>{@link SystemInfoData#toString()}
   *   <li>{@link SystemInfoData#getCpuCount()}
   *   <li>{@link SystemInfoData#getCpuUsage()}
   *   <li>{@link SystemInfoData#getDiscUsage()}
   *   <li>{@link SystemInfoData#getMemoryUsage()}
   *   <li>{@link SystemInfoData#getServiceId()}
   *   <li>{@link SystemInfoData#getServiceType()}
   *   <li>{@link SystemInfoData#getTotalDiscSpace()}
   *   <li>{@link SystemInfoData#getTotalMemory()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void SystemInfoData.<init>()",
    "Long SystemInfoData.getCpuCount()",
    "Long SystemInfoData.getCpuUsage()",
    "Long SystemInfoData.getDiscUsage()",
    "Long SystemInfoData.getMemoryUsage()",
    "String SystemInfoData.getServiceId()",
    "String SystemInfoData.getServiceType()",
    "Long SystemInfoData.getTotalDiscSpace()",
    "Long SystemInfoData.getTotalMemory()",
    "void SystemInfoData.setCpuCount(Long)",
    "void SystemInfoData.setCpuUsage(Long)",
    "void SystemInfoData.setDiscUsage(Long)",
    "void SystemInfoData.setMemoryUsage(Long)",
    "void SystemInfoData.setServiceId(String)",
    "void SystemInfoData.setServiceType(String)",
    "void SystemInfoData.setTotalDiscSpace(Long)",
    "void SystemInfoData.setTotalMemory(Long)",
    "String SystemInfoData.toString()"
  })
  void testGettersAndSetters() {
    // Arrange and Act
    SystemInfoData actualSystemInfoData = new SystemInfoData();
    actualSystemInfoData.setCpuCount(3L);
    actualSystemInfoData.setCpuUsage(1L);
    actualSystemInfoData.setDiscUsage(1L);
    actualSystemInfoData.setMemoryUsage(1L);
    actualSystemInfoData.setServiceId("42");
    actualSystemInfoData.setServiceType("Service Type");
    actualSystemInfoData.setTotalDiscSpace(1L);
    actualSystemInfoData.setTotalMemory(1L);
    String actualToStringResult = actualSystemInfoData.toString();
    Long actualCpuCount = actualSystemInfoData.getCpuCount();
    Long actualCpuUsage = actualSystemInfoData.getCpuUsage();
    Long actualDiscUsage = actualSystemInfoData.getDiscUsage();
    Long actualMemoryUsage = actualSystemInfoData.getMemoryUsage();
    String actualServiceId = actualSystemInfoData.getServiceId();
    String actualServiceType = actualSystemInfoData.getServiceType();
    Long actualTotalDiscSpace = actualSystemInfoData.getTotalDiscSpace();
    Long actualTotalMemory = actualSystemInfoData.getTotalMemory();

    // Assert
    assertEquals("42", actualServiceId);
    assertEquals("Service Type", actualServiceType);
    assertEquals(
        "SystemInfoData(serviceId=42, serviceType=Service Type, cpuUsage=1, cpuCount=3, memoryUsage=1,"
            + " totalMemory=1, discUsage=1, totalDiscSpace=1)",
        actualToStringResult);
    assertEquals(1L, actualCpuUsage.longValue());
    assertEquals(1L, actualDiscUsage.longValue());
    assertEquals(1L, actualMemoryUsage.longValue());
    assertEquals(1L, actualTotalDiscSpace.longValue());
    assertEquals(1L, actualTotalMemory.longValue());
    assertEquals(3L, actualCpuCount.longValue());
  }
}
