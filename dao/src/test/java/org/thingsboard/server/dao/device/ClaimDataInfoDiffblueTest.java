package org.thingsboard.server.dao.device;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.thingsboard.server.dao.device.claim.ClaimData;

class ClaimDataInfoDiffblueTest {
  /**
   * Test {@link ClaimDataInfo#equals(Object)}, and {@link ClaimDataInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimDataInfo#equals(Object)}
   *   <li>{@link ClaimDataInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();
    ClaimDataInfo claimDataInfo =
        new ClaimDataInfo(true, key, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));
    ArrayList<Object> key2 = new ArrayList<>();
    ClaimDataInfo claimDataInfo2 =
        new ClaimDataInfo(
            true, key2, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));

    // Act and Assert
    assertEquals(claimDataInfo, claimDataInfo2);
    assertEquals(claimDataInfo.hashCode(), claimDataInfo2.hashCode());
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}, and {@link ClaimDataInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is equal.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimDataInfo#equals(Object)}
   *   <li>{@link ClaimDataInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is equal; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ClaimDataInfo claimDataInfo = new ClaimDataInfo(true, new ArrayList<>(), null);
    ClaimDataInfo claimDataInfo2 = new ClaimDataInfo(true, new ArrayList<>(), null);

    // Act and Assert
    assertEquals(claimDataInfo, claimDataInfo2);
    assertEquals(claimDataInfo.hashCode(), claimDataInfo2.hashCode());
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}, and {@link ClaimDataInfo#hashCode()}.
   *
   * <ul>
   *   <li>When other is same.
   *   <li>Then return equal.
   * </ul>
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimDataInfo#equals(Object)}
   *   <li>{@link ClaimDataInfo#hashCode()}
   * </ul>
   */
  @Test
  @DisplayName("Test equals(Object), and hashCode(); when other is same; then return equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();
    ClaimDataInfo claimDataInfo =
        new ClaimDataInfo(true, key, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));

    // Act and Assert
    assertEquals(claimDataInfo, claimDataInfo);
    int expectedHashCodeResult = claimDataInfo.hashCode();
    assertEquals(expectedHashCodeResult, claimDataInfo.hashCode());
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();
    ClaimDataInfo claimDataInfo =
        new ClaimDataInfo(
            false, key, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));
    ArrayList<Object> key2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(
        claimDataInfo,
        new ClaimDataInfo(
            true, key2, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)));
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();
    key.add("42");
    ClaimDataInfo claimDataInfo =
        new ClaimDataInfo(true, key, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));
    ArrayList<Object> key2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(
        claimDataInfo,
        new ClaimDataInfo(
            true, key2, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)));
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();
    ClaimDataInfo claimDataInfo = new ClaimDataInfo(true, key, new ClaimData("Secret Key", 1L));
    ArrayList<Object> key2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(
        claimDataInfo,
        new ClaimDataInfo(
            true, key2, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)));
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is different.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is different; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ClaimDataInfo claimDataInfo = new ClaimDataInfo(true, new ArrayList<>(), null);
    ArrayList<Object> key = new ArrayList<>();

    // Act and Assert
    assertNotEquals(
        claimDataInfo,
        new ClaimDataInfo(
            true, key, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)));
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is {@code null}.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is 'null'; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();

    // Act and Assert
    assertNotEquals(
        new ClaimDataInfo(true, key, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)),
        null);
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   *
   * <ul>
   *   <li>When other is wrong type.
   *   <li>Then return not equal.
   * </ul>
   *
   * <p>Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  @DisplayName("Test equals(Object); when other is wrong type; then return not equal")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();

    // Act and Assert
    assertNotEquals(
        new ClaimDataInfo(true, key, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)),
        "Different type to ClaimDataInfo");
  }

  /**
   * Test getters and setters.
   *
   * <p>Methods under test:
   *
   * <ul>
   *   <li>{@link ClaimDataInfo#ClaimDataInfo(boolean, List, ClaimData)}
   *   <li>{@link ClaimDataInfo#toString()}
   *   <li>{@link ClaimDataInfo#getData()}
   *   <li>{@link ClaimDataInfo#getKey()}
   *   <li>{@link ClaimDataInfo#isFromCache()}
   * </ul>
   */
  @Test
  @DisplayName("Test getters and setters")
  @Tag("ContributionFromDiffblue")
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClaimDataInfo.<init>(boolean, List, ClaimData)",
    "ClaimData ClaimDataInfo.getData()",
    "List ClaimDataInfo.getKey()",
    "boolean ClaimDataInfo.isFromCache()",
    "String ClaimDataInfo.toString()"
  })
  void testGettersAndSetters() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();
    ClaimData data = new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L);

    // Act
    ClaimDataInfo actualClaimDataInfo = new ClaimDataInfo(true, key, data);
    String actualToStringResult = actualClaimDataInfo.toString();
    ClaimData actualData = actualClaimDataInfo.getData();
    List<Object> actualKey = actualClaimDataInfo.getKey();
    boolean actualIsFromCacheResult = actualClaimDataInfo.isFromCache();

    // Assert
    assertEquals(
        "ClaimDataInfo(fromCache=true, key=[], data=ClaimData(secretKey=EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY,"
            + " expirationTime=1))",
        actualToStringResult);
    assertTrue(actualKey.isEmpty());
    assertTrue(actualIsFromCacheResult);
    assertSame(key, actualKey);
    assertSame(data, actualData);
  }
}
