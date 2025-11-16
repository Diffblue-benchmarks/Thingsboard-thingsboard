/**
 * Copyright © 2016-2024 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.thingsboard.server.dao.device;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import com.diffblue.cover.annotations.ContributionFromDiffblue;
import com.diffblue.cover.annotations.ManagedByDiffblue;
import com.diffblue.cover.annotations.MethodsUnderTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.thingsboard.server.dao.device.claim.ClaimData;

public class ClaimDataInfoDiffblueTest {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsEqual_thenReturnEqual2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  public void testEqualsAndHashCode_whenOtherIsSame_thenReturnEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual2() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual3() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  public void testEquals_whenOtherIsDifferent_thenReturnNotEqual4() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  public void testEquals_whenOtherIsNull_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({"boolean ClaimDataInfo.equals(Object)", "int ClaimDataInfo.hashCode()"})
  public void testEquals_whenOtherIsWrongType_thenReturnNotEqual() {
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
  @Category(ContributionFromDiffblue.class)
  @ManagedByDiffblue
  @MethodsUnderTest({
    "void ClaimDataInfo.<init>(boolean, List, ClaimData)",
    "ClaimData ClaimDataInfo.getData()",
    "List ClaimDataInfo.getKey()",
    "boolean ClaimDataInfo.isFromCache()",
    "String ClaimDataInfo.toString()"
  })
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
