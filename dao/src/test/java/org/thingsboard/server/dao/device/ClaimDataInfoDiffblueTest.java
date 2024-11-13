package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.thingsboard.server.dao.device.claim.ClaimData;

public class ClaimDataInfoDiffblueTest {
  /**
   * Test {@link ClaimDataInfo#equals(Object)}, and
   * {@link ClaimDataInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimDataInfo#equals(Object)}
   *   <li>{@link ClaimDataInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();
    ClaimDataInfo claimDataInfo = new ClaimDataInfo(true, key,
        new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));
    ArrayList<Object> key2 = new ArrayList<>();
    ClaimDataInfo claimDataInfo2 = new ClaimDataInfo(true, key2,
        new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));

    // Act and Assert
    assertEquals(claimDataInfo, claimDataInfo2);
    int expectedHashCodeResult = claimDataInfo.hashCode();
    assertEquals(expectedHashCodeResult, claimDataInfo2.hashCode());
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}, and
   * {@link ClaimDataInfo#hashCode()}.
   * <ul>
   *   <li>When other is equal.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimDataInfo#equals(Object)}
   *   <li>{@link ClaimDataInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
    // Arrange
    ClaimDataInfo claimDataInfo = new ClaimDataInfo(true, new ArrayList<>(), null);
    ClaimDataInfo claimDataInfo2 = new ClaimDataInfo(true, new ArrayList<>(), null);

    // Act and Assert
    assertEquals(claimDataInfo, claimDataInfo2);
    int expectedHashCodeResult = claimDataInfo.hashCode();
    assertEquals(expectedHashCodeResult, claimDataInfo2.hashCode());
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}, and
   * {@link ClaimDataInfo#hashCode()}.
   * <ul>
   *   <li>When other is same.</li>
   *   <li>Then return equal.</li>
   * </ul>
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimDataInfo#equals(Object)}
   *   <li>{@link ClaimDataInfo#hashCode()}
   * </ul>
   */
  @Test
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();
    ClaimDataInfo claimDataInfo = new ClaimDataInfo(true, key,
        new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));

    // Act and Assert
    assertEquals(claimDataInfo, claimDataInfo);
    int expectedHashCodeResult = claimDataInfo.hashCode();
    assertEquals(expectedHashCodeResult, claimDataInfo.hashCode());
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();
    ClaimDataInfo claimDataInfo = new ClaimDataInfo(false, key,
        new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));
    ArrayList<Object> key2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(claimDataInfo,
        new ClaimDataInfo(true, key2, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)));
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();
    key.add("42");
    ClaimDataInfo claimDataInfo = new ClaimDataInfo(true, key,
        new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));
    ArrayList<Object> key2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(claimDataInfo,
        new ClaimDataInfo(true, key2, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)));
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();
    ClaimDataInfo claimDataInfo = new ClaimDataInfo(true, key, new ClaimData("Secret Key", 1L));
    ArrayList<Object> key2 = new ArrayList<>();

    // Act and Assert
    assertNotEquals(claimDataInfo,
        new ClaimDataInfo(true, key2, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)));
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
    // Arrange
    ClaimDataInfo claimDataInfo = new ClaimDataInfo(true, new ArrayList<>(), null);
    ArrayList<Object> key = new ArrayList<>();

    // Act and Assert
    assertNotEquals(claimDataInfo,
        new ClaimDataInfo(true, key, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)));
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual5() {
    // Arrange
    ClaimDataInfo claimDataInfo = new ClaimDataInfo(true, new ArrayList<>(), mock(ClaimData.class));
    ArrayList<Object> key = new ArrayList<>();

    // Act and Assert
    assertNotEquals(claimDataInfo,
        new ClaimDataInfo(true, key, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)));
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is different.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual6() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();
    ArrayList<Object> key2 = new ArrayList<>();
    key.add(new ClaimDataInfo(true, key2, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)));
    ClaimDataInfo claimDataInfo = new ClaimDataInfo(true, key,
        new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L));

    ArrayList<Object> key3 = new ArrayList<>();
    key3.add("42");

    // Act and Assert
    assertNotEquals(claimDataInfo,
        new ClaimDataInfo(true, key3, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)));
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is {@code null}.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();

    // Act and Assert
    assertNotEquals(new ClaimDataInfo(true, key, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)), null);
  }

  /**
   * Test {@link ClaimDataInfo#equals(Object)}.
   * <ul>
   *   <li>When other is wrong type.</li>
   *   <li>Then return not equal.</li>
   * </ul>
   * <p>
   * Method under test: {@link ClaimDataInfo#equals(Object)}
   */
  @Test
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
    // Arrange
    ArrayList<Object> key = new ArrayList<>();

    // Act and Assert
    assertNotEquals(new ClaimDataInfo(true, key, new ClaimData("EXAMPLEKEYwjalrXUtnFEMI/K7MDENG/bPxRfiCY", 1L)),
        "Different type to ClaimDataInfo");
  }

  /**
   * Test getters and setters.
   * <p>
   * Methods under test:
   * <ul>
   *   <li>{@link ClaimDataInfo#ClaimDataInfo(boolean, List, ClaimData)}
   *   <li>{@link ClaimDataInfo#toString()}
   *   <li>{@link ClaimDataInfo#getData()}
   *   <li>{@link ClaimDataInfo#getKey()}
   *   <li>{@link ClaimDataInfo#isFromCache()}
   * </ul>
   */
  @Test
  public void testGettersAndSetters() {
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
